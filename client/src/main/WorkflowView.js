import React, {Component} from 'react';
import "./WorkflowView.css";
import Board from "react-trello";
import {Button, Modal, notification, Row} from "antd";
import AppBreadcrumb from "../common/AppBreadcrumb";
import {changeJobStatus, getAllJobs} from "../utils/APIUtils";
import moto_icon from "../images/moto_icon.png"
import {PlusOutlined, UserOutlined} from "@ant-design/icons";
import JobForm from "../components/forms/JobForm";

export default class WorkflowView extends Component {

    constructor(props) {
        super(props);

        this.state = {
            estimate: [],
            droppedOff: [],
            inProgress: [],
            invoice: [],
            showJobForm: false,
        }
    }

    componentDidMount(): void {
        this.getJobs();
    }

    getJobs() {
        getAllJobs().then(response => {
            this.createCards(response);
        });
    };

    createDescriptionCell(job) {
        return <div className={"description-cell"}>
            <Row>
                <img src={moto_icon} alt={'img'}/><span>{job.vehicle.year} {job.vehicle.make} {job.vehicle.model}</span>
            </Row>
            <Row>
                <UserOutlined/><span>{job.technician.name} {job.technician.surname}</span>
            </Row>
            <Row>
                <span><strong>Notes:</strong> {job.notes}</span>
            </Row>
            <Row>
                <span><strong>Estimated cost:</strong> {job.labor * job.rate} EUR</span>
            </Row>
            <Row>
                <span><strong>Due date:</strong> {job.dueDate.toLocaleString().split("T")[0]}</span>
            </Row>
        </div>;
    }

    createCards = (listOfJobs) => {
        let estimates = [];
        let droppedOff = [];
        let inProgress = [];
        let invoices = [];

        listOfJobs.forEach(job => {
            if (job.status === "ESTIMATE") {
                estimates.push({
                    id: job.id + "",
                    title: "(#" + job.id + ") " + job.name,
                    description: this.createDescriptionCell(job),
                    label: job.labor + " hours",
                });
            } else if (job.status === "DROPPED_OFF") {
                droppedOff.push({
                    id: job.id + "",
                    title: "(#" + job.id + ") " + job.name,
                    description: this.createDescriptionCell(job),
                    label: job.labor + " hours",
                });
            } else if (job.status === "IN_PROGRESS") {
                inProgress.push({
                    id: job.id + "",
                    title: "(#" + job.id + ") " + job.name,
                    description: this.createDescriptionCell(job),
                    label: job.labor + " hours",
                });
            } else {
                invoices.push({
                    id: job.id + "",
                    title: "(#" + job.id + ") " + job.name,
                    description: this.createDescriptionCell(job),
                    label: job.labor + " hours",
                });
            }
        });
        this.setState({estimates, droppedOff, inProgress, invoices});
    };

    handleLaneChange = (fromLaneId, toLaneId, cardId, index) => {
        let status = "ESTIMATE";
        if (toLaneId === "droppedOff") {
            status = "DROPPED_OFF";
        }
        if (toLaneId === "inProgress") {
            status = "IN_PROGRESS";
        }
        if (toLaneId === "invoice") {
            status = "INVOICE";
        }
        changeJobStatus(cardId, status).then(response => {
            this.getJobs();
            notification.success({
                message: 'WROOM',
                description: "Job status has been changed"
            });
        })
    };

    countCardsOnLane = (laneId) => {
        let sum = this.state.estimate.length + this.state.droppedOff.length + this.state.inProgress.length + this.state.invoice.length;
        return this.state[laneId].length + "/" + sum;
    };

    handleCancel = () => {
        this.setState({showJobForm: false}, () => {
            this.getJobs();
        });
    };

    render() {

        const data = {
            editable: true,
            hideCardDeleteIcon: true,
            lanes: [
                {
                    id: 'estimate',
                    title: 'Estimates',
                    label: this.countCardsOnLane("estimate"),
                    cards: this.state.estimates
                },
                {
                    id: 'droppedOff',
                    title: 'Dropped Off',
                    label: this.countCardsOnLane("droppedOff"),
                    cards: this.state.droppedOff,
                },
                {
                    id: 'inProgress',
                    title: 'In Progress',
                    label: this.countCardsOnLane("inProgress"),
                    cards: this.state.inProgress,
                },
                {
                    id: 'invoice',
                    title: 'Invoice',
                    label: this.countCardsOnLane("invoice"),
                    cards: this.state.invoices,
                }
            ]
        };

        return (
            <div className={"workflow-view"}>
                <AppBreadcrumb items={"Dashboard"}/>
                <Row>
                    <Button style={{marginLeft: 5}} onClick={() => this.setState({showJobForm: true})}><PlusOutlined/>Create
                        New</Button>
                </Row>
                <Board onCardDelete={(cardId, laneId) => console.log(cardId)}
                       onCardMoveAcrossLanes={this.handleLaneChange}
                       data={data}
                       style={{background: "none"}}/>
                <Modal
                    title="Create job"
                    visible={this.state.showJobForm}
                    confirmLoading={false}
                    onCancel={() => this.handleCancel("showJobForm")}
                    footer={null}
                    width={"850px"}
                >
                    <JobForm closeModal={() => this.handleCancel("showJobForm")}/>
                </Modal>
            </div>
        )
    }
}

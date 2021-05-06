import React, {Component} from 'react';
import "./WorkflowView.css";
import Board from "react-trello";
import {Col, notification, Row} from "antd";
import AppBreadcrumb from "../common/AppBreadcrumb";
import {changeJobStatus, getAllJobs} from "../utils/APIUtils";

export default class WorkflowView extends Component {

    constructor(props) {
        super(props);

        this.state = {
            estimate: [],
            droppedOff: [],
            inProgress: [],
            invoice: []
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

    createCards = (listOfJobs) => {
        let estimates = [];
        let droppedOff = [];
        let inProgress = [];
        let invoices = [];

        listOfJobs.forEach(job => {
            if (job.status === "ESTIMATE") {
                estimates.push({
                    id: job.id,
                    title: "(#" + job.id + ") " + job.name,
                    description: "Test test",
                    label: job.labor + " hours",
                });
            } else if (job.status === "DROPPED_OFF") {
                droppedOff.push({
                    id: job.id,
                    title: "(#" + job.id + ") " + job.name,
                    description: "Test test",
                    label: job.labor + " hours",
                });
            } else if (job.status === "IN_PROGRESS") {
                inProgress.push({
                    id: job.id,
                    title: "(#" + job.id + ") " + job.name,
                    description: "Test test",
                    label: job.labor + " hours",
                });
            } else {
                invoices.push({
                    id: job.id,
                    title: "(#" + job.id + ") " + job.name,
                    description: "Test test",
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
                <Board onCardDelete={(cardId, laneId) => console.log(cardId)}
                       onCardMoveAcrossLanes={this.handleLaneChange}
                       data={data}
                       style={{background: "none"}}/>
            </div>
        )
    }
}

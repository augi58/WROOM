import React, {Component} from 'react';
import "./CalendarView.css"
import {Calendar, Modal, Tag} from "antd";
import AppBreadcrumb from "../common/AppBreadcrumb";
import JobForm from "../components/forms/JobForm";
import {getActiveJobs} from "../utils/APIUtils";

export default class CalendarView extends Component {

    // TODO get appointments and set to calendar. Show only future events

    constructor(props) {
        super(props);

        this.state = {
            dateSelected: null,
            showNewJobForm: false,
            jobs: []
        };
    }

    componentDidMount(): void {
        this.getJobs();
    }

    dateCellRender = (date) => {
        let foundJobs = [];
        if (this.state.jobs.filter(job => {
            let dueDate = new Date(Date.parse(job.dueDate));
            let cellDate = new Date(date.toDate());
            dueDate.setHours(0, 0, 0, 0);
            cellDate.setHours(0, 0, 0, 0);
            if (dueDate.getTime() === cellDate.getTime()) {
                foundJobs.push(job);
                return true;
            } else {
                return false;
            }
        }).length) {
            return foundJobs.map(foundJob => {
                return foundJob.status !== "INVOICE" && <ul className="events">
                    <Tag
                        color={"orange"}>{foundJob.name} for {foundJob.vehicle.year} {foundJob.vehicle.make} {foundJob.vehicle.model}</Tag>
                </ul>
            })
        } else {
            return null;
        }
    };

    handleDateCellSelect = (dateSelected) => {
        this.setState({dateSelected}, () => {
            this.setState({showNewJobForm: true});
        });
    };


    getJobs = () => {
        getActiveJobs(this.props.accountId).then(jobs => {
            this.setState({jobs})
        });
    };


    handleCancel = () => {
        this.setState({showNewJobForm: false}, () => {
            this.getJobs();
        });
    };

    render() {
        return (
            <div className={"calendar-view"}>
                <AppBreadcrumb items={"Calendar"}/>
                <Calendar onSelect={this.handleDateCellSelect} dateCellRender={this.dateCellRender}/>
                <Modal
                    title="Create job"
                    visible={this.state.showNewJobForm}
                    confirmLoading={false}
                    onCancel={this.handleCancel}
                    footer={null}
                    width={"850px"}
                >
                    <JobForm dateSelected={this.state.dateSelected} closeModal={this.handleCancel}/>
                </Modal>
            </div>
        )
    }
}

import React, {Component} from 'react';
import "./CalendarView.css"
import {Calendar, Modal} from "antd";
import AppBreadcrumb from "../common/AppBreadcrumb";
import JobForm from "../components/forms/JobForm";

export default class CalendarView extends Component {

    // TODO get appointments and set to calendar. Show only future events

    constructor(props) {
        super(props);

        this.state = {
            dateSelected: null,
            showNewJobForm: false
        };
    }

    dateCellRender = (date) => {
        return (
            <ul className="events">

            </ul>
        );
    };

    handleDateCellSelect = (dateSelected) => {
        this.setState({dateSelected}, () => {
            this.setState({showNewJobForm: true});
        });
    };


    handleCancel = () => {
        this.setState({showNewJobForm: false});
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

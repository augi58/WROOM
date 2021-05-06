import React, {Component} from 'react';
import "./DashboardCards.css"
import {Button, Modal} from "antd";
import JobForm from "./forms/JobForm";

export default class QuickActions extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showNewJobForm: false
        }
    }

    handleCancel = () => {
        this.setState({showNewJobForm: false});
    };

    render() {

        return (
            <div className={"card"}>

                <div className={"header"}><span>Quick Actions</span></div>

                <div className={"content"}>
                    <Button onClick={() => this.setState({showNewJobForm: true})}>New Job</Button>
                    <Button>New Inventory Item</Button>
                    <Button>New Customer</Button>
                </div>

                <Modal
                    title="Create job"
                    visible={this.state.showNewJobForm}
                    confirmLoading={false}
                    onCancel={this.handleCancel}
                    footer={null}
                    width={"850px"}
                >
                    <JobForm closeModal={this.handleCancel}/>
                </Modal>

            </div>
        )
    }
}

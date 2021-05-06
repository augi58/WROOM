import React, {Component} from 'react';
import "./DashboardView.css";
import {Col, Row} from "antd";
import UpcomingAppointments from "../components/UpcomingAppointments";
import AppBreadcrumb from "../common/AppBreadcrumb";
import WorkflowView from "./WorkflowView";
import WorkflowStatus from "../components/WorkflowStatus";
import QuickActions from "../components/QuickActions";
import DoorToDoorStatus from "../components/DoorToDoorStatus";

export default class DashboardView extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={"dashboard-view"}>
                <AppBreadcrumb/>
                <div className={"header"}>Welcome back, Augustinas!</div>
                <div>
                    <Row>
                        <Col span={10}>
                            <WorkflowStatus/>
                        </Col>
                        <Col span={14}>
                            <UpcomingAppointments/>
                        </Col>
                    </Row>
                    <Row>
                        <Col span={10}>
                            <QuickActions/>
                        </Col>
                        <Col span={14}>
                            <DoorToDoorStatus/>
                        </Col>
                    </Row>
                </div>
            </div>
        );
    }
}

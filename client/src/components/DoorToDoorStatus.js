import React, {Component} from 'react';
import "./DashboardCards.css"
import {Col, Row} from "antd";
import {getSummary} from "../utils/APIUtils";


export default class DoorToDoorStatus extends Component {

    constructor(props) {
        super(props);

        this.state = {
            summary: {}
        }
    }

    componentDidMount(): void {
        getSummary().then(summary => {
            this.setState({summary})
        })
    }

    render() {
        const summary = this.state.summary;
        return (
            <div className={"card"}>
                <div className={"header"}><span>Door-to-Door Jobs</span></div>
                <div className={"content"}>
                    <Row className={"row"}>
                        <Col span={12}>
                            Awaiting Pick-Up
                        </Col>
                        <Col span={12}>
                            {summary.doorToDoorEstimatesOrders} orders
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={12}>
                            In Progress
                        </Col>
                        <Col span={12}>
                            {summary.doorToDoorInProgressOrders} orders
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={12}>
                            Delivered
                        </Col>
                        <Col span={12}>
                            {summary.doorToDoorDeliveredOrders} orders
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

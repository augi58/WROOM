import React, {Component} from 'react';
import "./DashboardCards.css"
import {Col, Row, Tabs} from "antd";
import {getSummary} from "../utils/APIUtils";

export default class WorkflowStatus extends Component {

    // TODO get summary data

    constructor(props) {
        super(props);

        this.state = {
            summary: {}
        };
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
                <div className={"header"}><span>Workflow Summary</span></div>

                <div className={"content"}>
                    <Row className={"row"}>
                        <Col span={8}>
                            Estimates
                        </Col>
                        <Col span={8}>
                            {summary?.estimatesOrders} orders
                        </Col>
                        <Col span={8}>
                            {summary?.estimatesSum} EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            Dropped Off
                        </Col>
                        <Col span={8}>
                            {summary?.droppedOffOrders} orders
                        </Col>
                        <Col span={8}>
                            {summary?.droppedOffSum} EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            In Progress
                        </Col>
                        <Col span={8}>
                            {summary?.inProgressOrders} orders
                        </Col>
                        <Col span={8}>
                            {summary?.inProgressSum} EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            Invoices
                        </Col>
                        <Col span={8}>
                            {summary?.invoicesOrders} orders
                        </Col>
                        <Col span={8}>
                            {summary?.invoicesSum} EUR
                        </Col>
                    </Row>
                    <Row className={"total-row"}>
                        <Col span={8}>
                            TOTAL:
                        </Col>
                        <Col span={8}>
                            {summary?.totalOrders} orders
                        </Col>
                        <Col span={8}>
                            {summary?.totalSum} EUR
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

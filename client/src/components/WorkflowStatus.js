import React, {Component} from 'react';
import "./DashboardCards.css"
import {Col, Row, Tabs} from "antd";

export default class WorkflowStatus extends Component {

    // TODO get summary data

    constructor(props) {
        super(props);
    }

    render() {

        return (
            <div className={"card"}>
                <div className={"header"}><span>Workflow Summary</span></div>

                <div className={"content"}>
                    <Row className={"row"}>
                        <Col span={8}>
                            Estimates
                        </Col>
                        <Col span={8}>
                            0 orders
                        </Col>
                        <Col span={8}>
                            0 EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            Dropped Off
                        </Col>
                        <Col span={8}>
                            0 orders
                        </Col>
                        <Col span={8}>
                            0 EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            In Progress
                        </Col>
                        <Col span={8}>
                            0 orders
                        </Col>
                        <Col span={8}>
                            0 EUR
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={8}>
                            Invoices
                        </Col>
                        <Col span={8}>
                            0 orders
                        </Col>
                        <Col span={8}>
                            0 EUR
                        </Col>
                    </Row>
                    <Row className={"total-row"}>
                        <Col span={8}>
                            TOTAL:
                        </Col>
                        <Col span={8}>
                            0 orders
                        </Col>
                        <Col span={8}>
                            0 EUR
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

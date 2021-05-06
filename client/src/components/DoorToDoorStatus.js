import React, {Component} from 'react';
import "./DashboardCards.css"
import {Col, Row} from "antd";


export default class DoorToDoorStatus extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={"card"}>
                <div className={"header"}><span>Door-to-Door Jobs</span></div>
                <div className={"content"}>
                    <Row className={"row"}>
                        <Col span={12}>
                            Awaiting Pick-Up
                        </Col>
                        <Col span={12}>
                            0 orders
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={12}>
                            In Progress
                        </Col>
                        <Col span={12}>
                            0 orders
                        </Col>
                    </Row>
                    <Row className={"row"}>
                        <Col span={12}>
                            Delivered
                        </Col>
                        <Col span={12}>
                            0 orders
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}

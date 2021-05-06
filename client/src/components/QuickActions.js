import React, {Component} from 'react';
import "./DashboardCards.css"
import {Button, Col, Modal, Row} from "antd";
import JobForm from "./forms/JobForm";
import {PlusOutlined} from "@ant-design/icons";
import InventoryItemForm from "./forms/InventoryItemForm";
import UserForm from "./forms/UserForm";
import VehicleForm from "./forms/VehicleForm";

export default class QuickActions extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showJobForm: false,
            showInventoryItemForm: false,
            showUserForm: false,
            showVehicleForm: false,
        }
    }

    handleCancel = (formName) => {
        this.setState({[formName]: false});
    };

    render() {

        return (
            <div className={"card"}>

                <div className={"header"}><span>Quick Actions</span></div>

                <div className={"content"}>
                    <Row>
                        <Col span={5}>
                            <Button onClick={() => this.setState({showJobForm: true})}><PlusOutlined/>New
                                Job</Button>
                        </Col>
                        <Col span={7}>
                            <Button onClick={() => this.setState({showInventoryItemForm: true})}><PlusOutlined/>New
                                Inventory Item</Button>
                        </Col>
                        <Col span={6}>
                            <Button onClick={() => this.setState({showUserForm: true})}><PlusOutlined/>New
                                Customer</Button>
                        </Col>
                        <Col span={4}>
                            <Button onClick={() => this.setState({showVehicleForm: true})}><PlusOutlined/>New
                                Motorcycle</Button>
                        </Col>
                    </Row>
                </div>

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

                <Modal
                    title="Add part to inventory"
                    visible={this.state.showInventoryItemForm}
                    confirmLoading={false}
                    onCancel={() => this.handleCancel("showInventoryItemForm")}
                    footer={null}
                    width={"850px"}
                >
                    <InventoryItemForm closeModal={() => this.handleCancel("showInventoryItemForm")}/>
                </Modal>

                <Modal
                    title="Register New Customer"
                    visible={this.state.showUserForm}
                    confirmLoading={false}
                    onCancel={() => this.handleCancel("showUserForm")}
                    footer={null}
                    width={"850px"}
                >
                    <UserForm closeModal={() => this.handleCancel("showUserForm")}/>
                </Modal>

                <Modal
                    title="Register New Motorcycle"
                    visible={this.state.showVehicleForm}
                    confirmLoading={false}
                    onCancel={() => this.handleCancel("showVehicleForm")}
                    footer={null}
                    width={"850px"}
                >
                    <VehicleForm closeModal={() => this.handleCancel("showVehicleForm")}/>
                </Modal>

            </div>
        )
    }
}

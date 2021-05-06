import React, {Component} from 'react';
import {Button, Checkbox, Col, DatePicker, Form, Input, Modal, notification, Select} from 'antd';
import './Forms.css';
import {
    createUpdateJob, createUpdateVehicle,
    getAllClients,
    getAllClientVehicles,
    getAllParts,
    getAllTechnicians
} from "../../utils/APIUtils";
import PlusOutlined from "@ant-design/icons/lib/icons/PlusOutlined";
import UserForm from "./UserForm";

const {Option} = Select;

export default class VehicleForm extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const AntWrappedForm = Form.create()(GenericForm);
        return (
            <div>
                <AntWrappedForm dateSelected={this.props.dateSelected}
                                closeModal={this.props.closeModal}
                                user={this.props.user}
                                update={this.props.update}/>
            </div>
        );
    }
}

class GenericForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            clientOptions: null,
            vehicleOptions: null,
            technicianOptions: null,
            partsOptions: null,

            showUserForm: false,
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(): void {
        this.props.form.setFieldsValue({});

        getAllClients().then(response => {
            let clientOptions = response.map(k => {
                return <Option key={k.id} value={k.id}>{k.name} {k.surname}</Option>;
            });
            this.setState({clientOptions});
        }).catch(error => {
            console.log(error);
        });

    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;
        const inputValue = target.value;

        this.props.form.setFieldsValue({
            [inputName]: inputValue
        });
    }

    handleSelectChange = (fieldName, id) => {

    };

    handleCheckboxChange = (event) => {
        console.log(event);
    };

    handleSubmit(event) {

        event.preventDefault();

        this.props.form.validateFieldsAndScroll((err, values) => {

            if (!err) {

                this.setState((state) => {
                    return {disabledInputs: true};
                });

                let vehicleDTO = {
                    id: null,
                    ownerId: values.ownerId,
                    licenceNo: values.licenceNo,
                    year: parseInt(values.year),
                    make: values.make,
                    model: values.model,
                    VIN: values.VIN
                };

                createUpdateVehicle(vehicleDTO).then(response => {
                    notification.success({
                        message: 'WROOM',
                        description: "New vehicle has been added"
                    });
                    this.props.closeModal(false);
                }).catch(error => {
                    notification.error({
                            message: 'WROOM',
                            description: 'Something went wrong, could not update'
                        }
                    )
                });
            }
        });
    }

    handleCancel = (formName) => {
        this.setState({[formName]: false});
    };

    render() {

        const {getFieldDecorator} = this.props.form;

        const required = {
            required: true,
            message: 'Please fill in this field',
        };

        return (
            <div className="form">
                <div className="form-container">
                    <div className="content">
                        <Form layout={'horizontal'}
                              size={'small'}
                              onSubmit={this.handleSubmit}
                              className="sign-up-form">

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Owner:"
                                       extra={"Owner"}
                            >
                                {getFieldDecorator('ownerId', {rules: [required]})
                                (<Select style={{maxWidth: "100%"}}
                                         onChange={(id) => this.handleSelectChange("ownerId", id)}>{this.state.clientOptions}</Select>)}
                                <Button onClick={() => this.setState({showUserForm: true})}><PlusOutlined/>Add</Button>
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Year:"
                                       extra={"Year"}
                            >
                                {getFieldDecorator('year', {rules: [required]})
                                (<Input
                                    type={"number"}
                                    name="year"
                                    autoComplete="off"
                                    placeholder="Year"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Make:"
                                       extra={"Make"}
                            >
                                {getFieldDecorator('make', {rules: [required]})
                                (<Input
                                    name="make"
                                    autoComplete="off"
                                    placeholder="Make"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Model:"
                                       extra={"Model"}
                            >
                                {getFieldDecorator('model', {rules: [required]})
                                (<Input
                                    name="model"
                                    autoComplete="off"
                                    placeholder="Model"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Licence No.:"
                                       extra={"Licence Number Plate Number"}
                            >
                                {getFieldDecorator('licenseNo', {rules: [required]})
                                (<Input
                                    name="licenseNo"
                                    autoComplete="off"
                                    placeholder="Licence No."
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="VIN:"
                                       extra={"VIN"}
                            >
                                {getFieldDecorator('VIN', {rules: [required]})
                                (<Input
                                    name="VIN"
                                    autoComplete="off"
                                    placeholder="VIN"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <div className={"buttons"}>
                                <Form.Item
                                    className="button-container"
                                    style={{display: 'inline-block', width: 'calc(50% - 8px)'}}>
                                    <Button type="danger"
                                            onClick={() => this.props.closeModal()}
                                            className="form-button">
                                        Cancel
                                    </Button>
                                </Form.Item>

                                <Form.Item
                                    className="button-container"
                                    style={{display: 'inline-block', width: 'calc(50% - 8px)'}}>
                                    <Button type="primary"
                                            onClick={this.handleSubmit}
                                            className="form-button">
                                        Add Motorcycle
                                    </Button>
                                </Form.Item>

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
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        );
    }
}

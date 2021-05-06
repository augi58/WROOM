import React, {Component} from 'react';
import {Button, Checkbox, Col, DatePicker, Form, Input, Modal, notification, Select} from 'antd';
import './Forms.css';
import {
    createUpdateJob,
    getAllClients,
    getAllClientVehicles,
    getAllParts,
    getAllTechnicians
} from "../../utils/APIUtils";
import PlusOutlined from "@ant-design/icons/lib/icons/PlusOutlined";

const {Option} = Select;

export default class JobForm extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const AntWrappedForm = Form.create()(NewJobForm);
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

class NewJobForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            clientOptions: null,
            vehicleOptions: null,
            technicianOptions: null,
            partsOptions: null
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(): void {
        this.props.form.setFieldsValue({});

        getAllParts().then(response => {
            let partsOptions = response.map(k => {
                return <Option key={k.id} value={k.id}>{k.name} ({k.quantity} left)</Option>;
            });
            this.setState({partsOptions});
        }).catch(error => {
            console.log(error);
        });

        getAllClients().then(response => {
            let clientOptions = response.map(k => {
                return <Option key={k.id} value={k.id}>{k.name} {k.surname}</Option>;
            });
            this.setState({clientOptions});
        }).catch(error => {
            console.log(error);
        });

        getAllTechnicians().then(response => {
            let technicianOptions = response.map(k => {
                return <Option key={k.id} value={k.id}>{k.name} {k.surname}</Option>;
            });
            this.setState({technicianOptions});
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
        if (fieldName === "clientId") {
            getAllClientVehicles(id).then(response => {
                let vehicleOptions = response.map(k => {
                    return <Option key={k.id} value={k.id}>{k.year} {k.make} {k.model}</Option>;
                });
                this.setState({vehicleOptions});
            }).catch(error => {
                console.log(error);
            });
        }
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

                let jobDTO = {
                    id: null,
                    name: values.name,
                    clientId: values.clientId,
                    technicianId: values.technicianId,
                    vehicleId: values.vehicleId,
                    status: "ESTIMATE",
                    parts: values.parts,
                    labor: parseFloat(values.labor),
                    rate: parseFloat(values.rate),
                    dueDate: values.dueDate.toDate(),
                    notes: values.notes,
                    doorToDoor: values.doorToDoor,
                };

                createUpdateJob(jobDTO).then(response => {
                    notification.success({
                        message: 'WROOM',
                        description: "New job has been added"
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
                                       label="Job Name:"
                                       extra={"Job Name"}
                            >
                                {getFieldDecorator('name', {rules: [required]})
                                (<Input
                                    name="name"
                                    autoComplete="off"
                                    placeholder="Name"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Client:"
                                       extra={"Client"}
                            >
                                {getFieldDecorator('clientId', {rules: [required]})
                                (<Select style={{maxWidth: "100%"}}
                                         onChange={(id) => this.handleSelectChange("clientId", id)}>{this.state.clientOptions}</Select>)}
                                <Button><PlusOutlined/>Add</Button>
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Motorcycle:"
                                       extra={"Motorcycle"}
                            >
                                {getFieldDecorator('vehicleId', {rules: [required]})
                                (<Select disabled={!this.props.form.getFieldValue("clientId")}
                                         onChange={(id) => this.handleSelectChange("vehicleId", id)}>{this.state.vehicleOptions}</Select>)}
                                <Button
                                    disabled={!this.props.form.getFieldValue("clientId")}><PlusOutlined/>Add</Button>
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Parts:"
                                       extra={"Parts"}
                            >
                                {getFieldDecorator('parts', {rules: [required]})
                                (<Select disabled={!this.props.form.getFieldValue("vehicleId")}
                                         mode={"multiple"}
                                         style={{maxWidth: "100%"}}
                                         onChange={(selectedIds) => this.handleSelectChange("parts", selectedIds)}>{this.state.partsOptions}</Select>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Assign to:"
                                       extra={"Assign job to this technician"}
                            >
                                {getFieldDecorator('technicianId', {rules: [required]})
                                (<Select style={{maxWidth: "100%"}}
                                         onChange={(id) => this.handleSelectChange("technicianId", id)}>{this.state.technicianOptions}</Select>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Labor:"
                                       extra={"Labor in hours"}
                            >
                                {getFieldDecorator('labor', {rules: [required]})
                                (<Input
                                    type={"number"}
                                    name="labor"
                                    autoComplete="off"
                                    placeholder="Labor"
                                    suffix={"H"}
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Rate:"
                                       extra={"Custom job cost rate"}
                            >
                                {getFieldDecorator('rate', {rules: [required]})
                                (<Input
                                    type={"number"}
                                    name="rate"
                                    autoComplete="off"
                                    placeholder="Rate"
                                    suffix={"EUR/H"}
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Due Date">{getFieldDecorator('dueDate', {initialValue: this.props.dateSelected})
                            (<DatePicker/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Additional Notes:"
                            >
                                {getFieldDecorator('notes')
                                (<Input.TextArea
                                    name="notes"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Door2Door:"
                            >
                                {getFieldDecorator('doorToDoor')
                                (<Checkbox onChange={this.handleCheckboxChange}/>)}
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
                                        Create Job
                                    </Button>
                                </Form.Item>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        );
    }
}

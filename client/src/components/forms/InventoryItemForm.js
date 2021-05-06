import React, {Component} from 'react';
import {Button, Form, Input, notification} from 'antd';
import './Forms.css';
import {createUpdateInventoryItem} from "../../utils/APIUtils";

export default class InventoryItemForm extends Component {

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
            partsOptions: null
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(): void {
        this.props.form.setFieldsValue({});
    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;
        const inputValue = target.value;

        this.props.form.setFieldsValue({
            [inputName]: inputValue
        });
    }

    handleSubmit(event) {

        event.preventDefault();

        this.props.form.validateFieldsAndScroll((err, values) => {

            if (!err) {

                this.setState((state) => {
                    return {disabledInputs: true};
                });

                let inventoryItemDTO =
                    {
                        id: null,
                        name: values.name,
                        make: values.make,
                        serialNo: values.serialNo,
                        fitsFor: values.fitsFor.split(","),
                        workshopId: 1,
                        quantity: parseInt(values.quantity),
                    };

                createUpdateInventoryItem(inventoryItemDTO).then(response => {
                    notification.success({
                        message: 'WROOM',
                        description: "New part has been added to inventory"
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
                                       label="Part Name:"
                                       extra={"Part Name"}
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
                                       label="Make:"
                                       extra={"Part Make"}
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
                                       label="Serial No.:"
                                       extra={"Serial Number"}
                            >
                                {getFieldDecorator('serialNo', {rules: [required]})
                                (<Input
                                    name="serialNo"
                                    autoComplete="off"
                                    placeholder="Serial Number"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Fits For:"
                                       extra={"Part fits these models (leave blank if part is generic)"}
                            >
                                {getFieldDecorator('fitsFor')
                                (<Input
                                    name="fitsFor"
                                    autoComplete="off"
                                    placeholder="Fits for"
                                    onChange={this.handleInputChange}/>)}
                            </Form.Item>

                            <Form.Item labelCol={{span: 5}}
                                       wrapperCol={{span: 18}}
                                       label="Quantity:"
                                       extra={"Quantity"}
                            >
                                {getFieldDecorator('quantity', {rules: [required]})
                                (<Input
                                    type={"number"}
                                    step={1}
                                    name="quantity"
                                    autoComplete="off"
                                    placeholder="Quantity"
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
                                        Add part(s)
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

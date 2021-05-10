import React, {Component} from "react";
import './UserPanel.css';
import {Avatar, Button, Col, Dropdown, Menu, Row} from "antd";
import {Link} from 'react-router-dom';
import {API_BASE_URL} from '../constants/index';
import DownOutlined from "@ant-design/icons/lib/icons/DownOutlined";

export default class UserPanel extends Component {

    constructor(props) {
        super(props);

        this.state = {
            account: {}
        };
    }

    render() {

        let logo = null;
        let name = "Augustinas Čečys";

        const menu = (
            <Menu>
                <Menu.Item key="1">
                    <Link to="/profile">Profile</Link>
                </Menu.Item>
                <Menu.Item key="2" onClick={() => this.props.switchAccount(2)}>
                    Switch account
                </Menu.Item>
                <Menu.Item key="3" onClick={this.props.logout}>
                    Logout
                </Menu.Item>
            </Menu>
        );

        let avatar = '';
        if (logo === null) {
            avatar = <Avatar className="ml--10"
                             style={{
                                 backgroundColor: '#9f9f9f',
                                 verticalAlign: 'middle',
                             }}
                             size="large"
            >
                {"AČ"}
            </Avatar>
        } else {
            avatar = <Avatar className="ml--10"
                             style={{
                                 backgroundColor: '#9f9f9f',
                                 verticalAlign: 'middle',
                             }}
                             size="large" src={API_BASE_URL + "/file/" + logo}> </Avatar>;
        }


        return (
            <div className={"user-panel"}>
                <Dropdown overlay={menu}>
                    <Button className="user-panel-btn">
                        <Row>
                            <Col span={5}>
                                {avatar}
                            </Col>
                            <Col span={18}>
                                <div className={"name-container"}>
                                    <span className={"name"}>{name}</span><br/>
                                    <span
                                        className={"account-name"}>{"Manager"}</span>
                                </div>
                            </Col>
                            <Col span={1}>
                                <DownOutlined className="arrow"/>
                            </Col>
                        </Row>
                    </Button>
                </Dropdown>
            </div>
        )
    }
}

import React, {Component} from 'react';
import {Link, withRouter} from 'react-router-dom';
import {Col, Row} from "antd";
import UserPanel from "../components/UserPanel";
import logo from '../images/logo.png';
import './AppHeader.css';

class AppHeader extends Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {
        return (
            <div className="navigation-bar">
                <Row>
                    <Col span={1} className="logo-wrapper">
                        <a href={"/"}>
                            <img
                                src={logo}
                                className="logo"
                                alt={"logo"}/>
                        </a>
                    </Col>

                    <Col span={17} className="menu-wrapper">
                        <Link to={"/"} className="nav-item">Dashboard</Link>
                        <Link to={"/workflow"} className="nav-item">Workflow</Link>
                        <Link to={"/calendar"} className="nav-item">Calendar</Link>
                        <Link to={"/inventory"} className="nav-item">Inventory</Link>
                        <Link to={"/lists"} className="nav-item">Lists</Link>
                    </Col>

                    <Col span={4}>
                        <div className="account-data-wrapper">
                            <UserPanel switchAccount={this.props.switchAccount} user={this.props.user} logout={this.props.logout}/>
                        </div>
                    </Col>
                </Row>
            </div>
        );
    }
}

export default withRouter(AppHeader);

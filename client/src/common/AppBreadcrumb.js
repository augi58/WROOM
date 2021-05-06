import React from "react";
import {Component} from "react";
import {Breadcrumb} from "antd";

export default class AppBreadcrumb extends Component {
    render() {
        return (
            <Breadcrumb>
                <Breadcrumb.Item>Home</Breadcrumb.Item>
                {this.props.items?.split(",").map(item => {
                    return <Breadcrumb.Item>
                        <a href="#">{item}</a>
                    </Breadcrumb.Item>
                })}
            </Breadcrumb>
        );
    }
}

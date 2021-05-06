import React from "react";
import {Layout, Switch} from "antd";
import AppHeader from "../common/AppHeader";
import {Route, withRouter} from "react-router-dom";
import MainContainer from "../main/MainContainer";
import AppFooter from "../common/AppFooter";
import "antd/dist/antd.css"
import './App.css';

const {Content} = Layout;

function App() {
    return (
        <div>
            <Layout className="main-layout">
                <AppHeader/>
                <div className="content-layout">
                    <Content className="container">
                        <MainContainer/>
                    </Content>
                </div>
                <AppFooter/>
            </Layout>
        </div>
    );
}

export default withRouter(App);


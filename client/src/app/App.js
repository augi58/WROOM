import React, {Component} from "react";
import {Layout} from "antd";
import AppHeader from "../common/AppHeader";
import {withRouter} from "react-router-dom";
import MainContainer from "../main/MainContainer";
import AppFooter from "../common/AppFooter";
import "antd/dist/antd.css"
import './App.css';

const {Content} = Layout;

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            currentAccount: 1
        }
    }

    changeAccount = (account) => {
        if (this.state.currentAccount != account) {
            this.setState({currentAccount: account});
        } else {
            this.setState({currentAccount: 1});
        }
    };

    render(): React.ReactElement<any, string | React.JSXElementConstructor<any>> | string | number | {} | React.ReactNodeArray | React.ReactPortal | boolean | null | undefined {
        console.log(this.state.currentAccount);
        return (
            <div>
                <Layout className="main-layout">
                    <AppHeader switchAccount={this.changeAccount}/>
                    <div className="content-layout">
                        <Content className="container">
                            <MainContainer accountId={this.state.currentAccount}/>
                        </Content>
                    </div>
                    <AppFooter/>
                </Layout>
            </div>
        );
    }

}

export default withRouter(App);


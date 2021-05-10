import React, {Component} from 'react';
import {Route, Switch, withRouter} from 'react-router-dom'
import './MainContainer.css'
import DashboardView from "./DashboardView.js";
import WorkflowView from "./WorkflowView";
import CalendarView from "./CalendarView";

class MainContainer extends Component {
    render() {

        return (
            <div className={"main-container"}>
                <Switch>
                    <Route path="/workflow">
                        <WorkflowView accountId={this.props.accountId}/>
                    </Route>
                    <Route path="/calendar">
                        <CalendarView accountId={this.props.accountId}/>
                    </Route>
                    <Route path="/">
                        <DashboardView accountId={this.props.accountId}/>
                    </Route>
                </Switch>
            </div>
        )
    }
}

export default withRouter(MainContainer);

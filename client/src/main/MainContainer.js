import React, {Component} from 'react';
import {Route, Switch, withRouter} from 'react-router-dom'
import './MainContainer.css'
import DashboardView from "./DashboardView.js";
import WorkflowView from "./WorkflowView";
import CalendarView from "./CalendarView";

const queryString = require('query-string');

class MainContainer extends Component {
    render() {

        const params = queryString.parse(this.props.location.search);

        return (
            <div className={"main-container"}>
                <Switch>
                    <Route path="/workflow">
                        <WorkflowView/>
                    </Route>
                    <Route path="/calendar">
                        <CalendarView/>
                    </Route>
                    <Route path="/">
                        <DashboardView/>
                    </Route>
                </Switch>
            </div>
        )
    }
}

export default withRouter(MainContainer);

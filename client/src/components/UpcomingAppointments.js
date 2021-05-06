import React, {Component} from 'react';
import {CalendarOutlined} from "@ant-design/icons";
import "./DashboardCards.css"
import {Tabs} from "antd";

const {TabPane} = Tabs;

export default class UpcomingAppointments extends Component {

    // TODO get summary data

    constructor(props) {
        super(props);
    }

    render() {

        const noUpcomingEventsMessage =
            <div className={"no-upcoming-events-message"}>There are no upcoming appointments for selected period
                <br/>
                <div className={"no-upcoming-events-message"}>
                    <CalendarOutlined style={{fontSize: 60}}/>
                </div>
            </div>;

        return (
            <div className={"card"}>

                <div className={"header"}><span>Upcoming Appointments</span></div>

                <div className={"content"}>
                    <Tabs defaultActiveKey="1">
                        <TabPane tab="Today" key="1">
                            {noUpcomingEventsMessage}
                        </TabPane>
                        <TabPane tab="Tomorrow" key="2">
                            {noUpcomingEventsMessage}
                        </TabPane>
                        <TabPane tab="This Week" key="3">
                            {noUpcomingEventsMessage}
                        </TabPane>
                        <TabPane tab="Next Week" key="4">
                            {noUpcomingEventsMessage}
                        </TabPane>
                    </Tabs>
                </div>
            </div>
        )
    }
}

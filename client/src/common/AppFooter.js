import React, {Component} from "react";
import './AppFooter.css';

export default class AppFooter extends Component {
    render() {
        return (
            <div className="footerContainer">
                <div className="footer">
                    <div className={"footer-content-wrapper"}>
                        <strong>@Augustinas Čečys</strong>
                    </div>
                </div>
            </div>
        )
    }
}

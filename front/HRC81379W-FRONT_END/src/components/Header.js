import React from "react";
import "./Header.css";


class Header extends React.Component {
  render() {
    return (
      <div className="main">
        <div className="header">
          <img id="abcproduct" src={require("./images/abcproduct.jpg")} />
          <img id="highradius" src={require("./images/highradius.jpg")} />
        </div>
        <h3 id="invoicehead">Invoice List</h3>

        
      </div>
    );
  }
}
export default Header;

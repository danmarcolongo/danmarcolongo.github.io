import React from "react";
import './header.css';
/*
calls the css file to create a sticky header
creates links to the other pages
*/
const Header = () => {
    return (
        <div className="sticky">
        <header className="App-header">
          <h1>Welcome to the Jungle</h1>
          <div>
          <ul className="navi">
            <li><a href="http://localhost:3000/#home">Home</a></li>
            <li><a href="http://localhost:3000/#about">About</a></li>
            <li><a href="http://localhost:3000/#contacts">Contacts</a></li>
            <li><a href="http://localhost:3000/#sources">Sources</a></li>
          </ul>
          </div>
        </header>
        </div>
    );
}

export default Header;
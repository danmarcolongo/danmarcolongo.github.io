import React, { Component } from 'react';
import './App.css';
import Contacts from './contacts/contacts';
import About from './about/about';
import Home from './home/home';
import Header from './header/header';
import Resources1 from './resources1/resources1';

class App extends Component {
  render() {
    return (
      //calls the classes to the front page to render
      <div className="App">
        <Header/>
        <Home/>
        <About/>
        <Contacts/>
        <Resources1/>
      </div>
    );
  }
}

export default App;

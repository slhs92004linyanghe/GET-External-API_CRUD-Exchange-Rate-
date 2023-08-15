import logo from './logo.svg';
import './App.css';
import Appbar from './components/Appbar';
import Rate from './components/Rate';
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate  } from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <Appbar/>
      <Rate/>
    </div>
  );

 
  

}

export default App;




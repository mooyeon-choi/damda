import * as React from 'react';
import logo from './../damdaticon.png';

interface IMainProps {
}

const Main: React.FunctionComponent<IMainProps> = (props) => {
  return (<div>
    <img src={logo} className="App-logo" alt="logo" />
    <p>
      Hi~
    </p>
    <a
      className="App-link"
      href="https://reactjs.org"
      target="_blank"
      rel="noopener noreferrer"
    >
      Learn React
    </a>
  </div>);
};

export default Main;

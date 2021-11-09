import * as React from 'react';
import logo from './../damdaticon.png';
import styled from 'styled-components';

interface IMainProps {
}

const Title = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: palevioletred;
`;

// Create a Wrapper component that'll render a <section> tag with some styles
const Wrapper = styled.section`
  padding: 4em;
  background: papayawhip;
`;

const Main: React.FunctionComponent<IMainProps> = (props) => {
  return (<Wrapper>
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
  </Wrapper>);
};

export default Main;

import React from 'react';
import ReactDOM from 'react-dom';
import Home from './src/Home.jsx';
import reducer from './src/reducers/index-reducer';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import { Router, Route, browserHistory, IndexRoute} from 'react-router'

let store = createStore(reducer);

ReactDOM.render(
<Provider store={store}>
  <Home/>
</Provider>, 
document.getElementById('app'));

export default store;
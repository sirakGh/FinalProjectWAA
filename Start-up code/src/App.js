import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Login from './component/login/login';
function App() {

  return (
    <BrowserRouter>

      <Switch>
        
        <Route exact path="/" component={Login} />
        <Route><h1>404 Not Found</h1></Route>
      </Switch>

    </BrowserRouter>
  );
}

export default App;

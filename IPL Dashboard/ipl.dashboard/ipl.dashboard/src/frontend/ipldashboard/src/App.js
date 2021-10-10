import {BrowserRouter as Router, Route} from 'react-router-dom'
import './App.css';
import { TeamPage } from './pageComponent/TeamPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/teams/:teamName">
          <TeamPage/>
        </Route>
      </Router>
      
    </div>
  );
}

export default App;

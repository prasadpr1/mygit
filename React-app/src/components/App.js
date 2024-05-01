import React from "react";
import ReactDOM from "react-dom";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Home from "../routes/Home";
import Aboutpage from "../routes/Aboutpage";
import Path from "../routes/Paths";
import NotFound from "../routes/NotFound";
import Route1 from "./Route1";
import Route2 from "./Route2";

function App() {
  return (
    <>
      <div className="container-fluid">
        <Router>
          <Routes>
            <Route path="/" element={<Navigate replace to="/home" />} />
            <Route path="/" element={<Path />}>
              <Route index path="home" element={<Home />} />
              <Route path="about" element={<Aboutpage />} />
              <Route path="route1" element={<Route1 />} />
              <Route path="route2" element={<Route2 />} />
              <Route path="*" element={<NotFound />} />
            </Route>
          </Routes>
        </Router>
      </div>
    </>
  );
}

export default App;

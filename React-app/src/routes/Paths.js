import { NavLink, Outlet } from "react-router-dom";

const Path = () => {
  return (
    <>
      <div className="container mt-3">
        <ul className="nav nav-pills">
          <li className="nav-item">
            <NavLink className="nav-link" to="/home" activeclassname="active">
              Home
            </NavLink>
          </li>
          <span style={marginStyle}></span>
          <li className="nav-item">
            <NavLink className="nav-link" to="/about" activeclassname="active">
              About
            </NavLink>
          </li>
          <span style={marginStyle}></span>
          <li className="nav-item">
            <NavLink className="nav-link" to="/route1" activeclassname="active">
              Route1
            </NavLink>
          </li>
          <span style={marginStyle}></span>
          <li className="nav-item">
            <NavLink className="nav-link" to="/route2" activeclassname="active">
              Route2
            </NavLink>
          </li>
        </ul>
      </div>
      <Outlet></Outlet>
    </>
  );
};

const marginStyle = {
  marginRight: "20px",
};

export default Path;

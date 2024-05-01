import PropTypes from "prop-types";
import Button from "./Button";
import { useState } from "react";

const Header = ({ title, showForm, hideForm }) => {
  const [text, setText] = useState("Show Form");

  return (
    <header className="header">
      <h3>{title}</h3>
      <Button
        buttonClass="btn btn-dark"
        buttonName={!hideForm ? "Add" : "Hide"}
        onClick={showForm}
      />
    </header>
  );
};

Header.propTypes = {
  title: PropTypes.string,
};

export default Header;

import React from "react";
import PropTypes from "prop-types";
import { FaTimes } from "react-icons/fa";

const Task = ({ task, onDelete, onToggle }) => {
  return (
    <div
      className="well well-lg"
      style={task.reminder ? dynamicClass : fixedStyle}
      onDoubleClick={() => onToggle(task.id)}
    >
      <blockquote>
        {" "}
        <h4>
          {task.text}&nbsp;
          <FaTimes style={iconStyle} onClick={() => onDelete(task.id)} />
        </h4>
        <p>{task.day}</p>
      </blockquote>
    </div>
  );
};

const iconStyle = {
  color: "red",
  cursor: "pointer",
};

const dynamicClass = {
  paddingLeft: "6px",
};

const fixedStyle = {
  borderLeft: "5px solid red",
  paddingLeft: "6px",
};

export default Task;

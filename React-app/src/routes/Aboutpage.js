import { useState } from "react";
import { reducer, initialTodos } from "../reducers/AboutReducer";
import { useReducer } from "react";

const Aboutpage = () => {
  const [buttonTg, setButtonTg] = useState("btn default");
  const [todos, dispatch] = useReducer(reducer, initialTodos);
  const handleComplete = (todo) => {
    dispatch({ type: "COMPLETE", id: todo.id });
  };
  var count = 1;

  setTimeout(() => {
    count = count + 1;
    console.log("ddd");
    console.log(todos?.length);
    dispatch({
      type: "INSERT",
      item: {
        id: new Date().getMilliseconds,
        title: `Todo ${new Date().getUTCMilliseconds()}`,
      },
    });
  }, 10000);
  return (
    <div className="alert alert-warning" style={marginStyle}>
      <strong>Success!</strong> Backend Services are done.
      {todos?.map((todo) => (
        <div key={todo.id}>
          <label>
            <input
              type="checkbox"
              checked={todo.complete}
              onChange={() => handleComplete(todo)}
            />
            {todo.title}
          </label>
        </div>
      ))}
    </div>
  );
};

const marginStyle = {
  marginTop: "20px",
};

export default Aboutpage;

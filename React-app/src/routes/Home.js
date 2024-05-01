import React, { useState, useEffect } from "react";
import Header from "../components/Header";
import Tasks from "../components/Tasks";
import { useReducer } from "react";
import { reducer, initialTodos } from "../reducers/AboutReducer";

function Home() {
  const name = "Prasad";

  const [tasks, setTasks] = useState([]);
  const [hideForm, setHideForm] = useState(false);
  const [error, setError] = useState(false);
  const [todos, dispatch] = useReducer(reducer, initialTodos);

  useEffect(() => {
    fetchTasks()
      .then((res) => {
        setTasks(res);
        console.log(tasks);
        setError(false);
      })
      .catch((error) => {
        console.log("backend services are down");
        setError(true);
      });
  }, []);

  setTimeout(() => {
    console.log(`size is ${todos.length}`, 10000);
  });
  //fetch-backend
  const fetchTasks = async () => {
    const res = await fetch("./dummy.json");
    const data = await res.json();
    return data;
  };

  //delete-backend
  const delTask = async (id) => {
    const res = await fetch("http://localhost:8080/tasks/" + id);
    const data = await res.json();
    return data;
  };

  //add-backend
  const addTsk = async (task) => {
    const res = await fetch(
      "http://localhost:8080/tasks/add?text=" +
        task.text +
        "&day=" +
        task.day +
        "&reminder=" +
        task.reminder
    );
    const data = await res.json();
    return data;
  };

  function addTask(task) {
    addTsk(task)
      .then((e) => setTasks(e))
      .catch((e) => {
        console.log(`error occured ${e}`);
      });
  }

  function deleteTask(id) {
    let confimation = window.confirm("do you want delete the task");
    if (confimation === true) {
      delTask(id)
        .then((res) => {
          fetchTasks();
        })
        .catch((e) => {
          console.log(`error occured ${e}`);
        });
    }
  }

  function toggleButton(id) {
    console.log("Remainder");
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, reminder: !task.reminder } : task
      )
    );
    console.log(JSON.stringify(tasks));
  }

  function showForm() {
    setHideForm(!hideForm);
  }
  return (
    <div className="container" style={marginStyle}>
      {error && (
        <div class="alert alert-warning">
          <strong>Warning!</strong> Backend Services are down.
        </div>
      )}

      <div className="addborder">
        <Header title="Task Tracker" showForm={showForm} hideForm={hideForm} />
        {tasks?.length > 0 ? (
          <Tasks
            tasks={tasks}
            onDelete={deleteTask}
            onToggle={toggleButton}
            addTask={addTask}
            hideForm={hideForm}
          />
        ) : (
          "No Tasks to Show"
        )}
      </div>
    </div>
  );
}

const marginStyle = {
  marginTop: "20px",
};
export default Home;

import { useState } from "react"
import Task from "./Task"
import AddTask from "./AddTask"

const Tasks = ({tasks,onDelete,onToggle,addTask,hideForm}) => {

  return (
    
  <div className="jumbotron">
 {hideForm && <AddTask addTask={addTask}></AddTask>}
   {tasks.map((task1)=><Task key={task1.id} task={task1} onDelete={onDelete} onToggle={onToggle}/>)}
  </div>
  )
}

export default Tasks
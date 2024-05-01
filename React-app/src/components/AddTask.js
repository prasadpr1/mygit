import { useState ,useEffect} from "react"
const AddTask = ({addTask}) => {
  const [text,setText] = useState("");
  const [day,setDay] = useState("");
  const[reminder,setReminder] = useState(false);

  function addTaskDetails(e){
    e.preventDefault();
    if(!text){
      alert("Plese add a task")
      return;
    }
    if(!day){
      alert("Please add day")
      return;
    }
    let task =  {
      text:text,
      day:day,
      reminder:reminder
  }
  setText('');
  setReminder(false);
  setDay('');

  addTask(task);

  }
  return (
    <div className="container mt-3">
    <h2>Add Task</h2>
    <form onSubmit={addTaskDetails}>
      <div className="mb-4 mt-4">
        <label htmlFor="task">Task</label>
        <input type="text" value ={text} className="form-control" id="task" 
        placeholder="Add Task" name="task" onChange={e=>setText(e.target.value)}/>
      </div>
      <div className="mb-4">
        <label htmlFor="day">Day & Time</label>
        <input type="datetime-local" value={day} className="form-control" 
        id="text" placeholder="Add Day & Time" name="day" onChange={e=>setDay(e.target.value)}/>
      </div>
      <div  className="form-check mb-4">
        <label className="form-check-label">
          <input value ={reminder} className="form-check-input"  type="checkbox" 
          name="remainder"  onChange={(e)=>setReminder(e.currentTarget.checked)}/> Reminder
        </label>
      </div>
      <input type="submit" className="btn btn-primary" value="Save Task" />
    </form>
  </div>
  )
}

export default AddTask
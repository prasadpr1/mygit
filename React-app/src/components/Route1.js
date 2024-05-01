import { useState, useMemo, useCallback, useEffect, useRef } from "react";
const Route1 = () => {
  const [count, setCount] = useState(0);
  const [todos, setTodos] = useState([]);
  const [calculation, setCalculation] = useState(0);
  const [flag, setFlag] = useState(false);
  const clickCount = useRef(-1);

  const increment = useMemo(() => {
    return setCalculation(expensiveCalculation(count));
  }, [count]);

  const clickCountInc = () => {
    console.log(`Increment ops ${clickCount.current}`);
    clickCount.current = clickCount.current + 1;
    setCount(clickCount.current);
  };

  const clickCountDec = () => {
    clickCount.current = clickCount.current - 1;
    console.log(`Decrement ops ${clickCount.current}`);
    if (clickCount.current > -6) {
      setCount(clickCount.current);
    }
  };
  useEffect(() => {
    console.log("rendering");
  }, [count]);
  const addTodo = useCallback(() => {
    console.log("todos event is started");
    expensiveCalculation(count + 1);
    setFlag(!flag);
    setTodos((t) => {
      return [...t, `New Todo => ${todos.length + 1}`];
    });
  }, [todos]);

  return (
    <div>
      <div>
        <h2>My Todos</h2>
        {todos.map((todo, index) => {
          return <p key={index}>{todo}</p>;
        })}
        <button onClick={addTodo}>Add Todo</button>
      </div>
      <hr />
      <div>
        Count: {count}
        <button onClick={clickCountInc}>+</button>
        <button onClick={clickCountDec}>-</button>
        <h2>Expensive Calculation</h2>
        {calculation}
      </div>
    </div>
  );
};
const expensiveCalculation = (num) => {
  for (let i = 0; i < 100000000; i++) {
    num += 1;
  }
  console.log("Expensive calication");
  return num;
};
export default Route1;

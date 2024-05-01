import React from 'react'

const Button = ({buttonClass,buttonName,onClick}) => {
  return (
    <button type="button" className={buttonClass} onClick={onClick}>{buttonName}</button>
  )
}

export default Button;
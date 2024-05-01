const NotFound = () => {
  return (
    <>
      <div class="alert alert-danger" style={marginStyle}>
        <strong>Error!</strong> No Page Found
      </div>
    </>
  );
};

const marginStyle = {
  marginTop: "20px",
};

export default NotFound;

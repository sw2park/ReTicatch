import "./Expectation.css";

function Expectation({ expectation }) {
  return (
    <div className="expectation-item">
      <div className="expectation-content">
        <p className="expectation-text">{expectation.exp_content}</p>
      </div>
      <div className="expectation-footer">
        <span className="expectation-user">{expectation.seq_user_id.user_name}</span>
        <span className="expectation-date">{expectation.exp_date}</span>
        <span className="expectation-tag">예매자</span>
      </div>
    </div>
  );
}

export default Expectation;
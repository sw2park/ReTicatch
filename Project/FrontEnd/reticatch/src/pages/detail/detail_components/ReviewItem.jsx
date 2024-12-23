import "./ReviewItem.css";

function ReviewItem({ review }) {
  return (
    <div className="review-item">
      <div className="review-content">
        <p className="review-text">{review.review_content}</p>
      </div>
      <div className="review-footer">
        <span className="review-user">{review.seq_user_id.user_name}</span>
        <span className="review-date">{review.review_date}</span>
        <span className="review-tag">예매자</span>
      </div>
    </div>
  );
}

export default ReviewItem;
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import ReviewItem from "../detail_components/ReviewItem";

import "./DetailReview.css";

function DetailReview({ seqNum }) {
  const [reviewList, setReviewList] = useState();
  const [textData, setTextData] = useState();
  const navigate = useNavigate();

  let userId = sessionStorage.getItem('loginId');

  useEffect(() => {
    postReviewList(seqNum);
  }, []);

  function onChangeTextarea(e) {
    console.log(e.target.value);
    setTextData(e.target.value);
  }

  function handleClickBtn() {
    if (userId === undefined || userId === null) {
      alert("로그인 후 사용 가능합니다.");
      navigate("/login");
    } else {
      postAddReview(seqNum, userId);
    }
  }

  async function postAddReview(pfJoinSeqNum, userId) {
    const reqData = { pfJoinSeqNum, textData, userId};
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postAddReview",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(reqData),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
    } catch (e) {
      console.log(e);
    }
    alert('고객님의 리뷰가 추가되었습니다!');
    window.location.reload();
  }

  async function postReviewList(seqNum) {
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postReviewData",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(seqNum),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      console.log(responseData);
      setReviewList(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <div className="detail-review-main-wrap">
      <div>
        <h3>
          게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.
        </h3>
      </div>
      <div className="detail-review-main-container">
        <div className="detail-review-main-header">
          <p className="detail-review-main-title">관람후기를 남겨보세요!</p>
        </div>
        <div className="detail-review-main-body">
          <textarea
            className="detail-review-main-textarea"
            placeholder="관람후기를 남겨보세요!"
            maxlength="1000"
            onChange={onChangeTextarea}
          ></textarea>
        </div>
        <div className="detail-review-main-footer">
          <button
            className="detail-review-main-submit-btn"
            onClick={handleClickBtn}
          >
            등록
          </button>
        </div>
      </div>
      <div className="review-container">
        {reviewList != null || reviewList != undefined ? (
          reviewList.map((review, index) => (
            <ReviewItem key={index} review={review} />
          ))
        ) : (
          <p>No content</p>
        )}
      </div>
    </div>
  );
}

export default DetailReview;

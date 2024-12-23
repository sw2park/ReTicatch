import { useEffect, useState } from "react";

import TableData from "../mypage_components/mypage_manage/TableData";
import "./ManageReviewPage.css";

function ManageReviewPage() {
  const [reviewList, setReviewList] = useState();
  let userId = sessionStorage.getItem("loginId");

  useEffect(() => {
    postReviewList();
  }, []);

  async function postReviewList() {
    try {
      const response = await fetch(
        "http://localhost:9090/api/mypage/postReviewList",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(userId),
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
    <div className="manage-wrapper">
      <div className="manage-title">
        <h1>리뷰 관리</h1>
      </div>
      <div className="manage-subtitle">
        <p>
          고객님께서 작성하신 리뷰들을 확인하실 수 있습니다. <br /> 티캐치
          운영정책에 위반되거나, 후기의 성격에 맞지 않는 글은 고객님께 사전 통보
          없이 삭제될 수 있습니다.
        </p>
      </div>
      <div className="manage-table">
        <table className="manage-table-head">
          <th className="manage-table-name">상품명</th>
          <th className="manage-table-contents">리뷰 내용</th>
          <th className="manage-table-day">작성일</th>
          {reviewList != null || reviewList != undefined ? (
            reviewList.map((review, index) => (
              <TableData key={index} review={review} />
            ))
          ) : (
            <p>No content</p>
          )}
        </table>
      </div>
    </div>
  );
}

export default ManageReviewPage;

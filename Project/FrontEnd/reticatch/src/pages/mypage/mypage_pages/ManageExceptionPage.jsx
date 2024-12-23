import { useEffect, useState } from "react";

import ManageTable from "../mypage_components/mypage_manage/ManageTable";
import "./ManageExceptionPage.css";

function ManageExceptionPage() {
  const [exceptionList, setExceptionList] = useState();
  let userId = sessionStorage.getItem("loginId");

  useEffect(() => {
    postExceptionList();
  }, []);

  async function postExceptionList() {
    try {
      const response = await fetch(
        "http://localhost:9090/api/mypage/postExceptionList",
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
      setExceptionList(responseData);
    } catch (e) {
      console.log(e);
    }
  }
  return (
    <div className="manage-wrapper">
      <div className="manage-title">
        <h1>기대평 관리</h1>
      </div>
      <div className="manage-subtitle">
        <p>
          고객님께서 남겨주신 기대평을 확인하실 수 있습니다. <br /> 티캐치
          운영정책에 위반되거나, 후기의 성격에 맞지 않는 글은 고객님께 사전 통보
          없이 삭제될 수 있습니다.
        </p>
      </div>
      <div className="manage-table">
        <table className="manage-table-head">
          <th className="manage-table-name">상품명</th>
          <th className="manage-table-contents">기대평 내용</th>
          <th className="manage-table-day">작성일</th>
          {exceptionList != null || exceptionList != undefined ? (
            exceptionList.map((exception, index) => (
              <ManageTable key={index} exception={exception} />
            ))
          ) : (
            <p>No content</p>
          )}
        </table>
      </div>
    </div>
  );
}

export default ManageExceptionPage;

import { useState, useEffect } from "react";

import ConfirmNotice from "../mypage_components/mypage_confirm/ConfirmNotice";

import ConfirmSubTitle from "../mypage_components/mypage_confirm/ConfirmSubTitle";
import ConfirmMenuNoitce from "../mypage_components/mypage_confirm/ConfirmMenuNotice";
import TableRow from "../mypage_components/mypage_confirm/TableRow";

import "./ConfirmReservePage.css";

const BASE_URL = "http://localhost:9090/api/mypage/";

function ConfirmReservePage() {
  const [listData, setListData] = useState([]);

  useEffect(() => {
    postTableData();
  }, []);

  async function postTableData() {
    const username = sessionStorage.getItem('loginId');

    try {
      const response = await fetch(BASE_URL + "searchConfirmQuery", {
        method: "POST",
        headers: { "Content-Type" : "application/json"},
        body: JSON.stringify(username),
      });
      if(!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      setListData(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
      <div className="confirm-wrapper">
        <div className="confirm-title">
          <h1>예매 확인 / 취소</h1>
        </div>
        <ConfirmSubTitle />
        <div className="confirm-notice-wrapper">
          <ConfirmMenuNoitce />
        </div>
        <div className="confirm-table">
          <table className="confirm-table-head">
            <th className="confirm-table-num">예매번호</th>
            <th className="confirm-table-name">티켓명</th>
            <th className="confirm-table-day">관람일시</th>
            <th className="confirm-table-count">매수</th>
            <th className="confirm-table-cancel">취소가능일</th>
            <th className="confirm-table-status">상태</th>
            <th className="confirm-table-buttton">취소하기</th>
            <TableRow listData={listData} />
          </table>
        </div>
        <ConfirmNotice />
      </div>
  );
}

export default ConfirmReservePage;

import { useState, useEffect } from "react";

import ConfirmNotice from "../mypage_components/mypage_confirm/ConfirmNotice";

import ConfirmSubTitle from "../mypage_components/mypage_confirm/ConfirmSubTitle";
import ConfirmMenuNoitce from "../mypage_components/mypage_confirm/ConfirmMenuNotice";
import TableRow from "../mypage_components/mypage_confirm/TableRow";

import "./ConfirmReservePage.css";
import axios from "axios";

const BASE_URL = "http://localhost:9090/api/mypage/";

function ConfirmReservePage() {
  const [listData, setListData] = useState([]);

  useEffect(() => {
    postTableData();
    // getTableData();
  }, []);

  async function postTableData() {
    const username = 'user02'; // 테스트용

    try {
      const response = await fetch("/api/mypage/searchConfirmQuery", {
        method: "POST",
        headers: { "Content-Type" : "application/json"},
        body: JSON.stringify(username),
      });
      if(!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      console.log(response);
      // setListData(responseData.data);
    } catch (e) {
      console.log(e);
    }
  }

  async function getTableData() {
    await axios
      .get(BASE_URL + "searchConfirm")
      .then((response) => {
        console.log("데이터 통신 성공");
        console.log(response.data);

        setListData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
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
            <TableRow listData={listData} />
          </table>
        </div>
        <ConfirmNotice />
      </div>
  );
}

export default ConfirmReservePage;

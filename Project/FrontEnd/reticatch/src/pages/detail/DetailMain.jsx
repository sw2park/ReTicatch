import { useNavigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";

import DetailCancelNotice from "./detail_pages/DetailCancelNotice";
import DetailExpection from "./detail_pages/DetailExpectation";
import DetailInfo from "./detail_pages/DetailInfo";
import DetailReview from "./detail_pages/DetailReview";


import Footer from "../main/footer/Footer";

import "./DetailMain.css";

function DetailMain() {
  const { seqpfjoinId } = useParams();
  const [detailData, setDetailData] = useState();
  const [contents, setContents] = useState("detailInfo");
  const navigate = useNavigate();

  let userId = sessionStorage.getItem("loginId");
  
  useEffect(() => {
    postDetailData();
  }, []);

  function handleSelect(selectedButton) {
    setContents(selectedButton);
  }

  function handleClickBtn() {
    if (userId === undefined || userId === null) {
      alert("로그인 후 사용 가능합니다.");
      navigate("/login");
    } else {
      postAddOrders(seqpfjoinId);
      alert("성공적으로 예매했습니다!");
      navigate("/mypage");
    }
  }

  const renderPage = () => {
    switch (contents) {
      case "detailInfo":
        return <DetailInfo seqNum={seqpfjoinId} />;
      case "review":
        return <DetailReview seqNum={seqpfjoinId} />;
      case "expectation":
        return <DetailExpection seqNum={seqpfjoinId} />;
      case "cancelNotice":
        return <DetailCancelNotice />;
      default:
        return <DetailInfo />;
    }
  };

  async function postAddOrders(seqpfjoinId) {
    const reqData = {seqpfjoinId, userId};
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postAddOrders",
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
  }

  async function postDetailData() {
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postDetailData",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(seqpfjoinId),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      console.log(responseData);
      setDetailData(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <div className="detail-main">
        <div className="detail-info-header-wrap">
          <div className="detail-info-header-wrap-left">
            <div className="detail-info-header-poster">
              <img
                className="detail-info-poster"
                src={detailData?.p_poster || "default-poster.png"}
                alt={detailData?.p_title || "No title available"}
              />
            </div>
          </div>
          <div className="detail-info-header-wrap-right">
            <div className="detail-info-header-title">
              <span className="detail-info-title">
                {detailData?.p_title || "No title available"}
              </span>
            </div>
            <div className="detail-info-header-table">
              <table>
                <tr>
                  <th className="detail-info-table-head">장소</th>
                  <td className="detail-info-table-data">
                    {detailData?.pd_hall_name || "default"}
                  </td>
                  <th className="detail-info-table-head">관람시간</th>
                  <td className="detail-info-table-data">
                    {detailData?.pd_runtime || "default"}
                  </td>
                </tr>
                <tr>
                  <th className="detail-info-table-head">기간</th>
                  <td className="detail-info-table-data">
                    {detailData?.p_start_date || "default"}&nbsp;~&nbsp;
                    {detailData?.p_end_date || "default"}
                  </td>
                  <th className="detail-info-table-head">어린이 관람</th>
                  <td className="detail-info-table-data">
                    {detailData?.pd_child || "default"}
                  </td>
                </tr>
                <tr>
                  <th className="detail-info-table-head">가격</th>
                  <td className="detail-info-table-data">
                    {detailData?.pd_seatprice || "default"}
                  </td>
                  <th className="detail-info-table-head">출연진</th>
                  <td className="detail-info-table-data">
                    {detailData?.pd_cast || "default"}
                  </td>
                </tr>
              </table>
            </div>
            <div>
              <button className="detail-info-button" onClick={handleClickBtn}>
                예매하기
              </button>
            </div>
          </div>
        </div>
        <div className="detail-info-wrap">
          <ul className="detail-info-list-wrap">
            <li
              className="detail-info-list"
              onClick={() => {
                handleSelect("detailInfo");
              }}
            >
              상세정보
            </li>
            <li
              className="detail-info-list"
              onClick={() => {
                handleSelect("review");
              }}
            >
              관람후기
            </li>
            <li
              className="detail-info-list"
              onClick={() => {
                handleSelect("expectation");
              }}
            >
              기대평
            </li>
            <li
              className="detail-info-list"
              onClick={() => {
                handleSelect("cancelNotice");
              }}
            >
              예매/취소안내
            </li>
          </ul>
        </div>
        <div className="detail-contents-wrap">
          <div className="detail-contents">{renderPage()}</div>
        </div>
      </div>
      <Footer></Footer>
    </>
  );
}

export default DetailMain;

import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";

import "./DetailMain.css";

function DetailMain() {
  const { seqpfjoinId } = useParams();
  const [detailData, setDetailData] = useState();

  useEffect(() => {
    postDetailData();
  }, []);

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
        </div>
      </div>
      <div className="detail-reserve-box-wrap">
        <div className="detail-reserve-box-left">
          <div className="detail-reserve-box-left-header">
            <span className="detail-reserve-box-step">Step1</span>
            <span className="detail-reserve-box-title">날짜 선택</span>
          </div>
          <div className="detail-reserve-box-left-content">
            캘린더 들어갈 자리
          </div>
        </div>
        <div className="detail-reserve-box-center">
          <div className="detail-reserve-box-center-header">
            <span className="detail-reserve-box-step">Step2</span>
            <span className="detail-reserve-box-title">회차 선택</span>
          </div>
          <div className="detail-reserve-box-center-content">
            회차 정보 들어갈 자리
          </div>
        </div>
        <div className="detail-reserve-box-right">
          <span className="detail-reserve-right-title">예매가능좌석</span>
          <table className="detail-reserve-right-table">
            <tr>
              <th className="detail-reserve-table-head">R석</th>
              <td className="detail-reserve-table-data">매진</td>
            </tr>
            <tr>
              <th className="detail-reserve-table-head">S석</th>
              <td className="detail-reserve-table-data">매진</td>
            </tr>
            <tr>
              <th className="detail-reserve-table-head">VIP석</th>
              <td className="detail-reserve-table-data">매진</td>
            </tr>
          </table>
        </div>
      </div>
      <div>상세정보 및 탭바 들어갈 자리</div>
    </div>
  );
}

export default DetailMain;

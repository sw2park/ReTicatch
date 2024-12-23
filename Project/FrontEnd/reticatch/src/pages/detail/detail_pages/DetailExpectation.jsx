import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import Expectation from "../detail_components/Expectation";

import "./DetailExpectation.css";
//expectation
function DetailExpectation({ seqNum }) {
  const [expectationList, setExpectationList] = useState();
  const [textData, setTextData] = useState();
  const navigate = useNavigate();

  let userId = sessionStorage.getItem("loginId");

  useEffect(() => {
    postExpectationList(seqNum);
  }, []);

  function onChangeTextarea(e) {
    setTextData(e.target.value);
  }

  function handleClickBtn() {
    if (userId === undefined || userId === null) {
      alert("로그인 후 사용 가능합니다.");
      navigate("/login");
    } else {
      postAddExpectation(seqNum, userId);
    }
  }

  async function postAddExpectation(pfJoinSeqNum, userId) {
    const reqData = { pfJoinSeqNum, textData, userId };
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postAddExpectation",
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
    alert("고객님의 기대평이 추가되었습니다!");
    window.location.reload();
  }

  async function postExpectationList(seqNum) {
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postExpectationList",
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
      setExpectationList(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <div className="detail-expectation-main-wrap">
      <div>
        <h3>
          게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.
        </h3>
      </div>
      <div className="detail-expectation-main-container">
        <div className="detail-expectation-main-header">
          <p className="detail-expectation-main-title">기대평을 남겨보세요!</p>
        </div>
        <div className="detail-expectation-main-body">
          <textarea
            className="detail-expectation-main-textarea"
            placeholder="기대평을 남겨보세요!"
            maxlength="1000"
            onChange={onChangeTextarea}
          ></textarea>
        </div>
        <div className="detail-expectation-main-footer">
          <button
            className="detail-expectation-main-submit-btn"
            onClick={handleClickBtn}
          >
            등록
          </button>
        </div>
      </div>
      <div className="expectation-container">
        {expectationList != null || expectationList != undefined ? (
          expectationList.map((expectation, index) => (
            <Expectation key={index} expectation={expectation} />
          ))
        ) : (
          <p>No content</p>
        )}
      </div>
    </div>
  );
}

export default DetailExpectation;

import { useState, useEffect } from "react";

import "./MyPage.css";
import TabList from "./mypage_components/mypage_menu/TabList";
import Footer from "../main/footer/Footer";

import ConfirmReservePage from "./mypage_pages/ConfirmReservePage";
import DeleteMemberPage from "./mypage_pages/DeleteMemberPage";
import ManageExceptionPage from "./mypage_pages/ManageExceptionPage";
import ManageReviewPage from "./mypage_pages/ManageReviewPage";
import ModifyMemberInfoPage from "./mypage_pages/ModifyMemberInfoPage";

function MyPage() {
  const [contents, setContents] = useState("ConfirmReservePage");
  const [reviewCount, setReviewCount] = useState();
  const [exceptionCount, setExceptionCount] = useState();
  const [reserveCount, setReserveCount] = useState();

  useEffect(() => {
    postSomeCount();
  });

  async function postSomeCount() {
    const userId = sessionStorage.getItem("loginId");
    try {
      const response = await fetch(
        "http://localhost:9090/api/mypage/postSomeCount",
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
      setReviewCount(responseData.reviewCount);
      setExceptionCount(responseData.expectionCount);
      setReserveCount(responseData.reserveCount);
    } catch (e) {
      console.log(e);
    }
  }

  function handleSelect(selectedButton) {
    setContents(selectedButton);
  }

  const renderPage = () => {
    switch (contents) {
      case "ConfirmReservePage":
        return <ConfirmReservePage />;
      case "ManageExceptionPage":
        return <ManageExceptionPage />;
      case "ManageReviewPage":
        return <ManageReviewPage />;
      case "ModifyMemberInfoPage":
        return <ModifyMemberInfoPage />;
      case "DeleteMemberPage":
        return <DeleteMemberPage />;
      default:
        return <ConfirmReservePage />;
    }
  };

  return (
    <>
      <main className="mypage-body">
        <div className="top-bar">
          <div className="left-title">
            <div className="mypage-title">
              <h1>마이페이지</h1>
            </div>
          </div>
          <div className="right-title">
            <div className="mypage-point">
              <div className="mypage-exceptions">
                <span className="span-title">나의 기대평</span>
                <span
                  className="span-subtitle"
                  onClick={() => {
                    handleSelect("ManageExceptionPage");
                  }}
                >
                  {exceptionCount}
                </span>
              </div>
              <div className="mypage-review">
                <span className="span-title">후기</span>
                <span
                  className="span-subtitle"
                  onClick={() => {
                    handleSelect("ManageReviewPage");
                  }}
                >
                  {reviewCount}
                </span>
              </div>
              <div className="mypage-reservation-count">
                <span className="span-title">나의 예매권</span>
                <span
                  className="span-subtitle"
                  onClick={() => {
                    handleSelect("ConfirmReservePage");
                  }}
                >
                  {reserveCount}
                </span>
              </div>
              <div className="mypage-edit-myInfo">
                <span className="span-title">나의 회원정보</span>
                <span
                  className="span-subtitle"
                  onClick={() => {
                    handleSelect("ModifyMemberInfoPage");
                  }}
                >
                  수정 &gt;
                </span>
              </div>
            </div>
          </div>
        </div>
        <div className="flex-container">
          <div className="left-pannel">
            <div className="mypage-menu">
              <div className="mypage-menu-reservation">
                <ul>
                  <li className="mypage-menu-title">예매관리</li>
                  <TabList
                    onClick={() => {
                      handleSelect("ConfirmReservePage");
                    }}
                  >
                    예매 확인 / 취소
                  </TabList>
                </ul>
              </div>
              <div className="mypage-menu-activity">
                <ul>
                  <li className="mypage-menu-title">활동관리</li>
                  <TabList
                    onClick={() => {
                      handleSelect("ManageExceptionPage");
                    }}
                  >
                    기대평 관리
                  </TabList>
                  <TabList
                    onClick={() => {
                      handleSelect("ManageReviewPage");
                    }}
                  >
                    후기 관리
                  </TabList>
                </ul>
              </div>
              <div className="mypage-menu-memberinfo">
                <ul>
                  <li className="mypage-menu-title">회원정보관리</li>
                  <TabList
                    onClick={() => {
                      handleSelect("ModifyMemberInfoPage");
                    }}
                  >
                    회원정보수정
                  </TabList>
                  <TabList
                    onClick={() => {
                      handleSelect("DeleteMemberPage");
                    }}
                  >
                    회원 탈퇴
                  </TabList>
                </ul>
              </div>
            </div>
          </div>
          <div className="right-pannel">
            <div className="mypage-contents">{renderPage()}</div>
          </div>
        </div>
      </main>
      <Footer />
    </>
  );
}

export default MyPage;

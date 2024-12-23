import { useNavigate } from "react-router-dom";

import "./DeleteMemberPage.css";

function DeleteMemberPage() {
  const navigate = useNavigate();
  function handleClickBtn() {
    postDeleteUser();
    alert("회원탈퇴가 완료되었습니다. \n메인 화면으로 이동합니다.");
    sessionStorage.clear();
    navigate("/");
    window.location.reload();
  }

  async function postDeleteUser() {
    const userId = sessionStorage.getItem("loginId");
    try {
      const response = await fetch(
        "http://localhost:9090/api/mypage/postDeleteUser",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(userId),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <div className="delete-title-wrap">
        <h1>회원 탈퇴</h1>
        <h2>정말 탈퇴하시겠습니까?</h2>
        <p>회원 탈퇴를 희망하시는 경우 아래 '탈퇴하기' 버튼을 눌러주십시오.</p>
        <button className="delete-title-button" onClick={handleClickBtn}>
          탈퇴하기
        </button>
      </div>
    </>
  );
}

export default DeleteMemberPage;

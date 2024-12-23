import { useState, useEffect } from "react";

import "./ModifyMemberInfoPage.css";

function ModifyMemberInfoPage() {
  const [userData, setUserData] = useState([]);
  const [isModify, setIsModify] = useState(false);

  const [userId, setUserId] = useState();
  const [userPW, setUserPW] = useState();
  const [userName, setUserName] = useState();
  const [userPhone, setUserPhone] = useState();

  useEffect(() => {
    postUserData();
  }, []);

  function onChangeId(event) {
    setUserId(event.target.value);
  }

  function onChangePW(event) {
    setUserPW(event.target.value);
  }

  function onChangeName(event) {
    setUserName(event.target.value);
  }

  function onChangePhone(event) {
    setUserPhone(event.target.value);
  }

  function handleSelectButton(data) {
    let pw = prompt(
      "회원정보를 수정하시려면 비밀번호 확인이 필요합니다. \n비밀번호를 입력해주세요."
    );

    if (pw === data.user_pw) {
      alert("비밀번호가 확인되었습니다. \n회원정보 수정이 가능합니다.");
      setIsModify(true);
    } else {
      alert("비밀번호가 틀렸습니다.");
    }
  }

  function handleUpdateButton(seq_user_id) {
    postUpadateUserData(seq_user_id);
  }

  async function postUpadateUserData(seq_user_id) {
    try {
      const reqData = {
        seq_user_id,
        userId: sessionStorage.getItem("loginId"),
        userPW,
        userName,
        userPhone,
      };

      const response = await fetch(
        "http://localhost:9090/api/mypage/postUpdateUser",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(reqData),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      alert("회원정보 수정 완료!");
      window.location.reload();
    } catch (e) {
      console.log(e);
    }
  }

  async function postUserData() {
    const username = sessionStorage.getItem("loginId");

    try {
      const response = await fetch(
        "http://localhost:9090/api/mypage/postUserData",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(username),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      setUserData(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <div className="modify-wrapper">
        <div className="modify-title">
          <h1>회원 정보 수정 </h1>
        </div>
        <div className="modify-info-wrapper">
          <table className="modify-table">
            <tr>
              <th className="modify-table-th">아이디</th>
              <td className="modify-table-td">{userData.user_id}</td>
            </tr>
            <tr>
              <th className="modify-table-th">비밀번호</th>
              <td className="modify-table-td">
                {isModify == true ? (
                  <input
                    type="password"
                    className="modify-table-input"
                    placeholder={userData.user_pw}
                    onChange={onChangePW}
                  />
                ) : (
                  "******************"
                )}
              </td>
            </tr>
            <tr>
              <th className="modify-table-th">이름</th>
              <td className="modify-table-td">{userData.user_name}</td>
            </tr>
            <tr>
              <th className="modify-table-th">연락처</th>
              <td className="modify-table-td">
                {isModify == true ? (
                  <input
                    type="text"
                    className="modify-table-input"
                    placeholder={userData.user_phone}
                    onChange={onChangePhone}
                  />
                ) : (
                  userData.user_phone
                )}
              </td>
            </tr>
            <tr>
              <th className="modify-table-th">로그인 정보</th>
              <td className="modify-table-td">{userData.login_type}</td>
            </tr>
            <tr>
              <th className="modify-table-th">회원가입일</th>
              <td className="modify-table-td">{userData.u_create_date}</td>
            </tr>
            <tr>
              <th className="modify-table-th">마지막 정보수정일</th>
              <td className="modify-table-td">{userData.u_update_date}</td>
            </tr>
          </table>
        </div>
        <div className="modify-info-btn-section">
          <button
            className="modify-info-button"
            onClick={
              isModify == true
                ? () => handleUpdateButton(userData.seq_user_id)
                : () => handleSelectButton(userData)
            }
          >
            회원정보 수정
          </button>
        </div>
      </div>
    </>
  );
}

export default ModifyMemberInfoPage;

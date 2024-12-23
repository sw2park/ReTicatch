import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import "./Header.css";

export default function Header() {
  const [isLogin, setIsLogin] = useState(false);

  useEffect(() => {
    setIsLogin(sessionStorage.getItem("loginId"));
  }, []);

  function handleLogoutBtn () {
    setIsLogin(false);
    // 세션해제
    sessionStorage.clear();
    sessionStorage.removeItem('loginId');
    alert('로그아웃되었습니다!');
    window.location.reload();
  }

  return (
    <header>
      <div className="top-bar-gray">
        {isLogin == undefined || isLogin == null ? (
          <ul className="top-bar-gray-right">
            <Link to="/login">
              <li className="top-bar-gray-right-list">로그인</li>
            </Link>
            <Link to="/signup">
              <li className="top-bar-gray-right-list">회원가입</li>
            </Link>
            <li className="top-bar-gray-right-list-end">고객센터</li>
          </ul>
        ) : (
          <ul className="top-bar-gray-login">
            <Link to="/mypage">
              <li className="top-bar-login">{isLogin}&nbsp;님, 환영합니다.</li>
            </Link>
              <li className="top-bar-login-end" onClick={handleLogoutBtn}> 로그아웃</li>
          </ul>
        )}
      </div>
      <div className="top-bar">
        <div className="con top-con">
          <div className="logo-box">
            <Link to="/">Ticatch</Link>
          </div>
        </div>
      </div>
      <hr />
    </header>
  );
}
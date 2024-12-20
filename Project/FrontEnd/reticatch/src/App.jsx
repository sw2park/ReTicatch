import {
  BrowserRouter as Router,
  Routes,
  Route,
  useLocation,
} from "react-router-dom";
import Header from "./pages/main/header/Header.jsx";
import Login from "./pages/signUp/LoginForm";
import AddMemberForm from "./pages/signUp/addMemberForm";
import "./pages/signUp/login.css";
import Banner from "./pages/main/banner/BannerSlider.jsx";
import MainSlide from "./pages/main/banner/MainSlide.jsx";
import MainSlide2 from "./pages/main/banner/MainSlide2.jsx";
import Footer from "./pages/main/footer/Footer.jsx";

import MyPage from "./pages/mypage/mypage";
import DetailMain from "./pages/detail/DetailMain.jsx";

function App() {
  const location = useLocation(); // 현재 경로 가져오기

  // 로그인 및 회원가입 페이지가 아닌 경우에만 Header 렌더링
  const hideHeaderPaths = ["/login", "/signup"];
  const shouldShowHeader = !hideHeaderPaths.includes(location.pathname);

  return (
    <>
      {shouldShowHeader && <Header />}
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<AddMemberForm />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/detail/:seqpfjoinId/view" element={<DetailMain />} />
        <Route
          path="/"
          element={
            <div>
              <Banner />
              <MainSlide />
              <MainSlide2 />
              <Footer />
            </div>
          }
        />
      </Routes>
    </>
  );
}

export default function AppWithRouter() {
  return (
    <Router>
      <App />
    </Router>
  );
}

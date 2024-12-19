import "./SelectSection.css";
import { useState } from "react";

function SelectSection() {
  const [selectMode, setSelectMode] = useState("buy_date");
  const [selectMonth, setSelectMonth] = useState("01");
  const [selectYear, setSelectYear] = useState("2024");

  const data = {
    mode: "예매일",
    month: "월",
    year: "연도",
  };

  const handleSelectModeValue = (e) => {
    setSelectMode(e.target.value);
    console.log(e.target.value);
  };

  const handleSelectMonthValue = (e) => {
    setSelectMonth(e.target.value);
    console.log(e.target.value);
  };

  const handleSelectYearValue = (e) => {
    setSelectYear(e.target.value);
    console.log(e.target.value);
  };

  async function handleClickBtn() {
    // 데이터 세팅하고
    data.mode = selectMode;
    data.month = selectMonth;
    data.year = selectYear;

    // post 요청 보내기
    // 기간별 조회로
    try {
      const response = await fetch("/api/mypage/searchConfirmQuery", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      });
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      console.log(data);
      const responseData = await response.json();
      console.log(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <p>월 별 조회</p>
      <div className="confirm-menu-search-select">
        <select
          name="search-mode"
          onChange={handleSelectModeValue}
          value={selectMode}
        >
          <option value="buy_date">예매일</option>
          <option value="view_date">관람일</option>
        </select>
        <select
          name="search-mode-year"
          onChange={handleSelectYearValue}
          value={selectYear}
        >
          <option value="2024">2024년</option>
          <option value="2023">2023년</option>
          <option value="2022">2022년</option>
        </select>
        <select
          name="search-mode-month"
          onChange={handleSelectMonthValue}
          value={selectMonth}
        >
          <option value="01">1월</option>
          <option value="02">2월</option>
          <option value="03">3월</option>
          <option value="04">4월</option>
          <option value="05">5월</option>
          <option value="06">6월</option>
          <option value="07">7월</option>
          <option value="08">8월</option>
          <option value="09">9월</option>
          <option value="10">10월</option>
          <option value="11">11월</option>
          <option value="12">12월</option>
        </select>
        <button onClick={handleClickBtn}>조회</button>
      </div>
    </>
  );
}

export default SelectSection;
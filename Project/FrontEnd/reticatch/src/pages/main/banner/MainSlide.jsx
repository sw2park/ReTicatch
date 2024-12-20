import React, { useState, useRef, useEffect } from "react";
import { Link } from "react-router-dom";
import "./MainSlide.css"; // 스타일을 별도로 관리하는 경우

const Carousel = () => {
  const [currentSlide, setCurrentSlide] = useState(0);
  const [listData, setListData] = useState([]);
  const slidesContainerRef = useRef(null);
  const slideRef = useRef(null);
  const slidesToShow = 4; // 화면에 표시할 슬라이드 개수

  const totalSlides = listData.length;

  const moveSlide = (direction) => {
    let newSlide = currentSlide + direction;

    // 화면에 표시할 슬라이드 개수를 고려하여 인덱스 범위 조정
    if (newSlide < 0) {
      newSlide = totalSlides - slidesToShow;
    } else if (newSlide > totalSlides - slidesToShow) {
      newSlide = 0;
    }

    setCurrentSlide(newSlide);
  };

  useEffect(() => {
    const slidesContainer = slidesContainerRef.current;
    const singleSlide = slideRef.current;

    if (slidesContainer && singleSlide) {
      const slideWidth = singleSlide.offsetWidth;
      slidesContainer.style.transform = `translateX(-${
        currentSlide * slideWidth
      }px)`;
    }
  }, [currentSlide]);

  useEffect(() => {
    getPfjoinApi();
  }, []);

  async function getPfjoinApi() {
    try {
      const response = await fetch("http://localhost:9090/api/getPfjoinApi", {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      const responseData = await response.json();
      console.log(responseData);
      setListData(responseData);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <div className="main-slide">
      <button className="prev" onClick={() => moveSlide(-1)}>
        &lt;
      </button>
      <div className="carousel-slides" ref={slidesContainerRef}>
        {listData.map((data, index) => (
          <div
            className="slide"
            key={index}
            style={{ flex: `0 0 ${100 / slidesToShow}%` }}
            ref={index === 0 ? slideRef : null}
          >
            <Link to={`/detail/${data.seq_pfjoin_id}/view`}>
              <img src={data.p_poster} alt={`Image ${index + 1}`} />
            </Link>
          </div>
        ))}
      </div>
      <button className="next" onClick={() => moveSlide(1)}>
        &gt;
      </button>
    </div>
  );
};

export default Carousel;

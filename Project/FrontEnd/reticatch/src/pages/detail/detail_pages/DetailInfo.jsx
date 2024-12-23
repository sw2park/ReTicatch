import { useState, useEffect } from "react";

import './DetailInfo.css';

function DetailInfo({seqNum}) {
  const [imageData, setImageData] = useState([]);
  
  useEffect(() => {
    postDetailImage(seqNum);
  }, []);

  async function postDetailImage(seqNum) {
    try {
      const response = await fetch(
        "http://localhost:9090/api/detail/postDetailImage",
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
      setImageData(responseData);
      console.log(imageData);
    } catch (e) {
      console.log(e);
    }
  }
  return (
    <div className="component-detail-info-wrap">
      {imageData.length > 0
        ? imageData.map((data, index) => <img key={index} src={data} className="component-detail-info-img"/>)
        : "no"}
    </div>
  );
}

export default DetailInfo;

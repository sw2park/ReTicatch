import "./TableRow.css";

function TableRow({ listData }) {
  async function postCancelReserve(data) {
    const username = "user02"; // 테스트용 라우터로 통합시 userid로 왔다갔다 할 예정

    try {
      const reqData = { ...data, username };

      const response = await fetch(
        "http://localhost:9090/api/mypage/postCancelReserve",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(reqData),
        }
      );
      if (!response.ok) {
        throw Error(`Error : ${response.status}`);
      }
      window.location.reload();
    } catch (e) {
      console.log(e);
    }
  }

  function handleClickBtn(cancelData) {
    let result = confirm("정말로 취소하시겠습니까?");
    // result가 true면 > 주문 취소 진행 후 alert
    // result가 false면 > 그대로
    if (result == true) {
      postCancelReserve(cancelData);
    } else {
      alert("주문취소를 취소한다");
    }
  }
  return (
    <>
      {listData.map((data) => (
        <tr className="confirm-table-row" key={data.seq_order_id}>
          <td>{data.seq_order_id}</td>
          <td>{data.pf_title}</td>
          <td>{data.view_date}</td>
          <td>{data.total_ticket}장</td>
          <td>{data.ablecancleDate}</td>
          <td>{data.cancel_status === "N" ? "취소 가능" : "취소 완료"}</td>
          <td>
            <button
              className="confirm-table-row-button"
              onClick={() => handleClickBtn(data)}
            >
              예약 취소
            </button>
          </td>
        </tr>
      ))}
    </>
  );
}

export default TableRow;

import "./DetailCancelNotice.css";

function DetailCancelNotice() {
  return (
    <div className="cancel-contents-wrap">
      <div className="cancel-title">
        <h1 className="cancel-title-text">예매/취소안내</h1>
      </div>
      <div className="cancel-contents-text-wrap">
        <h2 className="cancel-contents-text-subtitle">티켓 수령안내</h2>
        <h3 className="cancel-contents-text-subsubtitle">
          1&#41; &nbsp;일반 배송
        </h3>
        <p className="cancel-contents-text-contents">
          예매 완료&#40;결제 완료&#41;확인 후, 인편배송으로 영업일 기준 10일
          이내 티켓을 수령하실 수 있습니다. <br />
          티켓을 배송하기 위한 배송료는 고객이 부담합니다. <br />
          행사 또는 관람일에 따라 일반배송 선택이 제한될 수 있습니다.​
        </p>
        <h3 className="cancel-contents-text-subsubtitle">
          2&#41; &nbsp;현장수령
        </h3>
        <p className="cancel-contents-text-contents">
          행사 당일 공연 시작 시간 1시간 전 ~ 30분 전까지 행사장 매표소에서
          티켓을 수령하실 수 있습니다. <br />
          현장 매표소에서 예매 완료 SMS 또는 예매번호 및 예매자 정보 확인 후
          티켓을 수령할 수 있습니다. <br /> 기획사 정책 또는 행사일에 따라 현장
          수령 방법의 선택이 제한될 수 있습니다.​
        </p>
        <h2 className="cancel-contents-text-subtitle">예매 취소 안내</h2>
        <p className="cancel-contents-text-contents">
          예매 당일 취소하는 경우 이외에는 예매수수료는 환불되지 않습니다.
        </p>
        <p className="cancel-contents-text-contents">
          티켓 예매 후 7일 이내 취소 시 취소수수료는 부과되지 않습니다. <br />
          단, 예매 후 7일 이내라도 취소시점이 관람일로부터 10일 이내라면 그에
          해당하는 취소수수료가 부과됩니다.
        </p>
        <p className="cancel-contents-text-contents">
          배송 받은 티켓의 반품 접수는 취소가능시간 이내&#40;영업일 기준&#41;에
          우편&#40;빠른 등기&#41; 또는 본사 반품을 통해서 입고 완료 건에 한하여
          취소 가능하며, 입고 일을 기준으로 취소수수료 적용됩니다. <br />
          일반우편 또는 택배로 반송 시 발생되는 분실, 지연 도착 등의 문제는
          티켓링크에서 책임지지 않으니 이점 유의하시기 바랍니다.
        </p>

        <table className="cancel-contents-table-wrap">
          <tr>
            <th className="cancel-contents-table-head">관람일 구분</th>
            <th className="cancel-contents-table-head">취소가능시간</th>
          </tr>
          <tr>
            <td className="cancel-contents-table-data">일반</td>
            <td className="cancel-contents-table-data">
              관람일 1일전 17:00시까지
            </td>
          </tr>
          <tr>
            <td className="cancel-contents-table-data">
              관람일이 연휴기간이거나 연휴 다음날인 경우
            </td>
            <td className="cancel-contents-table-data">
              연휴 시작일 1일전 17:00시까지
              <br />
              &#40;연휴기간이 '토요일~화요일'인 경우 금요일 17시까지
              취소가능&#41;
            </td>
          </tr>
        </table>
        <p className="cancel-contents-text-contents">
          일부 공연의 경우 취소 가능 시간이 상이할 수 있습니다.​​​{" "}
        </p>
        <h2 className="cancel-contents-text-subtitle">티켓 환불 안내</h2>
        <p className="cancel-contents-text-contents">
          예매취소 시 취소수수료와 배송료를 제외한 나머지 금액이 환불 됩니다.
          <br />
          취소수수료는 상품별로 상이할 수 있으며 상품 상세정보 하단에서 확인할
          수 있습니다.
        </p>
        <p className="cancel-contents-text-contents">
          무통장입금으로 결제한 경우 환불처리를 위해 예매자 본인명의의
          계좌정보&#40;예금주, 은행, 계좌번호&#41;를 입력해야 하며 접수일로부터
          3~5일&#40;영업일기준&#41;이내 환불 받을 수 있습니다. <br /> 상품에
          따라 환불 시 송금수수료 500원이 부과될 수 있습니다. ​
        </p>
        <p className="cancel-contents-text-contents">
          신용카드로 결제한 경우 취소일로부터 3~6일&#40;영업일기준&#41;이내
          카드사에서 승인취소를 확인할 수 있습니다.
        </p>
        <p className="cancel-contents-text-contents">
          계좌이체, 실시간 계좌출금으로 결제한 경우 취소 시 1~2일&#40;영업일
          기준&#41;이내 환불 됩니다. <br /> 휴대폰결제로 결제한 경우 당월 취소
          시 즉시 환불되나 익월 취소 시에는 최대 60일까지 소요됩니다. <br />
          PAYCO포인트, 예매권, 상품권으로 결제한 경우 취소 시 즉시 계정으로 환불
          됩니다.
        </p>
      </div>
    </div>
  );
}

export default DetailCancelNotice;

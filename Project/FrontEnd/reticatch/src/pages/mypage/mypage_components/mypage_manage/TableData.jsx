import { Link } from "react-router-dom";

import "./TableData.css";

function TableData({ review }) {
  return (
    <tr className="manage-table-row">
      <td>
        <Link to={`/detail/${review.seq_pfJoin_id}/view`}>
          {review.ticketName}
        </Link>{" "}
      </td>
      <td>{review.context}</td>
      <td>{review.date}</td>
    </tr>
  );
}

export default TableData;

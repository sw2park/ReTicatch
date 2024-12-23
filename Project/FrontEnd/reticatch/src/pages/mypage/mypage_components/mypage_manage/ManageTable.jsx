import { Link } from "react-router-dom";

import "./ManageTable.css";

function ManageTable({ exception }) {
  return (
    <tr className="manage-table-row">
      <td><Link to={`/detail/${exception.seq_pfJoin_id}/view`}>{exception.ticketName}</Link> </td>
      <td>{exception.context}</td>
      <td>{exception.date}</td>
    </tr>
  );
}

export default ManageTable;
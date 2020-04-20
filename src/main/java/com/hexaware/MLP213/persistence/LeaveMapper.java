package com.hexaware.MLP213.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.MLP213.model.Leave;
/**
 * Mapper class to map from result set to Leave object.
 */
public class LeaveMapper implements ResultSetMapper<Leave> {
  /**
   * @param idx1 the index
   * @param rs1 the resultset
   * @param ctx1 the context
   * @return the mapped Leave object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Leave map(final int idx1, final ResultSet rs1, final StatementContext ctx1) throws SQLException {
    /**
     * @return Leave
     */
    Leave lp = new Leave(rs1.getInt("LEAVE_ID"), rs1.getInt("EMP_ID"), rs1.getInt("NO_OF_DAYS"),
        rs1.getDate("START_DATE"), rs1.getDate("END_DATE"), rs1.getString("LEAVE_TYPE"),
        rs1.getString("LEAVE_STATUS"), rs1.getString("LEAVE_REASON"), rs1.getDate("APPLIED_ON"),
        rs1.getString("MANAGER_COMMENT"));
    return lp;
  }
}

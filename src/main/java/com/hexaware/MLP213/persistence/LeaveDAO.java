package com.hexaware.MLP213.persistence;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP213.model.Leave;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * The DAO class for Leave.
 */
public interface LeaveDAO  {
    /**
   * return all the details of all the employee leave details.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveMapper.class)
  List<Leave> list();
  /**
   * return all the leave details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveMapper.class)
  List<Leave> find(@Bind("empID") int empID);
  /**
   * return all the leave details of the selected employee in particular range.
   * @param empID the id of the employee.
   * @param r1 the starting range.
   * @param r2 the ending range.
   * @return the Leave object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID AND APPLIED_ON >= :r1 AND APPLIED_ON <= :r2")
  @Mapper(LeaveMapper.class)
  List<Leave> rfind(@Bind("empID") int empID, @Bind("r1")Date r1, @Bind("r2")Date r2);
  /**
   * return all the leave details of the selected Leave Id.
   * @param lID the id of the Leave
   * @return the Leave object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :lID")
  @Mapper(LeaveMapper.class)
  Leave find1(@Bind("lID") int lID);
  /**
   * return all the status of the employee leaves for manager.
   * @param eId for manager Id.
   * @param lStat the leave status
   * @return the Leave  object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS JOIN EMPLOYEE ON LEAVE_DETAILS.EMP_ID ="
      + " EMPLOYEE.EMP_ID WHERE EMPLOYEE.MANAGER_ID = :eId AND LEAVE_DETAILS.LEAVE_STATUS = :lStat")
  @Mapper(LeaveMapper.class)
  List<Leave> findPend(@Bind("eId") int eId, @Bind("lStat") String lStat);
  /**
   * update for approve deny method.
   * @param lstat the leave status.
   * @param mcomm the manager comment.
   * @param leaveid the leave id.
   */
  @SqlUpdate("update LEAVE_DETAILS set LEAVE_STATUS = :lstatus, MANAGER_COMMENT = :mcom"
           + " where LEAVE_ID = :lid")
  void approveLeave(@Bind("lstatus")String lstat, @Bind("mcom")String mcomm,
          @Bind("lid")int leaveid);

/**
   * update for modify leave method.
   * @param noofdays the days.
   * @param sdate the start date.
   * @param edate the end date.
   * @param ltype the leave type.
   * @param lreason the leave reason.
   * @param apdate the application date.
   * @param leaveid the leave id.
   */
  @SqlUpdate("update LEAVE_DETAILS set NO_OF_DAYS = :days, START_DATE = :sdate, END_DATE = :edate,"
           + "LEAVE_TYPE = :ltype, LEAVE_REASON = :lreason,"
           + " APPLIED_ON = :apdate where LEAVE_ID = :lid")
  void changeLeave(@Bind("days")int noofdays, @Bind("sdate")Date sdate, @Bind("edate")Date edate,
          @Bind("ltype")String ltype,  @Bind("lreason")String lreason, @Bind("apdate")Date apdate,
          @Bind("lid")int leaveid);

 /**
   * to save the employee leave details of the apply leave method.
   * @param empid the id of the employee.
   * @param noofdays the days.
   * @param sdate the start date.
   * @param edate the end date.
   * @param ltype the leave type.
   * @param lreason the leave reason.
   * @param apdate the application date.
   * @return leave.
   */
  @SqlUpdate("insert into LEAVE_DETAILS(EMP_ID,NO_OF_DAYS,START_DATE,END_DATE,LEAVE_TYPE,LEAVE_REASON,APPLIED_ON)"
           + " values(:eid,:days,:sdate,:edate,:ltype,:lreason,:apdate)")
  @GetGeneratedKeys
  int createLeave(@Bind("eid")int empid, @Bind("days")int noofdays, @Bind("sdate")Date sdate,
          @Bind("edate")Date edate, @Bind("ltype")String ltype, @Bind("lreason")String lreason,
          @Bind("apdate")Date apdate);
/**
   * to save the manager leave details of the apply leave method.
   * @param empid the id of the employee.
   * @param noofdays the days.
   * @param sdate the start date.
   * @param edate the end date.
   * @param ltype the leave type.
   * @param lstat the leave status
   * @param lreason the leave reason.
   * @param apdate the application date.
   * @return leave.
   */
  @SqlUpdate("insert into LEAVE_DETAILS(EMP_ID,NO_OF_DAYS,START_DATE,END_DATE,LEAVE_TYPE,LEAVE_STATUS,"
      + "LEAVE_REASON,APPLIED_ON) values(:eid,:days,:sdate,:edate,:ltype,:lstat,:lreason,:apdate)")
  @GetGeneratedKeys
  int createLeave1(@Bind("eid")int empid, @Bind("days")int noofdays, @Bind("sdate")Date sdate,
          @Bind("edate")Date edate, @Bind("ltype")String ltype, @Bind("lstat")String lstat,
           @Bind("lreason")String lreason,
          @Bind("apdate")Date apdate);
  /**
  * close with no args is used to close the connection.
  */
  void close();
  /**
   *
   * @param i empId
   * @param sd1 start date
   * @param ed1 end date
   * @return count1
   */
  int count1(int i, Date sd1, Date ed1);
}

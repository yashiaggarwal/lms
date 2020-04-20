package com.hexaware.MLP213.persistence;

import com.hexaware.MLP213.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();
  /**
   * decrements the Earned Leave balance.
   * @param noOfDays the available leave balance.
   * @param eid the employee id.
   */
  @SqlUpdate("update EMPLOYEE set EARNED_LEAVE_BALANCE = EARNED_LEAVE_BALANCE - :nod where EMP_ID = :eid")
  void changeEBal(@Bind("nod")int noOfDays, @Bind("eid")int eid);
  /**
   * decrement the Maternity Leave balance.
   * @param noOfDays the available leave balance.
   * @param eid the employee id.
   */
  @SqlUpdate("update EMPLOYEE set MATERNITY_LEAVE_BALANCE = MATERNITY_LEAVE_BALANCE - :nod where EMP_ID = :eid")
  void changeMBal(@Bind("nod")int noOfDays, @Bind("eid")int eid);
  /**
   * decerements the Sick Leave balance.
   * @param noOfDays the available leave balance.
   * @param eid the employee id.
   */
  @SqlUpdate("update EMPLOYEE set SICK_LEAVE_BALANCE = SICK_LEAVE_BALANCE - :nod where EMP_ID = :eid")
  void changeSlBal(@Bind("nod")int noOfDays, @Bind("eid")int eid);

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
  * close with no args is used to close the connection.
  */
  void close();
  /**
   *
   * @param empId empId
   * @param sd start date
   * @param ed end date
   * @return empId, sd, ed
   */
  int count1(int empId, Date sd, Date ed);
}

package com.hexaware.MLP213.model;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.hexaware.MLP213.persistence.DbConnection;
import com.hexaware.MLP213.persistence.EmployeeDAO;
/**
 * Employee class to save employee personal details.
 * @author hexaware
 */
public class Employee {
  /**
   * empId to save employee id.
   */
  private int empId;
  /**
   * name to save employee name.
   */
  private String name;
  /**
   * gender to save gender of employee.
   */
  private String gender;
  /**
   * emailId to save email id.
   */
  private String emailId;
  /**
   * phoneNumber to save phone number.
   */
  private int phoneNumber;
  /**
   * joiningDate to save joining date.
   */
  private Date joiningDate;
  /**
   * department to save department name.
   */
  private String department;
  /**
   * earned leave Balance to save available earned leave Balanceance.
   */
  private int earnedLeaveBalance;
  /**
   * maternity leave Balance to save available maternity leave .
   */
  private  int maternityLeaveBalance;
  /**
   * sick leave Balance to save available sick leave Balanceance.
   */
  private  int sickLeaveBalance;
  /**
   * managerId to save manager id.
   */
  private int managerId;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(name, emp.name)
            && Objects.equals(gender, emp.gender)
        && Objects.equals(emailId, emp.emailId) && Objects.equals(phoneNumber, emp.phoneNumber)
        && Objects.equals(joiningDate, emp.joiningDate) && Objects.equals(department, emp.department)
        && Objects.equals(earnedLeaveBalance, emp.earnedLeaveBalance) && Objects.equals(maternityLeaveBalance, emp.maternityLeaveBalance) && Objects.equals(sickLeaveBalance, emp.sickLeaveBalance)
        && Objects.equals(managerId, emp.managerId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(empId, name, gender, emailId, phoneNumber, joiningDate,
         department, earnedLeaveBalance, maternityLeaveBalance, sickLeaveBalance, managerId);
  }

/**
   * empty constructor.
   */
  public Employee() {
  }

/**
   * @param argEmpId to initialize employee id.
   * @param argName to name.
   * @param argGender to gender.
   * @param argEmailId to emailId.
   * @param argPhoneNumber to phnno.
   * @param argJoiningDate to doj.
   * @param argDepartment to dept.
   * @param argEarnedLeaveBalance to earned leave Balance.
   * @param argMaternityLeaveBalance to maternity leave Balance.
   * @param argSickLeaveBalance to sick leave Balance.
   * @param argManagerId to manager id.
    */
  public Employee(final int argEmpId,
                       final String argName,
                       final String argGender,
                        final String argEmailId,
                         final int argPhoneNumber,
       final Date argJoiningDate,
       final String argDepartment,
       final int argEarnedLeaveBalance,
       final int argMaternityLeaveBalance,
       final int argSickLeaveBalance,
       final int argManagerId) {
    this.empId = argEmpId;
    this.name = argName;
    this.gender = argGender;
    this.emailId = argEmailId;
    this.phoneNumber = argPhoneNumber;
    this.joiningDate = argJoiningDate;
    this.department = argDepartment;
    this.earnedLeaveBalance = argEarnedLeaveBalance;
    this.maternityLeaveBalance = argMaternityLeaveBalance;
    this.sickLeaveBalance = argSickLeaveBalance;
    this.managerId = argManagerId;
  }

 /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

/**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

/**
   * Gets the name.
   *
   * @return this name.
   */
  public final String getName() {
    return name;
  }

/**
   *
   * @param argName to set name.
   */
  public final void setName(final String argName) {
    this.name = argName;
  }

/**
   * Gets the gender.
   * @return this gender.
   */
  public final String getGender() {
    return gender;
  }

/**
   *
   * @param argGender to set gender.
   */
  public final void setGender(final String argGender) {
    this.gender = argGender;
  }
  /**
    *
    *@return emailId
    */
  public final String getEmailId() {
    return emailId;
  }

/**
   *
   * @param argEmailId to set emailId.
   */
  public final void setEmailId(final String argEmailId) {
    this.emailId = argEmailId;
  }

/**
   * Gets the phoneNumber.
   *
   * @return this phoneNumber.
   */
  public final int getPhoneNumber() {
    return phoneNumber;
  }

/**
   *
   * @param argPhoneNumber to set phoneNumber.
   */
  public final void setPhoneNumber(final int argPhoneNumber) {
    this.phoneNumber = argPhoneNumber;
  }

/**
   * Gets the joiningDate.
   *
   * @return this joiningDate.
   */
  public final Date getJoiningDate() {
    return joiningDate;
  }

/**
   *
   * @param argJoiningDate to set joiningdate.
   */
  public final void setJoiningDate(final Date argJoiningDate) {
    this.joiningDate = argJoiningDate;
  }

/**
   * Gets the department.
   *
   * @return this department.
   */
  public final String getDepartment() {
    return department;
  }

/**
   *
   * @param argDepartment to set department.
   */
  public final void setDepartment(final String argDepartment) {
    this.department = argDepartment;
  }

/**
   * Gets the Earned Leave Balanceance.
   *
   * @return this Eearned Leave Balanceance.
   */
  public final int getEarnedLeaveBalance() {
    return earnedLeaveBalance;
  }

/**
   *
   * @param argEarnedLeaveBalance to set Earned Leave Balanceance.
   */
  public final void setEarnedLeaveBalance(final int argEarnedLeaveBalance) {
    this.earnedLeaveBalance = argEarnedLeaveBalance;
  }

/**
   * Gets the Maternity Leave Balanceance.
   *
   * @return this Maternity Leave Balanceance.
   */
  public final int getMaternityLeaveBalance() {
    return maternityLeaveBalance;
  }

/**
   *
   * @param argMaternityLeaveBalance to set Maternity Leave Balanceance.
   */
  public final void setMaternityLeaveBalance(final int argMaternityLeaveBalance) {
    this.maternityLeaveBalance = argMaternityLeaveBalance;
  }

/**
   * Gets the Sick Leave Balanceance.
   *
   * @return this Sick Leave Balanceance.
   */
  public final int getSickLeaveBalance() {
    return sickLeaveBalance;
  }

/**
   *
   * @param argSickLeaveBalance to set Sick Leave Balanceance.
   */
  public final void setSickLeaveBalance(final int argSickLeaveBalance) {
    this.sickLeaveBalance = argSickLeaveBalance;
  }

/**
   * Gets the managerId.
   * @return this managerId.
   */
  public final int getManagerId() {
    return managerId;
  }

/**
   *
   * @param argManagerId to set managerId.
   */
  public final void setManagerId(final int argManagerId) {
    this.managerId = argManagerId;
  }

/**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

/**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

/**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

/**
   * The validate employee in the employee table.
   * @param eId emp id.
   * @return integer to check employee is there or not.
   */
  public static int validateEid(final int eId) {
    Employee emp = Employee.listById(eId);
    if (emp == null) {
      return 0;
    } else {
      return 1;
    }
  }

/**
   * @return  for employee.
   */
  public final String toString() {
    return empId + "\t" + name + "      \t" + gender + "   \t" + emailId
      + "  \t" + phoneNumber + " \t" + joiningDate + " \t" + department + "\t"
      + earnedLeaveBalance + "\t" + maternityLeaveBalance + "\t" + sickLeaveBalance + "\t" + managerId;
  }
}

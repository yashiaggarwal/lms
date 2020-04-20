package com.hexaware.MLP213.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.hexaware.MLP213.persistence.DbConnection;
import com.hexaware.MLP213.persistence.EmployeeDAO;
import com.hexaware.MLP213.persistence.LeaveDAO;
/**
 * Leave class to store employee leave details.
 *
 * @author hexaware
 */
public class Leave {
  /**
   * leaveId to store leave id.
   */
  private int leaveId;
   /**
   * empId to store employee id.
   */
  private int empId;
   /**
   * noOfDays to store leave duration.
   */
  private int noOfDays;
   /**
   * startDate to store leave start date.
   */
  private Date startDate;
   /**
   * endDate to store leave end date.
   */
  private Date endDate;
   /**
   * leaveType to store leave type.
   */
  private String leaveType;
   /**
   * leaveStatus to store leave Status.
   */
  private String leaveStatus;
   /**
   * leaveReason to store leave reason.
   */
  private String leaveReason;
   /**
   * appliedOn to store leave application date.
   */
  private Date appliedOn;
   /**
   * managerComment to store manager comment.
   */
  private String managerComment;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Leave lmp = (Leave) obj;
    if (Objects.equals(leaveId, lmp.leaveId) && Objects.equals(empId, lmp.empId)
        && Objects.equals(noOfDays, lmp.noOfDays) && Objects.equals(startDate, lmp.startDate)
        && Objects.equals(endDate, lmp.endDate) && Objects.equals(leaveType, lmp.leaveType)
        && Objects.equals(leaveStatus, lmp.leaveStatus) && Objects.equals(leaveReason, lmp.leaveReason)
        && Objects.equals(appliedOn, lmp.appliedOn) && Objects.equals(managerComment, lmp.managerComment)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, empId, noOfDays, startDate, endDate, leaveType, leaveStatus, leaveReason,
               appliedOn, managerComment);
  }

  /**
   * Empty constructor.
   */
  public Leave() {

  }
/**
   * constructer for Leave class.
   * @param argLeaveId to leave id.
   * @param argEmpId to set employee id.
   * @param argNoOfDays to noofdays.
   * @param argStartDate to set start date.
   * @param argEndDate to set end date.
   * @param argLeaveType to set leave type.
   * @param argLeavestatus for leave status.
   * @param argLeaveReason to set leave reason.
   * @param argAppliedOn to set leave reason.
   * @param argManagercomment to mcom.
   */
  public Leave(
                final int argLeaveId,
                final int argEmpId,
                final int argNoOfDays,
                final Date argStartDate,
                final Date argEndDate,
                final String argLeaveType,
                final String argLeavestatus,
                final String argLeaveReason,
                final Date argAppliedOn,
                final String argManagercomment)     {
    this.leaveId = argLeaveId;
    this.empId = argEmpId;
    this.noOfDays = argNoOfDays;
    this.startDate = argStartDate;
    this.endDate = argEndDate;
    this.leaveType = argLeaveType;
    this.leaveStatus = argLeavestatus;
    this.leaveReason = argLeaveReason;
    this.appliedOn = argAppliedOn;
    this.managerComment = argManagercomment;

  }
/**
   * Gets the leaveId.
   * @return this leaveId.
   */
  public final int getLeaveId() {
    return leaveId;
  }
 /**
   *
   * @param argLeaveId to set leaveId.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
/**
   * Gets the empId.
   * @return this empId.
   */
  public final int getEmpId() {
    return empId;
  }
 /**
   *
   * @param argEmpId to set empId.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
/**
   * Gets the noOfDays.
   * @return this noOfDays.
   */
  public final int getNoOfDays() {
    return noOfDays;
  }
/**
   *
   * @param argNoOfDays to set noOfDays.
   */
  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }
/**
   * Gets the startDate.
   * @return this startDate.
   */
  public final Date getStartDate() {
    return startDate;
  }
/**
   *
   * @param argStartDate to set startDate.
   */
  public final void setStartDate(final Date argStartDate) {
    this.startDate = argStartDate;
  }
/**
   * Gets the endDate.
   * @return this endDate.
   */
  public final Date getEndDate() {
    return endDate;
  }
/**
   *
   * @param argEndDate to set endDate.
   */
  public final void setEndDate(final Date argEndDate) {
    this.endDate = argEndDate;
  }
/**
   * Gets the leaveType.
   * @return this leaveType.
   */
  public final String getLeaveType() {
    return leaveType;
  }
/**
   *
   * @param argLeaveType to set leaveType.
   */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = argLeaveType;
  }
/**
   * Gets the leaveStatus.
   * @return this leaveStatus.
   */
  public final String getLeaveStatus() {
    return leaveStatus;
  }
/**
   *
   * @param argLeaveStatus to set leaveStatus.
   */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
/**
   * Gets the leaveReason.
   * @return this leaveReason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
/**
   *
   * @param argLeaveReason to set leaveReason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }
/**
   * Gets the appliedOn.
   * @return this appliedOn.
   */
  public final Date getAppliedOn() {
    return appliedOn;
  }
/**
   *
   * @param argAppliedOn to set appliedOn.
   */
  public final void setAppliedOn(final Date argAppliedOn) {
    this.appliedOn = argAppliedOn;
  }
/**
   * Gets the managerComment.
   * @return this managerComment.
   */
  public final String getManagerComment() {
    return managerComment;
  }
/**
   *
   * @param argManagerComment to set managerComment.
   */
  public final void setManagerComment(final String argManagerComment) {
    this.managerComment = argManagerComment;
  }
  /**
   * The dao for Leave.
   */
  private static LeaveDAO ldao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDAO.class);
  }
  /**
   * list all leave details from leave table.
   * @return all employee's leave details.
   */
  public static Leave[] listAll() {

    List<Leave> leave = ldao().list();
    return leave.toArray(new Leave[leave.size()]);
  }

  /**
   * list employee leave  details by employee id.
   * @param empID id to get employee leave details.
   * @return Leave
   */
  public static Leave[] listById(final int empID) {
    final List<Leave> leave = ldao().find(empID);
    return leave.toArray(new Leave[leave.size()]);
  }
  /**
   * list employee details by id in specific range.
   * @param empID id to get employee leave details.
   * @param r1 for starting range.
   * @param r2 for  ending range.
   * @return Leave
   */
  public static Leave[] listByIdr(final int empID, final String r1, final String r2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date date1 = null;
    Date date2 = null;
    try {
      date1 = sdf.parse(r1);
      date2 = sdf.parse(r2);
    } catch (ParseException e) {
      System.out.println("Please Enter Correct Date format");
    }
    final List<Leave> leave = ldao().rfind(empID, date1, date2);
    return leave.toArray(new Leave[leave.size()]);
  }
  /**
   * list employee leave details by leave id.
   * @param leaveID id to get employee leave details.
   * @return Leave
   */
  public static Leave listBylId(final int leaveID) {
    return ldao().find1(leaveID);
  }
  /**
   * list employee leave details by id and status.
   * @param eId for employee id.
   * @param lstat for leave status.
   * @return Leave
   */
  public static Leave[] listByStatus(final int eId, final String lstat) {
    final List<Leave> leave = ldao().findPend(eId, lstat);
    return leave.toArray(new Leave[leave.size()]);
  }
  /**
   * @return  for Leave details.
   */
  public final String toString() {
    return leaveId + "\t" + empId + "      \t" + noOfDays + "   \t" + startDate
      + "  \t" + endDate + " \t" + leaveType + " \t" + leaveStatus + "\t" + leaveReason
      + " \t" + appliedOn + "\t" + managerComment;
  }
   /**
   * NO of overlping Leaves.
   * @param empId id to get employee details.
   * @param sd id to get employee details.
   * @param ed id to get employee details.
   * @return count of no of employee.
   */
  public static int countNo(final int empId, final Date sd, final Date ed) {
    int count1 = dao().count1(empId, sd, ed);
    return count1;
  }

  /**
   * The apply leave method to apply leave.
   * @param empId emp id.
   * @param sDate strat date.
   * @param eDate end Date.
   * @param lType leave type.
   * @param lReason leave reason.
   * @return leave.
   */
  public static String applyLeave(final int empId, final String sDate, final String eDate, final String lType,
      final String lReason) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    int days = 0;
    Date sd = null;
    Date ed = null;
    Date apDate = null;
    String lmstat = "APPROVED";
    try {
      sd = sdf.parse(sDate);
      ed = sdf.parse(eDate);
      Date cd = new Date();
      DateFormat df = DateFormat.getDateInstance();
      Date curDate = df.parse(df.format(cd));
      Calendar start = Calendar.getInstance();
      start.setTime(sd);
      Calendar end = Calendar.getInstance();
      end.setTime(ed);
      int count1 = 0;
      for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
          count1++;
        }
        count1 = count1 + 1;
      }
      Leave[] sv = listById(empId);
      for (Leave s : sv) {
        if (sd.getTime() >= s.getStartDate().getTime() && sd.getTime() <= s.getEndDate().getTime()
                 || ed.getTime() >= s.getStartDate().getTime() && ed.getTime() <= s.getEndDate().getTime()) {
          return "you already applied on this duration.";
        }
      }
      if (sd.getTime() >= curDate.getTime() && ed.getTime() >= sd.getTime()) {
        long difmil = Math.abs(ed.getTime() - sd.getTime());
        long diff = TimeUnit.DAYS.convert(difmil, TimeUnit.MILLISECONDS) + 1;
        int days1 = (int) diff;
        int noOfHolidays = Leave.totalDays(sd, ed);
        days = days1 - noOfHolidays;
        apDate = curDate;
      } else {
        return "enter valid Date";
      }
    } catch (ParseException e) {
      return "Please Enter Correct Date format";
    }
    Employee e = Employee.listById(empId);
    if (e.getManagerId() == 0) {
      if (lType.equalsIgnoreCase("EL")) {
        if (e.getEarnedLeaveBalance() >= days) {
          int id1 = ldao().createLeave1(empId, days, sd, ed, lType, lmstat, lReason, apDate);
          dao().changeEBal(days, empId);
          return "leave applied" + "leave Id is" + id1;
        } else {
          return "check EL balance";
        }
      }
    } else if (lType.equalsIgnoreCase("ML")) {
      if (e.getMaternityLeaveBalance() >= days) {
        int id1 = ldao().createLeave1(empId, days, sd, ed, lType, lmstat, lReason, apDate);
        dao().changeMBal(days, empId);
        return "leave applied" + "leave Id is" + id1;
      } else {
        return "check ML balance";
      }
    } else if (lType.equalsIgnoreCase("SL")) {
      if (e.getSickLeaveBalance() >= days) {
        int id1 = ldao().createLeave1(empId, days, sd, ed, lType, lmstat, lReason, apDate);
        dao().changeSlBal(days, empId);
        return "leave applied" + "leave Id is" + id1;
      } else {
        return "check SL balance";
      }
    } else {
      return "check leave type";
    }
    if (lType.equalsIgnoreCase("EL")) {
      if (e.getEarnedLeaveBalance() >= days) {
        int id = ldao().createLeave(empId, days, sd, ed, lType, lReason, apDate);
        return "leave applied" + "leave Id is" + id;
      } else {
        return "check EL balance";
      }
    } else if (lType.equalsIgnoreCase("ML")) {
      if (e.getMaternityLeaveBalance() >= days) {
        int id = ldao().createLeave(empId, days, sd, ed, lType, lReason, apDate);
        return "leave applied" + "leave Id is" + id;
      } else {
        return "check ML balance";
      }
    } else if (lType.equalsIgnoreCase("SL")) {
      if (e.getSickLeaveBalance() >= days) {
        int id = ldao().createLeave(empId, days, sd, ed, lType, lReason, apDate);
        return "leave applied" + "leave Id is" + id;
      } else {
        return "check SL balance";
      }
    } else {
      return "check leave type";
    }
  }
   /**
   * The modify leave method to modify Leave.
   * Employee can can modify only if leave status is pending.
   * @param empId1 emp id.
   * @param leaveId emp id.
   * @param sDate1 strat date.
   * @param eDate1 end Date.
   * @param lType1 leave type.
   * @param lReason1 leave reason.
   * @return leave.\
   */
  public static String modifyLeave(final int empId1, final int leaveId, final String sDate1,
      final String eDate1, final String lType1, final String lReason1) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    int days = 0;
    Date sd = null;
    Date ed1 = null;
    Date apDate = null;
    try {
      sd = sdf.parse(sDate1);
      ed1 = sdf.parse(eDate1);
      Date cd = new Date();
      DateFormat df = DateFormat.getDateInstance();
      Date curDate = df.parse(df.format(cd));
      if (sd.getTime() >= curDate.getTime() && ed1.getTime() >= sd.getTime()) {
        long difmil = Math.abs(ed1.getTime() - sd.getTime());
        long diff = TimeUnit.DAYS.convert(difmil, TimeUnit.MILLISECONDS) + 1;
        int days1 = (int) diff;
        int  noOfHolidays = Leave.totalDays(sd, ed1);
        days = days1 - noOfHolidays;
        apDate = curDate;
        apDate = curDate;
      } else {
        return "enter valid Date";
      }
    } catch (ParseException e) {
      return "Please Enter Correct Date format";
    }
    Employee e1 = Employee.listById(empId1);
    if (lType1.equalsIgnoreCase("EL")) {
      if (e1.getEarnedLeaveBalance() >= days) {
        ldao().changeLeave(days, sd, ed1, lType1, lReason1, apDate, leaveId);
        return "leave modified";
      } else {
        return "not modified";
      }
    } else if (lType1.equalsIgnoreCase("ML")) {
      if (e1.getMaternityLeaveBalance() >= days) {
        ldao().changeLeave(days, sd, ed1, lType1, lReason1, apDate, leaveId);
        return "leave modified";
      } else {
        return "not modified";
      }
    } else if (lType1.equalsIgnoreCase("SL")) {
      if (e1.getSickLeaveBalance() >= days) {
        ldao().changeLeave(days, sd, ed1, lType1, lReason1, apDate, leaveId);
        return "leave modified";
      } else {
        return "not modified";
      }
    }  else {
      return "check leavetype";
    }
  }
  /**
   * The approve deny method  for manager to apply or deny leaves applied by employee.
   * @param empId emp id.
   * @param leaveId emp id.
   * @param lstat leave status.
   * @param mcom manager comment.
   * @return leave.
   */
  public static String approveLeave(final int empId, final int leaveId,
       final String lstat, final String mcom) {
    Leave l = Leave.listBylId(leaveId);
    int days = l.getNoOfDays();
    ldao().approveLeave(lstat, mcom, leaveId);
    if (lstat.equalsIgnoreCase("APPROVED")) {
      if (l.getLeaveType().equalsIgnoreCase("EL")) {
        dao().changeEBal(days, empId);
      } else if (l.getLeaveType().equalsIgnoreCase("ML")) {
        dao().changeMBal(days, empId);
      } else if (l.getLeaveType().equalsIgnoreCase("SL")) {
        dao().changeSlBal(days, empId);
      }
    } else {
      return "leave not approved";
    }
    return "leave is   " + lstat;
  }
  /**
   * The validating leave Id method to check leave id present or not in Leave details.
   * @param lId leave id.
   * @return leave.
   */
  public static int validatelId(final int lId) {
    Leave l = Leave.listBylId(lId);
    if (l == null) {
      return 0;
    } else {
      return 1;
    }
  }
  /**
   * The validate manager for Leave to check the manager validation for their respective employees.
   * @param lId leave id
   * @param eId manager id.
   * @return leave.
   */
  public static int validateManager(final int lId, final int eId) {
    Leave l = Leave.listBylId(lId);
    int eid = l.getEmpId();
    Employee emp = Employee.listById(eid);
    int mid = emp.getManagerId();
    if (eId == mid) {
      return 1;
    } else {
      return 0;
    }
  }
  /**
   * The find employee method to get the Employee Id.
   * @param lId leave id
   * @return Employee id.
   */
  public static int findEmpId(final int lId) {
    Leave l = Leave.listBylId(lId);
    int eid = l.getEmpId();
    return eid;
  }
  /**
   * The find ELBal method to get EL bal.
   * @param eId employee id
   * @return EL Balance.
   */
  public static int findElBal(final int eId) {
    Employee l = Employee.listById(eId);
    int elbal = l.getEarnedLeaveBalance();
    return elbal;
  }
  /**
   * The find MLBal method to get ML bal.
   * @param eId employee id
   * @return ML Balance.
   */
  public static int findMlBal(final int eId) {
    Employee l = Employee.listById(eId);
    int mlbal = l.getMaternityLeaveBalance();
    return mlbal;
  }
  /**
   * The find SLBal method to get SL bal.
   * @param eId employee id
   * @return Sl Balance.
   */
  public static int findSlBal(final int eId) {
    Employee l = Employee.listById(eId);
    int slbal = l.getSickLeaveBalance();
    return slbal;
  }
  /**
   * The find leave status method to get leave status.
   * @param lId leave id
   * @return leave status.
   */
  public static String findLeaveStat(final int lId) {
    Leave l = Leave.listBylId(lId);
    String stat = l.getLeaveStatus();
    return stat;
  }
/**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  private static int totalDays(final Date sd, final Date ed) {
    Calendar start = Calendar.getInstance();
    start.setTime(sd);
    Calendar end = Calendar.getInstance();
    end.setTime(ed);
    int count = 0;
    if (end.get(Calendar.DAY_OF_WEEK) == 1 || end.get(Calendar.DAY_OF_WEEK) == 7) {
      for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
          return count;
        }
      }
    } else {
      for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
          count++;
        }
      }
      return count;
    }
    return count;
  }
}

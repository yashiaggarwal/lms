package com.hexaware.MLP213.util;

import java.util.Scanner;

import com.hexaware.MLP213.model.Employee;
import com.hexaware.MLP213.model.Leave;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("**********************Welcome To Leave Management System**********************");
    System.out.println("==============================================================================");
    System.out.println("    |1. List All Employees Info                                      |");
    System.out.println("    |2. Display Employee Info                                        |");
    System.out.println("    |3. Apply Leave                                                  |");
    System.out.println("    |4. Modify Leave                                                 |");
    System.out.println("    |5. Leave History                                                |");
    System.out.println("    |6. Approve / Deny Leave                                         |");
    System.out.println("    |7. Pending Leaves                                               |");
    System.out.println("    |8.-->Exit<--                                                    |");
    System.out.println("===============================================================================");
    System.out.println("\n=====================Kindly enter what service you want:=======================");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        displayEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        modifyLeave();
        break;
      case 5:
        leaveHistory();
        break;
      case 6:
        approveDenyLeave();
        break;
      case 7:
        pendingLeaves();
        break;
      case 8:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        System.out.println("============You are exiting from the Leave Management System============");
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("\n============ Service you entered is not available============");
        System.out.println("\n============Kindly read the available services and enter again: )"
            + "============");
        System.out.println("Choose again");
    }
    mainMenu();
  }
  private void listEmployeesDetails() {
    System.out.println("\n============You selected the listing employee service============");
    Employee[] employee = Employee.listAll();
    System.out.println("========================================================================"
        + "========================================================================");
    for (Employee e : employee) {
      System.out.println(e);
    }
    System.out.println("========================================================================"
        + "========================================================================");
  }
  private void displayEmployeeDetail() {
    System.out.println("\n============You selected the employee search service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("========================================================================");
      System.out.println("Sorry, No such employee");
      System.out.println("========================================================================");

    } else {
      System.out.println("========================================================================"
            + "========================================================================");
      System.out.println(employee);
      System.out.println("========================================================================"
          + "========================================================================");

    }
  }
  private void applyLeave() {
    System.out.println("\n============You selected the apply leave service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter Employee ID:");
    int empId = option.nextInt();
    int e = Employee.validateEid(empId);
    if (e == 0) {
      System.out.println("========================================================================");
      System.out.println("Sorry, No such employee");
      System.out.println("========================================================================");

    } else {
      System.out.println("========================================================================"
             + "========================================================================");
      int elbal = Leave.findElBal(empId);
      int mlbal = Leave.findMlBal(empId);
      int slbal = Leave.findSlBal(empId);
      System.out.println("your leave balance is------------->" + "\nELBAL " + elbal
               + "\nMLBAL " + mlbal
               + "\nSLBAL " + slbal);
      System.out.println("========================================================================"
              + "========================================================================");
      System.out.println("Enter start date:");
      String startDate = option.next();
      System.out.println("Enter end date:");
      String endDate = option.next();
      System.out.println("Enter leave type--->(EL,ML,SL)<---:");
      String leaveType = option.next();
      if (leaveType.equalsIgnoreCase("EL") || leaveType.equalsIgnoreCase("ML")
                              || leaveType.equalsIgnoreCase("SL")) {
        System.out.println("Enter leave reason:");
        option.nextLine();
        String leaveReason = option.nextLine();
        String result = Leave.applyLeave(empId, startDate, endDate, leaveType, leaveReason);
        System.out.println("========================================================================"
              + "========================================================================");
        System.out.println(result);
        System.out.println("========================================================================"
              + "========================================================================");
      } else {
        System.out.println("========================================================================"
            + "========================================================================");
        System.out.println("Please enter the correct leave type.");
        System.out.println("========================================================================"
            + "========================================================================");
      }
    }
  }
  private void modifyLeave() {
    System.out.println("\n============You selected the modify leave service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter employee ID:");
    int eId = option.nextInt();
    int e1 = Employee.validateEid(eId);
    if (e1 == 0) {
      System.out.println("========================================================================");
      System.out.println("Sorry, No such employee");
      System.out.println("========================================================================");
    } else {
      System.out.println("Enter Leave ID:");
      int lId = option.nextInt();
      System.out.println("Enter start date:");
      String startDate = option.next();
      System.out.println("Enter end date:");
      String endDate = option.next();
      System.out.println("Enter leave type--->(EL,ML,SL)<---:");
      String leaveType = option.next();
      if (leaveType.equalsIgnoreCase("EL") || leaveType.equalsIgnoreCase("ML")
                         || leaveType.equalsIgnoreCase("SL")) {
        System.out.println("Enter leave reason:");
        option.nextLine();
        String leaveReason = option.nextLine();
        String stat = Leave.findLeaveStat(lId);
        if (stat.equalsIgnoreCase("PENDING")) {
          String result = Leave.modifyLeave(eId, lId, startDate, endDate, leaveType, leaveReason);
          System.out.println("========================================================================"
                  + "========================================================================");
          System.out.println(result);
          System.out.println("========================================================================"
                  + "========================================================================");
        } else {
          System.out.println("========================================================================"
                  + "========================================================================");
          System.out.println("You cannot modify leave.");
          System.out.println("========================================================================"
                  + "========================================================================");
        }
      } else {
        System.out.println("========================================================================"
                  + "========================================================================");
        System.out.println("Enter correct leave type");
        System.out.println("========================================================================"
                  + "========================================================================");

      }
    }
  }
  private void leaveHistory() {
    System.out.println("\n============You selected the leave history service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    int e2 = Employee.validateEid(empId);
    if (e2 == 0) {
      System.out.println("========================================================================");
      System.out.println("Sorry, No such employee");
      System.out.println("========================================================================");

    } else {
      System.out.println("enter range1");
      String r1 = option.next();
      System.out.println("enter range2");
      String r2 = option.next();
      Leave[] l = Leave.listByIdr(empId, r1, r2);
      if (l.length == 0) {
        System.out.println("========================================================================"
              + "========================================================================");
        System.out.println("No leave history for   " + empId);
        System.out.println("========================================================================"
              + "========================================================================");
      } else {
        System.out.println("========================================================================"
              + "========================================================================");
        for (Leave i : l) {
          System.out.println(i);
        }
        System.out.println("========================================================================"
              + "========================================================================");
      }

    }
  }
  private void approveDenyLeave() {
    System.out.println("\n============You selected the approve (or) Deny service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter an employee Id");
    int eId = option.nextInt();
    System.out.println("Enter an leave status");
    String lStat = option.next();
    Leave[] l = Leave.listByStatus(eId, lStat);
    if (l.length == 0) {
      System.out.println("========================================================================"
              + "========================================================================");
      System.out.println("No pending leaves available");
      System.out.println("========================================================================"
              + "========================================================================");
    } else {
      System.out.println("========================================================================"
              + "========================================================================");
      for (Leave i : l) {
        System.out.println(i);
      }
      System.out.println("========================================================================"
              + "========================================================================");
      System.out.println("Enter Leave ID:");
      int lId = option.nextInt();
      int lv = Leave.validatelId(lId);
      if (lv == 0) {
        System.out.println("========================================================================"
              + "========================================================================");
        System.out.println("No leave id available");
        System.out.println("========================================================================"
              + "========================================================================");
      } else {
        int m = Leave.validateManager(lId, eId);
        if (m == 1) {
          System.out.println("Enter leave status--->(APPROVED,REJECTED)<---:");
          option.nextLine();
          String lStat1 = option.nextLine();
          if (lStat1.equalsIgnoreCase("APPROVED") || lStat1.equalsIgnoreCase("REJECTED")) {
            int id = Leave.findEmpId(lId);
            System.out.println("Enter manager comment:");
              // option.nextLine();
            String mCom = option.nextLine();
            String result = Leave.approveLeave(id, lId, lStat1, mCom);
            System.out.println("========================================================================"
                  + "========================================================================");
            System.out.println(result);
            System.out.println("========================================================================"
                  + "========================================================================");
          } else {
            System.out.println("========================================================================"
                  + "========================================================================");
            System.out.println("Please enter correct leave status");
            System.out.println("========================================================================"
                  + "========================================================================");
          }
        } else {
          System.out.println("========================================================================"
                + "========================================================================");
          System.out.println("You are not the manager of this employee who applied leave " + lId);
          System.out.println("========================================================================"
                + "========================================================================");
        }
      }
    }
  }

  private void pendingLeaves() {
    System.out.println("\n============You selected the pending leaves service============");
    System.out.println("\n============Kindly enter the following details============");
    System.out.println("Enter an employee Id");
    int eId1 = option.nextInt();
    int et = Employee.validateEid(eId1);
    if (et == 0) {
      System.out.println("========================================================================"
                + "========================================================================");
      System.out.println("Sorry no such employee");
      System.out.println("========================================================================"
                + "========================================================================");
    } else {
      System.out.println("Enter an leave status");
      String lStat1 = option.next();
      Leave[] l1 = Leave.listByStatus(eId1, lStat1);
      if (l1.length == 0) {
        System.out.println("========================================================================"
              + "========================================================================");
        System.out.println("No pending leaves available");
        System.out.println("========================================================================"
              + "========================================================================");
      } else {
        System.out.println("========================================================================"
              + "========================================================================");
        for (Leave i : l1) {
          System.out.println(i);
        }
        System.out.println("========================================================================"
              + "========================================================================");
      }
    }

  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();

  }
}

package com.hexaware.MLP213.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Calendar;

import com.hexaware.MLP213.persistence.EmployeeDAO;
import com.hexaware.MLP213.persistence.LeaveDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Leave.
 */
@RunWith(JMockit.class)
public class LeaveTest {

  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for date
   */
  @Test
  public final void testLeave() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sd = sdf.parse("2020-06-12");
    Date ed = sdf.parse("2020-06-13");
    //Date ad = sdf.parse("2020-06-12");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate = df.parse(df.format(today));
    Leave l1 = new Leave(1, 1000, 1, sd, ed, "EL", "PENDING", "vacation", apDate, "enjoy");
    Leave l2 = new Leave();
    // checking constructor is not null.
    assertNotNull(l1);
    assertEquals(l2, new Leave());
    assertNotEquals(l1, null);
    assertNotEquals(l1, new Integer(1));
    assertEquals(l1.hashCode(), new Leave(1, 1000, 1, sd, ed, "EL", "PENDING", "vacation", apDate, "enjoy").hashCode());
    assertEquals(1, l1.getLeaveId());
    assertNotEquals(10001, l1.getLeaveId());
    assertEquals(l1, new Leave(1, 1000, 1, sd, ed, "EL", "PENDING", "vacation", apDate, "enjoy"));
    // checking getters&setters of leave id.
    l1.setLeaveId(1);
    assertEquals(1, l1.getLeaveId());
    assertNotEquals(10001, l1.getLeaveId());
    // checking getters&setters of empId.
    l1.setEmpId(10001);
    assertEquals(10001, l1.getEmpId());
    assertNotEquals(1000, l1.getEmpId());
    // checking getters&setters of noofdays.
    l1.setNoOfDays(10001);
    assertEquals(10001, l1.getNoOfDays());
    assertNotEquals(1000, l1.getNoOfDays());
    // checking getters&setters of start date.
    l1.setStartDate(sd);
    assertEquals(sd, l1.getStartDate());
    assertNotEquals(ed, l1.getStartDate());
    // checking getters&setters of end date.
    l1.setEndDate(ed);
    assertEquals(ed, l1.getEndDate());
    assertNotEquals(sd, l1.getEndDate());
    // checking getters&setters of leave type.
    l1.setLeaveType("EL");
    assertEquals("EL", l1.getLeaveType());
    assertNotEquals("ML", l1.getLeaveType());
    assertNotEquals("SL", l1.getLeaveType());
    l1.setLeaveType("ML");
    assertEquals("ML", l1.getLeaveType());
    assertNotEquals("SL", l1.getLeaveType());
    assertNotEquals("EL", l1.getLeaveType());
    l1.setLeaveType("SL");
    assertEquals("SL", l1.getLeaveType());
    assertNotEquals("ML", l1.getLeaveType());
    assertNotEquals("EL", l1.getLeaveType());
    // checking getters&setters of leave status.
    l1.setLeaveStatus("PENDING");
    assertEquals("PENDING", l1.getLeaveStatus());
    assertNotEquals("REJECT", l1.getLeaveStatus());
    assertNotEquals("APPROVED", l1.getLeaveStatus());
    l1.setLeaveStatus("REJECT");
    assertEquals("REJECT", l1.getLeaveStatus());
    assertNotEquals("PENDING", l1.getLeaveStatus());
    assertNotEquals("APPROVED", l1.getLeaveStatus());
    l1.setLeaveStatus("APPROVED");
    assertEquals("APPROVED", l1.getLeaveStatus());
    assertNotEquals("REJECT", l1.getLeaveStatus());
    assertNotEquals("PENDING", l1.getLeaveStatus());
    // checking getters&setters of leave Reason.
    l1.setLeaveReason("vacation");
    assertEquals("vacation", l1.getLeaveReason());
    assertNotEquals("fever", l1.getLeaveReason());
    // checking getters&setters of applied date.
    l1.setAppliedOn(apDate);
    assertEquals(apDate, l1.getAppliedOn());
    assertNotEquals(ed, l1.getAppliedOn());
    // checking getters&setters of manager comment.
    l1.setManagerComment("enjoy vacation");
    assertEquals("enjoy vacation", l1.getManagerComment());
    assertNotEquals("come to office", l1.getManagerComment());
  }

  /**
   * tests that empty Levae list is handled correctly.
   * @param ldao mocking the ldao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDAO ldao) {
    new Expectations() {
      {
        ldao.list();
        result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls = Leave.listAll();
    assertEquals(0, ls.length);
    assertNotEquals(1, ls.length);
  }

  /**
   * Tests that a list with some Leave details is handled correctly.
   * @param ldao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListAllSome(@Mocked final LeaveDAO ldao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sd1 = sdf.parse("2020-06-13");
    Date ed1 = sdf.parse("2020-06-16");
    //Date ad1 = sdf.parse("2020-06-13");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sd1 = sdf.parse("2020-06-13");
        Date ed1 = sdf.parse("2020-06-16");
        //Date ad1 = sdf.parse("2020-06-13");
        final DateFormat df = DateFormat.getDateInstance();
        final Date today = new Date();
        //final Date apDate = sf.parse(today);
        final Date apDate1 = df.parse(df.format(today));
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(1, 1000, 2, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls.add(new Leave(2, 2000, 2, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.list();
        result = ls;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls = Leave.listAll();
    assertEquals(2, ls.length);
    assertNotEquals(3, ls.length);
    assertNotEquals(0, ls.length);
    assertNotEquals(ls[0], new Leave(2, 2000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
    assertEquals(ls[1], new Leave(2, 2000, 2, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
    assertEquals(ls[0], new Leave(1, 1000, 2, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
    assertNotEquals(ls[1], new Leave(1, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param ldao mocking the dao class
   * @throws ParseException for date parsing.
   */
  @Test
  public final void testListBylId(@Mocked final LeaveDAO ldao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sd2 = sdf.parse("2020-06-13");
    Date ed2 = sdf.parse("2020-06-16");
    //Date ad2 = sdf.parse("2020-06-13");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate2 = df.parse(df.format(today));
    final Leave l1000 = new Leave(1, 1000, 4, sd2, ed2, "EL", "PENDING", "vacation", apDate2, "enjoy");
    new Expectations() {
      {
        ldao.find1(1);
        result = l1000;
        ldao.find1(100);
        result = null;
        ldao.find1(-1);
        result = null;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave l = Leave.listBylId(1);
    Leave l1 = Leave.listBylId(100);
    assertEquals(l1000, l);
    assertNotEquals(l1000, l1);

    l = Leave.listBylId(-1);
    assertNull(l);
  }

  /**
   * Tests the to string methods of the employee class.
   * @throws ParseException for date parse errors.
   */
  @Test
  public final void testToString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sd3 = sdf.parse("2020-06-10");
    Date ed3 = sdf.parse("2020-06-13");
    //Date ad3 = sdf.parse("2020-06-13");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate3 = df.parse(df.format(today));
    Leave ls1 = new Leave(1, 1000, 4, sd3, ed3, "EL", "PENDING", "vacation", apDate3, "enjoy");
    String result = "1" + "\t" + "1000" + "      \t" + "4" + "   \t" + sd3 + "  \t" + ed3 + " \t" + "EL" + " \t"
        + "PENDING" + "\t" + "vacation" + " \t" + apDate3 + "\t" + "enjoy";
    assertEquals(ls1.toString(), result);
  }

  /**
   * tests that empty Levae list for particular id is handled correctly.
   * @param ldao mocking the dao class
   */
  @Test
  public final void testListByIdEmpty(@Mocked final LeaveDAO ldao) {
    new Expectations() {
      {
        ldao.find(1000);
        result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls1 = Leave.listById(1000);
    assertEquals(0, ls1.length);
    assertNotEquals(1, ls1.length);
  }

  /**
   * Tests that a list with some leave details for particular id is handled correctly.
   * @param ldao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListByIdSome(@Mocked final LeaveDAO ldao) throws ParseException {
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sd1 = sdf.parse("2020-06-13");
        Date ed1 = sdf.parse("2020-06-16");
        //Date ad1 = sdf.parse("2020-06-13");
        final DateFormat df = DateFormat.getDateInstance();
        final Date today = new Date();
        //final Date apDate = sf.parse(today);
        final Date apDate1 = df.parse(df.format(today));
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(1, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls.add(new Leave(2, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.find(1000);
        result = ls;
        ArrayList<Leave> ls1 = new ArrayList<Leave>();
        ls1.add(new Leave(1, 2000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls1.add(new Leave(2, 2000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.find(2000);
        result = ls1;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls = Leave.listById(1000);
    Leave[] ls1 = Leave.listById(2000);
    assertEquals(2, ls.length);
    assertNotEquals(3, ls.length);
    assertNotEquals(0, ls.length);
    assertEquals(2, ls1.length);
    assertNotEquals(3, ls1.length);
    assertNotEquals(0, ls1.length);
  }

  /**
   * testing of the leave history method is empty or not.
   * @param ldao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListByIdrEmpty(@Mocked final LeaveDAO ldao) throws ParseException {
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sdr = sdf.parse("2020-05-10");
        Date edr = sdf.parse("2020-06-15");
        ldao.rfind(1000, sdr, edr);
        result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls1 = Leave.listByIdr(1000, "2020-05-10", "2020-06-15");
    assertEquals(0, ls1.length);
    assertNotEquals(1, ls1.length);
  }

  /**
   * testing the leave history with some values.
   * @param ldao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListByIdrSome(@Mocked final LeaveDAO ldao) throws ParseException {
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sd1 = sdf.parse("2020-06-13");
        Date ed1 = sdf.parse("2020-06-16");
        //Date ad1 = sdf.parse("2020-06-13");
        final DateFormat df = DateFormat.getDateInstance();
        final Date today = new Date();
        //final Date apDate = sf.parse(today);
        final Date apDate1 = df.parse(df.format(today));
        Date sdr = sdf.parse("2020-05-10");
        Date edr = sdf.parse("2020-06-15");
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(1, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls.add(new Leave(2, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.rfind(1000, sdr, edr);
        result = ls;
        ArrayList<Leave> ls1 = new ArrayList<Leave>();
        ls1.add(new Leave(1, 2000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls1.add(new Leave(2, 2000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.rfind(2000, sdr, edr);
        result = ls1;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls1 = Leave.listByIdr(1000, "2020-05-10", "2020-06-15");
    Leave[] ls2 = Leave.listByIdr(2000, "2020-05-10", "2020-06-15");
    assertEquals(2, ls1.length);
    assertNotEquals(1, ls1.length);
    assertEquals(2, ls2.length);
    assertNotEquals(1, ls2.length);
  }

  /**
   * testing the list by status method with empty list.
   * @param ldao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListByStatusEmpty(@Mocked final LeaveDAO ldao) throws ParseException {
    new Expectations() {
      {
        ldao.findPend(1000, "PENDING");
        result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls1 = Leave.listByStatus(1000, "PENDING");
    assertEquals(0, ls1.length);
    assertNotEquals(1, ls1.length);
  }

  /**
   * testing the list by status with some values.
   * @param ldao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testListByStatusSome(@Mocked final LeaveDAO ldao) throws ParseException {
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sd1 = sdf.parse("2020-02-13");
        Date ed1 = sdf.parse("2020-02-16");
        //Date ad1 = sdf.parse("2020-02-13");
        final DateFormat df = DateFormat.getDateInstance();
        final Date today = new Date();
        //final Date apDate = sf.parse(today);
        final Date apDate1 = df.parse(df.format(today));
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(1, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ls.add(new Leave(2, 1000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, "enjoy"));
        ldao.findPend(1000, "PENDING");
        result = ls;
        ArrayList<Leave> ls1 = new ArrayList<Leave>();
        ls1.add(new Leave(3, 2000, 4, sd1, ed1, "EL", "REJECT", "vacation", apDate1, "enjoy"));
        ls1.add(new Leave(4, 2000, 4, sd1, ed1, "EL", "REJECT", "vacation", apDate1, "enjoy"));
        ldao.findPend(2000, "REJECT");
        result = ls1;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave[] ls1 = Leave.listByStatus(1000, "PENDING");
    Leave[] ls2 = Leave.listByStatus(2000, "REJECT");
    assertEquals(2, ls1.length);
    assertNotEquals(0, ls1.length);
    assertEquals(2, ls2.length);
    assertNotEquals(0, ls2.length);
  }

  /**
   * testing apply leave method.
   * @param ldao mocking the dao class
   * @param dao  mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testApplyLeave(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(9000, "ANMOL", "Male", "anmol@gmail.com", 777556098,
          doj, "HEXAVARSITY", 10, 10, 10, 2000);
    final Employee emp1000 = new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
          doj, "HUMAN_RESOURCES", 10, 10, 10, 0);
    final Date sd1 = sf.parse("2020-06-14");
    final Date ed1 = sf.parse("2020-06-16");
    //final Date cd = new Date();
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate = df.parse(df.format(today));
    final Date sd2 = sf.parse("2020-05-14");
    final Date ed2 = sf.parse("2020-05-16");
    final ArrayList<Leave> ls = new ArrayList<Leave>();
    ls.add(new Leave(1, 9000, 2, sd1, ed1, "EL", "PENDING", "vacation", apDate, "enjoy"));
    final ArrayList<Leave> ls1 = new ArrayList<Leave>();
    ls1.add(new Leave(2, 1000, 2, sd1, ed1, "EL", "APPROVED", "vacation", apDate, "enjoy"));
    final ArrayList<Leave> ls2 = new ArrayList<Leave>();
    ls2.add(new Leave(3, 1000, 0, sd2, ed2, "EL", "APPROVED", "vacation", apDate, "enjoy"));

    new Expectations() {
      {
        ldao.count1(9000, sd1, ed1); result = 2;
        ldao.count1(1000, sd1, ed1); result = 2;
        ldao.count1(1000, sd2, ed2); result = 0;
        ldao.find(9000); result = ls;
        dao.find(9000);  result = emp3000;
        ldao.find(1000); result = ls1;
        dao.find(1000); result = emp1000;
        ldao.createLeave(9000, 3, sd1, ed1, "EL", "Fever", apDate);
        ldao.createLeave1(1000, 3, sd1, ed1, "EL", "APPROVED", "Fever", apDate);
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String result1 = Leave.applyLeave(9000, "2020-06-14", "2020-06-16", "EL", "Fever");
    assertEquals("leave appliedleave Id is0", result1);
    String result2 = Leave.applyLeave(1000, "2020-06-14", "2020-06-16", "EL", "Fever");
    assertEquals("leave appliedleave Id is0", result2);
    String result3 = Leave.applyLeave(1000, "2020-06-14", "2020-06-16", "ML", "Fever");
    assertEquals("leave appliedleave Id is0", result3);
    String result4 = Leave.applyLeave(1000, "2020-06-14", "2020-06-16", "SL", "Fever");
    assertEquals("leave appliedleave Id is0", result4);
    String result5 = Leave.applyLeave(1000, "2020-06-14", "2020-06-26", "SL", "Fever");
    assertEquals("check SL balance", result5);
    String result6 = Leave.applyLeave(1000, "2020-06-14", "2020-06-26", "ML", "Fever");
    assertEquals("check ML balance", result6);
    String result7 = Leave.applyLeave(1000, "2020-06-14", "2020-06-26", "EL", "Fever");
    assertEquals("check EL balance", result7);
    String result8 = Leave.applyLeave(9000, "2020-06-14", "2020-06-16", "ML", "Fever");
    assertEquals("leave appliedleave Id is0", result8);
    String result9 = Leave.applyLeave(9000, "2020-06-14", "2020-06-16", "SL", "Fever");
    assertEquals("leave appliedleave Id is0", result9);
    String result10 = Leave.applyLeave(9000, "2020-06-14", "2020-06-26", "SL", "Fever");
    assertEquals("check SL balance", result10);
    String result11 = Leave.applyLeave(9000, "2020-06-14", "2020-06-26", "ML", "Fever");
    assertEquals("check ML balance", result11);
    String result12 = Leave.applyLeave(9000, "2020-06-14", "2020-06-26", "EL", "Fever");
    assertEquals("check EL balance", result12);
    String result13 = Leave.applyLeave(9000, "2020-06-14", "2020-06-16", "AL", "Fever");
    assertEquals("check leave type", result13);
    String result14 = Leave.applyLeave(9000, "2020-06-14", "2020-06-16", "AL", "Fever");
    assertEquals("check leave type", result14);
    String result15 = Leave.applyLeave(1000, "2020-06-14", "2020-06-16", "AL", "Fever");
    assertEquals("you already applied on this duration.", result15);
    String result16 = Leave.applyLeave(1000, "2020-06-13", "2020-06-10", "AL", "Fever");
    assertEquals("enter valid Date", result16);
    String result17 = Leave.applyLeave(1000, "2020/06/14", "2020/06/16", "AL", "Fever");
    assertEquals("Please Enter Correct Date format", result17);
  }
  /**
   * testing modify leave method.
   * @param ldao mocking the ldao class
   * @param dao mocking dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testModifyLeave(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO dao)
                   throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(3000, "YASHI", "Female", "yashi@gmail.com", 701456855,
          doj, "HEXAVARSITY", 10, 10, 10, 2001);
    final Date sd1 = sf.parse("2040-06-14");
    final Date ed1 = sf.parse("2040-06-16");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate = df.parse(df.format(today));
    //final Date cd = new Date();
    //final DateFormat df = DateFormat.getDateInstance();
    //final  Date ad1 = df.parse(df.format(cd));
    new Expectations() {
      {
        dao.find(3000);  result = emp3000;
        ldao.changeLeave(3, sd1, ed1, "EL", "fever", apDate, 1);
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    //Employee employee2 = Employee.listById(3000);
    String m1 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-16", "EL", "fever");
    assertEquals("leave modified", m1);
    String m2 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-16", "ML", "fever");
    assertEquals("leave modified", m2);
    String m3 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-16", "SL", "fever");
    assertEquals("leave modified", m3);
    String m4 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-26", "EL", "fever");
    assertEquals("not modified", m4);
    String m5 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-26", "ML", "fever");
    assertEquals("not modified", m5);
    String m6 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-26", "SL", "fever");
    assertEquals("not modified", m6);
    String m7 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-26", "AL", "fever");
    assertEquals("check leavetype", m7);
    String m8 = Leave.modifyLeave(3000, 3, "2020-06-14", "2020-06-16", "SL", "fever");
    assertEquals("enter valid Date", m8);
    String m9 = Leave.modifyLeave(3000, 3, "2020/06/14", "2020/06/26", "SL", "fever");
    assertEquals("Please Enter Correct Date format", m9);
    String m10 = Leave.modifyLeave(3000, 3, "2020-06-16", "2020-06-15", "SL", "fever");
    assertEquals("enter valid Date", m10);
  }
  /**
   * testing approve deny method.
   * @param ldao mocking the ldao class
   * @param dao mocking the dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testApproveLeave(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd1 = sf.parse("2020-06-14");
    final Date ed1 = sf.parse("2020-06-16");
    //final Date ad1 = sf.parse("2020-06-14");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    final Leave lt = new Leave(10, 8001, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, null);
    final Leave lt1 = new Leave(11, 8001, 4, sd1, ed1, "ML", "PENDING", "vacation", apDate1, null);
    final Leave lt2 = new Leave(12, 8001, 4, sd1, ed1, "SL", "PENDING", "vacation", apDate1, null);
    new Expectations() {
      {
        ldao.find1(10); result = lt;
        ldao.find1(11); result = lt1;
        ldao.find1(12); result = lt2;
        ldao.approveLeave("APPROVED", "enjoy", 10);
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String a = Leave.approveLeave(8001, 10, "APPROVED", "enjoy");
    assertEquals("leave is   APPROVED", a);
    String a1 = Leave.approveLeave(8001, 11, "APPROVED", "enjoy");
    assertEquals("leave is   APPROVED", a1);
    String a2 = Leave.approveLeave(8001, 12, "APPROVED", "enjoy");
    assertEquals("leave is   APPROVED", a2);
    String a4 = Leave.approveLeave(8001, 12, "REJECTED", "enjoy");
    assertEquals("leave not approved", a4);
  }
  /**
   * testing validate leave id method.
   * @param ldao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testValidatelId(@Mocked final LeaveDAO ldao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd1 = sf.parse("2020-06-14");
    final Date ed1 = sf.parse("2020-06-16");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    //final Date ad1 = sf.parse("2020-06-14");
    final Leave lt = new Leave(1, 3001, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, null);
    new Expectations() {
      {
        ldao.find1(1); result = lt;
        ldao.find1(2); result = null;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave lm = Leave.listBylId(1);
    assertEquals(lm, lt);
    Leave lm1 = Leave.listBylId(2);
    assertEquals(lm1, null);
    int l = Leave.validatelId(1);
    assertEquals(l, 1);
    assertNotEquals(l, 0);
    int l1 = Leave.validatelId(2);
    assertEquals(l1, 0);
    assertNotEquals(l1, 1);
  }
  /**
   * testing find employee method.
   * @param ldao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testFindEmpId(@Mocked final LeaveDAO ldao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd1 = sf.parse("2020-06-14");
    final Date ed1 = sf.parse("2020-06-16");
    //final Date ad1 = sf.parse("2020-06-14");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    final Leave lt = new Leave(1, 3001, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, null);
    new Expectations() {
      {
        ldao.find1(1); result = lt;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    Leave lm = Leave.listBylId(1);
    int eid = lm.getEmpId();
    assertEquals(eid, lt.getEmpId());
    assertNotEquals(eid, 3000);
    int e = Leave.findEmpId(1);
    assertEquals(e, 3001);
    assertNotEquals(e, 3000);
  }
  /**
   * testing find El balance method.
   * @param dao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testFindElBal(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(3000, "YASHI", "Female", "yashi@gmail.com", 701456855,
          doj, "HEXAVARSITY", 10, 10, 10, 2001);
    new Expectations() {
      {
        dao.find(3000); result = emp3000;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int elb = Leave.findElBal(3000);
    assertEquals(elb, 10);
    assertNotEquals(elb, 3);
  }
  /**
   * testing the ML balance method.
   * @param dao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testFindMlBal(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(3000, "YASHI", "Female", "yashi@gmail.com", 701456855,
          doj, "HEXAVARSITY", 10, 10, 10, 2001);
    new Expectations() {
      {
        dao.find(3000); result = emp3000;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int mlb = Leave.findMlBal(3000);
    assertEquals(mlb, 10);
    assertNotEquals(mlb, 3);
  }
  /**
   * testing SL balance method.
   * @param dao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testFindSlBal(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(3000, "YASHI", "Female", "yashi@gmail.com", 701456855,
          doj, "HEXAVARSITY", 10, 10, 10, 2001);
    new Expectations() {
      {
        dao.find(3000); result = emp3000;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int slb = Leave.findSlBal(3000);
    assertEquals(slb, 10);
    assertNotEquals(slb, 3);
  }
  /**
   * testing leave status method.
   * @param ldao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testLeaveStat(@Mocked final LeaveDAO ldao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd1 = sf.parse("2020-06-14");
    final Date ed1 = sf.parse("2020-06-16");
    //final Date ad1 = sf.parse("2020-06-14");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    final Leave lt = new Leave(1, 3001, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, null);
    new Expectations() {
      {
        ldao.find1(1); result = lt;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    String stat = Leave.findLeaveStat(1);
    assertEquals(stat, "PENDING");
    assertNotEquals(stat, "REJECTED");
  }
   /**
   * testing validate manager id method.
   * @param ldao mocking the ldao class
   * @param dao mocking dao class
   * @throws ParseException for date.
   */
  @Test
  public final void testValidateManager(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO dao)
                   throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2020-05-10");
    final Employee emp3000 = new Employee(3000, "YASHI", "Female", "yashi@gmail.com", 701456855,
          doj, "HEXAVARSITY", 10, 10, 10, 2001);
    final Date sd1 = sf.parse("2040-06-14");
    final Date ed1 = sf.parse("2040-06-16");
    //final Date ad1 = sf.parse("2020-06-17");
    final DateFormat df = DateFormat.getDateInstance();
    final Date today = new Date();
    //final Date apDate = sf.parse(today);
    final Date apDate1 = df.parse(df.format(today));
    final Leave lv = new Leave(1, 3000, 4, sd1, ed1, "EL", "PENDING", "vacation", apDate1, null);
    new Expectations() {
      {
        ldao.find1(1); result = lv;
        dao.find(3000);  result = emp3000;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO ldao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Leave lms = Leave.listBylId(1);
    int eid = lms.getEmpId();
    Employee ems = Employee.listById(eid);
    int mid = ems.getManagerId();
    assertEquals(mid, emp3000.getManagerId());
    int m = Leave.validateManager(1, 2001);
    assertEquals(m, 1);
    assertNotEquals(m, 0);
    int m1 = Leave.validateManager(1, 2000);
    assertEquals(m1, 0);
    assertNotEquals(m1, 1);
  }
}

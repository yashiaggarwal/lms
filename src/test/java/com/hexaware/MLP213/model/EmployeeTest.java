package com.hexaware.MLP213.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.MLP213.persistence.EmployeeDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for date parse.
   */
  @Test
  public final void testEmployee() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1000 = sdf.parse("2010-02-11");
    Date d2000 = sdf.parse("2012-01-10");
    Employee e1000 = new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d1000, "HUMAN_RESOURCE", 30, 30, 30, 0);
    Employee e2000 = new Employee(2000, "MURUGAN", "Male", "murugan@gmail.com", 786735646,
                d2000, "HEXAVARSITY", 30, 30, 30, 0);
    Employee e3004 = new Employee();
    //testing empty constructor
    assertEquals(e3004, new Employee());
    //testing empty parametarized constructor
    assertEquals(e1000, new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d1000, "HUMAN_RESOURCE", 30, 30, 30, 0));
    assertNotEquals(e1000, new Employee(1000, "KRISHNA", " ", "krishna@gmail.com", 987654331,
                d1000, "HUMAN_RESOURCE", 30, 30, 30, 0));
    assertNotEquals(e1000, new Integer(10001));
    //checking constructor is not null.
    assertNotNull(e1000);
    assertNotNull(e2000);
    assertNotEquals(e1000, null);
    assertEquals(e1000, new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d1000, "HUMAN_RESOURCE", 30, 30, 30, 0));
    assertEquals(e1000.hashCode(), new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d1000, "HUMAN_RESOURCE", 30, 30, 30, 0).hashCode());
    assertEquals(1000, e1000.getEmpId());
    assertNotEquals(10001, e1000.getEmpId());
    //checking getters&setters of empId.
    e1000.setEmpId(10001);
    assertEquals(10001, e1000.getEmpId());
    assertNotEquals(1000, e1000.getEmpId());
    //checking getters&setters of name.
    e1000.setName("Shiv");
    assertEquals("Shiv", e1000.getName());
    assertNotEquals("Divya", e1000.getName());
    //checking getters&setters of gender.
    e1000.setGender("Female");
    assertNotEquals("female", e1000.getGender());
    assertEquals("Female", e1000.getGender());
    assertNotEquals("Male", e1000.getGender());
    //checking getters&setters of email Id.
    e1000.setEmailId("shiv@gmail.com");
    assertEquals("shiv@gmail.com", e1000.getEmailId());
    assertNotEquals("sivh@gmail.com", e1000.getEmailId());
    //checking getters&setters of phone number.
    e1000.setPhoneNumber(999999999);
    assertEquals(999999999, e1000.getPhoneNumber());
    assertNotEquals(653793688, e1000.getPhoneNumber());
    //checking getters&setters of joining date.
    e1000.setJoiningDate(d1000);
    assertEquals(d1000, e1000.getJoiningDate());
    assertNotEquals(d2000, e1000.getJoiningDate());
    //checking getters&setters of department.
    e1000.setDepartment("HEXAVARSITY");
    assertEquals("HEXAVARSITY", e1000.getDepartment());
    assertNotEquals("HUMAN_RESOURCE", e1000.getDepartment());
    //checking getters&setters of el balance.
    e1000.setEarnedLeaveBalance(10);
    assertEquals(10, e1000.getEarnedLeaveBalance());
    assertNotEquals(1000, e1000.getEarnedLeaveBalance());
    //checking getters&setters of ml balance.
    e1000.setMaternityLeaveBalance(1000);
    assertEquals(1000, e1000.getMaternityLeaveBalance());
    assertNotEquals(10001, e1000.getMaternityLeaveBalance());
    //checking getters&setters of sl balance.
    e1000.setSickLeaveBalance(10001);
    assertEquals(10001, e1000.getSickLeaveBalance());
    assertNotEquals(1000, e1000.getSickLeaveBalance());
    //checking getters&setters of manager id.
    e1000.setManagerId(10001);
    assertEquals(10001, e1000.getManagerId());
    assertNotEquals(1000, e1000.getManagerId());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
    assertNotEquals(1, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date parse errors.
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d100011 = sdf.parse("2010-02-11");
    Date d200011 = sdf.parse("2012-01-10");
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d10001 = sdf.parse("2010-02-11");
        Date d20001 = sdf.parse("2012-01-10");
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com",  987654331,
                d10001, "HUMAN_RESOURCE", 30, 30, 30, 0));
        es.add(new Employee(2000, "MURUGAN", "Male", "murugan@gmail.com", 786735646,
                d20001, "HEXAVARSITY", 30, 30, 30, 0));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(2, es.length);
    assertNotEquals(3, es.length);
    assertNotEquals(0, es.length);
    assertNotEquals(es[0], null);
    assertNotEquals(es[0], new Employee(2000, "MURUGAN", "Male", "murugan@gmail.com", 786735646,
                d200011, "HEXAVARSITY", 30, 30, 30, 0));
    assertEquals(es[1], new Employee(2000, "MURUGAN", "Male", "murugan@gmail.com", 786735646,
                d200011, "HEXAVARSITY", 30, 30, 30, 0));
    assertEquals(es[0], new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d100011, "HUMAN_RESOURCE", 30, 30, 30, 0));
    assertNotEquals(es[1], new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d100011, "HUMAN_RESOURCE", 30, 30, 30, 0));
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date parse errors.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d10 = null;
    d10 = sdf.parse("2010-02-11");
    final Employee e100 = new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
                d10, "HUMAN_RESOURCE", 30, 30, 30, 0);
    new Expectations() {
      {
        dao.find(1000); result = e100;
        dao.find(100); result = null;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(1000);
    Employee e1 = Employee.listById(100);
    assertEquals(e100, e);
    assertNotEquals(e100, e1);

    e = Employee.listById(-1);
    assertNull(e);
  }
  /**
   * tests that empty Levae status method is handled correctly.
   * @param dao mocking the ldao class
   * @throws ParseException for date.
   */
  @Test
  public final void testLeaveStat(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date doj = sf.parse("2013-08-20");
    final Employee emp2001 = new Employee(2001, "BABU", "Male", "babu@gmail.com", 980668961,
          doj, "HEXAVARSITY", 30, 30, 30, 2000);
    new Expectations() {
      {
        dao.find(2001); result = emp2001;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int e = Employee.validateEid(2001);
    assertEquals(e, 1);
    assertNotEquals(e, 0);
  }
  /**
   * Tests the to string methods of the employee class.
   * @throws ParseException for date parse errors.
   */
  @Test
  public final void testToString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d10 = sdf.parse("2010-02-11");
    Employee emp1 =  new Employee(1000, "KRISHNA", "Male", "krishna@gmail.com", 987654331,
           d10, "HUMAN_RESOURCE", 30, 30, 30, 0);
    String result = "1000" + "\t" + "KRISHNA" + "      \t" + "Male" + "   \t" + "krishna@gmail.com"
        + "  \t" + 987654331 + " \t" + d10 + " \t" + "HUMAN_RESOURCE" + "\t"
        + "30" + "\t" + "30" + "\t" + "30" + "\t" + "0";
  }
}


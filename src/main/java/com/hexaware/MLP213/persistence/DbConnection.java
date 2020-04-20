package com.hexaware.MLP213.persistence;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.logging.PrintStreamLog;;

/**
 */
public class DbConnection {
    /**
     * Connecting to MYSQL DB.
     * @return database Connection.
     */
  public final DBI getConnect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbc = System.getenv("DB_CONNECTION");
      if (dbc == null || dbc.equals("")) {
        dbc = "localhost:3306";
      }
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/MLP213", "root", "Password123");
      dbi.setSQLLog(new PrintStreamLog());
      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

package lk.ijse.futureapez.bo.custom;

import lk.ijse.futureapez.bo.SuperBO;

import java.sql.SQLException;

public interface DashboardBO extends SuperBO {
    int getcourseCount() throws SQLException, ClassNotFoundException;
    int geteacherCount() throws SQLException, ClassNotFoundException;
    int getStCount() throws SQLException, ClassNotFoundException;
    int getEmployeeCount() throws SQLException, ClassNotFoundException;
}

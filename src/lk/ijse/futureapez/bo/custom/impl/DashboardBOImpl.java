package lk.ijse.futureapez.bo.custom.impl;

import lk.ijse.futureapez.bo.custom.DashboardBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dao.custom.EmployeeDAO;
import lk.ijse.futureapez.dao.custom.StudentDAO;

import java.sql.SQLException;

public class DashboardBOImpl implements DashboardBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    @Override
    public int getStCount() throws SQLException, ClassNotFoundException {
        return studentDAO.getStCount ();
    }
    @Override
    public int getcourseCount() throws SQLException, ClassNotFoundException {
        return  courseDAO.getcourseCount ();
    }

    @Override
    public int geteacherCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.geteacherCount ();
    }
    @Override
    public int getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeCount ();
    }


}

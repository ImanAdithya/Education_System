package lk.ijse.futureapez.dao;

import lk.ijse.futureapez.dao.custom.SuperDAO;
import lk.ijse.futureapez.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT,COURSE,CREATE_ACC,EMPLOYEE,EXAM,LOGIN,MARK,PAYMENT,SALARY,SUBJECT
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl ();
            case COURSE:
                return new CourseDAOImpl ();
            case CREATE_ACC:
                return new CreateAccImpl ();
            case EMPLOYEE:
                return new EmployeeDAOImpl ();
            case EXAM:
                return new ExamDAOImpl ();
            case LOGIN:
                return new LoginDAOImpl ();
            case MARK:
                return new MarkDAOImpl ();
            case PAYMENT:
                return new PaymentDAOImpl ();
            case SALARY:
                return new SalaryDAOImpl ();
            case SUBJECT:
                return new SubjectDAOImpl ();
            default:
                return null;
        }
    }
}

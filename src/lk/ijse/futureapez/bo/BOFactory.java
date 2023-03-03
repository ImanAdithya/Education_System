package lk.ijse.futureapez.bo;

import lk.ijse.futureapez.bo.custom.impl.*;
import lk.ijse.futureapez.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes {
        STUDENT,COURSE,CREATE_ACC,EMPLOYEE,EXAM,LOGIN,MARK,PAYMENT,SALARY,SUBJECT,DASHBOARD
    }


    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl ();
            case COURSE:
                return new CourseBOImpl ();
            case CREATE_ACC:
                return new CreateAccBOImpl ();
            case EMPLOYEE:
                return new EmployeeBOImpl ();
            case DASHBOARD:
                return new DashboardBOImpl ();
            case LOGIN:
                return new LoginBOImpl ();
            case MARK:
                return new MarkBOImpl ();
            case PAYMENT:
                return new PaymentBOImpl ();
            case SALARY:
                return new SalaryBOImpl ();
            default:
                return null;
        }
    }
}

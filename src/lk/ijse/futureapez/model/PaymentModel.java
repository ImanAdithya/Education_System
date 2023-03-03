package lk.ijse.futureapez.model;

import lk.ijse.futureapez.view.tm.CourseStudent;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModel {



    public static CourseStudent loadDetails(String stId) throws SQLException, ClassNotFoundException {
        String sql="select * from studentCourse where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        while (result.next()){
            return new CourseStudent(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getDouble(6),result.getString(7));
        }
        return null;

    }

















}


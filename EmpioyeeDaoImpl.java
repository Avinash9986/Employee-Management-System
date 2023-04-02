package ems;

import java.sql.*;

public class EmpioyeeDaoImpl implements EmployeeDoaIntrf {
    // create emplyoee
    Connection conn ;
    public void createEM(Employee emp) {
        conn = DBConnection.createDBConnection() ;
        String query = "insert into emplyoee values(?,?,?,?)" ;
        try {
            PreparedStatement pstm = conn.prepareStatement(query) ;
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt = pstm.executeUpdate() ;
            if(cnt != 0){
                System.out.println("inserted succesfully");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void showem() {
        conn = DBConnection.createDBConnection() ;
        String query = "SELECT * from emplyoee" ;
        System.out.println("Empyloee Details");
        System.out.format("%s\t%s\t%s\t%s\n",
                "ID",
                "Name",
                "Salary",
                "age");
        try {
            Statement stmt  = conn.createStatement() ;
            ResultSet result = stmt.executeQuery(query) ;
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

    public void showemid(int id) {
        conn = DBConnection.createDBConnection() ;
        String query = "SELECT * from emplyoee where id= "+id ;
        System.out.println("Empyloee Details");
        System.out.format("%s\t%s\t%s\t%s\n",
                "ID",
                "Name",
                "Salary",
                "age");
        try {
            Statement stmt = conn.createStatement() ;
            ResultSet result = stmt.executeQuery(query) ;
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void updateem(int id, String name) {
        conn = DBConnection.createDBConnection() ;
        String query = "update emplyoee set name=? where id=?" ;
        try {
            PreparedStatement pstm = conn.prepareStatement(query) ;
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate() ;
            if(cnt != 0){
                System.out.println("Eployess details are updated");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void deleteem(int id) {
        conn = DBConnection.createDBConnection() ;
        String query = "delete from emplyoee where id=?" ;
        try {
            PreparedStatement pstm = conn.prepareStatement(query) ;
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate() ;
            if(cnt != 0){
                System.out.println("Deletion is successfull");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}

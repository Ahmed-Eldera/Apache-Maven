package org.Der3;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner s = new Scanner(System.in);
    final String url = "jdbc:mariadb://localhost:3301/online_store";
    final String username = "root";
    final String pass = "Hotoboboweare2f";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(url, username, pass);
        int choice;
        while(true){
            System.out.println("choose 1 to insert an admin - 2 to show all admins - 3 to show admin details by id");
            choice = s.nextInt();
            switch(choice){
                case 1 :
                    s.nextLine();
                    System.out.println("Enter name:");
                    String name = s.nextLine();
                    System.out.println("Enter Email:");
                    String email =s.nextLine();
                    System.out.println("Enter Password:");
                    String password = s.nextLine();
                    insert(conn,name,email,password);
                    break;
                case 2 :
                    getAdmins(conn);
                    break;
                case 3 :
                    System.out.println("Enter ID:");
                    int id = s.nextInt();
                    getAdminById(conn,id);
                    break;
            }
        }

    }
    public static void insert(Connection conn, String name , String email , String password) throws SQLException {
        String sql = "insert into admin (name , email , password) values (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,email);
        pstmt.setString(3,password);

        if(pstmt.executeUpdate()>0){
            System.out.println("inserted successfully!");
            return;
        }else{
            System.out.println("Error happened Insertion failed please try again!");
            throw new SQLException();
        }
    }
        public static void getAdmins(Connection conn) throws SQLException {
        String sql = "select * from admin";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        System.out.println("\n All Admins: \n");
        while(resultSet.next()){
            int id = resultSet.getInt("id");          // column by name
            String name = resultSet.getString("name");
          String email = resultSet.getString("email");
//          String phone = resultSet.getString("phone");

            System.out.println("id : "+id+" ------- name : " + name + " - email : " + email );
                        System.out.println('\n');
        }
    }

        public static void getAdminById(Connection conn,int id) throws SQLException {
                String sql = "select name,email from admin where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet resultSet = pstmt.executeQuery();
        while(resultSet.next()){
//            int idz = resultSet.getInt("id");          // column by name
            String name = resultSet.getString("name");
          String email = resultSet.getString("email");
//          String phone = resultSet.getString("phone");
            System.out.println("id : "+id+" - name : " + name + " - email : " + email);
            System.out.println('\n');
        }
        }


}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleconnectionimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sales.Province;
import sales.Sales;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public class SaleConnectionImpl implements Sales {

    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public List<Province> getProvince() throws Exception {
        List<Province> list = new ArrayList<Province>();

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String dB = "jdbc:mysql://localhost:3306/nersa";

        String user = "root";
        String pass = "";

        Connection conn = null;
        Statement state = null;

        Class.forName("com.mysql.jdbc.Driver");
        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(dB, user, pass);
        System.out.println("Connected database successfully...");

        //Execute a query 
        System.out.println("Creating statement...");

        state = conn.createStatement();
        String sql = "SELECT * FROM nersa";
        ResultSet rs = state.executeQuery(sql);

        //Extract data from result set 
        while (rs.next()) {
            // Retrieve by column name 
            int id = rs.getInt("id");
            String provinceName = rs.getString("provinceName");
            int litres = rs.getInt("litres");

            // Setting the values 
            Province pro = new Province();
            pro.setId(id);
            pro.setProvinceName(provinceName);
            pro.setLitres(litres);
            list.add(pro);
        }
        rs.close();

        return list;
    }

}

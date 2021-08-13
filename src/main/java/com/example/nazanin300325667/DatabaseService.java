package com.example.nazanin300325667;

import com.sun.tools.javac.jvm.Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{
    Connection con;
    public DatabaseService(Connection con){
        this.con = con;
    }
    @Override
    public void add(Customer customer) throws  ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO savingstable VALUES(?,?,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1, customer.getCustno());
        query.setString(2, customer.getCustname());
        query.setDouble(3, customer.getCdep());
        query.setInt(4, customer.getNyears());
        query.setString(5, customer.getSavtype());
        query.executeUpdate();
    }

    @Override public Customer edit(Customer customer, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update savingstable set custno=?, custname=?,cdep=?, nyears=?,savtype=?  where custno = ?");
        query.setString(1, customer.getCustno());
        query.setString(2, customer.getCustname());
        query.setDouble(3, customer.getCdep());
        query.setInt(4, customer.getNyears());
        query.setString(5, customer.getSavtype());
        query.setString(6, custno);
        query.executeUpdate();
        return customer;
    }

    @Override
    public void delete(String custno) throws SQLException{
        String quer1 = "DELETE from savingstable where custno=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();
    }

    @Override
    public Customer search(String custno) throws  SQLException,ClassNotFoundException{
        String quer1 = "SELECT * from savingstable where custno =?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1,custno);

        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Customer obj1=null;
        obj1 =  new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));
        return obj1;
    }
    @Override
    public List<Customer> display() throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Customer> Cuslist = new ArrayList<Customer>();
        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Customer obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));
            Cuslist.add(obj1);
        }
        return Cuslist;
    }

    @Override
    public List<Items> display2(String custno) throws ClassNotFoundException, SQLException {
        return null;
    }

    /*@Override
    public List<Items> display2(String custno) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Items> Itemlist = new ArrayList<Items>();
        String quer1 = "Select itemcode,itemdesc from items where catcode=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode);
        ResultSet rs = query.executeQuery();
        Items obj2;
        while (rs.next()) {
            obj2 = new Items(rs.getString("itemcode"),rs.getString("itemdesc"));
            Itemlist.add(obj2);
        }

        return Itemlist;
    }*/
}

package com.example.nazanin300325667;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImplementation implements DaoInterface{
    //
    public Connection123 con3;

    //generated constructor
    public DaoImplementation(Connection123 con3) {
        this.con3 = con3;
    }

    @Override
    public void add(Customer customer) throws SQLException, ClassNotFoundException {
        String qre1 = "INSERT INTO savingstable values(?,?,?,?,?)";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
        obj1.setString(1, customer.getCustno());
        obj1.setString(2, customer.getCustname());
        obj1.setDouble(3, customer.getCdep());
        obj1.setInt(4, customer.getNyears());
        obj1.setString(5, customer.getSavtype());
        obj1.executeUpdate();
        System.out.println("one record added");
    }

    @Override
    public Customer edit(Customer customer, String ccCustomer) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con3.connect().prepareStatement("Update savingstable set custno=?, custname=?,cdep=?, nyears=?,savtype=?  where custno = ?");
        query.setString(1, customer.getCustno());
        query.setString(2, customer.getCustname());
        query.setDouble(3, customer.getCdep());
        query.setInt(4, customer.getNyears());
        query.setString(5, customer.getSavtype());
        query.setString(6, ccCustomer);

        query.executeUpdate();

        System.out.println("One record edited");


        return customer;

    }

    @Override
    public void delete(String custno) throws SQLException, ClassNotFoundException {
        String quer1 = "Delete from savingstable where custno = ?";
        PreparedStatement query = con3.connect().prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();

        System.out.println("One record Deleted");

    }

    @Override
    public void display() throws SQLException, ClassNotFoundException {
        Customer customerDispaly;
        String qre1 = "SELECT * from savingstable";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
        ResultSet rs = obj1.executeQuery();
        while (rs.next()){
            customerDispaly = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));
            System.out.println();
            System.out.println("Customer number \t" + customerDispaly.getCustno());
            System.out.println("Customer name \t" + customerDispaly.getCustname());
            System.out.println("Customer deposit \t" + customerDispaly.getCdep());
            System.out.println("Number of years \t" + customerDispaly.getNyears());
            System.out.println("saving Type \t" + customerDispaly.getSavtype());
        }

    }

    @Override
    public void display2() throws SQLException, ClassNotFoundException {
        String quer1 = "Select * from savingstable order by custno";
        PreparedStatement query = con3.connect().prepareStatement(quer1);

        ResultSet rs = query.executeQuery();

        Customer obj1;

        //display records if there is data;
        while (rs.next()) {

            obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));

            System.out.println();

            System.out.println();
            System.out.println("Customer number \t" + obj1.getCustno());
            System.out.println("Customer name \t" + obj1.getCustname());
            System.out.println("Customer deposit \t" + obj1.getCdep());
            System.out.println("Number of years \t" + obj1.getNyears());
            System.out.println("saving Type \t" + obj1.getSavtype());

        }

    }

    @Override
    public Customer search(String custno) throws SQLException, ClassNotFoundException {
        String qre1 = "SELECT * from savingstable where custno =?";
        PreparedStatement query = con3.connect().prepareStatement(qre1, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        query.setString(1, custno);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.println("Record not existing");
            return null;
        }
        Customer obj2 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));

        return obj2;
    }
}

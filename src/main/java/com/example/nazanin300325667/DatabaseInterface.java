package com.example.nazanin300325667;

import com.sun.tools.javac.jvm.Items;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Customer cat) throws ClassNotFoundException, SQLException;
    public Customer edit(Customer cat, String custno) throws SQLException, ClassNotFoundException;
    public void delete(String custno) throws SQLException;
    public List<Customer> display() throws ClassNotFoundException, SQLException;


    public List<Items> display2(String custno) throws ClassNotFoundException, SQLException;
    public Customer search(String custno) throws  SQLException,ClassNotFoundException;
}



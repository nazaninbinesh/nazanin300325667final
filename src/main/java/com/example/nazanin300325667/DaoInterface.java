package com.example.nazanin300325667;

import java.sql.SQLException;

public interface DaoInterface {
    public void add(Customer customer) throws SQLException, ClassNotFoundException;

    //save the old value
    public Customer edit(Customer customer, String ccCustomer) throws SQLException, ClassNotFoundException;

    public void delete(String custno) throws SQLException, ClassNotFoundException;

    public void display() throws SQLException, ClassNotFoundException;
    public void display2() throws SQLException, ClassNotFoundException;
    public Customer search(String custno) throws SQLException, ClassNotFoundException;
}

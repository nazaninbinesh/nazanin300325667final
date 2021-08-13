package com.example.nazanin300325667;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static List<Customer> cutomerList = new ArrayList<Customer>();

    static {
        cutomerList.add(new Customer("115","Jasper Diaz",15000, 5, "Saving-Deluxe"));
        cutomerList.add(new Customer("112","Zanip Mendiz", 5000,2, "Saving-Regulars"));
    }
    public void initialadd(){

        cutomerList.add(new Customer("115","Jasper Diaz",15000, 5, "Saving-Deluxe"));
        cutomerList.add(new Customer("112","Zanip Mendiz", 5000,2, "Saving-Regulars"));

    }

    public List<Customer> retrieveCustomers(){
        List<Customer> filteredCutomerList = new ArrayList<Customer>();
        for (Customer customer: cutomerList){
            filteredCutomerList.add(customer);
        }
        return filteredCutomerList;
    }
    public void addCustomer(String custno, String custname, double cdep, int nyears, String savtype){

        cutomerList.add(new Customer(custno,custname,cdep,nyears,savtype));
    }
    public void deleteCustomer(String id) {

        for (int i = 0; i < cutomerList.size(); i++) {

            if(id.equals(cutomerList.get(i).getCustno())) {

                cutomerList.remove(i);
                break;
            }

        }


    }

    public Customer retrieve(String id){

        for(Customer customer: cutomerList){
            if(customer.getCustno().equals(id)){
                return customer;
            }
        }
        return null;

    }

    public void update(Customer customer){
        cutomerList.remove(customer);
        cutomerList.add(customer);
    }

    public List<Customer> Filter(String id){
        List<Customer> filtered = new ArrayList<Customer>();
        for (Customer customer: cutomerList){
            if(customer.getCustno().equals(id)){
                return filtered;
            }
        }
        return null;
    }
}

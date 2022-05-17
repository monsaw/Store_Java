package org.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cashier extends Staff_Information implements  CanProducts {
    private HashMap<String,String> CustomersTable= new HashMap<String, String>();

    public Cashier() {
        super();
    }

    private HashMap<String, String> getCustomersTable() {
        return CustomersTable;
    }

    private void setCustomersTable(HashMap<String, String> customersTable) {
        CustomersTable = customersTable;
    }

    public Cashier(String name, String contact, Address address) {
        super(name, contact, address);

        Manager.TotalNumberCashier++;
        Manager.ListOfCashiers.put(name,contact);

//


    }



    @Override
    public void showAvailabeStock() {
        System.out.println("\t Available Products in Store \n");
        System.out.println("Products                      Quantities");
        for (Map.Entry mark : Manager.product.entrySet()) {
            System.out.println(mark.getKey() + "                               " + mark.getValue());

        }

    }

    public void sell(Customers customer,String product, Integer quantity ){
        int initialQuantity = 0;
        int finalQuantity = 0;
        String full_name = "";
        if (customer instanceof Customers && Manager.product.containsKey(product.toUpperCase())){
            for (Map.Entry mark : Manager.product.entrySet()){
                if(mark.getKey().equals(product.toUpperCase())){
                    initialQuantity = Integer.parseInt(mark.getValue().toString());
                    if(quantity > initialQuantity) {
                        System.out.println("Sorry " + product.toUpperCase() +
                            " stock is minimal!");
                    }
                    else {
                        finalQuantity = initialQuantity - quantity;
                        Manager.product.put(product.toUpperCase(),finalQuantity);
                        full_name = customer.getName() + " " + product;
                        customer.setFullName(full_name);
                        CustomersTable.put(full_name , Integer.toString(quantity));

                    }
                    break;


                }
            }

        }else{
            System.out.println("Either you are not recognized as a customer or " +
                    "the product you tends to buy is not available !");
        }
    }

    public void receipt(Customers customer){

        if (CustomersTable.containsKey(customer.getFullName())){
            System.out.println();
            System.out.println("\t\t ***** RECEIPT *****\n");
            String split[];
            for(var customers : CustomersTable.entrySet()){
                if(customers.getKey().equals(customer.getFullName())){
                    split = customers.getKey().split(" ",0);
                    System.out.println("Name           :           "+ customer.getName());
                    System.out.println("Contact       :           "+ customer.getNumber());
                    System.out.println("Purchase       :           "+ split[1].toUpperCase());
                    System.out.println("Quantity       :           "+ customers.getValue());
//                    System.out.println("Sold By       :           "+ );
                }
            }

        }
    }


}

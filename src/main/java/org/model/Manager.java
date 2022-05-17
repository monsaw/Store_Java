package org.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager extends Staff_Information implements CanProducts{
    protected static int TotalNumberCashier;
    private static int NumberOfQualifiedCashier;

    public static int getNumberOfQualifiedCashier() {
        return NumberOfQualifiedCashier;
    }

    protected static HashMap<String, String> ListOfCashiers = new HashMap<String, String>();



    public static HashMap<String, String> showAllCashiers() {
        return ListOfCashiers;
    }


    public Manager(String name, String contact, Address address) {
        super(name, contact, address);
        ArrayList<Integer> values1 = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();
        ArrayList<Integer> values3 = new ArrayList<>();

    // Initiating product to store


        product.put("MILO",10);
        product.put("BIRO",10);
        product.put("BOOK",10);

    }


//    A method of the Manager that set conditions on criteria for hiring cashier :
//          1.  cashier must be between age of 25 and 30
//          2.  cashier must have FirstClass or Second Class

    public Cashier hireCashier(CashierApllicant cashierApllicant) {

        if ((cashierApllicant.getAge() >= 25 && cashierApllicant.getAge() <= 30) &&
                ((cashierApllicant.getQualification() == Qualification.FirstClass) ||
                        (cashierApllicant.getQualification() == Qualification.SecondClassUpper))) {
            System.out.println("Congrats " + cashierApllicant.getName() + "! you are selected for the role!");
            NumberOfQualifiedCashier++;
            TotalNumberCashier++;
            Cashier newCash = new Cashier();
            newCash.setName(cashierApllicant.getName());
            newCash.setAddress(cashierApllicant.getAddress());
            newCash.setContact(cashierApllicant.getContact());


            ListOfCashiers.put(newCash.getName(), newCash.getContact());
            return newCash;

        } else {
            System.out.println("Sorry " + cashierApllicant.getName() + " you are not qualified for the role, Thanks for applying.");
        Cashier empty = new Cashier();
        return empty;
        }

    }


    public void updateStock(String product , Integer quanties) {

        if (this.product.containsKey(product.toUpperCase())){
            int initialQuantity;
            Integer updateQuantity;
        for(Map.Entry products : this.product.entrySet()){

                if (products.getKey().equals(product.toUpperCase())){
                    initialQuantity = Integer.parseInt(products.getValue().toString());
                    updateQuantity = initialQuantity + quanties;
                    this.product.put(product.toUpperCase(),updateQuantity);


                    System.out.println("Stock Updated!");
            }

            }

        }else{
            this.product.put(product.toUpperCase(),quanties);
        }
    }

    @Override
    public void showAvailabeStock() {
        System.out.println("\t Available Products in Store \n");
        System.out.println("Products                      Quantities");
        for (Map.Entry mark : Manager.product.entrySet()) {
            System.out.println(mark.getKey() + "                               " + mark.getValue());

        }
    }
}

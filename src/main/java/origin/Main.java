package origin;

import org.model.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    //  Initiating Manager class with manager_1 object

        Address manager_1_address = new Address(4,"Edo");
        Manager manager1 = new Manager("Ope","09062104892",manager_1_address);


    //  3 Candidates submitting application for the role of cashier

        Address applicantaddress = new Address(3,"Ilorin");


        CashierApllicant applicant_1 = new CashierApllicant("Monsuru",26,
                applicantaddress, Qualification.FirstClass, "08011223344");

        CashierApllicant applicant_2 = new CashierApllicant("Afeez",25,
                applicantaddress,Qualification.SecondClassLower, "09088776655");

        CashierApllicant applicant_3 = new CashierApllicant("Lawal",24,
                applicantaddress,Qualification.SecondClassUpper,"07055446644");

    //  applicant_1 got selected for the role because he passed the set criteria
        Cashier new_cashier = manager1.hireCashier(applicant_1);

    // new_cashier can now display the roles of an existing cashier
        new_cashier.showAvailabeStock();


    // applicant_2 is not selected for the role because he did not pass the set criteria
        manager1.hireCashier(applicant_2);


    // applicant_3 is not selected for the role because he did not pass the set criteria
        manager1.hireCashier(applicant_3);


    // We can confirm the statement above by confirming the total number of successfully hired Cashier;
        int numberOfQualifiedCashier = Manager.getNumberOfQualifiedCashier();
        System.out.println(numberOfQualifiedCashier);

    // An Existing Cashier Initiation.
        Address cashier_1_address = new Address(7,"Benin");
        Cashier cashier_1 = new Cashier("Adekunle","0801226644",cashier_1_address);

    // This is use to get the lists of all the cashiers both the qualified applicants and instantiated/ existing cashier.
        System.out.println(Manager.showAllCashiers());


        System.out.println(Manager.showAllCashiers());

    // Any Manager and  Any Cashier has the right to share the available store products.
        manager1.showAvailabeStock();
        cashier_1.showAvailabeStock();

    // Manager tends to update store for more products. Only Manager has this feature and not cashier.
        manager1.updateStock("book",4);

    // Prove to verify update...
        manager1.showAvailabeStock();

    // Manager tends to add new product that has never been in store.
        manager1.updateStock("Foam",9);
        manager1.updateStock("foam",2);

    //  Prove to verify above...
        manager1.showAvailabeStock();

    // A new customer coming to the store
    Customers customer_1 = new Customers("Arinze","08028293474");
    Customers customer_2 = new Customers("Sulaimon","09087456635");

    // Customer getting to Cashier to buy from store / Cashier to sell to a customer.
    cashier_1.sell(customer_2,"book",3);


    //     Verifying the purchase....
    cashier_1.showAvailabeStock();

    // Issuing Receipt for customer.

    cashier_1.receipt(customer_1);
    cashier_1.receipt(customer_2);

        System.out.println(Manager.showAllCashiers());




    }
}
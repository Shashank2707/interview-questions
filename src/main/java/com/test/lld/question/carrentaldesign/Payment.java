package com.test.lld.question.carrentaldesign;


public class Payment {

    public void payBill(Bill bill) {
        //do payment processing and update the bill status;
    	System.out.println("Payment is completed !!");
    	bill.isBillPaid = true;
    }
}

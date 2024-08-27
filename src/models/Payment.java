package models;

import constants.PaymentMode;
import constants.PaymentStatus;

import java.util.Date;

public class Payment extends BaseModel{
    private int amount;
    private Date time;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String refNumber;

}

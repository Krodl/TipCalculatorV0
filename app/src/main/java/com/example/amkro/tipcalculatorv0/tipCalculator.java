package com.example.amkro.tipcalculatorv0;

/**
 * Created by amkro on 1/26/2018.
 */

public class tipCalculator {
    private float tip;
    private float bill;

    public tipCalculator(float newTip, float newBill){
        setTip(newTip);
        setBill(newBill);
    }

    public float getTip(){
        return tip;
    }
    public float getBill(){
        return bill;
    }
    public void setTip(float newTip){
        if(newTip > 0)
            tip = newTip;
    }
    public void setBill(float newBill){
        if(newBill>0)
            bill = newBill;
    }
    public float tipAmount(){
        return bill * tip;
    }
    public float totalAmount(){
        return bill + tipAmount();
    }
}

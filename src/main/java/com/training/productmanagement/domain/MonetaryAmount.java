package com.training.productmanagement.domain;

import com.training.productmanagement.enums.Currency;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class MonetaryAmount {
    @Column
    private BigDecimal amount = new BigDecimal(0);
    @Column
    private Currency currency = Currency.COP;

    private MonetaryAmount(){

    }

    private MonetaryAmount(String price) throws Exception {
        if (isNotCorrectFormatPrice(price))
            throw new Exception("Price haven't correct format!!");

        extractValues(price);
    }

    private void extractValues(String price) {
        String[] partPrice = price.split(" ");
        this.setAmount(new BigDecimal(partPrice[0]));
        this.setCurrency(Currency.valueOf(partPrice[1]));
    }

    private boolean isNotCorrectFormatPrice(String price) {
        String regexPrice = "^[\\d]+\\s{1}[a-zA-Z]{1,3}";
        return !price.matches(regexPrice);
    }

    MonetaryAmount(BigDecimal amount, Currency currency){
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}

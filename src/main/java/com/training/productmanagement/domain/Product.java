package com.training.productmanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.productmanagement.enums.Currency;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
public class Product {

    @Column(length = 15)
    @Id
    @JsonProperty
    private String code;

    @Column
    @JsonProperty
    private String name;

    @Column
    @Embedded
    @JsonProperty
    private MonetaryAmount price = new MonetaryAmount(new BigDecimal(0), Currency.COP);

    @Column
    @JsonProperty
    private String summary = "";

    @Column
    @JsonProperty
    private int quantityAvailable = 0;

    @Column
    @JsonProperty
    private boolean visibleForSale = true;

    @Column
    @JsonProperty
    private boolean logicErased = false;

    @Column
    @JsonProperty
    private String category;

    private Product(){

    }

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Product(String code, String name, MonetaryAmount price, String summary, int quantityAvailable, boolean visibleForSale, boolean logicErased, String category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.quantityAvailable = quantityAvailable;
        this.visibleForSale = visibleForSale;
        this.logicErased = logicErased;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public void setPrice(MonetaryAmount price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public boolean isVisibleForSale() {
        return visibleForSale;
    }

    public void setVisibleForSale(boolean visibleForSale) {
        this.visibleForSale = visibleForSale;
    }

    public boolean isLogicErased() {
        return logicErased;
    }

    public void setLogicErased(boolean logicErased) {
        this.logicErased = logicErased;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

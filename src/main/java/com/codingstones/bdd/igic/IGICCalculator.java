package com.codingstones.bdd.igic;

public class IGICCalculator {

    public float calculateTotal(String productName, float price) {
        if (productName.equals("common bread") || productName.equals("eggs") || productName.equals("water")) {
            return price;
        }

        if (productName.equals("clothes")) {
            return price * 1.03F;
        }

        if (productName.equals("cigar")) {
            return price * 1.15F;
        }

        return price * 1.07F;
    }
}

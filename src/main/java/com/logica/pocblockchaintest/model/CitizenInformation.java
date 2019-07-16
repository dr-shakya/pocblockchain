package com.logica.pocblockchaintest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenInformation {

    private String property;
    private String previousProperty;
    private String value;
    private int currentWordCount;
    private int wordLimit;

    public CitizenInformation(String property, String previousProperty, String value, int wordLimit) {
        this.property = property;
        this.previousProperty = previousProperty;
        this.value = value;
        this.wordLimit = wordLimit;
    }

}

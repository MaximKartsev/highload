package com.mkartsev.highload.l3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeRate {
    @JsonProperty("r030")
    private String code;
    @JsonProperty("txt")
    private String name;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("cc")
    private String abbreviation;
    @JsonProperty("exchangedate")
    private String exchangedate;
}

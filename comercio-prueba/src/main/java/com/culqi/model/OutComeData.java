package com.culqi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutComeData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("code")
    private String code;

    @JsonProperty("merchant_message")
    private String merchantMessage;

    @JsonProperty("user_message")
    private String userMessage;

    public String getType() {
        return type;
    }

    public OutComeData setType(String type) {
        this.type = type;
        return this;
    }

    public String getCode() {
        return code;
    }

    public OutComeData setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMerchantMessage() {
        return merchantMessage;
    }

    public OutComeData setMerchantMessage(String merchantMessage) {
        this.merchantMessage = merchantMessage;
        return this;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public OutComeData setUserMessage(String userMessage) {
        this.userMessage = userMessage;
        return this;
    }
}

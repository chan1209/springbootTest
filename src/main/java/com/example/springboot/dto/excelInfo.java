package com.example.springboot.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 *
 * @author chenpei
 * @date 2018-08-15
 */
public class ExcelInfo implements Serializable {
    String url;
    String param;
    String value;
    String caseDesc;
    String caseExpect;
    String code;

    public static ExcelInfo build(
            String url,String param,String value,String caseDesc,String caseExpect,String code
    ){
        ExcelInfo excelInfo = new ExcelInfo();
        excelInfo.setUrl(url);
        excelInfo.setParam(param);
        excelInfo.setValue(value);
        excelInfo.setCaseDesc(caseDesc);
        excelInfo.setCaseExpect(caseExpect);
        excelInfo.setCode(code);
        return excelInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    public String getCaseExpect() {
        return caseExpect;
    }

    public void setCaseExpect(String caseExpect) {
        this.caseExpect = caseExpect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

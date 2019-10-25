/*
 * This file is generated by jOOQ.
 */
package com.example.phone_info.tables.pojos;


import com.example.phone_info.tables.interfaces.IData;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Data implements IData {

    private static final long serialVersionUID = 1075328571;

    private Integer id;
    private String  partyAccount;
    private String  accessDate;
    private String  responseDate;
    private String  logType;
    private String  appId;
    private String  menuId;
    private String  menuName;
    private String  phoneInfo;
    private String  phoneUnique;
    private String  errorMsg;

    public Data() {}

    public Data(IData value) {
        this.id = value.getId();
        this.partyAccount = value.getPartyAccount();
        this.accessDate = value.getAccessDate();
        this.responseDate = value.getResponseDate();
        this.logType = value.getLogType();
        this.appId = value.getAppId();
        this.menuId = value.getMenuId();
        this.menuName = value.getMenuName();
        this.phoneInfo = value.getPhoneInfo();
        this.phoneUnique = value.getPhoneUnique();
        this.errorMsg = value.getErrorMsg();
    }

    public Data(
        Integer id,
        String  partyAccount,
        String  accessDate,
        String  responseDate,
        String  logType,
        String  appId,
        String  menuId,
        String  menuName,
        String  phoneInfo,
        String  phoneUnique,
        String  errorMsg
    ) {
        this.id = id;
        this.partyAccount = partyAccount;
        this.accessDate = accessDate;
        this.responseDate = responseDate;
        this.logType = logType;
        this.appId = appId;
        this.menuId = menuId;
        this.menuName = menuName;
        this.phoneInfo = phoneInfo;
        this.phoneUnique = phoneUnique;
        this.errorMsg = errorMsg;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPartyAccount() {
        return this.partyAccount;
    }

    @Override
    public void setPartyAccount(String partyAccount) {
        this.partyAccount = partyAccount;
    }

    @Override
    public String getAccessDate() {
        return this.accessDate;
    }

    @Override
    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    @Override
    public String getResponseDate() {
        return this.responseDate;
    }

    @Override
    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    @Override
    public String getLogType() {
        return this.logType;
    }

    @Override
    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public String getAppId() {
        return this.appId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getMenuId() {
        return this.menuId;
    }

    @Override
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String getMenuName() {
        return this.menuName;
    }

    @Override
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String getPhoneInfo() {
        return this.phoneInfo;
    }

    @Override
    public void setPhoneInfo(String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    @Override
    public String getPhoneUnique() {
        return this.phoneUnique;
    }

    @Override
    public void setPhoneUnique(String phoneUnique) {
        this.phoneUnique = phoneUnique;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Data (");

        sb.append(id);
        sb.append(", ").append(partyAccount);
        sb.append(", ").append(accessDate);
        sb.append(", ").append(responseDate);
        sb.append(", ").append(logType);
        sb.append(", ").append(appId);
        sb.append(", ").append(menuId);
        sb.append(", ").append(menuName);
        sb.append(", ").append(phoneInfo);
        sb.append(", ").append(phoneUnique);
        sb.append(", ").append(errorMsg);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IData from) {
        setId(from.getId());
        setPartyAccount(from.getPartyAccount());
        setAccessDate(from.getAccessDate());
        setResponseDate(from.getResponseDate());
        setLogType(from.getLogType());
        setAppId(from.getAppId());
        setMenuId(from.getMenuId());
        setMenuName(from.getMenuName());
        setPhoneInfo(from.getPhoneInfo());
        setPhoneUnique(from.getPhoneUnique());
        setErrorMsg(from.getErrorMsg());
    }

    @Override
    public <E extends IData> E into(E into) {
        into.from(this);
        return into;
    }
}

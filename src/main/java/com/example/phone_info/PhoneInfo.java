/*
 * This file is generated by jOOQ.
 */
package com.example.phone_info;


import com.example.phone_info.tables.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class PhoneInfo extends SchemaImpl {

    private static final long serialVersionUID = 162081918;

    /**
     * The reference instance of <code>phone_info</code>
     */
    public static final PhoneInfo PHONE_INFO = new PhoneInfo();

    /**
     * The table <code>phone_info.data</code>.
     */
    public final Data DATA = com.example.phone_info.tables.Data.DATA;

    /**
     * No further instances allowed
     */
    private PhoneInfo() {
        super("phone_info", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Data.DATA);
    }
}
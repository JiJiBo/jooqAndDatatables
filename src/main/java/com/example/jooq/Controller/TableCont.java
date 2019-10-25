package com.example.jooq.Controller;

import com.alibaba.fastjson.JSON;
import com.example.phone_info.Tables;
import com.example.phone_info.tables.records.DataRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = {"/", "/sysLogInfoController"})
public class TableCont {
    @Autowired
    private DSLContext dsl;

    @RequestMapping(path = {"/table"})
    public String table(Model m) {
        return "table";
    }

    @RequestMapping(path = {"/listloginfo"})
    @ResponseBody
    public String getData(HttpServletRequest request) {
//        String start = 0 + "";
//        String length = 5 + "";
//        String draw = 1 + ""
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        Map qmap = request.getParameterMap();
        String[] queryList = (String[]) qmap.get("search[value]");
        String query = queryList[0];
        String draw = request.getParameter("draw");
        System.out.println("1123   query  " + query);
        Result<DataRecord> fetch = dsl.selectFrom(Tables.DATA).where(Tables.DATA.ID.like("%" + query + "%")).orderBy(Tables.DATA.ID.asc()).offset(Integer.parseInt(start)).limit(Integer.parseInt(length)).fetch();
        Result<DataRecord> fetchAll = dsl.selectFrom(Tables.DATA).where(Tables.DATA.ID.like("%" + query + "%")).orderBy(Tables.DATA.ID.desc()).fetch();
        System.out.println("1123   " + "fetch  " + fetch.size());
        System.out.println("1123   " + "fetchAll  " + fetchAll.size());
        HashMap<String, Object> map = new HashMap<>();
        map.put("draw", draw);
        map.put("page", Integer.parseInt(start) / Integer.parseInt(length) + 1);
        map.put("recordsTotal", fetchAll.size());
        map.put("pages", fetchAll.size() / Integer.parseInt(length) + 1);
        map.put("start", start);
        map.put("start1", 1);
        map.put("end", fetch.size());
        map.put("recordsFiltered", fetchAll.size());
        ArrayList<HashMap<String, String>> datas = new ArrayList<>();
        for (Record re : fetch) {
            HashMap<String, String> m = new HashMap<>();
            for (Field f : re.fields()) {
                m.put(f.getName(), f.getValue(re).toString());
            }
            datas.add(m);
        }
        map.put("data", datas);
        return JSON.toJSONString(map);
    }

    @RequestMapping(path = {"/data/{start}/{length}/{draw}"})
    @ResponseBody
    public String getData2(@PathVariable(name = "start") int start, @PathVariable(name = "length") int length, @PathVariable(name = "draw") int draw) {
//        String start = 0 + "";
//        String length = 5 + "";
//        String draw = 1 + "";
//        String start = request.getParameter("start");
//        String length = request.getParameter("length");
//        String draw = request.getParameter("draw");
        System.out.println("1123   " + "start  " + start);
        System.out.println("1123   " + "length  " + length);
        Result<DataRecord> fetch = dsl.selectFrom(Tables.DATA).orderBy(Tables.DATA.ID.asc()).offset(start).limit(length).fetch();
        Result<DataRecord> fetchAll = dsl.selectFrom(Tables.DATA).orderBy(Tables.DATA.ID.desc()).fetch();
        System.out.println("1123   " + "fetch  " + fetch.size());
        System.out.println("1123   " + "fetchAll  " + fetchAll.size());
        HashMap<String, Object> map = new HashMap<>();
        map.put("draw", draw);
        map.put("page", start / length + 1);
        map.put("recordsTotal", fetchAll.size());
        map.put("pages", fetchAll.size() / length + 1);
        map.put("start", start);
        map.put("start1", 1);
        map.put("end", fetch.size());
        map.put("recordsFiltered", fetchAll.size());
        ArrayList<HashMap<String, String>> datas = new ArrayList<>();
        for (Record re : fetch) {
            HashMap<String, String> m = new HashMap<>();
            for (Field f : re.fields()) {
                m.put(f.getName(), f.getValue(re).toString());
            }
            datas.add(m);
        }
        map.put("data", datas);
        return JSON.toJSONString(map);
    }

    @RequestMapping(path = {"/query/{start}/{length}/{draw}/{query}"})
    @ResponseBody
    public String query(@PathVariable(name = "start") int start,
                        @PathVariable(name = "length") int length,
                        @PathVariable(name = "draw") int draw,
                        @PathVariable(name = "query") int query
    ) {
        Result<DataRecord> fetch = dsl.selectFrom(Tables.DATA).where(Tables.DATA.ID.like("%" + query + "%")).orderBy(Tables.DATA.ID.asc()).offset(start).limit(length).fetch();
        Result<DataRecord> fetchAll = dsl.selectFrom(Tables.DATA).where(Tables.DATA.ID.like("%" + query + "%")).orderBy(Tables.DATA.ID.desc()).fetch();
        HashMap<String, Object> map = new HashMap<>();
        map.put("draw", draw);
        map.put("page", start / length + 1);
        map.put("recordsTotal", fetchAll.size());
        map.put("pages", fetchAll.size() / length + 1);
        map.put("start", start);
        map.put("start1", 1);
        map.put("end", fetch.size());
        map.put("recordsFiltered", fetchAll.size());
        ArrayList<HashMap<String, String>> datas = new ArrayList<>();
        for (Record re : fetch) {
            HashMap<String, String> m = new HashMap<>();
            for (Field f : re.fields()) {
                m.put(f.getName(), f.getValue(re).toString());
            }
            datas.add(m);
        }
        map.put("data", datas);
        return JSON.toJSONString(map);
    }
}

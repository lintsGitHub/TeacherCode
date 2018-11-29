package com.nf147.test01.vo;

import com.nf147.test01.entity.Emp;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FormBean {

    private Set<Integer> ids;

    private List<Emp> emps;

    private Map<String, Emp> emap;

    public Map<String, Emp> getEmap() {
        return emap;
    }

    public void setEmap(Map<String, Emp> emap) {
        this.emap = emap;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}

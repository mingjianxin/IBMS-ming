package com.ruoyi.framework.web.domain;

import java.util.List;

public class ZtreeList {
    private List<Ztree> ztreeList;

    private Long roleId;

    public ZtreeList(){}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public ZtreeList(List<Ztree> ztreeList) {
        super();
        this.ztreeList = ztreeList;
    }

    public List<Ztree> getZtreeList() {
        return ztreeList;
    }

    public void setZtreeList(List<Ztree> ztreeList) {
        this.ztreeList = ztreeList;
    }
}

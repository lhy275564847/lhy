package com.ocean.project.ssm.dto;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/25.
 */
public class MenuDto {

    //菜单id
    private String id;
    //菜单名称
    private String name;
    //菜单url
    private String url;
    //菜单编码
    private String code;
    //排序
    private Integer sort;
    //上级菜单名称
    private String parentName;

    private List<MenuDto> children;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDto> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}

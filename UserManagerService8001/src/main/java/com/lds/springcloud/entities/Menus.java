package com.lds.springcloud.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Menus implements Serializable {
    private Integer id;
    private String authName;
    private String path;
    private List<Menus> children;
    private Integer order;

    public Menus(Integer id, String authName, String path, List<Menus> children, Integer order) {
        this.id = id;
        this.authName = authName;
        this.path = path;
        this.children = children;
        this.order = order;
    }

    public static List<Menus> getAdminMenuList() {
//      二级菜单
        List<Menus> subItems = new ArrayList<Menus>();
        Menus userList = new Menus(110, "用户列表", "users", null, null);
        subItems.add(userList);
//      一级菜单
        Menus items = new Menus(125, "用户管理", "users", subItems, 1);

        List<Menus> result = new ArrayList<Menus>();
        result.add(items);
        return result;
    }

    public static List<Menus> getStudentMenuList() {
//      二级菜单
        List<Menus> subItems1 = new ArrayList<Menus>();
        Menus userList = new Menus(110, "个人信息", "myInfo", null, null);
        subItems1.add(userList);

        List<Menus> subItems2 = new ArrayList<Menus>();
        Menus searchCourse = new Menus(111, "查询课程", "searchCourse", null, null);
        Menus searchScore = new Menus(112, "查询成绩", "searchScore", null, null);
        subItems2.add(searchCourse);
        subItems2.add(searchScore);


        List<Menus> subItems3 = new ArrayList<Menus>();
        Menus optCourse = new Menus(113, "选修课程", "optCourse", null, null);
        subItems3.add(optCourse);
//      一级菜单
        Menus items1 = new Menus(125, "我的资料", "users", subItems1, 1);
        Menus items2 = new Menus(126, "信息查询", "search", subItems2, 2);
        Menus items3 = new Menus(127, "选课报名", "optional", subItems3, 3);
        List<Menus> result = new ArrayList<Menus>();
        result.add(items1);
        result.add(items2);
        result.add(items3);
        return result;
    }

    public static List<Menus> getTeacherMenuList() {
//      二级菜单
        List<Menus> subItems1 = new ArrayList<Menus>();
        Menus userList = new Menus(110, "个人信息", "myInfo", null, null);
        subItems1.add(userList);

        List<Menus> subItems2 = new ArrayList<Menus>();
        Menus searchTeaching = new Menus(111, "查询授课", "searchTeaching", null, null);
        Menus publishCourses = new Menus(112, "发布课程", "publishCourses", null, null);
        Menus giveScore = new Menus(113, "评定成绩", "giveScore", null, null);
        subItems2.add(searchTeaching);
        subItems2.add(publishCourses);
        subItems2.add(giveScore);
//      一级菜单
        Menus items1 = new Menus(125, "我的资料", "users", subItems1, 1);
        Menus items2 = new Menus(126, "授课任务", "course", subItems2, 2);

        List<Menus> result = new ArrayList<Menus>();
        result.add(items1);
        result.add(items2);
        return result;
    }
}

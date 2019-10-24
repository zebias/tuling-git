package com.tuling.teach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserControl {
    /*
        查看用户名称
     */
    public void showName(){
        System.out.println("查看到了一个用户");
    }
   /*
       删除了一个用户名称
   */
    public void delName(){
        // 修改这个del功能
        System.out.print("删除了一个用户名称");
    }

    public void updateName() {
        // update user
    }

    @RequestMapping("/")
    @ResponseBody
    public String show(){
        return "this is web page";
    }
}

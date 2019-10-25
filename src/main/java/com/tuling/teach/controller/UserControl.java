package com.tuling.teach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;

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
        return "this is web page but create at jenkins tools by test branch";
    }
    /*
        getSHA1
     */
    private static String getSHA1(String ticket, String timestamp, String noncestr, String url){
        // 拼接字符串
        String str= "ticket="+ticket+"&noncestr="+
        noncestr+"&timestamp="+
                timestamp+"&url="+url;
        // 打印内容
        System.out.println("str: " + str);
        // 对象
        MessageDigest md;
        try {
            // 获取实例
            md = MessageDigest.getInstance("SHA-1");
            // 更新数据（字符串转byte数组）
            md.update(str.getBytes());
            // 获取byte数组
            byte[] digest = md.digest();
            // 创建一个字符串
            StringBuffer hexstr = new StringBuffer();
            // 复制为空字符串
            String shaHex = "";
            // 遍历数据
            for (int i = 0; i < digest.length; i++) {
                // 应该是转成16进制字符串
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                // 如果每次遍历长度小于2就追加0
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                //把转好的添加到预先定义的字符串中，追加形式。
                hexstr.append(shaHex);
            }
            // 返回字符串
            return hexstr.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // ticket=FEashrXpKasl7Fvr&noncestr=wyetd7293jfue8di39ei8djeuf738423&timestamp=1571966374&url=http://106.15.120.35:9990/h5
        String sha1 = getSHA1("FEashrXpKasl7Fvr", "1571966374", "wyetd7293jfue8di39ei8djeuf738423", "http://106.15.120.35:9990/h5");
        System.out.println(sha1);
    }
}

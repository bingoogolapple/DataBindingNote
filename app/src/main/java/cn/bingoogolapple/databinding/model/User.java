package cn.bingoogolapple.databinding.model;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 下午1:21
 * 描述:
 */
public class User {
    public String name;
    public String phone;
    public boolean isMan;
    public int age;

    public User(String name, String phone, int age, boolean isMan) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.isMan = isMan;
    }

}
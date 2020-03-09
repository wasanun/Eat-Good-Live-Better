package com.example.eatgood;

public class Member {
    private String id;
    private String Name;
    private String Age;
    private String Hight;
    private String Weight;
    private String Sex;
    private String Weight1;
    private String Burn;
    private String Msg;

    public Member(){

    }

    public Member(String id, String name, String age, String hight, String weight, String sex, String weight1, String burn, String msg) {
        this.id = id;
        Name = name;
        Age = age;
        Hight = hight;
        Weight = weight;
        Sex = sex;
        Weight1 = weight1;
        Burn = burn;
        Msg = msg;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHight() {
        return Hight;
    }

    public void setHight(String hight) {
        Hight = hight;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        this.Msg = msg;
    }

    public String getWeight1() {
        return Weight1;
    }

    public void setWeight1(String weight1) {
        Weight1 = weight1;
    }

    public String getBurn() {
        return Burn;
    }

    public void setBurn(String burn) {
        Burn = burn;
    }
}




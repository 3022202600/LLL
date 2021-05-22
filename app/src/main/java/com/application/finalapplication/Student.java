package com.application.finalapplication;

public class Student {
    public int ID = -1;
    public String Name;
    public String Sex;
    public int Totalcredits;

    @Override
    public String toString(){
        String result = "";
        result += "ID：" + this.ID + "，";
        result += "姓名：" + this.Name + "，";
        result += "性别：" + this.Sex + "， ";
        result += "总学分：" + this.Totalcredits + "，";
        return result;
    }
}
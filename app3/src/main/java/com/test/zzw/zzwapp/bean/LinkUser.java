package com.test.zzw.zzwapp.bean;

/**
 * Created by Administrator on 2017/6/8.
 */

public class LinkUser {
    private String userid;
    private String password;
    private String easemob_username;
    private String easemob_password;
    private String nickname;
    private String email;
    private String sex;
    private String area;
    private String avatar;
    private String updateTime;
    private int isexpert;//行家id，(0 = 普通用户) (>0行家id)
    private int type;//环信消息用，0是客服 1是用户    //也用来代表群组成员类型 2表示行家 1表示管理员 0表示普通用户

    private String mobilephone;
    private String username;

    private int isvip;//0 不是vip
    private String vipexpirationtime;
    private int registertype;
    private String yetai;
    private String jobyear;
    private String department;

    public int fanscount;
    public int followcount;

    public int getFanscount() {
        return fanscount;
    }

    public void setFanscount(int fanscount) {
        this.fanscount = fanscount;
    }

    public int getFollowcount() {
        return followcount;
    }

    public void setFollowcount(int followcount) {
        this.followcount = followcount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getEasemob_username() {
        return easemob_username;
    }
    public void setEasemob_username(String easemob_username) {
        this.easemob_username = easemob_username;
    }
    public String getEasemob_password() {
        return easemob_password;
    }
    public void setEasemob_password(String easemob_password) {
        this.easemob_password = easemob_password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsexpert() {
        return isexpert;
    }

    public void setIsexpert(int isexpert) {
        this.isexpert = isexpert;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsvip() {
        return isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }

    public String getVipexpirationtime() {
        return vipexpirationtime;
    }

    public void setVipexpirationtime(String vipexpirationtime) {
        this.vipexpirationtime = vipexpirationtime;
    }

    public int getRegistertype() {
        return registertype;
    }

    public void setRegistertype(int registertype) {
        this.registertype = registertype;
    }

    public String getYetai() {
        return yetai;
    }

    public void setYetai(String yetai) {
        this.yetai = yetai;
    }

    public String getJobyear() {
        return jobyear;
    }

    public void setJobyear(String jobyear) {
        this.jobyear = jobyear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

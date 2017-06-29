package com.test.zzw.zzwapp.bean;

/**
 * Created by Administrator on 2017/6/8.
 */

/**
 * 版本号
 */
public class Version {

    int lastVersion;
    String url;
    String versionName;
    String versionDesp;

    public int getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(int lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionDesp() {
        return versionDesp;
    }

    public void setVersionDesp(String versionDesp) {
        this.versionDesp = versionDesp;
    }
}

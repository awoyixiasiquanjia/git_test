package com.example.administrator.icome.icomeutils.utils.bean;

public class SelectPersonBean {
    private String name;
    private int userId;
    private boolean isSelect;
    private String personIcon;

    public SelectPersonBean(String name, int userId, boolean isSelect, String personIcon) {
        this.name = name;
        this.userId = userId;
        this.isSelect = isSelect;
        this.personIcon = personIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getPersonIcon() {
        return personIcon;
    }

    public void setPersonIcon(String personIcon) {
        this.personIcon = personIcon;
    }
}

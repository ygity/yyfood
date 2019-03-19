package yyy.vo;

import yyy.pojo.Food;

import java.util.List;

public class VMenuInfo {

    private Integer typeid;
    private String typename;
    private List<Food> foodList;

    public VMenuInfo(){}

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}

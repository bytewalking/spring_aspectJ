package com.evan.aspectJ.demo1;

public class ProductDao {

    public void save(){
        System.out.println("保存商品..");
    }

    public void update(){
        System.out.println("更新商品..");
    }

    public void delete(){
        System.out.println("删除商品..");
    }

    public void findeOne(){
        System.out.println("查找一个商品..");
    }

    public void findeAll(){
        System.out.println("查找所有商品..");
    }
}

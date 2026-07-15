package com.jinan.log.facade;

public class BathRoom implements LightInfo{
    @Override
    public void on() {
        System.out.println("开启卫生间灯");
    }

    @Override
    public void off() {
        System.out.println("关闭卫生间灯");
    }
}

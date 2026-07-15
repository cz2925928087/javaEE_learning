package com.jinan.log.facade;

public class LivingRoomLight implements LightInfo{
    @Override
    public void on() {
        System.out.println("开启客厅灯");
    }

    @Override
    public void off() {
        System.out.println("关闭客厅灯");
    }
}

package com.jinan.log.facade;

public class HallLight implements LightInfo{


    @Override
    public void on() {
        System.out.println("开启走廊灯");
    }

    @Override
    public void off() {
        System.out.println("关闭走廊灯");
    }
}

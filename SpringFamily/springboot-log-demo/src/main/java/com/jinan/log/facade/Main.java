package com.jinan.log.facade;

//门面模式设计

public class Main {
    public static void main(String[] args) {
        LightFacade lightFacade = new LightFacade();
        lightFacade.on();
        lightFacade.off();
    }
}

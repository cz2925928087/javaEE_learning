package com.jinan.log.facade;

public class LightFacade {
    BathRoom bathRoom = new BathRoom();
    HallLight hallLight = new HallLight();
    LivingRoomLight livingRoomLight = new LivingRoomLight();

    void on() {
        bathRoom.on();
        hallLight.on();
        livingRoomLight.on();
    }

    void off() {
        bathRoom.off();
        hallLight.off();
        livingRoomLight.off();
    }
}

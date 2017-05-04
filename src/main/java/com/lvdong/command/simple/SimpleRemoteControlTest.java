package com.lvdong.command.simple;


/**
 * 命令模式
 * Created by lvdong on 2017/2/7.
 */
public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();

        System.out.println("-----------------------------------------");

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}

class SimpleRemoteControl{
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void buttonWasPressed(){
        System.out.println("开关按下");
        command.execute();
    }
}

class Light{
    Light() {
        System.out.println("我是一盏灯");
    }

    void on(){
        System.out.println("灯开了");
    }
}

class GarageDoor{
    GarageDoor() {
        System.out.println("我是车库门");
    }

    void open(){
        System.out.println("车库门开了");
    }

    void close(){
        System.out.println("车库门关了");
    }
}

interface Command{
    void execute();
}

/**
 * 开灯命令
 */
class LightOnCommand implements Command{

    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
        System.out.println("灯和命令已经关联");
    }

    @Override
    public void execute() {
        light.on();
    }
}

/**
 * 打开车库门命令
 */
class GarageDoorOpenCommand implements Command{

    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
        System.out.println("车库门和命令已经关联");
    }

    @Override
    public void execute() {
        garageDoor.open();
    }
}

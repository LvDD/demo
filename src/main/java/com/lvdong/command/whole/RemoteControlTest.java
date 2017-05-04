package com.lvdong.command.whole;


/**
 * 命令模式
 * Created by lvdong on 2017/2/7.
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light("卧室灯");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        Light light2 = new Light("厨房灯");
        LightOnCommand lightOnCommand2 = new LightOnCommand(light2);
        LightOffCommand lightOffCommand2 = new LightOffCommand(light2);

        GarageDoor garageDoor = new GarageDoor("地下1层车库门");
        GarageDoorOnCommand garageDoorOnCommand = new GarageDoorOnCommand(garageDoor);
        GarageDoorOffCommand garageDoorOffCommand = new GarageDoorOffCommand(garageDoor);


        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, garageDoorOnCommand, garageDoorOffCommand);
        remoteControl.setCommand(2, lightOnCommand2, lightOffCommand2);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);

        remoteControl.undoButtonWasPushed();
//        remoteControl.offButtonWasPushed(0);
//        remoteControl.onButtonWasPushed(1);
//        remoteControl.offButtonWasPushed(1);
//        remoteControl.onButtonWasPushed(2);
//        remoteControl.offButtonWasPushed(2);

    }
}

class RemoteControl {
    private Command[] onCommand;
    private Command[] offCommand;
    private Command undoCommand;

    RemoteControl() {
        onCommand = new Command[7];
        offCommand = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            this.onCommand[i] = noCommand;
            this.offCommand[i] = noCommand;
        }

        undoCommand = noCommand;
    }

    void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    void onButtonWasPushed(int slot) {
        System.out.println("on开关按下[" + slot + "]");
        onCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    void offButtonWasPushed(int slot) {
        System.out.println("off开关按下[" + slot + "]");
        offCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    void undoButtonWasPushed(){
        System.out.println("undo开关按下");
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n-------------------------------Remote Control-------------------------------\n");
        for (int i = 0; i < onCommand.length; i++) {
            stringBuilder.append(" [slot ").append(i).append("] ").append(onCommand[i].getClass().getName()).append("\t\t\t\t").append(offCommand[i].getClass().getName()).append("\n");
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}

class Light {

    private String name;


    Light(String name) {
        this.name = name;
    }

    void on() {
        System.out.println(name + "开了");
    }

    void off() {
        System.out.println(name + "关了");
    }
}

class GarageDoor {
    private String name;

    GarageDoor(String name) {
        this.name = name;
    }

    void open() {
        System.out.println(name + "开了");
    }

    void close() {
        System.out.println(name + "关了");
    }
}

interface Command {
    void execute();
    void undo();
}

class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}

/**
 * 开灯命令
 */
class LightOnCommand implements Command {

    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
        System.out.println("灯和命令已经关联");
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

/**
 * 关灯命令
 */
class LightOffCommand implements Command {

    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
        System.out.println("灯和命令已经关联");
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

/**
 * 打开车库门命令
 */
class GarageDoorOnCommand implements Command {

    private GarageDoor garageDoor;

    GarageDoorOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
        System.out.println("车库门和命令已经关联");
    }

    @Override
    public void execute() {
        garageDoor.open();
    }

    @Override
    public void undo() {
        garageDoor.close();
    }
}

/**
 * 关闭车库门命令
 */
class GarageDoorOffCommand implements Command {

    private GarageDoor garageDoor;

    GarageDoorOffCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
        System.out.println("车库门和命令已经关联");
    }

    @Override
    public void execute() {
        garageDoor.close();
    }

    @Override
    public void undo() {
        garageDoor.open();
    }
}
package Trabajo_11.Actividades;

interface Command {
    void execute();
}

class Television {

    public void powerOn() {
        System.out.println("La televisión está encendida.");
    }

    public void powerOff() {
        System.out.println("La televisión está apagada.");
    }

    public void volumeUp() {
        System.out.println("Volumen aumentado.");
    }

    public void volumeDown() {
        System.out.println("Volumen disminuido.");
    }

    public void mute() {
        System.out.println("La televisión está silenciada.");
    }
}

class PowerOnCommand implements Command {
    private final Television television;

    public PowerOnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.powerOn();
    }
}

class PowerOffCommand implements Command {
    private final Television television;

    public PowerOffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.powerOff();
    }
}


class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Actividad_3 {
    public static void main(String[] args) {
        Television television = new Television();
        Command powerOnCommand = new PowerOnCommand(television);
        Command powerOffCommand = new PowerOffCommand(television);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(powerOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(powerOffCommand);
        remoteControl.pressButton();
    }
}
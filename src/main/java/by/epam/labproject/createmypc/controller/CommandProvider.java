package by.epam.labproject.createmypc.controller;


import by.epam.labproject.createmypc.controller.command.impl.*;
import by.epam.labproject.createmypc.controller.command.Command;


import java.util.HashMap;
import java.util.Map;

class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.HELLO_PAGE, new HelloPage());
        commands.put(CommandName.MAIN_PAGE, new MainPage());
    }

    Command getCommand(String commandName) {
        Command command;

        command = commands.get(CommandName.valueOf(commandName.toUpperCase()));

        return command;

    }

}

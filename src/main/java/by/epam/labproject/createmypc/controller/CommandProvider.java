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
        commands.put(CommandName.PROFILE_PAGE, new ProfilePage());
        commands.put(CommandName.USERLIST_PAGE, new UserListPage());
        commands.put(CommandName.REG_PAGE, new RegPage());
        commands.put(CommandName.REG_USER, new RegUser());
        commands.put(CommandName.CHECK_USER, new CheckUser());
        commands.put(CommandName.LOG_OUT, new LogOut());
    }

    Command getCommand(String commandName) {
        Command command;

        command = commands.get(CommandName.valueOf(commandName.toUpperCase()));

        return command;

    }

}

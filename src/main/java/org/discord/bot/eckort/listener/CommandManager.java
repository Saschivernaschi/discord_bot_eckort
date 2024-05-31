package org.discord.bot.eckort.listener;

import org.discord.bot.eckort.Main;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.discord.bot.eckort.listener.commands.CommandInterface;

import java.util.HashMap;

public class CommandManager {
    private static CommandManager instance;
    private HashMap<String, CommandInterface> commandMap = new HashMap<>();

    public static CommandManager getInstance(){
        if (instance == null){
            instance = new CommandManager();
        }
        return instance;
    }

    public void performCommand(String command, Member member, TextChannel channel, Message message){
        if (commandMap.containsKey(command)) {
            CommandInterface commandObject = commandMap.get(command);
            commandObject.performCommand(member, channel, message);
        }
    }

    public void addCommand(String command, CommandInterface commandObject) throws IllegalStateException{
        if(commandMap.containsKey(command)) throw new IllegalStateException("command kann nicht hingefügt werden.");
        commandMap.put(command, commandObject);
    }

    protected static boolean isArgumentsEmpty(Message message){
        String[] arguments = getArguments(message);
        if (arguments.length == 0) return true;
        return false;
    }

    protected static String[] getArguments(Message message){
        return message.getContentDisplay().substring(Main.PREFIX.length()).split(" "); //TODO: fix message split (currently command looks like: "/EPing" instead of "/E Ping")
    }
}
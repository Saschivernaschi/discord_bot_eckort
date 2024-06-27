package org.discord.bot.eckort.commandMangement;

import org.discord.bot.eckort.Main;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.discord.bot.eckort.commandMangement.commands.CommandInterface;
import org.discord.bot.eckort.commandMangement.commands.PingPongCommand;
import org.discord.bot.eckort.commandMangement.commands.TextToSpeechCommand;

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

    private void addCommand(String command, CommandInterface commandObject) throws IllegalStateException{
        if(commandMap.containsKey(command)) throw new IllegalStateException("command kann nicht hingefügt werden.");
        commandMap.put(command, commandObject);
    }

    protected static boolean isArgumentsEmpty(Message message){
        String[] arguments = getArguments(message);
        if (arguments.length == 0) return true;
        return false;
    }

    public static String[] getArguments(Message message){
        return message.getContentDisplay().substring(Main.PREFIX.length()).split(" "); //TODO: fix message split (currently command looks like: "/EPing" instead of "/E Ping")
    }

    public static void addAllCommands(){
        CommandManager.getInstance().addCommand("Ping", new PingPongCommand());
        CommandManager.getInstance().addCommand("TextToSpeech", new TextToSpeechCommand());
    }
}

package org.discord.bot.eckort.commandMangement;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.discord.bot.eckort.Main;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getChannelType() == ChannelType.TEXT && !e.getAuthor().isBot() && e.getMessage().getContentDisplay().startsWith(Main.PREFIX) && !CommandManager.isArgumentsEmpty(e.getMessage())){
            String[] userMessage = CommandManager.getArguments(e.getMessage());
            String userCommand = userMessage[0];
            CommandManager.getInstance().performCommand(userCommand, e.getMember(), e.getChannel().asTextChannel(), e.getMessage());
        }
    }
}

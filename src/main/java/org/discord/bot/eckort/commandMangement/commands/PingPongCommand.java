package org.discord.bot.eckort.commandMangement.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class PingPongCommand implements CommandInterface {
    @Override
    public void performCommand(Member member, TextChannel channel, Message message){
        channel.sendMessage("Pong").queue();
    }
}

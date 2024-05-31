package org.discord.bot.eckort.listener.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public interface CommandInterface {
    void performCommand(Member member, TextChannel channel, Message message);
}

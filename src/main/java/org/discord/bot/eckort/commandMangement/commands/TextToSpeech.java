package org.discord.bot.eckort.commandMangement.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.discord.bot.eckort.voicehandling.textToSpeech.textToSpeechHandler;

public class TextToSpeech implements CommandInterface {
    @Override
    public void performCommand(Member member, TextChannel channel, Message message) {
        textToSpeechHandler.runHandler(member, channel, message);
    }
}

package org.discord.bot.eckort.textToSpeech;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.Objects;

public class textToSpeechHandler{
    public static void runHandler (Member member, TextChannel channel, Message message) throws NullPointerException{
        performAudioConnection(member);

    }
    private static void performAudioConnection(Member member) throws NullPointerException{
        Guild guild = member.getGuild();
        AudioChannelUnion voiceChannel = Objects.requireNonNull(member.getVoiceState().getChannel());
        if (voiceChannel.getMembers().contains(member)){
            AudioManager audioManager = guild.getAudioManager();
            audioManager.openAudioConnection(voiceChannel);
        } else {
            throw new NullPointerException();
        }
    }
}

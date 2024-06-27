package org.discord.bot.eckort.voicehandling.textToSpeech;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.managers.AudioManager;
import org.discord.bot.eckort.commandMangement.CommandManager;
import org.discord.bot.eckort.commandMangement.commands.TextToSpeechCommand;

import java.util.Objects;

import static org.discord.bot.eckort.commandMangement.CommandManager.getArguments;
//Todo implement get arguments to handle optional arguments
public class textToSpeechHandler{
    public static void runHandler (Member member, TextChannel channel, Message message) throws NullPointerException{
        performAudioConnection(member);
        //String [] userArguments = CommandManager.getArguments(message);
        //TextToSpeechBot textToSpeechBot = new TextToSpeechBot();
    }
    private static void performAudioConnection(Member member) throws NullPointerException{
        Guild guild = member.getGuild();
        AudioChannelUnion voiceChannel = Objects.requireNonNull(member.getVoiceState()).getChannel();
        if (voiceChannel != null){
            AudioManager audioManager = guild.getAudioManager();
            audioManager.openAudioConnection(voiceChannel);
        } else {
            throw new NullPointerException("connect to voicechannel failed");
        }
    }
}
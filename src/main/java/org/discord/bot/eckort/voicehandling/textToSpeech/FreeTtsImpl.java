package org.discord.bot.eckort.voicehandling.textToSpeech;

import com.sun.speech.freetts.FreeTTSSpeakableImpl;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.Arrays;


//Todo: implement dynamic voiceChoice and implement Player()
public class FreeTtsImpl extends FreeTTSSpeakableImpl {
    public FreeTtsImpl(String text) {
        super(text);
        javax.speech.synthesis.Voice selectedVoice;
    }
    /*
    public void resumePlay() {
        VoiceManager voiceManager = VoiceManager.getInstance();

        // create a list of new Voice instances
        Voice[] voices = voiceManager.getVoices();


        // get correct voice

        // Stimme initialisieren und Text vorlesen

    }
    public String listAvailableVoices(VoiceManager voiceManager) {
        Voice[] voices = voiceManager.getVoices();
        return Arrays.toString(voices);
    }
    public Voice getVoice (Voice[] voices, Voice voiceChoice){
        try {
            // Gewählte Stimme
            Voice voice = voices[0];
            return voice;
        } catch (Exception e){
            throw new IllegalArgumentException("incorrect voice argument.");
        }

    }*/
}

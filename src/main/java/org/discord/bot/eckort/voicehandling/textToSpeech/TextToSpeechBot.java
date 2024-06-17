package org.discord.bot.eckort.voicehandling.textToSpeech;

import com.sun.speech.freetts.FreeTTS;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class TextToSpeechBot {
    private final String voiceString;
    private final float rate;
    private final String text;

    public TextToSpeechBot(String voice, float rate, String text) {
        this.voiceString = voice;
        this.rate = rate;
        this.text = text;
    }
    public TextToSpeechBot(String text) {
        this.voiceString = "Kevin";
        this.rate = 1;
        this.text = text;
    }
    public void speak() {
        try {
            // Initialize FreeTTS mode
            FreeTTS tts = new FreeTTS();

            // VoiceManager to get voice
            VoiceManager voiceManager = VoiceManager.getInstance();
            Voice voice = voiceManager.getVoice(this.voiceString);
            voice = voiceManager.getVoice(voiceString);

            // set voice speed rate
            voice.setRate(rate);

            // Text ausgeben
            tts.textToSpeech(this.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

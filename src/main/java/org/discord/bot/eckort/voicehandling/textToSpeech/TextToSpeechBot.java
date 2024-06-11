package org.discord.bot.eckort.voicehandling.textToSpeech;


import com.sun.speech.freetts.FreeTTS;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeechBot {
    private String voice;
    private float rate;
    private String text;

    public TextToSpeechBot(String voice, float rate, String text) {
        this.voice = voice;
        this.rate = rate;
        this.text = text;
    }
    public void speak() {
        try {
            // Initialize FreeTTS mode
            FreeTTS tts = new FreeTTS();

            // VoiceManager to get voice
            VoiceManager voiceManager = VoiceManager.getInstance();
            Voice voice = voiceManager.getVoice(this.voice);

            if (voice == null) {
                voice = voiceManager.getVoice("Kevin");
            }
            // set voice speed rate
            if (!Float.isInfinite(rate)){
                voice.setRate(rate);
            } else {
                voice.setRate(1);
            }

            // Text ausgeben
            tts.textToSpeech(this.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

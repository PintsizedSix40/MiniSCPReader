package com.harium.hci.espeak;

import java.io.IOException;

/**
 * Reference: http://espeak.sourceforge.net/commands.html
 */
public class Espeak {

    public static final String COMMAND_ESPEAK = "espeak";
    private Voice voice;
    private Process proc = null;

    public Espeak() {
        this(new Voice());
    }

    public Espeak(Voice voice) {
        this.voice = voice;
    }

    /**
     * Create a new espeak process
     *
     * @param text - the text to speak
     */
    public void speak(String text) {
        if(proc != null) {
    	proc.destroy();
        }
    	execute(COMMAND_ESPEAK,
        		"-m",
                "-v", voice.getName() + voice.getVariant(),
                "-p", Integer.toString(voice.getPitch()),
                "-a", Integer.toString(voice.getAmplitude()),
                "-s", Integer.toString(voice.getSpeed()),
                "-g", Integer.toString(voice.getGap()),
                text);
    }
    
    public void kill() {
    	if(proc != null) {
        	proc.destroy();
            }
    }

    private void execute(final String ... command) {
        String threadName = "espeak";

        new Thread(new Runnable() {
            public void run() {
                ProcessBuilder b = new ProcessBuilder(command);
                try {
                    proc = b.start();
                    proc.waitFor();
                    proc.destroy();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, threadName).start();
    }

}

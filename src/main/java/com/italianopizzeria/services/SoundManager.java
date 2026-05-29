package com.italianopizzeria.services;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundManager {

    private Clip backgroundClip;

    public void playBackgroundMusic() {
        try {
            URL soundURL = getClass().getResource(
                    "/assets/sounds/backgroundSound.wav"
            );

            if (soundURL == null) {
                System.out.println("Background sound file not found.");
                return;
            }

            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(soundURL);

            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioInputStream);

            setVolume(backgroundClip, -42.0f);

            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported background audio file format.");
        } catch (IOException e) {
            System.out.println("Error loading background music.");
        } catch (LineUnavailableException e) {
            System.out.println("Background audio line unavailable.");
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundClip != null) {
            backgroundClip.stop();
            backgroundClip.close();
        }
    }

    public void playMenuClick() {
        try {
            URL soundURL = getClass().getResource(
                    "/assets/sounds/softclick.wav"
            );

            if (soundURL == null) {
                System.out.println("Click sound file not found.");
                return;
            }

            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(soundURL);

            Clip clickClip = AudioSystem.getClip();
            clickClip.open(audioInputStream);

            setVolume(clickClip, -3.0f);

            clickClip.start();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported click audio file format.");
        } catch (IOException e) {
            System.out.println("Error loading click sound.");
        } catch (LineUnavailableException e) {
            System.out.println("Click audio line unavailable.");
        }
    }

    private void setVolume(Clip clip, float volumeLevel) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl volume =
                    (FloatControl) clip.getControl(
                            FloatControl.Type.MASTER_GAIN
                    );

            volume.setValue(volumeLevel);
        }
    }
}
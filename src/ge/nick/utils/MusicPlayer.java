package ge.nick.utils;

/**
 * Music player major component of Jukebox.
 * It component to work with music.
 * Have own thread to play music.
 */

public class MusicPlayer extends Thread {

    // Name of music. Label.
    protected String songMusic;

    // Music playing duration.
    protected int songDuration;

    // Action that can be called while playing music.
    protected PlayerCallBack playerCallBack;

    // Parametric constructor to set values.
    public MusicPlayer(String songMusic, int songDuration) {
        this.songMusic = songMusic;
        this.songDuration = songDuration;
    }

    // To set action.
    public void setPlayerCallBack(PlayerCallBack playerCallBack) {
        this.playerCallBack = playerCallBack;
    }

    // To start playing music.
    public void play(){

        //System.out.println("Now is playing: " + this.songMusic);

        try {

            // Sleep thread to while playing music.
            Thread.sleep(this.songDuration);

            // Run action at music playing.
            this.playerCallBack.callback();

        } catch (InterruptedException e) {

            //System.out.println("Playing stopped.");
        }
    }

    // To run (on) music player.
    public void run(){ this.play(); }
}

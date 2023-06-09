package ge.nick.utils;

public class MusicPlayer extends Thread {

    protected String songMusic;
    protected int songDuration;

    protected PlayerCallBack playerCallBack;

    public MusicPlayer(String songMusic, int songDuration) {
        this.songMusic = songMusic;
        this.songDuration = songDuration;
    }

    public void setPlayerCallBack(PlayerCallBack playerCallBack) {
        this.playerCallBack = playerCallBack;
    }

    public void play(){

        //System.out.println("Now is playing: " + this.songMusic);

        try {

            Thread.sleep(this.songDuration);
            this.playerCallBack.callback();

        } catch (InterruptedException e) {

            //System.out.println("Playing stopped.");
        }
    }

    public void run(){ this.play(); }
}

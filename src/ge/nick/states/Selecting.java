package ge.nick.states;

import ge.nick.Jukebox;
import ge.nick.utils.MusicPlayer;

public class Selecting extends State{

    public Selecting(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void ejectMoney() {

        System.out.println("Client do not like playlist and prefer to come money back.");
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void stopMusic() {

        System.out.println("Music ended. Insert money to select new one.");
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void playMusic(String name, Integer musicDuration) {

        System.out.println("Client chosen song and now playing: " + name);

        MusicPlayer musicPlayer = new MusicPlayer(name, musicDuration);
        musicPlayer.setPlayerCallBack(this::stopMusic);
        musicPlayer.start();

        jukebox.setState(new Playing(jukebox, musicPlayer));
    }
}

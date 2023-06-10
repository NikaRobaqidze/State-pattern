package ge.nick.states;

import ge.nick.utils.Jukebox;
import ge.nick.utils.MusicPlayer;

/**
 * Jukebox state when music can be selected.
 * Client can select music to play.
 * Also, can eject money if change client change mind.
 * Client can stop music.
 */

public class Selecting extends State{

    public Selecting(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void ejectMoney() {

        System.out.println("Client do not like playlist and prefer to come money back.");

        // Set default state when machine wait to insert money.
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void stopMusic() {

        System.out.println("Music ended. Insert money to select new one.");

        // Set default state when machine wait to insert money.
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void playMusic(String name, Integer musicDuration) {

        System.out.println("Client chosen song and now playing: " + name);

        // Initialize music player.
        MusicPlayer musicPlayer = new MusicPlayer(name, musicDuration);

        // Set music stop trigger.
        musicPlayer.setPlayerCallBack(this::stopMusic);

        // Start playing music. Run thread.
        musicPlayer.start();

        // Set state when machine playing music.
        jukebox.setState(new Playing(jukebox, musicPlayer));
    }
}

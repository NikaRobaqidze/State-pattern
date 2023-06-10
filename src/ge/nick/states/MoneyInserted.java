package ge.nick.states;

import ge.nick.utils.Jukebox;
import ge.nick.utils.MusicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * State of Jukebox when money inserted to machine.
 * After that client can select to play it.
 * Music can be selected randomly aor by hand.
 * Also, can stop it if music already playing.
 * If client stop music it will not get money back.
 * Machine have buttons that call functions by click.
 */

public class MoneyInserted extends State{

    public MoneyInserted(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void playRandomMusic() {

        // To select music randomly.

        System.out.println("Jukebox randomly selecting music.");

        // Set state when music can be selected.
        jukebox.setState(new Selecting(jukebox));

        Random rand = new Random();

        // Playlist of music. Key - Music name, Value - Duration of music.
        final Map<String, Integer> jukeboxPlaylist = jukebox.getPlaylist();

        // List of music names.
        List<String> nameList = new ArrayList<>(jukeboxPlaylist.keySet());

        // Select music randomly from array.
        String songName = nameList.get(rand.nextInt(nameList.size()));

        // Play music.
        this.playMusic(songName, jukeboxPlaylist.get(songName));
    }

    @Override
    public void stopMusic() {

        System.out.println("Music ended. Insert money to select new one.");

        // Set default state when machine wait to insert money.
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void playMusic(String name, Integer musicDuration) {

        System.out.println("Randomly selected and now playing: " + name);

        // Initialize music player.
        MusicPlayer musicPlayer = new MusicPlayer(name, musicDuration);

        // Set music stop trigger.
        musicPlayer.setPlayerCallBack(this::stopMusic);

        // Start playing music. Run thread.
        musicPlayer.start();

        // Set state when machine playing music.
        jukebox.setState(new Playing(jukebox, musicPlayer));
    }

    @Override
    public void selectMusic() {

        System.out.println("Client selecting music.");

        // Set state when music can be selected.
        jukebox.setState(new Selecting(jukebox));
    }
}

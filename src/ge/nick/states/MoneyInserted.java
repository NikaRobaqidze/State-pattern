package ge.nick.states;

import ge.nick.Jukebox;
import ge.nick.utils.MusicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MoneyInserted extends State{

    public MoneyInserted(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void playRandomMusic() {

        System.out.println("Jukebox randomly selecting music.");
        jukebox.setState(new Selecting(jukebox));

        Random rand = new Random();

        final Map<String, Integer> jukeboxPlaylist = jukebox.getPlaylist();

        List<String> nameList = new ArrayList<>(jukeboxPlaylist.keySet());
        String songName = nameList.get(rand.nextInt(nameList.size()));

        this.playMusic(songName, jukeboxPlaylist.get(songName));
    }

    @Override
    public void stopMusic() {

        System.out.println("Music ended. Insert money to select new one.");
        jukebox.setState(new WaitForMoney(jukebox));
    }

    @Override
    public void playMusic(String name, Integer musicDuration) {

        System.out.println("Randomly selected and now playing: " + name);

        MusicPlayer musicPlayer = new MusicPlayer(name, musicDuration);
        musicPlayer.setPlayerCallBack(this::stopMusic);
        musicPlayer.start();

        jukebox.setState(new Playing(jukebox, musicPlayer));
    }

    @Override
    public void selectMusic() {

        System.out.println("Client selecting music.");
        jukebox.setState(new Selecting(jukebox));
    }
}

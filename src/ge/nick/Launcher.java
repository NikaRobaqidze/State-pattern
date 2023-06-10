package ge.nick;

import ge.nick.utils.Jukebox;

import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args) {

        Map<String, Integer> playList = new HashMap<>();

        playList.put("Gym Class Heroes - Stereo Hearts", 3000);
        playList.put("Alexandra Stan - Mr. Saxobeat", 5000);

        Jukebox jukebox = new Jukebox(playList);

        // Stop musical.

        jukebox.insertMoney();
        jukebox.playRandomMusic();
        jukebox.stopMusic();

        // Eject money.

        jukebox.insertMoney();
        jukebox.selectMusic();
        jukebox.ejectMoney();

        // Select and listening music.

        jukebox.insertMoney();
        jukebox.selectMusic();

        String songName = "Gym Class Heroes - Stereo Hearts";
        jukebox.playMusic(songName, playList.get(songName));
    }
}
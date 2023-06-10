/**
 * @Author: Nika Robaqidze
 * @Email: nika42568@gmail.com

 * Scenario:
 * Jukebox machine that take money and play music.
 * It has work states. Each step of work have state.
 * Machine work steps:
 * - Inserting money;
 * - Selecting music;
 * - Play/stop music;
 */

package ge.nick;

import ge.nick.utils.Jukebox;

import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args) {

        // Playlist to set into Jukebox.
        Map<String, Integer> playList = new HashMap<>();

        // 'Installing' musics.
        playList.put("Some music name - Author name", 3000);
        playList.put("Example name - John Doe", 5000);

        // Initialize Jukebox machine.
        Jukebox jukebox = new Jukebox(playList);

        // Scenario: Stop musical.

        jukebox.insertMoney();
        jukebox.playRandomMusic();
        jukebox.stopMusic();

        // Scenario: Eject money.

        jukebox.insertMoney();
        jukebox.selectMusic();
        jukebox.ejectMoney();

        // Scenario: Select and listening music.

        jukebox.insertMoney();
        jukebox.selectMusic();

        // Music name that client select.
        String songName = "Example name - John Doe";

        // Start playing selected by hand music.
        jukebox.playMusic(songName, playList.get(songName));
    }
}
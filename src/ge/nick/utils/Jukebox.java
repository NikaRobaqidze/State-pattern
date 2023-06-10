package ge.nick.utils;

import ge.nick.states.State;
import ge.nick.states.WaitForMoney;

import java.util.Map;

/**
 * Class that represent Jukebox machine.
 * There described all allowed functions.
 * All actions that can execute it.
 */

public class Jukebox {

    // State of work with default state.
    private State state = new WaitForMoney(this);

    // Music map Key - Music name, Value - playing duration.
    protected Map<String, Integer> playlist;

    // Parametric constructor to install playlist.
    public Jukebox(Map<String, Integer> playlist) {
        this.playlist = playlist;
    }

    // To get installed playlist.
    public Map<String, Integer> getPlaylist() {
        return playlist;
    }

    // To set state of Jukebox work.
    public void setState(State state) {
        this.state = state;
    }

    // To get state of Jukebox work.
    public State getState() {
        return state;
    }

    // To insert money into machine.
    public void insertMoney() { this.state.insertMoney(); }

    // To eject money and stop music on machine.
    public void ejectMoney(){ this.state.ejectMoney(); }

    // To start play selected music on machine.
    public void playMusic(String name, Integer musicDuration) { this.state.playMusic(name, musicDuration); }

    // To start play randomly selected music on machine.
    public void playRandomMusic() { this.state.playRandomMusic(); }

    // To select music.
    public void selectMusic() { this.state.selectMusic(); }

    // To stop music.
    public void stopMusic() { this.state.stopMusic(); }

    @Override
    public String toString() {
        return "Jukebox{" +
                "state=" + state +
                ", playlist=" + playlist +
                '}';
    }
}

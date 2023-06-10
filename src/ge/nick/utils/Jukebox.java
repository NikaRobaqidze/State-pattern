package ge.nick.utils;

import ge.nick.states.State;
import ge.nick.states.WaitForMoney;

import java.util.Map;

public class Jukebox {

    private State state = new WaitForMoney(this);

    protected Map<String, Integer> playlist;

    public Jukebox(Map<String, Integer> playlist) {
        this.playlist = playlist;
    }

    public State getState() {
        return state;
    }

    public Map<String, Integer> getPlaylist() {
        return playlist;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertMoney() { this.state.insertMoney(); }

    public void ejectMoney(){ this.state.ejectMoney(); }

    public void playMusic(String name, Integer musicDuration) { this.state.playMusic(name, musicDuration); }

    public void playRandomMusic() { this.state.playRandomMusic(); }

    public void selectMusic() { this.state.selectMusic(); }

    public void stopMusic() { this.state.stopMusic(); }

    @Override
    public String toString() {
        return "Jukebox{" +
                "state=" + state +
                ", playlist=" + playlist +
                '}';
    }
}

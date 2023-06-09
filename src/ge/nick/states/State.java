package ge.nick.states;

import ge.nick.Jukebox;

abstract public class State {

    protected Jukebox jukebox;

    public State(Jukebox jukebox){ this.jukebox = jukebox; }

    public void insertMoney() {}

    public void ejectMoney(){}

    public void playMusic(String name, Integer musicDuration) {}

    public void playRandomMusic() {}

    public void selectMusic() {}

    public void stopMusic() {}
}

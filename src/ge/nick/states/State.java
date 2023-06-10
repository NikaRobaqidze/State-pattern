package ge.nick.states;

import ge.nick.utils.Jukebox;

/**
 * Class that described all opportunities of Jukebox.
 * Required functions will override in state to set allowed actions.
 * Class must be initialized in state class to use it.
 */

abstract public class State {

    // Jukebox machine.
    protected Jukebox jukebox;

    // Parametric constructor to set machine.
    public State(Jukebox jukebox){ this.jukebox = jukebox; }

    // To insert money into machine.
    public void insertMoney() {}

    // To eject money and stop music on machine.
    public void ejectMoney(){}

    // To start play selected music on machine.
    public void playMusic(String name, Integer musicDuration) {}

    // To start play randomly selected music on machine.
    public void playRandomMusic() {}

    // To select music.
    public void selectMusic() {}

    // To stop music.
    public void stopMusic() {}
}

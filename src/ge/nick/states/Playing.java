package ge.nick.states;

import ge.nick.utils.Jukebox;

/**
 * Jukebox state when it plays selected music.
 * Client can stop music or eject money.
 * At eject music will stop.
 * Jukebox initialize thread to play music
 * to stop it thread will be killed.
 */

public class Playing extends State{

    // Thread to play music.
    private final Thread playThread;

    public Playing(Jukebox jukebox, Thread playThread) {

        super(jukebox);

        // Set thread for music playing.
        this.playThread = playThread;
    }

    @Override
    public void stopMusic() {

        System.out.println("Music stopped by client. Thanks, Bye...");

        // Set default state when machine wait to insert money.
        jukebox.setState(new WaitForMoney(jukebox));

        // Kill music play thread.
        this.playThread.interrupt();
    }

    @Override
    public void ejectMoney() {

        System.out.println("Client prefer to come money back.");

        // Stop playing music. Call local function.
        this.stopMusic();

        // Kill music play thread.
        this.playThread.interrupt();

        System.out.println("Roll back money.");
    }
}

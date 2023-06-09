package ge.nick.states;

import ge.nick.Jukebox;

public class Playing extends State{

    private Thread playThread;

    public Playing(Jukebox jukebox, Thread playThread) {
        super(jukebox);
        this.playThread = playThread;
    }

    @Override
    public void stopMusic() {

        System.out.println("Music stopped by client. Thanks, Bye...");
        jukebox.setState(new WaitForMoney(jukebox));

        this.playThread.interrupt();
    }

    @Override
    public void ejectMoney() {

        System.out.println("Client prefer to come money back.");

        this.stopMusic();
        this.playThread.interrupt();

        System.out.println("Roll back money.");
    }
}

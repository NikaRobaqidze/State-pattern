package ge.nick.states;

import ge.nick.utils.Jukebox;

/**
 * Jukebox default state when machine is
 * waiting to insert money and start to work.
 */

public class WaitForMoney extends State{

    public WaitForMoney(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void insertMoney() {

        System.out.println("Client has inserted money.");

        // State when money inserted to Jukebox.
        jukebox.setState(new MoneyInserted(jukebox));
    }
}

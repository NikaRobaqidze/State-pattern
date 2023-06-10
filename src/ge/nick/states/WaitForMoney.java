package ge.nick.states;

import ge.nick.utils.Jukebox;

public class WaitForMoney extends State{

    public WaitForMoney(Jukebox jukebox) {
        super(jukebox);
    }

    @Override
    public void insertMoney() {

        System.out.println("Client has inserted money.");
        jukebox.setState(new MoneyInserted(jukebox));
    }
}

public class Tiles {

    boolean haveMine = false;
    int numberOfMinesCloseBy = 0;
    boolean flag = false;

// Constructor

    public Tiles (boolean haveMine, int numberOfMinesCloseBy, boolean flag){

        this.haveMine = haveMine;
        this.numberOfMinesCloseBy = numberOfMinesCloseBy;
        this.flag = flag;
    }

    public void setBomb(){
        this.haveMine = true;
    }

// Methods







}

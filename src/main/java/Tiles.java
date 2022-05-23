public class Tiles {

    boolean haveMine = false;
    int numberOfMinesCloseBy = 0;
    boolean flag = false;
    boolean revealTile = false;

// Constructor

    public Tiles (boolean haveMine, int numberOfMinesCloseBy, boolean flag){

        this.haveMine = haveMine;
        this.numberOfMinesCloseBy = numberOfMinesCloseBy;
        this.flag = flag;
        this.revealTile = false;
    }

    public void setBomb(){
        this.haveMine = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    // Methods







}

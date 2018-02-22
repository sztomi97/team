public class Field
{
    private Field neighbours[] = new Field[4];
    private int id;
    private Movable movableItem;

    boolean moveTo(Movable m, int dir){                         //kivalasztja a megfelelo szomszedot es meghivja a
        if(neighbours[dir] == null)                             //moveHere() metodusat
            return false;                                       //

       // System.err.println("f1");                               //
        return (neighbours[dir].moveHere(this, m, dir));  //
    }

    boolean moveTo(Wall w, int dir){
        return false;
    }


    boolean moveHere(Field from, Movable m, int dir){
        if(movableItem != null) {

            if (m.isPlayer() && movableItem.isPlayer()) //player tolna playert
            {
                return false;
            }

            if (!movableItem.move(dir) && !movableItem.isPlayer())//ha a hatralevo lepesek valamelyike false-al ter vissza
                return false;// és NEM player van a mezőn akkor továbbadja

        }
        //különben felulírja a mezot es kitorli a cuccot az elozo mezorol
        this.movableItem = m;
        m.onField = this;
        from.movableItem = null;
        return true;
    }

    void setMovableItem(Movable m){
        movableItem = m;
        m.onField = this;
    }

    Field(int id){
        this.id = id;
    }

    void addNeighbour(Field f, int dir){
        neighbours[dir] = f;
    }

    void printMovable() {
        if (movableItem != null) {
            System.out.print(movableItem.toString());
        }
        else {
            System.out.print(".");
        }
    }
}

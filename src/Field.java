public class Field
{
    private Field neighbours[] = new Field[4];
    private int id;
    private Movable movableItem;

    boolean moveTo(Player p, int dir){                         //kivalasztja a megfelelo szomszedot es meghivja a
        if(neighbours[dir] == null)                             //moveHere() metodusat
            return false;                                       //
        //
        return (neighbours[dir].moveHere(this, p, dir));  //
    }

    boolean moveTo(Movable m, int dir){                         //kivalasztja a megfelelo szomszedot es meghivja a
        if(neighbours[dir] == null)                             //moveHere() metodusat
            return false;                                       //
                               //
        return (neighbours[dir].moveHere(this, m, dir));  //
    }

    boolean moveTo(Wall w, int dir){
        return false;
    }

    boolean moveHere(Field from, Player m, int dir) {
        if (movableItem != null) {
            if (movableItem.isPlayer()) //player tolna playert{
                return false;


            if (!movableItem.move(dir)) {//ha a hatralevo lepesek valamelyike false-al ter vissza
                return false;// és NEM player van a mezőn akkor továbbadja
            }
        }
        //különben felulírja a mezot es kitorli a cuccot az elozo mezorol
        changeItem(m, from);
        return true;
    }

    boolean moveHere(Field from, Movable m, int dir){
        if(movableItem != null) {
            if (!movableItem.move(dir) && !movableItem.isPlayer())//ha a hatralevo lepesek valamelyike false-al ter vissza
                return false;// és NEM player van a mezőn akkor továbbadja
        }
        //különben felulírja a mezot es kitorli a cuccot az elozo mezorol
        changeItem(m, from);
        return true;
    }

    void changeItem(Movable m, Field from){
        this.movableItem = m;
        m.onField = this;
        from.removeMovableItem(movableItem, true);

    }



    void removeMovableItem(Player p, boolean toDie){
            p.die();
        movableItem = null;
    }

    void removeMovableItem(Movable p, boolean toDie){
        movableItem = null;
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

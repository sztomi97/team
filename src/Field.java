public class Field
{
    private Field neighbours[] = new Field[4];
    private int id;
    private Movable movableItem;


    /*moveTo-bol azert kell ketto hogy a moveHereben meg lehessen különböztetni az erkezo Playert a Boxtol
    * ezt beszeljuk meg mert ha hasznalhatunk getNeighbourt akkor felesleges az egesz
    */

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

    /*
    moveHere arra valo hogy az elozo fielrol atvegye az objektumot

    ha player jön, le van kezelve hogy ha player all a mezon akkor nem tud idejonni a masik
     */

    boolean moveHere(Field from, Player p, int dir) {
        if (movableItem != null) {
            if (movableItem.isPlayer())     //player tolna playert, visszamegy a false vegig
                return false;


            if (!movableItem.move(dir)) {   //ha a hatralevo lepesek valamelyike false-al ter vissza
                return false;               //akkor továbbadja
            }
        }
        //különben felulírja a mezot es kitorli a cuccot az elozo mezorol
        changeItem(p, from);
        return true;
    }

    /*
    itt pedig ha Box jon, es player all a mezon (tehat nem ment el, mert nem tudott), akkor szarja le es menjen ra es rip
    az isPlayer helyett ki kene talalni vmit, mert ki fognak nevetni minket(engem) :D
     */
    boolean moveHere(Field from, Movable m, int dir){
        if(movableItem != null) {
            if (!movableItem.move(dir) && !movableItem.isPlayer())  //ha a hatralevo lepesek valamelyike false-al ter vissza
                return false;                                       // és NEM player van a mezőn akkor továbbadja
        }                                                           // ha doboz jön, és player áll itt, az azt jelenti hogy nem tudott tovább menni tehát rip
        //különben felulírja a mezot es kitorli a cuccot az elozo mezorol
        changeItem(m, from);
        return true;
    }

    void changeItem(Movable m, Field from){         //
        if(movableItem!= null)                      //ha maradt a mezőn valami, az tuti jatekos, es rip
            movableItem.die();
        this.movableItem = m;
        m.onField = this;                           //ezt setOnField()-el kell majd
        from.removeMovableItem();                   //az elozo mezo elengedi a movable cuccot
    }



    void removeMovableItem(){
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

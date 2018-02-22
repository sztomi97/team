public class Player extends Movable {
    @Override
    public String toString(){
        return "o";
    }

    @Override
    public boolean move(int dir){
        return onField.moveTo(this, dir);
        //System.err.println("p");
        //return true;                   // azért true mert ha elakad, attól még át tudják tolni rajta a ládát és r.i.p.
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    public void die(){
        System.err.println("rip");
    }
}

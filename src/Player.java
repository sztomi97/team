public class Player extends Movable {
    @Override
    public String toString(){
        return "o";
    }

    @Override
    public boolean move(int dir){       //egyelore ennek igy semmi ertelme, de hatha kell majd kezelgetni valamit ezert overrideoltam
        return super.move(dir);
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void die(){
        System.err.println("rip");
    }
}

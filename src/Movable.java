public abstract class Movable extends FieldElement {

    public boolean move(int dir){
        return onField.moveTo(this, dir);
    }

    public void die(){
        System.out.println("rip");
        return;
    }

    public abstract boolean isPlayer();
}

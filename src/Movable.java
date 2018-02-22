public abstract class Movable extends FieldElement {

    public boolean move(int dir){
        return onField.moveTo(this, dir);
    }

    public abstract boolean isPlayer();
}

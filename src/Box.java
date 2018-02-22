public class Box extends Movable {
    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}

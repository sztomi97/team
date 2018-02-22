public class Wall extends Movable {

    @Override
    public boolean move(int dir) {

        return onField.moveTo(this, dir);
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public String toString(){
        return "W";
    }
}

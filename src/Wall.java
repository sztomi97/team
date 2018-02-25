public class Wall extends Movable {

    @Override
    public boolean move(int dir) {

        return false;
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

public class Box extends Movable {
    @Override
    public String toString(){
        return "B";
    }

    boolean helyen = false;

    @Override
    public boolean move(int dir){   //ha jo helyen van nem akar mozogni, kulonben de
        if(helyen)
            return false;
        return super.move(dir);
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}

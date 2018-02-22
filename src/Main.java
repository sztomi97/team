public class Main {

    final int N = 8;

    Field[] fields = new Field[N*N];

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
    }

    Main() throws InterruptedException {

        for (int i = 0; i < fields.length; i++)
            fields[i] = new Field(i);

        for (int i = 0; i < fields.length; i++) {
            if (i < N * (N - 1)) {
                fields[i].addNeighbour(fields[i + N], 2);
            }
            if (i > N - 1) {
                fields[i].addNeighbour(fields[i - N], 0);
            }
            if (i % N != N - 1) {
                fields[i].addNeighbour(fields[i + 1], 1);
            }
            if (i % N != 0) {
                fields[i].addNeighbour(fields[i - 1], 3);
            }
        }

        Player p = new Player();
        fields[0].setMovableItem(p);

        Player p2 = new Player();
        fields[3].setMovableItem(p2);

        Box b = new Box();
        fields[2].setMovableItem(b);


        Box b2 = new Box();
        fields[10].setMovableItem(b2);

        Box b3 = new Box();
        fields[4].setMovableItem(b3);
        Box b4 = new Box();
        fields[17].setMovableItem(b4);
        Box b5 = new Box();
        fields[30].setMovableItem(b5);
        Box b6 = new Box();
        fields[55].setMovableItem(b6);


        Wall w = new Wall();
        fields[6].setMovableItem(w);

        Wall w2 = new Wall();
        fields[20].setMovableItem(w2);

        Wall w3 = new Wall();
        fields[23].setMovableItem(w3);

        Wall w4 = new Wall();
        fields[44].setMovableItem(w4);
        // for(Field f : fields){
        //     f.printMovable();
        //
        System.out.println("asd");

        int[] moves = {
                1, 1, 1, 1, 2, 2, 1, 3, 0, 3, 2, 2, 1, 1, 1, 0
        };

        int i = 0;
        while (true) {
            printField();
            p.move(moves[i]);
            if (++i >= moves.length)
                i = 0;

            Thread.sleep(500);

            System.out.println(moves[i]);
        }
    }

    void printField(){
        System.out.print('\n');
        System.out.print('\n');
        System.out.print('\n');
        System.out.print('\n');

        for(int i = 0; i < N*N; i++) {
            System.out.print('\t');
            fields[i].printMovable();
            if(i % N == N-1)
                System.out.print('\n');
        }
    }
}

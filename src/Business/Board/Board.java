package Business.Board;

import java.util.ArrayList;

public class Board {
    public static final int MAX_PLAYER = 4;        // maximum 4 players
    public static final int MAX_FIELD = 68;        // 68 fields, without stairs and homes
    public static final int MAX_HOMEFIELD = 4;     // 4 homefields
    public static final int MAX_STAIR = 7;         // 7 stairfields
    public static final int MAX_PIECE = 4;         // maximum 4 pieces

    private ArrayList<Field> fields = new ArrayList<Field>(MAX_FIELD);
    private ArrayList<ArrayList<Home>> homes = new ArrayList<ArrayList<Home>>(MAX_PLAYER);
    private ArrayList<ArrayList<Stair>> stairs = new ArrayList<ArrayList<Stair>>(MAX_PLAYER);
    private ArrayList<Heaven> heaven = new ArrayList<Heaven>(1);

    public Board() {
        for (int i = 0; i < MAX_FIELD; i++) {

            // TODO: banks must be implemented here

            fields.add(i, new Field());
        }

        heaven.add(new Heaven());

        for (int p = 0; p < MAX_PLAYER; p++) {
            // create home fields
            homes.add(p, new ArrayList<Home>(MAX_HOMEFIELD));
            for (int h = 0; h < MAX_HOMEFIELD; h++) {
                homes.get(p).add(h, new Home());
            }

            // create stairs fields
            stairs.add(p, new ArrayList<Stair>(MAX_STAIR));
            for (int s = 0; s < MAX_STAIR; s++) {
                stairs.get(p).add(s, new Stair());
            }
        }
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Home> getHomeByPlayerID(int id) {
        return homes.get(id);
    }

    public ArrayList<Stair> getStairsByPlayerID(int id) {
        return stairs.get(id);
    }

    public ArrayList<Heaven> getHeaven() {
        return heaven;
    }

    @Override
    public String toString() {
        return "Board{" +
                "homes=" + homes +
                ", fields=" + fields +
                ", stairs=" + stairs +
                ", heaven=" + heaven +
                '}';
    }
}

class Pokemon {
    class Ability {

    }

    class Move {
        private String name;
        private

    }

    enum Type {
        ELECTRIC,
        WATER,
        PSYCHIC,
        GHOST,
        DARK,
        FIRE,
        GRASS,
        FLYING
    }

    List<Ability> abilities;
    List<Move> moves;

    public Pokemon() {
        this.abilities = new ArrayList<>();
        this.moves = new ArrayList<>();
    }

    public Pokemon(List<Ability> abilities, List<Move> moves) {
        this.abilities = abilities;
        this.moves = moves;
    }
}
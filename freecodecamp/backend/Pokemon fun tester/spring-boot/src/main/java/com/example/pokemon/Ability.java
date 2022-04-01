class Ability {
    private String name;
    private PokemonType type;

    public Ability(String name, PokemonType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }
}
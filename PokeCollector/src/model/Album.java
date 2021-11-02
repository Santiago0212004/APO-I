package model;

public class Album{

    private String region;
    private int pokemonQuantity;
    private Pokemon albumPokemon;
    private Map regionMap;

    public Album(String region, int pokemonQuantity, Pokemon albumPokemon, Map regionMap){
        this.region = region;
        this.pokemonQuantity = pokemonQuantity;
        this.albumPokemon = albumPokemon;
        this.regionMap = regionMap;
    }

    


}
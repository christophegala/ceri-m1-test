package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;

/**
 * Factory implementation of IPokemonFactory.
 * 
 * @author cg
 */
public class PokemonFactory implements IPokemonFactory {

	/**
	 * Creates a pokemon instance computing it IVs.
	 * 
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
	{
		PokemonMetadata pokemonmetadata =  pokemonMetadataProvider().getPokemonMetadata(index);
		int iv = new CalculatorIV().getIv(tmp.getName(), cp, hp, dust);
        return new Pokemon(index,
        		pokemonmetadata.getName(),
        		pokemonmetadata.getAttack(),
        		pokemonmetadata.getDefense(),
        		pokemonmetadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                iv);
	}
}

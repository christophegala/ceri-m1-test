package fr.univavignon.pokedex.api.implementation;


import fr.univavignon.pokedex.api.*;

/**
 * Factory implementation of IPokedexFactory.
 * 
 * @author cg
 */
public class PokedexFactory implements IPokedexFactory {

	/**
	 * Creates a new pokedex instance using the given 
	 * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>. 
	 * 
	 * @param metadataProvider Metadata provider the created pokedex will use.
	 * @param pokemonFactory Pokemon factory the created pokedex will use.
	 * @return Created pokedex instance.
	 */
	@Override
	IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory)
	{
		return new Pokedex(metadataProvider, pokemonFactory);
	}
	
}

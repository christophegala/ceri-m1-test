package fr.univavignon.pokedex.api.implementation;


import fr.univavignon.pokedex.api.*;

/**
 * Factory interface for class that aims to create IPokedex instance.
 * 
 * @author cg
 */
public interface IPokedexFactory {

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

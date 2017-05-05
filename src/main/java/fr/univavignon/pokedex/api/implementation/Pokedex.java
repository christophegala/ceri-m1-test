package fr.univavignon.pokedex.api.implementation;

import java.util.Comparator;
import java.util.List;
import java.io.Serializable;
import fr.univavignon.pokedex.api.*;

/**
 * Pokedex implementation of IPokedex.
 * 
 * @author cg
 */
public class Pokedex implements IPokedex, Serializable {
	
	private List<Pokemon> pokemons;
	private IPokemonMetadataProvider metadataprovider;
	private IPokemonFactory pokemonFactory;
	
	public Pokedex()
	{
		
	}
	
	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory)
	{
		this.metadataprovider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
	}
	/**
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 */
	@Override
	public int size()
	{
		return pokemons.size();
	}
	
	/**
	 * Adds the given <tt>pokemon</tt> to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 */
	@Override
	public int addPokemon(Pokemon pokemon)
	{
		if(pokemons.size()<151)
		{
			pokemons.add(pokemon);
			return pokemons.size()-1;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * Locates the pokemon identified by the given <tt>id</tt>.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given <tt>index</tt> is not valid.
	 */
	@Override
	public Pokemon getPokemon(int id) throws PokedexException
	{
		return pokemons.get(id);
	}
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
	@Override
	public List<Pokemon> getPokemons()
	{
		return pokemons;
	}

	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <tt>order</tt>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order)
	{
		List<Pokemon> ordered=pokemons;
		ordered.sort(order);
		return ordered;
	}
}

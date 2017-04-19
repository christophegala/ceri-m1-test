package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {
	public PokemonMetadata pokemonmetadata=new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	public PokemonMetadata pokemonmetadata2=new PokemonMetadata(133, "Aquali", 186, 168, 260);
	public Pokemon poke1=new Pokemon(pokemonmetadata.getIndex(), pokemonmetadata.getName(), pokemonmetadata.getAttack(), pokemonmetadata.getDefense(), pokemonmetadata.getStamina(),
									0, 613, 64, 4000, 4);
	public Pokemon poke2=new Pokemon(pokemonmetadata2.getIndex(), pokemonmetadata2.getName(), pokemonmetadata2.getAttack(), pokemonmetadata2.getDefense(), pokemonmetadata2.getStamina(),
									133, 2729, 202, 5000, 4);
	@Mock private IPokedex pokedex;
	@Mock private IPokemonMetadataProvider metadataprovider;
	
	@Test
	public void addPokemon()
	{
		assertEquals(pokedex.addPokemon(poke1), 0);
		assertEquals(pokedex.addPokemon(poke2), 133);
	}
	
	@Test
	public void getPokemon() throws PokedexException
	{
		assertEquals(pokedex.getPokemon(0), poke1);
		assertEquals(pokedex.getPokemon(133), poke2);
	}
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokedex.addPokemon(poke1)).thenReturn(0);
		Mockito.when(pokedex.addPokemon(poke2)).thenReturn(133);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(poke1);
		Mockito.when(pokedex.getPokemon(133)).thenReturn(poke2);
	}
}

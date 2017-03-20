package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonMetadataProviderTest {
	public PokemonMetadata poke1=new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	public PokemonMetadata poke2=new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
	@Mock private IPokemonMetadataProvider poketest;
	
	@Test
	public void Equal() throws PokedexException
	{
		assertEquals(poketest.getPokemonMetadata(0), poke1);
		assertEquals(poketest.getPokemonMetadata(133), poke2);
	}
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(poketest.getPokemonMetadata(0)).thenReturn(this.poke1);
		Mockito.when(poketest.getPokemonMetadata(133)).thenReturn(this.poke2);
	}
}

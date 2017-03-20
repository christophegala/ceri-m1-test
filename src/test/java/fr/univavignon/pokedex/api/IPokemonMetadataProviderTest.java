package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
}

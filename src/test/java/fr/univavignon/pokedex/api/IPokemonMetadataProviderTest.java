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
		assertEquals(poketest.getPokemonMetadata(0).getIndex(), poke1.getIndex());
		assertEquals(poketest.getPokemonMetadata(0).getName(), poke1.getName());
		assertEquals(poketest.getPokemonMetadata(0).getAttack(), poke1.getAttack());
		assertEquals(poketest.getPokemonMetadata(0).getDefense(), poke1.getDefense());
		assertEquals(poketest.getPokemonMetadata(0).getStamina(), poke1.getStamina());
		
		assertEquals(poketest.getPokemonMetadata(133).getIndex(), poke2.getIndex());
		assertEquals(poketest.getPokemonMetadata(133).getName(), poke2.getName());
		assertEquals(poketest.getPokemonMetadata(133).getAttack(), poke2.getAttack());
		assertEquals(poketest.getPokemonMetadata(133).getDefense(), poke2.getDefense());
		assertEquals(poketest.getPokemonMetadata(133).getStamina(), poke2.getStamina());
	}
	
	@Test (expected=PokedexException.class)
	public void min() throws PokedexException
	{
		poketest.getPokemonMetadata(-1);
	}
	
	@Test (expected=PokedexException.class)
	public void max() throws PokedexException
	{
		poketest.getPokemonMetadata(151);
	}
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(poketest.getPokemonMetadata(0)).thenReturn(this.poke1);
		Mockito.when(poketest.getPokemonMetadata(133)).thenReturn(this.poke2);
		Mockito.when(poketest.getPokemonMetadata(-1)).thenThrow(new PokedexException("min=0"));
		Mockito.when(poketest.getPokemonMetadata(151)).thenThrow(new PokedexException("max=150"));
	}
}

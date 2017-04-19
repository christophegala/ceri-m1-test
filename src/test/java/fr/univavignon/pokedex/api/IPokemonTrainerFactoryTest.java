package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {
	@Mock private IPokemonTrainerFactory pokemontrainerfactory;
	@Mock private PokemonTrainer pokemontrainer;
	@Mock private IPokedex pokedex;
	@Mock private IPokedexFactory pokedexfactory;
	
	@Test
	public void createTrainer()
	{
		assertEquals(pokemontrainerfactory.createTrainer("chris", Team.MYSTIC, pokedexfactory), pokemontrainer);
	}
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemontrainerfactory.createTrainer("chris", Team.MYSTIC, pokedexfactory)).thenReturn(pokemontrainer);
	}
}

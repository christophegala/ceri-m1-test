package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {
	@Mock private IPokemonTrainerFactory pokemontrainerfactory;
	@Mock private IPokedexFactory pokedexfactory;
	@Mock private IPokemonMetadataProvider metadataprovider = Mockito.mock(IPokemonMetadataProvider.class);
	@Mock private IPokemonFactory pokemonfactory = Mockito.mock(IPokemonFactory.class);
	
	public PokemonTrainer pokemontrainer=new PokemonTrainer("chris", Team.MYSTIC, pokedexfactory.createPokedex(metadataprovider, pokemonfactory));
	
	
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

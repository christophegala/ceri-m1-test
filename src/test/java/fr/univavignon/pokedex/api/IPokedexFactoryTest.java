package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {

	@Mock private IPokedex pokedex;
	@Mock private IPokedexFactory pokedexfactory;
	@Mock private IPokemonMetadataProvider metadataprovider;
	@Mock private IPokemonFactory pokemonfactory; 

	@Test
	public void createPokedex()
	{
		assertEquals(pokedexfactory.createPokedex(metadataprovider, pokemonfactory), pokedex);
	}

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokedexfactory.createPokedex(metadataprovider, pokemonfactory)).thenReturn(pokedex);
	}
}

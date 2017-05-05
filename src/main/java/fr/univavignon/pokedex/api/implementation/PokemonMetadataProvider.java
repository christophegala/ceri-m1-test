package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;
import org.apache.commons.io.*;
import org.json.*;
import java.io.*;
import java.net.*;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 * 
 * @author cg
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	private static final String url = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	private static JSONArray json;
	private static  final String pokemonname = "Identifier";
	private static  final String pokemonattaque = "BaseAttack";
	private static  final String pokemondefense = "BaseDefense";
	private static  final String pokemonstamina = "BaseStamina";

	public PokemonMetadataProvider() throws IOException
	{
	    getJson();
	}

	private void setJson() throws IOException
	{
	    try (InputStream is = new URL(url).openStream())
	    {
	        json = new JSONArray(IOUtils.toString(is, "UTF-8"));
	    }
	}

	/**
	* Retrieves and returns the metadata for the pokemon
	* denoted by the given <tt>index</tt>.
	*
	* @param index Index of the pokemon to retrieve metadata for.
	* @return Metadata of the pokemon.
	* @throws PokedexException If the given <tt>index</tt> is not valid.
	*/
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
	    if (index > -1 && index < 151)
	    {
	    	try
	    	{
		        JSONObject jsonobject = json.getJSONObject(index);
		        if (jsonobject != null)
		        {
		           return new PokemonMetadata(index, jsonobject.getString(pokemonname), jsonobject.getInt(pokemonattaque), jsonobject.getInt(pokemondefense), jsonobject.getInt(pokemonstamina));
		        }
		        return null;
		        }
	    	catch (JSONException e)
	    	{
		        return null;
		    }
	    }
	    else return null;
	}
}

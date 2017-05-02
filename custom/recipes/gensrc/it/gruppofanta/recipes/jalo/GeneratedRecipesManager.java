/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2-mag-2017 17.50.44                         ---
 * ----------------------------------------------------------------
 */
package it.gruppofanta.recipes.jalo;

import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import it.gruppofanta.recipes.constants.RecipesConstants;
import it.gruppofanta.recipes.jalo.Food;
import it.gruppofanta.recipes.jalo.Recipe;
import it.gruppofanta.recipes.jalo.RecipeEntry;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>RecipesManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRecipesManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public Food createFood(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RecipesConstants.TC.FOOD );
			return (Food)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Food : "+e.getMessage(), 0 );
		}
	}
	
	public Food createFood(final Map attributeValues)
	{
		return createFood( getSession().getSessionContext(), attributeValues );
	}
	
	public Recipe createRecipe(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RecipesConstants.TC.RECIPE );
			return (Recipe)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Recipe : "+e.getMessage(), 0 );
		}
	}
	
	public Recipe createRecipe(final Map attributeValues)
	{
		return createRecipe( getSession().getSessionContext(), attributeValues );
	}
	
	public RecipeEntry createRecipeEntry(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RecipesConstants.TC.RECIPEENTRY );
			return (RecipeEntry)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating RecipeEntry : "+e.getMessage(), 0 );
		}
	}
	
	public RecipeEntry createRecipeEntry(final Map attributeValues)
	{
		return createRecipeEntry( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return RecipesConstants.EXTENSIONNAME;
	}
	
}

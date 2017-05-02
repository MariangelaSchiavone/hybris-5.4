/**
 *
 */
package it.gruppofanta.recipes.interceptors;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import it.gruppofanta.recipes.model.RecipeModel;


/**
 * @author Luca Tiso
 *
 */
public class AddTimePrepareInterceptor implements PrepareInterceptor<RecipeModel>
{

	public static final int TIME = 10;

	@Override
	public void onPrepare(final RecipeModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		if (arg0 != null)
		{
			arg0.setTime(Integer.valueOf(arg0.getTime().intValue() + TIME));
		}

	}

}

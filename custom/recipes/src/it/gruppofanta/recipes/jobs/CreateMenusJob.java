/**
 *
 */
package it.gruppofanta.recipes.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;

import java.util.List;

import org.apache.log4j.Logger;

import it.gruppofanta.recipes.model.MenuModel;
import it.gruppofanta.recipes.model.RecipeModel;


/**
 * @author Luca Tiso
 *
 */
public class CreateMenusJob extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(CreateMenusJob.class);
	private static int noMenu = 1;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		final String queryString = "SELECT {p:" + RecipeModel.PK + "} FROM {" + RecipeModel._TYPECODE + " AS p} ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		final List<RecipeModel> recipes = flexibleSearchService.<RecipeModel> search(query).getResult();
		if (recipes.isEmpty())
		{
			LOG.info("Non ci sono ricette");
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		final MenuModel menu = modelService.create(MenuModel.class);
		menu.setCode("menu" + noMenu);
		menu.setName("menu" + noMenu);
		noMenu++;
		menu.setRecipes(recipes);
		modelService.save(menu);
		LOG.info("Menu creato");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}

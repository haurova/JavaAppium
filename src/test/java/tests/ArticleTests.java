package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickbyArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title!",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    public void testSwipeArticle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickbyArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();

    }

    /** Ex6: Тест: assert title */
    @Test

    public void testAssertTitle()
    {
        String name_of_article = "Foals (band)";

        /* Пропуск онбординга и поиск статьи */
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.skipOnboarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Foals");

        /* Открытие статьи и быстрая проверка на наличие тайтла. Падает, потому что тайтл не успевает загрузиться */
        SearchPageObject.clickbyArticleWithSubstring("Foals (band)");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        assertFalse(
                "No article title found",
                ArticlePageObject.getAmountOfTitlesOnThePage() == 0
        );
    }
}

package Test;

import Base.BaseTest;
import Pages.Page;
import org.junit.Test;

public class ImdbTest extends BaseTest {

    Page checkMovie;

    @Test
    public void ImdbTest() {
        checkMovie= new Page();
        checkMovie.checkMovie();
        checkMovie.checkTheMovieFromSearch();
        checkMovie.photoCheck();

    }


}

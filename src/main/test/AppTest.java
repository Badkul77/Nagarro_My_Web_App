import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nagarro.ourapp.controller.AdditionController;

public class AppTest {
	 AdditionController app = new AdditionController();

	    @Test
	    public void testApp()
	    {
	        assertEquals("Hello world", app.greet("world"));
	    }

	    @Test
	    public void testTrue()
	    {
	        assertTrue( true );
	    }
}

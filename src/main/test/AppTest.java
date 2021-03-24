import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
	    public void testAppData()
	    {
	        assertNotNull(app);
	    }
	    @Test
	    public void testTrue()
	    {
	        assertTrue(app.isValid());
	    	
	    }
	    @Test
	    public void testAgeCalc()
	    {
	   assertEquals("You are 21 Year 2 months and 22 days Old",app.findAge(22, 3, 2021, 31, 12, 1999));
	    }
}

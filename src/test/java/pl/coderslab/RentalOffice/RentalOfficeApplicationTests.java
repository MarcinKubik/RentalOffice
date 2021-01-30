package pl.coderslab.RentalOffice;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.RentalOffice.controller.StartController;
import static org.junit.Assert.*;



@SpringBootTest
public class RentalOfficeApplicationTests {

	//private StartController startController;


	public RentalOfficeApplicationTests() {
	}

	/*@Before
	public void setup(){
		startController = new StartController();
	}*/

	@Test
	public void contextLoads(){
		//assertTrue(startController != null);
	}

}

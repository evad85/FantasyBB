package is.hbv401g.tests;

import static org.junit.Assert.*;
import is.hbv401g.code.user.User;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.mock.RandomNumberOfPlayersMock;

import org.junit.Test;
import is.hbv401g.code.user.UserTeam;
public class UserTest {

	@Test
	public void testBuyPlayerWithRandom() {
		
		double marketValue = 1000;
		
		/*UserTeam randomPlayerMock = new RandomNumberOfPlayersMock();
		int numberOfPlayers = randomPlayerMock.getNumberOfPlayers();
		assertTrue(numberOfPlayers < 16);
		assertFalse(numberOfPlayers >= 16);
		
		User user = new User("Birkir", randomPlayerMock);*/
		
		//valid equivalence classes for budget are x is int,  x >= 1000
		/*assertTrue(user.buyPlayer(1200, marketValue));
		assertTrue(user.buyPlayer(1900, marketValue));
		assertTrue(user.buyPlayer(2340, marketValue));
		assertTrue(user.buyPlayer(10000, marketValue));
		assertTrue(user.buyPlayer(1000, marketValue));
		
		
		
		//invalid equivalence classes for budget are x is not int,  x < 1000
		assertFalse(user.buyPlayer(20, marketValue));
		assertFalse(user.buyPlayer(0, marketValue));
		assertFalse(user.buyPlayer(50, marketValue));
		assertFalse(user.buyPlayer(100, marketValue));
		assertFalse(user.buyPlayer(600, marketValue));
		assertFalse(user.buyPlayer(999, marketValue));*/
		
		
		
		
		
	}

}

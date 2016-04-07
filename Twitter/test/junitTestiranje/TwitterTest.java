package junitTestiranje;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter twitter;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

//	Metoda VratiSvePoruke vraca listu poruka i sluzi za testiranje ostalih metoda
//	i njena implementacija je jednostavna tako da nema potrebe da se testira.
	@Test
	public void testVratiSvePoruke() {
		
	}

	@Test
	public void UnesiSveOk() {
		twitter.unesi("Korisnik twittera", "Nova poruka");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Korisnik twittera");
		tp.setPoruka("Nova poruka");
		
		assertEquals(tp.getKorisnik(), twitter.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals(tp.getPoruka(), twitter.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void UnesiUnetiNullKorisnik() {
		twitter.unesi(null, "Nova poruka");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Korisnik twittera");
		tp.setPoruka("Nova poruka");
		
		assertEquals(tp.getKorisnik(), twitter.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals(tp.getPoruka(), twitter.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void UnesiUnetaNullPoruka() {
		twitter.unesi("Korisnik", null);
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Korisnik twittera");
		tp.setPoruka("Nova poruka");
		
		assertEquals(tp.getKorisnik(), twitter.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals(tp.getPoruka(), twitter.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void UnesiNullKorisnik() {
		twitter.unesi(null, "Nova poruka");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void UnesiNullPoruka() {
		twitter.unesi("Aleksandar", null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void VratiPorukeNullTag() {
		twitter.vratiPoruke(20, null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void VratiPorukePrazanTag() {
		twitter.vratiPoruke(50, "");
	}
	
	@Test
	public void VratiPorukeProveraIndeksaNula() {
		twitter.unesi("Aleksandar", "Dosta bre vise...");
		TwitterPoruka[] porukeTwitter = twitter.vratiPoruke(10, "bre");
		assertEquals("Aleksandar", porukeTwitter[0].getKorisnik());
		assertEquals("Dosta bre vise...", porukeTwitter[0].getPoruka());
	}
	
	@Test
	public void VratiPorukeSveOk() {
		twitter.unesi("Aleksandar", "Dosta bre vise...");
		twitter.unesi("Dragana", "Sta ti je sine?");
		TwitterPoruka[] porukeTwitter = twitter.vratiPoruke(10, "i");
		assertEquals("Aleksandar", porukeTwitter[0].getKorisnik());
		assertEquals("Dosta bre vise...", porukeTwitter[0].getPoruka());
		assertEquals("Dragana", porukeTwitter[1].getKorisnik());
		assertEquals("Sta ti je sine?", porukeTwitter[1].getPoruka());
	}
}

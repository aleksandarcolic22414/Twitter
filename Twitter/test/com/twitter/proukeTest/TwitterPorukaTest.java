package com.twitter.proukeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	TwitterPoruka twitterPoruka;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void SetKorisnikPrazanString() {
		twitterPoruka.setKorisnik("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void SetKorisnikNullString() {
		twitterPoruka.setKorisnik(null);
	}
	
	@Test
	public void SetKorisnikSveOk() {
		twitterPoruka.setKorisnik("Aleksandar Colic");
		assertEquals("Aleksandar Colic", twitterPoruka.getKorisnik());
	}
	
	@Test
	public void GetKorisnikSveOk() {
		String korisnik = twitterPoruka.getKorisnik();
		assertEquals(twitterPoruka.getKorisnik(), korisnik);
	}
	
	@Test
	public void GetKorisnikNull() {
		assertEquals(null, twitterPoruka.getKorisnik());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void SetPorukaPredugackaPoruka() {
		twitterPoruka.setPoruka("Bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla bla bla bla"
				+ " bla bla bla bla bla bla bla bla bla");
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void SetPorukaNullPoruka() {
		twitterPoruka.setPoruka(null);
	}
	
	@Test
	public void SetPorukaSveOk() {
		twitterPoruka.setPoruka("Nova poruka");
		assertEquals("Nova poruka", twitterPoruka.getPoruka());
	}
	

	@Test
	public void GetPorukaSveOk() {
		twitterPoruka.setPoruka("Nova poruka");
		assertEquals("Nova poruka", twitterPoruka.getPoruka());
	}

	

	@Test
	public void testToString() {
		twitterPoruka.setKorisnik("Aca");
		twitterPoruka.setPoruka("Nova poruka");
		assertEquals("KORISNIK:Aca PORUKA:Nova poruka",twitterPoruka.toString());
	}

}

package com.twitter.poruke;

/**
 * Klasa TwitterPoruka sluzi za skladistenje poruke na twitter-u
 * i njenog vlasnika (korisnik).Koristi se u kombinaciji sa
 * klasom Twitter koja cuva twitter poruke kao listu
 * poruka i omogucava razne manipulacije sa njima.
 * 
 * @author Aleksandar Colic 224/14
 */

public class TwitterPoruka {
	
	/** Atribut sluzi za skladistenje imena korisnika */
	private String korisnik;
	/** Atribut koji sadrzi poruku */
	private String poruka;
	/**
	 * Vraca se String korisnik.
	 * @return vrednost atributa korisnik.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja vrednost atributa korisnik na vrednost prosledjenu kao parametar
	 * ako je prosledjeni parametar razlicit od praznog String-a i ako je inicijalizovan. 
	 * 
	 * @param korisnik,Nova vrednost atributa korisnik.
	 * 
	 * @throws java.lang.RuntimeException ako String korisnik nije inicijalizovan ili
	 * ako je njegova vrednost prazan String.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca vrednost atributa poruka.
	 * @return poruka
	 */

//	Greska prilikom implementacije metode getPoruka.
//	Nove vraca se vrednost poruka vec String "poruka"
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Metoda postavlja vrednost atributa poruka na unetu vrednost ako je
	 * duzina unetog String-a manja od 140 i ako je inicijalizovan.
	 * 
	 * @param poruka,Vrednost koju dodeljujemo atributu poruka.
	 * 
	 * @throws java.lang.RuntimeException ukoliko ulazni parametar nije
	 * inicijalizovan ili ukoliko je duzina unetog String-a veca od 140.
	 */
	
//	Greska prilikom implementacije metode setPoruka.
//	Proverava se duzina atributa poruka umesto duzine
//	unesenog parametra poruka
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Redefinisana toString metoda 
	 * @return Vraca se "KORISNIK" + vrednost atributa korisnik + " PORUKA" + vrednost
	 * atributa poruka.
	 */
	
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}

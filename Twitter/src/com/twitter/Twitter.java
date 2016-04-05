package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter se koristi za manipulaciju
 * twitter porukama.Twitter poruke se cuvaju kao
 * lista gde svaki element predstavlja objekat
 * klase Twitter poruka.
 *
 * @author Aleksandar Colic 224/14
 */

public class Twitter {
	/**Atribut poruke koji predstavlja listu poruka*/
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca Listu poruka
	 * 
	 * @return poruke kao listu
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda koja ubacuje novu poruku u listu poruka
	 * 
	 * @param korisnik , nova vrednost atributa korisnik
	 * @param poruka , nova vrednost atributa poruka
	 */
	
//	setKorisnik metoda postavlja vrednost atributa korisnik na "korisnik"
//	bez obzira sta se prosledi ka parametar.
//	Otklonili smo gresku.
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda nalazi poruke koje sadrze odgovarajuci tag i upisuje ih u niz TwitterPoruka[].
	 * Ukoliko je vrednost atributa max <= 0 , max se postavlja na 100.
	 * 
	 * @param maxBroj , maksimalni broj unetih poruka
	 * @param tag , vrednost taga preko kojeg se pretrazuju poruke
	 * @throws java.lang.RuntimeException ukoli je vrednost parametra tag
	 * <ul> 
  	 * 		<li>null</li>
 	 * 		<li>prazan String</li>
 	 * </ul>
	 * @return niz poruka 
	 */
	
//	Prva poruka se ubacuje na drugo mesto u nizu tako da ne bi doslo do
//	izuzetka moramo ispraviti ovu metodu.
//	Takodje brojac moze da ide do maxBroj vrednosti zato sto je niz
//	inicijalizovan na maxBroj elemenenata
	
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac <= maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 

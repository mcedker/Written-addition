package dodawaniepisemne;

import java.util.Scanner;

class dodawanie {
	int WynJed;
	int WynDzies;
	int WynSet;
	int WynTys;
	static int przeniesienie =0;
	int DodJed(int jed1,int jed2) {
		int WynJed=jed1+jed2;
		if(WynJed>=10)
			 przeniesienie = 1;
		return WynJed; 
	}
	int DodDzies(int dzies1,int dzies2) {
		int WynDzies=dzies1+dzies2+przeniesienie;
		if(WynDzies>=10)
			przeniesienie = 1;
		else 
			przeniesienie = 0;
		return WynDzies;
	}
	int DodSet(int set1, int set2) {
		int WynSet=set1+set2+przeniesienie;
		if(WynSet>=10)
			przeniesienie = 1;
		else 
			przeniesienie = 0;
		return WynSet;
	}
	int DodTys(int tys1, int tys2) {
		int WynTys=tys1+tys2+przeniesienie;
		return WynTys;
	}
}


class liczba {
	int tysiace;
	int setki;
	int dziesiatki;
	int jednosci;
	int WylJedn(int i) {
		jednosci=i%10;
		return jednosci;	
	}
	int WylDzies(int i) {
		dziesiatki=(i%100-jednosci)/10;
		return dziesiatki;
	}
	int WylSetki(int i) {
		setki=(i%1000-dziesiatki-jednosci)/100;
		return setki;
	}
	int WylTys(int i) {
		tysiace=(i%10000-setki-dziesiatki-jednosci)/1000;
		return tysiace;
	}
}

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Wprowadz pierwsza liczbe (0>9999)");
		int liczba1=input.nextInt();
		System.out.println("Wprowadz druga liczbe (0>9999)");
		int liczba2=input.nextInt();
		System.out.println("Wprowadziles "+liczba1+" oraz "+liczba2);
		liczba licz1=new liczba();
		licz1.jednosci=licz1.WylJedn(liczba1);
		licz1.dziesiatki=licz1.WylDzies(liczba1);
		licz1.setki=licz1.WylSetki(liczba1);
		licz1.tysiace=licz1.WylTys(liczba1);
		
		
		liczba licz2=new liczba();
		licz2.jednosci=licz2.WylJedn(liczba2);
		licz2.dziesiatki=licz1.WylDzies(liczba2);
		licz2.setki=licz2.WylSetki(liczba2);
		licz2.tysiace=licz2.WylTys(liczba2);
		
		dodawanie dod1=new dodawanie();
		dod1.WynJed=dod1.DodJed(licz1.jednosci, licz2.jednosci);
		dod1.WynDzies=dod1.DodDzies(licz1.dziesiatki,licz2.dziesiatki);
		dod1.WynSet=dod1.DodSet(licz1.setki, licz2.setki);
		dod1.WynTys=dod1.DodTys(licz1.tysiace, licz2.tysiace);
		
		System.out.println("     "+licz1.tysiace+licz1.setki+licz1.dziesiatki+licz1.jednosci);
		System.out.println("    +"+licz2.tysiace+licz2.setki+licz2.dziesiatki+licz2.jednosci);
		System.out.println("    _____");
		System.out.println("    "+dod1.WynTys+dod1.WynSet+dod1.WynDzies+dod1.WynJed);
		
	}

}



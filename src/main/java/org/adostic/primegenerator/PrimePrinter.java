package org.adostic.primegenerator;

public class PrimePrinter {

	public static void main(String[] args) {
		final int THOUSAND = 1000;
		final int RR = 50;
		final int CC = 4;
		final int WW = 10;
		final int ORDMAX = 30;

		int prostiBrojevi[] = new int[THOUSAND + 1];
		int mult[] = new int[ORDMAX + 1];

		int trenutniProstiBroj = 1;
		int brojPronadenihProstihBrojeva=1;
		prostiBrojevi[1] = 2;
		int squere = 9;
		boolean jPrime=true;
		int ord = 2;

		while (brojPronadenihProstihBrojeva < THOUSAND) {
			do {
				trenutniProstiBroj = getIduciProstiBroj(trenutniProstiBroj);
				if (trenutniProstiBroj == squere) {
					ord = ord + 1;
					squere = prostiBrojevi[ord] * prostiBrojevi[ord];
					mult[ord - 1] = trenutniProstiBroj;
				}
				int N = 2;
				jPrime = true;
				while (N < ord && jPrime) {
					while (mult[N] < trenutniProstiBroj) {
						mult[N] = mult[N] + prostiBrojevi[N] + prostiBrojevi[N];
					}
					if (mult[N] == trenutniProstiBroj)
						jPrime = false;
					N = N + 1;
				}
			} while (!jPrime);
			brojPronadenihProstihBrojeva += 1;
			prostiBrojevi[brojPronadenihProstihBrojeva] = trenutniProstiBroj;
		}
		{
			int pageNumber = 1;
			int pageOffset = 1;
			while (pageOffset <= THOUSAND) {
				System.out.println("The First " + THOUSAND +
						" Prime Numbers --- Page " + pageNumber);
				System.out.println("");
				for (int rowOffset = pageOffset; rowOffset < pageOffset + RR; rowOffset++){
					for (int C = 0; C < CC;C++)
						if (rowOffset + C * RR <= THOUSAND)
							System.out.format("%10d", prostiBrojevi[rowOffset + C * RR]);
					System.out.println("");
				}
				System.out.println("\f");
				pageNumber = pageNumber + 1;
				pageOffset = pageOffset + RR * CC;
			}
		}
	}

	private static int getIduciProstiBroj(int trenutniProstiBroj) {
		return trenutniProstiBroj+2;
	}
}

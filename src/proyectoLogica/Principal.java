package proyectoLogica;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	Scanner lectura = null;
        int numCandidatos = 0;
        int numVotantes = 0;
         
        while (true) {
            try {
                System.out.print("Ingrese el número de candidatos: ");
                lectura = new Scanner(System.in);
                numCandidatos = lectura.nextInt();
                if (numCandidatos > 0) break;
                System.out.println("Por favor, ingrese un número positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor válido para candidatos.");
                lectura.next();
            }
        }

        while (true) {
            try {
                System.out.print("Ingrese el número de votantes: ");
                lectura = new Scanner(System.in);
                numVotantes = lectura.nextInt();
                if (numVotantes > 0) break;
                System.out.println("Por favor, ingrese un número positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor válido para votantes.");
                lectura.next();
            }
        }

        int[] votos = new int[numCandidatos];

        for (int i = 0; i < numVotantes; i++) {
            int candidato;
            while (true) {
                try {
                    System.out.print("Votante " + (i + 1) + ", elija su candidato (1 a " + numCandidatos + "): ");
                    lectura = new Scanner(System.in);
                    candidato = lectura.nextInt();
                    if (candidato >= 1 && candidato <= numCandidatos) {
                        votos[candidato - 1]++;
                        break;
                    } else {
                        System.out.println("Voto no válido, intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número válido.");
                    lectura.next();
                }
            }
        }

        Integer[] indices = new Integer[votos.length];
        for (int i = 0; i < votos.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(votos[b], votos[a]));

        System.out.println("\nResultados de las elecciones:");
        int lugar = 1;
        for (int i = 0; i < votos.length; i++) {
            if (i > 0 && votos[indices[i]] != votos[indices[i - 1]]) {
                lugar = i + 1;
            }
            System.out.println("Lugar " + lugar + ": Candidato " + (indices[i] + 1) + " con " + votos[indices[i]] + " votos");
        }
    }
}

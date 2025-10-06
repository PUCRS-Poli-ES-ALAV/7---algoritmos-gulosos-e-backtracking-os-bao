import java.util.*;

public class SDM {
    private static int iteracoes = 0;

    public static Set<Integer> sdmGuloso(Interval[] intervalos) {
        iteracoes = 0;
        Set<Integer> X = new HashSet<>();
        
        // Ordena os intervalos pelo tempo de término
        Arrays.sort(intervalos);
        
        int ultimoFim = Integer.MIN_VALUE;
        
        for (Interval intervalo : intervalos) {
            iteracoes++;
            if (intervalo.getInicio() > ultimoFim) {
                X.add(intervalo.getIndice());
                ultimoFim = intervalo.getFim();
            }
        }
        
        return X;
    }

    public static void main(String[] args) {
        // Cria intervalos de teste
        Interval[] intervalos = {
            new Interval(4, 8, 1),
            new Interval(6, 7, 2),
            new Interval(13, 14, 3),
            new Interval(4, 5, 4),
            new Interval(2, 4, 5),
            new Interval(6, 9, 6),
            new Interval(7, 10, 7),
            new Interval(9, 11, 8),
            new Interval(1, 6, 9),
            new Interval(3, 13, 10),
            new Interval(9, 12, 11)
        };

        System.out.println("=== Problema de Escalonamento de Intervalos ===\n");
        
        System.out.println("Intervalos de Entrada:");
        System.out.println("Índice\tInício\tFim");
        System.out.println("-----------------------");
        for (Interval intervalo : intervalos) {
            System.out.printf("%d\t%d\t%d%n", 
                intervalo.getIndice(), 
                intervalo.getInicio(), 
                intervalo.getFim());
        }
        System.out.println();

        Set<Integer> resultado = sdmGuloso(intervalos);
        
        System.out.println("Intervalos Selecionados:");
        System.out.println("Índice\tInício\tFim");
        System.out.println("-----------------------");
        for (Interval intervalo : intervalos) {
            if (resultado.contains(intervalo.getIndice())) {
                System.out.printf("%d\t%d\t%d%n", 
                    intervalo.getIndice(), 
                    intervalo.getInicio(), 
                    intervalo.getFim());
            }
        }
        System.out.println();
        
        System.out.print("Vetor solução X: [");
        for (int i = 0; i < intervalos.length; i++) {
            System.out.print(resultado.contains(i + 1) ? "1" : "0");
            if (i < intervalos.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        
        System.out.println("\nEstatísticas:");
        System.out.printf("- Número total de intervalos: %d%n", intervalos.length);
        System.out.printf("- Intervalos selecionados: %d%n", resultado.size());
        System.out.printf("- Número de iterações: %d%n", iteracoes);
    }
}


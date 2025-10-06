public class Interval implements Comparable<Interval> {
    private int inicio;
    private int fim;
    private int indice;

    public Interval(int inicio, int fim, int indice) {
        this.inicio = inicio;
        this.fim = fim;
        this.indice = indice;
    }

    public int getInicio() { return inicio; }
    public int getFim() { return fim; }
    public int getIndice() { return indice; }

    @Override
    public int compareTo(Interval outro) {
        return Integer.compare(this.fim, outro.fim);
    }

    @Override
    public String toString() {
        return String.format("Intervalo %d: (%d, %d)", indice, inicio, fim);
    }
}

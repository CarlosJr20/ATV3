package index;
// package Index ;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Index {
    private int[][] Matriz;
    private int quantidade;
    private Scanner input;
    private int VerticesIs;
    private int VerticesCont;


    public Index(Scanner seach) {
        this.input = seach;
        this.lineIndex();
        
    }
    private void lineIndex() {
        this.VerticesCont = Integer.parseInt(this.input.nextLine());
        this.quantidade = Integer.parseInt(this.input.nextLine());
        this.Matriz = new int[this.VerticesCont][this.quantidade];

        this.Matriz = setAdjacencyMatrixValues(this.Matriz, this.input);
        this.VerticesIs = isolatedVerticesCounter();
    }
    private int[][] setAdjacencyMatrixValues(int[][] adjacencyMatriz, Scanner seach) {
        while (seach.hasNextLine()) {
            String line = seach.nextLine();
            String[] array = line.split(" ");
            int originVertice = Integer.parseInt(array[0]);
            int destineVertice = Integer.parseInt(array[1]);
            adjacencyMatriz[originVertice][destineVertice] = 1;
        }
        return adjacencyMatriz;
    }
    private int isolatedVerticesCounter() {
        boolean isIsolatedVertice;
        int conte = 0;
        for (int i = 0; i < this.Matriz.length; i++) {
            isIsolatedVertice = true;
            for (int j = 0; j < this.Matriz.length; j++) {
                if (this.Matriz[i][j] == 1 || this.Matriz[j][i] == 1)
                    isIsolatedVertice = false;
            }
            if (isIsolatedVertice == true)
                conte++;
        }
        return conte;
    }
    public void getEntryDegree() {
        int conte = 0;
        for (int i = 0; i < this.Matriz.length; i++) {
            System.out.print("Entrada " + i + "= ");
            for (int j = 0; j < this.Matriz.length; j++) {
                if (this.Matriz[j][i] != 0)
                    conte++;
            }
            System.out.println(conte);
            conte = 0;
        }
    }
    public int[][] getAdjacencyMatrix() {
        return this.Matriz;
    }
    public int getVerticesQuantity() {
        return VerticesCont;
    }
    public int getIsolatedVertices() {
        return VerticesIs;
    }
    public int getEdgesQuantity() {
        return quantidade;
    }
}

package index;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Index Index;
        int[][] adjacencyMatrix;
        int edgesQuantity, verticesQuantity, isolatedVertices;
        Index = new Index(readFile());
        adjacencyMatrix = Index.getAdjacencyMatrix();
        edgesQuantity = Index.getEdgesQuantity();
        verticesQuantity = Index.getVerticesQuantity();
        isolatedVertices = Index.getIsolatedVertices();
        System.out.println();
        showAdjacencyMatrix(adjacencyMatrix);
        System.out.println();
        System.out.println("Ordem do gráfico: " + edgesQuantity);
        System.out.println("Tamanho do gráfico: " + verticesQuantity);
        System.out.println("Grau de entrada de todos os vértices: ");
        Index.getEntryDegree();
        System.out.println();
        System.out.println("Número de vértices isolados: " + isolatedVertices);
        System.out.println("Em um grafo direcionado, o número de vértices das extremidades é nulo");
    }
    private static void showAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static Scanner readFile() throws FileNotFoundException {
        String seach = "index\\src\\pequenoG.txt";
        FileReader reader = new FileReader(seach);
        return new Scanner(reader).useDelimiter("\\n");
    }
}


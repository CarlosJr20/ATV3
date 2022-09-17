package index;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

class Atv3 {
		public static void main(String[] args) throws Exception  {
			
			Index Index;
			
			int edgesQuantity, verticesQuantity, isolatedVertices;
			Index = new Index(readFile());
			int[][] adjacencyMatrix = Index.getAdjacencyMatrix();
			edgesQuantity = Index.getEdgesQuantity();
			verticesQuantity = Index.getVerticesQuantity();
			isolatedVertices = Index.getIsolatedVertices();

 
		    int distancias[] = buscaLateral(edgesQuantity, adjacencyMatrix, isolatedVertices);
		    System.out.println("Início: " + edgesQuantity);
		    System.out.println("Fim: " +  adjacencyMatrix);
			System.out.println("Menor distância do início ao fim: " + distancias[isolatedVertices]);
		}
 
		public static int[] buscaLateral(int inicio, int[][] adjacencyMatrix, int edgesQuantity){
 
			int[] nivel = new int[edgesQuantity];
			Queue<Integer> fila = new LinkedList<Integer>();
 
			// Inicialinzando nivel de todos os vértices como -1
			for(int i=0; i<8; i++)
				nivel[i]=-1;
 
			// O nível do vértice inicial é zero
			nivel[edgesQuantity] = 0;
			fila.add(edgesQuantity);
 
			// Executando a busca lateral
			while(!fila.isEmpty()){
				int atual = fila.remove();
				for(int i = 0; i < 8; i++)
					if(ma(atual, i, adjacencyMatrix) == 1 && nivel[i] == -1){
						nivel[i] = nivel[atual] + 1;
						fila.add(i);
					}
			}
 
			return nivel;
		}
 
		public static int ma(int i, int j, int[][] ma){
			if(i < j)
				return ma[i][j];
			else
				return ma[j][i];
		}
		private static Scanner readFile() throws FileNotFoundException {
			String seach = "index\\src\\pequenoG.txt";
			FileReader reader = new FileReader(seach);
			return new Scanner(reader).useDelimiter("\\n");
		}
 
}
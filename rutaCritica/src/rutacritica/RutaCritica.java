/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rutacritica;
import java.util.Scanner;
/**
 *
 * @author Chema
 */
public class RutaCritica {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int fil=0;
       Scanner in=new Scanner(System.in);
       System.out.println("Num_Act:");
       fil=in.nextInt();
       String datos[][]=new String[fil][3];
       String ida[][]=new String[fil][2];
       String vuelta[][]=new String[fil][2];
       datos=llenarMatriz(fil);
       mostrar(datos,fil);
       ida=llenarIda(datos,fil);
       mostrarIda(ida,fil);
       String fin=identificaFin(datos,fil);
       System.out.print("\n las actividades que llegan a fin son:"+ fin +"\n");
       int mayor=mayorVuelta(ida,fin,fil);
    }
    //***************************************************************************************
    
     public static String[][] llenarMatriz(int fil){
         Scanner in=new Scanner(System.in);
         String datos[][]=new String[fil][3];
         for(int i=0;i<fil;i++){
             System.out.print("Actividad: "+(i+1)+"\n");
             for(int j=0;j<3;j++){
                 datos[i][j]=in.next();
             }
         }
         return datos;
     }
     public static void mostrar(String datos[][],int fil){
         for(int i=0;i<fil;i++){
             for(int j=0;j<3;j++){
                 System.out.print(datos[i][j]+"\t");
             }
             System.out.print("\n");
         }
     }
     public static String[][] llenarIda(String datos[][],int fil){
         //esta funcion llena la matriz [fil] x [2] con las sumas de ida 
         String ida[][]=new String[fil][2];
         for(int i=0;i<fil;i++){
             if(datos[i][2].equals("-")){
                 ida[i][0]="0";
                 ida[i][1]=datos[i][1];
             }
             else{
                 
                String prec=datos[i][2];
                int tam=prec.length();
                int valor=1;
                for(int s=0;s<tam;s++){//este for hace la busqueda de las precedencias segun el numero de estas que sean
                    char c=prec.charAt(s);
                    for(int r=0;r<i;r++){//este for busca las precedencias de la posicion que esta hacia atras
                        //****************************************************************************************
                        if(c==datos[r][0].charAt(0) && Integer.parseInt(ida[r][1])>valor){//busca si la precedencia c es igual a la actividad datos[r][0]
                            valor=Integer.parseInt(ida[r][1]);
                        }
                    }
                }
                 ida[i][0]=Integer.toString(valor);
                 ida[i][1]=Integer.toString(valor+Integer.parseInt(datos[i][1]));
                }
         }
         return ida;
     }
     public static void mostrarIda(String ida[][],int fil){
          System.out.print("\n ESTA TABLA MUESTRA LAS SUMAS DE IDA \n");
         for(int i=0;i<fil;i++){
             for(int j=0;j<2;j++){
                 System.out.print(ida[i][j]+"\t");
             }
             System.out.print("\n");
         }
     }
     public static String identificaFin(String datos[][],int fil){
     //esta funcion detecta las actividades que llegan al fin
         String precedencias="";
         String fin="";
         for(int i=0;i<fil;i++){
             precedencias+=datos[i][2];
         }
         int tam=precedencias.length();
         for(int k=0;k<fil;k++){
             int cont=0;
             char c=datos[k][0].charAt(0);
             for(int h=0;h<tam;h++){
                 if(c==precedencias.charAt(h)){
                     cont++;
                 }
                 }
             if(cont==0){fin+=c;}
         }
         return fin;
     }
     //esta funcion detecta el numero mayor que llega al fin para hacer las operaciones correspondientes
     public static int  mayorVuelta(String ida[][],String fin,int fil){
     int tam=fin.length();
     for(int i=0;i<tam;i++){
         int valor=0;
         for(int j=0;j<fil;j++){
             
         }
     }
         return 0;
     }
}


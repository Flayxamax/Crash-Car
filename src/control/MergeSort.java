/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Usuario;

/**
 *
 * @author Flayxamax
 */
public class MergeSort {
    /**
     * Divide en dos mitades el vector que se da por parametro hasta que el 
     * vector se quede de tamaño 1
     * @param arr Arreglo que se quiere ordenar
     * @param left Limite izquierdo del arreglo
     * @param right Limite derecho del arreglo
     */
    public void sort(Usuario arr[], int left, int right){
        if(left < right){    //1
          //Encuentra el punto medio del vector.
          int middle = (left + right) / 2;//4

          //Divide la primera y segunda mitad (llamada recursiva).
          sort(arr, left, middle); //5 * log(n)
          sort(arr, middle+1, right); //6 * log(n)

          //Une las mitades.
          merge(arr, left, middle, right); //(21n + 19) * log(n)
        }
    }
    /**
     * Método que crea los arreglos resultantes al dividir uno en 2
     * @param arr Arreglo que se dividira
     * @param left Limite izquierdo del arreglo 1
     * @param middle Limite derecho del arreglo 1
     * @param right Limite derecho del arreglo 2
     */
    public void merge(Usuario arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;//4
        int n2 = right - middle;//3

        //Vectores temporales.
        Usuario leftArray[] = new Usuario [n1]; //2
        Usuario rightArray[] = new Usuario [n2];//2

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {//1, n, n
            leftArray[i] = arr[left+i]; //2n
        }
        for (int j=0; j < n2; j++) {//1, n, n
            rightArray[j] = arr[middle + j + 1];//3n
        }
        /* Une los vectorestemporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;//4

        //Índice inicial del sub-vector arr[].
        int k = left;//2

        //Ordenamiento.
        while (i < n1 && j < n2) {//n
            if (leftArray[i].getPuntuacion() <= rightArray[j].getPuntuacion()) {//n
                arr[k] = leftArray[i];//n
                i++;//n
            } else {
                arr[k] = rightArray[j];//n
                j++;//n
            }
            k++;//n
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {//n
            arr[k] = leftArray[i];//n
            i++;//n
            k++;//n
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {//n
            arr[k] = rightArray[j];//n
            j++;//n
            k++;//n
        }
    }
}

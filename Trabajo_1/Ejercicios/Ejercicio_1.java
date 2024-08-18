package Trabajo_1.Ejercicios;

public class Ejercicio_1 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 4, 13};
        System.out.println("La suma de los elementos del arreglo es: " + sumaArreglo(arr));
    }

    public static int sumaArreglo(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
        return suma;
    }
}


/*
int suma_arreglo(int arr[], int size) {
    int suma = 0;
    for (int i = 0; i < size; i++) {
        suma += arr[i];
    }
    return suma;
}

int main() {
    int arr[] = {10, 20, 50, 4, 13};
    int size = sizeof(arr) / sizeof(arr[0]);
    cout << "La suma de los elementos del arreglo es: " << suma_arreglo(arr, size) << endl;
    return 0;
}
*/


/*
def suma_arreglo(arr):
        return sum(arr)

arr = [10, 20, 50, 4, 13]
print(f"La suma de los elementos del arreglo es: {suma_arreglo(arr)}")
*/

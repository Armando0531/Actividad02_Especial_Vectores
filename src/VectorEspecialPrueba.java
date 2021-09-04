import java.util.Arrays;
import java.util.Scanner;

class VectorEspecial{
	
	private int vector[];
	Scanner input = new Scanner(System.in);
	
	public VectorEspecial() {
		
	}
	public VectorEspecial(int tamaño) {
		this.vector = new int[tamaño];
	}
	
	public int[] getVector(){
		return this.vector;
	}
	public void setVector(int[] edades){
		this.vector = vector;
	}
	
	public void llenarVector() {
		for (int i = 0; i < vector.length; i++) {
			System.out.println("ingresa la calificacion "+(i+1)+": ");
			vector[i]=this.validacionEntero();
		}
	}
	public void mostrarVector() {
		System.out.println(Arrays.toString(vector));
	}
	public int obtenerPosicionInicio() {
		return this.vector[0];
	}
	public int obtenerPosicionFin() {
		return this.vector[this.vector.length-1];
	}
	public int obtenerCantidadElementos() {
		return this.vector.length;
	}
	public void mostrarElementoInicio() {
		System.out.println(this.vector[0]);
	}
	public void mostrarElementoFin() {
		System.out.println(this.vector[this.vector.length-1]);
	}
	public void aumentarTamañoDelArreglo(int tamaño) {
		while (tamaño<1) {
			System.out.println("el tamaño solo puede positivo ingresa el tamaño a aumentar: ");
			tamaño = input.nextInt();
		}
		int[] newArray = Arrays.copyOf(vector, vector.length + tamaño);
		this.setVector(newArray);
		System.out.println("el vector se aumentó "+tamaño);
	}
	public void disminuirTamañoDelArreglo(int magnitud) {
		boolean err=false;
		do {
			err=false;
			try {
				int[] newArray = Arrays.copyOf(vector, vector.length - magnitud);
				this.setVector(newArray);
			} catch (NegativeArraySizeException e) {
				do {
					System.out.println("no se puede disminuir el mismo tamaño o superior, ");
					magnitud=input.nextInt();
					err=true;
					continue;
				} while (magnitud>this.obtenerCantidadElementos());
			}
		} while (err);
		System.out.println("el vector se disminuyó "+magnitud);
	}
	public void insertarElementoPosicionEspecifica(int posicion, int elemento) {
		boolean err=false;
		do {
			err=false;
			try {
				this.getVector()[posicion-1]=elemento;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("posicion: ");
				posicion=this.validacionEntero();
				System.out.println("elemento: ");
				elemento=this.validacionEntero();
				err=true;
			}
		} while (err);
	}
	public void eliminarElementoPosicionEspecifica(int posicion) {
		boolean err=false;
		do {
			err=false;
			try {
				this.getVector()[posicion-1]=0;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("solo se puede tener de 1 a n posiciones, introducir la posicion: ");
				posicion = this.validacionEntero();
				err=true;
			}
		} while (err);
		System.out.println("elemento eliminado exitosamente");
	}
	public void invertirElVector() {
		int[] newArray = Arrays.copyOf(vector, vector.length);
		int edades[]=this.getVector();
		for (int i = 0; i < newArray.length; i++) {
			newArray[i]=edades[edades.length-1-i];
		}
		this.setVector(newArray);
		System.out.println("vector invertido correctamente");
	}

	public int validacionEntero() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("intente de nuevo:");
				input.nextLine();
				err=true;
				continue;
			}
			if (ret>0) {
				err=false;
			}else {
				System.out.println("solo números positivos");
				err=true;
			}
		}while(err);
		return ret;
	}
}
public class VectorEspecialPrueba {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean salir = false;
		byte opc = 0;
		VectorEspecial ve0 = new VectorEspecial();
		System.out.println("tamaño del vector:");
		VectorEspecial ve1 = new VectorEspecial(ve0.validacionEntero());
		
		ve1.llenarVector();
		ve1.mostrarVector();
		
		do {
			System.out.println(" 1)obtener posicion inicio \n 2)obtener posicion fin \n 3)obtener cantidad elementos \n 4)mostrar todo los elementos \n 5)mostrar elemento inicio"
					+ " \n 6)mostrar elemento fin \n 7)aumentar tamaño del arreglo \n 8)disminuir tamaño del arreglo \n 9)insertar elemento posicion especifica "
					+ "\n 10)eliminar elemento posicion especifica \n 11)invertir el vector \n 12)salir");
			
			try {
				opc = input.nextByte();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida");
				input.nextLine();
			}
			if (opc<1||opc>13) {
				System.out.println("opcion no valida");
			}
			
			switch (opc) {
			case 1:	System.out.println(ve1.obtenerPosicionInicio());break;
			case 2:	System.out.println(ve1.obtenerPosicionFin());break;
			case 3:	System.out.println(ve1.obtenerCantidadElementos());break;
			case 4:	ve1.mostrarVector();break;
			case 5:	ve1.mostrarElementoInicio();;break;
			case 6:	ve1.mostrarElementoFin();;break;
			case 7:	
				System.out.println("tamaño a aumentar: ");
				int tamaño = ve0.validacionEntero();
				ve1.aumentarTamañoDelArreglo(tamaño);;break;
			case 8:
				System.out.println("tamaño a disminuir: ");
				int tamaño1 = ve0.validacionEntero();
				ve1.disminuirTamañoDelArreglo(tamaño1);;break;
			case 9:
				System.out.println("posicion: ");
				int posicion = ve0.validacionEntero();
				System.out.println("elemento a insertar: ");
				int elemento = ve0.validacionEntero();
				ve1.insertarElementoPosicionEspecifica(posicion, elemento);
				break;
			case 10:
				System.out.println("elemento a eliminar:");
				int elemento1 = ve0.validacionEntero();
				ve1.eliminarElementoPosicionEspecifica(elemento1);
				break;
			case 11:ve1.invertirElVector();break;
			case 12:salir=true;break;
			default:break;
			}
			
		} while (!salir);
		System.out.println("Fin del programa");

	}

}


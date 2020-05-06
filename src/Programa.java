
/*

Problema de codificación 5.  Valor 15 puntos.

Cree un programa que indique al usuario la cantidad de días que ha vivido hasta la fecha de hoy.


Considere que:

  - El año comercialmente hablando tiene 365 días repartidos en 12 meses que tienen entre 28 y 31 días respectivamente.
  - Cada año bisiesto significa un día adicional en el mes de febrero; así que, el cálculo por desglose de la diferencia entre el año vigente a la fecha y su año de nacimiento sufre alteración por estos días adicionales vividos.  Debe considerar la cantidad de años bisiestos vividos por la persona.
  
Presente al usuario la pantalla para leer su fecha de nacimiento expresada en números enteros.  Calcule la edad del usuario, y la cantidad de días vividos hasta la fecha de hoy. 


Que el usuario pueda repetir el proceso de ingreso de la fecha de nacimiento, para recibir el desglose de días vividos hasta que no desee continuar.

*/
import java.util.Scanner;

public class Programa
{
	public static void main(String[] args)
	{
		DiasVida dv = new DiasVida();
		Scanner sc = new Scanner(System.in);
		String str = "04/08/2000";
		// System.out.println(dv.MesADias(36,2020));
		System.out.print("Ingrese su fecha de Nacimiento: ");
		dv.fechaNac(str);
		str = sc.nextLine();
		if (!dv.fechaNac(str))
		{
			System.out.println("Fecha con formato incorrecto, por favor usar DD/MM/YYYY");
			System.out.println("");
			System.out.println("El programa automaticamente usara: 04/08/2000");
			System.out.println("");
		}
		if (str.length() < 6)
		{
			str = "04/08/2000";
		}
		while (!(str.equals("si")))
		{
			while (!(dv.fechaNac(str)))
			{

				System.out.print("Por favor ingrese su fecha de nacimiento: ");

				str = sc.nextLine();
			}
			System.out.println("Su edad es: " + dv.Edad() + " Anos");
			System.out.println("Ha vivido: " + dv.DiasVividos() + " Dias hasta hoy.");
			while (!(str.equals("si")) && !(str.equals("no")))
			{

				System.out.print("Desea detener el programa?(si o no): ");

				str = sc.nextLine();
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("fin del programa . . . ");
		sc.close();
	}
}

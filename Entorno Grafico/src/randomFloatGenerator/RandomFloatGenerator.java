package randomFloatGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Documentado por Pablo Sánchez Sanviente Contiene metodos para generar valores
 * aleatorios tipo float y comprobar los parámetros insertados por el usuario.
 * 
 * @author vith21
 * @version 2.0
 */
public class RandomFloatGenerator {

	/** Mensaje mostrado si el limite máximo no es más grande que el mínimo */
	static String messageRange = "Max must be higher than Min";
	/** Mensaje mostrado si no hay valores en el rango o en la presición */
	static String messageNoData = "Please, check data to generate numbers";
	/** Objeto aleatorio para generar un valor tipo float */
	static Random random = new Random();

	/**
	 * Genera un valor tipo float aleatorio dentro del rango máximo y mínimo
	 * 
	 * @param min
	 *            valor mínimo
	 * @param max
	 *            valor máximo
	 * @param random
	 *            objeto aleatorio
	 * @return número aleatorio dentro del rango
	 */
	private static float generateRandomNumber(float min, float max,
			Random random) {
		return random.nextFloat() * (max - min) + min;
	}

	/**
	 * Comprueba el rango
	 * 
	 * @param min
	 *            valor mínimo
	 * @param max
	 *            valor máximo
	 * @return nos devuelve un true en caso positivo de ser mayor
	 */
	public static boolean checkRange(float min, float max) {
		if (max > min)
			return true;
		return false;
	}

	/**
	 * Da formato a un número según su presición
	 * 
	 * @param randomNumber
	 *            número aleatorio
	 * @param precision
	 *            presición
	 * @return Devuelve un string diciendo el formato.
	 */
	private static String formatRandomNumber(float randomNumber, int precision) {
		return String.format("%." + precision + "f", randomNumber);
	}

	/**
	 * Devuelve un grupo de números aleatorios tipo float que son tipo String
	 * ahora.
	 * 
	 * @param amount
	 *            cantidad de valores
	 * @param min
	 *            valor mínimo
	 * @param max
	 *            valor máximo
	 * @param precision
	 *            precisión requerida
	 * @return
	 */
	public static String getGroupOfNumbers(int amount, float min, float max,
			int precision) {
		ArrayList<String> al = new ArrayList<String>(amount);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < amount; i++)
			al.add(formatRandomNumber(generateRandomNumber(min, max, random),
					precision));

		for (String string : al) {
			sb.append(string + "\n");
		}
		return sb.toString();
	}

}

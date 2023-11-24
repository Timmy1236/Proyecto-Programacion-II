package capaDatos;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import capaNegocios.MisMetodosDB;

public class Validaciones {
	
	// Validacion de si la tecla pulsada pertenece a los strings
	public static void validarString(KeyEvent letraPulsada) {
		char letra = letraPulsada.getKeyChar();
		
		//  si no es una letra o el espacio o el backspace
		if (!Character.isLetter(letra) && letra!= 32 && letra!=8 ) {
			Toolkit.getDefaultToolkit().beep();
			letraPulsada.consume();
		}
	}
	
	// Validacion en si el textField esta vacio o no.
	public static boolean vacio(JTextField txtdato) {
		if (txtdato.getText().isEmpty()) {
			//ImageIcon miIcono = new ImageIcon(MisMetodosDB.class.getResource("/AgendaImagenes/274e.png"));
			JOptionPane.showMessageDialog(null, "No pueden haber datos vacios ", "Error, de ingreso de datos",
					JOptionPane.PLAIN_MESSAGE);
			txtdato.requestFocus();
			return true;
		}else {
			return false;
		}
	}
	
	// Validacion de si la tecla pulsada pertecene a los numeros.
	public static void validarTelefono(KeyEvent letraPulsada) {
		char letra = letraPulsada.getKeyChar();
		
		//  si no es una número o el espacio o el backspace o el +
		if (!Character.isDigit(letra) && letra!= 32 && letra!=8 && letra!= 43 ) {
			
			Toolkit.getDefaultToolkit().beep();
			letraPulsada.consume();	
		}
	}
	
	// Validacion de si la tecla pulsada pertecene a los numeros.
		public static void validarInt(KeyEvent letraPulsada) {
			char letra = letraPulsada.getKeyChar();
			
			//  Si no es numero:
			if (!Character.isDigit(letra)) {
				
				Toolkit.getDefaultToolkit().beep();
				letraPulsada.consume();	
			}
		}
		
	public static void validarEmail(KeyEvent letraPulsada) {
		char letra=letraPulsada.getKeyChar();
		
		//  si no es una letra o el backspace o el @ o el .
		if (!Character.isLetter(letra) && letra!=8 && letra!= 64 && letra!= 46 ) {
			
			Toolkit.getDefaultToolkit().beep();
			letraPulsada.consume();
		}
	}
	
	// SOURCE: https://github.com/fabdelgado/ciuy
    public static boolean validateCi(String ci) {
        String cleanCi = cleanCi(ci);
        char validationDigit = cleanCi.charAt(cleanCi.length() - 1);

        return Character.getNumericValue(validationDigit) == validationDigit(cleanCi);
    }

    public static String cleanCi(String ci) {
        return ci.replaceAll("[^0-9]", "");
    }

    protected static int validationDigit(String ci) {
        String cleanCi = cleanCi(ci);
        int a = 0;
        String baseNumber = "2987634";
        String addZeros = String.format("%8s", cleanCi).replace(" ", "0");

        for (int i = 0; i < baseNumber.length(); i++) {
            int baseDigit = Character.getNumericValue(baseNumber.charAt(i));
            int ciWithZeros = Character.getNumericValue(addZeros.charAt(i));
            a += (baseDigit * ciWithZeros) % 10;
        }
        return a % 10 == 0 ? 0 : 10 - a % 10;
    }
}

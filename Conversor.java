import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Conversor {
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            // Mostrar el menú principal y obtener la selección del usuario
            String opcion = (String) JOptionPane.showInputDialog(
                null,
                "Menú Principal",
                "Seleccione una opción:",
                JOptionPane.PLAIN_MESSAGE,
                null,
                new String[] { "Conversor de Moneda", "Conversor de Temperatura", "Salir" },
                "Conversor de Moneda"
            );

            if (opcion == null) {
                salir = true;
            } else {
                switch (opcion) {
                    case "Conversor de Moneda":
                        realizarConversionMoneda();
                        break;
                    case "Conversor de Temperatura":
                        realizarConversionTemperatura();
                        break;
                    case "Salir":
                        salirDelPrograma();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.");
                }
            }
        }
    }

    public static void realizarConversionMoneda() {
        boolean continuar = true;
        while (continuar) {
            double cantidad = obtenerCantidadValida();
            if (cantidad == -1) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese una cantidad numérica.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Mostrar el cuadro de diálogo para seleccionar la moneda de conversión
            String[] opcionesMoneda = {
                "Convertir de Pesos Mexicanos a Dólar",
                "Convertir de Pesos Mexicanos a Euros",
                "Convertir de Pesos Mexicanos a Libras Esterlinas",
                "Convertir de Pesos Mexicanos a Yen Japonés",
                "Convertir de Pesos Mexicanos a Won sul-coreano",
                "Convertir de Dólar a Pesos Mexicanos",
                "Convertir de Euros a Pesos Mexicanos",
                "Convertir de Libras Esterlinas a Pesos Mexicanos",
                "Convertir de Yen Japonés a Pesos Mexicanos",
                "Convertir de Won sul-coreano a Pesos Mexicanos"
            };

            String monedaSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la conversión deseada:",
                "Seleccionar Moneda",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMoneda,
                opcionesMoneda[0]
            );

            double resultado = realizarConversionMoneda(cantidad, monedaSeleccionada);

            JOptionPane.showMessageDialog(
                null,
                "El resultado de la conversión es: " + resultado,
                "Resultado de la Conversión",
                JOptionPane.INFORMATION_MESSAGE
            );

            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea realizar otra conversión?",
                "Continuar",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }
    }

    public static double obtenerCantidadValida() {
        while (true) {
            String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad:");

            if (cantidadStr == null) {
                return -1;
            }

            try {
                return Double.parseDouble(cantidadStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese una cantidad numérica.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double realizarConversionMoneda(double cantidad, String monedaSeleccionada) {
        double tipoCambioDólarToMXN = 20.0;
        double tipoCambioEuroToMXN = 23.0;
        double tipoCambioLibraToMXN = 27.0;
        double tipoCambioYenToMXN = 0.18;
        double tipoCambioWonToMXN = 0.018;

        if (monedaSeleccionada.equals("Convertir de Pesos Mexicanos a Dólar")) {
            return cantidad / tipoCambioDólarToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Pesos Mexicanos a Euros")) {
            return cantidad / tipoCambioEuroToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Pesos Mexicanos a Libras Esterlinas")) {
            return cantidad / tipoCambioLibraToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Pesos Mexicanos a Yen Japonés")) {
            return cantidad / tipoCambioYenToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Pesos Mexicanos a Won sul-coreano")) {
            return cantidad / tipoCambioWonToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Dólar a Pesos Mexicanos")) {
            return cantidad * tipoCambioDólarToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Euros a Pesos Mexicanos")) {
            return cantidad * tipoCambioEuroToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Libras Esterlinas a Pesos Mexicanos")) {
            return cantidad * tipoCambioLibraToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Yen Japonés a Pesos Mexicanos")) {
            return cantidad * tipoCambioYenToMXN;
        } else if (monedaSeleccionada.equals("Convertir de Won sul-coreano a Pesos Mexicanos")) {
            return cantidad * tipoCambioWonToMXN;
        } else {
            return 0.0; // Opción no válida
        }
    }

    public static void realizarConversionTemperatura() {
        boolean continuar = true;
        while (continuar) {
            // Mostrar el cuadro de diálogo para seleccionar el tipo de conversión
            String[] opcionesTemperatura = {"Convertir de Celsius a Fahrenheit", "Convertir de Fahrenheit a Celsius"};
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la conversión deseada:",
                "Seleccionar Conversión de Temperatura",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesTemperatura,
                opcionesTemperatura[0]
            );

            if (opcionSeleccionada == null) {
                return; // El usuario canceló la operación
            }

            double temperatura;
            try {
                temperatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura:"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese una temperatura numérica.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double resultado;

            if (opcionSeleccionada.equals("Convertir de Celsius a Fahrenheit")) {
                resultado = (temperatura * 9 / 5) + 32;
            } else {
                resultado = (temperatura - 32) * 5 / 9;
            }

            JOptionPane.showMessageDialog(
                null,
                "El resultado de la conversión es: " + resultado,
                "Resultado de la Conversión de Temperatura",
                JOptionPane.INFORMATION_MESSAGE
            );

            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea realizar otra conversión de temperatura?",
                "Continuar",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }
    }

    public static void salirDelPrograma() {
        JOptionPane.showMessageDialog(null, "Programa Terminado", "Fin del Programa", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

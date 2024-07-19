import java.util.Scanner;

 class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter Program");
        System.out.println("Enter the temperature value:");
        double temperature = scanner.nextDouble();

        System.out.println("Enter the original unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin):");
        String originalUnit = scanner.next().toUpperCase();

        switch (originalUnit) {
            case "C":
                convertFromCelsius(temperature);
                break;
            case "F":
                convertFromFahrenheit(temperature);
                break;
            case "K":
                convertFromKelvin(temperature);
                break;
            default:
                System.out.println("Invalid input. Please enter C, F, or K.");
                break;
        }

        scanner.close();
    }

    public static void convertFromCelsius(double celsius) {
        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;

        System.out.println(celsius + " degrees Celsius is equal to:");
        System.out.println(fahrenheit + " degrees Fahrenheit");
        System.out.println(kelvin + " Kelvin");
    }

    public static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        double kelvin = (fahrenheit + 459.67) * 5 / 9;

        System.out.println(fahrenheit + " degrees Fahrenheit is equal to:");
        System.out.println(celsius + " degrees Celsius");
        System.out.println(kelvin + " Kelvin");
    }

    public static void convertFromKelvin(double kelvin) {
        double celsius = kelvin - 273.15;
        double fahrenheit = kelvin * 9 / 5 - 459.67;

        System.out.println(kelvin + " Kelvin is equal to:");
        System.out.println(celsius + " degrees Celsius");
        System.out.println(fahrenheit + " degrees Fahrenheit");
    }
}
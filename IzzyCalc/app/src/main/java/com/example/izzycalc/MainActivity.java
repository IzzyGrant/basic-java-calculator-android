package com.example.izzycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    // Variable String que sera utilizada para el display de la calculadora.
    static String displaytxt = " ";
    // Variables que determinaran si se escribira punto y operador impidiendo duplicidad.
    static boolean ifOperador, ifDot, minus = false;

    private double operacion(String cadena){ // metodo de clase

        // Regex que convierte el String en un arreglo(llamado split) seccionando numeros y operadores.
        // Ejemplo: "12.6+20" ==> [12.6, +, 20]
        String[] split = cadena.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");

        // en caso de que el primer numero sea negativo se arreglan las posiciones
        // Ejemplo: (si en pantalla se ingreso "-12.6+20") [-, 12.6, +, 20] ==> [-12.6, +, 20, null]
        if("-".equals(split[0])){
            System.out.println("El arreglo contiene el primer numero como negativo : " + Arrays.toString(split));
            split[0] = "-" + split[1];
            split[1] = split[2];
            split[2] = split[3];
            split[3] = null;
            System.out.println("Correccion de arreglo: " +Arrays.toString(split));
        }

        // en caso de que el segundo numero sea negativo se arreglan las posiciones
        // Ejemplo: (si en pantalla se ingreso "12.6+-20") [12.6, +-, 20] ==> [12.6, +, -20]
        if("+-".equals(split[1]) || "--".equals(split[1]) || "*-".equals(split[1]) || "/-".equals(split[1])){
            System.out.println("El arreglo contiene el segundo numero como negativo : " +Arrays.toString(split));
            char operadorDoble = split[1].charAt(0);
            switch(operadorDoble){
                case '+':
                    split[1] = "+";
                    break;
                case '-':
                    split[1] = "-";
                    break;
                case '*':
                    split[1] = "*";
                    break;
                case '/':
                    split[1] = "/";
                    break;
            }
            String aux = split[2];
            split[2] = "-" + aux;
            System.out.println("Correccion de arreglo: " +Arrays.toString(split));
        }

        // Una vez corregidos los arreglos en caso de negativos ahora se traduce el String en double
        // para poder operar los numeros ingresados.
        double a = Double.parseDouble(split[0]); // usando parse
        double b = Double.parseDouble(split[2]); // usando parse

        // Se operan los numeros obtenidos dependiendo del operador solicitado: + ,- ,* , /
        double resultado = 0;
        switch(split[1]){
            case "+":
                resultado = a+b;
                break;
            case "-":
                resultado = a-b;
                break;
            case "*":
                resultado = a*b;
                break;
            case "/":
                resultado = a/b;
                break;
        }
        //double res = a+b; // operando los 2 valores obtenidos del arreglo
        System.out.println(Arrays.toString(split) + "resultado: " + resultado + "|  |  "); // display output
        ifDot = false;

        return resultado; // Devuelve el resultado de la operacion.
    } // Fin de metodo


    // Este metodo revisara mediante Regex las posiciones, la longitud y el contenido que halla dentro del arreglo
    // y retornara un booleano si hay condicion para ello.
    private boolean CheckNeg(String cadena){
        boolean canWrNeg = false;

        // Regex que convierte el String en un arreglo(llamado split) seccionando numeros y operadores.
        // Ejemplo: "12.6+20" ==> [12.6, +, 20]
        String[] arrNeg = cadena.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");
        System.out.println("Inspeccion de negativos: " + Arrays.toString(arrNeg));
        System.out.println("Negativos.length: " + arrNeg.length);

        if(arrNeg.length == 1){
            if(" ".equals(arrNeg[0])){
                System.out.println(">>>Cadena Vacia. Puede escribir negativo");
                canWrNeg = true;
            }
        }

        if (arrNeg.length == 2){
            if("+".equals(arrNeg[1])||"-".equals(arrNeg[1])||"*".equals(arrNeg[1])||"/".equals(arrNeg[1])){
                System.out.println(">>>Se puede escribir negativo");
                canWrNeg = true;
            }
        }
        if(arrNeg.length == 3){
            if("+".equals(arrNeg[2])||"-".equals(arrNeg[2])||"*".equals(arrNeg[2])||"/".equals(arrNeg[2])){
                System.out.println(">>Segundo numero. Puede escribir negativo");
                canWrNeg = true;
            }
        }

        System.out.println("Fin de metodo negativo.");
        return canWrNeg;
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint("SetTextI18n")
    public void multiplicar(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("*");
    }

    @SuppressLint("SetTextI18n")
    public void dividir(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("/");
    }

    @SuppressLint("SetTextI18n")
    public void sumar(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("+");
    }

    @SuppressLint("SetTextI18n")
    public void restar(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("-");
    }

    @SuppressLint("SetTextI18n")
    public void resultado(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("Azul");
    }
    @SuppressLint("SetTextI18n")
    public void teclaAC(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText(" ");
    }

    @SuppressLint("SetTextI18n")
    public void tecla0(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("00");
    }

    @SuppressLint("SetTextI18n")
    public void tecladecimal(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText(".");
    }

    @SuppressLint("SetTextI18n")
    public void tecla1(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("1");
    }

    @SuppressLint("SetTextI18n")
    public void tecla2(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("2");
    }

    @SuppressLint("SetTextI18n")
    public void tecla3(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("3");
    }

    @SuppressLint("SetTextI18n")
    public void tecla4(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("4");
    }

    @SuppressLint("SetTextI18n")
    public void tecla5(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("5");
    }

    @SuppressLint("SetTextI18n")
    public void tecla6(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("6");
    }

    @SuppressLint("SetTextI18n")
    public void tecla7(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("7");
    }

    @SuppressLint("SetTextI18n")
    public void tecla8(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("8");
    }

    @SuppressLint("SetTextI18n")
    public void tecla9(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("9");
    }
}
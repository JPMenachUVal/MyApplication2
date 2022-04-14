package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtResultado;
    private Button btnMostrar;
    private Button btnInvertir;
    private EditText etNombre, etCelular;

    private String nombre;
    private int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        //Configurar el botón para que esté pendiente de un evento en pantalla,
        //en este caso el evento de que un usuario haga click en pantalla.

        /*Parámetro de la función espera que le mandes tu lógica desarrollada que
         quieres que se aplique cuando cada usuario haga click.*/
        btnMostrar.setOnClickListener(this);
        btnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        /*Inicializamos vistas y referenciamos nuestros componentes visuales
        diseñados con los atributos o variables que hemos creado*/
        txtResultado = findViewById(R.id.txtResultado);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnInvertir = findViewById(R.id.btnInvertir);
        etNombre = findViewById(R.id.etNombre);
        etCelular = findViewById(R.id.etCelular);
    }

    private void obtenerValores(){
        //Como obtener los datos que el usuario ingresó al componente de texto:
        nombre = etNombre.getText().toString();//getText trae objeto de tipo
        // editable, SE ARREGLA CON TOSTRING
        //to.String() -> convierte la cadena de texto del campo referenciado
        String celularTexto = etCelular.getText().toString();
        celular = Integer.parseInt(celularTexto);
    }

    private void mostrarTexto(){
        txtResultado.setText("Nombre: " + this.nombre + ", \nCelular: " + this.celular);
    }

    private void invertirNumero(){
        //Invertir número
        //123456 a 654321
        int resto = 0, invertido = 0;
        while (this.celular > 0){
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado.setText("Invertido: "+invertido);
    }

    @Override
    public void onClick(View view) {
        /*
        El parámetro view es un objeto que recibe la información del componente visual que el
        usuario ha presionado en pantalla, si presiona el botón invertir view es igual a ese botón
        y de ese botón u otra vista pueden obtener información como por ejemplo, el atributo que los
        identifica como algo único
        */
        obtenerValores();
        switch (view.getId()) {
            case R.id.btnMostrar:
                mostrarTexto();
                break;
            case R.id.btnInvertir:
                invertirNumero();
                break;
        }
    }
}
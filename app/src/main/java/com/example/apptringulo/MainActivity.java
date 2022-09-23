package com.example.apptringulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Aplicando variaveis a seus respectivos inputs
    EditText sideA,sideB,sideC;
    TextView result;
    Button verify;
    float triângulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Criando as variáveis
        sideA = (EditText) findViewById(R.id.sideInputA);
        sideB = (EditText) findViewById(R.id.sideInputB);
        sideC = (EditText) findViewById(R.id.sideInputC);
        verify = (Button) findViewById(R.id.buttonVerify);
        result = (TextView) findViewById(R.id.textResult);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Convertendo as variaveis dos lados para float
                float numberSideA = Float.parseFloat(sideA.getText().toString());
                float numberSideB = Float.parseFloat(sideB.getText().toString());
                float numberSideC = Float.parseFloat(sideC.getText().toString());


                //Verificando se os lados formam um triângulo
                //Se a soma de dois dos lados forem menor que o terceiro lado não forma um triangulo
                if((numberSideA + numberSideB) > numberSideC && (numberSideA + numberSideC) > numberSideB && (numberSideC + numberSideB)>numberSideA) {
                    //Se os lados forem todos iguais ele é equilatero
                    if(numberSideA == numberSideB && numberSideB == numberSideC){
                        result.setText("Os valores informados formam um triângulo Equilátero");
                    }
                    //Se os lados forem todos diferentes ele é um Escaleno
                    else if(numberSideA != numberSideB && numberSideB != numberSideC && numberSideA != numberSideC){
                        result.setText("Os valores informados formam um triângulo Escaleno");

                    }
                    //Se um dos lados for diferente e dois lados forem iguais é escaleno
                    //Se o Lado A for Igual ao lado B e diferente do lado C e vice-versa
                    else if(numberSideA == numberSideB && numberSideA != numberSideC || numberSideB == numberSideC && numberSideB != numberSideA || numberSideA == numberSideC && numberSideA != numberSideB){
                        result.setText("Os valores informados formam um triângulo Isósceles");
                    }
                }
                //Se não formar um triângulo irá exibir essa mensagem
                else{
                    result.setText("Os valores informados não formam um triângulo");
                }


            }
        });


    }
}
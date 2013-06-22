package com.example.exercito2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	static final double CAFE = 0.020;
	static final double MARGARINA = 0.030;	
	static final double ARROZ = 0.180;
	static final double FEIJAO = 0.120;
	static final double CARNE = 0.400;
	static final double OLEO = 0.030;
	static final double SAL = 0.010;
	static final double MACARRAO = 0.030;
	static final double LEITE = 0.050;
	static final double ACUCAR = 0.080;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void Calcular(View view)
    {
    	TextView resultado= (TextView) findViewById(R.id.viewResultado);
    	EditText txtCafe = (EditText) findViewById(R.id.txtCafe);
		EditText txtAlmoco = (EditText) findViewById(R.id.txtAlmoco);
		EditText txtJantar = (EditText) findViewById(R.id.txtJantar);
    	String resposta = "Quantidade retirada do estoque (em gramas):\n";
    	int pessoasCafe = 0, pessoasAlmoco = 0, pessoasJantar = 0;
    	
    	try
    	{
    		pessoasCafe = Integer.parseInt(txtCafe.getText().toString());
    		pessoasAlmoco = Integer.parseInt(txtAlmoco.getText().toString());
    		pessoasJantar = Integer.parseInt(txtJantar.getText().toString());
    		if (pessoasCafe > 0)
    			resposta += Cafe(pessoasCafe);
    		if (pessoasAlmoco >0 && pessoasJantar >0)
    		{
    			resposta += Almoco(pessoasAlmoco+pessoasJantar);
    			resposta += SomenteJantar(pessoasJantar);
    		}
    		else 
    		{
    			if (pessoasAlmoco > 0)
    				resposta += Almoco(pessoasAlmoco);
    			if (pessoasJantar > 0)
    			{
    				resposta += Jantar(pessoasJantar);    		
    			}
    		}
    		
    		resultado.setText(String.valueOf(resposta));
    	}
    	catch (NumberFormatException ex)
    	{
    		resultado.setText("preencha os campos");
    	}
    	catch (Exception ex)
    	{
    		resultado.setText(ex.getMessage());
    	}
    }    
	String Cafe(int pessoas)
	{
		String resultado = "";
		double totalMarcarina = MARGARINA*pessoas;		
		double totalCafe = CAFE*pessoas;
		resultado = "Quantidade de margarina: " + String.valueOf(totalMarcarina) + "\nQuantidade de café:" + String.valueOf(totalCafe)+"\n";		
		return resultado;
	}
	String Almoco(int pessoas)
	{	
		String resultado = ""; //ARROZ+FEIJAO+CARNE+OLEO+SAL+MACARRAO;
		double totalArroz = ARROZ*pessoas/2;
		double totalFeijao = FEIJAO*pessoas/2;
		double totalCarne = CARNE*pessoas/2;
		double totalOleo = OLEO*pessoas/2;
		double totalSal = SAL*pessoas/2;
		double totalMacarrao = MACARRAO*pessoas/2;
		resultado = "Quantidade de arroz: " + String.valueOf(totalArroz) +
				"\nQuantidade de feijão:" + String.valueOf(totalFeijao)+
				"\nQuantidade de carne:" + String.valueOf(totalCarne)+
				"\nQuantidade de óleo:" + String.valueOf(totalOleo)+
				"\nQuantidade de sal:" + String.valueOf(totalSal)+
				"\nQuantidade de macarrão:" + String.valueOf(totalMacarrao)+
				"\n";
		return resultado;
	}	
	
	String Jantar(int pessoas)
	{
		String resultado = Almoco(pessoas);
		resultado += SomenteJantar(pessoas);
		return resultado;
	}
	String SomenteJantar(int pessoas)
	{
		double totalAcucar = ACUCAR*pessoas/4;
		double totalLeite = LEITE*pessoas/4;
		
		String resultado =
				"Quantidade de açúcar: " + String.valueOf(totalAcucar) +
				"\nQuantidade de leite:" + String.valueOf(totalLeite);
		return resultado;
	}
}

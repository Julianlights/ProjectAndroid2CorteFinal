package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.mvp.Presentador.ProductoPresentador;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements ProductoPresentador.View{
    private ProductoPresentador productoPresentador;
    AsyncHttpClient client = new AsyncHttpClient();
    String token;
    TableLayout table;
    TextView textName;
    EditText txtName;
    TextView textPrecio;
    TextView textdescripcion;
    Button btnShow;

    ArrayList<Integer> Ids = new ArrayList<>();
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Precios = new ArrayList<>();
    ArrayList<String> Descripciones = new ArrayList<>();
    ArrayList<String> TipoProductos = new ArrayList<>();
    ArrayList<String> Proveedores = new ArrayList<>();
    ArrayList<Integer> Statuses = new ArrayList<>();
    ArrayList<String> Folios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        table =  findViewById(R.id.tablelayout);
        txtName = findViewById(R.id.txtName);
        btnShow = findViewById(R.id.btnShow);

        Bundle extra = getIntent().getExtras();
        token = (String) extra.get("token");

        productoPresentador = new ProductoPresentador(this);
        productoPresentador.setDataToken(token);
        productoPresentador.showDatas();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mostrara();
            }
        });
    }


    @Override
    public void sendDataToken(String Token) {
    }

    public void Mostrara()
    {
        Ids = productoPresentador.getIds();
        Names = productoPresentador.getNombres();
        Descripciones = productoPresentador.getDescripciones();
        Precios = productoPresentador.getPrecios();
        Proveedores = productoPresentador.getProveedores();
        TipoProductos = productoPresentador.getTipoProductos();
        Statuses = productoPresentador.getStatuses();
        Folios = productoPresentador.getFolios();
        SelecctUser();
    }




    public void SelecctUser()
    {
        if (token.equals("AquiDebeIrMiTokenPrimer")){
            Token1();
        }else{
            if (token.equals("AquiDebeIrMiOtroTokenxd")){
                Token2();
            }
        }
    }


    public void Token1()
    {
        int NUM_ROWS= Names.size();
        int NUM_COLS= 1;


        for(int i = 0; i<NUM_ROWS; i++){
            TableRow tableRow = new TableRow(getBaseContext());
            table.addView(tableRow);

            for(int j= 0; j<NUM_COLS; j++){
                textName = new TextView(getBaseContext());
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setPadding(60, 40, 60, 25);
                textName.setBackgroundResource(R.color.design_default_color_primary_dark);
                textName.setTextColor(Color.WHITE);

                textPrecio  = new TextView(getBaseContext());
                textPrecio.setPadding(60, 40, 60, 25);
                textPrecio.setBackgroundResource(R.color.design_default_color_primary_dark);
                textPrecio.setTextColor(Color.WHITE);


                textName.setText(Names.get(i));
                textPrecio.setText(Precios.get(i));

                tableRow.addView(textName);
                tableRow.addView(textPrecio);
            }
        }
    }

    public void Token2(){
        int NUM_COLS= 1;
        int NUM_ROWS= Names.size();

        for(int i = 0; i<NUM_ROWS; i++){
            TableRow tableRow = new TableRow(getBaseContext());
            table.addView(tableRow);

            for(int j= 0; j<NUM_COLS; j++){
                final int idDa = i;

                textName = new TextView(getBaseContext());
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setPadding(40, 35, 40, 25);
                textName.setBackgroundResource(R.color.colorPrimaryDark);
                textName.setTextColor(Color.WHITE);

                textPrecio  = new TextView(getBaseContext());
                textPrecio.setPadding(40, 35, 40, 25);
                textPrecio.setBackgroundResource(R.color.colorPrimaryDark);
                textPrecio.setTextColor(Color.WHITE);

                textdescripcion  = new TextView(getBaseContext());
                textdescripcion.setPadding(40, 35, 40, 25);
                textdescripcion.setBackgroundResource(R.color.colorPrimaryDark);
                textdescripcion.setTextColor(Color.WHITE);


                textName.setText(Names.get(i));
                textPrecio.setText(Precios.get(i));
                textdescripcion.setText(Descripciones.get(i));
                tableRow.addView(textName);
                tableRow.addView(textPrecio);
                tableRow.addView(textdescripcion);
            }
        }
    }

}

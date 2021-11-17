package com.iesinfantaelena.practica3;

import android.app.Activity;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calculos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calculos extends Fragment implements View.OnClickListener {
    MaterialButton botonCubo;
    MaterialButton botonEsfera;
    MaterialButton botonParalepipedo;
    MaterialButton calcularCubo;
    MaterialButton calcularEsfera;
    MaterialButton calcularParalepipedo;
    MaterialButton figuraCubo;
    MaterialButton figuraEsfera;
    MaterialButton figuraParalepipedo;
    ConstraintLayout datosCubo;
    ConstraintLayout datosEsfera;
    ConstraintLayout datosParalepipedo;
    EditText lado;
    EditText radio;
    EditText profundidad;
    EditText largo;
    EditText ancho;
    TextView areaCubo;
    TextView volumenCubo;
    TextView areaEsfera;
    TextView volumenEsfera;
    TextView areaParalepipedo;
    TextView volumenParalepipedo;
    WebView pagina;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calculos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calculos.
     */
    // TODO: Rename and change types and number of parameters
    public static calculos newInstance(String param1, String param2) {
        calculos fragment = new calculos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_calculos, container, false);
        definirObjetos(v);
        mostarSeccion();
        calcular();
        cambiarURL();
        return v;
    }
    public void definirObjetos(View v){
        botonCubo= v.findViewById(R.id.botonCubo);
        botonEsfera=v.findViewById(R.id.botonEsfera);
        botonParalepipedo=v.findViewById(R.id.botonParalepipedo);
        calcularCubo=v.findViewById(R.id.calcularCubo);
        calcularEsfera=v.findViewById(R.id.calcularEsfera);
        calcularParalepipedo=v.findViewById(R.id.calcularParalepipedo);
        figuraCubo=v.findViewById(R.id.figuraCubo);
        figuraEsfera=v.findViewById(R.id.figuraEsfera);
        figuraParalepipedo=v.findViewById(R.id.figuraParalepipedo);
        datosCubo=v.findViewById(R.id.datosCubo);
        datosEsfera=v.findViewById(R.id.datosEsfera);
        datosParalepipedo=v.findViewById(R.id.datosParalepipedo);
        lado=v.findViewById(R.id.editLadoCubo);
        radio=v.findViewById(R.id.editRadioEsfera);
        largo=v.findViewById(R.id.editLargoParalepipedo);
        profundidad=v.findViewById(R.id.editProfParalepipedo);
        ancho=v.findViewById(R.id.editAnchoParalepipedo);
        areaCubo=v.findViewById(R.id.AreaCubo);
        volumenCubo=v.findViewById(R.id.VolCubo);
        areaEsfera=v.findViewById(R.id.AreaEsfera);
        volumenEsfera=v.findViewById(R.id.VolEsfera);
        areaParalepipedo=v.findViewById(R.id.AreaParalepipedo);
        volumenParalepipedo=v.findViewById(R.id.VolParalepipedo);
    }
    public void mostarSeccion(){
        botonCubo.setOnClickListener(this);
        botonEsfera.setOnClickListener(this);
        botonParalepipedo.setOnClickListener(this);

    }

    public void calcular(){
        calcularCubo.setOnClickListener(this);
        calcularEsfera.setOnClickListener(this);
        calcularParalepipedo.setOnClickListener(this);
    }

    public void cambiarURL(){
        figuraCubo.setOnClickListener(this);
        figuraEsfera.setOnClickListener(this);
        figuraParalepipedo.setOnClickListener(this);
    }

    public void calcularCubo(){
        double area,volumen,valor1;
        try {
            valor1=Double.parseDouble(lado.getText().toString());
            area=(6*(Math.pow(valor1,2)));
            volumen=Math.pow(valor1,3);
            areaCubo.setText("A="+ area);
            volumenCubo.setText("V=" + volumen);
        }catch (Exception e){
            Toast.makeText(getContext(),"Error: Es necesario introducir un numero",Toast.LENGTH_LONG).show();
        }
    }

    public void calcularEsfera(){
        double area,volumen,valor1;
        try {
            valor1=Double.parseDouble(radio.getText().toString());
            area=(4*Math.PI*(Math.pow(valor1,2)));
            volumen=((4*Math.PI*(Math.pow(valor1,3)))/3);
            area=Math.round(area);
            volumen=Math.round(volumen);
            areaEsfera.setText("A="+ area);
            volumenEsfera.setText("V=" + volumen);
        }catch (Exception e){
            Toast.makeText(getContext(),"Error: Es necesario introducir un numero",Toast.LENGTH_LONG).show();
        }
    }

    public void calcularParalepipedo(){
        double area,volumen,valor1,valor2,valor3;
        try {
            valor1=Double.parseDouble(largo.getText().toString());
            valor2=Double.parseDouble(profundidad.getText().toString());
            valor3=Double.parseDouble(ancho.getText().toString());
            area=(2*valor1*valor2)+(2*valor1*valor3)+(2*valor2*valor3);
            volumen=(valor1*valor2*valor3);
            areaParalepipedo.setText("A="+area);
            volumenParalepipedo.setText("V="+volumen);
        }catch (Exception e){
            Toast.makeText(getContext(),"Error: Es necesario rellenar todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        String url;
        switch (view.getId()){
            case R.id.botonCubo:
                if (!datosCubo.isShown()){
                    datosCubo.setVisibility(View.VISIBLE);
                }
                else{
                    datosCubo.setVisibility(View.GONE);
                }
                break;
            case R.id.botonEsfera:
                if (!datosEsfera.isShown()){
                    datosEsfera.setVisibility(View.VISIBLE);
                }
                else{
                    datosEsfera.setVisibility(View.GONE);
                }
                break;
            case R.id.botonParalepipedo:
                if (!datosParalepipedo.isShown()){
                    datosParalepipedo.setVisibility(View.VISIBLE);
                }
                else{
                    datosParalepipedo.setVisibility(View.GONE);
                }
                break;
            case R.id.calcularCubo:
                calcularCubo();
                break;
            case R.id.calcularEsfera:
                calcularEsfera();
                break;
            case R.id.calcularParalepipedo:
                calcularParalepipedo();
                break;
            case R.id.figuraCubo:
                url="https://es.wikipedia.org/wiki/Cubo";
                conectarWeb(url);
                break;
            case R.id.figuraEsfera:
                url="https://es.wikipedia.org/wiki/Esfera";
                conectarWeb(url);
                break;
            case R.id.figuraParalepipedo:
                url="https://es.wikipedia.org/wiki/Paralelep%C3%ADpedo";
                conectarWeb(url);
                break;

        }
    }
    public void conectarWeb(String url) {
        //Le pasamos a esta actividad el webview del otro fragmento
        Activity ac = (Activity) getActivity();
        assert ac != null;
        WebView pagina = ac.findViewById(R.id.pagina);
        pagina.loadUrl(url);
    }
}
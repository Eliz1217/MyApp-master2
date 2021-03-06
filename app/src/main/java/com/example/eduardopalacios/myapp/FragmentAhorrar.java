package com.example.eduardopalacios.myapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentAhorrar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAhorrar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //SPINNERS
    Spinner Spinner_cuenta, Spinner_cargo, Spinner_años;

    ArrayAdapter <String> adapter;

    //BOTONES
    Button boton_guardar, button_calcular;
    //EditText
    EditText Edittext_meta;
    //TextView
    TextView Textview_cantidad;

    private OnFragmentInteractionListener mListener;



    public FragmentAhorrar() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public  FragmentAhorrar newInstance(String param1, String param2) {
        FragmentAhorrar fragment = new FragmentAhorrar();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_ahorrar, container, false);
        inicializar_componentes(view);

        //Spinners


        String [] contenido_cargo={"1","2","3","6"};
        adapter= new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contenido_cargo);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Spinner_cargo.setAdapter(adapter);


        String [] contenido_tiempo=new String[]{"1", "2", "3"};
        adapter= new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, contenido_tiempo);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Spinner_años.setAdapter(adapter);

        //Botones

        //Boton calcular

        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int cuenta= Integer.parseInt(Spinner_cuenta.getSelectedItem().toString());
                int meta= Integer.parseInt(Edittext_meta.getText().toString());
                int cargo= Integer.parseInt(Spinner_cargo.getSelectedItem().toString());
                int años= Integer.parseInt(Spinner_años.getSelectedItem().toString());
                int meses;
                int res;
                int cantidad = 0;
                switch (años){
                    case 1: meses=12;
                        res= meses/cargo;
                        cantidad= meta/res;
                        break;
                    case 2: meses=24;
                        res= meses/cargo;
                        cantidad= meta/res;
                        break;
                    case 3: meses=36;
                        res= meses/cargo;
                        cantidad= meta/res;
                        break;
                }
                Textview_cantidad.setText(""+cantidad);
            }
        });
        //Boton guardar e ir a la siguiente actividad
        boton_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
                builder.setTitle("DATOS AHORRO");
                builder.setMessage("Â¿Deseas guardar?");

                builder.setPositiveButton("SHI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Ã‘O", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });
                AlertDialog dialog=builder.create();
                dialog.show();

            }
        });




        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }





    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void inicializar_componentes(View view){
        Spinner_cuenta= (Spinner)view.findViewById(R.id.Spinner_cuenta);
        Spinner_cargo= (Spinner)view.findViewById(R.id.Spinner_cargo);
        Spinner_años= (Spinner)view.findViewById(R.id.Spinner_años);
        Edittext_meta=(EditText)view.findViewById(R.id.editText_meta);
        Textview_cantidad=(TextView)view.findViewById(R.id.textView_cantidad);
        button_calcular= (Button)view.findViewById(R.id.button_calc);
        boton_guardar = (Button)view.findViewById(R.id.Button3);
    }
}

package com.example.tarea3fragmentbasico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiFragmento extends Fragment {

    private static final String ARG_TEXTO = "texto";

    private String textoRecibido;
    private TextView textFragment;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MiFragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiFragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static MiFragmento newInstance(String texto) {
        MiFragmento fragment = new MiFragmento();
        Bundle args = new Bundle();
        args.putString(ARG_TEXTO, texto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textoRecibido = getArguments().getString(ARG_TEXTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_mi_fragmento, container, false);
        textFragment = view.findViewById(R.id.textFragment);

        // Establece el texto recibido en el TextView
        if (textoRecibido != null) {
            textFragment.setText(textoRecibido);
        }

        return view;
    }
}
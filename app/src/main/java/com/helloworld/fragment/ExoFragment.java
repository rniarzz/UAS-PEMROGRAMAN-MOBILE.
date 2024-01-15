package com.helloworld.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.helloworld.R;
import com.helloworld.activity.PlayerActivity;

public class ExoFragment extends Fragment {

    private ImageView ExoFragment;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exo, container, false);

        ExoFragment = view.findViewById(R.id.ExoFragment);

        ExoFragment.setOnClickListener(v -> playVideo("exo"));

        return view;
    }

    private void playVideo(String videoFileName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoFileName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), PlayerActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ExoFragment() {
        // Konstruktor publik kosong yang diperlukan
    }

    public static ExoFragment newInstance(String param1, String param2) {
        ExoFragment fragment = new ExoFragment();
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
}

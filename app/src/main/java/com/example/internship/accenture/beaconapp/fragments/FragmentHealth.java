package com.example.internship.accenture.beaconapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship.accenture.beaconapp.R;
import com.example.internship.accenture.beaconapp.model.MotorHealth;
import com.example.internship.accenture.beaconapp.utils.MotorHealthAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oprea.flaviu on 8/14/2017.
 */

public class FragmentHealth extends Fragment {

    RelativeLayout mRelativeLayout;
    private TextView mTitleTextView;
    private ImageView mHealthImageView;
    private TextView mFrequencyTextView;
    private TextView mIsAliveTextView;

    private static final String URL = "http://www.mocky.io/";

    private String title;
    private String isLive;
    private String frequency;
    private String health;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        loadDataRetrofit();

        View view = inflater.inflate(R.layout.fragment_health, container, false);

        mRelativeLayout = view.findViewById(R.id.health_relativeLayout);
        mTitleTextView = view.findViewById(R.id.title_textView);
        mHealthImageView = view.findViewById(R.id.health_imageView);
        mFrequencyTextView = view.findViewById(R.id.frequency_textView);
        mIsAliveTextView = view.findViewById(R.id.isAlive_textView);




        return view;
    }


    private void loadDataRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MotorHealthAPI motorHealthAPI = retrofit.create(MotorHealthAPI.class);
        Call<MotorHealth> call = motorHealthAPI.getData();

        call.enqueue(new Callback<MotorHealth>() {
            @Override
            public void onResponse(@NonNull Call<MotorHealth> call, @NonNull Response<MotorHealth> response) {
                Toast.makeText(getActivity(), "Retrofit Good", Toast.LENGTH_SHORT).show();

                if (response.body() != null) {

                    title = response.body().getAsset();
                    isLive = "Is live: " + response.body().getIsLive();
                    frequency = "Frequency: " + response.body().getFrequency();
                    health = response.body().getHealth();

                    mRelativeLayout.setBackgroundResource(R.drawable.layout_bg);
                    mTitleTextView.setText(title);
                    mFrequencyTextView.setText(frequency);
                    mIsAliveTextView.setText(isLive);

                    if (health.equals("green")) {
                        mHealthImageView.setImageResource(R.drawable.greenimg);
                    }else if(health.equals("red")){
                        mHealthImageView.setImageResource(R.drawable.redimg);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MotorHealth> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), "Retrofit Bad", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

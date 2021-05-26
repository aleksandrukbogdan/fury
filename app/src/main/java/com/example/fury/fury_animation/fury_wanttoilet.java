package com.example.fury.fury_animation;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fury.MainActivity;
import com.example.fury.R;

import static com.example.fury.MainActivity.mediaPlayerHungry;
import static com.example.fury.MainActivity.mediaPlayerWantSleep;
import static com.example.fury.MainActivity.mediaPlayerWantToilet;
import static com.example.fury.MainActivity.mediaPlayerWash;

public class fury_wanttoilet extends Fragment {

    ImageButton btn_fury1;

    ImageView furystandart;
    AnimationDrawable furyfight_animation, furypet_animation, furywantstoilet_animation;
    Handler animation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fury_wanttoilet, container,
                false);

        btn_fury1 = view.findViewById(R.id.btn_fury1);

        btn_fury1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = new Handler();
                animation.post(new Runnable() {
                    @Override
                    public void run() {
                        furystandart = view.findViewById(R.id.furywanttoilet);
                        furystandart.setBackgroundResource(R.drawable.furyfight_animation);
                        furyfight_animation = (AnimationDrawable) furystandart.getBackground();
                        furyfight_animation.start();
                        if(MainActivity.loadedsound){
                            int streamId = MainActivity.soundPool.play(MainActivity.soundFight, (float)0.5, (float)0.5, 1, 0, 1f);
                        }
                    }
                });
                animation.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        furyfight_animation.stop();
                        furystandart = view.findViewById(R.id.furywanttoilet);
                        furystandart.setBackgroundResource(R.drawable.furywantstoilet_animation);
                        furywantstoilet_animation = (AnimationDrawable) furystandart.getBackground();
                        furywantstoilet_animation.start();

                    }
                }, 2000);
            }
        });



        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            furystandart = getView().findViewById(R.id.furywanttoilet);
            furystandart.setBackgroundResource(R.drawable.furywantstoilet_animation);
            furywantstoilet_animation = (AnimationDrawable) furystandart.getBackground();
            furywantstoilet_animation.start();

            if (mediaPlayerHungry != null)
                mediaPlayerHungry.stop();
            if (mediaPlayerWantSleep!= null)
                mediaPlayerWantSleep.stop();
            mediaPlayerWantToilet = MediaPlayer.create(getContext(),R.raw.wanttoilet);
            mediaPlayerWantToilet.setLooping(true);
            mediaPlayerWantToilet.start();

    }
}

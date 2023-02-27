package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton buttonMessage, btn;
    TextView textA, textB;
    CircleImageView civ1, civ2;
    boolean _isOnTextA = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //****************************************************************************
        //Переход в приложение "Сообщения"
        buttonMessage = findViewById(R.id.activity_main__messageButton);
        buttonMessage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("sms:"));
                startActivity(intent);
            }
        });
        //****************************************************************************
        //Инициализаия полей из (**)
        textA = findViewById(R.id.activity_main__your_textview);
        textB = findViewById(R.id.activity_main__text2);
        btn = findViewById(R.id.activity_main__WindowsButton);
        civ1 = findViewById(R.id.activity_main__your_avatar);
        civ2 = findViewById(R.id.activity_main__another_avatar);

        //****************************************************************************
        //Переход на другую активность
        View v = findViewById(R.id.activity_main__groupButton);
        v.setOnClickListener(this);
    }

    //****************************************************************************
    //Поменять плитки участников местами (**)
    public void switchViews(View v) {
        if (_isOnTextA) {
            textA.setText(R.string.long_nickname);
            textB.setText(R.string.short_nickname);
            civ1.setImageResource(R.drawable.frodo);
            civ2.setImageResource(R.drawable.legolas);
            _isOnTextA = false;
        } else {
            textA.setText(R.string.short_nickname);
            textB.setText(R.string.long_nickname);
            civ1.setImageResource(R.drawable.legolas);
            civ2.setImageResource(R.drawable.frodo);
            _isOnTextA = true;
        }
    }

    //****************************************************************************
    //Отключить микрофон
    private boolean isMicOff = false;
    public void buttonPressedOffMic(View view) {
        ImageButton button = (ImageButton) view;
        int icon;

        if (isMicOff) {
            isMicOff = false;
            icon = R.drawable.mic_off_black_48dp;
        } else {
            isMicOff = true;
            icon = R.drawable.mic_black__on_48dp;
        }
        button.setImageDrawable(
                ContextCompat.getDrawable(getApplicationContext(), icon));
    }

    //****************************************************************************
    //Отключить камеру
    private boolean isCamOff = false;

    public void buttonPressedOffCam(View view) {
        ImageButton button = (ImageButton) view;
        int icon;

        if (isCamOff) {
            isCamOff = false;
            icon = R.drawable.videocam_off_black_48dp;
        } else {
            isCamOff = true;
            icon = R.drawable.videocam_black_on_48dp;
        }

        button.setImageDrawable(
                ContextCompat.getDrawable(getApplicationContext(), icon));
    }

    //****************************************************************************
    //Закрыть приложение
    public void onBackPressed(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    //****************************************************************************
    //Приветствие
    public void greetingButton(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.test_message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //****************************************************************************
    //Переход к контактам
    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.activity_main__groupButton) {
            Intent intent = new Intent(this, SecondActivity.class);
            this.startActivity(intent);
        }
    }
}
package com.solodilov.evgen.singlmvpexemple;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    final private String KEY = MainActivity.class.getCanonicalName();
    CustomText customText;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new Person("Vasya", 25);
        customText = (CustomText) findViewById(R.id.et_my);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.info(this, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.info(this, "onResume");
        customText.setText(person.toString());

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.info(this, "onPause");
    }

    @Override
    protected void onStop() {
        LogUtil.info(this, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        LogUtil.info(this, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        LogUtil.info(this, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        person.incrementation();
        outState.putParcelable(KEY,person);
        super.onSaveInstanceState(outState);
        LogUtil.info(this, "onSave");
        }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        person = savedInstanceState.getParcelable(KEY);
        LogUtil.info(this, "onRestore");
    }
}

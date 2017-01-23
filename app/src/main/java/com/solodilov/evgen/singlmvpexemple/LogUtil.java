package com.solodilov.evgen.singlmvpexemple;

import android.util.Log;

class LogUtil {
    static void info(Object o, String mes) {
        Log.d(o.getClass().getCanonicalName(), mes);
    }
}

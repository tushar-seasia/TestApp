package com.example.bawejatushar.demoapp.utils;

import android.support.annotation.Nullable;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class StringUtils {
    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.toString().trim().length() == 0)
            return true;
        else
            return false;
    }
}

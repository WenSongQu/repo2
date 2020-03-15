package com.supergenius.admin.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AuthcodeUtils {
    public static String generateCode() {
        Date date = new Date();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMdd");
        String format = format0.format(date);

        return format + AuthcodeUtils.getFourRandom();
    }

    public static String getFourRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }
}

package com.cipolat.news.Utils;

import android.content.Context;
import java.util.Random;
/**
 * Created by sebastian on 24/07/17.
 */

public class Utils {
    public static int randomArrayValue(Context ctx, int arrayID) {

        int[] colors = ctx.getResources().getIntArray(arrayID);
        int min = 0;
        int max = colors.length - 1;
        Random rand = new Random();
        int i1 = rand.nextInt(max - min + 1) + min;
        return colors[i1];
    }
}


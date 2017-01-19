package com.marin.saul.a02_adventure.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.JetPlayer;

import com.marin.saul.a02_adventure.R;

/**
 * Created by g7-1105ss on 19/01/2017.
 */

public class JetPlayerUtil {

    public static void play(Context context, int jet){
        JetPlayer jetPlayer = JetPlayer.getJetPlayer();
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(jet);
        jetPlayer.loadJetFile(afd);
        byte segmentId = 0;

        // queue segment 0, repeat once, use General MIDI
        jetPlayer.queueJetSegment(0, -1, 0, 0, 0, (byte) 0);
        jetPlayer.play();
    }
}

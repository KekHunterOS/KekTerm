package com.team420.kekterm.emulatorview.compat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.ClipboardManager;

@SuppressLint("NewApi")
public class ClipboardManagerCompatV11 implements ClipboardManagerCompat {
    private final ClipboardManager clip;

    private Context context;
    public ClipboardManagerCompatV11(Context context) {
        this.context=context;
        clip = (ClipboardManager) context.getApplicationContext()
                .getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @Override
    public CharSequence getText() {
        ClipData.Item item = clip.getPrimaryClip().getItemAt(0);
        if(item.getText()!=null)
            return item.getText();
        return item.coerceToText(context);
    }

    @Override
    public boolean hasText() {
        return clip.hasPrimaryClip();
    }

    @Override
    public void setText(CharSequence text) {
        ClipData clipData = ClipData.newPlainText("simple text", text);
        clip.setPrimaryClip(clipData);
    }
}

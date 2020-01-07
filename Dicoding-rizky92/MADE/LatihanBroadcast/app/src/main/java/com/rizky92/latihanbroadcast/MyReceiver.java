package com.rizky92.latihanbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    final String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pduObj = (Object[]) bundle.get("pdus");
                if (pduObj != null) {
                    for (Object aPduObj : pduObj) {
                        SmsMessage currentMsg = getIncomingMessage(aPduObj, bundle);
                        String num = currentMsg.getDisplayOriginatingAddress();
                        String msg = currentMsg.getDisplayMessageBody();
                        Log.d(TAG, "senderNum: " + num + "; message: " + msg);

                        Intent showSmsIntent = new Intent(context, SmsReceiverActivity.class);
                        showSmsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        showSmsIntent.putExtra(SmsReceiverActivity.EXTRA_SMS_NO, num);
                        showSmsIntent.putExtra(SmsReceiverActivity.EXTRA_SMS_MESSAGE, msg);
                        context.startActivity(showSmsIntent);
                    }
                } else {
                    Log.d(TAG, "onReceive: SMS is null");
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "Exception smsReceiver " + e);
        }
    }

    private SmsMessage getIncomingMessage(Object object, Bundle bundle) {
        SmsMessage currentSms;
        if (Build.VERSION.SDK_INT >= 23) {
            String string = bundle.getString("format");
            currentSms = SmsMessage.createFromPdu((byte[]) object, string);
        } else {
            currentSms = SmsMessage.createFromPdu((byte[]) object);
        }
        return currentSms;
    }
}

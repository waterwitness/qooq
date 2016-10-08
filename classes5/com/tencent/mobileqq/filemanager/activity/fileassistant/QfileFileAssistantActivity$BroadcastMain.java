package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QfileFileAssistantActivity$BroadcastMain
  extends BroadcastReceiver
{
  public QfileFileAssistantActivity$BroadcastMain(QfileFileAssistantActivity paramQfileFileAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext.getSharedPreferences("Offline_Flags", 0).edit().clear().commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\fileassistant\QfileFileAssistantActivity$BroadcastMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
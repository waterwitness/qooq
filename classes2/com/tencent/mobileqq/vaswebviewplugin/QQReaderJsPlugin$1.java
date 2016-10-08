package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQReaderJsPlugin$1
  extends BroadcastReceiver
{
  QQReaderJsPlugin$1(QQReaderJsPlugin paramQQReaderJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getExtras();
    if (QLog.isColorLevel()) {
      QLog.d("QQReaderJsPlugin", 2, "onReceive action:" + paramContext);
    }
    if (("com.tencent.mobileqq.jsPlugin.AddToBookShelf".equals(paramContext)) || (paramIntent != null)) {
      paramContext = new JSONObject();
    }
    try
    {
      paramContext.put("id", paramIntent.getString("bookId"));
      this.this$0.dispatchJsEvent("qqReaderCenterSucceedAddingToShelf", paramContext, null);
      return;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQReaderJsPlugin", 2, paramIntent.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQReaderJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
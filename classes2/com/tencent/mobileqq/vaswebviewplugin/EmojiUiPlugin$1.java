package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class EmojiUiPlugin$1
  extends Client.onRemoteRespObserver
{
  EmojiUiPlugin$1(EmojiUiPlugin paramEmojiUiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "onBindedToClient");
    }
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    int i = -1;
    int j;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.key))
    {
      String str = paramBundle.getString("cmd");
      Bundle localBundle = paramBundle.getBundle("response");
      int k = paramBundle.getInt("failcode");
      if ((str != null) && ("writeQFaceResult".equals(str)))
      {
        j = localBundle.getInt("result", -1);
        paramBundle = localBundle.getString("messge");
        if (k == 1000) {
          break label125;
        }
        paramBundle = "QFaceResult error";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i + " msg:" + paramBundle);
      }
      return;
      label125:
      i = j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiUiPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
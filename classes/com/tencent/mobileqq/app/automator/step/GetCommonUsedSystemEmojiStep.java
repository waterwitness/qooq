package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GetCommonUsedSystemEmojiStep
  extends AsyncStep
{
  public GetCommonUsedSystemEmojiStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.a().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
    long l = localSharedPreferences.getLong("lastRequestTime", 0L);
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.a.b.a(12);
    if (!new File(BaseApplicationImpl.a.getFilesDir(), "commonusedSystemEmojiInfoFile_v2_" + this.a.b.a()).exists())
    {
      QLog.d("QQInitHandler", 1, "GetCommonUsedSystemEmojiStep file not exsist");
      localEmoticonHandler.c();
      localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
      return 7;
    }
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep send req");
      }
      localEmoticonHandler.c();
      localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
      return 7;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep updateCacheFromFile");
    }
    ((CommonUsedSystemEmojiManager)this.a.b.getManager(171)).b();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetCommonUsedSystemEmojiStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class PPCLoginAuth
  extends AsyncStep
{
  public PPCLoginAuth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.a().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastPPCLoginAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      ((PPCLoginAuthHandler)this.a.b.a(58)).b();
      localSharedPreferences.edit().putLong("lastPPCLoginAuthTime", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\PPCLoginAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
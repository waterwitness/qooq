package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.NumRedPointHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class GetNumRedStep
  extends AsyncStep
{
  public GetNumRedStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.a().getSharedPreferences(this.a.b.getAccount(), 0);
    int i = localSharedPreferences.getInt("NumRedTimeInterval", 600);
    int j = localSharedPreferences.getInt("NumRedLastTime", 0);
    if ((int)(System.currentTimeMillis() / 1000L) - j > i) {
      ((NumRedPointHandler)this.a.b.a(55)).a();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetNumRedStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
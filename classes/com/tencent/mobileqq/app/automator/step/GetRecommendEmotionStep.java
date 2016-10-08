package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetRecommendEmotionStep
  extends AsyncStep
{
  public GetRecommendEmotionStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("recommendEmotion_sp_name", 0);
    long l1 = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.f(), 0L);
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.d("GetRecommendEmotionStep", 2, "lastRequestTime = " + l1 + ", intervalTime: " + l2);
    }
    if ((l2 > 3600L * paramLong * 1000L) || (l2 < 0L))
    {
      ((EmoticonHandler)paramQQAppInterface.a(12)).a();
      localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.f(), System.currentTimeMillis()).commit();
    }
  }
  
  protected int a()
  {
    a(this.a.b, 12L);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetRecommendEmotionStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
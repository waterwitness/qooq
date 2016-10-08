package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  public static final String c = "last_pull_free_emosm_update_time";
  
  public GetEmoticonWhenNoFile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_free_emosm_update_time", 0L);
    if (System.currentTimeMillis() - l > 43200000L)
    {
      new EPRecommendTask(this.a.b).a("http://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json", "3").a();
      localSharedPreferences.edit().putLong("last_pull_free_emosm_update_time", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetEmoticonWhenNoFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
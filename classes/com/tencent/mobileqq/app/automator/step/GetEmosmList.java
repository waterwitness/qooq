package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GetEmosmList
  extends AsyncStep
{
  public GetEmosmList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "getEmosmList start int QQInitHandler...");
    }
    Object localObject1 = (EmoticonManager)this.a.b.getManager(13);
    Object localObject2 = this.a.b.getApplication().getSharedPreferences("mobileQQ", 0);
    if (!Boolean.valueOf(((SharedPreferences)localObject2).getBoolean("emosm_has_set_emosmpackage_valid_" + this.a.b.a(), false)).booleanValue())
    {
      List localList = ((EmoticonManager)localObject1).a();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackage)localIterator.next()).valid = true;
        }
        ((EmoticonManager)localObject1).a(localList);
      }
      ((SharedPreferences)localObject2).edit().putBoolean("emosm_has_set_emosmpackage_valid_" + this.a.b.a(), true).commit();
    }
    localObject1 = Boolean.valueOf(((SharedPreferences)localObject2).getBoolean("emosm_has_download_emosmpackage_tag_" + this.a.b.a(), false));
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "oidbFlag oidbFlag int oidbFlag..." + localObject1);
    }
    localObject2 = (EmoticonHandler)this.a.b.a(12);
    if (((Boolean)localObject1).booleanValue()) {
      ((EmoticonHandler)localObject2).a(0, 0);
    }
    for (;;)
    {
      return 7;
      ((EmoticonHandler)localObject2).b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetEmosmList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
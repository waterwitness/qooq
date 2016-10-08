package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Utils;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePatchConfig
  extends Step
{
  private static final String a = "update_patch_version";
  private static final String c = "cur_version";
  
  private void a(Context paramContext)
  {
    int i = 0;
    QLog.d("UpdatePatchConfig", 1, "clearPatchConfig start.");
    try
    {
      SharedPreUtils.i(paramContext, 0);
      SharedPreUtils.a(paramContext, 0L);
      paramContext = paramContext.getSharedPreferences("sp_dex_patch", 4).edit();
      paramContext.clear();
      paramContext.commit();
      paramContext = new File("/data/data/com.tencent.mobileqq/files/hotpatch");
      if (paramContext.exists())
      {
        paramContext = paramContext.listFiles();
        if ((paramContext != null) && (paramContext.length > 0))
        {
          int j = paramContext.length;
          while (i < j)
          {
            Object localObject = paramContext[i];
            if ((localObject != null) && (((File)localObject).exists())) {
              ((File)localObject).delete();
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    Context localContext = BaseApplicationImpl.a.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("update_patch_version", 0);
    String str1 = localSharedPreferences.getString("cur_version", "");
    String str2 = ApkUtils.a(localContext) + "." + ApkUtils.a(localContext);
    QLog.d("UpdatePatchConfig", 1, "version, currentVersion :" + str1 + ", " + str2);
    if (!str2.equals(str1))
    {
      a(localContext);
      localSharedPreferences.edit().putString("cur_version", str2).commit();
    }
    Utils.a(localContext);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\UpdatePatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
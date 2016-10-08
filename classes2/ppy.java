import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ppy
  implements Runnable
{
  public ppy(ApolloManager paramApolloManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    int k = 0;
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = this.a.a.getApplication().getSharedPreferences("apollo_sp", 0);
    int j = localSharedPreferences.getInt("apollo_def_res_version", 0);
    if (6 != j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "QQ ver update last: " + j + ", cur ver: " + 6);
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "check default res step 1 cost: " + (System.currentTimeMillis() - l1) + " ms");
      }
      if (i != 0) {
        FileUtils.a(new File(ApolloConstant.k, "/def/").getAbsolutePath());
      }
      try
      {
        long l2 = System.currentTimeMillis();
        ApolloManager.a(BaseApplicationImpl.a().getApplicationContext(), "apollo_def_rsc", ApolloConstant.j + "/apollo_def_rsc");
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "copy file to sdcard cost:" + (l3 - l2));
        }
        i = LzmaUtils.a(BaseApplicationImpl.a().getApplicationContext(), ApolloConstant.j + "/apollo_def_rsc", BaseApplicationImpl.a().getFilesDir().getAbsolutePath() + "/");
        localSharedPreferences.edit().putInt("apollo_def_res_version", 6).commit();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "check default res step all cost: " + (System.currentTimeMillis() - l1) + " ms" + ",code:" + i);
        }
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        int m;
        while (!QLog.isColorLevel()) {}
        QLog.d("ApolloManager", 2, "errorInfo->" + localException.getMessage());
      }
      localObject = new File(ApolloConstant.k, "/def/scene.lua");
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "/apollo/def/scene.lua file do not exist");
        }
        i = 1;
      }
      else
      {
        if (ApolloUtil.c(0)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role res is invalid");
        }
        i = 1;
      }
    }
    localObject = ApolloResDownloader.a(0);
    if ((localObject == null) || (localObject.length == 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("dresses is invalid size:");
        if (localObject != null) {
          break label496;
        }
      }
      for (;;)
      {
        QLog.d("ApolloManager", 2, i);
        i = 1;
        break;
        label496:
        i = localObject.length;
      }
    }
    m = localObject.length;
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      i = localObject[j];
      if (!ApolloUtil.b(i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "dress is invalid id: " + i);
        }
        i = 1;
        break;
      }
      j += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
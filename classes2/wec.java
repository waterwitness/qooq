import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class wec
  extends DownloadListener
{
  public wec()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject2 = paramDownloadTask.a();
    String str1 = ((Bundle)localObject2).getString("method");
    if (str1 == null) {
      str1 = "other";
    }
    for (;;)
    {
      String str2 = ((Bundle)localObject2).getString("ifromet");
      if (str2 == null) {
        str2 = "null";
      }
      for (;;)
      {
        boolean bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Club_jsonDownloadListener key = " + paramDownloadTask.a + ",satatus = " + paramDownloadTask.a() + ",errCode = " + paramDownloadTask.z + ",errMsg = " + paramDownloadTask.b);
        }
        Object localObject1 = BaseApplicationImpl.a.a();
        if (localObject1 != null) {}
        for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
        {
          Object localObject3;
          boolean bool1;
          if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
          {
            localObject3 = ((Bundle)localObject2).getString("version_key");
            if (localObject3 != null) {
              ClubContentJsonTask.a(BaseApplicationImpl.a.getApplicationContext(), (String)localObject3, ((Bundle)localObject2).getInt("version", 0));
            }
            if ((paramDownloadTask.a != null) && (localObject1 != null)) {
              if (paramDownloadTask.a.equals(ClubContentJsonTask.k.b))
              {
                ThreadManager.a(new wed(this), 5, null, true);
                bool1 = bool2;
              }
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ClubContentJsonTask", 2, "jsonDownloadListener,ret=" + bool1 + ",file.name:" + paramDownloadTask.a + ",method:" + str1 + ",ifromet:" + str2);
            }
            if (localObject1 != null) {}
            try
            {
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("param_jsonName", paramDownloadTask.a);
              ((HashMap)localObject2).put("param_method", str1);
              ((HashMap)localObject2).put("param_from", str2);
              StatisticCollector.a(((QQAppInterface)localObject1).getApplication().getApplicationContext()).a(((QQAppInterface)localObject1).getAccount(), "ClubContentJsonLoaded", bool1, 1L, 0L, (HashMap)localObject2, "", false);
              return;
            }
            catch (Exception paramDownloadTask)
            {
              label830:
              label884:
              paramDownloadTask.printStackTrace();
              return;
            }
            if (ClubContentJsonTask.d.b.equals(paramDownloadTask.a))
            {
              ClubContentJsonTask.d.a = null;
              ClubContentJsonTask.d.a(((QQAppInterface)localObject1).getApplication());
              localObject2 = ((QQAppInterface)localObject1).a().getSharedPreferences("individuation_predownload_resource_config", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean("checked", false);
              ((SharedPreferences.Editor)localObject2).putInt("counter", 0);
              ClubContentJsonTask.a();
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.j.b))
            {
              FunnyPicHelper.a((QQAppInterface)localObject1);
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.m.b))
            {
              ((QQAppInterface)localObject1).a().getSharedPreferences("clubContentPendantMarketJsonUpdate", 0).edit().putBoolean("clubContentPendantMarketJsonUpdate", true).commit();
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.f.b))
            {
              localObject2 = (EmoticonManager)((QQAppInterface)localObject1).getManager(13);
              bool1 = bool2;
              if (localObject2 != null)
              {
                ((EmoticonManager)localObject2).a(true);
                bool1 = bool2;
              }
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.c.b))
            {
              ClubContentJsonTask.b((QQAppInterface)localObject1);
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.b.b))
            {
              IndividuationUrlHelper.a((AppRuntime)localObject1);
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.l.b))
            {
              ((URLInterceptManager)((QQAppInterface)localObject1).getManager(149)).a((QQAppInterface)localObject1);
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.e.b))
            {
              ClubContentJsonTask.e.a = null;
              ClubContentJsonTask.e.a(((QQAppInterface)localObject1).getApplication());
              bool1 = bool2;
            }
            else if (paramDownloadTask.a.equals(ClubContentJsonTask.n.b))
            {
              ((FontManager)((QQAppInterface)localObject1).getManager(41)).b(true);
              bool1 = bool2;
            }
            else
            {
              bool1 = bool2;
              if (paramDownloadTask.a.equals(ClubContentJsonTask.o.b))
              {
                bool1 = bool2;
                if (localObject1 != null)
                {
                  ((VoiceChangeManager)((QQAppInterface)localObject1).getManager(175)).a(null);
                  bool1 = bool2;
                  continue;
                  localObject2 = new StringBuilder().append("jsonDownloadListener, app == null:");
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    localObject2 = ((StringBuilder)localObject2).append(bool1).append(",key == null:");
                    if (paramDownloadTask.a != null) {
                      break label884;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.e("ClubContentJsonTask", 2, bool1);
                    bool1 = bool2;
                    break;
                    bool1 = false;
                    break label830;
                  }
                  QLog.e("ClubContentJsonTask", 1, "ClubContentJsonTask jsondownfail task.key = " + paramDownloadTask.a);
                  if ((paramDownloadTask.a != null) && (paramDownloadTask.a.equals(ClubContentJsonTask.k.b)) && (localObject1 != null))
                  {
                    localObject3 = (IndividualRedPacketManager)((QQAppInterface)localObject1).getManager(130);
                    localObject2 = "0";
                    if (((IndividualRedPacketManager)localObject3).a()) {
                      localObject2 = "1";
                    }
                    ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, (String)localObject2, "0", "", "");
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
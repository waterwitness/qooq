import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qbar.QbarCrashCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneCrashHandler;
import cooperation.qzone.RDMEtraMsgCollector;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class uui
  implements CrashHandleListener
{
  public uui(StatisticCollector paramStatisticCollector)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    QLog.d("StatisticCollector", 1, "getCrashExtraMessage...isNativeCrashed: " + paramBoolean + " crashType=" + paramString1 + " crashAddress=" + paramString2 + " crashStack=" + paramString3 + " native_SICODE=" + paramInt + " crashTime=" + paramLong);
    try
    {
      paramString2 = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
      if ((paramString2 != null) && (!paramString2.exists())) {
        paramString2.mkdirs();
      }
      paramString2 = new FileWriter("/data/data/com.tencent.mobileqq/files/crashinfo/" + paramLong + ".log");
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append(StatisticCollector.a().format(new Date(paramLong))).append("\n").append(paramString1).append("\n").append(paramString3);
      paramString2.write(((StringBuilder)localObject).toString());
      paramString2.flush();
      paramString2.close();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Object localObject;
        paramString1.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    paramString1 = BaseApplicationImpl.processName;
    if ((paramBoolean) && ((paramString1.endsWith(":qzone")) || (paramString1.endsWith(":picture"))))
    {
      QLog.e("crash", 1, paramString3);
      QZoneCrashHandler.a(paramString3);
    }
    boolean bool;
    for (;;)
    {
      try
      {
        paramString1 = StatisticCollector.a().getSharedPreferences("sp_dex_patch", 4);
        paramBoolean = paramString1.getBoolean("enable", false);
        bool = paramBoolean;
        if (!paramBoolean) {}
      }
      catch (Throwable paramString1)
      {
        int i;
        label744:
        paramBoolean = false;
      }
      try
      {
        paramString2 = paramString1.getString("crashKey", "");
        bool = paramBoolean;
        if (!TextUtils.isEmpty(paramString2))
        {
          int j = 0;
          paramString2 = paramString2.split(";");
          i = j;
          if (paramString2 != null)
          {
            i = j;
            if (paramString2.length > 0)
            {
              i = j;
              if (!TextUtils.isEmpty(paramString3))
              {
                int k = paramString2.length;
                paramInt = 0;
                i = j;
                if (paramInt < k)
                {
                  if (!paramString3.contains(paramString2[paramInt])) {
                    continue;
                  }
                  i = 1;
                }
              }
            }
          }
          bool = paramBoolean;
          if (i != 0)
          {
            paramInt = paramString1.getInt("patchCrashCount", 0);
            if ((paramInt == 1) || (paramInt == 3))
            {
              paramString2 = paramString1.getString("name", "");
              if (!TextUtils.isEmpty(paramString2))
              {
                paramString2 = new File("/data/data/com.tencent.mobileqq/files/hotpatch/" + paramString2);
                if ((paramString2 != null) && (paramString2.exists())) {
                  paramString2.delete();
                }
              }
            }
            paramString1.edit().putInt("patchCrashCount", paramInt + 1).commit();
            bool = paramBoolean;
          }
        }
        paramString3 = new StringBuilder(128);
      }
      catch (Throwable paramString1)
      {
        for (;;) {}
      }
      try
      {
        paramString3.append("\nisPublicVersion=true");
        paramString3.append("\nrevision=229354");
        paramString3.append("\nsInjectResult: ").append(BaseApplicationImpl.sInjectResult);
        paramString3.append("\nsQQAppInterfaceEscaped: ").append(BaseApplicationImpl.a);
        paramString3.append("\nsSplashActivityEscaped: ").append(BaseApplicationImpl.b);
        paramString3.append("\nCountSuicide: ").append(StartupDirector.d);
        paramString3.append("\nPatch enable=").append(bool).append(", inject result=").append(BaseApplicationImpl.j);
        paramString1 = WebpSoLoader.a;
        if ((paramString1 != null) && (paramString1.length >= 3)) {
          paramString3.append(String.format("\nWebP support library v%d.%d.%d was loaded.", new Object[] { Integer.valueOf(paramString1[0]), Integer.valueOf(paramString1[1]), Integer.valueOf(paramString1[2]) }));
        }
        paramString3.append("\n");
        paramString2 = StatisticCollector.a();
        localObject = DeviceInfoUtil.a();
        paramString3.append(DeviceInfoUtil.l()).append("\n");
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "null";
        }
        paramString3.append(paramString1).append("\n");
        paramString3.append("Rom total size: ").append(localObject[0]).append(" MB, Rom available size: ").append(localObject[1]).append(" MB\n");
        if (StatisticCollector.a(this.a) != null) {
          break label1242;
        }
        paramString1 = "null";
        paramString3.append(paramString1).append("\n");
        paramString3.append("SplashActivity curFragment=").append(SplashActivity.c).append("\n");
        paramString1 = BaseActivity.sTopActivity;
        if ((paramString1 instanceof SplashActivity))
        {
          paramString1 = (SplashActivity)paramString1;
          paramString3.append("SplashActivity curTab=").append(paramString1.a()).append("\n");
        }
        paramString3.append(StatisticCollector.b(this.a).toString());
        paramString3.append(StatisticCollector.a(this.a).toString());
        if ((!TextUtils.isEmpty(QZoneCrashHandler.a)) && (Build.VERSION.SDK_INT >= 8)) {
          paramString3.append("lastCrashedText(Base64): " + Base64.encodeToString(QZoneCrashHandler.a.getBytes(), 0) + "\n");
        }
        if (!TextUtils.isEmpty(QZoneCrashHandler.b)) {
          paramString3.append("qzonePluginVersion:").append(QZoneCrashHandler.b).append("\n");
        }
        paramString3.append(RDMEtraMsgCollector.a().a());
        paramString3.append("\n");
      }
      catch (Throwable paramString1)
      {
        continue;
      }
      try
      {
        if (StatisticCollector.a(this.a).size() > 0) {
          paramString3.append(((uuo)StatisticCollector.a(this.a).removeLast()).toString());
        }
        try
        {
          paramInt = WebView.getTbsSDKVersion(StatisticCollector.a());
          i = QbSdk.getTbsVersion(StatisticCollector.a());
          paramString2 = paramString3.append('\n').append("Current WebView: ");
          if (i == 0)
          {
            paramString1 = "system";
            paramString2.append(paramString1).append("; TBS sdk version: ").append(paramInt).append("; X5 core version: ").append(i);
            if (BaseApplicationImpl.i == 3) {
              paramString3.append("\nTBS CrashExtraMsg:").append(WebView.getCrashExtraMessage(StatisticCollector.a()));
            }
          }
        }
        catch (Throwable paramString1) {}
      }
      catch (Throwable paramString1) {}
    }
    for (;;)
    {
      paramString3.append("\nMobileQQ onActivityCreate component: ").append(BaseApplicationImpl.a().startComponentInfo);
      if ((BaseApplicationImpl.a().broadcastInfoQueue == null) || (BaseApplicationImpl.a().broadcastInfoQueue.isEmpty())) {
        break label1260;
      }
      paramString1 = BaseApplicationImpl.a().broadcastInfoQueue.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Pair)paramString1.next();
        if (paramString2 != null) {
          paramString3.append("\nQQBroadcastReceiver time: ").append(StatisticCollector.a().format(new Date(((Long)paramString2.first).longValue()))).append(", broadcast intent: ").append((String)paramString2.second);
        }
      }
      paramString1.printStackTrace();
      bool = paramBoolean;
      break;
      label1242:
      paramString1 = StatisticCollector.a(this.a);
      break label744;
      paramString1 = "x5";
    }
    try
    {
      label1260:
      paramString1 = QbarCrashCollector.a;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString3.append("\nQbar scanning url:").append(paramString1);
      }
    }
    catch (Throwable paramString1)
    {
      for (;;) {}
    }
    QLog.d("StatisticCollector", 1, "getCrashExtraMsg: " + paramString3.toString());
    return paramString3.toString();
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleEnd...isNativeCrashed: " + paramBoolean);
    Object localObject = BaseApplicationImpl.processName;
    try
    {
      if (!((String)localObject).equals("com.tencent.mobileqq")) {
        break label218;
      }
      if (!this.a.a) {
        break label249;
      }
      QLog.d("StatisticCollector", 1, "onCrashHandleEnd...shouldStopMsf=" + this.a.a + ", kill package processes.");
      localObject = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          String str = localRunningAppProcessInfo.processName;
          if ((str != null) && (str.startsWith("com.tencent.mobileqq:")) && (!str.endsWith(":MSF")))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            continue;
            return true;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    BaseApplicationImpl.a().stopMsfOnCrash(true);
    Process.killProcess(Process.myPid());
    break label249;
    label209:
    BaseApplicationImpl.a().QQProcessExit(true);
    return true;
    label218:
    if ((!localThrowable.endsWith(":qzone")) && (!localThrowable.endsWith(":buscard"))) {}
    for (;;)
    {
      BaseApplicationImpl.a().otherProcessExit(false);
      return true;
      label249:
      if (paramBoolean) {
        break label209;
      }
      break label209;
      if (!paramBoolean) {
        break;
      }
    }
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart...isNativeCrashed: " + paramBoolean + ", hasCrashed: " + StatisticCollector.a(this.a));
    Object localObject3 = BaseApplicationImpl.processName;
    if ((StatisticCollector.a(this.a)) && (!((String)localObject3).endsWith(":buscard"))) {
      Process.killProcess(Process.myPid());
    }
    label754:
    label790:
    do
    {
      Object localObject2;
      do
      {
        for (;;)
        {
          try
          {
            Object localObject4 = new StringBuilder(128);
            Object localObject5 = new StringBuilder().append("topActivity:");
            Object localObject1;
            int j;
            if (BaseActivity.sTopActivity == null)
            {
              localObject1 = "null";
              localObject1 = (String)localObject1;
              localObject5 = new StringBuilder(128);
              j = StatisticCollector.a(this.a).size();
              int i = Math.min(j, 5);
              if (i > 0)
              {
                String str = (String)StatisticCollector.a(this.a).pop();
                if (((StringBuilder)localObject5).length() > 0) {
                  ((StringBuilder)localObject5).append("\n--->");
                }
                ((StringBuilder)localObject5).append(str);
                i -= 1;
                continue;
                StatisticCollector.a(this.a, true);
              }
            }
            else
            {
              localObject1 = BaseActivity.sTopActivity.toString();
              continue;
            }
            StatisticCollector.a(this.a).clear();
            ((StringBuilder)localObject4).append((String)localObject1).append("\n");
            ((StringBuilder)localObject4).append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
            ((StringBuilder)localObject4).append((CharSequence)localObject5).append("\n");
            ((StringBuilder)localObject4).append("Current mapEvent content is:\n");
            ((StringBuilder)localObject4).append(StatisticCollector.a(this.a).toString());
            StatisticCollector.a(this.a, ((StringBuilder)localObject4).toString());
            if (!((String)localObject3).endsWith(":qzone")) {
              break;
            }
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              BaseApplicationImpl.a().closeAllActivitys();
              StatisticCollector.a(this.a, StatisticCollector.a(), (String)localObject3);
              try
              {
                if (((String)localObject3).equals("com.tencent.mobileqq"))
                {
                  this.a.a();
                  this.a.b();
                }
                if ((((String)localObject3).endsWith(":qzone")) || (((String)localObject3).endsWith(":web")) || (((String)localObject3).endsWith(":peak")))
                {
                  this.a.a();
                  this.a.b((String)localObject3);
                }
                if (((((String)localObject3).endsWith(":qzone")) || (((String)localObject3).endsWith(":web")) || (((String)localObject3).endsWith(":peak")) || (((String)localObject3).endsWith(":qzonevideo")) || (((String)localObject3).endsWith(":picture"))) && (LocalMultiProcConfig.a("key_sp_qzone_isforeground", false)))
                {
                  QLog.d("StatisticCollector", 1, "qzone crash | crash time:" + System.currentTimeMillis() / 1000L);
                  LocalMultiProcConfig.a("key_sp_qzone_crash_time_" + this.a.bG, System.currentTimeMillis() / 1000L);
                  LocalMultiProcConfig.b("key_sp_qzone_isforeground", false);
                }
              }
              catch (Throwable localThrowable4)
              {
                QLog.d("StatisticCollector", 1, "init and update crashcontrol exception happen.");
                continue;
                localThrowable4.putStringArrayListExtra("procNameList", (ArrayList)localObject3);
                localThrowable4.putExtra("verify", BaseApplicationImpl.a((ArrayList)localObject3, false));
                StatisticCollector.a().sendBroadcast(localThrowable4);
                BaseApplicationImpl.a().crashed();
                return;
              }
              try
              {
                StatisticCollector.a(this.a).append("Current thread Id=").append(Thread.currentThread().getId()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
                SharedPreferencesProxyManager.getInstance().trySave();
                if (!((String)localObject3).equals("com.tencent.mobileqq")) {
                  break label790;
                }
                localObject1 = new Intent("com.tencent.process.exit");
                localObject4 = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses();
                localObject3 = new ArrayList();
                if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
                  break label754;
                }
                localObject4 = ((List)localObject4).iterator();
                if (!((Iterator)localObject4).hasNext()) {
                  break label754;
                }
                localObject5 = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject4).next()).processName;
                if ((localObject5 == null) || (!((String)localObject5).startsWith("com.tencent.mobileqq:")) || (((String)localObject5).endsWith(":MSF"))) {
                  continue;
                }
                ((ArrayList)localObject3).add(localObject5);
                continue;
                localThrowable2 = localThrowable2;
              }
              catch (Throwable localThrowable1)
              {
                localThrowable1.printStackTrace();
                return;
              }
              localThrowable2.printStackTrace();
              continue;
            }
            catch (Throwable localThrowable3)
            {
              localThrowable3.printStackTrace();
              continue;
            }
          }
          localObject2 = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.equals("com.tencent.mobileqq:qzonevideo")) {
              Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
            }
          }
        }
        if (!((String)localObject3).endsWith(":video")) {
          break;
        }
        localObject2 = BaseApplicationImpl.a().a();
      } while ((localObject2 == null) || (!(localObject2 instanceof StatisticCollector.StatisticCallback)));
      ((StatisticCollector.StatisticCallback)localObject2).a();
      return;
    } while (!((String)localObject3).endsWith(":TMAssistantDownloadSDKService"));
    TMAssistantDownloadManager.closeAllService(StatisticCollector.a());
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    WebpSoLoader.a(paramString3);
    GifSoLoader.a(paramString3);
    if ((!TextUtils.isEmpty(paramString3)) && ((paramString3.contains("com.facebook")) || (paramString3.contains("libreactnativejni")) || (paramString3.contains("libjsc")) || (paramString3.contains("libfbjni"))) && (BaseApplicationImpl.processName.endsWith(":qzone")))
    {
      paramInt = LocalMultiProcConfig.a("react_native_crash_count", 0) + 1;
      LocalMultiProcConfig.a("react_native_crash_count", paramInt);
      QLog.i("QzoneReact", 1, "crashCount=" + paramInt);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.CpuUtils;
import cooperation.qzone.util.PerfTracer;
import java.io.BufferedReader;
import java.io.FileReader;

public class QZoneVideoCommonUtils
{
  private static int a = -1;
  public static final long a = 62914560L;
  public static final String a = "cover_mall_record_video";
  private static long b = -1L;
  public static final String b = "M032|";
  public static final String c = "GN9000L|";
  public static final String d = "GT-N7100|";
  private static final String e = "QZoneVideoCommonUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    int i = 0;
    if (i < 8) {}
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq"), 1024);
        String str = localBufferedReader.readLine();
        if (str == null) {
          break label88;
        }
        l = Long.parseLong(str) / 1024L;
        localBufferedReader.close();
        return l;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
      break;
      return 0L;
      label88:
      long l = 0L;
    }
  }
  
  public static QZoneVideoCommonUtils.VideoSupport a()
  {
    int j = -1;
    if (QzoneConfig.a().a("MiniVideo", "SupportMiniVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    int i = QzoneConfig.a().a("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("GN9000L|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    if (QzoneConfig.a().a("MiniVideo", "IgnoreLocalJudge", -1) == 1) {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severWhiteList");
      }
    }
    label635:
    long l2;
    do
    {
      i = QzoneConfig.a().a("MiniVideo", "MinSdkVersion", 14);
      j = Build.VERSION.SDK_INT;
      if (j >= i) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
      }
      return QZoneVideoCommonUtils.VideoSupport.e;
      if (a < 0) {
        a();
      }
      if (b < 0L) {
        b = CpuUtils.getCpuFeatures();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + a + " mCpuFeature=" + b);
      }
      i = QzoneConfig.a().a("MiniVideo", "SupportedCpuFamily", 2);
      if ((1 << a & i) == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverCpuFamily=" + i + " mCpuFamily=" + a);
        }
        return QZoneVideoCommonUtils.VideoSupport.b;
      }
      Object localObject = QzoneConfig.a().a("MiniVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (a >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + a + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      for (;;)
      {
        i = QzoneConfig.a().a("MiniVideo", "MinCpu", 1150);
        l1 = a();
        if (l1 >= i) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverCPUFreq=" + i + " localCpuFreq=" + l1);
        }
        return QZoneVideoCommonUtils.VideoSupport.d;
        localObject = localObject[a];
        i = ((String)localObject).length() - 1;
        for (;;)
        {
          if (i < 0) {
            break label635;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + b);
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((b & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + b);
            }
            return QZoneVideoCommonUtils.VideoSupport.b;
          }
          i -= 1;
        }
      }
      l1 = QzoneConfig.a().a("MiniVideo", "MinRam", 700);
      l2 = DeviceInfoUtil.c() / 1024L / 1024L;
    } while (l2 >= l1);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverRam=" + l1 + " localRam=" + l2);
    }
    return QZoneVideoCommonUtils.VideoSupport.d;
    if (!CacheManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdcard !mounted");
      }
      return QZoneVideoCommonUtils.VideoSupport.f;
    }
    long l1 = b();
    if (l1 < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdCardFreeSpace=" + l1 + " STORAGE_LIMIT=" + 62914560L);
      }
      return QZoneVideoCommonUtils.VideoSupport.g;
    }
    return QZoneVideoCommonUtils.VideoSupport.a;
  }
  
  private static void a()
  {
    if (Build.CPU_ABI.contains("armeabi"))
    {
      a = 1;
      return;
    }
    if (Build.CPU_ABI.contains("x86"))
    {
      a = 2;
      return;
    }
    if (Build.CPU_ABI.contains("mips"))
    {
      a = 3;
      return;
    }
    a = 0;
  }
  
  public static void a(long paramLong, Activity paramActivity, String paramString, QZoneVideoCommonUtils.onForwardVideoActivityFailedListener paramonForwardVideoActivityFailedListener)
  {
    PerfTracer.a("Video_component_pre_launch");
    QZoneVideoCommonUtils.VideoSupport localVideoSupport1 = a();
    QZoneVideoCommonUtils.VideoSupport localVideoSupport2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + localVideoSupport1.a() + ", support trim=" + localVideoSupport2.a());
    }
    if ((!localVideoSupport1.a()) && (!localVideoSupport2.a()))
    {
      if (localVideoSupport1.b()) {}
      for (paramString = localVideoSupport1.a();; paramString = null)
      {
        String str;
        if (paramString != null)
        {
          str = paramString;
          if (paramString.length() == 0)
          {
            str = paramString;
            if (paramActivity == null) {}
          }
        }
        else
        {
          str = paramActivity.getString(2131367099);
        }
        if (paramonForwardVideoActivityFailedListener != null) {
          paramonForwardVideoActivityFailedListener.a(paramActivity, str);
        }
        if (QLog.isColorLevel()) {
          QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + localVideoSupport1.a() + ",trimSupport tips=" + localVideoSupport2.a() + ",show tips=" + str);
        }
        return;
      }
    }
    a(paramLong, paramActivity, localVideoSupport1.a(), localVideoSupport2.a(), paramString);
    PerfTracer.b("Video_component_pre_launch");
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("is_qzone_vip", paramBoolean3);
    localIntent.putExtra("enable_edit_video", paramBoolean4);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  private static long b()
  {
    try
    {
      long l = CacheManager.b();
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneVideoCommonUtils", 1, "Get Free Space Failed", localException);
    }
    return 0L;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport b()
  {
    int j = -1;
    if (QzoneConfig.a().a("TrimVideo", "SupportTrimVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    int i = QzoneConfig.a().a("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("M032|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    if (QzoneConfig.a().a("TrimVideo", "IgnoreLocalJudge", -1) == 1) {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severWhiteList");
      }
    }
    label651:
    long l2;
    do
    {
      i = QzoneConfig.a().a("TrimVideo", "MinSdkVersion", 14);
      j = Build.VERSION.SDK_INT;
      if (j >= i) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
      }
      return QZoneVideoCommonUtils.VideoSupport.e;
      if (a < 0) {
        a();
      }
      if (b < 0L) {}
      try
      {
        b = CpuUtils.getCpuFeatures();
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + a + " mCpuFeature=" + b);
        }
        i = QzoneConfig.a().a("TrimVideo", "SupportedCpuFamily", 2);
        if ((1 << a & i) == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverCpuFamily=" + i + " mCpuFamily=" + a);
          }
          return QZoneVideoCommonUtils.VideoSupport.b;
        }
      }
      catch (Exception localException)
      {
        return QZoneVideoCommonUtils.VideoSupport.b;
      }
      Object localObject = QzoneConfig.a().a("TrimVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (a >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + a + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      for (;;)
      {
        i = QzoneConfig.a().a("TrimVideo", "MinCpu", 1000);
        l1 = a();
        if (l1 >= i) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverCPUFreq=" + i + " localCpuFreq=" + l1);
        }
        return QZoneVideoCommonUtils.VideoSupport.d;
        localObject = localObject[a];
        i = ((String)localObject).length() - 1;
        for (;;)
        {
          if (i < 0) {
            break label651;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + b);
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((b & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + b);
            }
            return QZoneVideoCommonUtils.VideoSupport.b;
          }
          i -= 1;
        }
      }
      l1 = QzoneConfig.a().a("TrimVideo", "MinRam", 500);
      l2 = DeviceInfoUtil.c() / 1024L / 1024L;
    } while (l2 >= l1);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverRam=" + l1 + " localRam=" + l2);
    }
    return QZoneVideoCommonUtils.VideoSupport.d;
    if (!CacheManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdcard !mounted");
      }
      return QZoneVideoCommonUtils.VideoSupport.f;
    }
    long l1 = b();
    if (l1 < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdCardFreeSpace=" + l1 + " STORAGE_LIMIT=" + 62914560L);
      }
      return QZoneVideoCommonUtils.VideoSupport.g;
    }
    return QZoneVideoCommonUtils.VideoSupport.a;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport c()
  {
    if (QzoneConfig.a().a("TrimVideo", "SupportTrimVideoHW", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    int i = QzoneConfig.a().a("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.c;
    }
    return QZoneVideoCommonUtils.VideoSupport.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneVideoCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
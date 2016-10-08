import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkSoLoader;
import com.tencent.mobileqq.earlydownload.handler.ArkSoDownloadHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class qqp
  implements Runnable
{
  public qqp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1;
    long l2;
    if ((!ArkAppCenter.a) && (ArkAppCenter.b))
    {
      l1 = System.currentTimeMillis();
      UpdateArkSo.a(BaseApplicationImpl.getContext(), "png-armeabi-v7a");
      ArkAppCenter.a = UpdateArkSo.a(BaseApplicationImpl.getContext(), "ark-armeabi-v7a");
      l2 = System.currentTimeMillis();
      QLog.d("ArkApp", 1, "load libark.so for ARMv7!, loaded=" + Boolean.toString(ArkAppCenter.a) + ", time=" + (l2 - l1));
    }
    while (ArkAppCenter.d())
    {
      return;
      if ((!ArkAppCenter.a) && (ArkAppCenter.c()))
      {
        l1 = System.currentTimeMillis();
        if ((!ArkAppCenter.a().booleanValue()) || (!ArkSoDownloadHandler.d())) {
          ArkAppCenter.a(false);
        }
        for (ArkAppCenter.a = false;; ArkAppCenter.a = ArkSoLoader.b("ark-armeabi"))
        {
          l2 = System.currentTimeMillis();
          QLog.d("ArkApp", 1, "load libark.so for ARMv5!, loaded=" + Boolean.toString(ArkAppCenter.a) + ", time=" + (l2 - l1));
          break;
          ArkSoLoader.b("png-armeabi");
        }
      }
    }
    ArkAppCenter.a(true);
    if (ArkAppCenter.a)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.success", 0, 0, "0", "0", Build.CPU_ABI, Build.CPU_ABI2);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
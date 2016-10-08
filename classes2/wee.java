import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class wee
  extends DownloadListener
{
  public wee(ColorRingManager paramColorRingManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + paramDownloadTask.a());
    }
    Bundle localBundle = paramDownloadTask.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (paramDownloadTask.a() == 3)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = localBundle.getBoolean("isExists", false);
        localObject = localBundle.getString("path");
        if (!bool2) {
          break label479;
        }
        label96:
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("ColorRingManager", 2, "rename failure.");
            bool2 = bool1;
          }
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().getBoolean("isIPC")))
      {
        paramDownloadTask = new Bundle();
        paramDownloadTask.putString("status", "onDone");
        paramDownloadTask.putInt("fcStatus", 3);
        paramDownloadTask.putInt("id", k);
        paramDownloadTask.putInt("callId", k);
        paramDownloadTask.putInt("srcType", localBundle.getInt("srcType"));
        paramDownloadTask.putBoolean("result", bool2);
        paramDownloadTask.putInt("resourceType", localBundle.getInt("resourceType"));
        paramDownloadTask.putString("colorType", localBundle.getString("colorType"));
        paramDownloadTask.putBoolean("result_boo", bool2);
        paramDownloadTask.putInt("resourceType", i);
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramDownloadTask);
      }
      if (i == 3)
      {
        paramDownloadTask = (SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = paramDownloadTask.h();
        if (i != 2) {
          break label507;
        }
        i = 0;
      }
    }
    label296:
    label326:
    label479:
    label507:
    label525:
    label531:
    for (;;)
    {
      int j;
      if ("colorring".equals(localBundle.getString("colorType")))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (bool2)
        {
          j = 0;
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
        }
      }
      else if ("comering".equals(localBundle.getString("colorType")))
      {
        if (!bool2) {
          break label525;
        }
      }
      for (i = 0;; i = 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + paramDownloadTask.h(), k + "", "", "");
        return;
        bool1 = false;
        break;
        bool1 = FileUtils.c((String)localObject + ".tmp", (String)localObject);
        break label96;
        if (i != 3) {
          break label531;
        }
        i = 2;
        break label296;
        j = 1;
        break label326;
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if ((paramDownloadTask.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
    {
      Bundle localBundle1 = paramDownloadTask.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)paramDownloadTask.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(localBundle2);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if ((paramDownloadTask.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
    {
      paramDownloadTask = paramDownloadTask.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", paramDownloadTask.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", paramDownloadTask.getInt("callId"));
      localBundle.putInt("srcType", paramDownloadTask.getInt("srcType"));
      localBundle.putInt("resourceType", paramDownloadTask.getInt("resourceType"));
      localBundle.putString("colorType", paramDownloadTask.getString("colorType"));
      this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(localBundle);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Bundle;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.AfterDownloadCallback;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class wep
  extends DownloadListener
{
  public wep(IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    boolean bool1;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      bool1 = true;
      if (!bool1) {
        break label49;
      }
    }
    Bundle localBundle;
    label49:
    for (int i = 2;; i = -1)
    {
      localBundle = paramDownloadTask.a();
      if (localBundle != null) {
        break label55;
      }
      return;
      bool1 = false;
      break;
    }
    label55:
    String str = localBundle.getString("res_id");
    Object localObject1 = str;
    if (str == null) {
      localObject1 = "";
    }
    int j = localBundle.getInt("load_action", 0);
    int k = localBundle.getInt("res_type");
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "resDownloadListener loadAction: " + j + ", resType: " + k + ", downloadOK: " + bool1 + ", status: " + paramDownloadTask.a() + ", errCode:" + paramDownloadTask.z + ", errMsg: " + paramDownloadTask.b + ", id: " + (String)localObject1);
    }
    Object localObject2 = (IndividualRedPacketManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
    str = "0";
    if (((IndividualRedPacketManager)localObject2).a()) {
      str = "1";
    }
    long l = paramDownloadTask.h - paramDownloadTask.g;
    switch (k)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    default: 
    case 8: 
    case 1: 
    case 11: 
      for (;;)
      {
        label304:
        if (1 == j)
        {
          this.a.a();
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.e = i;
          }
          if ((bool1) && (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info != null) && (1 == j))
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str, "1", String.valueOf(l), "");
            this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((IndividualRedPacketManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info);
          }
          if (!bool1)
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str, "0", String.valueOf(l), "");
            if (QLog.isColorLevel())
            {
              QLog.e("IndividualRedPacketResDownloader", 2, "download font error : " + paramDownloadTask.b + " " + paramDownloadTask.z);
              continue;
              if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.e = i;
              }
              if ((bool1) && (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info != null) && (1 == j))
              {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str, "1", String.valueOf(l), "");
                this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((IndividualRedPacketManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info);
              }
              if (!bool1)
              {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str, "0", String.valueOf(l), "");
                if (QLog.isColorLevel())
                {
                  QLog.e("IndividualRedPacketResDownloader", 2, "download char300 error : " + paramDownloadTask.b + " " + paramDownloadTask.z);
                  continue;
                  if (this.a.b != null)
                  {
                    this.a.b.e = i;
                    if (bool1)
                    {
                      bool2 = false;
                      paramDownloadTask = (IndividualRedPacketManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
                      paramDownloadTask = IndividualRedPacketManager.a(this.a.b.c, null, this.a.b.j, this.a.b.d, 0);
                      try
                      {
                        FileUtils.a(paramDownloadTask, IndividualRedPacketManager.c, false);
                        bool1 = true;
                      }
                      catch (IOException localIOException)
                      {
                        for (;;)
                        {
                          bool1 = bool2;
                          if (QLog.isColorLevel())
                          {
                            QLog.e("IndividualRedPacketResDownloader", 2, "IndividualRedPacketResDownloader FileUtils.uncompressZip IOException:" + localIOException.getMessage());
                            bool1 = bool2;
                          }
                        }
                      }
                      if (bool1) {
                        break label1400;
                      }
                      localObject1 = new File(IndividualRedPacketManager.c);
                      paramDownloadTask = new File(paramDownloadTask);
                      if (QLog.isColorLevel()) {
                        QLog.d("IndividualRedPacketResDownloader", 2, "IndividualRedPacketResDownloader DownloaderFactory.unzipResource");
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1400:
    for (boolean bool2 = DownloaderFactory.a(paramDownloadTask, (File)localObject1, false);; bool2 = false)
    {
      if ((bool1) || (bool2))
      {
        if (!QLog.isColorLevel()) {
          break label304;
        }
        QLog.d("IndividualRedPacketResDownloader", 2, "IndividualRedPacketResDownloader DownloaderFactory.unzipResource:" + bool1 + ", unZipRet:" + bool2);
        break label304;
      }
      if (!QLog.isColorLevel()) {
        break label304;
      }
      QLog.e("IndividualRedPacketResDownloader", 2, "IndividualRedPacketResDownloader DownloaderFactory.unzipResource error;");
      break label304;
      localObject2 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.a.jdField_a_of_type_JavaUtilMap.get(localIOException);
      if ((localObject2 != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).a != null)) {
        ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).a.e = i;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback.a(paramDownloadTask.a, localIOException, k, bool1, localBundle);
      }
      if (bool1)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "1", String.valueOf(l), localIOException);
        break label304;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "0", String.valueOf(l), localIOException);
      break label304;
      localObject2 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.a.jdField_a_of_type_JavaUtilMap.get(localIOException);
      if ((localObject2 != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).b != null)) {
        ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).b.e = i;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback.a(paramDownloadTask.a, localIOException, k, bool1, localBundle);
      }
      if (bool1)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "1", String.valueOf(l), localIOException);
        break label304;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "0", String.valueOf(l), localIOException);
      break label304;
      localObject2 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.a.jdField_a_of_type_JavaUtilMap.get(localIOException);
      if ((localObject2 != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).c != null)) {
        ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).c.e = i;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback.a(paramDownloadTask.a, localIOException, k, bool1, localBundle);
      }
      if (bool1)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "1", String.valueOf(l), localIOException);
        break label304;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str, "0", String.valueOf(l), localIOException);
      break label304;
      break;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
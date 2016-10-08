import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class tk
  extends DownloadListener
{
  public tk(FontManager paramFontManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    this.a.a("Font_download_cancel", paramDownloadTask.b(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onCancel|font id=" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", isCancel=" + paramDownloadTask.b());
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    boolean bool3 = paramDownloadTask.a().getBoolean("isUpdate", false);
    boolean bool2 = false;
    boolean bool1;
    int i;
    if (paramDownloadTask.a() == 3)
    {
      long l1 = paramDownloadTask.h;
      long l2 = paramDownloadTask.g;
      bool1 = this.a.a(paramDownloadTask.b(), (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c));
      this.a.a("Font_download_succ", paramDownloadTask.b(), l1 - l2);
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "onDone| task:" + paramDownloadTask.b() + "status=" + paramDownloadTask.a() + ", iCancel=" + paramDownloadTask.b() + "succ=" + bool1);
      }
      if (!bool1) {
        break label433;
      }
      i = 0;
      label163:
      if (!paramDownloadTask.b()) {
        break label445;
      }
      int j = 2;
      i = j;
      if (bool3)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80067E6", 0, 0, Integer.toString(paramDownloadTask.b()), "2", "", "");
        i = j;
      }
    }
    label433:
    label439:
    label445:
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      String str2;
      if (bool3)
      {
        localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str2 = Integer.toString(paramDownloadTask.b());
        if (!bool1) {
          break label439;
        }
      }
      for (String str1 = "1";; str1 = "3")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80067E6", 0, 0, str2, str1, "", "");
        if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramDownloadTask.b(), i, paramDownloadTask.a());
        }
        bool2 = paramDownloadTask.a().getBoolean("needRefresh", false);
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "onDone download needRefresh = " + bool2);
        }
        if ((bool2) && (bool1)) {
          VasUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        return;
        bool1 = bool2;
        if (!bool3) {
          break;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80067E6", 0, 0, Integer.toString(paramDownloadTask.b()), "3", "", "");
        bool1 = bool2;
        break;
        i = -1;
        break label163;
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onProgress|fontId" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", isCancel=" + paramDownloadTask.b() + ", progress=" + paramDownloadTask.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onStart| task:" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", iCancel=" + paramDownloadTask.b());
    }
    if (!paramDownloadTask.a().containsKey("callbackId")) {
      this.a.a("AIO_Font_download", paramDownloadTask.b(), 0L);
    }
    for (;;)
    {
      super.onStart(paramDownloadTask);
      return true;
      this.a.a("Font_download", paramDownloadTask.b(), 0L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
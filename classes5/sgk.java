import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class sgk
  extends FMObserver
{
  sgk(sgj paramsgj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          paramString1 = BaseApplicationImpl.getContext().getString(2131362775);
          if (QLog.isColorLevel()) {
            QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
          }
          return;
        }
        if (paramBoolean)
        {
          if (!FMConfig.a) {
            break label174;
          }
          paramString1 = "183.61.37.13";
          paramInt1 = 443;
          if (QLog.isDevelopLevel()) {
            QLog.i("PreviewStep_1", 4, "SUCCESS OnFileDiscOfflinePreview harcode[" + FMConfig.a + "]");
          }
          sgj.a(this.a, paramString1, paramString4, paramInt1, paramString2, null);
          continue;
        }
        PreviewingOfflineFileView.b(this.a.a).runOnUiThread(new sgm(this));
      }
      finally {}
      continue;
      label174:
      paramInt1 = paramInt2;
      paramString1 = paramString3;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if ((paramBoolean) && (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = BaseApplicationImpl.getContext().getString(2131362775);
      if (QLog.isColorLevel()) {
        QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
      }
      return;
    }
    if (paramBoolean)
    {
      if (!FMConfig.a) {
        break label162;
      }
      paramString1 = "183.61.37.13";
      paramInt1 = 443;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PreviewStep_1", 4, "SUCCESS OnFileWeiYunPreview harcode[" + FMConfig.a + "]");
      }
      sgj.a(this.a, paramString1, paramString5, paramInt1, paramString2, paramString3);
      return;
      PreviewingOfflineFileView.c(this.a.a).runOnUiThread(new sgn(this));
      return;
      label162:
      paramInt1 = paramInt2;
      paramString1 = paramString4;
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          paramString1 = BaseApplicationImpl.getContext().getString(2131362775);
          if (QLog.isColorLevel()) {
            QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
          }
          return;
        }
        if (paramBoolean)
        {
          if (!FMConfig.a) {
            break label174;
          }
          paramString1 = "183.61.37.13";
          paramInt1 = 443;
          if (QLog.isDevelopLevel()) {
            QLog.i("PreviewStep_1", 4, "SUCCESS OnFileOfflinePreview harcode[" + FMConfig.a + "]");
          }
          sgj.a(this.a, paramString1, paramString4, paramInt1, paramString2, null);
          continue;
        }
        PreviewingOfflineFileView.a(this.a.a).runOnUiThread(new sgl(this));
      }
      finally {}
      continue;
      label174:
      paramInt1 = paramInt2;
      paramString1 = paramString3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
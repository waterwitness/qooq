import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class qgf
  extends DownloadListener
{
  public qgf(SignatureManager paramSignatureManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onDone| task:" + paramDownloadTask);
    }
    Object localObject = paramDownloadTask.a();
    if (localObject != null) {}
    for (int i = ((Bundle)localObject).getInt("resType");; i = 0)
    {
      switch (i)
      {
      }
      label298:
      for (;;)
      {
        return;
        if ((3 == paramDownloadTask.a()) || (paramDownloadTask.a() == 0))
        {
          SignatureManager.a(this.a).sendEmptyMessage(1);
          if (this.a.a != null)
          {
            paramDownloadTask = this.a.a.a().getSharedPreferences("sigResUpt", 0);
            i = paramDownloadTask.getInt("sigTplCfgVerTemp", 0);
            paramDownloadTask = paramDownloadTask.edit();
            paramDownloadTask.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8)
            {
              paramDownloadTask.commit();
              return;
            }
            paramDownloadTask.apply();
            return;
            if ((3 == paramDownloadTask.a()) || (paramDownloadTask.a() == 0))
            {
              i = ((Bundle)localObject).getInt("dynamicType");
              String str = ((Bundle)localObject).getString("tplId");
              localObject = ((Bundle)localObject).getString("fileName");
              paramDownloadTask = null;
              switch (i)
              {
              }
              for (;;)
              {
                if (paramDownloadTask == null) {
                  break label298;
                }
                paramDownloadTask = new File(paramDownloadTask);
                if (!DownloaderFactory.a(new File(SignatureTemplateConfig.a(str, (String)localObject)), paramDownloadTask, true)) {
                  break;
                }
                SignatureManager.a(this.a).sendEmptyMessage(3);
                return;
                paramDownloadTask = SignatureTemplateConfig.a(str, "dynamic_aio");
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onStart| task:" + paramDownloadTask);
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class mot
  extends DownloadListener
{
  public mot(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "fontNameDownloadListener.onCancel| task:" + paramDownloadTask);
    }
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "fontNameDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {
      return;
    }
    if (paramDownloadTask.a() == -1)
    {
      paramDownloadTask = new Message();
      paramDownloadTask.what = 17;
      this.a.a.sendMessage(paramDownloadTask);
      return;
    }
    paramDownloadTask = new Message();
    paramDownloadTask.what = 16;
    this.a.a.sendMessage(paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "fontNameDownloadListener.onStart| task:" + paramDownloadTask);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
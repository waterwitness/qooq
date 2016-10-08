import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class rpz
  implements DownloadListener
{
  public rpz(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadPause " + paramDownloadInfo.d);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898"))) {
      this.a.runOnUiThread(new rqc(this));
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadError " + paramDownloadInfo.d);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ("1101070898".equals(paramString1))
    {
      paramString1 = "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(UniformDownloadActivity.b(this.a)) + "&via=" + "ANDROIDQQ.POPUP.YYBDOWNAPP";
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.a, 2, "tmastUrl=" + paramString1);
      }
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.setFlags(268435456);
    }
    try
    {
      this.a.startActivity(paramString1);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.a, 2, "onDownloadUpdate " + localDownloadInfo.d);
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.b.equals("1101070898"))) {
        this.a.runOnUiThread(new rqb(this, localDownloadInfo));
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    this.a.runOnUiThread(new rqa(this));
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadFinish " + paramDownloadInfo.d);
    }
    this.a.runOnUiThread(new rqd(this));
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadCancel " + paramDownloadInfo.d);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
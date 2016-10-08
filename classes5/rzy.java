import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class rzy
  implements UniformDownloadUtil.GetFileInfoCallBack
{
  public rzy(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (UniformDownloadUtil.a(paramString))
    {
      StatisticAssist.a(this.a.a.getApplication().getApplicationContext(), this.a.a.a(), "Stop_download_2-2_3-0");
      return;
    }
    StatisticAssist.a(this.a.a.getApplication().getApplicationContext(), this.a.a.a(), "Stop_download_2-2_3-1");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
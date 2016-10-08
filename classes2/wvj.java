import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.base.img.ImageDownCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

public class wvj
  implements ImageDownCallback
{
  public wvj(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.d(DownloadManager.a, ">>download apk icon err,should load another size icon");
    ImageCache.a("app", ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, 75), null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
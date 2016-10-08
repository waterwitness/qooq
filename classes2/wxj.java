import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener;

public class wxj
  implements Runnable
{
  public wxj(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (ControlPolicyUtil.a(l))
    {
      if ((AppUtil.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k))) {
        AppUtil.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k);
      }
    }
    else {
      return;
    }
    LogUtility.c("MyAppApi", "root confused and remember user operation time!");
    ControlPolicyUtil.a(l);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import java.io.File;

class meq
  implements Runnable
{
  meq(meo parammeo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.s = null;
    this.a.a.t = true;
    this.a.a.a.a(this.a.a.getString(2131364914));
    if (new File(QQMapConstants.i).exists()) {
      UniformDownloadUtil.a(QQMapConstants.i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\meq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.activity.SecurityPickproofActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class mkc
  implements Runnable
{
  public mkc(SecurityPickproofActivity paramSecurityPickproofActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HttpDownloadUtil.a(this.a.d, this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
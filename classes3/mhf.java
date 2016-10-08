import com.tencent.mobileqq.activity.QQSpaceCleanActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class mhf
  implements Runnable
{
  public mhf(QQSpaceCleanActivity paramQQSpaceCleanActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HttpDownloadUtil.a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
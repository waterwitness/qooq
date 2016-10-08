import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;

public final class wak
  implements Runnable
{
  public wak()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileUtils.a(BaseApplicationImpl.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpFilterHelper;

public class pvx
  implements Runnable
{
  public pvx(ConfigHandler paramConfigHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    JumpFilterHelper.a().a(this.a.b.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class pxd
  implements Runnable
{
  public pxd(DiscussionIconHelper paramDiscussionIconHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = DeviceInfoUtil.a();
    int i = DeviceInfoUtil.b();
    if ((l != 0L) && (l < 1024L) && (i <= 1)) {
      DiscussionIconHelper.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
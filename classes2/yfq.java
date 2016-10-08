import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class yfq
  implements Runnable
{
  public yfq(DatalineRemoteManager paramDatalineRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatalineRemoteManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
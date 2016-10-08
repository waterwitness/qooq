import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yig
  implements Runnable
{
  public yig(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return;
    }
    WifiConversationManager.a().a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
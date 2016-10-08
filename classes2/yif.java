import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.AP;
import cooperation.qqhotspot.QQHotSpotHelper.APConnInfo;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import java.io.Serializable;

public class yif
  implements Runnable
{
  public yif(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Serializable localSerializable = this.jdField_a_of_type_AndroidOsBundle.getSerializable("APINFO");
    if ((localSerializable instanceof QQHotSpotHelper.AP))
    {
      WifiConversationManager.a().a((QQHotSpotHelper.AP)localSerializable);
      if (((QQHotSpotHelper.AP)localSerializable).ApConnInfo.ConnStatus == 2) {}
      WifiConversationManager.a().a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
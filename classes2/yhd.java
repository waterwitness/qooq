import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.WifiConversationManager;

public class yhd
  implements Runnable
{
  public yhd(WifiConversationManager paramWifiConversationManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WifiConversationManager.a(this.jdField_a_of_type_CooperationQqhotspotWifiConversationManager, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
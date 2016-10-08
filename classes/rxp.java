import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class rxp
  implements Runnable
{
  public rxp(OnlineFileSessionCenter paramOnlineFileSessionCenter, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OnlineFileSessionCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter, new rxq(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(OnlineFileSessionCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter), localIntentFilter);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
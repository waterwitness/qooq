import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class thz
  implements Runnable
{
  public thz(NearbyProxy paramNearbyProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(NearbyProxy.jdField_a_of_type_JavaLangString, 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    ((RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = NearbyMineHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
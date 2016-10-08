import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public class snt
  implements Runnable
{
  public snt(NearbyFragment paramNearbyFragment, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    long l = System.currentTimeMillis();
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l));
    NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment, StatisticConstants.a());
    if ((!this.jdField_a_of_type_Boolean) || (!NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment, this.jdField_a_of_type_AndroidContentIntent)))
    {
      Object localObject = null;
      Message localMessage = null;
      if (this.b)
      {
        localObject = localMessage;
        if (!this.c) {
          localObject = NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment);
        }
        NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment);
        NearbyFragment.b(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment);
      }
      localMessage = Message.obtain();
      localMessage.what = 7;
      localMessage.obj = localObject;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
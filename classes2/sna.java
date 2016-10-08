import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class sna
  implements Runnable
{
  public sna(MineFragment paramMineFragment, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MineFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment, this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a("100510.100523"));
    Object localObject;
    if (MineFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment) != null)
    {
      MineFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment).type.set(0);
      localObject = new BusinessInfoCheckUpdate.RedDisplayInfo();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set("-1");
      localRedTypeInfo.red_desc.set("");
      ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
      ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).tab_display_info.set(localRedTypeInfo);
      MineFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment).red_display_info.set((MessageMicro)localObject);
    }
    if (this.jdField_a_of_type_Boolean) {
      if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
      {
        localObject = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
        if (localObject != null)
        {
          ((NearbyHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
          this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.d = false;
        }
      }
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_AndroidOsHandler.obtainMessage(8, 0, 0).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
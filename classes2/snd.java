import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfigExtraVal;
import java.util.List;

public class snd
  implements Runnable
{
  public snd(MineFragment paramMineFragment, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyMyTabCard.NearbyMyTabConfig localNearbyMyTabConfig;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList != null) {
        break;
      }
    case 0: 
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList == null);
        this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.h();
        i = 0;
      } while (i >= this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.size());
      localNearbyMyTabConfig = (NearbyMyTabCard.NearbyMyTabConfig)this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.get(i);
      if ((localNearbyMyTabConfig == null) || (localNearbyMyTabConfig.redTouch == null) || (localNearbyMyTabConfig.extraVal == null)) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, i, 0, this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.a(localNearbyMyTabConfig)).sendToTarget();
      }
    case 100519: 
      this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.h();
      return;
    }
    int i = 0;
    label170:
    if (i < this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.size())
    {
      localNearbyMyTabConfig = (NearbyMyTabCard.NearbyMyTabConfig)this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.get(i);
      if ((localNearbyMyTabConfig != null) && (localNearbyMyTabConfig.redTouch != null) && (localNearbyMyTabConfig.extraVal != null)) {
        break label234;
      }
    }
    for (;;)
    {
      i += 1;
      break label170;
      break;
      label234:
      if (localNearbyMyTabConfig.extraVal.pathId == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, i, 0, this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.a(localNearbyMyTabConfig)).sendToTarget();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
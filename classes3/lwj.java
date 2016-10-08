import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class lwj
  extends FragmentPagerAdapter
{
  public HotChatFragment a;
  
  public lwj(NearbyActivity paramNearbyActivity, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    NearbyBaseFragment localNearbyBaseFragment = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.b(paramInt);
    if (localNearbyBaseFragment == null) {}
    switch (((Integer)this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a.get(paramInt)).intValue())
    {
    default: 
      return localNearbyBaseFragment;
    case 0: 
      return new NearbyFragment();
    case 1: 
      return new FreshNewsFragment();
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment = new HotChatFragment();
      }
      return this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
    }
    return new MineFragment();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
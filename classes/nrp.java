import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;

public class nrp
  implements View.OnClickListener
{
  public nrp(TroopRewardItemBuilder paramTroopRewardItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    TroopRewardMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
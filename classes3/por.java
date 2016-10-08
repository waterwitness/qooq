import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;

public class por
  implements View.OnClickListener
{
  public por(LebaListMgrAdapter paramLebaListMgrAdapter, RedTouch paramRedTouch, LebaViewItem paramLebaViewItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    LebaListMgrAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\por.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
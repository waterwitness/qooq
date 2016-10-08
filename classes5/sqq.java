import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.FreshNewsNotify;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sqq
  implements View.OnClickListener
{
  public sqq(FreshNewsNotifyAdapter paramFreshNewsNotifyAdapter, FreshNewsNotify paramFreshNewsNotify)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FreshNewsUtil.a(FreshNewsNotifyAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter), this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify.userTinyId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify.userNickName, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify.userAge, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify.userGender, 32);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
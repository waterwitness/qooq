import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class prg
  implements Runnable
{
  public prg(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a = new TextView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setBackgroundResource(2130843457);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentResResources));
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setTextSize(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131428258));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setText(2131369134);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a, localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
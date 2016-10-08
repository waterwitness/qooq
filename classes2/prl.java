import android.widget.TextView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class prl
  implements Runnable
{
  public prl(ApolloGuestsStateActivity paramApolloGuestsStateActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGuestsStateActivity.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGuestsStateActivity.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGuestsStateActivity.l = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int >= 999)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGuestsStateActivity.jdField_a_of_type_AndroidWidgetTextView.setText("999");
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGuestsStateActivity.l = 999;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
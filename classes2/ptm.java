import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class ptm
  implements Runnable
{
  public ptm(ApolloPanel paramApolloPanel, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a != null)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, 2, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getString(2131372312), 1).b(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
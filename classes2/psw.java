import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class psw
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public psw(ApolloLinearLayout paramApolloLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ApolloLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout);
  }
  
  public void run()
  {
    ViewParent localViewParent = ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout);
    ApolloLinearLayout.ViewHolder localViewHolder;
    if ((localViewParent != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout)) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView != null))
    {
      localViewHolder = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView.getTag();
      if ((localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.a.a != null) && (localViewHolder.a.a.status == 1)) {
        break label86;
      }
    }
    label86:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_Boolean = true;
      localViewParent.requestDisallowInterceptTouchEvent(true);
      ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout, 2);
    } while ((localViewHolder.a == null) || (localViewHolder.a.b == 1));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView, localViewHolder.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
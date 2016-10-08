import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.WeakReferenceHandler;

public class psa
  implements OnApolloViewListener
{
  public psa(ApolloStoreActivity paramApolloStoreActivity, DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.b != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.b.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(19, this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
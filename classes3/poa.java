import android.view.View;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class poa
  implements Runnable
{
  public poa(BaseWhatASmoothAdapter paramBaseWhatASmoothAdapter, View paramView, Object paramObject1, Object paramObject2, int paramInt, poc parampoc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_JavaLangObject != null) && (this.b != null) && ((this.b.equals(localObject)) || (localObject == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter.b + this.jdField_a_of_type_Int);
    }
    poc.a(this.jdField_a_of_type_Poc, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
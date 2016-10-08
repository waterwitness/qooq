import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.t9search.T9SearchResultAdapter;
import com.tencent.mobileqq.t9search.T9SearchableData;

public class uyh
  implements View.OnClickListener
{
  public uyh(T9SearchResultAdapter paramT9SearchResultAdapter, T9SearchableData paramT9SearchableData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(T9SearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter), QCallDetailActivity.class);
    paramView.putExtra("contactID", this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchableData.n);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchableData.h);
    paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchableData.o);
    paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchableData.b());
    T9SearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter).startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
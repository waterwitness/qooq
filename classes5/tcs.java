import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class tcs
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  int b;
  
  public tcs(RoamSearchDialog paramRoamSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.b == 0) {}
    while ((this.jdField_a_of_type_Int != this.b) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Tcz == null) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Tcz.b != true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(RoamSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, reach bottom, lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Tcz.a = true;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_Tcz.notifyDataSetChanged();
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.b;
    RoamSearchDialog localRoamSearchDialog = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog;
    paramInt = localRoamSearchDialog.k + 1;
    localRoamSearchDialog.k = paramInt;
    paramAbsListView.a(str1, str2, 5, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
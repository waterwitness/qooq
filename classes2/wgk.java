import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;

public final class wgk
  implements DialogInterface.OnClickListener
{
  public wgk(wgl paramwgl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.c, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_a_of_type_ArrayOfJavaLangString);
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
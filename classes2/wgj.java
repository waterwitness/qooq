import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public final class wgj
  implements DialogInterface.OnClickListener
{
  /* Error */
  public wgj(String paramString, int paramInt1, com.tencent.mobileqq.app.BaseActivity paramBaseActivity, int paramInt2, wgl paramwgl)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 16	wgj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5: aload_0
    //   6: iload_2
    //   7: putfield 18	wgj:jdField_a_of_type_Int	I
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 20	wgj:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 22	wgj:jdField_b_of_type_Int	I
    //   21: aload_0
    //   22: aload 5
    //   24: putfield 24	wgj:jdField_a_of_type_Wgl	Lwgl;
    //   27: aload_0
    //   28: invokespecial 27	java/lang/Object:<init>	()V
    //   31: getstatic 33	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   34: istore 6
    //   36: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	wgj
    //   0	37	1	paramString	String
    //   0	37	2	paramInt1	int
    //   0	37	3	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	37	4	paramInt2	int
    //   0	37	5	paramwgl	wgl
    //   34	1	6	bool	boolean
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VipOpenVipDialog", 2, "onClick:aid=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int == 1) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wgl != null) {
        VipUtils.a(this.jdField_a_of_type_Wgl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Wgl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wgl.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Wgl.c, this.jdField_a_of_type_Wgl.jdField_a_of_type_Int, this.jdField_a_of_type_Wgl.jdField_b_of_type_Int, this.jdField_a_of_type_Wgl.jdField_a_of_type_ArrayOfJavaLangString);
      }
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
      VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
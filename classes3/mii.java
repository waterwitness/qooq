import com.tencent.mobileqq.activity.RegisterBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class mii
  implements Runnable
{
  public mii(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131370504, new mij(this));
    localQQCustomDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class mki
  implements DialogInterface.OnClickListener
{
  public mki(SendMultiPictureHelper paramSendMultiPictureHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      this.a.b = true;
      SendMultiPictureHelper.a(this.a);
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
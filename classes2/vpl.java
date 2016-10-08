import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class vpl
  implements Runnable
{
  public vpl(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.b);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(this.jdField_a_of_type_Int), new vpm(this));
    localQQCustomDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
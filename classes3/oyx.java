import android.content.Context;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.CameraPreviewNew;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class oyx
  implements Runnable
{
  public oyx(CameraPreviewNew paramCameraPreviewNew, String paramString, int paramInt, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131362953);
    }
    localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131362952), new oyy(this));
    try
    {
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(CameraPreviewNew.a(), 2, "", localBadTokenException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
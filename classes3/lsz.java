import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsz
  implements Runnable
{
  public lsz(LoginActivity paramLoginActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a(this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.runOnUiThread(new lta(this, localBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
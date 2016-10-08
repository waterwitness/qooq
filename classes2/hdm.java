import android.app.Dialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hdm
  implements Runnable
{
  hdm(hdl paramhdl, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
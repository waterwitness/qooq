import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wah
  implements View.OnClickListener
{
  public wah(DialogInterface.OnClickListener paramOnClickListener1, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131301457) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_AndroidAppDialog, 0);
        }
        if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      if (paramView.getId() == 2131301458)
      {
        if (this.b != null) {
          this.b.onClick(this.jdField_a_of_type_AndroidAppDialog, 1);
        }
        try
        {
          if (this.jdField_a_of_type_AndroidAppDialog.isShowing())
          {
            this.jdField_a_of_type_AndroidAppDialog.dismiss();
            return;
          }
        }
        catch (Exception paramView) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
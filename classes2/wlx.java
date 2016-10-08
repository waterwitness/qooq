import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.DropdownView;

public class wlx
  implements View.OnClickListener
{
  public wlx(DropdownView paramDropdownView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Wma.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Wma.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Wma.getAdapter() != null) && (this.a.jdField_a_of_type_Wma.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean)) {
        DropdownView.a(this.a).postDelayed(new wly(this, paramView), 250L);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Wma.dismissDropDown();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
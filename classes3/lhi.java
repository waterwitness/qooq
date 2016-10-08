import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lhi
  implements Runnable
{
  lhi(lhh paramlhh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a.v);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(119, 119, 119));
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.rightViewText.setEnabled(true);
      return;
    }
    this.a.a.rightViewText.setEnabled(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
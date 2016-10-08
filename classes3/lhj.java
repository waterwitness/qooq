import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lhj
  implements Runnable
{
  lhj(lhh paramlhh, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lhh.a.a.setText(this.jdField_a_of_type_Lhh.a.v);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Lhh.a.m)
    {
      this.jdField_a_of_type_Lhh.a.a.setTextColor(-65536);
      this.jdField_a_of_type_Lhh.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_Lhh.a.a.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_Lhh.a.rightViewText.setEnabled(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;

class xzl
  implements Runnable
{
  xzl(xzk paramxzk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l2 = (System.currentTimeMillis() - this.a.a.jdField_a_of_type_JavaLangLong.longValue()) / 1000L;
    long l1 = l2;
    if (l2 >= this.a.a.jdField_b_of_type_Int)
    {
      l2 = this.a.a.jdField_b_of_type_Int;
      l1 = l2;
      if (!this.a.a.c)
      {
        this.a.a.c = true;
        l1 = l2;
        if (this.a.a.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          this.a.a.a(true);
          l1 = l2;
        }
      }
    }
    this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(l1 + "\"");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
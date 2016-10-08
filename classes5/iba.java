import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class iba
  implements Runnable
{
  iba(iaz paramiaz, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "scroll " + this.jdField_a_of_type_Int + " to top");
    }
    int i = this.jdField_a_of_type_Iaz.a.a.a.getChildAt(this.jdField_a_of_type_Int - this.jdField_a_of_type_Iaz.a.a.a.s()).getBottom();
    ReadInJoyBaseAdapter.a(this.jdField_a_of_type_Iaz.a.a).removeMessages(1001);
    this.jdField_a_of_type_Iaz.a.a.a.f(i, 1500);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
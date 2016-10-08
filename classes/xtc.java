import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.FastScroller;

public class xtc
  implements Runnable
{
  public xtc(FastScroller paramFastScroller)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k;
    int j;
    int i;
    if (this.a.jdField_a_of_type_ComTencentWidgetAbsListView.n)
    {
      this.a.f();
      k = this.a.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
      j = (int)this.a.jdField_a_of_type_Float - this.a.jdField_a_of_type_Int + 10;
      if (j >= 0) {
        break label100;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.c = i;
      this.a.a(this.a.c / (k - this.a.jdField_a_of_type_Int));
      this.a.b = false;
      return;
      label100:
      i = j;
      if (this.a.jdField_a_of_type_Int + j > k) {
        i = k - this.a.jdField_a_of_type_Int;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xtc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
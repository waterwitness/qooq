import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public class xtz
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private xtz(ListView paramListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public xtz a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xtz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
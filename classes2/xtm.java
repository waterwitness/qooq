import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class xtm
  implements Runnable
{
  public xtm(HorizontalListView paramHorizontalListView, xtr paramxtr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.y = -1;
    HorizontalListView.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
    if (!HorizontalListView.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView)) {
      this.jdField_a_of_type_Xtr.run();
    }
    HorizontalListView.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class xtr
  extends xtv
  implements Runnable
{
  public int a;
  
  private xtr(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b()) {}
    ListAdapter localListAdapter;
    int i;
    View localView;
    do
    {
      do
      {
        ((View)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getParent()).performClick();
        do
        {
          return;
        } while (HorizontalListView.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView));
        localListAdapter = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a;
        i = this.jdField_a_of_type_Int;
      } while ((localListAdapter == null) || (i == -1) || (i >= localListAdapter.getCount()) || (!a()));
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition());
    } while (localView == null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.performItemClick(localView, i, localListAdapter.getItemId(i));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
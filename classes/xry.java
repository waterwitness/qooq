import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xry
  extends xsc
  implements Runnable
{
  public int a;
  
  private xry(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.r) {}
    ListAdapter localListAdapter;
    int i;
    boolean bool;
    View localView;
    do
    {
      do
      {
        return;
        localListAdapter = this.jdField_a_of_type_ComTencentWidgetAbsListView.a;
        i = this.jdField_a_of_type_Int;
        bool = AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, i, this.jdField_a_of_type_ComTencentWidgetAbsListView.a.getCount());
      } while ((localListAdapter == null) || ((!bool) && (!AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView))) || (!a()));
      localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetAbsListView.au);
    } while ((localView == null) && (!AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    if (bool) {}
    for (long l = localListAdapter.getItemId(i);; l = 0L)
    {
      localAbsListView.a(localView, i, l);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
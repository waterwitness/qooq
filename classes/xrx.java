import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.MultiChoiceModeListener;

public class xrx
  implements AbsListView.MultiChoiceModeListener
{
  private AbsListView.MultiChoiceModeListener jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener;
  
  public xrx(AbsListView paramAbsListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener.a(paramActionMode, paramInt, paramLong, paramBoolean);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.e() == 0) {
      paramActionMode.finish();
    }
  }
  
  public void a(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener = paramMultiChoiceModeListener;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener.onCreateActionMode(paramActionMode, paramMenu))
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setLongClickable(false);
      bool = true;
    }
    return bool;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener.onDestroyActionMode(paramActionMode);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.a = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.i();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.r = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.t();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.requestLayout();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setLongClickable(true);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView$MultiChoiceModeListener.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
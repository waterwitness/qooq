import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rhi
  extends DataSetObserver
{
  rhi(rhh paramrhh, DragSortListView paramDragSortListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_Rhh.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Rhh.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
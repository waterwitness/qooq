import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsSpinner;

public class xse
{
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  
  public xse(AbsSpinner paramAbsSpinner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public View a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localView != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
    }
    return localView;
  }
  
  public void a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.a(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
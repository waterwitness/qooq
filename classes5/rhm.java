import android.util.SparseIntArray;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class rhm
{
  private int jdField_a_of_type_Int;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public rhm(DragSortListView paramDragSortListView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, -1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label77;
      }
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.delete(((Integer)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
      return;
      label77:
      this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
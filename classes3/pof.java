import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

class pof
  implements Runnable
{
  pof(poe parampoe, ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BuddyListAdapter.a(this.jdField_a_of_type_Poe.a, this.jdField_a_of_type_JavaUtilArrayList);
    BuddyListAdapter.a(this.jdField_a_of_type_Poe.a, this.jdField_a_of_type_AndroidUtilSparseArray);
    BuddyListAdapter.a(this.jdField_a_of_type_Poe.a, this.jdField_a_of_type_AndroidUtilSparseIntArray);
    ((FPSPinnedHeaderExpandableListView)this.jdField_a_of_type_Poe.a.a).c();
    BuddyListAdapter.a(this.jdField_a_of_type_Poe.a);
    if (BuddyListAdapter.a(this.jdField_a_of_type_Poe.a))
    {
      BuddyListAdapter.a(this.jdField_a_of_type_Poe.a, false);
      BuddyListAdapter.b(this.jdField_a_of_type_Poe.a);
      if ((BuddyListAdapter.a(this.jdField_a_of_type_Poe.a).a() != 0) && (BuddyListAdapter.a(this.jdField_a_of_type_Poe.a) >= 0)) {
        this.jdField_a_of_type_Poe.a.a.d(BuddyListAdapter.a(this.jdField_a_of_type_Poe.a));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
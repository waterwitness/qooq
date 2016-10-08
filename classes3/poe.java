import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class poe
  implements Runnable
{
  public poe(BuddyListAdapter paramBuddyListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = new SparseArray();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    BuddyListAdapter.a(this.a, localArrayList, localSparseArray, localSparseIntArray);
    ThreadManager.c().post(new pof(this, localArrayList, localSparseArray, localSparseIntArray));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
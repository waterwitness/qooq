import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;
import java.util.Map.Entry;

public class mwb
  implements Comparator
{
  public mwb(TroopMemberListActivity.ListAdapter paramListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    return ((Integer)paramEntry1.getKey()).compareTo((Integer)paramEntry2.getKey());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
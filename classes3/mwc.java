import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mwc
  implements Runnable
{
  public mwc(TroopMemberListActivity.ListAdapter paramListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;

public class poi
  implements ExpandableListView.OnGroupExpandListener
{
  public poi(BuddyListAdapter paramBuddyListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyListAdapter", 2, "onGroupExpand:" + paramInt);
    }
    this.a.a(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ojc
  extends TroopObserver
{
  public ojc(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class ojb
  extends FriendListObserver
{
  public ojb(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.a.a()) && (SystemMsgListView.a(this.a) != null))
    {
      if (paramBoolean)
      {
        SystemMsgListView.a(this.a).notifyDataSetChanged();
        AutoRemarkActivity.a(this.a.a.getActivity(), 0, paramString, 0L);
      }
    }
    else {
      return;
    }
    paramString = SystemMsgListView.a(this.a).getResources().getString(2131367430);
    QQToast.a(SystemMsgListView.a(this.a), 1, paramString, 0).b(this.a.a());
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
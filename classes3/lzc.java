import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

public class lzc
  extends FriendListObserver
{
  public lzc(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (paramBoolean1)
    {
      paramList = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramList != null) && (paramList.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramList = "暂无";; paramList = paramList.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramList);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      paramArrayOfObject = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramArrayOfObject != null) && (paramArrayOfObject.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramArrayOfObject = "暂无";; paramArrayOfObject = paramArrayOfObject.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramArrayOfObject);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      paramArrayOfObject = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramArrayOfObject != null) && (paramArrayOfObject.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramArrayOfObject = "暂无";; paramArrayOfObject = paramArrayOfObject.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramArrayOfObject);
      return;
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131370267, 1);
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
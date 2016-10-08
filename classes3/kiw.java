import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;

public class kiw
  extends BizTroopObserver
{
  public kiw(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    Switch localSwitch;
    AddFriendVerifyActivity localAddFriendVerifyActivity;
    if ((paramBoolean) && (paramInt1 == 1))
    {
      localSwitch = this.a.c.a();
      localSwitch.setOnCheckedChangeListener(null);
      localAddFriendVerifyActivity = this.a;
      if (paramInt2 != 1) {
        break label72;
      }
    }
    label72:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localAddFriendVerifyActivity.a = paramBoolean;
      localSwitch.setChecked(this.a.a);
      localSwitch.setOnCheckedChangeListener(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class lvu
  extends FriendListObserver
{
  public lvu(MoveToGroupActivity paramMoveToGroupActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131368710), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.removeObserver(MoveToGroupActivity.a(this.a));
      return;
      QQToast.a(this.a, 2, this.a.getString(2131368708), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
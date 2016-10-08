import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class mlc
  extends CardObserver
{
  public mlc(ShowReactiveActivity paramShowReactiveActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    Switch localSwitch;
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      localObject = this.a;
      localSwitch = this.a.a.a();
      if (paramBoolean2) {
        break label117;
      }
    }
    label117:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ShowReactiveActivity.a((ShowReactiveActivity)localObject, localSwitch, paramBoolean1);
      if (QLog.isColorLevel())
      {
        localObject = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
        QLog.d("interactive", 2, " ShowReactiveActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + ((Card)localObject).allowCalInteractive);
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    Card localCard;
    ShowReactiveActivity localShowReactiveActivity;
    Switch localSwitch;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
      localShowReactiveActivity = this.a;
      localSwitch = this.a.a.a();
      if (localCard.allowCalInteractive) {
        break label111;
      }
    }
    label111:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ShowReactiveActivity.a(localShowReactiveActivity, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, "ShowReactiveActivity onSetCalReactiveDays allowCalInteractive= " + localCard.allowCalInteractive);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
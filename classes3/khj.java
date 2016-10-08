import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class khj
  extends MessageObserver
{
  public khj(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (this.a.isFinishing()) {}
    SubAccountControll localSubAccountControll;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localSubAccountControll = (SubAccountControll)this.a.app.getManager(61);
        if (paramSubAccountBackProtocData.p != 1) {
          break;
        }
        if ((this.a.isResume()) && (SubAccountControll.a(this.a.app, "sub.uin.all")))
        {
          paramString = localSubAccountControll.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramSubAccountBackProtocData = (Pair)paramString.get(i);
            localSubAccountControll.a(this.a.app, this.a, paramSubAccountBackProtocData, new khk(this, localSubAccountControll, paramSubAccountBackProtocData));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localSubAccountControll.a(paramString, 1, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
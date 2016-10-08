import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class khi
  extends SubAccountBindObserver
{
  public khi(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.a(this.a, false);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
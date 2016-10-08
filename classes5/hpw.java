import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class hpw
  implements Runnable
{
  public hpw(PublicAccountManageActivity paramPublicAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PublicAccountManageActivity.a(this.a).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
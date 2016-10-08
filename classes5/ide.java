import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ide
  implements Runnable
{
  ide(idc paramidc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = true;
    SubscriptFeedsActivity.a(this.a.a).b = true;
    SubscriptFeedsActivity localSubscriptFeedsActivity = this.a.a;
    if (SubscriptFeedsActivity.a(this.a.a).g == 1) {}
    for (;;)
    {
      SubscriptFeedsActivity.a(localSubscriptFeedsActivity, false, bool, false);
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
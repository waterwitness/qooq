import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class idr
  implements Runnable
{
  public idr(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.a.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.e();
      this.a.leftView.post(new ids(this, i));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
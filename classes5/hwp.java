import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hwp
  implements Runnable
{
  public hwp(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.a.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.e();
      this.a.b(i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
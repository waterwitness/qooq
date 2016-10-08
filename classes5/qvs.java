import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvs
  implements Runnable
{
  public qvs(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BusinessCardEditActivity.a(this.a, this.a.a.cardName, this.a.a.company, this.a.a.mobilesNum);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
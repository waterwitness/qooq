import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hpg
  implements Runnable
{
  public hpg(PublicAccountBrowser paramPublicAccountBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a(this.a.getAppInterface(), false, this.a.ab);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "set subscribe full recommend switch = false , result : " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
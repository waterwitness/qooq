import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class htu
  extends MessageObserver
{
  public htu(EcShopAssistantActivity paramEcShopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    EcShopAssistantActivity.a(this.a);
  }
  
  protected void b()
  {
    EcShopAssistantActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
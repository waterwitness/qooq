import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.BannerConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class hub
  implements Comparator
{
  public hub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(EcShopAssistantManager.BannerConfig paramBannerConfig1, EcShopAssistantManager.BannerConfig paramBannerConfig2)
  {
    return paramBannerConfig1.a - paramBannerConfig2.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
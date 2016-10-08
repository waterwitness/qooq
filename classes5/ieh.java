import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ieh
  extends PublicAccountObserver
{
  public ieh(SubscriptRecommendController paramSubscriptRecommendController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ieh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
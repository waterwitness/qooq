import VipRecommend.MQQ.CommPayInfo;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.VIPRecommendPayObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class loy
  extends VIPRecommendPayObserver
{
  public loy(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a = ((CommPayInfo)paramObject);
      IndividuationSetActivity.a(this.a, this.a.a);
      return;
    }
    this.a.m = 1;
    this.a.e = "mvip.gexinghua.android.zbcenter_h5recall";
    IndividuationSetActivity.a(this.a, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\loy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
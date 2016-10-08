import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import java.util.ArrayList;

public class tiy
  extends NearbyCardObserver
{
  public tiy(NearbyGuideActivity paramNearbyGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new tiz(this, paramBoolean, paramInt1, paramArrayList));
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new tja(this, paramBoolean, paramInt1, paramArrayList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
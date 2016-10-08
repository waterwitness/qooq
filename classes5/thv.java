import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;

public class thv
  implements Runnable
{
  public thv(NearbyFlowerAnimationController paramNearbyFlowerAnimationController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyFlowerAnimationController.a(this.a);
    if (this.a.a != null) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
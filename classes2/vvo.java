import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.Options;

public class vvo
  implements Action.OnActionEndListener
{
  public vvo(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (TroopGiftToAllSurfaceView.a(this.a).d == 0) {
      this.a.a(1, TroopGiftToAllSurfaceView.a(this.a));
    }
    for (;;)
    {
      TroopGiftToAllSurfaceView.a(this.a).a.b();
      return;
      this.a.a(0, TroopGiftToAllSurfaceView.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
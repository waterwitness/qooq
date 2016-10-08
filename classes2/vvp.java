import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.ImageButton;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

public class vvp
  implements Action.OnActionEndListener
{
  public vvp(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, TroopGiftToAllSurfaceView.a(this.a), TroopGiftToAllSurfaceView.a(this.a) * 0.95F), new ScaleAction(400, TroopGiftToAllSurfaceView.a(this.a) * 0.95F, TroopGiftToAllSurfaceView.a(this.a)) });
    localSequenceAction.a = true;
    TroopGiftToAllSurfaceView.a(this.a).a(new Action[] { localSequenceAction });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
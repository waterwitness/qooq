import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.Label;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

public class vvr
  implements Action.OnActionEndListener
{
  public vvr(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    TroopGiftToAllSurfaceView.a(this.a).a(new Action[] { new OpacityAction(600, 0, 255), new SequenceAction(new Action[] { new ScaleAction(300, 0.0F, 1.2F), new ScaleAction(300, 1.2F, 1.0F) }) });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
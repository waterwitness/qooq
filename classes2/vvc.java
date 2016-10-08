import android.content.Context;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.Sprite;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

public class vvc
  implements ImageButton.OnClickListener
{
  public vvc(TroopGiftAnimationController paramTroopGiftAnimationController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Sprite paramSprite)
  {
    if (TroopGiftAnimationController.a(this.a) != null) {}
    for (paramSprite = "0";; paramSprite = "1")
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + TroopGiftAnimationController.a(this.a).frienduin, "" + TroopGiftUtil.a(TroopGiftAnimationController.a(this.a)), paramSprite, "" + TroopMemberUtil.a(TroopGiftAnimationController.a(this.a), TroopGiftAnimationController.a(this.a).a(), TroopGiftAnimationController.a(this.a).frienduin));
      paramSprite = TroopGiftAnimationController.a(this.a);
      if ((paramSprite == null) || (NetworkUtil.a(paramSprite) != 0)) {
        break;
      }
      ((TroopGiftToAllSurfaceView)this.a.a).b();
      paramSprite = paramSprite.getString(2131364197);
      ((TroopGiftToAllSurfaceView)this.a.a).a(paramSprite, TroopGiftAnimationController.a(this.a).m, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      return;
    }
    ((TroopGiftToAllSurfaceView)this.a.a).b();
    paramSprite = (TroopGiftManager)TroopGiftAnimationController.a(this.a).getManager(112);
    TroopGiftAnimationController.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    paramSprite.a(TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
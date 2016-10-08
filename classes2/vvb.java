import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;

public class vvb
  extends TroopGiftCallback
{
  public vvb(TroopGiftAnimationController paramTroopGiftAnimationController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView)
    {
      if ((TroopGiftAnimationController.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      TroopGiftAnimationController.a(this.a).a = 3;
      ((TroopGiftManager)TroopGiftAnimationController.a(this.a).getManager(112)).a(TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
      return;
    }
    String str1;
    String str2;
    if (paramInt == -1)
    {
      str1 = TroopGiftAnimationController.a(this.a).getResources().getString(2131365224);
      str2 = com.tencent.mobileqq.app.AppConstants.b[com.tencent.mobileqq.utils.NetworkUtil.a(TroopGiftAnimationController.a(this.a))];
      if (TroopGiftAnimationController.a(this.a) == null) {
        break label406;
      }
    }
    label374:
    label376:
    label406:
    for (paramString = "0";; paramString = "1")
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + TroopGiftAnimationController.a(this.a).frienduin, "" + TroopGiftUtil.a(TroopGiftAnimationController.a(this.a)), paramString, str2);
      for (paramString = str1;; paramString = TroopGiftAnimationController.a(this.a).getResources().getString(2131365225))
      {
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView instanceof TroopGiftToAllSurfaceView)) {
          break label374;
        }
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(paramString, TroopGiftAnimationController.a(this.a).m, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
        TroopGiftAnimationController.a(this.a).a = 2;
        if (TroopGiftAnimationController.a(this.a).c <= 0L) {
          break;
        }
        if (TroopGiftAnimationController.a(this.a).b <= TroopGiftAnimationController.a(this.a).c + 3000L) {
          break label376;
        }
        return;
      }
      break;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(TroopGiftAnimationController.a(this.a));
      this.a.a(2000L);
      break;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView)
    {
      if ((TroopGiftAnimationController.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView == null)) {
        return;
      }
    }
    TroopGiftAnimationController.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    TroopGiftAnimationController.a(this.a).a = 2;
    if (TroopGiftAnimationController.a(this.a).c > 0L)
    {
      if (TroopGiftAnimationController.a(this.a).b > TroopGiftAnimationController.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(TroopGiftAnimationController.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = TroopGiftAnimationController.a(this.a).l;; paramInt1 = TroopGiftAnimationController.a(this.a).m)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(paramString, paramInt1, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).b();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
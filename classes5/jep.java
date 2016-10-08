import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

public class jep
  implements Runnable
{
  public jep(TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", 0, 0, this.a.a(), "", this.a.c, "" + TroopMemberUtil.a((AppInterface)this.a.a.get(), ((AppInterface)this.a.a.get()).a(), this.a.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
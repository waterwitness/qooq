import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jev
  extends TroopGiftCallback
{
  public jev(TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_fail", 0, 0, this.a.a(), "", this.a.c, "" + TroopMemberUtil.a((AppInterface)this.a.a.get(), ((AppInterface)this.a.a.get()).a(), this.a.a()));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult productId = " + paramInt);
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_suc", 0, 0, this.a.a(), "", this.a.c, "" + TroopMemberUtil.a((AppInterface)this.a.a.get(), ((AppInterface)this.a.a.get()).a(), this.a.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
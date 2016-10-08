import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jeq
  extends TroopGiftCallback
{
  public jeq(TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "onGetStockResult count = " + paramInt);
    }
    this.a.e = paramInt;
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      this.a.b.setText(paramInt + "");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new jer(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "onGetStockResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "fail_expbean", 0, 0, this.a.a(), "", this.a.c, "" + TroopMemberUtil.a((AppInterface)this.a.a.get(), ((AppInterface)this.a.a.get()).a(), this.a.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
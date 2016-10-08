import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jes
  implements URLDrawable.DownloadListener
{
  public jes(TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.a.b.setCompoundDrawables(null, null, null, null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
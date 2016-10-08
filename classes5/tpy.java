import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil.NRNReportAction;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;

class tpy
  implements DialogInterface.OnClickListener
{
  tpy(tpx paramtpx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.e();
    this.a.a.a(new NRNReportUtil.NRNReportAction("actNAUserChooseLoadSo", this.a.a.getCurrentAccountUin(), this.a.a.a, true, 0));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
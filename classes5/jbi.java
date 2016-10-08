import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class jbi
  implements WXShareHelper.WXShareListener
{
  public jbi(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.m == null) || (!this.a.m.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QRUtils.a(1, 2131369518);
      return;
    }
    QRUtils.a(2, 2131369517);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
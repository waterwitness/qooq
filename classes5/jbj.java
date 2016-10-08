import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class jbj
  implements AdapterView.OnItemClickListener
{
  public jbj(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.c.dismiss();
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131369529;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(this.a, this.a.getString(i), 0).b(this.a.getTitleBarHeight());
        this.a.l = -1;
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131369530;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("QRDisplayActivity", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
        }
        this.a.l = ((int)paramLong);
        QRDisplayActivity.a(this.a);
        return;
      }
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
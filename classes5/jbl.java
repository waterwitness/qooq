import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jbl
  implements ActionSheet.OnButtonClickListener
{
  public jbl(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    this.a.l = -1;
    this.a.d = true;
    this.a.c.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jbx
  implements ActionSheet.OnButtonClickListener
{
  public jbx(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    this.a.d = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      if (!this.a.a)
      {
        this.a.e();
        if ((this.a.k & 0x1) != 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
          continue;
          if (!this.a.a)
          {
            this.a.f();
            if ((this.a.k & 0x1) != 0)
            {
              ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
              continue;
              if (!this.a.a)
              {
                this.a.d();
                if ((this.a.k & 0x1) != 0) {
                  ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                }
                if (this.a.g == 2) {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_save", 0, 0, this.a.h, "", "", String.valueOf(this.a.e));
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
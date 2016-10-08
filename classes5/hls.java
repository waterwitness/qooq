import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hls
  implements ActionSheet.OnButtonClickListener
{
  public hls(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.s) {
      return;
    }
    this.a.s = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.c.dismiss();
      return;
      this.a.m = false;
      this.a.w();
      if (((EcShopAssistantManager)this.a.a.getManager(87)).a(this.a.p)) {
        ((EcshopReportHandler)this.a.a.a(88)).a(134243868, this.a.p, null, null, null, 2L, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
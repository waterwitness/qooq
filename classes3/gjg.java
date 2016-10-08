import android.content.res.Resources;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class gjg
  implements WXShareHelper.WXShareListener
{
  public gjg(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.b == null) || (!this.a.b.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a, 1, 2131369518, 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    QQToast.a(this.a, 2, 2131369517, 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
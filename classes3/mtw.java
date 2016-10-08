import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;

public class mtw
  extends ClickableSpan
{
  public mtw(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (OlympicManager)this.a.app.getManager(166);
    if (this.a.app.f().equals(String.valueOf(this.a.a.memberUin))) {
      if (((OlympicManager)localObject).c("HomePage"))
      {
        paramView = String.format("http://sqimg.qq.com/qq_product_operations/olympic/detail.html?_wv=16777216&uin=%s&adtag=%s", new Object[] { NearbyURLSafeUtil.a(this.a.app.a()), "profileCard" });
        localObject = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramView));
        this.a.startActivity((Intent)localObject);
      }
    }
    for (;;)
    {
      OlympicUtil.a(this.a.app, "0X8006890", 3, Long.toString(this.a.a.memberUin));
      return;
      localObject = String.format("http://sqimg.qq.com/qq_product_operations/olympic/detail.html?_wv=16777216&uin=%s&adtag=%s", new Object[] { NearbyURLSafeUtil.a(String.valueOf(this.a.a.memberUin)), "profileCard" });
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLUtil.guessUrl((String)localObject));
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
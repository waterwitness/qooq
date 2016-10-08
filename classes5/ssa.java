import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

class ssa
  implements DialogInterface.OnClickListener
{
  ssa(srx paramsrx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", this.a.a.a.a());
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.a.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
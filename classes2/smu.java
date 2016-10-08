import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class smu
  implements DialogInterface.OnClickListener
{
  public smu(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", this.a.a.a());
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
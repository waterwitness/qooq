import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.qphone.base.util.BaseApplication;

class swf
  implements LoginKeyHelper.GetLoginKeyListener
{
  swf(swe paramswe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.a.a.a.a.a().a != null))
    {
      paramString = new Intent("qq.launch.login");
      paramString.putExtras(this.a.a.a.a.a().a.getExtras());
      paramString.putExtra("withlogin", true);
      paramString.putExtra("pluginflag", true);
      paramString.putExtra("pluginid", "Live");
      paramString.putExtra("hosttype", String.valueOf(2));
      BaseApplicationImpl.getContext().sendBroadcast(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
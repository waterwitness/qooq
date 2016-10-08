package cooperation.comic;

import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class VipComicProxyActivity
  extends PluginProxyActivity
{
  public VipComicProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Class a(String paramString)
  {
    if (paramString.equals("com.qqcomic.activity.reader.VipComicLandReadingActivity")) {
      return VipComicLandReaderProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.reader.VipComicPortraitReadingActivity")) {
      return VipComicPortraitReaderProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.VipComicTranslucentBrowserActivity")) {
      return VipComicTranslucentBrowserActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.media.VipComicMediaPlayActivity")) {
      return VipComicPlayProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.VipComicMainTabActivity")) {
      return VipComicProxyActivity.SingleTop.class;
    }
    return VipComicProxyActivity.class;
  }
  
  public String getPluginID()
  {
    return "comic_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
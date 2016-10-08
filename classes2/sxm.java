import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.IOException;

public class sxm
  implements Runnable
{
  public sxm(DataApiPlugin paramDataApiPlugin, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    i = 200;
    Object localObject1 = null;
    try
    {
      localObject2 = HttpUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_AndroidOsBundle);
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        i = 0;
        localIOException.printStackTrace();
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqJspDataApiPlugin.mRuntime.a();
    if ((!TextUtils.isEmpty(this.c)) && (localObject2 != null)) {
      ((Activity)localObject2).runOnUiThread(new sxn(this, (Activity)localObject2, (String)localObject1, i));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
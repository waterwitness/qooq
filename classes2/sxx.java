import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;
import org.json.JSONObject;

public class sxx
  implements Runnable
{
  public sxx(QQApiPlugin paramQQApiPlugin, HashMap paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject, String paramString5, String paramString6, String paramString7, int paramInt, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = HttpUtil.a(this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject1 = (String)((HashMap)localObject2).get("share_url");
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      String str1 = (String)((HashMap)localObject2).get("image_url");
      if (str1 == null) {
        str1 = this.b;
      }
      for (;;)
      {
        String str2 = (String)((HashMap)localObject2).get("flash_url");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = this.c;
        }
        localObject1 = new sxy(this, (String)localObject1, str1, (String)localObject2);
        if (this.jdField_a_of_type_AndroidAppActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
        {
          this.jdField_a_of_type_AndroidAppActivity.runOnUiThread((Runnable)localObject1);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a().runOnUiThread((Runnable)localObject1);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
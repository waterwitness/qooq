import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import java.io.File;
import java.util.HashMap;

public final class wsl
  implements Runnable
{
  public wsl(Bundle paramBundle1, Bundle paramBundle2, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool;
    Object localObject1;
    Object localObject2;
    Intent localIntent;
    Bundle localBundle;
    label172:
    Object localObject3;
    if (Common.a(this.jdField_a_of_type_AndroidOsBundle.getString("schemaUrl")).get("auto_download") != null)
    {
      bool = true;
      if (!MyAppApi.a().a(CommonDataAdapter.a().a(), this.jdField_b_of_type_AndroidOsBundle, bool, false))
      {
        localObject1 = Common.i() + File.separator + "qapp_center_detail.htm";
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          LogUtility.d(AppClient.jdField_a_of_type_JavaLangString, "file" + (String)localObject1 + " not exist copyassets.");
          FileUtils.a("Page/system", Common.j());
        }
        localIntent = new Intent();
        localBundle = new Bundle();
        if (!((File)localObject2).exists()) {
          break label420;
        }
        localObject2 = "file:///" + (String)localObject1;
        localObject3 = "&from=-10&id=" + this.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject1 = localObject3;
          if (this.jdField_b_of_type_JavaLangString.contains("channelId")) {}
        }
        else
        {
          localObject1 = (String)localObject3 + "&channelId=" + this.c;
        }
        if (!bool) {
          break label481;
        }
        localObject1 = (String)localObject1 + "&auto_download=1";
      }
    }
    label420:
    label451:
    label481:
    for (;;)
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
          break label451;
        }
      }
      for (localObject3 = localObject1;; localObject3 = (String)localObject1 + "&" + this.jdField_b_of_type_JavaLangString)
      {
        localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
        localBundle.putString("APP_URL", (String)localObject2);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        LogUtility.b("Jie", "APP_URL:" + (String)localObject2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
        localIntent.putExtras(localBundle);
        localIntent.putExtra("adapter_action", "action_app_detail");
        localIntent.addFlags(872415232);
        CommonDataAdapter.a().a().startActivity(localIntent);
        return;
        bool = false;
        break;
        localObject2 = Common.p() + File.separator + "qapp_center_detail.htm";
        break label172;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
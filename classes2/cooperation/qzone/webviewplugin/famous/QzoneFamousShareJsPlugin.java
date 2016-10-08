package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneActionSheetAdapter;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import java.io.PrintStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import yrz;
import ysa;

public class QzoneFamousShareJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a;
  public static String b = "Qzone";
  public static String c = "famous_uin";
  public static String d = "title";
  public static String e = "summary";
  public static String f = "thumb_photo_url";
  public static String g = "detail_url";
  public static String h = "is_followed";
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QzoneFamousShareJsPlugin.class.getSimpleName();
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      paramArrayOfString = ((JSONObject)localObject).getString("famous_uin");
      String str1 = ((JSONObject)localObject).getString("title");
      String str2 = ((JSONObject)localObject).getString("summary");
      String str3 = ((JSONObject)localObject).getString("thumb_photo_url");
      localObject = ((JSONObject)localObject).getString("detail_url");
      System.out.println("---------title:" + str1 + ",summary:" + str2 + ",thumb_photo_url" + str3 + ",detail_url:" + (String)localObject);
      Intent localIntent = new Intent();
      localIntent.putExtra(c, paramArrayOfString);
      localIntent.putExtra(d, str1);
      localIntent.putExtra(e, str2);
      localIntent.putExtra(f, str3);
      localIntent.putExtra(g, (String)localObject);
      b(paramActivity, localIntent);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void b(Activity paramActivity, Intent paramIntent)
  {
    QzoneActionSheetAdapter localQzoneActionSheetAdapter = QzoneActionSheetAdapter.a(paramActivity, new int[] { 0, 1, 2, 3, 6 });
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = QzoneActionSheetAdapter.a(paramActivity, localQzoneActionSheetAdapter, new yrz(this, paramActivity, paramIntent), new ysa(this));
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private static void c(Activity paramActivity, Intent paramIntent)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramIntent.getStringExtra(f));
    localQZoneShareData.a = ((ArrayList)localObject);
    localQZoneShareData.b = paramIntent.getStringExtra(d);
    localQZoneShareData.c = paramIntent.getStringExtra(e);
    localQZoneShareData.g = 2;
    localQZoneShareData.d = paramIntent.getStringExtra(g);
    localQZoneShareData.h = 0;
    localObject = new Intent();
    ((Intent)localObject).setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
    paramIntent.putExtra("qzone_uin", QZoneHelper.UserInfo.a().jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("extraIntentKeyParcelable", localQZoneShareData);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(b)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("showShareMenu")) {
      return false;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), paramVarArgs);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\famous\QzoneFamousShareJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
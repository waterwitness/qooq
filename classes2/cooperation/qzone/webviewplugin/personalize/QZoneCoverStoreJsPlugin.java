package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.Size;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import ysb;
import ysc;
import ysd;

public class QZoneCoverStoreJsPlugin
  extends WebViewPlugin
{
  public static final int a = 0;
  public static final String a = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  public static final int b = 1;
  public static final String b = "CoverStore";
  public static final int c = 2;
  public static final String c = "QzCover";
  public static final int d = 3;
  public static final String d = "goToPhotoWall";
  public static final int e = 4;
  public static final String e = "goToUserDefine";
  public static final int f = 5;
  public static final String f = "setCover";
  public static final int g = 6;
  public static final String g = "setLocalCover";
  public static final int h = 1;
  public static final String h = "setWidgetEnable";
  public static final int i = 2;
  public static final String i = "setWidget";
  public static final String j = "openYellowDiamond";
  public static final String k = "showStoreButton";
  public static final String l = "getWidgetEnable";
  public static final String m = "leftButtonClick";
  private static final int n = 0;
  public static final String n = "openVipInfo";
  private static final int o = 1;
  public static final String o = "forwardSelectVideoCover";
  public static final String r = "com.tencent.mobileqq.action.ACTION_WEBVIEW_UPLOADING_VIDEO_COVER";
  public static final String s = "com.tencent.msg.permission.pushnotify";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private volatile boolean jdField_a_of_type_Boolean;
  public int j;
  public int k;
  public int l;
  public int m;
  private int p;
  public String p;
  String q;
  
  public QZoneCoverStoreJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 0;
    this.k = 4;
    this.jdField_p_of_type_JavaLangString = "";
    this.q = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ysd(this);
    this.mPluginNameSpace = "QzCover";
  }
  
  private int a(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    int i1 = paramInt;
    if ((localActivity instanceof WebViewPluginContainer)) {
      i1 = ((WebViewPluginContainer)localActivity).switchRequestCode(this, (byte)paramInt);
    }
    return i1;
  }
  
  private int a(String paramString)
  {
    try
    {
      int i1 = new JSONObject(paramString).getInt("widgetId");
      return i1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private String a()
  {
    switch (this.k)
    {
    case 4: 
    default: 
      return "jhan-cover1";
    case 1: 
      return "jhan-cover1";
    case 5: 
      return "jhan-cover1b";
    case 2: 
      return "jhan-cover2";
    case 6: 
      return "jhan-cover2b";
    case 3: 
      return "jhan-ziliaocover";
    }
    return "jhan-ziliaocoverb";
  }
  
  private String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("type");
      try
      {
        String str = localJSONObject.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome"))) {}
        for (this.j = 0;; this.j = 1)
        {
          this.k = Integer.parseInt(localJSONObject.getString("page"));
          return paramString;
        }
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      IntentFilter localIntentFilter;
      Activity localActivity;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CoverStore", 2, "video cover registerBroadcast start");
        }
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_UPLOADING_VIDEO_COVER");
        localActivity = this.mRuntime.a();
      } while ((localActivity == null) || (this.jdField_a_of_type_Boolean));
      try
      {
        localActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("CoverStore", 2, "regist receiver error:" + localException.toString());
  }
  
  private void a(int paramInt)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
      return;
    }
    int i2 = this.mRuntime.a().getResources().getDimensionPixelSize(2131492908);
    if (!QZoneHelper.d()) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      QQToast.a(this.mRuntime.a(), 2131367099, 0).b(i2);
      return;
    }
    a();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.mRuntime.a().a();
      BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
      localBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString = localUserInfo.jdField_a_of_type_JavaLangString;
      localBaseBusinessAlbumInfo.jdField_a_of_type_Long = this.mRuntime.a().getLongAccountUin();
      localBaseBusinessAlbumInfo.c = 10;
      localBaseBusinessAlbumInfo.d = 10;
      localBaseBusinessAlbumInfo.b = this.mRuntime.a().getString(2131367015);
      QZoneHelper.a(this.mRuntime.a(), localUserInfo, localBaseBusinessAlbumInfo, -1, "cover_mall_record_video");
      return;
    }
    QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
    QZoneVideoCommonUtils.a(this.mRuntime.a().getLongAccountUin(), this.mRuntime.a(), "cover_mall_record_video", new ysc(this, i2));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CoverStore", 2, "video cover setting start,notify to h5");
    }
    for (;;)
    {
      int i1;
      JSONObject localJSONObject;
      try
      {
        i1 = paramIntent.getIntExtra("PhotoConst.VIDEO_TYPE", -1);
        str = paramIntent.getStringExtra("thumbnail_path");
        if (TextUtils.isEmpty(str)) {
          break;
        }
        localJSONObject = new JSONObject();
        if (i1 == 2)
        {
          localJSONObject.put("type", 1);
          localJSONObject.put("picurl", str);
          localJSONObject.put("videoid", paramIntent.getStringExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID"));
          localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
          localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
          localJSONObject.put("videourl", paramIntent.getStringExtra("file_send_path"));
          paramIntent = "window.QZVideoCoverJSInterface.onSetCover(" + localJSONObject.toString() + ")";
          callJs(paramIntent);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        QLog.e("CoverStore", 1, paramIntent, new Object[] { "toBase64 error " });
        return;
      }
      if ((i1 != 0) && (1 != i1)) {
        break label436;
      }
      Object localObject = QzoneDynamicAlbumPlugin.a(str);
      if (localObject == null) {
        break;
      }
      double d1 = QzoneDynamicAlbumPlugin.a((QzoneDynamicAlbumPlugin.Size)localObject);
      if (d1 > 0.0D)
      {
        ((QzoneDynamicAlbumPlugin.Size)localObject).a = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).a / d1));
        ((QzoneDynamicAlbumPlugin.Size)localObject).b = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).b / d1));
      }
      localObject = QzoneDynamicAlbumPlugin.a(str, ((QzoneDynamicAlbumPlugin.Size)localObject).a, ((QzoneDynamicAlbumPlugin.Size)localObject).b);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.w("CoverStore", 1, "video cover pic not exist,imageBase64 empty. path=" + str);
        return;
      }
      String str = "data:image/jpg;base64," + (String)localObject;
      localJSONObject.put("type", 0);
      localJSONObject.put("data", str);
      localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
      localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
    }
    label436:
    QLog.w("CoverStore", 1, "unknown video type");
  }
  
  private void a(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {}
    }
    while ((!"QzoneAlbum".equals(paramString)) || (this.mRuntime.a() == null))
    {
      return;
      paramString = new Intent(this.mRuntime.a(), PhotoListActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      ((AbsBaseWebViewActivity)this.mRuntime.a()).a(this, paramString, (byte)2);
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", 2);
    Object localObject = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    QZoneHelper.a(this.mRuntime.a(), (QZoneHelper.UserInfo)localObject, paramString, a(3));
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i1);
          if (TextUtils.isEmpty(str)) {
            break label232;
          }
          Object localObject = QzoneDynamicAlbumPlugin.a(str);
          if (localObject == null) {
            break label232;
          }
          double d1 = QzoneDynamicAlbumPlugin.a((QzoneDynamicAlbumPlugin.Size)localObject);
          if (d1 > 0.0D)
          {
            ((QzoneDynamicAlbumPlugin.Size)localObject).a = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).a / d1));
            ((QzoneDynamicAlbumPlugin.Size)localObject).b = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).b / d1));
          }
          str = QzoneDynamicAlbumPlugin.a(str, ((QzoneDynamicAlbumPlugin.Size)localObject).a, ((QzoneDynamicAlbumPlugin.Size)localObject).b);
          if (TextUtils.isEmpty(str)) {
            break label232;
          }
          localObject = new JSONObject();
          ((JSONObject)localObject).put("type", this.q);
          ((JSONObject)localObject).put("data", "" + "data:image/jpg;base64," + str);
          callJs("window.QZImagePickerJSInterface.onReceive(" + ((JSONObject)localObject).toString() + ")");
        }
      }
      catch (Exception paramArrayList)
      {
        QLog.e("CoverStore", 1, "toBase64: " + paramArrayList);
      }
      return;
      label232:
      i1 += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("enable");
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome")))
        {
          this.j = 0;
          this.k = Integer.parseInt(paramString.getString("page"));
          this.jdField_p_of_type_JavaLangString = paramString.getString("aid");
          str = paramString.optString("viptype", "COMMON_VIP");
          if ("STAR_VIP".equals(str))
          {
            this.l = 3;
            this.m = paramString.optInt("openmonth", 0);
          }
        }
        else
        {
          this.j = 1;
          continue;
        }
        if (!"COMMON_VIP".equals(str)) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.l = 1;
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      this.jdField_p_of_type_Int = new JSONObject(paramString).optInt("source", 0);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934600L)
    {
      int i1 = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      int i2 = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (((i1 == a(2)) || (i1 == a(3))) && (i2 == -1))
      {
        callJs("window.QZImagePickerJSInterface.doSelectPhoto");
        paramMap = new ArrayList();
        paramString = paramString.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramString))
        {
          paramMap.add(paramString);
          a(paramMap);
        }
      }
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzCover".equals(paramString2)) {
      return false;
    }
    if (paramString3.equals("goToPhotoWall"))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        b(paramVarArgs[0]);
      }
      return true;
    }
    if (paramString3.equals("showStoreButton"))
    {
      if (this.mRuntime.a() == null) {
        return false;
      }
      paramJsBridgeListener = (TextView)this.mRuntime.a().findViewById(2131297183);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText("背景商城");
        paramJsBridgeListener.setOnClickListener(new ysb(this));
      }
    }
    do
    {
      for (;;)
      {
        return false;
        if (paramString3.equals("goToUserDefine"))
        {
          this.q = a(paramVarArgs[0]);
          a(this.q);
          return true;
        }
        if ("forwardSelectVideoCover".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            c(paramVarArgs[0]);
          }
          a(this.jdField_p_of_type_Int);
          return true;
        }
        if (paramString3.equals("setWidgetEnable"))
        {
          boolean bool = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 3);
          paramJsBridgeListener.putExtra("widgetEnable", bool);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(6));
          }
        }
        else if (paramString3.equals("setWidget"))
        {
          int i1 = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 2);
          paramJsBridgeListener.putExtra("widgetId", i1);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(5));
          }
        }
        else
        {
          if (!paramString3.equals("openYellowDiamond")) {
            break;
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            b(paramVarArgs[0]);
          }
          if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
            return false;
          }
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new Intent();
          paramString2 = this.mRuntime.a().getResources().getString(2131366901);
          QzonePluginProxyActivity.a(paramString1, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
          if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
            this.jdField_p_of_type_JavaLangString = a();
          }
          paramString1.putExtra("aid", this.jdField_p_of_type_JavaLangString);
          paramString1.putExtra("success_tips", paramString2);
          paramString1.putExtra("direct_go", true);
          paramString1.putExtra("viptype", this.l);
          paramString1.putExtra("month", this.m);
          QzonePluginProxyActivity.a(this.mRuntime.a(), paramJsBridgeListener, paramString1, a(4));
        }
      }
      if (paramString3.equals("setCover"))
      {
        if ((paramVarArgs != null) && (!TextUtils.isEmpty(paramVarArgs[0]))) {
          try
          {
            if (("PhotoWallCover".equals(new JSONObject(paramVarArgs[0]).getString("coverType"))) && (this.mRuntime.a() != null))
            {
              paramJsBridgeListener = this.mRuntime.a();
              if (paramJsBridgeListener != null) {
                return true;
              }
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = new Intent();
            QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
            paramJsBridgeListener.putExtra("open_what", 4);
            paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
            if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
              QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(7));
            }
          }
        }
        return true;
      }
      if ("setLocalCover".equals(paramString3))
      {
        if ((paramVarArgs == null) || (TextUtils.isEmpty(paramVarArgs[0]))) {
          return true;
        }
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 6);
        paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
        if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
          QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(8));
        }
        return true;
      }
      if (paramString3.equals("getWidgetEnable"))
      {
        if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
          return false;
        }
        paramString1 = "Widget_" + this.mRuntime.a().a();
        paramJsBridgeListener.a(Boolean.valueOf(this.mRuntime.a().getSharedPreferences(paramString1, 4).getBoolean("WidgetShow", true)));
        return true;
      }
    } while (!paramString3.equals("leftButtonClick"));
    if (this.mRuntime.a() == null) {
      return false;
    }
    ((TextView)this.mRuntime.a().findViewById(2131297083)).performClick();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt == -1) {}
    Object localObject;
    switch (paramByte)
    {
    case 1: 
    case 5: 
    case 6: 
    default: 
    case 7: 
    case 8: 
    case 4: 
      for (;;)
      {
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("need_jump", false)) && (this.mRuntime.a() != null))
        {
          this.mRuntime.a().finish();
          return;
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("needJump", false)) && (this.mRuntime.a() != null))
          {
            this.mRuntime.a().finish();
            return;
            if (paramInt == -1)
            {
              localObject = this.mRuntime.a();
              if (localObject != null)
              {
                ((CustomWebView)localObject).c("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
                if (paramIntent != null) {
                  try
                  {
                    paramIntent = paramIntent.getExtras().getString("qzone_vip_open_succ_str");
                    if (!TextUtils.isEmpty(paramIntent))
                    {
                      paramIntent = new JSONObject(paramIntent);
                      dispatchJsEvent("openVipInfo", paramIntent, paramIntent);
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    QLog.e("CoverStore", 2, paramIntent.getMessage());
                    return;
                  }
                }
              }
            }
          }
        }
      }
    case 2: 
      callJs("window.QZImagePickerJSInterface.doSelectPhoto");
      localObject = new ArrayList();
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        ((ArrayList)localObject).add(paramIntent);
      }
      a((ArrayList)localObject);
      return;
    }
    callJs("window.QZImagePickerJSInterface.doSelectPhoto");
    a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
  }
  
  protected void onDestroy()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.jdField_a_of_type_Boolean)) {}
    try
    {
      localActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CoverStore", 2, localException, new Object[] { "unregisterReceiver exception" });
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZoneCoverStoreJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
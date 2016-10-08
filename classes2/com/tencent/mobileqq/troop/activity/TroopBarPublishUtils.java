package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable.Factory;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vib;
import vic;
import vid;

public class TroopBarPublishUtils
{
  public static final int A = 500;
  public static final String A = "content";
  public static final int B = 4;
  public static final String B = "selectTitle";
  public static final int C = 9;
  public static final String C = "selectContent";
  protected static final int D = 196;
  public static final String D = "selectUrl";
  public static final int E = 1;
  public static final String E = "groupUin";
  public static final int F = 2;
  public static final String F = "key_photo_delete_action";
  public static final int G = 1;
  public static final String G = "key_photo_delete_position";
  public static final int H = 2;
  public static final String H = "key_photo_add_action";
  public static final int I = 3;
  public static final String I = "key_music_delete_action";
  public static final int J = 1;
  public static final String J = "key_audio_delete_action";
  public static final int K = 2;
  public static final String K = "key_audio_playing_action";
  public static final int L = 3;
  public static final String L = "key_video_delete_action";
  public static final int M = 1;
  public static final String M = "key_audio_play_action";
  public static final int N = 2;
  public static final String N = "key_video_play_action";
  public static final int O = 3;
  public static final String O = "key_video_time_overflow";
  public static final int P = 4;
  public static final String P = "key_video_size_overflow";
  public static final String Q = "key_video_select_apply_click";
  public static final String R = "key_video_select_confirm_ok_click";
  public static final String S = "need_plus_btn";
  public static final String T = "content_to_web";
  public static final String U = "sendToWeb";
  public static final String V = "needTribeReport";
  public static final String W = "barindex";
  public static final String X = "sbarindex";
  public static final int a = 1;
  public static Editable.Factory a;
  private static TroopBarPublishUtils.UserInvokeAction a;
  public static final String a = "TroopBarPublishUtils";
  public static final int b = 2;
  public static final String b = "groupType";
  public static final int c = 4;
  public static final String c = "needDestination";
  public static final int d = 8;
  public static final String d = "needTitle";
  public static final int e = 1001;
  public static final String e = "needLocation";
  public static final int f = 1002;
  public static final String f = "needFace";
  public static final int g = 1003;
  public static final String g = "contentPlaceholder";
  public static final int h = 0;
  public static final String h = "minContentLength";
  public static final int i = 1;
  public static final String i = "maxContentLength";
  public static final int j = 2;
  public static final String j = "barTitle";
  public static final int k = 3;
  public static final String k = "isPreUpload";
  public static final int l = 0;
  public static final String l = "maxPhotoCount";
  public static final int m = 1;
  public static final String m = "photoOrContent";
  public static final int n = 2;
  public static final String n = "isReply";
  public static final int o = 3;
  public static final String o = "from";
  public static final int p = -1;
  public static final String p = "topicFrom";
  public static final int q = 0;
  public static final String q = "flag";
  public static final int r = 1;
  public static final String r = "recordTimeLimit";
  protected static final int s = 1001;
  public static final String s = "requireType";
  protected static final int t = 1003;
  public static final String t = "optionType";
  protected static final int u = 1004;
  public static final String u = "cacheKey";
  protected static final int v = 1005;
  public static final String v = "defaultCategory";
  protected static final int w = 1006;
  public static final String w = "forbiddenType";
  protected static final int x = 1007;
  public static final String x = "forbiddenMsg";
  protected static final int y = 1008;
  public static final String y = "image_list";
  protected static final int z = 1009;
  public static final String z = "needForward";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidTextEditable$Factory = new vib();
  }
  
  protected static Uri a(BaseActivity paramBaseActivity)
  {
    return TroopBarUtils.a(paramBaseActivity, AppConstants.bo, 1001);
  }
  
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    DeviceLib.a(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
    paramEditText.setBackgroundResource(2130837544);
    paramEmoticonCallback = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramContext, 196.0F));
    int i1 = (int)DisplayUtils.a(paramContext, 20.0F);
    paramEditText.setPadding(0, i1, 0, i1);
    paramViewGroup.addView(paramEditText, paramEmoticonCallback);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList paramArrayList, AudioInfo paramAudioInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    try
    {
      localJSONObject.put("content", localObject);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int i1 = 0;
        while (i1 < paramString.size())
        {
          localObject = (String)paramString.get(i1);
          localObject = (TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject);
          if (localObject != null) {
            paramArrayList.put(((TroopBarPublishActivity.Pic_list)localObject).getJsonObject());
          }
          i1 += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        if (paramAudioInfo != null) {
          paramString = new JSONArray();
        }
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
          return localJSONObject.toString();
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        for (;;) {}
      }
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a(paramActivity);
      if (paramBundle.getString("pid") == null) {}
      for (paramActivity = "pub_page_new";; paramActivity = "reply_page_new")
      {
        TroopBarUtils.b(paramActivity, "Clk_install", paramBundle.getString("bid"), "", "", "");
        return;
      }
    case 1: 
      a(paramActivity, paramBundle);
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  protected static void a(Activity paramActivity)
  {
    if (TroopFileUtils.a(paramActivity) != 2)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      localQQCustomDialog.setTitle("你的网络连接不是WIFI，是否继续下载");
      paramActivity = new vid(paramActivity);
      localQQCustomDialog.setNegativeButton("取消", paramActivity);
      localQQCustomDialog.setPositiveButton("土豪继续下载", paramActivity);
      localQQCustomDialog.show();
      return;
    }
    b(paramActivity);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = PackageUtil.a(paramActivity, "com.tencent.tribe");
    jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$UserInvokeAction = new TroopBarPublishUtils.UserInvokeAction(paramActivity, paramInt1, paramInt2, paramBundle);
    if (!"0".equals(str))
    {
      b(paramActivity, paramInt1, paramInt2, paramBundle);
      return;
    }
    b(paramActivity, 3, paramInt2, paramBundle);
    if (paramBundle.getString("pid") == null) {}
    for (paramActivity = "pub_page_new";; paramActivity = "reply_page_new")
    {
      TroopBarUtils.b(paramActivity, "exp_install", paramBundle.getString("bid"), "", "", "");
      return;
    }
  }
  
  protected static void a(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://gbar_home/?bid=%s&from=qqbuluo&post=true&uin=%s&title=%s&msg=%s&clicktype=%s", new Object[] { paramBundle.getString("bid"), paramBundle.getString("uin"), URLEncoder.encode(paramBundle.getString("title"), "UTF-8"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, "打开应用失败，请重试", 0).b(50);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ArrayList paramArrayList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.addAll(paramArrayList);
    }
    paramArrayList = new Intent();
    paramArrayList.setClass(paramBaseActivity, PhotoListActivity.class);
    paramArrayList.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramBaseActivity.getClass().getName());
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramArrayList.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramArrayList.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramArrayList.getExtras().remove("forward_type");
    paramArrayList.putExtra("album_enter_directly", true);
    paramArrayList.putExtra("ALBUM_ID", AlbumUtil.b);
    paramArrayList.putExtra("ALBUM_NAME", AlbumUtil.c);
    paramArrayList.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramBaseActivity.startActivityForResult(paramArrayList, 1001);
    AlbumUtil.a(paramBaseActivity, false, true);
  }
  
  public static void b(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " http://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      Object localObject2 = new JSONObject(HttpUtil.a(paramActivity, "http://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131364813);
      localObject2 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      paramActivity.getString(2131364814);
      String str = paramActivity.getString(2131364815);
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, (String)localObject1);
      localBundle.putString(DownloadConstants.i, (String)localObject2);
      localBundle.putInt(DownloadConstants.j, 2);
      localBundle.putString(DownloadConstants.k, str);
      localBundle.putBoolean(DownloadConstants.q, false);
      localBundle.putBoolean(DownloadConstants.w, false);
      localBundle.putString(DownloadConstants.l, "_" + (String)localObject1);
      DownloadApi.a(paramActivity, localBundle, 0, null, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "====tribe app download====" + localException.toString());
      }
      QQToast.a(paramActivity, "下载失败，请重试", 0).b(50);
    }
  }
  
  protected static void b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 != 3) && (jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$UserInvokeAction.a().booleanValue()))
    {
      a(paramInt1, paramActivity, paramBundle);
      return;
    }
    String str2 = "";
    String str1;
    switch (paramInt2)
    {
    default: 
      str1 = "文字";
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      localQQCustomDialog.setTitle(paramActivity.getString(2131364812, new Object[] { str2, str1 }));
      paramActivity = new vic(paramBundle, paramInt1, paramActivity);
      localQQCustomDialog.setNegativeButton("取消", paramActivity);
      localQQCustomDialog.setPositiveButton("立即" + str2, paramActivity);
      localQQCustomDialog.show();
      return;
      str1 = "视频";
      break;
      str1 = "音乐";
      break;
      str2 = "安装";
      continue;
      str2 = "使用";
    }
  }
  
  protected static void b(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://post_detail/?pid=%s&bid=%s&bar_type=0&from=qqbuluo&post=true&uin=%s&floor=%s&msg=%s&clicktype=%s", new Object[] { paramBundle.getString("pid"), paramBundle.getString("bid"), paramBundle.getString("uin"), paramBundle.getString("floor"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, "打开应用失败，请重试", 0).b(50);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.pubaccount.util;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.ui.IvrScanBarActivity;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ifg;
import ifh;
import ifi;
import ifj;
import ifk;
import ifl;
import ifm;
import ifn;
import ifo;
import ifp;
import ifq;
import ifr;
import ifs;
import ift;
import ifu;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPlugin
  extends WebViewPlugin
{
  public static String A;
  public static final String D = "pic_local_path";
  public static final String E = "is_showProgress_tips";
  public static final String F = "pic_server_id";
  public static final String G = "pic_local_id";
  public static final String H = "pic_callback";
  public static final String I = "pic_puin";
  public static final String J = "is_pic_or_voice";
  public static final byte a = 111;
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "PublicAccountH5AbilityPlugin";
  public static ArrayList a;
  public static HashMap a;
  static final boolean jdField_a_of_type_Boolean = false;
  public static final byte b = 112;
  public static final int b = 102;
  public static final String b = "publicAccountNew";
  public static HashMap b;
  public static boolean b = false;
  public static final String c = "from_pub5";
  public static final String d = "mqqpa://resourceid/";
  public static final String e = "menuItem:share:qq";
  public static final String f = "menuItem:share:QZone";
  static final int g = 1000;
  public static final String g = "menuItem:share:appMessage";
  public static final String h = "menuItem:share:timeline";
  public static final String i = "menuItem:share:qiDian";
  public static final String j = "menuItem:share:qiYeQQ";
  public static final String k = "menuItem:openWithQQBrowser";
  public static final String l = "menuItem:openWithSafari";
  public static final String m = "menuItem:favorite";
  public static final String n = "menuItem:copyUrl";
  public static final String o = "menuItem:exposeArticle";
  public static final String p = "menuItem:setFont";
  public static final String q = "filepath";
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public String B;
  String C = "";
  public String K = "";
  public String L = "";
  public String M = "";
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Handler a;
  PublicAccountH5AbilityForPtt jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public QQBrowserActivity a;
  public ActionSheet a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  ArrayList b;
  public int c;
  ArrayList c;
  public boolean c;
  public int d = 1282;
  int e = -1;
  int f = -1;
  String r;
  String s;
  public String z = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "ui.closeWebViews");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), "publicAccount.getLocation");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(30), "wallet.publicPay");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountH5AbilityPlugin()
  {
    this.jdField_c_of_type_Int = 1281;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new ifg(this);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static WebResourceResponse a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString);
        if (paramString == null) {
          return null;
        }
        paramString = CrmUtils.a(SafeBitmapFactory.decodeFile(paramString));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/png", "UTF-8", paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString))
        {
          paramArrayList.remove(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if ("QQApi.shareMsg".equals(paramString)) {
      if ((a(jdField_a_of_type_JavaUtilArrayList, "ui.setOnShareQQFriendHandler")) || (a(jdField_a_of_type_JavaUtilArrayList, "ui.ui.setOnShareQZoneHandler")) || (a(jdField_a_of_type_JavaUtilArrayList, "ui.ui.setOnShareWXFriendHandler")) || (a(jdField_a_of_type_JavaUtilArrayList, "ui.setOnShareWXTimelineHandler"))) {
        bool = true;
      }
    }
    while (!a(jdField_a_of_type_JavaUtilArrayList, paramString)) {
      return bool;
    }
    if ("qbizApi.getNetworkType".equals(paramString)) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString)) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
    }
  }
  
  public static boolean a(ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i1 = 0;
    while (i1 < 32)
    {
      arrayOfInt[(31 - i1)] = (paramInt >> i1 & 0x1);
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  public ArrayList a()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      return localSwiftBrowserShareMenuHandler.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (paramInt2 == 1)
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, IvrScanBarActivity.class);
      localIntent.putExtra("from_other", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivityForResult(localIntent, 102);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, ScannerActivity.class);
    localIntent.putExtra("finishAfterSucc", true);
    if (paramInt1 == 1)
    {
      localIntent.putExtra("from", "publicAccountNew");
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivityForResult(localIntent, 1);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "Success");
      callJs(this.s, new String[] { localJSONObject.toString() });
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivity(localIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, null));
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2130904281, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131296494);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131302153);
    localObject = (TextView)((View)localObject).findViewById(2131302154);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      localTextView1.setOnClickListener(new ifq(this, paramString));
      localTextView2.setOnClickListener(new ifr(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new ifs(this));
      return;
      if (paramInt1 == 2)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str3 = this.z;
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3)) {}
    }
    else
    {
      str1 = "12345678";
    }
    try
    {
      Long.parseLong(str1);
      if ((this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) && (!"".equals(paramString1))) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramString1, paramInt, str1, paramBoolean, new ifj(this, paramBoolean, paramString3, paramString2), new ifk(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "12345678";
      }
    }
  }
  
  void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.z;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject1 = "12345678";
    }
    try
    {
      Long.parseLong((String)localObject1);
      if ((this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + HttpUtil.a());
        }
        if (HttpUtil.a() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "你已离开wifi环境", 0).a();
          }
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramInt, (String)localObject1, paramBoolean, new ifh(this, paramString2, paramBoolean), new ifi(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "12345678";
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (paramBundle.equals(((Map.Entry)localObject3).getValue())) {
          ((ArrayList)localObject1).add((String)((Map.Entry)localObject3).getKey());
        }
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ifu localifu = (ifu)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localifu.b)) {
            paramBundle.add(localifu);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(paramBundle);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        paramBundle = (ifu)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramBundle.b);
        a(paramBundle.jdField_a_of_type_Int, (String)localObject1, true, paramBundle.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("fromBrowser", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivity(localIntent);
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("6.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(this.d);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.z);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new ifo(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("6.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_c_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.z);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        PublicAccountH5AbilityForPtt localPublicAccountH5AbilityForPtt;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new ifn(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.h();
      localJSONObject.put("file_uuid", paramString1);
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_md5", PublicAccountH5AbilityForPtt.b());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_name", PublicAccountH5AbilityForPtt.c());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_size", PublicAccountH5AbilityForPtt.b());
      localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
      localJSONObject.put("file_time", PublicAccountH5AbilityForPtt.c());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.b()).append(" file_name:");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.c()).append(" file_size=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        paramString1 = paramString1.append(PublicAccountH5AbilityForPtt.b()).append(" file_time=");
        localPublicAccountH5AbilityForPtt = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt;
        QLog.i("PublicAccountH5AbilityPlugin", 2, PublicAccountH5AbilityForPtt.c());
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!a(a(), str)) {
        a().add(str);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramBoolean);
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.f();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", "确定");
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label152;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(this, localIntent, (byte)111);
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label152:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
    }
  }
  
  public void b(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ift localift = (ift)localIterator.next();
        if (paramString.equals(localift.b)) {
          localArrayList.add(localift);
        }
      }
      this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
    }
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = (ift)this.jdField_c_of_type_JavaUtilArrayList.get(0);
      a(paramString.b, paramString.jdField_a_of_type_Int, true, paramString.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      a(a(), str);
    }
  }
  
  void c()
  {
    this.C = "";
    jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_b_of_type_Boolean = false;
    this.z = "";
  }
  
  void d()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("6.5.5,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(this.C);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + this.C);
    }
    localNewIntent.setObserver(new ifp(this));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, PoiMapActivity.class).putExtra("uin", this.r);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.showActionSheet();
  }
  
  public void g()
  {
    a().clear();
    a().add("menuItem:share:qq");
    a().add("menuItem:share:QZone");
    a().add("menuItem:share:appMessage");
    a().add("menuItem:share:timeline");
    a().add("menuItem:openWithQQBrowser");
    a().add("menuItem:openWithSafari");
    a().add("menuItem:favorite");
    a().add("menuItem:copyUrl");
  }
  
  public void h()
  {
    a().clear();
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i1 = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i1 == 102) || (i1 == 1))
        {
          int i2 = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i1, i2);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      b();
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i1;
    int i2;
    boolean bool;
    if ("publicAccountNew".endsWith(paramString2))
    {
      if ("openLocation".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          e();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005869", "0X8005869", 0, 0, "", "", "", "");
        return true;
      }
      if ("showOfficialAccountProfile".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
          if (!"".equals(paramJsBridgeListener)) {
            a(paramJsBridgeListener);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("scanQRCode".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i1 = paramJsBridgeListener.optInt("needResult");
          i2 = paramJsBridgeListener.optInt("scanType");
          this.s = paramJsBridgeListener.optString("callback");
          a(i1, i2);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "0", "", "", "");
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("showWebPanel".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          f();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("setRightButtonState".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          bool = paramJsBridgeListener.optBoolean("hidden");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          a(bool);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("hideMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          a(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586E", "0X800586E", 0, 0, "", "", "", "");
        return true;
      }
      if ("showMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          b(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586F", "0X800586F", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          g();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005870", "0X8005870", 0, 0, "", "", "", "");
        return true;
      }
      if ("showAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          h();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005871", "0X8005871", 0, 0, "", "", "", "");
        return true;
      }
      if ("showWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          j();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005898", "0X8005898", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          i();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005897", "0X8005897", 0, 0, "", "", "", "");
        return true;
      }
      if ("uploadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("localId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          paramString2 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString1);
          paramString3 = new File(paramString2);
          if ((paramString3 == null) || (!paramString3.exists()))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "文件不存在" + paramString2, 0).a();
            return true;
          }
          if (paramString3.length() > 2097152L)
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "请选择小于2M文件" + paramString2, 0).a();
            return true;
          }
          paramString3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (paramString3.hasNext())
          {
            paramVarArgs = (ifu)paramString3.next();
            if ((paramString1 != null) && (paramString1.equals(paramVarArgs.b)))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "任务已经在上传队列", 0).a();
              return true;
            }
          }
          paramString3 = new ifu();
          paramString3.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString3.b = paramString1;
          paramString3.jdField_a_of_type_Int = i1;
          this.jdField_b_of_type_JavaUtilArrayList.add(paramString3);
          if (this.jdField_b_of_type_JavaUtilArrayList.size() != 1) {
            break label1774;
          }
          a(i1, paramString2, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, 2, "1", "", "", "");
        return true;
        label1774:
        return true;
      }
      if ("downloadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("serverId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          if (("".equals(paramJsBridgeListener)) || ("".equals(paramString1)))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "callback or mediaId is null", 0).a();
            return true;
          }
          paramString2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (ift)paramString2.next();
            if ((paramString1 != null) && (paramString1.equals(paramString3.b)))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, "任务已经在下载队列", 0).a();
              return true;
            }
          }
          paramString2 = new ift();
          paramString2.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString2.b = paramString1;
          paramString2.jdField_a_of_type_Int = i1;
          this.jdField_c_of_type_JavaUtilArrayList.add(paramString2);
          if (this.jdField_c_of_type_JavaUtilArrayList.size() != 1) {
            break label2024;
          }
          a(paramString1, i1, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 2, "1", "", "", "");
        return true;
        label2024:
        return true;
      }
      if ("uploadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label4180;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("localId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool = TextUtils.isEmpty(paramString2);
            if (bool) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "file not exists");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
              break label2227;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
          label2227:
          paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString2);
          paramString2 = new File(paramString1);
          if (!paramString2.exists())
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "file not exists");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if (paramString2.length() > 5242880L)
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "请上传5MB以内的音频");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
          else
          {
            a(i1, paramString1, false, paramJsBridgeListener);
          }
        }
      }
      if ("downloadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label4182;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("serverId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool = TextUtils.isEmpty(paramString2);
            if (bool) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "invalid serverId");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            a(paramString2, i1, false, paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("getPicture".endsWith(paramString3)) {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label4191;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("callback");
        i3 = paramString2.optInt("count");
        if (i3 > 9) {
          break label4184;
        }
        if (i3 >= 1) {
          break label4177;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        int i4;
        paramJsBridgeListener.printStackTrace();
        break;
      }
      paramString1 = paramString2.optJSONArray("sizeType");
      paramString2 = paramString2.optJSONArray("sourceType");
      if ((paramString2 != null) && (paramString2.length() == 1))
      {
        paramString2 = paramString2.optString(0);
        if ("camera".equalsIgnoreCase(paramString2))
        {
          i1 = 1;
          i4 = 0;
          i2 = i4;
          if (paramString1 != null)
          {
            i2 = i4;
            if (paramString1.length() == 1)
            {
              paramString1 = paramString1.optString(0);
              if (!"original".equalsIgnoreCase(paramString1)) {
                continue;
              }
              i2 = 1;
            }
          }
          a(i1, i2, paramJsBridgeListener, i3);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
          break;
        }
        else
        {
          if (!"album".equalsIgnoreCase(paramString2)) {
            break label4171;
          }
          i1 = 2;
          continue;
        }
        bool = "compressed".equalsIgnoreCase(paramString1);
        i2 = i4;
        if (!bool) {
          continue;
        }
        i2 = 2;
        continue;
        if ("startRecord".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            t = new JSONObject(paramVarArgs[0]).optString("callback");
            if (!TextUtils.isEmpty(t))
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b();
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          return true;
        }
        if ("stopRecord".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          for (;;)
          {
            try
            {
              u = new JSONObject(paramVarArgs[0]).optString("callback");
              if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.a())) {
                continue;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.c();
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 2, "1", "", "", "");
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              continue;
            }
            return true;
            try
            {
              paramJsBridgeListener = new JSONObject();
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "fail");
              callJs(u, new String[] { paramJsBridgeListener.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("playVoice".endsWith(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label4193;
          }
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              v = paramJsBridgeListener.optString("callback");
              paramJsBridgeListener = paramJsBridgeListener.optString("localId");
              if (!TextUtils.isEmpty(v))
              {
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  break label3427;
                }
                if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b())) {
                  return true;
                }
                if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                  this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
                }
                paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramJsBridgeListener);
                paramJsBridgeListener = new JSONObject();
                if (new File(paramString1).exists()) {
                  this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString1);
                }
              }
              else
              {
                try
                {
                  paramJsBridgeListener.put("retCode", 0);
                  paramJsBridgeListener.put("msg", "success");
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 0, "1", "", "", "");
                  callJs(v, new String[] { paramJsBridgeListener.toString() });
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 2, "1", "", "", "");
                }
                catch (JSONException paramString1)
                {
                  paramString1.printStackTrace();
                  continue;
                }
              }
              try
              {
                paramJsBridgeListener.put("retCode", -1);
                paramJsBridgeListener.put("msg", "file not exists");
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, -1, "1", "", "", "");
              }
              catch (JSONException paramString1)
              {
                for (;;)
                {
                  paramString1.printStackTrace();
                }
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            label3427:
            paramJsBridgeListener = new JSONObject();
            try
            {
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "missing arguments");
              callJs(v, new String[] { paramJsBridgeListener.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("pauseVoice".endsWith(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            break label4195;
          }
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString1 = paramString1.optString("localId");
            if (!TextUtils.isEmpty(paramString1))
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramString1);
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b())
              {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.g();
                paramString1 = new JSONObject();
              }
            }
            try
            {
              paramString1.put("retCode", 0);
              paramString1.put("msg", "success");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 0, "1", "", "", "");
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 2, "1", "", "", "");
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
            if (!"stopVoice".endsWith(paramString3)) {
              break label3891;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          w = paramJsBridgeListener.optString("callback");
          paramJsBridgeListener = paramJsBridgeListener.optString("localId");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt == null) {
              this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt = new PublicAccountH5AbilityForPtt(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.r, this.mRuntime);
            }
            this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.b(paramJsBridgeListener);
            this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.e();
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 0, "1", "", "", "");
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 2, "1", "", "", "");
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
        label3891:
        if ("onVoiceRecordEnd".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            x = new JSONObject(paramVarArgs[0]).optString("callback");
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("onVoicePlayEnd".endsWith(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            y = new JSONObject(paramVarArgs[0]).optString("callback");
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        if ("config".endsWith(paramString3))
        {
          if (this.jdField_c_of_type_Boolean) {
            return true;
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              A = paramString1.optString("appId");
              paramString1.put("appver", "6.5.5");
              paramString2 = this.mRuntime.a();
              paramJsBridgeListener = null;
              if (paramString2 != null) {
                paramJsBridgeListener = paramString2.getUrl();
              }
              paramString1.put("url", paramJsBridgeListener);
              this.C = paramString1.toString();
              this.B = paramString1.optString("callback");
              paramJsBridgeListener = paramString1.optJSONArray("jsApiList");
              if (paramJsBridgeListener != null)
              {
                jdField_a_of_type_JavaUtilArrayList.clear();
                i1 = 0;
                while (i1 < paramJsBridgeListener.length())
                {
                  jdField_a_of_type_JavaUtilArrayList.add(paramJsBridgeListener.optString(i1));
                  i1 += 1;
                }
              }
              d();
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        return false;
      }
      label4171:
      i1 = 0;
      continue;
      label4177:
      continue;
      label4180:
      return true;
      label4182:
      return true;
      label4184:
      int i3 = 9;
    }
    label4191:
    return true;
    label4193:
    return true;
    label4195:
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setBottomBarVisible(false);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setBottomBarVisible(true);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.f();
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.K = "";
    this.L = "";
    this.M = "";
  }
  
  public void l()
  {
    Object localObject = AppConstants.bj + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.L, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    this.M = UUID.randomUUID().toString();
    this.K = ((String)localObject + this.M + ".jpg");
    localObject = Uri.fromFile(new File(this.K));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      startActivityForResult(localIntent, (byte)112);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void m()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        n();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665)).setText("正在处理");
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    String str;
    if (paramByte == 102) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("scanStr");
        if (!TextUtils.isEmpty(str)) {}
      }
    }
    do
    {
      return;
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("retCode", 0);
        paramIntent.put("msg", "Success");
        if (this.e != 1) {}
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          try
          {
            paramIntent.put("scanResult", str);
            if (!TextUtils.isEmpty(this.s)) {
              callJs(this.s, new String[] { paramIntent.toString() });
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
            if (!TextUtils.isEmpty(this.s)) {
              callJs(this.s, new String[] { paramIntent.toString() });
            }
            this.e = -1;
            this.f = -1;
            return;
            localJSONException2 = localJSONException2;
            localJSONException2.printStackTrace();
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            continue;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, QQBrowserActivity.class);
          localObject1 = 1024 + "http://qm.qq.com/cgi-bin/result" + "?p=a&v=" + DeviceInfoUtil.c() + "&r=" + URLEncoder.encode(localJSONException1).replaceAll("\\+", "%20") + "&_wv=1027";
          localIntent.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131364392));
          localIntent.putExtra("url", (String)localObject1);
          localIntent.putExtra("key_isReadModeEnabled", true);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivity(localIntent);
        }
      }
      if (paramByte == 1)
      {
        if (paramIntent != null) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("retCode", 0);
          ((JSONObject)localObject1).put("msg", "Success");
          paramIntent = paramIntent.getStringExtra("scanResult");
          if (this.e != 1) {}
        }
        catch (JSONException localJSONException3)
        {
          try
          {
            ((JSONObject)localObject1).put("scanResult", paramIntent);
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
            if (!TextUtils.isEmpty(this.s)) {
              callJs(this.s, new String[] { ((JSONObject)localObject1).toString() });
            }
            this.e = -1;
            this.f = -1;
            return;
            localJSONException3 = localJSONException3;
            localJSONException3.printStackTrace();
          }
          catch (JSONException paramIntent)
          {
            for (;;)
            {
              paramIntent.printStackTrace();
            }
          }
        }
      }
      if (paramByte == 112)
      {
        paramIntent = new File(this.K);
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        if (paramIntent != null) {
          try
          {
            if (paramIntent.exists())
            {
              ThreadManager.a().post(new ifl(this, (JSONArray)localObject2, (JSONObject)localObject1));
              return;
            }
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            return;
          }
        }
        ((JSONObject)localObject1).put("retCode", 1);
        ((JSONObject)localObject1).put("msg", "cancel");
        ((JSONObject)localObject1).put("sourceType", "camera");
        callJs(this.L, new String[] { ((JSONObject)localObject1).toString() });
        this.K = "";
        this.L = "";
        this.M = "";
        return;
      }
    } while (paramByte != 111);
    Object localObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (paramIntent != null) {}
    for (Object localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");; localObject1 = null)
    {
      paramInt = 0;
      if (localObject1 != null) {}
      try
      {
        if (((ArrayList)localObject1).size() != 0) {
          break;
        }
        ((JSONObject)localObject2).put("retCode", 1);
        ((JSONObject)localObject2).put("msg", "");
        ((JSONObject)localObject2).put("sourceType", "album");
        callJs(this.L, new String[] { ((JSONObject)localObject2).toString() });
        this.L = "";
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 0) {
      paramInt = 1;
    }
    if (paramInt != 0)
    {
      ThreadManager.a().post(new ifm(this, (ArrayList)localObject1, localJSONArray, (JSONObject)localObject2));
      return;
    }
    for (;;)
    {
      if (paramInt < ((ArrayList)localObject1).size())
      {
        paramIntent = UUID.randomUUID();
        paramIntent = "mqqpa://resourceid/" + paramIntent.toString();
        localJSONArray.put(paramInt, paramIntent);
        jdField_b_of_type_JavaUtilHashMap.put(paramIntent, ((ArrayList)localObject1).get(paramInt));
        paramInt += 1;
      }
      else
      {
        ((JSONObject)localObject2).put("value", localJSONArray);
        ((JSONObject)localObject2).put("retCode", 0);
        ((JSONObject)localObject2).put("msg", "Success");
        ((JSONObject)localObject2).put("sourceType", "album");
        callJs(this.L, new String[] { ((JSONObject)localObject2).toString() });
        this.L = "";
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        return;
        paramInt = 0;
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
      this.r = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    }
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      k();
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      }
      c();
      a().clear();
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityForPtt.f();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicAccountH5AbilityPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
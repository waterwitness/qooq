package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebShareServlet;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.stat.MttLoader.BrowserInfo;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyShareManager;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import jia;
import jic;
import jig;
import jih;
import jij;
import jil;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class Share
  implements View.OnClickListener
{
  private static final long jdField_b_of_type_Long = 801097412L;
  public static final int c = 1;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 4;
  protected static final int g = 34;
  public static final String g = "extra_url_info_from";
  protected static final int h = 30;
  protected static final String h = "http://openmobile.qq.com/api/get_app_info_by_id?appid=%d";
  protected static final int i = 64;
  public static final String i = "http://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s";
  protected static final int j = 1001;
  public static final String j = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
  protected static final int k = 1002;
  public static final String k = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  protected static final int l = 1;
  public static final String l = "http://url.cn/JS8oE7";
  public static final int m = 1;
  public static final String m = "source_name";
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public static final int r = 6;
  public static final int s = 7;
  private static String u = "share";
  private static final String v = "com.tencent.mtt";
  private static final String w = "tencent100446242://";
  private static final String x = "http://url.cn/PWkhNu";
  private static final String y = "http://url.cn/UQoBHn";
  private static final String z = "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";
  public float a;
  protected int a;
  public long a;
  public Activity a;
  public Context a;
  protected Handler a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public QQProgressDialog a;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public GetAppInfoProto.GetAppinfoResponse a;
  protected String a;
  public WeakReference a;
  protected BusinessObserver a;
  public int b;
  Activity jdField_b_of_type_AndroidAppActivity = null;
  protected ImageView b;
  protected LinearLayout b;
  public TextView b;
  public String b;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public ImageView c;
  public String c;
  public String d;
  protected String e;
  protected String f;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  private volatile int t;
  public String t;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Share(AppInterface paramAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new jij(this);
    this.jdField_a_of_type_AndroidOsHandler = new jil(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.n = paramAppInterface.getAccount();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
    if ((paramActivity instanceof WebUiBaseInterface)) {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference((WebUiBaseInterface)paramActivity);
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    paramAppInterface = (WebUiBaseInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((paramAppInterface != null) && ((paramAppInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((WebUiUtils.WebUiMethodInterface)paramAppInterface).getWebView();
    }
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    g();
  }
  
  public static final String a(PBRepeatMessageField paramPBRepeatMessageField, int paramInt)
  {
    List localList = null;
    Object localObject = localList;
    int i2;
    int i1;
    if (paramPBRepeatMessageField != null)
    {
      localObject = localList;
      if (!paramPBRepeatMessageField.isEmpty())
      {
        localList = paramPBRepeatMessageField.get();
        i2 = localList.size();
        i1 = 0;
        paramPBRepeatMessageField = null;
        if (i1 >= i2) {
          break label260;
        }
        localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
      }
    }
    label240:
    label249:
    label252:
    label257:
    label260:
    for (;;)
    {
      try
      {
        int i3 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
        if (i3 < paramInt) {
          break label257;
        }
        localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
        paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          localObject = paramPBRepeatMessageField;
          if (paramPBRepeatMessageField == null)
          {
            i1 = i2 - 1;
            if (i1 < 0) {
              break label252;
            }
            localObject = (GetAppInfoProto.MsgIconsurl)localList.get(i1);
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.valueOf(((GetAppInfoProto.MsgIconsurl)localObject).size.get()).intValue();
          if (i2 >= paramInt) {
            break label249;
          }
          localObject = ((GetAppInfoProto.MsgIconsurl)localObject).url.get();
          paramPBRepeatMessageField = (PBRepeatMessageField)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label240;
          }
          if (QLog.isColorLevel()) {
            QLog.d(u, 2, "QQBrowserActivity findAppIcon() iconUrl = " + (String)localObject);
          }
          return (String)localObject;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break label240;
          }
          QLog.d(u, 2, localNumberFormatException2.getMessage());
        }
        localNumberFormatException1 = localNumberFormatException1;
        if (QLog.isColorLevel()) {
          QLog.d(u, 2, localNumberFormatException1.getMessage());
        }
        i1 += 1;
      }
      for (;;)
      {
        i1 += 1;
        break;
      }
      PBRepeatMessageField localPBRepeatMessageField = paramPBRepeatMessageField;
      continue;
    }
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong1, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("6.5.5");
    localGetAppinfoRequest.setHasFlag(true);
    paramContext = new NewIntent(paramContext, ProtoServlet.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    if (paramLong2 > 0L) {
      paramContext.putExtra("timeout", paramLong2);
    }
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("6.5.5");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong2);
    localGetAppinfoRequest.signature.set(paramString2);
    paramContext = new NewIntent(paramContext, ProtoServlet.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong, BusinessObserver paramBusinessObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramLong, 0L, paramBusinessObserver);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("appShareID", 0L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299843));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label52;
      }
    }
    label52:
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299842);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.n, AppShareIDUtil.b(this.jdField_a_of_type_Long), this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427773));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839098);
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838591);
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363065);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.75F);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427774));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.75F);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838943);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427774));
        localObject1 = new LinearLayout.LayoutParams((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 56.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
        localObject1 = new FrameLayout.LayoutParams(-1, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 80;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity));
      localObject2 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    } while (((QQBrowserActivity)localObject2).a.a == null);
    ((QQBrowserActivity)localObject2).a.a.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QQProgressDialog a()
  {
    WebUiBaseInterface localWebUiBaseInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      localWebUiBaseInterface = (WebUiBaseInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface))) {
        break label70;
      }
    }
    label70:
    for (int i1 = ((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).getTitleBarHeight();; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369680);
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    }
  }
  
  public String a()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        return "";
        if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (WebUiBaseInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface))) {
            localObject = ((WebUiUtils.WebUiMethodInterface)localObject).getCurrentUrl();
          }
        }
      }
      else
      {
        return Util.a((String)localObject, new String[0]);
      }
      localObject = "";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.jdField_t_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    if (this.jdField_b_of_type_AndroidAppActivity == null) {
      if (!this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        break label280;
      }
    }
    Object localObject1;
    label280:
    for (this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(); paramInt == 2; this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity)
    {
      localObject1 = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject1).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject1).putString("desc", paramString1);
      ((Bundle)localObject1).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject1).putLong("req_share_id", 0L);
      if (this.jdField_b_of_type_Int != -1) {
        ((Bundle)localObject1).putInt("iUrlInfoFrm", this.jdField_b_of_type_Int);
      }
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
      {
        paramString1 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
        ((Bundle)localObject1).putString("strurt_msgid", paramString1.ax);
        ((Bundle)localObject1).putString("struct_uin", paramString1.aw);
        ((Bundle)localObject1).putString("struct_url", paramString1.ab);
        ((Bundle)localObject1).putBoolean("from_web", true);
        if ((paramString1.ay != null) && (!"".equals(paramString1.ay))) {
          ((Bundle)localObject1).putString("source_puin", paramString1.ay);
        }
      }
      if (!QZoneShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null)) {
        QRUtils.a(1, 2131369679);
      }
      return;
    }
    Object localObject4;
    String str2;
    String str1;
    Object localObject2;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser))
      {
        localObject3 = ((PublicAccountBrowser)this.jdField_a_of_type_AndroidAppActivity).b();
        localObject4 = this.jdField_a_of_type_AndroidAppActivity.getResources();
        str2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
        Activity localActivity;
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str2)))
        {
          paramBitmap = " ";
          localObject1 = null;
          str1 = null;
          localObject2 = null;
          str2 = ((Resources)localObject4).getString(2131364568);
          localActivity = this.jdField_a_of_type_AndroidAppActivity;
          if (!TextUtils.isEmpty(paramString4)) {
            break label511;
          }
          paramString4 = null;
          label398:
          if (!TextUtils.isEmpty(paramString2)) {
            break label514;
          }
          paramString2 = paramString3;
        }
        label511:
        label514:
        for (;;)
        {
          ShareMsgHelper.a(localActivity, 1001, 1, "web_share", (String)localObject3, paramString4, paramString1, paramString2, String.format(((Resources)localObject4).getString(2131364569), new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject1, str1, (String)localObject2, str2, null);
          return;
          paramBitmap = "plugin";
          localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { localObject3 });
          str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { localObject3 });
          localObject2 = "http://url.cn/JS8oE7";
          break;
          break label398;
        }
      }
      localObject4 = "";
      str1 = " ";
      localObject2 = null;
      str2 = null;
      paramBitmap = null;
      localObject3 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = this.jdField_b_of_type_AndroidAppActivity.getString(2131364568);
        str1 = "app";
        paramBitmap = MttLoader.getBrowserInfo(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
        if ((paramBitmap != null) && (!TextUtils.isEmpty(paramBitmap.packageName)))
        {
          paramBitmap = paramBitmap.packageName + "://" + paramString3;
          str2 = "tencent100446242://" + paramString3;
          localObject3 = "http://url.cn/PWkhNu";
          localObject2 = paramBitmap;
          paramBitmap = (Bitmap)localObject3;
        }
      }
      else
      {
        if (!"QQ空间".equals(localObject1)) {
          break label1540;
        }
      }
    }
    label739:
    label756:
    label869:
    label872:
    label957:
    label987:
    label990:
    label1273:
    label1291:
    label1442:
    label1465:
    label1487:
    label1527:
    label1540:
    for (Object localObject3 = "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";; localObject3 = paramBitmap)
    {
      paramBitmap = (Bitmap)localObject4;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
      {
        paramBitmap = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
        if ((paramBitmap.ay != null) && (!"".equals(paramBitmap.ay))) {
          paramBitmap = paramBitmap.ay;
        }
      }
      else
      {
        localObject4 = this.jdField_b_of_type_AndroidAppActivity;
        if (!TextUtils.isEmpty(paramString4)) {
          break label869;
        }
        paramString4 = null;
        if (!TextUtils.isEmpty(paramString2)) {
          break label872;
        }
        paramString2 = paramString3;
      }
      for (;;)
      {
        ShareMsgHelper.a((Context)localObject4, 1001, 1, "web_share", paramBitmap, paramString4, paramString1, paramString2, this.jdField_b_of_type_AndroidAppActivity.getString(2131364569, new Object[] { paramString1 }), paramString3, "web", null, null, null, str1, null, (String)localObject2, str2, (String)localObject3, (String)localObject1, "", null, -1, "http://url.cn/UQoBHn", 801097412L);
        return;
        paramBitmap = "com.tencent.mtt://" + paramString3;
        break;
        paramBitmap = paramBitmap.aw;
        break label739;
        break label756;
      }
      if ((paramInt == 3) || (paramInt == 4))
      {
        if (paramInt == 3)
        {
          this.jdField_t_of_type_Int = 1;
          if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new jig(this, paramString3);
            WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
          }
          this.o = String.valueOf(System.currentTimeMillis());
          paramString4 = WXShareHelper.a();
          localObject1 = this.o;
          if (!TextUtils.isEmpty(paramString2)) {
            break label987;
          }
          paramString2 = paramString3;
          if (paramInt != 3) {
            break label990;
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          paramString4.a((String)localObject1, paramString1, paramBitmap, paramString2, paramString3, paramInt);
          return;
          this.jdField_t_of_type_Int = 2;
          break;
          break label957;
        }
      }
      if (paramInt == 5)
      {
        if ((this.jdField_a_of_type_Int == -1) || (TextUtils.isEmpty(this.e)))
        {
          ReportController.b(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
          QLog.w(u, 1, "onGetSummary invalid shareInfo");
          return;
        }
        localObject1 = new Bundle();
        paramBitmap = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramBitmap = paramString3;
        }
        ((Bundle)localObject1).putString("title", paramBitmap);
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = paramString3;
        }
        ((Bundle)localObject1).putString("desc", paramString1);
        ((Bundle)localObject1).putString("detail_url", paramString3);
        ((Bundle)localObject1).putString("cover_url", this.e);
        ((Bundle)localObject1).putString("source_name", this.f);
        ((Bundle)localObject1).putInt("article_id", this.jdField_a_of_type_Int);
        paramString1 = new ArrayList(1);
        paramString1.add(paramString4);
        ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
        ((Bundle)localObject1).putLong("req_share_id", 0L);
        if (this.jdField_b_of_type_AndroidAppActivity == null) {
          this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
        }
        if (ReadInJoyShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null, 0)) {
          break;
        }
        QRUtils.a(1, 2131369679);
        return;
      }
      if ((paramInt != 6) && (paramInt != 7)) {
        break;
      }
      localObject1 = null;
      localObject2 = null;
      str1 = null;
      if (paramString4 == null)
      {
        paramString4 = null;
        if (paramString1 != null) {
          break label1442;
        }
        paramString1 = "";
        if (paramString2 != null) {
          break label1465;
        }
        paramString2 = "";
        if (paramString3 != null) {
          break label1487;
        }
        paramString3 = "";
        localObject1 = new StringBuilder();
        if (paramInt != 6) {
          break label1527;
        }
      }
      for (paramBitmap = "qdapi://";; paramBitmap = "eimapi://")
      {
        ((StringBuilder)localObject1).append(paramBitmap);
        ((StringBuilder)localObject1).append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
        ((StringBuilder)localObject1).append("&image_url=").append(paramString4);
        ((StringBuilder)localObject1).append("&title=").append(paramString1);
        ((StringBuilder)localObject1).append("&description=").append(paramString2);
        ((StringBuilder)localObject1).append("&url=").append(paramString3);
        paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject1).toString()));
        paramString1.putExtra("pkg_name", "com.tencent.mobileqq");
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        return;
        paramBitmap = (Bitmap)localObject2;
        try
        {
          paramString4 = Base64.encodeToString(paramString4.getBytes("UTF-8"), 2);
          break;
          paramBitmap = (Bitmap)localObject2;
          localObject1 = paramString4;
          paramString1 = Base64.encodeToString(paramString1.getBytes("UTF-8"), 2);
          break label1273;
          paramBitmap = paramString1;
          localObject1 = paramString4;
          paramString2 = Base64.encodeToString(paramString2.getBytes("UTF-8"), 2);
        }
        catch (UnsupportedEncodingException paramString3)
        {
          try
          {
            paramString3 = Base64.encodeToString(paramString3.getBytes("UTF-8"), 2);
          }
          catch (UnsupportedEncodingException paramString3)
          {
            for (;;) {}
          }
          paramString3 = paramString3;
          paramString2 = null;
          paramString4 = (String)localObject1;
          paramString1 = paramBitmap;
        }
        paramString3.printStackTrace();
        paramString3 = str1;
        break label1291;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    Bitmap localBitmap = null;
    byte[] arrayOfByte;
    try
    {
      if ((paramGetAppinfoResponse.has()) && (paramGetAppinfoResponse.ret.get() == 0))
      {
        this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = paramGetAppinfoResponse;
        paramGetAppinfoResponse = a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 64);
        localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if ((TextUtils.isEmpty(paramGetAppinfoResponse)) || (localAndroidInfo == null) || (localAndroidInfo.packName == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e(u, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", androidInfo is null, OR androidInfo.packName is null !!!");
          }
        }
        else
        {
          arrayOfByte = HttpUtil.a(paramContext, paramGetAppinfoResponse, "GET", null, null);
          if (arrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(u, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", imageBytes is NULL!!!!!!!!");
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      GetAppInfoProto.AndroidInfo localAndroidInfo;
      if (QLog.isColorLevel())
      {
        QLog.d(u, 2, paramContext.getMessage());
        return;
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
        paramGetAppinfoResponse = localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          paramGetAppinfoResponse = localBitmap;
          localMessage.obj = localBitmap;
          paramGetAppinfoResponse = localBitmap;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = paramGetAppinfoResponse;
            if (QLog.isColorLevel())
            {
              QLog.e(u, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
              localGetAppinfoResponse = paramGetAppinfoResponse;
            }
          }
          paramContext = HttpUtil.a(paramContext, String.format("http://openmobile.qq.com/api/get_app_info_by_id?appid=%d", new Object[] { Long.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)) }), "GET", null, null);
          if (!TextUtils.isEmpty(paramContext)) {
            break label365;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(u, 2, "QQBrowserActivity urlResponse is null");
          return;
          paramContext = new JSONObject(paramContext);
          if (paramContext.getInt("retcode") == 0) {
            break label401;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(u, 2, "QQBrowserActivity retcode is -1");
          return;
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("mobile");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("android");
          if (paramContext == null) {
            return;
          }
          paramGetAppinfoResponse = paramContext.getString("yyb_url");
          if ((paramContext.getInt("AppState") != 1) || (TextUtils.isEmpty(paramGetAppinfoResponse))) {
            return;
          }
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(u, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
          }
        }
        if (PackageUtil.a(paramContext, localAndroidInfo.packName.get()))
        {
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = localBitmap;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.e(u, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
        }
      }
    }
    label365:
    label401:
    return;
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    }
    for (;;)
    {
      a().show();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.p, new String[] { paramString });
      return;
      if (paramInt == 2) {
        paramString = "1";
      } else if (paramInt == 3) {
        paramString = "2";
      } else {
        paramString = "3";
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    Object localObject;
    Uri localUri;
    do
    {
      do
      {
        return false;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramString)));
      localObject = Uri.parse((String)localObject);
      localUri = Uri.parse(paramString);
    } while ((((Uri)localObject).isOpaque()) || (localUri.isOpaque()) || (!((Uri)localObject).getScheme().equals(localUri.getScheme())) || (!((Uri)localObject).getHost().equals(localUri.getHost())));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidAppActivity))
    {
      QRUtils.a(1, 2131369008);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131369681);
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.length() > 30)) {
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.substring(0, 29);
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 40)) {
      this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.substring(0, 39);
    }
    a().b(2131369680);
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localObject = null;
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        break label396;
      }
      if ((paramInt != 1) || ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser))) {
        break label494;
      }
      if (paramString.length() <= 60) {
        break label303;
      }
      i1 = 1;
    }
    for (;;)
    {
      label181:
      boolean bool1;
      label199:
      boolean bool2;
      if ((i1 != 0) || (paramString.length() > 180))
      {
        bool1 = true;
        if ((this.d == null) || (this.d.length() <= 40)) {
          break label315;
        }
        bool2 = true;
        label221:
        if ((!paramBoolean) || (localObject != null) || (TextUtils.isEmpty(this.d))) {
          break label321;
        }
      }
      label303:
      label315:
      label321:
      for (boolean bool3 = true;; bool3 = false)
      {
        if ((!bool1) && (!bool2) && (!bool3)) {
          break label327;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        new jia(this, bool1, paramString, bool2, bool3, (Bitmap)localObject, paramInt).start();
        return true;
        localObject = (Bitmap)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break;
        i1 = 0;
        break label181;
        bool1 = false;
        break label199;
        bool2 = false;
        break label221;
      }
      label327:
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      String str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_c_of_type_JavaLangString;
      String str3 = this.d;
      if (paramBoolean) {}
      for (;;)
      {
        a(paramInt, str1, str2, paramString, str3, (Bitmap)localObject);
        break;
        localObject = null;
      }
      label396:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      long l1 = System.currentTimeMillis();
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), WebShareServlet.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "SQQzoneSvc.getUrlInfo");
      ((NewIntent)localObject).putExtra("extra_current_uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      ((NewIntent)localObject).putExtra("extra_url", paramString);
      ((NewIntent)localObject).setObserver(new jic(this, l1, paramString, paramInt, paramBoolean));
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject);
      return true;
      label494:
      i1 = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramBundle, false);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString3)) && (!paramBoolean) && (!a(paramString3))) {
      return false;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = paramString3;
    }
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString4;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (paramBundle != null) {}
    try
    {
      QLog.d(u, 1, "setSummary need parse extraData");
      this.jdField_b_of_type_Int = paramBundle.getInt("extra_url_info_from", -1);
      this.e = paramBundle.getString("cover_url");
      this.f = paramBundle.getString("source_name");
      this.jdField_a_of_type_Int = Integer.parseInt(paramBundle.getString("article_id"));
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        QLog.w(u, 1, "setSummary extraData parse articleId exception");
        this.jdField_a_of_type_Int = -1;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.w(u, 1, "setSummary extraData parse unknown exception");
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidAppActivity))
    {
      QRUtils.a(1, 2131369008);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QRUtils.a(1, 2131369681);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      paramString7 = (WebUiBaseInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((paramString7 == null) || (!(paramString7 instanceof WebUiUtils.WebTitleBarInterface))) {
        break label299;
      }
    }
    label144:
    label191:
    label197:
    label299:
    for (int i1 = ((WebUiUtils.WebTitleBarInterface)paramString7).getTitleBarHeight();; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369680);
      boolean bool;
      if ((paramString5 != null) && (paramString5.length() > 180))
      {
        bool = true;
        if ((paramString5 == null) || (paramString5.length() <= 40)) {
          break label191;
        }
        i1 = 1;
        if ((!bool) && (i1 == 0)) {
          break label197;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        new jih(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        i1 = 0;
        break label144;
        paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364569), new Object[] { paramString2 });
        ShareMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 1, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "http://url.cn/JS8oE7", paramString6, null);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (this.q != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.q, new String[] { "0" });
    }
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d()
  {
    if (this.r != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.r, new String[] { "1" });
    }
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e()
  {
    if (this.s != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.s, new String[] { "2" });
    }
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f()
  {
    if (this.jdField_t_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.jdField_t_of_type_JavaLangString, new String[] { "3" });
    }
  }
  
  public void onClick(View paramView)
  {
    GetAppInfoProto.AndroidInfo localAndroidInfo;
    if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      if ((paramView != this.jdField_a_of_type_AndroidWidgetImageView) && (paramView != this.jdField_a_of_type_AndroidViewView)) {
        break label197;
      }
      if (!PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get())) {
        break label98;
      }
      PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
      paramView = "run";
      Util.a(null, "", "webviewsourceclick", AppShareIDUtil.b(this.jdField_a_of_type_Long), 0L, paramView);
    }
    label98:
    label197:
    label408:
    do
    {
      for (;;)
      {
        return;
        paramView = new Bundle();
        paramView.putString("uin", this.n);
        paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
        paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
        paramView.putBoolean("autoDownload", true);
        paramView.putString("packageName", localAndroidInfo.packName.get());
        AppClient.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), 2470, paramView);
        paramView = "setup";
        break;
        if (paramView != this.jdField_b_of_type_AndroidWidgetTextView) {
          break label408;
        }
        if (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get()))
        {
          PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
          OpenSdkStatic.a().a(this.n, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "203", false);
        }
        while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          return;
          paramView = new Bundle();
          paramView.putString("uin", this.n);
          paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
          paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          paramView.putBoolean("autoDownload", true);
          paramView.putString("packageName", localAndroidInfo.packName.get());
          paramView.putString("appId", String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)));
          AppClient.b(this.jdField_a_of_type_AndroidAppActivity, paramView);
          OpenSdkStatic.a().a(this.n, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "202", false);
        }
      }
    } while ((paramView != this.jdField_b_of_type_AndroidWidgetLinearLayout) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\Share.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
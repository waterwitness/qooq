package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import wij;
import wik;
import wil;
import wim;
import win;
import wio;
import wip;
import wiq;
import wir;
import wis;

public class SwiftBrowserShareMenuHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback, AdapterView.OnItemClickListener, ScreenshotContentObserver.Listener, RangeButtonView.OnChangeListener
{
  public static final int a = 1;
  public static final String a = "qq";
  public static final int[] a;
  public static final int b = 2;
  public static final String b = "public_uin";
  public static final int c = 3;
  public static final String c = "source_public_uin";
  public static final int d = 4;
  public static final String d = "default_url";
  public static final int e = 5;
  public static final String e = "msg_id";
  public static final int f = 1;
  public static final String f = "troop_id";
  public static final String g = "troop_app_id";
  public static final String h = "troop_app_info_url";
  public static final String i = "troop_app_share_url";
  public static final String j = "uin_type";
  public static final int k = 1;
  static final String k = "SwiftBrowserShareMenuHandler";
  public static final int l = 2;
  public static final int m = 3;
  public long a;
  public Activity a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public PopupWindow a;
  private ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public Share a;
  public ElasticHorScrView a;
  public ActionSheet a;
  public final ArrayList a;
  public boolean a;
  public ElasticHorScrView b;
  private ActionSheet b;
  public boolean b;
  public boolean c;
  boolean d = false;
  private boolean e;
  private boolean f;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  int h;
  public int i;
  public int j = 1;
  public String l = "";
  public String m = "";
  private int n;
  public String n;
  private int o;
  public String o;
  private int jdField_p_of_type_Int;
  private String jdField_p_of_type_JavaLangString;
  private int jdField_q_of_type_Int;
  private String jdField_q_of_type_JavaLangString;
  private int jdField_r_of_type_Int;
  private String jdField_r_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
  }
  
  public SwiftBrowserShareMenuHandler()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_o_of_type_JavaLangString = "";
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->begin isShow:" + paramBoolean + ", orientation:" + paramInt);
    }
    if (paramBoolean) {
      if (!this.jdField_g_of_type_Boolean) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag() instanceof Integer)))
          {
            int i1 = ((Integer)this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag()).intValue();
            if (i1 != paramInt)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->orientation change old:" + i1 + ", new:" + paramInt);
              }
              localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297376);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
              this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903489, null));
            localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297376);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(15);
            localLayoutParams.setMargins(0, 0, AIOUtils.a(7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramInt));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298778).setOnClickListener(new wir(this));
            ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298779).getLayoutParams()).height = (this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493690) * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298779).setOnClickListener(new wis(this));
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
          }
          ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298779)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
        return;
        if (QLog.isDevelopLevel())
        {
          QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility());
          }
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0));
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      ((AlphaAnimation)localObject).setAnimationListener(new wik(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    } while (!QLog.isDevelopLevel());
    QLog.d("SwiftBrowserShareMenuHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
  }
  
  private List[] b()
  {
    ArrayList localArrayList = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364561);
    localActionSheetItem.u = 2130838114;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 2;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364567);
    localActionSheetItem.u = 2130838115;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 3;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364577);
    localActionSheetItem.u = 2130838116;
    localActionSheetItem.v = 9;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364578);
    localActionSheetItem.u = 2130838112;
    localActionSheetItem.v = 10;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void h()
  {
    if (a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int i2 = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 190;
      }
      str = String.format("var getSharePreviewImage=function(e){var l=function(t,r){var q;r=r.toLowerCase();if(r&&typeof value===\"undefined\"){if(t.style&&t.style[r]){q=t.style[r]}else{if(t.currentStyle){r=r.replace(/\\-([a-z])([a-z]?)/ig,function(w,v,u){return v.toUpperCase()+u.toLowerCase()});q=t.currentStyle[r]}else{if(document.defaultView&&document.defaultView.getComputedStyle){var s=document.defaultView.getComputedStyle(t,null);q=s.getPropertyValue(r)}}}if(q.indexOf(\"px\")!=-1){q=q.replace(/(px)/i,\"\")}return q}};var o=function(q){return document.getElementsByTagName(q)};var g=false;var b=function(q){if(g){return}g=true;e(q)};var a=o(\"img\");if(a.length==0){return b()}var c={};var d=[];for(var k=0;k<a.length;k++){var n=a[k];if(l(n,\"display\")==\"none\"||l(n,\"visibility\")==\"hidden\"){continue}if(c[n.src]){}else{c[n.src]=1;d.push(n)}}var j=[];var m=%d;var p=%d;var h;for(var k=0;k<d.length&&k<100;k++){h=d[k];var f=new Image();f.onload=function(){this.isLoaded=true;var s=0;for(var q=0;q<j.length;q++){var r=j[q];if(!r.isLoaded){break}s++;if(r.width>=m&&r.height>=p){b(r);break}}if(s==j.length){b()}};f.src=h.src;j.push(f)}setTimeout(function(){for(var q=0;q<j.length;q++){var r=j[q];if(!r.isLoaded){continue}if(r.width>=m&&r.height>=p){b(r);return}}b()},1000)};getSharePreviewImage(function(e){var h=document.documentURI;var k=document.getElementsByTagName(\"meta\");var a=\"\";var b=\"\";for(i in k){if(typeof k[i].name!=\"undefined\"&&k[i].name.toLowerCase()==\"description\"){a=k[i].content;if(typeof k[i].getAttribute(\"itemprop\")!=\"undefined\"&&(k[i].getAttribute(\"itemprop\")+\"\").toLowerCase()==\"description\"){if(typeof k[i].content!=\"undefined\"&&k[i].content!=\"\"){b=k[i].content}}}}if(b!=\"\"){a=b}var f=(a!=\"\")?a:document.documentURI;var j=document.title;var l=\"\";if(e){if(e instanceof Array){if(e[0]){l=e[0].src}}else{l=e.src}console.log(\"Current found Image : \"+l)}else{console.log(\"Inject WxJs But Still Not Found Image\")}var c=encodeURIComponent(JSON.stringify({\"type\":\"share\",\"image\":l,\"title\":j,\"summary\":f,\"shareURL\":h,\"callback\":\"1\"}));var g=\"jsbridge://share/setShare?p=\"+c;var d=document.createElement(\"iframe\");d.style.cssText=\"display:none;width:0px;height:0px;\";(document.body||document.documentElement).appendChild(d);d.src=g});", new Object[] { Integer.valueOf(i1), Integer.valueOf(i1) });
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().loadUrl("javascript:" + str + ";");
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new wip(this);
  }
  
  protected View a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130903348, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298208));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298211));
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    Object localObject2 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) && (localObject2 != null))
    {
      localObject1 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (((SwiftBrowserStatistics)localObject2).h)
      {
        localObject2 = new TextView(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
        ((TextView)localObject2).setText(Html.fromHtml("<font color='#777777'>应用由 </font><font color='#00a5e0'>" + ((QQBrowserActivity)localObject1).aC + "</font><font color='#777777'> 提供</font>"));
        ((TextView)localObject2).setTextSize(18.0F);
        localObject3 = (LinearLayout)localView.findViewById(2131298207);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 22);
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).gravity = 17;
        ((LinearLayout.LayoutParams)localObject4).setMargins(0, 35, 0, 35);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((LinearLayout)localObject3).addView((View)localObject2, 0);
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
        ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, "" + ((QQBrowserActivity)localObject1).M, "" + ((QQBrowserActivity)localObject1).L, "", "");
      }
    }
    Object localObject4 = (GridView)localView.findViewById(2131298209);
    Object localObject3 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    float f1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(new wij(this, paramBoolean));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    ((GridView)localObject3).setSmoothScrollbarEnabled(false);
    label488:
    label501:
    int i1;
    label609:
    int i2;
    if (paramBoolean)
    {
      localObject2 = b();
      if (localObject2.length <= 0) {
        break label782;
      }
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label794;
      }
      localObject2 = localObject2[1];
      i1 = ((List)localObject1).size();
      ((GridView)localObject4).setNumColumns(i1);
      ViewGroup.LayoutParams localLayoutParams = ((GridView)localObject4).getLayoutParams();
      localLayoutParams.width = ((int)(((i1 - 1) * 10 + i1 * 75 + 3) * f1));
      ((GridView)localObject4).setLayoutParams(localLayoutParams);
      ((GridView)localObject4).setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
      ((GridView)localObject4).setSelector(new ColorDrawable(0));
      if (!paramBoolean) {
        break label807;
      }
      if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener == null) {
        i();
      }
      ((GridView)localObject4).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      i1 = localLayoutParams.width;
      this.h = i1;
      i2 = ((List)localObject2).size();
      localObject1 = localView.findViewById(2131298210);
      if (i2 > 0) {
        break label816;
      }
      ((View)localObject1).setVisibility(8);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    for (;;)
    {
      localObject1 = ((GridView)localObject3).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f1 * (i2 * 75 + (i2 - 1) * 10 + 3)));
      ((GridView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((GridView)localObject3).setNumColumns(i2);
      ((GridView)localObject3).setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
      ((GridView)localObject3).setSelector(new ColorDrawable(0));
      ((GridView)localObject3).setOnItemClickListener(this);
      i2 = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_g_of_type_Int = i2;
      localView.post(new wil(this, i1, i2));
      return localView;
      localObject2 = a();
      break;
      label782:
      localObject1 = new ArrayList(0);
      break label488;
      label794:
      localObject2 = new ArrayList(0);
      break label501;
      label807:
      ((GridView)localObject4).setOnItemClickListener(this);
      break label609;
      label816:
      ((View)localObject1).setVisibility(0);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(0);
    }
  }
  
  public TroopMemberApiClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    return this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    super.a();
    this.d = false;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    b();
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_p_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.l)) {
      return;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1001, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 1: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1011, 1, 0, this.l, (String)localObject2, this.m, (String)localObject3);
      return;
    case 2: 
    case 3: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1002, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    case 9: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1003, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    case 10: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1004, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    case 5: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1005, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    case 4: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1006, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    case 6: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1007, 1, 0, this.l, (String)localObject2, this.m, localException);
      return;
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1008, 1, 0, this.l, (String)localObject2, this.m, localException);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    e();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    label192:
    label203:
    label212:
    for (;;)
    {
      return;
      this.d = true;
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      g();
      return;
      if ((paramBundle != null) && (paramBundle.getInt("state_machine_step", -1) == 0))
      {
        d();
        return;
        paramInt = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
        if ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView != null) && (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView != null))
        {
          if (paramInt >= this.h) {
            break label192;
          }
          this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
          if (paramInt >= this.jdField_g_of_type_Int) {
            break label203;
          }
          this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
            break label212;
          }
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
          c();
          return;
          this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
          break;
          this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    String str6 = "";
    String str5;
    String str4;
    String str3;
    String str2;
    String str1;
    int i3;
    int i1;
    int i2;
    if (paramBundle != null)
    {
      str5 = paramBundle.getString("qq", "");
      str4 = paramBundle.getString("public_uin", "");
      str3 = paramBundle.getString("source_public_uin", "");
      str2 = paramBundle.getString("default_url", "");
      str1 = paramBundle.getString("msg_id", "");
      i3 = paramBundle.getInt("troop_app_id", 0);
      i1 = paramBundle.getInt("troop_id", 0);
      str6 = paramBundle.getString("troop_app_info_url", "");
      i2 = paramBundle.getInt("uin_type", 0);
    }
    for (;;)
    {
      String str8 = this.jdField_p_of_type_JavaLangString;
      String str7 = str8;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
      {
        str7 = str8;
        if (!TextUtils.isEmpty(((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).G)) {
          str7 = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).G;
        }
      }
      if (paramInt == 1)
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
        QRUtils.a(2, 2131364463);
      }
      label1389:
      label1461:
      label1478:
      label1716:
      do
      {
        for (;;)
        {
          if ((i2 == 1008) && ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))) {
            a(paramInt);
          }
          return;
          if (paramInt == 11)
          {
            paramBundle = Pattern.compile("http://.*.mp.qq.com.*").matcher(paramString);
            i1 = 0;
            if (paramBundle.matches()) {
              i1 = 1;
            }
            paramBundle = null;
            try
            {
              paramString = URLEncoder.encode(paramString, "UTF-8");
              if (i1 != 0)
              {
                str7 = String.valueOf(NetConnInfoCenter.getServerTime());
                str6 = MD5Utils.b(paramString + 200 + str7 + "jubao@article@123");
                paramBundle = str6;
                if (str6 != null)
                {
                  paramBundle = str6;
                  if (!str6.isEmpty()) {
                    paramBundle = str6.toLowerCase();
                  }
                }
                paramString = "http://jubao.mp.qq.com/mobile/report?qq=" + str5 + "&mp_uin=" + str4 + "&scene=200&sub_appname=article_webview&timestamp=" + str7 + "&sign=" + paramBundle + "&article_url=" + paramString;
                paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramBundle.putExtra("url", paramString);
                paramBundle.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
                if ((str3 == null) || ("".equals(str3))) {
                  continue;
                }
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str3, str1, str2, AccountDetailActivity.a(str2));
              }
            }
            catch (UnsupportedEncodingException paramString)
            {
              for (;;)
              {
                paramString = paramBundle;
                if (QLog.isColorLevel())
                {
                  QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
                  paramString = paramBundle;
                  continue;
                  paramString = "http://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str5 + "&_wv=7";
                }
              }
            }
          }
          else
          {
            if (paramInt == 2)
            {
              PublicAccountUtil.a(1001, str7, this.jdField_r_of_type_Int);
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_p_of_type_JavaLangString)) {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 1, false);
              }
              for (;;)
              {
                ReportCenter.a().a("", "", "", "1000", "101", "0", false);
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_q_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
                } else {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 1, false);
                }
              }
            }
            if (paramInt == 4)
            {
              paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
              paramString.putExtra("normal", true);
              try
              {
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, Util.b(str2, new String[0]), null, null, null);
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
                if ((str3 == null) || ("".equals(str3))) {
                  continue;
                }
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str3, str1, str2, AccountDetailActivity.a(str2));
              }
              catch (ActivityNotFoundException paramString)
              {
                for (;;)
                {
                  QRUtils.a(1, 2131364483);
                }
              }
            }
            else if (paramInt == 5)
            {
              if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
              {
                if (!TextUtils.isEmpty(paramString))
                {
                  paramBundle = new HashMap();
                  paramBundle.put("KEY_PID", String.valueOf(50079));
                  paramBundle.put("KEY_EUSESTAT", String.valueOf(5));
                  paramBundle.put("ChannelID", this.jdField_a_of_type_AndroidAppActivity.getApplicationInfo().processName);
                  paramBundle.put("PosID", Integer.toString(0));
                  paramString = MttLoader.getValidQBUrl(this.jdField_a_of_type_AndroidAppActivity, paramString);
                  i1 = MttLoader.loadUrl(this.jdField_a_of_type_AndroidAppActivity, paramString, paramBundle, null);
                  if ((4 == i1) || (5 == i1) || (i1 != 0))
                  {
                    paramString = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(16);
                    if (paramString != null) {
                      paramString.a("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367", true);
                    }
                  }
                }
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
                ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, Util.b(str2, new String[0]), null, null, null);
                if ((str3 != null) && (!"".equals(str3))) {
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, str3, str1, str2, AccountDetailActivity.a(str2));
                }
              }
              else
              {
                throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
              }
            }
            else
            {
              if (paramInt == 3)
              {
                PublicAccountUtil.a(1002, str7, this.jdField_r_of_type_Int);
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_p_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 2, false);
                }
                for (;;)
                {
                  ReportCenter.a().a("", "", "", "1000", "102", "0", false);
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
                  break;
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_r_of_type_JavaLangString)) {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d();
                  } else {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 2, false);
                  }
                }
              }
              if (paramInt == 6)
              {
                if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
                {
                  ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).a(paramString, true);
                  if ((str3 != null) && (!"".equals(str3))) {
                    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str3, str1, str2, AccountDetailActivity.a(str2));
                  }
                }
                else
                {
                  throw new InvalidParameterException("ACTION_ADD_FAVORITER should be handled by QQBrowserActivity!");
                }
              }
              else if ((paramInt == 9) || (paramInt == 10))
              {
                i1 = -1;
                if (paramInt == 9)
                {
                  PublicAccountUtil.a(1003, str7, this.jdField_r_of_type_Int);
                  if (WXShareHelper.a().a()) {
                    break label1461;
                  }
                  i1 = 2131369529;
                }
                for (;;)
                {
                  if (i1 == -1) {
                    break label1478;
                  }
                  QRUtils.a(0, i1);
                  if (paramInt != 9) {
                    break label1716;
                  }
                  ReportCenter.a().a("", "", "", "1000", "103", "0", false);
                  break;
                  PublicAccountUtil.a(1004, str7, this.jdField_r_of_type_Int);
                  break label1389;
                  if (!WXShareHelper.a().b()) {
                    i1 = 2131369530;
                  }
                }
                if (paramInt == 9)
                {
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_p_of_type_JavaLangString)) {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 3, true);
                  }
                  for (;;)
                  {
                    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
                    if ((str3 == null) || ("".equals(str3))) {
                      break;
                    }
                    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, str3, str1, str2, AccountDetailActivity.a(str2));
                    break;
                    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.s)) {
                      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e();
                    } else {
                      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 3, true);
                    }
                  }
                }
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_p_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 4, true);
                }
                for (;;)
                {
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
                  break;
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.t)) {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.f();
                  } else {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 4, true);
                  }
                }
                if (paramInt == 10) {
                  ReportCenter.a().a("", "", "", "1000", "104", "0", false);
                }
              }
              else if (paramInt == 13)
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 5, true);
              }
              else if (paramInt == 15)
              {
                if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
                  throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
                }
                paramString = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
                if (!NetworkUtil.e(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
                {
                  QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, 2131367461, 0).b(paramString.getTitleBarHeight());
                  return;
                }
                a().a(i3, new wim(this, paramString));
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i1, "" + i3, "", "");
              }
              else if (paramInt == 16)
              {
                paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramString.putExtra("shareUrl", str6);
                paramString.putExtra("hide_operation_bar", true);
                paramString.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i1, "" + i3, "", "");
              }
              else if (paramInt == 17)
              {
                paramString = "";
                if (paramBundle != null) {
                  paramString = paramBundle.getString("troop_app_share_url", "");
                }
                paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramBundle.putExtra("shareUrl", paramString);
                paramBundle.putExtra("hide_operation_bar", true);
                paramBundle.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i1, "" + i3, "", "");
              }
              else
              {
                if (paramInt == 18)
                {
                  if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
                    throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
                  }
                  paramString = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
                  paramBundle = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
                  if ((!TextUtils.isEmpty(paramString.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) && (paramBundle != null))
                  {
                    paramString.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c = false;
                    paramBundle.n = System.currentTimeMillis();
                    paramString.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
                    paramString.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnCustomScrollChangeListener(null);
                    paramBundle.a(paramString.jdField_a_of_type_ComTencentBizUiTouchWebView, paramString.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 1, 0, 0, 0, 0, null);
                  }
                  for (;;)
                  {
                    ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + i1, "" + i3, "", "");
                    break;
                    str1 = paramString.getCurrentUrl();
                    if ((!TextUtils.isEmpty(str1)) && (paramBundle != null))
                    {
                      paramString.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c = false;
                      paramBundle.n = System.currentTimeMillis();
                      paramString.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str1);
                      paramBundle.a(paramString.jdField_a_of_type_ComTencentBizUiTouchWebView, str1, 1, 0, 0, 0, 0, null);
                    }
                  }
                }
                if (paramInt != 7) {
                  break;
                }
                c();
              }
            }
          }
        }
      } while ((paramInt != 19) && (paramInt != 20));
      if (paramInt == 19) {}
      for (i1 = 6;; i1 = 7)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, i1, true);
        break;
      }
      i2 = 0;
      i1 = 0;
      i3 = 0;
      str1 = "";
      str2 = "";
      str3 = "";
      str4 = "";
      str5 = "";
    }
  }
  
  public void a(long paramLong)
  {
    ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2)).jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
    paramIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, 6, this.jdField_q_of_type_JavaLangString, BaseApplicationImpl.a().a().getAccount(), "", "", "分享", 0);
  }
  
  public void a(Uri paramUri, String paramString)
  {
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (!((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->activity is not resume!");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->begin time:" + System.currentTimeMillis());
    }
    paramUri = "";
    paramString = Uri.parse(this.jdField_p_of_type_JavaLangString);
    try
    {
      paramString = paramString.getQueryParameter("article_id");
      paramUri = paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i1;
        paramString.printStackTrace();
        continue;
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), null, false);
      }
    }
    paramString = paramUri;
    if (paramUri == null) {
      paramString = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->after report time:" + System.currentTimeMillis());
    }
    paramUri = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297831);
    paramString = paramUri.getDrawingCache();
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->get screenshot time:" + System.currentTimeMillis());
    }
    i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation;
    if (paramString != null) {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    try
    {
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label446;
      }
      int i2 = ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramString, 0, i2, paramString.getWidth(), paramString.getHeight() - i2, null, false);
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->clip screenshot time:" + System.currentTimeMillis());
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Message localMessage;
        localOutOfMemoryError.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.e = true;
      localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = i1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onDetectScreenshot->send msg_show_pad time:" + System.currentTimeMillis());
      }
      ThreadManager.c(new wiq(this));
    }
    paramString.recycle();
    paramUri.destroyDrawingCache();
  }
  
  public void a(Share paramShare, long paramLong)
  {
    if (paramShare == null) {}
    while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    Object localObject1 = this.jdField_p_of_type_JavaLangString;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) && (!TextUtils.isEmpty(((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).G))) {
      localObject1 = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).G;
    }
    for (;;)
    {
      PublicAccountUtil.a((String)localObject1);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = paramShare;
      this.jdField_a_of_type_Long = paramLong;
      b();
      h();
      a();
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
        paramShare = a(false);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(paramShare, null);
      }
      try
      {
        for (;;)
        {
          if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          }
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
            break;
          }
          QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
          if (localQQBrowserActivity.t != 1008) {
            break;
          }
          paramShare = a();
          localObject1 = paramShare;
          if (paramShare == null) {
            localObject1 = localQQBrowserActivity.ab;
          }
          if (TextUtils.isEmpty(localQQBrowserActivity.aw)) {
            break;
          }
          paramShare = "";
          Object localObject2 = Uri.parse((String)localObject1);
          try
          {
            localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
            paramShare = (Share)localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          localObject2 = paramShare;
          if (paramShare == null) {
            localObject2 = "";
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 1, 0, localQQBrowserActivity.aw, (String)localObject1, localQQBrowserActivity.ax, (String)localObject2);
          return;
          paramShare = a(false);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.b(paramShare, null);
        }
      }
      catch (Exception paramShare)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramShare);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_p_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.d) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      int i1 = WebView.getTbsCoreVersion(this.jdField_a_of_type_AndroidAppActivity);
      if ((i1 > 0) && (i1 < 36201))
      {
        this.jdField_a_of_type_Boolean = false;
        return this.jdField_a_of_type_Boolean;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(Util.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) && (localObject1 != null))
    {
      localObject2 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (((SwiftBrowserStatistics)localObject1).h)
      {
        localObject1 = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131365261);
        ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130840057;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 15;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
        localArrayList.add(localObject1);
        localObject1 = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131365262);
        ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130840059;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 16;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
        localArrayList.add(localObject1);
        localObject1 = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131365263);
        ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130840062;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 17;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
        localArrayList.add(localObject1);
        localObject1 = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131365264);
        ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130840061;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 18;
        ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
        localArrayList.add(localObject1);
        return (List[])new ArrayList[] { localArrayList };
      }
    }
    localObject1 = null;
    if (BaseApplicationImpl.a().a() != null) {
      localObject1 = BaseApplicationImpl.a().a();
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364561);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130838114;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364567);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130838115;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (ReadInJoyHelper.a()) && (localObject1 != null))
    {
      localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences((String)localObject2, 4);
      if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
      {
        localObject2 = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364579);
        ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130838113;
        ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 13;
        ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
        localArrayList.add(localObject2);
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364577);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130838116;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 9;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364578);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130838112;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 10;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364566);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130839507;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364565);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130839505;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getPackageManager();
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L) && (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity((PackageManager)localObject2) != null))
    {
      PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364580);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.u = 2130840442;
      localActionSheetItem.v = 19;
      localActionSheetItem.b = "";
      localArrayList.add(localActionSheetItem);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364581);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).u = 2130840443;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).v = 20;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).b = "";
      localArrayList.add(localObject2);
    }
    localObject2 = new ArrayList();
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364576);
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130840304;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 6;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.c) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364562);
      ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130839506;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 7;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364563);
      ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130838111;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 1;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean))
    {
      localObject1 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364564);
      ((PublicAccountBrowser.ActionSheetItem)localObject1).u = 2130839494;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).v = 11;
      ((PublicAccountBrowser.ActionSheetItem)localObject1).b = "";
      ((ArrayList)localObject2).add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList, localObject2 };
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_p_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_p_of_type_JavaLangString == null)
    {
      this.jdField_p_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_p_of_type_JavaLangString == null) {
        this.jdField_p_of_type_JavaLangString = "";
      }
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      this.i = ((Bundle)localObject).getInt("uin_type");
      this.l = ((Bundle)localObject).getString("puin");
      this.m = ((Bundle)localObject).getString("msg_id");
      if (this.m == null) {
        this.m = "";
      }
      this.jdField_n_of_type_JavaLangString = ((Bundle)localObject).getString("source_puin");
      if (this.jdField_n_of_type_JavaLangString == null) {
        this.jdField_n_of_type_JavaLangString = "";
      }
      this.jdField_o_of_type_JavaLangString = ((Bundle)localObject).getString("friendUin");
      if (this.jdField_o_of_type_JavaLangString == null) {
        this.jdField_o_of_type_JavaLangString = "";
      }
      ((Bundle)localObject).getBoolean("isOpeningQunApp");
      this.jdField_n_of_type_Int = ((Bundle)localObject).getInt("appid");
      this.jdField_o_of_type_Int = ((Bundle)localObject).getInt("troopid");
      if (((Bundle)localObject).getString("extraParams") == null) {}
      this.jdField_r_of_type_Int = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null) || (this.d)) {
      return;
    }
    this.j = paramInt;
    paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSettings().setTextZoom(paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_r_of_type_JavaLangString = paramString;
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "showShareActionSheet->mEditScreenshotPath:" + this.jdField_r_of_type_JavaLangString + ", mScreenShotItemClickListener:" + this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    if ((this.jdField_b_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener == null))
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
      paramString = a(true);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.b(paramString, null);
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130903349, null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -1, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131298213);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title("小", TypedValue.applyDimension(1, 15.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("标准", TypedValue.applyDimension(1, 16.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("大", TypedValue.applyDimension(1, 18.0F, FontSettingManager.a)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.j);
    localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_AndroidAppActivity.getString(2131362112));
    localArrayList.add(this.jdField_a_of_type_AndroidAppActivity.getString(2131362113));
    localArrayList.add(this.jdField_a_of_type_AndroidAppActivity.getString(2131362114));
    localArrayList.add(this.jdField_a_of_type_AndroidAppActivity.getString(2131362115));
    localArrayList.add(this.jdField_a_of_type_AndroidAppActivity.getString(2131362116));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 83, 0, 0);
  }
  
  public void d()
  {
    if (a())
    {
      a().a(new win(this));
      return;
    }
    b(1);
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("sp_public_account_with_cuin_" + BaseApplicationImpl.a().a().getAccount(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("browser_font_size_index", this.j);
      ((SharedPreferences.Editor)localObject).commit();
    }
    a().a(this.j);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver == null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Object localObject = new DisplayMetrics();
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_p_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_q_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(this);
      localObject = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297831);
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new wio(this, (View)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.jdField_p_of_type_Int + ", mScreenHeight:" + this.jdField_q_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener == null) {
      i();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        View localView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297831);
        if (localView != null) {
          localView.setDrawingCacheEnabled(false);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      a(true, paramMessage.arg1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
      }
      a(false, 0);
      continue;
      paramMessage = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhotoPlusBridgeActivity.class);
      paramMessage.putExtra("photo_path", this.jdField_q_of_type_JavaLangString);
      paramMessage.putExtra("iswaitforsult", true);
      paramMessage.putExtra("type", 1008);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramMessage, 100003);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SwiftBrowserShareMenuHandler", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    paramInt = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
    paramAdapterView = a();
    paramView = new Bundle();
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
    {
      QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      paramView.putString("qq", localQQBrowserActivity.J);
      paramView.putString("public_uin", localQQBrowserActivity.aw);
      paramView.putString("source_public_uin", localQQBrowserActivity.ay);
      paramView.putString("default_url", localQQBrowserActivity.ab);
      paramView.putString("msg_id", localQQBrowserActivity.ax);
      paramView.putString("troop_app_info_url", localQQBrowserActivity.aE);
      paramView.putString("troop_app_share_url", localQQBrowserActivity.aD);
      paramView.putInt("troop_id", localQQBrowserActivity.M);
      paramView.putInt("troop_app_id", localQQBrowserActivity.L);
      paramView.putInt("uin_type", localQQBrowserActivity.t);
    }
    a(paramInt, paramAdapterView, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserShareMenuHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
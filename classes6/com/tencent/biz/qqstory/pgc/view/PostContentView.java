package com.tencent.biz.qqstory.pgc.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryPostDes;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryWebView;
import com.tencent.biz.qqstory.view.widget.ResponsiveScrollView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import imk;
import iml;
import imm;
import imn;
import imo;
import imq;
import imr;
import ims;
import imt;
import java.util.HashMap;

public class PostContentView
  extends BaseContentPagerView
  implements INetInfoHandler
{
  public static final int b = 0;
  public static final String b;
  public static final int c = 1;
  public static final String c = "sub";
  public static final int d = 2;
  public static final String d = "un_sub";
  public static final String e = "open_info_card";
  public static final String f = "forward";
  public static final String g = "show_toolbar";
  public static final String h = "getNetworkInfo";
  public static final String i = "open_bigvcontent";
  public static final String j = "showAlert";
  protected FrameLayout a;
  protected ImageButton a;
  protected LinearLayout a;
  public RelativeLayout a;
  protected QQStoryObserver a;
  public QQStoryContentActivity a;
  public QQStoryWebView a;
  public ResponsiveScrollView a;
  public HashMap a;
  private String[] a;
  protected QQAppInterface b;
  protected View c;
  protected View d;
  public boolean d;
  protected int e;
  public View e;
  protected boolean e;
  public View f;
  public boolean f;
  protected View g;
  public boolean g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = PostContentView.class.getName();
  }
  
  public PostContentView(QQStoryContentActivity paramQQStoryContentActivity, Story paramStory, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramQQStoryContentActivity, paramStory, paramOnClickListener);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "sub", "un_sub", "open_info_card", "forward", "show_toolbar", "getNetworkInfo", "open_bigvcontent", "showAlert" };
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ims(this);
    if (!TextUtils.isEmpty(paramStory.contentTips)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips(paramStory.contentTips);
    }
    for (;;)
    {
      this.d = paramBoolean;
      setHideBottom(this.d, true);
      this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity = paramQQStoryContentActivity;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.app;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips("阅读");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:" + paramString1 + "('" + paramString2.replace("'", "\"") + "')");
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    String str1 = "{\"ret\":1}";
    if (paramString1.equals("sub")) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.b, this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.e, 0, 1);
      }
    }
    String str2;
    do
    {
      do
      {
        return;
        if (!paramString1.equals("un_sub")) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler == null);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.b, this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.e, 1, 1);
      return;
      if (paramString1.equals("forward"))
      {
        if (a()) {
          str1 = "{\"ret\":0}";
        }
        a(paramString2, str1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        return;
      }
      if (paramString1.equals("open_info_card"))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.a.nick))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.a(5);
          str1 = "{\"ret\":0}";
        }
        a(paramString2, str1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        return;
      }
      if (paramString1.equals("show_toolbar"))
      {
        str2 = str1;
        if (paramArrayOfString != null)
        {
          str2 = str1;
          if (paramArrayOfString.length > 0)
          {
            b(paramArrayOfString[0].equals("0"));
            str2 = "{\"ret\":0}";
          }
        }
        a(paramString2, str2);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        return;
      }
      if (paramString1.equals("getNetworkInfo"))
      {
        int k = NetworkUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity);
        a(paramString2, "{\"ret\":0,\"netType\":" + k + "}");
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        return;
      }
      if (paramString1.equals("open_bigvcontent"))
      {
        str2 = str1;
        if (paramArrayOfString != null)
        {
          str2 = str1;
          if (paramArrayOfString.length > 2)
          {
            str2 = str1;
            if (getContext() != null) {
              str1 = paramArrayOfString[0];
            }
          }
        }
        try
        {
          long l = Long.parseLong(paramArrayOfString[1]);
          if (!paramArrayOfString[2].equals("0")) {
            bool = true;
          }
          StoryPlayVideoActivity.a((Activity)getContext(), l, str1, bool);
          str2 = "{\"ret\":0}";
        }
        catch (Exception paramArrayOfString)
        {
          for (;;)
          {
            str2 = "{\"ret\":2}";
          }
        }
        a(paramString2, str2);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        return;
      }
    } while (!paramString1.equals("showAlert"));
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "网络提醒", "你当前处于非WIFI网络，观看视频将会产生流量费用。", "取消", "继续观看", new imq(this, paramString2), new imr(this, paramString2)).show();
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130904472, this, false));
    this.c = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298843);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298715);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302730);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView = ((ResponsiveScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297559));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131302850));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView = new QQStoryWebView(getContext().getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131302849));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    k();
    j();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setScrollbarFadingEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setScrollbarFadingEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setJavaScriptEnabled(true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setAllowFileAccess(true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setLoadWithOverviewMode(true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setUseWideViewPort(true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setSaveFormData(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setSavePassword(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.title)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new iml(this));
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  public QQStoryWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView;
  }
  
  public void a(int paramInt)
  {
    if ((this.j != 0) || (this.jdField_f_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:try{hideWebviewPage();}catch(e){}");
      AppNetConnInfo.unregisterNetInfoHandler(this);
      for (;;)
      {
        super.a(paramInt);
        return;
        if (this.jdField_f_of_type_Boolean) {}
        try
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:try{showWebviewPage();}catch(e){}");
          if (!this.jdField_e_of_type_Boolean)
          {
            StoryReportor.a("play_page_share", "exp", ((QQStoryContentActivity)getContext()).g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
            this.jdField_e_of_type_Boolean = true;
          }
          AppNetConnInfo.registerConnectionChangeReceiver(getContext().getApplicationContext(), this);
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected void b(boolean paramBoolean)
  {
    setHideBottom(paramBoolean, false);
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt == 1) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.getScrollY() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.getScrollY() == 0);
  }
  
  public void c()
  {
    super.c();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setCookies(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url, (CookieManager)localObject);
      this.jdField_f_of_type_Boolean = false;
      localObject = Uri.parse(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("comeFrom", this.jdField_a_of_type_Int + "");
      this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url = ((Uri.Builder)localObject).toString();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url);
    }
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setWebViewClient(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.onPause();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("about:blank");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.removeAllViews();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.destroy();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      super.d();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void e()
  {
    if (this.jdField_f_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:try{showWebviewPage();}catch(e){}");
      if (this.j == 1) {
        AppNetConnInfo.registerConnectionChangeReceiver(getContext().getApplicationContext(), this);
      }
      super.e();
      this.g = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    if (this.jdField_f_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:try{hideWebviewPage();}catch(e){}");
      if (this.j == 1) {
        AppNetConnInfo.unregisterNetInfoHandler(this);
      }
      super.f();
      this.g = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void g()
  {
    post(new imn(this));
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setOnEndScrollListener(new imm(this));
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setWebViewClient(new imo(this));
  }
  
  protected void l()
  {
    post(new imt(this));
  }
  
  public void onNetMobile2None()
  {
    l();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    l();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    l();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    l();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    l();
  }
  
  public void onNetWifi2None()
  {
    l();
  }
  
  public void setHideBottom(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (this.d == paramBoolean1)) {
      return;
    }
    this.d = paramBoolean1;
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131300908).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131302851).setVisibility(8);
    }
    for (;;)
    {
      post(new imk(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131300908).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.findViewById(2131302851).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\PostContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
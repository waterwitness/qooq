package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import jio;
import jip;
import jiq;
import jir;

public class UrlCheckPlugin
  extends WebViewPlugin
{
  public static int a = 0;
  public static final String a = "URL_CHECK";
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  private static final int i = 1;
  private static final int j = 2;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SoftKeyboardObserver a;
  public CustomWebView a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jir(this);
  private boolean jdField_a_of_type_Boolean;
  public int e = jdField_a_of_type_Int;
  private int f;
  private int g;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UrlCheckPlugin()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    this.mPluginNameSpace = "URL_CHECK";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null) {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, new jip(this));
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof BaseActivity)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
        continue;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)localObject);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903250, null));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297873));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297874));
        this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      }
      try
      {
        k = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 49;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (k + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1002;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 262664;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new jiq(this));
        }
        if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
          this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager();
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(paramInt));
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.h + this.g);
        this.e = c;
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          return;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(this.TAG, 2, "addView exception:" + localException1.getMessage());
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int k = (int)(localException1.getDisplayMetrics().density * 25.0F + 0.5D);
        }
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.e == c))
    {
      localObject = ((Activity)localObject).getWindowManager();
      this.e = d;
    }
    try
    {
      ((WindowManager)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "removeView Error:" + localIllegalArgumentException.getMessage());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramString = this.mRuntime.a();
        } while (!(paramString instanceof BaseActivity));
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramString);
        a();
        if (paramLong != 8589934597L) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver != null)
        {
          this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
          this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
        }
      } while ((this.e != c) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      b();
      return false;
    } while ((paramLong != 8589934594L) || (this.f != 2) || (this.e == c));
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(new jio(this), this.g);
    return false;
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\UrlCheckPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
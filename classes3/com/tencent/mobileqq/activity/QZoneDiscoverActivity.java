package com.tencent.mobileqq.activity;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.DiscoverTab;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.widget.RedTouchExtendButton;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import mhh;
import mqq.os.MqqHandler;

public class QZoneDiscoverActivity
  extends ActivityGroup
  implements View.OnClickListener
{
  public static final String a = "tab_data";
  private static final String b = "QZoneDiscoverActivity";
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public QZoneDiscoverActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private void a()
  {
    QLog.d("QZoneDiscoverActivity", 4, "initTab");
    b();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    DiscoverTab localDiscoverTab;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localDiscoverTab = (DiscoverTab)((Iterator)localObject).next();
    } while (!localDiscoverTab.jdField_a_of_type_Boolean);
    for (;;)
    {
      localObject = localDiscoverTab;
      if (localDiscoverTab == null) {
        localObject = (DiscoverTab)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      a((DiscoverTab)localObject);
      return;
      localDiscoverTab = null;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {}
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    DiscoverTab localDiscoverTab;
    for (;;)
    {
      return;
      localLayoutParams = new LinearLayout.LayoutParams((int)UITools.a(this, 60.0F), (int)UITools.a(this, 29.0F));
      localLayoutParams.gravity = 16;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localDiscoverTab = (DiscoverTab)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localDiscoverTab != null) {
            break label106;
          }
          i += 1;
        }
      }
    }
    label106:
    RedTouchExtendButton localRedTouchExtendButton = new RedTouchExtendButton(this);
    localRedTouchExtendButton.setTag(localDiscoverTab);
    localDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton = localRedTouchExtendButton;
    localRedTouchExtendButton.setGravity(17);
    localRedTouchExtendButton.setText(localDiscoverTab.jdField_a_of_type_JavaLangString);
    localRedTouchExtendButton.setAppInfo(localDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo);
    if (i == 0) {
      localRedTouchExtendButton.setBackgroundResource(2130842919);
    }
    for (;;)
    {
      localRedTouchExtendButton.setTextSize(13.0F);
      localRedTouchExtendButton.setTextColor(getResources().getColorStateList(2131428336));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRedTouchExtendButton, localLayoutParams);
      localRedTouchExtendButton.setOnClickListener(this);
      break;
      if (i == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        localRedTouchExtendButton.setBackgroundResource(2130842920);
      } else {
        localRedTouchExtendButton.setBackgroundResource(2130842921);
      }
    }
  }
  
  private void b(DiscoverTab paramDiscoverTab)
  {
    if (paramDiscoverTab == null) {
      return;
    }
    QLog.d("QZoneDiscoverActivity", 2, "createAndShowChild name:" + paramDiscoverTab.jdField_a_of_type_JavaLangString);
    if (WebSoUtils.b(paramDiscoverTab.jdField_b_of_type_JavaLangString))
    {
      QLog.d("QZoneDiscoverActivity", 2, "hasProxyParam:" + paramDiscoverTab.jdField_b_of_type_Boolean);
      RemoteHandleManager.a().a().b(paramDiscoverTab);
    }
    c(paramDiscoverTab);
  }
  
  private void c(DiscoverTab paramDiscoverTab)
  {
    if (paramDiscoverTab == null) {}
    do
    {
      return;
      Intent localIntent = a(paramDiscoverTab.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("is_wns_proxy", paramDiscoverTab.jdField_b_of_type_Boolean);
      paramDiscoverTab.jdField_a_of_type_AndroidViewView = getLocalActivityManager().startActivity(paramDiscoverTab.jdField_a_of_type_JavaLangString, localIntent).getDecorView();
      QLog.d("QZoneDiscoverActivity", 2, "showTab name:" + paramDiscoverTab.jdField_a_of_type_JavaLangString);
    } while (paramDiscoverTab.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramDiscoverTab.jdField_a_of_type_AndroidViewView);
    RemoteHandleManager.a().a().a(paramDiscoverTab);
    paramDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo = null;
    paramDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton.setAppInfo(paramDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo);
  }
  
  Intent a(String paramString)
  {
    localObject2 = paramString;
    if (paramString != null)
    {
      localObject1 = Uri.parse(paramString);
      localObject2 = paramString;
      if (((Uri)localObject1).isHierarchical())
      {
        localObject2 = ((Uri)localObject1).getQueryParameter("_wv");
        if (localObject2 == null) {
          break label194;
        }
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong((String)localObject2, 10);
        localObject1 = paramString;
        paramString = paramString.replace("_wv=" + (String)localObject2, "_wv=" + (l | 0x20000));
        localObject1 = paramString;
        paramString = paramString + "&_fv=0";
        localObject2 = paramString;
      }
      catch (NumberFormatException paramString)
      {
        label194:
        localObject2 = localObject1;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("QZoneDiscoverActivity", 4, "_wv param not found");
        localObject2 = localObject1;
        continue;
      }
      paramString = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      paramString.putExtra("url", (String)localObject2);
      paramString.putExtra("fromQZone", true);
      paramString.putExtra("injectrecommend", true);
      paramString.putExtra("source_name", getString(2131367184));
      paramString.setData(Uri.parse((String)localObject2));
      paramString.addFlags(268435456);
      return paramString;
      localObject1 = paramString;
      if (paramString.indexOf("?") > 0)
      {
        localObject1 = paramString;
        paramString = paramString + "&_fv=0&_wv=" + 0L;
      }
      else
      {
        localObject1 = paramString;
        paramString = paramString + "?_fv=0&_wv=" + 0L;
      }
    }
  }
  
  public void a(DiscoverTab paramDiscoverTab)
  {
    QLog.d("QZoneDiscoverActivity", 2, "setTab name:" + paramDiscoverTab.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((DiscoverTab)localIterator.next()).jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton.setChecked(false);
    }
    paramDiscoverTab.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton.setChecked(true);
    ThreadManager.c().post(new mhh(this, paramDiscoverTab));
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof DiscoverTab))) {
      a((DiscoverTab)localObject);
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      }
      try
      {
        onBackPressed();
        return;
      }
      catch (Throwable paramView) {}
    } while (!QLog.isColorLevel());
    QLog.e("QZoneDiscoverActivity", 2, "onBackPressed", paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QLog.d("QZoneDiscoverActivity", 4, "onCreate");
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    super.setContentView(2130904713);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303840));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297886));
    paramBundle = (TextView)findViewById(2131297083);
    paramBundle.setText("返回");
    paramBundle.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("tab_data");
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1))
    {
      finish();
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QZoneDiscoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.intervideo.now;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.txproxy.XPlugin;
import mqq.app.MobileQQ;
import svt;
import svu;
import svv;
import svw;

public class NowLoadingActivity
  extends Activity
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, IVPluginEvtListener
{
  static final String jdField_a_of_type_JavaLangString = "XProxy|NowLoadingActivity";
  static boolean c;
  AlertDialog jdField_a_of_type_AndroidAppAlertDialog;
  Handler jdField_a_of_type_AndroidOsHandler;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  public RoundProgressBar a;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  public boolean d;
  
  public NowLoadingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidAppAlertDialog = null;
    this.b = false;
    this.d = false;
  }
  
  private void a()
  {
    NowProxy localNowProxy = (NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo != null)
    {
      localNowProxy.a.a(this);
      localNowProxy.a.d();
      return;
    }
    a("Live", 55535, "参数错误!");
  }
  
  private void b()
  {
    if (c) {
      a();
    }
    do
    {
      return;
      if (!NetworkUtil.h(this))
      {
        a("Live", 55534, "网络连接错误，请稍候再试!");
        return;
      }
      if (NetworkUtil.b(this)) {
        break label177;
      }
      int i = NetworkUtil.a(this);
      Object localObject = (NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181);
      if ((i == 4) || (((NowProxy)localObject).a.a.hasLocalPlugin())) {
        break;
      }
      localObject = new AlertDialog.Builder(this);
      ((AlertDialog.Builder)localObject).setTitle("提示");
      ((AlertDialog.Builder)localObject).setMessage("观看直播需先加载直播组件，当前处于非Wi-Fi网络环境下，将消耗少许流量，是否继续？");
      this.b = false;
      ((AlertDialog.Builder)localObject).setPositiveButton("取消", this);
      ((AlertDialog.Builder)localObject).setNegativeButton("继续", this);
      this.jdField_a_of_type_AndroidAppAlertDialog = ((AlertDialog.Builder)localObject).create();
      this.jdField_a_of_type_AndroidAppAlertDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppAlertDialog.setOnDismissListener(this);
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.show();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    a();
    return;
    label177:
    a();
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(100);
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new svw(this), 4000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    runOnUiThread(new svv(this, paramInt));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("直播组件下载失败，请点击屏幕重试");
    this.d = true;
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void b(String paramString)
  {
    finish();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(97);
  }
  
  public void onBackPressed()
  {
    ((NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181)).a.a("nowloadingback");
    StoryReportor.a("now_live", "user_cancel", 0, 0, new String[0]);
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.b = false;
        ((NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181)).a.a("now_nowificancel");
      } while (isFinishing());
      try
      {
        this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
        return;
      }
      catch (IllegalArgumentException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        return;
      }
      this.b = true;
      c = true;
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      return;
    }
    catch (IllegalArgumentException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130904462);
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar = ((RoundProgressBar)findViewById(2131302816));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131302817));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)getIntent().getSerializableExtra("plugininfo"));
    paramBundle = (ImageView)findViewById(2131302743);
    Drawable localDrawable = getResources().getDrawable(2130841568);
    try
    {
      paramBundle.setImageDrawable(localDrawable);
      findViewById(2131302743).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302818));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramBundle = (NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181);
      if ((paramBundle.a.a.getStatus() == 3) || (paramBundle.a.a.getStatus() == 2)) {
        a("Live", 100);
      }
      findViewById(2131302743).setOnClickListener(new svt(this));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new svu(this), 50L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramBundle.setImageDrawable(localDrawable);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((NowProxy)((QQAppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null)).getManager(181)).b(this);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.b)
    {
      a();
      return;
    }
    super.finish();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowLoadingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
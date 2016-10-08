package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import ofg;
import ofh;
import ofi;
import ofk;
import ofl;
import ofm;

public class BlessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 0.6933333F;
  public static final String a = "PARAM_IS_FROM_SEARCH";
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BlessManager jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager;
  private QQVideoView jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public BlessActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "BlessActivity";
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "stopPlayingStarVideo mNeedShowStarVideo=" + this.jdField_b_of_type_Boolean + ", mIsPlayingStarVideo=" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (paramBoolean)
      {
        View localView = findViewById(2131297132);
        localView.setVisibility(0);
        localView.bringToFront();
        findViewById(2131297134).bringToFront();
        findViewById(2131297123).bringToFront();
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.stopPlayback();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    Object localObject1 = (RelativeLayout)findViewById(2131296895);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = ((QQVideoView)findViewById(2131297133));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoPath(this.jdField_c_of_type_JavaLangString);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = this.jdField_c_of_type_Int;
    int i = (int)(j / '΄' * 'ʼ' + 0.5F);
    if (i % 2 == 1) {
      i += 1;
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      c();
      Object localObject2 = (RelativeLayout.LayoutParams)findViewById(2131297132).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297131));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      try
      {
        localObject2 = new FileInputStream(this.jdField_d_of_type_JavaLangString);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, j, i));
        localObject2 = BitmapManager.a(this.jdField_d_of_type_JavaLangString, localOptions);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = j;
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_b_of_type_JavaLangString, 2, "decode mVideoCoverPath error = " + localException.getMessage());
          }
        }
      }
      findViewById(2131297123).bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(j, i);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getLayoutParams()).setMargins(0, 0, 0, 0);
      this.jdField_b_of_type_AndroidViewView = new View(this);
      ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidViewView);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)(localDisplayMetrics.density * 31.0F + 0.5F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      this.jdField_b_of_type_AndroidViewView.bringToFront();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ofh(this));
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(new ofi(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(new ofk(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(new ofl(this));
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ofm(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    ((ImmersiveTitleBar2)findViewById(2131297137)).setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297123);
    findViewById(2131297083).setOnClickListener(this);
    findViewById(2131297136).setOnClickListener(this);
    Object localObject1 = (ImageView)findViewById(2131297134);
    int i = BlessManager.g();
    int j = (int)(i * 0.6933333F);
    ((ImageView)localObject1).getLayoutParams().height = j;
    ((ImageView)localObject1).requestLayout();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "target banner size: " + i + " * " + j);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
    if (localObject2 != null) {}
    try
    {
      localFileInputStream = new FileInputStream((String)localObject2);
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = ((int)ImageUtil.a(localFileInputStream, i, j));
      localObject2 = BitmapManager.a((String)localObject2, localOptions);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        FileInputStream localFileInputStream;
        BitmapFactory.Options localOptions;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "banner not exist");
        }
      }
    }
    localObject1 = (ImageView)findViewById(2131297135);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    if (localObject2 != null) {}
    try
    {
      localFileInputStream = new FileInputStream((String)localObject2);
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = ((int)ImageUtil.a(localFileInputStream, ((ImageView)localObject1).getLayoutParams().width, ((ImageView)localObject1).getLayoutParams().height));
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "target center size: " + ((ImageView)localObject1).getLayoutParams().width + " * " + ((ImageView)localObject1).getLayoutParams().height);
      }
      localObject2 = BitmapManager.a((String)localObject2, localOptions);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "center not exist");
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = (RelativeLayout)findViewById(2131296895);
      ((RelativeLayout)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new ofg(this, (RelativeLayout)localObject1));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903104);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h())
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.g();
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h();
      if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString != null)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromoutweb", false);
    this.f = getIntent().getBooleanExtra("PARAM_IS_FROM_SEARCH", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnPause");
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      if (!this.e) {
        break label48;
      }
      a(true);
    }
    for (;;)
    {
      super.doOnPause();
      return;
      label48:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getCurrentPosition();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent");
    }
    a(false);
    if (!this.f)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297083: 
      onBackEvent();
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f() <= 0)
    {
      QQToast.a(this, String.format(getString(2131372357), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }), 0).b(this.jdField_a_of_type_AndroidViewView.getHeight());
      paramView = this.app;
      if (!this.jdField_a_of_type_Boolean) {
        break label288;
      }
    }
    for (;;)
    {
      ReportController.b(paramView, "CliOper", "", "", "0X800618C", "0X800618C", i, 0, "", "", "", "");
      return;
      paramView = new Intent(this, SelectMemberActivity.class);
      paramView.putExtra("param_type", 9003);
      paramView.putExtra("param_entrance", 15);
      paramView.putExtra("param_only_friends", true);
      paramView.putExtra("param_donot_need_contacts", true);
      paramView.putExtra("param_title", getString(2131372354));
      paramView.putExtra("param_done_button_wording", getString(2131366640));
      paramView.putExtra("param_max", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f());
      paramView.putExtra("param_uins_selected_friends", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a());
      paramView.putExtra("param_exit_animation", 1);
      startActivity(paramView);
      overridePendingTransition(2130968590, 2130968591);
      break;
      label288:
      i = 0;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.activity.bless;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import ogb;
import ogc;
import oge;

public class BlessTypeActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float jdField_a_of_type_Float = 0.48F;
  private static final int jdField_a_of_type_Int = 101;
  private static final String jdField_a_of_type_JavaLangString = "BlessTyeActivity";
  private static final int jdField_b_of_type_Int = 102;
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BlessManager jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager;
  private VideoEnvironment.ShortVideoDownload jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload;
  public QQViewPager a;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private oge jdField_a_of_type_Oge;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  public BlessTypeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload = new ogc(this);
  }
  
  private void a()
  {
    ((ImmersiveTitleBar2)findViewById(2131297137)).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297196));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131297197));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131297198));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296826);
    findViewById(2131297083).setOnClickListener(this);
    findViewById(2131297202).setOnClickListener(this);
    View localView = findViewById(2131297201);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f()) {
      localView.setOnClickListener(this);
    }
    for (;;)
    {
      Object localObject1 = (ImageView)findViewById(2131297134);
      int i = BlessManager.g();
      int j = (int)(i * 0.48F);
      ((ImageView)localObject1).getLayoutParams().height = j;
      ((ImageView)localObject1).requestLayout();
      if (QLog.isColorLevel()) {
        QLog.d("BlessTyeActivity", 2, "target banner size: " + i + " * " + j);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
      if (localObject2 != null) {}
      try
      {
        FileInputStream localFileInputStream = new FileInputStream((String)localObject2);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int)ImageUtil.a(localFileInputStream, i, j));
        localObject2 = BitmapManager.a((String)localObject2, localOptions);
        if (localObject2 != null) {
          ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BlessTyeActivity", 2, "banner not exist");
          }
        }
      }
      localObject1 = BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0);
      if ((!((SharedPreferences)localObject1).getBoolean("bless_entered" + this.app.f(), false)) && (localView.getVisibility() == 0) && (this.jdField_a_of_type_Boolean))
      {
        ((SharedPreferences)localObject1).edit().putBoolean("bless_entered" + this.app.f(), true).commit();
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297169));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        this.jdField_b_of_type_AndroidViewView = findViewById(2131297203);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = getResources().getDisplayMetrics().heightPixels;
        this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this);
        ((ScrollView)this.jdField_b_of_type_AndroidViewView.getParent().getParent()).setVerticalScrollBarEnabled(false);
      }
      return;
      localView.setVisibility(8);
    }
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
    if (paramIntent != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramIntent);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      paramIntent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramIntent.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramIntent.next();
        this.jdField_b_of_type_JavaUtilArrayList.add(localResultRecord.a);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 8)
    {
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(0);
  }
  
  public boolean a()
  {
    if ((ShortVideoUtils.a()) && (VideoEnvironment.b(3)) && (VideoEnvironment.b(4))) {
      return true;
    }
    if (!VideoEnvironment.d(this.app)) {
      return false;
    }
    if (!jdField_b_of_type_Boolean)
    {
      ShortVideoUtils.a(this.app);
      if ((ShortVideoUtils.a()) && (VideoEnvironment.b(3)) && (VideoEnvironment.b(4))) {
        return true;
      }
      if ((ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS == -5) || (!VideoEnvironment.b(3)) || (!VideoEnvironment.b(4))) {
        jdField_b_of_type_Boolean = true;
      }
    }
    if ((c) && (jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.a(true);
      return false;
    }
    if (!NetworkUtil.h(this))
    {
      QQToast.a(this, 2131367234, 0).a();
      return false;
    }
    VideoEnvironment.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload);
    QQShortVideoHandler localQQShortVideoHandler = (QQShortVideoHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.native.short.video");
    if (localQQShortVideoHandler != null)
    {
      localQQShortVideoHandler.jdField_a_of_type_Boolean = false;
      localQQShortVideoHandler.a(true);
      if (localQQShortVideoHandler.b <= 0) {
        break label232;
      }
      QQToast.a(BaseApplicationImpl.getContext(), "短视频插件下载中，已下载" + localQQShortVideoHandler.b + "%", 0).a();
    }
    for (;;)
    {
      return false;
      label232:
      QQToast.a(BaseApplicationImpl.getContext(), "短视频插件下载中", 0).a();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      a(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Oge.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Oge);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Oge.getCount() - 1, false);
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903115);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
    a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    a(getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Oge = new oge(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Oge);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.jdField_a_of_type_Oge);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(ScreenUtil.a(10.0F));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Oge != null) {
      this.jdField_a_of_type_Oge.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BlessTyeActivity", 2, "onNewIntent");
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        QQToast.a(BaseApplication.getContext(), 2131371373, 0).a();
        return;
      }
      paramView = new Intent(this, BlessSendTextActivity.class);
      paramView.putStringArrayListExtra("uin_list", this.jdField_b_of_type_JavaUtilArrayList);
      paramView.putExtra("param_ptv_enable", this.jdField_a_of_type_Boolean);
      startActivity(paramView);
      overridePendingTransition(2130968592, 2130968593);
      ReportController.b(this.app, "CliOper", "", "", "0X800618D", "0X800618D", 0, 0, "", "", "", "");
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplication.getContext(), "对不起，你的设备不支持视频祝福功能", 0).a();
        return;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        QQToast.a(BaseApplication.getContext(), 2131371373, 0).a();
        return;
      }
      if (this.app.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131368056, 0).a();
        return;
      }
      if (AudioHelper.b(0))
      {
        ChatActivityUtils.b(this);
        return;
      }
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this);
        return;
      }
      if (AudioHelper.a(0))
      {
        DialogUtil.a(this, 230, getString(2131367661), getString(2131367663), new ogb(this), null).show();
        return;
      }
    } while (!a());
    if (!VideoEnvironment.a())
    {
      QQToast.a(this, "对不起，你的设备不支持视频对讲美颜", 0).a();
      return;
    }
    paramView = new Intent(this, BlessPTVActivity.class);
    paramView.putStringArrayListExtra("uin_list", this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    startActivityForResult(paramView, 102);
    overridePendingTransition(2130968592, 2130968593);
    ReportController.b(this.app, "CliOper", "", "", "0X800618E", "0X800618E", 0, 0, "", "", "", "");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
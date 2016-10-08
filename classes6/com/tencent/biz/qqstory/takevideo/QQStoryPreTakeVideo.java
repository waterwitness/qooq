package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.richmedia.CameraPreviewNew;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.FilterVideoSoCallback;
import com.tencent.mobileqq.shortvideo.util.PtvSoDownLoadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import iwu;
import iwv;
import iww;

public class QQStoryPreTakeVideo
  extends BaseActivity
  implements View.OnClickListener, VideoEnvironment.ShortVideoDownload, PtvFilterSoLoad.FilterVideoSoCallback
{
  public static final String a = "QQStoryPreTakeVideo";
  private int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  CameraPreviewNew jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew;
  public CircleProgress a;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public QQStoryPreTakeVideo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = null;
  }
  
  private void c()
  {
    PtvSoDownLoadManager.a(this.app, this, false);
  }
  
  public void a()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryPreTakeVideo", 2, "startNewFlow=====" + this.jdField_a_of_type_Int + "mFilterSoState=" + this.jdField_b_of_type_Int + "hasStartAct=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    getIntent();
    if ((this.jdField_a_of_type_Int > 100) && (this.jdField_b_of_type_Int > 100)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryPreTakeVideo", 2, "startNextActivity soReady=" + bool);
      }
      if (bool) {
        break;
      }
      QQToast.a(BaseApplicationImpl.getContext(), "正在下载插件，已下载" + (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2 + "%", 0).a();
      return;
      bool = false;
    }
    ShortVideoUtils.a(this.app);
    bool = PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryPreTakeVideo", 2, "is load svFilterSo:" + bool);
    }
    setResult(-1);
    super.finish();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == -4) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131367234, 0).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new iwu(this));
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryPreTakeVideo", 2, "onProgress mVideoState=" + this.jdField_a_of_type_Int + "mFilterSoState=" + this.jdField_b_of_type_Int);
      }
    } while ((this.jdField_a_of_type_Int <= 100) || (this.jdField_b_of_type_Int <= 100) || (isFinishing()));
    a();
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    PtvSoDownLoadManager.a(this.app, false, this);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryPreTakeVideo", 2, "VideoSoDownloadProgress mVideoState=" + this.jdField_a_of_type_Int + "mFilterSoState=" + this.jdField_b_of_type_Int);
    }
    if (paramInt == -3) {}
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage("短视频插件下载完成，需要重启QQ生效").setNegativeButton(2131367262, new DialogUtil.DialogOnClickAdapter()).setPositiveButton(2131367263, new iwv(this));
      if (!isFinishing()) {
        localQQCustomDialog.show();
      }
      if (paramInt == -4)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131367234, 0).a();
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQStoryPreTakeVideo", 2, "", localException);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new iww(this));
      } while ((this.jdField_a_of_type_Int <= 100) || (this.jdField_b_of_type_Int <= 100) || (isFinishing()));
      a();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    PtvSoDownLoadManager.a(this);
    PtvSoDownLoadManager.a(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296494);
    if (localView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = new CameraPreviewNew(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setCamera(this.jdField_a_of_type_Boolean);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setId(2131296494);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew, 0, localLayoutParams);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("flow_key_from_guide", false);
    setContentView(2130904452);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296895));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302777));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131301628));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131427407), 100, getResources().getColor(2131427713));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    b();
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\QQStoryPreTakeVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
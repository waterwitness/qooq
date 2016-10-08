package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import piw;

public class PreviewVideoActivity
  extends PeakActivity
  implements ImageViewVideoPlayer.IMPlayerEndListener
{
  private static final String jdField_a_of_type_JavaLangString = PreviewVideoActivity.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  private String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void B_()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
  }
  
  public void C_() {}
  
  public void D_() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.L = true;
    this.M = false;
    super.onCreate(paramBundle);
    setContentView(2130904790);
    try
    {
      if (VideoEnvironment.b("AVCodec", getApplicationContext()) != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 4, "load so failed");
        finish();
      }
      GloableValue.a();
      if (getIntent() == null)
      {
        Toast.makeText(getApplicationContext(), "预览视频无参数", 1).show();
        finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 4, "load so failed");
        finish();
      }
      int i = getIntent().getIntExtra("video_type", -1);
      if (i != 0)
      {
        Toast.makeText(getApplicationContext(), "预览视频参数错误", 1).show();
        QLog.e(jdField_a_of_type_JavaLangString, 4, "init error, mVideoType=" + i);
        finish();
        return;
      }
      this.b = getIntent().getStringExtra("video_source_path");
      if (TextUtils.isEmpty(this.b))
      {
        Toast.makeText(getApplicationContext(), "预览视频参数错误", 1).show();
        QLog.e(jdField_a_of_type_JavaLangString, 4, "init error, mSourcePath=" + this.b);
        finish();
        return;
      }
      paramBundle = (FrameLayout)findViewById(2131304191);
      findViewById(2131297886).setOnClickListener(new piw(this));
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.jdField_a_of_type_Int = getIntent().getBundleExtra("encode_video_params").getInt("sv_total_frame_count");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, 17);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, false, ScreenUtil.a(5.0F));
      paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
    }
    GloableValue.b();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(this.b)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\PreviewVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
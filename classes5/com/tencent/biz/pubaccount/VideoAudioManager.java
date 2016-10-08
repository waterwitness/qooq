package com.tencent.biz.pubaccount;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hrb;

public class VideoAudioManager
{
  public static final String a = "Q.pubaccount.video.VideoAudioManager";
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public VideoAudioManager(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
        return;
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      this.c = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "smoothAdjustVolume() mOriginalMusicVolume = " + this.jdField_b_of_type_Int + ", mOriginalRingVolume = " + this.c + ", mOriginalRingMode = " + this.jdField_a_of_type_Int);
      }
      if (("user_click".equals(paramString)) && (this.jdField_b_of_type_Int == 0))
      {
        VideoVolumeControl.a().a(false, "user_click");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "exception : ");
        return;
        if ((!"user_click".equals(paramString)) && ((this.c == 0) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
        {
          VideoVolumeControl.a().a(true, "smooth init volume 0");
          return;
        }
        if (this.jdField_b_of_type_Int > 0)
        {
          VideoVolumeControl.a().a(false, "smooth init");
          int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
          this.e = ((int)(i * 0.6D));
          if (this.jdField_b_of_type_Int < this.e) {
            this.e = this.jdField_b_of_type_Int;
          }
          this.f = ((int)(2000.0F / this.e));
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "smoothAdjustVolume() systemMaxVolume = " + i + ", mTargetMusicVolume = " + this.e + ", mSmoothAjustIntervalTime = " + this.f);
          }
          if ((this.e > 0) && (this.f > 0))
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, 0, 0);
            this.d = 1;
            this.jdField_a_of_type_AndroidMediaAudioManager.adjustStreamVolume(3, 1, 0);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hrb(this), this.f);
          }
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "doOnDestroy() , mOriginalMusicVolume = " + this.jdField_b_of_type_Int + ", mTargetMusicVolume = " + this.e);
    }
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != this.e) && (i == this.e)) {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoAudioManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
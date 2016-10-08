package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import ivw;
import ivx;
import ivz;
import iwa;
import iwq;
import java.util.concurrent.atomic.AtomicInteger;

public class NewStoryRMViewSTInterface
  extends NewStoryPart
  implements RMViewSTInterface
{
  public static final int a = 2000;
  protected static final String a = "Q.qqstory.record.NewStoryRMViewSTInterface";
  public static final int b = 100;
  protected ImageView a;
  protected ImageViewVideoPlayer a;
  Runnable a;
  public ImageView b;
  private Runnable b;
  int c;
  
  public NewStoryRMViewSTInterface()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = new iwa(this);
  }
  
  public void E_()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "initUI_InitState");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setProgress(0.0F);
  }
  
  public void F_()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "initUI_RecordState mIsVideoMode=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.b();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double <= 0.0D) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.f)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e = true;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    }
  }
  
  public void G_()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "initUI_IdleState mIsVideoMode=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setProgress(0.0F);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setNeedWrite(false);
      float f;
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e))
      {
        f = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        if (!RMVideoStateMgr.jdField_a_of_type_Boolean) {}
        int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e;
        int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, f, i, j);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e = false;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a = null;
      }
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f = (float)(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() * 1000.0F / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(f, -1);
      }
    }
  }
  
  public void a(int paramInt)
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "realDeleteVideoSegment delReason=" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "previewSizeAdjustUI, width = " + paramInt1 + ", height = " + paramInt2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_p_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.q = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c(true);
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setPreviewSize(paramInt1, paramInt2, localRMVideoClipSpec);
    if ((VersionUtils.c()) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidViewView.isEnabled())) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidViewView.setEnabled(true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.record.NewStoryRMViewSTInterface", 2, "previewSizeAdjustUI spec: " + localRMVideoClipSpec.toString());
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "errCode=" + paramInt + " errMsg=" + paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.runOnUiThread(new ivx(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.record.NewStoryRMViewSTInterface", "updateProgress time=" + paramInt + " isRecordOver=" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c)
    {
      this.c = paramInt;
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      localRMVideoStateMgr.jdField_a_of_type_Int += 1;
      if (!paramBoolean) {
        break label103;
      }
      paramInt = this.c - 200;
      if (paramInt <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.a(paramInt / 9800.0F);
      return;
      label103:
      int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(paramInt, i);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.B)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.B = false;
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.B = true;
      break;
      label165:
      paramInt = 0;
    }
  }
  
  public void a(Message paramMessage)
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "onHandleMessage=" + paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (!(paramMessage.obj instanceof MotionEvent));
    ((MotionEvent)paramMessage.obj).recycle();
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "deleteLastVideoSegment deleteNative=" + paramBoolean);
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131301548));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131301604));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131301328));
    if (Build.VERSION.SDK_INT >= 11) {}
    paramNewStoryTakeVideoActivity = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr.a();
    if (paramNewStoryTakeVideoActivity != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramNewStoryTakeVideoActivity);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
  }
  
  public int c_()
  {
    return 0;
  }
  
  public void d()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "initUI_previewState");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.h();
    int k = this.c;
    int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    int i = j;
    if (j <= 0) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.d, k, i, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a = new BitmapDrawable(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources(), (Bitmap)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    this.jdField_b_of_type_JavaLangRunnable = new ivw(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
  }
  
  public void e()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "initRecordEngineOK");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.o = true;
    boolean bool1 = CameraCompatibleList.a(CameraCompatibleList.q);
    boolean bool2 = CameraCompatibleList.e(CameraCompatibleList.A);
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.b) && ((bool1) || (bool2))) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public void f()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "addOneSegment_RecordState");
  }
  
  public void g()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "recordVideoFinish");
    QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new iwq(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.h();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.b(2131370344);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.h();
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
  }
  
  public void h()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "onViewDestroy");
  }
  
  public void i()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "enterViewVideoMode");
  }
  
  public void j()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "exitViewVideoMode");
  }
  
  public void k()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "getFirstFrame");
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setStartOffset(300L);
      localAlphaAnimation.setDuration(300L);
      localAlphaAnimation.setAnimationListener(new ivz(this));
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    SLog.a("face", "getFirstFrame gl_root.getVisibility()=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getVisibility());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.b = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.a();
    long l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_Long;
    if (l > 0L) {
      StoryReportor.b("take_video", "video_initial", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - l), String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.x) });
    }
  }
  
  public void l()
  {
    SLog.c("Q.qqstory.record.NewStoryRMViewSTInterface", "finishUI");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.finish();
  }
  
  public void m()
  {
    SLog.b("Q.qqstory.record.NewStoryRMViewSTInterface", "notifyAvcodecOK");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryRMViewSTInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
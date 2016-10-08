package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.bitmap.BitmapAdjustJobSegment;
import com.tencent.biz.qqstory.takevideo.bitmap.BlurJobSegment;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import ivh;

public class NewStoryImagePlayerModule
  extends NewStoryPart
  implements ImageViewVideoPlayer.IMPlayerEndListener, IEventReceiver
{
  protected static final String a = "Q.qqstory.record.NewStoryImagePlayerListener";
  public ImageView a;
  public ImageViewVideoPlayer a;
  public boolean a;
  
  public NewStoryImagePlayerModule()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void B_()
  {
    SLog.b("Q.qqstory.record.NewStoryImagePlayerListener", "onPlayerEnd");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.l();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(true);
  }
  
  public void C_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onPlayerRecyle() playBgMusic----------1");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.q();
  }
  
  public void D_()
  {
    SLog.b("Q.qqstory.record.NewStoryImagePlayerListener", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_a_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_a_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction(2)).map(new BitmapAdjustJobSegment(0.2F, false)).map(new BlurJobSegment(10)).map(new UIThreadOffFunction(this)).subscribe(new ivh(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a;
    float f = ((RMVideoClipSpec)localObject).f * 1.0F / ((RMVideoClipSpec)localObject).e;
    SLog.c("Q.qqstory.record.NewStoryImagePlayerListener", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + ((RMVideoClipSpec)localObject).f + "dst_width=" + ((RMVideoClipSpec)localObject).e);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, ScreenUtil.a(5.0F));
    localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.f == 3)
    {
      SLog.b("Q.qqstory.record.NewStoryImagePlayerListener", "pausePreview");
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.s();
      return;
    }
    SLog.d("Q.qqstory.record.NewStoryImagePlayerListener", "pausePreview but the player has not started : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.f);
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)paramNewStoryTakeVideoActivity.findViewById(2131301548));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramNewStoryTakeVideoActivity.findViewById(2131301604));
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer == null) {
      throw new IllegalStateException("can not find view by id 2131301548");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      throw new IllegalStateException("can not find view by id 2131301604");
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    a(TakeVideoUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources()), TakeVideoUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources()));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.f == 4)
    {
      SLog.b("Q.qqstory.record.NewStoryImagePlayerListener", "restartPreview");
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.t();
      return;
    }
    SLog.d("Q.qqstory.record.NewStoryImagePlayerListener", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.f);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.isValidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryImagePlayerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
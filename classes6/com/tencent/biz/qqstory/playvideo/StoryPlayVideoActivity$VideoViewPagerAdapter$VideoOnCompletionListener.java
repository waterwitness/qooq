package com.tencent.biz.qqstory.playvideo;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ipm;
import java.util.List;

public class StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnCompletionListener
  implements MediaPlayer.OnCompletionListener
{
  public int a;
  
  public StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnCompletionListener(StoryPlayVideoActivity.VideoViewPagerAdapter paramVideoViewPagerAdapter, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "video onCompletion time:" + System.currentTimeMillis() + ",position:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.K) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.h(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.K);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.O == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.j(this.jdField_a_of_type_Int);
      paramMediaPlayer.start();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.O == 2) && (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() == 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.j(this.jdField_a_of_type_Int);
      paramMediaPlayer.start();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$SwitchVideoListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.K + 1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.runOnUiThread(new ipm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnCompletionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
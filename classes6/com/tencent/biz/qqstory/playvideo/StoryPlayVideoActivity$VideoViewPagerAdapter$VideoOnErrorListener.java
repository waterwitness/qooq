package com.tencent.biz.qqstory.playvideo;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import ipn;

public class StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnErrorListener
  implements MediaPlayer.OnErrorListener
{
  public int a;
  public StoryVideoItem a;
  public StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder a;
  
  public StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnErrorListener(StoryPlayVideoActivity.VideoViewPagerAdapter paramVideoViewPagerAdapter, StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter$VideoViewHolder = paramVideoViewHolder;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter$VideoViewHolder.a.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter$VideoViewHolder.a.setOnRetryClickListener(new ipn(this));
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "play error: what =" + paramInt1 + " extra = " + paramInt2 + ",VideoUrl = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoUrl);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.app, "dc00899", "grp_story_engineer", "", "play_video", "play_done", 0, 0, "1", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$VideoViewPagerAdapter$VideoOnErrorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
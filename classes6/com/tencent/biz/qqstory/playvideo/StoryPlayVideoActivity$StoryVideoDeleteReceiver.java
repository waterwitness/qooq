package com.tencent.biz.qqstory.playvideo;

import android.util.SparseArray;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryPlayVideoActivity$StoryVideoDeleteReceiver
  extends QQUIEventReceiver
{
  public StoryPlayVideoActivity$StoryVideoDeleteReceiver(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    super(paramStoryPlayVideoActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(StoryPlayVideoActivity paramStoryPlayVideoActivity, DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    paramStoryPlayVideoActivity.e();
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      boolean bool = paramStoryPlayVideoActivity.a.a(paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString);
      paramStoryPlayVideoActivity.a.notifyDataSetChanged();
      if (bool) {
        paramStoryPlayVideoActivity.a();
      }
    }
    if ((!paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean) && (paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "删除失败：" + paramDeleteStoryVideoEvent.a());
      }
      QQToast.a(paramStoryPlayVideoActivity, 1, "删除失败，请稍后重试", 0).a();
      paramStoryPlayVideoActivity = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(paramStoryPlayVideoActivity.a).get(paramStoryPlayVideoActivity.K);
      if (paramStoryPlayVideoActivity != null)
      {
        paramStoryPlayVideoActivity = paramStoryPlayVideoActivity.a;
        if (paramStoryPlayVideoActivity != null) {
          paramStoryPlayVideoActivity.start();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$StoryVideoDeleteReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
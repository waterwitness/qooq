package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TakeVideoButtonSubPart$exitRecodeModeRunnable
  implements Runnable
{
  private final NewStoryTakeVideoActivity jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity;
  
  public TakeVideoButtonSubPart$exitRecodeModeRunnable(TakeVideoButtonSubPart paramTakeVideoButtonSubPart, NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity = paramNewStoryTakeVideoActivity;
  }
  
  public void run()
  {
    SLog.b("TakeVideoButtonSubPart", "exitRecodeModeRunnable run");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.d();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.j();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\TakeVideoButtonSubPart$exitRecodeModeRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
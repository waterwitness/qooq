package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryPlayVideoActivity$ReportVideoReceiver
  extends QQUIEventReceiver
{
  public StoryPlayVideoActivity$ReportVideoReceiver(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    super(paramStoryPlayVideoActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(StoryPlayVideoActivity paramStoryPlayVideoActivity, ReportEvilHandler.ReportEvent paramReportEvent)
  {
    if (!paramStoryPlayVideoActivity.isFinishing())
    {
      if (paramReportEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        QQToast.a(paramStoryPlayVideoActivity.getApplicationContext(), 2, "举报成功，客服人员会尽快处理", 0).a();
        StoryReportor.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramReportEvent.jdField_a_of_type_Int), "", "", paramReportEvent.jdField_a_of_type_JavaLangString });
      }
    }
    else {
      return;
    }
    QQToast.a(paramStoryPlayVideoActivity.getApplicationContext(), 1, "举报失败，请稍后重试", 0).a();
    StoryReportor.a("play_video", "report_fail", 0, 0, new String[] { "", "", "", paramReportEvent.jdField_a_of_type_JavaLangString });
  }
  
  public Class acceptEventClass()
  {
    return ReportEvilHandler.ReportEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$ReportVideoReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
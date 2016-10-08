package com.tencent.biz.qqstory.takevideo;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantDownloadEvent;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewStorySelectPendant$PendantDownloadReceiver
  extends QQUIEventReceiver
{
  public NewStorySelectPendant$PendantDownloadReceiver(NewStorySelectPendant paramNewStorySelectPendant)
  {
    super(paramNewStorySelectPendant);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NewStorySelectPendant paramNewStorySelectPendant, NewStoryPendantDownloadEvent paramNewStoryPendantDownloadEvent)
  {
    SLog.a(this.TAG, "onEvent : %s", new Object[] { paramNewStoryPendantDownloadEvent });
    paramNewStoryPendantDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a();
    String str = paramNewStoryPendantDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a();
    if (!TextUtils.isEmpty(str))
    {
      NewStoryPendantItem localNewStoryPendantItem = NewStorySelectPendant.a(paramNewStorySelectPendant);
      if ((localNewStoryPendantItem != null) && (TextUtils.equals(localNewStoryPendantItem.a, paramNewStoryPendantDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a)))
      {
        NewStorySelectPendant.a(paramNewStorySelectPendant).setVideoFilter(str);
        NewStorySelectPendant.b(paramNewStorySelectPendant, paramNewStoryPendantDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem);
      }
    }
    if (paramNewStoryPendantDownloadEvent.jdField_a_of_type_Int != 0)
    {
      StoryReportor.a("video_shoot", "fail_effect", 0, 0, new String[] { paramNewStoryPendantDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a });
      QQToast.a(paramNewStorySelectPendant.a, "网络异常，特效下载失败", 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return NewStoryPendantDownloadEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStorySelectPendant$PendantDownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
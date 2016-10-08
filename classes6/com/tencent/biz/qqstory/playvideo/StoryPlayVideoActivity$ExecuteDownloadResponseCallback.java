package com.tencent.biz.qqstory.playvideo;

import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class StoryPlayVideoActivity$ExecuteDownloadResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public long a;
  public StoryVideoItem a;
  public String a;
  public WeakReference a;
  
  public StoryPlayVideoActivity$ExecuteDownloadResponseCallback(StoryDownloadView paramStoryDownloadView, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramStoryDownloadView);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    StoryDownloadView localStoryDownloadView = (StoryDownloadView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localStoryDownloadView != null)
    {
      localStoryDownloadView.setWhiteMode(true);
      localStoryDownloadView.setVisibility(0);
      localStoryDownloadView.a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (StoryDownloadView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      QQToast.a(BaseApplication.getContext(), 2, "已保存到本地相册", 0).a();
      paramString.a(true);
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    long l3 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration;
    StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    StoryReportor.a("play_video", "down_watermark_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(l3) });
    StoryReportor.a("play_video", "down_watermark", 0, 0, new String[0]);
    FileUtils.a(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    paramString = (StoryDownloadView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, "保存失败，请稍候重试", 0).a();
      paramString.b(true);
    }
    StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    StoryReportor.a("play_video", "down_watermark", 0, 1, new String[0]);
  }
  
  public void c(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$ExecuteDownloadResponseCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
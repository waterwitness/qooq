package com.tencent.biz.qqstory.base.videoupload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class ShortVideoUploadSegment
  extends JobSegment
{
  public static final int a = 16384;
  public static final String a = "Q.qqstory.publish:StoryVideoUploadSegment";
  public static final int b = 131072;
  public static final int c = 131072;
  public static final int d = 2;
  public String b;
  public String c;
  public int e;
  
  public ShortVideoUploadSegment(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramInt;
  }
  
  private int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      return 131072;
    }
    return 16384;
  }
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    SLog.c("Q.qqstory.publish:StoryVideoUploadSegment", "runSegment begin");
    paramErrorMessage = (VideoServerInfoManager)SuperManager.a(4);
    byte[] arrayOfByte = paramErrorMessage.a();
    paramJobContext = "";
    if (arrayOfByte != null) {
      paramJobContext = paramErrorMessage.b();
    }
    SLog.c("Q.qqstory.publish:StoryVideoUploadSegment", "runSegment get ip");
    String str1;
    String str2;
    int i;
    if ((arrayOfByte != null) && (!TextUtils.isEmpty(paramJobContext)))
    {
      str1 = HexUtil.a(FileUtils.b(this.b));
      str2 = QQStoryContext.a().a();
      if ((this.e != 0) && (!paramJobContext.equals(this.c)))
      {
        this.e = 0;
        SLog.d("Q.qqstory.publish:StoryVideoUploadSegment", "ip change from %s to %s so reset offset=%d", new Object[] { this.c, paramJobContext, Integer.valueOf(this.e) });
      }
      i = 1;
      if (!NetworkUtils.a(QQStoryContext.a().a()))
      {
        paramJobContext = new VideoUploadHelper.UploadResult();
        paramJobContext.d = this.c;
        paramJobContext.jdField_a_of_type_Int = this.e;
        paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(880001, "no network");
        label179:
        super.notifyResult(paramJobContext);
        StoryReportor.b("publish_story", "publish_video", 0, paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(paramJobContext.jdField_a_of_type_Long), String.valueOf(paramJobContext.b), StoryReportor.a(BaseApplication.getContext()) });
        if (!paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
          break label409;
        }
        MonitorReport.a(2444474);
      }
    }
    for (;;)
    {
      SLog.c("Q.qqstory.publish:StoryVideoUploadSegment", "runSegment end");
      return;
      paramErrorMessage = new VideoUploadHelper().a(str2, this.b, this.e, str1, a(), paramJobContext, arrayOfByte);
      if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        SLog.b("Q.qqstory.publish:StoryVideoUploadSegment", "upload file success with result:%s", paramErrorMessage);
        paramJobContext = paramErrorMessage;
        break label179;
      }
      if (i < 2)
      {
        SLog.d("Q.qqstory.publish:StoryVideoUploadSegment", "had upload %d, but fail", new Object[] { Integer.valueOf(paramErrorMessage.jdField_a_of_type_Int - this.e) });
        SLog.d("Q.qqstory.publish:StoryVideoUploadSegment", "retry upload file after 500ms after fail with result:%s", new Object[] { paramErrorMessage });
        this.e = paramErrorMessage.jdField_a_of_type_Int;
        try
        {
          Thread.sleep(500L);
          i += 1;
        }
        catch (InterruptedException paramErrorMessage)
        {
          for (;;)
          {
            SLog.b("Q.qqstory.publish:StoryVideoUploadSegment", "sleep", paramErrorMessage);
          }
        }
      }
      SLog.d("Q.qqstory.publish:StoryVideoUploadSegment", "upload file fail with result:%s", new Object[] { paramErrorMessage });
      paramJobContext = paramErrorMessage;
      break label179;
      label409:
      MonitorReport.a(2444473);
      continue;
      paramJobContext = new VideoUploadHelper.UploadResult();
      paramJobContext.d = this.c;
      paramJobContext.jdField_a_of_type_Int = this.e;
      paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940009, "get auth key fail");
      SLog.b("Q.qqstory.publish:StoryVideoUploadSegment", "upload file get ip fail:%s", paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      super.notifyResult(paramJobContext);
      StoryReportor.b("publish_story", "publish_video", 0, paramJobContext.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(paramJobContext.jdField_a_of_type_Long), String.valueOf(paramJobContext.b), StoryReportor.a(BaseApplication.getContext()) });
      MonitorReport.a(2444473);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\ShortVideoUploadSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.qqstory.base.preload.storylist;

import android.os.Handler;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ihv;

public class DelayUpdateDownloadQueueJob
{
  public static final int a = 1;
  protected static final String a = "Q.qqstory.download.preload.DelayUpdateDownloadQueueJob";
  public static final int b = 4000;
  public static final int c = 8000;
  public Handler a;
  public PreloadVideoSource a;
  public ihv a;
  public boolean a;
  
  public DelayUpdateDownloadQueueJob(PreloadVideoSource paramPreloadVideoSource)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource = paramPreloadVideoSource;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b());
  }
  
  public void a()
  {
    int i = FileUtils.a(QQStoryConstant.p);
    if (i > 400) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        SLog.d("Q.qqstory.download.preload.DelayUpdateDownloadQueueJob", "video source is load too much , count = " + i);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((paramInt == 1) && (this.jdField_a_of_type_Ihv != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ihv);
        this.jdField_a_of_type_Ihv = null;
      }
    } while (this.jdField_a_of_type_Ihv != null);
    this.jdField_a_of_type_Ihv = new ihv(this, null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Ihv, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\DelayUpdateDownloadQueueJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
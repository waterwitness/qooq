package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;

public class GenerateVideoSegment$CallBack
  extends ExecuteBinResponseCallback
{
  public GenerateVideoSegment$CallBack(GenerateVideoSegment paramGenerateVideoSegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    GenerateVideoSegment.a(this.a);
    GenerateVideoSegment.a(this.a, new ErrorMessage());
    SLog.a("Q.qqstory.publish:GenerateVideoSegment", "combine music success take time:%d", Long.valueOf(System.currentTimeMillis() - GenerateVideoSegment.a(this.a)));
    FileUtils.a(this.a.b);
  }
  
  public void b(String paramString)
  {
    SLog.d("Q.qqstory.publish:GenerateVideoSegment", "combine audio fail %s", new Object[] { paramString });
    GenerateVideoSegment.b(this.a, new ErrorMessage(941000, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\meta\GenerateVideoSegment$CallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
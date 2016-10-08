package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FFmpegCommandAlreadyRunningException
  extends Exception
{
  public FFmpegCommandAlreadyRunningException(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\ffmpeg\FFmpegCommandAlreadyRunningException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
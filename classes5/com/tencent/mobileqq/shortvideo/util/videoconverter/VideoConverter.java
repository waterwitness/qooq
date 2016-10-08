package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import usy;

public class VideoConverter
{
  VideoConverter.VideoConverterImpl a;
  
  public VideoConverter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new usy();
    }
  }
  
  public VideoConverter(VideoConverter.VideoConverterImpl paramVideoConverterImpl)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = paramVideoConverterImpl;
    }
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, paramProcessor, paramBoolean);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\videoconverter\VideoConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
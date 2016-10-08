package com.tencent.mobileqq.emoticonview;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class VoiceGifFactory
{
  public static final String a = "VoiceGifFactory";
  
  public VoiceGifFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AbstractGifImage a(File paramFile, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (NativeGifFactory.isUseNewGif()) {
        return new VoiceGifImageV2(paramFile, paramInt, paramBoolean);
      }
      paramFile = new VoiceGifImage(paramFile, paramInt, paramBoolean);
      return paramFile;
    }
    catch (IOException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceGifFactory", 2, "getVoiceGifObject exception. msg:" + paramFile.getMessage());
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\VoiceGifFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
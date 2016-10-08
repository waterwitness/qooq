package com.dataline.util.file;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageInfo$InvalidImageException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public ImageInfo$InvalidImageException(ImageInfo paramImageInfo, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\file\ImageInfo$InvalidImageException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
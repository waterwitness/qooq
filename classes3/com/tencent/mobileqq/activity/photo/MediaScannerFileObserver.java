package com.tencent.mobileqq.activity.photo;

import android.os.FileObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MediaScannerFileObserver
  extends FileObserver
{
  private MediaScanner jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner;
  private final String jdField_a_of_type_JavaLangString;
  private String b;
  
  public MediaScannerFileObserver(MediaScanner paramMediaScanner, String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "MediaScannerFileObserver";
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner = paramMediaScanner;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner.a(paramInt, this.b, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\MediaScannerFileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
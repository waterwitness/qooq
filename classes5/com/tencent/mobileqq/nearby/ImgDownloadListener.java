package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import the;
import thf;

public class ImgDownloadListener
  implements URLDrawable.DownloadListener
{
  public static final String a;
  public static final String b = "actTopListPicDownload";
  public static final String c = "actNearbyFeedAdPicDownload";
  public static final String d = "actInterestTagPicDownload";
  public static final String e = "actProfileCardHobbyPicDownload";
  public static final String f = "actProfileCardFreshNewsEntryPicDownload";
  public static final String g = "actProfileCardQzoneEntryPicDownload";
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private String h = "freshnews.small_pic_download";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ImgDownloadListener.class.getSimpleName();
  }
  
  public ImgDownloadListener(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ImgDownloadListener(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.h = paramString;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    ThreadManager.a(new thf(this, paramInt), null, true);
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ThreadManager.a(new the(this, paramLong), null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ImgDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
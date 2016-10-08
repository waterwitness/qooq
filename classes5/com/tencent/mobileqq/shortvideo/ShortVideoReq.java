package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;

public class ShortVideoReq
  implements Comparable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int k = 200;
  public static final int l = 201;
  public static final int m = 202;
  private static final int n = 200;
  public MessageForShortVideo a;
  public ShortVideoDownloadInfo a;
  public ShortVideoForwardInfo a;
  public ShortVideoUploadInfo a;
  public UiCallBack a;
  public String a;
  public String b;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public ShortVideoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = -1;
    this.j = 201;
    this.jdField_a_of_type_JavaLangString = PicReq.a();
  }
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    if (this.j < paramShortVideoReq.j) {
      return -1;
    }
    if (this.j > paramShortVideoReq.j) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    int i2 = 6;
    if (paramShortVideoDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramShortVideoDownloadInfo.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo = paramShortVideoDownloadInfo;
    int i1;
    if (paramShortVideoDownloadInfo.g == 1002) {
      i1 = 7;
    }
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.b, 0, i1);
      return;
      if (paramShortVideoDownloadInfo.g == 1006)
      {
        i1 = 18;
      }
      else if (paramShortVideoDownloadInfo.g == 1004)
      {
        i1 = 16;
      }
      else
      {
        i1 = i2;
        if (paramShortVideoDownloadInfo.g != 1001) {
          if (paramShortVideoDownloadInfo.g == 1005)
          {
            i1 = 17;
          }
          else
          {
            i1 = i2;
            if (paramShortVideoDownloadInfo.g == 1003) {
              i1 = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramShortVideoForwardInfo.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo = paramShortVideoForwardInfo;
    this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo.b, 2, 20);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i1 = 6;
    if (paramShortVideoUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramShortVideoUploadInfo.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
    if (paramShortVideoUploadInfo.b == 0) {}
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.b, 1, i1);
      return;
      if (paramShortVideoUploadInfo.b == 3000) {
        i1 = 17;
      } else if (paramShortVideoUploadInfo.b == 1) {
        i1 = 9;
      }
    }
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
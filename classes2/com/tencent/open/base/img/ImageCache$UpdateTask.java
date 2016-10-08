package com.tencent.open.base.img;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected ImageDownCallback a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, ImageDownCallback paramImageDownCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback = paramImageDownCallback;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UpdateTask)) {
      return false;
    }
    return this.jdField_a_of_type_JavaLangString.equals(((UpdateTask)paramObject).jdField_a_of_type_JavaLangString);
  }
  
  public void run()
  {
    ImageInfo localImageInfo;
    long l;
    do
    {
      do
      {
        try
        {
          if (((!Common.a()) || (!APNUtil.b(CommonDataAdapter.a().a()))) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)) {
            this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
          }
          Object localObject1 = Common.f() + ImageCache.jdField_b_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + FileUtils.a(this.jdField_c_of_type_JavaLangString);
          LogUtility.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + FileUtils.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null))
          {
            this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
            this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback = null;
          }
          localImageInfo = ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a(this.jdField_a_of_type_JavaLangString);
          if (localImageInfo == null)
          {
            LogUtility.a(ImageCache.jdField_a_of_type_JavaLangString, "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
            localObject1 = new ImageInfo();
            ((ImageInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            ((ImageInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
            ((ImageInfo)localObject1).jdField_c_of_type_Long = 0L;
            ((ImageInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          for (;;)
          {
            if (!ImageDownloader.a((ImageInfo)localObject1)) {
              break label605;
            }
            LogUtility.d(ImageCache.jdField_a_of_type_JavaLangString, "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
            ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a((ImageInfo)localObject1);
            if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback == null) {
              return;
            }
            this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Common.f() + ImageCache.jdField_b_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + FileUtils.a(((ImageInfo)localObject1).jdField_b_of_type_JavaLangString));
            return;
            localImageInfo.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback == null) {
              break;
            }
            LogUtility.a(ImageCache.jdField_a_of_type_JavaLangString, "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
            localImageInfo.jdField_c_of_type_Long = 0L;
            localObject1 = localImageInfo;
          }
          l = System.currentTimeMillis();
        }
        catch (Exception localException)
        {
          LogUtility.b(ImageCache.jdField_a_of_type_JavaLangString, "Download img warning", localException);
          return;
        }
        localObject2 = localImageInfo;
      } while (l <= localImageInfo.jdField_b_of_type_Long);
      Object localObject2 = localImageInfo;
    } while (l >= localImageInfo.jdField_a_of_type_Long + localImageInfo.jdField_b_of_type_Long);
    LogUtility.a(ImageCache.jdField_a_of_type_JavaLangString, "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localImageInfo.jdField_a_of_type_Long + localImageInfo.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
    return;
    label605:
    LogUtility.d(ImageCache.jdField_a_of_type_JavaLangString, "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null) {
      this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\img\ImageCache$UpdateTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
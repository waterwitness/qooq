package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class OlympicActConfig$CityImage
  implements Serializable
{
  public int companyId;
  public String md5;
  public long picId;
  public String starMd5;
  public String starUrl;
  public String url;
  
  public OlympicActConfig$CityImage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("companyId=").append(this.companyId);
    localStringBuilder.append(", url=").append(this.url);
    localStringBuilder.append(", picId=").append(this.picId);
    localStringBuilder.append(", md5=").append(this.md5);
    localStringBuilder.append(", starUrl=").append(this.starUrl);
    localStringBuilder.append(", starMd5=").append(this.starMd5);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicActConfig$CityImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
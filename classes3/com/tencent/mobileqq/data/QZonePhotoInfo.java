package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;

public class QZonePhotoInfo
  extends ProfilePhotoWall
{
  public String photoId;
  public Map photoUrls;
  
  public QZonePhotoInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = 1;
  }
  
  private String getOther(int paramInt)
  {
    Object localObject = null;
    int i = 1;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.photoUrls.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return (String)localObject;
  }
  
  public String getOriginUrl()
  {
    Object localObject = null;
    if (this.photoUrls != null)
    {
      String str = (String)this.photoUrls.get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getOther(1);
      }
    }
    return (String)localObject;
  }
  
  public String getThumbUrl(int paramInt)
  {
    Object localObject = null;
    if (this.photoUrls != null) {
      if (paramInt > 100) {
        break label51;
      }
    }
    label51:
    for (paramInt = 3;; paramInt = 2)
    {
      String str = (String)this.photoUrls.get(Integer.valueOf(paramInt));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getOther(paramInt);
      }
      return (String)localObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\QZonePhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
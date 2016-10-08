package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ProfilePhotoWall
{
  public static final int TYPE_NOW_PHOTO = 2;
  public static final int TYPE_QZONE_PHOTO_WALL = 1;
  public long time;
  public int type;
  public String uin;
  
  public ProfilePhotoWall()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract String getOriginUrl();
  
  public abstract String getThumbUrl(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ProfilePhotoWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
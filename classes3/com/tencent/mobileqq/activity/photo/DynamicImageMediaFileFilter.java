package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DynamicImageMediaFileFilter
  extends MediaFileFilter
{
  private MediaFileFilter d;
  
  public DynamicImageMediaFileFilter(MediaFileFilter paramMediaFileFilter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = paramMediaFileFilter;
  }
  
  public boolean a()
  {
    return this.d.a();
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    if ((arrayOfString != null) && ("image".equals(arrayOfString[0])) && ("gif".equals(arrayOfString[1]))) {
      return true;
    }
    return this.d.a(paramString);
  }
  
  public boolean b()
  {
    return this.d.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\DynamicImageMediaFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
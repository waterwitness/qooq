package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BasicLocation
{
  public final int a;
  public final int b;
  
  public BasicLocation(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (BasicLocation)paramObject;
      if (this.a != ((BasicLocation)paramObject).a) {
        return false;
      }
    } while (this.b == ((BasicLocation)paramObject).b);
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  public String toString()
  {
    return "GpsMsg{mLatitude=" + this.a + ", mLongitude=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\lbs\BasicLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
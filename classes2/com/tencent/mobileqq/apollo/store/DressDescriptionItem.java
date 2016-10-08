package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DressDescriptionItem
  implements Comparable
{
  public static final int b = 0;
  public static final int c = 1;
  public int a;
  public String a;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public DressDescriptionItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (DressDescriptionItem)paramObject;
    if (this.f < ((DressDescriptionItem)paramObject).f) {
      return 1;
    }
    if (this.f > ((DressDescriptionItem)paramObject).f) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\DressDescriptionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.av.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArrayUtils
{
  public ArrayUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt, 0);
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        break label38;
      }
      paramInt2 = i;
      if (paramInt1 == paramArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject, 0);
  }
  
  public static int a(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i;
      if (paramObject == null)
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramArrayOfObject[i] == null) {
            break;
          }
          i += 1;
        }
      }
      if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramObject.equals(paramArrayOfObject[i])) {
            break;
          }
          i += 1;
        }
      }
      label82:
      return -1;
    }
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt) != -1;
  }
  
  public static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject) != -1;
  }
  
  public static int b(Object[] paramArrayOfObject, Object paramObject)
  {
    return b(paramArrayOfObject, paramObject, Integer.MAX_VALUE);
  }
  
  public static int b(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null) {}
    while (paramInt < 0) {
      return -1;
    }
    if (paramInt >= paramArrayOfObject.length) {
      paramInt = paramArrayOfObject.length - 1;
    }
    for (;;)
    {
      if (paramObject == null)
      {
        while (paramInt >= 0)
        {
          if (paramArrayOfObject[paramInt] == null) {
            return paramInt;
          }
          paramInt -= 1;
        }
        break;
      }
      if (!paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
        break;
      }
      while (paramInt >= 0)
      {
        if (paramObject.equals(paramArrayOfObject[paramInt])) {
          return paramInt;
        }
        paramInt -= 1;
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
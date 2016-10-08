package com.facebook.common.util;

import javax.annotation.Nullable;

public class HashCodeUtil
{
  private static final int X = 31;
  
  public static int hashCode(int paramInt)
  {
    return paramInt + 31;
  }
  
  public static int hashCode(int paramInt1, int paramInt2)
  {
    return (paramInt1 + 31) * 31 + paramInt2;
  }
  
  public static int hashCode(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((paramInt1 + 31) * 31 + paramInt2) * 31 + paramInt3;
  }
  
  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (((paramInt1 + 31) * 31 + paramInt2) * 31 + paramInt3) * 31 + paramInt4;
  }
  
  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return ((((paramInt1 + 31) * 31 + paramInt2) * 31 + paramInt3) * 31 + paramInt4) * 31 + paramInt5;
  }
  
  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return (((((paramInt1 + 31) * 31 + paramInt2) * 31 + paramInt3) * 31 + paramInt4) * 31 + paramInt5) * 31 + paramInt6;
  }
  
  public static int hashCode(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return hashCode(i);
    }
  }
  
  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    int j = 0;
    int i;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null) {
        break label26;
      }
    }
    for (;;)
    {
      return hashCode(i, j);
      i = paramObject1.hashCode();
      break;
      label26:
      j = paramObject2.hashCode();
    }
  }
  
  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    int k = 0;
    int i;
    int j;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null) {
        break label37;
      }
      j = 0;
      label16:
      if (paramObject3 != null) {
        break label46;
      }
    }
    for (;;)
    {
      return hashCode(i, j, k);
      i = paramObject1.hashCode();
      break;
      label37:
      j = paramObject2.hashCode();
      break label16;
      label46:
      k = paramObject3.hashCode();
    }
  }
  
  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    int m = 0;
    int i;
    int j;
    label17:
    int k;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null) {
        break label49;
      }
      j = 0;
      if (paramObject3 != null) {
        break label58;
      }
      k = 0;
      label24:
      if (paramObject4 != null) {
        break label67;
      }
    }
    for (;;)
    {
      return hashCode(i, j, k, m);
      i = paramObject1.hashCode();
      break;
      label49:
      j = paramObject2.hashCode();
      break label17;
      label58:
      k = paramObject3.hashCode();
      break label24;
      label67:
      m = paramObject4.hashCode();
    }
  }
  
  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5)
  {
    int n = 0;
    int i;
    int j;
    label17:
    int k;
    label24:
    int m;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null) {
        break label59;
      }
      j = 0;
      if (paramObject3 != null) {
        break label68;
      }
      k = 0;
      if (paramObject4 != null) {
        break label77;
      }
      m = 0;
      label31:
      if (paramObject5 != null) {
        break label86;
      }
    }
    for (;;)
    {
      return hashCode(i, j, k, m, n);
      i = paramObject1.hashCode();
      break;
      label59:
      j = paramObject2.hashCode();
      break label17;
      label68:
      k = paramObject3.hashCode();
      break label24;
      label77:
      m = paramObject4.hashCode();
      break label31;
      label86:
      n = paramObject5.hashCode();
    }
  }
  
  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6)
  {
    int i1 = 0;
    int i;
    int j;
    label17:
    int k;
    label24:
    int m;
    label31:
    int n;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null) {
        break label69;
      }
      j = 0;
      if (paramObject3 != null) {
        break label78;
      }
      k = 0;
      if (paramObject4 != null) {
        break label87;
      }
      m = 0;
      if (paramObject5 != null) {
        break label96;
      }
      n = 0;
      label39:
      if (paramObject6 != null) {
        break label106;
      }
    }
    for (;;)
    {
      return hashCode(i, j, k, m, n, i1);
      i = paramObject1.hashCode();
      break;
      label69:
      j = paramObject2.hashCode();
      break label17;
      label78:
      k = paramObject3.hashCode();
      break label24;
      label87:
      m = paramObject4.hashCode();
      break label31;
      label96:
      n = paramObject5.hashCode();
      break label39;
      label106:
      i1 = paramObject6.hashCode();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\util\HashCodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
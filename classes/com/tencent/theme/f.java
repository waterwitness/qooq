package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.LongSparseArray;

@TargetApi(16)
class f
  extends d
{
  public f(SkinEngine paramSkinEngine, Resources paramResources, LongSparseArray paramLongSparseArray, Class paramClass, int paramInt)
  {
    super(paramSkinEngine, paramResources, paramLongSparseArray, paramClass, paramInt);
  }
  
  public Object get(long paramLong)
  {
    Object localObject = (Integer)this.a.get(paramLong);
    if (localObject == null) {
      return this.b.get(paramLong);
    }
    localObject = this.c.b(((Integer)localObject).intValue());
    if (localObject != null) {
      return ((SkinnableColorStateList)localObject).a;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\theme\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
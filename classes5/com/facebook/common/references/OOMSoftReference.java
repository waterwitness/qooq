package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OOMSoftReference<T>
{
  SoftReference<T> softRef1 = null;
  SoftReference<T> softRef2 = null;
  SoftReference<T> softRef3 = null;
  
  public void clear()
  {
    if (this.softRef1 != null)
    {
      this.softRef1.clear();
      this.softRef1 = null;
    }
    if (this.softRef2 != null)
    {
      this.softRef2.clear();
      this.softRef2 = null;
    }
    if (this.softRef3 != null)
    {
      this.softRef3.clear();
      this.softRef3 = null;
    }
  }
  
  @Nullable
  public T get()
  {
    if (this.softRef1 == null) {
      return null;
    }
    return (T)this.softRef1.get();
  }
  
  public void set(@Nonnull T paramT)
  {
    this.softRef1 = new SoftReference(paramT);
    this.softRef2 = new SoftReference(paramT);
    this.softRef3 = new SoftReference(paramT);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\references\OOMSoftReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
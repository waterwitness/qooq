package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;

public class ResizeOptions
{
  public final int height;
  public final int width;
  
  public ResizeOptions(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.width = paramInt1;
      this.height = paramInt2;
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ResizeOptions)) {
        return false;
      }
      paramObject = (ResizeOptions)paramObject;
    } while ((this.width == ((ResizeOptions)paramObject).width) && (this.height == ((ResizeOptions)paramObject).height));
    return false;
  }
  
  public int hashCode()
  {
    return HashCodeUtil.hashCode(this.width, this.height);
  }
  
  public String toString()
  {
    return String.format(null, "%dx%d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\common\ResizeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
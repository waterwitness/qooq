package com.tencent.av.opengl.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import junit.framework.Assert;

public class ResourceTexture
  extends UploadedTexture
{
  protected final Context a;
  protected final int q;
  
  public ResourceTexture(Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    Assert.assertNotNull(paramContext);
    this.a = paramContext;
    this.q = paramInt;
    d(false);
  }
  
  protected Bitmap a()
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inScaled = false;
    int i = UITools.a(this.a);
    localOptions.inSampleSize = 1;
    if (i <= 480) {
      localOptions.inSampleSize = 2;
    }
    Resources localResources = this.a.getResources();
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeResource(localResources, this.q, localOptions);
      localObject = localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      do
      {
        localOptions.inSampleSize *= 2;
      } while (localResources == null);
      try
      {
        localObject = BitmapFactory.decodeResource(localResources, this.q, localOptions);
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localOptions.inSampleSize *= 2;
        i = this.q;
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(localResources, i, localOptions);
          return localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
      }
    }
    return (Bitmap)localObject;
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\ResourceTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
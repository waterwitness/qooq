package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RoundedTransformation
  implements Transformation
{
  protected final int a;
  protected final int b;
  
  public RoundedTransformation(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - i) / 2, i, i);
    if (localBitmap1 != paramBitmap) {
      paramBitmap.recycle();
    }
    paramBitmap = new Paint();
    paramBitmap.setAntiAlias(true);
    paramBitmap.setShader(new BitmapShader(localBitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), localBitmap1.getConfig());
    new Canvas(localBitmap2).drawRoundRect(new RectF(this.b, this.b, localBitmap1.getWidth() - this.b, localBitmap1.getHeight() - this.b), this.a, this.a, paramBitmap);
    if (localBitmap1 != localBitmap2) {
      localBitmap1.recycle();
    }
    return localBitmap2;
  }
  
  public String a()
  {
    return "rounded(radius=" + this.a + ", margin=" + this.b + ")";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\RoundedTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
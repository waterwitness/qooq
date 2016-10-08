package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CircleTransformation
  implements Transformation
{
  public CircleTransformation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - i) / 2, i, i);
    paramBitmap = Bitmap.createBitmap(i, i, paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint();
    localPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    localPaint.setAntiAlias(true);
    float f = i / 2.0F;
    localCanvas.drawCircle(f, f, f, localPaint);
    localBitmap.recycle();
    return paramBitmap;
  }
  
  public String a()
  {
    return "circle";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\CircleTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
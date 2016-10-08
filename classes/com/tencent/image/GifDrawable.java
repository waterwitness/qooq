package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.File;
import java.io.IOException;

public class GifDrawable
  extends Drawable
  implements AnimationCallback
{
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mGifHeight;
  private GifState mGifState;
  private int mGifWidth;
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage)
  {
    this(paramAbstractGifImage, null);
  }
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage, Resources paramResources)
  {
    this(new GifState(paramAbstractGifImage), paramResources);
    this.mGifState.mTargetDensity = this.mTargetDensity;
  }
  
  public GifDrawable(GifState paramGifState, Resources paramResources)
  {
    this.mGifState = paramGifState;
    paramGifState.mGif.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramGifState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public GifDrawable(File paramFile, Resources paramResources)
    throws IOException
  {
    this(paramFile, paramResources, false);
  }
  
  public GifDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
    throws IOException
  {
    this(NativeGifFactory.getNativeGifObject(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mGifWidth = this.mGifState.mGif.getScaledWidth(this.mTargetDensity);
    this.mGifHeight = this.mGifState.mGif.getScaledHeight(this.mTargetDensity);
  }
  
  /* Error */
  public static boolean isGifFile(File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 104	java/io/File:exists	()Z
    //   11: ifne +9 -> 20
    //   14: iconst_0
    //   15: istore 4
    //   17: iload 4
    //   19: ireturn
    //   20: aconst_null
    //   21: astore_1
    //   22: aconst_null
    //   23: astore_2
    //   24: new 106	java/io/RandomAccessFile
    //   27: dup
    //   28: aload_0
    //   29: ldc 108
    //   31: invokespecial 111	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_0
    //   35: iconst_3
    //   36: newarray <illegal type>
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 115	java/io/RandomAccessFile:read	([B)I
    //   44: pop
    //   45: aload_1
    //   46: iconst_0
    //   47: baload
    //   48: bipush 71
    //   50: if_icmpne +21 -> 71
    //   53: aload_1
    //   54: iconst_1
    //   55: baload
    //   56: bipush 73
    //   58: if_icmpne +13 -> 71
    //   61: aload_1
    //   62: iconst_2
    //   63: baload
    //   64: istore_3
    //   65: iload_3
    //   66: bipush 70
    //   68: if_icmpeq +13 -> 81
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_0
    //   82: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   85: aload_0
    //   86: ifnull -69 -> 17
    //   89: aload_0
    //   90: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   93: iconst_1
    //   94: ireturn
    //   95: astore_0
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_0
    //   99: aload_2
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: goto -44 -> 79
    //   126: astore_0
    //   127: goto -18 -> 109
    //   130: astore_1
    //   131: goto -11 -> 120
    //   134: astore_2
    //   135: aload_0
    //   136: astore_1
    //   137: aload_2
    //   138: astore_0
    //   139: goto -27 -> 112
    //   142: astore_1
    //   143: goto -42 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	File
    //   21	96	1	arrayOfByte	byte[]
    //   130	1	1	localIOException	IOException
    //   136	1	1	localFile	File
    //   142	1	1	localException	Exception
    //   23	77	2	localObject1	Object
    //   134	4	2	localObject2	Object
    //   64	5	3	i	int
    //   1	17	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   24	35	98	java/lang/Exception
    //   24	35	111	finally
    //   75	79	122	java/io/IOException
    //   105	109	126	java/io/IOException
    //   116	120	130	java/io/IOException
    //   35	45	134	finally
    //   81	85	134	finally
    //   35	45	142	java/lang/Exception
    //   81	85	142	java/lang/Exception
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mGifState.mGravity, this.mGifWidth, this.mGifHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    this.mGifState.mGif.draw(paramCanvas, this.mDstRect, this.mGifState.mPaint, this.mUseAnimation);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mGifState;
  }
  
  public int getGravity()
  {
    return this.mGifState.mGravity;
  }
  
  public AbstractGifImage getImage()
  {
    return this.mGifState.mGif;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mGifHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mGifWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mGifState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mGifState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mGifState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mGifState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.mGifState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  static final class GifState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    AbstractGifImage mGif;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    
    public GifState(AbstractGifImage paramAbstractGifImage)
    {
      this.mGif = paramAbstractGifImage;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new GifDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new GifDrawable(this, paramResources);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\GifDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
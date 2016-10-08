package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DoodleView
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = "DoodleView";
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private EmptyLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  private BaseLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  private DoodleConfig jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private int b;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d();
  }
  
  private Bitmap b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null))
    {
      SLog.b("DoodleView", "doodle bitmap has been recycled.");
      return null;
    }
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)((Map.Entry)localIterator.next()).getValue()).b(localCanvas);
    }
    SLog.b("DoodleView", "getResultBitmap cost time:" + (SystemClock.uptimeMillis() - l));
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = new EmptyLayer(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy.a(this.jdField_a_of_type_JavaUtilList, this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      this.jdField_a_of_type_JavaUtilMap.put(localBaseLayer.a(), localBaseLayer);
    }
    SLog.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
    requestLayout();
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = b();
    if (localBitmap != null) {
      SLog.b("DoodleView", "Doodle Bitmap size:" + localBitmap.getHeight() * localBitmap.getRowBytes() / 1024 + "kb");
    }
    return localBitmap;
  }
  
  public BaseLayer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  }
  
  public BaseLayer a(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      BaseLayer localBaseLayer = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localBaseLayer.b(paramMotionEvent)) {
        return localBaseLayer;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public BaseLayer a(String paramString)
  {
    paramString = (BaseLayer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }
    return paramString;
  }
  
  public void a()
  {
    setActiveLayer(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  /* Error */
  public boolean a(Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: ldc 8
    //   5: new 103	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   12: ldc -19
    //   14: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_3
    //   18: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 51	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 239	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:a	()Landroid/graphics/Bitmap;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnonnull +13 -> 48
    //   38: ldc 8
    //   40: ldc -15
    //   42: invokestatic 51	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload 9
    //   47: ireturn
    //   48: aconst_null
    //   49: astore 6
    //   51: aconst_null
    //   52: astore 4
    //   54: aconst_null
    //   55: astore 5
    //   57: new 243	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 244	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 8
    //   67: aload 4
    //   69: astore_3
    //   70: aload 8
    //   72: invokevirtual 247	java/io/File:exists	()Z
    //   75: ifne +12 -> 87
    //   78: aload 4
    //   80: astore_3
    //   81: aload 8
    //   83: invokevirtual 250	java/io/File:createNewFile	()Z
    //   86: pop
    //   87: aload 4
    //   89: astore_3
    //   90: new 252	java/io/FileOutputStream
    //   93: dup
    //   94: aload 8
    //   96: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: astore 4
    //   101: aload 7
    //   103: aload_1
    //   104: iload_2
    //   105: aload 4
    //   107: invokevirtual 259	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   110: pop
    //   111: iconst_1
    //   112: istore 9
    //   114: aload 4
    //   116: ifnull -71 -> 45
    //   119: aload 4
    //   121: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore 4
    //   135: aload 5
    //   137: astore_1
    //   138: aload_1
    //   139: astore_3
    //   140: aload 4
    //   142: invokevirtual 266	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_1
    //   146: ifnull -101 -> 45
    //   149: aload_1
    //   150: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 4
    //   164: aload 6
    //   166: astore_1
    //   167: aload_1
    //   168: astore_3
    //   169: aload 4
    //   171: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   174: aload_1
    //   175: ifnull -130 -> 45
    //   178: aload_1
    //   179: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   207: goto -7 -> 200
    //   210: astore_1
    //   211: aload 4
    //   213: astore_3
    //   214: goto -22 -> 192
    //   217: astore_3
    //   218: aload 4
    //   220: astore_1
    //   221: aload_3
    //   222: astore 4
    //   224: goto -57 -> 167
    //   227: astore_3
    //   228: aload 4
    //   230: astore_1
    //   231: aload_3
    //   232: astore 4
    //   234: goto -96 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	DoodleView
    //   0	237	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	237	2	paramInt	int
    //   0	237	3	paramString	String
    //   52	68	4	localFileOutputStream	java.io.FileOutputStream
    //   133	8	4	localFileNotFoundException	java.io.FileNotFoundException
    //   162	57	4	localIOException	java.io.IOException
    //   222	11	4	str	String
    //   55	81	5	localObject1	Object
    //   49	116	6	localObject2	Object
    //   31	71	7	localBitmap	Bitmap
    //   65	30	8	localFile	java.io.File
    //   1	112	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   119	124	126	java/io/IOException
    //   70	78	133	java/io/FileNotFoundException
    //   81	87	133	java/io/FileNotFoundException
    //   90	101	133	java/io/FileNotFoundException
    //   149	153	155	java/io/IOException
    //   70	78	162	java/io/IOException
    //   81	87	162	java/io/IOException
    //   90	101	162	java/io/IOException
    //   178	182	184	java/io/IOException
    //   70	78	191	finally
    //   81	87	191	finally
    //   90	101	191	finally
    //   140	145	191	finally
    //   169	174	191	finally
    //   196	200	202	java/io/IOException
    //   101	111	210	finally
    //   101	111	217	java/io/IOException
    //   101	111	227	java/io/FileNotFoundException
  }
  
  public boolean a(String paramString)
  {
    return a(Bitmap.CompressFormat.PNG, 100, paramString);
  }
  
  public BaseLayer b(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      BaseLayer localBaseLayer = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localBaseLayer.c(paramMotionEvent)) {
        return localBaseLayer;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((BaseLayer)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    invalidate();
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((BaseLayer)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    SLog.b("DoodleView", "recycle bitmap.");
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)((Map.Entry)localIterator.next()).getValue()).c(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if ((j != Integer.MIN_VALUE) || (k == Integer.MIN_VALUE)) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
    } while ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig == null));
    SLog.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int == 0)
    {
      paramInt3 = this.jdField_a_of_type_Int;
      label115:
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b != 0) {
        break label304;
      }
    }
    label304:
    for (paramInt4 = this.b;; paramInt4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b)
    {
      float f = DisplayUtil.a(this.jdField_a_of_type_Int, this.b, paramInt3, paramInt4);
      paramInt3 = (int)(this.jdField_a_of_type_Int * f);
      paramInt4 = (int)(this.b * f);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      SLog.b("DoodleView", "create Doodle bitmap, width:" + paramInt3 + ",height:" + paramInt4 + ",scaleValue:" + f);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
        localBaseLayer.a(f);
        localBaseLayer.b(paramInt1, paramInt2);
      }
      break;
      paramInt3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int;
      break label115;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = a(paramMotionEvent);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.b(true);
      SLog.b("DoodleView", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.e(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      invalidate();
    }
  }
  
  public void setActiveLayer(BaseLayer paramBaseLayer)
  {
    BaseLayer localBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = paramBaseLayer;
    if (localBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer) {
      return;
    }
    localBaseLayer.h();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.i();
  }
  
  public void setDoodleConfig(DoodleConfig paramDoodleConfig)
  {
    SLog.b("DoodleView", "init DoodleConfig: " + paramDoodleConfig.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig = paramDoodleConfig;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    e();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\doodle\DoodleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
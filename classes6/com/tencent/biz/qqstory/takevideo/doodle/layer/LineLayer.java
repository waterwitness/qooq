package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineLayer
  extends BaseLayer
{
  public static final int a = Integer.MAX_VALUE;
  public static final String a = "LineLayer";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int f = Color.parseColor("#f93021");
  public float a;
  public Paint a;
  public LineLayer.LayerEventListener a;
  public ixc a;
  public List a;
  public boolean a;
  public byte[] a;
  public byte[][] a;
  public float b;
  public float c;
  public float d;
  public int e;
  public int g = f;
  public int h;
  public int i = 10;
  public int j;
  public int k;
  public int l;
  public int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    j();
  }
  
  private void a(Canvas paramCanvas, ixc paramixc, Paint paramPaint)
  {
    if (paramixc.jdField_a_of_type_Int == 3) {
      return;
    }
    a(paramPaint, paramixc);
    paramCanvas.drawPath(paramixc.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
  }
  
  private void a(Paint paramPaint, ixc paramixc)
  {
    if (paramixc.jdField_a_of_type_Int == 1) {
      paramPaint.setXfermode(null);
    }
    for (;;)
    {
      paramPaint.setColor(paramixc.jdField_b_of_type_Int);
      paramPaint.setStrokeWidth(paramixc.c);
      return;
      if (paramixc.jdField_a_of_type_Int == 2) {
        paramPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
    }
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_e_of_type_Int = 1;
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      return;
    case 2: 
      this.jdField_e_of_type_Int = 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      return;
    }
    this.jdField_e_of_type_Int = 3;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int n = 0;
    SLog.b("LineLayer", "increaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.l + ",MosaicMaskHeight:" + this.m);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = n;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      n = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (n >= 0) && (paramInt2 < this.l) && (n < this.m))
      {
        int i1 = this.l * n + paramInt2;
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ArrayOfByte[i1] != Byte.MAX_VALUE)
        {
          arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          arrayOfByte[i1] = ((byte)(arrayOfByte[i1] + 1));
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Array2dOfByte[n][paramInt2] < 127))
        {
          arrayOfByte = this.jdField_a_of_type_Array2dOfByte[n];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] + 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int n = 0;
    SLog.b("LineLayer", "decreaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.l + ",MosaicMaskHeight:" + this.m);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = n;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      n = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (n >= 0) && (paramInt2 < this.l) && (n < this.m))
      {
        int i1 = this.l * n + paramInt2;
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ArrayOfByte[i1] > 0)
        {
          arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          arrayOfByte[i1] = ((byte)(arrayOfByte[i1] - 1));
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Array2dOfByte[n][paramInt2] > 0))
        {
          arrayOfByte = this.jdField_a_of_type_Array2dOfByte[n];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] - 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void j()
  {
    this.h = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(f);
  }
  
  private void k()
  {
    c(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.h);
  }
  
  private void l()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      SLog.b("LineLayer", "------------------------------------------------------------------------");
      StringBuilder localStringBuilder = new StringBuilder();
      int n = 0;
      while (n < this.jdField_a_of_type_Array2dOfByte.length)
      {
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_Array2dOfByte[0].length)
        {
          localStringBuilder.append(this.jdField_a_of_type_Array2dOfByte[n][i1] + " ");
          i1 += 1;
        }
        SLog.b("LineLayer", localStringBuilder.toString());
        localStringBuilder.delete(0, localStringBuilder.length());
        n += 1;
      }
    }
  }
  
  private void m()
  {
    SLog.b("LineLayer", "NotifyDrawMosaic.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener.a(this.jdField_a_of_type_ArrayOfByte, this.l, this.m);
    }
    if (this.jdField_a_of_type_Boolean) {
      l();
    }
  }
  
  public int a()
  {
    int[] arrayOfInt = a();
    int n = arrayOfInt[0];
    return arrayOfInt[1] + n;
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    c(1);
    this.g = f;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(f);
    this.jdField_a_of_type_Ixc = null;
    int n;
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      n = 0;
      while (n < this.jdField_a_of_type_ArrayOfByte.length)
      {
        this.jdField_a_of_type_ArrayOfByte[n] = 0;
        n += 1;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      n = 0;
      while (n < this.jdField_a_of_type_Array2dOfByte.length)
      {
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_Array2dOfByte[0].length)
        {
          this.jdField_a_of_type_Array2dOfByte[n][i1] = 0;
          i1 += 1;
        }
        n += 1;
      }
    }
    m();
    SLog.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SLog.b("LineLayer", "standardWidth:" + paramInt1 + ",standardHeight:" + paramInt2);
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a(paramCanvas, (ixc)localIterator.next(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    k();
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener = paramLayerEventListener;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ixc)localIterator.next()).jdField_a_of_type_Int != 3) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (a() == Integer.MAX_VALUE)
    {
      SLog.b("LineLayer", "line count is max count.can not add more.");
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener.a(Integer.MAX_VALUE);
      }
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.c = f1;
      this.d = f2;
      this.jdField_a_of_type_Ixc = new ixc(new Path(), this.jdField_e_of_type_Int, c(), b());
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ixc);
      int n;
      int i1;
      if (this.jdField_e_of_type_Int == 3)
      {
        DoodleLayout.a("use_mosaics");
        n = (int)(this.b * f1 / this.i);
        i1 = (int)(this.b * f2 / this.i);
        if ((n >= 0) && (i1 >= 0))
        {
          this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(n));
          this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(i1));
          c(n, i1);
          m();
        }
      }
      else
      {
        DoodleLayout.a("use_graffiti");
        this.jdField_a_of_type_Ixc.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_Ixc.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
        this.jdField_a_of_type_Ixc.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + 1.0F, f2 + 1.0F);
        continue;
        int i2;
        int i3;
        if (this.jdField_e_of_type_Int == 3)
        {
          n = ((Integer)this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
          i1 = ((Integer)this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.get(this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.size() - 1)).intValue();
          i2 = (int)(f1 * this.b / this.i);
          i3 = (int)(f2 * this.b / this.i);
          if (((i2 != n) || (i3 != i1)) && (i2 >= 0) && (i3 >= 0))
          {
            this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(i2));
            this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(i3));
            c(i2, i3);
            m();
          }
        }
        else
        {
          this.jdField_a_of_type_Ixc.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.c, this.d, (this.c + f1) / 2.0F, (this.d + f2) / 2.0F);
          this.c = f1;
          this.d = f2;
          continue;
          if (this.jdField_e_of_type_Int == 3)
          {
            n = ((Integer)this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
            i1 = ((Integer)this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.get(this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.size() - 1)).intValue();
            i2 = (int)(f1 * this.b / this.i);
            i3 = (int)(f2 * this.b / this.i);
            if (((i2 != n) || (i3 != i1)) && (i2 >= 0) && (i3 >= 0))
            {
              this.jdField_a_of_type_Ixc.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(i2));
              this.jdField_a_of_type_Ixc.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(i3));
              c(i2, i3);
              m();
            }
          }
        }
      }
    }
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return arrayOfInt;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ixc)localIterator.next()).jdField_a_of_type_Int == 3) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject = (ixc)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (((ixc)localObject).jdField_a_of_type_Int != 3) {
        break label135;
      }
      DoodleLayout.a("delete_mosaics");
      List localList = ((ixc)localObject).jdField_a_of_type_JavaUtilList;
      localObject = ((ixc)localObject).jdField_b_of_type_JavaUtilList;
      int n = 0;
      while ((n < localList.size()) && (n < ((List)localObject).size()))
      {
        d(((Integer)localList.get(n)).intValue(), ((Integer)((List)localObject).get(n)).intValue());
        n += 1;
      }
      m();
    }
    for (;;)
    {
      e();
      return;
      label135:
      DoodleLayout.a("delete_graffiti");
    }
  }
  
  public void b(int paramInt)
  {
    SLog.b("LineLayer", "set MosaicSize:" + paramInt);
    this.i = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.jdField_a_of_type_Float = (this.j / paramInt1);
    this.b = (this.k / paramInt2);
    if (this.b <= 0.0F)
    {
      SLog.e("LineLayer", "mosaicHeightScale <= 0.");
      this.b = this.jdField_e_of_type_Float;
    }
    this.l = ((int)(paramInt1 * this.b / this.i));
    this.m = ((int)(paramInt2 * this.b / this.i));
    SLog.b("LineLayer", "create mosaic mask array, width:" + this.l + ",height:" + this.m + ",array length:" + this.l * this.m);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.l * this.m];
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_ArrayOfByte.length)
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt1] = 0;
      paramInt1 += 1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = this.m;
      paramInt2 = this.l;
      this.jdField_a_of_type_Array2dOfByte = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, paramInt2 }));
      paramInt1 = 0;
      while (paramInt1 < this.m)
      {
        paramInt2 = 0;
        while (paramInt2 < this.l)
        {
          this.jdField_a_of_type_Array2dOfByte[paramInt1][paramInt2] = 0;
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeJoin(Paint.Join.ROUND);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint.setColor(f);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a(paramCanvas, new ixc((ixc)localIterator.next(), this.jdField_e_of_type_Float), localPaint);
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Int == 3;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
  }
  
  public void c()
  {
    SLog.b("LineLayer", "switchMosaicMode.");
    c(3);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void d()
  {
    SLog.b("LineLayer", "switchNormalMode.");
    c(1);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\LineLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FaceLayer
  extends BaseLayer
{
  public static final int a = 5;
  public static final String a;
  public static final int b = 50;
  public Paint a;
  public TextPaint a;
  public FaceLayer.LayerEventListener a;
  public GestureHelper a;
  public ixb a;
  public List a;
  public Map a;
  public boolean a;
  public Paint b;
  public List b;
  public int c;
  public Paint c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = FaceLayer.class.getSimpleName();
  }
  
  public FaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    c();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Ixb);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ixb);
    }
  }
  
  private void a(ixb paramixb, Canvas paramCanvas)
  {
    if (paramixb == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramixb));
    paramixb.a(paramCanvas);
    paramCanvas.restore();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      ixb localixb = (ixb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localixb, paramFloat1, paramFloat2))
      {
        this.jdField_a_of_type_Ixb = localixb;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Ixb = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    e();
    b(false);
  }
  
  private boolean b()
  {
    return a() == 50;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-16711936);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void d()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Ixb);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener != null) && (this.jdField_a_of_type_Ixb != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a((FaceLayer.FaceAndTextItem)this.jdField_a_of_type_Ixb);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      SLog.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ixb = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    SLog.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((ixb)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(FaceLayer.LayerEventListener paramLayerEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener = paramLayerEventListener;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public boolean a(Bitmap paramBitmap, FaceLayer.LayerParams paramLayerParams)
  {
    if (paramBitmap == null) {
      SLog.e(jdField_a_of_type_JavaLangString, "Face bitmap is null.");
    }
    do
    {
      return false;
      if (paramLayerParams == null)
      {
        SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a(50);
    return false;
    SLog.b(jdField_a_of_type_JavaLangString, "Face image from bitmap.");
    int i = (int)(paramBitmap.getWidth() * paramLayerParams.jdField_a_of_type_Float);
    int j = (int)(paramBitmap.getHeight() * paramLayerParams.jdField_a_of_type_Float);
    float f2 = paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f1 = f2;
    if (f2 - i / 2 < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + i / 2;
    }
    if (i / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.right) {}
    for (f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - i / 2;; f2 = f1)
    {
      if (f3 - j / 2 < this.jdField_a_of_type_AndroidGraphicsRect.top) {}
      for (f1 = this.jdField_a_of_type_AndroidGraphicsRect.top + j / 2;; f1 = f3)
      {
        if (j / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
          f1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - j / 2;
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramLayerParams.jdField_a_of_type_JavaLangString))
          {
            SLog.b(jdField_a_of_type_JavaLangString, "Create FaceItem : Normal FaceItem.");
            paramBitmap = new ixb(this, paramBitmap);
          }
          for (;;)
          {
            paramBitmap.jdField_a_of_type_Boolean = paramLayerParams.jdField_a_of_type_Boolean;
            paramBitmap.jdField_c_of_type_AndroidGraphicsPointF = new PointF(f2, f1);
            paramBitmap.jdField_a_of_type_Float = paramLayerParams.jdField_a_of_type_Float;
            this.jdField_a_of_type_JavaUtilList.add(paramBitmap);
            e();
            return true;
            SLog.b(jdField_a_of_type_JavaLangString, "Create FaceItem : Text FaceItem,text:" + paramLayerParams.jdField_a_of_type_JavaLangString);
            paramBitmap = new FaceLayer.FaceAndTextItem(this, paramBitmap);
            ((FaceLayer.FaceAndTextItem)paramBitmap).jdField_a_of_type_JavaLangString = paramLayerParams.jdField_a_of_type_JavaLangString;
            ((FaceLayer.FaceAndTextItem)paramBitmap).jdField_b_of_type_Int = paramLayerParams.jdField_b_of_type_Int;
            ((FaceLayer.FaceAndTextItem)paramBitmap).jdField_c_of_type_Int = paramLayerParams.jdField_a_of_type_Int;
            ((FaceLayer.FaceAndTextItem)paramBitmap).jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramLayerParams.jdField_b_of_type_AndroidGraphicsPointF.x, paramLayerParams.jdField_b_of_type_AndroidGraphicsPointF.y);
            ((FaceLayer.FaceAndTextItem)paramBitmap).jdField_b_of_type_AndroidGraphicsPointF = new PointF(paramLayerParams.jdField_c_of_type_AndroidGraphicsPointF.x, paramLayerParams.jdField_c_of_type_AndroidGraphicsPointF.y);
            ((FaceLayer.FaceAndTextItem)paramBitmap).a(paramLayerParams.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_c_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent);
      return true;
      this.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Ixb != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_Ixb);
        continue;
        if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Ixb instanceof FaceLayer.FaceAndTextItem))) {
            d();
          }
          b(paramMotionEvent);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams)
  {
    int i = 0;
    if (paramDrawable == null) {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
    }
    do
    {
      return false;
      if (paramLayerParams == null)
      {
        SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a(50);
    return false;
    SLog.b(jdField_a_of_type_JavaLangString, "Face image from drawable.");
    Rect localRect = paramDrawable.getBounds();
    int j;
    if (localRect != null)
    {
      j = (int)(localRect.width() * paramLayerParams.jdField_a_of_type_Float);
      i = (int)(localRect.height() * paramLayerParams.jdField_a_of_type_Float);
    }
    for (;;)
    {
      float f2 = paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
      float f3 = paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
      float f1 = f2;
      if (f2 - j / 2 < this.jdField_a_of_type_AndroidGraphicsRect.left) {
        f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + j / 2;
      }
      f2 = f1;
      if (j / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.right) {
        f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - j / 2;
      }
      if (f3 - i / 2 < this.jdField_a_of_type_AndroidGraphicsRect.top) {}
      for (f1 = this.jdField_a_of_type_AndroidGraphicsRect.top + i / 2;; f1 = f3)
      {
        if (i / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
          f1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - i / 2;
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramLayerParams.jdField_a_of_type_JavaLangString))
          {
            SLog.b(jdField_a_of_type_JavaLangString, "Create FaceItem : Normal FaceItem.");
            paramDrawable = new ixb(this, paramDrawable);
            paramDrawable.jdField_a_of_type_Boolean = paramLayerParams.jdField_a_of_type_Boolean;
            paramDrawable.jdField_c_of_type_AndroidGraphicsPointF = new PointF(f2, f1);
            paramDrawable.jdField_a_of_type_Float = paramLayerParams.jdField_a_of_type_Float;
            paramDrawable.jdField_c_of_type_JavaLangString = paramString1;
            paramDrawable.d = paramString2;
            this.jdField_a_of_type_JavaUtilList.add(paramDrawable);
            e();
            if (!(paramDrawable instanceof FaceLayer.FaceAndTextItem)) {
              break label550;
            }
            this.jdField_b_of_type_JavaUtilList.add(paramDrawable.d);
          }
          for (;;)
          {
            return true;
            SLog.b(jdField_a_of_type_JavaLangString, "Create FaceItem : Text FaceItem,text:" + paramLayerParams.jdField_a_of_type_JavaLangString);
            paramDrawable = new FaceLayer.FaceAndTextItem(this, paramDrawable);
            ((FaceLayer.FaceAndTextItem)paramDrawable).jdField_a_of_type_JavaLangString = paramLayerParams.jdField_a_of_type_JavaLangString;
            ((FaceLayer.FaceAndTextItem)paramDrawable).jdField_b_of_type_Int = paramLayerParams.jdField_b_of_type_Int;
            ((FaceLayer.FaceAndTextItem)paramDrawable).jdField_c_of_type_Int = paramLayerParams.jdField_a_of_type_Int;
            ((FaceLayer.FaceAndTextItem)paramDrawable).jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramLayerParams.jdField_b_of_type_AndroidGraphicsPointF.x, paramLayerParams.jdField_b_of_type_AndroidGraphicsPointF.y);
            ((FaceLayer.FaceAndTextItem)paramDrawable).jdField_b_of_type_AndroidGraphicsPointF = new PointF(paramLayerParams.jdField_c_of_type_AndroidGraphicsPointF.x, paramLayerParams.jdField_c_of_type_AndroidGraphicsPointF.y);
            ((FaceLayer.FaceAndTextItem)paramDrawable).a(paramLayerParams.jdField_a_of_type_JavaLangString);
            break;
            label550:
            paramLayerParams = this.jdField_a_of_type_JavaUtilMap;
            paramString2 = (List)paramLayerParams.get(paramDrawable.jdField_c_of_type_JavaLangString);
            paramString1 = paramString2;
            if (paramString2 == null)
            {
              paramString1 = new ArrayList();
              paramLayerParams.put(paramDrawable.jdField_c_of_type_JavaLangString, paramString1);
            }
            paramString1.add(paramDrawable.d);
          }
        }
      }
      j = 0;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ixb)localIterator.next() instanceof FaceLayer.FaceAndTextItem)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    ixb localixb;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localixb = (ixb)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (!(localixb instanceof FaceLayer.FaceAndTextItem)) {
        break label71;
      }
      DoodleLayout.a("delete_poi");
      this.jdField_b_of_type_JavaUtilList.remove(localixb.d);
    }
    label71:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.a("delete_oneface");
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localixb.jdField_c_of_type_JavaLangString);
      } while (localList == null);
      localList.remove(localixb.d);
    } while (!localList.isEmpty());
    this.jdField_a_of_type_JavaUtilMap.remove(localixb.jdField_c_of_type_JavaLangString);
  }
  
  public void b(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (ixb)localIterator.next();
      if ((localObject instanceof FaceLayer.FaceAndTextItem)) {}
      for (localObject = new FaceLayer.FaceAndTextItem(this, (FaceLayer.FaceAndTextItem)localObject, this.jdField_e_of_type_Float);; localObject = new ixb(this, (ixb)localObject, this.jdField_e_of_type_Float))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a((GestureHelper.ZoomItem)localObject));
        ((ixb)localObject).a(paramCanvas);
        paramCanvas.restore();
        break;
      }
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (ixb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, f1, f2)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramMotionEvent = (ixb)this.jdField_a_of_type_JavaUtilList.get(i);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, f1, f2, f3, f4)) {
          this.jdField_a_of_type_Ixb = paramMotionEvent;
        }
      }
      else
      {
        if (i >= 0) {
          break;
        }
        return false;
      }
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Ixb);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ixb);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_Ixb);
    return true;
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener.a(this, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent);
      e();
      return true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
      this.jdField_a_of_type_Ixb = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\FaceLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
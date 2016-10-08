package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixe;
import ixg;

public class TextLayer
  extends BaseLayer
{
  public static final int a = 420;
  public static final String a;
  public static int b = 0;
  public static final int c = -1;
  public static final int d = Color.parseColor("#80000000");
  public static final int e = 5;
  public static final int f = 1;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 6;
  public final long a;
  public Paint a;
  public TextLayer.LayerListener a;
  public TextLayer.State a;
  public GestureHelper a;
  public ixg a;
  public TextLayer.State b;
  public int j;
  public int k;
  public int l;
  public int m = d;
  public int n;
  public int o;
  public int p;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TextLayer.class.getSimpleName();
  }
  
  public TextLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Long = 270L;
    d();
  }
  
  private void b(int paramInt)
  {
    SLog.b(jdField_a_of_type_JavaLangString, "setMode:" + paramInt + ",preMode:" + this.k);
    this.k = this.j;
    this.j = paramInt;
  }
  
  private void d()
  {
    this.n = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.l = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State = new ixe(this);
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State;
    this.k = 1;
    this.j = 1;
    this.jdField_a_of_type_Ixg = new ixg();
    this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ixg.c = new PointF();
    this.jdField_a_of_type_Ixg.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
  }
  
  private void d(Canvas paramCanvas)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a(paramCanvas);
  }
  
  private void j()
  {
    Paint localPaint = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a();
    float f1 = localPaint.measureText(this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString);
    float f2 = localPaint.descent();
    float f3 = localPaint.ascent();
    this.jdField_a_of_type_Ixg.e = f1;
    this.jdField_a_of_type_Ixg.f = (f2 - f3);
  }
  
  public int a()
  {
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public TextInfo a()
  {
    TextInfo localTextInfo = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a();
    localTextInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString;
    return localTextInfo;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.j = 1;
    this.k = 1;
    this.m = d;
    this.p = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a();
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
    this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ixg.c.x = (this.jdField_a_of_type_AndroidGraphicsRect.width() / 2);
    this.jdField_a_of_type_Ixg.c.y = (this.jdField_a_of_type_AndroidGraphicsRect.height() / 2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_Ixg);
    SLog.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
    this.p = paramInt;
  }
  
  protected void a(Canvas paramCanvas)
  {
    d(paramCanvas);
  }
  
  public void a(TextLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener = paramLayerListener;
  }
  
  public void a(TextInfo paramTextInfo)
  {
    if (paramTextInfo == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "textInfo is null.");
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "setTextInfo:" + paramTextInfo.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramTextInfo.jdField_a_of_type_JavaLangString))
    {
      a();
      e();
      return;
    }
    this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString = paramTextInfo.jdField_a_of_type_JavaLangString;
    int i1 = paramTextInfo.e;
    if (i1 == 1) {}
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a(paramTextInfo);
      break;
      if (i1 == 2) {
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b(jdField_a_of_type_JavaLangString, "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      e();
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Ixg.jdField_a_of_type_JavaLangString)) {
        b(1);
      } else {
        b(4);
      }
    }
  }
  
  public boolean a()
  {
    return this.j == 1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener.a();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.jdField_a_of_type_Ixg.jdField_a_of_type_AndroidGraphicsRect.set(0, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 - this.n / 2, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 + this.n / 2);
    this.jdField_a_of_type_Ixg.c.x = (paramInt1 / 2);
    this.jdField_a_of_type_Ixg.c.y = (paramInt2 / 2);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
    if (localBitmap != null) {
      jdField_b_of_type_Int = (int)(localBitmap.getWidth() * 0.04F);
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.b(paramCanvas);
  }
  
  public boolean b()
  {
    return (this.j == 4) || (this.j == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return (b()) && (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.a(paramMotionEvent));
  }
  
  public void c()
  {
    if (!a())
    {
      b(6);
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener.a(1.0F);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (b()) && (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer$State.b(paramMotionEvent));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\TextLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
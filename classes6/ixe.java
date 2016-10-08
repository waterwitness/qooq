import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixe
  extends ixd
{
  private float jdField_a_of_type_Float;
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private ixg jdField_a_of_type_Ixg;
  private float jdField_b_of_type_Float;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  public ixe(TextLayer paramTextLayer)
  {
    super(paramTextLayer);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.d = TextLayer.a(paramTextLayer).getResources().getDimensionPixelSize(2131494205);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.e = 2;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.d);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
  }
  
  private void a(Canvas paramCanvas, ixg paramixg, TextPaint paramTextPaint, StaticLayout paramStaticLayout)
  {
    if ((paramixg == null) || (paramStaticLayout == null)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramixg));
    if (paramStaticLayout.getLineCount() == 1)
    {
      paramTextPaint.setTextAlign(Paint.Align.CENTER);
      float f1 = -((paramTextPaint.descent() + paramTextPaint.ascent()) / 2.0F);
      paramCanvas.drawText(paramixg.jdField_a_of_type_JavaLangString, 0.0F, f1, paramTextPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      paramTextPaint.setTextAlign(Paint.Align.LEFT);
      paramCanvas.translate(-paramixg.e / 2.0F, -paramixg.f / 2.0F);
      paramStaticLayout.draw(paramCanvas);
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.l, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.j == 6)
    {
      a(paramCanvas, this.jdField_a_of_type_Ixg, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextStaticLayout);
      return;
    }
    a(paramCanvas, this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextStaticLayout);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent);
      super.a(paramMotionEvent);
      return;
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg);
      continue;
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b(false);
    }
  }
  
  public void a(TextInfo paramTextInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString = paramTextInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c = paramTextInfo.c;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramTextInfo.c);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(255);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.l - TextLayer.b * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      TextLayer.a(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer);
    }
    for (;;)
    {
      this.i = TextLayer.b;
      return;
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.e = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth();
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.f = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    return this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg, f1, f2);
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_Ixg = new ixg(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg, 1.0F);
      c();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.setDuration(270L);
      localValueAnimator.addUpdateListener(new ixf(this));
      localValueAnimator.start();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    ixg localixg = new ixg(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg, TextLayer.a(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer));
    StaticLayout localStaticLayout = new StaticLayout(localixg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.l - TextLayer.b * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    a(paramCanvas, localixg, this.jdField_a_of_type_AndroidTextTextPaint, localStaticLayout);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    return this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg, f1, f2, f3, f4);
  }
  
  protected void c()
  {
    this.jdField_c_of_type_Float = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.jdField_c_of_type_Float;
    this.d = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.d;
    this.jdField_a_of_type_Float = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.jdField_a_of_type_Float;
    this.jdField_b_of_type_Float = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.jdField_b_of_type_Float;
    this.e = (-this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.jdField_c_of_type_AndroidGraphicsPointF.x + this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.e / 2.0F + this.i - this.jdField_c_of_type_Float);
    this.f = (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.p + this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.f / 2.0F - this.jdField_b_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_Ixg.jdField_c_of_type_AndroidGraphicsPointF.y - this.d);
    this.g = (1.0F - this.jdField_a_of_type_Float);
    if (this.jdField_b_of_type_Float < 180.0F)
    {
      this.h = (0.0F - this.jdField_b_of_type_Float);
      return;
    }
    this.h = (360.0F - this.jdField_b_of_type_Float);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
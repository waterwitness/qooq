package com.tencent.av.widget.stageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hcv;

public class StageMemberView
  extends ViewGroup
{
  public static final int a = 500;
  private static final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(3);
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final String jdField_a_of_type_JavaLangString = "StageMemberView";
  private static final int jdField_b_of_type_Int = 15;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  public ImageView a;
  public MemberEffect a;
  private hcv jdField_a_of_type_Hcv;
  private boolean jdField_a_of_type_Boolean;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = Color.parseColor("#FF6633");
  private String jdField_c_of_type_JavaLangString;
  private int d = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StageMemberView(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
    this.jdField_a_of_type_Hcv = new hcv(this, getContext());
    this.jdField_a_of_type_Hcv.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    addViewInLayout(this.jdField_a_of_type_AndroidWidgetImageView, 0, generateDefaultLayoutParams(), false);
    addViewInLayout(this.jdField_b_of_type_AndroidWidgetImageView, 1, generateDefaultLayoutParams(), false);
    addViewInLayout(this.jdField_a_of_type_Hcv, 2, generateDefaultLayoutParams(), false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    setClipChildren(false);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Integer.MAX_VALUE);
    this.jdField_a_of_type_AndroidTextTextPaint.density = getResources().getDisplayMetrics().density;
    float f = a(0, 15.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f);
    super.setBackgroundColor(this.jdField_c_of_type_Int);
  }
  
  private float a(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth() + 21, paramBitmap1.getHeight() + 21, Bitmap.Config.ARGB_8888);
    paramBitmap2 = Bitmap.createScaledBitmap(paramBitmap2, paramBitmap1.getWidth() + 21, paramBitmap1.getHeight() + 21, true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 10.0F, 10.0F, null);
    localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    localCanvas.save(31);
    localCanvas.restore();
    return localBitmap;
  }
  
  private ShapeDrawable a()
  {
    int i = (int)TypedValue.applyDimension(1, 18.0F, getResources().getDisplayMetrics());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    if (this.jdField_c_of_type_Int == -1) {
      this.jdField_c_of_type_Int = Color.parseColor("#FF6633");
    }
    localShapeDrawable.getPaint().setColor(this.jdField_c_of_type_Int);
    return localShapeDrawable;
  }
  
  private void b()
  {
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.measure(i, j);
    i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    j = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
    if (this.d == 3)
    {
      float f = a(1.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.layout(54, (int)(108.0F - j * 1.4F / f - 2), (int)(i * 1.4F / f + 54.0F), 106);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  float a(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources()) {
      return TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    }
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  void a()
  {
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    if (this.jdField_c_of_type_JavaLangString == null) {}
    for (int i = 0;; i = (int)Layout.getDesiredWidth(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint))
    {
      int j = (int)(localFontMetrics.descent - localFontMetrics.ascent);
      getWidth();
      this.jdField_a_of_type_Hcv.layout((getWidth() - i) / 2 + 5, this.jdField_b_of_type_AndroidWidgetImageView.getHeight(), (i + getWidth()) / 2 + 5, j + this.jdField_b_of_type_AndroidWidgetImageView.getHeight());
      b();
      return;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (((this.jdField_c_of_type_JavaLangString == null) && (paramString == null)) || ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(paramString)))) {
      return;
    }
    float f2 = super.getResources().getDimensionPixelSize(2131493965);
    String str2 = paramString;
    if (f2 > 0.0F)
    {
      float f1 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
      str2 = paramString;
      if (f1 > f2)
      {
        float f3 = f2 - this.jdField_a_of_type_AndroidTextTextPaint.measureText(".");
        String str1 = paramString;
        while ((f3 > 0.0F) && (f1 > f3) && (str1.length() > 0))
        {
          str2 = str1.substring(0, str1.length() - 1);
          f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(str2);
          str1 = str2;
          f1 = f2;
          if (f2 == 0.0F)
          {
            str1 = str2;
            f1 = f2;
            if (str2.length() > 0)
            {
              f1 = 1.0F + f3;
              str1 = str2;
            }
          }
        }
        str2 = paramString;
        if (f3 > 0.0F)
        {
          str2 = paramString;
          if (str1.length() > 0) {
            str2 = str1 + ".";
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.a))) {
      if ((TextUtils.isEmpty(str2)) && (this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.a.contains("%s "))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.a.replace("%s ", "");
      }
    }
    for (;;)
    {
      a();
      this.jdField_a_of_type_Hcv.invalidate();
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
      setContentDescription(this.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_c_of_type_JavaLangString = String.format(this.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.a, new Object[] { str2 });
      continue;
      this.jdField_c_of_type_JavaLangString = str2;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_Boolean) {
        break label47;
      }
    }
    label47:
    for (Object localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;; localObject = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      invalidate();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_a_of_type_AndroidWidgetImageView.isShown()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Hcv.invalidate();
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_b_of_type_AndroidWidgetImageView.invalidate();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;; localObject = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, jdField_a_of_type_AndroidGraphicsRect, jdField_a_of_type_AndroidGraphicsPaint);
      dispatchDraw(paramCanvas);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    paramInt1 = (int)9.5F;
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
    this.jdField_b_of_type_AndroidWidgetImageView.layout(0, 0, 114, 114);
    a();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      if (!this.jdField_a_of_type_Boolean) {
        break label79;
      }
    }
    label79:
    for (Object localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;; localObject = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      int i = (int)9.5F;
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_b_of_type_AndroidWidgetImageView.layout(0, 0, 114, 114);
      super.invalidate();
      a();
      return;
    }
  }
  
  public void setIconBadge(int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.d = paramInt;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        b();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\stageview\StageMemberView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
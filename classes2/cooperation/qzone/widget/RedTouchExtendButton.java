package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import ysg;

public class RedTouchExtendButton
  extends ExtendButton
{
  public static final int a = 11;
  public static final int b = 0;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 24;
  public static final int f = 10;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RedTouchExtendButton.RedInfo jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo;
  public String a;
  private String b = "";
  private int g = a(24);
  private int h = a(10);
  private int i = a(10);
  private int j = 100;
  
  public RedTouchExtendButton(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a()
  {
    return (int)getLayout().getLineRight(0);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (a(this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo)) {}
    try
    {
      int m = b() - a(4);
      int k = a() - a(2);
      if (this.j == 0)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843321);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, m, this.i + k, this.i + m);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      Object localObject1;
      if (this.j == 4)
      {
        localObject1 = this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo.jdField_a_of_type_JavaLangString;
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(a(11));
        localPaint.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = localPaint.getFontMetrics();
        m = a(2) + k;
        int n = getHeight() / 2 - (this.i + a(0) * 2) / 2;
        Rect localRect = new Rect();
        localRect.left = m;
        localRect.top = n;
        int i1 = this.i + a(0) * 2;
        localRect.bottom = (n + i1);
        localRect.right = (i1 + m);
        float f1 = a(0) + n;
        float f2 = ((Paint.FontMetrics)localObject2).top;
        localObject2 = getResources().getDrawable(2130843321);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(m, n, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.j == 3)
      {
        localObject1 = getResources().getDrawable(2130842455);
        k += a(2);
        m = getHeight() / 2 - ((Drawable)localObject1).getIntrinsicHeight() / 2;
        ((Drawable)localObject1).setBounds(k, m, ((Drawable)localObject1).getIntrinsicWidth() + k, ((Drawable)localObject1).getIntrinsicHeight() + m);
        ((Drawable)localObject1).draw(paramCanvas);
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c() >= this.g)
    {
      bool1 = bool2;
      if (d() >= this.g + a(2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    if (paramRedInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (!paramRedInfo.jdField_a_of_type_Boolean);
      a(a(), paramRedInfo);
      if (paramRedInfo.e == 3)
      {
        if (a())
        {
          this.i = this.g;
          this.jdField_a_of_type_JavaLangString = paramRedInfo.b;
          this.j = 3;
          return true;
        }
        if (b())
        {
          this.i = this.h;
          this.j = 0;
          return true;
        }
        this.i = 0;
        this.j = 100;
        return false;
      }
      if (paramRedInfo.e == 4)
      {
        this.b = paramRedInfo.jdField_a_of_type_JavaLangString;
        if (a(this.b))
        {
          paramRedInfo = new TextPaint();
          paramRedInfo.setTextSize(a(11));
          int k = (int)paramRedInfo.measureText(this.b);
          paramRedInfo = paramRedInfo.getFontMetrics();
          this.i = Math.max(k, (int)(paramRedInfo.bottom - paramRedInfo.top));
          this.j = 4;
          return true;
        }
        if (b())
        {
          this.i = this.h;
          this.j = 0;
          return true;
        }
        this.i = 0;
        this.j = 100;
        return false;
      }
    } while (paramRedInfo.e != 0);
    if (b())
    {
      this.i = this.h;
      this.j = 0;
      return true;
    }
    this.i = 0;
    this.j = 100;
    return false;
  }
  
  private boolean a(RedTouchExtendButton.RedInfo paramRedInfo1, RedTouchExtendButton.RedInfo paramRedInfo2)
  {
    return a(paramRedInfo1, paramRedInfo2);
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int k;
    do
    {
      return false;
      TextPaint localTextPaint = new TextPaint();
      localTextPaint.setTextSize(a(11));
      k = (int)localTextPaint.measureText(paramString);
      paramString = localTextPaint.getFontMetrics();
      k = Math.max(k, (int)(paramString.bottom - paramString.top));
    } while (d() < k + a(0) * 2 + a(2));
    return true;
  }
  
  private int b()
  {
    Rect localRect = new Rect();
    getLineBounds(0, localRect);
    int k = localRect.top;
    if (k > 0) {
      return k;
    }
    return 0;
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c() >= this.h)
    {
      bool1 = bool2;
      if (d() + a(2) >= this.h) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int c()
  {
    return getHeight();
  }
  
  private int d()
  {
    int k = a();
    return getWidth() - k - a(0);
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected Bitmap a(File paramFile)
  {
    try
    {
      paramFile = new BitmapDrawable(new FileInputStream(paramFile)).getBitmap();
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  public RedTouchExtendButton.RedInfo a()
  {
    return this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ysg(this));
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo = paramRedInfo;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\widget\RedTouchExtendButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
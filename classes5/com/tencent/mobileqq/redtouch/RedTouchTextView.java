package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.json.JSONObject;
import ufe;
import uff;

public class RedTouchTextView
  extends TextView
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 9;
  public static final int f = 100;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 11;
  public static final int j = 6;
  public static final int k = 2;
  public static final int l = 0;
  public static final int m = 0;
  public static final int n = 8;
  public static final int o = 30;
  public static final int p = 10;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private boolean jdField_a_of_type_Boolean;
  public Drawable b;
  public String b = "";
  private String c = "";
  private int q = a(30);
  private int r = a(10);
  private int s = a(10);
  private int t = 100;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RedTouchTextView.class.getSimpleName();
  }
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a()
  {
    return getHeight();
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
      }
      return null;
    }
    paramAppInfo = paramAppInfo.red_type_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRedTypeInfoFromAppInfo redInfos = null");
      }
      return null;
    }
    if (paramAppInfo.size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
      }
      return null;
    }
    return (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(1);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "drawRed start draw");
      }
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        break label34;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label34:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.get())) {}
        int i4;
        int i5;
        int i1;
        int i2;
        int i3;
        for (Object localObject1 = new JSONObject();; localObject1 = new JSONObject(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.get()))
        {
          i4 = getWidth() - a(0) - this.s;
          i5 = getHeight() / 2 - this.s / 2;
          if (this.t == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "draw redtouchpoint");
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843321);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i4, i5, this.s + i4, this.s + i5);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          }
          if (this.t == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "draw redtouch text");
            }
            i1 = -1;
            i2 = 0;
            if (((JSONObject)localObject1).has("cr")) {
              i1 = a(((JSONObject)localObject1).getString("cr"));
            }
            if (((JSONObject)localObject1).has("cn")) {
              i2 = a(((JSONObject)localObject1).getString("cn"));
            }
            localObject2 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.get();
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(a(11));
            localPaint.setTextAlign(Paint.Align.LEFT);
            Object localObject3 = localPaint.getFontMetrics();
            i3 = (int)(((Paint.FontMetrics)localObject3).bottom - ((Paint.FontMetrics)localObject3).top);
            int i6 = getWidth() - a(0) - this.s - a(6) * 2;
            int i7 = getHeight() / 2 - i3 / 2 - a(2);
            Rect localRect = new Rect();
            localRect.left = i6;
            localRect.top = i7;
            localRect.right = (this.s + i6 + a(6) * 2);
            localRect.bottom = (i3 + i7 + a(2) * 2);
            float f1 = a(2) + i7;
            float f2 = ((Paint.FontMetrics)localObject3).top;
            if (i2 != 0)
            {
              localObject3 = getResources().getDrawable(2130843325);
              ((Drawable)localObject3).getBounds();
              ((Drawable)localObject3).setBounds(i6, i7, localRect.right, localRect.bottom);
              ((Drawable)localObject3).draw(paramCanvas);
            }
            localPaint.setColor(i1);
            paramCanvas.drawText((String)localObject2, a(6) + i6, f1 - f2, localPaint);
          }
          if (this.t != 3) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "draw redtouch img");
          }
          i1 = 0;
          i2 = 0;
          i3 = 0;
          if (((JSONObject)localObject1).has("av")) {
            i1 = ((JSONObject)localObject1).getInt("av");
          }
          if (((JSONObject)localObject1).has("dot")) {
            i2 = ((JSONObject)localObject1).getInt("dot");
          }
          if (((JSONObject)localObject1).has("st")) {
            i3 = Integer.valueOf(((JSONObject)localObject1).getString("st")).intValue();
          }
          if (i3 != 1) {
            break label761;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "draw redtouch img gif ");
          }
          localObject1 = getResources().getDrawable(2130838582);
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.q;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.q;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
          localObject1 = URLDrawable.getDrawable(this.b, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject1).setCallback(this);
          ((URLDrawable)localObject1).draw(paramCanvas);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            break;
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i4, i5, this.s + i4, this.s + i5);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          return;
        }
        label761:
        if (i3 != 0) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "draw redtouch img static ");
        }
        if (i2 == 1)
        {
          localObject1 = getResources().getDrawable(2130843321);
          ((Drawable)localObject1).setBounds(getWidth() - a(0) - a(8), i5, getWidth() - a(0), a(8) + i5);
          ((Drawable)localObject1).draw(paramCanvas);
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          localObject1 = getResources().getDrawable(2130838582);
          ((Drawable)localObject1).setBounds(i4, i5, this.s + i4, this.s + i5);
          ((Drawable)localObject1).draw(paramCanvas);
        }
        while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          ThreadManager.a(new ufe(this, i1), 8, null, true);
          return;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i4, i5, this.s + i4, this.s + i5);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        return;
      }
      catch (Exception paramCanvas) {}
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a() >= this.q)
    {
      bool1 = bool2;
      if (b() >= this.q) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportRedImage result = " + bool1);
    }
    return bool1;
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return false;
    }
    if (paramAppInfo.iNewFlag.get() == 0) {
      return false;
    }
    paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
    if (paramAppInfo == null) {
      return false;
    }
    paramAppInfo = paramAppInfo.red_type_info.get();
    if (paramAppInfo == null) {
      return false;
    }
    if (paramAppInfo.size() < 2) {
      return false;
    }
    paramAppInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(1);
    if (paramAppInfo == null) {
      return false;
    }
    if (a(paramAppInfo, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo)) {}
    while (paramAppInfo.red_type.get() == 3) {
      if (a())
      {
        this.s = this.q;
        this.b = paramAppInfo.red_content.get();
        this.t = 3;
        return true;
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = paramAppInfo;
      }
      else
      {
        if (b())
        {
          this.s = this.r;
          this.t = 0;
          return true;
        }
        this.s = 0;
        this.t = 100;
        return false;
      }
    }
    if (paramAppInfo.red_type.get() == 4)
    {
      this.c = paramAppInfo.red_content.get();
      if (a(this.c))
      {
        paramAppInfo = new TextPaint();
        paramAppInfo.setTextSize(a(11));
        this.s = ((int)paramAppInfo.measureText(this.c));
        this.t = 4;
        return true;
      }
      if (b())
      {
        this.s = this.r;
        this.t = 0;
        return true;
      }
      this.s = 0;
      this.t = 100;
      return false;
    }
    if (paramAppInfo.red_type.get() == 0)
    {
      if (b())
      {
        this.s = this.r;
        this.t = 0;
        return true;
      }
      this.s = 0;
      this.t = 100;
      return false;
    }
    return false;
  }
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if ((paramRedTypeInfo1 == null) || (paramRedTypeInfo2 == null)) {}
    while ((paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) || (!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) || (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) || (paramRedTypeInfo1.red_priority.get() != paramRedTypeInfo2.red_priority.get())) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(a(11));
    int i1 = (int)localTextPaint.measureText(paramString);
    if (b() >= i1 + a(6) * 2) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportRedText result = " + bool);
    }
    return bool;
  }
  
  private int b()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    float f1 = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f1 - getPaddingLeft() - a(0) - a(0));
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a() >= this.r)
    {
      bool1 = bool2;
      if (b() >= this.r) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportRedPoint result = " + bool1);
    }
    return bool1;
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  public Bitmap a(File paramFile)
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
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    return this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new uff(this));
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
  
  public void setAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setAppInfo appInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setAppInfo path = " + paramAppInfo.path.get() + "; inewflag = " + paramAppInfo.iNewFlag.get());
    }
    if (!a(a(paramAppInfo), this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedTouchTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import voj;
import vom;

public class RollangleImageView
  extends ImageView
{
  public static final int a = 50;
  public static LruCache a;
  private static final String c;
  public String a;
  vom jdField_a_of_type_Vom = null;
  boolean jdField_a_of_type_Boolean = false;
  public String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = RollangleImageView.class.getSimpleName();
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new voj((int)Runtime.getRuntime().maxMemory() / 8);
  }
  
  public RollangleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap a(String paramString)
  {
    Bitmap localBitmap = (Bitmap)jdField_a_of_type_AndroidSupportV4UtilLruCache.get("troopfilerollangleimage://");
    Object localObject4 = (Bitmap)jdField_a_of_type_AndroidSupportV4UtilLruCache.get("troopfilerollangleimageborder://");
    Object localObject3;
    Object localObject2;
    Object localObject5;
    if (localBitmap != null)
    {
      localObject3 = localBitmap;
      localObject2 = localObject4;
      if (localObject4 != null) {}
    }
    else
    {
      localObject5 = BaseApplication.getContext().getResources();
      localObject1 = localBitmap;
      if (localBitmap != null) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject5, 2130839415);
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put("troopfilerollangleimage://", localObject1);
      localObject3 = localObject1;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = BitmapFactory.decodeResource((Resources)localObject5, 2130839414);
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put("troopfilerollangleimageborder://", localObject2);
        localObject3 = localObject1;
      }
      localObject1 = ImageUtil.a(new BitmapFactory.Options(), paramString, 128);
      i = paramString.getWidth();
    }
    catch (OutOfMemoryError paramString)
    {
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        if (paramString != null) {
          break label169;
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e(c, 4, "decode srcBmp OutOfMemoryError error");
        return null;
      }
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e(c, 4, "decode maskBmp borderBmp OutOfMemoryError error");
      }
      return null;
    }
    label167:
    label169:
    int i;
    int j = paramString.getHeight();
    int k = Math.max(i, j);
    if (k <= 0) {
      return null;
    }
    Object localObject1 = new Rect(0, 0, k, k);
    try
    {
      localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      localObject4 = new Canvas(localBitmap);
      localObject5 = new Paint();
      ((Paint)localObject5).setAntiAlias(true);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject3, new Rect(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()), (Rect)localObject1, (Paint)localObject5);
      localObject3 = new Rect();
      ((Rect)localObject3).left = ((k - i) / 2);
      ((Rect)localObject3).top = ((k - j) / 2);
      ((Rect)localObject3).right = (((Rect)localObject3).left + i);
      ((Rect)localObject3).bottom = (((Rect)localObject3).top + j);
      Rect localRect = new Rect(0, 0, i, j);
      ((Paint)localObject5).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject4).drawBitmap(paramString, localRect, (Rect)localObject3, (Paint)localObject5);
      localObject3 = new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      ((Paint)localObject5).setXfermode(null);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, (Rect)localObject3, (Rect)localObject1, (Paint)localObject5);
      paramString.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(c, 2, "generateRollAngleThumb, rollAngleBmp, OutOfMemoryError");
      }
    }
    return null;
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      if (paramBoolean) {
        return RollangleImageView.ImageCache.a().b(this.b, this);
      }
      return RollangleImageView.ImageCache.a().a(this.b, this);
    }
    return RollangleImageView.ImageCache.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static void setSuspendLoad(boolean paramBoolean)
  {
    RollangleImageView.ImageCache.a().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vom != null)
    {
      this.jdField_a_of_type_Vom.cancel(true);
      this.jdField_a_of_type_Vom = null;
    }
    this.jdField_a_of_type_Vom = new vom(this);
    this.jdField_a_of_type_Vom.execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    if ((TroopFileUtils.a(paramString1, this.jdField_a_of_type_JavaLangString)) && (TroopFileUtils.a(paramString2, this.b))) {
      return;
    }
    if (RollangleImageView.ImageCache.a().jdField_a_of_type_Boolean)
    {
      setParamsOnScrolling(paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a(true);
  }
  
  public void setParamsOnScrolling(String paramString1, String paramString2)
  {
    if ((TroopFileUtils.a(paramString1, this.jdField_a_of_type_JavaLangString)) && (TroopFileUtils.a(paramString2, this.b))) {
      return;
    }
    Bitmap localBitmap = RollangleImageView.ImageCache.a().a(paramString2, this);
    if (localBitmap == null) {}
    for (paramString1 = RollangleImageView.ImageCache.a().a(paramString1);; paramString1 = localBitmap)
    {
      setImageBitmap(paramString1);
      return;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\RollangleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
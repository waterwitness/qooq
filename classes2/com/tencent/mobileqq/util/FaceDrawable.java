package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class FaceDrawable
  extends AsynLoadDrawable
  implements FaceDecodeTask.DecodeCompletionListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDrawable";
  FaceDrawable.OnLoadingStateChangeListener jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener;
  public FaceInfo a;
  public boolean b;
  
  protected FaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramDrawable1, paramDrawable2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    long l1 = System.currentTimeMillis();
    a(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener = paramOnLoadingStateChangeListener;
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramInt3 = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = new FaceInfo(paramInt1, paramString, false, paramByte, paramInt3, paramBoolean1, paramInt2, paramBoolean2);
      paramAppInterface = b();
      if (paramAppInterface != null)
      {
        this.d = 1;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BaseApplicationImpl.a().getResources(), paramAppInterface);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener.a(-1, this.d);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDrawable", 2, "time cost FaceDrawable:" + (l2 - l1));
        }
        return;
        this.d = 0;
        a();
      }
    }
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      return ImageUtil.c();
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      return ImageUtil.d();
    }
    if (paramInt2 == 1) {
      return new ColorDrawable(Color.parseColor("#ebe9e9"));
    }
    return ImageUtil.b();
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    Drawable localDrawable = a(paramInt, 3);
    return a(paramAppInterface, paramInt, paramString, 3, localDrawable, localDrawable);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, false);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, false);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1 + ",appIntf=" + paramAppInterface);
      }
    }
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, false, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramOnLoadingStateChangeListener, false);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, paramOnLoadingStateChangeListener, paramBoolean);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, null, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, null, paramBoolean);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramAppInterface, paramInt, paramString, paramBoolean, false);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt + ",appIntf=" + paramAppInterface);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, 3);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDrawableImpl(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDrawable(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = a(1, paramByte);
    return a(paramAppInterface, 1, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "http://q.qlogo.cn/qqapp/" + paramString2 + "/" + paramString1 + "/100";
  }
  
  public static FaceDrawable b(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = a(11, paramByte);
    return a(paramAppInterface, 11, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public Drawable a()
  {
    return a(1, 3);
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
      this.c = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener = null;
    }
    super.a();
  }
  
  protected abstract void a(AppInterface paramAppInterface);
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((this.jdField_b_of_type_Boolean) || (paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (!paramFaceInfo.equals(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo))) {
      return;
    }
    b();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((this.jdField_b_of_type_Boolean) || (paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (!paramFaceInfo.equals(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo))) {
      return;
    }
    paramFaceInfo = null;
    int j = 0;
    if (paramBitmap != null) {
      paramFaceInfo = new BitmapDrawable(BaseApplicationImpl.a().getResources(), paramBitmap);
    }
    int i;
    if (paramFaceInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFaceInfo;
      i = 1;
      label65:
      if (i == 0) {
        break label205;
      }
      i = this.d;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label207;
      }
      this.d = 1;
      if (this.e != -1) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.e);
      }
      if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
    }
    for (;;)
    {
      invalidateSelf();
      if ((i == this.d) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawable$OnLoadingStateChangeListener.a(i, this.d);
      return;
      i = j;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break label65;
      }
      i = j;
      if (this.d == 2) {
        break label65;
      }
      i = 1;
      break label65;
      label205:
      break;
      label207:
      this.d = 2;
      if (this.c != null)
      {
        if (this.e != -1) {
          this.c.setAlpha(this.e);
        }
        if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
          this.c.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
        }
        this.c.setVisible(isVisible(), true);
        this.c.setBounds(getBounds());
      }
    }
  }
  
  protected abstract boolean a();
  
  protected abstract Bitmap b();
  
  protected abstract void b();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FaceDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
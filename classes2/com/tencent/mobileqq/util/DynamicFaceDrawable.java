package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicFaceDrawable
{
  public static final int a = 0;
  public static long a = 0L;
  public static Object a;
  public static final String a = "Q.dynamicAvatar";
  public static int[] a;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public Drawable a;
  public URLDrawable a;
  public DynamicAvatarManager a;
  public WeakReference a;
  public boolean a;
  public String b;
  public WeakReference b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public boolean f;
  public boolean g;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 3, 5, 0, 4, 6, 1 };
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public DynamicFaceDrawable()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4))
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
      a(paramAppInterface, paramBoolean4, paramInt5, paramBoolean2, paramBoolean5, null, paramBoolean1);
      return;
    }
  }
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 0, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
    a(paramAppInterface, paramBoolean3, paramInt4, paramBoolean5, paramBoolean4, paramDynamicAvatar, paramBoolean2);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_b_of_type_Boolean = true;
      AbstractVideoImage.pauseAll();
      paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(179);
      if (paramAppInterface != null) {
        paramAppInterface.d();
      }
      ThreadManager.b().removeCallbacks(paramAppInterface.a);
      return;
    }
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    int n;
    if (jdField_a_of_type_Long <= 0L)
    {
      n = DeviceInfoUtil.b();
      if (n < 8) {
        break label50;
      }
      jdField_a_of_type_Long = 100L;
    }
    for (;;)
    {
      paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(179);
      ThreadManager.b().postDelayed(paramAppInterface.a, jdField_a_of_type_Long);
      return;
      label50:
      if (n >= 4) {
        jdField_a_of_type_Long = 200L;
      } else if (n >= 3) {
        jdField_a_of_type_Long = 400L;
      } else if (n >= 2) {
        jdField_a_of_type_Long = 800L;
      } else {
        jdField_a_of_type_Long = 1000L;
      }
    }
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    if (!b()) {
      return;
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
  }
  
  public void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DynamicAvatar paramDynamicAvatar, boolean paramBoolean5)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.i = paramInt4;
    this.m = paramInt5;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_c_of_type_Boolean = paramBoolean4;
    this.g = paramBoolean2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramInt2 == 200)
    {
      this.k = 17;
      if (paramInt1 != 32) {
        break label144;
      }
    }
    label144:
    for (this.j = 18;; this.j = 17)
    {
      this.l = paramInt3;
      this.f = paramBoolean1;
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_d_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = false;
      this.jdField_e_of_type_JavaLangString = DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt3);
      if (!paramBoolean5) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramAppInterface.getManager(179));
      return;
      this.k = 18;
      break;
    }
  }
  
  public void a(AppInterface paramAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, DynamicAvatar paramDynamicAvatar, boolean paramBoolean4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this);
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(paramInt)))
    {
      paramBoolean1 = true;
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (this.jdField_a_of_type_Boolean) {
        break label43;
      }
    }
    label43:
    do
    {
      do
      {
        return;
        paramBoolean1 = false;
        break;
      } while ((!paramBoolean2) && (!NetworkUtil.i(BaseApplicationImpl.getContext())) && (paramBoolean3));
      if ((paramBoolean2) || (paramDynamicAvatar == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b(this);
        return;
      }
      if (paramDynamicAvatar != null)
      {
        this.jdField_c_of_type_JavaLangString = DynamicAvatarManager.a(this.j, this.l, paramDynamicAvatar);
        this.jdField_d_of_type_JavaLangString = DynamicAvatarManager.a(this.j, 640, paramDynamicAvatar);
        if ((paramBoolean4) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_JavaLangString = DynamicAvatarManager.a(17, this.l, paramDynamicAvatar);
          this.jdField_d_of_type_JavaLangString = DynamicAvatarManager.a(17, 640, paramDynamicAvatar);
        }
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_e_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "initValue url: " + this.jdField_c_of_type_JavaLangString);
        }
      }
    } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b(this);
  }
  
  public boolean a()
  {
    return a() == this.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public boolean a(URLDrawable paramURLDrawable)
  {
    if (!b()) {
      return false;
    }
    if (this.jdField_c_of_type_JavaLangString.equals(((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url equals currentUrl");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url not equals currentUrl");
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    if (!jdField_b_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return false;
    }
    return ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable == this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\DynamicFaceDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
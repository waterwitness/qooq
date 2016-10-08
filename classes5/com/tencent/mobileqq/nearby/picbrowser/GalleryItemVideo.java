package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import tkt;
import tku;

public class GalleryItemVideo
  extends PicBrowserImage
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  public static final String a;
  int jdField_a_of_type_Int;
  DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  int g = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GalleryItemVideo.class.getSimpleName();
  }
  
  public GalleryItemVideo(Context paramContext, PicInfo paramPicInfo)
  {
    super(paramContext, paramPicInfo);
    paramContext = (AppInterface)BaseApplicationImpl.a().a();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramContext.getManager(179));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager == null) {}
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this);
      return;
      if ((paramContext instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramContext.getManager(179));
      }
    }
  }
  
  private URLDrawable.URLDrawableOptions a(Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    paramDrawable = new VideoDrawable.VideoDrawableParams();
    paramDrawable.mPlayVideoFrame = true;
    paramDrawable.mPlayAudioFrame = true;
    paramDrawable.mEnableAntiAlias = true;
    paramDrawable.mEnableFilter = true;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mExtraInfo = paramDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString.replaceFirst("http", "nearbyimage");
      localObject1 = localObject2;
      if (AbsDownloader.a(str))
      {
        paramString = URLDrawable.getDrawable(str, null);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + str);
          localObject1 = paramString;
        }
      }
    }
    return (URLDrawable)localObject1;
  }
  
  public View a(int paramInt, Handler paramHandler, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      return localURLImageView;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getView pos:" + paramInt);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localURLImageView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLoadListener);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.e;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.e;
    paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.jdField_a_of_type_JavaLangString);
    int i;
    label149:
    label187:
    boolean bool2;
    if (paramHandler != null)
    {
      i = 1;
      if (i == 0)
      {
        paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        if (paramHandler == null) {
          break label456;
        }
        i = 1;
        if (i == 0)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b)) {
            break label462;
          }
          paramHandler = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b.replaceFirst("http", "nearbyimage"), (URLDrawable.URLDrawableOptions)localObject);
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.e)) {
        break label522;
      }
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.e);
      bool2 = ((File)localObject).exists();
      bool1 = bool2;
      if (bool2) {
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((File)localObject, a(paramHandler)));
      }
    }
    label397:
    label456:
    label462:
    label522:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
        {
          bool1 = DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
          bool2 = bool1;
          if (bool1)
          {
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d), a(paramHandler)));
            bool2 = bool1;
          }
        }
      }
      if (!bool2) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
        {
          this.g = 0;
          localURLImageView.setImageDrawable(paramHandler);
          paramHandler = (AppInterface)BaseApplicationImpl.a().a();
          if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)) {
            this.jdField_b_of_type_Int = 0;
          }
          paramOnLoadListener.a(paramInt, this.jdField_b_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "fileNotExsits progress:" + this.jdField_b_of_type_Int + " url:" + this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
          }
        }
      }
      for (;;)
      {
        return localURLImageView;
        i = 0;
        break;
        i = 0;
        break label149;
        paramHandler = URLDrawableHelper.e;
        break label187;
        localURLImageView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
        this.g = 2;
        paramOnLoadListener.a(paramInt, false);
        break label397;
        this.jdField_b_of_type_Int = 0;
        this.g = 1;
        paramOnLoadListener.a(paramInt, true);
      }
    }
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "preload:" + this.jdField_a_of_type_Int);
      }
      if (!DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
      }
    }
  }
  
  public void a(View paramView, int paramInt, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    boolean bool2 = true;
    paramView = (URLImageView)paramView;
    Drawable localDrawable = paramView.getDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof URLDrawable))) {
      return;
    }
    if ((this.g != 1) && (this.g != 2) && (this.g != 3) && (this.g != 4))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "updateProgressOnSelected:" + this.jdField_b_of_type_Int);
      }
      if (this.jdField_b_of_type_Int > 0) {
        paramOnLoadListener.b(paramInt, this.jdField_b_of_type_Int / 100);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    boolean bool1 = bool2;
    if (this.g != 1) {
      if (this.g != 4) {
        break label166;
      }
    }
    label166:
    for (bool1 = bool2;; bool1 = false)
    {
      paramOnLoadListener.a(paramInt, bool1);
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
    {
      this.jdField_b_of_type_Int = paramInt;
      paramString = (PicBrowserImage.OnLoadListener)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (paramString != null) {
        paramString.b(this.jdField_a_of_type_Int, paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i;
    URLImageView localURLImageView;
    String str;
    StringBuilder localStringBuilder;
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
    {
      if (!paramBoolean1) {
        break label275;
      }
      i = 1;
      this.g = i;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onDownloadFinish pos:" + this.jdField_a_of_type_Int + " suc:" + paramBoolean1);
      }
      paramString = (PicBrowserImage.OnLoadListener)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      localURLImageView = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        paramString.a(this.jdField_a_of_type_Int, paramBoolean1);
        paramString.a(this.jdField_a_of_type_Int);
      }
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("onDownloadFinish onloadli=null:");
        if (paramString != null) {
          break label281;
        }
      }
    }
    label275:
    label281:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      QLog.i(str, 2, paramBoolean2);
      if (localURLImageView != null)
      {
        i = j;
        if (paramBoolean1)
        {
          i = j;
          if (DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
          {
            localURLImageView.post(new tkt(this, localURLImageView, URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d), a(localURLImageView.getDrawable()))));
            i = 1;
          }
        }
        if (i == 0) {
          localURLImageView.post(new tku(this, localURLImageView, BaseApplicationImpl.a().getResources().getDrawable(2130837568)));
        }
      }
      return;
      i = 2;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "pause audio:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Object localObject = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)) {
            ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).stopAudio();
          }
        }
      }
    }
  }
  
  public Drawable c()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return (Drawable)localObject2;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.e;
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.e;
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.jdField_a_of_type_JavaLangString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        localObject1 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile()), localURLDrawableOptions);
        localObject2 = b();
        if ((localObject1 != null) && (localObject2 != null))
        {
          this.h = a((Rect)localObject2, (Drawable)localObject1);
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getAnimationDrawable ,cutValue = " + this.h);
          return (Drawable)localObject1;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localMalformedURLException.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    super.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\GalleryItemVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
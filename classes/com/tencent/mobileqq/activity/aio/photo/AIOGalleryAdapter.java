package com.tencent.mobileqq.activity.aio.photo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import nsy;
import nta;
import ntc;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements ProGallery.OnProGalleryListener
{
  static final String jdField_a_of_type_JavaLangString = "AIOGalleryAdapter";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "NOSAMPLE";
  private static final String jdField_c_of_type_JavaLangString = "DISPLAY";
  private static final String jdField_d_of_type_JavaLangString = "PART";
  public int a;
  long jdField_a_of_type_Long;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public AIOGalleryActivity a;
  private AIOGalleryAdapter.GalleryURLImageView jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView;
  public AIOGalleryAdapter.OnAdapterNotify a;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  public IAIOImageProvider a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  long jdField_b_of_type_Long;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.e = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.f = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.c = -1;
  }
  
  private void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    do
    {
      do
      {
        return;
        paramURLDrawable = paramURLDrawable.getCurrDrawable();
      } while (!VideoDrawable.class.isInstance(paramURLDrawable));
      ((VideoDrawable)paramURLDrawable).stopAudio();
      if (this.jdField_b_of_type_Long > 0L)
      {
        this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
        paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
        if (paramURLDrawable != null)
        {
          int i = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
          paramURLDrawable = paramURLDrawable.getStringExtra("uin");
          new DCShortVideo(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, 2001, 0, i, paramURLDrawable, this.jdField_a_of_type_Long / 1000L);
        }
        this.jdField_b_of_type_Long = -1L;
        this.jdField_a_of_type_Long = -1L;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.stopVideoAudio(): position " + paramInt);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
      return null;
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return null;
    }
    Object localObject;
    if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramViewGroup = ((AIOImageData)localObject).a(4);
      if (paramViewGroup != null) {
        break label968;
      }
      paramView = ((AIOImageData)localObject).a(2);
      if (paramView == null) {}
    }
    for (;;)
    {
      int i;
      if (paramViewGroup != null)
      {
        i = 1;
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
        paramViewGroup.mFailedDrawable = URLDrawableHelper.e;
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        if ((((AIOImageData)localObject).h == 1) && ((((AIOImageData)localObject).j & 0x2) == 2)) {
          paramViewGroup.mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!((AIOImageData)localObject).d)) {
          break label222;
        }
        paramView = URLDrawable.getDrawable(((AIOImageData)localObject).a(2) + "#" + "PART", paramViewGroup);
        label193:
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      }
      for (;;)
      {
        return null;
        i = 0;
        break;
        label222:
        paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
        break label193;
        if ((!((AIOImageData)localObject).jdField_c_of_type_Boolean) && (!((AIOImageData)localObject).jdField_b_of_type_Boolean) && (!((AIOImageData)localObject).jdField_a_of_type_Boolean)) {
          if (((AIOImageData)localObject).a(1) != null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mLoadingDrawable = URLDrawableHelper.e;
            paramView.mFailedDrawable = URLDrawableHelper.e;
            if ((((AIOImageData)localObject).h == 1) && ((((AIOImageData)localObject).j & 0x2) == 2)) {
              paramView.mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(((AIOImageData)localObject).a(1), paramView).startDownload();
            if ((NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!PeakUtils.a(((AIOImageData)localObject).jdField_g_of_type_Int))) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).k, 2);
            }
          }
          else if ((NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!PeakUtils.a(((AIOImageData)localObject).jdField_g_of_type_Int)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).k, 2);
            if (QLog.isDevelopLevel())
            {
              QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
              continue;
              if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
              {
                paramViewGroup = (AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                paramView = paramViewGroup.a(0);
                if (paramView != null)
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.e;
                  paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
                  paramView.startDownload();
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.jdField_b_of_type_Boolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.a(1) != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramViewGroup.jdField_f_of_type_Long, paramViewGroup.k, 0);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.d != 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramViewGroup.jdField_f_of_type_Long, paramViewGroup.k, 1);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
                  }
                }
              }
              else if (AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
              {
                localObject = (AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                paramViewGroup = ((AIOFilePicData)localObject).a(20);
                paramView = paramViewGroup;
                if (paramViewGroup == null)
                {
                  paramView = ((AIOFilePicData)localObject).a(18);
                  if (paramView == null) {}
                }
                else
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.e;
                  paramViewGroup.mPlayGifImage = true;
                  paramViewGroup.mUseExifOrientation = false;
                  paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
                  paramView.setTag(Integer.valueOf(1));
                  paramView.startDownload();
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  continue;
                }
                paramView = ((AIOFilePicData)localObject).a(16);
                if (paramView != null)
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.e;
                  URLDrawable.getDrawable(paramView, paramViewGroup).startDownload();
                  if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject).jdField_f_of_type_Long, ((AIOFilePicData)localObject).k, 18);
                  }
                }
                else if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject).jdField_f_of_type_Long, ((AIOFilePicData)localObject).k, 18);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
              }
            }
          }
        }
      }
      label968:
      paramView = paramViewGroup;
    }
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.c)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.c = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    AIORichMediaInfo localAIORichMediaInfo;
    if (URLImageView.class.isInstance(paramView))
    {
      paramViewGroup = (URLImageView)paramView;
      localAIORichMediaInfo = a(paramInt);
      if (localAIORichMediaInfo != null) {
        break label103;
      }
    }
    label103:
    do
    {
      do
      {
        AIORichMediaData localAIORichMediaData;
        do
        {
          return;
          localAIORichMediaData = localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (AIOImageData.class.isInstance(localAIORichMediaData))
          {
            if (URLDrawable.class.isInstance(((URLImageView)paramView).getDrawable())) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(localAIORichMediaInfo.hashCode());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a();
            return;
          }
        } while (!AIOShortVideoData.class.isInstance(localAIORichMediaData));
        paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (paramView == null) {
          break;
        }
        paramViewGroup.setImageDrawable(paramView);
      } while (!QLog.isColorLevel());
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
      return;
      paramViewGroup.setImageDrawable(URLDrawableHelper.e);
    } while (!QLog.isColorLevel());
    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof AbstractImageAdapter.URLImageView2))
    {
      paramView = (AbstractImageAdapter.URLImageView2)paramView;
      localObject1 = a(paramInt);
      if (localObject1 != null) {
        break label25;
      }
    }
    label25:
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((!paramBoolean) || (((AIOImageData)localObject2).a(8) == null));
      localObject1 = paramView.getDrawable();
      Object localObject2 = ((AIOImageData)localObject2).a(8);
      localObject2 = (String)localObject2 + "#" + "DISPLAY";
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject1 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      paramView.setDecodingDrawble((URLDrawable)localObject1);
      ((URLDrawable)localObject1).startDownload();
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
      return;
    } while (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
  }
  
  void a(int paramInt, ImageView paramImageView)
  {
    paramImageView = paramImageView.getDrawable();
    if (URLDrawable.class.isInstance(paramImageView)) {
      a(paramInt, (URLDrawable)paramImageView);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AIORichMediaInfo localAIORichMediaInfo;
    if ((paramView instanceof AbstractImageAdapter.URLImageView2))
    {
      paramView = (AbstractImageAdapter.URLImageView2)paramView;
      localAIORichMediaInfo = a(paramInt);
      if (localAIORichMediaInfo != null) {}
    }
    else
    {
      return;
    }
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject2 = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (paramString1 != null) {
        ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = paramString1;
      }
      if (paramString2 != null) {
        ((AIOImageData)localObject2).jdField_a_of_type_JavaLangString = paramString2;
      }
      if (((AIOImageData)localObject2).jdField_b_of_type_Boolean)
      {
        paramString1 = paramView.getDrawable();
        if (!URLDrawable.class.isInstance(paramString1)) {
          break label1234;
        }
        paramString1 = (URLDrawable)paramString1;
      }
    }
    for (paramString2 = paramString1.getURL().getRef();; paramString2 = (String)localObject1)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (((AIOImageData)localObject2).d)) {
        QQToast.a(paramView.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      label219:
      label1226:
      label1232:
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
          return;
          if (((AIOImageData)localObject2).a(2) != null)
          {
            paramString2 = ((AIOImageData)localObject2).a(2);
            paramString1 = paramString2;
            if (paramBoolean) {
              paramString1 = paramString2 + "#PART";
            }
            paramString2 = URLDrawable.URLDrawableOptions.obtain();
            paramString2.mUseExifOrientation = false;
            paramString2.mPlayGifImage = true;
            paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
            if ((paramString2.getStatus() == 1) && (!((AIOImageData)localObject2).d))
            {
              paramView.setImageDrawable(paramString2);
              a(paramInt, true);
            }
            for (;;)
            {
              paramString2 = FileUtils.a(((AIOImageData)localObject2).jdField_b_of_type_JavaLangString);
              if ("png".equals(paramString2)) {
                paramView.setTag(Integer.valueOf(102));
              }
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
              }
              ((AIOImageData)localObject2).d = paramBoolean;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
              break;
              paramString2.setTag(Integer.valueOf(1));
              paramString2.startDownload();
              paramView.setDecodingDrawble(paramString2);
            }
          }
          if (((AIOImageData)localObject2).a(1) == null) {
            continue;
          }
          paramView.setImageDrawable(URLDrawable.getDrawable(((AIOImageData)localObject2).a(1), URLDrawable.URLDrawableOptions.obtain()));
          continue;
          if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            paramString2 = (AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            if (paramString2.d == 0) {
              continue;
            }
            if (paramString2.jdField_b_of_type_Boolean)
            {
              paramView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
              a(paramInt, false);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
              continue;
            }
            paramString1 = paramString2.a(1);
            if (paramString1 != null)
            {
              paramString2 = URLDrawable.URLDrawableOptions.obtain();
              paramString2.mLoadingDrawable = URLDrawableHelper.f;
              paramString2.mUseMemoryCache = false;
              localObject1 = new VideoDrawable.VideoDrawableParams();
              ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
              ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
              ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
              paramString2.mExtraInfo = localObject1;
              paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
              if (paramString1.getStatus() == 1) {
                paramView.setImageDrawable(paramString1);
              }
              for (;;)
              {
                a(paramInt, true);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
                break;
                paramView.setDecodingDrawble(paramString1);
                paramString1.startDownload();
              }
            }
            if ((paramString2.a(0) == null) || (!QLog.isColorLevel())) {
              continue;
            }
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
            continue;
          }
          if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            localObject1 = (AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            if (((AIOFilePicData)localObject1).jdField_a_of_type_Boolean)
            {
              paramString1 = paramView.getDrawable();
              if (!URLDrawable.class.isInstance(paramString1)) {
                break label1226;
              }
              paramString1 = (URLDrawable)paramString1;
              paramString2 = paramString1.getURL().getRef();
            }
          }
        }
        for (;;)
        {
          if ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2)))) {
            break label1232;
          }
          paramView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
          a(paramInt, false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
          break label219;
          localObject2 = ((AIOFilePicData)localObject1).a(18);
          if (localObject2 == null) {
            break label219;
          }
          paramString2 = ((AIOFilePicData)localObject1).a(18);
          paramString1 = paramString2;
          if (paramBoolean) {
            paramString1 = paramString2 + "#PART";
          }
          paramString2 = URLDrawable.URLDrawableOptions.obtain();
          paramString2.mUseExifOrientation = false;
          paramString2.mPlayGifImage = true;
          paramString2 = URLDrawable.getDrawable((File)localObject2, paramString2);
          if (paramString2.getStatus() == 1)
          {
            paramView.setImageDrawable(paramString2);
            a(paramInt, true);
          }
          for (;;)
          {
            paramString2 = FileUtils.a(((AIOFilePicData)localObject1).jdField_c_of_type_JavaLangString);
            if ("png".equals(paramString2)) {
              paramView.setTag(Integer.valueOf(102));
            }
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
            break;
            paramString2.setTag(Integer.valueOf(1));
            paramString2.startDownload();
            paramView.setDecodingDrawble(paramString2);
          }
          if (!AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            break label219;
          }
          paramString2 = (AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          paramString1 = URLDrawable.URLDrawableOptions.obtain();
          paramString1.mUseExifOrientation = false;
          paramString1.mPlayGifImage = true;
          paramString2 = paramString2.a(0);
          if (paramString2 != null)
          {
            paramString1 = URLDrawable.getDrawable(paramString2, paramString1);
            if (paramString1.getStatus() == 1)
            {
              paramView.setImageDrawable(paramString1);
              a(paramInt, true);
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
              break;
              paramString1.setTag(Integer.valueOf(1));
              paramString1.startDownload();
              paramView.setDecodingDrawble(paramString1);
            }
          }
          paramView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
          a(paramInt, true);
          break label219;
          break;
          paramString2 = null;
          paramString1 = (String)localObject2;
        }
      }
      label1234:
      paramString1 = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.e) || (j != this.f))
    {
      this.e = i;
      this.f = j;
      URLDrawable.clearMemoryCache();
      a();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    a();
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(paramInt);
    Object localObject;
    if ((paramView != null) && (AbstractImageAdapter.URLImageView2.class.isInstance(paramView)))
    {
      if ((this.d != paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null)) {
        a(this.d, this.jdField_b_of_type_ComTencentImageURLDrawable);
      }
      if ((paramAdapterView == null) || (!AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        break label383;
      }
      localObject = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramAdapterView = (AbstractImageAdapter.URLImageView2)paramView;
      if ((this.d != paramInt) || (this.jdField_b_of_type_ComTencentImageURLDrawable == null) || (this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() != 1)) {
        break label137;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): Has videoDrawable cache position " + paramInt);
      }
    }
    label137:
    label383:
    do
    {
      do
      {
        do
        {
          return;
          paramView = ((AIOShortVideoData)localObject).a(1);
          if (paramView != null)
          {
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.e;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.e;
            ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
            VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
            localVideoDrawableParams.mPlayVideoFrame = true;
            localVideoDrawableParams.mPlayAudioFrame = true;
            localVideoDrawableParams.mEnableAntiAlias = true;
            localVideoDrawableParams.mEnableFilter = true;
            ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
            localObject = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject);
            if (((URLDrawable)localObject).getStatus() == 1)
            {
              paramAdapterView.setImageDrawable((Drawable)localObject);
              a(paramInt, true);
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
              this.d = paramInt;
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): video file " + paramView);
              return;
              paramAdapterView.setDecodingDrawble((URLDrawable)localObject);
              ((URLDrawable)localObject).startDownload();
            }
          }
          paramAdapterView = ((AIOShortVideoData)localObject).a(0);
        } while (paramAdapterView == null);
        this.d = -1;
        this.jdField_b_of_type_ComTencentImageURLDrawable = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOShortVideoData)localObject).jdField_f_of_type_Long, ((AIOShortVideoData)localObject).k, 1);
      } while (!QLog.isColorLevel());
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): thumb file " + paramAdapterView);
      return;
      this.d = -1;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    } while (!QLog.isColorLevel());
    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): Data is image");
  }
  
  public void a(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt1);
    if (localAIORichMediaInfo == null) {}
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
      } while (((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
      super.b(paramInt1, paramInt2);
      return;
      if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        super.b(paramInt1, paramInt2);
        return;
      }
    } while (!AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    super.b(paramInt1, paramInt2);
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (paramInt == this.c)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.c = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, a());
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    a(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbstractImageAdapter.URLImageView2 localURLImageView2 = (AbstractImageAdapter.URLImageView2)paramView;
    paramView = localURLImageView2.getDrawable();
    paramViewGroup = localURLImageView2.jdField_a_of_type_ComTencentImageURLDrawable;
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.c) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label152;
        }
        paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
          {
            QLog.d("AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
        if (paramView.getStatus() != 1) {
          break label280;
        }
        localURLImageView2.jdField_a_of_type_Boolean = true;
        localURLImageView2.setImageDrawable(paramView);
        localURLImageView2.jdField_a_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      paramView = a(paramInt);
      if (paramView != null) {
        break label293;
      }
      return;
      label152:
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
        QLog.d("AIOGalleryAdapter", 2, "rawDrawable is exist");
      }
      paramView = paramView.toString() + "#" + "NOSAMPLE";
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mUseExifOrientation = false;
      paramViewGroup.mUseMemoryCache = false;
      paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
      paramViewGroup.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
      this.c = paramInt;
      paramView = paramViewGroup;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
      paramView = paramViewGroup;
      break;
      label280:
      localURLImageView2.setDecodingDrawble(paramView);
      paramView.startDownload();
    }
    label293:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c(paramView.hashCode());
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 1;
    if (paramView != null) {}
    label16:
    AIOGalleryAdapter.GalleryURLImageView localGalleryURLImageView;
    Object localObject2;
    AIOImageData localAIOImageData;
    Object localObject1;
    boolean bool1;
    for (;;)
    {
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): position=" + paramInt);
      }
      localGalleryURLImageView = new AIOGalleryAdapter.GalleryURLImageView(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
      localGalleryURLImageView.setAdjustViewBounds(true);
      localObject2 = a(paramInt);
      paramView = localGalleryURLImageView;
      if (localObject2 != null)
      {
        if (!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label2061;
        }
        localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localGalleryURLImageView.jdField_a_of_type_Int = paramInt;
        localGalleryURLImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject2);
        localGalleryURLImageView.jdField_a_of_type_Boolean = false;
        paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
        {
          localGalleryURLImageView.setImageDrawable(paramViewGroup);
          paramView = localAIOImageData.a(4);
          localObject1 = paramViewGroup.getURL().toString();
          if (((String)localObject1).equals(paramView)) {
            localGalleryURLImageView.jdField_b_of_type_Boolean = true;
          }
          if (((AIORichMediaInfo)localObject2).b == -2) {}
          try
          {
            ((AIORichMediaInfo)localObject2).b = JpegExifReader.readOrientation(paramViewGroup.getURL().getFile());
            a(localGalleryURLImageView, paramViewGroup, ((AIORichMediaInfo)localObject2).b);
            if (localGalleryURLImageView.jdField_b_of_type_Boolean)
            {
              paramView = localAIOImageData.jdField_c_of_type_JavaLangString;
              paramView = FileUtils.a(paramView);
              if ("png".equals(paramView)) {
                localGalleryURLImageView.setTag(Integer.valueOf(102));
              }
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): cache url is " + (String)localObject1 + ", cache type is " + localAIOImageData.a(paramViewGroup.getURL().getFile()) + ",extName = + " + paramView);
              }
              if (localAIOImageData.d) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k, 2);
              }
              if (!localGalleryURLImageView.jdField_b_of_type_Boolean) {
                break label575;
              }
              paramView = "original";
              bool1 = true;
              paramInt = i;
              label373:
              if (paramInt != 0)
              {
                paramInt = localObject2.hashCode();
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Int = paramInt;
                paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a();
                paramViewGroup.a(paramInt);
                paramViewGroup.a(paramInt, localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_b_of_type_Long);
                paramViewGroup.b(paramInt, PeakUtils.a(localAIOImageData.jdField_g_of_type_Int));
                if (localAIOImageData.e) {
                  paramViewGroup.d(paramInt);
                }
                if (paramView != null)
                {
                  paramViewGroup.a(paramInt, paramView);
                  paramViewGroup.a(paramInt, bool1);
                }
              }
              paramViewGroup = localAIOImageData.jdField_f_of_type_Long + "_" + localAIOImageData.k;
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramViewGroup)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k);
              this.jdField_a_of_type_JavaUtilArrayList.add(paramViewGroup);
              return localGalleryURLImageView;
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AIOGalleryAdapter", 2, "read exif error", paramView);
              }
              ((AIORichMediaInfo)localObject2).b = 1;
              continue;
              paramView = localAIOImageData.jdField_b_of_type_JavaLangString;
              continue;
              label575:
              paramView = "large";
            }
          }
        }
      }
    }
    paramView = localAIOImageData.a(4);
    if (paramView == null)
    {
      paramViewGroup = localAIOImageData.a(2);
      if (paramViewGroup == null) {}
    }
    for (;;)
    {
      if (paramView != null)
      {
        bool2 = true;
        label611:
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = this.e;
        paramView.mRequestHeight = this.f;
        paramView.mLoadingDrawable = URLDrawableHelper.e;
        paramView.mPlayGifImage = true;
        paramView.mUseExifOrientation = false;
        if ((localAIOImageData.h == 1) && ((localAIOImageData.j & 0x2) == 2)) {
          paramView.mUseAutoScaleParams = false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView == null) {
            break label1049;
          }
          paramView.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView.getDrawable();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = null;
        }
        label706:
        if (bool2) {
          break label1081;
        }
      }
      for (;;)
      {
        try
        {
          if (localAIOImageData.d)
          {
            localObject1 = URLDrawable.getDrawable(localAIOImageData.a(2) + "#" + "PART", paramView);
            ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
            if (!((URLDrawable)localObject1).isDownloadStarted()) {
              break label3357;
            }
            if (BaseApplicationImpl.a.get(((URLDrawable)localObject1).getURL().toString()) == null) {
              break label1113;
            }
            bool1 = true;
            if (!bool2) {
              break label1119;
            }
            paramView = "original";
          }
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            localGalleryURLImageView.setImageDrawable((Drawable)localObject1);
            localGalleryURLImageView.jdField_b_of_type_Boolean = bool2;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              ((URLDrawable)localObject1).downloadImediatly();
            }
            if (!bool2) {
              break label1208;
            }
            paramViewGroup = localAIOImageData.jdField_c_of_type_JavaLangString;
            paramViewGroup = FileUtils.a(paramViewGroup);
            if ("png".equals(paramViewGroup)) {
              localGalleryURLImageView.setTag(Integer.valueOf(102));
            }
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + ((URLDrawable)localObject1).getURL().toString() + ", file type is " + localAIOImageData.a(((URLDrawable)localObject1).getURL().toString()) + ",extName = " + paramViewGroup);
            }
            if ((bool2) || (!localAIOImageData.d) || (localAIOImageData.jdField_b_of_type_Boolean)) {
              break label1217;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k, 2);
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
            }
            paramInt = i;
            break label373;
            bool2 = false;
            break label611;
            label1049:
            if (BaseApplicationImpl.a.get(localAIOImageData.a(1)) == null) {
              break label706;
            }
            paramView.mLoadingDrawable = URLDrawable.getDrawable(localAIOImageData.a(1), null);
            break label706;
            label1081:
            localObject1 = URLDrawable.getDrawable(paramViewGroup, paramView);
            continue;
            if (!QLog.isColorLevel()) {
              break label16;
            }
          }
        }
        catch (Throwable paramView)
        {
          paramView = localGalleryURLImageView;
        }
        QLog.e("AIOGalleryAdapter", 2, "[getView] URLDrawable.getDrawable failed.");
        return localGalleryURLImageView;
        label1113:
        bool1 = false;
        continue;
        label1119:
        paramView = "large";
        continue;
        if (((AIORichMediaInfo)localObject2).b == -2) {}
        try
        {
          ((AIORichMediaInfo)localObject2).b = JpegExifReader.readOrientation(paramViewGroup.getAbsolutePath());
          a(localGalleryURLImageView, (URLDrawable)localObject1, ((AIORichMediaInfo)localObject2).b);
          if (((URLDrawable)localObject1).getStatus() == 1) {
            bool3 = true;
          }
          a(paramInt, bool3);
        }
        catch (Exception paramViewGroup)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AIOGalleryAdapter", 2, "read exif error", paramViewGroup);
            }
            ((AIORichMediaInfo)localObject2).b = 1;
          }
        }
        label1208:
        paramViewGroup = localAIOImageData.jdField_b_of_type_JavaLangString;
        continue;
        label1217:
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
          continue;
          if (localAIOImageData.a(8) != null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mLoadingDrawable = URLDrawableHelper.e;
            paramView.mFailedDrawable = URLDrawableHelper.e;
            paramView.mUseExifOrientation = false;
            if ((localAIOImageData.h == 1) && ((localAIOImageData.j & 0x2) == 2)) {
              paramView.mUseAutoScaleParams = false;
            }
            localGalleryURLImageView.setImageDrawable(URLDrawable.getDrawable(localAIOImageData.a(8), paramView));
            a(paramInt, ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int / 100);
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localAIOImageData.a(8) + ", file type is " + 8);
            }
            if (!localAIOImageData.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k, 2);
            }
            for (;;)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(true);
              }
              if ((QLog.isDevelopLevel()) && (localAIOImageData.d)) {
                QQToast.a(localGalleryURLImageView.getContext(), "Refresh temp display image", 2000).a();
              }
              paramView = null;
              bool1 = false;
              paramInt = i;
              break;
              if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
              }
            }
          }
          if ((localAIOImageData.jdField_c_of_type_Boolean) || (localAIOImageData.jdField_b_of_type_Boolean) || (localAIOImageData.jdField_a_of_type_Boolean)) {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView != null))
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView.getDrawable();
              localGalleryURLImageView.setImageDrawable(paramView);
              if (URLDrawable.class.isInstance(paramView)) {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)paramView);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = null;
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): IMAGE_FILE_ERROR");
              paramView = null;
              bool1 = false;
              paramInt = 0;
              break;
              localGalleryURLImageView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
              a(paramInt, false);
              continue;
              if (localAIOImageData.a(1) != null)
              {
                paramView = URLDrawable.URLDrawableOptions.obtain();
                paramView.mLoadingDrawable = URLDrawableHelper.e;
                paramView.mFailedDrawable = URLDrawableHelper.e;
                if ((localAIOImageData.h == 1) && ((localAIOImageData.j & 0x2) == 2)) {
                  paramView.mUseAutoScaleParams = false;
                }
                paramView = URLDrawable.getDrawable(localAIOImageData.a(1), paramView);
                localGalleryURLImageView.setImageDrawable(paramView);
                if (!localAIOImageData.jdField_g_of_type_Boolean)
                {
                  paramView.downloadImediatly();
                  a(paramInt, ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int / 100);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k, 2);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localAIOImageData.a(1) + ", file type is " + 1);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(localAIOImageData.jdField_f_of_type_Boolean);
                  }
                }
                for (;;)
                {
                  paramView = null;
                  bool1 = false;
                  paramInt = i;
                  break;
                  paramView = TroopMemberApiClient.a();
                  paramView.a();
                  paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_JavaLangString, localAIOImageData, new nsy(this, paramInt, localGalleryURLImageView));
                }
              }
              a(paramInt, ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int / 100);
              localGalleryURLImageView.setImageDrawable(URLDrawableHelper.e);
              if (localAIOImageData.jdField_g_of_type_Boolean) {
                break label2002;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.k, 2);
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): No pic");
              }
            }
          }
          for (;;)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(localAIOImageData.jdField_f_of_type_Boolean);
            }
            paramView = null;
            bool1 = false;
            paramInt = 0;
            break;
            label2002:
            paramView = TroopMemberApiClient.a();
            paramView.a();
            paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_JavaLangString, localAIOImageData, new nta(this, paramInt, localGalleryURLImageView));
            paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_JavaLangString, localAIOImageData, new ntc(this, paramInt, localGalleryURLImageView));
          }
          label2061:
          if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            paramView = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
            localGalleryURLImageView.jdField_a_of_type_Int = paramInt;
            localGalleryURLImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject2);
            if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
            {
              localGalleryURLImageView.setImageDrawable(paramViewGroup);
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): video cache url is " + paramViewGroup.getURL());
              }
            }
            for (;;)
            {
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
                break;
              }
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_Boolean) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
              return localGalleryURLImageView;
              paramViewGroup = paramView.a(0);
              if (paramViewGroup != null)
              {
                if ((this.d == paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null))
                {
                  localGalleryURLImageView.setImageDrawable(this.jdField_b_of_type_ComTencentImageURLDrawable);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): load thumb and videoDrawable exist, position is " + paramInt);
                  }
                }
                else
                {
                  paramView = URLDrawable.URLDrawableOptions.obtain();
                  paramView.mLoadingDrawable = URLDrawableHelper.e;
                  paramView.mFailedDrawable = URLDrawableHelper.e;
                  paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
                  localGalleryURLImageView.setImageDrawable(paramView);
                  if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
                    paramView.downloadImediatly();
                  }
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): load thumb, position is " + paramInt);
                  }
                }
              }
              else if (paramView.a(1) != null)
              {
                localGalleryURLImageView.setImageDrawable(URLDrawableHelper.e);
                if (QLog.isColorLevel()) {
                  QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): only video exist, position is " + paramInt);
                }
              }
              else if ((paramView.jdField_a_of_type_Boolean) || (paramView.jdField_b_of_type_Boolean))
              {
                localGalleryURLImageView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837568));
                a(paramInt, false);
                if (QLog.isColorLevel()) {
                  QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): MEDIA_FILE_ERROR");
                }
              }
              else
              {
                a(paramInt, ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int / 100);
                localGalleryURLImageView.setImageDrawable(URLDrawableHelper.e);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramView.jdField_f_of_type_Long, paramView.k, 1);
                if (QLog.isColorLevel()) {
                  QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): video and thumb not exist, download video, position is " + paramInt);
                }
              }
            }
          }
          paramView = localGalleryURLImageView;
          if (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            break;
          }
          localObject1 = (AIOFilePicData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localGalleryURLImageView.jdField_a_of_type_Int = paramInt;
          localGalleryURLImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject2);
          localGalleryURLImageView.jdField_a_of_type_Boolean = false;
          paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
          if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
          {
            localGalleryURLImageView.setImageDrawable(paramViewGroup);
            paramView = ((AIOFilePicData)localObject1).a(20);
            str = paramViewGroup.getURL().toString();
            if (str.equals(paramView)) {
              localGalleryURLImageView.jdField_b_of_type_Boolean = true;
            }
            if (((AIORichMediaInfo)localObject2).b == -2) {
              ((AIORichMediaInfo)localObject2).b = JpegExifReader.readOrientation(paramViewGroup.getURL().getFile());
            }
            a(localGalleryURLImageView, paramViewGroup, ((AIORichMediaInfo)localObject2).b);
            if (localGalleryURLImageView.jdField_b_of_type_Boolean) {}
            for (paramView = ((AIOFilePicData)localObject1).d;; paramView = ((AIOFilePicData)localObject1).jdField_c_of_type_JavaLangString)
            {
              localObject2 = FileUtils.a(paramView);
              if ("png".equals(localObject2)) {
                localGalleryURLImageView.setTag(Integer.valueOf(102));
              }
              paramView = localGalleryURLImageView;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): cache url is " + str + ", cache type is " + ((AIOFilePicData)localObject1).a(paramViewGroup.getURL().getFile()) + ",extName = + " + (String)localObject2);
              return localGalleryURLImageView;
            }
          }
          paramViewGroup = ((AIOFilePicData)localObject1).a(20);
          if (paramViewGroup == null)
          {
            paramView = ((AIOFilePicData)localObject1).a(18);
            if (paramView == null) {}
          }
          for (;;)
          {
            if (paramViewGroup != null)
            {
              bool1 = true;
              label2842:
              paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
              paramViewGroup.mRequestWidth = this.e;
              paramViewGroup.mRequestHeight = this.f;
              paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
              paramViewGroup.mPlayGifImage = true;
              paramViewGroup.mUseExifOrientation = false;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView != null))
              {
                paramViewGroup.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView.getDrawable();
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = null;
              }
              paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
              paramViewGroup.setTag(Integer.valueOf(1));
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramViewGroup);
              switch (paramViewGroup.getStatus())
              {
              default: 
                label2964:
                localGalleryURLImageView.setImageDrawable(paramViewGroup);
                localGalleryURLImageView.jdField_b_of_type_Boolean = bool1;
                if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
                  paramViewGroup.downloadImediatly();
                }
                if (!bool1) {
                  break;
                }
              }
            }
            for (paramView = ((AIOFilePicData)localObject1).d;; paramView = ((AIOFilePicData)localObject1).jdField_c_of_type_JavaLangString)
            {
              if ("png".equals(FileUtils.a(paramView))) {
                localGalleryURLImageView.setTag(Integer.valueOf(102));
              }
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
                break;
              }
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_Boolean) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
              return localGalleryURLImageView;
              bool1 = false;
              break label2842;
              if (((AIORichMediaInfo)localObject2).b == -2) {
                ((AIORichMediaInfo)localObject2).b = JpegExifReader.readOrientation(paramView.getAbsolutePath());
              }
              a(localGalleryURLImageView, paramViewGroup, ((AIORichMediaInfo)localObject2).b);
              if (paramViewGroup.getStatus() == 1) {
                bool2 = true;
              }
              a(paramInt, bool2);
              break label2964;
            }
            paramView = ((AIOFilePicData)localObject1).a(16);
            if (paramView != null)
            {
              paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
              paramViewGroup.mLoadingDrawable = URLDrawableHelper.e;
              paramViewGroup.mFailedDrawable = URLDrawableHelper.e;
              paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
              localGalleryURLImageView.setImageDrawable(paramView);
              paramView.downloadImediatly();
              a(paramInt, ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int / 100);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject1).jdField_f_of_type_Long, ((AIOFilePicData)localObject1).k, 18);
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + ((AIOFilePicData)localObject1).a(16) + ", file type is " + 16);
              }
              paramView = localGalleryURLImageView;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
              return localGalleryURLImageView;
            }
            localGalleryURLImageView.setImageDrawable(URLDrawableHelper.e);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject1).jdField_f_of_type_Long, ((AIOFilePicData)localObject1).k, 18);
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): No pic");
            }
            paramView = localGalleryURLImageView;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              break;
            }
            return localGalleryURLImageView;
            paramView = paramViewGroup;
          }
          label3357:
          bool1 = false;
          paramView = str;
        }
      }
      paramViewGroup = paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOGalleryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
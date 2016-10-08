package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import vtp;

public class TroopAvatarBigPhotoAdapter
  extends BaseAdapter
{
  public static final String a = "TroopAvatarBigPhotoAdapter";
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  protected List a;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  
  public TroopAvatarBigPhotoAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.c = null;
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131492943));
  }
  
  private URL a(URL paramURL)
  {
    URL localURL = paramURL;
    if (!TextUtils.isEmpty(this.c))
    {
      localURL = paramURL;
      if ("2000".equals(this.c))
      {
        localURL = paramURL;
        if (paramURL.getProtocol().startsWith("http")) {
          localURL = PubAccountHttpDownloader.a(paramURL.toString(), 2);
        }
      }
    }
    return localURL;
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    label46:
    label246:
    do
    {
      do
      {
        return;
        localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
        localImageProgressCircle = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
        localObject = a(paramInt);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewHolder = (TroopAvatarBigPhotoAdapter.ViewHolder)localObject;
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + paramViewHolder);
        }
        String str = Uri.parse(paramViewHolder).getScheme();
        if ((!TextUtils.isEmpty(str)) && ((str.equals("http")) || (str.equals("https")))) {
          break label246;
        }
      }
      for (;;)
      {
        try
        {
          paramViewHolder = new File(paramViewHolder).toURL();
          paramViewHolder = a(paramViewHolder);
          if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType != 0)) || (localObject == null) || (!((String)localObject).equals(AvatarWallAdapter.AvatarInfo.a))) {
            break label276;
          }
          localURLImageView.setImageResource(2130839408);
          return;
        }
        catch (MalformedURLException paramViewHolder) {}
        if (AvatarTroopUtil.b((String)localObject))
        {
          if ((localObject != null) && (((String)localObject).equals(AvatarWallAdapter.AvatarInfo.a)))
          {
            paramViewHolder = AvatarTroopUtil.a((String)localObject, this.jdField_b_of_type_JavaLangString, 0);
            paramViewHolder = AvatarTroopUtil.b(paramViewHolder);
            break label46;
          }
          paramViewHolder = AvatarTroopUtil.a((String)localObject, this.jdField_b_of_type_JavaLangString, 1);
          continue;
        }
        paramViewHolder = (TroopAvatarBigPhotoAdapter.ViewHolder)localObject;
        break label46;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        return;
        try
        {
          paramViewHolder = new URL(paramViewHolder);
        }
        catch (MalformedURLException paramViewHolder) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
    return;
    label276:
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.e;
    if (this.jdField_b_of_type_Boolean) {
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    }
    localURLImageView.setImageDrawable(URLDrawable.getDrawable(paramViewHolder, (URLDrawable.URLDrawableOptions)localObject));
    a(localImageProgressCircle);
    localURLImageView.setURLDrawableDownListener(new vtp(this, localImageProgressCircle, localURLImageView));
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString, Setting paramSetting)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130905052, null);
      paramView = new TroopAvatarBigPhotoAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131296303));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131296302));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramInt, paramViewGroup);
      return localView;
      paramViewGroup = (TroopAvatarBigPhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopAvatarBigPhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nvi;
import nvj;
import nvk;

public class PhotoListPanel$MyAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  public ArrayList a;
  int b;
  int c;
  int d;
  
  public PhotoListPanel$MyAdapter(PhotoListPanel paramPhotoListPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = AIOUtils.a(4.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.b = i;
    this.c = i;
    this.jdField_a_of_type_Int = AIOUtils.a(27.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.d = AIOUtils.a(57.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.a(paramString);
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return (LocalMediaInfo)localObject1;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)localIterator.next();
    } while (!localLocalMediaInfo.jdField_a_of_type_JavaLangString.equals(paramString));
    for (paramString = localLocalMediaInfo;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LocalMediaInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView1.post(new nvk(this, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramView1));
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      PhotoListPanel.g = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131367225), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });
    }
    for (;;)
    {
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131367226);
    }
  }
  
  public void b(List paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidOsHandler.post(new nvj(this, paramList));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.a(a(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("check", 2, "getView position=" + paramInt);
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    label374:
    int i;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904282, paramViewGroup, false);
      paramView = new PhotoListPanel.MyAdapter.Holder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131302156));
      paramView.jdField_a_of_type_Nvi = new nvi(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramViewGroup.findViewById(2131297854));
      a(paramViewGroup, paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_a_of_type_Int, this.b, this.c, this.d);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramView.jdField_a_of_type_Nvi);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k) && (paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302158));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131302157));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_Nvi.a(paramInt);
      paramView.jdField_a_of_type_Nvi.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      localObject1 = a(paramInt);
      localObject2 = paramView.jdField_a_of_type_ComTencentImageURLImageView;
      Object localObject4 = new EmptyDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h, ((LocalMediaInfo)localObject1).f, ((LocalMediaInfo)localObject1).g);
      EmptyDrawable localEmptyDrawable = new EmptyDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i, ((LocalMediaInfo)localObject1).f, ((LocalMediaInfo)localObject1).g);
      URL localURL = AlbumUtil.a((LocalMediaInfo)localObject1, "FLOW_THUMB");
      localObject3 = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURL != null) && ((localObject3 == null) || (!((URLDrawable)localObject3).getURL().equals(localURL))))
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if ((((LocalMediaInfo)localObject1).f <= 0) || (((LocalMediaInfo)localObject1).g <= 0)) {
          break label565;
        }
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
        localURLDrawableOptions.mFailedDrawable = localEmptyDrawable;
        localObject4 = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        ((URLDrawable)localObject4).setTag(localObject1);
        ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
        paramView.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
        if (localObject3 != null) {
          ((URLDrawable)localObject3).cancelDownload(true);
        }
      }
      localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
      localObject3 = paramView.b;
      ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
      if (!((LocalMediaInfo)localObject1).jdField_a_of_type_Boolean) {
        break label592;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).jdField_a_of_type_JavaLangString);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
      label480:
      localObject3 = paramView.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label607;
      }
      ((ImageView)localObject3).setVisibility(4);
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        paramViewGroup.setContentDescription(PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt));
        localObject1 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      return paramViewGroup;
      localObject1 = (PhotoListPanel.MyAdapter.Holder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      break;
      label565:
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b;
      break label374;
      label592:
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label480;
      label607:
      if (i == 1) {
        ((ImageView)localObject3).setVisibility(0);
      } else {
        ((ImageView)localObject3).setVisibility(4);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\PhotoListPanel$MyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
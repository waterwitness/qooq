package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;
import txn;

public class VipPhotoViewForSimple$PhotoAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List jdField_a_of_type_JavaUtilList;
  
  public VipPhotoViewForSimple$PhotoAdapter(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple)) {
        this.jdField_a_of_type_JavaUtilList.add(new QzonePhotoView.PhotoInfo(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      paramList.j = 102;
      this.jdField_a_of_type_JavaUtilList.set(i - 1, paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new txn(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904610, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.g, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.h));
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131303336));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      paramViewGroup.a.setOnClickListener(VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
      if (localObject1 != null)
      {
        if ((((QzonePhotoView.PhotoInfo)localObject1).j != 100) && (((QzonePhotoView.PhotoInfo)localObject1).j != 102)) {
          break label271;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label238;
        }
        paramView.setBackground(null);
        paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    label238:
    Object localObject2;
    label271:
    while (((QzonePhotoView.PhotoInfo)localObject2).j != 101) {
      try
      {
        localObject1 = new URL("qzone_cover", "original", ((QzonePhotoView.PhotoInfo)localObject1).a());
        if (localObject1 != null) {
          paramViewGroup.a.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.g, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.h));
        }
        return paramView;
        paramViewGroup = (txn)paramView.getTag();
        break;
        paramView.setBackgroundDrawable(null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, localException.toString());
          }
          localObject2 = null;
        }
      }
    }
    paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER);
    ProfileCardTemplate.a(paramViewGroup.a, "src", VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a, "simpleGridAddSrc");
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\VipPhotoViewForSimple$PhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
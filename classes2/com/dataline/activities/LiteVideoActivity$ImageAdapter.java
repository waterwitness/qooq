package com.dataline.activities;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import ce;
import com.dataline.util.file.ImageInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiteVideoActivity$ImageAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public LiteVideoActivity$ImageAdapter(LiteVideoActivity paramLiteVideoActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a();
  }
  
  private void a(List paramList)
  {
    Collections.sort(paramList, LiteVideoActivity.a());
  }
  
  public ImageInfo a(int paramInt)
  {
    return (ImageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public URL a(String paramString)
  {
    try
    {
      paramString = new URL("videothumb", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    List localList = MediaStoreUtil.b(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.getApplicationContext(), "1=1 )GROUP BY (_data", 0);
    if (localList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localList);
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageInfo localImageInfo = a(paramInt);
    Object localObject1;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903280, null);
      localObject1 = new ce(this);
      ((ce)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296844));
      ((ce)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297963));
      ((ce)localObject1).b = ((ImageView)paramViewGroup.findViewById(2131297964));
      paramViewGroup.setTag(localObject1);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.a, this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.b));
      ((ce)localObject1).jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      ((ce)localObject1).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.getResources().getDrawable(2130842111);
      Object localObject2 = a(localImageInfo.a());
      if (localObject2 != null)
      {
        paramView = URLDrawable.getDrawable((URL)localObject2, paramView, paramView, false);
        ((ce)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      }
      ((ce)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localImageInfo.d());
      if (!LiteVideoActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity, localImageInfo)) {
        break;
      }
      ((ce)localObject1).b.setVisibility(0);
      return paramViewGroup;
      localObject2 = (ce)paramView.getTag();
      localObject1 = localObject2;
      paramViewGroup = paramView;
      if (LiteVideoActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity))
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.a, this.jdField_a_of_type_ComDatalineActivitiesLiteVideoActivity.b));
        localObject1 = localObject2;
        paramViewGroup = paramView;
      }
    }
    ((ce)localObject1).b.setVisibility(4);
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\LiteVideoActivity$ImageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
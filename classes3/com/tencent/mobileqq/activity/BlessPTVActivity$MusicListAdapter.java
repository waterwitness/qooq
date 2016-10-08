package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import krd;

public class BlessPTVActivity$MusicListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BlessPTVActivity.MusicItemData jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData;
  private List jdField_a_of_type_JavaUtilList;
  
  public BlessPTVActivity$MusicListAdapter(Context paramContext, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {}
    for (int i = paramList.size();; i = 8)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(i);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      return;
    }
  }
  
  private void a(BlessPTVActivity.MusicItemData paramMusicItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = paramMusicItemData;
  }
  
  public int a(BlessPTVActivity.MusicItemData paramMusicItemData)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramMusicItemData);
  }
  
  public BlessPTVActivity.MusicItemData a(int paramInt)
  {
    return (BlessPTVActivity.MusicItemData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.get(paramInt) != null) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BlessPTVActivity.MusicItemData localMusicItemData = a(paramInt);
    if (localMusicItemData == null)
    {
      if (paramView != null) {
        return paramView;
      }
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903110, paramViewGroup, false);
    }
    View localView;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903111, paramViewGroup, false);
      paramView = new krd(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297170));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297173));
      paramView.b = ((ImageView)localView.findViewById(2131297172));
      paramView.c = ((ImageView)localView.findViewById(2131297171));
      paramView.d = ((ImageView)localView.findViewById(2131297174));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (localMusicItemData.jdField_a_of_type_Int != -1) {
        break label333;
      }
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      label175:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localMusicItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemData.jdField_a_of_type_JavaLangString);
      if (localMusicItemData.b <= 0) {
        break label363;
      }
      if (localMusicItemData.b != 1) {
        break label347;
      }
      i = 2130837987;
    }
    for (;;)
    {
      label220:
      paramViewGroup.b.setImageResource(i);
      paramViewGroup.b.setVisibility(0);
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == a(paramInt).jdField_a_of_type_Int))
        {
          if (localMusicItemData.jdField_a_of_type_Int == 0)
          {
            paramViewGroup.c.setImageResource(2130837997);
            paramViewGroup.c.setVisibility(0);
            paramViewGroup.d.setImageResource(2130837965);
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12b7f5"));
            return localView;
            paramViewGroup = (krd)paramView.getTag();
            localView = paramView;
            break;
            label333:
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
            break label175;
            label347:
            if (localMusicItemData.b != 2) {
              break label461;
            }
            i = 2130837986;
            break label220;
            label363:
            paramViewGroup.b.setVisibility(8);
            continue;
          }
          paramViewGroup.c.setImageResource(2130837996);
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.d.setImageResource(2130837964);
          paramViewGroup.d.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427711));
          return localView;
        }
      }
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return localView;
      label461:
      i = 0;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\BlessPTVActivity$MusicListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
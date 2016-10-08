package com.tencent.biz.qqstory.takevideo.poilist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class QQStoryPoiListAdapter
  extends XBaseAdapter
{
  public static final TroopBarPOI a;
  protected LayoutInflater a;
  protected ArrayList a;
  protected TroopBarPOI b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", "不显示位置", 0, "", 0, "");
  }
  
  public QQStoryPoiListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(ArrayList paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    if ((paramTroopBarPOI != null) && (paramArrayList != null) && (paramArrayList.remove(paramTroopBarPOI))) {
      paramArrayList.add(0, paramTroopBarPOI);
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = paramTroopBarPOI;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopBarPOI localTroopBarPOI;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904475, null);
      paramViewGroup = new QQStoryPoiListAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302861));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302860));
      paramView.setTag(paramViewGroup);
      localTroopBarPOI = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.j);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (!localTroopBarPOI.equals(this.b)) {
        break label135;
      }
    }
    label135:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      paramView.setContentDescription(localTroopBarPOI.j);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      return paramView;
      paramViewGroup = (QQStoryPoiListAdapter.ViewHolder)paramView.getTag();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\poilist\QQStoryPoiListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
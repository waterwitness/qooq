package com.tencent.biz.pubaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class PublicAccountBrowser$ActionSheetItemAdapter
  extends ArrayAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public PublicAccountBrowser$ActionSheetItemAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public PublicAccountBrowser.ActionSheetItem a(int paramInt)
  {
    return (PublicAccountBrowser.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903347, null);
      paramViewGroup = new PublicAccountBrowser.ActionSheetItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298205));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298206));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      PublicAccountBrowser.ActionSheetItem localActionSheetItem = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$ActionSheetItem = localActionSheetItem;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localActionSheetItem.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localActionSheetItem.u);
      return paramView;
      paramViewGroup = (PublicAccountBrowser.ActionSheetItemViewHolder)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountBrowser$ActionSheetItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
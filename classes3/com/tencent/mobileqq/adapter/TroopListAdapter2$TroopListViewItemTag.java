package com.tencent.mobileqq.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Switch;

public class TroopListAdapter2$TroopListViewItemTag
  extends FacePreloadBaseAdapter.ViewHolder
{
  public View a;
  public ImageView a;
  public TextView a;
  public TroopListAdapter2.TroopListItem a;
  public Switch a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  
  public TroopListAdapter2$TroopListViewItemTag(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = ((ImageView)paramView.findViewById(2131296790));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299498));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305163));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297741));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297746));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299716));
    this.d.setClickable(false);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131305166));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299653);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299652));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapter2$TroopListViewItemTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
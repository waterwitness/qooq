package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectMemberActivity$GridViewAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public SelectMemberActivity$GridViewAdapter(SelectMemberActivity paramSelectMemberActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840575);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() > 0))
      {
        String str = ((ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() - 1)).jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
          if ((i == 8) || (i == 9) || (i == 6) || (i == 5) || (i == 7) || (i == 2) || (i == 0) || (i == 10)) {
            ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
          }
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
          ((ImageView)localView.findViewById(2131296814)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.next();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.contains(localResultRecord)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.add(localResultRecord);
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size())) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903380, null);
    }
    paramViewGroup.setTag(localResultRecord);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131296814);
    if (paramInt == getCount() - 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localImageView.setImageDrawable(paramView);
        label75:
        localImageView.setBackgroundDrawable(null);
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label189;
        }
      }
    }
    TextView localTextView;
    label189:
    for (paramInt = 11;; paramInt = 1)
    {
      localTextView = (TextView)paramViewGroup.findViewById(2131297782);
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label194;
      }
      localImageView.setImageResource(2130839106);
      localTextView.setVisibility(0);
      localTextView.setText(ContactUtils.a(localResultRecord.b));
      if (AppSetting.j) {
        localImageView.setContentDescription(localResultRecord.b + " 已选中,双击删除,按钮");
      }
      return paramViewGroup;
      paramView = null;
      break;
      localImageView.setImageDrawable(null);
      break label75;
    }
    label194:
    String str = localResultRecord.jdField_a_of_type_JavaLangString;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, str);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, paramInt, true);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b;
    }
    for (;;)
    {
      localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramView));
      localTextView.setVisibility(8);
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\SelectMemberActivity$GridViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
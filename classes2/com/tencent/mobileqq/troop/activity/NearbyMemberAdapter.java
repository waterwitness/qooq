package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vek;
import vel;

public class NearbyMemberAdapter
  extends BaseAdapter
{
  protected static final String a = "NearbyMemberAdapter";
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected QQAppInterface a;
  public NearbyMemberAdapter.OnClickOnMemberListener a;
  public NearbyMemberAdapter.OnClickSayHelloListener a;
  protected List a;
  protected View.OnClickListener b;
  
  public NearbyMemberAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vek(this);
    this.b = new vel(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int a(long paramLong)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (((NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void a(NearbyMemberAdapter.OnClickOnMemberListener paramOnClickOnMemberListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter$OnClickOnMemberListener = paramOnClickOnMemberListener;
  }
  
  public void a(NearbyMemberAdapter.OnClickSayHelloListener paramOnClickSayHelloListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter$OnClickSayHelloListener = paramOnClickSayHelloListener;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount() - 1)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1)) {
      return -1L;
    }
    return ((NearbyMember)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Long;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    NearbyMember localNearbyMember = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localNearbyMember == null) {
      return null;
    }
    if (paramView == null) {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903921, paramViewGroup, false);
    }
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (NearbyMemberAdapter.ViewHolder)paramView.getTag();
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null)
      {
        paramViewGroup = new NearbyMemberAdapter.ViewHolder();
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300661));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300662));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299086));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299849));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300660));
        paramViewGroup.jdField_a_of_type_JavaLangString = (localNearbyMember.jdField_a_of_type_Long + "");
        paramView.setTag(paramViewGroup);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramViewGroup.jdField_a_of_type_JavaLangString, (byte)3, true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localNearbyMember.jdField_a_of_type_JavaLangString);
      localObject = TroopMemberLbsHelper.a(localNearbyMember.c);
      localObject = String.format("%d岁 %s", new Object[] { Integer.valueOf(localNearbyMember.d), localObject });
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (localNearbyMember.e == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840198);; localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840199))
      {
        ((Drawable)localObject).setLevel(1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localNearbyMember);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localNearbyMember);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.b);
        long l2 = System.currentTimeMillis();
        paramViewGroup = paramView;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("NearbyMemberAdapter", 2, "getView:" + paramInt + ", " + (l2 - l1) + "," + bool);
        return paramView;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
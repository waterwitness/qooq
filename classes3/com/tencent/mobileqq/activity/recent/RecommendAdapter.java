package com.tencent.mobileqq.activity.recent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oyi;

public class RecommendAdapter
  extends PagerAdapter
{
  private static final int jdField_a_of_type_Int = 50;
  public static final String a = "RecommendAdapter";
  private static final int jdField_b_of_type_Int = 7;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int[] jdField_b_of_type_ArrayOfInt;
  private final int[] c;
  
  public RecommendAdapter(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131297720, 2131297721, 2131297722, 2131297723, 2131297724, 2131297725, 2131297726 };
    this.b = new int[] { 2131297796, 2131297799, 2131297802, 2131297805, 2131297808, 2131297811, 2131297814 };
    this.c = new int[] { 2131297798, 2131297801, 2131297804, 2131297807, 2131297810, 2131297813, 2131297816 };
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new oyi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public List a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a()
  {
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(OnRecentUserOpsListener paramOnRecentUserOpsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    a(null);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(50);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem");
    }
    if (paramView == null) {
      return false;
    }
    int j = 0;
    if (j < 7)
    {
      Object localObject1 = paramView.findViewById(this.jdField_a_of_type_ArrayOfInt[j]);
      Object localObject2;
      ImageView localImageView;
      if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
      {
        localObject2 = (String)((View)localObject1).getTag();
        localImageView = (ImageView)((View)localObject1).findViewWithTag("head");
        localObject1 = (TextView)((View)localObject1).findViewWithTag("name");
        if ((localImageView != null) && (localObject1 != null)) {
          break label100;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label100:
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject2, (byte)3, true);
        label117:
        int i;
        if (localBitmap == null)
        {
          ((TextView)localObject1).setText(ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2));
          localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c((String)localObject2);
          if (localObject2 == null) {
            continue;
          }
          switch (((Friends)localObject2).netTypeIconId)
          {
          default: 
            i = 2130840597;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label364;
          }
          ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          break;
          localImageView.setImageBitmap(localBitmap);
          break label117;
          i = 2130840605;
          continue;
          i = 2130840597;
          continue;
          i = 2130840599;
          continue;
          i = 2130840601;
          continue;
          i = 2130843418;
          continue;
          i = 2130840603;
          continue;
          i = 2130843411;
          continue;
          i = 2130843414;
          continue;
          i = 2130843421;
          continue;
          i = 2130843405;
          continue;
          i = 2130843408;
        }
        try
        {
          label364:
          int k = (int)(((TextView)localObject1).getTextSize() + 0.5D);
          localObject2 = BitmapFactory.decodeResource(((TextView)localObject1).getResources(), i);
          localObject2 = new BitmapDrawable(((TextView)localObject1).getResources(), (Bitmap)localObject2);
          ((Drawable)localObject2).setBounds(0, 0, k, k);
          ((TextView)localObject1).setCompoundDrawables(null, null, (Drawable)localObject2, null);
          ((TextView)localObject1).setCompoundDrawablePadding(10);
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    }
    return true;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem uin: " + paramString);
    }
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      localObject = paramView.findViewWithTag(paramString);
    } while (localObject == null);
    paramView = (ImageView)((View)localObject).findViewWithTag("head");
    Object localObject = (TextView)((View)localObject).findViewWithTag("name");
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, true);
    if ((localBitmap != null) && (paramView != null)) {
      paramView.setImageBitmap(localBitmap);
    }
    paramView = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    if (localObject != null) {
      ((TextView)localObject).setText(paramView);
    }
    return true;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j = a() / 7;
    if (a() % 7 == 0) {}
    for (int i = 0;; i = 1) {
      return i + j;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem position: " + paramInt);
    }
    if (a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem data list is empty!");
      }
      return null;
    }
    int j = a() / 7;
    int i;
    int k;
    if (a() % 7 == 0)
    {
      i = 0;
      k = j + i;
      if (a() % 7 != 0) {
        break label592;
      }
      i = 7;
      label99:
      if (k <= 1) {
        break label835;
      }
    }
    label133:
    label149:
    label166:
    label261:
    label447:
    label466:
    label592:
    label609:
    label624:
    label776:
    label794:
    label835:
    for (j = paramInt * 7;; j = 0)
    {
      if ((k == 1) || (paramInt == k - 1)) {}
      for (;;)
      {
        View localView1;
        View localView2;
        ImageView localImageView;
        TextView localTextView;
        String str;
        Object localObject1;
        Object localObject2;
        if (paramInt % 2 == 0)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label609;
          }
          localView1 = View.inflate(paramViewGroup.getContext(), 2130903227, null);
          FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          k = 0;
          paramInt = i;
          if (k >= i) {
            break label794;
          }
          localView2 = localView1.findViewById(this.jdField_a_of_type_ArrayOfInt[k]);
          localImageView = (ImageView)localView1.findViewById(this.b[k]);
          localTextView = (TextView)localView1.findViewById(this.c[k]);
          str = ((Long)this.jdField_a_of_type_JavaUtilList.get(j + k)).toString();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, (byte)3, true);
          if (localObject1 != null) {
            break label624;
          }
          localObject1 = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          localTextView.setText((CharSequence)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem uin: " + str + ", name: " + (String)localObject1);
          }
          localObject2 = localFriendsManager.c(str);
          if (localObject2 == null) {
            break label776;
          }
          int m = ((Friends)localObject2).netTypeIconId;
          switch (m)
          {
          default: 
            paramInt = 2130840597;
            if (paramInt == 0)
            {
              localTextView.setCompoundDrawables(null, null, null, null);
              localTextView.setCompoundDrawablePadding(0);
              if (QLog.isColorLevel()) {
                QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem networkType: " + m + ", resId: " + paramInt);
              }
            }
            break;
          }
        }
        for (;;)
        {
          localImageView.setTag("head");
          localTextView.setTag("name");
          localView2.setTag(str);
          localView2.setVisibility(0);
          localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView2.setContentDescription("点击向" + (String)localObject1 + "发起QQ通话");
          k += 1;
          break label166;
          i = 1;
          break;
          i = a() % 7;
          break label99;
          paramInt = 0;
          break label133;
          localView1 = View.inflate(paramViewGroup.getContext(), 2130903226, null);
          break label149;
          localImageView.setImageBitmap((Bitmap)localObject1);
          break label261;
          paramInt = 2130840605;
          break label447;
          paramInt = 2130840597;
          break label447;
          paramInt = 2130840599;
          break label447;
          paramInt = 2130840601;
          break label447;
          paramInt = 2130843418;
          break label447;
          paramInt = 2130840603;
          break label447;
          paramInt = 2130843411;
          break label447;
          paramInt = 2130843414;
          break label447;
          paramInt = 2130843421;
          break label447;
          paramInt = 2130843405;
          break label447;
          paramInt = 2130843408;
          break label447;
          int n = (int)(localTextView.getTextSize() + 0.5D);
          try
          {
            localObject2 = BitmapFactory.decodeResource(localTextView.getResources(), paramInt);
            localObject2 = new BitmapDrawable(localTextView.getResources(), (Bitmap)localObject2);
            ((Drawable)localObject2).setBounds(0, 0, n, n);
            localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
            localTextView.setCompoundDrawablePadding(10);
          }
          catch (OutOfMemoryError localOutOfMemoryError) {}
          break label466;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem cannot find friend!");
          }
        }
        while (paramInt < 7)
        {
          localView1.findViewById(this.jdField_a_of_type_ArrayOfInt[paramInt]).setVisibility(4);
          paramInt += 1;
        }
        paramViewGroup.addView(localView1);
        return localView1;
        i = 7;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
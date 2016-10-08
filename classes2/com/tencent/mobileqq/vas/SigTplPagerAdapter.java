package com.tencent.mobileqq.vas;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.LinkedList;

public class SigTplPagerAdapter
  extends PagerAdapter
  implements AbsListView.OnScrollListener
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  public LinkedList a;
  private int b;
  
  public SigTplPagerAdapter(QQAppInterface paramQQAppInterface, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramQQAppInterface.getApplication());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView((View)paramObject);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.b > 0)
    {
      this.b -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
    Object localObject;
    SigTlpGridViewAdapter localSigTlpGridViewAdapter;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      localSigTlpGridViewAdapter = (SigTlpGridViewAdapter)((GridView)localObject).a();
      localSigTlpGridViewAdapter.jdField_a_of_type_Int = paramInt;
      if (paramInt != localSignatureManager.e) {
        break label280;
      }
    }
    label280:
    for (int i = localSignatureManager.f;; i = -1)
    {
      localSigTlpGridViewAdapter.a(i, localSignatureManager.a(paramInt));
      localSigTlpGridViewAdapter.notifyDataSetChanged();
      paramViewGroup.addView((View)localObject, 0);
      return localObject;
      localObject = new GridView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      GridView localGridView = (GridView)localObject;
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localGridView.setSelector(new ColorDrawable(0));
      localGridView.setPadding(0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15.0F), 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15.0F));
      localGridView.setClipToPadding(false);
      localGridView.setClickable(true);
      localGridView.setFocusable(true);
      localGridView.setNumColumns(3);
      localGridView.setVerticalSpacing(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 20.0F));
      localGridView.setHorizontalSpacing(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 1.0F));
      localGridView.setOnScrollListener(this);
      localGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      localGridView.setFocusable(true);
      localGridView.setFocusableInTouchMode(true);
      localSigTlpGridViewAdapter = new SigTlpGridViewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localGridView.setAdapter(localSigTlpGridViewAdapter);
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.b = getCount();
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\SigTplPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
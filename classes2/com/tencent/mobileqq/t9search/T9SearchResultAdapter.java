package com.tencent.mobileqq.t9search;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import uyg;
import uyh;

public class T9SearchResultAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private static final int jdField_a_of_type_Int = 80;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Comparator jdField_a_of_type_JavaUtilComparator;
  private List jdField_a_of_type_JavaUtilList;
  
  public T9SearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilComparator = new uyg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void a(T9SearchResultAdapter.ViewHolder paramViewHolder, T9SearchableData paramT9SearchableData)
  {
    switch (paramT9SearchableData.j)
    {
    default: 
      return;
    case 1: 
      b(paramViewHolder, paramT9SearchableData);
      return;
    case 3: 
      c(paramViewHolder, paramT9SearchableData);
      return;
    case 2: 
      d(paramViewHolder, paramT9SearchableData);
      return;
    }
    e(paramViewHolder, paramT9SearchableData);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new T9SearchableData(paramString);
      paramString.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  private void b(T9SearchResultAdapter.ViewHolder paramViewHolder, T9SearchableData paramT9SearchableData)
  {
    paramViewHolder.d.setText(2131372457);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramT9SearchableData.h);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramT9SearchableData.h, 1, true);
      localBitmap1 = ImageUtil.a();
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    if (paramT9SearchableData.l == 1)
    {
      T9Utils.a(paramViewHolder.b, paramT9SearchableData.c, paramT9SearchableData.a().toString());
      paramViewHolder.c.setText(paramT9SearchableData.g);
    }
    do
    {
      return;
      if (paramT9SearchableData.l == 2)
      {
        T9Utils.a(paramViewHolder.b, paramT9SearchableData.d, paramT9SearchableData.a().toString());
        paramViewHolder.c.setText(paramT9SearchableData.g);
        return;
      }
    } while (paramT9SearchableData.l != 3);
    paramViewHolder.b.setText(paramT9SearchableData.b());
    T9Utils.a(paramViewHolder.c, paramT9SearchableData.g, paramT9SearchableData.jdField_a_of_type_JavaLangString);
  }
  
  private void c(T9SearchResultAdapter.ViewHolder paramViewHolder, T9SearchableData paramT9SearchableData)
  {
    paramViewHolder.d.setText(2131372458);
    if (paramT9SearchableData.o == 0)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(11, paramT9SearchableData.h);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      if (paramT9SearchableData.l != 1) {
        break label110;
      }
      T9Utils.a(paramViewHolder.b, paramT9SearchableData.c, paramT9SearchableData.a().toString());
      paramViewHolder.c.setText(paramT9SearchableData.e);
    }
    label110:
    do
    {
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(paramT9SearchableData.b()));
      break;
      if (paramT9SearchableData.l == 2)
      {
        T9Utils.a(paramViewHolder.b, paramT9SearchableData.d, paramT9SearchableData.a().toString());
        paramViewHolder.c.setText(paramT9SearchableData.e);
        return;
      }
      if (paramT9SearchableData.l == 4)
      {
        paramViewHolder.b.setText(paramT9SearchableData.b());
        T9Utils.a(paramViewHolder.c, paramT9SearchableData.e, paramT9SearchableData.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramT9SearchableData.l != 3);
    paramViewHolder.b.setText(paramT9SearchableData.b());
    T9Utils.a(paramViewHolder.c, paramT9SearchableData.g, paramT9SearchableData.jdField_a_of_type_JavaLangString);
  }
  
  private void d(T9SearchResultAdapter.ViewHolder paramViewHolder, T9SearchableData paramT9SearchableData)
  {
    paramViewHolder.d.setText(2131372459);
    if (paramT9SearchableData.o == 3000)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001, paramT9SearchableData.h));
      if (paramT9SearchableData.l != 1) {
        break label166;
      }
      T9Utils.a(paramViewHolder.b, paramT9SearchableData.c, paramT9SearchableData.a().toString());
      paramViewHolder.c.setText(paramT9SearchableData.e);
    }
    label166:
    while (paramT9SearchableData.l != 4)
    {
      return;
      if ((paramT9SearchableData.o == 1006) || (paramT9SearchableData.o == 56938) || (paramT9SearchableData.o == 2016))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.d(paramT9SearchableData.b()));
        break;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramT9SearchableData.h, paramT9SearchableData.o));
      break;
    }
    paramViewHolder.b.setText(paramT9SearchableData.b());
    T9Utils.a(paramViewHolder.c, paramT9SearchableData.e, paramT9SearchableData.jdField_a_of_type_JavaLangString);
  }
  
  private void e(T9SearchResultAdapter.ViewHolder paramViewHolder, T9SearchableData paramT9SearchableData)
  {
    paramViewHolder.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131372460));
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839109);
    T9Utils.a(paramViewHolder.c, paramT9SearchableData.h, paramT9SearchableData.h);
    paramViewHolder.e.setVisibility(4);
  }
  
  public T9SearchableData a(int paramInt)
  {
    return (T9SearchableData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof FacePreloadBaseAdapter.ViewHolder)))
      {
        localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
        if (paramString != null) {
          break label59;
        }
      }
      label59:
      while (!paramString.equals(((FacePreloadBaseAdapter.ViewHolder)localObject).b))
      {
        paramInt1 += 1;
        break;
      }
      ((FacePreloadBaseAdapter.ViewHolder)localObject).d.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(T9SearchResultAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    paramViewHolder.b.setText("");
    paramViewHolder.c.setText("");
    paramViewHolder.d.setText("");
    paramViewHolder.e.setVisibility(0);
  }
  
  public void a(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    try
    {
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      ArrayList localArrayList = new ArrayList();
      if (paramList.size() < 20)
      {
        paramList = T9Utils.a(paramList);
        if (paramList.size() <= 80) {
          break label114;
        }
        this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 80));
        a(paramString);
        notifyDataSetChanged();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("T9SearchResultAdapter", 2, "IllegalArgumentException, crash.");
          continue;
          localIllegalArgumentException.addAll(paramList);
          paramList = localIllegalArgumentException;
          continue;
          label114:
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903614, null);
      paramViewGroup = new T9SearchResultAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299455));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299456));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131299459));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131299460));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131299458));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131299457));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      T9SearchableData localT9SearchableData = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchableData = localT9SearchableData;
      if (localT9SearchableData != null) {
        a(paramViewGroup, localT9SearchableData);
      }
      paramViewGroup.e.setOnClickListener(new uyh(this, localT9SearchableData));
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (T9SearchResultAdapter.ViewHolder)paramView.getTag();
      a(paramViewGroup);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\T9SearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
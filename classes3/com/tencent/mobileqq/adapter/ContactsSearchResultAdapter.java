package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchAdapterInterface.SearchResultCallBack;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean b;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.b = paramBoolean;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(SearchAdapterInterface.SearchResultCallBack paramSearchResultCallBack)
  {
    this.a = paramSearchResultCallBack;
  }
  
  protected boolean a(BaseSearchResultAdapter.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof ContactsSearchResultAdapter.ViewTag))
    {
      paramViewHolder = (ContactsSearchResultAdapter.ViewTag)paramViewHolder;
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void e()
  {
    super.d();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IContactSearchable localIContactSearchable;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903223, paramViewGroup, false);
      paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297143));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297774));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297776));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297466));
      SearchUtil.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297778));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297777));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131297773));
      paramView.setTag(paramViewGroup);
      localIContactSearchable = (IContactSearchable)getItem(paramInt);
      if (localIContactSearchable == null) {
        break label548;
      }
    }
    label243:
    label273:
    label318:
    label360:
    label455:
    label485:
    label522:
    label542:
    label548:
    for (Object localObject = localIContactSearchable.c();; localObject = null)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (localIContactSearchable != null)
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localIContactSearchable.b());
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(localIContactSearchable.b());
      }
      PhoneContactSelectActivity localPhoneContactSelectActivity;
      String str;
      boolean bool;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof PhoneContactSelectActivity))
      {
        localPhoneContactSelectActivity = (PhoneContactSelectActivity)this.jdField_a_of_type_AndroidContentContext;
        str = localIContactSearchable.d();
        if ((localPhoneContactSelectActivity.g != null) && (localPhoneContactSelectActivity.g.contains(str)))
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131368277);
          if ((localPhoneContactSelectActivity.b == null) || (!localPhoneContactSelectActivity.b.contains(str))) {
            break label455;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131368277);
          paramViewGroup.jdField_a_of_type_JavaLangString = localIContactSearchable.d();
          paramViewGroup.jdField_a_of_type_Int = localIContactSearchable.c();
          if (!(localIContactSearchable instanceof ContactSearchableSearchHistory)) {
            break label542;
          }
          if (((ContactSearchableSearchHistory)localIContactSearchable).a().type != 56938) {
            break label485;
          }
          bool = true;
        }
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Boolean = bool;
        if (paramViewGroup.jdField_a_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
          paramViewGroup.d.setVisibility(0);
          paramViewGroup.d.setText(ContactUtils.a((String)localObject));
          localObject = localIContactSearchable.a();
          if (localObject != null) {
            break label522;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          return paramView;
          paramViewGroup = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
          break;
          if (localPhoneContactSelectActivity.a(str))
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131368278);
            break label243;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
          break label243;
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
          break label273;
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
          break label273;
          bool = false;
          break label318;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Int));
          paramViewGroup.d.setVisibility(8);
          break label360;
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        bool = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\ContactsSearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
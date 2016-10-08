package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.ListView;
import ula;
import ulb;

public class SelectMemberContactSearchFragment
  extends BaseSearchFragment
{
  private boolean a;
  private int g;
  private int h;
  
  public SelectMemberContactSearchFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SelectMemberContactSearchFragment a(int paramInt1, int paramInt2)
  {
    SelectMemberContactSearchFragment localSelectMemberContactSearchFragment = new SelectMemberContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localSelectMemberContactSearchFragment.setArguments(localBundle);
    return localSelectMemberContactSearchFragment;
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ulb(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    return new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.h, this.g, null);
  }
  
  protected String a()
  {
    return "联系人";
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if ((!SearchUtils.a(this.h)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427650);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837958);
  }
  
  protected boolean a()
  {
    return SearchUtils.a(this.h);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.g = localBundle.getInt("contactSearchSource", 197501);
      this.h = localBundle.getInt("fromType", -1);
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.a(this.h))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427650);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ula(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\fragment\SelectMemberContactSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
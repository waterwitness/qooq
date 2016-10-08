package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.util.ObjectTransfer;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ukv;
import ukw;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener;
  private String jdField_a_of_type_JavaLangString;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private Set b;
  private Set c;
  private int g;
  private int h;
  
  public ContactSearchFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new HashSet();
    this.c = new HashSet();
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, null, null, null);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (paramOnActionListener != null) {
      localBundle.putLong("contactSearchOnActionListener", ObjectTransfer.a().a(paramOnActionListener));
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ukw(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    return new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.h, this.g, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
  }
  
  protected String a()
  {
    return "联系人";
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (((!SearchUtils.a(this.h)) || (this.h == -1)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label71;
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.h == -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427379);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427650);
    return;
    label71:
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837958);
  }
  
  public void a(List paramList1, List paramList2)
  {
    this.b.clear();
    this.c.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        this.b.add(str);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        this.c.add(paramList2);
      }
    }
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
      this.jdField_a_of_type_JavaLangString = localBundle.getString("specifiedTroopUin");
      String[] arrayOfString = localBundle.getStringArray("hiddenUinSet");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = ((ContactSearchResultPresenter.OnActionListener)ObjectTransfer.a().a(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.a(this.h))
    {
      if (this.h != -1) {
        break label54;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427379);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ukv(this));
      return;
      label54:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427650);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\fragment\ContactSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
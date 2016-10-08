package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import uld;

public class FTSEntitySearchFragment
  extends BaseSearchFragment
{
  public FTSEntitySearchFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static FTSEntitySearchFragment a()
  {
    return new FTSEntitySearchFragment();
  }
  
  public static FTSEntitySearchFragment a(String paramString)
  {
    FTSEntitySearchFragment localFTSEntitySearchFragment = new FTSEntitySearchFragment();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("keyword", paramString);
    localFTSEntitySearchFragment.setArguments(localBundle);
    return localFTSEntitySearchFragment;
  }
  
  protected BaseMvpAdapter a()
  {
    return new uld(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseSearchActivity.jdField_b_of_type_Int);
  }
  
  protected String a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(localBaseSearchActivity, localBaseSearchActivity.jdField_b_of_type_Int);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 1);
  }
  
  protected void c()
  {
    Object localObject = (BaseSearchActivity)super.getActivity();
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      if (localObject != null) {
        break label66;
      }
    }
    label66:
    for (localObject = null;; localObject = ((BaseSearchActivity)localObject).e)
    {
      if ((!bool) || (localObject == null)) {
        break label74;
      }
      this.c.setText(Html.fromHtml(String.format(BaseApplicationImpl.a.getString(2131372228), new Object[] { localObject })));
      return;
      bool = ((BaseSearchActivity)localObject).jdField_b_of_type_Boolean;
      break;
    }
    label74:
    this.c.setText(Html.fromHtml(String.format(BaseApplicationImpl.a.getString(2131372228), new Object[] { this.b })));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.b = getArguments().getString("keyword");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.d();
  }
  
  public void onStart()
  {
    super.onStart();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsentity\FTSEntitySearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements AbsListView.OnScrollListener
{
  private static final int g = AIOUtils.a(10.0F, BaseApplicationImpl.a().getResources());
  private int h = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static GroupSearchFragment a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected BaseMvpAdapter a()
  {
    return new GroupSearchAdapter(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this, this.h);
  }
  
  protected ISearchEngine a()
  {
    return new GroupSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.h);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0)) {}
    label287:
    label296:
    label394:
    for (;;)
    {
      return;
      paramAbsListView = (ISearchResultGroupModel)this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramInt1);
      Object localObject;
      if (paramInt1 == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
        if (localObject != null) {
          if (((View)localObject).getBottom() < ((View)localObject).getHeight())
          {
            this.d.setVisibility(0);
            if (!this.d.getText().equals(paramAbsListView.a())) {
              this.d.setText(paramAbsListView.a());
            }
          }
          else
          {
            this.d.setVisibility(4);
          }
        }
      }
      else
      {
        localObject = (ISearchResultGroupModel)this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramInt1 + 1);
        if (localObject != null)
        {
          if (((ISearchResultGroupModel)localObject).a() != 1) {
            break label296;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(1);
          if (localObject != null)
          {
            paramInt1 = ((View)localObject).getHeight();
            paramInt2 = ((View)localObject).getBottom();
            localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
            if (paramInt2 >= paramInt1 * 2 - g) {
              break label287;
            }
            ((LinearLayout.LayoutParams)localObject).topMargin = (paramInt2 - paramInt1 * 2 + g);
            this.d.setVisibility(0);
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.d.requestLayout();
          }
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(paramAbsListView.a())) || (this.d.getText().equals(paramAbsListView.a()))) {
            break label394;
          }
          if (SQLiteFTSUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) {
            break label396;
          }
          this.d.setText(paramAbsListView.a());
          return;
          ((LinearLayout.LayoutParams)localObject).topMargin = 0;
          break;
          if (paramAbsListView.a() == 1)
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
            if (localObject != null)
            {
              paramInt1 = ((View)localObject).getBottom();
              if (((View)localObject).getHeight() - paramInt1 >= g)
              {
                localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject).topMargin = 0;
                this.d.setVisibility(0);
                this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
                this.d.requestLayout();
              }
              else
              {
                this.d.setVisibility(4);
              }
            }
          }
        }
      }
    }
    label396:
    if ((paramAbsListView instanceof FTSGroupSearchModelMessage))
    {
      this.d.setText("聊天记录");
      return;
    }
    this.d.setText(paramAbsListView.a());
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      this.h = localBundle.getInt("fromType", -1);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\fragment\GroupSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
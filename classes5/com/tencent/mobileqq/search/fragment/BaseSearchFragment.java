package com.tencent.mobileqq.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import uks;
import ukt;

public abstract class BaseSearchFragment
  extends Fragment
  implements Handler.Callback, ISearchListener
{
  protected static final int a = 1;
  private static final long jdField_a_of_type_Long = 300L;
  private static final String jdField_a_of_type_JavaLangString = "GroupSearchFragment";
  protected static final int b = 2;
  private static final int g = 1;
  private static final int h = 3;
  private static final int i = 4;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  protected ProgressBar a;
  protected TextView a;
  protected QQAppInterface a;
  protected BaseMvpAdapter a;
  public ISearchEngine a;
  public FaceDecoder a;
  protected ListView a;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  protected TextView b;
  public String b;
  protected int c;
  protected TextView c;
  protected TextView d;
  
  public BaseSearchFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private void d()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("正在加载…");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void e()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (a()) {}
    for (int j = 0;; j = 8)
    {
      localTextView.setVisibility(j);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected abstract BaseMvpAdapter a();
  
  protected abstract ISearchEngine a();
  
  protected String a()
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(String paramString)
  {
    a(paramString, 1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "startSearch, key: " + paramString + getClass());
    }
    FragmentActivity localFragmentActivity = super.getActivity();
    boolean bool;
    if ((localFragmentActivity instanceof BaseSearchActivity))
    {
      bool = ((BaseSearchActivity)localFragmentActivity).b;
      if ((!TextUtils.isEmpty(paramString)) || (bool) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null)) {
        break label154;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      a();
    }
    label154:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_b_of_type_JavaLangString = paramString;
      } while (this.jdField_a_of_type_ComTencentWidgetListView == null);
      switch (paramInt)
      {
      default: 
        a();
        d();
        this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(null);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_c_of_type_Int += 1;
    if ((localFragmentActivity instanceof BaseSearchActivity)) {}
    for (String str = ((BaseSearchActivity)localFragmentActivity).e;; str = null)
    {
      if (str != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", str);
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localFragmentActivity).f);
        localBundle.putBoolean("search_restrict_empty", bool);
        localBundle.putInt("search_restrict_uintype", ((BaseSearchActivity)localFragmentActivity).jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(new SearchRequest(paramString, localBundle), this);
        return;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
        break;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(new SearchRequest(paramString), this);
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long >= 300L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L - (l - this.jdField_b_of_type_Long));
  }
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    this.d.setVisibility(8);
    c();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  protected void b(List paramList)
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  protected void c()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(String.format(BaseApplicationImpl.a.getString(2131372228), new Object[] { this.jdField_b_of_type_JavaLangString })));
  }
  
  protected void c(List paramList)
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((paramList == null) || (paramList.isEmpty())) {
      b();
    }
  }
  
  protected void d(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() <= 0)
    {
      e();
      b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      b(this.jdField_a_of_type_JavaUtilList);
      continue;
      c(this.jdField_a_of_type_JavaUtilList);
      continue;
      d(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramActivity).app;
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine = a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2130904332, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131297845));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new uks(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298449));
    paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
    if (a()) {}
    for (int j = 0;; j = 8)
    {
      paramBundle.setVisibility(j);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297445));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131297479));
      this.d = ((TextView)paramViewGroup.findViewById(2131297123));
      this.d.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.inflate(2130903405, this.jdField_a_of_type_ComTencentWidgetListView, false));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("正在加载…");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      return paramViewGroup;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_c_of_type_Int), "", this.jdField_b_of_type_JavaLangString, "");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
    e();
    if ((super.getActivity() instanceof BaseSearchActivity)) {}
    for (boolean bool = ((BaseSearchActivity)super.getActivity()).b;; bool = false)
    {
      ThreadManager.a(new ukt(this, bool), null, true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\fragment\BaseSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
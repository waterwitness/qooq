package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.TipsInfo;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ogy;
import ogz;
import oha;
import ohb;
import ohd;
import ohe;
import ohf;
import ohg;
import ohh;
import ohi;
import ohj;
import ohk;
import ohl;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements ReadInJoySearchHistoryAdapter.OnItemClickObserver
{
  public static int a = 0;
  private static SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  public static final String a = "ClassificationSearchActivity";
  public static int b = 0;
  public static final String b = "0X8004AB4";
  public static int c = 0;
  public static String c;
  static String jdField_d_of_type_JavaLangString = "";
  public static final int e = 20;
  public static final int f = 1;
  public static final int g = 2;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new ohi(this);
  protected ReadInJoyObserver a;
  ReadInJoySearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = new ohk(this);
  ReadInJoySearchTipsContainer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ReadInJoySearchTipsContainer.OnTipClickListener jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = new ohl(this);
  ReadInJoySearchTipsContainer jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  public List b;
  View c;
  public List c;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  View e;
  View f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_c_of_type_JavaLangString = "is_from";
  }
  
  public ClassificationSearchActivity()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ohj(this);
    this.jdField_a_of_type_AndroidOsHandler = new ohd(this);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    jdField_d_of_type_JavaLangString = paramString;
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void b(String paramString)
  {
    String str = paramString.trim();
    Object localObject = PublicAccountConfigUtil.C;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (!((String)localObject).contains("keyword")) {}
    }
    for (paramString = ((String)localObject).replace("keyword", str);; paramString = "https://so.mp.qq.com/search/index?key=" + str + "&_wv=3&_bid=2321")
    {
      localObject = new Intent(this, PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", paramString);
      startActivity((Intent)localObject);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChannelInfo localChannelInfo = (ChannelInfo)localIterator.next();
        ReadInJoySearchTipsContainer.TipsInfo localTipsInfo = new ReadInJoySearchTipsContainer.TipsInfo();
        localTipsInfo.word = localChannelInfo.mChannelName;
        localTipsInfo.frameColor = localChannelInfo.mFrameColor;
        localTipsInfo.textColor = localChannelInfo.mFontColor;
        localArrayList.add(localTipsInfo);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.a(localArrayList);
    } while (!paramBoolean);
    f();
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((SearchProtocol.WordItem)localIterator.next());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.b(localArrayList);
    } while (!paramBoolean);
    f();
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903730, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297768));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903463, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131298186));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298693);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298691);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131298690));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131298688);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void f()
  {
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.g();
        a(false);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_d_of_type_AndroidViewView);
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      this.e.setVisibility(8);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
        break label197;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      label144:
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label208;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      a(true);
      return;
      this.e.setVisibility(0);
      break;
      label197:
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      break label144;
      label208:
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected SearchBaseFragment a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult == null) && ((this.jdField_d_of_type_Int == jdField_a_of_type_Int) || (this.jdField_d_of_type_Int == jdField_b_of_type_Int) || (this.jdField_d_of_type_Int == jdField_c_of_type_Int))) {
      return ClassificationSearchFragment.a(this.jdField_d_of_type_Int);
    }
    return ClassificationSearchFragment.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult);
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(jdField_c_of_type_JavaLangString)) {
      this.jdField_d_of_type_Int = localIntent.getIntExtra(jdField_c_of_type_JavaLangString, 0);
    }
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    if (this.jdField_d_of_type_Int == jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramReadInJoySearchHistoryEntity.keyWord);
      b(paramReadInJoySearchHistoryEntity.keyWord);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramReadInJoySearchHistoryEntity.keyWord, "");
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a(new ogz(this, paramString), 10, null, true);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      f();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.a() == null)
    {
      paramList = new ReadInJoySearchHistoryAdapter(this, paramList, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramList);
    }
    ReadInJoySearchHistoryAdapter localReadInJoySearchHistoryAdapter;
    do
    {
      return;
      if (!(this.jdField_a_of_type_ComTencentWidgetXListView.a() instanceof HeaderViewListAdapter)) {
        break;
      }
      localReadInJoySearchHistoryAdapter = (ReadInJoySearchHistoryAdapter)((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.a()).getWrappedAdapter();
    } while (localReadInJoySearchHistoryAdapter == null);
    localReadInJoySearchHistoryAdapter.a(paramList);
    return;
    ((ReadInJoySearchHistoryAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.a()).a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (!paramBoolean) {
        break label89;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(-1);
      if (this.f != null) {
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      }
      this.f = new View(this);
      this.f.setBackgroundColor(1996488704);
      addContentView(this.f, new ViewGroup.LayoutParams(-1, -1));
    }
    label89:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(0);
      }
    } while (this.f == null);
    this.f.setVisibility(8);
  }
  
  protected void b()
  {
    super.b();
    String str;
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null)
    {
      str = "";
      switch (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ohe(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new ohf(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ohg(this));
      if (AppSetting.j) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏" + this.h);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ohh(this));
      if (this.jdField_d_of_type_Int == jdField_a_of_type_Int) {
        e();
      }
      return;
      str = "网络查找人";
      continue;
      str = "网络查找群";
      continue;
      if (GroupSearchActivity.e == 12)
      {
        str = "网络查找" + PublicAccountConfigUtil.a(this.app, getApplicationContext());
      }
      else
      {
        str = "网络查找公众号";
        continue;
        str = "网络查找相关文章";
      }
    }
  }
  
  public void c()
  {
    ThreadManager.a(new oha(this), 10, null, true);
  }
  
  public void d()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new ohb(this);
    localQQCustomDialog.setPositiveButton(2131365002, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131365001, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131365000);
    localQQCustomDialog.setTitle(2131364950);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131427355));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.h);
    if (!TextUtils.isEmpty(this.h)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length() - 1);
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_d_of_type_Int == jdField_a_of_type_Int)
    {
      c();
      SearchProtocol.b(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      if (ReadInJoyLogicEngine.a().a() == 0) {
        ReadInJoyLogicEngine.a().a(1, 1);
      }
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a())
    {
      Looper.myQueue().addIdleHandler(new ogy(this));
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(false);
    }
    if (this.jdField_d_of_type_Int == jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索相关文章");
      f();
    }
    if (this.jdField_d_of_type_Int == jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索相关文章");
      if ((!TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(jdField_d_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_d_of_type_Int == jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.g();
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("网络查找公众号");
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.g();
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\ClassificationSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
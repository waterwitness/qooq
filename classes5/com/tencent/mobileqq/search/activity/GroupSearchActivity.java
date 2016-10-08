package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ukl;
import ukm;
import ukn;
import uko;
import ukp;
import ukq;
import ukr;

public class GroupSearchActivity
  extends BaseSearchActivity
  implements Handler.Callback, GestureDetector.OnGestureListener
{
  public static long a = 0L;
  public static final String a = "last_search_keyword_";
  public static long b = 0L;
  public static final int d = 97001;
  public static int e = 0;
  private static final int jdField_g_of_type_Int = 1;
  private static final int h = 2;
  private static int i = 777777;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ukq(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  private View b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_Int = -1;
    jdField_b_of_type_Long = -1L;
  }
  
  public GroupSearchActivity()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
  }
  
  private List a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.app.getManager(54);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SearchHistoryManager)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new ContactSearchableSearchHistory(this.app, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("searchUtils", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    jdField_e_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + jdField_e_of_type_Int);
    }
    if (jdField_e_of_type_Int == 12)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", jdField_e_of_type_Int, 0, "", "", "", "");
      Intent localIntent = new Intent(paramActivity, GroupSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt);
      paramActivity.startActivityForResult(localIntent, 97001);
      paramActivity.overridePendingTransition(0, 0);
      jdField_a_of_type_Long = System.currentTimeMillis();
      if (jdField_e_of_type_Int != 2) {
        break label163;
      }
      PADetailReportUtil.a().a(200);
    }
    label163:
    do
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", jdField_e_of_type_Int, 0, "", "", "", "");
      break;
      if (jdField_e_of_type_Int == 1)
      {
        PADetailReportUtil.a().a(100);
        return;
      }
    } while (jdField_e_of_type_Int != 12);
    PADetailReportUtil.a().a(400);
  }
  
  private void b(String paramString)
  {
    if (paramString.startsWith(this.jdField_e_of_type_JavaLangString))
    {
      paramString = paramString.substring(this.jdField_e_of_type_JavaLangString.length()).trim();
      if (TextUtils.isEmpty(paramString))
      {
        this.jdField_b_of_type_Boolean = true;
        if (!this.jdField_f_of_type_Boolean) {
          break label114;
        }
        this.jdField_f_of_type_Boolean = false;
        if (this.jdField_a_of_type_Int != 0) {
          break label114;
        }
        this.jdField_b_of_type_Int = 1;
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = FTSEntitySearchFragment.a(paramString);
        paramString = super.getSupportFragmentManager().beginTransaction();
        paramString.replace(2131298333, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
        paramString.commitAllowingStateLoss();
        this.jdField_a_of_type_Int = 1;
      }
    }
    label114:
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      break;
      a(paramString);
      return;
      this.jdField_e_of_type_JavaLangString = null;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(null);
    } while (this.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = GroupSearchFragment.a(jdField_e_of_type_Int);
    paramString = super.getSupportFragmentManager().beginTransaction();
    paramString.replace(2131298333, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
    paramString.commitAllowingStateLoss();
    this.jdField_a_of_type_Int = 0;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) && (jdField_e_of_type_Int != 12))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (((paramBoolean) || (this.jdField_b_of_type_AndroidViewView.getVisibility() == 8)) && (jdField_e_of_type_Int != 12));
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected int a()
  {
    return 2130903374;
  }
  
  protected BaseSearchFragment a()
  {
    return GroupSearchFragment.a(jdField_e_of_type_Int);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-2 ResultModule:" + SearchStatisticsConstants.a());
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "2", "", SearchStatisticsConstants.a(), "");
    finish();
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "showSearchHistory,  isShow: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 0) && (jdField_e_of_type_Int != 12))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        return;
      }
    } while (((paramBoolean) || (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 0)) && (jdField_e_of_type_Int != 12));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    while (this.jdField_e_of_type_JavaLangString != null)
    {
      b(paramEditable);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    paramEditable = paramEditable.trim();
    if (!paramEditable.equals(this.jdField_d_of_type_JavaLangString)) {
      com.tencent.mobileqq.search.util.SearchUtils.jdField_a_of_type_Long = 0L;
    }
    if (!this.jdField_f_of_type_Boolean) {
      super.a(paramEditable);
    }
    if (!TextUtils.isEmpty(this.g))
    {
      a(TextUtils.isEmpty(paramEditable));
      b(false);
      return;
    }
    a(false);
    b(TextUtils.isEmpty(paramEditable));
  }
  
  void b()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      ThreadManager.a(new uko(this), null, true);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903222, null);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ukp(this));
      ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297770)).setText(this.g);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
      b(false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((TextUtils.isEmpty(paramCharSequence)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = false;
      SQLiteFTSUtils.FtsItemClickEvent.a();
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == i) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
        if ((paramIntent != null) && (!paramIntent.isEmpty()))
        {
          paramIntent = (ResultRecord)paramIntent.get(0);
          if ((!TextUtils.isEmpty(paramIntent.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramIntent.b))) {
            break label61;
          }
        }
      }
    }
    label61:
    do
    {
      do
      {
        return;
        this.jdField_f_of_type_JavaLangString = paramIntent.jdField_a_of_type_JavaLangString;
        if (paramIntent.jdField_a_of_type_Int == 0) {
          this.jdField_c_of_type_Int = 0;
        }
        for (;;)
        {
          this.jdField_e_of_type_JavaLangString = ("#" + paramIntent.b + "# ");
          localObject = new SpannableStringBuilder(this.jdField_e_of_type_JavaLangString);
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(-4331268), 0, this.jdField_e_of_type_JavaLangString.length() - 1, 33);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText((CharSequence)localObject);
          ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(0, 2);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.requestFocus();
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(this.jdField_e_of_type_JavaLangString.length());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("searchUtils", 2, String.format("SearchMemberActivity result, uin: %s, name: %s", new Object[] { paramIntent.jdField_a_of_type_JavaLangString, paramIntent.b }));
          return;
          if (paramIntent.jdField_a_of_type_Int == 1) {
            this.jdField_c_of_type_Int = 1000;
          } else if (paramIntent.jdField_a_of_type_Int == 2) {
            this.jdField_c_of_type_Int = 1004;
          } else {
            this.jdField_c_of_type_Int = -1;
          }
        }
        this.jdField_f_of_type_Boolean = false;
        a("#");
        return;
      } while ((paramInt1 != 1300) || (-1 != paramInt2) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("roomId");
    } while (paramIntent == null);
    Object localObject = ContactUtils.a(this.app, getActivity().getApplicationContext(), paramIntent);
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramIntent);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", (String)localObject);
    RecentUtil.a(localIntent);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
  }
  
  public void doOnBackPressed()
  {
    this.jdField_f_of_type_Int = 0;
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    super.doOnCreate(paramBundle);
    jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298334);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new ukl(this));
    if (jdField_e_of_type_Int == 12) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131364553), new Object[] { PublicAccountConfigUtil.a(this.app, getApplicationContext()) }));
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297768));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, null, new ukm(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ukn(this));
    paramBundle = this.app.a().getSharedPreferences(this.app.a(), 0);
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("first_time_revoke_msg", true);; bool = false)
    {
      this.g = SearchHistoryManager.a(this.app);
      if ((!TextUtils.isEmpty(this.g)) && (!bool))
      {
        if (jdField_e_of_type_Int != 12) {
          b();
        }
        b(false);
      }
      for (;;)
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(2);
        return true;
        if (bool) {
          paramBundle.edit().putBoolean("first_time_revoke_msg", false).commit();
        }
        a(false);
        b(TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString));
      }
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.e();
    PAOfflineSearchManager.a().d();
    jdField_e_of_type_Int = -1;
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    jdField_b_of_type_Long = -1L;
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.d += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.c) / 1000000L;
      SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Long += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.e) / 1000000L;
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      StatisticCollector.a(BaseApplicationImpl.a()).a(this.app.a(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - jdField_a_of_type_Long, 0L, null, "", false);
    }
  }
  
  public void finish()
  {
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.b(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          paramMessage = LayoutInflater.from(this).inflate(2130903211, null);
          ((TextView)paramMessage.findViewById(2131297700)).setText("搜索历史");
          this.jdField_a_of_type_ComTencentWidgetXListView.a(paramMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "load history data finish");
      }
    }
    while (2 != paramMessage.what) {
      return true;
    }
    ThreadManager.a(new ukr(this), null, true);
    return true;
  }
  
  public void onBackPressed()
  {
    if (this.jdField_f_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "cancelType-0 ResultModule:" + SearchStatisticsConstants.a());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "0", "", SearchStatisticsConstants.a(), "");
    }
    for (;;)
    {
      super.onBackPressed();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "cancelType-1 ResultModule:" + SearchStatisticsConstants.a());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "1", "", SearchStatisticsConstants.a(), "");
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onRestart()
  {
    super.onRestart();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
      SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-1 ResultModule:" + SearchStatisticsConstants.a());
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "1", "", SearchStatisticsConstants.a(), "");
    finish();
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramCharSequence.charAt(paramInt1) == '#') && (paramCharSequence.toString().equals("#")) && (SQLiteFTSUtils.g(this.app)) && (SQLiteFTSUtils.j(this.app) == 1))
    {
      this.jdField_f_of_type_Boolean = true;
      paramCharSequence = new Intent(this, SelectMemberActivity.class);
      paramCharSequence.putExtra("param_done_button_wording", getString(2131370181));
      paramCharSequence.putExtra("param_done_button_highlight_wording", getString(2131370182));
      paramCharSequence.putExtra("param_max", 1);
      paramCharSequence.putExtra("param_show_myself", true);
      startActivityForResult(paramCharSequence, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\activity\GroupSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
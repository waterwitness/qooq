package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountManagePopBar;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mbe;
import mbf;
import mbg;
import mbh;
import mbi;
import mbj;
import mbk;
import mbl;
import mbm;
import mbn;
import mbo;
import mbp;
import mbq;
import mbr;
import mbs;
import mbt;
import mbu;
import mqq.os.MqqHandler;

public class PublicAccountListActivity
  extends BaseActivity
  implements ThreadExcutor.IThreadListener, IndexView.OnIndexChangedListener
{
  public static final int a = 0;
  public static final String a;
  public Dialog a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new mbe(this);
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mbk(this);
  public View a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountManagePopBar jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar;
  PublicAccountListActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = null;
  PublicAccountListActivity.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter;
  PublicAccountListActivity.SearchResultComparator jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator = new PublicAccountListActivity.SearchResultComparator(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mbg(this);
  public PublicAccountDataManager a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new mbh(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new mbi(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new mbj(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new mbm(this);
  private Comparator jdField_a_of_type_JavaUtilComparator = new mbl(this);
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public View d;
  TextView d;
  View e;
  View f;
  View g;
  private View h;
  private View i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PublicAccountListActivity.class.getSimpleName();
  }
  
  public PublicAccountListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private mbu a(PublicAccountInfo paramPublicAccountInfo)
  {
    mbu localmbu = new mbu(paramPublicAccountInfo);
    localmbu.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localmbu.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localmbu;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, PublicAccountListActivity.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298716));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131296706);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297183));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.e = super.findViewById(2131298717);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131298718));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131298104));
    this.f = super.findViewById(2131298719);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if ((PublicAccountConfigUtil.d) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar == null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar = new PublicAccountManagePopBar(this);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371914);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371913);
    if (PublicAccountConfigUtil.d) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131372562);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(5).c(5).a();
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.j)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "返回按钮");
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131368676);
    }
  }
  
  private void i()
  {
    View localView = super.getLayoutInflater().inflate(2130903471, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131298720));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895)).setOnTouchListener(new mbo(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300876)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = new PublicAccountListActivity.ListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903478);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903477, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_d_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView.setTag("");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter = new PublicAccountListActivity.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new mbs(this, (InputMethodManager)localObject));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296895);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PublicAccountListActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new mbt(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297765));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new mbf(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298721);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298722));
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131298723)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void k()
  {
    if (this.g == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131297951);
      if (localViewStub == null) {
        return;
      }
      this.g = localViewStub.inflate();
      this.g.findViewById(2131298723).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void l()
  {
    if (this.g != null) {
      this.g.setVisibility(8);
    }
    this.e.setVisibility(0);
  }
  
  private void m()
  {
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      Object localObject = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      ((RedTouchManager)localObject).a(localAppInfo);
      if (!PublicAccountConfigUtil.d) {
        break label337;
      }
      localObject = (PublicAccountDataManager)this.app.getManager(55);
      if ((localObject == null) || (!((PublicAccountDataManager)localObject).b())) {
        break label337;
      }
      bool1 = true;
      long l1 = 0L;
      localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.app.a(), 0);
      if (localObject != null)
      {
        bool2 = ((SharedPreferences)localObject).getBoolean("public_account_manage_notify", true);
        l2 = ((SharedPreferences)localObject).getLong("public_account_manage_activity_enter_time", 0L);
        l1 = l2;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "upDataPARedTouch->receiveNotify:" + bool2 + ", lastEnterTime:" + l2);
          bool1 = bool2;
          l1 = l2;
        }
      }
      l1 = PublicAccountUtil.b(l1) / PublicAccountConfigUtil.c;
      long l2 = PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c;
      if ((!bool1) || (l2 - l1 < 30L)) {
        break label337;
      }
      bool2 = true;
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a()) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.RedTypeInfo());
      }
    }
    label337:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar.a(bool1);
      }
      return;
    }
  }
  
  public void a() {}
  
  protected void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      mbu localmbu = (mbu)localIterator.next();
      String str = localmbu.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        localArrayList4.add(localmbu);
      }
      else
      {
        str = localmbu.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.toLowerCase();
        if ((str.equals(paramString)) || (localmbu.b.equals(paramString)) || (localmbu.jdField_a_of_type_JavaLangString.equals(paramString)) || (localmbu.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin().equals(paramString))) {
          localArrayList1.add(localmbu);
        } else if ((str.indexOf(paramString) == 0) || (localmbu.b.indexOf(paramString) == 0) || (localmbu.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localmbu.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin().indexOf(paramString) == 0)) {
          localArrayList2.add(localmbu);
        } else if ((str.indexOf(paramString) > 0) || (localmbu.b.indexOf(paramString) > 0) || (localmbu.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localmbu.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin().indexOf(paramString) > 0)) {
          localArrayList3.add(localmbu);
        }
      }
    }
    Collections.sort(localArrayList4, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList3, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList4);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131364557, new Object[] { paramString }));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.jdField_a_of_type_JavaUtilList.size() + "," + this.jdField_b_of_type_JavaUtilList.size());
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a(paramString);
    } while (j == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(j + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  public void c()
  {
    runOnUiThread(new mbn(this));
  }
  
  public void d()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -j);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -j, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new mbp(this, localTranslateAnimation1, localTranslateAnimation2, j));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new mbq(this, j, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300876);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new mbr(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.app.getManager(55));
    super.setContentView(2130903470);
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    g();
    h();
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.jdField_a_of_type_Boolean) {
      f();
    }
    for (;;)
    {
      e();
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, this, true);
    }
  }
  
  protected void doOnDestroy()
  {
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.b();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.a(getClass());
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManagePopBar.b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_Boolean = true;
    try
    {
      getWindow().setSoftInputMode(48);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
      m();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected void e()
  {
    Object localObject = (ViewGroup)super.findViewById(2131297082);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131296706);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131297083);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void f()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      l();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        this.jdField_b_of_type_JavaUtilList.add(a((PublicAccountInfo)localIterator.next()));
      }
      if (localArrayList.size() < 15) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      continue;
      k();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      PAStartupTracker.a("pubAcc_follow_list_display", null, "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PublicAccountListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
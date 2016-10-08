package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.search.model.ContactSearchModelCircleBuddy;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import pfs;
import pft;
import pfy;
import pfz;
import pga;
import pgb;
import pgc;
import pgd;

public class PhoneContactSelectActivity
  extends SelectMemberActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "param_ip_pstn_enter_type";
  private static final String ah = "PhoneContactSelectActivity";
  public static final int b = 1;
  public static final String b = "param_uin_create_list";
  public static final int c = 2;
  public static final String c = "param_uin_selected_list";
  static final int jdField_d_of_type_Int = 0;
  public static final String d = "param_uin_selected_default_contact";
  static final int jdField_e_of_type_Int = 1;
  public static final String e = "param_uin_selected_default_friends";
  public static final int f = 2;
  public static final String f = "param_uin_divider_list";
  public static final int g = 3;
  public static final String g = "param_divider_title";
  public static final String h = "param_no_answer_list_default_selected";
  public static final String i = "param_ui_flag";
  public static final String j = "param_show_none_friends_in_contact";
  public static final String k = "param_phone_list";
  public PstnObserver a;
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  Thread jdField_a_of_type_JavaLangThread;
  public ArrayList a;
  public boolean a;
  TipsBar jdField_b_of_type_ComTencentMobileqqWidgetTipsBar;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean;
  public ArrayList c;
  boolean c;
  public ArrayList d;
  boolean jdField_d_of_type_Boolean;
  public ArrayList e;
  boolean jdField_e_of_type_Boolean;
  public ArrayList f;
  boolean f;
  boolean g;
  int h;
  int i;
  public String l;
  
  public PhoneContactSelectActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
    this.jdField_a_of_type_JavaLangThread = new pgd(this);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.i("PhoneContactSelectActivity", 1, "=== openPhoneContactSelectActivity mActivity is null");
      return;
    }
    Intent localIntent = new Intent(paramActivity, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_ui_flag", 0);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131369290));
    localIntent.putExtra("param_done_button_highlight_wording", paramActivity.getString(2131370215));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.putExtra("key_is_from_web", paramBoolean);
    localIntent.setFlags(603979776);
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(2130968590, 2130968591);
  }
  
  public static void a(Context paramContext, int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_ui_flag", 1);
    localIntent.putExtra("param_from", 1007);
    localIntent.putExtra("param_uin_divider_list", paramArrayList);
    localIntent.putExtra("param_title", paramContext.getString(2131372488));
    localIntent.putExtra("param_divider_title", paramContext.getString(paramInt2));
    localIntent.putExtra("param_entrance", 17);
    localIntent.putExtra("param_ip_pstn_enter_type", paramInt1);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    ((Activity)paramContext).startActivityForResult(localIntent, 110);
  }
  
  public static void a(Context paramContext, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_phone_list", paramArrayList1);
    localIntent.putParcelableArrayListExtra("param_uin_selected_list", paramArrayList2);
    localIntent.putExtra("param_entrance", 18);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.putExtra("param_done_button_wording", paramContext.getString(2131369290));
    localIntent.putExtra("param_done_button_highlight_wording", paramContext.getString(2131370215));
    localIntent.putExtra("param_report_type", paramInt);
    localIntent.setFlags(603979776);
    ((Activity)paramContext).startActivityForResult(localIntent, 111);
  }
  
  private boolean e()
  {
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((ResultRecord)localIterator.next()).jdField_a_of_type_Int == 5);
    for (int m = 1;; m = 0)
    {
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)) && (m != 0))
      {
        DialogUtil.a(this, 230, getString(2131363525), getString(2131368258), 2131363532, 2131363537, new pfz(this), new pga(this)).show();
        return true;
      }
      return false;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = true;
    if (this.jdField_i_of_type_JavaUtilArrayList.size() == 0) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.c.size() <= this.jdField_i_of_type_JavaUtilArrayList.size())
    {
      bool1 = bool2;
      if (this.ad != null)
      {
        Iterator localIterator = this.c.iterator();
        for (bool1 = true; localIterator.hasNext(); bool1 = false)
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          bool1 = bool2;
          if (!this.jdField_i_of_type_JavaUtilArrayList.contains(localResultRecord)) {
            break;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean g()
  {
    if (this.jdField_i_of_type_JavaUtilArrayList.size() == 0) {}
    while (this.c.size() != this.jdField_i_of_type_JavaUtilArrayList.size()) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        return bool;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (!this.jdField_i_of_type_JavaUtilArrayList.contains(localResultRecord)) {
        break;
      }
    }
    return bool;
  }
  
  protected ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.app.getManager(10);
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
      else if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+")))
      {
        localArrayList.add(localResultRecord);
      }
      else
      {
        PhoneContact localPhoneContact = localPhoneContactManager.a(localResultRecord.jdField_a_of_type_JavaLangString);
        if ((localPhoneContact != null) && (this.jdField_e_of_type_JavaUtilArrayList.contains(localPhoneContact.mobileNo))) {
          localArrayList.add(localResultRecord);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    setContentView(2130903436);
  }
  
  public void a(View paramView)
  {
    IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramView.getTag(2131296489);
    if (localIContactSearchModel == null) {}
    label732:
    for (;;)
    {
      return;
      Object localObject1 = localIContactSearchModel.a();
      paramView = localIContactSearchModel.a().toString();
      Object localObject2 = "";
      if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
        ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();
      }
      Object localObject3;
      if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact))
      {
        if (a())
        {
          DialogUtil.a(this, PstnUtils.b(this.app, 2), PstnUtils.c(this.app, 2), PstnUtils.d(this.app, 2), new pgb(this), getString(2131364005), new pgc(this)).show();
          return;
        }
        localObject2 = ((ContactSearchModelPhoneContact)localIContactSearchModel).a;
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin))
        {
          localObject1 = "pstn" + ((PhoneContact)localObject2).mobileNo;
          paramView = ((PhoneContact)localObject2).mobileNo;
          localObject3 = ((PhoneContact)localObject2).name;
          localObject2 = paramView;
          paramView = (View)localObject3;
        }
      }
      for (;;)
      {
        if (((this.jdField_g_of_type_JavaUtilArrayList != null) && (this.jdField_g_of_type_JavaUtilArrayList.contains(localObject1))) || (a((String)localObject1)) || (d()) || (a((String)localObject1, paramView))) {
          break label732;
        }
        localObject3 = (ContactFriendInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1) {
          if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 2, ((ContactFriendInnerFrame)localObject3).a()));
          }
        }
        for (;;)
        {
          o();
          i();
          ((ContactFriendInnerFrame)localObject3).f();
          a(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return;
          if (((PhoneContact)localObject2).uin.equals("0"))
          {
            paramView = ((PhoneContact)localObject2).nationCode + ((PhoneContact)localObject2).mobileCode;
            localObject1 = paramView;
            break;
          }
          localObject1 = ((PhoneContact)localObject2).uin;
          paramView = ((PhoneContact)localObject2).mobileNo;
          break;
          if ((localIContactSearchModel instanceof ContactSearchModelFriend)) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 0, "-1"));
          } else if ((localIContactSearchModel instanceof ContactSearchModelCircleBuddy)) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 3, "-1"));
          } else if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
            if ((((String)localObject1).startsWith("pstn")) && (b((String)localObject1, paramView, 5, "-1")))
            {
              this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 5, "-1", (String)localObject2));
            }
            else if (((String)localObject1).startsWith("+"))
            {
              this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 4, "-1"));
            }
            else
            {
              this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 0, "-1"));
              continue;
              if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 2) {
                this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 1, ((ContactFriendInnerFrame)localObject3).a()));
              } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 3) {
                this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 2, ((ContactFriendInnerFrame)localObject3).a()));
              } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) {
                if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact))
                {
                  if (((String)localObject1).startsWith("pstn"))
                  {
                    if (b((String)localObject1, paramView, 5, "-1")) {
                      this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 5, "-1", (String)localObject2));
                    }
                  }
                  else if (((String)localObject1).startsWith("+")) {
                    this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 4, "-1", (String)localObject2));
                  } else {
                    this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 0, "-1", (String)localObject2));
                  }
                }
                else if ((localIContactSearchModel instanceof ContactSearchModelFriend)) {
                  this.jdField_i_of_type_JavaUtilArrayList.add(a((String)localObject1, paramView, 0, "-1", (String)localObject2));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    if (this.Q == 10)
    {
      if ((this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.h == 2)) {}
    }
    else {
      while (((this.Q == 17) || (this.Q == 20) || (this.Q == 19) || (this.Q == 18)) && (!this.jdField_f_of_type_Boolean) && (this.h != 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.a(paramString))
    {
      bool1 = true;
      return bool1;
    }
    int m = 0;
    for (;;)
    {
      bool1 = bool2;
      if (m >= this.jdField_i_of_type_JavaUtilArrayList.size()) {
        break;
      }
      if (paramString.equals(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(m)).d)) {
        return true;
      }
      m += 1;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new pfs(this);
    if (this.app != null) {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    }
  }
  
  protected void d()
  {
    super.d();
    this.k = true;
    this.h = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_ui_flag", 0);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uin_selected_default_contact");
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uin_selected_default_friends");
    this.d = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_uin_create_list");
    this.jdField_e_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uin_divider_list");
    this.l = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_divider_title");
    this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_ip_pstn_enter_type", 2);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_answer_list_default_selected", true);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_none_friends_in_contact", true);
    this.jdField_f_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_phone_list");
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_is_from_web", false);
    this.c = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_uin_selected_list");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("NEED_CLOSE_WHEN_PSTN_CLOSE", false)) {
      c();
    }
    if (this.h == 0)
    {
      Object localObject = (PstnManager)this.app.getManager(142);
      if (localObject != null)
      {
        localObject = ((PstnManager)localObject).a(this.app.a());
        if ((localObject != null) && (((PstnCardInfo)localObject).pstn_ever_c2c_vip == 0) && (((PstnCardInfo)localObject).pstn_ever_multi_vip == 0) && (!PstnUtils.a(this.app, 2)) && (!PstnUtils.a(this.app, 1))) {
          this.h = 2;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.c != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter.a(this.c);
      a(true);
      o();
      i();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_e_of_type_Boolean = PstnUtils.a(this.app, 1);
    this.jdField_f_of_type_Boolean = PstnUtils.a(this.app, 2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)findViewById(2131298593));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(this);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)findViewById(2131298592));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  protected void f()
  {
    super.f();
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new pft(this));
  }
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new pfy(this));
  }
  
  public void h()
  {
    switch (this.N)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    }
    Object localObject2;
    ResultRecord localResultRecord;
    if (this.s)
    {
      localObject1 = this.jdField_g_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = ((String)localObject2);
        localResultRecord.jdField_a_of_type_Int = 0;
        localResultRecord.c = "-1";
        this.jdField_i_of_type_JavaUtilArrayList.add(localResultRecord);
      }
    }
    if (this.d != null)
    {
      localObject1 = this.d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        if (!this.jdField_i_of_type_JavaUtilArrayList.contains(localObject2)) {
          this.jdField_i_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
    }
    int i2 = this.jdField_i_of_type_JavaUtilArrayList.size();
    Object localObject1 = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int n = 0;
    label229:
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResultRecord)((Iterator)localObject1).next();
      if ((((ResultRecord)localObject2).jdField_a_of_type_Int == 5) || (((ResultRecord)localObject2).jdField_a_of_type_Int == 4) || (((ResultRecord)localObject2).jdField_a_of_type_Int == 0))
      {
        if ((((ResultRecord)localObject2).d == null) || (((ResultRecord)localObject2).d.equals("")) || (i1 != 0)) {
          break label1049;
        }
        m = 1;
      }
    }
    for (;;)
    {
      i1 = m;
      break label229;
      if (n == 0)
      {
        m = i1;
        n = 1;
        continue;
        if (((this.O == 0) && (i2 == 1) && (this.Q == 10)) || ((this.Q == 18) && (i2 == 1) && (TextUtils.isEmpty(this.ad))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContactSelectActivity", 2, "start C2C audio");
          }
          localResultRecord = (ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0);
          m = localResultRecord.jdField_a_of_type_Int;
          localObject2 = null;
          if (localResultRecord.jdField_a_of_type_Int == 0)
          {
            m = 0;
            localObject1 = localObject2;
          }
          for (;;)
          {
            if (i1 != 0) {
              break label582;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactSelectActivity", 2, "start c2c call.");
            }
            if (!ChatActivityUtils.a(this.app, this, 0, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.b, null, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 9, true)) {
              break;
            }
            this.S = 2;
            finish();
            return;
            if (localResultRecord.jdField_a_of_type_Int == 1)
            {
              m = 1000;
              localObject1 = a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c);
            }
            else if (localResultRecord.jdField_a_of_type_Int == 2)
            {
              m = 1004;
              localObject1 = ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c;
            }
            else if (localResultRecord.jdField_a_of_type_Int == 3)
            {
              m = 1021;
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              if (localResultRecord.jdField_a_of_type_Int == 4)
              {
                m = 1006;
                localObject1 = localObject2;
              }
            }
          }
          label582:
          if ((i1 != 0) && ((!PstnUtils.a(this.app, 2)) || (PstnUtils.a(this.app, 1))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactSelectActivity", 2, "start c2c call.");
            }
            localObject2 = localResultRecord.d;
            if (!ChatActivityUtils.a(this.app, this, m, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.b, (String)localObject2, true, (String)localObject1, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 9, true)) {
              break;
            }
            if (this.jdField_g_of_type_Boolean) {
              ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 12, 0, "", "", "", "");
            }
            for (;;)
            {
              this.S = 2;
              finish();
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 1, 0, "", "", "", "");
            }
          }
        }
        if (this.Q == 18)
        {
          if (g())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("audioType", 2);
            ((Intent)localObject1).putExtra("uinType", 3000);
            ((Intent)localObject1).putExtra("roomId", this.ad);
            ((Intent)localObject1).putExtra("qqPhoneUserList", this.jdField_f_of_type_JavaUtilArrayList);
            ((Intent)localObject1).putExtra("from", 3);
            ((Intent)localObject1).putExtra("callType", 2);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
          }
          if (f()) {}
          for (m = 2131368254;; m = 2131368255)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(m);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            this.jdField_a_of_type_JavaLangThread.setName("PhoneContactSelectActivity_addDiscussion");
            ThreadManager.a(this.jdField_a_of_type_JavaLangThread, null, false);
            return;
          }
        }
        if ((this.O == 0) || (this.O == 1) || (n != 0)) {
          if (this.O != 0) {
            break label1041;
          }
        }
        label1041:
        for (m = 2131368254;; m = 2131368255)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(m);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          this.jdField_a_of_type_JavaLangThread.setName("SelectMemberActivity_addDiscussion");
          ThreadManager.a(this.jdField_a_of_type_JavaLangThread, null, false);
          if (this.O == 0) {
            break;
          }
          p();
          if (n != 0) {
            break;
          }
          finish();
          return;
        }
      }
      label1049:
      m = i1;
    }
  }
  
  protected boolean onBackEvent()
  {
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return true;
    case 0: 
      finish();
      return true;
    case 1: 
      n();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    }
    n();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298594: 
    case 2131298595: 
    default: 
      return;
    }
    PstnUtils.a(this.app, this, 2, 1);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\PhoneContactSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
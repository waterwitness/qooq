package com.tencent.mobileqq.activity.recent;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.C2CCallToGroupCall;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.t9search.T9KeyBoard;
import com.tencent.mobileqq.t9search.T9KeyBoard.onKeyClickListener;
import com.tencent.mobileqq.t9search.T9SearchResultAdapter;
import com.tencent.mobileqq.t9search.T9SearchableData;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import oxt;
import oxu;
import oxv;
import oxw;
import oxx;
import oxy;
import oxz;
import oya;
import oyb;

public class RecentT9SearchActivity
  extends FragmentActivity
  implements View.OnClickListener, T9KeyBoard.onKeyClickListener, AbsListView.OnScrollListener
{
  public static final int a = 10;
  public static final String a = "key_is_from_try";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "key_is_from_web";
  private static final int jdField_c_of_type_Int = 1;
  private static final String f = "RecentT9SearchActivity";
  protected Handler.Callback a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private C2CCallToGroupCall jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall;
  protected ChatActivityUtils.StartVideoListener a;
  private T9KeyBoard jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard;
  public T9SearchResultAdapter a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  public List a;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private TextView d;
  public String d;
  private TextView e;
  public String e;
  private String g;
  
  public RecentT9SearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new oxt(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new oxu(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new oxv(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private int a(String paramString)
  {
    switch (PstnUtils.a(paramString, true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131370208;
    case 1: 
      return 2131370209;
    case 2: 
      return 2131370210;
    case 3: 
      return 2131370211;
    case 4: 
      return 2131370212;
    case 5: 
      return 2131370213;
    }
    return 2131370214;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length())
      {
        if ((i == 0) && (paramString.charAt(0) == '+')) {
          localStringBuilder.append('+');
        }
        for (;;)
        {
          i += 1;
          break;
          if (Character.isDigit(paramString.charAt(i))) {
            localStringBuilder.append(paramString.charAt(i));
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void a(T9SearchableData paramT9SearchableData)
  {
    if (paramT9SearchableData == null) {}
    label322:
    label498:
    label765:
    label850:
    label1015:
    label1135:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RecentT9SearchActivity", 2, "startCall|" + paramT9SearchableData);
      }
      this.g = paramT9SearchableData.e;
      Object localObject1;
      Object localObject2;
      if (paramT9SearchableData.o == 0) {
        if (ChatActivityUtils.a(this.app, 0, paramT9SearchableData.h))
        {
          localObject1 = new PstnSessionInfo();
          ((PstnSessionInfo)localObject1).jdField_a_of_type_Int = paramT9SearchableData.o;
          ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramT9SearchableData.a();
          ((PstnSessionInfo)localObject1).b = paramT9SearchableData.e;
          if ((((PstnSessionInfo)localObject1).b == null) && (((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString != null))
          {
            localObject2 = ((PhoneContactManager)this.app.getManager(10)).a(paramT9SearchableData.h);
            if (localObject2 != null) {
              ((PstnSessionInfo)localObject1).b = ((PhoneContact)localObject2).mobileNo;
            }
          }
          ((PstnSessionInfo)localObject1).jdField_d_of_type_JavaLangString = paramT9SearchableData.b();
          localObject2 = ((PhoneContactManager)this.app.getManager(10)).a();
          ((PstnSessionInfo)localObject1).jdField_c_of_type_JavaLangString = (((RespondQueryQQBindingStat)localObject2).nationCode + ((RespondQueryQQBindingStat)localObject2).mobileNo);
          if ((!PstnUtils.a(this.app, 1)) && (PstnUtils.a(this.app, 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall = new C2CCallToGroupCall();
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.app, this, getIntent(), getActivity(), ((PstnSessionInfo)localObject1).jdField_c_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_d_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_a_of_type_Int, ((PstnSessionInfo)localObject1).b, 5);
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this, true);
            if (!this.jdField_b_of_type_Boolean) {
              break label498;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 13, 0, "", "", "", "");
            if (paramT9SearchableData.j == 4) {
              b(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            }
            if (!TextUtils.isEmpty(this.g)) {
              SharedPreUtils.c(this, this.app.a(), this.g);
            }
            this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.a();
            if (paramT9SearchableData.j != 1) {
              break label1015;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X80063F2", "0X80063F2", 3, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label1135;
        }
        finish();
        return;
        ChatActivityUtils.a(this.app, this, 0, paramT9SearchableData.h, paramT9SearchableData.b(), ((PstnSessionInfo)localObject1).b, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 5, true);
        break;
        ChatActivityUtils.a(this.app, this, 0, paramT9SearchableData.h, paramT9SearchableData.b(), paramT9SearchableData.e, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 5, true);
        break;
        ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 8, 0, "", "", "", "");
        break label322;
        if ((paramT9SearchableData.o == 1006) || (paramT9SearchableData.o == 56938) || (paramT9SearchableData.o == 2016))
        {
          localObject1 = new PstnSessionInfo();
          ((PstnSessionInfo)localObject1).jdField_a_of_type_Int = paramT9SearchableData.o;
          ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramT9SearchableData.a();
          ((PstnSessionInfo)localObject1).b = paramT9SearchableData.e;
          if ((((PstnSessionInfo)localObject1).b == null) && (((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString != null) && (a(((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString) == 0)) {
            ((PstnSessionInfo)localObject1).b = ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString;
          }
          ((PstnSessionInfo)localObject1).jdField_d_of_type_JavaLangString = paramT9SearchableData.b();
          localObject2 = ((PhoneContactManager)this.app.getManager(10)).a();
          ((PstnSessionInfo)localObject1).jdField_c_of_type_JavaLangString = (((RespondQueryQQBindingStat)localObject2).nationCode + ((RespondQueryQQBindingStat)localObject2).mobileNo);
          if ((!PstnUtils.a(this.app, 1)) && (PstnUtils.a(this.app, 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall = new C2CCallToGroupCall();
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.app, this, getIntent(), getActivity(), ((PstnSessionInfo)localObject1).jdField_c_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_d_of_type_JavaLangString, ((PstnSessionInfo)localObject1).jdField_a_of_type_Int, ((PstnSessionInfo)localObject1).b, 4);
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this, true);
            if (!this.jdField_b_of_type_Boolean) {
              break label850;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 13, 0, "", "", "", "");
          }
          for (;;)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X80063F2", "0X80063F2", 3, 0, "", "", "", "");
            break;
            ChatActivityUtils.a(this.app, this, (PstnSessionInfo)localObject1, 5);
            break label765;
            ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 8, 0, "", "", "", "");
          }
        }
        if (paramT9SearchableData.o != 3000) {
          break label322;
        }
        if (!TextUtils.isEmpty(paramT9SearchableData.i))
        {
          localObject1 = new ArrayList();
          localObject2 = PstnUtils.a(paramT9SearchableData.i);
          if (localObject2 != null)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add(((AVPhoneUserInfo)((Iterator)localObject2).next()).telInfo.mobile);
            }
          }
          ChatActivityUtils.a(this.app, this, paramT9SearchableData.o, paramT9SearchableData.h, true, true, true, null, (ArrayList)localObject1, 2, 3);
          break label322;
        }
        ChatActivityUtils.a(this.app, this, paramT9SearchableData.o, paramT9SearchableData.h, true, true, true, null, null, 2, 3);
        break label322;
        if (paramT9SearchableData.j == 3)
        {
          if (paramT9SearchableData.o == 0) {
            ReportController.b(this.app, "CliOper", "", "", "0X80063F2", "0X80063F2", 2, 0, "", "", "", "");
          } else {
            ReportController.b(this.app, "CliOper", "", "", "0X80063F2", "0X80063F2", 1, 0, "", "", "", "");
          }
        }
        else if (paramT9SearchableData.j == 2) {
          ReportController.b(this.app, "CliOper", "", "", "0X80063F2", "0X80063F2", 4, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = SharedPreUtils.a(this, this.app.a());
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setString(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentT9SearchActivity", 2, "startCall|phoneNumber is empty.");
      }
    }
    for (;;)
    {
      return;
      paramString = paramString.replace("-", "").replace(" ", "");
      int i = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("RecentT9SearchActivity", 2, "startCall|result:" + i);
      }
      if (i != 0) {
        QQToast.a(this, 0, i, 0).a();
      }
      while (this.jdField_b_of_type_Boolean)
      {
        finish();
        return;
        Object localObject = (PhoneContactManager)this.app.getManager(10);
        PstnSessionInfo localPstnSessionInfo = new PstnSessionInfo();
        RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)localObject).a();
        if (localRespondQueryQQBindingStat != null) {
          localPstnSessionInfo.jdField_c_of_type_JavaLangString = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
        }
        if (((localPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (localPstnSessionInfo.jdField_c_of_type_JavaLangString.equals(paramString))) || ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.mobileNo.equals(paramString))))
        {
          QQToast.a(this, 2131364030, 0).b(getResources().getDimensionPixelSize(2131492908));
          return;
        }
        localObject = ((PhoneContactManager)localObject).b(paramString);
        if (localObject != null) {
          if ((!TextUtils.isEmpty(((PhoneContact)localObject).uin)) && (!"0".equals(((PhoneContact)localObject).uin)))
          {
            localPstnSessionInfo.jdField_a_of_type_Int = 0;
            label299:
            localPstnSessionInfo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject).uin;
            localPstnSessionInfo.b = ((PhoneContact)localObject).mobileNo;
            localPstnSessionInfo.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject).name;
            label323:
            if ((TextUtils.isEmpty(localPstnSessionInfo.jdField_a_of_type_JavaLangString)) || (localPstnSessionInfo.jdField_a_of_type_JavaLangString.equals("0"))) {
              localPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
            }
            if ((PstnUtils.a(this.app, 1)) || (!PstnUtils.a(this.app, 2))) {
              break label576;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall = new C2CCallToGroupCall();
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.app, this, getIntent(), getActivity(), localPstnSessionInfo.jdField_c_of_type_JavaLangString, localPstnSessionInfo.jdField_a_of_type_JavaLangString, localPstnSessionInfo.jdField_d_of_type_JavaLangString, localPstnSessionInfo.jdField_a_of_type_Int, localPstnSessionInfo.b, 4);
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this, true);
          }
        }
        label576:
        for (boolean bool = true;; bool = ChatActivityUtils.a(this.app, this, localPstnSessionInfo, 4))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentT9SearchActivity", 2, "startCall|ret=" + bool + " sessionInfo=" + localPstnSessionInfo);
          }
          SharedPreUtils.c(this, this.app.a(), paramString);
          this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.a();
          if (!this.jdField_b_of_type_Boolean) {
            break label591;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 11, 0, "", "", "", "");
          break;
          localPstnSessionInfo.jdField_a_of_type_Int = 56938;
          break label299;
          localPstnSessionInfo.jdField_a_of_type_JavaLangString = paramString;
          localPstnSessionInfo.b = paramString;
          localPstnSessionInfo.jdField_a_of_type_Int = 2016;
          localPstnSessionInfo.jdField_d_of_type_JavaLangString = paramString;
          break label323;
        }
        label591:
        ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 10, 0, "", "", "", "");
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard = ((T9KeyBoard)findViewById(2131299454));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299441));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299442));
    this.e = ((TextView)findViewById(2131299448));
    if (this.jdField_b_of_type_Boolean) {
      this.e.setText(getString(2131372456));
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299440));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299444));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299445));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299447));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299451));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131299450));
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter = new T9SearchResultAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299446));
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setAttachEditText(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setOnKeyClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    f();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
  }
  
  private void e()
  {
    if (!PstnUtils.a(this.app, this))
    {
      Intent localIntent = new Intent(this, PhoneContactSelectActivity.class);
      localIntent.putExtra("param_ui_flag", 1);
      localIntent.putExtra("param_type", 3000);
      localIntent.putExtra("param_subtype", 0);
      localIntent.putExtra("param_entrance", 10);
      localIntent.putExtra("param_from", 1003);
      localIntent.putExtra("param_done_button_wording", getString(2131369290));
      localIntent.putExtra("param_done_button_highlight_wording", getString(2131370215));
      localIntent.putExtra("param_max", 99);
      localIntent.putExtra("param_exit_animation", 1);
      localIntent.putExtra("param_back_button_side", 0);
      localIntent.putExtra("key_is_from_web", this.jdField_b_of_type_Boolean);
      localIntent.setFlags(603979776);
      startActivityForResult(localIntent, 1400);
      overridePendingTransition(2130968590, 2130968591);
    }
  }
  
  private void f()
  {
    InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(100);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localLengthFilter });
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new oxx(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new oxy(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new oxz(this));
    if (VersionUtils.e()) {
      this.jdField_a_of_type_AndroidWidgetEditText.setTextIsSelectable(true);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setAttachEditText(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new oya(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843376, 0, 0);
  }
  
  public void a(char paramChar) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    while ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_JavaLangString = PhoneNumberUtil.a(paramString);
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter.a();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
    new oyb(this, null).execute(new String[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80063F0", "0X80063F0", 0, 0, "", "", "", "");
    if (paramString.equals("PASTE")) {
      c();
    }
    while (!paramBoolean) {
      return;
    }
    a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.a(new oxw(this, paramBoolean), 5, null, false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843377, 0, 0);
  }
  
  public void c()
  {
    Object localObject2 = null;
    Object localObject1;
    if (VersionUtils.e())
    {
      localObject1 = (android.content.ClipboardManager)getSystemService("clipboard");
      if (!((android.content.ClipboardManager)localObject1).hasPrimaryClip()) {
        break label162;
      }
      localObject1 = ((android.content.ClipboardManager)localObject1).getPrimaryClip().getItemAt(0).getText();
      if (localObject1 == null) {
        break label162;
      }
      localObject1 = ((CharSequence)localObject1).toString();
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(((String)localObject1).trim())))
      {
        QQToast.a(this, 2131372461, 0).a();
        return;
        android.text.ClipboardManager localClipboardManager = (android.text.ClipboardManager)getSystemService("clipboard");
        localObject1 = localObject2;
        if (localClipboardManager.hasText())
        {
          localObject1 = localObject2;
          if (localClipboardManager.getText() != null) {
            localObject1 = localClipboardManager.getText().toString();
          }
        }
      }
      else
      {
        localObject1 = PhoneNumberUtil.b((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QQToast.a(this, 2131372461, 0).a();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.a(this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd(), (String)localObject1);
        return;
        label162:
        localObject1 = null;
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1400) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("roomId");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("qqPhoneUserList");
      paramInt1 = paramIntent.getIntExtra("callType", 2);
      paramInt2 = paramIntent.getIntExtra("from", 6);
      ChatActivityUtils.a(this.app, this, 3000, str, true, true, true, null, localArrayList, paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        finish();
      }
      return;
      if ((paramInt1 == 2002) && (paramInt2 == -1)) {
        a(true);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_is_from_try", true);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_is_from_web", false);
    super.doOnCreate(paramBundle);
    setContentView(2130903613);
    paramBundle = (ViewGroup)findViewById(2131299437);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      paramBundle.setFitsSystemWindows(true);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131428295));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    d();
    a(PstnUtils.a(this.app));
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (((PstnManager)this.app.getManager(142)).b() != 1) {
      finish();
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131427709);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.a(i);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.b(i);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968593);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299442: 
    case 2131299443: 
    default: 
      return;
    case 2131299441: 
      if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.getVisibility() == 0)
      {
        a();
        return;
      }
      b();
      return;
    case 2131299440: 
      ReportController.b(this.app, "CliOper", "", "", "0X80063F1", "0X80063F1", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter.getCount() > 0)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter.a(0);
        if (paramView.jdField_a_of_type_Boolean)
        {
          a(paramView);
          return;
        }
      }
      b(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
    case 2131299444: 
      finish();
      return;
    }
    e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentT9SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
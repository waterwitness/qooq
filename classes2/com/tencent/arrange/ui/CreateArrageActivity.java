package com.tencent.arrange.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.arrange.op.ArrangeResult;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import gdf;
import gdh;
import gdi;
import gdj;
import gdk;
import gdl;
import gdm;
import gdn;
import gdo;
import gdp;
import gdq;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CreateArrageActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, ArrangeResult
{
  static final String jdField_a_of_type_JavaLangString = "memberUin";
  static final String jdField_b_of_type_JavaLangString = "memberName";
  static final String jdField_c_of_type_JavaLangString = "faceId";
  static final String jdField_d_of_type_JavaLangString = "pinyin";
  static final String jdField_e_of_type_JavaLangString = "isDiscussionMember";
  private static final String jdField_f_of_type_JavaLangString = CreateArrageActivity.class.getSimpleName();
  private static final int m = 0;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrangeHandler jdField_a_of_type_ComTencentArrangeOpArrangeHandler;
  private MeetingInfo jdField_a_of_type_ComTencentArrangeOpMeetingInfo;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  private gdn jdField_a_of_type_Gdn;
  private gdq jdField_a_of_type_Gdq;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 15;
  private long jdField_b_of_type_Long;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private IphonePickerView jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private gdn jdField_b_of_type_Gdn;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private int jdField_f_of_type_Int;
  private final int jdField_g_of_type_Int = 3;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 2;
  private final int i = 4;
  private final int j = 9;
  private int k;
  private int l;
  private int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CreateArrageActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new gdj(this);
  }
  
  private String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format("%d-%02d-%02d %02d:%02d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)), Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
  }
  
  private List a()
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.app.getManager(52);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getParticipants().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      DiscussionMemberInfo localDiscussionMemberInfo = localDiscussionManager.a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getDiscuss_uin(), str);
      if (localDiscussionMemberInfo != null)
      {
        localArrayList.add(localDiscussionMemberInfo);
      }
      else
      {
        QLog.i("CreateArrageActivity", 2, "discussion info of uin: " + str + " cannot be getted");
        localDiscussionMemberInfo = new DiscussionMemberInfo();
        Friends localFriends = ((FriendsManager)this.app.getManager(50)).c(str);
        if (localFriends != null)
        {
          localDiscussionMemberInfo.memberUin = str;
          localDiscussionMemberInfo.discussionUin = "";
          localDiscussionMemberInfo.memberName = localFriends.getFriendNick();
        }
        for (localDiscussionMemberInfo.inteRemark = localFriends.remark;; localDiscussionMemberInfo.inteRemark = str)
        {
          localArrayList.add(localDiscussionMemberInfo);
          break;
          localDiscussionMemberInfo.memberUin = str;
          localDiscussionMemberInfo.discussionUin = "";
          localDiscussionMemberInfo.memberName = str;
        }
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    h();
    b();
  }
  
  private void a(int paramInt)
  {
    if (((paramInt == 0) || (paramInt == 1)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    }
    if (((paramInt == 0) || (paramInt == 2)) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if (paramIntent != null)
      {
        if (paramIntent.size() > 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8005563", "0X8005563", 0, 0, "", "", "", "");
        }
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          Object localObject = (ResultRecord)paramIntent.next();
          if (!TextUtils.isEmpty(((ResultRecord)localObject).a))
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
            this.jdField_a_of_type_JavaUtilArrayList.add(((ResultRecord)localObject).a);
            HashMap localHashMap = new HashMap();
            localHashMap.put("memberUin", ((ResultRecord)localObject).a);
            localHashMap.put("memberName", ((ResultRecord)localObject).b);
            localHashMap.put("pinyin", ((ResultRecord)localObject).c);
            localHashMap.put("isDiscussionMember", Boolean.valueOf(false));
            localObject = ((FriendsManager)this.app.getManager(50)).c(((ResultRecord)localObject).a);
            if (localObject != null) {
              localHashMap.put("faceId", Short.valueOf(((Friends)localObject).faceid));
            }
            this.jdField_a_of_type_JavaUtilList.add(localHashMap);
          }
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() > this.k) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)) {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        }
      }
    } while (this.jdField_a_of_type_Gdq == null);
    this.jdField_a_of_type_Gdq.notifyDataSetChanged();
  }
  
  private void a(IphonePickerView paramIphonePickerView, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i1 = localCalendar.get(6);
    int i2 = localCalendar.get(11);
    int i3 = localCalendar.get(12);
    paramIphonePickerView.setSelection(0, i1 - 1);
    paramIphonePickerView.setSelection(1, i2);
    paramIphonePickerView.setSelection(2, i3 / this.jdField_b_of_type_Int);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(20.0F * f1);
    int i5 = (int)(20.0F * f1);
    int i3 = (int)(66.0F * f1);
    int i4 = (int)(50.0F * f1);
    i5 = (i1 - i2) / (i5 + i4);
    i1 = (i1 - i2 - i5 * i3 - (i3 - i4)) / (i5 + 1) + (i3 - i4) / 2;
    i2 = (int)(f1 * 20.0F);
    this.jdField_c_of_type_Int = i1;
    this.jdField_d_of_type_Int = i1;
    this.e = i2;
    this.jdField_f_of_type_Int = i2;
    paramMyGridView.setPadding(this.jdField_c_of_type_Int, this.e, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130843277);
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      ThreadManager.a(new gdl(this, paramString), 8, null, false);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    boolean bool = localInputMethodManager.isActive();
    if ((bool) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    return bool;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        return true;
        if (paramInt == 2) {
          paramInt = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility();
        }
      }
      else
      {
        return false;
      }
      paramInt = 0;
    }
  }
  
  private boolean a(long paramLong)
  {
    return paramLong < NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void b()
  {
    super.setTitle(2131365083);
    Object localObject = (TextView)findViewById(2131297083);
    ((TextView)localObject).setText(2131365086);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = (TextView)findViewById(2131297183);
      ((TextView)localObject).setText(2131365085);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener(this);
    }
    do
    {
      return;
      localObject = (ImageView)super.findViewById(2131297836);
    } while (localObject == null);
    ((ImageView)localObject).setVisibility(8);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      a(2);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestFocus();
        a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 2);
      a(1);
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestFocus();
    a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_b_of_type_Long);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() > 0) || (this.jdField_a_of_type_JavaUtilList.size() > this.k) || (this.jdField_c_of_type_Long != this.jdField_a_of_type_Long) || (this.jdField_d_of_type_Long != this.jdField_b_of_type_Long);
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    localQQProgressDialog.b(2131368255);
    localQQProgressDialog.show();
  }
  
  private void d()
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("forward_type");
    if (str == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = 3000;
      if (str.equals("create_mode"))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("uin");
        return;
      }
    } while (!str.equals("details_mode"));
    this.jdField_a_of_type_Boolean = false;
    try
    {
      long l1 = Long.parseLong(localIntent.getStringExtra("uin"));
      long l2 = Long.parseLong(localIntent.getStringExtra("forward_seq"));
      this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.a(l1, l2, this);
      return;
    }
    catch (Exception localException)
    {
      finish();
    }
  }
  
  private void e()
  {
    a(this.jdField_g_of_type_JavaLangString);
  }
  
  private void f()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    Intent localIntent = TroopMemberListActivity.a(this, this.jdField_g_of_type_JavaLangString, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void g() {}
  
  private void h()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    View localView1 = View.inflate(this, 2130903574, null);
    XListView localXListView = (XListView)localView1.findViewById(2131297613);
    localXListView.setDivider(null);
    localXListView.setVerticalScrollBarEnabled(false);
    localXListView.setPadding(0, 0, 0, 0);
    View localView2 = View.inflate(this, 2130903536, null);
    Object localObject2 = (LinearLayout)localView2.findViewById(2131298976);
    LinearLayout localLinearLayout1 = (LinearLayout)localView2.findViewById(2131298970);
    Object localObject1 = (TextView)localView2.findViewById(2131299093);
    LinearLayout localLinearLayout2 = (LinearLayout)localView2.findViewById(2131298992);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView2.findViewById(2131299094));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView2.findViewById(2131298998));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView2.findViewById(2131297562));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005561", "0X8005561", 0, 0, "", "", "", "");
      ((LinearLayout)localObject2).setVisibility(0);
      ((LinearLayout)localObject2).setOnTouchListener(this);
      localLinearLayout1.setVisibility(8);
      ((TextView)localObject1).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localLinearLayout2.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localView2.findViewById(2131298323));
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      }
      ((RelativeLayout)localView2.findViewById(2131299091)).setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131298977));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(50));
      }
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      i();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView2.findViewById(2131298980));
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnTouchListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag("begin_time");
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView2.findViewById(2131298988));
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnTouchListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag("end_time");
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)localView2.findViewById(2131298982));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131428291));
        localObject1 = new gdo(this, null);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a((IphonePickerView.PickerViewAdapter)localObject1);
        this.jdField_a_of_type_Gdn = new gdn(this, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_Gdn);
      }
      this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)localView2.findViewById(2131298990));
      if (this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131428291));
        localObject1 = new gdo(this, null);
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a((IphonePickerView.PickerViewAdapter)localObject1);
        this.jdField_b_of_type_Gdn = new gdn(this, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_b_of_type_Gdn);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView2.findViewById(2131298981));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView2.findViewById(2131298989));
      a(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      localXListView.setAdapter(new XSimpleListAdapter(localView2));
      if (this.jdField_a_of_type_Int != 1) {
        break label1239;
      }
      g();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      this.jdField_a_of_type_Gdq = new gdq(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Gdq);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.l, this.l);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14, -1);
      super.setContentView(localView1);
      super.setContentBackgroundResource(2130837958);
      if (this.jdField_a_of_type_Gdn != null)
      {
        long l1 = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Gdn.a(this.jdField_b_of_type_Long);
        this.jdField_a_of_type_Gdn.a(l1);
      }
      return;
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout1.setVisibility(0);
      ((TextView)localObject1).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView2.findViewById(2131298975));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getEnable() == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005570", "0X8005570", 0, 0, "", "", "", "");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838983);
      }
      for (;;)
      {
        ((TextView)localView2.findViewById(2131298973)).setText(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getFormatTime());
        ((TextView)localView2.findViewById(2131298974)).setText(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getIntroduction());
        localObject2 = ((FriendsManager)this.app.getManager(50)).c(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getCreator_uin());
        if (localObject2 == null) {
          break label1205;
        }
        ((TextView)localObject1).setText("发起人：" + ((Friends)localObject2).getFriendNick());
        break;
        if (a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getBegin_time()))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8005571", "0X8005571", 0, 0, "", "", "", "");
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838984);
        }
        else if (this.app.a().equals(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getCreator_uin()))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800556D", "0X800556D", 0, 0, "", "", "", "");
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        }
        else
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800556F", "0X800556F", 0, 0, "", "", "", "");
        }
      }
      label1205:
      ((TextView)localObject1).setText("发起人：" + this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getCreator_uin());
      break;
      label1239:
      if (this.jdField_a_of_type_Int == 3000) {
        e();
      }
    }
  }
  
  private void i()
  {
    long l1 = (NetConnInfoCenter.getServerTimeMillis() / 60000L + 10L + 29L) / 30L * 30L;
    this.jdField_c_of_type_Long = (l1 * 60L * 1000L);
    this.jdField_d_of_type_Long = ((l1 + 60L) * 60L * 1000L);
    this.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    this.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {}
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, EditMemberActivity.class);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_JavaUtilList);
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("list", localArrayList);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("jump_from", 1);
      startActivityForResult(localIntent, 4);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_f_of_type_JavaLangString, 2, localException.toString());
    }
  }
  
  private void k()
  {
    a();
    Object localObject1 = "";
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() <= 0) {
      localObject1 = getString(2131365093);
    }
    while (((String)localObject1).length() > 0)
    {
      localObject2 = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject2).setTitle(getString(2131365094));
      ((QQCustomDialog)localObject2).getMessageTextView().setGravity(1);
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).setPositiveButton(2131365090, new gdm(this));
      ((QQCustomDialog)localObject2).show();
      return;
      if (a(this.jdField_a_of_type_Long)) {
        localObject1 = getString(2131365095);
      } else if (this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long) {
        localObject1 = getString(2131365096);
      }
    }
    a(0);
    a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilArrayList);
    ReportController.b(this.app, "CliOper", "", "", "0X8005569", "0X8005569", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_JavaUtilList.size() > this.k) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005564", "0X8005564", 0, 0, "", "", "", "");
    }
    localObject1 = new MeetingInfo();
    ((MeetingInfo)localObject1).setDiscuss_uin(this.jdField_g_of_type_JavaLangString);
    ((MeetingInfo)localObject1).setCreator_uin(this.app.a());
    ((MeetingInfo)localObject1).setBegin_time(this.jdField_a_of_type_Long);
    ((MeetingInfo)localObject1).setEnd_time(this.jdField_b_of_type_Long);
    Object localObject2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject2).add((String)localIterator.next());
    }
    ((MeetingInfo)localObject1).setParticipants((ArrayList)localObject2);
    ((MeetingInfo)localObject1).setIntroduction(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.a((MeetingInfo)localObject1, this);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.n = paramInt1;
    runOnUiThread(new gdf(this));
  }
  
  void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = ((MeetingInfo)paramList.get(0));
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getDiscuss_uin();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getBegin_time();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getEnd_time();
      runOnUiThread(new gdi(this));
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ThreadManager.a(new gdk(this, paramArrayList, paramString), 5, null, false);
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
      Object localObject1 = new DiscussionMemberInfo();
      int i1 = 0;
      DiscussionMemberInfo localDiscussionMemberInfo;
      label117:
      Object localObject2;
      if (i1 < paramList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.get(i1);
        if (localDiscussionMemberInfo != null)
        {
          if (!localDiscussionMemberInfo.memberUin.equals(this.app.a())) {
            break label117;
          }
          ((DiscussionMemberInfo)localObject1).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a(this.app, localDiscussionMemberInfo);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.app);
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject2).memberName, 1);
          localArrayList.add(localObject2);
        }
      }
      Collections.sort(localArrayList, new gdp(this, null));
      localArrayList.add(0, localObject1);
      paramList = new ArrayList();
      localObject1 = new ArrayList();
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i1);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("memberUin", localDiscussionMemberInfo.memberUin);
        ((HashMap)localObject2).put("memberName", localDiscussionMemberInfo.memberName);
        ((HashMap)localObject2).put("isDiscussionMember", Boolean.valueOf(true));
        if (i1 > 0) {
          ((HashMap)localObject2).put("pinyin", localDiscussionMemberInfo.discussionUin);
        }
        Friends localFriends = localFriendsManager.c(localDiscussionMemberInfo.memberUin);
        if (localFriends != null) {
          ((HashMap)localObject2).put("faceId", Short.valueOf(localFriends.faceid));
        }
        paramList.add(localObject2);
        ((ArrayList)localObject1).add(localDiscussionMemberInfo.memberUin);
        i1 += 1;
      }
      if (paramList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        paramList.clear();
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(50 - i1));
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      runOnUiThread(new gdh(this));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateArrageActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (this.jdField_a_of_type_Gdq == null);
              this.jdField_a_of_type_Gdq.notifyDataSetChanged();
              return;
              a(paramIntent);
              return;
            } while (paramIntent == null);
            paramIntent = paramIntent.getStringArrayListExtra("result_list");
          } while ((paramIntent == null) || (paramIntent.size() == 0));
          ReportController.b(this.app, "CliOper", "", "", "0X8005566", "0X8005566", 0, 0, "", "", "", "");
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            if (paramIntent.contains((String)localIterator.next())) {
              localIterator.remove();
            }
          }
          localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            if (paramIntent.contains(((ResultRecord)localIterator.next()).a)) {
              localIterator.remove();
            }
          }
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            if (paramIntent.contains(((HashMap)localIterator.next()).get("memberUin").toString())) {
              localIterator.remove();
            }
          }
          this.jdField_a_of_type_Gdq.notifyDataSetChanged();
        } while ((this.jdField_a_of_type_JavaUtilList.size() != this.k) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem == null));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Gdq == null);
    this.jdField_a_of_type_Gdq.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler = ((ArrangeHandler)this.app.a(61));
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      h();
      b();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298980: 
      a();
      if (!a(1))
      {
        b(1);
        return;
      }
      a(1);
      return;
    case 2131298988: 
      a();
      if (!a(2))
      {
        b(2);
        return;
      }
      a(2);
      return;
    case 2131299094: 
      ReportController.b(this.app, "CliOper", "", "", "0X8005565", "0X8005565", 0, 0, "", "", "", "");
      j();
      return;
    case 2131297183: 
      k();
      return;
    case 2131298998: 
      ReportController.b(this.app, "CliOper", "", "", "0X800556E", "0X800556E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.b(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo, this);
      return;
    case 2131298323: 
      a(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005567", "0X8005567", 0, 0, "", "", "", "");
      if (b()) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005568", "0X8005568", 0, 0, "", "", "", "");
      }
    }
    this.onBackListeger.onClick(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    default: 
      a();
      a(0);
      return false;
    case 2131298323: 
      a(0);
      return false;
    case 2131298980: 
      a();
      return false;
    }
    a();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\ui\CreateArrageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
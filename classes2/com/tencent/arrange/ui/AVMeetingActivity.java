package com.tencent.arrange.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.arrange.op.ArrangeResult;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import gct;
import gcv;
import gcw;
import gcx;
import gcy;
import gcz;
import gda;
import gdb;
import gdc;
import gdd;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AVMeetingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, ArrangeResult
{
  public static int a = 0;
  static final String jdField_a_of_type_JavaLangString = "AVMeetingActivity";
  static final String jdField_e_of_type_JavaLangString = "memberUin";
  static final String jdField_f_of_type_JavaLangString = "memberName";
  static final String jdField_g_of_type_JavaLangString = "faceId";
  static final String jdField_h_of_type_JavaLangString = "pinyin";
  static final String jdField_i_of_type_JavaLangString = "isDiscussionMember";
  static final int k = 0;
  static final int l = 1;
  static final int m = 2;
  public static final int n = 48;
  public static final int o = 150;
  public static final int p = 730;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new gcx(this);
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ArrangeHandler jdField_a_of_type_ComTencentArrangeOpArrangeHandler;
  MeetingInfo jdField_a_of_type_ComTencentArrangeOpMeetingInfo;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new gcy(this);
  public IphonePickerView a;
  public MyGridView a;
  public QQProgressDialog a;
  gdb jdField_a_of_type_Gdb;
  public gdd a;
  public SimpleDateFormat a;
  public ArrayList a;
  public List a;
  public boolean a;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  IphonePickerView jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  public gdb b;
  public String b;
  public ArrayList b;
  public boolean b;
  public int c;
  long jdField_c_of_type_Long;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public int e;
  View jdField_e_of_type_AndroidViewView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout = null;
  final int jdField_f_of_type_Int = 3;
  View jdField_f_of_type_AndroidViewView;
  LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout = null;
  final int jdField_g_of_type_Int = 2;
  View jdField_g_of_type_AndroidViewView;
  final int jdField_h_of_type_Int = 4;
  View jdField_h_of_type_AndroidViewView;
  int jdField_i_of_type_Int = 0;
  View jdField_i_of_type_AndroidViewView = null;
  public int j;
  public int q = 0;
  public int r = 0;
  int s = 0;
  int t = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 15;
  }
  
  public AVMeetingActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public static int a(String paramString)
  {
    int i1 = 0;
    byte[] arrayOfByte;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = new byte[0];
    }
    try
    {
      paramString = paramString.getBytes("utf-8");
      i1 = paramString.length;
      return i1;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = arrayOfByte;
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i3 = 0;
    byte[] arrayOfByte;
    int i1;
    try
    {
      arrayOfByte = paramString.getBytes("utf-8");
      i1 = paramInt;
      if (arrayOfByte.length >= paramInt) {
        break label38;
      }
      i1 = arrayOfByte.length;
    }
    catch (Exception paramString)
    {
      return "";
    }
    paramString = paramString.substring(0, i2);
    return paramString;
    label38:
    int i2 = 0;
    label41:
    int i4;
    if (i3 < i1)
    {
      i4 = 1;
      if ((arrayOfByte[i3] & 0x80) != 0) {
        break label87;
      }
      paramInt = i3 + 1;
    }
    for (;;)
    {
      i3 = paramInt;
      if (paramInt > i1) {
        break label41;
      }
      i2 = i4 + i2;
      i3 = paramInt;
      break label41;
      break;
      label87:
      if ((arrayOfByte[i3] & 0xE0) == 192)
      {
        paramInt = i3 + 2;
      }
      else if ((arrayOfByte[i3] & 0xF0) == 224)
      {
        paramInt = i3 + 3;
      }
      else
      {
        paramInt = i3 + 4;
        i4 = 2;
      }
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label229:
    label263:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
      Object localObject;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131363990));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        a();
        localObject = "";
        if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() < 1)) {
          localObject = getString(2131363987);
        }
        if ((this.jdField_c_of_type_Boolean) || (!a(this.jdField_a_of_type_Long))) {
          break label229;
        }
        paramView = getString(2131365095);
      }
      for (;;)
      {
        if (paramView.length() <= 0) {
          break label263;
        }
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(getString(2131365094));
        ((QQCustomDialog)localObject).getMessageTextView().setGravity(1);
        ((QQCustomDialog)localObject).setMessage(paramView);
        ((QQCustomDialog)localObject).setPositiveButton(2131365090, new gcz(this));
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        ((QQCustomDialog)localObject).show();
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131363991));
        break;
        paramView = (View)localObject;
        if (!this.jdField_c_of_type_Boolean)
        {
          paramView = (View)localObject;
          if (this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long) {
            paramView = getString(2131365096);
          }
        }
      }
      a(0);
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVMeetingActivity", 2, "member list null");
    return;
    ThreadManager.a(new gda(this), 5, null, false);
  }
  
  public int a(long paramLong, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramBoolean) {
      localCalendar.set(this.s, this.t, this.q, 0, 0, 0);
    }
    for (;;)
    {
      long l1 = (paramLong - localCalendar.getTime().getTime()) / 1000L / 86400L;
      if (l1 <= 729L)
      {
        paramLong = l1;
        if (l1 <= 2147483647L) {}
      }
      else
      {
        paramLong = 729L;
      }
      l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      return (int)l1;
      localCalendar.set(this.s, this.t, this.r, 0, 0, 0);
    }
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {}
    String str2;
    for (paramInt = 48;; paramInt = 150)
    {
      str2 = getResources().getString(2131363992);
      if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))) {
        break label83;
      }
      str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (a(str1) <= paramInt) {
        break label81;
      }
      return a(str1, paramInt);
      if (paramInt != 1) {
        break;
      }
    }
    return "";
    label81:
    return str1;
    label83:
    String str1 = this.app.b();
    String str3 = getResources().getString(2131363994);
    String str4 = str1 + str2;
    if (a(str4) > paramInt)
    {
      str2 = str3 + str2;
      int i1 = a(str2);
      return a(str1, paramInt - i1) + str2;
    }
    return str4;
  }
  
  public String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format("%d-%02d-%02d %02d:%02d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)), Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
  }
  
  public void a()
  {
    super.setTitle(2131363977);
    Object localObject = (TextView)findViewById(2131297083);
    ((TextView)localObject).setText(2131365086);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localObject = (ImageView)super.findViewById(2131297836);
    } while (localObject == null);
    ((ImageView)localObject).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131428262));
        }
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if ((paramInt == 0) || (paramInt == 2))
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null)) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131428262));
        }
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramInt1;
    runOnUiThread(new gct(this));
  }
  
  public void a(int paramInt, IphonePickerView paramIphonePickerView, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i1 = localCalendar.get(11);
    int i2 = localCalendar.get(12);
    if (paramInt == 1)
    {
      paramInt = a(paramLong, true);
      if (paramInt == 0) {
        paramIphonePickerView.setSelection(0, 0);
      }
      for (;;)
      {
        paramIphonePickerView.setSelection(1, i1);
        paramIphonePickerView.setSelection(2, i2 / jdField_a_of_type_Int);
        return;
        paramIphonePickerView.setSelection(0, paramInt);
      }
    }
    paramIphonePickerView.setSelection(0, a(paramLong, false));
    paramIphonePickerView.setSelection(1, i1);
    paramIphonePickerView.setSelection(2, i2 / jdField_a_of_type_Int);
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = ((MeetingInfo)paramList.get(0));
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getDiscuss_uin();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getBegin_time();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getEnd_time();
      runOnUiThread(new gcw(this));
    }
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if (paramIntent != null)
      {
        if (paramIntent.size() > 0) {}
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
            localHashMap.put("memberName", ((ResultRecord)localObject).jdField_b_of_type_JavaLangString);
            localHashMap.put("pinyin", ((ResultRecord)localObject).jdField_c_of_type_JavaLangString);
            localHashMap.put("isDiscussionMember", Boolean.valueOf(false));
            localObject = ((FriendsManager)this.app.getManager(50)).c(((ResultRecord)localObject).a);
            if (localObject != null) {
              localHashMap.put("faceId", Short.valueOf(((Friends)localObject).faceid));
            }
            this.jdField_a_of_type_JavaUtilList.add(localHashMap);
          }
        }
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_i_of_type_AndroidViewView != null) {
          this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_Gdd != null) {
        this.jdField_a_of_type_Gdd.notifyDataSetChanged();
      }
    }
    c();
  }
  
  void a(MyGridView paramMyGridView)
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
    this.jdField_b_of_type_Int = i1;
    this.jdField_c_of_type_Int = i1;
    this.jdField_d_of_type_Int = i2;
    this.jdField_e_of_type_Int = i2;
    this.jdField_b_of_type_Int = 0;
    paramMyGridView.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVMeetingActivity", 2, "invalid dissuin");
      }
      finish();
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new HashMap();
      ((Map)localObject).put("jump_from", "gavideo_avmeeting");
      if (this.jdField_b_of_type_Boolean)
      {
        ((Map)localObject).put("isAVGroupMeeting", "true");
        ChatActivityUtils.a(this.app, this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 3000, paramString, true, true, null, (Map)localObject);
        if (!this.jdField_b_of_type_Boolean) {
          break label153;
        }
        ReportController.b(null, "CliOper", "", "", "0X800667C", "0X800667C", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        finish();
        return;
        ((Map)localObject).put("isAVMeeting", "true");
        break;
        label153:
        ReportController.b(null, "CliOper", "", "", "0X8006415", "0X8006415", 0, 0, "", "", "", "");
      }
    }
    Object localObject = new MeetingInfo();
    ((MeetingInfo)localObject).setDiscuss_uin(paramString);
    ((MeetingInfo)localObject).setCreator_uin(this.app.a());
    ((MeetingInfo)localObject).setBegin_time(this.jdField_a_of_type_Long);
    ((MeetingInfo)localObject).setEnd_time(this.jdField_b_of_type_Long);
    paramString = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      paramString.add((String)localIterator.next());
    }
    ((MeetingInfo)localObject).setParticipants(paramString);
    ((MeetingInfo)localObject).setIntroduction(a(1));
    if (this.jdField_b_of_type_Boolean) {
      ((MeetingInfo)localObject).setType(3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.a((MeetingInfo)localObject, this);
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X800667B", "0X800667B", 0, 0, "", "", "", "");
      return;
      ((MeetingInfo)localObject).setType(2);
    }
    ReportController.b(null, "CliOper", "", "", "0X8006414", "0X8006414", 0, 0, "", "", "", "");
  }
  
  void a(ArrayList paramArrayList) {}
  
  void a(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_d_of_type_AndroidWidgetLinearLayout == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838998));
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (a(1)) {
          a(1);
        }
        if (a(2)) {
          a(2);
        }
        if (this.jdField_e_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      } while (this.jdField_f_of_type_AndroidWidgetLinearLayout == null);
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      float f1 = getResources().getDisplayMetrics().density;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.topMargin = ((int)(f1 * 20.0F));
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838998));
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_e_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.jdField_f_of_type_AndroidWidgetLinearLayout == null);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.topMargin = 0;
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  boolean a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    boolean bool = localInputMethodManager.isActive();
    if ((bool) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    return bool;
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        return true;
        if ((paramInt == 2) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)) {
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
  
  public boolean a(long paramLong)
  {
    return paramLong < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void b()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    View localView = View.inflate(this, 2130903574, null);
    Object localObject1 = (XListView)localView.findViewById(2131297613);
    ((XListView)localObject1).setDivider(null);
    ((XListView)localObject1).setVerticalScrollBarEnabled(false);
    ((XListView)localObject1).setPadding(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131299310));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131363997);
    Object localObject2 = View.inflate(this, 2130903525, null);
    Object localObject3 = (LinearLayout)((View)localObject2).findViewById(2131298976);
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131298970);
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298992));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298993));
    this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131298962).setVisibility(0);
    TextView localTextView = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131298965);
    localTextView.setTextColor(getResources().getColor(2131427830));
    localTextView.setText(getText(2131363998));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131298994));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131298996));
    this.jdField_i_of_type_AndroidViewView = ((View)localObject2).findViewById(2131298995);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131298998));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject2).findViewById(2131297562));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298978));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298966));
    localTextView = (TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298965);
    localTextView.setText(2131363995);
    localTextView.setTextColor(getResources().getColorStateList(2131428262));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298962).setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298968).setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298979));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131298966));
    localTextView = (TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131298965);
    localTextView.setText(2131363996);
    localTextView.setTextColor(getResources().getColorStateList(2131428262));
    this.jdField_g_of_type_AndroidViewView = this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131298969);
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    this.jdField_h_of_type_AndroidViewView = this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131298968);
    this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = ((View)localObject2).findViewById(2131298991);
    a(true);
    if (this.jdField_a_of_type_Boolean)
    {
      ((LinearLayout)localObject3).setVisibility(0);
      ((LinearLayout)localObject3).setOnTouchListener(this);
      localLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject2).findViewById(2131298323));
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(a(1));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131298977));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(50));
      }
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      long l1 = (NetConnInfoCenter.getServerTimeMillis() / 60000L + 10L + 29L) / 30L * 30L;
      this.jdField_c_of_type_Long = (60L * l1 * 1000L);
      this.jdField_d_of_type_Long = ((l1 + 60L) * 60L * 1000L);
      this.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      this.q = ((Calendar)localObject3).get(6);
      this.r = ((Calendar)localObject3).get(6);
      this.s = ((Calendar)localObject3).get(1);
      this.t = ((Calendar)localObject3).get(2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298980));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298965);
        ((TextView)localObject3).setText(2131363983);
        ((TextView)localObject3).setTextColor(getResources().getColor(2131427830));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag("begin_time");
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298967));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298968);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298966));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843181));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131298988));
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject3 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298965);
        ((TextView)localObject3).setText(2131363984);
        ((TextView)localObject3).setTextColor(getResources().getColor(2131427830));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setTag("end_time");
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298967));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298969);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298966));
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843181));
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298968);
        this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298963);
        this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298962);
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)((View)localObject2).findViewById(2131298982));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131428291));
        localObject3 = new gdc(this, true);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a((IphonePickerView.PickerViewAdapter)localObject3);
        this.jdField_a_of_type_Gdb = new gdb(this, this.jdField_a_of_type_AndroidWidgetLinearLayout, true);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_Gdb);
      }
      this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)((View)localObject2).findViewById(2131298990));
      if (this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131428291));
        localObject3 = new gdc(this, false);
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a((IphonePickerView.PickerViewAdapter)localObject3);
        this.jdField_b_of_type_Gdb = new gdb(this, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_b_of_type_Gdb);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131298981));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131298989));
      a(0);
      ((XListView)localObject1).setAdapter(new XSimpleListAdapter((View)localObject2));
      localObject1 = new HashMap();
      localObject2 = this.app.a();
      ((HashMap)localObject1).put("memberUin", localObject2);
      ((HashMap)localObject1).put("memberName", this.app.b());
      ((HashMap)localObject1).put("pinyin", "-1");
      ((HashMap)localObject1).put("isDiscussionMember", Boolean.valueOf(true));
      localObject3 = ((FriendsManager)this.app.getManager(50)).c(this.app.a());
      if (localObject3 != null) {
        ((HashMap)localObject1).put("faceId", Short.valueOf(((Friends)localObject3).faceid));
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      if (this.jdField_a_of_type_Gdd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_b_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
        this.jdField_a_of_type_Gdd.notifyDataSetChanged();
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      this.jdField_a_of_type_Gdd = new gdd(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Gdd);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.jdField_i_of_type_Int, this.jdField_i_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14, -1);
      setContentView(localView);
      setContentBackgroundResource(2130837958);
      if (this.jdField_a_of_type_Gdb != null)
      {
        l1 = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Gdb.a(this.jdField_b_of_type_Long, false);
        this.jdField_a_of_type_Gdb.a(l1, false);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    ((LinearLayout)localObject3).setVisibility(8);
    localLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131298975));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getEnable() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838983);
    }
    for (;;)
    {
      ((TextView)((View)localObject2).findViewById(2131298973)).setText(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getFormatTime());
      ((TextView)((View)localObject2).findViewById(2131298974)).setText(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getIntroduction());
      break;
      if (a(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getBegin_time()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838984);
      }
      else if (this.app.a().equals(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo.getCreator_uin()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
    }
  }
  
  void b(int paramInt)
  {
    if (paramInt == 1)
    {
      a(2);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestFocus();
        a(paramInt, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_a_of_type_Long);
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131428268));
        }
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 2) || ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (getResources().getText(2131363980).equals(this.jdField_c_of_type_AndroidWidgetTextView.getText()))));
      a(1);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestFocus();
        a(paramInt, this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_b_of_type_Long);
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131428268));
        }
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_f_of_type_AndroidViewView == null);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      runOnUiThread(new gcv(this));
    }
  }
  
  void c()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (this.jdField_i_of_type_AndroidViewView == null);
    this.jdField_i_of_type_AndroidViewView.setVisibility(8);
  }
  
  void d()
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
      localIntent.putExtra("jump_from", 2);
      startActivityForResult(localIntent, 4);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AVMeetingActivity", 2, localException.toString());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVMeetingActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
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
          return;
        } while (this.jdField_a_of_type_Gdd == null);
        this.jdField_a_of_type_Gdd.notifyDataSetChanged();
        return;
        a(paramIntent);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringArrayListExtra("result_list");
          if ((paramIntent != null) && (paramIntent.size() != 0))
          {
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
            this.jdField_a_of_type_Gdd.notifyDataSetChanged();
          }
        }
        c();
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Gdd == null);
    this.jdField_a_of_type_Gdd.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler = ((ArrangeHandler)this.app.a(61));
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      a();
    }
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("param_only_troop_member", false);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("group_uin");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("group_name");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
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
    case 2131298996: 
      d();
      return;
    case 2131298998: 
      this.jdField_a_of_type_ComTencentArrangeOpArrangeHandler.b(this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo, this);
      return;
    case 2131298323: 
      a(0);
      return;
    case 2131297083: 
      this.onBackListeger.onClick(paramView);
      return;
    case 2131298978: 
      a(true);
      return;
    }
    a(false);
  }
  
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\ui\AVMeetingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
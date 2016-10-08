package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kyb;
import kyc;
import kyd;
import kye;
import kyf;
import kyg;
import kyh;
import kyi;
import kyj;
import kyk;
import kyl;
import kym;
import kyn;
import kyo;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1000;
  public static final String a = "isShieldMsgSwitchUnClickable";
  private static final boolean jdField_a_of_type_Boolean = AppSetting.j;
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private static final int jdField_i_of_type_Int = 33;
  private static final int jdField_j_of_type_Int = 18;
  private static final int jdField_k_of_type_Int = 32;
  private float jdField_a_of_type_Float;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new kyn(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kym(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new kyc(this);
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new kyh(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new kyo(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new kye(this);
  public RichStatus a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private XSimpleListAdapter jdField_a_of_type_ComTencentWidgetXSimpleListAdapter;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public MqqHandler a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 2;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int = 3;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = "";
  private String jdField_j_of_type_JavaLangString;
  private String jdField_k_of_type_JavaLangString;
  private int l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ChatSettingActivity()
  {
    this.j = "";
    this.k = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new kyl(this);
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(63530);
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.a(paramString.toString(), null);
    } while (paramString == null);
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label151;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label151:
      if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendsManager)this.app.getManager(50)).a(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = (FriendsManager)this.app.getManager(50);
    } while (localObject == null);
    Friends localFriends = ((FriendsManager)localObject).c(paramString);
    if (localFriends != null) {
      if (localFriends.remark != null)
      {
        paramString = localFriends.remark;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (TextUtils.isEmpty(localFriends.name)) {}
        }
      }
    }
    for (Object localObject = localFriends.name;; localObject = null)
    {
      return (String)localObject;
      paramString = null;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramInt <= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int m = paramInt;
    if (paramInt > 999) {
      m = 999;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(m + "天");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_f_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_h_of_type_Int |= 0x1;
          a(paramIntent);
          e(getString(2131369546));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(2131370010, 1);
        return;
      }
      a(2131370009, 0);
      return;
    }
    a(2131368804, 1);
  }
  
  private void a(FriendsManager paramFriendsManager, ExtensionInfo paramExtensionInfo)
  {
    int m;
    int n;
    int i1;
    int i2;
    if (AppSetting.j)
    {
      boolean bool = paramFriendsManager.d();
      m = paramFriendsManager.a(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, 1, bool);
      n = paramFriendsManager.b(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      i1 = paramFriendsManager.c(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      i2 = paramFriendsManager.a(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      if (m <= 0) {
        break label190;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372677, new Object[] { Integer.valueOf(paramFriendsManager.jdField_b_of_type_Int) }));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131372677, new Object[] { Integer.valueOf(paramFriendsManager.jdField_c_of_type_Int) }));
      if (i1 != 1) {
        break label264;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372673, new Object[] { Integer.valueOf(paramFriendsManager.jdField_f_of_type_Int) }));
      label158:
      if (i2 != 1) {
        break label301;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372675, new Object[] { Integer.valueOf(m) }));
    }
    label190:
    label264:
    label301:
    while (i2 != 2)
    {
      return;
      if (n == 1)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372671, new Object[] { Integer.valueOf(paramFriendsManager.jdField_d_of_type_Int) }));
        break;
      }
      if (n != 2) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372672, new Object[] { Integer.valueOf(paramFriendsManager.jdField_e_of_type_Int) }));
      break;
      if (i1 != 2) {
        break label158;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372674, new Object[] { Integer.valueOf(paramFriendsManager.g) }));
      break label158;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131372676, new Object[] { Integer.valueOf(m) }));
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
      if (localStatusManager != null) {}
      for (paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);; paramRichStatus = BitmapManager.a(getResources(), 2130842868))
      {
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, getTitleBarHeight(), 0, paramInt);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 1007: 
    case 1008: 
    case 1010: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1020: 
    case 1021: 
    case 1022: 
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(50)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    paramString = localFriendsManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendsManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843190);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843184);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int m = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendsManager)this.app.getManager(50)).a(String.valueOf(m));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_f_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void c()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.a(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843192);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843186);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(String paramString)
  {
    Object localObject = this.app.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.app.a().f(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, l1);
          }
          paramString = this.app.a(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.jdField_c_of_type_JavaLangString;
          ((Message)localObject).arg1 = this.jdField_b_of_type_Int;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void d()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.a(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = null;
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843191);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843185);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131368711)).setMessage(getString(2131368722)).setPositiveButton(2131367499, new kyk(this, paramString)).setNegativeButton(2131367976, new kyj(this)).show();
  }
  
  private void e()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = 1003;
    }
    if ((1 == this.jdField_b_of_type_Int) || (1000 == this.jdField_b_of_type_Int) || (1004 == this.jdField_b_of_type_Int)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.l = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("add_friend_source_id", 10004);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904920);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131368647));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      h();
    }
    for (;;)
    {
      setTitle(2131369485);
      setLeftViewName(2131366637);
      setContentBackgroundResource(2130837958);
      return;
      g();
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130903384, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    try
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903188, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
      super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297588));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297589));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297591));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297594));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297595));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297596));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297597));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297592));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297598));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297568));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297569));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297570));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297602));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297603));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297600));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297601));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297604));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (AppSetting.j)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131369947));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131368608));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367904));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367906));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369470));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131371016));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131369506));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369474));
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131368711));
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368904));
      }
      this.jdField_f_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_f_of_type_JavaLangString == null) {
        this.jdField_f_of_type_JavaLangString = "";
      }
      a(this.jdField_f_of_type_JavaLangString);
      if (this.jdField_f_of_type_JavaLangString != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      }
      Object localObject;
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        localObject = FaceDrawable.a(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      a(a(this.jdField_c_of_type_JavaLangString), this.jdField_d_of_type_AndroidWidgetTextView);
      this.jdField_g_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_g_of_type_JavaLangString == null) {
        this.jdField_g_of_type_JavaLangString = "";
      }
      b(this.jdField_g_of_type_JavaLangString);
      o();
      if (this.app != null)
      {
        t();
        localObject = (FriendsManager)this.app.getManager(50);
        ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_c_of_type_JavaLangString, false);
        boolean bool = ((FriendsManager)localObject).d();
        int m = ((FriendsManager)localObject).a(this.jdField_c_of_type_JavaLangString, localExtensionInfo, 1, bool);
        int n = ((FriendsManager)localObject).b(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool);
        int i1 = ((FriendsManager)localObject).c(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool);
        int i2 = ((FriendsManager)localObject).a(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool);
        b(n);
        a(m);
        c(i1);
        d(i2);
        a((FriendsManager)localObject, localExtensionInfo);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void h()
  {
    Object localObject = View.inflate(this, 2130903190, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131297613));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903189, null);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    super.setContentView((View)localObject);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297605));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297610));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297606));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297608));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297609));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297611));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297612));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297614));
    if (AppSetting.j)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131369947));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369503));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131369506));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131369504));
      this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368906));
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((this.jdField_b_of_type_Int == 1006) && (this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false)))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject != null) {
        ((Switch)localObject).setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_b_of_type_Int != 1010) && (this.jdField_b_of_type_Int != 1001) && ((this.jdField_b_of_type_Int != 1022) || ((this.l != 3007) && (this.l != 2007) && (this.l != 4007) && (this.l != 3019) && (this.l != 2019)))) {
        break label847;
      }
      localObject = FaceDrawable.a(this.app, 200, this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label521:
      this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1004)) {
        this.j = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if (this.jdField_b_of_type_Int == 1001) {
        break label957;
      }
      if (this.jdField_b_of_type_Int == 1006)
      {
        this.k = this.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.k)) {
          break label917;
        }
        this.jdField_f_of_type_Boolean = false;
      }
      label606:
      localObject = (ShieldMsgManger)this.app.getManager(15);
      if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_e_of_type_Boolean = ((ShieldMsgManger)localObject).a(this.jdField_i_of_type_JavaLangString);
      }
      label645:
      if (!a(this.jdField_b_of_type_Int)) {
        break label1007;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_h_of_type_Boolean = true;
      s();
      a(a(this.jdField_c_of_type_JavaLangString), this.jdField_h_of_type_AndroidWidgetTextView);
      localObject = new String[1];
      localObject[0] = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        b();
      }
      if ((this.jdField_b_of_type_Int != 1010) && (this.jdField_b_of_type_Int != 1001) && ((this.jdField_b_of_type_Int != 1022) || ((this.l != 3007) && (this.l != 2007) && (this.l != 4007) && (this.l != 3019) && (this.l != 2019)))) {
        break label1019;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject, true);
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new kyb(this));
      break;
      label847:
      if (this.jdField_b_of_type_Int == 1006)
      {
        localObject = FaceDrawable.b(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        break label521;
      }
      localObject = FaceDrawable.a(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label521;
      label917:
      localObject = ContactUtils.f(this.app, this.k);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_f_of_type_Boolean = false;
        break label606;
      }
      this.jdField_f_of_type_Boolean = true;
      this.jdField_i_of_type_JavaLangString = ((String)localObject);
      break label606;
      label957:
      localObject = ((FriendsManager)this.app.getManager(50)).c(this.jdField_i_of_type_JavaLangString);
      if ((localObject != null) && (((Friends)localObject).groupid == 64534))
      {
        this.jdField_e_of_type_Boolean = true;
        break label645;
      }
      this.jdField_e_of_type_Boolean = false;
      break label645;
      label1007:
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label1019:
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject, false);
  }
  
  private void i()
  {
    int m = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), 0);
    Object localObject = null;
    switch (m)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131368136);
      break;
      localObject = getResources().getString(2131368135);
      break;
      localObject = getResources().getString(2131368134);
      break;
      localObject = getResources().getString(2131368133);
      break;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "messge roam flag is error ,is : " + m);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    startActivityForResult(localIntent, 2);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (Intent localIntent = new Intent(this, ChatHistoryForC2C.class);; localIntent = new Intent(this, ChatHistory.class))
    {
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
      localIntent.putExtra("FriendNick", this.jdField_h_of_type_JavaLangString);
      startActivityForResult(localIntent, 1000);
      return;
    }
  }
  
  private void l()
  {
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("leftViewText", getString(2131369487));
    startActivity(localIntent);
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, ChatBackgroundMarketActivity.class);
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    String str = String.valueOf(33554432L);
    if (WebViewPluginFactory.a.containsKey(str)) {
      localIntent.putExtra("insertPluginsArray", new String[] { str });
    }
    localIntent.putExtra("business", 33554432L);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("url", IndividuationUrlHelper.a(this, "background", ""));
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 1);
  }
  
  private void n()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void o()
  {
    Object localObject = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!QvipSpecialCareManager.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130843324);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130843321);
    getResources().getDrawable(2130838201);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void p()
  {
    ThreadManager.a(new kyi(this, new StringBuilder()), 8, null, true);
    a(2, getString(2131368681));
  }
  
  private void q()
  {
    boolean bool = true;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      b();
      return;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (l1 > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_d_of_type_Boolean)
        {
          localFriendListHandler.a(l1, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        bool = false;
      }
      a(1, "无效的号码");
    }
  }
  
  private void r()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    for (;;)
    {
      return;
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      try
      {
        l1 = Long.parseLong(this.jdField_i_of_type_JavaLangString);
        if (l1 > 0L)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(l1));
          if (this.jdField_e_of_type_Boolean)
          {
            localShieldMsgManger.b(this.jdField_b_of_type_Int, localArrayList);
            this.jdField_g_of_type_Boolean = true;
            if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 1003))
            {
              if (!this.jdField_e_of_type_Boolean) {
                break label247;
              }
              if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
              {
                this.app.a().b(this.jdField_c_of_type_JavaLangString);
                this.jdField_g_of_type_Boolean = true;
              }
            }
            if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_Int != 1010)) {
              continue;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break label286;
            }
            ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = 0L;
          continue;
          localShieldMsgManger.a(this.jdField_b_of_type_Int, localException);
          continue;
          a(1, "无效的号码");
          continue;
          label247:
          if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
          {
            this.app.a().a(this.jdField_c_of_type_JavaLangString);
            this.jdField_g_of_type_Boolean = true;
          }
        }
        label286:
        ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      if (AppSetting.j) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131369505));
      }
    }
    if ((this.jdField_b_of_type_Int == 1003) || (!this.jdField_f_of_type_Boolean)) {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void t()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    if ((localFriendsManager != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_d_of_type_Boolean = localFriendsManager.e(this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
      if (AppSetting.j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131369505));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      while (jdField_a_of_type_Boolean)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
    }
  }
  
  private void u()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.a(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.a(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void v()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.a = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localAllInOne.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localAllInOne.jdField_f_of_type_Int = 5;
    localAllInOne.g = 61;
    label276:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 1010) && ((this.jdField_b_of_type_Int != 1022) || ((this.l != 3007) && (this.l != 2007) && (this.l != 4007) && (this.l != 3019) && (this.l != 2019)))) {
        break label493;
      }
      if (this.jdField_b_of_type_Int == 1001)
      {
        localAllInOne.g = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", localAllInOne);
        if (!Utils.a(this.jdField_c_of_type_JavaLangString, this.app.a())) {
          break label481;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      return;
      localAllInOne.a = 42;
      break;
      localAllInOne.a = 76;
      break;
      localAllInOne.a = 22;
      localAllInOne.jdField_d_of_type_JavaLangString = this.j;
      break;
      localAllInOne.a = 70;
      break;
      localAllInOne.a = 47;
      localAllInOne.jdField_e_of_type_JavaLangString = this.j;
      break;
      localAllInOne.a = 2;
      break;
      localAllInOne.a = 34;
      break;
      localAllInOne.a = 57;
      break;
      localAllInOne.a = 72;
      break;
      localAllInOne.a = 74;
      break;
      localAllInOne.a = 27;
      break;
      localAllInOne.a = 58;
      break;
      if (this.jdField_b_of_type_Int == 1010)
      {
        localAllInOne.g = 13;
        break label276;
      }
      localAllInOne.g = 30;
      break label276;
      label481:
      localIntent.putExtra("param_mode", 3);
    }
    label493:
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void w()
  {
    int i2 = 10004;
    int i1 = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int m = i2;
    int n = i1;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      n = i1;
      m = i2;
      localObject1 = localObject2;
    }
    while (m == 3007)
    {
      if (LBSHandler.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        break label328;
      }
      a();
      return;
      m = 3004;
      n = 3;
      localObject1 = getIntent().getStringExtra("troop_uin");
      continue;
      m = 3007;
      n = 3;
      localObject1 = localObject2;
      continue;
      m = 3003;
      localObject1 = localObject2;
      n = i1;
      continue;
      m = 3005;
      n = 3;
      localObject1 = localObject2;
      continue;
      m = 3008;
      localObject1 = localObject2;
      n = i1;
      continue;
      m = 3006;
      localObject1 = localObject2;
      n = i1;
      continue;
      m = 3013;
      localObject1 = localObject2;
      n = i1;
      continue;
      m = 3008;
      localObject1 = localObject2;
      n = i1;
      continue;
      m = 3003;
      n = 2;
      localObject1 = localObject2;
      continue;
      m = 3019;
      localObject1 = localObject2;
      n = i1;
    }
    if ((m == 3019) && (!DatingUtil.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      a();
      return;
    }
    label328:
    if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 4000) || (this.jdField_b_of_type_Int == 1006)) {}
    for (localObject1 = AddFriendLogicActivity.a(this, 2, this.k, null, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);; localObject1 = AddFriendLogicActivity.a(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject1, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null))
    {
      startActivity((Intent)localObject1);
      return;
    }
  }
  
  private void x()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_b_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    }
    localAllInOne.jdField_f_of_type_Int = 5;
    localAllInOne.g = 61;
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void y()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void z()
  {
    ThreadManager.a(new kyd(this), 8, null, true);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131371566), new kyf(this), new kyg(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_c_of_type_Boolean = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      return;
      n();
      finish();
      return;
      if (this.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnActivityResult");
        }
        paramIntent = (FriendsManager)this.app.getManager(50);
        localObject = paramIntent.a(this.jdField_c_of_type_JavaLangString, false);
        boolean bool = paramIntent.d();
        paramInt1 = paramIntent.a(this.jdField_c_of_type_JavaLangString, (ExtensionInfo)localObject, 1, bool);
        paramInt2 = paramIntent.b(this.jdField_c_of_type_JavaLangString, (ExtensionInfo)localObject, bool);
        int m = paramIntent.c(this.jdField_c_of_type_JavaLangString, (ExtensionInfo)localObject, bool);
        int n = paramIntent.a(this.jdField_c_of_type_JavaLangString, (ExtensionInfo)localObject, bool);
        b(paramInt2);
        a(paramInt1);
        c(m);
        d(n);
        a(paramIntent, (ExtensionInfo)localObject);
      }
      setResult(-1);
      this.jdField_b_of_type_Boolean = true;
      return;
      a(paramIntent);
      return;
      b(paramIntent);
      return;
      switch (paramIntent.getIntExtra("param_subtype", -1))
      {
      default: 
        return;
      case 0: 
        ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
      }
      Object localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      ((Intent)localObject).putExtra("uin", paramIntent);
      ((Intent)localObject).putExtra("uintype", 3000);
      ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
      ((Intent)localObject).putExtra("isBack2Root", true);
      startActivity((Intent)localObject);
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
    c();
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        FaceDrawable localFaceDrawable;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    d();
    this.jdField_h_of_type_Boolean = false;
  }
  
  protected void doOnPause()
  {
    this.jdField_c_of_type_Boolean = true;
    u();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(32);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131370237));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131370238));
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)) {
      i();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean) {
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
    }
    for (;;)
    {
      q();
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131297598: 
    case 2131297568: 
    case 2131297569: 
    case 2131297570: 
    case 2131297602: 
    case 2131297610: 
    case 2131297614: 
      do
      {
        return;
        j();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
        return;
        k();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
        return;
        l();
        FileManagerReporter.a("0X8004E01");
        return;
        m();
        ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        return;
        z();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
        return;
        p();
        ReportController.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      } while (!a(this.jdField_b_of_type_Int));
      ProfileCardUtil.a(this, this.jdField_c_of_type_JavaLangString, null, this.app.getAccount(), 1101);
      return;
    case 2131297605: 
      v();
      return;
    case 2131297612: 
      w();
      ReportController.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
      return;
    case 2131297588: 
      x();
      return;
    case 2131297603: 
      d(this.jdField_c_of_type_JavaLangString);
      ReportController.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      return;
    case 2131297600: 
      paramView = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      paramView.edit().putBoolean("special_care_chat_setting", false).commit();
      if (paramView.getBoolean("special_care_red_point_one", false)) {
        paramView.edit().putBoolean("special_care_red_point_one", false).commit();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      paramView = new Intent(this, QQSpecialCareSettingActivity.class);
      paramView.putExtra("key_friend_uin", this.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
      return;
    }
    ProfileCardUtil.a(this, this.jdField_c_of_type_JavaLangString, null, this.app.getAccount(), 1101);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
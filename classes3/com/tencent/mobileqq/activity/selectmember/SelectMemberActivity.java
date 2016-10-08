package com.tencent.mobileqq.activity.selectmember;

import QQService.AddDiscussMemberInfo;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.model.ContactSearchModelCircleBuddy;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.dingdong.DingdongOpenIdProvider;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.groupvideo.GroupVideoWrapper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import pgv;
import pgw;
import pgx;
import pgy;
import pgz;
import pha;
import phb;
import phc;
import phd;
import phe;
import phg;
import phh;
import phj;
import phk;
import phl;
import phm;
import phn;
import phq;
import phr;
import phs;
import pht;
import phu;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;

public class SelectMemberActivity
  extends FragmentActivity
  implements View.OnClickListener, ContactSearchResultPresenter.OnActionListener
{
  public static final int A = 23;
  public static final String A = "multi_chat";
  public static final int B = 24;
  public static final String B = "param_min";
  static final int C = 0;
  public static final String C = "param_show_myself";
  static final int D = 1;
  public static final String D = "result_set";
  static final int E = 2;
  public static final String E = "param_donot_need_circle";
  static final int F = 3;
  public static final String F = "param_donot_need_contacts";
  static final int G = 4;
  public static final String G = "param_donot_need_troop";
  static final int H = 5;
  public static final String H = "param_donot_need_discussion";
  static final int I = 6;
  public static final String I = "param_only_friends";
  static final int J = 7;
  public static final String J = "param_only_troop_member";
  public static final int K = 8;
  public static final String K = "param_only_discussion_member";
  public static final int L = 9;
  public static final String L = "param_title";
  public static final int M = 10;
  public static final String M = "param_done_button_wording";
  public static final String N = "param_done_button_highlight_wording";
  public static final String O = "param_add_passed_members_to_result_set";
  public static final String P = "param_exit_animation";
  public static final String Q = "param_back_button_side";
  public static final String R = "param_enable_all_select";
  public static final String S = "param_overload_tips_include_default_count";
  public static final String T = "param_default_selected_troop_members";
  public static final String U = "param_member_show_type";
  public static final String V = "param_report_type";
  protected static final int W = 0;
  public static final String W = "is_support_select_from_friend_groups";
  protected static final int X = 1;
  public static final String X = "is_story_not_see";
  protected static final int Y = 2;
  public static final String Y = "PARAMR_ADMIN_GVIDEO_ROOM_NUM";
  public static final String Z = "friend_team_id";
  private static final int jdField_a_of_type_Int = 1000;
  private static final String jdField_a_of_type_JavaLangString = "not_admin_invite_member_count";
  public static final int aa = 5;
  public static final String aa = "group_uin";
  public static final int ab = 3;
  public static final String ab = "group_name";
  public static final String ac = "NEED_CLOSE_WHEN_PSTN_CLOSE";
  private static final int d = 3;
  private static final int e = 8;
  public static boolean h = false;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  static final String jdField_m_of_type_JavaLangString = "SelectMemberActivity";
  public static final int n = 10;
  public static final String n = "param_type";
  public static final int o = 11;
  public static final String o = "param_subtype";
  public static final int p = 12;
  public static final String p = "param_is_troop_admin";
  public static final int q = 13;
  public static final String q = "param_from";
  public static final int r = 14;
  public static final String r = "param_entrance";
  public static final int s = 15;
  public static final String s = "param_groupcode";
  public static final int t = 16;
  public static final String t = "param_face_to_face_troop";
  public static final int u = 17;
  public static final String u = "param_uins_selected_default";
  public static final int v = 18;
  public static final String v = "param_uins_selected_friends";
  public static final int w = 19;
  public static final String w = "param_selected_records_for_create_discussion";
  public static final int x = 20;
  public static final String x = "param_uins_hide";
  public static final int y = 21;
  public static final String y = "param_show_owner_and_admins_only";
  public static final int z = 22;
  public static final String z = "param_max";
  protected int N;
  public int O;
  public int P;
  public int Q;
  int R;
  public int S;
  int T;
  protected int U;
  protected int V;
  public int Z;
  protected float a;
  private long jdField_a_of_type_Long;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Intent a;
  protected Bitmap a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  public View a;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public EditText a;
  public GridView a;
  public HorizontalScrollView a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  private QavWrapper jdField_a_of_type_ComTencentAvServiceQavWrapper;
  public InnerFrameManager a;
  protected ChatActivityUtils.StartVideoListener a;
  private BlessManager jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager;
  public SelectMemberActivity.GridViewAdapter a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public ContactSearchFragment a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  protected QQToastNotifier a;
  private DingdongOpenIdProvider jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider;
  private GroupVideoWrapper jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper;
  public String ad;
  String ae;
  String af;
  String ag;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public View b;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  private int c;
  public TextView c;
  protected TextView d;
  public TextView e;
  protected TextView f;
  private TextView g;
  public ArrayList g;
  public ArrayList h;
  public ArrayList i;
  public boolean i;
  public ArrayList j;
  boolean j;
  boolean k;
  boolean l;
  boolean jdField_m_of_type_Boolean;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  boolean s;
  public boolean t;
  public boolean u;
  public boolean v;
  public boolean w;
  boolean x;
  
  public SelectMemberActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.t = true;
    this.jdField_i_of_type_JavaUtilArrayList = new ArrayList();
    this.v = true;
    this.jdField_c_of_type_Int = 0;
    this.Z = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new pgw(this);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_AndroidOsHandler = new phe(this);
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.c = paramString3;
    return localResultRecord;
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void a(byte paramByte)
  {
    String str = null;
    if (7 == paramByte) {
      str = getString(2131370198);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str).sendToTarget();
      return;
      if (9 == paramByte) {
        str = getString(2131370199);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_i_of_type_Boolean) && (a() >= 3)) {}
    return true;
  }
  
  private void b(int paramInt)
  {
    b(getString(paramInt));
  }
  
  private void b(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 'ߐ')
    {
      QQToast.a(this, paramString, 2000).b(this.jdField_b_of_type_AndroidViewView.getHeight());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = this.jdField_i_of_type_JavaUtilArrayList.size();
    String str1;
    if (i1 <= 1) {
      if (this.O == 3)
      {
        String str2 = this.af;
        str1 = str2;
        if (i1 != 1)
        {
          paramBoolean = false;
          str1 = str2;
        }
        if (!paramBoolean) {
          break label155;
        }
        this.e.setEnabled(true);
        this.e.setText(str1);
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.e.setContentDescription(this.af + ",已选择" + i1 + "人");
      }
      return;
      str1 = this.af;
      break;
      if (this.O == 3)
      {
        str1 = this.af;
        break;
      }
      str1 = MessageFormat.format(this.ag, new Object[] { Integer.valueOf(i1) });
      break;
      label155:
      this.e.setEnabled(false);
      this.e.setText(str1);
    }
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131370196);
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.ae);
    if (AppSetting.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.ae);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131370196));
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new pgv(this));
    if (this.N == 9003)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427710));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131428132));
      this.e.setTextColor(getResources().getColorStateList(2131428132));
    }
    i();
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "WL_DEBUG sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private boolean e()
  {
    boolean bool = false;
    int i1;
    if (this.O == 1) {
      if (this.jdField_a_of_type_ComTencentAvServiceQavWrapper != null) {
        i1 = this.jdField_a_of_type_ComTencentAvServiceQavWrapper.a(Long.valueOf(this.ad).longValue(), this.N) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      label50:
      int i2;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).jdField_a_of_type_Int == 5)
        {
          i2 = i1 + 1;
          i1 = i2;
          if (i2 < 8) {}
        }
      }
      for (;;)
      {
        if (i2 < 8) {
          bool = true;
        }
        return bool;
        if (this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper == null) {
          break label141;
        }
        i1 = this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper.a(Long.valueOf(this.ad).longValue(), this.N) + 0;
        break;
        break label50;
        i2 = i1;
      }
      label141:
      i1 = 0;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    if (this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider == null) {
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider = new DingdongOpenIdProvider(this.app);
    }
    ArrayList localArrayList = new ArrayList(this.jdField_i_of_type_JavaUtilArrayList.size());
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      oidb_0x589.GetUserOpenIdReq localGetUserOpenIdReq = new oidb_0x589.GetUserOpenIdReq();
      localGetUserOpenIdReq.setHasFlag(true);
      localGetUserOpenIdReq.uint64_req_uin.set(Long.parseLong(localResultRecord.jdField_a_of_type_JavaLangString));
      switch (localResultRecord.jdField_a_of_type_Int)
      {
      default: 
        localGetUserOpenIdReq.uint32_req_flag.set(1);
      }
      for (;;)
      {
        localArrayList.add(localGetUserOpenIdReq);
        break;
        localGetUserOpenIdReq.uint32_req_flag.set(2);
        localGetUserOpenIdReq.uint64_req_host_uin.set(Long.parseLong(localResultRecord.c));
        continue;
        localGetUserOpenIdReq.uint32_req_flag.set(3);
        localGetUserOpenIdReq.uint64_req_host_uin.set(Long.parseLong(localResultRecord.c));
      }
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a(this.jdField_a_of_type_AndroidContentIntent.getLongExtra("param_dingdong_appId", 0L), localArrayList, false, new pha(this));
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130904920);
    this.f = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852));
    this.f.setText(getString(2131368647));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296851));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131304261));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new phb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new phc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new phd(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298594));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298595));
    long l1 = this.app.a().a();
    int i2 = this.app.a().a();
    int i1 = 0;
    if (l1 > 0L) {
      i1 = this.app.a().b(l1);
    }
    if ((i2 == 1) && (i1 == 2))
    {
      this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper = new GroupVideoWrapper(this.app);
      this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper.a(new phj(this));
      return;
    }
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper = new QavWrapper(this);
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper.a(new phk(this));
  }
  
  public int a()
  {
    int i2 = 0;
    long l1 = Utils.a();
    Object localObject = this.app.a().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i1 = i2;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i1 = i2;
      if (Long.parseLong(localObject[0]) == l1) {
        i1 = Integer.parseInt(localObject[1]);
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int a(String paramString)
  {
    switch (PstnUtils.a(paramString.substring("pstn".length()), true))
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
  
  public ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.c = paramString3;
    localResultRecord.d = paramString4;
    return localResultRecord;
  }
  
  public String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.a(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  protected ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
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
    }
    return localArrayList;
  }
  
  protected void a()
  {
    setContentView(2130904976);
  }
  
  public void a(int paramInt)
  {
    long l1 = Utils.a();
    SharedPreferences.Editor localEditor = this.app.a().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l1 + ":" + paramInt);
    localEditor.commit();
  }
  
  public void a(View paramView)
  {
    IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramView.getTag(2131296489);
    if (localIContactSearchModel == null) {
      return;
    }
    paramView = localIContactSearchModel.a();
    String str2 = localIContactSearchModel.a().toString();
    if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {}
    for (String str1 = ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();; str1 = "-1")
    {
      if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact))
      {
        paramView = ((ContactSearchModelPhoneContact)localIContactSearchModel).a;
        if (!TextUtils.isEmpty(paramView.uin)) {
          break label152;
        }
        paramView = "pstn" + paramView.mobileNo;
      }
      while ((localIContactSearchModel instanceof ContactSearchModelDiscussion))
      {
        paramView = new Bundle();
        paramView.putString("group_uin", ((ContactSearchModelDiscussion)localIContactSearchModel).a());
        paramView.putString("group_name", ((ContactSearchModelDiscussion)localIContactSearchModel).c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, paramView);
        l();
        return;
        label152:
        if (paramView.uin.equals("0")) {
          paramView = paramView.nationCode + paramView.mobileCode;
        } else {
          paramView = paramView.uin;
        }
      }
      if ((localIContactSearchModel instanceof ContactSearchModelTroop))
      {
        paramView = new Bundle();
        paramView.putString("group_uin", ((ContactSearchModelTroop)localIContactSearchModel).a());
        paramView.putString("group_name", ((ContactSearchModelTroop)localIContactSearchModel).c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, paramView);
        l();
        return;
      }
      if (((this.jdField_g_of_type_JavaUtilArrayList != null) && (this.jdField_g_of_type_JavaUtilArrayList.contains(paramView))) || (a(paramView)) || (d()) || (a(paramView, str2))) {
        break;
      }
      SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
      int i1;
      if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 4) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 10)) {
        if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
          i1 = 2;
        }
      }
      for (;;)
      {
        label378:
        if (i1 != -1) {
          this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, i1, str1));
        }
        for (;;)
        {
          o();
          i();
          localSelectMemberInnerFrame.f();
          a(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          if ((this.N != 9003) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramView))) {
            break;
          }
          this.jdField_b_of_type_Int += 1;
          return;
          if ((localIContactSearchModel instanceof ContactSearchModelFriend))
          {
            i1 = 0;
            break label378;
          }
          if ((localIContactSearchModel instanceof ContactSearchModelCircleBuddy))
          {
            i1 = 3;
            break label378;
          }
          if (!(localIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
            break label776;
          }
          if ((paramView.startsWith("pstn")) && (b(paramView, str2, 5, str1)))
          {
            i1 = 5;
            break label378;
          }
          if (paramView.startsWith("+"))
          {
            i1 = 4;
            break label378;
          }
          i1 = 0;
          break label378;
          if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 1, localSelectMemberInnerFrame.a()));
          } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 9) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 2, localSelectMemberInnerFrame.a()));
          } else if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 7)) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 3, localSelectMemberInnerFrame.a()));
          } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 2) {
            if ((paramView.startsWith("pstn")) && (b(paramView, str2, 5, localSelectMemberInnerFrame.a()))) {
              this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 5, localSelectMemberInnerFrame.a()));
            } else if (paramView.startsWith("+")) {
              this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 4, localSelectMemberInnerFrame.a()));
            } else {
              this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str2, 0, localSelectMemberInnerFrame.a()));
            }
          }
        }
        label776:
        i1 = -1;
      }
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    while (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.jdField_i_of_type_JavaUtilArrayList.remove(i1);
        if ((this.N == 9003) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString))) {
          this.jdField_b_of_type_Int -= 1;
        }
      }
      i1 += 1;
    }
    o();
  }
  
  public void a(String paramString1, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    paramString1 = new phg(this, paramString1);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramString1, 100L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_i_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_i_of_type_JavaUtilArrayList.size() * 40 + this.jdField_i_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    j();
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.O == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304930));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131365273, new Object[] { Integer.valueOf(Math.min(paramInt, this.U)) }));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131365272, new Object[] { Integer.valueOf(this.U) }));
  }
  
  public void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendResultBroadcastToVideo");
    }
    Intent localIntent = new Intent("tencent.video.q2v.AddDiscussMember");
    localIntent.setPackage(this.app.getApplication().getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong);
    localIntent.putStringArrayListExtra("newMemberUin", paramArrayList);
    this.app.a().sendBroadcast(localIntent);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new phh(this));
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130843454);
      this.d.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      if (this.Q != 13) {
        break label160;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363952);
    }
    for (;;)
    {
      if (AppSetting.jdField_j_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText() + "按钮");
        this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new phl(this), 1000L);
      }
      return;
      c();
      break;
      label160:
      if ((this.Q == 14) || (this.Q == 21))
      {
        if (!TextUtils.isEmpty(this.ae)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.ae);
        } else {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
        }
      }
      else if (this.O == 3) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131365271));
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
      {
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean a(String paramString1, String paramString2)
  {
    if ((this.N == 9003) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1)) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d()))
    {
      b(String.format(getString(2131372356), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c()) }));
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a(paramString1))
    {
      a(paramString1);
      bool1 = bool2;
    }
    for (;;)
    {
      a(bool1);
      i();
      o();
      return bool1;
      bool1 = bool2;
      if (!d())
      {
        bool1 = bool2;
        if (!a(paramString1, paramString2))
        {
          bool1 = bool2;
          if (b(paramString1, paramString2, paramInt, paramString3))
          {
            bool2 = true;
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
            bool1 = bool2;
            if (this.N == 9003)
            {
              bool1 = bool2;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1))
              {
                this.jdField_b_of_type_Int += 1;
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a(paramString1))
    {
      a(paramString1);
      bool1 = bool2;
    }
    for (;;)
    {
      a(bool1);
      i();
      o();
      return bool1;
      bool1 = bool2;
      if (!d())
      {
        bool1 = bool2;
        if (b(paramString1, paramString2, paramInt, paramString3))
        {
          bool1 = true;
          this.jdField_i_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3, paramString4));
        }
      }
    }
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_i_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_i_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_g_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_g_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label280;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))
        {
          if ((d()) || (a(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b)) || (!b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b, ((ResultRecord)localObject).jdField_a_of_type_Int, ((ResultRecord)localObject).c))) {
            break;
          }
          this.jdField_i_of_type_JavaUtilArrayList.add(localObject);
          if ((this.N == 9003) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      if (9999 == this.N) {
        DingdongPluginHelper.a("0X8005EA7");
      }
    } while (this.N == 9003);
    label280:
    a(true);
    i();
    o();
    if (9999 == this.N) {
      DingdongPluginHelper.a("0X8005EA6");
    }
    return true;
  }
  
  public int b()
  {
    return this.N;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.p)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  public void b(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendResultBroadcastToVideo");
    }
    Intent localIntent = new Intent("tencent.video.q2v.SwitchToDiscuss");
    localIntent.setPackage(this.app.getApplication().getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong);
    localIntent.putExtra("qqPhoneUserList", paramArrayList);
    paramArrayList = null;
    if (this.jdField_j_of_type_JavaUtilArrayList != null)
    {
      int i2 = this.jdField_j_of_type_JavaUtilArrayList.size();
      paramArrayList = new long[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        paramArrayList[i1] = ((AddDiscussMemberInfo)this.jdField_j_of_type_JavaUtilArrayList.get(i1)).Uin;
        i1 += 1;
      }
    }
    localIntent.putExtra("memberUin", paramArrayList);
    this.app.a().sendBroadcast(localIntent);
    if (paramBoolean) {
      ((QCallFacade)this.app.getManager(37)).a(1, paramLong, "", "");
    }
  }
  
  public boolean b()
  {
    this.jdField_i_of_type_JavaUtilArrayList.clear();
    a(false);
    i();
    o();
    return true;
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i1;
    if (paramInt == 5)
    {
      bool = e();
      if (!bool) {
        QQToast.a(this, 2131370207, 1).b(getTitleBarHeight());
      }
      i1 = a(paramString1);
      if (i1 != 0) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        QQToast.a(this, i1, 1).b(getTitleBarHeight());
      }
      if ((!bool) || (paramInt == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.x;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.N = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.O = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.P = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.Q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_g_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.h = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.ad = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.U = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", Integer.MAX_VALUE);
    this.V = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_circle", false);
    this.k = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.l = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.p = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.q = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.r = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.ae = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.ae == null) {
      this.ae = getString(2131370173);
    }
    this.af = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.af == null) {
      this.af = getString(2131370177);
    }
    this.ag = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.ag == null) {
      this.ag = (this.af + "({0})");
    }
    this.s = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.S = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.T = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_report_type", 0);
    if ((this.Q == 14) || (this.Q == 21))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
          this.jdField_i_of_type_JavaUtilArrayList.add(localResultRecord);
        }
      }
    }
    this.v = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
  }
  
  boolean d()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.N == 3000)
    {
      bool1 = bool2;
      if (this.jdField_i_of_type_JavaUtilArrayList.size() >= this.U)
      {
        if ((this.Q != 12) || (this.U != 1)) {
          break label56;
        }
        b(2131368276);
        bool1 = true;
      }
    }
    label56:
    label106:
    label148:
    label255:
    label319:
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
                do
                {
                  return bool1;
                  b(2131368275);
                  break;
                  if (this.N != 1) {
                    break label255;
                  }
                  if (this.O != 0) {
                    break label106;
                  }
                  bool1 = bool2;
                } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.U);
                b(2131369769);
                return true;
                if (this.O != 1) {
                  break label148;
                }
                bool1 = bool2;
              } while (this.jdField_i_of_type_Boolean);
              bool1 = bool2;
            } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.U);
            b(2131369769);
            return true;
            bool1 = bool2;
          } while (this.O != 3);
          bool1 = bool2;
        } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.U);
        b(getString(2131372584));
        ReportController.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.ad, TroopMemberUtil.a(this.app, this.app.a(), this.ad) + "", "", "");
        return true;
        if (this.N != 9003) {
          break label319;
        }
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f();
        bool1 = bool2;
      } while (this.jdField_i_of_type_JavaUtilArrayList.size() < i1);
      b(String.format(getString(2131372357), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }));
      return true;
      bool1 = bool2;
    } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.U);
    if ((this.r) && (this.jdField_g_of_type_JavaUtilArrayList != null)) {}
    for (int i1 = this.jdField_g_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      b(String.format(getString(2131370200), new Object[] { Integer.valueOf(i1 + this.U) }));
      if (9999 == this.N) {
        DingdongPluginHelper.a("0X8005EA5");
      }
      return true;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetEditText.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i1) && (paramMotionEvent.getX() <= i1 + this.jdField_a_of_type_AndroidWidgetEditText.getWidth()) && (paramMotionEvent.getY() >= i2) && (paramMotionEvent.getY() > i2 + this.jdField_a_of_type_AndroidWidgetEditText.getHeight())) {}
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131559171);
    super.doOnCreate(paramBundle);
    d();
    a();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false) == true) {
      super.getWindow().addFlags(524288);
    }
    e();
    c();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    f();
    k();
    s();
    b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new phu(this);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if ((this.N == 9003) || (8998 == this.N))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
      Object localObject = getIntent().getStringArrayListExtra("param_uins_selected_friends");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramBundle = (FriendsManager)this.app.getManager(50);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = paramBundle.c(str);
          if (localFriends != null) {
            localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        a(localArrayList, false);
      }
    }
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      a(paramBundle, false);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider != null) {
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
    if (this.N == 9003)
    {
      b();
      ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
    c(false);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
    c(true);
    if ((this.N == 9003) && (this.mSystemBarComp != null))
    {
      int i1 = getResources().getColor(2131427710);
      this.mSystemBarComp.a(i1);
      this.mSystemBarComp.b(i1);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  protected void e()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296706);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.d = ((TextView)findViewById(2131297391));
    this.e = ((TextView)findViewById(2131297183));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298601));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131298602));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131297648));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131298597));
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298600));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297765);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298455));
  }
  
  protected void f()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter = new SelectMemberActivity.GridViewAdapter(this, this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    if ((this.jdField_i_of_type_JavaUtilArrayList.size() != 0) && ((this.Q == 14) || (this.Q == 21)))
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        localResultRecord.b = ContactUtils.f(this.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
      }
      a(true);
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new phm(this));
    this.e.setOnClickListener(new phn(this));
  }
  
  public void finish()
  {
    super.finish();
    switch (this.S)
    {
    default: 
      overridePendingTransition(0, 2130968584);
    }
    try
    {
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.Q == 15) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
        }
        if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
          l();
        }
        return;
        overridePendingTransition(2130968587, 2130968588);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "", localException);
        }
      }
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new phq(this));
  }
  
  public void h()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i3;
    int i2;
    int i1;
    switch (this.N)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.s)
      {
        localObject1 = this.jdField_g_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new ResultRecord();
          ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((ResultRecord)localObject3).jdField_a_of_type_Int = 0;
          ((ResultRecord)localObject3).c = "-1";
          this.jdField_i_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      localObject1 = (FriendsManager)this.app.getManager(50);
      i3 = this.jdField_i_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      i2 = 0;
      i1 = 0;
      label208:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).jdField_a_of_type_Int == 3) {
          i2 = 1;
        }
        if (((ResultRecord)localObject3).jdField_a_of_type_Int != 5)
        {
          i1 = 1;
          label249:
          if ((i2 == 0) || (i1 == 0)) {
            break;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label300:
        if ((this.O != 0) || (i3 != 1) || ((this.Q == 10) && (this.Q != 13)) || (i1 == 0)) {
          break label906;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C conversation");
        }
        localObject2 = new Intent(this, SplashActivity.class);
        AIOUtils.a((Intent)localObject2, null);
        ((Intent)localObject2).putExtra("uin", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject3 = ((FriendsManager)localObject1).c(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
          if (!((FriendsManager)localObject1).b(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString)) {
            break label709;
          }
          ((Intent)localObject2).putExtra("uintype", 0);
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          ((Intent)localObject2).putExtra("cSpecialFlag", ((Friends)localObject3).cSpecialFlag);
          if (((Friends)localObject3).cSpecialFlag == 1)
          {
            ((Intent)localObject2).setClass(this, SplashActivity.class);
            ((Intent)localObject2).putExtra("chat_subType", 1);
          }
        }
        ((Intent)localObject2).putExtra("uinname", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b);
        if (this.Q != 13) {
          break label891;
        }
        localObject1 = null;
        localObject3 = ((Intent)localObject2).getStringExtra("troop_uin");
        i1 = ((Intent)localObject2).getIntExtra("uintype", -1);
        if (i1 == -1) {
          break;
        }
        PhoneContact localPhoneContact = ((PhoneContactManager)this.app.getManager(10)).a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localPhoneContact != null) {
          localObject1 = localPhoneContact.nationCode + localPhoneContact.mobileCode;
        }
        localObject2 = new pgx(this, (Intent)localObject2);
        ChatActivityUtils.a(this.app, this, i1, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b, (String)localObject1, true, (String)localObject3, true, true, (ChatActivityUtils.StartVideoListener)localObject2, "from_internal");
        return;
        break label208;
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label300;
        label709:
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("uintype", 1000);
          localObject1 = a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c);
          if (localObject1 != null) {
            ((Intent)localObject2).putExtra("troop_uin", (String)localObject1);
          }
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          ((Intent)localObject2).putExtra("uintype", 1004);
          ((Intent)localObject2).putExtra("troop_uin", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c);
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3)
        {
          ((Intent)localObject2).putExtra("uintype", 1021);
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4)
        {
          ((Intent)localObject2).putExtra("uintype", 1006);
        }
      }
      label891:
      startActivity((Intent)localObject2);
      this.S = 2;
      finish();
      return;
      label906:
      if ((this.O == 0) && (i3 == 1) && (this.Q == 10) && (i1 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C audio");
        }
        if ((((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 0) && (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != 1)) {
          break label1684;
        }
        localObject1 = a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c);
        i1 = 1000;
      }
      for (;;)
      {
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          i1 = 1004;
          localObject1 = ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).c;
        }
        for (;;)
        {
          if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3) {
            i1 = 1021;
          }
          for (;;)
          {
            localObject2 = null;
            localObject3 = ((PhoneContactManager)this.app.getManager(10)).a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
            if (localObject3 != null) {
              localObject2 = ((PhoneContact)localObject3).nationCode + ((PhoneContact)localObject3).mobileCode;
            }
            localObject3 = new pgy(this);
            ChatActivityUtils.a(this.app, this, i1, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b, (String)localObject2, true, (String)localObject1, true, true, (ChatActivityUtils.StartVideoListener)localObject3, "from_internal");
            return;
            if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4) {
              i1 = 1006;
            }
          }
          if (this.O == 0)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
            label1258:
            if (this.O != 0) {
              break label1403;
            }
          }
          label1403:
          for (i2 = 2131368254;; i2 = 2131368255)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(i2);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            if ((this.O == 0) || (i1 != 0))
            {
              localObject1 = new pgz(this, (FriendsManager)localObject1);
              ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
              ThreadManager.a((Runnable)localObject1, null, false);
            }
            if (this.O == 0) {
              break;
            }
            p();
            if (i1 != 0) {
              break;
            }
            finish();
            return;
            ReportController.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
            break label1258;
          }
          localObject1 = new ArrayList();
          localObject2 = this.jdField_i_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(((ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
          }
          if ((((ArrayList)localObject1).size() > 0) && (this.ad.length() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.ad + " member count: " + ((ArrayList)localObject1).size());
            }
            if (!a())
            {
              QQToast.a(this, 2131369501, 0).b(getTitleBarHeight());
              return;
            }
            ((TroopHandler)this.app.a(20)).a(this.ad, (ArrayList)localObject1, "");
            r();
            this.jdField_a_of_type_AndroidAppDialog.show();
            return;
          }
          finish();
          return;
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          if (this.Q == 15)
          {
            localObject1 = new Intent(this, BlessTypeActivity.class);
            ((Intent)localObject1).putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
            startActivity((Intent)localObject1);
            return;
          }
          this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
          setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
          finish();
          return;
          q();
          return;
        }
        label1684:
        i1 = 0;
        localObject1 = null;
      }
      break label249;
    }
  }
  
  public void i()
  {
    if (this.jdField_i_of_type_JavaUtilArrayList.size() >= this.V)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    int i1 = (int)(this.jdField_a_of_type_Float * 40.0F);
    int i2 = (int)(this.jdField_a_of_type_Float * 10.0F);
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > 0) {
      if (this.jdField_i_of_type_JavaUtilArrayList.size() < 5)
      {
        i1 = (int)((this.jdField_i_of_type_JavaUtilArrayList.size() * 40 + this.jdField_i_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float) + (int)(this.jdField_a_of_type_Float * 10.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i1, 0, i2, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
      i1 = (int)(230.0F * this.jdField_a_of_type_Float);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    g();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new phr(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new phs(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new pht(this));
  }
  
  void l()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.x = false;
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838325);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void n()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void o()
  {
    String str = null;
    int i1 = 0;
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label139;
      }
      if (i1 >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(a(), this.jdField_g_of_type_JavaUtilArrayList);
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.b;
      label99:
      i1 += 1;
    }
    label139:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.b;
      break label99;
    }
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      l();
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      l();
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    case 0: 
    default: 
      return super.onBackEvent();
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      n();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    case 7: 
      n();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      return true;
    case 8: 
      if (this.o)
      {
        finish();
        return true;
      }
      n();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
      return true;
    case 9: 
      if (this.p)
      {
        finish();
        return true;
      }
      n();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
      return true;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.Q == 11)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005529", "0X8005529", 0, 0, "", "", "", "");
        return;
      }
    } while (this.Q != 10);
    ReportController.b(this.app, "CliOper", "", "", "0X8005524", "0X8005524", 0, 0, "", "", "", "");
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((this.N == 9003) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.g()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localFriendsManager.c(str);
          if (localFriends != null) {
            localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        a(localArrayList, true);
        ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
      }
    }
  }
  
  protected void p()
  {
    if ((this.jdField_i_of_type_JavaUtilArrayList != null) && (this.jdField_i_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject = a();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i1 = this.jdField_i_of_type_JavaUtilArrayList.size();
      localObject = ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b;
      localIntent.putExtra("InviteCount", i1);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\SelectMemberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
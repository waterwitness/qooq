package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener2;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mub;
import muc;
import mud;
import mue;
import muf;
import mug;
import muh;
import mui;
import muj;
import muk;
import mun;
import muo;
import mup;
import muq;
import mur;
import mus;
import mut;
import muu;
import muv;
import muw;
import muz;
import mvb;
import mvh;
import mvi;
import mvj;
import mvk;
import mvm;
import mvn;
import mvo;
import mvp;
import mvq;
import mvr;
import mvs;
import mvt;
import mvu;
import mvv;
import mvw;
import mvx;
import mvy;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopMemberListActivity
  extends BaseActivity
  implements IndexView.OnIndexChangedListener, IndexView.OnIndexChangedListener2, AdapterView.OnItemClickListener
{
  public static final int A = 8;
  public static final int B = 9;
  public static final int C = 11;
  public static final int D = 12;
  public static final int E = 13;
  public static final int F = 14;
  protected static final int H = 0;
  protected static final int I = 1;
  public static final String K = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
  protected static final int L = 1;
  protected static final int M = 2;
  public static final int R = 500;
  public static final int S = 300000;
  public static final int T = 86400000;
  public static final int U = 21600000;
  public static final int V = 60000;
  public static final int X = 0;
  public static final int Y = 1;
  public static final int Z = 2;
  public static final int a = 1;
  public static final String a = "TroopMemberListActivityget_troop_member";
  public static final int aa = 3;
  public static final int ab = 4;
  public static final int ac = 5;
  public static final int ad = 6;
  public static final int ae = 7;
  public static final int af = 5;
  public static final int ag = 34;
  public static final int ah = 250;
  private static int ak = 1000;
  public static double b = 0.0D;
  public static final int b = 2;
  public static final String b = "last_update_time";
  private static final double c = 0.9D;
  public static final int c = 3;
  public static final String c = "key_last_update_time";
  protected static final int d = 1;
  public static final String d = "key_last_update_num";
  protected static final int e = 2;
  public static final String e = "key_troop_info_last_update";
  protected static final int f = 5;
  public static final String f = "member_uin";
  protected static final int g = 6;
  public static final String g = "member_display_name";
  protected static final int h = 7;
  public static final String h = "troop_uin";
  protected static final int i = 8;
  public static final String i = "troop_gift_from";
  protected static final int j = 9;
  protected static final int k = 10;
  protected static final int l = 11;
  protected static final int m = 12;
  protected static final int n = 13;
  public static final int q = 0;
  public static final int r = 1;
  public static final String r = "param_is_pop_up_style";
  public static final int s = 0;
  public static final String s = "param_from";
  public static final int t = 1;
  public static final String t = "param_troop_fee_project_id";
  public static final int u = 2;
  public static final String u = "param_troop_fee_entrance_type";
  public static final int v = 3;
  public static final String v = "param_troop_send_apollo_msg";
  public static final int w = 4;
  public static final String w = "param_chat_mode";
  public static final int x = 5;
  public static final String x = "custom_title_name";
  public static final int y = 6;
  public static final String y = "Show_Newer_GuideFlag_Of_ContactsMode";
  public static final int z = 7;
  protected static final String z = "http://exp.qq.com/ur/?urid=23242";
  public String A;
  protected String B;
  protected String C;
  protected String D;
  protected String E;
  public String F = "2";
  public int G;
  public String G;
  protected String H = "";
  public String I = "";
  public int J;
  public String J;
  public int K = -1;
  public String L;
  protected int N = 0;
  protected int O = Integer.MAX_VALUE;
  protected int P;
  protected int Q;
  public int W = 0;
  public double a;
  public float a;
  protected long a;
  public Dialog a;
  protected Drawable a;
  public Handler a;
  protected LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  public TextView a;
  public TroopMemberListActivity.ListAdapter a;
  public TroopMemberListActivity.SearchResultAdapter a;
  protected DiscussionHandler a;
  public DiscussionObserver a;
  public TroopObserver a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public HttpWebCgiAsyncTask.Callback a;
  protected TroopInfoData a;
  protected IndexView a;
  public PinnedDividerListView a;
  public PullRefreshHeader a;
  public TabBarView a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  protected OverScrollViewListener a;
  protected XListView a;
  public ArrayList a;
  public List a;
  public ConcurrentHashMap a;
  public boolean a;
  private int ai = -1;
  private int aj;
  protected long b;
  public Dialog b;
  protected Drawable b;
  public View.OnClickListener b;
  protected View b;
  protected RelativeLayout b;
  protected TextView b;
  public List b;
  public boolean b;
  public long c;
  protected Drawable c;
  public View.OnClickListener c;
  protected View c;
  protected RelativeLayout c;
  protected TextView c;
  protected List c;
  public boolean c;
  public long d;
  public View.OnClickListener d;
  protected View d;
  public RelativeLayout d;
  public TextView d;
  protected List d;
  public boolean d;
  private long e;
  public View e;
  public RelativeLayout e;
  public List e;
  public boolean e;
  protected RelativeLayout f;
  private List f;
  public boolean f;
  protected boolean g;
  public boolean h;
  public boolean i;
  public String j;
  protected boolean j;
  public String k;
  protected boolean k;
  protected String l;
  public boolean l;
  protected String m;
  public boolean m;
  public String n;
  private boolean n;
  public int o;
  public String o;
  private boolean o;
  protected int p;
  public String p;
  protected String q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Double = 10.0D;
  }
  
  public TroopMemberListActivity()
  {
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_p_of_type_JavaLangString = "";
    this.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_j_of_type_Boolean = true;
    this.jdField_J_of_type_Int = 0;
    this.jdField_G_of_type_JavaLangString = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new mvu(this);
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new muk(this);
    this.jdField_a_of_type_AndroidOsHandler = new mur(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new mus(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new mut(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_J_of_type_JavaLangString = "";
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new muw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new muz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mvb(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new mvp(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new mvr(this);
  }
  
  private int a()
  {
    int i1 = 1;
    switch (this.jdField_J_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_o_of_type_Boolean) {
        i1 = 3;
      }
      return i1;
      i1 = 2;
    }
  }
  
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, TroopMemberListActivity.class);
    paramContext.putExtra("troop_uin", paramString);
    paramContext.putExtra("param_from", paramInt);
    return paramContext;
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mvq(this), paramLong);
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((this.jdField_e_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 4)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[1]);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[2]);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[3]);
        if (this.jdField_a_of_type_JavaUtilList.size() != 0)
        {
          h();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter == null) {
            break label271;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
        }
        if ((!this.jdField_d_of_type_Boolean) || (this.jdField_J_of_type_Int == 11)) {
          k();
        }
        d();
        return;
      }
      if ((paramMessage != null) && (paramMessage.length == 1))
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
        }
        label271:
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
      }
    }
  }
  
  private void a(List paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!Utils.c(localTroopMemberInfo.memberuin)) {
          break label153;
        }
        if ((this.jdField_J_of_type_Int != 2) || ((!localTroopMemberInfo.memberuin.equals(this.jdField_n_of_type_JavaLangString)) && (!this.jdField_o_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin)))) {
          break label192;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label153:
        if (QLog.isColorLevel())
        {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:" + localTroopMemberInfo.memberuin);
          continue;
          label192:
          if (!localTroopMemberInfo.memberuin.equals("50000000")) {
            localArrayList.add(a(localTroopMemberInfo, localFriendsManager));
          }
        }
      }
    }
    paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localArrayList);
    paramList.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_c_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305224)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null)) {
        break label172;
      }
    }
    label172:
    TextView localTextView;
    Button localButton;
    int i1;
    do
    {
      return;
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297466)).setTextColor(getResources().getColor(2131428262));
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305224);
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305226);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new mvi(this));
      i1 = ((SVIPHandler)this.app.a(13)).h();
      if (this.jdField_J_of_type_Int != 11) {
        break;
      }
    } while (!paramString1.equals(this.jdField_j_of_type_JavaLangString));
    this.jdField_o_of_type_Int = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label302:
      this.jdField_c_of_type_Boolean = paramBoolean1;
      if (!this.jdField_c_of_type_Boolean) {
        break label447;
      }
      this.jdField_p_of_type_JavaLangString = ("剩余" + paramInt1 + "次");
      localTextView.setText(this.jdField_p_of_type_JavaLangString);
      paramString1 = "@全体成员" + "," + this.jdField_p_of_type_JavaLangString;
      label384:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
        paramString2.rightMargin = AIOUtils.a(20.0F, getResources());
        localTextView.setLayoutParams(paramString2);
      }
    }
    for (paramString2 = paramString1;; paramString2 = "@全体成员" + "," + paramString1)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString2);
      return;
      paramBoolean1 = false;
      break label302;
      label447:
      if (paramInt1 == 0)
      {
        this.jdField_p_of_type_JavaLangString = "该功能的使用次数已用完";
        paramString1 = "@全体成员" + "," + "剩余0次";
        localTextView.setText("剩余0次");
        break label384;
      }
      this.jdField_p_of_type_JavaLangString = "";
      paramString1 = "@全体成员" + "," + "现在无法发送@All消息";
      localTextView.setText("");
      break label384;
      if (!paramString1.equals(this.jdField_k_of_type_JavaLangString)) {
        break;
      }
      this.jdField_c_of_type_Boolean = paramBoolean2;
      this.jdField_p_of_type_JavaLangString = paramString3;
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("TroopMemberListActivityget_troop_member", 1, "updateUIForAtAllRemainedCount remainTips empty");
        return;
      }
      paramString1 = paramString2;
      if (!this.jdField_c_of_type_Boolean)
      {
        paramString1 = paramString2;
        if (i1 != 3)
        {
          localButton.setVisibility(0);
          paramString2 = paramString2 + ",\n超级会员可继续使用";
          localTextView.setGravity(21);
          localTextView.setLineSpacing(this.jdField_a_of_type_Float * 5.0F, 1.0F);
          paramInt1 = (int)("超级会员可继续使用".length() * 12 * this.jdField_a_of_type_Float);
          new DisplayMetrics();
          paramInt2 = (int)(getResources().getDisplayMetrics().widthPixels - 227.0F * this.jdField_a_of_type_Float - 5.0F * this.jdField_a_of_type_Float);
          paramString1 = paramString2;
          if (paramInt1 > paramInt2)
          {
            localTextView.setSingleLine(false);
            localTextView.setLines(2);
            localTextView.setWidth(paramInt2);
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            paramString1 = paramString2;
          }
        }
      }
      paramString2 = new SpannableString(paramString1);
      paramString3 = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (!TextUtils.isEmpty(paramString3))
      {
        paramInt1 = paramString1.indexOf(paramString3);
        paramInt2 = paramString3.length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      if (paramString1.contains("超级会员"))
      {
        paramInt1 = paramString1.indexOf("超级会员");
        paramInt2 = "超级会员".length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      localTextView.setText(paramString2);
    }
  }
  
  private void b(long paramLong)
  {
    if (paramLong == 1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverscrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getContext().getResources().getDrawable(2130838317));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    }
    while (paramLong != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverscrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getContext().getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverScrollHeader(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverScrollListener(null);
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130904937);
    Object localObject = this.jdField_b_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getSystemService("input_method");
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_b_of_type_AndroidAppDialog.getWindow().addFlags(67108864);
      int i1 = getResources().getColor(2131428295);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296895);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131298733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter = new TroopMemberListActivity.SearchResultAdapter(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new muf(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopMemberListActivity.SearchTextWatcher(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296895);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131300880));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297767);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297765));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new mug(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new muh(this));
  }
  
  private void p()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
    localIntent.putExtra("param_only_troop_member", true);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_done_button_wording", getString(2131370179));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131370180));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("group_uin", this.jdField_k_of_type_JavaLangString);
    localIntent.putExtra("group_name", this.jdField_l_of_type_JavaLangString);
    startActivityForResult(localIntent, 3);
  }
  
  private void q()
  {
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf(0), Integer.valueOf(this.aj) }));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public TroopMemberListActivity.ATroopMember a(DiscussionMemberInfo paramDiscussionMemberInfo, FriendsManager paramFriendsManager)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramFriendsManager != null) {
      localFriends = paramFriendsManager.a(paramDiscussionMemberInfo.memberUin);
    }
    localATroopMember.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.jdField_a_of_type_Short = 0;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localATroopMember.e(localFriends.remark);
      localATroopMember.g(ChnToSpell.a(localATroopMember.jdField_k_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_k_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localATroopMember.h(paramDiscussionMemberInfo.memberName);
        localATroopMember.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localATroopMember.i(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      return localATroopMember;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localATroopMember.e(paramDiscussionMemberInfo.inteRemark);
        localATroopMember.g(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localATroopMember.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public TroopMemberListActivity.ATroopMember a(TroopMemberInfo paramTroopMemberInfo, FriendsManager arg2)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (??? != null) {
      localFriends = ???.a(paramTroopMemberInfo.memberuin);
    }
    localATroopMember.jdField_b_of_type_JavaLangString = ContactUtils.f(this.app, this.jdField_k_of_type_JavaLangString, localATroopMember.jdField_a_of_type_JavaLangString);
    localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localATroopMember.e(localFriends.remark);
      localATroopMember.g(ChnToSpell.a(localATroopMember.jdField_k_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_k_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.troopnick != null) && (paramTroopMemberInfo.troopnick.length() > 0))
      {
        localATroopMember.h(paramTroopMemberInfo.troopnick);
        localATroopMember.j(paramTroopMemberInfo.pyAll_troopnick);
        localATroopMember.i(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localATroopMember.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localATroopMember.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localATroopMember.u = paramTroopMemberInfo.mUniqueTitle;
        localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_J_of_type_Int == 6)) {}
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        paramTroopMemberInfo = (TroopMemberCardInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramTroopMemberInfo.memberuin);
        if (paramTroopMemberInfo != null)
        {
          if (paramTroopMemberInfo.tel != null) {
            localATroopMember.e = paramTroopMemberInfo.tel;
          }
          if (paramTroopMemberInfo.job != null) {
            localATroopMember.v = paramTroopMemberInfo.job;
          }
          if (TextUtils.getTrimmedLength(localATroopMember.e) <= 0) {
            localATroopMember.e = "";
          }
          if (TextUtils.getTrimmedLength(localATroopMember.v) <= 0) {
            localATroopMember.v = "";
          }
        }
        return localATroopMember;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
          continue;
        }
        localATroopMember.e(paramTroopMemberInfo.autoremark);
        localATroopMember.g(paramTroopMemberInfo.pyAll_autoremark);
        localATroopMember.f(paramTroopMemberInfo.pyFirst_autoremark);
      }
    }
  }
  
  public TroopMemberListActivity.ATroopMember a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeItem:" + paramString);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.remove(i1);
            return paramString;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public TroopMemberListActivity.TmViewHolder a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int i2;
    int i1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
      i2 = ((ViewGroup)localObject1).getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label135;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof TroopMemberListActivity.TmViewHolder)))
      {
        localObject2 = (TroopMemberListActivity.TmViewHolder)((View)localObject2).getTag();
        if ((((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString != null) && (((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "findListItemHolderByUin:" + i1);
          }
          return (TroopMemberListActivity.TmViewHolder)localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
          break;
        }
      }
      i1 += 1;
    }
    label135:
    return null;
  }
  
  protected void a()
  {
    Object localObject = (ViewGroup)findViewById(2131297082);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131296706);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131297083);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void a(int paramInt)
  {
    if (!this.jdField_f_of_type_Boolean) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 0);
        localObject1 = (ViewStub)findViewById(2131305208);
      } while (localObject1 == null);
      localObject1 = ((ViewStub)localObject1).inflate();
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131303326));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new mvn(this));
      ((ImageView)((View)localObject1).findViewById(2131296798)).setOnClickListener(new mvo(this));
      localObject1 = (ImageView)((View)localObject1).findViewById(2131305145);
    } while (localObject1 == null);
    Object localObject2 = getResources().getDisplayMetrics();
    paramInt = (int)((((DisplayMetrics)localObject2).widthPixels - (int)(((DisplayMetrics)localObject2).density * 50.0F + 0.5F)) / 6.0D);
    localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = paramInt;
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    b(paramLong);
    Object localObject;
    TroopInfo localTroopInfo;
    if (this.jdField_J_of_type_Int == 6)
    {
      localObject = getResources().getStringArray(2131230776);
      this.W = 0;
      a(this.jdField_a_of_type_ComTencentWidgetActionSheet, (String[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
      h();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
      if (paramLong != 0L) {
        break label255;
      }
      this.jdField_J_of_type_Int = this.N;
      this.jdField_a_of_type_Long = 0L;
      this.W = 0;
      if (!this.g)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367347));
        if ((this.B != null) && (!TextUtils.isEmpty(this.B))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.B);
        }
      }
      if (paramBoolean)
      {
        localObject = (TroopManager)this.app.getManager(51);
        if (localObject != null)
        {
          localTroopInfo = ((TroopManager)localObject).a(this.jdField_k_of_type_JavaLangString);
          if (localTroopInfo != null)
          {
            localTroopInfo.dwOfficeMode = this.jdField_a_of_type_Long;
            ((TroopManager)localObject).b(localTroopInfo);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      }
      if (paramBoolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X80054AF", "0X80054AF", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      localObject = getResources().getStringArray(2131230775);
      break;
      label255:
      if (paramLong == 1L)
      {
        this.N = this.jdField_J_of_type_Int;
        this.jdField_J_of_type_Int = 6;
        this.jdField_a_of_type_Long = 1L;
        this.W = 0;
        if (!this.g)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367349));
          if ((this.B != null) && (!TextUtils.isEmpty(this.B))) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.B);
          }
        }
        if (paramBoolean)
        {
          localObject = (TroopManager)this.app.getManager(51);
          if (localObject != null)
          {
            localTroopInfo = ((TroopManager)localObject).a(this.jdField_k_of_type_JavaLangString);
            if (localTroopInfo != null)
            {
              localTroopInfo.dwOfficeMode = this.jdField_a_of_type_Long;
              ((TroopManager)localObject).b(localTroopInfo);
            }
          }
        }
        if (this.jdField_j_of_type_Boolean)
        {
          q();
          this.jdField_j_of_type_Boolean = false;
          ThreadManager.a(new mvk(this), 8, null, true);
        }
        while (paramBoolean)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X80054AE", "0X80054AE", 0, 0, "", "", "", "");
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          }
        }
      }
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new mvy(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    int i1 = 3;
    if ((paramATroopMember != null) && (paramATroopMember.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
      paramATroopMember = new Intent();
      paramATroopMember.putExtra("result", new JSONArray().toString());
      setResult(-1, paramATroopMember);
      ReportController.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_k_of_type_JavaLangString, "", "", "");
      finish();
    }
    Object localObject1;
    Object localObject2;
    label558:
    do
    {
      do
      {
        return;
      } while ((paramATroopMember == null) || (paramATroopMember.jdField_a_of_type_JavaLangString == null));
      if (this.jdField_J_of_type_Int == 1)
      {
        if (this.app.a().equals(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localObject1 = new ProfileActivity.AllInOne(paramATroopMember.jdField_a_of_type_JavaLangString, 0);
          ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.i(this.app, paramATroopMember.jdField_a_of_type_JavaLangString);
          ((ProfileActivity.AllInOne)localObject1).f = 3;
          ((ProfileActivity.AllInOne)localObject1).g = 4;
          ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
          return;
        }
        a(paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_b_of_type_JavaLangString);
        return;
      }
      if (this.jdField_J_of_type_Int == 2)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_k_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        localObject2 = new TroopMemberListActivity.TroopAdmin();
        ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
        ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramATroopMember.jdField_a_of_type_Short;
        ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramATroopMember.jdField_b_of_type_JavaLangString;
        ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
        setResult(-1, (Intent)localObject1);
        finish();
        return;
      }
      if ((this.jdField_J_of_type_Int == 3) || (this.jdField_J_of_type_Int == 11))
      {
        localObject1 = getIntent();
        if (this.jdField_o_of_type_Boolean)
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("isApollo", true);
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
          setResult(-1, (Intent)localObject1);
          finish();
          return;
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
        }
      }
      if ((this.jdField_J_of_type_Int == 0) || (this.jdField_J_of_type_Int == 4) || (this.jdField_J_of_type_Int == 6) || (this.jdField_J_of_type_Int == 9))
      {
        e(paramATroopMember.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_J_of_type_Int == 5)
      {
        if ((this.jdField_n_of_type_JavaLangString != null) && (this.jdField_n_of_type_JavaLangString.equals(paramATroopMember.jdField_a_of_type_JavaLangString)))
        {
          startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_k_of_type_JavaLangString, paramATroopMember.jdField_a_of_type_JavaLangString, i1, paramATroopMember.u, paramATroopMember.jdField_b_of_type_Int), 2);
          this.L = paramATroopMember.jdField_a_of_type_JavaLangString;
          localObject1 = this.app;
          localObject2 = this.jdField_k_of_type_JavaLangString;
          i1 = this.W;
          if (!this.jdField_m_of_type_Boolean) {
            break label558;
          }
        }
        for (paramATroopMember = "1";; paramATroopMember = "0")
        {
          ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramATroopMember, "");
          return;
          if ((this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
          {
            i1 = 2;
            break;
          }
          i1 = 1;
          break;
        }
      }
      if ((this.jdField_J_of_type_Int == 8) || (this.jdField_J_of_type_Int == 14))
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_k_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("troop_gift_from", this.jdField_m_of_type_JavaLangString);
        setResult(-1, (Intent)localObject1);
        finish();
        return;
      }
    } while (this.jdField_J_of_type_Int != 12);
    if (this.O == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
      paramATroopMember = new Intent();
      localObject1 = new JSONArray();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((Iterator)localObject2).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("uin", localATroopMember.jdField_a_of_type_JavaLangString);
              localJSONObject.put("nick", localATroopMember.jdField_b_of_type_JavaLangString);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopMemberListActivityget_troop_member", 2, "json put error");
                }
              }
            }
          }
        }
      }
      paramATroopMember.putExtra("result", ((JSONArray)localObject1).toString());
      setResult(-1, paramATroopMember);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.remove(paramATroopMember);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.size() < this.O)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
      }
      else if (this.O == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
      }
      else
      {
        QQToast.a(this, "最多只能选" + this.O + "个成员!", 0).a();
      }
    }
  }
  
  protected void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = this.jdField_J_of_type_JavaLangString;
      paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean;
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if ((this.jdField_J_of_type_Int != 13) || (!paramBoolean)) {
        break label542;
      }
      paramBitmap = paramATroopMember.jdField_b_of_type_JavaLangString + "(" + paramATroopMember.jdField_a_of_type_JavaLangString + ")";
      SpannableString localSpannableString = new SpannableString(paramBitmap);
      localSpannableString.setSpan(new ForegroundColorSpan(-7829368), paramATroopMember.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(localSpannableString);
      label149:
      paramTmViewHolder.jdField_b_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
      paramTmViewHolder.jdField_c_of_type_Int = 1;
      paramTmViewHolder.g.setText("");
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
      if (this.jdField_J_of_type_Int != 9) {
        break label556;
      }
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label201:
      paramTmViewHolder.h.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (!this.jdField_b_of_type_Boolean) {
        break label571;
      }
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
      label271:
      if ((this.jdField_J_of_type_Int != 1) && (this.jdField_J_of_type_Int != 13)) {
        break label653;
      }
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368285) + paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText().toString());
      if (this.jdField_J_of_type_Int != 13) {
        break label590;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label347:
      if (!str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        break label642;
      }
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
      label367:
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131368282), new Object[] { paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText().toString() }));
      paramTmViewHolder.h.setContentDescription(getString(2131368283));
      label417:
      if (this.jdField_J_of_type_Int != 6) {
        break label2505;
      }
      if ((paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a())) || (TextUtils.isEmpty(paramATroopMember.e))) {
        break label2481;
      }
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramTmViewHolder.e.setVisibility(0);
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(paramATroopMember.e)) {
        break label2493;
      }
      paramTmViewHolder.e.setText(getString(2131367396));
      return;
      str = this.I;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label542:
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramATroopMember.jdField_b_of_type_JavaLangString);
      break label149;
      label556:
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean));
      break label201;
      label571:
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label271;
      label590:
      if ((this.jdField_n_of_type_JavaLangString != null) && (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString)))
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label347;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label347;
      label642:
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label367;
      label653:
      if (this.W == 2) {
        if (this.jdField_J_of_type_Int != 5) {
          if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString)))
          {
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            if (TextUtils.isEmpty(paramATroopMember.u))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367352);
              label718:
              TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, 0);
              label727:
              paramTmViewHolder.f.setVisibility(0);
              paramTmViewHolder.f.setText(getString(2131367393, new Object[] { Long.valueOf(paramATroopMember.jdField_c_of_type_Long) }));
              label763:
              if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankSysFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag != 1)) && (paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
              {
                if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString))) {
                  break label2373;
                }
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367352);
              }
            }
          }
        }
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString))) || ((!this.app.a().equals(this.jdField_n_of_type_JavaLangString)) && (this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString))))
          {
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
            break;
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
            break label718;
            if ((this.jdField_o_of_type_JavaLangString != null) && (paramATroopMember != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.u)) {
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367351);
              }
              for (;;)
              {
                TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 1, 0);
                break;
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
              }
            }
            if (TextUtils.isEmpty(paramATroopMember.u))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              break label727;
            }
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
            TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 2, 0);
            break label727;
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            paramTmViewHolder.j.setVisibility(0);
            if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString)))
            {
              paramTmViewHolder.i.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.u)) {
                paramTmViewHolder.i.setText(2131367352);
              }
              for (;;)
              {
                TroopRankColorConfig.a(paramTmViewHolder.i, 0, 0);
                break;
                paramTmViewHolder.i.setText(paramATroopMember.u);
              }
            }
            if ((this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.i.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.u)) {
                paramTmViewHolder.i.setText(2131367351);
              }
              for (;;)
              {
                TroopRankColorConfig.a(paramTmViewHolder.i, 1, 0);
                break;
                paramTmViewHolder.i.setText(paramATroopMember.u);
              }
            }
            if (!TextUtils.isEmpty(paramATroopMember.u))
            {
              paramTmViewHolder.i.setVisibility(0);
              paramTmViewHolder.i.setText(paramATroopMember.u);
              TroopRankColorConfig.a(paramTmViewHolder.i, 2, 0);
              break label727;
            }
            paramTmViewHolder.i.setVisibility(8);
            break label727;
            paramTmViewHolder.f.setVisibility(8);
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
            int i1;
            if ((this.jdField_J_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap() != null) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_a_of_type_Int)))))
            {
              i1 = 1;
              label1358:
              if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_n_of_type_JavaLangString))) {
                break label1775;
              }
              if (this.jdField_J_of_type_Int != 5) {
                break label1464;
              }
              paramTmViewHolder.i.setVisibility(0);
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              paramTmViewHolder.j.setVisibility(0);
              if (!TextUtils.isEmpty(paramATroopMember.u)) {
                break label1450;
              }
              paramTmViewHolder.i.setText(2131367352);
            }
            for (;;)
            {
              TroopRankColorConfig.a(paramTmViewHolder.i, 0, 0);
              break;
              i1 = 0;
              break label1358;
              label1450:
              paramTmViewHolder.i.setText(paramATroopMember.u);
            }
            label1464:
            if (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a()))
            {
              if (i1 != 0)
              {
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                if (TextUtils.isEmpty(paramATroopMember.u)) {
                  paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367352);
                }
                for (;;)
                {
                  TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, 0);
                  if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                    break;
                  }
                  paramTmViewHolder.g.setText(getString(2131367355));
                  break;
                  paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
                }
              }
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              if (this.jdField_J_of_type_Int == 11)
              {
                paramTmViewHolder.g.setText(getString(2131367355));
                break label763;
              }
              if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                break label763;
              }
              paramTmViewHolder.g.setText(getString(2131367354));
              break label763;
            }
            if (i1 != 0)
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.u)) {
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367352);
              }
              for (;;)
              {
                TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, 0);
                paramTmViewHolder.g.setText("");
                break;
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
              }
            }
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (this.jdField_J_of_type_Int == 11)
            {
              paramTmViewHolder.g.setText("");
              break label763;
            }
            if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
              break label763;
            }
            paramTmViewHolder.g.setText(getString(2131367352));
            break label763;
            label1775:
            if ((this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              if (this.jdField_J_of_type_Int == 5)
              {
                paramTmViewHolder.i.setVisibility(0);
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                paramTmViewHolder.j.setVisibility(0);
                if (TextUtils.isEmpty(paramATroopMember.u)) {
                  paramTmViewHolder.i.setText(2131367351);
                }
                for (;;)
                {
                  TroopRankColorConfig.a(paramTmViewHolder.i, 1, 0);
                  break;
                  paramTmViewHolder.i.setText(paramATroopMember.u);
                }
              }
              if (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a()))
              {
                if (i1 != 0)
                {
                  paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                  if (TextUtils.isEmpty(paramATroopMember.u)) {
                    paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367351);
                  }
                  for (;;)
                  {
                    TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 1, 0);
                    if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                      break;
                    }
                    paramTmViewHolder.g.setText(getString(2131367355));
                    break;
                    paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
                  }
                }
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                  break label763;
                }
                paramTmViewHolder.g.setText(getString(2131367353));
                break label763;
              }
              if (i1 != 0)
              {
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                if (TextUtils.isEmpty(paramATroopMember.u)) {
                  paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367351);
                }
                for (;;)
                {
                  TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 1, 0);
                  paramTmViewHolder.g.setText("");
                  break;
                  paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
                }
              }
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              if ((this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                break label763;
              }
              paramTmViewHolder.g.setText(getString(2131367351));
              break label763;
            }
            if (this.jdField_J_of_type_Int == 5)
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              paramTmViewHolder.j.setVisibility(0);
              if (!TextUtils.isEmpty(paramATroopMember.u))
              {
                paramTmViewHolder.i.setVisibility(0);
                paramTmViewHolder.i.setText(paramATroopMember.u);
                TroopRankColorConfig.a(paramTmViewHolder.i, 2, 0);
                break label763;
              }
              paramTmViewHolder.i.setVisibility(8);
              break label763;
            }
            if (i1 != 0) {
              if (TextUtils.isEmpty(paramATroopMember.u))
              {
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_a_of_type_Int)));
                TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 3, paramATroopMember.jdField_a_of_type_Int);
                label2271:
                paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              }
            }
            for (;;)
            {
              if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a())) || (this.jdField_J_of_type_Int == 9) || (this.jdField_J_of_type_Int == 12)) {
                break label2371;
              }
              paramTmViewHolder.g.setText(getString(2131367355));
              break;
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.u);
              TroopRankColorConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, 2, 0);
              break label2271;
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            label2371:
            break label763;
            label2373:
            if ((this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131367351);
              continue;
            }
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
          }
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (str.equals(paramATroopMember.jdField_a_of_type_JavaLangString))
          {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
            break;
          }
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
          break;
        }
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label417;
      label2481:
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label2493:
    paramTmViewHolder.e.setText(paramATroopMember.e);
    return;
    label2505:
    paramTmViewHolder.e.setVisibility(8);
    paramTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(ActionSheet paramActionSheet, String[] paramArrayOfString)
  {
    if (this.jdField_J_of_type_Int == 9) {
      break label9;
    }
    label9:
    while ((paramActionSheet == null) || (paramArrayOfString == null)) {
      return;
    }
    for (;;)
    {
      LinearLayout localLinearLayout;
      int i2;
      int i1;
      try
      {
        localLinearLayout = (LinearLayout)paramActionSheet.findViewById(2131296884);
        i2 = localLinearLayout.getChildCount();
        paramActionSheet = paramArrayOfString[this.W];
        if ((this.jdField_J_of_type_Int != 6) || (this.W != 5)) {
          break label244;
        }
        paramActionSheet = paramArrayOfString[1];
        if (!QLog.isColorLevel()) {
          break label247;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "checkSortType:" + paramActionSheet);
      }
      catch (Exception paramActionSheet) {}
      if (i1 >= i2) {
        break;
      }
      View localView = localLinearLayout.getChildAt(i1);
      if (localView != null)
      {
        paramArrayOfString = localView.findViewById(2131296886);
        localView = localView.findViewById(2131296887);
        if (((paramArrayOfString instanceof TextView)) && ((localView instanceof ImageView)))
        {
          if (paramActionSheet.equals(((TextView)paramArrayOfString).getText().toString()))
          {
            localView.setVisibility(0);
            localView.setContentDescription(getResources().getString(2131362094));
            break label253;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TroopMemberListActivityget_troop_member", 2, "checkSortType:" + paramActionSheet.toString());
            return;
          }
          localView.setVisibility(4);
          break label253;
          label244:
          continue;
          label247:
          i1 = 0;
          continue;
        }
      }
      label253:
      i1 += 1;
    }
  }
  
  protected void a(AdapterView paramAdapterView, int paramInt)
  {
    paramAdapterView = (TroopMemberListActivity.ATroopMember)paramAdapterView.a().getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    a(paramAdapterView);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeSearchItem:" + paramString);
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_b_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_J_of_type_Int == 11) && (paramInt == 1)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_J_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendsManager)this.app.getManager(50);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.jdField_a_of_type_Int = 20;
        paramString1.d = this.jdField_j_of_type_JavaLangString;
        paramString1.jdField_c_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
        paramString1.g = 4;
        ProfileActivity.b(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.jdField_a_of_type_Int = 21;
    paramString1.d = this.jdField_j_of_type_JavaLangString;
    paramString1.jdField_c_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
    paramString1.g = 4;
    ProfileActivity.b(this, paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport, actionName=" + paramString1 + " ext2=" + paramString2 + " ext3=" + paramString3 + " from=" + this.jdField_J_of_type_Int);
      }
      if (this.jdField_J_of_type_Int == 1) {
        return;
      }
      if (this.jdField_J_of_type_Int == 11) {
        return;
      }
      if (this.jdField_J_of_type_Int != 9) {
        break label177;
      }
      if (this.K != 1) {
        break label170;
      }
      paramString2 = "suc_pay_list";
    }
    catch (Exception paramString1)
    {
      while (QLog.isColorLevel())
      {
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport:" + paramString1.toString());
        return;
        label170:
        paramString2 = "un_pay_list";
      }
      label177:
      ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_k_of_type_JavaLangString, paramString2, paramString3, "");
    }
    ReportController.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_k_of_type_JavaLangString, paramString3, "", "");
    return;
  }
  
  protected void a(String paramString, List paramList)
  {
    ThreadManager.a(new muu(this, paramString, paramList), 8, null, true);
  }
  
  public Object[] a(String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList;
    long l1;
    Object localObject;
    long l2;
    int i2;
    try
    {
      localArrayList = new ArrayList();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = (FriendsManager)this.app.getManager(50);
        this.jdField_c_of_type_JavaUtilList = ((DiscussionManager)this.app.getManager(52)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
        }
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label559;
        }
        i2 = this.jdField_c_of_type_JavaUtilList.size();
        if (i1 < i2)
        {
          paramString = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
          if (paramString == null) {
            break label565;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.jdField_J_of_type_Int == 2) && (paramString.memberUin.equals(this.jdField_n_of_type_JavaLangString))) || ((this.jdField_J_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              break label565;
            }
            localArrayList.add(a(paramString, (FriendsManager)localObject));
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
        }
        paramString = new Object[1];
        paramString[0] = localArrayList;
        return paramString;
        if (!QLog.isColorLevel()) {
          break label565;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label322:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.a() == null) {
        break label574;
      }
    }
    finally {}
    this.app.a().f();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + localArrayList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(localArrayList);
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[4];
        paramString[0] = localArrayList;
        paramString[1] = localObject[0];
        paramString[2] = localObject[1];
        paramString[3] = localObject[2];
        break label322;
      }
      paramString = new Object[1];
      paramString[0] = localArrayList;
      break label322;
      label559:
      i1 = 0;
      continue;
      label565:
      i1 += 1;
      break;
      label574:
      i1 = i2;
    }
  }
  
  /* Error */
  public Object[] a(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1666	java/lang/System:currentTimeMillis	()J
    //   5: lstore 7
    //   7: new 211	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 212	java/util/ArrayList:<init>	()V
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 469	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: bipush 50
    //   21: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 477	com/tencent/mobileqq/app/FriendsManager
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 469	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 1715	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 1721	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 5
    //   41: aload_2
    //   42: invokeinterface 1423 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 1428 1 0
    //   54: ifeq +84 -> 138
    //   57: aload 5
    //   59: ldc_w 483
    //   62: iconst_0
    //   63: ldc_w 1723
    //   66: iconst_2
    //   67: anewarray 493	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: invokeinterface 1431 1 0
    //   82: checkcast 493	java/lang/String
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 1728	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull -49 -> 48
    //   100: aload 6
    //   102: invokeinterface 403 1 0
    //   107: ifle -59 -> 48
    //   110: aload_3
    //   111: aload_0
    //   112: aload 6
    //   114: iconst_0
    //   115: invokeinterface 481 2 0
    //   120: checkcast 483	com/tencent/mobileqq/data/TroopMemberInfo
    //   123: aload 4
    //   125: invokevirtual 508	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lcom/tencent/mobileqq/app/FriendsManager;)Lcom/tencent/mobileqq/activity/TroopMemberListActivity$ATroopMember;
    //   128: invokeinterface 511 2 0
    //   133: pop
    //   134: goto -86 -> 48
    //   137: astore_1
    //   138: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +34 -> 175
    //   144: ldc 49
    //   146: iconst_2
    //   147: new 448	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 1730
    //   157: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokestatic 1666	java/lang/System:currentTimeMillis	()J
    //   163: lload 7
    //   165: lsub
    //   166: invokevirtual 1678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_0
    //   176: monitorexit
    //   177: iconst_1
    //   178: anewarray 967	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_3
    //   184: aastore
    //   185: areturn
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	TroopMemberListActivity
    //   0	191	1	paramString	String
    //   0	191	2	paramList	List
    //   14	170	3	localArrayList	ArrayList
    //   27	97	4	localFriendsManager	FriendsManager
    //   39	19	5	localEntityManager	EntityManager
    //   93	20	6	localList	List
    //   5	159	7	l1	long
    // Exception table:
    //   from	to	target	type
    //   29	48	137	java/lang/Exception
    //   48	95	137	java/lang/Exception
    //   100	134	137	java/lang/Exception
    //   2	29	186	finally
    //   29	48	186	finally
    //   48	95	186	finally
    //   100	134	186	finally
    //   138	175	186	finally
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305207));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296706);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    if ((this.jdField_J_of_type_Int == 3) || (this.jdField_J_of_type_Int == 11))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297391));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131299166));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298104));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297005);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301381));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304977));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131304904));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131304905));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131362110));
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  public void b(String paramString, List paramList)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (this.jdField_f_of_type_JavaUtilList == null)
        {
          this.jdField_f_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
          this.jdField_a_of_type_Double = 0.0D;
          this.ai = -1;
          this.aj = 0;
        }
      }
      finally {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getTroopMemberFromDBIfNeeded, uin:" + paramString);
        }
        this.jdField_e_of_type_Long = System.currentTimeMillis();
        if (paramList != null)
        {
          localObject = paramList;
          if (!paramList.isEmpty()) {}
        }
        else
        {
          localObject = this.app.a().createEntityManager();
          paramList = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
          ((EntityManager)localObject).a();
          long l1 = System.currentTimeMillis();
          localObject = paramList;
          if (QLog.isColorLevel())
          {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "getTroopMemberFromDB, queryTime:" + (l1 - this.jdField_e_of_type_Long));
            localObject = paramList;
          }
        }
        if (this.jdField_J_of_type_Int == 6) {
          f(paramString);
        }
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          break label244;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
        }
        k();
      }
      catch (Exception paramString)
      {
        int i2;
        int i3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getTroopMemberFromDBIfNeeded:" + paramString.toString());
        continue;
      }
      catch (OutOfMemoryError paramString)
      {
        int i1;
        while (QLog.isColorLevel())
        {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getTroopMemberFromDBIfNeeded:" + paramString.toString());
          break;
          i1 = 1;
        }
      }
      return;
      this.jdField_f_of_type_JavaUtilList.clear();
      continue;
      label244:
      i2 = ((List)localObject).size();
      this.aj = i2;
      i3 = i2 / ak;
      if (i2 % ak != 0) {
        break;
      }
      i1 = 0;
      this.ai = (i1 + i3);
      i1 = 0;
      while (i1 < i2)
      {
        ThreadManager.a(new muv(this, (List)localObject, i1, Math.min(ak + i1 - 1, i2)), 8, null, true);
        i1 += ak;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getTroopMemberFromDBIfNeeded, listSize:" + i2 + "|mJobCount:" + this.ai);
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_J_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131369557));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368729));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368284));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    if (this.jdField_J_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367356));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367975);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new mvh(this));
      return;
    }
    if (this.jdField_J_of_type_Int == 3)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364627));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367262);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new mvs(this));
      return;
    }
    if (this.jdField_J_of_type_Int == 11)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364628));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367262);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new mvt(this));
      return;
    }
    if (this.jdField_J_of_type_Int == 5)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364879));
      if (this.q == null) {
        this.q = getString(2131367975);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.q);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      return;
    }
    if ((this.jdField_J_of_type_Int == 8) || (this.jdField_J_of_type_Int == 14))
    {
      if ((this.B != null) && (!TextUtils.isEmpty(this.B))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.B);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131365213);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    if (this.jdField_J_of_type_Int == 12)
    {
      if (this.C != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.C);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367262);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (this.jdField_J_of_type_Int == 6) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367349));
    }
    for (;;)
    {
      if ((this.B != null) && (!TextUtils.isEmpty(this.B))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.B);
      }
      if (this.q == null) {
        this.q = getString(2131367975);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.q);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368729);
      if (this.jdField_J_of_type_Int == 4) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131362110));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367347));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void c(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_J_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    String str1 = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramString = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label908;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
        localATroopMember.f = "";
        localATroopMember.g = "";
        if ((str1.equals(localATroopMember.jdField_n_of_type_JavaLangString)) || (str1.equals(localATroopMember.jdField_p_of_type_JavaLangString)) || (str1.equals(localATroopMember.jdField_o_of_type_JavaLangString)))
        {
          localATroopMember.f = localATroopMember.jdField_n_of_type_JavaLangString;
          localArrayList1.add(localATroopMember);
          if (!QLog.isColorLevel()) {
            break label1085;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localATroopMember.jdField_a_of_type_JavaLangString + "," + localATroopMember.f);
          break label1085;
        }
        if ((str1.equals(localATroopMember.jdField_k_of_type_JavaLangString)) || (str1.equals(localATroopMember.jdField_m_of_type_JavaLangString)) || (str1.equals(localATroopMember.jdField_l_of_type_JavaLangString)))
        {
          localATroopMember.f = localATroopMember.jdField_k_of_type_JavaLangString;
          localArrayList1.add(localATroopMember);
          continue;
        }
        if (str2.equals(localATroopMember.h)) {
          break label388;
        }
      }
      finally {}
      if ((str2.equals(localATroopMember.jdField_j_of_type_JavaLangString)) || (str2.equals(localATroopMember.i)))
      {
        label388:
        localATroopMember.f = localATroopMember.h;
        localArrayList1.add(localATroopMember);
      }
      else if (str2.equals(localATroopMember.jdField_a_of_type_JavaLangString))
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList1.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_n_of_type_JavaLangString.indexOf(str2) == 0) || (localATroopMember.jdField_p_of_type_JavaLangString.indexOf(str2) == 0) || (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.jdField_n_of_type_JavaLangString;
        localATroopMember.g = localATroopMember.jdField_o_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_k_of_type_JavaLangString.indexOf(str2) == 0) || (localATroopMember.jdField_m_of_type_JavaLangString.indexOf(str2) == 0) || (localATroopMember.jdField_l_of_type_JavaLangString.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.jdField_k_of_type_JavaLangString;
        localATroopMember.g = localATroopMember.jdField_l_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.h.indexOf(str2) == 0) || (localATroopMember.jdField_j_of_type_JavaLangString.indexOf(str2) == 0) || (localATroopMember.i.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.h;
        localATroopMember.g = localATroopMember.i;
        localArrayList2.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) == 0)
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localATroopMember.g = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_n_of_type_JavaLangString.indexOf(str2) > 0) || (localATroopMember.jdField_p_of_type_JavaLangString.indexOf(str2) > 0) || (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.jdField_n_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_k_of_type_JavaLangString.indexOf(str2) > 0) || (localATroopMember.jdField_m_of_type_JavaLangString.indexOf(str2) > 0) || (localATroopMember.jdField_l_of_type_JavaLangString.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.jdField_k_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.h.indexOf(str2) > 0) || (localATroopMember.jdField_j_of_type_JavaLangString.indexOf(str2) > 0) || (localATroopMember.i.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.h;
        localArrayList3.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) > 0)
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
        continue;
        label908:
        Collections.sort(localArrayList2, new TroopMemberListActivity.SearchResultComparator(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + str2 + "," + (l2 - l1) + "," + this.jdField_b_of_type_JavaUtilList.size() + "," + this.jdField_a_of_type_JavaUtilList.size());
          return;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        label1085:
        i1 += 1;
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_J_of_type_Int == 2) || (this.jdField_J_of_type_Int == 3) || (this.jdField_J_of_type_Int == 11) || (this.jdField_J_of_type_Int == 0) || (this.jdField_J_of_type_Int == 5) || (this.jdField_J_of_type_Int == 6) || (this.jdField_J_of_type_Int == 9)) {
      if ((this.jdField_J_of_type_Int == 9) && (this.K == 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mvv(this));
      if ((this.jdField_J_of_type_Int == 0) || (this.jdField_J_of_type_Int == 6) || (this.jdField_J_of_type_Int == 9))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new mvw(this));
        return;
      }
    } while (this.jdField_J_of_type_Int != 7);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void d(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903052);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_J_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(getString(2131368268));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_j_of_type_JavaLangString), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString.toString());
      }
      bool = false;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    Object localObject2 = (TroopManager)this.app.getManager(51);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      return;
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      ThreadManager.a(new mub(this, paramIntent, (FriendsManager)localObject1, (TroopManager)localObject2), 8, null, true);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_k_of_type_JavaLangString);
      if (this.jdField_J_of_type_Int == 6) {}
      for (long l1 = 1L; (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (l1 != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode) && (this.h); l1 = 0L)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode, false);
        return;
      }
      continue;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          localObject1 = ContactUtils.a(this.app, getApplicationContext(), paramIntent);
          localObject2 = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", paramIntent);
          ((Intent)localObject2).putExtra("uintype", 3000);
          ((Intent)localObject2).putExtra("uinname", (String)localObject1);
          ((Intent)localObject2).putExtra("isBack2Root", true);
          ((Intent)localObject2).setFlags(67108864);
          startActivity((Intent)localObject2);
          finish();
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
          if (!TextUtils.isEmpty(this.L))
          {
            ThreadManager.a(new muo(this, (FriendsManager)localObject1), 8, null, true);
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_k_of_type_JavaLangString);
            if (this.jdField_J_of_type_Int == 6) {}
            for (l1 = 1L; (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (l1 != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode) && (this.h); l1 = 0L)
            {
              a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode, false);
              return;
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_J_of_type_Int == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    Object localObject1 = getIntent().getExtras();
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject1).getString("troop_uin");
    this.jdField_l_of_type_JavaLangString = ((Bundle)localObject1).getString("troop_info_name");
    this.jdField_m_of_type_JavaLangString = ((Bundle)localObject1).getString("troop_gift_from");
    this.q = ((Bundle)localObject1).getString("leftViewText");
    this.jdField_k_of_type_Boolean = ((Bundle)localObject1).getBoolean("param_is_pop_up_style", false);
    this.jdField_J_of_type_Int = ((Bundle)localObject1).getInt("param_from", 0);
    this.A = ((Bundle)localObject1).getString("param_troop_fee_project_id");
    this.K = ((Bundle)localObject1).getInt("param_troop_fee_entrance_type", -1);
    this.H = ((Bundle)localObject1).getString("callback");
    this.jdField_o_of_type_Boolean = ((Bundle)localObject1).getBoolean("param_troop_send_apollo_msg", false);
    this.aj = ((Bundle)localObject1).getInt("TROOP_INFO_MEMBER_NUM", 0);
    if ((this.jdField_J_of_type_Int == 9) && (TextUtils.isEmpty(this.A)) && (QLog.isColorLevel())) {
      QLog.e("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    this.jdField_p_of_type_Int = ((Bundle)localObject1).getInt("param_chat_mode", 0);
    this.jdField_f_of_type_Boolean = ((Bundle)localObject1).getBoolean("Show_Newer_GuideFlag_Of_ContactsMode", false);
    this.B = ((Bundle)localObject1).getString("custom_title_name");
    localObject1 = ((Bundle)localObject1).getString("param_from");
    if (localObject1 != null) {}
    try
    {
      this.jdField_J_of_type_Int = Integer.parseInt((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, troopCode=" + this.jdField_k_of_type_JavaLangString + " troopUin=" + this.jdField_j_of_type_JavaLangString + " from=" + this.jdField_J_of_type_Int);
      }
      if (this.jdField_k_of_type_Boolean) {
        setTheme(2131559171);
      }
      super.doOnCreate(paramBundle);
      setContentView(2130905077);
      b();
      if (this.aj == 0)
      {
        paramBundle = ((TroopManager)this.app.getManager(51)).a(this.jdField_k_of_type_JavaLangString);
        if (paramBundle != null) {
          this.aj = paramBundle.wMemberNum;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
      this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      paramBundle = (TroopManager)this.app.getManager(51);
      localObject1 = (DiscussionManager)this.app.getManager(52);
      if ((paramBundle != null) && (localObject1 != null)) {
        if ((this.jdField_J_of_type_Int == 1) || (this.jdField_J_of_type_Int == 11))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionManager)localObject1).a(this.jdField_k_of_type_JavaLangString);
          this.jdField_j_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
          this.h = TroopUtils.a(Long.toString(this.jdField_b_of_type_Long));
          if ((this.h) && (this.jdField_a_of_type_Long == 1L) && (this.jdField_J_of_type_Int == 0))
          {
            this.N = 0;
            this.jdField_J_of_type_Int = 6;
            this.jdField_j_of_type_Boolean = false;
            ReportController.b(this.app, "CliOper", "", "", "0X80054B0", "0X80054B0", 0, 0, "", "", "", "");
          }
          if ((this.jdField_J_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.a()))) {
            break label727;
          }
          finish();
          return false;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.jdField_k_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_k_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getCurrentAccountUin());
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode;
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
        this.jdField_n_of_type_Boolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 32);
      }
      finish();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
    label727:
    label766:
    boolean bool;
    label828:
    Object localObject2;
    label926:
    String str;
    if ((this.jdField_J_of_type_Int == 1) || (this.jdField_J_of_type_Int == 11))
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.jdField_J_of_type_Int != 7) {
        break label1015;
      }
      this.W = 3;
      if (this.jdField_J_of_type_Int == 1) {
        break label1236;
      }
      if (this.jdField_J_of_type_Int != 11) {
        break label1044;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.jdField_n_of_type_JavaLangString == null) || (!this.jdField_n_of_type_JavaLangString.equals(this.app.a()))) {
          break label1038;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      c();
      e();
      f();
      a();
      localObject2 = "4";
      paramBundle = (Bundle)localObject2;
      switch (this.jdField_J_of_type_Int)
      {
      default: 
        paramBundle = (Bundle)localObject2;
      case 1: 
        str = "2";
        if ((this.jdField_n_of_type_JavaLangString != null) && (this.jdField_n_of_type_JavaLangString.equals(this.app.a()))) {
          localObject2 = "0";
        }
        break;
      }
    }
    for (;;)
    {
      this.F = ((String)localObject2);
      a("exp", paramBundle, (String)localObject2);
      if (this.jdField_J_of_type_Int != 6) {
        a(0);
      }
      if (this.jdField_J_of_type_Int == 8) {
        n();
      }
      return true;
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
      break;
      label1015:
      if ((!this.jdField_o_of_type_Boolean) || (this.jdField_J_of_type_Int != 3)) {
        break label766;
      }
      this.W = 1;
      break label766;
      label1038:
      bool = false;
      break label828;
      label1044:
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.jdField_o_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.app.a()))) || ((this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.contains(this.app.a()))))
        {
          bool = true;
          label1155:
          this.jdField_a_of_type_Boolean = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_o_of_type_JavaLangString + "  owner:" + this.jdField_n_of_type_JavaLangString);
        break;
        bool = false;
        break label1155;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1236:
      this.jdField_b_of_type_Boolean = true;
      this.I = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
        this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
      }
      for (;;)
      {
        if ((this.jdField_n_of_type_JavaLangString != null) && (this.jdField_n_of_type_JavaLangString.equals(this.app.a()))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo owner: " + this.jdField_n_of_type_JavaLangString);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo==null");
        }
      }
      paramBundle = "0";
      break label926;
      paramBundle = "1";
      break label926;
      paramBundle = "2";
      break label926;
      paramBundle = "3";
      break label926;
      localObject2 = str;
      if (this.jdField_o_of_type_JavaLangString != null)
      {
        localObject2 = str;
        if (this.jdField_o_of_type_JavaLangString.contains(this.app.a())) {
          localObject2 = "1";
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    this.g = true;
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      try
      {
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.b();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.b();
        }
        if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_b_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(48);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
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
    View localView = getLayoutInflater().inflate(2130905080, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131298720));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)localView.findViewById(2131305222));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131305223));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297466);
    this.Q = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
    int i1;
    if ((this.jdField_J_of_type_Int == 3) && (this.jdField_a_of_type_Boolean) && (this.jdField_p_of_type_Int != 1))
    {
      i1 = 1;
      if ((this.jdField_J_of_type_Int != 11) || (!this.jdField_a_of_type_Boolean)) {
        break label725;
      }
    }
    Object localObject;
    label725:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 != 0) || (i2 != 0))
      {
        localObject = getString(2131367365);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305224);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298136)).setBackgroundDrawable(ImageUtil.c());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305225);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new mvx(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new muc(this, (String)localObject));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (TroopHandler)this.app.a(20);
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label731;
        }
        QQToast.a(this, 2131367481, 0).b(getTitleBarHeight());
      }
      if (this.jdField_J_of_type_Int == 6) {
        b(1L);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, "tab0");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, "tab1");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new mud(this));
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300876)).setVisibility(8);
      if (this.jdField_J_of_type_Int != 9) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
      if (this.jdField_J_of_type_Int != 9) {
        o();
      }
      ((EditText)localObject).setOnTouchListener(new mue(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_J_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      i1 = 0;
      break;
    }
    label731:
    if ((this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler != null) && (this.jdField_J_of_type_Int == 11)) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.app.a(), this.jdField_j_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838325);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_c_of_type_AndroidGraphicsDrawableDrawable).start();
      break;
      if (localObject != null) {
        ((TroopHandler)localObject).a(this.app.a(), this.jdField_k_of_type_JavaLangString);
      }
    }
  }
  
  protected void e(String paramString)
  {
    Intent localIntent = new Intent(this, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_k_of_type_JavaLangString);
    localIntent.putExtra("memberUin", paramString);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", getString(2131367347));
    if ((this.B != null) && (!TextUtils.isEmpty(this.B))) {
      localIntent.putExtra("custom_leftbackbutton_name", getString(2131367975));
    }
    this.L = paramString;
    startActivityForResult(localIntent, 1);
    a("Clk_item", this.F, "");
  }
  
  protected void f()
  {
    q();
    if (this.jdField_J_of_type_Int == 9) {
      ThreadManager.a(new mui(this), 8, null, true);
    }
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      long l1;
      long l2;
      if ((this.jdField_J_of_type_Int != 1) && (this.jdField_J_of_type_Int != 11))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13));
        localObject1 = null;
        if ((this.jdField_J_of_type_Int != 11) && (this.jdField_J_of_type_Int != 1) && (NetworkUtil.h(this)))
        {
          localObject2 = getSharedPreferences("last_update_time" + this.app.a(), 0);
          l1 = ((SharedPreferences)localObject2).getLong("key_last_update_time" + this.jdField_k_of_type_JavaLangString, 0L);
          l2 = Math.abs(System.currentTimeMillis() - l1);
          int i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            i1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum;
          }
          int i2 = ((SharedPreferences)localObject2).getInt("key_last_update_num" + this.jdField_k_of_type_JavaLangString, 0);
          ((SharedPreferences)localObject2).edit().putInt("key_last_update_num" + this.jdField_k_of_type_JavaLangString, i1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i1 + " lastUpdateMemberNum:" + i2);
          }
          localObject2 = (TroopHandler)this.app.a(20);
          if (localObject2 != null)
          {
            if (this.jdField_J_of_type_Int == 6) {
              this.i = true;
            }
            this.jdField_d_of_type_Boolean = true;
            this.jdField_c_of_type_Long = System.currentTimeMillis();
            ((TroopHandler)localObject2).a(true, this.jdField_k_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, true, a());
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_j_of_type_JavaLangString + " troopCode: " + this.jdField_k_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((TroopHandler)localObject2).a(Long.parseLong(this.jdField_k_of_type_JavaLangString), 0L, 1, null, 0, 0);
        if (this.jdField_J_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.a(), 0).getLong("key_troop_info_last_update" + this.jdField_k_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (TroopHandler)this.app.a(20);
            if (localObject2 != null)
            {
              this.jdField_d_of_type_Long = System.currentTimeMillis();
              ((TroopHandler)localObject2).a(this.jdField_k_of_type_JavaLangString, (byte)0, 0L, 0);
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, getGroupInfoReq, mTroopUin:" + this.jdField_k_of_type_JavaLangString);
              }
            }
          }
        }
        if (localObject1 == null) {
          continue;
        }
        ThreadManager.a((Runnable)localObject1, 8, null, true);
        return;
        localObject1 = new muj(this);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
          }
        }
      }
    }
  }
  
  /* Error */
  protected void f(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +29 -> 37
    //   11: ldc 49
    //   13: iconst_2
    //   14: new 448	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 2358
    //   24: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: invokestatic 1666	java/lang/System:currentTimeMillis	()J
    //   40: lstore 6
    //   42: aload_0
    //   43: getfield 469	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 1715	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   49: invokevirtual 1721	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: astore_2
    //   53: aload_2
    //   54: ldc_w 1130
    //   57: iconst_0
    //   58: ldc_w 1771
    //   61: iconst_1
    //   62: anewarray 493	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 1728	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 1772	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   81: invokestatic 1666	java/lang/System:currentTimeMillis	()J
    //   84: lstore 8
    //   86: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +33 -> 122
    //   92: ldc 49
    //   94: iconst_2
    //   95: new 448	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 2360
    //   105: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: lload 8
    //   110: lload 6
    //   112: lsub
    //   113: invokevirtual 1678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_1
    //   123: ifnull +221 -> 344
    //   126: aload_1
    //   127: invokeinterface 403 1 0
    //   132: istore 5
    //   134: aload_0
    //   135: getfield 232	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: astore_2
    //   139: aload_2
    //   140: monitorenter
    //   141: iload 4
    //   143: iload 5
    //   145: if_icmpge +35 -> 180
    //   148: aload_1
    //   149: iload 4
    //   151: invokeinterface 481 2 0
    //   156: checkcast 1130	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   159: astore_3
    //   160: aload_3
    //   161: ifnull +189 -> 350
    //   164: aload_0
    //   165: getfield 232	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   168: aload_3
    //   169: getfield 2361	com/tencent/mobileqq/data/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   172: aload_3
    //   173: invokevirtual 2364	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: goto +173 -> 350
    //   180: aload_2
    //   181: monitorexit
    //   182: iload 5
    //   184: istore 4
    //   186: invokestatic 1666	java/lang/System:currentTimeMillis	()J
    //   189: lstore 8
    //   191: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +59 -> 253
    //   197: ldc 49
    //   199: iconst_2
    //   200: new 448	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 2366
    //   210: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: lload 8
    //   215: lload 6
    //   217: lsub
    //   218: invokevirtual 1678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc_w 1706
    //   224: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokeinterface 403 1 0
    //   233: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc_w 1708
    //   239: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload 4
    //   244: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: monitorexit
    //   255: return
    //   256: astore_1
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq -12 -> 253
    //   268: ldc 49
    //   270: iconst_2
    //   271: new 448	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 2368
    //   281: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: invokevirtual 1599	java/lang/Exception:toString	()Ljava/lang/String;
    //   288: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: goto -44 -> 253
    //   300: astore_1
    //   301: aload_0
    //   302: monitorexit
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -56 -> 253
    //   312: ldc 49
    //   314: iconst_2
    //   315: new 448	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 2368
    //   325: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: invokevirtual 1695	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   332: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 462	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -88 -> 253
    //   344: iconst_0
    //   345: istore 4
    //   347: goto -161 -> 186
    //   350: iload 4
    //   352: iconst_1
    //   353: iadd
    //   354: istore 4
    //   356: goto -215 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	TroopMemberListActivity
    //   0	359	1	paramString	String
    //   52	206	2	localObject	Object
    //   159	14	3	localTroopMemberCardInfo	TroopMemberCardInfo
    //   1	354	4	i1	int
    //   132	51	5	i2	int
    //   40	176	6	l1	long
    //   84	130	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   148	160	256	finally
    //   164	177	256	finally
    //   180	182	256	finally
    //   257	259	256	finally
    //   5	37	261	java/lang/Exception
    //   37	122	261	java/lang/Exception
    //   126	141	261	java/lang/Exception
    //   186	253	261	java/lang/Exception
    //   259	261	261	java/lang/Exception
    //   5	37	300	finally
    //   37	122	300	finally
    //   126	141	300	finally
    //   186	253	300	finally
    //   259	261	300	finally
    //   262	297	300	finally
    //   306	341	300	finally
    //   5	37	305	java/lang/OutOfMemoryError
    //   37	122	305	java/lang/OutOfMemoryError
    //   126	141	305	java/lang/OutOfMemoryError
    //   186	253	305	java/lang/OutOfMemoryError
    //   259	261	305	java/lang/OutOfMemoryError
  }
  
  public void finish()
  {
    if ((this.jdField_J_of_type_Int == 9) && ((this.jdField_l_of_type_Boolean) || (this.jdField_G_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
      localIntent.putExtra("callback", this.H);
      setResult(-1, localIntent);
    }
    super.finish();
    if (this.jdField_k_of_type_Boolean) {
      overridePendingTransition(0, 2130968584);
    }
    if ((this.jdField_J_of_type_Int == 8) || (this.jdField_J_of_type_Int == 12)) {
      overridePendingTransition(0, 2130968593);
    }
  }
  
  public void g()
  {
    boolean bool = TroopMemberLbsHelper.a(this.jdField_k_of_type_JavaLangString, this.app).booleanValue();
    String[] arrayOfString;
    int i1;
    label62:
    int i2;
    if (this.jdField_J_of_type_Int == 6)
    {
      arrayOfString = getResources().getStringArray(2131230776);
      if ((this.jdField_J_of_type_Int != 0) && (this.jdField_J_of_type_Int != 6)) {
        break label199;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      i2 = 0;
      label72:
      if (i2 >= i1) {
        break label355;
      }
      if ((i2 != 9) || (this.jdField_J_of_type_Int == 6)) {
        break label222;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[i2], 3);
    }
    for (;;)
    {
      i2 += 1;
      break label72;
      if (this.jdField_J_of_type_Int == 9)
      {
        arrayOfString = getResources().getStringArray(2131230779);
        break;
      }
      arrayOfString = getResources().getStringArray(2131230775);
      break;
      label147:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption != 3)
        {
          i1 = arrayOfString.length - 2;
          break label62;
        }
        i1 = arrayOfString.length - 3;
        break label62;
      }
      i1 = arrayOfString.length - 3;
      break label62;
      label199:
      if (this.jdField_J_of_type_Int == 9)
      {
        i1 = arrayOfString.length;
        break label62;
      }
      i1 = arrayOfString.length - 5;
      break label62;
      label222:
      if ((i2 == 6) && (this.jdField_J_of_type_Int == 6)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[i2], 3);
      } else if (((bool) || (i2 != 3) || (this.jdField_J_of_type_Int == 6)) && ((this.h) || (((i2 != 8) || (this.jdField_J_of_type_Int == 6)) && ((i2 != 5) || (this.jdField_J_of_type_Int != 6)))) && ((this.jdField_n_of_type_Boolean) || (((i2 != 6) || (this.jdField_J_of_type_Int == 6)) && ((i2 != 2) || (this.jdField_J_of_type_Int != 6))))) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(arrayOfString[i2]);
      }
    }
    label355:
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    a(this.jdField_a_of_type_ComTencentWidgetActionSheet, arrayOfString);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "checkShowCharIndexView, mItemCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int + " mCharSegmentCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int);
    }
    if (this.W == 0)
    {
      if (this.jdField_J_of_type_Int == 11)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int > 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int > 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void i()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903052);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_J_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(getString(2131368647));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_J_of_type_Int == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new mun(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new mup(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131300876);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new muq(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void k()
  {
    if ((this.jdField_e_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    String str = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_k_of_type_JavaLangString;
    localIntent.putExtra("url", str);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "showMemberDstribute:" + str);
    }
    a("Clk_mberdist", this.F, "");
  }
  
  public void m()
  {
    ThreadManager.a(new mvj(this), 8, null, true);
    a("Clk_invite", this.F, "");
  }
  
  void n()
  {
    if (!this.jdField_n_of_type_Boolean)
    {
      ViewStub localViewStub = (ViewStub)findViewById(2131305209);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131305244)).setOnTouchListener(new mvm(this));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
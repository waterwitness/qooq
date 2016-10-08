package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import cooperation.huangye.C2BUtils;
import cooperation.qqfav.QfavUtil;
import hld;
import hle;
import hlf;
import hlh;
import hli;
import hlj;
import hlk;
import hlm;
import hln;
import hlo;
import hlp;
import hlq;
import hlr;
import hls;
import hlt;
import hlu;
import hlv;
import hlw;
import hly;
import hlz;
import hma;
import hmb;
import hmd;
import hme;
import hmf;
import hmg;
import hmh;
import hmi;
import hmj;
import hmk;
import hml;
import hmm;
import hmn;
import hmo;
import hmp;
import hmq;
import hmr;
import hms;
import hmt;
import hmu;
import hmv;
import hmw;
import hmx;
import hmy;
import hmz;
import hna;
import hnb;
import hnc;
import hnd;
import hne;
import hnn;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static final int A = 2;
  public static final int C = 1;
  public static final int D = 2;
  static int M = 0;
  public static int N = -1;
  public static int O = 1;
  public static double a = 0.0D;
  public static final int a = 1;
  static double jdField_b_of_type_Double = 0.0D;
  public static final int b = 2;
  static final String jdField_b_of_type_JavaLangString = "0X8005B6D";
  public static final int c = 3;
  static final String jdField_c_of_type_JavaLangString = "0X8005B6E";
  public static final int d = 4;
  public static final String d = "com.tencent.biz.pubaccount.AccountDetailActivity";
  public static final int e = 5;
  public static final String e = "AccountDetailActivity.bindTroop";
  public static final int f = 104;
  public static final String f = "source";
  public static final int g = 105;
  public static final String g = "fromBrowser";
  public static final int h = 106;
  public static final String h = "from_card";
  public static final int i = 108;
  public static final String i = "report_src_param_type";
  public static final int j = 109;
  public static final String j = "report_src_param_name";
  public static final int k = 111;
  public static final int l = 112;
  public static final int m = 113;
  public static final String m = "find.mp.qq.com";
  public static final int n = 114;
  public static final String n = "post.mp.qq.com";
  protected static final int o = 1;
  public static final String o = "article.mp.qq.com";
  protected static final int p = 0;
  protected static final int q = 1;
  public static final String q = "account_type";
  protected static final int r = 2;
  protected static final int s = 3;
  protected static final int t = 4;
  protected static final int u = 5;
  protected static final String u = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=";
  static int v = 0;
  protected static final String v = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=";
  protected static final int w = 1;
  protected static final String w = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=";
  protected static final int x = 2;
  static final int y = 3;
  static final int jdField_z_of_type_Int = 3;
  public int B = 1008;
  public int E;
  public int F = 0;
  public int G = 0;
  public int H = 0;
  public int I = 0;
  int J = 0;
  public int K;
  int L = 0;
  public int P = M;
  protected int Q = -1;
  protected float a;
  public Intent a;
  public Drawable a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public Button a;
  public ImageView a;
  protected LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  public AccountDetailXListView a;
  public AccountDetailActivity.AccountDetailAdapter a;
  AccountDetailActivity.FriendAvatarWeakReference jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$FriendAvatarWeakReference;
  protected PaConfigAttr.PaConfigInfo a;
  PhotoWallViewForAccountDetail.PhotoWallCallback jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback = new hmv(this);
  public ProfileParams a;
  ShareActionSheet jdField_a_of_type_ComTencentBizTroopbarShareActionSheet;
  ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog;
  protected FriendListObserver a;
  public PublicAccountHandler a;
  final PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new hld(this);
  public QQAppInterface a;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  hnn jdField_a_of_type_Hnn;
  public ArrayList a;
  protected NewIntent a;
  protected BusinessObserver a;
  boolean jdField_a_of_type_Boolean = false;
  public View b;
  public Button b;
  protected ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ActionSheet b;
  protected NewIntent b;
  protected BusinessObserver b;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  Button jdField_c_of_type_AndroidWidgetButton;
  protected ImageView c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public ActionSheet c;
  NewIntent jdField_c_of_type_MqqAppNewIntent;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  protected Button d;
  public ImageView d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  NewIntent jdField_d_of_type_MqqAppNewIntent;
  BusinessObserver jdField_d_of_type_MqqObserverBusinessObserver;
  boolean jdField_d_of_type_Boolean = true;
  protected View e;
  public ImageView e;
  protected TextView e;
  NewIntent jdField_e_of_type_MqqAppNewIntent;
  BusinessObserver jdField_e_of_type_MqqObserverBusinessObserver;
  protected boolean e;
  protected View f;
  ImageView f;
  public boolean f;
  protected View g;
  ImageView g;
  public boolean g;
  private View h;
  public boolean h;
  public boolean i;
  public boolean j = false;
  public String k;
  public boolean k;
  public String l;
  public boolean l;
  public boolean m = true;
  public boolean n;
  boolean o = false;
  public String p;
  public boolean p;
  boolean q = true;
  public String r;
  public boolean r;
  protected String s;
  public boolean s;
  protected String t;
  public boolean t;
  boolean u = false;
  public boolean v;
  boolean w = false;
  public boolean x;
  public boolean y;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_v_of_type_Int = 100;
    jdField_a_of_type_Double = 0.4D;
    jdField_b_of_type_Double = 0.4D;
  }
  
  public AccountDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_c_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new hma(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo = new PaConfigAttr.PaConfigInfo();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new hna(this);
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i1 = paramString.indexOf("article_id=");
        if (i1 > 0)
        {
          String str = paramString.substring(i1 + 11);
          i1 = str.indexOf("&");
          paramString = str;
          if (i1 >= 0) {
            paramString = str.substring(0, i1);
          }
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("source"))) {
      return;
    }
    switch (paramIntent.getIntExtra("source", 0))
    {
    default: 
      return;
    case 1: 
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "");
      return;
    case 2: 
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "");
      return;
    case 3: 
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "");
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    Object localObject = GroupSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      l1 = ((structmsg.StructMsg)localObject).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject).req_uin.get();
      int i2 = ((structmsg.StructMsg)localObject).msg.sub_type.get();
      int i3 = ((structmsg.StructMsg)localObject).msg.src_id.get();
      int i4 = ((structmsg.StructMsg)localObject).msg.sub_src_id.get();
      int i5 = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
      localObject = ((structmsg.StructMsg)localObject).msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramPaConfigInfo.jdField_a_of_type_Int == 3) && ((paramPaConfigInfo.jdField_c_of_type_Int == 3) || (paramPaConfigInfo.jdField_c_of_type_Int == 16) || (paramPaConfigInfo.jdField_c_of_type_Int == 21) || (paramPaConfigInfo.jdField_c_of_type_Int == 13))) {}
    while ((paramPaConfigInfo.jdField_e_of_type_Int == 5) || ((paramPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1))) {
      return true;
    }
    return false;
  }
  
  protected static boolean a(AccountDetail paramAccountDetail)
  {
    boolean bool2 = true;
    if (paramAccountDetail == null) {
      return false;
    }
    int i1 = PublicAccountUtil.a(paramAccountDetail.accountFlag);
    boolean bool1 = bool2;
    if (i1 != -2)
    {
      bool1 = bool2;
      if (i1 != -3)
      {
        if (i1 != -4) {
          break label42;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      label42:
      bool1 = bool2;
      if (PublicAccountUtil.a(paramAccountDetail.accountFlag2) != -8L) {
        bool1 = false;
      }
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    View localView = new View(this);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(0.7D * this.jdField_a_of_type_Float)));
    localView.setBackgroundColor(Color.parseColor("#dedfe0"));
    paramViewGroup.addView(localView);
  }
  
  private boolean j()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  public void A()
  {
    ThreadManager.b().postDelayed(new hlk(this), 10L);
  }
  
  public void B()
  {
    this.jdField_c_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    String str = getString(2131364479, new Object[] { a() });
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(str);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(2131364502, 3);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new hlr(this));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new hls(this));
    if (!this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_s_of_type_Boolean = false;
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void C()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
    if ((i1 > 8) && (i1 < 13)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
  }
  
  void D()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor)) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg));
    }
    try
    {
      for (;;)
      {
        int i1 = Color.parseColor("#E6" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6));
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(i1));
        return;
        ThreadManager.b().postDelayed(new hlw(this), 10L);
      }
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    }
  }
  
  protected void E()
  {
    this.G = getWindowManager().getDefaultDisplay().getHeight();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    if (c()) {
      return;
    }
    if (FontSettingManager.a() == 20.0F)
    {
      jdField_v_of_type_Int = 80;
      if (Build.BOARD.equals("mx")) {
        jdField_v_of_type_Int = 64;
      }
      jdField_b_of_type_Double = 0.32D;
    }
    for (;;)
    {
      localLayoutParams1.height = ((int)(this.G * jdField_a_of_type_Double));
      localLayoutParams2.height = ((int)(jdField_v_of_type_Int * this.jdField_a_of_type_Float));
      localLayoutParams2.width = ((int)(jdField_v_of_type_Int * this.jdField_a_of_type_Float));
      localLayoutParams2.topMargin = ((int)(localLayoutParams1.height * jdField_b_of_type_Double - jdField_v_of_type_Int * this.jdField_a_of_type_Float / 2.0F));
      localLayoutParams3.height = ((int)((jdField_v_of_type_Int + 8) * this.jdField_a_of_type_Float));
      localLayoutParams3.width = localLayoutParams3.height;
      localLayoutParams3.topMargin = ((int)(localLayoutParams2.topMargin - 4.0F * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
      this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams3);
      return;
      if (FontSettingManager.a() == 18.0F)
      {
        jdField_v_of_type_Int = 88;
        if (Build.BOARD.equals("mx")) {
          jdField_v_of_type_Int = 71;
        }
        jdField_b_of_type_Double = 0.36D;
      }
      else if (FontSettingManager.a() == 17.0F)
      {
        jdField_v_of_type_Int = 94;
        jdField_b_of_type_Double = 0.38D;
        if (Build.BOARD.equals("mx")) {
          jdField_v_of_type_Int = 75;
        }
      }
      else
      {
        jdField_v_of_type_Int = 100;
        jdField_b_of_type_Double = 0.4D;
        if (Build.BOARD.equals("mx")) {
          jdField_v_of_type_Int = 80;
        }
      }
    }
  }
  
  public void F()
  {
    if (d())
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  void G()
  {
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void H()
  {
    if (d())
    {
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.jdField_d_of_type_AndroidWidgetButton.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 8)) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  void I()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void J()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "firstFetch");
    }
    c();
    i();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.postDelayed(new hlz(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "firstFetch exit");
    }
  }
  
  void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_p_of_type_JavaLangString));
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new hme(this);
        this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        this.E += 1;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void M()
  {
    if ((TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet == null) {
      this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet = new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), b(), b());
    }
    this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet.a();
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_p_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  void N()
  {
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    P();
    O();
  }
  
  protected void O()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    View localView = getLayoutInflater().inflate(2130903460, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131298678)).setText(str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  protected void P()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = getLayoutInflater().inflate(2130903460, null);
    ((TextView)localView.findViewById(2131298678)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131296821)).setVisibility(8);
    ((TextView)localView.findViewById(2131297123)).setText(2131364504);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  protected void Q()
  {
    if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
    }
    do
    {
      return;
      if (NetworkUtil.i(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$FriendAvatarWeakReference = new AccountDetailActivity.FriendAvatarWeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$FriendAvatarWeakReference.a();
  }
  
  public void R()
  {
    if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace uin is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace again");
    }
    Drawable localDrawable = a();
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
  }
  
  public void S()
  {
    if (!i()) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.parseLong(this.jdField_p_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailActivity.bindTroop", 2, "getBindedTroops:" + l1);
        }
        if (l1 == -1L) {
          continue;
        }
        oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
        localReqBody.uint32_channel.set(1);
        localReqBody.uint64_subscribe_code.set(l1);
        ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new hmx(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = -1L;
        }
      }
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade;
    }
    return 0;
  }
  
  Bitmap a(Bitmap paramBitmap)
  {
    int i3 = 0;
    int i4 = getWindowManager().getDefaultDisplay().getWidth();
    int i5 = (int)(getWindowManager().getDefaultDisplay().getHeight() * jdField_a_of_type_Double);
    int i1 = paramBitmap.getHeight();
    int i2 = paramBitmap.getWidth();
    if (i2 * i5 > i1 * i4)
    {
      i5 = i4 * i1 / i5;
      i4 = (i2 - i5) / 2;
      i2 = i5;
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, i4, i3, i2, i1);
      i4 = i5 * i2 / i4;
      i3 = (i1 - i4) / 2;
      i1 = i4;
      i4 = 0;
    }
  }
  
  Drawable a()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    FaceDrawable localFaceDrawable;
    do
    {
      return (Drawable)localObject;
      localObject = new File(ProfileCardUtil.a(this.jdField_p_of_type_JavaLangString));
      if (((File)localObject).isFile())
      {
        f(((File)localObject).getAbsolutePath());
        return FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_p_of_type_JavaLangString);
      }
      localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_p_of_type_JavaLangString);
      localObject = localFaceDrawable;
    } while (this.jdField_a_of_type_Hnn != null);
    this.jdField_a_of_type_Hnn = new hnn(this);
    addObserver(this.jdField_a_of_type_Hnn);
    return localFaceDrawable;
  }
  
  public Drawable a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      paramBitmap = a(paramBitmap);
      StackBlur.a(paramBitmap, 1);
      paramBitmap = new BitmapDrawable(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  protected View a()
  {
    return super.getLayoutInflater().inflate(2130903284, null);
  }
  
  protected View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmq(this, paramInt, paramPaConfigInfo));
    return localView;
  }
  
  protected ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  protected ShareActionSheet.Detail a()
  {
    ShareActionSheet.Detail localDetail = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localDetail = new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localDetail;
  }
  
  protected String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    }
    return str;
  }
  
  String a(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    do
    {
      return paramIntent;
      paramIntent = (Intent)localObject;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null);
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a().jdField_b_of_type_JavaLangString;
  }
  
  protected List a(List paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)paramList.get(i1);
      if ((localPaConfigInfo.jdField_a_of_type_Int == 3) && ((localPaConfigInfo.jdField_c_of_type_Int == 7) || (localPaConfigInfo.jdField_c_of_type_Int == 8))) {
        localArrayList.add(localPaConfigInfo);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public JSONObject a(BaseActivity paramBaseActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramBaseActivity.app.a().a(paramString, 0, new int[] { 64536, 63536, 63534, 63525, 63514 }, 40);
        paramBaseActivity = new ArrayList();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          if (i1 > 0)
          {
            if (((MessageRecord)((List)localObject1).get(i1 - 1)).issend != 0) {
              break label720;
            }
            paramBaseActivity.add(((List)localObject1).get(i1 - 1));
            if (paramBaseActivity.size() <= 4) {
              break label720;
            }
          }
        }
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localJSONObject2.put("qq", localObject2);
        Object localObject3 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        String str = String.valueOf(NetConnInfoCenter.getServerTime());
        localJSONObject2.put("skey", localObject3);
        localJSONObject2.put("mpUin", paramString);
        localJSONObject2.put("timestamp", "" + str);
        localJSONObject2.put("scene", "201");
        localJSONObject2.put("subAppname", "profile");
        localJSONObject2.put("sign", MD5Utils.b((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
        if (paramBaseActivity != null)
        {
          int i2 = 0;
          if (i2 < paramBaseActivity.size())
          {
            paramString = new JSONObject();
            localObject2 = new JSONObject();
            localObject3 = (MessageRecord)paramBaseActivity.get(i2);
            if ((localObject3 instanceof MessageForText))
            {
              ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
              i1 = 1;
              paramString.put("content", localObject2);
              paramString.put("messageType", "" + i1);
              localJSONArray.put(i2, paramString);
              i2 += 1;
              continue;
            }
            if ((localObject3 instanceof MessageForPic))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
              i1 = 2;
              continue;
            }
            if ((localObject3 instanceof MessageForPtt))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
              ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
              i1 = 3;
              continue;
            }
            if ((localObject3 instanceof MessageForShortVideo))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
              i1 = 4;
              continue;
            }
            if ((localObject3 instanceof MessageForStructing))
            {
              ((JSONObject)localObject2).put("text", new String(StructMsgUtils.a(QfavUtil.a(((AbsShareMsg)StructMsgFactory.a(((MessageRecord)localObject3).msgData)).getXmlBytes()), 0), "utf-8"));
              i1 = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", Base64Util.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
          }
        }
        else
        {
          localJSONObject1.put("Verify", localJSONObject2);
          localJSONObject1.put("reportData", localObject1);
          return localJSONObject1;
        }
      }
      catch (Exception paramBaseActivity)
      {
        return null;
      }
      int i1 = 0;
      continue;
      label720:
      i1 -= 1;
    }
  }
  
  protected void a()
  {
    int i1 = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.paConfigAttrs;
      if (localList == null) {
        localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList);
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        int i2 = localList.size();
        boolean bool = false;
        while (i1 < i2)
        {
          bool = a((PaConfigAttr)localList.get(i1), i1, i2, true, bool);
          i1 += 1;
        }
      }
      N();
      return;
      continue;
      localList = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs = true;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isAgreeSyncLbs = paramBoolean;
    }
    f();
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(paramActivity);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a("关注成功");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364595);
    str = str + "应用";
    paramActivity = new hlh(this, paramActivity);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str, paramActivity);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramActivity);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = (ProfileParams)((Bundle)localObject).getParcelable("profile_params");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams = ((ProfileParams)localObject);
      }
    }
    this.jdField_p_of_type_JavaLangString = a(paramIntent);
    this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_type");
    this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_name");
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[sopType]:" + this.jdField_k_of_type_JavaLangString + ",[sopName]:" + this.jdField_l_of_type_JavaLangString);
    }
    this.jdField_r_of_type_JavaLangString = paramIntent.getStringExtra("extvalue");
    this.jdField_s_of_type_JavaLangString = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString))
    {
      if (!"2".equals(this.jdField_s_of_type_JavaLangString)) {
        break label197;
      }
      this.jdField_f_of_type_Boolean = true;
    }
    label197:
    do
    {
      while ((this.jdField_p_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
      {
        return;
        if ("1".equals(this.jdField_s_of_type_JavaLangString)) {
          this.jdField_g_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      p();
      Q();
      b(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "init exit");
  }
  
  public void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131296821);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    if (!i()) {}
    int i2;
    do
    {
      return;
      i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailActivity.bindTroop", 2, "addBindedTroopItem:" + i2 + "," + this.x);
      }
    } while ((i2 == 0) && (!this.x));
    View localView = LayoutInflater.from(this).inflate(2130903728, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131298671);
    Object localObject = localView.findViewById(2131297013);
    this.jdField_a_of_type_AndroidViewViewGroup = localLinearLayout;
    if (i2 == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      ((View)localObject).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = new ImageView(this);
        int i3 = (int)(32.0F * this.jdField_a_of_type_Float);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i3, i3);
        localLayoutParams.leftMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1)));
        ((ImageView)localObject).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
        localLinearLayout.addView((View)localObject);
        i1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    localView.setOnClickListener(new hmy(this, i2));
    paramViewGroup.addView(localView);
    b(paramViewGroup);
  }
  
  void a(ViewGroup paramViewGroup, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "addPublicAccountDetailItem");
    }
    if (a(paramPaConfigInfo)) {
      return;
    }
    label50:
    int i1;
    int i2;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3) {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = n(paramPaConfigInfo);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label514;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837508);
        i1 = (int)(10.0F * this.jdField_a_of_type_Float);
        i2 = (int)(15.0F * this.jdField_a_of_type_Float);
        if (paramPaConfigInfo.jdField_a_of_type_Int != 4) {
          break label516;
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(i2, i2, i2, i2);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      b(paramViewGroup);
      this.Q = paramInt;
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_Int = paramPaConfigInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_e_of_type_JavaLangString = paramPaConfigInfo.jdField_e_of_type_JavaLangString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "addPublicAccountDetailItem exit");
      return;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = l(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 9);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 10);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = m(paramPaConfigInfo);
        break label50;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      return;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView = p(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = o(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramPaConfigInfo);
        break label50;
      }
      this.jdField_a_of_type_AndroidViewView = a();
      break label50;
      label514:
      break;
      label516:
      if ((paramPaConfigInfo.jdField_a_of_type_Int == 2) || ((paramPaConfigInfo.jdField_a_of_type_Int == 5) && (!paramPaConfigInfo.jdField_e_of_type_JavaLangString.equals("[]")))) {
        this.jdField_a_of_type_AndroidViewView.setPadding(i2, 0, i2, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setPadding(i2, i1, i2, i1);
      }
    }
  }
  
  protected void a(ViewGroup paramViewGroup, List paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail(this);
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback);
    localPhotoWallViewForAccountDetail.a(this, paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  public void a(Button paramButton1, Button paramButton2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramButton1.setTextColor(Color.parseColor("#000000"));
      paramButton2.setTextColor(Color.parseColor("#9d9d9d"));
      return;
    }
    paramButton1.setTextColor(Color.parseColor("#9d9d9d"));
    paramButton2.setTextColor(Color.parseColor("#000000"));
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    int i1 = paramPaConfigInfo.jdField_d_of_type_Int;
    this.jdField_h_of_type_Boolean = false;
    if ((i1 == 1) || (i1 == 2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131371917);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131371918);
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131371917, 5, false);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131371918, 5, false);
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.e(0);
      if ((paramInt != 1) && (paramInt != 2)) {
        break label142;
      }
    }
    label142:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new hlt(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new hlu(this, paramPaConfigInfo, paramInt));
      if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.jdField_t_of_type_Boolean = false;
        this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.e(1);
      break;
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.jdField_h_of_type_Boolean = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    int i1 = 1;
    b(2131364484);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_d_of_type_MqqAppNewIntent = localNewIntent;
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_p_of_type_JavaLangString));
    int i2 = paramPaConfigInfo.jdField_e_of_type_Int;
    if (paramBoolean) {}
    for (;;)
    {
      localSetFunctionFlagRequset.type.set(i2);
      localSetFunctionFlagRequset.value.set(i1);
      localSetFunctionFlagRequset.account_type.set(b());
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_d_of_type_MqqObserverBusinessObserver = new hln(this, paramPaConfigInfo, paramSwitch, i1, i2, paramBoolean);
      localNewIntent.setObserver(this.jdField_d_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      this.E += 1;
      return;
      i1 = 2;
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramProfileImageInfo.jdField_e_of_type_JavaLangString + ", state=" + paramProfileImageInfo.h);
      }
    } while (paramProfileImageInfo.h != 6);
    f(paramProfileImageInfo.jdField_d_of_type_JavaLangString);
  }
  
  public void a(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((EntityManager)localObject).a(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
        if (paramAccountDetail.followType == 1) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((EntityManager)localObject).a(paramAccountDetail);
    }
  }
  
  public void a(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.b().postDelayed(new hmb(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class paramClass)
  {
    a(paramString1, paramInt, paramString2, paramClass, false);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Class paramClass, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this, paramClass));
    paramClass = new Bundle();
    paramClass.putString("uin", paramString1);
    paramClass.putInt("uintype", paramInt);
    paramClass.putString("uinname", paramString2);
    localIntent.putExtras(paramClass);
    localIntent.setFlags(67108864);
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false);
    if (this.jdField_f_of_type_Boolean)
    {
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", this.jdField_r_of_type_JavaLangString);
      this.jdField_f_of_type_Boolean = false;
    }
    if (bool) {
      super.finish();
    }
    localIntent.putExtra("isforceRequestDetail", paramBoolean);
    localIntent.putExtra("jump_from", 2);
    super.startActivity(localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isConfirmed = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int i3 = paramJSONArray.length();
    if (i3 <= 0) {
      return;
    }
    int i1 = 0;
    while ((i1 < 3) && (i1 + 1 <= i3))
    {
      int i2 = (int)(6.0F * this.jdField_a_of_type_Float);
      int i4 = (int)(32.0F * this.jdField_a_of_type_Float);
      ImageView localImageView = new ImageView(this);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i4, i4);
      if (i1 == 2) {
        i2 = 0;
      }
      localLayoutParams.setMargins(0, 0, i2, 0);
      localImageView.setLayoutParams(localLayoutParams);
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i1))) {
          localImageView.setImageResource(2130838424);
        }
        for (;;)
        {
          paramLinearLayout.addView(localImageView);
          i1 += 1;
          break;
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i1)));
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = ((AccountDetail)((EntityManager)localObject).a(AccountDetail.class, this.jdField_p_of_type_JavaLangString));
    ((EntityManager)localObject).a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.has())
      {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.unifiedDesrpition = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.parser();
      }
      for (;;)
      {
        if (i())
        {
          localObject = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_p_of_type_JavaLangString);
          if (localObject != null)
          {
            this.x = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
            localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              this.jdField_a_of_type_JavaUtilArrayList.clear();
              this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountDetailActivity.bindTroop", 2, "loadCache, hit cache");
            }
          }
        }
        return true;
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  boolean a(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramPaConfigAttr.a;
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = a();
      if (paramPaConfigAttr.jdField_c_of_type_Int != 1) {
        break;
      }
      localObject = paramPaConfigAttr.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localPaConfigInfo.jdField_e_of_type_JavaLangString)) {
          ((Iterator)localObject).remove();
        } else if ((localPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
    } while (paramPaConfigAttr.a.size() < 3);
    a(localViewGroup, paramPaConfigAttr.a);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    return false;
    int i3 = ((List)localObject).size();
    if (i3 <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i3 > 0) && (paramBoolean))
    {
      paramPaConfigAttr = new View(this);
      paramPaConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      paramPaConfigAttr.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramPaConfigAttr);
    }
    int i2 = 0;
    if (i2 < i3)
    {
      int i1;
      if (i3 > 1) {
        if (i2 == 0) {
          i1 = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (PaConfigAttr.PaConfigInfo)((List)localObject).get(i2), i1);
        i2 += 1;
        break;
        if (i2 == i3 - 1)
        {
          i1 = 2;
        }
        else
        {
          i1 = 3;
          continue;
          if (i3 > 3)
          {
            if (paramInt1 == 1) {
              i1 = 1;
            } else if (paramInt1 == paramInt2 - 1) {
              i1 = 2;
            } else {
              i1 = 3;
            }
          }
          else {
            i1 = 0;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  public boolean a(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramPaConfigAttr, paramInt1, paramInt2, paramBoolean2);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_t_of_type_JavaLangString == null) {
      this.jdField_t_of_type_JavaLangString = ("http://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_p_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account");
    }
    return this.jdField_t_of_type_JavaLangString;
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new hnb(this, paramInt), 500L);
  }
  
  void b(Intent paramIntent)
  {
    this.z = paramIntent.getBooleanExtra("fromBrowser", false);
    this.L = paramIntent.getIntExtra("source", 0);
    switch (this.L)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.K);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A24", "0X8005A24", this.K, 0, "", "", "", "");
      return;
      this.K = 2;
      continue;
      this.K = 1;
      continue;
      this.K = 0;
      continue;
      this.K = 3;
      continue;
      this.K = 4;
      continue;
      this.K = 5;
      continue;
      this.K = 6;
      continue;
      this.K = 8;
      continue;
      this.K = 9;
      continue;
      this.K = 11;
      continue;
      this.K = 50;
      continue;
      this.K = 12;
      continue;
      this.K = 13;
    }
  }
  
  public void b(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    b(2131364484);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_e_of_type_MqqAppNewIntent = localNewIntent;
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_p_of_type_JavaLangString));
    int i2 = paramPaConfigInfo.jdField_e_of_type_Int;
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "");
    }
    for (int i1 = 1;; i1 = 3)
    {
      localSetFunctionFlagRequset.type.set(i2);
      localSetFunctionFlagRequset.value.set(i1);
      localSetFunctionFlagRequset.account_type.set(b());
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_e_of_type_MqqObserverBusinessObserver = new hlv(this, paramPaConfigInfo, i1, paramInt);
      localNewIntent.setObserver(this.jdField_e_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      this.E += 1;
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "");
    }
  }
  
  public void b(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    this.j = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str = paramPaConfigInfo.jdField_d_of_type_JavaLangString;
    if (3 == paramPaConfigInfo.jdField_e_of_type_Int) {
      str = String.format(getString(2131362712), new Object[] { a() });
    }
    localQQCustomDialog.setTitle("温馨提示");
    localQQCustomDialog.setMessage(str);
    localQQCustomDialog.setOnCancelListener(new hlo(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new hlp(this, paramPaConfigInfo, paramSwitch, paramBoolean);
    localQQCustomDialog.setNegativeButton("取消", paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton("确定", paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  public void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramAccountDetail);
    localEntityManager.a();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this, PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_p_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_p_of_type_JavaLangString);
    paramString = a();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    super.startActivity(localIntent);
  }
  
  protected boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {
        bool = h();
      }
      while (((this.L == 5) || (this.L == 113)) && (h())) {
        return bool;
      }
      return false;
    }
    return false;
  }
  
  protected int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.equals("")) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.equals(null))) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
    }
    return Color.parseColor("#" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6));
  }
  
  public void c()
  {
    L();
    S();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.e();
        Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.b();
        Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.c();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        long l1 = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1).append(",").append("app").append(",").append((String)localObject2).append(",").append((String)localObject3).append(",").append(l1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
      }
      return;
    }
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null;
  }
  
  public int d()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  public void d(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public void d(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a();
  }
  
  public void d(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131558973);
    localDialog.setContentView(2130904118);
    ((TextView)localDialog.findViewById(2131301455)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131301456);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131301457);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131301458);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131367262);
    localTextView3.setText(2131369290);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new hmg(this, localDialog));
    localTextView3.setOnClickListener(new hmh(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected boolean d()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;
    }
    return i1 == 1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (!this.i);
      this.u = true;
      return true;
    } while (!this.u);
    this.u = false;
    return true;
  }
  
  public void doOnBackPressed()
  {
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null)
    {
      i1 = 1;
      if (this.jdField_l_of_type_Boolean) {
        break label110;
      }
      i2 = 1;
      label18:
      if ((i1 == 0) || (!this.jdField_l_of_type_Boolean)) {
        break label115;
      }
      moveTaskToBack(true);
    }
    for (;;)
    {
      if (!d()) {
        c("0X8005B6E");
      }
      if (getIntent().getBooleanExtra("from_newer_guide", false))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("has_operation", d());
        localIntent.putExtra("uin", this.jdField_p_of_type_JavaLangString);
        setResult(-1, localIntent);
      }
      super.doOnBackPressed();
      return;
      i1 = 0;
      break;
      label110:
      i2 = 0;
      break label18;
      label115:
      if ((i1 != 0) && (i2 != 0) && (super.isTaskRoot())) {
        super.startActivity(new Intent(this, SplashActivity.class));
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_p_of_type_JavaLangString != null) {
      A();
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    if (i()) {
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_p_of_type_JavaLangString != null) {
      A();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_l_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.y)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailActivity.bindTroop", 2, "doOnResume, isClickedBindTroopItem==true");
      }
      S();
      this.y = false;
    }
  }
  
  public int e()
  {
    return this.G - this.H - this.I - this.J - 1;
  }
  
  protected View e(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f))) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    TextView localTextView = (TextView)localView.findViewById(2131297123);
    String str1 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str2 = paramPaConfigInfo.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new hmi(this, paramPaConfigInfo, str2));
      return localView;
    }
    return null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      a(this.jdField_p_of_type_JavaLangString, this.B, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
    }
  }
  
  public void e(int paramInt)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - paramInt;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    if (c()) {
      return;
    }
    double d3 = jdField_a_of_type_Double;
    double d2;
    double d1;
    double d4;
    double d5;
    if (j())
    {
      d2 = 0.2D;
      d1 = 0.2D;
      d4 = (jdField_b_of_type_Double * d3 - 0.05D) / (d3 - 0.3D);
      d5 = (i1 - this.G * 0.3D) / ((d3 - 0.3D) * this.G);
      if (i1 > d2 * this.G) {
        break label272;
      }
      localLayoutParams1.height = ((int)(30.0F * this.jdField_a_of_type_Float));
      localLayoutParams1.width = ((int)(30.0F * this.jdField_a_of_type_Float));
      localLayoutParams1.topMargin = ((int)(this.G * 0.1D * 2.5D - localLayoutParams1.height / 2 - d1 * this.G));
      localLayoutParams2.height = ((int)(32.0F * this.jdField_a_of_type_Float));
      localLayoutParams2.width = localLayoutParams2.height;
      localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - 1.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new hly(this, localLayoutParams1, localLayoutParams2));
      f(i1);
      return;
      d2 = 0.2237D;
      d1 = 0.1763D;
      break;
      label272:
      if (i1 <= this.G * 0.3D)
      {
        localLayoutParams1.height = ((int)(30.0F * this.jdField_a_of_type_Float));
        localLayoutParams1.width = ((int)(30.0F * this.jdField_a_of_type_Float));
        localLayoutParams1.topMargin = ((int)(this.G * 0.1D * 2.5D - localLayoutParams1.height / 2 - paramInt));
        localLayoutParams2.height = ((int)(32.0F * this.jdField_a_of_type_Float));
        localLayoutParams2.width = localLayoutParams2.height;
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - 1.0F * this.jdField_a_of_type_Float));
      }
      else if (i1 >= this.G * d3)
      {
        localLayoutParams1.height = ((int)(jdField_v_of_type_Int * this.jdField_a_of_type_Float));
        localLayoutParams1.width = localLayoutParams1.height;
        localLayoutParams1.topMargin = ((int)(i1 * jdField_b_of_type_Double - localLayoutParams1.height / 2 + paramInt));
        localLayoutParams2.height = ((int)(localLayoutParams1.height + 8.0F * this.jdField_a_of_type_Float));
        localLayoutParams2.width = localLayoutParams2.height;
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - 4.0F * this.jdField_a_of_type_Float));
      }
      else
      {
        localLayoutParams1.height = ((int)((30.0D + (jdField_v_of_type_Int - 30) * d5) * this.jdField_a_of_type_Float));
        localLayoutParams1.width = localLayoutParams1.height;
        localLayoutParams1.topMargin = ((int)((i1 - this.G * 0.3D) * d4 + this.G * 0.1D * 0.5D - localLayoutParams1.height / 2 + paramInt));
        localLayoutParams2.height = ((int)(localLayoutParams1.height + (1.0D + 7.0D * d5) * this.jdField_a_of_type_Float));
        localLayoutParams2.width = localLayoutParams2.height;
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - (1.0D + 7.0D * d5) * this.jdField_a_of_type_Float / 2.0D));
      }
    }
  }
  
  public void e(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "");
      return;
    }
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton);
  }
  
  public int f()
  {
    return this.G - this.H - this.J - 1;
  }
  
  protected View f(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.h;
    if (str != null)
    {
      str = str.trim();
      if (Pattern.compile("[\\d-]+?").matcher(str).matches()) {}
    }
    else
    {
      return null;
    }
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    localView.setOnClickListener(new hmj(this, str, paramPaConfigInfo));
    return localView;
  }
  
  public void f()
  {
    ThreadManager.b().postDelayed(new hlm(this), 10L);
  }
  
  void f(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)super.findViewById(2131296801);
    View localView = super.findViewById(2131296804);
    double d1;
    if (j())
    {
      d1 = 0.1D;
      if (paramInt >= d1 * this.G) {
        break label138;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(c());
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_p_of_type_JavaLangString));
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.o)
      {
        localLinearLayout.setVisibility(0);
        localView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_b_of_type_AndroidWidgetButton);
      }
    }
    label138:
    while (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      return;
      d1 = 0.1172D;
      break;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    localLinearLayout.setVisibility(8);
    localView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetButton, this.jdField_b_of_type_AndroidWidgetButton);
  }
  
  void f(String paramString)
  {
    if (this.w) {
      return;
    }
    this.w = true;
    ThreadManager.b().post(new hmw(this, paramString));
  }
  
  protected boolean f()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1);
  }
  
  protected View g(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903284, null);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  public void g()
  {
    ThreadManager.b().postDelayed(new hnc(this), 10L);
  }
  
  public void g(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    int i2;
    int i1;
    do
    {
      do
      {
        return;
      } while (paramInt < 0);
      if (FontSettingManager.a() == 20.0F)
      {
        i2 = (int)(0.45D * this.G);
        i1 = (int)(0.35D * this.G);
      }
      for (;;)
      {
        paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - paramInt;
        if (Build.VERSION.SDK_INT >= 11) {
          break label227;
        }
        if (paramInt > i1) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        if (FontSettingManager.a() == 18.0F)
        {
          i2 = (int)(0.42D * this.G);
          i1 = (int)(0.32D * this.G);
        }
        else if (FontSettingManager.a() == 17.0F)
        {
          i2 = (int)(0.4D * this.G);
          i1 = (int)(0.3D * this.G);
        }
        else
        {
          i2 = (int)(0.39D * this.G);
          i1 = (int)(0.29D * this.G);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } while (a() == 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    return;
    label227:
    if ((paramInt <= i2) && (paramInt >= i1))
    {
      float f1;
      if (paramInt - i1 <= 0.01D * this.G) {
        f1 = 0.05F;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f1);
        this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(f1);
        this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(f1);
        return;
        if (paramInt - i1 <= 0.02D * this.G) {
          f1 = 0.15F;
        } else if (paramInt - i1 <= 0.03D * this.G) {
          f1 = 0.25F;
        } else if (paramInt - i1 <= 0.04D * this.G) {
          f1 = 0.35F;
        } else if (paramInt - i1 <= 0.05D * this.G) {
          f1 = 0.45F;
        } else if (paramInt - i1 <= 0.06D * this.G) {
          f1 = 0.55F;
        } else if (paramInt - i1 <= 0.07D * this.G) {
          f1 = 0.65F;
        } else if (paramInt - i1 <= this.G * 0.08D) {
          f1 = 0.75F;
        } else if (paramInt - i1 <= this.G * 0.08D) {
          f1 = 0.85F;
        } else {
          f1 = 0.95F;
        }
      }
    }
    if (paramInt < i1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.0F);
      this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  boolean g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      if ((!this.q) || ((this.P != M) && (this.P != N) && (this.P != O))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  protected View h(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = false;
    if ((this.o) && (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史"))) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130903456, null);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131298672).setVisibility(0);
      localView.setOnClickListener(new hmk(this, str, paramPaConfigInfo));
      bool = true;
    }
    try
    {
      for (;;)
      {
        paramPaConfigInfo = new JSONArray(paramPaConfigInfo.jdField_e_of_type_JavaLangString);
        a(bool, (LinearLayout)localView.findViewById(2131298671), paramPaConfigInfo);
        return localView;
        localView.findViewById(2131298672).setVisibility(8);
      }
    }
    catch (JSONException paramPaConfigInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramPaConfigInfo.printStackTrace();
      }
    }
  }
  
  public void h()
  {
    ThreadManager.b().postDelayed(new hne(this), 10L);
  }
  
  boolean h()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return false;
    }
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag2 & 0x80) != 0L)
    {
      i1 = 1;
      if ((i1 == 0) || (!C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1008))) {
        break label60;
      }
    }
    for (;;)
    {
      return bool;
      i1 = 0;
      break;
      label60:
      bool = false;
    }
  }
  
  protected View i(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hml(this, paramPaConfigInfo));
    return localView;
  }
  
  public void i()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateView");
    }
    this.o = a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.o) && (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString))) {
      AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_p_of_type_JavaLangString));
    }
    if (b())
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      int i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has())
        {
          i1 = i2;
          if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() == 2) {
            i1 = 1;
          }
        }
      }
      if (i1 == 0) {
        break label177;
      }
      G();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateView exit");
      }
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      break;
      label177:
      l();
      a();
      I();
      E();
      H();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter);
    }
  }
  
  protected boolean i()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      bool1 = bool2;
      if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailActivity.bindTroop", 2, "needShowBindTroopItem:" + bool1);
    }
    return bool1;
  }
  
  protected View j(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmm(this, paramPaConfigInfo));
    return localView;
  }
  
  protected View k(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmn(this, paramPaConfigInfo));
    return localView;
  }
  
  protected View l(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmp(this, paramPaConfigInfo));
    return localView;
  }
  
  protected void l()
  {
    R();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    C();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton;
    D();
    if (i1 != 0) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (!bool)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {
        break label162;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837505);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131364760));
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetButton.setText(2131371919);
      return;
      F();
      break;
      label162:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840081);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364687));
    }
  }
  
  protected View m(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmr(this, str, paramPaConfigInfo));
    return localView;
  }
  
  protected View n(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "Unhandled ConfigInfo(" + paramPaConfigInfo.jdField_a_of_type_Int + ", " + paramPaConfigInfo.jdField_c_of_type_Int + ", " + paramPaConfigInfo.jdField_e_of_type_Int + ")");
      }
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130905003, null);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297923));
    if ((paramPaConfigInfo.jdField_d_of_type_Int == 1) || (paramPaConfigInfo.jdField_d_of_type_Int == 2)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131371917);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new hms(this, paramPaConfigInfo));
      return localView;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131371918);
    }
  }
  
  protected void n()
  {
    PAStartupTracker.a(null, "pubAcc_follow_confirm", this.jdField_p_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow uin=" + this.jdField_p_of_type_JavaLangString);
    }
    this.i = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new hle(this), 3000L);
    b(2131364486);
    this.jdField_b_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) && (this.jdField_g_of_type_Boolean)) {
      localFollowRequest.ext.set(this.jdField_r_of_type_JavaLangString);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_p_of_type_JavaLangString));
    localFollowRequest.account_type.set(b());
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new hlf(this);
    this.jdField_b_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_b_of_type_MqqAppNewIntent);
    this.E += 1;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow exit");
    }
  }
  
  protected View o(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = true;
    View localView = getLayoutInflater().inflate(2130905031, null);
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131297888);
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1)
    {
      localSwitch.setChecked(true);
      if (paramPaConfigInfo.jdField_d_of_type_Int != 1) {
        break label98;
      }
    }
    for (;;)
    {
      a(paramPaConfigInfo.jdField_e_of_type_Int, bool);
      localSwitch.setOnCheckedChangeListener(new hmt(this, paramPaConfigInfo, localSwitch));
      return localView;
      localSwitch.setChecked(false);
      break;
      label98:
      bool = false;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_c_of_type_AndroidWidgetButton) {
      v();
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidViewView)
      {
        c("0X8005B6D");
        this.m = false;
        n();
        F();
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        this.jdField_b_of_type_AndroidViewView.postDelayed(new hmf(this), 1000L);
        if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_p_of_type_JavaLangString)) {
          ((EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134243868, this.jdField_p_of_type_JavaLangString, null, null, null, 1L, false);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A25", "0X8005A25", this.K, 0, "", "", "", "");
        PADetailReportUtil.a().a(4, this.jdField_p_of_type_JavaLangString, 0, GroupSearchActivity.jdField_e_of_type_Int, PAOfflineSearchManager.a().a(this.jdField_p_of_type_JavaLangString));
        return;
      }
      if (paramView == this.jdField_d_of_type_AndroidWidgetButton)
      {
        e();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8004E44", "0X8004E44", 0, 0, this.jdField_p_of_type_JavaLangString, "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_p_of_type_JavaLangString, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_f_of_type_AndroidViewView)
      {
        if (h())
        {
          C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_p_of_type_JavaLangString, a(), "publicAccountInfoCard");
          return;
        }
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), this.jdField_p_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_d_of_type_AndroidWidgetTextView)
      {
        doOnBackPressed();
        return;
      }
    } while (paramView != this.jdField_c_of_type_AndroidWidgetImageView);
    if (f())
    {
      M();
      return;
    }
    y();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    if (this.jdField_a_of_type_Hnn != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Hnn);
      this.jdField_a_of_type_Hnn = null;
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_b_of_type_MqqAppNewIntent != null) {
      this.jdField_b_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_d_of_type_MqqAppNewIntent != null)
    {
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_d_of_type_MqqAppNewIntent = null;
    }
    if (this.jdField_e_of_type_MqqAppNewIntent != null)
    {
      this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_e_of_type_MqqAppNewIntent = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$FriendAvatarWeakReference != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$FriendAvatarWeakReference.b();
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      PAStartupTracker.a("pubAcc_profile_display", null, this.jdField_p_of_type_JavaLangString);
      this.jdField_p_of_type_Boolean = true;
      return;
    }
    this.jdField_p_of_type_Boolean = false;
  }
  
  protected View p(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((this.o) && (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史"))) {
      return null;
    }
    View localView = getLayoutInflater().inflate(2130903383, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131297123)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131297013)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new hmu(this, str, paramPaConfigInfo));
    return localView;
  }
  
  void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2130903041);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    q();
    r();
    s();
    u();
    this.jdField_h_of_type_AndroidViewView = super.findViewById(2131296808);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296805));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296799));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296800));
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initView exit");
      }
      return;
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  void q()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296796));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    int i2;
    if (j()) {
      i2 = (int)(64.0F * this.jdField_a_of_type_Float);
    }
    for (int i1 = (int)(4.0F * this.jdField_a_of_type_Float);; i1 = (int)(25.0F * this.jdField_a_of_type_Float))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(0, i1, 0, 0);
      this.H = i2;
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296797));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131367975));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297183));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297392));
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      i2 = (int)(75.0F * this.jdField_a_of_type_Float);
    }
  }
  
  void r()
  {
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131296781);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.J = this.jdField_d_of_type_AndroidViewView.getLayoutParams().height;
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131296783);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131296782);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131296786);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131296785);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    super.setTitle(2131364474);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296807));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296784));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  void s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = ((AccountDetailXListView)super.findViewById(2131296795));
    this.G = getWindowManager().getDefaultDisplay().getHeight();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296787));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296788));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296790));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296789));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296793));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296792));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296794));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter = new AccountDetailActivity.AccountDetailAdapter(this, this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnScrollListener(new hlq(this));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setRefreshCallback(new hmd(this));
  }
  
  public void t()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  void u()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296802));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296803));
    int i1 = (int)(getWindowManager().getDefaultDisplay().getWidth() * 0.13D);
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(0, 0, i1, 0);
    this.jdField_b_of_type_AndroidWidgetButton.setPadding(i1, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new hmo(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new hmz(this));
  }
  
  void v()
  {
    super.finish();
    PublicAccountSearchActivity.a(this, "");
  }
  
  public void w()
  {
    PAStartupTracker.a(null, " pubAcc_follow_cancel", this.jdField_p_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow");
    }
    b(2131364485);
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(this.jdField_p_of_type_JavaLangString));
    localUnFollowRequest.account_type.set(b());
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_c_of_type_MqqObserverBusinessObserver = new hnd(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    this.E += 1;
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_p_of_type_JavaLangString);
    if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_p_of_type_JavaLangString))
    {
      int i1 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_p_of_type_JavaLangString);
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_p_of_type_JavaLangString), i1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow exit");
    }
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        a(this);
      }
      return;
    }
  }
  
  protected void y()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131364500, 5);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131364501, 5);
      if (e()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131364475, 3);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new hli(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new hlj(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_r_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void z()
  {
    JSONObject localJSONObject = a(this, this.jdField_p_of_type_JavaLangString);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("BSafeReportPost", true);
    if (localJSONObject != null) {}
    try
    {
      localIntent.putExtra("SafeReportData", localJSONObject.toString().getBytes("utf-8"));
      localIntent.putExtra("hide_more_buttonbutton", true);
      localIntent.putExtra("ishiderefresh", true);
      localIntent.putExtra("ishidebackforward", true);
      startActivity(localIntent.putExtra("url", "http://jubao.mp.qq.com/mobile/reportAccount"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
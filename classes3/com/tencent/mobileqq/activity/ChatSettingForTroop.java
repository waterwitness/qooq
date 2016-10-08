package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopProxyActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kzc;
import kzd;
import kze;
import kzf;
import kzh;
import kzi;
import kzj;
import kzk;
import kzl;
import kzm;
import kzn;
import kzq;
import kzr;
import kzs;
import kzu;
import kzz;
import laa;
import lac;
import lad;
import lae;
import laf;
import lag;
import lah;
import lai;
import laj;
import lak;
import lal;
import lam;
import lan;
import lao;
import lap;
import laq;
import lar;
import las;
import lau;
import lav;
import mqq.app.NewIntent;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.oidb.cmd0x5be.Oidb_0x5be.AppInfo;
import tencent.im.oidb.cmd0x5be.Oidb_0x5be.ReqBody;
import tencent.im.oidb.cmd0x5be.Oidb_0x5be.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final int A = 12;
  public static final int B = 13;
  public static final int C = 14;
  protected static final int D = 15;
  protected static final int E = 16;
  public static final int F = -1;
  public static final int G = 1;
  public static final int H = 2;
  protected static final int K = 0;
  protected static final int L = 1;
  protected static final int M = 2;
  protected static final int N = 3;
  protected static final int O = 4;
  protected static final int P = 5;
  protected static final int Q = 6;
  protected static final int R = 7;
  protected static final int S = 8;
  protected static final int T = 9;
  protected static final int U = 10;
  protected static final int V = 11;
  protected static final int W = 12;
  protected static final int X = 13;
  protected static final int Y = 14;
  protected static final int Z = 15;
  public static final int a = 1;
  public static final String a = "Q.chatopttroop";
  protected static final int aA = 3;
  protected static final int aB = 4;
  protected static final int aC = 5;
  protected static final int aD = 6;
  protected static final int aE = 7;
  protected static final int aF = 8;
  protected static final int aG = 9;
  protected static final int aH = 10;
  public static final int aI = 11;
  protected static final int aJ = 12;
  protected static final int aK = 13;
  public static final int aL = 14;
  public static final int aM = 15;
  protected static final int aN = 16;
  protected static final int aO = 17;
  protected static final int aP = 18;
  protected static final int aQ = 19;
  protected static final int aR = 20;
  protected static final int aS = 0;
  protected static final int aT = 8;
  protected static final int aa = 16;
  protected static final int ab = 17;
  protected static final int ac = 18;
  protected static final int ad = 19;
  protected static final int ae = 20;
  protected static final int af = 21;
  protected static final int ag = 21;
  protected static final int ah = 22;
  protected static final int ai = 23;
  protected static final int aj = 24;
  protected static final int ak = 25;
  protected static final int al = 26;
  protected static final int am = 27;
  protected static final int an = 229;
  public static final int aq = 6;
  protected static final int av = -158425;
  protected static final int aw = -950263;
  protected static final int az = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final String c = "http://qqweb.qq.com/m/qun/team/index.html?_wv=1027&_bid=2230&src=2&gc=";
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  protected static final String f = "Contacts_Mode_GuideTips_value";
  public static final int g = 7;
  protected static final String g = "Change_Msg_Notify_Tips_Value";
  public static final int h = 8;
  public static final String h = "PubAccountSvc.get_detail_info";
  public static final int i = 9;
  public static final int j = 3000;
  public static final int k = 0;
  protected static final String k = "_troop_community.nb";
  public static final int l = 1;
  public static final int m = 2;
  public static final String m = "qqact.actvitylist";
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  public static final int s = 4;
  public static final int t = 5;
  public static final int u = 6;
  public static final int v = 7;
  public static final int w = 8;
  public static final int x = 9;
  public static final int y = 10;
  public static final int z = 11;
  protected final int I;
  protected final int J;
  long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  public Intent a;
  protected Drawable a;
  public Handler a;
  public DisplayMetrics a;
  protected View.OnClickListener a;
  protected View a;
  public AlphaAnimation a;
  protected Animation.AnimationListener a;
  protected Button a;
  public ImageView a;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  protected TroopCardAppInfoHelper.IGetAppInfoCB a;
  protected TroopCardAppInfoHelper a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public TroopInfo a;
  public AvatarWallAdapter a;
  protected AvatarWallView a;
  public GroupCatalogBean a;
  public TroopInfoData a;
  protected TroopShareUtility a;
  public RoamSettingController a;
  protected QQProgressDialog a;
  public QQProgressNotifier a;
  protected QQToastNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ImmersiveTitleBar2 a;
  protected Runnable a;
  public ArrayList a;
  protected HashMap a;
  protected LinkedHashMap a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  protected BusinessObserver a;
  protected boolean a;
  public View[] a;
  private int aU;
  public int ao;
  public int ap;
  protected int ar;
  int as;
  public int at;
  public int au;
  protected int ax;
  protected int ay;
  public Drawable b;
  protected View b;
  public AlphaAnimation b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public TextView b;
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver;
  protected Runnable b;
  protected String b;
  protected ArrayList b;
  public List b;
  protected BusinessObserver b;
  public volatile boolean b;
  public View c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected TextView c;
  public List c;
  private BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  ImageView d;
  public final String d;
  public boolean d;
  ImageView e;
  public String e;
  protected boolean e;
  ImageView f;
  protected boolean f;
  ImageView g;
  protected boolean g;
  public ImageView h;
  public boolean h;
  protected String i;
  protected boolean i;
  protected String j;
  public boolean j;
  protected boolean k;
  protected String l;
  private boolean l;
  protected String n;
  
  public ChatSettingForTroop()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.I = 1;
    this.J = 4;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_JavaLangString = "http://app.qun.qq.com/mobileapp/index.html?_bid=136";
    this.ap = 1;
    this.jdField_d_of_type_JavaLangString = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.at = 6;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kzc(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new kzq(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new lae(this);
    this.jdField_a_of_type_JavaLangRunnable = new las(this);
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new kzd(this);
    this.jdField_b_of_type_JavaLangRunnable = new kzh(this);
    this.jdField_a_of_type_Long = 0L;
    this.ax = -1;
    this.jdField_a_of_type_AndroidOsHandler = new kzn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new kzr(this);
    this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new kzs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kzu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new lad(this);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new lal(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new lam(this);
    this.jdField_b_of_type_MqqObserverBusinessObserver = new lan(this);
    this.jdField_c_of_type_MqqObserverBusinessObserver = new lao(this);
    this.n = "";
    this.aU = 2;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.ar == 1) || (this.ar == 2)) {
        i1 = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_e_of_type_JavaLangString));
        return;
      }
      Intent localIntent = AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      startActivityForResult(localIntent, 10);
      return;
    }
    b(2131368626, 1);
  }
  
  private void B()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131369311, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new lag(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  private static int a()
  {
    try
    {
      String[] arrayOfString = "6.5.5".split("\\.");
      int i3 = 0;
      int i2 = 10000;
      int i1 = 0;
      int i5 = i2;
      i2 = i1;
      if (i3 < arrayOfString.length)
      {
        int i4 = Integer.parseInt(arrayOfString[i3]);
        if (i4 > 99) {
          i2 = 99;
        }
        for (;;)
        {
          i4 = i5 / 100;
          i3 += 1;
          i1 += i2 * i5;
          i2 = i4;
          break;
          i2 = i4;
          if (i4 < 0) {
            i2 = 0;
          }
        }
      }
      return i2;
    }
    catch (Exception localException)
    {
      i2 = 0;
    }
  }
  
  public static Bitmap a(DisplayMetrics paramDisplayMetrics, Bitmap paramBitmap)
  {
    int i3 = 0;
    if ((paramBitmap == null) || (paramDisplayMetrics == null)) {}
    label144:
    do
    {
      do
      {
        return null;
        int i4 = paramDisplayMetrics.widthPixels;
        int i5 = paramDisplayMetrics.heightPixels;
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
          if ((i2 > 0) && (i1 > 0)) {
            break label144;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("Q.chatopttroop", 2, "targetW or targetH <= 0, targeW:" + i2 + ", targetH:" + i1);
          return null;
          i4 = i5 * i2 / i4;
          i3 = (i1 - i4) / 2;
          i1 = i4;
          i4 = 0;
        }
        paramDisplayMetrics = Bitmap.createBitmap(paramBitmap, i4, i3, i2, i1);
      } while (paramDisplayMetrics == null);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.chatopttroop", 4, "is bitmap mutable: " + paramDisplayMetrics.isMutable());
      }
      if (paramDisplayMetrics.isMutable()) {
        return paramDisplayMetrics;
      }
    } while ((paramDisplayMetrics == null) || (paramDisplayMetrics.isRecycled()));
    paramBitmap = Bitmap.createScaledBitmap(paramDisplayMetrics, paramDisplayMetrics.getWidth() / 2, paramDisplayMetrics.getHeight() / 2, true);
    paramDisplayMetrics.recycle();
    return paramBitmap;
  }
  
  private String a(String paramString, long paramLong)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      str = "0";
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android6.5.5").replace("$UIN$", this.app.a()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (this.ap != 1) {
        break label128;
      }
    }
    label128:
    for (paramString = "1";; paramString = "2")
    {
      return str.replace("$ENTERSOURCE$", paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static void a(Activity paramActivity, View paramView, Bitmap paramBitmap)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      paramBitmap = a(localDisplayMetrics, paramBitmap);
      if (paramBitmap != null)
      {
        StackBlur.a(paramBitmap, 10);
        paramActivity.runOnUiThread(new laj(paramView, new BitmapDrawable(paramBitmap)));
      }
      return;
    }
    catch (OutOfMemoryError paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.chatopttroop", 2, "fast blur OOM");
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131368729));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_circle", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131364641));
    if (!paramBoolean) {
      localIntent.putExtra("param_max", 10);
    }
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramContext.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      troop_member_distribute.ReqBody localReqBody = new troop_member_distribute.ReqBody();
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new NewIntent(paramQQAppInterface.a(), ProtoServlet.class);
      paramString.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
      paramString.putExtra("data", localReqBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramString);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.app.getManager(36);
      this.jdField_b_of_type_JavaUtilArrayList = localTroopInfoManager.a(localTroopInfoManager.a(paramString));
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.j = true;
      }
    }
    else
    {
      return;
    }
    this.j = false;
  }
  
  private void a(troopactivity.GroupInfoCardResp paramGroupInfoCardResp)
  {
    if (paramGroupInfoCardResp == null) {}
    int i1;
    Object localObject1;
    do
    {
      return;
      i1 = paramGroupInfoCardResp.activitys.size();
      localObject1 = paramGroupInfoCardResp.group_act_url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.n = a((String)localObject1, 0L);
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    } while (localObject1 == null);
    View localView = ((View)localObject1).findViewById(2131300763);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131300764);
    if (i1 > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(14, 0, localView, getString(2131364839), getString(2131364990), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      this.aU = 1;
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_activity", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.ay + "", "1", "");
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i1 = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getString(2131364991), new Object[] { Integer.valueOf(i1) });
      a(14, 0, localView, getString(2131364839), paramGroupInfoCardResp, true);
      ((View)localObject1).setVisibility(0);
      localTextView.setVisibility(8);
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_activity", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.ay + "", "0", "");
      this.aU = 0;
      return;
    }
    ((View)localObject1).setVisibility(8);
    localTextView.setVisibility(8);
    this.aU = 2;
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131367918);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131367919);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131367921);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131367922);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131367923);
  }
  
  public static void b(Activity paramActivity, View paramView, Bitmap paramBitmap)
  {
    if (paramActivity.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.a(new lak(paramActivity, paramView, paramBitmap), 8, null, true);
      return;
    }
    a(paramActivity, paramView, paramBitmap);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new Oidb_0x5be.ReqBody();
    ((Oidb_0x5be.ReqBody)localObject).opt_uint64_groupcode.set(Long.parseLong(paramString));
    ((Oidb_0x5be.ReqBody)localObject).opt_uint32_request_app_num.set(8);
    ((Oidb_0x5be.ReqBody)localObject).opt_version.set(a());
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1470);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5be.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(paramQQAppInterface.a(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x5be_1");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void c(int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131369008, 1500);
    }
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.b.clear();
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
      if (!this.l)
      {
        SharedPreferences localSharedPreferences = this.app.a().getSharedPreferences(this.app.a(), 0);
        if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
        {
          this.l = true;
          localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
          DialogUtil.a(this, getString(2131364702), 2131369480, 2131369480, new DialogUtil.DialogOnClickAdapter(), null).show();
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
      ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
    } while (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask != 3) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask != 2)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.associatePubAccount <= 0L));
    ThreadManager.a(new kzj(this), 8, null, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    troopactivity.ActSSOReq localActSSOReq = new troopactivity.ActSSOReq();
    localActSSOReq.cmd.set(1);
    localActSSOReq.group_code.set(Long.parseLong(paramString));
    paramString = new NewIntent(paramQQAppInterface.a(), ProtoServlet.class);
    paramString.putExtra("cmd", "qqact.actvitylist");
    paramString.putExtra("data", localActSSOReq.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(51);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if ((this.ap == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      return;
    }
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (paramInt != 0)
    {
      bool = true;
      localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = this.app.a();
      localUserInfo.jdField_b_of_type_JavaLangString = this.app.b();
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        localTroopHandler.e(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum <= 0) {
        break label143;
      }
      QZoneHelper.b(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 7);
    }
    for (;;)
    {
      a("Grp_Admin_data", "Clk_album", "");
      BnrReport.a(this.app, 66);
      return;
      bool = false;
      break;
      label143:
      QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool, 7);
    }
  }
  
  private void v()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (localTroopHandler != null)
    {
      if ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        break label70;
      }
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
      return;
      label70:
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), false);
    }
  }
  
  private void w()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    startActivityForResult(localIntent, 5);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getString(2131369944, new Object[] { localObject }));
      localActionSheet.a(getString(2131364689), false);
      localActionSheet.a(getString(2131364690), false);
      localActionSheet.a(getString(2131364691), false);
      int i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.d(2131367262);
        localActionSheet.a(new kzi(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        localActionSheet.e(0);
        continue;
        localActionSheet.e(1);
        continue;
        localActionSheet.e(2);
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this, ChatActivity.class);; localIntent = new Intent(this, SplashActivity.class))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
      startActivity(localIntent);
      return;
    }
  }
  
  private void z()
  {
    n();
    ((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_e_of_type_JavaLangString, null, null);
  }
  
  public String a(long paramLong)
  {
    if (paramLong > 0L)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      return getResources().getString(2131364903) + localSimpleDateFormat.format(Long.valueOf(1000L * paramLong));
    }
    return getResources().getString(2131364903) + "1998年11月11日";
  }
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      try
      {
        View localView1 = View.inflate(this, 2130905061, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView1.findViewById(2131297613));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView1.findViewById(2131297137));
        this.jdField_b_of_type_AndroidViewView = localView1.findViewById(2131302291);
        Object localObject1;
        if (ThemeUtil.isInNightMode(this.app))
        {
          if (this.jdField_b_of_type_AndroidViewView != null) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
          this.jdField_a_of_type_ArrayOfAndroidViewView = new View[21];
          this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
          localObject1 = new AbsListView.LayoutParams(-1, -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
          localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
          if (this.ap == 2)
          {
            i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
            int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
            int i3 = getResources().getDimensionPixelOffset(2131493102);
            this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i1, 0, i2, i3);
          }
          super.setContentView(localView1);
          this.jdField_c_of_type_AndroidViewView = localView1;
          this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427849));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131297083));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131297392));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView1.findViewById(2131296706));
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131297139));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369484);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " " + getResources().getString(2131369484));
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369828) + getString(2131371277));
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840081);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131362110));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)View.inflate(this, 2130903916, null));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
          this.jdField_c_of_type_AndroidWidgetTextView.setFocusable(true);
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " " + getResources().getString(2131369484));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView);
          localObject1 = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
          i1 = 0;
          if (Build.VERSION.SDK_INT > 18) {
            i1 = ImmersiveUtils.a(getApplicationContext());
          }
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)UITools.a(this, 80.0F));
          ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)UITools.a(this, 80.0F));
          ((LinearLayout.LayoutParams)localObject1).topMargin = (i1 + (int)UITools.a(this, 6.0F));
        }
        TextView localTextView1;
        TextView localTextView2;
        TextView localTextView3;
        View localView2;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          continue;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject1 = View.inflate(this, 2130903649, null);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView = ((AvatarWallView)((View)localObject1).findViewById(2131296687));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setContentDescription(getResources().getString(2131364656));
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.ap != 1)) {
            break label2468;
          }
          bool = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_Admin_data");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.e(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903910, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
          localObject4 = (TextView)((View)localObject1).findViewById(2131298261);
          localTextView1 = (TextView)((View)localObject1).findViewById(2131300633);
          localTextView2 = (TextView)((View)localObject1).findViewById(2131300634);
          localTextView3 = (TextView)((View)localObject1).findViewById(2131300635);
          localObject3 = ((View)localObject1).findViewById(2131300637);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject3;
          localView2 = ((View)localObject1).findViewById(2131300638);
          this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localView2;
          ((TextView)localObject4).setTag(Integer.valueOf(1));
          ((TextView)localObject4).setOnLongClickListener(this);
          ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          localTextView1.setTag(Integer.valueOf(1));
          localTextView1.setOnLongClickListener(this);
          localTextView2.setText(String.format(getResources().getString(2131367762), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade) }));
          localTextView2.setTag(Integer.valueOf(1));
          localTextView2.setOnClickListener(this);
          localTextView2.setContentDescription(String.format(getResources().getString(2131367762), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade) }));
          localTextView3.setText(getResources().getString(2131367763));
          localTextView3.setContentDescription(getResources().getString(2131367763));
          localTextView3.setVisibility(8);
          ((View)localObject3).setTag(Integer.valueOf(9));
          ((View)localObject3).setOnClickListener(this);
          localObject4 = (TextView)((View)localObject3).findViewById(2131297123);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) {
            break label2474;
          }
          ((View)localObject3).setVisibility(8);
          ((View)localObject1).setBackgroundColor(Color.parseColor("#00000000"));
          r();
          if ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
            break label2589;
          }
          localObject1 = View.inflate(this, 2130903648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
          ((View)localObject1).setBackgroundResource(2130840145);
          ((View)localObject1).getBackground().setAlpha(229);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          localObject1 = View.inflate(this, 2130904388, null);
          ((View)localObject1).setBackgroundResource(2130843552);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130904377, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)) {
            break label2494;
          }
          a(4, 1, (View)localObject1, getString(2131367909), getResources().getString(2131365073), true);
          localObject3 = View.inflate(this, 2130904385, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject3;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          localObject1 = (TroopManager)this.app.getManager(51);
          if (localObject1 == null) {
            break label3356;
          }
          localObject1 = ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject1 == null) {
            break label3356;
          }
          if ((((TroopInfo)localObject1).dwOfficeMode != 1L) || (!TroopUtils.a(Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)))) {
            break label2519;
          }
          i1 = 1;
          if (i1 == 0) {
            break label2525;
          }
          localObject1 = getString(2131367932);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
            break label2536;
          }
          a(0, 2, (View)localObject3, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
          a((View)localObject3);
          localObject1 = View.inflate(this, 2130904381, null);
          a(3, 3, (FormSimpleItem)((View)localObject1).findViewById(2131302583), getString(2131367963), "", true);
          ((TextView)((View)localObject1).findViewById(2131302584)).setText(2131364733);
          this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject3 = (TroopPluginManager)this.app.getManager(118);
          if (localObject3 != null) {
            this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject3).a("troop_manage_plugin.apk", new lap(this));
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
            break label2574;
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = View.inflate(this, 2130904388, null);
          ((View)localObject1).setBackgroundResource(2130843552);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(21, 1, (FormSimpleItem)localObject1, getString(2131367908), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130840145);
          ((FormSwitchItem)localObject1).setText(getString(2131369608));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131427409));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(229);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131369608));
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          localObject3 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject3).setTrackResource(2130839413);
          ((Switch)localObject3).setThumbResource(2130839412);
          ((Switch)localObject3).setTag(Boolean.FALSE);
          i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = i1;
          }
          if (i1 == 1) {
            break label2583;
          }
          bool = true;
          ((Switch)localObject3).setChecked(bool);
          ((Switch)localObject3).setOnCheckedChangeListener(new laq(this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130904381, null);
          localObject3 = (FormSimpleItem)((View)localObject1).findViewById(2131302583);
          a(8, 3, (FormSimpleItem)localObject3, getString(2131367901), "", true);
          this.h = new ImageView(this);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.a(17.0F, getResources()), AIOUtils.a(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject4).addRule(11);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          ((FormSimpleItem)localObject3).addView(this.h, (ViewGroup.LayoutParams)localObject4);
          this.h.setImageDrawable(getResources().getDrawable(2130838321));
          this.h.setVisibility(8);
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130904388, null);
          ((View)localObject1).setBackgroundResource(2130843552);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(17, 1, (FormSimpleItem)localObject1, getString(2131369508), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isAdmin())))
          {
            localObject1 = new FormSimpleItem(this);
            a(18, 2, (FormSimpleItem)localObject1, getString(2131365034), "", true);
            this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          if ((this.jdField_a_of_type_ArrayOfAndroidViewView[18] != null) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 512))) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[18].setVisibility(8);
          }
          localObject4 = View.inflate(this, 2130904380, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject4;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
          localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
            localObject1 = (String)localObject3 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          }
          b(13, 0, (View)localObject4, getString(2131367744), (CharSequence)localObject1, false);
          localObject1 = View.inflate(this, 2130904388, null);
          ((View)localObject1).setBackgroundResource(2130843552);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131299502);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView1.findViewById(2131298931));
          this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new lar(this));
          if (this.ap == 2)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
              break label3117;
            }
            i1 = 1;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
              break label3123;
            }
            this.jdField_a_of_type_AndroidWidgetButton.setText(2131369988);
            this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(24));
            this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          }
          a(false);
          if (this.ap == 1) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
          }
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (!QLog.isColorLevel()) {
            break label2441;
          }
          QLog.d("Q.chatopttroop", 2, localOutOfMemoryError2.getMessage());
          finish();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (!QLog.isColorLevel()) {
            break label2463;
          }
          QLog.d("Q.chatopttroop", 2, localInflateException.getMessage());
          finish();
          return;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        finish();
        localOutOfMemoryError1.printStackTrace();
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      continue;
      label2441:
      label2463:
      label2468:
      boolean bool = false;
      continue;
      label2474:
      ((View)localObject3).setVisibility(0);
      ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      continue;
      label2494:
      a(4, 1, localInflateException, getString(2131367909), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard, true);
      continue;
      label2519:
      int i1 = 0;
      continue;
      label2525:
      Object localObject2 = getString(2131367347);
      continue;
      label2536:
      a(0, 3, (View)localObject3, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
      continue;
      label2574:
      ((View)localObject2).setVisibility(8);
      continue;
      label2583:
      bool = false;
      continue;
      label2589:
      if (this.ap == 2)
      {
        localObject4 = View.inflate(this, 2130904380, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject4;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
          localObject2 = (String)localObject3 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
        }
        b(13, 0, (View)localObject4, getString(2131367744), (CharSequence)localObject2, false);
        localObject2 = View.inflate(this, 2130903943, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        a(14, 0, ((View)localObject2).findViewById(2131300763), getString(2131364839), "", true);
        ((View)localObject2).setVisibility(8);
        localObject2 = View.inflate(this, 2130904388, null);
        ((View)localObject2).setBackgroundResource(2130843552);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject2 = View.inflate(this, 2130903912, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[15] = localObject2;
        a(15, 0, (View)localObject2, String.format(getString(2131367745), new Object[] { PublicAccountConfigUtil.a(this.app, BaseApplicationImpl.getContext()) }), true);
        ((View)localObject2).setPadding(0, 0, 0, getResources().getDimensionPixelSize(2131493155));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        ((View)localObject2).setVisibility(8);
        localObject3 = View.inflate(this, 2130904388, null);
        ((View)localObject3).setBackgroundResource(2130843552);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        ((View)localObject3).setVisibility(8);
        ((View)localObject2).setTag(2131296513, localObject3);
        localObject2 = View.inflate(this, 2130904385, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        a(16, 1, (View)localObject2, getString(2131367382), getString(2131367384), true);
        a((View)localObject2);
        localObject2 = View.inflate(this, 2130904388, null);
        ((View)localObject2).setBackgroundResource(2130843552);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject2 = View.inflate(this, 2130904386, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[20] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人";
        a(20, 1, (View)localObject2, getString(2131367348), (CharSequence)localObject3, true);
        f();
        localObject2 = View.inflate(this, 2130903671, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[19] = localObject2;
        ((View)localObject2).setBackgroundResource(2130840145);
        ((View)localObject2).getBackground().setAlpha(229);
        ((View)localObject2).setFocusable(true);
        ((View)localObject2).setTag(Integer.valueOf(19));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        continue;
        label3117:
        i1 = 0;
        continue;
        label3123:
        if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (i1 != 0))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131369989, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
          this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(27));
          this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[10].findViewById(2131300635)).setVisibility(0);
        }
        else
        {
          if (this.ar == 2) {
            ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_objgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131367292);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(25));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
          ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[10].findViewById(2131300635)).setVisibility(8);
          continue;
          label3356:
          i1 = 0;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.ap == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum != 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = 0;
        DBUtils.a(this.app.a(), "troop_file_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum);
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra(TroopProxyActivity.a, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject).putExtra("param_from", 3000);
      TroopFileProxyActivity.a(this, (Intent)localObject, 16);
      localObject = (QQAppInterface)getAppRuntime();
      if (localObject == null) {
        break;
      }
      a("Grp", "Clk_grpinfo_files", "0");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      BnrReport.a((AppInterface)localObject, 67);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[20];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131369437), new Object[] { Integer.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131297124);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131297124);
    paramString.setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      paramView.getBackground().setAlpha(229);
      TextView localTextView = (TextView)paramView.findViewById(2131297123);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130840145);
      continue;
      paramView.setBackgroundResource(2130840146);
      continue;
      paramView.setBackgroundResource(2130840146);
      continue;
      paramView.setBackgroundResource(2130840145);
      continue;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.getBackground().setAlpha(229);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setTextColor(getResources().getColor(2131427409));
        paramString = paramFormSimpleItem.b();
        paramString.setTextColor(getResources().getColor(2131427409));
        paramString.setEditableFactory(QQTextBuilder.a);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
      paramFormSimpleItem.setBackgroundResource(2130840145);
      break label60;
      paramFormSimpleItem.setBackgroundResource(2130840146);
      break label60;
      paramFormSimpleItem.setBackgroundResource(2130840146);
      break label60;
      paramFormSimpleItem.setBackgroundResource(2130840145);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  public void a(int paramInt, View paramView, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.findViewById(2131300571);
      localViewGroup.removeAllViews();
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {}
    }
    else
    {
      return;
    }
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      TextView localTextView = new TextView(this);
      localTextView.setId(2131296466);
      localTextView.setBackgroundResource(2130840205);
      localTextView.setTextSize(2, 14.0F);
      if (paramBoolean2) {
        localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
      }
      localTextView.setSingleLine();
      localTextView.setTextColor(-1);
      localTextView.setShadowLayer(0.0F, 0.0F, 2.0F, Color.parseColor("#000000"));
      localTextView.setGravity(17);
      localTextView.setText((CharSequence)paramArrayList.get(i1));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
      localViewGroup.addView(localTextView, localLayoutParams);
      i1 += 1;
    }
    paramArrayList = paramView.findViewById(2131297122);
    if (paramBoolean1)
    {
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(this);
      paramArrayList.setVisibility(0);
      return;
    }
    paramView.setTag(null);
    paramView.setOnClickListener(null);
    paramArrayList.setVisibility(8);
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {}
    boolean bool;
    do
    {
      return;
      bool = paramBoolean;
      if (this.ap == 2)
      {
        bool = paramBoolean;
        if (13 == paramInt) {
          bool = false;
        }
      }
      paramView = paramView.findViewById(2131297122);
    } while (paramView == null);
    if (bool) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return;
    }
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramCharSequence + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView = null)
    {
      if (localView != null)
      {
        TextView localTextView = (TextView)localView.findViewById(2131297124);
        localView.setVisibility(0);
        if (localTextView != null)
        {
          if (paramCharSequence != null) {
            break label144;
          }
          paramCharSequence = "";
          localTextView.setText(paramCharSequence);
        }
        if (!paramBoolean) {
          break label157;
        }
        localView.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(this);
      }
      for (;;)
      {
        a(paramInt, localView, paramBoolean);
        return;
        label144:
        paramCharSequence = new QQText(paramCharSequence, 3);
        break;
        label157:
        localView.setTag(null);
        localView.setOnClickListener(null);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ThreadManager.a(new kzf(this, paramLong), 8, null, true);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localObject2 == null) || (paramLong <= 0L)) {
      return;
    }
    ((View)localObject2).setVisibility(0);
    ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_guest", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    Object localObject1 = (View)((View)localObject2).getTag(2131296513);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ImageView)((View)localObject2).findViewById(2131300642);
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131300644);
    localObject2 = (TextView)((View)localObject2).findViewById(2131300645);
    Drawable localDrawable = ImageUtil.a();
    ((ImageView)localObject1).setBackgroundDrawable(FaceDrawable.a(this.app, 105, String.valueOf(paramLong), 3, localDrawable, localDrawable));
    localTextView.setText(paramString1);
    ((TextView)localObject2).setText(paramString2);
  }
  
  /* Error */
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 1889	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 907	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 908	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: aload_1
    //   24: getfield 1893	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1894	[B
    //   30: invokevirtual 1898	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1901	KQQ/BatchResponse:seq	I
    //   38: ifne +291 -> 329
    //   41: aload 5
    //   43: ifnull +286 -> 329
    //   46: aload 5
    //   48: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +275 -> 329
    //   57: aload 5
    //   59: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1908	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore_2
    //   69: new 1910	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   72: dup
    //   73: invokespecial 1911	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   76: astore_3
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual 1912	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: pop
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_3
    //   86: getfield 1915	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   89: invokevirtual 1918	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   92: astore 6
    //   94: aload 6
    //   96: ifnonnull +58 -> 154
    //   99: iconst_0
    //   100: istore 8
    //   102: goto +2079 -> 2181
    //   105: aload_2
    //   106: ifnonnull +223 -> 329
    //   109: iload 9
    //   111: iload 8
    //   113: if_icmpge +216 -> 329
    //   116: aload 6
    //   118: iload 9
    //   120: invokeinterface 1921 2 0
    //   125: checkcast 1923	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   128: astore 4
    //   130: aload 4
    //   132: ifnonnull +34 -> 166
    //   135: aload_2
    //   136: astore_3
    //   137: iload 9
    //   139: iconst_1
    //   140: iadd
    //   141: istore 9
    //   143: aload_3
    //   144: astore_2
    //   145: goto -40 -> 105
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 1924	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   153: return
    //   154: aload 6
    //   156: invokeinterface 1925 1 0
    //   161: istore 8
    //   163: goto +2018 -> 2181
    //   166: aload 4
    //   168: getfield 1928	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore 10
    //   176: iload 10
    //   178: bipush 72
    //   180: if_icmpne +704 -> 884
    //   183: iload 9
    //   185: ifne +699 -> 884
    //   188: aload_0
    //   189: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   192: iconst_1
    //   193: if_icmpeq +13 -> 206
    //   196: aload_0
    //   197: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   200: getfield 1077	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   203: ifeq +650 -> 853
    //   206: aload_0
    //   207: ldc_w 1929
    //   210: iconst_1
    //   211: invokestatic 1934	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   214: aload_0
    //   215: invokevirtual 1937	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   218: invokevirtual 1940	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   221: pop
    //   222: aload_0
    //   223: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   226: bipush 51
    //   228: invokevirtual 751	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   231: checkcast 1066	com/tencent/mobileqq/app/TroopManager
    //   234: astore_3
    //   235: aload_3
    //   236: ifnull +14 -> 250
    //   239: aload_3
    //   240: aload_0
    //   241: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   244: getfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   247: invokevirtual 1942	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   255: aload_0
    //   256: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   259: iconst_0
    //   260: putfield 1077	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   263: aload_0
    //   264: invokevirtual 384	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   267: astore_3
    //   268: aload_3
    //   269: ldc_w 676
    //   272: iconst_2
    //   273: invokevirtual 637	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   276: pop
    //   277: aload_3
    //   278: ldc_w 1943
    //   281: invokevirtual 681	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   284: pop
    //   285: aload_0
    //   286: invokevirtual 1177	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   289: aload_0
    //   290: iconst_0
    //   291: iconst_0
    //   292: invokevirtual 1946	com/tencent/mobileqq/activity/ChatSettingForTroop:overridePendingTransition	(II)V
    //   295: aload_0
    //   296: aload_3
    //   297: invokevirtual 378	com/tencent/mobileqq/activity/ChatSettingForTroop:startActivity	(Landroid/content/Intent;)V
    //   300: aload_0
    //   301: iconst_0
    //   302: iconst_0
    //   303: invokevirtual 1946	com/tencent/mobileqq/activity/ChatSettingForTroop:overridePendingTransition	(II)V
    //   306: aload_2
    //   307: astore_3
    //   308: goto -171 -> 137
    //   311: astore_2
    //   312: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +14 -> 329
    //   318: ldc_w 1948
    //   321: iconst_2
    //   322: aload_2
    //   323: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_1
    //   330: getfield 1901	KQQ/BatchResponse:seq	I
    //   333: iconst_1
    //   334: if_icmpne +74 -> 408
    //   337: aload 5
    //   339: ifnull +69 -> 408
    //   342: aload 5
    //   344: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   347: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   350: ifeq +58 -> 408
    //   353: aload 5
    //   355: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   358: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   361: invokevirtual 1908	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   364: astore_2
    //   365: new 1950	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   368: dup
    //   369: invokespecial 1951	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   372: astore_3
    //   373: aload_3
    //   374: aload_2
    //   375: invokevirtual 1952	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   378: pop
    //   379: aload_3
    //   380: getfield 1955	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   383: ifnull +25 -> 408
    //   386: aload_0
    //   387: aload_3
    //   388: getfield 1955	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 1918	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   394: invokevirtual 1958	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/List;)V
    //   397: aload_0
    //   398: aload_3
    //   399: getfield 1955	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   402: invokevirtual 1918	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   405: putfield 1960	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   408: aload_1
    //   409: getfield 1901	KQQ/BatchResponse:seq	I
    //   412: iconst_2
    //   413: if_icmpne -402 -> 11
    //   416: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +13 -> 432
    //   422: ldc_w 1962
    //   425: iconst_2
    //   426: ldc_w 1964
    //   429: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 5
    //   434: ifnull -423 -> 11
    //   437: aload 5
    //   439: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   442: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   445: ifeq -434 -> 11
    //   448: aload 5
    //   450: getfield 918	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   456: invokevirtual 1908	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   459: astore_2
    //   460: new 1966	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   463: dup
    //   464: invokespecial 1967	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   467: astore_1
    //   468: aload_1
    //   469: aload_2
    //   470: invokevirtual 1968	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   473: pop
    //   474: aload_1
    //   475: getfield 1969	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   478: invokevirtual 1970	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   481: ifeq -470 -> 11
    //   484: aload_1
    //   485: getfield 1973	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   488: invokevirtual 1975	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   491: ifne -480 -> 11
    //   494: aload_1
    //   495: getfield 1973	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   498: invokevirtual 1918	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   501: astore 4
    //   503: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +41 -> 547
    //   509: new 485	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 1977
    //   519: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: astore_2
    //   523: aload 4
    //   525: ifnonnull +1615 -> 2140
    //   528: iconst_0
    //   529: istore 8
    //   531: ldc_w 1962
    //   534: iconst_2
    //   535: aload_2
    //   536: iload 8
    //   538: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload 4
    //   549: ifnull -538 -> 11
    //   552: aload_0
    //   553: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   556: bipush 51
    //   558: invokevirtual 751	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   561: checkcast 1066	com/tencent/mobileqq/app/TroopManager
    //   564: astore_2
    //   565: aload_1
    //   566: getfield 1969	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   569: invokevirtual 1979	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   572: lstore 12
    //   574: aload_2
    //   575: lload 12
    //   577: invokestatic 1873	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   580: invokevirtual 1072	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   583: astore_3
    //   584: aload_3
    //   585: ifnull -574 -> 11
    //   588: aload_3
    //   589: aload 4
    //   591: invokevirtual 1982	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   594: aload_1
    //   595: getfield 1985	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   598: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   601: ifeq +1551 -> 2152
    //   604: aload_1
    //   605: getfield 1985	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   608: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   611: istore 8
    //   613: aload_3
    //   614: iload 8
    //   616: i2l
    //   617: putfield 1989	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   620: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +31 -> 654
    //   626: ldc_w 1962
    //   629: iconst_2
    //   630: new 485	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   637: ldc_w 1991
    //   640: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: iload 8
    //   645: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: aload_1
    //   655: getfield 1994	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +17 -> 679
    //   665: aload_3
    //   666: aload_1
    //   667: getfield 1994	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   670: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   673: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   676: putfield 2000	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   679: aload_1
    //   680: getfield 2003	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   683: astore 4
    //   685: aload 4
    //   687: ifnull +17 -> 704
    //   690: aload_3
    //   691: aload_1
    //   692: getfield 2003	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   695: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   698: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   701: putfield 2006	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   704: iconst_m1
    //   705: istore 8
    //   707: iconst_m1
    //   708: istore 9
    //   710: aload_1
    //   711: getfield 2009	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   714: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   717: ifeq +21 -> 738
    //   720: aload_3
    //   721: aload_1
    //   722: getfield 2009	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   725: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   728: i2b
    //   729: putfield 2012	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   732: aload_3
    //   733: getfield 2012	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   736: istore 8
    //   738: aload_1
    //   739: getfield 2015	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   742: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   745: ifeq +21 -> 766
    //   748: aload_3
    //   749: aload_1
    //   750: getfield 2015	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   753: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   756: i2b
    //   757: putfield 2018	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   760: aload_3
    //   761: getfield 2018	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   764: istore 9
    //   766: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +47 -> 816
    //   772: ldc_w 1962
    //   775: iconst_2
    //   776: new 485	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   783: lload 12
    //   785: invokevirtual 1619	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   788: ldc_w 2020
    //   791: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: iload 8
    //   796: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   799: ldc_w 2022
    //   802: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: iload 9
    //   807: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: new 2024	kzy
    //   819: dup
    //   820: aload_0
    //   821: aload_2
    //   822: aload_3
    //   823: invokespecial 2027	kzy:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   826: bipush 8
    //   828: aconst_null
    //   829: iconst_0
    //   830: invokestatic 884	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   833: return
    //   834: astore_1
    //   835: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq -827 -> 11
    //   841: ldc_w 1962
    //   844: iconst_2
    //   845: aload_1
    //   846: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   849: invokestatic 2029	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: return
    //   853: aload_2
    //   854: astore_3
    //   855: aload_0
    //   856: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   859: iconst_2
    //   860: if_icmpne -723 -> 137
    //   863: aload_0
    //   864: ldc_w 2030
    //   867: iconst_1
    //   868: invokestatic 1934	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   871: aload_0
    //   872: invokevirtual 1937	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   875: invokevirtual 1940	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   878: pop
    //   879: aload_2
    //   880: astore_3
    //   881: goto -744 -> 137
    //   884: aload_2
    //   885: astore_3
    //   886: iload 10
    //   888: ifne -751 -> 137
    //   891: aload_2
    //   892: astore_3
    //   893: aload 4
    //   895: getfield 2034	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   898: invokevirtual 2037	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   901: ifeq -764 -> 137
    //   904: aload 4
    //   906: getfield 2034	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   909: invokevirtual 2040	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   912: checkcast 2036	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   915: astore 4
    //   917: aload 4
    //   919: astore_3
    //   920: aload 4
    //   922: ifnull -785 -> 137
    //   925: aload_0
    //   926: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   929: ifnull +903 -> 1832
    //   932: aload_0
    //   933: getfield 786	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   936: bipush 10
    //   938: aaload
    //   939: astore_2
    //   940: aload 4
    //   942: getfield 2043	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   945: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   948: ifeq +35 -> 983
    //   951: aload_0
    //   952: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   955: aload 4
    //   957: getfield 2043	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   960: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   963: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   966: putfield 347	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   969: aload_0
    //   970: getfield 1345	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   973: aload_0
    //   974: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   977: getfield 347	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   980: invokevirtual 825	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   983: aload_0
    //   984: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   987: aload 4
    //   989: getfield 2046	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   992: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   995: putfield 1430	com/tencent/mobileqq/troopinfo/TroopInfoData:nTroopGrade	I
    //   998: aload_0
    //   999: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1002: ifnull +17 -> 1019
    //   1005: aload_0
    //   1006: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1009: aload_0
    //   1010: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1013: getfield 1430	com/tencent/mobileqq/troopinfo/TroopInfoData:nTroopGrade	I
    //   1016: putfield 2047	com/tencent/mobileqq/data/TroopInfo:nTroopGrade	I
    //   1019: aload_0
    //   1020: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1023: aload 4
    //   1025: getfield 2050	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:rpt_tag_record	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1028: invokevirtual 1918	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1031: invokestatic 2054	com/tencent/mobileqq/data/TroopInfo:setTags	(Ljava/util/List;)Ljava/lang/String;
    //   1034: invokestatic 2058	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   1037: putfield 2061	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   1040: aload_0
    //   1041: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1044: aload 4
    //   1046: getfield 2064	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_active_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1049: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1052: putfield 2067	com/tencent/mobileqq/troopinfo/TroopInfoData:nActiveMemberNum	I
    //   1055: aload_0
    //   1056: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1059: aload 4
    //   1061: getfield 2070	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1064: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1067: i2l
    //   1068: putfield 2073	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupFlagExt	J
    //   1071: aload_0
    //   1072: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1075: aload 4
    //   1077: getfield 2076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_certification_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1080: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1083: i2l
    //   1084: putfield 2079	com/tencent/mobileqq/troopinfo/TroopInfoData:dwAuthGroupType	J
    //   1087: aload_0
    //   1088: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1091: aload 4
    //   1093: getfield 2082	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1096: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1099: i2l
    //   1100: putfield 1477	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   1103: aload_0
    //   1104: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1107: aload 4
    //   1109: getfield 2085	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1112: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1115: putfield 1486	com/tencent/mobileqq/troopinfo/TroopInfoData:wMemberNum	I
    //   1118: aload_0
    //   1119: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1122: aload 4
    //   1124: getfield 2088	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1127: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1130: putfield 2091	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTypeExt	I
    //   1133: aload_0
    //   1134: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1137: aload 4
    //   1139: getfield 2094	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1142: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1145: putfield 1638	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopPrivilegeFlag	I
    //   1148: aload_0
    //   1149: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1152: aload 4
    //   1154: getfield 2097	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_subscription_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1157: invokevirtual 1979	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1160: putfield 2100	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   1163: aload 4
    //   1165: getfield 2104	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   1168: invokevirtual 2107	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:has	()Z
    //   1171: ifeq +40 -> 1211
    //   1174: aload 4
    //   1176: getfield 2104	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   1179: getfield 2110	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1182: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1185: ifeq +26 -> 1211
    //   1188: aload_0
    //   1189: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1192: aload 4
    //   1194: getfield 2104	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   1197: getfield 2110	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1200: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1203: i2f
    //   1204: ldc_w 2111
    //   1207: fmul
    //   1208: putfield 1692	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopNeedPayNumber	F
    //   1211: aload_0
    //   1212: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1215: ifnull +61 -> 1276
    //   1218: aload_0
    //   1219: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1222: aload_0
    //   1223: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1226: getfield 1692	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopNeedPayNumber	F
    //   1229: putfield 2112	com/tencent/mobileqq/data/TroopInfo:mTroopNeedPayNumber	F
    //   1232: aload_0
    //   1233: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1236: aload_0
    //   1237: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1240: getfield 1638	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopPrivilegeFlag	I
    //   1243: i2l
    //   1244: putfield 1596	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   1247: aload_0
    //   1248: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1251: aload_0
    //   1252: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1255: getfield 1638	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopPrivilegeFlag	I
    //   1258: i2l
    //   1259: putfield 2115	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   1262: aload_0
    //   1263: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1266: aload_0
    //   1267: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1270: getfield 2100	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   1273: putfield 1044	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   1276: aload_0
    //   1277: invokevirtual 2117	com/tencent/mobileqq/activity/ChatSettingForTroop:u	()V
    //   1280: aload_0
    //   1281: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1284: aload_0
    //   1285: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1288: getfield 2100	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   1291: new 2119	kzv
    //   1294: dup
    //   1295: aload_0
    //   1296: invokespecial 2120	kzv:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   1299: invokestatic 2125	com/tencent/mobileqq/troop/utils/TroopBindPubAccountProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLcom/tencent/biz/ProtoUtils$TroopProtocolObserver;)V
    //   1302: aload 4
    //   1304: getfield 2128	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1307: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1310: ifeq +42 -> 1352
    //   1313: aload_0
    //   1314: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1317: aload 4
    //   1319: getfield 2128	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1322: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1325: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1328: putfield 2131	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopClassExtText	Ljava/lang/String;
    //   1331: aload_0
    //   1332: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1335: ifnull +17 -> 1352
    //   1338: aload_0
    //   1339: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1342: aload_0
    //   1343: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1346: getfield 2131	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopClassExtText	Ljava/lang/String;
    //   1349: putfield 2134	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   1352: new 2136	kzw
    //   1355: dup
    //   1356: aload_0
    //   1357: invokespecial 2137	kzw:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   1360: bipush 8
    //   1362: aconst_null
    //   1363: iconst_1
    //   1364: invokestatic 884	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1367: aload 4
    //   1369: getfield 2141	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   1372: invokevirtual 2144	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1375: checkcast 2143	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   1378: astore_2
    //   1379: aload_2
    //   1380: getfield 2147	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1383: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1386: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1389: astore_3
    //   1390: aload_2
    //   1391: getfield 2151	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1394: invokevirtual 2154	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1397: l2i
    //   1398: istore 10
    //   1400: aload_2
    //   1401: getfield 2157	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1404: invokevirtual 2154	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1407: l2i
    //   1408: istore 11
    //   1410: aload_3
    //   1411: invokestatic 341	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1414: ifne +11 -> 1425
    //   1417: aload_0
    //   1418: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1421: aload_3
    //   1422: putfield 1441	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   1425: iload 10
    //   1427: ifeq +12 -> 1439
    //   1430: aload_0
    //   1431: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1434: iload 10
    //   1436: putfield 2160	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   1439: iload 11
    //   1441: ifeq +12 -> 1453
    //   1444: aload_0
    //   1445: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1448: iload 11
    //   1450: putfield 2163	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   1453: aload_2
    //   1454: getfield 2166	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:uint32_cityid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1457: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1460: ifeq +17 -> 1477
    //   1463: aload_0
    //   1464: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1467: aload_2
    //   1468: getfield 2166	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:uint32_cityid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1471: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1474: putfield 2169	com/tencent/mobileqq/troopinfo/TroopInfoData:cityId	I
    //   1477: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1480: ifeq +58 -> 1538
    //   1483: ldc_w 2171
    //   1486: iconst_2
    //   1487: new 485	java/lang/StringBuilder
    //   1490: dup
    //   1491: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   1494: ldc_w 2173
    //   1497: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: aload_0
    //   1501: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1504: getfield 2169	com/tencent/mobileqq/troopinfo/TroopInfoData:cityId	I
    //   1507: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1510: ldc_w 2175
    //   1513: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: iload 10
    //   1518: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1521: ldc_w 2177
    //   1524: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: iload 11
    //   1529: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1532: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1535: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1538: aload_0
    //   1539: invokevirtual 2179	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   1542: aload 4
    //   1544: getfield 2182	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1547: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1550: ifeq +506 -> 2056
    //   1553: aload_0
    //   1554: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1557: aload 4
    //   1559: getfield 2182	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1562: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1565: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1568: putfield 2185	com/tencent/mobileqq/troopinfo/TroopInfoData:troopIntro	Ljava/lang/String;
    //   1571: aload 4
    //   1573: getfield 2188	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1576: invokevirtual 1904	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1579: ifeq +490 -> 2069
    //   1582: aload_0
    //   1583: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1586: aload 4
    //   1588: getfield 2188	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1591: invokevirtual 1907	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1594: invokevirtual 1997	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1597: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1600: aload_0
    //   1601: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1604: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1607: invokestatic 341	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1610: ifeq +472 -> 2082
    //   1613: aload_0
    //   1614: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1617: aload_0
    //   1618: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1621: getfield 2185	com/tencent/mobileqq/troopinfo/TroopInfoData:troopIntro	Ljava/lang/String;
    //   1624: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1627: aload_0
    //   1628: getfield 786	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1631: bipush 13
    //   1633: aaload
    //   1634: astore 7
    //   1636: aload 7
    //   1638: ifnull +129 -> 1767
    //   1641: aload 4
    //   1643: getfield 2191	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1646: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1649: ifeq +42 -> 1691
    //   1652: aload_0
    //   1653: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1656: ifnull +19 -> 1675
    //   1659: aload_0
    //   1660: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1663: aload 4
    //   1665: getfield 2191	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1668: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1671: i2l
    //   1672: putfield 2194	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   1675: aload_0
    //   1676: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1679: aload 4
    //   1681: getfield 2191	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1684: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1687: i2l
    //   1688: putfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopCreateTime	J
    //   1691: aload_0
    //   1692: aload_0
    //   1693: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1696: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:mTroopCreateTime	J
    //   1699: invokevirtual 1606	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(J)Ljava/lang/String;
    //   1702: astore_3
    //   1703: aload_3
    //   1704: astore_2
    //   1705: aload_0
    //   1706: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1709: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1712: invokestatic 341	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1715: ifne +34 -> 1749
    //   1718: new 485	java/lang/StringBuilder
    //   1721: dup
    //   1722: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   1725: aload_3
    //   1726: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: ldc_w 1611
    //   1732: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: aload_0
    //   1736: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1739: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1742: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: astore_2
    //   1749: aload_0
    //   1750: bipush 13
    //   1752: iconst_0
    //   1753: aload 7
    //   1755: aload_0
    //   1756: ldc_w 1612
    //   1759: invokevirtual 815	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1762: aload_2
    //   1763: iconst_0
    //   1764: invokevirtual 1614	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1767: aload_0
    //   1768: invokevirtual 2196	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   1771: aload 4
    //   1773: getfield 2070	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1776: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1779: ifeq +18 -> 1797
    //   1782: aload_0
    //   1783: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1786: aload 4
    //   1788: getfield 2070	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1791: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1794: putfield 2199	com/tencent/mobileqq/troopinfo/TroopInfoData:nGroupFlagExt	I
    //   1797: aload_0
    //   1798: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1801: ifnull +31 -> 1832
    //   1804: aload_0
    //   1805: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1808: aload_0
    //   1809: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1812: getfield 2185	com/tencent/mobileqq/troopinfo/TroopInfoData:troopIntro	Ljava/lang/String;
    //   1815: putfield 2202	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   1818: aload_0
    //   1819: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1822: aload_0
    //   1823: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1826: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   1829: putfield 2203	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   1832: aload 4
    //   1834: getfield 2206	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1837: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1840: ifeq +93 -> 1933
    //   1843: aload 4
    //   1845: getfield 2206	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1848: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1851: ifle +82 -> 1933
    //   1854: aload 4
    //   1856: getfield 2085	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1859: invokevirtual 1986	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1862: ifeq +71 -> 1933
    //   1865: aload 4
    //   1867: getfield 2085	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1870: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1873: ifle +60 -> 1933
    //   1876: aload_0
    //   1877: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1880: ifnull +33 -> 1913
    //   1883: aload_0
    //   1884: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1887: aload 4
    //   1889: getfield 2206	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1892: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1895: putfield 2209	com/tencent/mobileqq/data/TroopInfo:wMemberMax	I
    //   1898: aload_0
    //   1899: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1902: aload 4
    //   1904: getfield 2085	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1907: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1910: putfield 2210	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1913: aload_0
    //   1914: aload 4
    //   1916: getfield 2085	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1919: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1922: aload 4
    //   1924: getfield 2206	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1927: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1930: invokevirtual 2211	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   1933: aload_0
    //   1934: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1937: ifnull +50 -> 1987
    //   1940: aload_0
    //   1941: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1944: aload 4
    //   1946: getfield 2070	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1949: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1952: i2l
    //   1953: putfield 2212	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   1956: aload_0
    //   1957: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1960: aload 4
    //   1962: getfield 2088	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1965: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1968: putfield 2213	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   1971: aload_0
    //   1972: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1975: aload 4
    //   1977: getfield 2216	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1980: invokevirtual 813	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1983: i2l
    //   1984: putfield 2219	com/tencent/mobileqq/data/TroopInfo:dwGroupFlag	J
    //   1987: aload_0
    //   1988: invokevirtual 1450	com/tencent/mobileqq/activity/ChatSettingForTroop:r	()V
    //   1991: aload 4
    //   1993: getfield 2222	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1996: invokevirtual 1970	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1999: ifeq +37 -> 2036
    //   2002: aload_0
    //   2003: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2006: new 485	java/lang/StringBuilder
    //   2009: dup
    //   2010: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   2013: ldc_w 318
    //   2016: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: aload 4
    //   2021: getfield 2222	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2024: invokevirtual 1979	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2027: invokevirtual 1619	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2030: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2033: putfield 2225	com/tencent/mobileqq/troopinfo/TroopInfoData:troopowneruin	Ljava/lang/String;
    //   2036: aload 4
    //   2038: astore_3
    //   2039: aload_0
    //   2040: getfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   2043: ifnull -1906 -> 137
    //   2046: aload_0
    //   2047: invokevirtual 2227	com/tencent/mobileqq/activity/ChatSettingForTroop:q	()V
    //   2050: aload 4
    //   2052: astore_3
    //   2053: goto -1916 -> 137
    //   2056: aload_0
    //   2057: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2060: ldc_w 318
    //   2063: putfield 2185	com/tencent/mobileqq/troopinfo/TroopInfoData:troopIntro	Ljava/lang/String;
    //   2066: goto -495 -> 1571
    //   2069: aload_0
    //   2070: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2073: ldc_w 318
    //   2076: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   2079: goto -479 -> 1600
    //   2082: aload_0
    //   2083: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2086: aload_0
    //   2087: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2090: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   2093: invokestatic 2232	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2096: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   2099: aload_0
    //   2100: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2103: aload_0
    //   2104: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2107: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   2110: invokestatic 2234	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2113: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   2116: goto -489 -> 1627
    //   2119: astore_2
    //   2120: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2123: ifeq -1715 -> 408
    //   2126: ldc_w 1948
    //   2129: iconst_2
    //   2130: aload_2
    //   2131: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   2134: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2137: goto -1729 -> 408
    //   2140: aload 4
    //   2142: invokeinterface 1925 1 0
    //   2147: istore 8
    //   2149: goto -1618 -> 531
    //   2152: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2155: ifeq -1501 -> 654
    //   2158: ldc_w 1962
    //   2161: iconst_2
    //   2162: ldc_w 2236
    //   2165: invokestatic 518	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2168: goto -1514 -> 654
    //   2171: astore 4
    //   2173: goto -1469 -> 704
    //   2176: astore 4
    //   2178: goto -1499 -> 679
    //   2181: iconst_0
    //   2182: istore 9
    //   2184: goto -2079 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2187	0	this	ChatSettingForTroop
    //   0	2187	1	paramBatchResponse	KQQ.BatchResponse
    //   68	239	2	localObject1	Object
    //   311	12	2	localException1	Exception
    //   364	1399	2	localObject2	Object
    //   2119	12	2	localException2	Exception
    //   76	1977	3	localObject3	Object
    //   128	2013	4	localObject4	Object
    //   2171	1	4	localException3	Exception
    //   2176	1	4	localException4	Exception
    //   19	430	5	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    //   92	63	6	localList	List
    //   1634	120	7	localView	View
    //   100	2048	8	i1	int
    //   109	2074	9	i2	int
    //   174	1343	10	i3	int
    //   1408	120	11	i4	int
    //   572	212	12	l1	long
    // Exception table:
    //   from	to	target	type
    //   21	34	148	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   69	83	311	java/lang/Exception
    //   85	94	311	java/lang/Exception
    //   116	130	311	java/lang/Exception
    //   154	163	311	java/lang/Exception
    //   166	176	311	java/lang/Exception
    //   188	206	311	java/lang/Exception
    //   206	235	311	java/lang/Exception
    //   239	250	311	java/lang/Exception
    //   250	306	311	java/lang/Exception
    //   855	879	311	java/lang/Exception
    //   893	917	311	java/lang/Exception
    //   925	983	311	java/lang/Exception
    //   983	1019	311	java/lang/Exception
    //   1019	1211	311	java/lang/Exception
    //   1211	1276	311	java/lang/Exception
    //   1276	1352	311	java/lang/Exception
    //   1352	1425	311	java/lang/Exception
    //   1430	1439	311	java/lang/Exception
    //   1444	1453	311	java/lang/Exception
    //   1453	1477	311	java/lang/Exception
    //   1477	1538	311	java/lang/Exception
    //   1538	1571	311	java/lang/Exception
    //   1571	1600	311	java/lang/Exception
    //   1600	1627	311	java/lang/Exception
    //   1627	1636	311	java/lang/Exception
    //   1641	1675	311	java/lang/Exception
    //   1675	1691	311	java/lang/Exception
    //   1691	1703	311	java/lang/Exception
    //   1705	1749	311	java/lang/Exception
    //   1749	1767	311	java/lang/Exception
    //   1767	1797	311	java/lang/Exception
    //   1797	1832	311	java/lang/Exception
    //   1832	1913	311	java/lang/Exception
    //   1913	1933	311	java/lang/Exception
    //   1933	1987	311	java/lang/Exception
    //   1987	2036	311	java/lang/Exception
    //   2039	2050	311	java/lang/Exception
    //   2056	2066	311	java/lang/Exception
    //   2069	2079	311	java/lang/Exception
    //   2082	2116	311	java/lang/Exception
    //   460	523	834	java/lang/Exception
    //   531	547	834	java/lang/Exception
    //   552	584	834	java/lang/Exception
    //   588	654	834	java/lang/Exception
    //   654	660	834	java/lang/Exception
    //   679	685	834	java/lang/Exception
    //   710	738	834	java/lang/Exception
    //   738	766	834	java/lang/Exception
    //   766	816	834	java/lang/Exception
    //   816	833	834	java/lang/Exception
    //   2140	2149	834	java/lang/Exception
    //   2152	2168	834	java/lang/Exception
    //   365	408	2119	java/lang/Exception
    //   690	704	2171	java/lang/Exception
    //   665	679	2176	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302588));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302589));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302590));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302591));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302592));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302593));
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_e_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_f_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_g_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = getResources().getDimensionPixelOffset(2131493156);
    int i3 = getResources().getDimensionPixelOffset(2131493157);
    int i2 = getResources().getDimensionPixelOffset(2131493162);
    i3 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - DisplayUtil.a(this, 10.0F) * 2;
    int i4 = getResources().getDimensionPixelOffset(2131493161);
    i1 = (int)Math.floor((i3 - i2 * 6) / i4);
    if (i1 > 6) {
      i1 = 6;
    }
    for (;;)
    {
      i4 += (i3 - i1 * i2 - i1 * i4) / i1;
      i3 = paramList.size();
      i2 = 0;
      ImageView localImageView;
      Object localObject;
      long l1;
      if (i2 < i1 - 1)
      {
        localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i2);
        if (i2 < i3)
        {
          localObject = (oidb_0x899.memberlist)paramList.get(i2);
          if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {}
        }
        for (;;)
        {
          i2 += 1;
          break;
          l1 = ((oidb_0x899.memberlist)localObject).uint64_member_uin.get();
          localImageView.setVisibility(0);
          localImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 1, Long.toString(l1)));
          localImageView.setTag(Long.toString(l1));
          localObject = localImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i4;
          ((ViewGroup.LayoutParams)localObject).width = i4;
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          continue;
          localImageView.setVisibility(4);
        }
      }
      if (i3 < i1 - 1)
      {
        ((ImageView)this.jdField_b_of_type_JavaUtilList.get(i1 - 1)).setVisibility(4);
        localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i3);
        label323:
        localObject = localImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i4;
        ((ViewGroup.LayoutParams)localObject).width = i4;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localImageView.setVisibility(0);
        if ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
          break label578;
        }
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label539;
        }
        i1 = 1;
        label405:
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3) || (i1 != 0))) {
          break label545;
        }
        localImageView.setVisibility(8);
      }
      for (;;)
      {
        label464:
        if (i3 > 0)
        {
          if ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
            break label661;
          }
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
          label494:
          if (paramList == null) {
            break label683;
          }
          paramList = (LinearLayout)paramList.findViewById(2131302587);
          if (paramList == null) {
            break;
          }
          paramList.setVisibility(0);
          return;
          localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i1 - 1);
          break label323;
          label539:
          i1 = 0;
          break label405;
          label545:
          localImageView.setBackgroundResource(2130839767);
          localImageView.setContentDescription(super.getString(2131365021));
          localImageView.setOnClickListener(new kze(this));
          continue;
          label578:
          if (i1 - 1 >= i3) {
            break label685;
          }
        }
      }
      label661:
      label683:
      label685:
      for (paramList = (oidb_0x899.memberlist)paramList.get(i1 - 1);; paramList = null)
      {
        if ((paramList != null) && (paramList.uint64_member_uin.has()))
        {
          l1 = paramList.uint64_member_uin.get();
          localImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 1, Long.toString(l1)));
          localImageView.setTag(Long.toString(l1));
          break label464;
        }
        localImageView.setVisibility(4);
        break label464;
        break;
        if (this.ap == 2)
        {
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
          break label494;
        }
        paramList = null;
        break label494;
        break;
      }
    }
  }
  
  public void a(Oidb_0x5be.RspBody paramRspBody)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (paramRspBody == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: respBody == null");
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    List localList = paramRspBody.rpt_appinfo_list.get();
    if (paramRspBody.opt_bytes_more_app_url.has()) {}
    for (String str = paramRspBody.opt_bytes_more_app_url.get().toStringUtf8();; str = "")
    {
      if ((localList == null) || (localList.size() == 0))
      {
        localView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
        return;
      }
      if (localList.size() <= 4)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 4");
        }
        localView.findViewById(2131299575).setVisibility(8);
      }
      if ((localList.size() == 8) && (!TextUtils.isEmpty(str)))
      {
        localList.remove(7);
        paramRspBody = new Oidb_0x5be.AppInfo();
        paramRspBody.bytes_url.set(ByteStringMicro.copyFromUtf8(str));
        paramRspBody.uint32_open_type.set(1);
        paramRspBody.int32_unread_num.set(0);
        paramRspBody.uint64_appid.set(0L);
        paramRspBody.bytes_app_name.set(ByteStringMicro.copyFromUtf8(getResources().getString(2131368194)));
        localList.add(paramRspBody);
      }
      int i1 = 0;
      while (i1 < localList.size()) {
        switch (i1)
        {
        default: 
          i1 += 1;
        }
      }
      paramRspBody = localView.findViewById(2131299571);
      label325:
      ImageView localImageView = (ImageView)paramRspBody.findViewById(2131299820);
      Object localObject = (TextView)paramRspBody.findViewById(2131300632);
      TextView localTextView = (TextView)paramRspBody.findViewById(2131300631);
      Oidb_0x5be.AppInfo localAppInfo = (Oidb_0x5be.AppInfo)localList.get(i1);
      ((TextView)localObject).setText(localAppInfo.bytes_app_name.get().toStringUtf8());
      int i2 = localAppInfo.int32_unread_num.get();
      if (i2 == -1)
      {
        localTextView.setVisibility(0);
        localTextView.setText("");
        localTextView.setBackgroundResource(0);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130843321, 0, 0, 0);
        label438:
        localObject = localAppInfo.bytes_icon.get().toStringUtf8();
        if ((i1 != 7) || (TextUtils.isEmpty(str))) {
          break label752;
        }
        localImageView.setImageResource(2130840157);
        label473:
        paramRspBody.setVisibility(0);
        paramRspBody.setTag(localAppInfo);
        paramRspBody.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (localAppInfo.uint64_appid.get() == 1105324038L)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label840;
          }
          paramRspBody = "1";
        }
      }
      for (;;)
      {
        ReportController.b(this.app, "dc00899", "Grp_calendar", "", "set", "exp_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", paramRspBody, "");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_data_appEntry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "" + localAppInfo.uint64_appid.get());
        break;
        paramRspBody = localView.findViewById(2131299572);
        break label325;
        paramRspBody = localView.findViewById(2131299573);
        break label325;
        paramRspBody = localView.findViewById(2131299574);
        break label325;
        paramRspBody = localView.findViewById(2131299576);
        break label325;
        paramRspBody = localView.findViewById(2131299577);
        break label325;
        paramRspBody = localView.findViewById(2131299578);
        break label325;
        paramRspBody = localView.findViewById(2131299579);
        break label325;
        if (i2 > 0)
        {
          localTextView.setVisibility(0);
          localTextView.setText(String.valueOf(i2));
          localTextView.setBackgroundResource(2130843325);
          break label438;
        }
        localTextView.setVisibility(8);
        break label438;
        label752:
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localImageView.setImageResource(2130840087);
          break label473;
        }
        try
        {
          i2 = AIOUtils.a(40.0F, getResources());
          localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, i2, i2, getResources().getDrawable(2130840087), getResources().getDrawable(2130840087)));
        }
        catch (Exception localException)
        {
          localImageView.setImageDrawable(getResources().getDrawable(2130840087));
        }
        break label473;
        label840:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          paramRspBody = "2";
        } else {
          paramRspBody = "3";
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
    }
    View localView;
    do
    {
      do
      {
        return;
      } while ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
    } while (localView == null);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_b_of_type_Boolean))
    {
      if ((!localView.isShown()) || (localView.getVisibility() == 8)) {
        localView.setVisibility(0);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130840146);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].getBackground().setAlpha(229);
      return;
    }
    if ((localView.isShown()) || (localView.getVisibility() == 0)) {
      localView.setVisibility(8);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130840145);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].getBackground().setAlpha(229);
  }
  
  /* Error */
  protected boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 55
    //   11: iconst_2
    //   12: ldc_w 2409
    //   15: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: ifnonnull +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 2411	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 2413	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Boolean	Z
    //   37: aload_0
    //   38: invokevirtual 384	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   41: invokevirtual 1782	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   49: aload_1
    //   50: ldc_w 1138
    //   53: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   63: aload_1
    //   64: ldc_w 2417
    //   67: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 2420	com/tencent/mobileqq/troopinfo/TroopInfoData:troopCode	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_1
    //   75: ldc_w 676
    //   78: iconst_1
    //   79: invokevirtual 2424	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   82: putfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 2426
    //   90: invokevirtual 2428	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   93: putfield 332	com/tencent/mobileqq/activity/ChatSettingForTroop:ar	I
    //   96: aload_0
    //   97: aload_1
    //   98: ldc_w 2430
    //   101: iconst_m1
    //   102: invokevirtual 2424	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   105: putfield 271	com/tencent/mobileqq/activity/ChatSettingForTroop:ax	I
    //   108: aload_0
    //   109: aload_1
    //   110: ldc_w 2432
    //   113: bipush 99
    //   115: invokevirtual 2424	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   118: putfield 839	com/tencent/mobileqq/activity/ChatSettingForTroop:ay	I
    //   121: aload_0
    //   122: aload_1
    //   123: ldc_w 2434
    //   126: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   136: getfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   139: invokestatic 710	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   142: lstore_2
    //   143: lload_2
    //   144: lconst_0
    //   145: lcmp
    //   146: ifle -121 -> 25
    //   149: aload_0
    //   150: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   153: aload_1
    //   154: ldc_w 2436
    //   157: invokevirtual 2428	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   160: putfield 1172	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   163: aload_0
    //   164: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   167: aload_1
    //   168: ldc_w 2438
    //   171: invokevirtual 2428	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   174: putfield 2441	com/tencent/mobileqq/troopinfo/TroopInfoData:nStatOption	I
    //   177: aload_0
    //   178: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   181: aload_1
    //   182: ldc_w 2443
    //   185: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: putfield 335	com/tencent/mobileqq/troopinfo/TroopInfoData:remark	Ljava/lang/String;
    //   191: aload_0
    //   192: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   195: aload_1
    //   196: ldc_w 2445
    //   199: invokevirtual 2447	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   202: putfield 1077	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   205: aload_0
    //   206: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   209: aload_1
    //   210: ldc_w 2449
    //   213: invokevirtual 2453	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   216: putfield 2456	com/tencent/mobileqq/troopinfo/TroopInfoData:troopface	S
    //   219: aload_0
    //   220: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   223: aload_1
    //   224: ldc_w 2458
    //   227: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: putfield 347	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   233: aload_0
    //   234: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   237: aload_1
    //   238: ldc_w 2460
    //   241: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: putfield 2225	com/tencent/mobileqq/troopinfo/TroopInfoData:troopowneruin	Ljava/lang/String;
    //   247: aload_0
    //   248: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   251: aload_1
    //   252: ldc_w 2462
    //   255: invokevirtual 2465	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   258: putfield 1477	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   261: aload_0
    //   262: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   265: aload_1
    //   266: ldc_w 2467
    //   269: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: putfield 1441	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   275: aload_0
    //   276: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   279: aload_1
    //   280: ldc_w 2469
    //   283: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   289: aload_0
    //   290: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   293: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   296: invokestatic 341	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifne +37 -> 336
    //   302: aload_0
    //   303: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   306: aload_0
    //   307: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   310: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   313: invokestatic 2232	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   316: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   323: aload_0
    //   324: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   327: getfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   330: invokestatic 2234	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   333: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   336: aload_0
    //   337: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   340: aload_1
    //   341: ldc_w 2471
    //   344: invokevirtual 2475	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   347: i2s
    //   348: putfield 326	com/tencent/mobileqq/troopinfo/TroopInfoData:cGroupOption	S
    //   351: aload_0
    //   352: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   355: aload_0
    //   356: aload_0
    //   357: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   360: getfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   363: invokestatic 2480	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   366: putfield 350	com/tencent/mobileqq/troopinfo/TroopInfoData:mStrJoinQuestion	Ljava/lang/String;
    //   369: aload_0
    //   370: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   373: aload_1
    //   374: ldc_w 2482
    //   377: invokevirtual 2428	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   380: putfield 1430	com/tencent/mobileqq/troopinfo/TroopInfoData:nTroopGrade	I
    //   383: aload_0
    //   384: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   387: aload_0
    //   388: aload_0
    //   389: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   392: getfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   395: invokestatic 2484	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   398: putfield 353	com/tencent/mobileqq/troopinfo/TroopInfoData:mStrJoinAnswer	Ljava/lang/String;
    //   401: aload_0
    //   402: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   405: aload_1
    //   406: ldc_w 2486
    //   409: invokevirtual 2465	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   412: putfield 2073	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupFlagExt	J
    //   415: aload_0
    //   416: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   419: aload_1
    //   420: ldc_w 2488
    //   423: invokevirtual 2465	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   426: putfield 2079	com/tencent/mobileqq/troopinfo/TroopInfoData:dwAuthGroupType	J
    //   429: aload_0
    //   430: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   433: aload_1
    //   434: ldc_w 2490
    //   437: invokevirtual 2415	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: invokestatic 2058	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   443: putfield 2061	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   446: aload_0
    //   447: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   450: bipush 51
    //   452: invokevirtual 751	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   455: checkcast 1066	com/tencent/mobileqq/app/TroopManager
    //   458: astore_1
    //   459: aload_1
    //   460: ifnull +51 -> 511
    //   463: aload_1
    //   464: aload_0
    //   465: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   468: getfield 344	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   471: invokevirtual 1072	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   474: astore_1
    //   475: aload_1
    //   476: ifnull +35 -> 511
    //   479: aload_0
    //   480: aload_1
    //   481: putfield 962	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   484: aload_0
    //   485: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   488: iconst_1
    //   489: putfield 1077	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   492: aload_0
    //   493: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   496: aload_1
    //   497: aload_0
    //   498: invokevirtual 1203	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   501: aload_0
    //   502: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   505: invokevirtual 557	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   508: invokevirtual 2494	com/tencent/mobileqq/troopinfo/TroopInfoData:updateForTroopChatSetting	(Lcom/tencent/mobileqq/data/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   511: aload_0
    //   512: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   515: iconst_m1
    //   516: if_icmpne +25 -> 541
    //   519: aload_0
    //   520: getfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   523: getfield 1077	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   526: ifeq +10 -> 536
    //   529: aload_0
    //   530: iconst_1
    //   531: putfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   534: iconst_1
    //   535: ireturn
    //   536: aload_0
    //   537: iconst_2
    //   538: putfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   541: iconst_1
    //   542: ireturn
    //   543: astore_1
    //   544: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +13 -> 560
    //   550: ldc 55
    //   552: iconst_2
    //   553: aload_1
    //   554: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   557: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_0
    //   561: getfield 553	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   564: bipush 69
    //   566: invokestatic 1115	com/tencent/biz/common/report/BnrReport:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   569: iload 4
    //   571: ireturn
    //   572: astore_1
    //   573: iconst_1
    //   574: istore 4
    //   576: goto -32 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	ChatSettingForTroop
    //   44	453	1	localObject	Object
    //   543	11	1	localException1	Exception
    //   572	1	1	localException2	Exception
    //   142	2	2	l1	long
    //   1	574	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   27	143	543	java/lang/Exception
    //   149	336	572	java/lang/Exception
    //   336	459	572	java/lang/Exception
    //   463	475	572	java/lang/Exception
    //   479	511	572	java/lang/Exception
    //   511	534	572	java/lang/Exception
    //   536	541	572	java/lang/Exception
  }
  
  protected void b()
  {
    Object localObject1 = ((TroopManager)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      Object localObject2 = ((TroopInfo)localObject1).mTroopPicList;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.c = str;
            if (localAvatarInfo.c.equals(AvatarWallAdapter.AvatarInfo.a)) {}
            for (localAvatarInfo.jdField_d_of_type_JavaLangString = "SYSTEM_PHOTO";; localAvatarInfo.jdField_d_of_type_JavaLangString = "AVATAR_URL_STR")
            {
              Set localSet = ((TroopInfo)localObject1).mTroopVerifyingPics;
              if (localSet != null) {
                localAvatarInfo.jdField_b_of_type_Boolean = localSet.contains(str);
              }
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      localObject1 = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject1).c = AvatarWallAdapter.AvatarInfo.a;
      ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_d_of_type_JavaLangString = "SYSTEM_PHOTO";
      localArrayList.add(localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void b(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramView = (TextView)paramView.findViewById(2131297124);
    paramView.setEditableFactory(QQTextBuilder.a);
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramView.setFocusable(false);
      return;
      paramView.setVisibility(0);
      paramView.setText(new QQText(paramCharSequence, 11, 16));
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a(this.app, this, paramIntent, localIntent);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.publicAccountUin)
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[15].findViewById(2131300642);
      Drawable localDrawable = ImageUtil.a();
      localImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 105, String.valueOf(paramLong), 3, localDrawable, localDrawable));
    }
  }
  
  protected boolean b()
  {
    if (!TroopUtils.a(Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt))) {}
    for (;;)
    {
      return false;
      boolean bool = this.app.a().getSharedPreferences(this.app.a(), 0).getBoolean("Contacts_Mode_GuideTips_value", false);
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        Object localObject = (TroopManager)this.app.getManager(51);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null) {
            if (((TroopInfo)localObject).dwOfficeMode == 1L) {
              bool = true;
            }
          }
        }
        while (!bool)
        {
          return true;
          bool = false;
        }
      }
    }
  }
  
  public void c()
  {
    if (!NetworkUtil.h(getApplicationContext())) {}
    for (;;)
    {
      return;
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
      ArrayList localArrayList;
      if (localTroopHandler != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.a());
        localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localTroopHandler != null)
      {
        l();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localTroopHandler.a(localArrayList);
        }
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.app);
      v();
      if ((this.ap == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_MqqObserverBusinessObserver);
      }
      while (this.ap == 2)
      {
        c(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_c_of_type_MqqObserverBusinessObserver);
        return;
        a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_MqqObserverBusinessObserver);
      }
    }
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        l();
      }
    }
    ThreadManager.a(new kzz(this), 8, null, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = true;
        if (!this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838321);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131493207));
          ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
        }
        if (!NetworkUtil.h(getApplicationContext())) {
          QQToast.a(getApplicationContext(), 1, getString(2131369008), 1).b(getTitleBarHeight());
        }
        ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
        this.au = 30;
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
        this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new lau(this));
        localObject = new lav(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
      } while ((this.ap != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
      localObject = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    } while (localObject == null);
    try
    {
      Oidb_0x5be.RspBody localRspBody = new Oidb_0x5be.RspBody();
      localRspBody.mergeFrom((byte[])localObject);
      a(localRspBody);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException) {}
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    if (localTroopManager == null) {}
    for (paramIntent = null;; paramIntent = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.app.a(), getResources());
        a(0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
      }
      paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
      if ((paramIntent == null) || (localTroopManager == null)) {
        break;
      }
      ThreadManager.a(new laa(this, localTroopManager, paramIntent), 8, null, true);
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    switch (paramInt1)
    {
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
                a(paramInt2, paramIntent);
                return;
                if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("isNeedFinish", true);
                  setResult(-1, paramIntent);
                  finish();
                  return;
                }
              } while (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null);
              ThreadManager.a(new lac(this), 8, null, true);
              return;
              b(paramInt2, paramIntent);
              return;
            } while (paramInt2 != -1);
            setResult(-1);
            this.k = true;
            return;
            c(paramInt2, paramIntent);
            return;
            d(paramInt2, paramIntent);
            return;
            ((TroopHandler)this.app.a(20)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            return;
            f(paramInt2, paramIntent);
            return;
          } while ((paramInt2 != -1) || (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null));
          paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
          paramInt1 = ProfileCardUtil.a(this);
          PhotoUtils.a(new Intent(), this, ChatSettingForTroop.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
          return;
          e(paramInt2, paramIntent);
          return;
        } while ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1));
        paramIntent = paramIntent.getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
        k();
        return;
      } while (paramInt2 != -1);
      if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
      }
      finish();
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void doOnBackPressed()
  {
    C();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
            a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(30));
          a();
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
          }
          QZoneHelper.b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.ap != 1) {
            break label360;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            a("Grp_Admin_data", "Clk_data", "0");
            BnrReport.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            return true;
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        catch (InflateException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        a("Grp_Admin_data", "Clk_data", "1");
        continue;
        label360:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          a("Grp_Visdata", "Clk_data", "0");
        } else {
          a("Grp_Visdata", "Clk_data", "1");
        }
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 2784	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   5: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +295 -> 303
    //   11: invokestatic 1225	java/lang/System:currentTimeMillis	()J
    //   14: lstore_2
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 2411	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 291	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   31: invokevirtual 2788	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 296	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver	Lcom/tencent/mobileqq/app/BizTroopObserver;
    //   39: invokevirtual 2788	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 286	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   47: invokevirtual 2788	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   55: invokevirtual 2788	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   58: aload_0
    //   59: getfield 276	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   62: ifnull +11 -> 73
    //   65: aload_0
    //   66: getfield 276	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   69: aconst_null
    //   70: invokevirtual 2791	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 2600	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   77: ifnull +30 -> 107
    //   80: aload_0
    //   81: getfield 2600	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   84: checkcast 2609	android/graphics/drawable/Animatable
    //   87: invokeinterface 2794 1 0
    //   92: ifeq +15 -> 107
    //   95: aload_0
    //   96: getfield 2600	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   99: checkcast 2609	android/graphics/drawable/Animatable
    //   102: invokeinterface 2797 1 0
    //   107: aload_0
    //   108: getfield 2799	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   111: ifnull +10 -> 121
    //   114: aload_0
    //   115: getfield 2799	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   118: invokevirtual 2803	com/tencent/mobileqq/troopshare/TroopShareUtility:g	()V
    //   121: aload_0
    //   122: getfield 1408	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   125: ifnull +10 -> 135
    //   128: aload_0
    //   129: getfield 1408	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   132: invokevirtual 2805	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:d	()V
    //   135: aload_0
    //   136: invokestatic 2810	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/troopinfo/GroupCatalogTool;
    //   139: invokevirtual 2811	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	()V
    //   142: aload_0
    //   143: getfield 2813	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   146: ifnull +10 -> 156
    //   149: aload_0
    //   150: getfield 2813	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   153: invokevirtual 2818	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   156: aload_0
    //   157: getfield 1127	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   160: ifnull +10 -> 170
    //   163: aload_0
    //   164: getfield 1127	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   167: invokevirtual 2819	com/tencent/biz/helper/TroopCardAppInfoHelper:a	()V
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 242	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   175: invokevirtual 2823	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   178: aload_0
    //   179: invokespecial 2825	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   182: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +33 -> 218
    //   188: ldc 55
    //   190: iconst_2
    //   191: new 485	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 2827
    //   201: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokestatic 1225	java/lang/System:currentTimeMillis	()J
    //   207: lload_2
    //   208: lsub
    //   209: invokevirtual 1619	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: return
    //   219: astore_1
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    //   225: astore_1
    //   226: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -51 -> 178
    //   232: ldc 55
    //   234: iconst_2
    //   235: new 485	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 2829
    //   245: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 2830	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 2029	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -83 -> 178
    //   264: astore_1
    //   265: invokestatic 483	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -90 -> 178
    //   271: ldc 55
    //   273: iconst_2
    //   274: new 485	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 486	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 2829
    //   284: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_1
    //   288: invokevirtual 2831	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 2029	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: goto -122 -> 178
    //   303: lconst_0
    //   304: lstore_2
    //   305: goto -290 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ChatSettingForTroop
    //   219	5	1	localObject	Object
    //   225	24	1	localIllegalArgumentException	IllegalArgumentException
    //   264	24	1	localException	Exception
    //   14	291	2	l1	long
    // Exception table:
    //   from	to	target	type
    //   18	26	219	finally
    //   220	223	219	finally
    //   170	178	225	java/lang/IllegalArgumentException
    //   170	178	264	java/lang/Exception
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, this.jdField_a_of_type_MqqObserverAccountObserver);
      if (paramIntent != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
        this.jdField_g_of_type_Boolean = true;
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      TroopNotificationHelper.a(this.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_e_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_e_of_type_Boolean = true;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      return;
    }
    TroopAvatarManger.a = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_e_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    for (;;)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131298261);
      localObject = (TextView)((View)localObject).findViewById(2131300634);
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((TextView)localObject).setText(String.format(getResources().getString(2131367762), new Object[] { Integer.valueOf(i1) }));
      ((TextView)localObject).setContentDescription(String.format(getResources().getString(2131367762), new Object[] { Integer.valueOf(i1) }));
      return;
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    Object localObject1 = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject1, getResources(), this.app.a());
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    u();
    localObject1 = TroopInfoActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      ((View)localObject2).setVisibility(8);
      a(12, (View)localObject2, (ArrayList)localObject1, true, true);
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      localObject2 = (TextView)((View)localObject1).findViewById(2131297123);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) {
        break label449;
      }
      ((View)localObject1).setVisibility(8);
      label146:
      r();
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[18] != null)
      {
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label469;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[18].setVisibility(8);
      }
      label206:
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      b(13, 0, localView, getString(2131367744), (CharSequence)localObject1, false);
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.coverAdministrators(this.app, paramIntent.getExtras().getStringArrayList("param_admins"));
      paramIntent = paramIntent.getExtras().getStringArrayList("deleted_members");
      if (paramIntent == null) {
        break label523;
      }
      a(0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
      paramInt = paramIntent.size() - 1;
    }
    for (;;)
    {
      if (paramInt < 0) {
        break label523;
      }
      int i1 = this.jdField_c_of_type_JavaUtilList.size() - 1;
      label397:
      if (i1 >= 0)
      {
        localObject1 = (oidb_0x899.memberlist)this.jdField_c_of_type_JavaUtilList.get(i1);
        if ((localObject1 == null) || (!((oidb_0x899.memberlist)localObject1).uint64_member_uin.has())) {}
        label449:
        label469:
        while (!String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get()).equals(paramIntent.get(paramInt)))
        {
          i1 -= 1;
          break label397;
          ((View)localObject2).setVisibility(0);
          break;
          ((View)localObject1).setVisibility(0);
          ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
          break label146;
          this.jdField_a_of_type_ArrayOfAndroidViewView[18].setVisibility(0);
          break label206;
        }
        this.jdField_c_of_type_JavaUtilList.remove(i1);
      }
      paramInt -= 1;
    }
    label523:
    a(this.jdField_c_of_type_JavaUtilList);
  }
  
  public void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    if ((this.ap == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)) {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.ap != 1)) {
        break label95;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b();
      r();
      return;
      label95:
      bool = false;
    }
  }
  
  protected void f(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("del_list");
      if (localArrayList1 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ((localObject != null) && (AvatarTroopUtil.b((String)localObject)))
          {
            paramInt = Integer.parseInt((String)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).c != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).c))) {
              localArrayList2.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).c)));
            }
          }
        }
        if (localArrayList2.size() > 0)
        {
          a("Grp_Admin_data", "del_head", "");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2, localArrayList2);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList1);
      }
      paramInt = paramIntent.getIntExtra("default_avator_index", -1);
      if (paramInt != -1)
      {
        if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
        }
        QQToast.a(this, getString(2131369191), 1).b(getTitleBarHeight());
      }
    }
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.canInviteMember()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.a(), 0);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.a(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("title", getString(2131365071));
    localIntent.putExtra("default_text", str);
    localIntent.putExtra("isTroopNick", true);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("uin", this.app.getAccount());
    localIntent.putExtra("max_num", 60);
    localIntent.putExtra("from", 0);
    startActivityForResult(localIntent, 2);
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
  }
  
  protected void i()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    if (b())
    {
      this.app.a().getSharedPreferences(this.app.a(), 0).edit().putBoolean("Contacts_Mode_GuideTips_value", true).commit();
      ((Intent)localObject).putExtra("Show_Newer_GuideFlag_Of_ContactsMode", true);
    }
    startActivityForResult((Intent)localObject, 9);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject = "0";
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      localIntent = new Intent(this, NearbyTroopsLocationActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
      localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
      localIntent.putExtra("location_name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      localIntent.putExtra("from", 11);
      localIntent.putExtra("mode", 1);
      localIntent.putExtra("is_show_mapentry", false);
      localIntent.putExtra("selfSet_leftViewText", getString(2131367776));
      NearbyTroopsLocationActivity.a(this, this.app, localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      Intent localIntent;
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 14);
  }
  
  public void k()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localView = localView.findViewById(2131300637);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131297123)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
  }
  
  protected void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (localTroopHandler == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          if ((this.ap == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
              break label121;
            }
            localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, (byte)1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwTimeStamp, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.chatopttroop", 2, localException.toString());
    return;
    label121:
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  protected void m()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    super.startActivity(localIntent);
  }
  
  public void n()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void o()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      paramView = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!(paramView instanceof Integer))) {}
    }
    switch (((Integer)paramView).intValue())
    {
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 13: 
    case 22: 
    case 23: 
    default: 
    case 4: 
    case 0: 
    case 2: 
    case 1: 
    case 8: 
    case 21: 
    case 24: 
    case 19: 
    case 20: 
    case 3: 
    case 27: 
    case 25: 
    case 12: 
    case 16: 
    case 9: 
    case 17: 
    case 18: 
    case 26: 
    case 14: 
      label1152:
      label1434:
      do
      {
        do
        {
          do
          {
            do
            {
              int i1;
              do
              {
                return;
                paramView = paramView.getTag();
                break;
                h();
                return;
                i();
                a("Grp_Admin_data", "Clk_mber", "");
                return;
                g();
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
                for (i1 = 0;; i1 = 1)
                {
                  paramView = new Intent(this, PublicAccountBrowser.class);
                  paramView.putExtra("hide_operation_bar", true);
                  paramView.putExtra("hideRightButton", true);
                  paramView.putExtra("isScreenOrientationPortrait", true);
                  paramView.putExtra("uin", this.app.a());
                  paramView.putExtra("url", "http://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i1);
                  startActivity(paramView);
                  ReportController.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                  BnrReport.a(this.app, 72);
                  return;
                }
                x();
                return;
                w();
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                return;
                y();
              } while (this.ar != 2);
              ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              return;
              m();
              return;
              paramView = new Intent();
              paramView.putExtra("uin", this.app.a());
              paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              paramView.putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
              paramView.putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
              paramView.putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
              paramView.putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
              paramView.putExtra("leftViewText", getResources().getString(2131369484));
              localObject1 = TroopProxyActivity.a(this);
              localObject2 = new TroopManageCmd(this.app);
              localObject3 = PluginCommunicationHandler.getInstance();
              if (localObject3 != null) {
                ((PluginCommunicationHandler)localObject3).register((RemoteCommand)localObject2);
              }
              TroopManageProxyActivity.a("troop_manage_plugin.apk", "管理群", TroopManageProxyActivity.class, this, paramView, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.a(), 8);
              localObject1 = this.app;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
              for (paramView = "0";; paramView = "1")
              {
                ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject2, paramView, "", "");
                return;
              }
              ReportController.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              TroopNotificationUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              return;
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
              {
                z();
                return;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 19) {
                ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              }
              while (!NetworkUtil.e(this))
              {
                b(2131367481, 0);
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 18)
                {
                  ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 24)
                {
                  ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 17)
                {
                  ReportController.b(this.app, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                }
                else
                {
                  i1 = -1;
                  int i2;
                  switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa)
                  {
                  default: 
                    i2 = i1;
                    if (i1 == -1)
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption != 7) {
                        break label1434;
                      }
                      i2 = 3;
                    }
                    break;
                  }
                  for (;;)
                  {
                    i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
                    if (QLog.isDevelopLevel()) {
                      QLog.d("Q.chatopttroop", 4, "statOption=" + i1);
                    }
                    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.ay + "", "" + i1, this.ax + "");
                    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.ay + "", this.aU + "", "");
                    break;
                    i1 = 0;
                    break label1152;
                    i1 = 1;
                    break label1152;
                    i1 = 2;
                    break label1152;
                    i1 = 6;
                    break label1152;
                    i1 = 7;
                    break label1152;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 8)
                    {
                      i2 = 4;
                    }
                    else
                    {
                      i2 = i1;
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 36) {
                        i2 = 10;
                      }
                    }
                  }
                }
              }
              paramView = (TroopHandler)this.app.a(20);
            } while (paramView == null);
            try
            {
              long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              n();
              paramView.a(l1, 8390784);
              return;
            }
            catch (Exception paramView) {}
          } while (!QLog.isColorLevel());
          QLog.i("Q.chatopttroop", 2, paramView.toString());
          return;
          ThreadManager.a(new kzk(this, Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)), 8, null, true);
          a("Grp_Visdata", "nonmber_Clk_tag", "");
          BnrReport.a(this.app, 71);
          return;
          p();
          return;
          j();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
          a("Grp_Admin_data", "Clk_share", "");
          return;
          paramView = new Intent(this, Face2FaceAddFriendActivity.class);
          paramView.putExtra("activity_from_type", 1);
          paramView.putExtra("activity_troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          startActivity(paramView);
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "share_grp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "6.5.5", "", "");
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
        } while (paramView == null);
        Object localObject1 = new Intent();
        ((Intent)localObject1).setClass(this, TroopAvatarWallPreviewActivity.class);
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("index", 0);
        Object localObject3 = new ArrayList();
        if (((paramView.jdField_d_of_type_JavaLangString.equals("AVATAR_URL_STR")) || (paramView.jdField_d_of_type_JavaLangString.equals("SYSTEM_PHOTO"))) && (paramView.jdField_b_of_type_JavaLangString == null)) {
          ((ArrayList)localObject3).add(paramView.c);
        }
        for (;;)
        {
          ((Bundle)localObject2).putBoolean("IS_EDIT", false);
          ((Bundle)localObject2).putStringArrayList("seqNum", (ArrayList)localObject3);
          ((Bundle)localObject2).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          ((Bundle)localObject2).putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          startActivityForResult((Intent)localObject1, 12);
          return;
          ((ArrayList)localObject3).add(paramView.jdField_b_of_type_JavaLangString);
        }
      } while (TextUtils.isEmpty(this.n));
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("url", this.n);
      startActivity(paramView);
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_activity", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.ay + "", this.aU + "", "");
      return;
    }
    paramView = new Intent(this, AccountDetailActivity.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.publicAccountUin + "");
    startActivity(paramView);
    ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "entry_guest", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (;;)
    {
      return false;
      try
      {
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131305407, getString(2131369291));
        BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, new kzl(this), new kzm(this));
      }
      catch (WindowManager.BadTokenException paramView) {}
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, paramView.getMessage());
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void p()
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (oidb_0x899.memberlist)this.jdField_c_of_type_JavaUtilList.get(i1);
      if ((localObject == null) || (!((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {}
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList.add(String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()));
      }
    }
    Object localObject = new Intent(this, TroopAdminList.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    ((Intent)localObject).putStringArrayListExtra("troop_info_memo", localArrayList);
    ((Intent)localObject).putExtra("t_s_f", getIntent().getIntExtra("t_s_f", -1));
    startActivity((Intent)localObject);
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "updateTroopInfoToDB");
      }
      ThreadManager.a(new laf(this), 5, null, false);
    }
  }
  
  protected void r()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    for (;;)
    {
      return;
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131300636);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
      {
        localObject = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) {
          localObject = getResources().getDrawable(2130840068);
        }
        while (localObject != null)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L) {
            localObject = getResources().getDrawable(2130840069);
          }
        }
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      GroupCatalogTool.a(localContext).a(new ChatSettingForTroop.GetClassChoiceCallBack(localContext, str), localContext);
    }
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    label67:
    label103:
    label170:
    label248:
    do
    {
      for (;;)
      {
        return;
        Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
        Object localObject2;
        if (localObject1 != null) {
          if (((((AvatarWallAdapter.AvatarInfo)localObject1).jdField_d_of_type_JavaLangString.equals("AVATAR_URL_STR")) || (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_d_of_type_JavaLangString.equals("SYSTEM_PHOTO"))) && (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_JavaLangString == null))
          {
            localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).c;
            localObject2 = localObject1;
            if (AvatarTroopUtil.b((String)localObject1))
            {
              if ((localObject1 == null) || (!((String)localObject1).equals(AvatarWallAdapter.AvatarInfo.a))) {
                break label170;
              }
              localObject1 = AvatarTroopUtil.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
              localObject2 = AvatarTroopUtil.a((String)localObject1);
            }
          }
        }
        Bitmap localBitmap;
        try
        {
          localObject1 = Uri.parse((String)localObject2);
          localObject1 = ((Uri)localObject1).getScheme();
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((!((String)localObject1).equals("http")) && (!((String)localObject1).equals("https"))))
          {
            ThreadManager.a(new lah(this, (String)localObject2), 8, null, true);
            return;
            localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_JavaLangString;
            break label67;
            localObject1 = AvatarTroopUtil.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
            break label103;
          }
          try
          {
            localObject1 = new URL((String)localObject2);
            localObject1 = URLDrawable.getDrawable((URL)localObject1, URLDrawableHelper.e, null, true);
            if (((URLDrawable)localObject1).getStatus() != 1) {
              break label248;
            }
            try
            {
              localObject1 = ImageUtil.a((Drawable)localObject1);
              b(this, this.jdField_c_of_type_AndroidViewView, (Bitmap)localObject1);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              return;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (MalformedURLException localMalformedURLException) {}
          QLog.i("Q.chatopttroop", 2, localMalformedURLException.toString());
          return;
        }
        catch (NullPointerException localNullPointerException) {}
      }
      localMalformedURLException.setURLDrawableListener(new lai(this));
    } while (localMalformedURLException.getStatus() != 1);
    try
    {
      localBitmap = ImageUtil.a(localMalformedURLException);
      b(this, this.jdField_c_of_type_AndroidViewView, localBitmap);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError2) {}
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
      } while (localObject == null);
      localObject = (TextView)((View)localObject).findViewById(2131300633);
    } while (localObject == null);
    ((TextView)localObject).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
    {
      ((TextView)localObject).setVisibility(8);
      if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
        break label350;
      }
    }
    label350:
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (i1 == 0)) {
        break label355;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131369989, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(27));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[10].findViewById(2131300635)).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
      {
        ((TextView)localObject).setVisibility(8);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        ((TextView)localObject).setText("(" + getString(2131364266) + ")");
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        ((TextView)localObject).setText("(" + getString(2131364266) + ")");
        break;
      }
      ((TextView)localObject).setVisibility(8);
      return;
    }
    label355:
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[10].findViewById(2131300635)).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatSettingForTroop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
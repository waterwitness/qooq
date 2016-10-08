package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import mqr;
import mqs;
import mqt;
import mqu;
import mqv;
import mqw;
import mqx;
import mqy;
import mqz;
import mrb;
import mrc;
import mrd;
import mre;
import mrf;
import mrg;
import mrh;
import mri;
import mrj;
import mrk;
import mrl;
import mrm;
import mrn;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int A = 28;
  public static final int B = 29;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 0;
  public static final int G = 18;
  public static final int H = 3001;
  public static final int I = 3002;
  public static final int J = 3003;
  public static final int K = 6;
  public static final int L = 5;
  public static final int M = 7;
  public static final int N = 11;
  public static final int O = 8;
  public static final int P = 9;
  public static final int Q = 16;
  public static final int R = 17;
  protected static final int S = 0;
  protected static final int T = 2;
  protected static final int U = 3;
  protected static final int V = 4;
  protected static final int W = 5;
  protected static final int X = 6;
  protected static final int Y = 7;
  protected static final int Z = 8;
  public static final int a = 1;
  public static final String a = "Q.troopinfo";
  public static final int aA = 24;
  public static final int aB = 26;
  public static final int aC = 30;
  public static final int aD = 13;
  public static final int aE = 15;
  public static final int aF = 32;
  public static final int aG = 33;
  public static final int aH = 36;
  public static final int aI = 37;
  public static final int aJ = 38;
  public static final int aK = 1;
  public static final int aL = 2;
  public static final int aM = 0;
  public static final int aN = 1;
  public static final int aO = 2;
  public static final int aP = 1;
  public static final int aQ = 0;
  public static final int aR = 2;
  public static final int aS = 3;
  public static final int aT = 4;
  protected static final int aV = 1;
  protected static final int aW = 2;
  protected static final int aX = 3;
  protected static final int aY = 4;
  protected static final int aZ = 5;
  protected static final int aa = 9;
  protected static final int ab = 10;
  protected static final int ac = 10;
  protected static final int ad = 11;
  protected static final int ae = 12;
  protected static final int af = 13;
  public static final int ag = 31;
  public static final int ah = 2;
  public static final int ai = 3;
  public static final int aj = 4;
  public static final int ak = 5;
  public static final int al = 6;
  public static final int am = 7;
  public static final int an = 8;
  public static final int ao = 9;
  public static final int ap = 10;
  public static final int aq = 11;
  public static final int ar = 12;
  public static final int as = 14;
  public static final int at = 18;
  public static final int au = 19;
  public static final int av = 21;
  public static final int aw = 22;
  public static final int ax = 23;
  public static final int ay = 24;
  public static final int az = 25;
  public static final int b = 2;
  protected static final int ba = 6;
  protected static final int bb = 7;
  protected static final int bc = 8;
  protected static final int bd = 9;
  protected static final int be = 10;
  public static final int bf = 1;
  public static final int bg = 2;
  public static final int bh = 4;
  public static final int bi = 8;
  public static final int bj = 16;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 26;
  public static final int z = 27;
  public long a;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  protected View a;
  protected Button a;
  protected LinearLayout a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public TroopInfo a;
  public AvatarWallAdapter a;
  public TroopInfoData a;
  protected QQProgressDialog a;
  protected QQToastNotifier a;
  protected XListView a;
  public ArrayList a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  protected boolean a;
  protected View[] a;
  public String[] a;
  public int aU;
  public long b;
  public View b;
  protected String b;
  public boolean b;
  public long c;
  protected View c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  protected boolean e;
  public boolean f;
  public boolean g;
  
  public TroopInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.aU = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.d = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mqq(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new mqr(this);
    this.jdField_a_of_type_AndroidOsHandler = new mqw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mqx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new mqy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mqz(this);
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, boolean paramBoolean, String paramString8, long paramLong2, long paramLong3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_loca", paramString7);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString8);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    localBundle.putInt("troop_info_from", paramInt);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    localBundle.putInt("troop_info_cityid", paramInt4);
    return localBundle;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(i1), Double.valueOf(d1), Double.valueOf(d2), str });
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.troopinfo.troop.location_info", 2, "initCurrentLocationStruct==>locationStruct:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public static String a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int i2 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, str);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        localStringBuffer.append(paramContext + " | ");
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int i3 = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (i2 < i3)
            {
              if ((i1 == 0) || (!((String)paramTroopInfoData.troopTags.get(i2)).equals(paramContext))) {
                localStringBuffer.append((String)paramTroopInfoData.troopTags.get(i2) + " | ");
              }
              i2 += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.a))) {
                break label274;
              }
              if (paramContext.a.equals("其他"))
              {
                paramContext = "";
                break;
              }
              paramContext = paramContext.a;
              break;
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
        }
        return localStringBuffer.toString();
      }
      label274:
      paramContext = "";
    }
  }
  
  public static ArrayList a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int i2 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuffer.append(paramContext + " | ");
        ((ArrayList)localObject).add(paramContext);
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int i3 = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (i2 < i3)
            {
              if ((i1 == 0) || (!((String)paramTroopInfoData.troopTags.get(i2)).equals(paramContext)))
              {
                localStringBuffer.append((String)paramTroopInfoData.troopTags.get(i2) + " | ");
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(i2));
              }
              i2 += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.a))) {
                break label301;
              }
              if (paramContext.a.equals("其他"))
              {
                paramContext = "";
                break;
              }
              paramContext = paramContext.a;
              break;
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
        }
        return (ArrayList)localObject;
      }
      label301:
      paramContext = "";
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramContext.toString());
    }
  }
  
  private void a(XListView paramXListView)
  {
    if (paramXListView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2130903886, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131299883);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131296906)).setOnClickListener(new mre(this, paramXListView));
    paramXListView.a(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    j();
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label168;
        }
      }
      label168:
      for (str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;; str = "")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str, "5", "", "");
        QQToast.a(this, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean) {
          finish();
        }
        return;
        switch ((int)paramLong)
        {
        default: 
          paramString = getString(2131369980);
          break;
        case 1281: 
          paramString = getString(2131365017);
          break;
        case 1282: 
          paramString = getString(2131365018);
          break;
        case 1283: 
          paramString = getString(2131365019);
          break;
        }
      }
    }
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label197:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break label264;
      }
    }
    label264:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa);; str = "")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, paramString, str, "", "");
      paramString = getString(2131369979);
      break;
      paramString = "";
      break label197;
    }
  }
  
  private String b()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131365051);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131365052);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131365053);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131365054);
    }
    AvatarWallAdapter.AvatarInfo localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
    if ((localAvatarInfo != null) && ("AVATAR_LOCAL_STR".equals(localAvatarInfo.d)) && (localAvatarInfo.jdField_b_of_type_Int < 100)) {
      return getString(2131365056);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131365055);
    }
    return "";
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(51);
      if (localObject != null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x4) > 0) {
          c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
        }
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          t();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
          a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
      }
      return;
    }
  }
  
  private void p()
  {
    if (this.f)
    {
      Object localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((QQCustomDialog)localObject).setMessage(getString(2131365029, new Object[] { l1 + "" }));
      ((QQCustomDialog)localObject).setNegativeButton(getString(2131365028), new mrk(this));
      ((QQCustomDialog)localObject).setPositiveButton(getString(2131369982), new mrl(this));
      ((QQCustomDialog)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
        return;
      }
    }
    i();
  }
  
  private void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
    if ((localObject == null) || (!"AVATAR_URL_STR".equals(((AvatarWallAdapter.AvatarInfo)localObject).d))) {
      return;
    }
    float f1 = getResources().getDisplayMetrics().density;
    localObject = URLDrawable.getDrawable(AvatarTroopUtil.b(AvatarTroopUtil.a(((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1)));
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      int i1 = (int)(((URLDrawable)localObject).getIntrinsicHeight() / f1);
      int i2 = (int)(((URLDrawable)localObject).getIntrinsicWidth() / f1);
      if ((i1 < 100) || (i2 < 100)) {
        a(getString(2131365056));
      }
    }
    for (;;)
    {
      ((URLDrawable)localObject).setURLDrawableListener(new mrm(this, f1));
      ((URLDrawable)localObject).downloadImediatly();
      return;
      p();
      continue;
      if (((URLDrawable)localObject).getStatus() == 0) {
        b(getString(2131369978));
      } else {
        QQToast.a(this, getString(2131369980), 1).b(getTitleBarHeight());
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, setLastActivityName()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, setLastActivityName()), 8);
      return;
    }
    a(2131368626, 1);
  }
  
  private void s()
  {
    Object localObject = this.app.a();
    int i1;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      i1 = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, i1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      if (i1 == 21)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          i1 = 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          i1 = 21;
          continue;
        }
      }
      i1 = 19;
    }
  }
  
  private void t()
  {
    ThreadManager.a(new mrb(this), 5, null, true);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.a(new mrd(this), 5, null, true);
  }
  
  private void v()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300559);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label393;
      }
    }
    label393:
    for (int i2 = 1;; i2 = 0)
    {
      int i1 = i2;
      if (this.jdField_c_of_type_Long != 0L) {
        i1 = i2 | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        i2 = i1;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        i2 = i1 | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        i1 = i2 | 0x8;
      }
      i2 = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        i2 = i1 | 0x10;
      }
      if (a(i2, 1)) {
        if (a(i2, 2)) {
          if ((a(i2, 4)) || (a(i2, 8)) || (a(i2, 16))) {
            i1 = 2131365040;
          }
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localTextView.setText(i1);
          localTextView.setContentDescription(getString(i1));
          return;
          i1 = 2131365041;
          continue;
          if (a(i2, 8))
          {
            i1 = 2131365045;
            continue;
          }
          if (a(i2, 4))
          {
            i1 = 2131365046;
            continue;
          }
          i1 = 2131365047;
          continue;
          if (a(i2, 2))
          {
            if (a(i2, 4))
            {
              i1 = 2131365042;
              continue;
            }
            if ((a(i2, 8)) || (a(i2, 16)))
            {
              i1 = 2131365043;
              continue;
            }
            i1 = 2131365044;
            continue;
          }
          if ((a(i2, 8)) && (a(i2, 4)))
          {
            i1 = 2131365048;
            continue;
          }
          if (a(i2, 8))
          {
            i1 = 2131365050;
            continue;
          }
          if (a(i2, 4)) {
            i1 = 2131365049;
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        i1 = 0;
      }
    }
  }
  
  private void w()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new mrf(this));
  }
  
  private void x()
  {
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new mrg(this));
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131365059);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131365060);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131365051);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131365053);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131365055);
    }
    return "";
  }
  
  protected void a()
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
            localAvatarInfo.jdField_c_of_type_JavaLangString = str;
            if (localAvatarInfo.jdField_c_of_type_JavaLangString.equals(AvatarWallAdapter.AvatarInfo.a)) {}
            for (localAvatarInfo.d = "SYSTEM_PHOTO";; localAvatarInfo.d = "AVATAR_URL_STR")
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
      ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = AvatarWallAdapter.AvatarInfo.a;
      ((AvatarWallAdapter.AvatarInfo)localObject1).d = "SYSTEM_PHOTO";
      localArrayList.add(localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, false);
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131369983), new mrn(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131369983));
    localQQCustomDialog.setNegativeButton(getString(2131369982), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131369982));
    localQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    label48:
    TextView localTextView2;
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131297123);
        localTextView2 = (TextView)paramView.findViewById(2131297124);
        localView = paramView.findViewById(2131297122);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView2.setEditableFactory(QQTextBuilder.a);
          localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramString2))
          {
            localTextView2.setVisibility(8);
            label135:
            if (!paramBoolean) {
              break label237;
            }
          }
        }
        break;
      }
    }
    label237:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130838349);
      break label48;
      paramView.setBackgroundResource(2130838357);
      break label48;
      paramView.setBackgroundResource(2130838355);
      break label48;
      paramView.setBackgroundResource(2130838352);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new QQText(paramString2, 11));
      break label135;
      localTextView2.setText(paramString2);
      break label135;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131297123);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131297122);
    if (paramBoolean)
    {
      paramInt3 = 0;
      label103:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label168;
      }
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt3 = 8;
        break label103;
        label168:
        paramView.setTag(null);
        paramView.setOnClickListener(null);
      }
    }
    paramView.setBackgroundResource(2130838349);
    return;
    paramView.setBackgroundResource(2130838357);
    return;
    paramView.setBackgroundResource(2130838355);
    return;
    paramView.setBackgroundResource(2130838352);
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label96;
      }
    }
    label96:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
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
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString))) {
              localArrayList2.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString)));
            }
          }
        }
        if (localArrayList2.size() > 0)
        {
          a("Grp_moredata", "del_head", "");
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
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramString + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView1 = null)
    {
      TextView localTextView;
      View localView2;
      if (localView1 != null)
      {
        localTextView = (TextView)localView1.findViewById(2131297124);
        localView2 = localView1.findViewById(2131297122);
        if (paramInt != 6) {
          break label204;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label169;
        }
        localTextView.setVisibility(8);
        if (!paramString.equals(getString(2131367329))) {
          break label193;
        }
        localTextView.setTextColor(-3355444);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label213;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
        return;
        label169:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11));
        break;
        label193:
        localTextView.setTextColor(-8355712);
        continue;
        label204:
        localTextView.setText(paramString);
      }
      label213:
      localView1.setTag(null);
      localView1.setOnClickListener(null);
      localView2.setVisibility(8);
      return;
    }
  }
  
  public void a(int paramInt1, ArrayList paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131302581);
        localLinearLayout.removeAllViews();
        if (paramArrayList != null) {}
      }
      else
      {
        return;
      }
      int i1 = 0;
      while ((i1 < paramArrayList.size()) && (i1 < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
        {
          i1 += 1;
        }
        else
        {
          TextView localTextView = new TextView(this);
          localTextView.setId(2131296466);
          if (paramInt2 == 1) {
            localTextView.setBackgroundResource(2130840141);
          }
          for (;;)
          {
            localTextView.setTextSize(2, 15.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
            }
            localTextView.setSingleLine();
            localTextView.setTextColor(-1);
            localTextView.setPadding(AIOUtils.a(6.0F, getResources()), AIOUtils.a(2.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(2.0F, getResources()));
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(i1));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
            localLinearLayout.addView(localTextView, localLayoutParams);
            break;
            if (paramInt2 == 2) {
              localTextView.setBackgroundResource(2130840140);
            } else {
              localTextView.setBackgroundResource(2130840140);
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131297122);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        paramArrayList.setVisibility(0);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      paramArrayList.setVisibility(8);
      return;
    }
  }
  
  public void a(String paramString)
  {
    String str = getString(2131369986);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(getString(2131369982), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      t();
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    do
    {
      try
      {
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
        if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) <= 0L) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa = ((Bundle)localObject).getInt("troop_info_from");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId = ((Bundle)localObject).getInt("troop_info_cityid", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.aU = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        localObject = (TroopManager)this.app.getManager(51);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.app.a());
            bool1 = true;
          }
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            this.d = "0";
            bool2 = bool1;
          }
          do
          {
            return bool2;
            if (QLog.isColorLevel()) {
              QLog.e("Q.troopinfo", 2, "can't find troop info of :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            }
            bool1 = false;
            break;
            bool2 = bool1;
          } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin);
          this.d = "1";
          return bool1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool2;
          boolean bool1 = false;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopinfo", 2, localException1.toString());
    return bool1;
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  protected void b()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2130904376, null);
    Object localObject1 = (ListView)localView.findViewById(2131302579);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("貂蝉");
    ((ArrayList)localObject2).add("陈圆圆");
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131297613));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[10];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837958);
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131367968);
    }
    setTitle((CharSequence)localObject1);
    localObject1 = View.inflate(this, 2130903649, null);
    localObject2 = (AvatarWallView)((View)localObject1).findViewById(2131296687);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), (GridView)localObject2, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_moredata");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a((GridView)localObject2);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(false);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2130904379, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131367758), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2130904388, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2130904379, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L))
    {
      bool = true;
      a(3, 1, (View)localObject1, getString(2131368682), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
      localObject1 = View.inflate(this, 2130904379, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131369781), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      k();
      localObject1 = View.inflate(this, 2130904379, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131367915), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = View.inflate(this, 2130904378, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(8, 2, (View)localObject1, getString(2131367916), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
      a(8, a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), true, 2, true);
      localObject1 = View.inflate(this, 2130904388, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      localObject2 = View.inflate(this, 2130904384, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label915;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      label733:
      a(6, 3, (View)localObject2, getString(2131367744), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
      localObject2 = View.inflate(this, 2130904388, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131299502);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298931));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label929;
      }
      b(10);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.leftView.setOnClickListener(new mrc(this));
      this.rightViewText.setOnClickListener(new mrh(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      bool = false;
      break;
      label915:
      localObject1 = getResources().getString(2131367329);
      break label733;
      label929:
      b(11);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    case 10: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131369975);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131367292);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(11));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void b(String paramString)
  {
    j();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new mqv(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(null);
        ((QQCustomDialog)localObject).setMessage(getString(2131365030));
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131365028), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131365028));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.f)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          ((QQCustomDialog)localObject).setMessage(getString(2131365031, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131365028), new mri(this));
          ((QQCustomDialog)localObject).setNegativeButton(getString(2131369982), new mrj(this));
          ((QQCustomDialog)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      i();
      return;
    }
    i();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
      return;
    }
  }
  
  public void d()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    a(2131369984);
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 58
    //   11: iconst_2
    //   12: new 362	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1561
    //   22: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 1040	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 1563
    //   32: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 1040	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 1565
    //   42: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 1045	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 464	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_m1
    //   56: iload_2
    //   57: if_icmpne +67 -> 124
    //   60: iload_1
    //   61: tableswitch	default:+63->124, 5:+388->449, 6:+473->534, 7:+64->125, 8:+592->653, 9:+673->734, 10:+63->124, 11:+506->567, 12:+782->843, 13:+789->850, 14:+63->124, 15:+63->124, 16:+129->190
    //   124: return
    //   125: aload_3
    //   126: ifnull -2 -> 124
    //   129: aload_3
    //   130: invokevirtual 1292	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   133: ifnull -9 -> 124
    //   136: aload_3
    //   137: invokevirtual 1292	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   145: aload_3
    //   146: ldc_w 1567
    //   149: invokevirtual 1294	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: putfield 592	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   159: aload_3
    //   160: ldc_w 1569
    //   163: iconst_0
    //   164: invokevirtual 1320	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   167: putfield 1236	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   170: aload_0
    //   171: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   174: aload_3
    //   175: ldc_w 1571
    //   178: iconst_0
    //   179: invokevirtual 1320	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   182: putfield 1242	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   185: aload_0
    //   186: invokevirtual 1460	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   189: return
    //   190: aload_3
    //   191: ifnull -67 -> 124
    //   194: aload_3
    //   195: invokevirtual 1292	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   198: ifnull -74 -> 124
    //   201: aload_3
    //   202: invokevirtual 1292	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: astore_3
    //   206: aload_0
    //   207: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   210: getfield 592	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   213: aload_3
    //   214: ldc_w 1567
    //   217: invokevirtual 1294	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 1576	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   223: ifne +8 -> 231
    //   226: aload_0
    //   227: iconst_1
    //   228: putfield 680	com/tencent/mobileqq/activity/TroopInfoActivity:f	Z
    //   231: aload_0
    //   232: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   235: aload_3
    //   236: ldc_w 1578
    //   239: invokevirtual 1294	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: putfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   245: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +36 -> 284
    //   251: ldc_w 360
    //   254: iconst_2
    //   255: new 362	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 1580
    //   265: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   272: getfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   275: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 1358	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_0
    //   285: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   288: getfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   291: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifne +39 -> 333
    //   297: aload_0
    //   298: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   301: getfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   304: ldc_w 1582
    //   307: invokevirtual 1586	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   310: astore 4
    //   312: aload 4
    //   314: arraylength
    //   315: iconst_5
    //   316: if_icmplt +92 -> 408
    //   319: aload_0
    //   320: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   323: aload 4
    //   325: iconst_4
    //   326: aaload
    //   327: invokestatic 1298	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   330: putfield 1589	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   333: aload_0
    //   334: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   337: aload_3
    //   338: ldc_w 1567
    //   341: invokevirtual 1294	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   344: putfield 592	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   347: aload_0
    //   348: invokevirtual 1460	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   351: return
    //   352: astore 5
    //   354: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -24 -> 333
    //   360: ldc 58
    //   362: iconst_2
    //   363: new 362	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 1591
    //   373: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 4
    //   378: iconst_4
    //   379: aaload
    //   380: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 1593
    //   386: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   393: getfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   396: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 1358	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -72 -> 333
    //   408: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq -78 -> 333
    //   414: ldc 58
    //   416: iconst_2
    //   417: new 362	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 1595
    //   427: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_0
    //   431: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   434: getfield 1325	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   437: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 1597	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto -113 -> 333
    //   449: aload_3
    //   450: ldc_w 1599
    //   453: invokevirtual 1602	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   456: astore_3
    //   457: aload_3
    //   458: aload_0
    //   459: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   462: getfield 598	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   465: invokestatic 1605	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   468: ifne -344 -> 124
    //   471: aload_0
    //   472: iconst_1
    //   473: putfield 680	com/tencent/mobileqq/activity/TroopInfoActivity:f	Z
    //   476: aload_0
    //   477: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   480: aload_3
    //   481: putfield 598	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   484: aload_0
    //   485: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   488: getfield 598	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   491: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   494: ifne +26 -> 520
    //   497: aload_0
    //   498: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   501: getfield 598	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   504: astore_3
    //   505: aload_0
    //   506: bipush 6
    //   508: aload_3
    //   509: aload_0
    //   510: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   513: invokevirtual 662	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   516: invokevirtual 665	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   519: return
    //   520: aload_0
    //   521: invokevirtual 739	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   524: ldc_w 1120
    //   527: invokevirtual 1506	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   530: astore_3
    //   531: goto -26 -> 505
    //   534: aload_3
    //   535: ldc_w 1599
    //   538: invokevirtual 1602	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   541: astore_3
    //   542: aload_3
    //   543: aload_0
    //   544: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   547: getfield 586	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   550: invokestatic 1576	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   553: ifne -429 -> 124
    //   556: aload_0
    //   557: iconst_1
    //   558: putfield 680	com/tencent/mobileqq/activity/TroopInfoActivity:f	Z
    //   561: aload_0
    //   562: aload_3
    //   563: invokevirtual 653	com/tencent/mobileqq/activity/TroopInfoActivity:c	(Ljava/lang/String;)V
    //   566: return
    //   567: ldc2_w 1606
    //   570: lstore 9
    //   572: aload_3
    //   573: ldc_w 1609
    //   576: invokevirtual 1602	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   579: invokestatic 1298	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   582: lstore 7
    //   584: aload_0
    //   585: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   588: getfield 383	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   591: lload 7
    //   593: lcmp
    //   594: ifeq -470 -> 124
    //   597: lload 7
    //   599: ldc2_w 1606
    //   602: lcmp
    //   603: ifeq -479 -> 124
    //   606: aload_0
    //   607: iconst_1
    //   608: putfield 680	com/tencent/mobileqq/activity/TroopInfoActivity:f	Z
    //   611: aload_0
    //   612: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   615: lload 7
    //   617: putfield 383	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   620: aload_0
    //   621: invokespecial 656	com/tencent/mobileqq/activity/TroopInfoActivity:t	()V
    //   624: return
    //   625: astore_3
    //   626: lload 9
    //   628: lstore 7
    //   630: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq -49 -> 584
    //   636: ldc 58
    //   638: iconst_2
    //   639: aload_3
    //   640: invokevirtual 462	java/lang/Exception:toString	()Ljava/lang/String;
    //   643: invokestatic 464	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: lload 9
    //   648: lstore 7
    //   650: goto -66 -> 584
    //   653: aload_0
    //   654: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   657: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   660: iconst_2
    //   661: if_icmpeq +63 -> 724
    //   664: aload_0
    //   665: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   668: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   671: bipush 6
    //   673: if_icmpeq +51 -> 724
    //   676: aload_0
    //   677: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   680: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   683: bipush 15
    //   685: if_icmpeq +39 -> 724
    //   688: aload_0
    //   689: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   692: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   695: bipush 10
    //   697: if_icmpeq +27 -> 724
    //   700: aload_0
    //   701: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   704: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   707: bipush 11
    //   709: if_icmpeq +15 -> 724
    //   712: aload_0
    //   713: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   716: getfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   719: bipush 19
    //   721: if_icmpne -597 -> 124
    //   724: aload_0
    //   725: iconst_m1
    //   726: invokevirtual 1612	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   729: aload_0
    //   730: invokevirtual 567	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   733: return
    //   734: aload_3
    //   735: ldc_w 1614
    //   738: invokevirtual 1602	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   741: astore 4
    //   743: aload 4
    //   745: ifnull -621 -> 124
    //   748: aload 4
    //   750: invokevirtual 431	java/lang/String:length	()I
    //   753: ifle -629 -> 124
    //   756: new 203	java/util/ArrayList
    //   759: dup
    //   760: invokespecial 204	java/util/ArrayList:<init>	()V
    //   763: astore_3
    //   764: new 1616	org/json/JSONArray
    //   767: dup
    //   768: invokespecial 1617	org/json/JSONArray:<init>	()V
    //   771: pop
    //   772: new 1616	org/json/JSONArray
    //   775: dup
    //   776: aload 4
    //   778: invokespecial 1619	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   781: astore 4
    //   783: iload 6
    //   785: istore_1
    //   786: aload 4
    //   788: invokevirtual 1620	org/json/JSONArray:length	()I
    //   791: istore_2
    //   792: iload_1
    //   793: iload_2
    //   794: if_icmpge +25 -> 819
    //   797: aload_3
    //   798: aload 4
    //   800: iload_1
    //   801: invokevirtual 1621	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   804: invokeinterface 963 2 0
    //   809: pop
    //   810: iload_1
    //   811: iconst_1
    //   812: iadd
    //   813: istore_1
    //   814: goto -28 -> 786
    //   817: astore 4
    //   819: aload_0
    //   820: iconst_1
    //   821: putfield 680	com/tencent/mobileqq/activity/TroopInfoActivity:f	Z
    //   824: aload_0
    //   825: getfield 199	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   828: aload_3
    //   829: putfield 407	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   832: aload_0
    //   833: getfield 235	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   836: bipush 6
    //   838: invokevirtual 1282	android/os/Handler:sendEmptyMessage	(I)Z
    //   841: pop
    //   842: return
    //   843: aload_0
    //   844: iload_2
    //   845: aload_3
    //   846: invokevirtual 1623	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILandroid/content/Intent;)V
    //   849: return
    //   850: getstatic 1626	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   853: ifnull -729 -> 124
    //   856: aload_0
    //   857: getstatic 1626	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   860: invokestatic 1631	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   863: astore_3
    //   864: aload_0
    //   865: invokestatic 1636	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/app/Activity;)I
    //   868: istore_1
    //   869: new 448	android/content/Intent
    //   872: dup
    //   873: invokespecial 1637	android/content/Intent:<init>	()V
    //   876: aload_0
    //   877: ldc 2
    //   879: invokevirtual 1642	java/lang/Class:getName	()Ljava/lang/String;
    //   882: iload_1
    //   883: iload_1
    //   884: sipush 640
    //   887: sipush 640
    //   890: aload_3
    //   891: invokestatic 1643	com/tencent/mobileqq/util/ProfileCardUtil:a	()Ljava/lang/String;
    //   894: invokestatic 1648	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Landroid/content/Intent;Landroid/app/Activity;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   897: return
    //   898: astore 5
    //   900: goto -90 -> 810
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	this	TroopInfoActivity
    //   0	903	1	paramInt1	int
    //   0	903	2	paramInt2	int
    //   0	903	3	paramIntent	Intent
    //   310	489	4	localObject	Object
    //   817	1	4	localJSONException1	org.json.JSONException
    //   352	1	5	localNumberFormatException	NumberFormatException
    //   898	1	5	localJSONException2	org.json.JSONException
    //   1	783	6	i1	int
    //   582	67	7	l1	long
    //   570	77	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   319	333	352	java/lang/NumberFormatException
    //   572	584	625	java/lang/Exception
    //   772	783	817	org/json/JSONException
    //   786	792	817	org/json/JSONException
    //   797	810	898	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      this.g = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return true;
      }
      b();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      paramBundle = (BizTroopHandler)this.app.a(22);
      if (paramBundle != null) {
        paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
      }
      BnrReport.a(this.app, 78);
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa), "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.d();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
    }
    super.doOnDestroy();
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
        this.e = true;
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.e)
    {
      this.e = false;
      return;
    }
    TroopAvatarManger.a = 0;
    a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ThreadManager.a(new mqs(this), 5, null, true);
  }
  
  public void finish()
  {
    j();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.g) {
      l();
    }
    super.finish();
  }
  
  protected void g()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = GroupCatalogTool.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int i1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append((String)localObject3 + "\n");
            continue;
            if ((localObject3 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject3).a))) {
              break label305;
            }
            if (((GroupCatalogBean)localObject3).a.equals("其他"))
            {
              i1 = 0;
              break;
            }
            localObject1 = ((GroupCatalogBean)localObject3).a;
            i1 = 1;
            break;
          }
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
      }
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("modifyToSrv", 0);
      startActivityForResult(localIntent, 9);
      return;
      label305:
      i1 = 0;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.f)
    {
      finish();
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa), "", "");
    Object localObject2 = (BizTroopHandler)this.app.a(22);
    if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null))
    {
      finish();
      return;
    }
    long l5;
    try
    {
      l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == -1)
      {
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct;
    int i4 = 0;
    int i3 = 0;
    long l3 = 0L;
    long l1;
    int i1;
    long l2;
    int i2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      l1 = l3;
      i1 = i3;
      l2 = l3;
      i2 = i4;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        l1 = l3;
        i1 = i3;
        l2 = l3;
        i2 = i4;
        i3 = Integer.valueOf(localObject1[0]).intValue();
        l1 = l3;
        i1 = i3;
        l2 = l3;
        i2 = i3;
        l3 = (Double.valueOf(localObject1[1]).doubleValue() * 1000000.0D);
        l1 = l3;
        i1 = i3;
        l2 = l3;
        i2 = i3;
        l4 = (Double.valueOf(localObject1[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject1[3];
        l1 = l4;
        l2 = l3;
        i1 = i3;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        long l4;
        String str1 = "";
        l3 = 0L;
        l2 = l1;
        l1 = l3;
        continue;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        str2 = "";
        l1 = 0L;
        i1 = i2;
        continue;
        i3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        i2 = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        i2 = 2;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) && (this.jdField_c_of_type_Long == 0L)) {
          continue;
        }
        TroopInfoActivityHelper.a(this.app, l5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i1, l2, l1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, str2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new mqu(this));
        return;
        ((BizTroopHandler)localObject2).a(l5, i3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, i1, l2, l1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, str2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
        return;
      }
      b(getString(2131369978));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        i3 = 3;
        if (i3 == -1) {
          break;
        }
        i2 = 1;
        if (this.jdField_c_of_type_Long == 0L) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.jdField_c_of_type_Long) {
          continue;
        }
        i2 = 3;
        if (((this.aU == 0) || (1 == this.aU)) && (i3 == 3)) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.d, "", "");
        }
        if (((this.aU == 2) || (this.aU == 3) || (this.aU == 4)) && ((i3 == 0) || (1 == i3))) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.d, "", "");
        }
        if (((2 != this.aU) && (4 != this.aU)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 4))) {
          continue;
        }
        localObject2 = localObject1;
        l4 = l1;
        l3 = l2;
        if (0L == l2)
        {
          localObject2 = localObject1;
          l4 = l1;
          l3 = l2;
          if (0L == l1)
          {
            l3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
            l4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
          }
        }
        ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.d, "", "");
        TroopInfoActivityHelper.a(this.app, l5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i1, l3, l4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new mqt(this));
        return;
      }
      String str2 = "";
      l1 = 0L;
      l2 = 0L;
      i1 = 0;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void k()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0)) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
          return;
        }
        a(5, "无", true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, false);
        return;
      }
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[5] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.a);
    startActivity(localIntent);
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b();
    }
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
      QLog.i("Q.troopinfo", 2, localException.toString());
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
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 7: 
    case 10: 
    default: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 11: 
      do
      {
        do
        {
          return;
          paramView = new Intent(this, EditInfoActivity.class);
          paramView.putExtra("edit_type", 0);
          paramView.putExtra("title", getString(2131368682));
          paramView.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
          paramView.putExtra("max_num", 30);
          paramView.putExtra("canPostNull", false);
          startActivityForResult(paramView, 6);
          return;
          paramView = new Intent(getActivity(), TroopClassChoiceActivity.class);
          paramView.putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
          startActivityForResult(paramView, 11);
          return;
          g();
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", "http://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
          paramView.putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId);
          startActivityForResult(paramView, 17);
          return;
          h();
          return;
          paramView = new Intent(this, EditInfoActivity.class);
          paramView.putExtra("edit_type", 1);
          paramView.putExtra("title", getString(2131367744));
          paramView.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
          paramView.putExtra("max_num", 900);
          paramView.putExtra("canPostNull", true);
          paramView.putExtra("support_emotion", true);
          paramView.putExtra("full_screen", true);
          startActivityForResult(paramView, 5);
          a("Grp_moredata", "Clk_brief", "");
          return;
          if (!NetworkUtil.e(this))
          {
            a(2131367481, 0);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          n();
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, 8390784);
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopinfo", 2, paramView.toString());
      return;
    }
    s();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
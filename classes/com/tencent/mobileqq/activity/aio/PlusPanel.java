package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.HotChatDemoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.secmsg.SecMsgHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import ndq;
import ndr;
import nds;
import ndt;
import ndu;
import org.json.JSONException;
import org.json.JSONObject;

public class PlusPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final int[] A = { 2131367455, 2130839364, 1101678813 };
  private static final int[] B = { 2131366513, 2130838175 };
  private static final int[] C = { 2131372039, 2130838156, 1104864062 };
  private static final int[] D = { 2131372051, 2130838168 };
  private static final int[] E = { 2131372042, 2130838154 };
  private static final int[] F = { 2131365211, 2130843470, 1104874204 };
  private static final int[] G = { 2131365886, 2130840299, 1104639410 };
  private static final int[] H = { 2131364359, 2130839372 };
  private static final int[] I = { 2131364360, 2130839416, 1104536706 };
  private static final int[] J = { 2131371128, 2130838176 };
  private static final int[] K = { 2131372203, 2130839450 };
  private static final int[] L = { 2131362494, 2130838150, 1104823592 };
  private static final int[] M = { 2131362495, 2130838145, 1105298834 };
  private static final int[] N = { 2131369160, 2130838171, 1104788679 };
  private static final int[] O = { 2131371254, 2130838160 };
  private static final int[] P = { 2131372212, 2130840910 };
  private static final int[] Q = { 2131365197, 2130838174, 1105015724 };
  private static final int[] R = { 2131372300, 2130837712 };
  private static final int[] S = { 2131365274, 2130840194, 1105146680 };
  private static final int[] T = { 2131367602, 2130838163 };
  private static final int[] U = { 2131372260, 2130838164 };
  public static final int a = 1104864064;
  public static final String a = "200002";
  public static final int b = 1104864054;
  public static final String b = "0";
  public static final int c = 1104788673;
  public static final String c = "1";
  public static final int d = 1104651886;
  public static final int e = 100719166;
  public static final int f = 1104864062;
  public static final int g = 1101487426;
  public static final int h = 1104864066;
  public static final int i = 1105015724;
  public static final int j = 1104864068;
  public static final int k = 1104864070;
  public static final int l = 1104788679;
  public static final int m = 1104639410;
  public static final int n = 1104445552;
  public static final int o = 1104874204;
  public static final int p = 1104823592;
  public static final int q = 1101678813;
  public static final int r = 1104536706;
  public static final int s = 200002;
  public static final int t = 1105002396;
  private static final int[] t;
  public static final int u = 1105298834;
  public static final int v = 1105146680;
  private static final int[] v;
  public static final int w = 1105220435;
  private static final int[] x;
  private static final int[] y;
  private static final int[] z;
  private long jdField_a_of_type_Long = -1L;
  public Dialog a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  ThridAppShareHelper jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = null;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public PanelAdapter a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131372256, 2130838166 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_hongbao", "chat_tool_qwallettransfer" };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.l, this.k, x, this.q, C, z, this.m, t, v, N, A, I, G, F };
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131368090, 2130838165, 1104864054 };
  private final int[][] jdField_b_of_type_Array2dOfInt = { this.jdField_b_of_type_ArrayOfInt, this.e, this.l, this.k, C, z, x, this.q, Q, this.m, t, v, N, A, I, G, F, this.w, L, M, S };
  private final int[] c = { 2131368091, 2130838149 };
  private final int[] d = { 2131368102, 2130838172 };
  private final int[] e = { 2131368102, 2130838172, 1104788673 };
  private final int[] f = { 2131371128, 2130838176 };
  private final int[] g = { 2131362139, 2130838178 };
  private final int[] h = { 2131362409, 2130838177 };
  private final int[] i = { 2131368096, 2130838146 };
  private final int[] j = { 2131368097, 2130838146 };
  private final int[] k = { 2131368099, 2130838147, 100719166 };
  private final int[] l = { 2131368098, 2130838148, 1104651886 };
  private final int[] m = { 2131368106, 2130838157, 1104864068 };
  private final int[] n = { 2131367619, 2130838169 };
  private final int[] o = { 2131372242, 2130838173 };
  private final int[] p = { 2131367620, 2130838167 };
  private final int[] q = { 2131367621, 2130838169, 1104864066 };
  private final int[] r = { 2131367766, 2130838161 };
  private final int[] s = { 2131367622, 2130838170 };
  private final int[] u = { 2131366515, 2130838144 };
  private final int[] w = { 2131372176, 2130840127, 1104445552 };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    t = new int[] { 2131369106, 2130838159, 1104864070 };
    v = new int[] { 2131371208, 2130839291 };
    x = new int[] { 2131364922, 2130839802, 1101487426 };
    y = new int[] { 2131364923, 2130839802 };
    z = new int[] { 2131367454, 2130839363, 1104864064 };
  }
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppDialog = null;
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidAppDialog = null;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (!str.equals("")) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
      }
      if ((paramBoolean) && (paramInt2 != 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramInt2), "", "");
      }
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
      continue;
      str = "4";
      continue;
      str = "5";
      continue;
      str = "6";
      continue;
      str = "8";
      continue;
      str = "9";
      continue;
      str = "10";
      continue;
      str = "11";
      continue;
      str = "12";
      continue;
      str = "13";
      continue;
      str = "14";
      continue;
      str = "15";
      continue;
      str = "16";
      continue;
      str = "17";
      continue;
      str = "18";
      continue;
      str = "20";
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((localObject != null) && (((HotChatManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(C);
      }
      if (((HotChatManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(P);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    while (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(y);
      return;
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject = (TroopAppMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    if (localObject == null)
    {
      localObject = null;
      label166:
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label356;
      }
      localObject = ((List)localObject).iterator();
    }
    label186:
    label251:
    label347:
    label356:
    label368:
    label402:
    label414:
    label418:
    for (;;)
    {
      TroopAIOAppInfo localTroopAIOAppInfo;
      int i2;
      if (((Iterator)localObject).hasNext())
      {
        localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localTroopAIOAppInfo.minVersion)) && (AppSetting.a(localTroopAIOAppInfo.minVersion) < 0)) {
          continue;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localTroopAIOAppInfo.appid, localTroopAIOAppInfo);
        int[][] arrayOfInt = this.jdField_b_of_type_Array2dOfInt;
        i2 = arrayOfInt.length;
        i1 = 0;
        if (i1 >= i2) {
          break label414;
        }
        int[] arrayOfInt1 = arrayOfInt[i1];
        if ((arrayOfInt1.length < 3) || (localTroopAIOAppInfo.appid != arrayOfInt1[2])) {
          break label347;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfInt1);
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label418;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(new int[] { -localTroopAIOAppInfo.appid, -localTroopAIOAppInfo.appid, localTroopAIOAppInfo.appid });
        break label186;
        break;
        localObject = ((TroopAppMgr)localObject).a(false);
        break label166;
        i1 += 1;
        break label251;
        localObject = this.jdField_a_of_type_Array2dOfInt;
        i2 = localObject.length;
        i1 = 0;
        if (i1 < i2)
        {
          localTroopAIOAppInfo = localObject[i1];
          if (localTroopAIOAppInfo != v) {
            break label402;
          }
          b("200002");
        }
        for (;;)
        {
          i1 += 1;
          break label368;
          break;
          this.jdField_a_of_type_JavaUtilArrayList.add(localTroopAIOAppInfo);
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio_new")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_poke")) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSharedPreferences);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper == null)
    {
      this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = ThridAppShareHelper.a();
      this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper.a(paramString))
    {
      if (!"200002".equals(paramString)) {
        break label53;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(v);
    }
    label53:
    do
    {
      return;
      if ("0".equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(H);
        return;
      }
    } while (!"1".equals(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(I);
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), null);
    localActionSheet.a(2131364896, 5);
    boolean bool = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (bool) {}
    for (String str = BaseApplicationImpl.getContext().getResources().getString(2131364895);; str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131364894))
    {
      localActionSheet.a(str, 5);
      localActionSheet.d(2131367262);
      localActionSheet.a(new nds(this, bool, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
      return;
      if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(G);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.s);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
        this.jdField_a_of_type_JavaUtilArrayList.add(t);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
        this.jdField_a_of_type_JavaUtilArrayList.add(N);
        return;
      }
      int i1 = PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      int i2 = PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(G);
      if ((i2 == 1) || (i2 == 2)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(U);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(C);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
      if ((i1 == 1) || (i1 == 2) || (i2 == 1) || (i2 == 2)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(T);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(B);
        this.jdField_a_of_type_JavaUtilArrayList.add(t);
        b("200002");
        this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
        this.jdField_a_of_type_JavaUtilArrayList.add(N);
        BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          SecMsgManager localSecMsgManager = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if ((localSecMsgManager != null) && (localSecMsgManager.a())) {
            this.jdField_a_of_type_JavaUtilArrayList.add(D);
          }
        }
        if ((localBusinessCardManager != null) && (localBusinessCardManager.a(0))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(O);
        }
        if ((ApolloManager.a(getContext(), Boolean.valueOf(false))) && (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) > 0)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(R);
        }
        if ((i2 == 1) || (i2 == 2)) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(T);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
        if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.p);
          this.jdField_a_of_type_JavaUtilArrayList.remove(B);
          this.jdField_a_of_type_JavaUtilArrayList.remove(v);
          this.jdField_a_of_type_JavaUtilArrayList.remove(D);
          this.jdField_a_of_type_JavaUtilArrayList.remove(T);
          b("200002");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(B);
        this.jdField_a_of_type_JavaUtilArrayList.remove(v);
        this.jdField_a_of_type_JavaUtilArrayList.remove(D);
        this.jdField_a_of_type_JavaUtilArrayList.remove(T);
        b("200002");
        return;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.s);
      }
    } while (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
  }
  
  public DeviceInfo a(long paramLong)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localSmartDeviceProxyMgr != null) {
      return localSmartDeviceProxyMgr.a(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_hotchat_hongbao.name(), "1"));
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      QLog.d("PlusPanel", 2, "reload(): showHongBao=" + bool);
      QLog.d("PlusPanel", 2, "reload(): type=" + i1);
    }
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reload(): iconList size" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if (i1 != 3000) {
        break label688;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.j);
      this.jdField_a_of_type_JavaUtilArrayList.add(J);
      this.jdField_a_of_type_JavaUtilArrayList.add(G);
      this.jdField_a_of_type_JavaUtilArrayList.add(C);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.u);
      this.jdField_a_of_type_JavaUtilArrayList.add(N);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
      localObject1 = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
      this.jdField_a_of_type_JavaUtilArrayList.add(t);
      b("200002");
      this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
      if ((localObject1 != null) && (((BusinessCardManager)localObject1).a(0))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(O);
      }
      if ((ApolloManager.a(super.getContext())) && (ApolloManager.c("discuss") == 1)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(R);
      }
      label339:
      if ((!VcSystemInfo.e()) || (!VcSystemInfo.f()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.i);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.j);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.k);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.l);
      }
      if ((i1 != 1) || (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label2139;
      }
    }
    label456:
    label688:
    label1777:
    label1800:
    label1893:
    label2006:
    label2139:
    for (i1 = 1;; i1 = 0)
    {
      ArrayList localArrayList = new ArrayList();
      int i2 = 0;
      if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        PlusPanel.PluginData localPluginData = new PlusPanel.PluginData();
        Resources localResources;
        if ((i1 != 0) && (arrayOfInt.length >= 3) && (this.jdField_a_of_type_AndroidUtilSparseArray != null))
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(arrayOfInt[2]);
          if (localTroopAIOAppInfo != null)
          {
            localResources = BaseApplicationImpl.getContext().getResources();
            for (;;)
            {
              try
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                if ((arrayOfInt.length < 2) || (arrayOfInt[1] <= 0)) {
                  continue;
                }
                i3 = arrayOfInt[1];
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(i3);
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(i3);
                localObject1 = URLDrawable.getDrawable(localTroopAIOAppInfo.iconUrl, (URLDrawable.URLDrawableOptions)localObject1);
              }
              catch (Exception localException2)
              {
                int i3;
                localObject2 = localResources.getDrawable(2130840058);
                continue;
              }
              localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
              localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
              localPluginData.jdField_b_of_type_Int = localTroopAIOAppInfo.appid;
              localPluginData.jdField_a_of_type_JavaLangString = localTroopAIOAppInfo.name;
              localPluginData.jdField_a_of_type_Boolean = localTroopAIOAppInfo.redPoint;
              localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + " 按钮");
              localArrayList.add(localPluginData);
              i2 += 1;
              break label456;
              this.jdField_a_of_type_JavaUtilArrayList.clear();
              break;
              if (i1 == 1)
              {
                a(bool);
                break label339;
              }
              if (i1 == 7100) {
                break label339;
              }
              if ((i1 == 1000) || (i1 == 1004))
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                this.jdField_a_of_type_JavaUtilArrayList.add(N);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break label339;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(C);
                this.jdField_a_of_type_JavaUtilArrayList.add(B);
                break label339;
              }
              if (i1 == 1006)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                this.jdField_a_of_type_JavaUtilArrayList.add(N);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                break label339;
              }
              if (i1 == 1020) {
                break label339;
              }
              if (i1 == 1025)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                break label339;
              }
              if ((i1 == 1008) || (i1 == 1024))
              {
                if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfInt);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
                if (i1 == 1008)
                {
                  localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x20000000) != 0) && (ShortVideoUtils.jdField_a_of_type_Boolean) && (VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                  {
                    this.jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
                  }
                  if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x10000000) != 0)) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ArrayOfInt);
                  }
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                break label339;
              }
              if ((i1 == 1005) || (i1 == 1003)) {
                break label339;
              }
              if (i1 == 1001)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 != null) && (localObject1.length > 0) && (bool)) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(C);
                }
                if (localObject1 != null) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                break label339;
              }
              if (i1 == 1010)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 != null) && (localObject1.length > 0)) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                break label339;
              }
              if (i1 == 1021)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                break label339;
              }
              if ((i1 == 1022) || (i1 == 1009) || (i1 == 1024) || (i1 == 1023)) {
                break label339;
              }
              if (i1 == 6000)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                this.jdField_a_of_type_JavaUtilArrayList.add(G);
                break label339;
              }
              if (i1 == 9501) {
                try
                {
                  l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                  if ((localObject1 == null) || (!((SmartDeviceProxyMgr)localObject1).d(l1))) {
                    break label339;
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                  long l1 = 0L;
                  continue;
                }
              }
              if ((i1 == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
              {
                f();
                break label339;
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
              break label339;
              i3 = 2130840058;
            }
          }
        }
        localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
        localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
        localPluginData.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
        Object localObject2 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localObject2 != null)
        {
          if (((GameCenterManagerImp)localObject2).a("999999.100004") != -1) {
            bool = true;
          }
        }
        else
        {
          if ((arrayOfInt != H) || (!a("chat_tool_dingyue"))) {
            break label1893;
          }
          localPluginData.jdField_a_of_type_Boolean = true;
          localPluginData.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + "按钮");
          if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (arrayOfInt != this.jdField_b_of_type_ArrayOfInt) {
              break label2006;
            }
            localPluginData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131364925);
          }
        }
        for (;;)
        {
          localArrayList.add(localPluginData);
          break;
          bool = false;
          break label1777;
          if ((arrayOfInt == B) && (a("chat_tool_qwallettransfer")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label1800;
          }
          if ((arrayOfInt == G) && (a("chat_tool_qfav")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label1800;
          }
          if ((arrayOfInt == R) && (a("chat_tool_apollo")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label1800;
          }
          if ((arrayOfInt == T) && (a("chat_tool_poke")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label1800;
          }
          localPluginData.jdField_a_of_type_Boolean = false;
          break label1800;
          if (arrayOfInt == this.c) {
            localPluginData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131364924);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount(), false);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
          post(new ndq(this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.d("PlusPanel", 2, "e=" + localException3);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131296994));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131296995));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    paramBaseChatPie = getResources().getDrawable(2130843209);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        a();
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label191;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "PlusPanle background is null:");
        }
      }
      label191:
      paramBaseChatPie = null;
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gaudio_new")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_poke")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i1 = PokeItemHelper.a(paramQQAppInterface, 0);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i1 == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i1 + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      a("chat_tool_gaudio_new");
      Object localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(10));
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Map)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1, 10);
        if ((localObject == null) || (((AVNotifyCenter.VideoRoomInfo)localObject).jdField_a_of_type_Int <= 0)) {
          break label158;
        }
      }
    }
    return;
    label158:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005928", "0X8005928", 0, 0, "", "", "", "");
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "showSelGAudioMembersActionSheet");
    }
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
      ActionSheet localActionSheet = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      localActionSheet.c(getResources().getString(2131363948));
      localActionSheet.c(getResources().getString(2131363949));
      localActionSheet.d(getResources().getString(2131367976));
      localActionSheet.a(new ndt(this, localActionSheet));
      localActionSheet.setOnDismissListener(new ndu(this));
      localActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie)) {
          ((DiscussChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a = localActionSheet;
        }
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  public void onClick(View paramView)
  {
    PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)paramView.getTag();
    int i3 = localViewHolder.jdField_a_of_type_Int;
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      label575:
      boolean bool;
      try
      {
        paramView = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramView != null) {
          i1 = paramView.productId;
        }
      }
      catch (Exception paramView)
      {
        i1 = 0;
        continue;
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        if (VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          continue;
        }
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter()).show();
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p(2);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.al();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
          break label1115;
        }
      }
      paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      switch (i3)
      {
      default: 
        if (i3 < 0)
        {
          if (-i3 == 1105220435)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), AVMeetingActivity.class);
            paramView.putExtra("param_only_troop_member", true);
            paramView.putExtra("group_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("group_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
            ReportController.b(null, "CliOper", "", "", "0X800667A", "0X800667A", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
              break label6518;
            }
            paramView = null;
            if ((paramView != null) && (paramView.redPoint)) {
              ThreadManager.a(new ndr(this, paramView), 8, null, false);
            }
            if ((paramView == null) || (!paramView.canRemove)) {
              break label6536;
            }
            bool = true;
            a(i3, localViewHolder.jdField_b_of_type_Int, bool);
          }
          return;
        }
        break;
      case 2130838149: 
      case 2130838172: 
      case 2130838162: 
      case 2130838165: 
        label616:
        label628:
        paramView = new Intent();
        if (paramView != null) {
          if (DeviceMsgChatPie.N) {
            break label1109;
          }
        }
        label929:
        label1109:
        for (bool = true;; bool = false)
        {
          paramView.putExtra("isdevicesupportmultiupload", bool);
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramView);
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i1);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
              paramView.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i1);
          }
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
        label1115:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramView = new Intent();
          paramView.putExtra("filter_photolist_troopalbum_toolbar", true);
        }
        break;
      }
      for (;;)
      {
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        break label929;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
          ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).j(true);
        }
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
        if (QLog.isColorLevel()) {
          QLog.i("testing", 2, "deliver flowers!");
        }
        paramView = getContext();
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        Object localObject2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k(str));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        if (Friends.isValidUin(str))
        {
          str = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(str), ((String)localObject2).toLowerCase(), Integer.valueOf(1), "aio.plus.s", "" });
          localObject2 = new Intent(paramView, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", str);
          paramView.startActivity((Intent)localObject2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052BE", "0X80052BE", 0, 0, "", "", "", "");
          break;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131371565, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight());
        break;
        TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_paypic", "", "AIOchat", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          e();
        }
        for (;;)
        {
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407F", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          a("chat_tool_gaudio");
          paramView = new HashMap();
          paramView.put("isVideo", "true");
          paramView.put("MultiAVType", String.valueOf(10));
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != l1) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005677", "0X8005677", 0, 0, "", "", "", "");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != 0L) {
            break;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1, 10);
          if ((paramView != null) && (paramView.jdField_a_of_type_Int > 0)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005929", "0X8005929", 0, 0, "", "", "", "");
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          a("chat_tool_gaudio");
          paramView = new HashMap();
          paramView.put("isVideo", "true");
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == l1) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
          if (LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label2277;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131371568));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131371568));
          break;
        }
        label2277:
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.al();
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, null, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        }
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004086", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
          break;
        }
        ((PublicAccountChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).l.performClick();
        break;
        d();
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          a("chat_tool_gaudio");
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, 0);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == l1) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          a("chat_tool_gaudio");
          paramView = new HashMap();
          paramView.put("MultiAVType", String.valueOf(2));
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1, l1)) {
            ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "1", "");
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB5", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
          if (LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label2961;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131371567));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131371567));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
          break;
        }
        label2961:
        a("chat_tool_audio");
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ah();
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
          if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
          {
            CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOBottomButtonEngineFalse");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407B", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          QQToast.a(BaseApplicationImpl.getContext(), 2131363560, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492908));
          if (QLog.isColorLevel())
          {
            QLog.d("AIOAudioPanel", 2, "Don't support ivr");
            continue;
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
          }
        }
        Environment.getExternalStorageState();
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            continue;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (paramView != null) && (paramView.d(l1)))
            {
              PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
            else
            {
              AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              paramView = new FileManagerReporter.fileAssistantReportData();
              paramView.jdField_b_of_type_JavaLangString = "send_file";
              paramView.jdField_a_of_type_Int = 1;
              FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
              PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          break;
        }
        a("chat_tool_qlink_file");
        b();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
        break;
        i1 = 1;
        if (this.jdField_a_of_type_Long == -1L)
        {
          label3508:
          if (i1 == 0) {
            break label3579;
          }
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        for (;;)
        {
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004081", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 10000L) {
            break label3508;
          }
          i1 = 0;
          break label3508;
          label3579:
          QQToast.a(BaseApplicationImpl.getContext(), "歇一会再发送窗口抖动吧", 0).a();
        }
        paramView = new Bundle();
        paramView.putInt("forward_type", 23);
        paramView.putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramView.putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramView.putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        Object localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramView);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (Intent)localObject1, 21);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80056B3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        paramView = new Bundle();
        paramView.putInt("forward_type", 23);
        paramView.putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramView.putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramView.putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), BusinessCardListActivity.class);
        ((Intent)localObject1).putExtras(paramView);
        ((Intent)localObject1).putExtra("Extra_Entrance", 3);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivityForResult((Intent)localObject1, 21);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80064F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
          break label628;
        }
        paramView = AuthorizeConfig.a().a("aio_qqMusicShare", "");
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004083", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        ThridAppShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "200002", "http://m.dianping.com/qq/aiodwonload", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ThridAppShareHelper.a("200002", "click_app", "", "", "");
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB2", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0");
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        paramView = new Bundle();
        paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putBoolean("hide_operation_bar", true);
        paramView.putBoolean("hide_more_button", true);
        paramView.putBoolean("isScreenOrientationPortrait", true);
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        break;
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          a("chat_tool_anonymous");
          b();
          if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
            break label628;
          }
          ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(2, "");
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
          break label628;
        }
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).i(false);
        ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
        break;
        a("chat_tool_qwallettransfer");
        b();
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TransactionActivity.class);
        ((Intent)localObject1).putExtra("come_from", 2);
        int i2 = 0;
        i1 = 0;
        paramView = null;
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("targetUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            ((JSONObject)localObject2).put("targetNickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            ((JSONObject)localObject2).put("sign", "");
            if (i2 != 0) {
              ((JSONObject)localObject2).put("source", i2);
            }
            ((JSONObject)localObject2).put("group_type", i1);
            if (!TextUtils.isEmpty(paramView)) {
              ((JSONObject)localObject2).put("group_uin", paramView);
            }
          }
          catch (JSONException paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
            }
          }
          ((Intent)localObject1).putExtra("extra_data", ((JSONObject)localObject2).toString());
          ((Intent)localObject1).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
          ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 0, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB0", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          i2 = 5;
          i1 = 3;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          continue;
          i2 = 5;
          i1 = 4;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        }
        DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 4, 0, i1);
        break;
        localObject1 = new Intent(BaseApplicationImpl.getContext(), LiteVideoActivity.class);
        i2 = 1;
        if (paramView != null) {}
        label6518:
        label6536:
        label6548:
        for (;;)
        {
          try
          {
            if (!paramView.a()) {
              break label6548;
            }
            bool = paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 9);
            if (!bool) {
              break label6548;
            }
            i2 = 1;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            continue;
          }
          ((Intent)localObject1).putExtra("maxCount", i2);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivityForResult((Intent)localObject1, 81);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break;
          }
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 5, 0, i1);
          break;
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
          {
            new PlusPanelUtils().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 0);
            break;
          }
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, 0);
          break;
          paramView = new Intent();
          paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putExtra("nickName", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject1 = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
            if ((localObject1 != null) && (((SecMsgManager)localObject1).c())) {
              SecMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramView);
            }
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AnonyMsg", "clk_aio_creat", 0, 0, "", "", "", "");
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            SecMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView);
            continue;
            SecMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView);
          }
          a("chat_tool_qfav");
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break;
          }
          PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          a("chat_tool_dingyue");
          b();
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          paramView.putExtra("url", "http://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
          break;
          a("chat_tool_toupiao");
          b();
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          paramView.putExtra("url", "http://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&src=3");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB9", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          paramView = new Intent();
          paramView.putExtra("_src_type_", DingdongPluginHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
          paramView.putExtra("_src_code_", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "com.dingdong.business.base.activity.DingdongDingActivity", paramView, -1);
          break;
          paramView = new Intent();
          if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
          {
            paramView.putExtra("ApprovalOpenParams.opentype", 1);
            paramView.putExtra("ApprovalOpenParams.fromuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "com.dingdong.business.approval.activity.ApprovalSessionsActivity", paramView, -1);
          break;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          paramView.putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793" + "&f=6" + "&uintype=3000" + "&touin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBB", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), HotChatDemoActivity.class);
          paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          paramView.putExtra("entrance", 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
          break;
          if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localViewHolder.jdField_b_of_type_Int) < 0)) {
            break;
          }
          paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localViewHolder.jdField_b_of_type_Int);
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          if ((paramView == null) || (paramView.url == null)) {
            break;
          }
          ((Intent)localObject1).putExtra("url", paramView.url.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBA", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          paramView = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
          if (paramView == null) {
            break;
          }
          TroopBarUtils.a.clear();
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "Grp_plus", "Clk_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
          if (paramView == null) {
            break;
          }
          localObject1 = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          if (localObject1 == null) {
            break;
          }
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (DeviceInfo)localObject1, false);
          break;
          bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
          a("chat_tool_apollo");
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ao();
          }
          if (bool) {}
          for (i1 = 1;; i1 = 0)
          {
            paramView = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i2 = paramView.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
            localObject2 = "" + i1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
            for (paramView = "0";; paramView = "2")
            {
              VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "panel_enter_clk", i2, 0, new String[] { localObject2, paramView });
              break;
            }
            a("chat_tool_poke");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("chat_tool_poke_clicked", true).commit();
            b();
            ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800676E", "0X800676E", 2, 0, "", "", "", "");
            break;
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
            break;
            if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localViewHolder.jdField_b_of_type_Int) < 0)) {
              break;
            }
            paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localViewHolder.jdField_b_of_type_Int);
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            if ((paramView == null) || (paramView.url == null)) {
              break;
            }
            ((Intent)localObject1).putExtra("url", paramView.url.replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).replace("$APPID$", String.valueOf(localViewHolder.jdField_b_of_type_Int)));
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
            break;
            paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localViewHolder.jdField_b_of_type_Int);
            break label575;
            bool = false;
            break label616;
          }
        }
        paramView = null;
      }
      i1 = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\PlusPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
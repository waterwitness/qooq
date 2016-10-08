package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lfp;
import lfq;
import lfr;
import lfs;
import lft;
import lfu;
import lfv;
import lfx;
import lfy;
import lga;
import lgb;
import lge;
import lgf;
import lgg;
import lgh;
import lgi;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final String a = "D2GType";
  public static final int c = 1000;
  public static final int d = 1;
  public static final int e = 2;
  public static final String f = "0";
  public static final String g = "1";
  public static final String h = "2";
  public static final String i = "3";
  private static final String jdField_j_of_type_JavaLangString = "DiscussionInfoCardActivity";
  private static final int v = 16;
  private static final int w = 17;
  private static final int x = 0;
  protected final int a;
  public long a;
  public Dialog a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Button jdField_a_of_type_AndroidWidgetButton;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public DiscussionInfo a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  protected FormSimpleItem a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  protected WXShareHelper.WXShareListener a;
  protected ActionSheet a;
  private List jdField_a_of_type_JavaUtilList;
  private lgh jdField_a_of_type_Lgh;
  public MqqHandler a;
  public boolean a;
  protected final int b;
  private long jdField_b_of_type_Long;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private FormSimpleItem c;
  public String c;
  private FormSimpleItem d;
  public String d;
  private FormSimpleItem e;
  public String e;
  protected final int f;
  private FormSimpleItem f;
  protected final int g;
  private FormSimpleItem g;
  protected final int h;
  private FormSimpleItem h;
  protected int i;
  private FormSimpleItem i;
  private int jdField_j_of_type_Int;
  private FormSimpleItem jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int m;
  private int n;
  private int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  
  public DiscussionInfoCardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = 4;
    this.p = 0;
    this.q = 1;
    this.r = 2;
    this.s = 3;
    this.t = 8;
    this.u = 9;
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 11;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 1;
    this.jdField_h_of_type_Int = 2;
    this.jdField_a_of_type_MqqOsMqqHandler = new lfy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lga(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new lgb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lge(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new lft(this);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str1;
    if ((paramString == null) || (paramInt <= 0)) {
      str1 = "";
    }
    for (;;)
    {
      return str1;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("utf-8");
        str1 = paramString;
        if (paramInt >= arrayOfByte.length) {
          continue;
        }
        str1 = new String(arrayOfByte, paramInt - 1, 3, "utf-8");
        String str2 = new String(arrayOfByte, paramInt - 2, 3, "utf-8");
        int i1;
        if ((str1.length() == 1) && (paramString.contains(str1))) {
          i1 = paramInt - 1;
        }
        for (;;)
        {
          return new String(arrayOfByte, 0, i1, "utf-8");
          i1 = paramInt;
          if (str2.length() == 1)
          {
            boolean bool = paramString.contains(str2);
            i1 = paramInt;
            if (bool) {
              i1 = paramInt - 2;
            }
          }
        }
        return paramString;
      }
      catch (Exception localException) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString1 = "点击链接加入多人聊天\"" + paramString2 + "\":\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, "已复制多人聊天链接", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492908));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    QQToast.a(paramQQAppInterface, 2, "复制多人聊天链接失败", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492908));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramQQProgressDialog != null)) {}
    try
    {
      paramQQProgressDialog.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        ThreadManager.a(new lfu(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, paramQQProgressDialog), 5, null, true);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiscussionInfoCardActivity", 2, localException.toString());
        }
      }
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, "拉取多人聊天连接失败，请重试！", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    paramString3 = String.format(paramActivity.getString(2131370147), new Object[] { paramString3 });
    paramString2 = QRUtils.a(paramActivity, "temp_discuss_link_share_" + paramString2 + ".png", TroopShareUtility.a(paramString1, paramActivity.getResources()));
    if (TextUtils.isEmpty(paramString2)) {
      QQToast.a(paramActivity, 1, 2131364460, 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
    }
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString2)) {
        localArrayList.add(paramString2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", paramString3);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", paramString1);
      localBundle.putStringArrayList("image_url", localArrayList);
      QZoneShareManager.a(paramQQAppInterface, paramActivity, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i("DiscussionInfoCardActivity", 2, "shareToQzone.title:" + paramString3 + " filePath:" + paramString2 + " shareLink:" + paramString1 + " desc:" + "");
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i3 = (int)(this.mDensity * 20.0F);
    int i1 = (int)(this.mDensity * 20.0F);
    int i4 = (int)(66.0F * this.mDensity);
    int i5 = (int)(50.0F * this.mDensity);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(this.mDensity * 20.0F);
    this.jdField_k_of_type_Int = i2;
    this.jdField_l_of_type_Int = i2;
    this.m = i3;
    this.n = i3;
    this.o = i1;
    paramMyGridView.setPadding(this.jdField_k_of_type_Int, this.m, this.jdField_l_of_type_Int, this.n);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      if (((this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) || ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130843286);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130843277);
  }
  
  private void j()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_k_of_type_JavaLangString == null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    }
    this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)this.app.getManager(52));
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_l_of_type_JavaLangString);
    k();
    setContentBackgroundResource(2130837958);
  }
  
  private void k()
  {
    Object localObject = (XListView)View.inflate(this, 2130903384, null);
    ((XListView)localObject).setDivider(null);
    ((XListView)localObject).setVerticalScrollBarEnabled(false);
    ((XListView)localObject).setPadding(0, 0, 0, 0);
    View localView = View.inflate(this, 2130903184, null);
    ((XListView)localObject).setAdapter(new XSimpleListAdapter(localView));
    setContentView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131297571));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131297562));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297560));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297566));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297565));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297564));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297568));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297569));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297570));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131297573));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131297572));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297563));
    this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297567));
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297561));
    i();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new lfp(this));
    this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    setTitle(2131369485);
    setLeftViewName(2131366637);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setBackgroundResource(2130838588);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
    {
      a(1, getString(2131367980));
      finish();
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_l_of_type_JavaLangString));
      localObject = (FriendsManager)this.app.getManager(50);
      if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null) && (!((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
        ((FriendListHandler)this.app.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "", false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasRenamed())
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_k_of_type_JavaLangString);
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "DiscussionInfo.DiscussionFlag:" + this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.DiscussionFlag);
        }
        v();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasCollect);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new lfv(this));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) || (this.app == null) || (this.app.a() == null)) {
          break label1025;
        }
        if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) || (!this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin))) {
          break label960;
        }
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        if (AppSetting.j)
        {
          this.rightViewImg.setContentDescription(getString(2131364687));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("编辑多人聊天名称 " + this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.b().getText());
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369500));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("删除多人聊天成员");
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131364647));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131364394));
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367904));
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367906));
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369470));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131364260));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131369552));
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131369481));
        }
        l();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + this.jdField_l_of_type_JavaLangString, localException);
          continue;
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131370167));
          continue;
          label960:
          if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
          {
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          }
          else
          {
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            continue;
            label1025:
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
        }
      }
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 762	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: aload_0
    //   6: invokevirtual 766	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 771	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: if_acmpne +20 -> 32
    //   15: new 773	lfw
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 774	lfw:<init>	(Lcom/tencent/mobileqq/activity/DiscussionInfoCardActivity;)V
    //   23: iconst_5
    //   24: aconst_null
    //   25: iconst_0
    //   26: invokestatic 330	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 147	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_ComTencentMobileqqAppDiscussionManager	Lcom/tencent/mobileqq/app/DiscussionManager;
    //   37: aload_0
    //   38: getfield 162	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokevirtual 777	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   44: invokevirtual 780	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:a	(Ljava/util/List;)V
    //   47: goto -18 -> 29
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	DiscussionInfoCardActivity
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	50	finally
    //   32	47	50	finally
  }
  
  private void m()
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
  
  private void n() {}
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131368262);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("action", 102);
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasRenamed()) {}
    for (String str = this.jdField_k_of_type_JavaLangString;; str = "")
    {
      localIntent.putExtra("current", str);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
      startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
      return;
    }
  }
  
  private void p()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_j_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void q()
  {
    FileManagerReporter.a("0X8004E02");
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_j_of_type_Int);
    localIntent.putExtra("uinname", this.jdField_k_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  private void r()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatBackgroundMarketActivity.class);
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("url", IndividuationUrlHelper.a(this, "background", ""));
    String str = String.valueOf(33554432L);
    if (WebViewPluginFactory.a.containsKey(str)) {
      localIntent.putExtra("insertPluginsArray", new String[] { str });
    }
    localIntent.putExtra("business", 33554432L);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_j_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 1);
  }
  
  private void s()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    Intent localIntent = TroopMemberListActivity.a(this, this.jdField_l_of_type_JavaLangString, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void t()
  {
    Object localObject2 = this.jdField_k_of_type_JavaLangString;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = getString(2131368269);
    }
    localObject2 = DialogUtil.a(this, 230);
    ((QQCustomDialog)localObject2).setTitle(getString(2131369481));
    ((QQCustomDialog)localObject2).setMessage(String.format(getString(2131369482), new Object[] { localObject1 }));
    ((QQCustomDialog)localObject2).setPositiveButton(2131369555, new lfq(this));
    ((QQCustomDialog)localObject2).setNegativeButton(2131367976, new lfr(this));
    ((QQCustomDialog)localObject2).show();
  }
  
  private void u()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_k_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_j_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void v()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager != null)
    {
      DiscussionMemberInfo localDiscussionMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_l_of_type_JavaLangString, this.app.a());
      if (localDiscussionMemberInfo == null) {
        break label104;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag:" + localDiscussionMemberInfo.flag);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((localDiscussionMemberInfo.flag & 0x1) != 0) {
          bool = true;
        }
        localFormSwitchItem.setChecked(bool);
      }
    }
    label104:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null)
    {
      FormSwitchItem localFormSwitchItem;
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof lgi)))
        {
          localObject = (lgi)localObject;
          if (paramString != null) {
            break label72;
          }
          a((lgi)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((lgi)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((lgi)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131296768);
    if (localObject == null) {}
    do
    {
      return;
      if (!((String)localObject).equals(getString(2131369432))) {
        break;
      }
    } while (3000 != this.jdField_j_of_type_Int);
    paramView = new Intent(this, SelectMemberActivity.class);
    localObject = ((DiscussionManager)this.app.getManager(52)).a(this.jdField_l_of_type_JavaLangString);
    if (localObject != null) {
      paramView.putStringArrayListExtra("param_uins_selected_default", new ArrayList(((Map)localObject).keySet()));
    }
    paramView.putExtra("param_groupcode", this.jdField_l_of_type_JavaLangString);
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 1);
    if (localObject != null) {}
    for (int i1 = ((Map)localObject).size();; i1 = 0)
    {
      paramView.putExtra("param_max", 100 - i1);
      startActivityForResult(paramView, 2);
      ReportController.b(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
      return;
    }
    if (((String)localObject).equals(this.app.a()))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 0);
      paramView.jdField_f_of_type_Int = 5;
      paramView.jdField_g_of_type_Int = 57;
      ProfileActivity.a(this, paramView, 3);
      return;
    }
    if (((FriendsManager)this.app.getManager(50)).b((String)localObject))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 1);
      paramView.h = ContactUtils.a(this.app, (String)localObject, 0);
      if (3000 != this.jdField_j_of_type_Int)
      {
        paramView.jdField_f_of_type_JavaLangString = ((String)localObject);
        paramView.jdField_e_of_type_Int = this.jdField_j_of_type_Int;
      }
      paramView.jdField_f_of_type_Int = 5;
      paramView.jdField_g_of_type_Int = 57;
      ProfileActivity.a(this, paramView, 3);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)localObject, 46);
    if (this.jdField_j_of_type_Int == 3000)
    {
      localAllInOne.jdField_a_of_type_Int = 46;
      localAllInOne.h = paramView;
      localAllInOne.jdField_f_of_type_JavaLangString = ((String)localObject);
      localAllInOne.jdField_e_of_type_Int = this.jdField_j_of_type_Int;
      if (3000 != this.jdField_j_of_type_Int) {
        break label508;
      }
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    }
    for (;;)
    {
      localAllInOne.jdField_f_of_type_Int = 5;
      localAllInOne.jdField_g_of_type_Int = 57;
      ProfileActivity.a(this, localAllInOne, 3);
      return;
      if (this.jdField_j_of_type_Int == 1000)
      {
        localAllInOne.jdField_a_of_type_Int = 22;
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
        break;
      }
      if (this.jdField_j_of_type_Int == 1001)
      {
        localAllInOne.jdField_a_of_type_Int = 42;
        break;
      }
      if (this.jdField_j_of_type_Int == 1005)
      {
        localAllInOne.jdField_a_of_type_Int = 2;
        break;
      }
      if (this.jdField_j_of_type_Int == 1023)
      {
        localAllInOne.jdField_a_of_type_Int = 74;
        break;
      }
      localAllInOne.jdField_a_of_type_Int = 19;
      break;
      label508:
      if (1000 == this.jdField_j_of_type_Int) {
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904920);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131368647));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  public void a(List paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    int i2;
    DiscussionMemberInfo localDiscussionMemberInfo1;
    int i1;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      localObject = (FriendsManager)this.app.getManager(50);
      localObject = null;
      i2 = 0;
      if (i2 < paramList.size())
      {
        localDiscussionMemberInfo1 = (DiscussionMemberInfo)paramList.get(i2);
        if (localDiscussionMemberInfo1 != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (localDiscussionMemberInfo1.memberUin != null)) {
            if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin))) {
              i1 = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label109:
      if (i1 != 0)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).memberUin = localDiscussionMemberInfo1.memberUin;
        ((DiscussionMemberInfo)localObject).memberName = ContactUtils.a(localDiscussionMemberInfo1, this.app);
      }
      for (;;)
      {
        i2 += 1;
        break;
        if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) || (!localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
          break label307;
        }
        i1 = 1;
        break label109;
        DiscussionMemberInfo localDiscussionMemberInfo2 = new DiscussionMemberInfo();
        localDiscussionMemberInfo2.memberUin = localDiscussionMemberInfo1.memberUin;
        localDiscussionMemberInfo2.memberName = ContactUtils.a(localDiscussionMemberInfo1, this.app);
        localDiscussionMemberInfo2.discussionUin = ChnToSpell.a(localDiscussionMemberInfo2.memberName, 1);
        localArrayList.add(localDiscussionMemberInfo2);
      }
      Collections.sort(localArrayList, new lgg(this));
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localArrayList).sendToTarget();
      }
      return;
      label307:
      i1 = 0;
    }
  }
  
  public void a(lgi paramlgi, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramlgi.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramlgi.jdField_a_of_type_Int, paramlgi.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramlgi.jdField_a_of_type_JavaLangString, paramlgi.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramlgi.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.jdField_l_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      SharedPreferences localSharedPreferences = getSharedPreferences("qrcode", 0);
      this.jdField_a_of_type_Long = localSharedPreferences.getLong("discussionvalidtime" + this.jdField_l_of_type_JavaLangString, 0L);
      this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("discussion" + this.jdField_l_of_type_JavaLangString, null);
      this.jdField_d_of_type_JavaLangString = localSharedPreferences.getString("discussionfullSig" + this.jdField_l_of_type_JavaLangString, null);
      int i1;
      if (this.jdField_a_of_type_Long - System.currentTimeMillis() / 1000L > 0L)
      {
        i1 = 1;
        if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (i1 == 0)) {
          break label248;
        }
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
        i1 = 0;
        break;
        label248:
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_l_of_type_JavaLangString), true);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", getString(2131364455));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_l_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      return;
    }
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "Clk_grptab", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), "", "", "");
      ChatSettingForTroop.a(this, TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16), 2);
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16);
    localBundle.putInt("D2GType", 1);
    ChatSettingForTroop.a(this, localBundle, 2);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
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
            return;
          } while (this.jdField_a_of_type_Lgh == null);
          this.jdField_a_of_type_Lgh.notifyDataSetChanged();
          return;
          u();
          finish();
          return;
          setResult(-1);
          this.jdField_b_of_type_Boolean = true;
          return;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_k_of_type_JavaLangString)));
        if (NetworkUtil.e(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue(), (String)localObject);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
          a(getString(2131369489));
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(1, getString(2131368805));
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
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(paramIntent);
        startActivity((Intent)localObject);
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Lgh == null);
    this.jdField_a_of_type_Lgh.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.a(DiscussionInfoCardActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    j();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.a(DiscussionInfoCardActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnPause()
  {
    m();
    super.doOnPause();
  }
  
  protected void e()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a(2131369562);
    localActionSheet.c(2131370838);
    localActionSheet.d(2131367262);
    localActionSheet.a(new lfs(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void f()
  {
    try
    {
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).longValue();
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(22);
      if (localBizTroopHandler == null) {
        return;
      }
      localBizTroopHandler.b(l1);
      g();
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369764);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void i()
  {
    int i1 = 2131370838;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupUin == 0L))
      {
        this.jdField_i_of_type_Int = 0;
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131370838));
      }
      while (AppSetting.j)
      {
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(i1));
        return;
        TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
        if (localTroopManager == null)
        {
          this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          return;
        }
        if (localTroopManager.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode)) != null)
        {
          this.jdField_i_of_type_Int = 1;
          this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131370839));
          i1 = 2131370839;
        }
        else
        {
          this.jdField_i_of_type_Int = 2;
          this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131370840));
          i1 = 2131370840;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    default: 
      a(paramView);
      return;
    case 2131297560: 
      o();
      return;
    case 2131297566: 
      n();
      return;
    case 2131297565: 
      b();
      return;
    case 2131297568: 
      p();
      return;
    case 2131297569: 
      q();
      return;
    case 2131297570: 
      r();
      return;
    case 2131297573: 
      t();
      return;
    case 2131297567: 
      d();
      return;
    case 2131297563: 
      s();
      return;
    }
    paramView = ActionSheet.a(this);
    paramView.a(2131367698, false);
    paramView.d(2131367262);
    paramView.a(new lfx(this, paramView));
    paramView.show();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(2130838442, "分享多人聊天未初始化成功");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    case 2: 
    case 3: 
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131369529;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label121;
        }
        QRUtils.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131369530;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new lgf(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      paramView = this.app;
      String str1;
      String str2;
      String str3;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        ReportController.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        if (paramInt != 2) {
          break label330;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
        this.jdField_b_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_l_of_type_JavaLangString, true);
        paramAdapterView = null;
        if ((paramView instanceof BitmapDrawable)) {
          paramAdapterView = ((BitmapDrawable)paramView).getBitmap();
        }
        paramView = WXShareHelper.a();
        str1 = this.jdField_b_of_type_JavaLangString;
        str2 = String.format(getString(2131370147), new Object[] { this.jdField_k_of_type_JavaLangString });
        str3 = this.jdField_c_of_type_JavaLangString;
        if (paramInt != 2) {
          break label362;
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        paramView.a(str1, str2, paramAdapterView, "", str3, paramInt);
        break;
        paramAdapterView = "0";
        break label163;
        ReportController.b(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
        break label221;
      }
    case 0: 
      label121:
      label163:
      label221:
      label330:
      label362:
      g();
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_l_of_type_JavaLangString);
      if (paramAdapterView == null) {
        break;
      }
    }
    for (paramInt = paramAdapterView.size();; paramInt = 0)
    {
      a(this.app, this, 11, this.jdField_d_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, paramInt, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      break;
      a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString);
      break;
      a(this.app, this.jdField_a_of_type_Long, this.jdField_c_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString);
      break;
      c();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\DiscussionInfoCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
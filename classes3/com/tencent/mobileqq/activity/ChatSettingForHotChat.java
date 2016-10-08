package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kyp;
import kyt;
import kyz;
import kza;
import kzb;

public class ChatSettingForHotChat
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 10;
  public static final String a = "troopUin";
  private static final int jdField_b_of_type_Int = 1500;
  public static final String b = "memberUin";
  public static final String c = "memberName";
  private static final String e = "ChatSettingForHotChat";
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public HotChatHandler a;
  public HotChatManager a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver;
  HotChatShare jdField_a_of_type_ComTencentMobileqqAppHotChatShare;
  public HotchatSCHelper a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public HotChatInfo a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public QQProgressDialog a;
  public Boolean a;
  public List a;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public String d;
  
  public ChatSettingForHotChat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangBoolean = null;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new kyp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new kyt(this);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ChatSettingForHotChat.class);
    localIntent.putExtra("troopUin", paramString);
    paramActivity.startActivityForResult(localIntent, 2000);
  }
  
  public static void a(HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    if ((paramHotChatInfo == null) || (TextUtils.isEmpty(paramHotChatInfo.troopCode)) || (TextUtils.isEmpty(paramHotChatInfo.troopUin))) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatSettingForHotChat", 2, "startTroopMemberChooseForFlowerActivity.troopcode or troopuin empty...");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent(paramActivity, HotChatMemberListActivity.class);
      localIntent.putExtra("troop_uin", paramHotChatInfo.troopUin);
      localIntent.putExtra("troop_code", paramHotChatInfo.troopCode);
      localIntent.putExtra("troop_owner", paramHotChatInfo.ownerUin);
      localIntent.putExtra("HC_MEMBER_ACTION", 2);
      localIntent.putExtra("from", paramInt);
      paramActivity.startActivityForResult(localIntent, 13003);
      paramActivity.overridePendingTransition(2130968592, 2130968589);
      if (paramInt == 0)
      {
        NearbyFlowerManager.a(paramQQAppInterface, "0X800638B");
        return;
      }
    } while (paramInt != 1);
    NearbyFlowerManager.a(paramQQAppInterface, "0X800638C");
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate == 0)
    {
      i = j;
      if (this.jdField_a_of_type_JavaLangBoolean != null)
      {
        i = j;
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          i = j + 1;
        }
      }
    }
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + i + "人");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("未知");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("ChatSettingForHotChat", "updateAnnouncement", new Object[] { paramString1, paramString2 });
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      if (TextUtils.isEmpty(paramString2))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843273);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setTag(paramString2);
        this.jdField_b_of_type_AndroidViewView.setTag(2131297580, Boolean.valueOf(true));
        return;
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838349);
      }
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memo))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("暂无公告");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel != 0) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoUrl))) {
        break label209;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843273);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setTag(2131297580, Boolean.valueOf(false));
      return;
      paramString1 = new QQText(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memo, 3, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      break;
      label209:
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838349);
    }
  }
  
  public boolean a()
  {
    try
    {
      View localView = View.inflate(this, 2130903185, null);
      super.setContentView(localView);
      setTitle("热聊设置");
      super.setLeftViewName(2131369828);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297574));
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297575);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297577));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297578));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297579));
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131297580);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297582));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131297583));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297573));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297584));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatSettingForHotChat", 2, "", localThrowable);
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name);
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838352);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper == null) {
        break label216;
      }
    }
    label104:
    label194:
    label205:
    label216:
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_JavaLangString, 1, HotchatSCHelper.a());; localObject = null)
    {
      if (localObject != null)
      {
        a(((HotchatSCMng.HotchatNote)localObject).jdField_a_of_type_JavaLangString, ((HotchatSCMng.HotchatNote)localObject).b);
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotThemeGroupFlag != 2)) {
          break label194;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel != 1) {
          break label205;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText("解散该房间");
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838355);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        break;
        a(null, null);
        break label104;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText("退出该房间");
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = this.jdField_a_of_type_AndroidViewView.getWidth();
    int k = AIOUtils.a(0.0F, getResources());
    int m = AIOUtils.a(0.0F, getResources());
    int n = AIOUtils.a(5.0F, getResources());
    int i1 = AIOUtils.a(50.0F, getResources());
    ArrayList localArrayList = new ArrayList(6);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin))) {
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (String)((HashMap)this.jdField_a_of_type_JavaUtilList.get(i)).get("memberUin");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin))) {
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    i = 0;
    if ((i >= localArrayList.size()) || (i * n + k + i * i1 + i1 > j - k)) {
      return;
    }
    Object localObject1 = (String)localArrayList.get(i);
    ImageView localImageView = new ImageView(this);
    Object localObject2 = new LinearLayout.LayoutParams(i1, i1);
    if (i == 0)
    {
      ((LinearLayout.LayoutParams)localObject2).setMargins(k, m, 0, AIOUtils.a(15.0F, getResources()));
      label273:
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
      localObject2 = (FriendsManager)this.app.getManager(50);
      boolean bool = this.app.a().equals(localObject1);
      if ((!((FriendsManager)localObject2).b((String)localObject1)) || (bool)) {
        break label375;
      }
    }
    label375:
    for (localObject1 = FaceDrawable.a(this.app, 1, (String)localObject1);; localObject1 = FaceDrawable.a(this.app, 200, (String)localObject1, true))
    {
      localImageView.setImageDrawable((Drawable)localObject1);
      i += 1;
      break;
      ((LinearLayout.LayoutParams)localObject2).setMargins(n, m, 0, AIOUtils.a(15.0F, getResources()));
      break label273;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatSettingForHotChat", 2, "startTroopMemberActivity.troopcode or troopuin empty...");
      }
      return;
    }
    Intent localIntent = new Intent(this, HotChatMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopCode);
    localIntent.putStringArrayListExtra("troop_admin", (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminUins);
    localIntent.putExtra("troop_owner", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel == 2)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("troop_manage", bool);
      localIntent.putExtra("HC_MEMBER_ACTION", 0);
      startActivity(localIntent);
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ChatSettingForHotChat", 2, "doOnActivityResult.requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (101 == paramInt1) {
      if (-1 == paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
        b();
        setResult(-1);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 101) {
          break;
        }
        paramIntent = paramIntent.getStringArrayListExtra("DelMembers");
      } while (paramIntent == null);
      paramInt1 = 0;
      while (paramInt1 < paramIntent.size())
      {
        localObject = (String)paramIntent.get(paramInt1);
        if (this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        paramInt1 += 1;
      }
      c();
      return;
    } while ((paramInt1 != 3) || (paramInt2 != -1));
    Object localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    startActivity((Intent)localObject);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = getIntent().getStringExtra("troopUin");
    if (!a())
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)this.app.getManager(59));
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler = ((HotChatHandler)this.app.a(35));
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.d);
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramBundle;
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) {
        break label247;
      }
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver, false);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, false);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.d, true);
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate != 1) {
        break label200;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label165:
      g();
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare(this, this.app, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
      return true;
      paramBundle = null;
      break;
      label200:
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid.getBytes(), this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label165;
      label247:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.d);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      QQToast.a(this, 2131367303, 0).b(getTitleBarHeight());
    }
  }
  
  protected void doOnDestroy()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a();
      }
      if (this.app != null)
      {
        this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b();
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = null;
      }
      super.doOnDestroy();
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
  
  public void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131371477));
    localActionSheet.a(getString(2131371476), 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new kyz(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a("确定要解散你的热聊房间吗？");
    localActionSheet.a("解散房间", 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new kza(this, localActionSheet));
    localActionSheet.show();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper == null)
    {
      kzb localkzb = new kzb(this);
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = new HotchatSCHelper(this.app, localkzb, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(10000L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!NetworkUtil.e(this))
          {
            QQToast.a(this, 0, 2131367256, 0).b(getTitleBarHeight());
            return;
          }
          d();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel == 1)
          {
            f();
            return;
          }
          e();
          return;
          if (!((Boolean)paramView.getTag(2131297580)).booleanValue()) {
            break;
          }
          paramView = (String)paramView.getTag();
          localObject = JumpParser.a(this.app, this, paramView);
          if (localObject != null)
          {
            ((JumpAction)localObject).b();
            return;
          }
        } while (TextUtils.isEmpty(paramView));
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        startActivity((Intent)localObject);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.adminLevel == 2))
        {
          paramView = new Intent(this, HotChatAnnounceActivity.class);
          paramView.putExtra("TROOPUIN", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate == 0) {
            paramView.putExtra("CANADDLINK", true);
          }
          for (;;)
          {
            paramView.putExtra("ANNOUCE", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memo);
            paramView.putExtra("LINK", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoUrl);
            startActivityForResult(paramView, 101);
            return;
            paramView.putExtra("CANADDLINK", false);
          }
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoUrl));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoUrl;
      paramView = (View)localObject;
      if (!((String)localObject).startsWith("http")) {
        paramView = "http://" + (String)localObject;
      }
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      startActivity((Intent)localObject);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null);
    NewReportPlugin.a(this, false, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 204, "hotchatroom", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatSettingForHotChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
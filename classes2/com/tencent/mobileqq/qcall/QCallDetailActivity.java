package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYBridgeActivity;
import cooperation.huangye.HuangyeHandler;
import cooperation.huangye.HuangyeImageUtils;
import cooperation.huangye.ipc.HYRemoteManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import tyz;
import tzc;
import tze;
import tzf;
import tzj;
import tzk;
import tzl;
import tzm;
import tzn;
import tzo;
import tzp;
import tzq;
import tzr;
import tzs;
import tzu;
import tzv;
import tzw;
import tzx;
import tzy;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 3;
  private static final String jdField_a_of_type_JavaLangString = "0X8004069";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "0X8004068";
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "QCallDetailActivity";
  public static final int d = 3;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public PstnSessionInfo a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private CLJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig;
  private LightalkShieldHandler jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler;
  private LightalkShieldManager jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager;
  private LightalkShieldObserver jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver;
  private LightalkSwitchHanlder jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder;
  private LightalkSwitchManager jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager;
  private PstnCardInfo jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo;
  private PstnManager jdField_a_of_type_ComTencentMobileqqQcallPstnManager;
  PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private tzy jdField_a_of_type_Tzy;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PstnManager jdField_b_of_type_ComTencentMobileqqQcallPstnManager;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private String k;
  private String l;
  private String m;
  private String n;
  
  public QCallDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tyz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new tzp(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver = new tzq(this);
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new tzs(this);
    this.jdField_b_of_type_ArrayOfByte = new byte[0];
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new tzc(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new tzo(this);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      finish();
    }
    label189:
    do
    {
      return;
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("uintype", 0);
      if (this.jdField_e_of_type_Int == 8) {
        this.jdField_e_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
      }
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("bind_type", 0);
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("bind_id");
      this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_huangye_logo_url");
      this.k = paramIntent.getStringExtra("key_huangye_business_se_id");
      if (this.jdField_g_of_type_Int == 2) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
      }
      if (!VideoUtils.a(this.jdField_e_of_type_Int, this.jdField_g_of_type_Int)) {
        break;
      }
      this.rightViewImg.setVisibility(0);
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("sig");
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("entrance");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_from_lightalk_phone_num", false);
      this.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
      if ((this.jdField_f_of_type_Int == 0) && (!a(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_f_of_type_Int = 1003;
      }
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    } while (this.jdField_i_of_type_Int != -1);
    paramIntent = (PhoneContactManager)this.app.getManager(10);
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      paramIntent = paramIntent.a(this.jdField_d_of_type_JavaLangString);
    }
    while (paramIntent != null)
    {
      this.jdField_i_of_type_Int = paramIntent.contactID;
      return;
      this.rightViewImg.setVisibility(8);
      break label189;
      paramIntent = paramIntent.c(this.jdField_d_of_type_JavaLangString);
      continue;
      paramIntent = paramIntent.b(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(50)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130904104, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297019));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296829));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299800));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301401));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301402));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301403));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301404));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301405));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301413));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301398));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301407));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301395));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301416));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301409));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301412);
    int i1 = getResources().getColor(2131428215);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i1);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301406);
    ((View)localObject1).setBackgroundColor(i1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297384);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298784);
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_d_of_type_JavaLangString));
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301415);
      ((TextView)localObject1).setContentDescription(getString(2131371111));
      ((TextView)localObject1).setOnClickListener(this);
      d();
      if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131363712));
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
      a(true);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(new tzu(this));
      if (this.jdField_i_of_type_Int != -1)
      {
        localObject1 = this.app.a().createEntityManager().a(PhoneContact.class, false, "contactID = " + this.jdField_i_of_type_Int, null, null, null, null, null);
        ReportController.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.jdField_e_of_type_Int == 26)
        {
          localObject1 = new ArrayList();
          localObject2 = new PhoneContact();
          ((PhoneContact)localObject2).mobileNo = this.jdField_d_of_type_JavaLangString;
          ((PhoneContact)localObject2).type = 0;
          ((PhoneContact)localObject2).label = "电话";
          ((List)localObject1).add(localObject2);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301410).setVisibility(0);
            localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301411);
            ((NoScrollListView)localObject2).setVisibility(0);
            localObject1 = new PhoneNumberAdapter(this, (List)localObject1);
            ((PhoneNumberAdapter)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig);
            ((NoScrollListView)localObject2).setAdapter((ListAdapter)localObject1);
            ((NoScrollListView)localObject2).setOnItemClickListener(new tzv(this));
          }
          return;
        }
      }
      break;
    case 3000: 
      label659:
      label712:
      if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager == null) || (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() != 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, this.jdField_d_of_type_JavaLangString));
        localObject3 = (DiscussionManager)this.app.getManager(52);
        if (localObject3 == null) {
          break label1551;
        }
        i1 = ((DiscussionManager)localObject3).a(this.jdField_d_of_type_JavaLangString);
      }
      break;
    }
    for (;;)
    {
      if (i1 > 0)
      {
        localObject3 = "(" + i1 + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      }
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (localObject1 != null))
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        ((View)localObject1).setVisibility(8);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject2).setVisibility(8);
        findViewById(2131301394).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break;
        localObject3 = FaceDrawable.a(1001, 3);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1001, this.jdField_d_of_type_JavaLangString, 1, (Drawable)localObject3, (Drawable)localObject3));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ContactUtils.e(this.app, this.jdField_d_of_type_JavaLangString));
        i1 = ContactUtils.a(this.app, this.jdField_d_of_type_JavaLangString);
        continue;
      }
      ((ImageView)localObject2).setVisibility(0);
      findViewById(2131301394).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 200, this.jdField_d_of_type_JavaLangString, true));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(ContactUtils.d(this.jdField_f_of_type_JavaLangString));
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131370698);
      ((View)localObject1).setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      findViewById(2131301394).setVisibility(8);
      break;
      ((TextView)localObject3).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      HuangyeImageUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_j_of_type_JavaLangString, true, true, this.jdField_f_of_type_JavaLangString);
      break;
      localObject2 = (PhoneContactManager)this.app.getManager(10);
      if (localObject2 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_h_of_type_JavaLangString);; localObject1 = null)
      {
        if ((localObject2 != null) && (this.jdField_h_of_type_JavaLangString != null)) {
          localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + localObject1);
          }
          if (localObject1 != null)
          {
            localObject2 = FaceDrawable.b(this.app, this.jdField_h_of_type_JavaLangString, (byte)3);
            this.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break;
          }
          localObject1 = this.app.a(16, this.jdField_d_of_type_JavaLangString, (byte)3, true, 16);
          localObject2 = ((QCallCardManager)this.app.getManager(139)).a(this.jdField_d_of_type_JavaLangString);
          if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          break;
          this.n = null;
          PhoneContact localPhoneContact = OpenSDKUtils.a(this.app, this.jdField_d_of_type_JavaLangString);
          if (localPhoneContact != null) {
            this.n = localPhoneContact.uin;
          }
          if (this.n == null)
          {
            ((ImageView)localObject2).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(ContactUtils.d(this.jdField_f_of_type_JavaLangString));
          }
          for (;;)
          {
            findViewById(2131301394).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((View)localObject1).setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break;
            ((ImageView)localObject2).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(OpenSDKUtils.a(this.app, this.jdField_d_of_type_JavaLangString));
          }
          break label712;
          localObject1 = null;
          break label659;
        }
      }
      label1551:
      i1 = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_e_of_type_Int == 3000)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    do
    {
      int i1;
      do
      {
        return;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        if (QLog.isColorLevel()) {
          QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.jdField_d_of_type_JavaLangString + " , uinType = " + this.jdField_e_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataFriends = localFriendsManager.c(this.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends == null) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() + ", friend.detalStatusFlag：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag + ", friend.iTermType：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        }
        i1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840617);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131363712);
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131363712));
          return;
        }
      } while (i1 == 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131371113);
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371113));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131371114);
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371114));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131371115);
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371115));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131371117));
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371117));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131371118));
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371118));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131371119));
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371119));
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840604);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131371116);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131371116));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((this.jdField_e_of_type_Int != 25) && (this.jdField_e_of_type_Int != 26));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840617);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131363712);
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131363712));
  }
  
  private void e()
  {
    if (this.jdField_e_of_type_Int == 3000)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
      if (TextUtils.isEmpty(((QCallRecent)localObject2).pstnInfo)) {}
      Object localObject1;
      Object localObject3;
      int i1;
      label156:
      do
      {
        do
        {
          return;
          localObject1 = (PhoneContactManager)this.app.getManager(10);
          localObject3 = PstnUtils.a(((QCallRecent)localObject2).pstnInfo);
        } while (localObject3 == null);
        localObject2 = new StringBuilder();
        i1 = 0;
        if (i1 < ((ArrayList)localObject3).size())
        {
          PhoneContact localPhoneContact = ((PhoneContactManager)localObject1).b(((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.mobile);
          if (localPhoneContact == null) {
            break;
          }
          ((StringBuilder)localObject2).append(localPhoneContact.name).append("、");
          if (i1 <= 2) {
            break label498;
          }
        }
      } while (((StringBuilder)localObject2).length() <= 0);
      ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
      if (((ArrayList)localObject3).size() > 1)
      {
        localObject1 = getString(2131363737, new Object[] { "" + ((ArrayList)localObject3).size() });
        label227:
        i1 = getResources().getDisplayMetrics().widthPixels;
        int i2 = getResources().getDimensionPixelSize(2131494057);
        localObject3 = new Paint(1);
        ((Paint)localObject3).setColor(-1);
        ((Paint)localObject3).setTextSize(getResources().getDimensionPixelSize(2131494053));
        float f1 = ((Paint)localObject3).measureText((String)localObject1);
        this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams((int)f1 + 1, -2));
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        i1 = i1 - i2 - ((int)f1 + 1);
        f1 = ((Paint)localObject3).measureText(((StringBuilder)localObject2).toString());
        if (i1 <= f1) {
          break label518;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams((int)f1, -2));
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        return;
        if (TextUtils.isEmpty(((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.mobile)) {
          break label156;
        }
        if (((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.nationState == 0)
        {
          ((StringBuilder)localObject2).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.mobile).append("、");
          break label156;
        }
        ((StringBuilder)localObject2).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.nation).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(i1)).telInfo.mobile).append("、");
        break label156;
        label498:
        i1 += 1;
        break;
        localObject1 = getString(2131363738);
        break label227;
        label518:
        this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams(i1, -2));
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25) || (this.jdField_e_of_type_Int == 26))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130904103, null));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription(getString(2131363714));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131301391);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131301921);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131301391));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131301390);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131301921);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131301390));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131301389);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131301921);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131301389));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131367902);
    if (this.jdField_e_of_type_Int == 3000)
    {
      localButton1.setContentDescription("发消息");
      localButton3.setText(2131370027);
      localButton3.setContentDescription("QQ电话");
      localLinearLayout2.setVisibility(8);
    }
    do
    {
      return;
      if (this.jdField_e_of_type_Int == 9502)
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText("拨打手机");
        localButton3.setContentDescription("点击拨打手机");
        return;
      }
      if (this.jdField_e_of_type_Int == 1008)
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText("QQ电话");
        localButton3.setContentDescription(getString(2131371130));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131370026);
        localButton3.setContentDescription(getString(2131371130));
        return;
      }
      localButton1.setContentDescription("发消息");
      localButton3.setText(2131370026);
      localButton3.setContentDescription("QQ电话");
      if (!CrmUtils.b(this.app, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int))
      {
        localLinearLayout2.setVisibility(0);
        localButton2.setText(2131371128);
        localButton2.setContentDescription("视频电话");
        return;
      }
      localLinearLayout2.setVisibility(8);
    } while ((this.jdField_g_of_type_Int != 2) && (this.jdField_g_of_type_Int != 3) && (this.jdField_e_of_type_Int != 25));
    localLinearLayout2.setVisibility(8);
    localButton3.setContentDescription(getString(2131371129));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131301393));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25) || (this.jdField_e_of_type_Int == 26)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_Tzy = new tzy(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Tzy);
  }
  
  private void h()
  {
    if (this.jdField_e_of_type_Int == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_e_of_type_Int, this.l, true, true, null, null);
      return;
    }
    if (this.jdField_e_of_type_Int == 9502)
    {
      HYRemoteManager.a(this.app, "callDetailPage");
      ((HuangyeHandler)this.app.a(9)).a().a(this, this.jdField_d_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.k, this.m);
      return;
    }
    Object localObject;
    if ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3) || (this.jdField_e_of_type_Int == 25))
    {
      localObject = new HashMap();
      ((Map)localObject).put("dstClient", "Lightalk");
      ((Map)localObject).put("bindType", String.valueOf(this.jdField_g_of_type_Int));
      ((Map)localObject).put("bindId", this.jdField_g_of_type_JavaLangString);
      ((Map)localObject).put("extraType", String.valueOf(this.jdField_h_of_type_Int));
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        String str = HexUtil.a(this.jdField_a_of_type_ArrayOfByte);
        if (QLog.isColorLevel())
        {
          QLog.d("QCallDetailActivity", 2, "mLightalksig = " + this.jdField_a_of_type_ArrayOfByte);
          QLog.d("QCallDetailActivity", 2, "sig = " + str);
        }
        ((Map)localObject).put("sig", str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCallDetailActivity", 2, "mBindId = " + this.jdField_g_of_type_JavaLangString + ", mBindType = " + this.jdField_g_of_type_Int + ", mExtraType = " + this.jdField_h_of_type_Int + ", mUinType = " + this.jdField_e_of_type_Int + ", mPhoneNumber = " + this.jdField_h_of_type_JavaLangString);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004E96", "0X8004E96", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_e_of_type_Int, this.l, this.jdField_f_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, true, this.jdField_e_of_type_JavaLangString, true, true, null, "from_internal", (Map)localObject);
      return;
    }
    ReportController.b(this.app, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.jdField_e_of_type_Int == 1008)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("businessName", this.jdField_f_of_type_JavaLangString);
      ((Bundle)localObject).putString("uin", this.l);
      ((Bundle)localObject).putString("from_where", "callDetailPage");
      C2BUtils.a(this.app, this, (Bundle)localObject);
      return;
    }
    if (this.jdField_e_of_type_Int == 1024)
    {
      CrmUtils.a(this.app, this, this.jdField_f_of_type_JavaLangString, this.l, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.jdField_e_of_type_Int, this.l, this.jdField_f_of_type_JavaLangString, this.m, true, this.jdField_e_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  private void i()
  {
    if (this.jdField_f_of_type_Int == 1024)
    {
      localObject = new Intent(this, EqqAccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_d_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivityForResult((Intent)localObject, 2000);
      return;
    }
    if (this.jdField_f_of_type_Int == 1008)
    {
      localObject = new Intent(this, AccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_d_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1008);
      ((Intent)localObject).putExtra("source", 113);
      startActivityForResult((Intent)localObject, 2000);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne(this.jdField_d_of_type_JavaLangString, 46);
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 19;
    ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_d_of_type_JavaLangString);
    label300:
    label336:
    Intent localIntent;
    switch (this.jdField_f_of_type_Int)
    {
    default: 
      if ((this.jdField_f_of_type_Int != 1001) && (this.jdField_f_of_type_Int != 1010)) {
        break label627;
      }
      if (this.jdField_f_of_type_Int == 1001)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!Utils.a(this.jdField_d_of_type_JavaLangString, this.app.a())) {
          break label615;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 20;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 42;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 76;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 22;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 70;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 47;
      ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break label300;
      if (TextUtils.isEmpty(this.n)) {
        break;
      }
      if (this.n.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
        break label300;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaLangString = this.n;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.n);
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break label300;
      j();
      return;
      if (this.jdField_f_of_type_Int != 1010) {
        break label336;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 13;
      break label336;
      label615:
      localIntent.putExtra("param_mode", 3);
    }
    label627:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  private void j()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_d_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((QCallCardManager)this.app.getManager(139)).a(this.jdField_d_of_type_JavaLangString);
    Object localObject = (PhoneContactManager)this.app.getManager(10);
    if ((localObject != null) && (this.jdField_h_of_type_JavaLangString != null)) {}
    for (localObject = ((PhoneContactManager)localObject).c(this.jdField_h_of_type_JavaLangString);; localObject = null)
    {
      if (localQCallCardInfo != null)
      {
        localAllInOne.jdField_h_of_type_JavaLangString = localQCallCardInfo.nickname;
        localAllInOne.jdField_a_of_type_Byte = ((byte)localQCallCardInfo.gender);
        if (QLog.isColorLevel()) {
          QLog.i("startQCallProfileCardActivity ", 2, "QCallCardInfo.uin = " + localQCallCardInfo.uin + "QCallCardInfo.nickname = " + localQCallCardInfo.nickname + "mPhoneNumber = " + this.jdField_h_of_type_JavaLangString + "mFriendUin = " + this.jdField_d_of_type_JavaLangString);
        }
      }
      if (localObject != null) {
        localAllInOne.jdField_h_of_type_JavaLangString = ((PhoneContact)localObject).name;
      }
      if (((localObject != null) || (localQCallCardInfo != null)) && (this.jdField_h_of_type_JavaLangString != null))
      {
        localAllInOne.jdField_a_of_type_Int = 80;
        localObject = new ProfileActivity.CardContactInfo("电话", this.jdField_h_of_type_JavaLangString, "");
        if (localAllInOne.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localAllInOne.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.jdField_e_of_type_Int != 25) {
          break label293;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label293:
      while ((this.jdField_e_of_type_Int != 24) && (this.jdField_g_of_type_Int != 2) && (this.jdField_g_of_type_Int != 3)) {
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    startActivityForResult(localIntent, 2000);
  }
  
  public void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    Object localObject;
    label113:
    label148:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig != null) {
      if ((NetworkUtil.e(paramContext)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_g_of_type_JavaLangString)))
      {
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_g_of_type_JavaLangString, 0, 0, null, null, false);
        localActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_f_of_type_JavaLangString, (Drawable)localObject, 0);
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[1] = 2;
        this.jdField_a_of_type_ArrayOfInt[2] = 3;
        ReportController.b(this.app, "CliOper", "", "", "0X8005AF7", "0X8005AF7", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
        QQAppInterface localQQAppInterface = this.app;
        PstnSessionInfo localPstnSessionInfo = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
        if (this.jdField_e_of_type_Int != 56938) {
          break label309;
        }
        localObject = paramString;
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(localQQAppInterface, localPstnSessionInfo, (String)localObject, this.jdField_e_of_type_Int);
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b = paramString;
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c == null) || (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() != 1)) {
          break label317;
        }
        i1 = 1;
        label217:
        this.jdField_j_of_type_Int = 0;
        if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
            break label323;
          }
          this.jdField_j_of_type_Int = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int != 26) {
        break label360;
      }
      OpenSDKUtils.a(this.app, paramContext, paramString, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 2);
      return;
      localActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_f_of_type_JavaLangString);
      break;
      this.jdField_a_of_type_ArrayOfInt[0] = 2;
      this.jdField_a_of_type_ArrayOfInt[1] = 3;
      break label113;
      label309:
      localObject = this.jdField_d_of_type_JavaLangString;
      break label148;
      label317:
      i1 = 0;
      break label217;
      label323:
      if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0)) {
        this.jdField_j_of_type_Int = 2;
      } else {
        this.jdField_j_of_type_Int = 5;
      }
    }
    label360:
    if (i1 != 0)
    {
      localActionSheet.a(2131372446);
      if (this.jdField_j_of_type_Int == 1)
      {
        localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839269), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      localActionSheet.d(2131367262);
      localActionSheet.a(new tzw(this));
      localActionSheet.a(new tzx(this, paramContext, paramString, localActionSheet));
      localActionSheet.show();
      ReportController.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
      return;
      if (this.jdField_j_of_type_Int == 2)
      {
        localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839268), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
      }
      else
      {
        localActionSheet.a(getResources().getString(2131372444), getResources().getDrawable(2130839267), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
        continue;
        localActionSheet.c(2131372177);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (DiscussionManager)this.app.getManager(52);
      } while (localObject1 == null);
      localObject2 = ((DiscussionManager)localObject1).a(paramString);
    } while ((localObject2 == null) || (((DiscussionInfo)localObject2).discussionName == null));
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager == null) || (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() != 1))
    {
      this.jdField_f_of_type_JavaLangString = ((DiscussionInfo)localObject2).discussionName;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, paramString));
      i1 = ((DiscussionManager)localObject1).a(paramString);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      if (i1 <= 0) {
        break label227;
      }
    }
    label227:
    for (paramString = "(" + i1 + ")";; paramString = "")
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      return;
      this.jdField_f_of_type_JavaLangString = ContactUtils.e(this.app, paramString);
      i1 = ContactUtils.a(this.app, paramString);
      localObject2 = FaceDrawable.a(1001, 3);
      localObject1 = FaceDrawable.a(this.app, 1001, this.jdField_d_of_type_JavaLangString, 1, (Drawable)localObject2, null);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = FaceDrawable.a(this.app, 101, this.jdField_d_of_type_JavaLangString, 1, (Drawable)localObject2, (Drawable)localObject2);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = VipFunCallManager.a(this.app, this.jdField_d_of_type_JavaLangString, 6, true, null);
    if ((i1 == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (VipSetFunCallHandler)this.app.a(46);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.jdField_d_of_type_JavaLangString));
      ((Bundle)localObject2).putString("phone", "");
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, true);
      ((VipSetFunCallHandler)localObject1).a(2, localObject2);
      if (i1 == 0)
      {
        localObject1 = getResources().getString(2131370394);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131370394);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCallDetailActivity", 1, "VipSetFunCallHandler Error:" + localException.getMessage());
        continue;
        String str = VipFunCallManager.b(this.app, i1, -1, "name");
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    String str;
    do
    {
      do
      {
        boolean bool1;
        do
        {
          return;
          boolean bool2 = false;
          bool1 = bool2;
          if (paramIntent != null)
          {
            bool1 = bool2;
            if (paramIntent.getExtras() != null) {
              bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
            }
          }
        } while (!bool1);
        finish();
        return;
      } while (paramIntent == null);
      str = paramIntent.getStringExtra("roomId");
    } while (TextUtils.isEmpty(str));
    paramIntent = paramIntent.getStringArrayListExtra("qqPhoneUserList");
    ChatActivityUtils.a(this.app, this, 3000, str, true, true, true, null, paramIntent, 1, 2);
    ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 1, 0, "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904102);
    ThreadManager.a(new tzr(this), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    this.rightViewImg.setImageResource(2130838587);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setContentDescription("更多按钮，点击进入");
    paramBundle = getString(2131371102);
    setTitle(paramBundle, paramBundle + getString(2131363973));
    setLeftViewName(2131371103);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.app.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager = ((LightalkSwitchManager)this.app.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder = ((LightalkSwitchHanlder)this.app.a(52));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager = ((LightalkShieldManager)this.app.getManager(138));
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager = ((PstnManager)this.app.getManager(142));
    a(getIntent());
    c();
    f();
    g();
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.addObserver(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    if ((this.jdField_e_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_d_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler = ((LightalkShieldHandler)this.app.a(78));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler.a();
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    if (this.jdField_e_of_type_Int == 25) {
      ReportController.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager = ((PstnManager)this.app.getManager(142));
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo = this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a(this.app.a());
      return true;
      if ((this.jdField_e_of_type_Int == 24) || (this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3)) {
        ReportController.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    try
    {
      e();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    this.l = null;
    this.m = null;
    int i1;
    if ((this.jdField_e_of_type_Int == 1006) || (this.jdField_e_of_type_Int == 9502))
    {
      this.m = this.jdField_d_of_type_JavaLangString;
      i1 = paramView.getId();
      if (2131301921 != i1) {
        break label2725;
      }
    }
    label305:
    label315:
    label484:
    label548:
    label561:
    label698:
    label871:
    label1677:
    label1822:
    label1859:
    label2004:
    label2136:
    label2719:
    label2725:
    for (;;)
    {
      int i2;
      try
      {
        i2 = ((Integer)paramView.getTag()).intValue();
        i1 = i2;
      }
      catch (Exception localException1)
      {
        continue;
        finish();
        return;
      }
      boolean bool4;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject;
      switch (i1)
      {
      default: 
        return;
        this.l = this.jdField_d_of_type_JavaLangString;
        break;
      case 2131297083: 
      case 2131297392: 
        ReportController.b(this.app, "CliOper", "", "", "0X8004E6D", "0X8004E6D", 0, 0, "", "", "", "");
        paramView = (ActionSheet)ActionSheetHelper.a(this, null);
        bool4 = false;
        bool1 = false;
        boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.b();
        if (this.jdField_e_of_type_Int == 26)
        {
          PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(this.jdField_d_of_type_JavaLangString);
          bool2 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager.a(localPhoneNumberInfo.jdField_a_of_type_JavaLangString + "-" + localPhoneNumberInfo.c);
          i1 = this.jdField_e_of_type_Int;
          bool3 = false;
          bool1 = false;
        }
        for (;;)
        {
          if (!bool2) {
            break label698;
          }
          i2 = 2131369507;
          paramView.c(i2);
          paramView.c(2131369311);
          paramView.d(2131367262);
          paramView.a(new tze(this));
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "isFriend:" + bool3 + " isQCallUin:" + bool1 + " isSwitch:" + bool5 + " isSield:" + bool2 + " mFriendUin:" + this.jdField_d_of_type_JavaLangString);
          }
          paramView.a(new tzf(this, bool2, bool3, bool5, i1, paramView));
          paramView.show();
          return;
          if ((this.jdField_e_of_type_Int == 0) && (!((FriendsManager)this.app.getManager(50)).b(this.jdField_d_of_type_JavaLangString)))
          {
            i1 = 1003;
            if ((i1 != 0) || (!((FriendsManager)this.app.getManager(50)).b(this.jdField_d_of_type_JavaLangString))) {
              break label548;
            }
            bool2 = true;
          }
          try
          {
            for (;;)
            {
              Long.parseLong(this.jdField_d_of_type_JavaLangString);
              if (bool5) {
                break label561;
              }
              bool4 = true;
              bool3 = bool2;
              bool2 = bool4;
              break;
              i1 = this.jdField_e_of_type_Int;
              break label484;
              bool2 = false;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              bool1 = true;
            }
          }
        }
        if (bool2)
        {
          localObject = (FriendsManager)this.app.getManager(50);
          if ((localObject == null) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
            break label2719;
          }
        }
      case 2131301415: 
      case 2131301391: 
      case 2131301390: 
      case 2131301389: 
      case 2131301395: 
      case 2131301407: 
      case 2131301396: 
      case 2131301398: 
      case 2131301402: 
        for (bool3 = ((FriendsManager)localObject).e(this.jdField_d_of_type_JavaLangString);; bool3 = false)
        {
          bool4 = bool2;
          bool2 = bool3;
          bool3 = bool4;
          break label305;
          if (bool1)
          {
            bool4 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager.a(UinUtils.a(this.jdField_d_of_type_JavaLangString));
            bool3 = bool2;
            bool2 = bool4;
            break label305;
          }
          localObject = (ShieldMsgManger)this.app.getManager(15);
          if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
          {
            bool4 = ((ShieldMsgManger)localObject).a(this.jdField_d_of_type_JavaLangString);
            bool3 = bool2;
            bool2 = bool4;
            break label305;
            i2 = 2131369505;
            break label315;
            ReportController.b(this.app, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Tc_msg_dinfo", 0, 0, "", "", "", "");
            if (this.jdField_e_of_type_Int == 3000)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004F93", "0X8004F93", 0, 0, "", "", "", "");
              if ((this.jdField_g_of_type_Int != 2) && (this.jdField_g_of_type_Int != 3) && (this.jdField_e_of_type_Int != 25)) {
                break label871;
              }
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(this.jdField_d_of_type_JavaLangString, 8);
            }
            for (;;)
            {
              b(true);
              this.jdField_a_of_type_Tzy.a.clear();
              this.jdField_a_of_type_Tzy.notifyDataSetChanged();
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8004F8D", "0X8004F8D", 0, 0, "", "", "", "");
              break;
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
            }
            if (this.jdField_e_of_type_Int == 3000)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
              ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              paramView = AIOUtils.a(new Intent(this, SplashActivity.class), null);
              paramView.putExtra("uin", this.jdField_d_of_type_JavaLangString);
              paramView.putExtra("uintype", this.jdField_e_of_type_Int);
              paramView.putExtra("uinname", this.jdField_f_of_type_JavaLangString);
              paramView.putExtra("entrance", 0);
              startActivity(paramView);
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
            }
            ReportController.b(this.app, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_e_of_type_Int), "", "");
            ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
            if (this.jdField_e_of_type_Int == 1024)
            {
              if (CrmUtils.b(this.app, this.l, this.jdField_e_of_type_Int))
              {
                CrmUtils.a(this.app, this, this.jdField_f_of_type_JavaLangString, this.l, "IvrCallDetailEngineFalse");
                ReportController.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
                return;
              }
              QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QCallDetailActivity", 2, "Don't support ivr");
              return;
            }
            ChatActivityUtils.a(this.app, this, this.jdField_e_of_type_Int, this.l, this.jdField_f_of_type_JavaLangString, this.m, false, this.jdField_e_of_type_JavaLangString, true, true, null, "from_internal");
            return;
            if (this.jdField_e_of_type_Int == 9502)
            {
              h();
              return;
            }
            if (this.jdField_e_of_type_Int == 3000)
            {
              if (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1)
              {
                paramView = VideoActionSheet.a(this);
                paramView.a(2131372446);
                paramView.c(2131368096);
                if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_multi_call_time > 0)
                {
                  this.jdField_j_of_type_Int = 3;
                  paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839269), 0);
                  ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
                }
                for (;;)
                {
                  paramView.d(2131367262);
                  paramView.a(new tzj(this));
                  paramView.a(new tzk(this, paramView));
                  paramView.show();
                  return;
                  if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.c() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_multi_try_status == 0))
                  {
                    this.jdField_j_of_type_Int = 4;
                    paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839268), 0);
                    ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
                  }
                  else
                  {
                    this.jdField_j_of_type_Int = 5;
                    paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839267), 0);
                    ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
                  }
                }
              }
              h();
              return;
            }
            this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
            this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.app, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null) && (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1))
            {
              i1 = 1;
              this.jdField_j_of_type_Int = 0;
              if (i1 != 0)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                  break label1822;
                }
                this.jdField_j_of_type_Int = 1;
              }
              if (i1 == 0) {
                break label2004;
              }
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
              paramView = VideoActionSheet.a(this);
              paramView.a(2131372446);
              paramView.c(2131368096);
              if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                break label1859;
              }
              this.jdField_j_of_type_Int = 1;
              paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839269), 0);
              ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            }
            for (;;)
            {
              paramView.d(2131367262);
              paramView.a(new tzl(this));
              paramView.a(new tzm(this, paramView));
              paramView.show();
              return;
              i1 = 0;
              break;
              if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
              {
                this.jdField_j_of_type_Int = 2;
                break label1677;
              }
              this.jdField_j_of_type_Int = 5;
              break label1677;
              if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
              {
                this.jdField_j_of_type_Int = 2;
                paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839268), 0);
                ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
              }
              else
              {
                this.jdField_j_of_type_Int = 5;
                paramView.a(getResources().getString(2131372444), getResources().getDrawable(2130839267), 0);
                ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
              }
            }
            h();
            return;
            if (this.jdField_e_of_type_Int == 26)
            {
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.app, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
              if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null) && (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1))
              {
                i1 = 1;
                this.jdField_j_of_type_Int = 0;
                if (i1 != 0)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                    break label2136;
                  }
                  this.jdField_j_of_type_Int = 1;
                }
              }
              for (;;)
              {
                OpenSDKUtils.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 2);
                return;
                i1 = 0;
                break;
                if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0)) {
                  this.jdField_j_of_type_Int = 2;
                } else {
                  this.jdField_j_of_type_Int = 5;
                }
              }
            }
            paramView = PstnUtils.a(this.app, this.l, 3000);
            localObject = new ArrayList();
            if (paramView != null)
            {
              i1 = 0;
              while (i1 < paramView.size())
              {
                ((ArrayList)localObject).add(((AVPhoneUserInfo)paramView.get(i1)).telInfo.mobile);
                i1 += 1;
              }
            }
            ChatActivityUtils.a(this.app, this, this.jdField_e_of_type_Int, this.l, true, true, true, null, (ArrayList)localObject, 1, 2);
            ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 1, 0, "", "", "", "");
            return;
            i1 = ((SVIPHandler)this.app.a(13)).h();
            if (i1 == 2) {
              i1 = 0;
            }
            for (;;)
            {
              paramView = new Intent(this, QQBrowserActivity.class);
              paramView.putExtra("individuation_url_type", 40304);
              VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, paramView, true, -1);
              ReportController.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i1, "", "", "");
              return;
              if (i1 == 3)
              {
                i1 = 2;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("QCallDetailActivity", 2, "qq_call_lightalk_download onclick");
                }
                paramView = new Intent(this, QQBrowserActivity.class);
                paramView.putExtra("url", "http://laidian.qq.com");
                ReportController.b(this.app, "CliOper", "", "", "0X8004E97", "0X8004E97", 0, 0, "", "", "", "");
                startActivity(paramView);
                return;
                switch (this.jdField_e_of_type_Int)
                {
                case 2016: 
                case 56938: 
                default: 
                  i();
                  ReportController.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
                  return;
                case 3000: 
                  if (this.jdField_a_of_type_Boolean) {
                    break;
                  }
                  ReportController.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
                  a();
                  return;
                case 9502: 
                  this.app.a(9);
                  paramView = new Intent(this, HYBridgeActivity.class);
                  paramView.putExtra("clickPos", "QQMainUI");
                  paramView.putExtra("keyword", this.jdField_f_of_type_JavaLangString);
                  paramView.putExtra("phone", this.m);
                  paramView.putExtra("jump_other", true);
                  paramView.putExtra("key_huangye_logo_url", this.jdField_j_of_type_JavaLangString);
                  paramView.putExtra("key_huangye_business_se_id", this.k);
                  startActivity(paramView);
                  return;
                }
              }
            }
          }
          bool3 = bool2;
          bool2 = bool4;
          break label305;
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    }
    ChatActivityUtils.a();
    if (this.jdField_a_of_type_Tzy != null)
    {
      this.jdField_a_of_type_Tzy.a = null;
      this.jdField_a_of_type_Tzy = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.deleteObserver(this);
    }
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i3 = 0;
    if (this.jdField_a_of_type_Tzy == null) {}
    label10:
    do
    {
      break label10;
      do
      {
        return;
      } while ((paramObservable == null) || (!(paramObservable instanceof QCallFacade)) || (paramObject == null) || (!(paramObject instanceof List)));
      paramObservable = (List)paramObject;
    } while ((paramObservable.isEmpty()) || (!(paramObservable.get(0) instanceof QCallRecord)));
    int i1 = 0;
    for (;;)
    {
      int i2 = i3;
      if (i1 < paramObservable.size())
      {
        if (!(paramObservable.get(i1) instanceof QCallRecord)) {
          break;
        }
        paramObject = (QCallRecord)paramObservable.get(i1);
        if ((TextUtils.isEmpty(((QCallRecord)paramObject).friendUin)) || (!((QCallRecord)paramObject).friendUin.equals(this.jdField_d_of_type_JavaLangString)) || (((QCallRecord)paramObject).uinType != this.jdField_e_of_type_Int)) {
          break label157;
        }
        i2 = 1;
      }
      if (i2 == 0) {
        break;
      }
      runOnUiThread(new tzn(this, paramObservable));
      return;
      label157:
      i1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\QCallDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.activity.phone;

import MyCarrier.Carrier;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import oon;
import ooo;
import oop;
import ooq;
import oor;
import oos;
import oot;
import oou;
import oov;
import oow;
import oox;
import ooy;

public class ContactListView
  extends BaseActivityView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  protected static final String a = "QQwangting";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected static final String b = "txl_show_bluebar";
  protected static final String c = "txl_clk_bluebar";
  protected static final String d = "txl_close_bluebar";
  protected static final String e = "show_bluebar";
  protected static final String f = "clk_bluebar";
  public static final int g = 1;
  protected static final String g = "close_bluebar";
  static final int jdField_h_of_type_Int = 2;
  private static final String jdField_h_of_type_JavaLangString = "未启用通讯录的联系人";
  static final int jdField_i_of_type_Int = 3;
  private static final String jdField_i_of_type_JavaLangString;
  public static final int j = 4;
  private static final String j = "contact_bind_info_global";
  public static final int k = 5;
  private static final String k = "business_show_count";
  public static final int l = 6;
  private static final int n = 1;
  private static final int o = 2;
  private static final int p = 3;
  private static final int q = 1;
  private static final int r = 1000;
  private static final int s = 1001;
  private static final int u = 3;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ooo(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new oop(this);
  public ForwardBaseOption a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = new oot(this);
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  List jdField_a_of_type_JavaUtilList;
  public oou a;
  oov jdField_a_of_type_Oov;
  private oow jdField_a_of_type_Oow;
  public ooy a;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  public List b;
  private View jdField_c_of_type_AndroidViewView;
  private List jdField_c_of_type_JavaUtilList;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  private View g;
  public int m;
  private int t = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    i = ContactListView.class.getSimpleName();
  }
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2130903434);
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "ContactListView()");
    }
    this.jdField_a_of_type_Ooy = new ooy(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298581));
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130904932, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131300876).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidViewView);
    this.e = c();
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.e);
    if (paramInt == 4)
    {
      this.jdField_d_of_type_AndroidViewView = b();
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_d_of_type_AndroidViewView);
    }
    a("P_CliOper", "QQwangting", "txl_show_bluebar", "show_bluebar");
    a(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298582));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 4) || (paramInt == 5))
    {
      this.jdField_a_of_type_Oov = new oov(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Oov);
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
      return;
    }
    this.jdField_a_of_type_Oou = new oou(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Oou);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  private View a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "generateMergeContactsView()");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
    if (this.f == null) {
      this.f = LayoutInflater.from(getContext()).inflate(2130905033, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    }
    this.f.findViewById(2131305093).setOnClickListener(new oor(this));
    this.f.findViewById(2131305090).setOnClickListener(new oos(this));
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)this.f.findViewById(2131305092)).setText(paramString);
    }
    return this.f;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    paramView = (oox)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i1 = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i1 == 2)
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (i1 != 2) {
        break label207;
      }
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).c(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ((Friends)localObject1).getFriendNickWithAlias());
          if (((Friends)localObject1).cSpecialFlag == 1) {
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
    }
    label207:
    while (i1 != 3)
    {
      return;
      paramView = "1";
      break;
    }
    paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    localObject2 = paramView.nationCode + paramView.mobileNo;
    paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
    paramView.putExtra("entrance", 3);
    paramView.putExtra("uin", ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode);
    paramView.putExtra("phonenum", (String)localObject2);
    paramView.putExtra("uintype", 1006);
    paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
    localObject2 = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 31);
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    ((ProfileActivity.AllInOne)localObject2).h = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).k = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).d = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).f = 3;
    ((ProfileActivity.AllInOne)localObject2).g = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    a(paramView);
  }
  
  private void a(View paramView, PhoneContact paramPhoneContact)
  {
    oox localoox = (oox)paramView.getTag();
    localoox.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    localoox.jdField_a_of_type_JavaLangString = null;
    localoox.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    localoox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramPhoneContact.uin.equals("0")) {
      if (paramPhoneContact.hasSendAddReq)
      {
        localoox.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        localoox.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localoox.jdField_c_of_type_AndroidWidgetTextView.setText("等待验证");
      }
    }
    for (;;)
    {
      paramView.setContentDescription(paramPhoneContact.name);
      if (paramPhoneContact.uin.equals("0")) {
        break;
      }
      localoox.jdField_a_of_type_Int = 2;
      a(localoox, paramPhoneContact.uin, Integer.parseInt(paramPhoneContact.faceUrl), 1);
      return;
      localoox.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      localoox.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getContext().getString(2131362100));
      localoox.jdField_c_of_type_AndroidWidgetButton.setTag(localoox);
      localoox.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      localoox.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localoox.jdField_c_of_type_AndroidWidgetTextView.setText("已添加");
    }
    localoox.jdField_a_of_type_Int = 3;
    a(localoox, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int i2;
    int i1;
    if (this.t == 0)
    {
      i2 = paramListView.getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        oox localoox = (oox)paramListView.getChildAt(i1).getTag();
        if ((localoox != null) && (paramString.equals(localoox.jdField_a_of_type_JavaLangString))) {
          localoox.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (QLog.isColorLevel())
    {
      QLog.i(i, 2, "refreshBlueBarTipsUi() tipsType " + paramQQPimTipsInfo.f);
      QLog.i(i, 2, "refreshBlueBarTipsUi() tipsString " + paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      QLog.i(i, 2, "refreshBlueBarTipsUi() repeatContactNum " + paramQQPimTipsInfo.g);
      QLog.i(i, 2, "refreshBlueBarTipsUi() mTextViewQQPimTips " + this.jdField_d_of_type_AndroidWidgetTextView.getClass().hashCode());
    }
    if (paramQQPimTipsInfo.f == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    }
    while (paramQQPimTipsInfo.f == 3)
    {
      a(true, paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      return;
      if ((paramQQPimTipsInfo.f == 1) || (paramQQPimTipsInfo.f == 2) || (paramQQPimTipsInfo.f == 4))
      {
        if (TextUtils.isEmpty(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText("");
        }
        for (;;)
        {
          if (paramQQPimTipsInfo.jdField_a_of_type_Byte <= 0) {
            break label251;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
        }
        label251:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    a(false, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, "", paramString3, paramString4, 0, 0, "", "", "", "");
  }
  
  private void a(oox paramoox, String paramString, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt2, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt2, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramoox.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramoox.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    SharedPreferences.Editor localEditor;
    if (localSharedPreferences != null)
    {
      localEditor = localSharedPreferences.edit();
      if (!paramBoolean) {
        break label48;
      }
    }
    label48:
    for (int i1 = 3;; i1 = localSharedPreferences.getInt("business_show_count", 0) + 1)
    {
      localEditor.putInt("business_show_count", i1);
      localEditor.commit();
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "initBlueTipsBar()");
    }
    if (paramBoolean) {
      paramString = a(paramString);
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.a(paramString);
        if (this.e != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.e);
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.e);
        }
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_d_of_type_AndroidViewView);
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_d_of_type_AndroidViewView);
        }
      }
      return;
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentWidgetXListView != null))
      {
        paramString = ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.carrierURL))) {}
        for (int i1 = 0;; i1 = 8)
        {
          if (i1 != 0) {
            break label170;
          }
          paramString = d();
          break;
        }
      }
      label170:
      paramString = null;
    }
  }
  
  private View b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130905057, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((TextView)localView.findViewById(2131298586)).setContentDescription(getContext().getString(2131367931));
    localView.setOnClickListener(new oon(this));
    return localView;
  }
  
  private void b(View paramView)
  {
    Object localObject = (oox)paramView.getTag();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i2;
    int i1;
    if (((oox)localObject).jdField_a_of_type_Int == 2)
    {
      paramView = "0";
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((oox)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      i2 = ((oox)localObject).jdField_a_of_type_Int;
      i1 = 0;
      if (i2 != 2) {
        break label179;
      }
      i1 = 0;
    }
    for (;;)
    {
      localObject = paramView.nationCode + paramView.mobileCode;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), i1, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "from_internal");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
      return;
      paramView = "1";
      break;
      label179:
      if (i2 == 3) {
        i1 = 1006;
      }
    }
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    return (localSharedPreferences == null) || (localSharedPreferences.getInt("business_show_count", 0) < 3);
  }
  
  private View c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80066FE", "0X80066FE", 0, 0, "", "", "", "");
    View localView = LayoutInflater.from(getContext()).inflate(2130905032, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131305088));
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "generateBackupContactsView() " + this.jdField_d_of_type_AndroidWidgetTextView.getClass().hashCode());
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131305089));
    localView.setOnClickListener(new ooq(this));
    return localView;
  }
  
  private void c(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    PhoneContact localPhoneContact = ((oox)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    a(AddFriendLogicActivity.a(getContext(), 2, localPhoneContact.nationCode + localPhoneContact.mobileCode, null, 3006, 3, localPhoneContact.name, null, null, "手机联系人", null));
    if (this.jdField_a_of_type_Int != 3) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag(2131296652);
      if (paramView != null)
      {
        int i1 = ((Integer)paramView).intValue();
        if (i1 < 5)
        {
          paramView = null;
          switch (i1)
          {
          }
          while (paramView != null)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            return;
            paramView = "0X80068B7";
            continue;
            paramView = "0X80068B8";
            continue;
            paramView = "0X80068B9";
            continue;
            paramView = "0X80068BA";
            continue;
            paramView = "0X80068BB";
          }
        }
      }
    }
  }
  
  private View d()
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "generateBusinessView()");
    }
    if (this.g == null) {
      this.g = LayoutInflater.from(getContext()).inflate(2130904113, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    }
    this.g.findViewById(2131301450).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.findViewById(2131301447).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setVisibility(0);
    return this.g;
  }
  
  private void d(View paramView)
  {
    Object localObject = (oox)paramView.getTag();
    if ((localObject == null) || (((oox)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {}
    PhoneContact localPhoneContact;
    int i1;
    do
    {
      return;
      localPhoneContact = ((oox)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      i1 = ((oox)localObject).jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      if (i1 == 2)
      {
        paramView = new Bundle();
        paramView.putString("uin", localPhoneContact.uin);
        paramView.putInt("uintype", 0);
        paramView.putString("uinname", localPhoneContact.name);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras(paramView);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), paramView);
        return;
      }
    } while (i1 != 3);
    paramView = new Bundle();
    paramView.putString("uin", localPhoneContact.nationCode + localPhoneContact.mobileCode);
    paramView.putInt("uintype", 1006);
    paramView.putString("uinname", localPhoneContact.name);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras(paramView);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.i.intValue(), paramView);
    return;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i1 == 2)
      {
        paramView = "0";
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
        label256:
        paramView = getContext();
        localObject = new Intent(paramView, QCallDetailActivity.class);
        ((Intent)localObject).putExtra("contactID", localPhoneContact.contactID);
        switch (i1)
        {
        default: 
          ((Intent)localObject).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject).putExtra("uintype", 56938);
          ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("entrance", "Call");
      paramView.startActivity((Intent)localObject);
      return;
      paramView = "1";
      break;
      if (this.jdField_a_of_type_Int != 3) {
        break label256;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
      paramView = paramView.getTag(2131296652);
      if (paramView == null) {
        break label256;
      }
      int i2 = ((Integer)paramView).intValue();
      if (i2 >= 5) {
        break label256;
      }
      paramView = null;
      switch (i2)
      {
      }
      while (paramView != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        break;
        paramView = "0X80068B2";
        continue;
        paramView = "0X80068B3";
        continue;
        paramView = "0X80068B4";
        continue;
        paramView = "0X80068B5";
        continue;
        paramView = "0X80068B6";
      }
      ((Intent)localObject).putExtra("uin", localPhoneContact.uin);
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.nickName);
      continue;
      ((Intent)localObject).putExtra("uin", localPhoneContact.nationCode + localPhoneContact.mobileCode);
      ((Intent)localObject).putExtra("uintype", 1006);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
    }
  }
  
  private void l()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Int == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i1 = 561243;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
    {
      i2 = 768;
      i1 = 561246;
    }
    for (;;)
    {
      ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 3, i2, i1);
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        i1 = 561248;
        i2 = 256;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        i1 = 561247;
        i2 = 256;
      }
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903435, null);
    oox localoox = new oox(null);
    localoox.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298583));
    localoox.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298584));
    localoox.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298585));
    localoox.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298586));
    localoox.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298587));
    localoox.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localoox.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298588));
    localoox.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localoox.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298590));
    localoox.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    localoox.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298589));
    localoox.jdField_a_of_type_AndroidViewView = localView.findViewById(2131298591);
    if (this.jdField_a_of_type_Int == 3)
    {
      localoox.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localView.setTag(localoox);
      return localView;
      localoox.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "onStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class, this.jdField_a_of_type_Ooy);
    TextView localTextView;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("选择通讯录联系人");
      if (this.jdField_a_of_type_Oow == null)
      {
        this.jdField_a_of_type_Oow = new oow(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Oow);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      j();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i1 == 0) {
        break label194;
      }
    }
    label194:
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
        break;
      }
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText("手机联系人");
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "onActivityResult() ");
    }
    if (paramInt1 == 1) {
      if (paramInt2 == 2)
      {
        localObject1 = new Intent(getContext(), BindNumberActivity.class);
        ((Intent)localObject1).putExtra("kNeedUnbind", true);
        a((Intent)localObject1);
        if (paramInt2 == -1) {
          switch (paramInt1)
          {
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == 0)
        {
          int i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
          if ((i1 != 1) && (i1 != 2)) {
            break;
          }
          a(new Intent(getContext(), PhoneLaunchActivity.class));
          break;
        }
        if (paramInt2 == 4002)
        {
          f();
          break;
        }
        a(new Intent(getContext(), PhoneLaunchActivity.class));
        break;
        if (paramInt1 != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false);
        break;
      } while (paramIntent == null);
      localObject1 = paramIntent.getStringExtra("contactSearchResultUin");
      paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      str1 = paramIntent.getStringExtra("contactSearchResultName");
      long l1 = paramIntent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
      localObject2 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
      String str2 = paramIntent.getStringExtra("contactSearchResultPhoneContactNationCode");
      paramInt2 = paramIntent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
      paramIntent = null;
      if (paramInt1 == 1006) {
        if (l1 == 3L)
        {
          paramInt1 = 32;
          paramIntent = new ProfileActivity.AllInOne((String)localObject1, paramInt1);
          paramIntent.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          paramIntent.k = str1;
          paramIntent.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(str1, (String)localObject2, str2));
          paramIntent.d = paramInt2;
          paramIntent.f = 3;
        }
      }
      for (;;)
      {
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
        return;
        paramInt1 = 31;
        break;
        if (paramInt1 == 0) {
          paramIntent = new ProfileActivity.AllInOne((String)localObject1, 1);
        }
      }
      SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
      return;
    } while (paramIntent == null);
    Object localObject1 = paramIntent.getStringExtra("contactSearchResultUin");
    paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
    String str1 = paramIntent.getStringExtra("contactSearchResultName");
    paramIntent = paramIntent.getStringExtra("contactSearchResultTroopUin");
    Object localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QCallDetailActivity.class);
    ((Intent)localObject2).putExtra("uin", (String)localObject1);
    ((Intent)localObject2).putExtra("troop_uin", paramIntent);
    ((Intent)localObject2).putExtra("uintype", paramInt1);
    ((Intent)localObject2).putExtra("uinname", str1);
    ((Intent)localObject2).putExtra("entrance", "Call");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "onCreate()");
    }
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringArrayExtra("key_reserved_mobile");
      if ((paramIntent != null) && (paramIntent.length > 0)) {
        this.jdField_c_of_type_JavaUtilList = Arrays.asList(paramIntent);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    if (this.jdField_a_of_type_Ooy != null) {
      this.jdField_a_of_type_Ooy.sendEmptyMessageDelayed(5, 1000L);
    }
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    oox localoox = (oox)paramView.getTag();
    if (paramBoolean)
    {
      localoox.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
      localoox.jdField_a_of_type_JavaLangString = null;
      localoox.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
      if (!TextUtils.isEmpty(paramPhoneContact.uin)) {
        break label163;
      }
      localoox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localoox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localoox.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localoox.jdField_a_of_type_Int = 1;
      localoox.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
      localoox.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(paramPhoneContact.name));
      localoox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label163:
    label465:
    do
    {
      do
      {
        return;
        localoox.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
        break;
        localoox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localoox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
        {
          localoox.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localoox.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        }
        localoox.jdField_a_of_type_AndroidWidgetButton.setTag(localoox);
        localoox.jdField_b_of_type_AndroidWidgetButton.setTag(localoox);
        localoox.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发消息");
        localoox.jdField_b_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发起语音通话");
        if (!paramPhoneContact.uin.equals("0"))
        {
          localoox.jdField_a_of_type_Int = 2;
          a(localoox, paramPhoneContact.uin, 0, 1);
          localoox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        localoox.jdField_a_of_type_Int = 3;
        a(localoox, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
        if ((this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 5)) {
          break label509;
        }
        if (!paramPhoneContact.isHiden) {
          break label465;
        }
        localoox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } while (!AppSetting.j);
      paramView.setContentDescription(paramPhoneContact.name + "，已隐藏");
      return;
      localoox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (!AppSetting.j);
    paramView.setContentDescription(paramPhoneContact.name + "，未隐藏");
    return;
    label509:
    localoox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.t = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < i2)
    {
      paramAbsListView = (oox)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int i1 = 1;
        if (paramAbsListView.jdField_a_of_type_Int == 3) {
          i1 = 11;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i1, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap != null) {
          break label142;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_JavaLangString, i1, false);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label52;
      break;
      label142:
      paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "onResume()");
    }
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d() != 6)
    {
      if (!NetworkUtil.e(getContext())) {
        break label98;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) {
        a(2131368647, 0L, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, true);
    h();
    return;
    label98:
    a(2131368805, 3000L);
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.m();
    localXListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + i1);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "onStop()");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    i();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_Oow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Oow);
      this.jdField_a_of_type_Oow = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.d();
  }
  
  protected void e()
  {
    QQPimGetTipsInfoIPC.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
    }
    super.e();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
    {
      k();
      this.jdField_a_of_type_Oov.notifyDataSetChanged();
    }
    int i1;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 3);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_c_of_type_JavaUtilList);
    } while (!QLog.isColorLevel());
    QLog.d("ContactListView", 2, "load contact friend result: " + i1);
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g());
      ((List)localObject1).add(new ArrayList());
    }
    for (this.jdField_a_of_type_JavaUtilList = ((List)localObject1); this.jdField_a_of_type_JavaUtilList == null; this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
    {
      this.jdField_a_of_type_Ooy.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = localObject1[i1];
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
      i1 += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = "*";
    Iterator localIterator = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      Object localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) == null)
      {
        localObject1 = "#";
        localPhoneContact.pinyinFirst = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue() + 1));
      localObject2 = localObject3;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      i2 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (i2 == 0) {
        break label500;
      }
    }
    label500:
    for (i2 = i2 + i1 + 1;; i2 = i1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i1));
      i1 = i2;
      break;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4))
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(1);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("未启用通讯录的联系人", Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((Iterator)localObject1).next();
            ((PhoneContact)localObject2).pinyinFirst = "未启用通讯录的联系人";
            localArrayList.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.m = this.jdField_a_of_type_JavaUtilArrayList.size();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      return;
    case 2131300895: 
      l();
      return;
    case 2131297183: 
      if (this.jdField_a_of_type_Int == 2)
      {
        f();
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      Intent localIntent = new Intent(getContext(), SettingActivity2.class);
      if (paramView.hasExtra("kSrouce")) {
        localIntent.putExtra("kSrouce", paramView.getIntExtra("kSrouce", 6));
      }
      b(localIntent, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131298587: 
      a(paramView);
      return;
    case 2131298588: 
      b(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\ContactListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
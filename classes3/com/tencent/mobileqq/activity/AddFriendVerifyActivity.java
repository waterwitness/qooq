package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kik;
import kil;
import kim;
import kin;
import kio;
import kip;
import kiq;
import kir;
import kis;
import kit;
import kiu;
import kiv;
import kiw;
import kix;
import kiy;
import kiz;
import kja;
import kjb;
import kjd;
import kje;
import kjf;
import kjg;
import kjh;
import mqq.os.MqqHandler;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1001;
  public static final String a = "AddFriendVerifyActivity";
  protected static final int b = 1;
  public static final String b = "start_recomend_page";
  public static final boolean b;
  protected static final int c = 2;
  public static final int d = 30;
  public static final int e = 1;
  private static final String jdField_e_of_type_JavaLangString = "last_verify_msg";
  public static final int f = 2;
  private static final String jdField_f_of_type_JavaLangString = "last_add_friend_verify_";
  public static final int g = 3;
  private static final String jdField_g_of_type_JavaLangString = "last_add_troop_verfity_";
  private static final int jdField_h_of_type_Int = 0;
  private static final String jdField_h_of_type_JavaLangString = "add_friend_verify_msg_modify_flag";
  private static final int jdField_j_of_type_Int = 90;
  private static int jdField_m_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFFFFFFFFFF);
  private long jdField_a_of_type_Long;
  private Uri jdField_a_of_type_AndroidNetUri;
  public Handler a;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new kio(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new kil(this);
  public InputMethodManager a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new kjh(this);
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new kiw(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new kip(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kiq(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new kir(this);
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new kin(this);
  public BusinessCard a;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  public QQProgressDialog a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new kim(this);
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public TextView b;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  protected FormSwitchItem b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new kix(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public FormSwitchItem c;
  public String c;
  protected boolean c;
  protected LinearLayout d;
  private TextView d;
  protected String d;
  public boolean d;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected boolean e;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private String jdField_m_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Boolean = AppSetting.j;
  }
  
  public AddFriendVerifyActivity()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidOsHandler = new kis(this);
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 238	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 243	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 248	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_1
    //   22: aload 4
    //   24: invokevirtual 243	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic 254	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_3
    //   34: aload_1
    //   35: astore_2
    //   36: aload_0
    //   37: invokestatic 259	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)I
    //   40: istore 5
    //   42: aload_1
    //   43: astore_2
    //   44: iload 5
    //   46: ifeq +33 -> 79
    //   49: aload_1
    //   50: astore_3
    //   51: aload_1
    //   52: astore_2
    //   53: aload_1
    //   54: iload 5
    //   56: i2f
    //   57: invokestatic 262	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   60: astore_0
    //   61: aload_0
    //   62: astore_2
    //   63: aload_0
    //   64: ifnull +15 -> 79
    //   67: aload_0
    //   68: astore_3
    //   69: aload_0
    //   70: astore_2
    //   71: aload_0
    //   72: aload 4
    //   74: invokestatic 265	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 270	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 273	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload_3
    //   96: astore_2
    //   97: aload_0
    //   98: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   101: aload_3
    //   102: ifnull -15 -> 87
    //   105: aload_3
    //   106: invokevirtual 270	android/graphics/Bitmap:recycle	()V
    //   109: return
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 270	android/graphics/Bitmap:recycle	()V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   21	33	1	localObject1	Object
    //   35	81	2	localObject2	Object
    //   33	73	3	localObject3	Object
    //   8	65	4	localFile	File
    //   40	15	5	n	int
    // Exception table:
    //   from	to	target	type
    //   22	32	88	java/lang/OutOfMemoryError
    //   36	42	94	java/io/IOException
    //   53	61	94	java/io/IOException
    //   71	77	94	java/io/IOException
    //   36	42	110	finally
    //   53	61	110	finally
    //   71	77	110	finally
    //   97	101	110	finally
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368647);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    long l1 = Long.parseLong(this.app.a());
    long l2 = Long.parseLong(paramString1);
    localTroopHandler.a(paramString1, paramString2, paramInt, this.jdField_j_of_type_JavaLangString, a(this.jdField_k_of_type_Int, this.jdField_k_of_type_JavaLangString, paramString2, l1, l2), this.jdField_l_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        paramString2 = "2";
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != null))
        {
          boolean bool = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().isChecked();
          ((BizTroopHandler)this.app.a(22)).a(null, this.jdField_c_of_type_JavaLangString, 3, bool);
          if (!bool) {
            break label489;
          }
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_open", 0, 0, paramString1, "", "", "");
          label226:
          if ((!this.jdField_a_of_type_Boolean) && (bool)) {
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_open", 0, 0, paramString1, "", "", "");
          }
          if ((this.jdField_a_of_type_Boolean) && (!bool)) {
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_close", 0, 0, paramString1, "", "", "");
          }
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label526;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean == true) && (!this.jdField_d_of_type_Boolean)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean == true)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      return;
      paramString2 = "0";
      break;
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "3";
      break;
      label489:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_close", 0, 0, paramString1, "", "", "");
      break label226;
      label526:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private boolean a()
  {
    int n = getIntent().getExtras().getInt("source_id", 10004);
    return (n == 3003) || (n == 3006) || (n == 3007) || (n == 3009) || (n == 3013);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131364853, 0).b(getTitleBarHeight());
      e();
    }
    while (((TroopManager)this.app.getManager(51) == null) || (this.jdField_c_of_type_JavaLangString == null)) {
      return;
    }
    ((TroopHandler)this.app.a(20)).a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramBoolean, true);
  }
  
  private boolean b()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296934));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296935));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296936));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296937));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131296938));
    int n = getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(this, 15.0F) * 2;
    int i1 = n * 600 / 1000;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.width = n;
    localLayoutParams.height = i1;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    a();
    b();
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
  }
  
  private void c(boolean paramBoolean)
  {
    if (((TroopInfoManager)this.app.getManager(36) == null) || (this.jdField_c_of_type_JavaLangString == null)) {}
    do
    {
      return;
      if (NetworkUtil.a(this) == 0)
      {
        QQToast.a(this, 2131364258, 0).b(getTitleBarHeight());
        a(paramBoolean);
        return;
      }
    } while (paramBoolean);
    DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131364889)).setNegativeButton(getString(2131364890), new kiu(this)).setPositiveButton(getString(2131364891), new kit(this, paramBoolean)).show();
  }
  
  private void d()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.jdField_d_of_type_Boolean = ((TroopManager)this.app.getManager(51)).c(this.jdField_c_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean == true) {}
    for (String str = getString(2131364851);; str = getString(2131364850))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void f()
  {
    ((BizTroopHandler)this.app.a(22)).a(null, this.jdField_c_of_type_JavaLangString, 1, false);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  private void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131370357, 5);
    localActionSheet.a(2131370359, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new kiy(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public void a()
  {
    BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.app.getManager(111);
    if (localBusinessCardManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = localBusinessCardManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    QLog.e("AddFriendVerifyActivity", 2, "BusinessCardManager is null");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("msg", paramString);
    localIntent.putExtra("sig", paramArrayOfByte);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      localIntent.putExtra("show_my_card", (byte)1);
      ReportController.b(this.app, "CliOper", "", "", "0X80064F5", "0X80064F5", 0, 0, "", "", "", "");
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity(localIntent);
      return;
    }
    startActivityForResult(localIntent, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(2));
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      localSwitch.setContentDescription(getString(2131364888));
      return;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 735	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 736	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore 8
    //   25: iload_1
    //   26: ifeq +128 -> 154
    //   29: aload_2
    //   30: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +121 -> 154
    //   36: new 738	tencent/im/msg/im_msg_body$Elem
    //   39: dup
    //   40: invokespecial 739	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   43: astore 9
    //   45: new 741	tencent/im/msg/im_msg_body$CustomFace
    //   48: dup
    //   49: invokespecial 742	tencent/im/msg/im_msg_body$CustomFace:<init>	()V
    //   52: astore 10
    //   54: aload 10
    //   56: getfield 746	tencent/im/msg/im_msg_body$CustomFace:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: iload_1
    //   60: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   63: aload 10
    //   65: getfield 755	tencent/im/msg/im_msg_body$CustomFace:bytes_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   68: aload_2
    //   69: invokestatic 760	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   72: invokestatic 766	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   75: invokevirtual 771	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   78: aload 10
    //   80: getfield 775	tencent/im/msg/im_msg_body$CustomFace:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   83: new 200	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   90: aload_2
    //   91: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 777
    //   97: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 781	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   106: aload 10
    //   108: getfield 784	tencent/im/msg/im_msg_body$CustomFace:uint32_useful	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: iconst_1
    //   112: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   115: aload 10
    //   117: getfield 787	tencent/im/msg/im_msg_body$CustomFace:biz_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: iconst_3
    //   121: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   124: aload 10
    //   126: getfield 790	tencent/im/msg/im_msg_body$CustomFace:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: bipush 66
    //   131: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   134: aload 9
    //   136: getfield 794	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   139: aload 10
    //   141: invokevirtual 797	tencent/im/msg/im_msg_body$CustomFace:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   144: aload 8
    //   146: getfield 801	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   149: aload 9
    //   151: invokevirtual 806	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   154: aload_3
    //   155: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +50 -> 208
    //   161: new 738	tencent/im/msg/im_msg_body$Elem
    //   164: dup
    //   165: invokespecial 739	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   168: astore_2
    //   169: new 808	tencent/im/msg/im_msg_body$Text
    //   172: dup
    //   173: invokespecial 809	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   176: astore 9
    //   178: aload 9
    //   180: getfield 812	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   183: aload_3
    //   184: invokestatic 816	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   187: invokevirtual 771	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   190: aload_2
    //   191: getfield 820	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   194: aload 9
    //   196: invokevirtual 821	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   199: aload 8
    //   201: getfield 801	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   204: aload_2
    //   205: invokevirtual 806	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   208: new 823	tencent/im/msg/im_msg_body$MsgBody
    //   211: dup
    //   212: invokespecial 824	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   215: astore_2
    //   216: aload_2
    //   217: getfield 828	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   220: aload 8
    //   222: invokevirtual 829	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   225: new 831	tencent/im/msg/im_msg$Msg
    //   228: dup
    //   229: invokespecial 832	tencent/im/msg/im_msg$Msg:<init>	()V
    //   232: astore 9
    //   234: aload 9
    //   236: getfield 836	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   239: aload_2
    //   240: invokevirtual 837	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   243: new 839	tencent/im/msg/im_msg$Group
    //   246: dup
    //   247: invokespecial 840	tencent/im/msg/im_msg$Group:<init>	()V
    //   250: astore_3
    //   251: new 842	tencent/im/msg/im_common$User
    //   254: dup
    //   255: invokespecial 843	tencent/im/msg/im_common$User:<init>	()V
    //   258: astore 10
    //   260: aload 10
    //   262: getfield 847	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   265: lload 4
    //   267: invokevirtual 852	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   270: aload 10
    //   272: getfield 855	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   275: sipush 1001
    //   278: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   281: aload 10
    //   283: getfield 858	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: iconst_1
    //   287: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   290: aload 10
    //   292: getfield 862	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   295: invokestatic 866	com/dataline/util/DatalineMathUtil:a	()J
    //   298: l2i
    //   299: invokevirtual 869	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   302: aload 10
    //   304: getfield 872	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   307: bipush 109
    //   309: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   312: aload 10
    //   314: getfield 875	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   317: getstatic 877	com/tencent/common/config/AppSetting:a	I
    //   320: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   323: aload_3
    //   324: getfield 881	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   327: aload 10
    //   329: invokevirtual 882	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 881	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   336: getfield 847	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 4
    //   341: invokevirtual 852	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: new 884	tencent/im/msg/im_common$GroupInfo
    //   347: dup
    //   348: invokespecial 885	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   351: astore_2
    //   352: aload_3
    //   353: getfield 889	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   356: aload_2
    //   357: invokevirtual 890	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   360: aload_3
    //   361: getfield 889	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   364: getfield 893	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   367: lload 6
    //   369: invokevirtual 852	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   372: aload_3
    //   373: getfield 889	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   376: getfield 897	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   379: iconst_1
    //   380: invokevirtual 900	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   383: new 902	tencent/im/msg/im_msg$RoutingHead
    //   386: dup
    //   387: invokespecial 903	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   390: astore_2
    //   391: aload_2
    //   392: getfield 907	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   395: aload_3
    //   396: invokevirtual 908	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   399: new 910	tencent/im/msg/im_msg$ContentHead
    //   402: dup
    //   403: invokespecial 911	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   406: astore_3
    //   407: aload_3
    //   408: getfield 914	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   411: astore 8
    //   413: getstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_m_of_type_Int	I
    //   416: istore_1
    //   417: iload_1
    //   418: iconst_1
    //   419: iadd
    //   420: putstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_m_of_type_Int	I
    //   423: aload 8
    //   425: iload_1
    //   426: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   429: new 916	tencent/im/msg/im_msg$MsgHead
    //   432: dup
    //   433: invokespecial 917	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   436: astore 8
    //   438: aload 8
    //   440: getfield 921	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   443: aload_3
    //   444: invokevirtual 922	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   447: aload 8
    //   449: getfield 926	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   452: aload_2
    //   453: invokevirtual 927	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   456: aload 9
    //   458: getfield 931	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   461: aload 8
    //   463: invokevirtual 932	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   466: new 934	tencent/im/msg/im_imagent$Signature
    //   469: dup
    //   470: invokespecial 935	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   473: astore 11
    //   475: aload 11
    //   477: getfield 938	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   480: iconst_1
    //   481: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   484: aload 11
    //   486: getfield 941	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   489: sipush 256
    //   492: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   495: aload_0
    //   496: getfield 209	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   499: invokestatic 946	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   502: astore_2
    //   503: aload_2
    //   504: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   507: istore 12
    //   509: aload_2
    //   510: astore 8
    //   512: iload 12
    //   514: ifeq +51 -> 565
    //   517: aconst_null
    //   518: areturn
    //   519: astore_3
    //   520: ldc_w 322
    //   523: astore_2
    //   524: aload_2
    //   525: astore 8
    //   527: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +35 -> 565
    //   533: ldc 14
    //   535: iconst_2
    //   536: new 200	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 948
    //   546: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 951	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   553: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 954	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload_2
    //   563: astore 8
    //   565: aload 11
    //   567: getfield 957	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   570: aload 8
    //   572: invokestatic 816	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   575: invokevirtual 771	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   578: new 959	tencent/im/msg/im_imagent$ImAgentHead
    //   581: dup
    //   582: invokespecial 960	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   585: astore_2
    //   586: aload_2
    //   587: getfield 963	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   590: iconst_3
    //   591: invokevirtual 900	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   594: aload_2
    //   595: getfield 967	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   598: aload 11
    //   600: invokevirtual 968	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   603: aload_2
    //   604: getfield 971	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   607: aload 10
    //   609: invokevirtual 882	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   612: aload_2
    //   613: getfield 972	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   616: astore_3
    //   617: getstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_m_of_type_Int	I
    //   620: istore_1
    //   621: iload_1
    //   622: iconst_1
    //   623: iadd
    //   624: putstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_m_of_type_Int	I
    //   627: aload_3
    //   628: iload_1
    //   629: invokevirtual 751	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   632: new 974	tencent/im/msg/im_msg$MsgSendReq
    //   635: dup
    //   636: invokespecial 975	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   639: astore_3
    //   640: aload_3
    //   641: getfield 978	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   644: aload 9
    //   646: invokevirtual 979	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   649: new 981	tencent/im/msg/im_imagent$ImAgentPackage
    //   652: dup
    //   653: invokespecial 982	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   656: astore 8
    //   658: aload 8
    //   660: getfield 985	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   663: aload_2
    //   664: invokevirtual 986	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   667: aload 8
    //   669: getfield 990	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   672: aload_3
    //   673: invokevirtual 991	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   676: aload 8
    //   678: invokevirtual 995	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   681: astore 8
    //   683: new 997	java/io/ByteArrayOutputStream
    //   686: dup
    //   687: aload 8
    //   689: arraylength
    //   690: bipush 8
    //   692: iadd
    //   693: invokespecial 999	java/io/ByteArrayOutputStream:<init>	(I)V
    //   696: astore_2
    //   697: new 1001	java/io/DataOutputStream
    //   700: dup
    //   701: aload_2
    //   702: invokespecial 1004	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   705: astore_3
    //   706: aload_3
    //   707: aload 8
    //   709: arraylength
    //   710: bipush 8
    //   712: iadd
    //   713: invokevirtual 1007	java/io/DataOutputStream:writeInt	(I)V
    //   716: aload_3
    //   717: bipush 123
    //   719: invokevirtual 1010	java/io/DataOutputStream:write	(I)V
    //   722: aload_3
    //   723: bipush 123
    //   725: invokevirtual 1010	java/io/DataOutputStream:write	(I)V
    //   728: aload_3
    //   729: aload 8
    //   731: invokevirtual 1013	java/io/DataOutputStream:write	([B)V
    //   734: aload_3
    //   735: bipush 125
    //   737: invokevirtual 1010	java/io/DataOutputStream:write	(I)V
    //   740: aload_3
    //   741: bipush 125
    //   743: invokevirtual 1010	java/io/DataOutputStream:write	(I)V
    //   746: aload_2
    //   747: invokevirtual 1014	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   750: astore 8
    //   752: aload_2
    //   753: invokevirtual 1016	java/io/ByteArrayOutputStream:close	()V
    //   756: aload_3
    //   757: invokevirtual 1017	java/io/DataOutputStream:close	()V
    //   760: aload 8
    //   762: areturn
    //   763: astore_2
    //   764: aload 8
    //   766: areturn
    //   767: astore 8
    //   769: aload 8
    //   771: invokevirtual 1018	java/lang/Exception:printStackTrace	()V
    //   774: aload_2
    //   775: invokevirtual 1016	java/io/ByteArrayOutputStream:close	()V
    //   778: aload_3
    //   779: invokevirtual 1017	java/io/DataOutputStream:close	()V
    //   782: aconst_null
    //   783: areturn
    //   784: astore 8
    //   786: aload_2
    //   787: invokevirtual 1016	java/io/ByteArrayOutputStream:close	()V
    //   790: aload_3
    //   791: invokevirtual 1017	java/io/DataOutputStream:close	()V
    //   794: aload 8
    //   796: athrow
    //   797: astore_2
    //   798: goto -4 -> 794
    //   801: astore_2
    //   802: goto -20 -> 782
    //   805: astore_3
    //   806: goto -282 -> 524
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	AddFriendVerifyActivity
    //   0	809	1	paramInt	int
    //   0	809	2	paramString1	String
    //   0	809	3	paramString2	String
    //   0	809	4	paramLong1	long
    //   0	809	6	paramLong2	long
    //   23	742	8	localObject1	Object
    //   767	3	8	localException	Exception
    //   784	11	8	localObject2	Object
    //   43	602	9	localObject3	Object
    //   52	556	10	localObject4	Object
    //   473	126	11	localSignature	tencent.im.msg.im_imagent.Signature
    //   507	6	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   495	503	519	java/lang/InterruptedException
    //   752	760	763	java/lang/Exception
    //   706	752	767	java/lang/Exception
    //   706	752	784	finally
    //   769	774	784	finally
    //   786	794	797	java/lang/Exception
    //   774	782	801	java/lang/Exception
    //   503	509	805	java/lang/InterruptedException
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl, this.jdField_a_of_type_ComTencentImageURLImageView, 1000, 600);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
        {
          ViewHelper.a(this.jdField_a_of_type_ComTencentImageURLImageView, 1.0F);
          return;
        }
        ViewHelper.a(this.jdField_a_of_type_ComTencentImageURLImageView, 0.3F);
        return;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    } while (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a());
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company)) {
      str = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.get(0)))) {
        str = (String)this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.get(0);
      } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName)) {
        str = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName;
      } else {
        str = "";
      }
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    if (!NetworkUtil.h(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 1, 2131364668, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.a(new kiz(this, paramString), 5, null, false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    switch (paramInt1)
    {
    }
    do
    {
      return;
      paramIntent = this.jdField_a_of_type_AndroidNetUri.getPath();
    } while (TextUtils.isEmpty(paramIntent));
    this.jdField_m_of_type_JavaLangString = paramIntent;
    a(this.jdField_m_of_type_JavaLangString);
    b(this.jdField_m_of_type_JavaLangString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject2 = getIntent();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_i_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("uin");
    this.jdField_i_of_type_Int = ((Intent)localObject2).getIntExtra("k_uin_type", 1);
    int n;
    int i1;
    label1357:
    label1366:
    Object localObject1;
    if (this.jdField_i_of_type_Int == 4)
    {
      setContentViewB(2130903073);
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296942));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296943));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296945));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296946));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296949));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296950));
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296948));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299581));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296844));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296302));
      this.h = ((TextView)findViewById(2131296951));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296952));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296953));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131296954));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296955));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368890);
      this.jdField_j_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authKey");
      if (this.jdField_j_of_type_JavaLangString != null) {}
      String str = getIntent().getExtras().getString("nick_name");
      if (this.jdField_i_of_type_Int == 4)
      {
        setTitle(2131370668);
        localObject2 = (TextView)findViewById(2131297083);
        str = getIntent().getExtras().getString("leftViewText");
        paramBundle = str;
        if (str == null) {
          paramBundle = getString(2131367975);
        }
        ((TextView)localObject2).setText(paramBundle);
        this.jdField_c_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
        f();
        findViewById(2131296957).setVisibility(0);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        n = getIntent().getExtras().getShort("group_option", (short)2);
        paramBundle = getIntent().getExtras().getString("troop_question");
        str = getIntent().getExtras().getString("troop_answer");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296956));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getResources().getString(2131364888));
        localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        ((Switch)localObject2).setTag(Integer.valueOf(2));
        ((Switch)localObject2).setChecked(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131364888));
      }
    }
    else
    {
      switch (n)
      {
      case 3: 
      default: 
      case 1: 
      case 2: 
      case 4: 
        do
        {
          getWindow().setSoftInputMode(5);
          enableRightHighlight(true);
          SearchProtocol.a(this, this.app, 10800000L, AddFriendVerifyActivity.class.getSimpleName());
          return true;
          setContentViewB(2130903072);
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296933));
          this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296939));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296941));
          c();
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296931));
          this.g = ((TextView)findViewById(2131296932));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296819));
          break;
          this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.h.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = 0;
          this.jdField_b_of_type_ComTencentImageURLImageView.setImageBitmap(this.app.a(this.app.a(), (byte)1, true));
          this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(100.0F, getResources()));
          this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(false);
          this.jdField_b_of_type_AndroidWidgetEditText.setGravity(48);
          this.jdField_b_of_type_AndroidWidgetEditText.setBackgroundResource(2130843273);
          this.jdField_b_of_type_AndroidWidgetEditText.setHint("");
          n = AIOUtils.a(10.0F, getResources());
          this.jdField_b_of_type_AndroidWidgetEditText.setPadding(n, n, n, n);
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          paramBundle = getString(2131364748, new Object[] { this.app.b() });
          if (this.jdField_i_of_type_Int != 4) {
            this.jdField_f_of_type_AndroidWidgetTextView.setText("30");
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetEditText.setText(paramBundle);
            this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_b_of_type_AndroidWidgetEditText.getText().length());
            setRightHighlightButton(2131367885, new kik(this));
            break;
            i1 = 0;
            try
            {
              n = paramBundle.getBytes("utf-8").length;
              this.jdField_f_of_type_AndroidWidgetTextView.setText(90 - n + "");
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
                n = i1;
                if (QLog.isColorLevel())
                {
                  QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
                  n = i1;
                }
              }
            }
          }
          this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.jdField_f_of_type_AndroidWidgetLinearLayout.getId());
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(this, 15.0F));
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          paramBundle = new QQText(getString(2131368663) + ":" + paramBundle, 13);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(paramBundle);
          this.jdField_i_of_type_AndroidWidgetTextView.setTag(this.jdField_c_of_type_JavaLangString);
          this.jdField_i_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
          if (jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131366781));
          }
          setRightHighlightButton(2131367885, new kiv(this, localException));
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        } while (paramBundle.n <= 0);
        i1 = 0;
        while (i1 < paramBundle.a.length)
        {
          if ((paramBundle.a[i1] instanceof QQText.LinkSpan)) {
            break label1366;
          }
          i1 += 1;
        }
        localObject1 = ((QQText.LinkSpan)paramBundle.a[i1]).a;
        n = -1;
        if (Patterns.c.matcher((CharSequence)localObject1).find()) {
          n = 0;
        }
        if (QQText.b.matcher((CharSequence)localObject1).find()) {
          n = 1;
        }
        if (QQText.d.matcher((CharSequence)localObject1).find()) {
          n = 2;
        }
        break;
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_c_of_type_JavaLangString, "" + n, "", "");
      break label1357;
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_f_of_type_AndroidWidgetLinearLayout.getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)DisplayUtils.a(this, 15.0F));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131368663) + ":" + paramBundle, 13);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_i_of_type_AndroidWidgetTextView.setTag(this.jdField_c_of_type_JavaLangString);
      this.jdField_i_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131366781));
      }
      setRightHighlightButton(2131367885, new kja(this));
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      if (paramBundle.n <= 0) {
        break;
      }
      i1 = 0;
      while (i1 < paramBundle.a.length)
      {
        if ((paramBundle.a[i1] instanceof QQText.LinkSpan)) {
          break label1758;
        }
        label1749:
        i1 += 1;
      }
      break;
      label1758:
      localObject1 = ((QQText.LinkSpan)paramBundle.a[i1]).a;
      n = -1;
      if (Patterns.c.matcher((CharSequence)localObject1).find()) {
        n = 0;
      }
      if (QQText.b.matcher((CharSequence)localObject1).find()) {
        n = 1;
      }
      if (QQText.d.matcher((CharSequence)localObject1).find()) {
        n = 2;
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_c_of_type_JavaLangString, "" + n, "", "");
        break label1749;
        setTitle(2131368515);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        n = getIntent().getExtras().getInt("source_id", 10004);
        if (this.jdField_i_of_type_Int == 2)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 11, this.jdField_i_of_type_JavaLangString));
          localObject3 = this.g;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = this.jdField_i_of_type_JavaLangString;
          }
          ((TextView)localObject3).setText(paramBundle);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
        }
        for (;;)
        {
          i1 = ((Intent)localObject2).getIntExtra("friend_setting", 0);
          localObject1 = getIntent().getExtras().getStringArrayList("user_question");
          switch (i1)
          {
          case 0: 
          case 2: 
          default: 
            break;
          case 1: 
            this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
            setRightHighlightButton(2131368949, new kjd(this));
            break;
            if (this.jdField_i_of_type_Int == 3)
            {
              paramBundle = ((Intent)localObject2).getStringExtra("extra");
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(FaceDrawable.a(this.jdField_i_of_type_JavaLangString, paramBundle)));
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              this.g.setText((CharSequence)localObject1);
              ((FriendListHandler)this.app.a(1)).a(this.jdField_i_of_type_JavaLangString, getIntent().getStringExtra("extra"));
            }
            else
            {
              if ((n == 3007) || (n == 2007) || (n == 4007) || (n == 3019) || (n == 2019)) {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 200, this.jdField_i_of_type_JavaLangString, true));
              }
              for (;;)
              {
                if (!a()) {
                  break label2281;
                }
                if (localObject1 == null) {
                  break;
                }
                this.g.setText((CharSequence)localObject1);
                break;
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_i_of_type_JavaLangString));
              }
              label2281:
              ThreadManager.b().post(new kjb(this, (String)localObject1));
            }
            break;
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297586);
        localObject2 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301217);
        ((TextView)localObject1).setText(getString(2131368663) + ":" + paramBundle);
        ((EditText)localObject2).setSingleLine(true);
        if (jdField_b_of_type_Boolean) {
          ((EditText)localObject2).setContentDescription(getString(2131366781));
        }
        setRightHighlightButton(2131368949, new kje(this, (EditText)localObject2, i1, n));
        getWindow().setSoftInputMode(5);
        break;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject2 = new InputFilter.LengthFilter(32);
        findViewById(2131296940).setVisibility(0);
        Object localObject3 = new StringBuffer();
        n = 0;
        if (n < ((ArrayList)localObject1).size())
        {
          switch (n)
          {
          default: 
            paramBundle = getResources().getString(2131368663);
          }
          for (;;)
          {
            View localView1 = getLayoutInflater().inflate(2130904060, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            View localView2 = getLayoutInflater().inflate(2130904059, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (n > 0)
            {
              localObject4 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
              if (localObject4 != null)
              {
                ((LinearLayout.LayoutParams)localObject4).topMargin = ((int)DisplayUtils.a(getApplication(), 20.0F));
                localView1.setLayoutParams((ViewGroup.LayoutParams)localObject4);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView1);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView2);
            Object localObject4 = (String)((ArrayList)localObject1).get(n);
            ((TextView)localView1.findViewById(2131297586)).setText(paramBundle + (String)localObject4);
            paramBundle = (EditText)localView2.findViewById(2131301217);
            paramBundle.setFilters(new InputFilter[] { localObject2 });
            paramBundle.setSingleLine(false);
            this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
            if (jdField_b_of_type_Boolean) {
              ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(n)).setContentDescription(getString(2131366781));
            }
            i1 = n + 1;
            ((StringBuffer)localObject3).append(getString(2131368663) + i1 + ":" + (String)localObject4);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131368667) + ":" + "${answer}");
            if (i1 != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            n += 1;
            break;
            paramBundle = getResources().getString(2131368892);
            continue;
            paramBundle = getResources().getString(2131368893);
            continue;
            paramBundle = getResources().getString(2131368894);
            continue;
            paramBundle = getResources().getString(2131368895);
            continue;
            paramBundle = getResources().getString(2131368896);
          }
        }
        setRightHighlightButton(2131368949, new kjf(this, (StringBuffer)localObject3));
        findViewById(2131296930).setOnTouchListener(new kjg(this));
        getWindow().setSoftInputMode(4);
        break;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_m_of_type_JavaLangString = ((String)paramIntent.get(0));
      b(this.jdField_m_of_type_JavaLangString);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_i_of_type_Int != 4) {}
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
      return;
    }
    String str4 = getString(2131368659);
    String str1;
    String str3;
    if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
    {
      str1 = str4 + getString(2131366359) + " " + ContactUtils.a(this.app, this.app.getAccount());
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str1);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      String str2 = null;
      if (this.jdField_i_of_type_Int == 3) {
        str2 = getIntent().getStringExtra("msg");
      }
      str3 = str2;
      if (TextUtils.isEmpty(str2)) {
        str3 = a(false);
      }
      if (!TextUtils.isEmpty(str3)) {
        break label301;
      }
    }
    for (;;)
    {
      if ((str4.equals(str1)) && (!b())) {
        str1 = str1 + ContactUtils.a(this.app, this.app.getAccount());
      }
      for (int n = 1;; n = 0)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
        if (n != 0) {}
        try
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str4.length(), str1.length());
          for (;;)
          {
            getWindow().setSoftInputMode(5);
            return;
            this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
            str1 = str4;
            break;
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str1.length());
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
      label301:
      Object localObject = str3;
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void finish()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 2);
    super.finish();
  }
  
  protected boolean onBackEvent()
  {
    String str;
    if (this.jdField_i_of_type_Int != 4)
    {
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 != this.jdField_i_of_type_Int) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      a(str, bool);
      if ((getString(2131368659).equals(str)) && (!b())) {
        d();
      }
      return super.onBackEvent();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {}
    while (((TroopManager)this.app.getManager(51) == null) || (this.jdField_c_of_type_JavaLangString == null)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    case 1: 
      b(paramBoolean);
      return;
    }
    c(paramBoolean);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131301217) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AddFriendVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
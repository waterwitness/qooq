package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lem;
import leo;
import lep;
import leq;
import ler;
import les;
import let;
import leu;
import lev;
import lew;
import lex;
import ley;
import lez;
import mqq.app.AppRuntime;

public class DetailProfileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 36;
  private static final long jdField_a_of_type_Long = 20000L;
  static final String jdField_a_of_type_JavaLangString = "DetailProfileActivity";
  private static final byte jdField_b_of_type_Byte = -1;
  static final int jdField_b_of_type_Int = 120;
  static final int jdField_c_of_type_Int = 40;
  static final int jdField_d_of_type_Int = 50;
  static final int jdField_e_of_type_Int = 383;
  static final int jdField_j_of_type_Int = 1000;
  static final int jdField_k_of_type_Int = 1001;
  static final int l = 1002;
  static final int m = 1003;
  static final int n = 1004;
  static final int o = 0;
  static final int p = 1;
  static final int q = 2;
  static final int r = 3;
  private static final int t = 0;
  private static final int u = 0;
  private static final int v = 0;
  private static final int w = -1;
  private static final int x = 1000;
  public byte a;
  public Dialog a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  public IphonePickerView a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public ActionSheet a;
  lez jdField_a_of_type_Lez;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  lez jdField_b_of_type_Lez;
  boolean jdField_b_of_type_Boolean;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  lez jdField_c_of_type_Lez;
  boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  lez jdField_d_of_type_Lez;
  boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean;
  private View jdField_j_of_type_AndroidViewView;
  private View jdField_k_of_type_AndroidViewView;
  public int s;
  
  public DetailProfileActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new les(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new let(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new leu(this);
    this.jdField_a_of_type_AndroidOsHandler = new lev(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.s = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new lex(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lep(this);
    this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new leq(this);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Lez.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Lez.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Lez.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Lez.jdField_b_of_type_Boolean) || (this.jdField_f_of_type_Boolean);
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i1;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i1 = 0;
        }
        for (;;)
        {
          if ((i1 >= paramArrayOfString1.length) || (!paramArrayOfString1[i1].equals(paramArrayOfString2[i1])))
          {
            int i2 = paramArrayOfString1.length;
            if (i1 == i2) {
              break;
            }
            bool = false;
            break;
          }
          i1 += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1) {}
    }
  }
  
  private void d()
  {
    super.setContentView(2130904289);
    setTitle(2131369991);
    setRightHighlightButton(2131368729, this);
    enableRightHighlight(false);
    setLeftButton(2131367262, new ler(this));
    this.leftView.setContentDescription("取消按钮");
    this.rightViewText.setContentDescription("完成按钮");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302179);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131302180));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131371648);
    this.jdField_a_of_type_Lez = new lez(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Lez);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131371647), "");
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302181);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302182));
    a(-1, false);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131302183);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131302184));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131302185);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131302186));
    a(0, 0, 0);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131302187);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302189));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302188));
    a(-1);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131302190);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_f_of_type_AndroidViewView.findViewById(2131302191));
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131371658);
    this.jdField_b_of_type_Lez = new lez(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Lez);
    a(this.jdField_f_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131371657), "");
    this.jdField_g_of_type_AndroidViewView = findViewById(2131302192);
    this.jdField_g_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)this.jdField_g_of_type_AndroidViewView.findViewById(2131302193));
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131371660);
    this.jdField_c_of_type_Lez = new lez(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Lez);
    a(this.jdField_g_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131371659), "");
    this.jdField_h_of_type_AndroidViewView = findViewById(2131302194);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131302195));
    a(null);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131302196);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_i_of_type_AndroidViewView.findViewById(2131302197));
    b(null);
    this.j = findViewById(2131302198);
    this.j.setClickable(false);
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)this.j.findViewById(2131302199));
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131371666);
    this.jdField_d_of_type_AndroidWidgetEditText.getInputType();
    this.jdField_d_of_type_Lez = new lez(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
    this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Lez);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.j, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131371665), "");
    this.k = findViewById(2131302200);
    this.k.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.k.findViewById(2131302201));
    this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine(false);
    c(null);
    a(this.k, this.jdField_h_of_type_AndroidWidgetTextView, getString(2131371667), "");
  }
  
  void a()
  {
    int i2 = 0;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296881);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130904203, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    int i1;
    if (this.jdField_a_of_type_Byte != 1) {
      i1 = 0;
    }
    for (;;)
    {
      ((IphonePickerView)localObject).setSelection(0, i1);
      if ((this.jdField_a_of_type_Byte != 0) && (this.jdField_a_of_type_Byte != 1))
      {
        i1 = i2;
        a(i1, true);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        i1 = 1;
        continue;
        i1 = this.jdField_a_of_type_Byte;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("DetailProfileActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  void a(int paramInt)
  {
    boolean bool = false;
    Object localObject2;
    Object localObject1;
    label74:
    TextView localTextView;
    String str;
    if (NearbyProfileUtil.a(paramInt))
    {
      this.jdField_i_of_type_Int = paramInt;
      localObject2 = NearbyProfileUtil.e(this.jdField_i_of_type_Int);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_i_of_type_Int = -1;
        localObject1 = getString(2131371656);
      }
      if ((this.jdField_i_of_type_Int < NearbyProfileUtil.e.length - 1) && (this.jdField_i_of_type_Int > 0)) {
        break label145;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (this.jdField_i_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (String)localObject1, bool);
      localObject2 = this.jdField_e_of_type_AndroidViewView;
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      str = getString(2131371655);
      if (this.jdField_i_of_type_Int == -1) {
        break label186;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.jdField_i_of_type_Int = -1;
      break;
      label145:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[this.jdField_i_of_type_Int]);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[this.jdField_i_of_type_Int]);
      break label74;
      label186:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = paramInt3;
    Object localObject2;
    Object localObject1;
    boolean bool1;
    label44:
    label70:
    Object localObject3;
    label87:
    Object localObject4;
    if (paramInt1 == 0)
    {
      localObject2 = getString(2131371652);
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramInt1 != 0) {
        break label203;
      }
      bool1 = true;
      a((TextView)localObject1, (String)localObject2, bool1);
      if (this.jdField_h_of_type_Int != 0) {
        break label209;
      }
      localObject1 = getString(2131371654);
      localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_h_of_type_Int != 0) {
        break label221;
      }
      bool1 = bool2;
      a((TextView)localObject3, (String)localObject1, bool1);
      localObject3 = this.jdField_c_of_type_AndroidViewView;
      localObject4 = this.jdField_b_of_type_AndroidWidgetTextView;
      String str = getString(2131371651);
      if (paramInt1 == 0) {
        break label227;
      }
      label122:
      a((View)localObject3, (View)localObject4, str, (String)localObject2);
      localObject2 = this.jdField_d_of_type_AndroidViewView;
      localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
      localObject4 = getString(2131371653);
      if (this.jdField_h_of_type_Int == 0) {
        break label235;
      }
    }
    for (;;)
    {
      a((View)localObject2, (View)localObject3, (String)localObject4, (String)localObject1);
      return;
      localObject2 = String.valueOf(paramInt2) + "岁";
      break;
      label203:
      bool1 = false;
      break label44;
      label209:
      localObject1 = Utils.a(this.jdField_h_of_type_Int);
      break label70;
      label221:
      bool1 = false;
      break label87;
      label227:
      localObject2 = "";
      break label122;
      label235:
      localObject1 = "";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.s = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new lew(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str1 = getString(2131371650);
    Object localObject;
    TextView localTextView;
    String str2;
    if (paramInt == 0)
    {
      str1 = getString(2131368209);
      if (!paramBoolean) {
        break label100;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, str1, 2131428268);
      localObject = this.jdField_b_of_type_AndroidViewView;
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      str2 = getString(2131371649);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label133;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      if (paramInt != 1) {
        break;
      }
      str1 = getString(2131368210);
      break;
      label100:
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((paramInt != 0) && (paramInt != 1)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a((TextView)localObject, str1, paramBoolean);
        break;
      }
      label133:
      str1 = "";
    }
  }
  
  public void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    if ((paramView2 instanceof TextView))
    {
      paramView2.setContentDescription(str);
      return;
    }
    paramView2.setContentDescription(paramString1 + ",编辑框," + paramString2 + ",");
  }
  
  void a(TextView paramTextView, String paramString, int paramInt)
  {
    paramTextView.setTextColor(getResources().getColor(paramInt));
    paramTextView.setText(paramString);
  }
  
  void a(TextView paramTextView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2131428306;; i1 = 2131428262)
    {
      a(paramTextView, paramString, i1);
      return;
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject2 = null;
    if ((!this.jdField_a_of_type_Lez.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strNick)))
    {
      this.jdField_a_of_type_Lez.jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty(paramCard.strNick)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCard.strNick);
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131371647), paramCard.strNick);
      if (!this.jdField_a_of_type_Boolean) {
        a(paramCard.shGender, false);
      }
      if (!this.jdField_b_of_type_Boolean) {
        a((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
      }
      if (!this.jdField_c_of_type_Boolean) {
        a(paramCard.iProfession);
      }
      if ((!this.jdField_b_of_type_Lez.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strCompany)))
      {
        this.jdField_b_of_type_Lez.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramCard.strCompany);
        a(this.jdField_f_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131371657), paramCard.strCompany);
      }
      if (!this.jdField_d_of_type_Boolean) {
        if (paramCard.strLocationCodes == null) {
          break label534;
        }
      }
    }
    label534:
    for (Object localObject1 = paramCard.strLocationCodes.split("-");; localObject1 = null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      a(paramCard.strLocationDesc);
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (paramCard.strHometownCodes != null) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        b(paramCard.strHometownDesc);
      }
      if ((!this.jdField_c_of_type_Lez.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strSchool)))
      {
        this.jdField_c_of_type_Lez.jdField_a_of_type_Boolean = true;
        this.jdField_c_of_type_AndroidWidgetEditText.setText(paramCard.strSchool);
        a(this.jdField_g_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131371659), paramCard.strSchool);
      }
      if ((!this.jdField_d_of_type_Lez.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!this.jdField_d_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strEmail)))
      {
        this.jdField_d_of_type_Lez.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_AndroidWidgetEditText.setText(paramCard.strEmail);
        a(this.j, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131371665), paramCard.strEmail);
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        c(paramCard.strPersonalNote);
        a(this.k, this.jdField_h_of_type_AndroidWidgetTextView, getString(2131371667), paramCard.strPersonalNote);
      }
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break;
    }
  }
  
  void a(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131371662);
      bool = true;
    }
    a(this.jdField_f_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_h_of_type_AndroidViewView;
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    String str2 = getString(2131371661);
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1);
      if (QLog.isColorLevel()) {
        QLog.d("DetailProfileActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131371450));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131371450));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    String[] arrayOfString1;
    if (paramInt == 1)
    {
      i1 = 2;
      localIntent.putExtra("param_req_type", i1);
      if (paramInt != 1) {
        break label280;
      }
      arrayOfString1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label179:
      String[] arrayOfString2;
      if (arrayOfString1 != null)
      {
        arrayOfString2 = arrayOfString1;
        if (arrayOfString1.length == 4) {}
      }
      else
      {
        arrayOfString2 = new String[4];
        arrayOfString2[0] = "0";
        arrayOfString2[1] = "0";
        arrayOfString2[2] = "0";
        arrayOfString2[3] = "0";
      }
      localIntent.putExtra("param_is_popup", false);
      localIntent.putExtra("param_location", arrayOfString2);
      localIntent.putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString2));
      if (paramInt != 1) {
        break label288;
      }
    }
    label280:
    label288:
    for (paramInt = 1002;; paramInt = 1003)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      i1 = 3;
      break;
      arrayOfString1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label179;
    }
  }
  
  void b(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131371664);
      bool = true;
    }
    a(this.jdField_g_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_i_of_type_AndroidViewView;
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    String str2 = getString(2131371663);
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Lez.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 1, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 2, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 3, 0, "", "", "", "");
      }
      if (this.jdField_h_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 4, 0, "", "", "", "");
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 5, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Lez.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 6, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Lez.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 7, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 9, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 8, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Lez.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 10, 0, "", "", "", "");
    }
    if (this.jdField_f_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 11, 0, "", "", "", "");
    }
  }
  
  void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = getString(2131371669);; str = paramString)
    {
      a(this.jdField_h_of_type_AndroidWidgetTextView, str, TextUtils.isEmpty(paramString));
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 == 1000)
    {
      paramInt1 = paramIntent.getShortExtra("param_year", (short)1990);
      paramInt2 = paramIntent.getByteExtra("param_month", (byte)1);
      int i1 = paramIntent.getByteExtra("param_day", (byte)1);
      int i2 = paramIntent.getIntExtra("param_age", 0);
      int i3 = paramIntent.getIntExtra("param_constellation_id", 0);
      int i4 = paramInt1 << 16 | paramInt2 << 8 | i1;
      if (i4 != this.jdField_f_of_type_Int)
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = true;
        a(i4, i2, i3);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DetailProfileActivity", 2, "onAgeSelectResult: year/month/day/age/constell" + paramInt1 + "  " + paramInt2 + "  " + i1 + "  " + i2 + "  " + i3 + "  " + this.jdField_i_of_type_Boolean);
      }
    }
    while (this.jdField_i_of_type_Boolean)
    {
      enableRightHighlight(true);
      return;
      if (paramInt1 == 1003)
      {
        paramIntent = paramIntent.getStringArrayExtra("param_location");
        if (!a(this.jdField_b_of_type_ArrayOfJavaLangString, paramIntent))
        {
          this.jdField_i_of_type_Boolean = true;
          this.jdField_b_of_type_ArrayOfJavaLangString = paramIntent;
          this.jdField_e_of_type_Boolean = true;
        }
      }
      try
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
        if (paramIntent != null)
        {
          localObject1 = paramIntent;
          if (!paramIntent.equals("不限")) {}
        }
        else
        {
          localObject1 = "";
        }
        b((String)localObject1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DetailProfileActivity", 2, "onHometownSelectResult: " + this.jdField_i_of_type_Boolean);
        continue;
        if (paramInt1 == 1002)
        {
          paramIntent = paramIntent.getStringArrayExtra("param_location");
          if (!a(this.jdField_a_of_type_ArrayOfJavaLangString, paramIntent))
          {
            this.jdField_a_of_type_ArrayOfJavaLangString = paramIntent;
            this.jdField_i_of_type_Boolean = true;
            this.jdField_d_of_type_Boolean = true;
          }
        }
        try
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
          if (paramIntent != null)
          {
            localObject1 = paramIntent;
            if (!paramIntent.equals("不限")) {}
          }
          else
          {
            localObject1 = "";
          }
          a((String)localObject1);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DetailProfileActivity", 2, "onLocationSelectResult: " + this.jdField_i_of_type_Boolean);
          continue;
          if (paramInt1 == 1004)
          {
            paramIntent = paramIntent.getStringExtra("result");
            if (paramIntent.equals(this.jdField_b_of_type_JavaLangString)) {
              continue;
            }
            this.jdField_i_of_type_Boolean = true;
            this.jdField_f_of_type_Boolean = true;
            c(paramIntent);
            continue;
          }
          if (paramInt1 != 1001) {
            continue;
          }
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          if (this.jdField_i_of_type_Int != paramInt1)
          {
            this.jdField_i_of_type_Boolean = true;
            this.jdField_c_of_type_Boolean = true;
            a(paramInt1);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DetailProfileActivity", 2, "onJobSelectResult: " + paramInt1 + " changed: " + this.jdField_i_of_type_Boolean);
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent = (Intent)localObject2;
          }
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent = (Intent)localObject1;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    d();
    this.app.a(new lem(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131371673, 2131370481, 2131369982, new ley(this), new leo(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    }
    finish();
    overridePendingTransition(0, 2130968584);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
        return;
      }
      break;
    case 2131302181: 
      a();
      return;
    case 2131302183: 
    case 2131302185: 
      if (paramView.getId() == 2131302183) {
        this.jdField_g_of_type_Boolean = true;
      }
      for (;;)
      {
        paramView = new Intent(this, AgeSelectionActivity.class);
        paramView.putExtra("param_birthday", this.jdField_f_of_type_Int);
        startActivityForResult(paramView, 1000);
        return;
        this.jdField_h_of_type_Boolean = true;
      }
    case 2131302187: 
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_i_of_type_Int);
      startActivityForResult(paramView, 1001);
      return;
    case 2131302194: 
      b(1);
      return;
    case 2131302196: 
      b(2);
      return;
    case 2131302200: 
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131371667).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131371669).putExtra("multiLine", true).putExtra("current", this.jdField_b_of_type_JavaLangString).putExtra("key_title_style", 1).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult(paramView, 1004);
      return;
    }
    if (this.jdField_d_of_type_Lez.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty(paramView)) && (!SearchBaseActivity.a.matcher(paramView).matches()))
      {
        QQToast.a(this, "邮箱格式不正确", 0).b(getTitleBarHeight());
        return;
      }
    }
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Lez.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        break label697;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        localBundle.putByte("sex", this.jdField_a_of_type_Byte);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localBundle.putInt("birthday", this.jdField_f_of_type_Int);
        localBundle.putInt("age", this.jdField_g_of_type_Int);
        localBundle.putInt("key_constellation", this.jdField_h_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        localBundle.putInt("profession", this.jdField_i_of_type_Int);
      }
      if (this.jdField_b_of_type_Lez.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Lez.jdField_b_of_type_Boolean) {
        localBundle.putString("college", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      Object localObject;
      if (this.jdField_d_of_type_Boolean)
      {
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("locationo_desc", this.jdField_f_of_type_AndroidWidgetTextView.getText().toString());
        localObject = null;
      }
      try
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putStringArray("location_name", paramView);
        if (this.jdField_e_of_type_Boolean)
        {
          localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
          localBundle.putString("hometown_desc", this.jdField_g_of_type_AndroidWidgetTextView.getText().toString());
        }
        if (this.jdField_d_of_type_Lez.jdField_b_of_type_Boolean) {
          localBundle.putString("email", this.jdField_d_of_type_AndroidWidgetEditText.getText().toString());
        }
        if (this.jdField_f_of_type_Boolean) {
          localBundle.putString("personalNote", this.jdField_b_of_type_JavaLangString);
        }
        if (localBundle.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(localBundle);
          a(3, getString(2131371670));
          return;
          label697:
          if (TextUtils.isEmpty(paramView.trim()))
          {
            QQToast.a(this, "昵称不可以为空", 0).b(getTitleBarHeight());
            return;
          }
          localBundle.putString("nick", paramView.trim());
          paramView = new QZoneDistributedAppCtrl.Control();
          paramView.a = 5;
          QZoneDistributedAppCtrl.a(getAppRuntime().getAccount()).a(paramView);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView = (View)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("DetailProfileActivity", 2, "onClick", localException);
            paramView = (View)localObject;
          }
        }
        finish();
        overridePendingTransition(0, 2130968584);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\DetailProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
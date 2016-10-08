package com.tencent.mobileqq.activity.bless;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.HbThemeConfigManager.HBThemeConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;
import ofn;
import ofo;
import ofp;
import ofq;
import ofr;
import ofs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BlessBaseActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BusinessObserver
{
  public static final long b = 300L;
  public static final long c = 15L;
  public static final long d = 67L;
  public static final String n = BlessBaseActivity.class.getSimpleName();
  public static final int o = 0;
  public static final String o = "uin_list";
  public static final int p = 64;
  public static final String p = "data";
  public static final int q = 1000;
  public static final String q = "token_id";
  public static final int r = 1001;
  public static final String r = "total_amount";
  public static final int s = 1002;
  public static final int t = 1;
  public static final int u = 2;
  private long jdField_a_of_type_Long;
  protected Dialog a;
  protected ProgressDialog a;
  protected CheckBox a;
  protected TextView a;
  protected BlessManager a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ofn(this);
  protected HbThemeConfigManager.HBThemeConfig a;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  private Dialog b;
  public boolean b;
  protected ImageView d;
  public long e;
  public long f;
  private long g;
  public String s;
  public String t;
  protected int v;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(n, 2, "cancelHongBao");
    }
    z();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Integer.valueOf(1000), getResources().getString(2131372375)));
    localArrayList.add(new Pair(Integer.valueOf(1001), getResources().getString(2131372376)));
    localArrayList.add(new Pair(Integer.valueOf(1002), getResources().getString(2131367262)));
    ActionSheet localActionSheet = ActionSheet.c(this);
    int i = 0;
    if (i < localArrayList.size())
    {
      if (1002 == ((Integer)((Pair)localArrayList.get(i)).first).intValue()) {
        localActionSheet.d((CharSequence)((Pair)localArrayList.get(i)).second);
      }
      for (;;)
      {
        i += 1;
        break;
        if (1000 == ((Integer)((Pair)localArrayList.get(i)).first).intValue()) {
          localActionSheet.a((CharSequence)((Pair)localArrayList.get(i)).second, 3);
        } else {
          localActionSheet.c((CharSequence)((Pair)localArrayList.get(i)).second);
        }
      }
    }
    localActionSheet.a(new ofo(this, localArrayList, localActionSheet));
    localActionSheet.setOnDismissListener(new ofp(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(n, 2, "show exception " + localException.getMessage());
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(n, 2, paramString + " is execute");
    }
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    for (;;)
    {
      z();
      return;
      if (paramInt == 1001)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.s = null;
        this.t = null;
      }
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(n, 2, paramString);
    }
    if (paramBoolean) {
      QQToast.a(this, paramInt, 1).a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  protected void A()
  {
    b(null);
  }
  
  public void B()
  {
    if (QLog.isColorLevel()) {
      QLog.e(n, 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void C()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.v), "", "", "");
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.b == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131372364));
      Object localObject = (FriendsManager)this.app.getManager(50);
      int i = 0;
      while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 50))
      {
        Friends localFriends = ((FriendsManager)localObject).c((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if (localFriends != null) {
          localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
        }
        i += 1;
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131372365), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      this.b = DialogUtil.a(this, -1, this.jdField_a_of_type_JavaLangString, 2131367262, 2131372366, new ofq(this), new ofr(this));
      if (this.v == 2)
      {
        localObject = this.b.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      localObject = (TextView)this.b.findViewById(2131296852);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new ofs(this, (TextView)localObject, localStringBuilder));
    }
    this.b.show();
  }
  
  public ChatActivityFacade.HongbaoParams a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int j = 1;
    ChatActivityFacade.HongbaoParams localHongbaoParams = new ChatActivityFacade.HongbaoParams();
    if (paramBoolean)
    {
      i = 1;
      localHongbaoParams.jdField_a_of_type_Int = i;
      if (this.v != 2) {
        break label106;
      }
    }
    label106:
    for (int i = j;; i = 0)
    {
      localHongbaoParams.jdField_b_of_type_Int = i;
      localHongbaoParams.jdField_b_of_type_Long = paramInt2;
      if ((paramBoolean) && (this.t != null))
      {
        localHongbaoParams.c = Long.valueOf(this.t).longValue();
        localHongbaoParams.jdField_a_of_type_ArrayOfByte = this.s.getBytes();
      }
      localHongbaoParams.jdField_a_of_type_Long = paramInt1;
      return localHongbaoParams;
      i = 0;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    long l = 300L;
    if (paramLong > 300L) {
      paramLong = l;
    }
    for (;;)
    {
      l = paramLong;
      if (paramLong <= 0L) {
        l = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d(n, 2, "setUploadUinOverloadDuration: " + l);
      }
      this.jdField_a_of_type_Long = l;
      return;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("h5_success", false);
      localJSONObject.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#multi");
      paramString = new Bundle();
      paramString.putString("json", localJSONObject.toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", System.currentTimeMillis());
      PayBridgeActivity.a(this, 9, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(long paramLong)
  {
    long l = 300L;
    if (paramLong > 300L) {
      paramLong = l;
    }
    for (;;)
    {
      l = paramLong;
      if (paramLong <= 0L) {
        l = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d(n, 2, "setSendMsgOverloadDuration: " + l);
      }
      this.g = l;
      return;
    }
  }
  
  protected void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(n, 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        if (this.v == 2)
        {
          localObject = this.jdField_a_of_type_AndroidAppProgressDialog.getWindow();
          ((Window)localObject).getAttributes().dimAmount = 0.7F;
          ((Window)localObject).addFlags(2);
        }
      }
      Object localObject = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665);
      if (TextUtils.isEmpty(paramString)) {
        ((TextView)localObject).setText(2131368771);
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        ((TextView)localObject).setText(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(n, 2, "showProgressDialog", paramString);
      }
    }
  }
  
  protected abstract void b(boolean paramBoolean);
  
  public boolean b()
  {
    if (this.g > 0L)
    {
      long l = System.currentTimeMillis() - this.f;
      if (QLog.isColorLevel()) {
        QLog.d(n, 2, "send text overload=" + l / 1000L + " duration=" + this.g);
      }
      if (l > this.g * 1000L)
      {
        b(0L);
        this.f = 0L;
      }
    }
    else
    {
      return true;
    }
    QQToast.a(this, 2131372386, 1).a();
    return false;
  }
  
  public abstract void c(boolean paramBoolean);
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("data");
        try
        {
          paramIntent = new JSONObject(paramIntent);
          this.s = paramIntent.getString("token_id");
          this.t = paramIntent.getString("total_amount");
          if (QLog.isColorLevel()) {
            QLog.d(n, 2, "doOnActivityResult MASS_BLESS_ORDER token=" + this.s + " amount=" + this.t);
          }
          if ((this.s == null) || (this.s.equals("")) || (this.t == null) || (this.t.equals("")))
          {
            a("no token or amount", 2131368649, true);
            return;
          }
        }
        catch (Throwable paramIntent)
        {
          paramIntent.printStackTrace();
          a("order result not OK", 2131368649, false);
          return;
        }
        float f1 = Float.valueOf(this.t).floatValue() / 100.0F;
        paramIntent = String.format(getResources().getString(2131372382), new Object[] { Float.valueOf(f1) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
        return;
      }
      a("order result not OK", 2131368649, false);
      return;
    }
    paramIntent = paramIntent.getStringExtra("result");
    for (;;)
    {
      try
      {
        paramInt1 = new JSONObject(paramIntent).getInt("resultCode");
        if (paramInt1 != 0) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        boolean bool = false;
        continue;
        b(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(n, 2, "onActivityResult: mPayAction=" + bool);
      }
      if (!bool) {
        continue;
      }
      b(true);
      return;
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getStringArrayListExtra("uin_list");
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      finish();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = BlessManager.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("BlessSendTextActivity doOnCreate uinList=");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label140;
      }
    }
    label140:
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      QLog.d(paramBundle, 2, i);
      this.app.registObserver(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.unRegistObserver(this);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    super.doOnPostCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297160));
    this.d = ((ImageView)findViewById(2131297161));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297162));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    findViewById(2131296906).setOnClickListener(this);
    findViewById(2131297202).setOnClickListener(this);
    findViewById(2131297201).setOnClickListener(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public abstract void n();
  
  public void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(this.v), "", "", "");
    finish();
    overridePendingTransition(2130968592, 2130968593);
  }
  
  protected boolean onBackEvent()
  {
    o();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l = System.currentTimeMillis() - this.e;
        if (QLog.isColorLevel()) {
          QLog.d(n, 2, "send uin list overload=" + l / 1000L + " duration=" + this.jdField_a_of_type_Long);
        }
        if (l > this.jdField_a_of_type_Long * 1000L)
        {
          a(0L);
          this.e = 0L;
        }
      }
      else
      {
        this.d.setImageResource(2130837974);
        ReportController.b(this.app, "CliOper", "", "", "0X800618F", "0X800618F", 0, 0, String.valueOf(this.v), "", "", "");
        BlessUploadUinListServlet.a(this.app, this.jdField_a_of_type_JavaUtilArrayList);
        A();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      QQToast.a(this, 2131372386, 1).a();
      return;
    }
    this.d.setImageResource(2130837975);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131372381));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296906: 
    case 2131297201: 
    case 2131297202: 
      o();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      a();
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = null;
    paramInt = 0;
    B();
    if (paramBundle == null)
    {
      paramBundle = "onReceive bundle is null";
      paramInt = 2131372387;
    }
    for (;;)
    {
      if (paramBundle != null) {
        a(paramBundle, paramInt, true);
      }
      return;
      String str = paramBundle.getString("store.key");
      int i = paramBundle.getInt("k_result_code", -1);
      int j = paramBundle.getInt("k_wait_time", 0);
      if (i < 0)
      {
        paramBundle = "result = " + i;
        if (i == -8)
        {
          this.e = System.currentTimeMillis();
          a(j);
          paramInt = 2131372386;
        }
        else
        {
          paramInt = 2131372387;
        }
      }
      else if (!paramBoolean)
      {
        paramBundle = "onReceive result false";
        paramInt = 2131372387;
      }
      else if ((str == null) || (str.equals("")))
      {
        paramBundle = "onReceive key = " + str;
        paramInt = 2131372387;
      }
      else
      {
        paramBundle = PlusPanelUtils.a(this.app);
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig = ((HbThemeConfigManager.HBThemeConfig)paramBundle.get(0));
          paramBundle = new JSONObject();
          if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig == null) {}
        }
        try
        {
          paramBundle.put("hb_theme_id", this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_JavaLangString)) {
            paramBundle.put("hb_theme_name", this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_b_of_type_JavaLangString)) {
            paramBundle.put("hb_theme_img", this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_b_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_b_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_b_of_type_OrgJsonJSONArray.length() > 0)) {
            paramBundle.put("hb_theme_money_array", this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_b_of_type_OrgJsonJSONArray);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_OrgJsonJSONArray.length() > 0)) {
            paramBundle.put("hb_theme_wish_array", this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_OrgJsonJSONArray);
          }
          paramBundle.put("channel", "64");
          localJSONObject = new JSONObject();
          if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig == null) {}
        }
        catch (JSONException paramBundle)
        {
          JSONObject localJSONObject;
          Intent localIntent;
          paramBundle = "onReceive json exception" + paramBundle.toString();
          paramInt = 2131372387;
        }
        try
        {
          localJSONObject.put("channel", "64");
          localIntent = new Intent();
          localIntent.setClass(this, SendHbActivity.class);
          localIntent.putExtra("theme", true);
          localIntent.putExtra("come_from", 2);
          localIntent.putExtra("group_id", "" + str);
          localIntent.putExtra("group_member_number", "" + this.jdField_a_of_type_JavaUtilArrayList.size());
          localIntent.putExtra("theme_type", "" + this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager$HBThemeConfig.jdField_a_of_type_Int);
          localIntent.putExtra("theme_config", paramBundle.toString());
          localIntent.putExtra("extra_data", localJSONObject.toString());
          localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#multi");
          localIntent.addFlags(536870912);
          localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_bless=true", 0, null));
          startActivityForResult(localIntent, 0);
          paramBundle = (Bundle)localObject;
        }
        catch (JSONException paramBundle)
        {
          paramBundle = "onReceive json exception" + paramBundle.toString();
          paramInt = 2131372387;
        }
        paramBundle = "onReceive no theme config";
        paramInt = 2131372387;
        continue;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.onTouchEvent(paramMotionEvent)) {
      o();
    }
    return true;
  }
  
  public void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    Intent localIntent = new Intent(this, BlessResultActivity.class);
    localIntent.putExtra("param_method", this.v);
    localIntent.putExtra("param_count", this.jdField_a_of_type_JavaUtilArrayList.size());
    startActivity(localIntent);
    finish();
  }
  
  public void z()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(n, 2, "dismiss exception " + localException.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
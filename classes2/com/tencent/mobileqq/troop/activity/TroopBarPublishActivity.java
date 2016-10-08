package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Hashtable;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;
import vhl;
import vhm;
import vhn;
import vho;

public class TroopBarPublishActivity
  extends AbsPublishActivity
  implements TextWatcher
{
  public static final String I = TroopBarPublishActivity.class.getName();
  protected static final int t = 2000;
  protected String J;
  Animation.AnimationListener a;
  public TroopBarMyBar a;
  private Handler b;
  protected View e;
  protected TextView e;
  protected boolean n;
  public boolean o;
  public final int u;
  public int v;
  public int w;
  public int x;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopBarPublishActivity()
  {
    this.jdField_u_of_type_Int = 4;
    this.jdField_b_of_type_AndroidOsHandler = new vhl(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new vhn(this);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVideoCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setMusicCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setAudioCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_e_of_type_AndroidViewView = ((ViewStub)findViewById(2131299737)).inflate();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299753));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if ((!"barindex".equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_i_of_type_Int == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString);
        this.jdField_n_of_type_Boolean = true;
        TroopBarUtils.b(this, (Bundle)localObject, "http://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.jdField_c_of_type_Boolean) {
        b(2131364603);
      }
      o();
      StringBuffer localStringBuffer = new StringBuffer();
      if ((this.jdField_n_of_type_Int & 0x1) == 1) {
        localStringBuffer.append("0");
      }
      if ((this.jdField_n_of_type_Int & 0x2) == 2) {
        localStringBuffer.append("1");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label306;
      }
      localObject = "0";
      label223:
      TroopBarUtils.a("pub_page", "exp", (String)localObject, this.jdField_c_of_type_JavaLangString, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label317;
      }
    }
    label306:
    label317:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "choose_place", (String)localObject, "0", "", "");
      if (this.jdField_i_of_type_Int == 2) {
        TroopBarUtils.a("Grp_talk", "pub_talk", "exp", this.jdField_w_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "");
      }
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString;
      break label223;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        a(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt2) {
          bool = true;
        }
        ((TroopBarImagePreviewAdapter)localObject).a(bool, true);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label130;
      }
    }
    label130:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "del_photo", (String)localObject, "", "", "");
      return;
      if (this.jdField_o_of_type_Boolean) {
        break;
      }
      this.jdField_w_of_type_Int = paramInt1;
      this.jdField_x_of_type_Int = paramInt2;
      c(paramInt1);
      break;
    }
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(paramInt))
    {
      a(this, TroopBarPublishActivity.class.getName());
      return;
    }
    AlbumUtil.a();
    paramView = new Intent();
    paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
    paramView.putExtra("back_btn_text", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364963));
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_JavaUtilArrayList.size());
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramView.putExtra("PhotoConst.IS_OVERLOAD", false);
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhotoPreviewActivity.class);
    paramView.addFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    AlbumUtil.a(this, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
    for (paramView = "0";; paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "choose_photo", paramView, "", "", "");
      return;
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      l = Long.parseLong(paramJSONObject.optString("bid"));
      this.J = paramJSONObject.optString("extparam");
      if (l > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = new TroopBarMyBar(l, paramJSONObject.optString("barName"));
        this.jdField_q_of_type_JavaLangString = (this.app.a() + "-" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString);
        this.jdField_v_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString;
      }
      this.t = "Grp_tribe";
      this.jdField_u_of_type_JavaLangString = "pub_page";
      b(paramJSONObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, localNumberFormatException.getMessage());
        }
        long l = 0L;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    super.a(paramJSONObject, paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.optInt("retcode", -1) == -1) {
          break;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_n_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.jdField_v_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_c_of_type_Boolean) {
        l();
      }
    } while (!this.jdField_n_of_type_Boolean);
    this.jdField_n_of_type_Boolean = false;
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.f = paramJSONObject.optInt("flag");
    }
    this.jdField_j_of_type_Boolean = paramJSONObject.optBoolean("photoOrContent");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("from");
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory", true);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("minTitleLength", this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = paramJSONObject.optInt("maxTitleLength", this.jdField_c_of_type_Int);
    this.jdField_h_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_h_of_type_JavaLangString);
    this.jdField_j_of_type_Int = paramJSONObject.optInt("minContentLength", this.jdField_j_of_type_Int);
    this.k = paramJSONObject.optInt("maxContentLength", this.k);
    this.jdField_o_of_type_JavaLangString = paramJSONObject.optString("contentPlaceholder", this.jdField_o_of_type_JavaLangString);
    this.jdField_h_of_type_Boolean = paramJSONObject.optBoolean("needLocation", true);
    this.jdField_i_of_type_Boolean = paramJSONObject.optBoolean("needFace", true);
    for (;;)
    {
      try
      {
        paramBundle = paramJSONObject.getJSONObject("publish_condition");
        if (paramBundle.optInt("requireType", 0) == 0) {
          continue;
        }
        bool = true;
        this.l = bool;
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        if (!this.jdField_n_of_type_Boolean) {
          continue;
        }
        this.jdField_n_of_type_Int |= paramBundle.optInt("optionType");
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.f == 1)) {
          this.jdField_n_of_type_Int |= 0x1;
        }
        if (paramBundle.optInt("recordTimeLimit") != 0) {
          continue;
        }
        paramInt = 60000;
        this.m = paramInt;
        this.p = paramBundle.optInt("forbiddenType", 0);
        this.jdField_r_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131364957));
      }
      catch (JSONException paramBundle)
      {
        boolean bool;
        continue;
        paramInt = 0;
        continue;
      }
      a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vhm(this), 200L);
      c(paramJSONObject);
      break;
      bool = false;
      continue;
      this.jdField_n_of_type_Int = paramBundle.optInt("optionType");
      continue;
      if (!"barindex".equals(this.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      paramInt = i;
      this.jdField_n_of_type_Int = paramBundle.optInt("optionType", paramInt);
      continue;
      paramInt = paramBundle.optInt("recordTimeLimit");
      paramInt *= 1000;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 0;
    super.afterTextChanged(paramEditable);
    this.jdField_q_of_type_Int = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
    this.jdField_r_of_type_Int = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    int i;
    if (str == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onTextChanged: " + i + "--" + this.jdField_q_of_type_Int + "--" + this.jdField_r_of_type_Int);
      }
      if ((this.k <= 0) || (i <= this.k)) {
        break label219;
      }
      i -= this.k;
      paramEditable.delete(this.jdField_q_of_type_Int - i, this.jdField_r_of_type_Int);
      this.jdField_q_of_type_Int -= i;
      this.jdField_r_of_type_Int -= i;
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label233;
      }
      QQToast.a(this, this.jdField_x_of_type_JavaLangString, 0).b(getTitleBarHeight());
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    label219:
    label233:
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetEditText.setSelection(i + this.jdField_q_of_type_Int);
      return;
      i = str.length();
      break;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i = j;
    }
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("share_from_app");
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("share_info");
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    TroopBarShareUtils.a(this.app, "share_ask", paramJSONObject.optString("bid"));
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 4;
    this.jdField_c_of_type_Int = 25;
    this.jdField_h_of_type_JavaLangString = getString(2131364768, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
    this.jdField_j_of_type_Int = 10;
    this.k = 700;
    this.jdField_o_of_type_JavaLangString = getString(2131364769, new Object[] { Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.k) });
    this.jdField_n_of_type_Int |= 0x1;
  }
  
  public void c(int paramInt)
  {
    boolean bool = false;
    if (paramInt == 8)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_x_of_type_Int) {
        bool = true;
      }
      ((TroopBarImagePreviewAdapter)localObject1).a(bool, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    label121:
    label169:
    do
    {
      return;
      this.jdField_v_of_type_Int = 0;
      this.jdField_o_of_type_Boolean = true;
      localObject1 = a(1.0F, 0.0F);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
      if (localObject2 != null) {
        ((View)localObject2).startAnimation((Animation)localObject1);
      }
      paramInt += 1;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        int j;
        int i;
        if (paramInt % 4 == 0)
        {
          j = 3;
          i = -1;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
          localObject2 = b(j, i);
          ((Animation)localObject2).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          if (localObject1 != null) {
            break label169;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          i = 0;
          j = -1;
          break label121;
          ((View)localObject1).startAnimation((Animation)localObject2);
          this.jdField_v_of_type_Int += 1;
        }
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    } while ((paramInt != 4) && (paramInt != 8));
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a());
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject1);
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString = paramJSONObject.optString("barName");
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString);
      this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString);
    }
  }
  
  protected void d(int paramInt)
  {
    if (paramInt == 1) {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      a(0);
      return;
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      case 1002: 
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j))
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
            a(1, new String[] { paramIntent });
            label96:
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
              break label145;
            }
          }
        }
        label145:
        for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "choose_place", paramIntent, "2", "", "");
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
          break;
          a(0, new String[0]);
          break label96;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)paramIntent.getParcelableExtra("key_selected_item"));
      paramInt1 = paramIntent.getIntExtra("key_drop_media_data", -1);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
      {
        this.jdField_v_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString;
        this.jdField_q_of_type_JavaLangString = (this.app.a() + "-" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString);
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_v_of_type_JavaLangString;
        this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        paramIntent = new Bundle();
        paramIntent.putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString);
        TroopBarUtils.b(this, paramIntent, "http://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
        if (this.jdField_c_of_type_Boolean)
        {
          this.l = false;
          this.jdField_n_of_type_Int = 0;
        }
      }
      while (paramInt1 > 0)
      {
        d(paramInt1);
        return;
        this.jdField_e_of_type_AndroidWidgetTextView.setText(null);
        paramIntent = getString(2131364802);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.d) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      TroopBarShareUtils.a(this, this.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id"));
    }
    String str1;
    if (!this.d)
    {
      if (((this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText.length() <= 0)) && ((this.jdField_b_of_type_AndroidWidgetEditText == null) || (this.jdField_b_of_type_AndroidWidgetEditText.length() <= 0)) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0))) {
        break label125;
      }
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label131;
      }
    }
    label125:
    label131:
    for (String str2 = "0";; str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "un", str2, str1, "", "");
      return;
      str1 = "1";
      break;
    }
  }
  
  public void j()
  {
    try
    {
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity$AudioUploadTask.a() != 0))
      {
        b(true);
        this.rightViewText.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      }
      Object localObject1;
      label590:
      label601:
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
        {
          QQToast.a(this, 2131364773, 1).b(getTitleBarHeight());
          n();
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "8", "", "");
            return;
          }
        }
        if (this.g)
        {
          localObject1 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1393;
          }
          localObject1 = ((String)localObject1).trim();
          i = ((String)localObject1).length();
          if (i == 0)
          {
            QQToast.a(this, 2131364774, 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "0", "", "");
              return;
            }
          }
          if (i < this.jdField_b_of_type_Int)
          {
            QQToast.a(this, getString(2131364776, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "0", "", "");
              return;
            }
          }
          if (i > this.jdField_c_of_type_Int)
          {
            QQToast.a(this, getString(2131364777, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "1", "", "");
              return;
            }
          }
          localObject3 = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break;
          }
          localObject3 = ((String)localObject3).trim();
          i = ((String)localObject3).length();
          if ((this.jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
            continue;
          }
          if (i >= this.jdField_j_of_type_Int) {
            break label601;
          }
          QQToast.a(this, getString(2131364778, new Object[] { Integer.valueOf(this.jdField_j_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            break label590;
          }
        }
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "2", "", "");
          return;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
            break;
          }
          QQToast.a(this, 2131364780, 0).b(getTitleBarHeight());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "35", "", "");
            return;
          }
        }
        if (i > this.k)
        {
          QQToast.a(this, getString(2131364779, new Object[] { Integer.valueOf(this.k) }), 0).b(getTitleBarHeight());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "4", "", "");
            if (this.jdField_i_of_type_Int != 2) {
              break;
            }
            ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "1", "", "", "");
            return;
          }
        }
      } while (!a(this.jdField_n_of_type_Int, this.l));
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.f == 1) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
      {
        QQToast.a(this, 2131364804, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "9", "", "");
          return;
        }
      }
      if (!HttpUtil.a(this))
      {
        QQToast.a(this, 2131367339, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "7", "", "");
          if (this.jdField_i_of_type_Int != 2) {
            break;
          }
          ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "2", "", "", "");
          return;
        }
      }
      b(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label1070;
        }
        localObject4 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject4) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "10", "", "");
            if (this.jdField_i_of_type_Int != 2) {
              break;
            }
            ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "3", "", "", "");
            return;
          }
        }
        i += 1;
      }
      label1070:
      Object localObject4 = TroopBarPublishUtils.a((String)localObject3, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      Object localObject3 = new JSONObject();
      for (;;)
      {
        try
        {
          long l;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
          {
            l = 0L;
            ((JSONObject)localObject3).put("bid", l);
            ((JSONObject)localObject3).put("post", localObject4);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((JSONObject)localObject3).put("title", localObject1);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              ((JSONObject)localObject3).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_h_of_type_JavaLangString);
              ((JSONObject)localObject3).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
              ((JSONObject)localObject3).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a));
            }
            ((JSONObject)localObject3).put("type", 0);
            ((JSONObject)localObject3).put("extparam", this.J);
            ((JSONObject)localObject3).put("version", "6.5.5.2880");
            ((JSONObject)localObject3).put("pfrom", this.jdField_b_of_type_JavaLangString);
            localObject4 = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
            if (this.jdField_i_of_type_Int == 1)
            {
              localObject1 = "MQUpdateSvc_com_qq_xiaoqu.web.publish_post";
              ((NewIntent)localObject4).putExtra("cmd", (String)localObject1);
              localObject1 = new WebSsoBody.WebSsoRequestBody();
              ((WebSsoBody.WebSsoRequestBody)localObject1).type.set(0);
              ((WebSsoBody.WebSsoRequestBody)localObject1).data.set(((JSONObject)localObject3).toString());
              ((NewIntent)localObject4).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
              ((NewIntent)localObject4).setObserver(new vho(this));
              this.app.startServlet((NewIntent)localObject4);
            }
          }
          else
          {
            l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString);
            continue;
          }
          String str = "MQUpdateSvc_com_qq_buluo.web.sbar_publish_post";
        }
        catch (Exception localException1)
        {
          QQToast.a(this, 1, 2131364761, 0).b(getTitleBarHeight());
          localException1.printStackTrace();
          return;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        int i = 0;
        continue;
        Object localObject2 = null;
        continue;
        label1393:
        i = 0;
      }
    }
  }
  
  protected void m()
  {
    n();
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {
        break label50;
      }
    }
    label50:
    for (String str2 = "0";; str2 = "1")
    {
      TroopBarUtils.a("pub_page", "choose_tribe", str1, str2, "", "");
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString;
      break;
    }
  }
  
  protected void n()
  {
    Intent localIntent = new Intent(this, TroopBarPublishBarSelectActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      localIntent.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    }
    int i = -1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i > 0) {
        localIntent.putExtra("key_media_data", i);
      }
      startActivityForResult(localIntent, 2000);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        i = 2;
      }
    }
  }
  
  protected void o()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      Object localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_title");
      Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_content");
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_img_list");
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_h_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_c_of_type_Int) });
      }
      if (this.jdField_b_of_type_AndroidWidgetEditText != null)
      {
        localObject3 = this.jdField_b_of_type_AndroidWidgetEditText;
        if (localObject2 != null) {
          break label209;
        }
      }
      label209:
      for (Object localObject1 = "";; localObject1 = localObject2)
      {
        ((EditText)localObject3).setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_o_of_type_JavaLangString);
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject1 = str.split(";");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          return;
        }
        localObject2 = new ArrayList();
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = new TroopBarPublishUtils.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList, "http://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask, 8, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131299750: 
    default: 
      return;
    case 2131299751: 
      m();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      paramView = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label100;
      }
    }
    label100:
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("pub_page", "Clk_place", paramView, str, "", "");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_x_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
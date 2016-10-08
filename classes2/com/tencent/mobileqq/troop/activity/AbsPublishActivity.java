package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataCacheEntity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vct;
import vcu;
import vcv;
import vcw;
import vcx;
import vcy;
import vcz;
import vda;
import vdb;
import vdc;
import vdd;
import vde;
import vdf;

public abstract class AbsPublishActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodLinearLayout.onSizeChangeListenner
{
  protected static final int a = 200;
  public static Editable.Factory a;
  protected static final int d = 4;
  protected static final String d = "needCategory";
  protected static final int e = 25;
  protected static final String e = "titlePlaceholder";
  protected static final int f = 10;
  protected static final String f = "minTitleLength";
  protected static final int g = 700;
  protected static final String g = "maxTitleLength";
  private static final int t = 100;
  protected long a;
  protected BroadcastReceiver a;
  protected Drawable a;
  public Uri a;
  protected Handler a;
  protected View a;
  public EditText a;
  protected FrameLayout a;
  public ImageButton a;
  protected ImageView a;
  public RelativeLayout a;
  protected TextView a;
  public BaseActivity a;
  protected SosoInterface.OnLocationListener a;
  public SystemEmoticonPanel a;
  protected AbsPublishActivity.AudioUploadTask a;
  public ExtendGridView a;
  public TroopBarImagePreviewAdapter a;
  protected TroopBarPublishUtils.PreUploadTask a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemBar a;
  public PublishItemContainer a;
  protected InputMethodLinearLayout a;
  public QQProgressDialog a;
  protected ActionSheet a;
  protected ScrollView a;
  protected Boolean a;
  protected String a;
  public ArrayList a;
  public JSONObject a;
  protected boolean a;
  protected int b;
  public View b;
  public EditText b;
  protected ImageView b;
  protected TextView b;
  protected QQProgressDialog b;
  protected String b;
  protected ArrayList b;
  protected boolean b;
  protected int c;
  public View c;
  public String c;
  public boolean c;
  public boolean d;
  protected boolean e = true;
  protected boolean f = true;
  protected boolean g = true;
  public int h;
  protected String h;
  protected boolean h;
  public int i;
  protected String i;
  protected boolean i;
  protected int j;
  protected String j;
  protected boolean j;
  protected int k;
  protected String k;
  protected boolean k;
  protected int l;
  protected String l;
  protected boolean l;
  public int m;
  protected String m;
  protected int n;
  protected String n;
  protected int o;
  protected String o;
  protected int p;
  protected String p;
  protected int q;
  protected String q;
  protected int r;
  protected String r;
  int s;
  protected String s;
  public String t;
  public String u;
  public String v;
  protected String w;
  protected String x = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidTextEditable$Factory = new vcu();
  }
  
  public AbsPublishActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_j_of_type_JavaLangString = "http://upload.buluo.qq.com/cgi-bin/bar/upload/image";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_h_of_type_Int = 9;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vcz(this);
    this.jdField_a_of_type_AndroidOsHandler = new vda(this);
    this.jdField_s_of_type_Int = 0;
  }
  
  public static String a(JSONArray paramJSONArray, String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      JSONArray localJSONArray = paramJSONArray;
      if (paramJSONArray == null) {
        localJSONArray = new JSONArray();
      }
      paramJSONArray = new JSONObject();
      paramJSONArray.put("imagePath", paramString);
      localJSONArray.put(paramJSONArray);
      return localJSONArray.toString();
    }
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findFocus() == this.jdField_b_of_type_AndroidWidgetEditText) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130842146);
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131364800));
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected int a()
  {
    return 2131364806;
  }
  
  public Animation a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  protected void a()
  {
    setContentView(2130903694);
    if (android.text.TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
    {
      setTitle(2131364770);
      setLeftViewName(2131367262);
      setRightButton(2131364771, this);
      if (AppSetting.jdField_j_of_type_Boolean)
      {
        this.leftView.setContentDescription(getString(2131364792));
        this.rightViewText.setContentDescription(getString(2131364793));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)findViewById(2131299437));
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131297559));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299761));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299735));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131299746);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299747));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299748));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299749));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299738));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299739));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299741));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131299743);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = ((ExtendGridView)findViewById(2131299744));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299759));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131299742));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131299745);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar = ((PublishItemBar)findViewById(2131299740));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setCallback(this.jdField_a_of_type_AndroidOsHandler);
      if (this.jdField_n_of_type_Int != 0) {
        break label530;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      label329:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      if (!this.g) {
        break label552;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    }
    for (;;)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if ((localDisplayMetrics != null) && (localDisplayMetrics.heightPixels <= 800)) {
        this.jdField_b_of_type_AndroidWidgetEditText.setMinLines(3);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new vde(this) });
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      a(this, this);
      i();
      if (!android.text.TextUtils.isEmpty(this.jdField_s_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_s_of_type_JavaLangString);
      }
      return;
      setTitle(this.jdField_k_of_type_JavaLangString);
      break;
      label530:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.jdField_n_of_type_Int);
      break label329;
      label552:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    default: 
      return;
    case 0: 
      Resources localResources = getResources();
      paramInt = (int)localResources.getDimension(2131493261);
      int i1 = (int)localResources.getDimension(2131493262);
      if (this.jdField_n_of_type_Int == 0) {}
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), paramInt);
        f();
        return;
        paramInt = paramInt + i1 + localResources.getDrawable(2130839425).getIntrinsicHeight();
      }
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(0);
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  protected void a(int paramInt, Handler paramHandler)
  {
    runOnUiThread(new vdc(this));
    if (((TicketManager)this.app.getManager(2)).getSkey(this.app.a()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.a(new TroopBarPublishUtils.PicUploadThread(this, paramHandler, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_j_of_type_JavaLangString), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(int paramInt, MediaInfo paramMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
    a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramMediaInfo instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
    }
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    boolean bool = false;
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramInt = 8;
      paramVarArgs = (String[])localObject;
      label41:
      this.jdField_a_of_type_AndroidViewView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if (AppSetting.jdField_j_of_type_Boolean) {
        if (!bool) {
          break label255;
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131366734);
      paramInt = 8;
      break label41;
      String str = getString(2131366733);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      paramInt = 8;
      paramVarArgs = str;
      break label41;
      paramVarArgs = getString(2131366732);
      paramInt = 8;
      break label41;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        paramInt = 0;
        bool = true;
        break label41;
      }
      a(0, new String[0]);
      return;
      label255:
      paramVarArgs = getString(2131364799);
    }
  }
  
  abstract void a(View paramView, int paramInt, long paramLong);
  
  protected void a(BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new vcv(this, 0, true, true, this.jdField_s_of_type_Int, false, false, "AbsPublish", paramBaseActivity, paramCallback);
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    a(2, new String[0]);
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    paramString = ActionSheet.a(paramBaseActivity);
    paramString.a(2131370357, 1);
    paramString.a(2131370359, 1);
    paramString.d(2131367262);
    paramString.a(new vdd(this, paramBaseActivity, paramString));
    paramString.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramString;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_b_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_b_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i1 = 0;
          while (i1 < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i1);
            if (localJSONObject != null) {
              a(this.jdField_a_of_type_AndroidOsHandler, localJSONObject.optString("imagePath"));
            }
            i1 += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(paramString));
        }
      }
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("minTitleLength", 4);
    this.jdField_c_of_type_Int = paramJSONObject.optInt("maxTitleLength", 25);
    this.jdField_h_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_h_of_type_JavaLangString);
    if (this.jdField_i_of_type_Int == 2) {
      this.jdField_c_of_type_JavaLangString = "sbarindex";
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("topicFrom")) {
        break label146;
      }
      this.jdField_c_of_type_JavaLangString = String.valueOf(0);
    }
    for (;;)
    {
      k();
      com.tencent.biz.common.util.ImageUtil.a((String)null, 0);
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("key_photo_delete_action");
      paramJSONObject.addAction("key_audio_delete_action");
      paramJSONObject.addAction("key_audio_play_action");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
      label146:
      if (this.jdField_a_of_type_JavaLangString.equals("sbarindex")) {
        this.jdField_c_of_type_JavaLangString = "sbarindex";
      } else {
        this.jdField_c_of_type_JavaLangString = String.valueOf(1);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_b_of_type_JavaUtilArrayList == null)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          break label226;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_k_of_type_JavaLangString;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      label226:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  protected boolean a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.q);
    }
    if (android.text.TextUtils.isEmpty(this.q)) {
      return false;
    }
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.a.get(this.q);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.q + ", data = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.a.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_i_of_type_JavaLangString = localPublishDataCacheEntity.jdField_c_of_type_JavaLangString;
    this.jdField_p_of_type_JavaLangString = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    this.jdField_h_of_type_JavaLangString = localPublishDataCacheEntity.jdField_a_of_type_JavaLangString;
    this.jdField_o_of_type_JavaLangString = localPublishDataCacheEntity.jdField_b_of_type_JavaLangString;
    if ((android.text.TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_c_of_type_Int = 25;
      this.jdField_h_of_type_JavaLangString = getString(2131364768, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if ((android.text.TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) || (this.jdField_j_of_type_Int < 0) || (this.jdField_k_of_type_Int <= 0))
    {
      this.jdField_j_of_type_Int = 10;
      this.jdField_k_of_type_Int = 700;
      this.jdField_o_of_type_JavaLangString = getString(2131364769, new Object[] { Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.jdField_k_of_type_Int) });
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = null;
    if ((this.jdField_p_of_type_Int & paramInt) == paramInt)
    {
      switch (paramInt)
      {
      }
      while (localObject != null)
      {
        QQToast.a(this, (CharSequence)localObject, 0).b(getTitleBarHeight());
        return true;
        localObject = getString(2131364959, new Object[] { this.r });
        continue;
        localObject = getString(2131364958, new Object[] { this.r });
      }
    }
    return false;
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      String str = null;
      if (((paramInt & 0x1) == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        str = getString(2131364962, new Object[] { getString(2131364947) });
      }
      while (str != null)
      {
        QQToast.a(this, str, 0).b(getTitleBarHeight());
        return false;
        if (((paramInt & 0x2) == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null)) {
          str = getString(2131364962, new Object[] { getString(2131364945) });
        } else if ((paramInt & 0x4) == 4) {
          str = getString(2131364962, new Object[] { getString(2131364946) });
        } else if ((paramInt & 0x8) == 8) {
          str = getString(2131364962, new Object[] { getString(2131364948) });
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131364960), 1).b(getTitleBarHeight());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131366624, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 9))
    {
      QQToast.a(this, getString(2131366624, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    if (paramArrayList != this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
    }
    for (;;)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(1005));
      return true;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    int i1;
    if (paramEditable == null)
    {
      i1 = 0;
      if ((this.jdField_k_of_type_Int <= 0) || (i1 <= this.jdField_k_of_type_Int)) {
        break label100;
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_k_of_type_Int - i1));
    }
    for (;;)
    {
      if ((Build.DISPLAY.equals("moonlight-diyroms' ROMS")) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null)) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      }
      return;
      i1 = paramEditable.length();
      break;
      label100:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492908));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (this.jdField_a_of_type_AndroidNetUri == null);
      paramIntent = com.tencent.mobileqq.utils.ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
      com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
      a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask.jdField_a_of_type_Boolean = true;
      }
    } while (!this.e);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = new TroopBarPublishUtils.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_j_of_type_JavaLangString);
    ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask, 8, null, true);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
    {
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString)) {}
      for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_k_of_type_JavaLangString;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString)
      {
        a(1, new String[] { paramIntent });
        return;
      }
    }
    a(0, new String[0]);
    return;
    paramIntent = (AudioInfo)paramIntent.getSerializableExtra("audio_info");
    a(2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity$AudioUploadTask = new AbsPublishActivity.AudioUploadTask(this, this, this.jdField_a_of_type_AndroidOsHandler, "http://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity$AudioUploadTask, 5, null, true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131364762, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.jdField_i_of_type_Int = paramBundle.optInt("groupType", 1);
        this.jdField_k_of_type_JavaLangString = paramBundle.optString("barTitle");
        this.jdField_l_of_type_JavaLangString = paramBundle.optString("selectTitle");
        this.jdField_m_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_n_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.jdField_j_of_type_Int = paramBundle.optInt("minContentLength", 10);
        this.jdField_k_of_type_Int = paramBundle.optInt("maxContentLength", 700);
        this.jdField_o_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_o_of_type_JavaLangString);
        this.x = getString(2131364781, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
        this.jdField_s_of_type_JavaLangString = paramBundle.optString("content", null);
        this.jdField_j_of_type_Boolean = paramBundle.optBoolean("photoOrContent");
        this.f = paramBundle.optBoolean("needDestination", true);
        this.g = paramBundle.optBoolean("needTitle", true);
        this.jdField_h_of_type_Boolean = paramBundle.optBoolean("needLocation", true);
        this.jdField_i_of_type_Boolean = paramBundle.optBoolean("needFace", true);
        this.jdField_k_of_type_Boolean = paramBundle.optBoolean("isReply", true);
        this.e = paramBundle.optBoolean("isPreUpload", true);
        this.jdField_a_of_type_JavaLangString = paramBundle.optString("from", "");
        this.jdField_b_of_type_JavaLangString = paramBundle.optString("topicFrom", String.valueOf(2));
        this.w = paramBundle.optString("groupUin", "");
        this.jdField_l_of_type_Int = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_m_of_type_Int = i1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label604;
          }
          bool = true;
          this.jdField_l_of_type_Boolean = bool;
          if (!"barindex".equals(this.jdField_a_of_type_JavaLangString)) {
            break label609;
          }
          i1 = 1;
          this.jdField_n_of_type_Int = paramBundle.optInt("optionType", i1);
          this.q = paramBundle.optString("cacheKey");
          this.jdField_o_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.jdField_h_of_type_Int = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_p_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.r = paramBundle.optString("forbiddenMsg", getString(2131364957));
          a(paramBundle);
          if (this.jdField_o_of_type_Int == 0) {
            a();
          }
          a(paramBundle.optString("image_list", null));
          a();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this, 1, getString(2131364762, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      int i1 = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label604:
      boolean bool = false;
      continue;
      label609:
      i1 = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (!this.d) {
        h();
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
      }
      if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
        this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
        SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsPublishActivity", 4, "unregisterReceiver(mItemDeleteReceiver) exception");
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask.jdField_a_of_type_Boolean = true;
        }
        if (this.e) {
          break label54;
        }
      }
    }
    return;
    label54:
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = new TroopBarPublishUtils.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_j_of_type_JavaLangString);
    ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask, 8, null, true);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    }
  }
  
  protected void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("audio_max_length", this.jdField_m_of_type_Int);
    if (this.v != null)
    {
      localIntent.putExtra("from", "publish");
      localIntent.putExtra("bid", this.v);
      localIntent.putExtra("fromflag", this.jdField_c_of_type_JavaLangString);
    }
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AudioRecordActivity.class);
    startActivityForResult(localIntent, 1003);
  }
  
  public void f()
  {
    Object localObject = a(1.0F, 0.0F);
    Animation localAnimation = a(0.0F, 1.0F);
    ((Animation)localObject).setAnimationListener(new vct(this, localAnimation));
    localAnimation.setAnimationListener(new vcw(this));
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    }
    for (int i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();; i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getMeasuredHeight())
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getMeasuredHeight();
      localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getLayoutParams()).bottomMargin + i2 - i1);
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getVisibility() != 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.startAnimation((Animation)localObject);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    overridePendingTransition(0, 2130968584);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void h()
  {
    int i2 = 0;
    if (this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "publish save key = " + this.q);
      }
      if (android.text.TextUtils.isEmpty(this.q)) {
        continue;
      }
      TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
      Object localObject1;
      int i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = new ArrayList();
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject1).add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          i1 += 1;
        }
        localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          localObject1 = new ArrayList();
          i1 = i2;
          while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            ((ArrayList)localObject1).add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
            i1 += 1;
          }
          localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
      localPublishDataCacheEntity.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      localPublishDataCacheEntity.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      localPublishDataCacheEntity.jdField_a_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localPublishDataCacheEntity.jdField_c_of_type_Int = this.jdField_j_of_type_Int;
      localPublishDataCacheEntity.jdField_d_of_type_Int = this.jdField_k_of_type_Int;
      localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.jdField_o_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
          localPublishDataCacheEntity.jdField_c_of_type_JavaLangString = ((String)localObject1);
          localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetEditText.getEditableText().toString();
          TroopBarUtils.a.put(this.q, localPublishDataCacheEntity);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopBar", 2, "publish save key = " + this.q + ", data = " + localPublishDataCacheEntity);
          return;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException));
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public void i()
  {
    label90:
    label130:
    label177:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar != null)
    {
      if (this.jdField_n_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      }
    }
    else
    {
      if ((this.jdField_n_of_type_Int & 0x1) != 1) {
        break label430;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setNumColumns(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setOnItemClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter = new TroopBarImagePreviewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter);
      if (!this.jdField_i_of_type_Boolean) {
        break label442;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetEditText, this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (!this.jdField_h_of_type_Boolean) {
        break label454;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_c_of_type_Int), new vdf(this) });
      EditText localEditText;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)
      {
        localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        if (android.text.TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
          break label466;
        }
        str = this.jdField_i_of_type_JavaLangString;
        label259:
        localEditText.setText(str);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_o_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getText().length() <= 0)
      {
        localEditText = this.jdField_b_of_type_AndroidWidgetEditText;
        if (android.text.TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
          break label471;
        }
        str = this.jdField_p_of_type_JavaLangString;
        label310:
        localEditText.setText(str);
      }
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null))
      {
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString)) {
          break label476;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_k_of_type_JavaLangString;
        label350:
        a(1, new String[] { str });
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label487;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaUtilArrayList);
      a(4);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.jdField_n_of_type_Int);
      break;
      label430:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label90;
      label442:
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label130;
      label454:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label177;
      label466:
      str = null;
      break label259;
      label471:
      str = null;
      break label310;
      label476:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString;
      break label350;
      label487:
      a(0);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public abstract void j();
  
  protected void k()
  {
    switch (this.jdField_o_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_n_of_type_Int & 0x2) != 2);
        e();
        return;
      } while ((this.jdField_n_of_type_Int & 0x1) != 1);
      this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      return;
    } while ((this.jdField_n_of_type_Int & 0x1) != 1);
    TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Int);
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      g();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    return super.onBackEvent();
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
        return;
        paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
        paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        startActivityForResult(paramView, 1002);
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
        if ((this.jdField_i_of_type_Int == 2) && ((this instanceof TroopBarPublishActivity))) {
          TroopBarUtils.a("Grp_talk", "pub_talk", "Clk_pub", this.w, this.jdField_b_of_type_JavaLangString, "", "");
        }
        j();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vcx(this), 200L);
      return;
    }
    InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vcy(this), 200L);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetEditText)
    {
      if (!paramBoolean) {
        break label47;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vdb(this), 200L);
      }
    }
    return;
    label47:
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
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
          do
          {
            return false;
          } while ((1 != paramMotionEvent.getAction()) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0));
          g();
          return false;
        } while (paramMotionEvent.getAction() != 2);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus())) {
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
        }
      } while (this.jdField_b_of_type_AndroidWidgetEditText == null);
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    return false;
  }
  
  public void setting() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\AbsPublishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
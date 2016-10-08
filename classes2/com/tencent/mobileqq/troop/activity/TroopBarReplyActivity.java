package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.PlusPanel.PluginData;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataCacheEntity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vie;
import vif;
import vii;
import vij;
import vik;
import vil;
import vim;
import vin;
import vio;
import vip;
import viq;
import vir;
import vis;
import vit;

public class TroopBarReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  private static final int A = 5;
  private static final int B = 7;
  public static final int a = 101000;
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  protected static final int b = 3;
  public static final String b = "bid";
  private static final int[] jdField_b_of_type_ArrayOfInt;
  protected static final int c = 700;
  public static final String c = "pid";
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  private static final int p = 0;
  private static final int q = 2;
  private static final int r = 3;
  private static final int s = 4;
  private static final int t = 5;
  private static final int v = 0;
  private static final int w = 1;
  private static final int x = 2;
  private static final int y = 3;
  private static final int z = 4;
  protected long a;
  protected BroadcastReceiver a;
  protected Drawable a;
  public Uri a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vii(this);
  protected View a;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  protected FrameLayout a;
  protected GridView a;
  public ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  private PlusPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter;
  public CommonRecordSoundPanel a;
  protected SystemEmoticonPanel a;
  protected TroopBarPublishUtils.PreUploadTask a;
  public TroopBarReplyActivity.AudioUploadTask a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemContainer a;
  protected InputMethodRelativeLayout a;
  public QQProgressDialog a;
  protected ActionSheet a;
  protected Boolean a;
  protected CharSequence a;
  public ArrayList a;
  public boolean a;
  private final int[][] jdField_a_of_type_Array2dOfInt = new int[5][];
  Handler jdField_b_of_type_AndroidOsHandler = new vit(this);
  public ImageButton b;
  private AudioInfo jdField_b_of_type_ComTencentMobileqqTroopDataAudioInfo;
  protected QQProgressDialog b;
  protected ArrayList b;
  public boolean b;
  protected boolean c;
  protected int d;
  protected String d;
  protected boolean d;
  protected int e;
  protected String e;
  protected boolean e;
  protected int f;
  protected String f;
  protected boolean f;
  protected int g;
  protected String g;
  protected boolean g;
  protected int h;
  protected String h;
  protected boolean h;
  protected int i;
  protected String i;
  protected boolean i;
  protected int j;
  protected String j;
  protected boolean j;
  protected int k;
  protected String k;
  public boolean k;
  protected int l;
  protected String l;
  private boolean l;
  protected int m;
  protected String m;
  protected int n;
  public String n;
  int o;
  public String o;
  public String p;
  protected String q = "";
  private int u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopBarReplyActivity.class.getName();
    jdField_a_of_type_ArrayOfInt = new int[] { 2131362138, 2130838165, 2131364939 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131368091, 2130838149, 2131364940 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131364945, 2130838166, 2131364941 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131369106, 2130838159, 2131364942 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131364948, 2130838147, 2131364943 };
  }
  
  public TroopBarReplyActivity()
  {
    this.jdField_f_of_type_JavaLangString = "http://upload.buluo.qq.com/cgi-bin/bar/upload/image";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 9;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vir(this);
    this.jdField_a_of_type_AndroidOsHandler = new vis(this);
    this.jdField_o_of_type_Int = 0;
  }
  
  private void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getResources();
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    if ((this.jdField_i_of_type_Int & 0x1) == 1)
    {
      this.jdField_a_of_type_Array2dOfInt[0] = jdField_a_of_type_ArrayOfInt;
      this.jdField_a_of_type_Array2dOfInt[1] = jdField_b_of_type_ArrayOfInt;
    }
    for (int i2 = 2;; i2 = 0)
    {
      int i1 = i2;
      if ((this.jdField_i_of_type_Int & 0x2) == 2)
      {
        this.jdField_a_of_type_Array2dOfInt[i2] = jdField_c_of_type_ArrayOfInt;
        i1 = i2 + 1;
      }
      i2 = i1;
      if ((this.jdField_i_of_type_Int & 0x8) == 8)
      {
        this.jdField_a_of_type_Array2dOfInt[i1] = jdField_e_of_type_ArrayOfInt;
        i2 = i1 + 1;
      }
      i1 = i2;
      if ((this.jdField_i_of_type_Int & 0x4) == 4)
      {
        this.jdField_a_of_type_Array2dOfInt[i2] = jdField_d_of_type_ArrayOfInt;
        i1 = i2 + 1;
      }
      if (i1 > 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        i1 = 0;
        if (i1 < this.jdField_a_of_type_Array2dOfInt.length)
        {
          int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i1];
          if (arrayOfInt == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfInt.length == jdField_a_of_type_ArrayOfInt.length)
            {
              PlusPanel.PluginData localPluginData = new PlusPanel.PluginData();
              localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(arrayOfInt[1]);
              localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
              localPluginData.jdField_a_of_type_JavaLangString = paramContext.getString(arrayOfInt[0]);
              localPluginData.jdField_b_of_type_JavaLangString = paramContext.getString(arrayOfInt[2]);
              localPluginData.jdField_a_of_type_Boolean = false;
              localArrayList.add(localPluginData);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation1.setDuration(0L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.4F, 1.0F);
    localAlphaAnimation2.setDuration(0L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    findViewById(2131299736).setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation2);
      findViewById(2131299736).setBackgroundColor(0);
      findViewById(2131299736).setBackgroundResource(2130843567);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation1);
    findViewById(2131299736).setBackgroundColor(1291845632);
    this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation1);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837544);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    case 2: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    case 3: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
  }
  
  public void a()
  {
    Object localObject2;
    if ((this.u == 101000) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean))
    {
      localObject1 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).replace("\n", " ");
      this.jdField_b_of_type_Boolean = true;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("result", "\"" + (String)localObject1 + "\"");
      setResult(-1, (Intent)localObject2);
      finish();
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_l_of_type_Int == 2) && (this.jdField_k_of_type_Boolean)) {
      TroopBarUtils.a("Grp_talk", "pub_reco", "Clk_reco", this.jdField_m_of_type_JavaLangString, "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask.a() != 0))
    {
      a(true);
      return;
    }
    Object localObject1 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ((String)localObject1).trim();
    }
    for (int i1 = ((String)localObject1).length();; i1 = 0)
    {
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (i1 == 0)
        {
          QQToast.a(this, 2131364783, 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.p, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 < this.jdField_e_of_type_Int)
        {
          QQToast.a(this, getString(2131364784, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.p, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 > this.jdField_f_of_type_Int)
        {
          QQToast.a(this, getString(2131364785, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.p, "4", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      if (!a(this.jdField_i_of_type_Int, this.jdField_g_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      if (!HttpUtil.a(this))
      {
        QQToast.a(this, 2131367339, 0).b(getTitleBarHeight());
        if (this.jdField_k_of_type_Boolean) {
          TroopBarUtils.a("reply_page", "fail", this.p, "7", "", "");
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      a(true);
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label614;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject2) == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(this, 1, this.jdField_a_of_type_AndroidOsHandler);
          if (!this.jdField_k_of_type_Boolean) {
            break;
          }
          TroopBarUtils.a("reply_page", "fail", this.p, "10", "", "");
          return;
        }
        i1 += 1;
      }
      label614:
      boolean bool;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
      {
        bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        localObject1 = TroopBarPublishUtils.a((String)localObject1, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
        localObject2 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          ((JSONObject)localObject2).put("pid", this.jdField_d_of_type_JavaLangString);
          ((JSONObject)localObject2).put("bid", Long.parseLong(this.p));
          ((JSONObject)localObject2).put("comment", localObject1);
          if (bool) {
            ((JSONObject)localObject2).put("is_forward", 1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
          {
            ((JSONObject)localObject2).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_h_of_type_JavaLangString);
            ((JSONObject)localObject2).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.b));
            ((JSONObject)localObject2).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
          }
          ((JSONObject)localObject2).put("extparam", this.jdField_e_of_type_JavaLangString);
          ((JSONObject)localObject2).put("version", "6.5.5.2880");
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
          if (bool) {
            TroopBarUtils.a(this.jdField_n_of_type_JavaLangString, "reply_page_new", "share_interest", this.p, "", "", "");
          }
          if (this.jdField_l_of_type_Int != 1) {
            break label947;
          }
          localObject1 = "MQUpdateSvc_com_qq_xiaoqu.web.comment";
          localNewIntent.putExtra("cmd", (String)localObject1);
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).type.set(0);
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set(((JSONObject)localObject2).toString());
          localNewIntent.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          localNewIntent.setObserver(new vie(this));
          this.app.startServlet(localNewIntent);
          return;
        }
        catch (Exception localException)
        {
          QQToast.a(this, 1, 2131364761, 0).b(getTitleBarHeight());
          a(false);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        bool = false;
        break;
        label947:
        String str = "MQUpdateSvc_com_qq_buluo.web.sbar_comment";
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131364950);
    Object localObject = new vif(this, paramInt);
    localQQCustomDialog.setNegativeButton(getString(2131364952), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 2: 
      str = getString(2131364944, new Object[] { getString(2131364945) });
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setPositiveButton(getString(2131364954), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.show();
      return;
      str = getString(2131364944, new Object[] { getString(2131364946) });
      localQQCustomDialog.setPositiveButton(getString(2131364953), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364944, new Object[] { getString(2131364947) });
      localQQCustomDialog.setPositiveButton(getString(2131364955), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364944, new Object[] { getString(2131364947) });
      localQQCustomDialog.setPositiveButton(getString(2131364955), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364809, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).a(bool);
        break;
        bool = false;
      }
      str = getString(2131364949);
      localQQCustomDialog.setPositiveButton(getString(2131364951), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364944, new Object[] { getString(2131364948) });
      localQQCustomDialog.setPositiveButton(getString(2131364956), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void a(int paramInt, MediaInfo paramMediaInfo)
  {
    if (paramMediaInfo == null) {
      return;
    }
    if ((paramMediaInfo instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
    d(0);
    InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    boolean bool = false;
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      label38:
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      if (!bool) {
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131366734);
      break label38;
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
      paramVarArgs = str;
      break label38;
      paramVarArgs = getString(2131366732);
      break label38;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        bool = true;
        break label38;
      }
      a(0, new String[0]);
      return;
      paramVarArgs = getString(2131364799);
    }
  }
  
  protected void a(View paramView, String paramString, int paramInt)
  {
    View localView;
    URLImageView localURLImageView;
    Object localObject2;
    if ((paramView != null) && (!android.text.TextUtils.isEmpty(paramString)))
    {
      localView = paramView.findViewById(2131299768);
      localURLImageView = (URLImageView)paramView.findViewById(2131299766);
      localURLImageView.setAdjustViewBounds(false);
      localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = 100;
      ((RelativeLayout.LayoutParams)localObject1).height = 100;
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localObject1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 2.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(this, 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        if (!((File)localObject2).exists()) {
          break label261;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label261:
        for (;;) {}
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      ((Drawable)localObject2).setBounds(0, 0, 100, 100);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      localView.setTag(paramString);
      localView.setOnClickListener(this);
      localURLImageView.setTag(paramString);
      localURLImageView.setOnClickListener(this);
      paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramView.rightMargin = DisplayUtil.a(this, 2.0F);
      paramView.width = (DisplayUtil.a(this, 10.0F) + 100);
      paramView.height = (DisplayUtil.a(this, 17.0F) + 100);
      return;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  protected void a(BaseActivity paramBaseActivity, int paramInt, Handler paramHandler)
  {
    paramBaseActivity.runOnUiThread(new vij(this));
    if (((TicketManager)paramBaseActivity.app.getManager(2)).getSkey(paramBaseActivity.app.a()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.a(new TroopBarPublishUtils.PicUploadThread(paramBaseActivity, paramHandler, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_JavaLangString), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    SosoInterface.a(new vil(this, 0, true, true, this.jdField_o_of_type_Int, false, false, "AbsPublish", paramBaseActivity, paramCallback));
    a(2, new String[0]);
  }
  
  protected void a(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    paramString = ActionSheet.a(paramBaseActivity);
    paramString.a(2131370357, 1);
    paramString.a(2131370359, 1);
    paramString.d(2131367262);
    paramString.a(new vik(this, paramBaseActivity, paramString));
    paramString.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramString;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842111);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131366954);
    com.tencent.biz.common.util.ImageUtil.a((String)null, 0);
    if (this.jdField_j_of_type_Int != 0) {
      j();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("key_photo_delete_action");
    localIntentFilter.addAction("key_audio_delete_action");
    localIntentFilter.addAction("key_photo_add_action");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.p = paramJSONObject.optString("bid", "");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("pid", "");
    this.jdField_k_of_type_JavaLangString = (this.app.a() + "-" + this.p + "-" + this.jdField_d_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("extparam");
    this.jdField_n_of_type_JavaLangString = "Grp_tribe";
    this.jdField_o_of_type_JavaLangString = "reply_page";
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
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131364810);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      d(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "repky restore key = " + this.jdField_k_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
      return false;
    }
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.b.get(this.jdField_k_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.jdField_k_of_type_JavaLangString + ", replyData = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.b.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_e_of_type_Int = localPublishDataCacheEntity.c;
    this.jdField_f_of_type_Int = localPublishDataCacheEntity.jdField_d_of_type_Int;
    this.jdField_i_of_type_JavaLangString = localPublishDataCacheEntity.jdField_b_of_type_JavaLangString;
    this.jdField_j_of_type_JavaLangString = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    return true;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = null;
    if ((this.jdField_k_of_type_Int & paramInt) == paramInt)
    {
      switch (paramInt)
      {
      }
      while (localObject != null)
      {
        QQToast.a(this, (CharSequence)localObject, 0).b(getTitleBarHeight());
        return true;
        localObject = getString(2131364959, new Object[] { this.jdField_l_of_type_JavaLangString });
        continue;
        localObject = getString(2131364958, new Object[] { this.jdField_l_of_type_JavaLangString });
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
      Object localObject2 = null;
      Object localObject1;
      if (((paramInt & 0x1) == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        localObject1 = getString(2131364962, new Object[] { getString(2131364947) });
      }
      while (localObject1 != null)
      {
        QQToast.a(this, (CharSequence)localObject1, 0).b(getTitleBarHeight());
        return false;
        localObject1 = localObject2;
        if ((paramInt & 0x2) == 2)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) {
            localObject1 = getString(2131364962, new Object[] { getString(2131364945) });
          }
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
    int i2 = 0;
    this.jdField_m_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    this.jdField_n_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    int i1;
    if (str == null)
    {
      i1 = 0;
      if ((this.jdField_f_of_type_Int <= 0) || (i1 <= this.jdField_f_of_type_Int)) {
        break label155;
      }
      i1 -= this.jdField_f_of_type_Int;
      paramEditable.delete(this.jdField_m_of_type_Int - i1, this.jdField_n_of_type_Int);
      this.jdField_m_of_type_Int -= i1;
      this.jdField_n_of_type_Int -= i1;
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label169;
      }
      QQToast.a(this, this.q, 0).b(getTitleBarHeight());
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    label155:
    label169:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1 + this.jdField_m_of_type_Int);
      return;
      i1 = str.length();
      break;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i1 = i2;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.p);
    localBundle.putString("pid", this.jdField_d_of_type_JavaLangString);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.app.a());
    localBundle.putString("content", TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).trim());
    String str;
    if (paramInt == 3) {
      str = "video";
    }
    for (;;)
    {
      localBundle.putString("clicktype", str);
      try
      {
        localBundle.putString("floor", new JSONObject(this.jdField_e_of_type_JavaLangString).getString("floor"));
        TroopBarPublishUtils.a(this, 2, paramInt, localBundle);
        return;
        str = "music";
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
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
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = new TroopBarPublishUtils.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList, "http://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask, 8, null, true);
    } while (!this.jdField_k_of_type_Boolean);
    TroopBarUtils.a("reply_page", "choose_place", this.p, "2", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask = new TroopBarReplyActivity.AudioUploadTask(this, this, this.jdField_a_of_type_AndroidOsHandler, "http://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask, 5, null, true);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131364762, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    this.u = paramBundle.getInt("requestCode", 0);
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.jdField_g_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_h_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.jdField_e_of_type_Int = paramBundle.optInt("minContentLength", 3);
        this.jdField_f_of_type_Int = paramBundle.optInt("maxContentLength", 700);
        this.jdField_i_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_i_of_type_JavaLangString);
        this.jdField_f_of_type_Boolean = paramBundle.optBoolean("photoOrContent");
        this.jdField_d_of_type_Boolean = paramBundle.optBoolean("needLocation", true);
        this.jdField_e_of_type_Boolean = paramBundle.optBoolean("needFace", true);
        this.jdField_l_of_type_Boolean = paramBundle.optBoolean("needForward", false);
        this.jdField_c_of_type_Boolean = paramBundle.optBoolean("isPreUpload", true);
        this.jdField_g_of_type_Int = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_h_of_type_Int = i1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label567;
          }
          bool = true;
          this.jdField_g_of_type_Boolean = bool;
          this.jdField_i_of_type_Int = paramBundle.optInt("optionType", 1);
          this.jdField_k_of_type_JavaLangString = paramBundle.optString("cacheKey");
          this.jdField_j_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.jdField_d_of_type_Int = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_k_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.jdField_l_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131364957));
          this.q = getString(2131364781, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
          this.jdField_l_of_type_Int = paramBundle.optInt("groupType", 1);
          this.jdField_m_of_type_JavaLangString = paramBundle.optString("groupUin", "");
          this.jdField_h_of_type_Boolean = paramBundle.optBoolean("need_plus_btn", true);
          this.jdField_i_of_type_Boolean = paramBundle.optBoolean("content_to_web", false);
          this.jdField_j_of_type_Boolean = paramBundle.optBoolean("sendToWeb", false);
          this.jdField_k_of_type_Boolean = paramBundle.optBoolean("needTribeReport", true);
          if (this.jdField_j_of_type_Boolean) {
            this.jdField_k_of_type_Boolean = false;
          }
          a(paramBundle);
          if (this.jdField_j_of_type_Int == 0) {
            a();
          }
          e();
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
      label567:
      boolean bool = false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.c();
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
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask = new TroopBarPublishUtils.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList, "http://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PreUploadTask, 8, null, true);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
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
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_l_of_type_Boolean)
        {
          setContentView(2130903703);
          this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131299773));
          Object localObject = findViewById(2131297082);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131299437));
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299761));
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131298675));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299747));
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299739));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298663));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131299771));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131299772);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299735));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
          findViewById(2131299736).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131299769));
          this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter = new PlusPanelAdapter();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter);
          a(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299733));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2130903645, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_b_of_type_AndroidOsHandler, 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.jdField_h_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
          this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
          if ((android.text.TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (this.jdField_e_of_type_Int <= 0) || (this.jdField_f_of_type_Int <= 0))
          {
            this.jdField_e_of_type_Int = 3;
            this.jdField_f_of_type_Int = 700;
            this.jdField_i_of_type_JavaLangString = getString(2131364769, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_f_of_type_Int) });
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_i_of_type_JavaLangString);
          if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)
          {
            EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
            if (!android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
            {
              localObject = this.jdField_j_of_type_JavaLangString;
              localEditText.setText((CharSequence)localObject);
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
              break label791;
            }
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString)) {
              break label780;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_k_of_type_JavaLangString;
            a(1, new String[] { localObject });
            a(this, this);
            localObject = this.jdField_a_of_type_AndroidWidgetImageView;
            if (!this.jdField_d_of_type_Boolean) {
              break label803;
            }
            i1 = 0;
            ((ImageView)localObject).setVisibility(i1);
            localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label809;
            }
            i1 = i2;
            ((ImageButton)localObject).setVisibility(i1);
            if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
              break label815;
            }
            a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaUtilArrayList);
            if (!this.jdField_h_of_type_Boolean) {
              this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
            }
            localObject = new StringBuffer();
            if ((this.jdField_i_of_type_Int & 0x1) == 1) {
              ((StringBuffer)localObject).append("0");
            }
            if ((this.jdField_i_of_type_Int & 0x2) == 2) {
              ((StringBuffer)localObject).append("1");
            }
            if (this.jdField_k_of_type_Boolean)
            {
              TroopBarUtils.a("reply_page", "choose_place", this.p, "0", ((StringBuffer)localObject).toString(), "");
              TroopBarUtils.a("reply_page", "exp", String.valueOf(this.p), "", "", "");
            }
          }
        }
        else
        {
          setContentView(2130903702);
          continue;
        }
        str = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        finish();
        return;
      }
      continue;
      label780:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_j_of_type_JavaLangString;
      continue;
      label791:
      a(0, new String[0]);
      continue;
      label803:
      int i1 = 8;
      continue;
      label809:
      i1 = 8;
      continue;
      label815:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vim(this), 200L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vin(this), 500L);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    overridePendingTransition(0, 2130968584);
    if (((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      if (this.jdField_k_of_type_Boolean) {
        TroopBarUtils.a("reply_page", "un", this.p, str, "", "");
      }
      return;
    }
  }
  
  protected void g()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.jdField_k_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
      ArrayList localArrayList;
      int i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localArrayList = new ArrayList();
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          i1 += 1;
        }
        localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          localArrayList = new ArrayList();
          i1 = i2;
          while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
            i1 += 1;
          }
          localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        }
      }
      localPublishDataCacheEntity.c = this.jdField_e_of_type_Int;
      localPublishDataCacheEntity.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
      localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        TroopBarUtils.b.put(this.jdField_k_of_type_JavaLangString, localPublishDataCacheEntity);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBar", 2, "reply save key = " + this.jdField_k_of_type_JavaLangString + ", data = " + localPublishDataCacheEntity);
        return;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException));
          }
        }
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      a(4);
      return;
    }
    TroopBarPublishUtils.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      a(4);
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    switch (this.jdField_j_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_i_of_type_Int & 0x2) != 2);
        f();
        return;
      } while ((this.jdField_i_of_type_Int & 0x1) != 1);
      i();
      return;
    } while ((this.jdField_i_of_type_Int & 0x1) != 1);
    h();
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
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
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.w("IphoneTitleBarActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
              finish();
              return;
              paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
              paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
              paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
              startActivityForResult(paramView, 1002);
            } while (!this.jdField_k_of_type_Boolean);
            String str = this.p;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
            for (paramView = "0";; paramView = "1")
            {
              TroopBarUtils.a("reply_page", "Clk_place", str, paramView, "", "");
              return;
            }
          } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
            InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
            this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
            return;
          }
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vio(this), 200L);
          return;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
          a();
          return;
        } while (!this.jdField_k_of_type_Boolean);
        TroopBarUtils.a("reply_page", "del_photo", this.p, "", "", "");
        return;
      } while (!this.jdField_k_of_type_Boolean);
      TroopBarUtils.a("pub_page", "choose_photo", this.p, "", "", "");
      return;
      if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)
      {
        d(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vip(this), 200L);
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new viq(this), 200L);
    } while (!this.jdField_k_of_type_Boolean);
    TroopBarUtils.a(this.jdField_n_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString, "Clk_add", this.p, "", "", "");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setting() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarReplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
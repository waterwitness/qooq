package com.tencent.biz.lebasearch;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.biz.widgets.ActiveSearchTipsContainer;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.VipComicReportUtils;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import hjb;
import hjd;
import hjf;
import hjg;
import hjh;
import hji;
import hjj;
import hjk;
import hjl;
import hjm;
import hjn;
import hjz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchActivity
  extends BaseActivity
  implements View.OnClickListener, SearchHistoryAdapter.OnItemClickObserver, SearchResultAdapter.OnResultItemClickedListener
{
  public static final int a = 1024;
  public static final String a = "DynamicSearch";
  public static final int b = 2049;
  public static final String b = "1002";
  public static final int c = 4096;
  public static final String c = "0X8004AB2";
  public static final int d = 1;
  public static final String d = "0X8004AB4";
  public static final int e = 2;
  public static final String e = "0X8004B21";
  public static final int f = 3;
  public static final String f = "0X8004B22";
  public static final int g = 4;
  public static final String g = "0X8004B23";
  public static final int h = 5;
  public static final String h = "0X8004B24";
  public static final String i = "0X8004D70";
  public static final int j = 0;
  public static final String j = "0X8004AB1";
  public static final int k = 1;
  public static final String k = "0X8004AB3";
  public static final int l = 2;
  public static final String l = "0X800513C";
  public static final int m = 3;
  public static final String m = "0X800516F";
  public static final int n = 20;
  public static final String n = "0X800516E";
  public static final int o = 1;
  public static final String o = "0X80053CF";
  public static final int p = 2;
  public static final String p = "0X80059E0";
  public static final String q = "0X8005F2B";
  public static final String r = "request_keyword";
  public static final String s = "request_home_hot_word";
  public static final String t = "key_docid";
  public static final String u = "key_posid";
  public static final String v = "key_clicktype";
  public static final String w = "key_keyword";
  public static final String x = "_";
  public long a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  View jdField_a_of_type_AndroidViewView;
  public InputMethodManager a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver;
  SearchProtocol.WordItem jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem;
  public SearchResultAdapter a;
  public ViewPluginManager a;
  ActiveSearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener;
  ActiveSearchTipsContainer jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer;
  public XListView a;
  private hjn jdField_a_of_type_Hjn;
  public List a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public XListView b;
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  XListView jdField_c_of_type_ComTencentWidgetXListView;
  List jdField_c_of_type_JavaUtilList;
  View jdField_d_of_type_AndroidViewView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  public int i;
  private int q;
  private int r;
  public String y;
  
  public SearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new hjb(this);
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener = new hjf(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new hji(this);
    this.jdField_a_of_type_Hjn = new hjn(this, null);
    this.q = -1;
    this.r = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new hjj(this);
    this.jdField_a_of_type_AndroidOsHandler = new hjk(this);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, SearchProtocol.WordItem paramWordItem)
  {
    paramView = new Intent(paramBaseActivity, SearchActivity.class);
    paramView.putExtra("request_home_hot_word", paramWordItem);
    paramBaseActivity.startActivityForResult(paramView, 1688001);
    paramBaseActivity.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    int i1 = 0;
    JSONObject localJSONObject1;
    if (i1 < paramJSONArray.length())
    {
      localJSONObject1 = paramJSONArray.optJSONObject(i1);
      if (localJSONObject1.has("result_type")) {}
    }
    else
    {
      label28:
      return;
    }
    if (localJSONObject1.optInt("result_type") == 2049) {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X80067B0", "0X80067B0", 0, 0, "", "", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), "");
    }
    for (;;)
    {
      i1 += 1;
      break;
      if (localJSONObject1.optInt("result_type") == 4096)
      {
        if (!localJSONObject1.has("result_extension")) {
          break label28;
        }
        JSONArray localJSONArray = localJSONObject1.optJSONArray("result_extension");
        if (localJSONArray == null) {
          break label28;
        }
        int i3 = localJSONArray.length();
        StringBuffer localStringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < i3)
        {
          JSONObject localJSONObject2 = localJSONArray.optJSONObject(i2);
          String str = localJSONObject2.optString("result_id");
          localStringBuffer.append(str + ",");
          VipComicReportUtils.a(this.app, "3024", "1", "30016", "", new String[] { str, localJSONObject2.optString("icon") });
          i2 += 1;
        }
        if (localJSONObject1.has("more_url")) {
          VipComicReportUtils.a(this.app, "3024", "1", "30015", "3", new String[] { localStringBuffer.toString(), localJSONObject1.optString("keyword") });
        } else {
          VipComicReportUtils.a(this.app, "3024", "1", "30015", "num", new String[] { localStringBuffer.toString(), localJSONObject1.optString("keyword") });
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((SearchProtocol.WordItem)localIterator.next());
      }
      this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.a(localArrayList);
    } while (!paramBoolean);
    c(1);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Hjn);
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word);
    localSpannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#b4e088")), 0, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word.length(), 33);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Hjn);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word.length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Hjn);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131364997);
  }
  
  private void e()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.y = null;
      this.i = 2;
      ReportController.b(this.app, "CliOper", "", "", "0X8004B22", "0X8004B22", 0, 0, null, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "4", null, null, null);
      d(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      c(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      a(true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem == null) {}
    for (String str = null;; str = this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.id)
    {
      this.y = str;
      this.i = 1;
      ReportController.b(this.app, "CliOper", "", "", "0X8004AB2", "0X8004AB2", 0, 0, this.y, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "0", null, null, null);
      break;
    }
  }
  
  public Intent a(hjz paramhjz)
  {
    Intent localIntent = new Intent(this, LebaSearchMoreInfoActivity.class);
    localIntent.putExtra("url", (String)paramhjz.jdField_a_of_type_JavaLangObject);
    localIntent.putExtra("type", paramhjz.f);
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    LebaViewItem localLebaViewItem;
    while (localIterator.hasNext())
    {
      localLebaViewItem = (LebaViewItem)localIterator.next();
      if ((localLebaViewItem.a != null) && (localLebaViewItem.a.lebaSearchResultType == paramhjz.f)) {
        localIntent.putExtra("id", localLebaViewItem.a.uiResId);
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if ((paramhjz.jdField_a_of_type_JavaLangString != null) && (i1 == 0))
      {
        localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localLebaViewItem = (LebaViewItem)localIterator.next();
          if ((localLebaViewItem.a != null) && (paramhjz.jdField_a_of_type_JavaLangString.equals(localLebaViewItem.a.strResName))) {
            localIntent.putExtra("id", localLebaViewItem.a.uiResId);
          }
        }
      }
      return localIntent;
    }
  }
  
  protected void a()
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299491));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298732));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131368228);
    this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-1431918938);
    this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300880));
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetEditText, getString(2131362090));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(this, 22.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(this, 22.0F));
    this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300876));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364998));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131299496));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297765));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297766));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297767));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299492));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(new hjg(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298454));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131299495));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new hjh(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131299493));
    this.jdField_c_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297768));
    this.jdField_c_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903627, null);
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer = ((ActiveSearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131298186));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298693);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298691);
    this.jdField_c_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131299498);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      continue;
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131365003);
      continue;
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131365004);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    b();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Hjn);
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
  }
  
  public void a(SearchHistoryEntity paramSearchHistoryEntity)
  {
    if (paramSearchHistoryEntity == null) {
      return;
    }
    this.i = 4;
    a(paramSearchHistoryEntity.keyWord);
    d(paramSearchHistoryEntity.keyWord);
    c(paramSearchHistoryEntity.keyWord);
    a(true);
    ReportController.b(this.app, "CliOper", "", "", "0X800513C", "0X800513C", 0, 0, null, null, null, null);
    ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "2", null, null, null);
  }
  
  public void a(hjz paramhjz)
  {
    if (paramhjz == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    label163:
    Object localObject3;
    if ((paramhjz.f == 1024) && (paramhjz.e == 2))
    {
      localObject1 = ((JSONObject)paramhjz.jdField_a_of_type_JavaLangObject).optString("jump_url");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = QZoneHelper.UserInfo.a();
        ((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString = this.app.a();
        ((QZoneHelper.UserInfo)localObject2).b = this.app.b();
        QZoneHelper.b(this, (QZoneHelper.UserInfo)localObject2, ((String)localObject1).trim(), "SearchActivity", -1);
        localObject2 = URLUtil.a((String)localObject1);
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("a");
        }
        if (localObject1 != null)
        {
          if (!((String)localObject1).equals("4")) {
            break label502;
          }
          localObject1 = "1";
          localObject2 = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject2).c = "464";
          ((QZoneClickReport.ReportInfo)localObject2).d = "2";
          ((QZoneClickReport.ReportInfo)localObject2).e = ((String)localObject1);
          QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
        }
      }
      if ((paramhjz.b != null) && ((paramhjz.b instanceof Map)))
      {
        Object localObject4 = (Map)paramhjz.b;
        if (((Map)localObject4).size() > 0)
        {
          localObject1 = (String)((Map)localObject4).get("key_docid");
          localObject2 = (String)((Map)localObject4).get("key_posid");
          localObject3 = (String)((Map)localObject4).get("key_clicktype");
          localObject4 = (String)((Map)localObject4).get("key_keyword");
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(System.currentTimeMillis()).append("_").append(SearchProtocol.jdField_a_of_type_Long).append("_").append(this.i).append("_").append(this.app.getAccount()).append("_").append((String)localObject1).append("_").append((String)localObject2).append("_").append((String)localObject3);
          ReportController.b(this.app, "CliOper", "", "", "0X80059E0", "0X80059E0", 0, 0, "", "", (String)localObject4, localStringBuffer.toString());
        }
      }
      if ((this.i != 2) && (this.i != 4)) {
        break label1058;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, null, "" + this.i, paramhjz.jdField_a_of_type_JavaLangString, "" + SearchProtocol.jdField_a_of_type_Long);
    }
    for (;;)
    {
      paramhjz = new HashMap();
      paramhjz.put("from", String.valueOf(this.i));
      StatisticCollector.a(BaseApplicationImpl.a()).a(this.app.a(), "LebaSearchResultClick", true, 0L, 0L, paramhjz, "", false);
      return;
      label502:
      if (((String)localObject1).equals("311"))
      {
        localObject1 = "2";
        break;
      }
      if (((String)localObject1).equals("2"))
      {
        localObject1 = "3";
        break;
      }
      localObject1 = "4";
      break;
      if ((paramhjz.f == 2049) && (paramhjz.e == 3))
      {
        localObject1 = new Intent();
        localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((Intent)localObject1).putExtra("last_key_words", (String)localObject2);
        ((Intent)localObject1).putExtra("from_key", 5);
        ((Intent)localObject1).putExtra(ClassificationSearchActivity.c, ClassificationSearchActivity.b);
        ((Intent)localObject1).putExtra("fromType", 15);
        ((Intent)localObject1).setClass(this, ClassificationSearchActivity.class);
        ClassificationSearchActivity.a(this, (Intent)localObject1, (String)localObject2);
        break label163;
      }
      if (paramhjz.e == 2)
      {
        localObject1 = (JSONObject)paramhjz.jdField_a_of_type_JavaLangObject;
        localObject2 = ((JSONObject)localObject1).optString("jump_url");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).trim();
          if ((!((String)localObject2).startsWith("http:")) && (!((String)localObject2).startsWith("https:"))) {
            break label786;
          }
          localObject3 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("articalChannelId", 13);
          ((Intent)localObject3).putExtra("url", (String)localObject2);
          startActivity((Intent)localObject3);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DynamicSearch", 2, "click detail : jumpUrl = " + (String)localObject2);
          }
          if (paramhjz.f != 4096) {
            break;
          }
          a((JSONObject)localObject1, "1");
          break;
          label786:
          if (((String)localObject2).startsWith("qapp://"))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setData(Uri.parse((String)localObject2));
            ((Intent)localObject3).setClass(this, JumpActivity.class);
            startActivity((Intent)localObject3);
          }
          else
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setData(Uri.parse((String)localObject2));
            ((Intent)localObject3).setAction("android.intent.action.VIEW");
            startActivity((Intent)localObject3);
          }
        }
      }
      if (paramhjz.e != 3) {
        break label163;
      }
      localObject1 = (String)paramhjz.jdField_a_of_type_JavaLangObject;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).trim();
        if ((!((String)localObject1).startsWith("http:")) && (!((String)localObject1).startsWith("https:"))) {
          break label981;
        }
        startActivity(a(paramhjz));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSearch", 2, "click more: jump_url = " + (String)localObject1);
        }
        if (paramhjz.f != 4096) {
          break;
        }
        a(null, "2");
        break;
        label981:
        if (((String)localObject1).startsWith("qapp://"))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setData(Uri.parse((String)localObject1));
          ((Intent)localObject2).setClass(this, JumpActivity.class);
          startActivity((Intent)localObject2);
        }
        else
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setData(Uri.parse((String)localObject1));
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          startActivity((Intent)localObject2);
        }
      }
      label1058:
      ReportController.b(this.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, this.y, "" + this.i, paramhjz.jdField_a_of_type_JavaLangString, "" + SearchProtocol.jdField_a_of_type_Long);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Hjn);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
    if ((this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem != null) && (!paramString.equals(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word))) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Hjn);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      c(1);
    }
    if (this.jdField_c_of_type_ComTencentWidgetXListView.a() == null)
    {
      paramList = new SearchHistoryAdapter(this, paramList, this);
      this.jdField_c_of_type_ComTencentWidgetXListView.setAdapter(paramList);
    }
    SearchHistoryAdapter localSearchHistoryAdapter;
    do
    {
      return;
      if (!(this.jdField_c_of_type_ComTencentWidgetXListView.a() instanceof HeaderViewListAdapter)) {
        break;
      }
      localSearchHistoryAdapter = (SearchHistoryAdapter)((HeaderViewListAdapter)this.jdField_c_of_type_ComTencentWidgetXListView.a()).getWrappedAdapter();
    } while (localSearchHistoryAdapter == null);
    localSearchHistoryAdapter.a(paramList);
    return;
    ((SearchHistoryAdapter)this.jdField_c_of_type_ComTencentWidgetXListView.a()).a(paramList);
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("result_id");
      paramJSONObject = paramJSONObject.optString("icon");
    }
    for (;;)
    {
      VipComicReportUtils.a(this.app, "3024", "2", "40081", paramString, new String[] { str, paramJSONObject });
      return;
      paramJSONObject = "";
      str = "";
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      c(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131367262);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364998));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
  }
  
  public void b()
  {
    ThreadManager.a(new hjm(this), 10, null, true);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter == null) {}
    label192:
    label200:
    label232:
    for (;;)
    {
      return;
      Object localObject2 = (hjz)this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter.getItem(paramInt);
      Object localObject1 = ((hjz)localObject2).jdField_a_of_type_JavaLangString;
      if (paramInt == 0)
      {
        localObject1 = this.jdField_b_of_type_ComTencentWidgetXListView.getChildAt(0);
        if (((View)localObject1).getBottom() < ((View)localObject1).getHeight())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((hjz)localObject2).jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject2 = (hjz)this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter.getItem(paramInt + 1);
      if (localObject2 != null)
      {
        if (((hjz)localObject2).e != 1) {
          break label200;
        }
        localObject2 = this.jdField_b_of_type_ComTencentWidgetXListView.getChildAt(1);
        paramInt = ((View)localObject2).getHeight();
        int i1 = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (i1 >= paramInt * 2) {
          break label192;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 - paramInt * 2);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label232;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        break;
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131367262);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364998));
      c(1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131364997);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364997));
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, paramString);
  }
  
  public void c()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new hjd(this);
    localQQCustomDialog.setPositiveButton(2131365002, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131365001, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131365000);
    localQQCustomDialog.setTitle(2131364950);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131427355));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.show();
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) && ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)))
      {
        this.r = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      this.r = 1;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
          break label193;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_c_of_type_ComTencentWidgetXListView.setSelection(0);
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    case 2: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.r = 2;
      this.jdField_c_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    case 3: 
      label193:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.r = 3;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.r = 0;
  }
  
  public void c(String paramString)
  {
    ThreadManager.a(new hjl(this, paramString), 10, null, true);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, paramString, this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_Boolean = true;
    ReportController.b(this.app, "CliOper", "", "", "0X8005F2B", "0X8005F2B", 0, 0, "0", null, null, null);
    paramString = new HashMap();
    paramString.put("from", String.valueOf(this.i));
    StatisticCollector.a(BaseApplicationImpl.a()).a(this.app.a(), "LebaRequestSearch", true, 0L, 0L, paramString, "", false);
  }
  
  public void doOnBackPressed()
  {
    switch (this.r)
    {
    default: 
      if (!this.jdField_a_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004B23", "0X8004B23", 1, 0, null, null, null, null);
      }
      finish();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_JavaUtilList = LebaShowListManager.a().a();
    setContentView(2130903628);
    a();
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this, "SearchViewPlugin.apk", "1002");
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a();
    SearchProtocol.a(this, this.app, 600000L, "SearchActivity");
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    a(paramBundle);
    c(0);
    ReportController.b(this.app, "CliOper", "", "", "0X8004B21", "0X8004B21", 0, 0, null, null, null, null);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.r == 0)
    {
      super.getWindow().setSoftInputMode(36);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      return;
    }
    super.getWindow().setSoftInputMode(34);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
  }
  
  public void finish()
  {
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    a(str);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
    this.jdField_b_of_type_Boolean = false;
    switch (paramView.getId())
    {
    default: 
    case 2131300876: 
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131367262)))
        {
          if (!this.jdField_a_of_type_Boolean) {
            ReportController.b(this.app, "CliOper", "", "", "0X8004B23", "0X8004B23", 0, 0, null, null, null, null);
          }
          finish();
          return;
        }
      } while ((!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131364997))) || (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())));
      e();
      return;
    case 2131300880: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      return;
    case 2131299491: 
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
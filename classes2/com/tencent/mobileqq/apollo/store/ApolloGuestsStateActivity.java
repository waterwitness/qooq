package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.data.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPopLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import prh;
import pri;
import prj;
import prk;
import prl;
import prm;
import pro;
import prp;
import prq;
import prr;
import prt;
import pru;

public class ApolloGuestsStateActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, IMessageHandler, WebUiBaseInterface
{
  public static final int a = 0;
  public static final String a = "ApolloGuestsStateActivity";
  public static final int b = 1;
  public static final String b = "extra_guest_nick";
  public static final int c = 2;
  public static final String c = "extra_guest_uin";
  public static final int d = 3;
  public static final String d = "apollo_zan_count";
  public static final int e = 4;
  public static final String e = "apollo_today_has_vote";
  public static final int f = 5;
  public static final String f = "cmshow_zan";
  public float a;
  public Handler a;
  public View a;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public TextView a;
  protected Share a;
  public ElasticHorScrView a;
  public ApolloRenderInterfaceImpl a;
  public ApolloSurfaceView a;
  public IRenderCallback a;
  private ApolloResDownloader.OnApolloDownLoadListener jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener;
  OnDressDoneListener jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver;
  public ActionSheet a;
  List jdField_a_of_type_JavaUtilList;
  prt jdField_a_of_type_Prt;
  pru jdField_a_of_type_Pru;
  public boolean a;
  public float b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ElasticHorScrView b;
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  public float c;
  public ImageView c;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  public boolean d;
  boolean e;
  public boolean f;
  int g;
  public String g;
  int jdField_h_of_type_Int;
  String jdField_h_of_type_JavaLangString;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public ApolloGuestsStateActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new prh(this);
    this.jdField_a_of_type_Pru = new pru(this);
    this.jdField_a_of_type_Prt = new prt(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener = new prm(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener = new prp(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback = new prq(this);
  }
  
  private void a(String paramString)
  {
    Object localObject = "apollo:" + paramString;
    paramString = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(1).a("apollo").e(paramString).a("web", paramString, null, (String)localObject, (String)localObject).a();
    if (QLog.isColorLevel()) {
      QLog.i("ApolloGuestsStateActivity", 2, "shareToMobileQQ.coverUrl:" + null);
    }
    localObject = new StructMsgItemLayoutDefault();
    ((AbsStructMsgItem)localObject).d(1);
    ((AbsStructMsgItem)localObject).b("免费给" + this.jdField_h_of_type_JavaLangString + "送朵花");
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a(null, "apollo", "我正在玩QQ厘米秀，快来给我的形象送朵花吧^^", 1);
    paramString.addItem((AbsStructMsgElement)localObject);
    paramString.addItem(localAbsStructMsgItem);
    localObject = new Intent();
    ((Intent)localObject).putExtra("forward_type", -3);
    ((Intent)localObject).putExtra("stuctmsg_bytes", paramString.getBytes());
    ForwardBaseOption.a(this, (Intent)localObject, 3);
  }
  
  private void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int m;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeView((View)this.jdField_a_of_type_JavaUtilList.get(m));
        m += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      m = 0;
      while (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        ((WindowManager)super.getSystemService("window")).removeView((View)this.jdField_b_of_type_JavaUtilList.get(m));
        m += 1;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DressDescriptionItem localDressDescriptionItem = (DressDescriptionItem)paramList.next();
      if (!TextUtils.isEmpty(localDressDescriptionItem.jdField_a_of_type_JavaLangString))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(localDressDescriptionItem.jdField_a_of_type_Int);
        localTextView.setText(localDressDescriptionItem.jdField_a_of_type_JavaLangString);
        localTextView.setTextSize(11.0F);
        localTextView.setTextColor(-1);
        localTextView.setGravity(17);
        if (!this.jdField_a_of_type_Boolean) {
          localTextView.setOnClickListener(this);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i1 = 0;
        m = 0;
        int n;
        if (localDressDescriptionItem.d == 0)
        {
          m = View.MeasureSpec.makeMeasureSpec(0, 0);
          n = View.MeasureSpec.makeMeasureSpec(0, 0);
          localTextView.setBackgroundResource(2130837736);
          localTextView.measure(m, n);
          n = localTextView.getMeasuredWidth();
          m = localTextView.getMeasuredHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "textview measure wiidth=" + localTextView.getMeasuredWidth());
          }
          localArrayList2.add(localTextView);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag textview height = " + m);
          }
          localLayoutParams.addRule(15, -1);
          localLayoutParams.addRule(12, -1);
          localLayoutParams.addRule(9, -1);
          localLayoutParams.bottomMargin = (localDressDescriptionItem.f - m / 2);
          localLayoutParams.leftMargin = (localDressDescriptionItem.e - n);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(localTextView, localLayoutParams);
          localTextView.setVisibility(4);
          this.jdField_a_of_type_JavaUtilList.add(localTextView);
          break;
          n = i1;
          if (localDressDescriptionItem.d == 1)
          {
            localTextView.setBackgroundResource(2130837737);
            localTextView.setPadding((int)(19.0F * localDisplayMetrics.density), 0, (int)(5.0F * localDisplayMetrics.density), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            m = localTextView.getMeasuredHeight();
            localArrayList1.add(localTextView);
            n = i1;
          }
        }
      }
    }
    a(localArrayList1);
    a(localArrayList2);
    a(localArrayList2, localArrayList1);
  }
  
  protected View a()
  {
    View localView = super.getLayoutInflater().inflate(2130903348, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298208));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298211));
    GridView localGridView2 = (GridView)localView.findViewById(2131298209);
    GridView localGridView1 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(new prr(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label394;
      }
    }
    label394:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int m = ((List)localObject1).size();
      localGridView2.setNumColumns(m);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      float f1 = super.getResources().getDisplayMetrics().density;
      localLayoutParams.width = ((int)(((m - 1) * 10 + m * 75 + 3) * f1));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      m = localLayoutParams.width;
      this.jdField_h_of_type_Int = m;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((n * 75 + (n - 1) * 10 + 3) * f1));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      n = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_g_of_type_Int = n;
      localView.post(new pri(this, m, n));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.getLayoutInflater().inflate(2130903097, null, false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(super.getResources().getColor(2131427430));
    float f1 = (float)(Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f()) / 1.45D);
    float f2 = f1 / 830.0F;
    this.jdField_b_of_type_Float = f1;
    Object localObject1 = new RelativeLayout.LayoutParams((int)(f2 * 630.0F), (int)f1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = AnimationUtils.loadAnimation(this, 2130968594);
    ((Animation)localObject1).setAnimationListener(this.jdField_a_of_type_Pru);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296818);
    ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).topMargin = ((int)(this.jdField_b_of_type_Float / 832.0F * 37.0F));
    this.jdField_h_of_type_JavaLangString = super.getIntent().getStringExtra("extra_guest_nick");
    this.jdField_g_of_type_JavaLangString = super.getIntent().getStringExtra("extra_guest_uin");
    Object localObject2 = ((ApolloManager)this.app.getManager(152)).b(this.jdField_g_of_type_JavaLangString);
    if (localObject2 != null)
    {
      localObject2 = ((ApolloBaseInfo)localObject2).getApolloDress();
      if (localObject2 != null) {
        this.i = ((ApolloDress)localObject2).jdField_a_of_type_Int;
      }
    }
    localObject2 = (BitmapDrawable)BaseApplicationImpl.a.get(this.i + "apollo_cmshow_background");
    if (localObject2 != null)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "nickname = " + this.jdField_h_of_type_JavaLangString + " uin=" + this.jdField_g_of_type_JavaLangString);
    }
    if (this.jdField_g_of_type_JavaLangString.equals(super.getAppInterface().a()))
    {
      this.jdField_a_of_type_Boolean = true;
      VipUtils.a(this.app, "cmshow", "Apollo", "PageView", 0, 0, new String[0]);
    }
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      ((TextView)localObject1).setText(this.jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297066));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297068));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297067));
      localObject1 = super.getBaseContext().getSharedPreferences("cmshow_zan", 0);
      this.l = ((SharedPreferences)localObject1).getInt("apollo_zan_count" + this.jdField_g_of_type_JavaLangString, 0);
      if (this.l >= 999) {
        this.l = 999;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.l);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297059));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297070));
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297058));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297061));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        break label953;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText("邀请好友送花");
      if ((super.getAppInterface() != null) && (((ApolloManager)super.getAppInterface().getManager(152)).b(this.jdField_g_of_type_JavaLangString) == 2))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText("开启厘米秀");
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      label728:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297062));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297063));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297064));
      localObject2 = Calendar.getInstance();
      if (!((SharedPreferences)localObject1).getBoolean(super.getAppInterface().a() + "apollo_today_has_vote" + this.jdField_g_of_type_JavaLangString + ((Calendar)localObject2).get(1) + ((Calendar)localObject2).get(2) + ((Calendar)localObject2).get(5), false)) {
        break label966;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("明天再来送吧");
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#cccccc"));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      return;
      ((TextView)localObject1).setText(" ");
      break;
      label953:
      this.jdField_a_of_type_AndroidWidgetButton.setText("厘米秀商城");
      break label728;
      label966:
      this.jdField_c_of_type_AndroidWidgetTextView.setText("送TA花");
    }
  }
  
  public void a(int paramInt)
  {
    super.runOnUiThread(new prl(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        int m;
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_AndroidWidgetTextView.setText("" + paramMessage.arg1);
          } while (paramMessage.arg1 >= paramMessage.arg2);
          m = paramMessage.arg1;
          int n = paramMessage.arg2;
          this.jdField_a_of_type_AndroidWidgetTextView.setText("" + n);
          m = n - m;
        } while (m <= 0);
        paramMessage = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297069);
        paramMessage.setText("+" + m);
        paramMessage.setVisibility(0);
        paramMessage.startAnimation(AnimationUtils.loadAnimation(this, 2130968597));
        return;
        b((List)paramMessage.obj);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGuestsStateActivity", 2, "dress tag list=" + ((List)paramMessage.obj).toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsStateActivity", 2, "littlemanHeight get height = " + this.k);
      }
      paramMessage = super.getResources().getDisplayMetrics();
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = (this.k + (int)paramMessage.density * 12);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      Object localObject = AnimationUtils.loadAnimation(this, 2130968596);
      ((Animation)localObject).setFillAfter(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (this.j / 2 + ((RelativeLayout.LayoutParams)localObject).width / 2);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(0.3D * this.jdField_b_of_type_Float) - (int)paramMessage.density * 20);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    paramMessage = new BitmapDrawable(paramMessage);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramMessage);
    BaseApplicationImpl.a.put(this.i + "apollo_cmshow_background", paramMessage);
  }
  
  public void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    ApolloPopLayout localApolloPopLayout = new ApolloPopLayout(this);
    Object localObject = new FrameLayout(this);
    TextView localTextView = new TextView(this);
    ((FrameLayout)localObject).addView(localTextView);
    localApolloPopLayout.addView((View)localObject);
    localApolloPopLayout.setId(paramTextView.getId());
    localApolloPopLayout.setOnClickListener(this);
    int[] arrayOfInt = new int[2];
    paramTextView.getLocationInWindow(arrayOfInt);
    int m = paramTextView.getWidth();
    int n = paramTextView.getHeight();
    localTextView.setText(paramTextView.getText().toString());
    localTextView.setTextColor(-1);
    localTextView.setTextSize(11.0F);
    if (paramBoolean)
    {
      localTextView.setPadding((int)(19.0F * this.jdField_c_of_type_Float), 0, (int)(5.0F * this.jdField_c_of_type_Float), 0);
      localTextView.setBackgroundResource(2130837737);
    }
    for (;;)
    {
      localTextView.setGravity(16);
      paramTextView = (FrameLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
      paramTextView.gravity = 16;
      paramTextView.width = m;
      paramTextView.height = n;
      paramTextView = (WindowManager)a(this, "window");
      localObject = new WindowManager.LayoutParams(-2, -2, 2, 32, -3);
      ((WindowManager.LayoutParams)localObject).gravity = 51;
      ((WindowManager.LayoutParams)localObject).width = m;
      ((WindowManager.LayoutParams)localObject).height = n;
      ((WindowManager.LayoutParams)localObject).x = arrayOfInt[0];
      ((WindowManager.LayoutParams)localObject).y = (arrayOfInt[1] - 100);
      paramTextView.addView(localApolloPopLayout, (ViewGroup.LayoutParams)localObject);
      if (this.jdField_b_of_type_JavaUtilList == null) {
        break;
      }
      this.jdField_b_of_type_JavaUtilList.add(localApolloPopLayout);
      return;
      localTextView.setBackgroundResource(2130837736);
    }
  }
  
  public void a(ApolloDress paramApolloDress)
  {
    if (paramApolloDress == null) {
      return;
    }
    ArrayList localArrayList;
    for (;;)
    {
      DressDescriptionItem localDressDescriptionItem;
      ApolloDress.Dress localDress;
      JSONObject localJSONObject;
      String str;
      try
      {
        paramApolloDress = paramApolloDress.jdField_a_of_type_JavaUtilHashMap;
        if (paramApolloDress == null) {
          break;
        }
        localArrayList = new ArrayList();
        Iterator localIterator = paramApolloDress.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label497;
        }
        localDressDescriptionItem = new DressDescriptionItem();
        paramApolloDress = (Map.Entry)localIterator.next();
        if (paramApolloDress == null) {
          continue;
        }
        m = ((Integer)paramApolloDress.getKey()).intValue();
        localDressDescriptionItem.jdField_a_of_type_Int = m;
        localDress = (ApolloDress.Dress)paramApolloDress.getValue();
        if ((localDress == null) || (localDress.a == null) || (localDress.a.size() <= 0)) {
          continue;
        }
        paramApolloDress = new File(ApolloConstant.m + m + "/config.json");
        if (paramApolloDress.exists()) {
          paramApolloDress = FileUtils.a(paramApolloDress);
        }
      }
      finally {}
      try
      {
        localJSONObject = new JSONObject(new String(paramApolloDress, "UTF-8"));
        if ((localJSONObject.has("isShowInCard")) && (localJSONObject.getInt("isShowInCard") == 0)) {
          continue;
        }
        str = localJSONObject.optString("name");
        paramApolloDress = str;
        if (localJSONObject.has("showName"))
        {
          if (!TextUtils.isEmpty(localJSONObject.getString("showName"))) {
            break label446;
          }
          paramApolloDress = str;
        }
        localDressDescriptionItem.jdField_a_of_type_JavaLangString = paramApolloDress;
      }
      catch (Exception paramApolloDress)
      {
        label446:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloGuestsStateActivity", 2, "initTag e=" + paramApolloDress.toString());
        continue;
      }
      paramApolloDress = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a((String)localDress.a.get(0));
      if ((paramApolloDress != null) && ((paramApolloDress.bottom != paramApolloDress.top) || (paramApolloDress.left != paramApolloDress.right)))
      {
        localDressDescriptionItem.f = (((int)paramApolloDress.top + (int)paramApolloDress.bottom) / 2);
        localDressDescriptionItem.jdField_h_of_type_Int = ((int)paramApolloDress.left);
        localDressDescriptionItem.jdField_g_of_type_Int = ((int)paramApolloDress.right);
        localArrayList.add(localDressDescriptionItem);
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGuestsStateActivity", 2, "item.name =" + localDressDescriptionItem.jdField_a_of_type_JavaLangString + " item.y = " + localDressDescriptionItem.f + " item.left = " + localDressDescriptionItem.jdField_h_of_type_Int + " item.right = " + localDressDescriptionItem.jdField_g_of_type_Int);
          continue;
          paramApolloDress = null;
          continue;
          paramApolloDress = localJSONObject.getString("showName");
        }
      }
    }
    label497:
    Collections.sort(localArrayList);
    int n = 0;
    int m = 0;
    for (;;)
    {
      if (n < localArrayList.size())
      {
        ((DressDescriptionItem)localArrayList.get(n)).d = m;
        if (m == 0)
        {
          ((DressDescriptionItem)localArrayList.get(n)).e = ((DressDescriptionItem)localArrayList.get(n)).jdField_h_of_type_Int;
          m = 1;
        }
        else if (m == 1)
        {
          ((DressDescriptionItem)localArrayList.get(n)).e = ((DressDescriptionItem)localArrayList.get(n)).jdField_g_of_type_Int;
          m = 0;
        }
      }
      else
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        paramApolloDress = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        paramApolloDress.obj = localArrayList;
        paramApolloDress.sendToTarget();
        break;
      }
      n += 1;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < paramList.size() - 1)
      {
        TextView localTextView1 = (TextView)paramList.get(m);
        TextView localTextView2 = (TextView)paramList.get(m + 1);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView2.getLayoutParams();
        int n = localLayoutParams1.bottomMargin - localLayoutParams2.bottomMargin;
        if (n < localTextView1.getMeasuredHeight())
        {
          n = localTextView1.getMeasuredHeight() - n + 2;
          localLayoutParams2.bottomMargin -= n;
          localTextView2.requestLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag location modify move distence=" + n);
          }
        }
        m += 1;
      }
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    int i1 = 0;
    if ((paramList1 == null) || (paramList2 == null)) {}
    for (;;)
    {
      return;
      int m = 0;
      int n;
      for (;;)
      {
        n = i1;
        if (m >= paramList1.size()) {
          break;
        }
        TextView localTextView = (TextView)paramList1.get(m);
        localTextView.post(new prj(this, localTextView));
        m += 1;
      }
      while (n < paramList2.size())
      {
        paramList1 = (TextView)paramList2.get(n);
        paramList1.post(new prk(this, paramList1));
        n += 1;
      }
    }
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364561);
    localActionSheetItem.u = 2130838114;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 2;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364567);
    localActionSheetItem.u = 2130838115;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 3;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364577);
    localActionSheetItem.u = 2130838116;
    localActionSheetItem.v = 9;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364578);
    localActionSheetItem.u = 2130838112;
    localActionSheetItem.v = 10;
    localActionSheetItem.b = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    if (this.app == null) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((ApolloManager)this.app.getManager(152)).b(this.jdField_g_of_type_JavaLangString);
    Object localObject1;
    int m;
    if (localApolloBaseInfo != null)
    {
      localObject1 = localApolloBaseInfo.getApolloDress();
      if (localObject1 != null)
      {
        m = ((ApolloDress)localObject1).jdField_a_of_type_Int;
        localObject1 = ((ApolloDress)localObject1).a();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (m > 0)
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localObject1.length > 0)
          {
            localObject2 = localObject1;
            if (!ApolloActionHelper.a(this.jdField_g_of_type_JavaLangString, m, (int[])localObject1, this.app, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener)) {
              localObject2 = ApolloResDownloader.a(m);
            }
          }
        }
      }
      int n = m;
      if (m < 0) {
        n = 0;
      }
      if ((localObject2 == null) || (localObject2.length <= 0)) {}
      for (localObject1 = ApolloResDownloader.a(n);; localObject1 = localObject2)
      {
        float f1 = (float)Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f()) * 0.2F / 368.0F;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.a(1, n, f1, this.jdField_a_of_type_Float, 0.0F);
        if (n == 0) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.a(1, ApolloResDownloader.a(n), null);
        }
        for (;;)
        {
          this.i = n;
          if (localApolloBaseInfo != null)
          {
            localApolloBaseInfo.getApolloDress();
            ThreadManager.a(new pro(this), 5, null, false);
          }
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback);
          localObject1 = ApolloActionTask.a(5, n, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.a(1, 5, ApolloActionManager.a().b(), localObject1[0], localObject1[1]);
          this.jdField_c_of_type_Boolean = true;
          return;
          if ((n > 0) && (localObject1 != null)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.a(1, (int[])localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener);
          }
        }
      }
      localObject1 = null;
      m = 0;
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = new File(ApolloConstant.n + paramInt + "/config.json");
    if (((File)localObject).exists())
    {
      localObject = FileUtils.a((File)localObject);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    do
    {
      for (;;)
      {
        return;
        localObject = null;
        break;
        try
        {
          localObject = new JSONObject(new String((byte[])localObject, "UTF-8")).optString("name");
          if (this.jdField_a_of_type_AndroidOsHandler != null)
          {
            Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
            localMessage.obj = localObject;
            localMessage.sendToTarget();
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloGuestsStateActivity", 2, "initTag e=" + localException.toString());
  }
  
  public void c()
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView1 = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView1, null);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGuestsStateActivity", 2, "actionSheet.show exception=" + localException);
      return;
      View localView2 = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView2, null);
    }
  }
  
  /* Error */
  public void c(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iload_1
    //   4: ifgt +4 -> 8
    //   7: return
    //   8: new 161	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   15: getstatic 1120	com/tencent/mobileqq/apollo/utils/ApolloConstant:n	Ljava/lang/String;
    //   18: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc_w 1152
    //   28: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: new 942	java/io/File
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 951	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 954	java/io/File:exists	()Z
    //   48: ifeq -41 -> 7
    //   51: aload_0
    //   52: invokespecial 300	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   55: invokevirtual 306	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   58: astore 6
    //   60: ldc_w 570
    //   63: aload 6
    //   65: getfield 425	android/util/DisplayMetrics:density	F
    //   68: fmul
    //   69: fconst_2
    //   70: fdiv
    //   71: fstore_2
    //   72: aload 6
    //   74: getfield 425	android/util/DisplayMetrics:density	F
    //   77: fstore_3
    //   78: fload_3
    //   79: ldc_w 569
    //   82: fmul
    //   83: fconst_2
    //   84: fdiv
    //   85: fstore_3
    //   86: new 1154	android/graphics/BitmapFactory$Options
    //   89: dup
    //   90: invokespecial 1155	android/graphics/BitmapFactory$Options:<init>	()V
    //   93: astore 6
    //   95: aload 6
    //   97: fload_3
    //   98: f2i
    //   99: putfield 1158	android/graphics/BitmapFactory$Options:outHeight	I
    //   102: aload 6
    //   104: fload_2
    //   105: f2i
    //   106: putfield 1161	android/graphics/BitmapFactory$Options:outWidth	I
    //   109: new 1163	java/io/BufferedInputStream
    //   112: dup
    //   113: new 1165	java/io/FileInputStream
    //   116: dup
    //   117: aload 4
    //   119: invokespecial 1166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   122: invokespecial 1169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: aconst_null
    //   126: aload 6
    //   128: invokestatic 1175	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull -128 -> 7
    //   138: aload_0
    //   139: getfield 785	com/tencent/mobileqq/apollo/store/ApolloGuestsStateActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   142: ifnull -135 -> 7
    //   145: aload_0
    //   146: getfield 785	com/tencent/mobileqq/apollo/store/ApolloGuestsStateActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   149: iconst_5
    //   150: invokevirtual 791	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   153: astore 5
    //   155: aload 5
    //   157: aload 4
    //   159: ldc_w 1176
    //   162: aload 4
    //   164: invokevirtual 1177	android/graphics/Bitmap:getWidth	()I
    //   167: aload 4
    //   169: invokevirtual 1178	android/graphics/Bitmap:getHeight	()I
    //   172: invokestatic 1183	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   175: putfield 815	android/os/Message:obj	Ljava/lang/Object;
    //   178: aload 5
    //   180: invokevirtual 802	android/os/Message:sendToTarget	()V
    //   183: return
    //   184: astore 4
    //   186: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -182 -> 7
    //   192: ldc 18
    //   194: iconst_2
    //   195: new 161	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 1185
    //   205: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 1018	java/lang/Exception:toString	()Ljava/lang/String;
    //   213: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 1020	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore 4
    //   225: aload 5
    //   227: astore 4
    //   229: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -99 -> 133
    //   235: ldc 18
    //   237: iconst_2
    //   238: ldc_w 1187
    //   241: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aload 5
    //   246: astore 4
    //   248: goto -115 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	ApolloGuestsStateActivity
    //   0	251	1	paramInt	int
    //   71	34	2	f1	float
    //   77	21	3	f2	float
    //   34	134	4	localObject1	Object
    //   184	25	4	localException	Exception
    //   223	1	4	localOutOfMemoryError	OutOfMemoryError
    //   227	20	4	localMessage1	Message
    //   1	244	5	localMessage2	Message
    //   58	69	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	78	184	java/lang/Exception
    //   86	133	184	java/lang/Exception
    //   138	183	184	java/lang/Exception
    //   229	244	184	java/lang/Exception
    //   86	133	223	java/lang/OutOfMemoryError
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      int m = 0;
      while (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        ((WindowManager)super.getSystemService("window")).removeView((View)this.jdField_b_of_type_JavaUtilList.get(m));
        m += 1;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    super.startActivity(localIntent);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().addFlags(16777216);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = PngFrameManager.a(this);
    this.jdField_c_of_type_Float = super.getResources().getDisplayMetrics().density;
    a();
    paramBundle = (VasExtensionHandler)super.getAppInterface().a(71);
    paramBundle.b(this.jdField_g_of_type_JavaLangString);
    super.setContentView(this.jdField_d_of_type_AndroidWidgetRelativeLayout);
    super.getAppInterface().a(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    paramBundle.a(this.jdField_g_of_type_JavaLangString, 256, "myApollo");
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      this.mSystemBarComp.a(0);
      this.mSystemBarComp.b(0);
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(super.getAppInterface(), this);
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a("免费给" + this.jdField_h_of_type_JavaLangString + "送朵花", "我正在玩QQ厘米秀，快来给我的形象送朵花吧^^", "www.qq.com", "hehe", null, true);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.g();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.c();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
    }
    if (super.getAppInterface() != null) {
      super.getAppInterface().b(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Prt = null;
    this.jdField_a_of_type_Pru = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskOnDressDoneListener = null;
  }
  
  protected boolean onBackEvent()
  {
    if (this.f) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.g();
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968595);
    localAnimation.setAnimationListener(this.jdField_a_of_type_Prt);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.g();
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
      }
      d();
      paramView = AnimationUtils.loadAnimation(this, 2130968595);
      paramView.setAnimationListener(this.jdField_a_of_type_Prt);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
    }
    label471:
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
              do
              {
                do
                {
                  return;
                  if (paramView.getId() != 2131297062) {
                    break;
                  }
                } while (this.e);
                VipUtils.a(this.app, "cmshow", "Apollo", "FlowerClick", 0, 0, new String[0]);
                this.e = true;
                this.l += 1;
                paramView = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F);
                paramView.setRepeatCount(1);
                paramView.setRepeatMode(2);
                paramView.setDuration(500L);
                this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramView);
                if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.l));
                }
                ((VasExtensionHandler)super.getAppInterface().a(71)).a(this.jdField_g_of_type_JavaLangString, "myApollo");
              } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
              this.jdField_c_of_type_AndroidWidgetTextView.setText("明天再来送吧");
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(false);
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
              if (Build.VERSION.SDK_INT >= 11) {
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#cccccc"));
              return;
              if (paramView.getId() != 2131297061) {
                break label471;
              }
              if (!this.jdField_a_of_type_Boolean) {
                break;
              }
            } while (super.getAppInterface() == null);
            paramView = (ApolloManager)super.getAppInterface().getManager(152);
            if ((paramView.b(this.jdField_g_of_type_JavaLangString) == 2) && (super.getAppInterface() != null))
            {
              super.getAppInterface().a(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
              ((VasExtensionHandler)super.getAppInterface().a(71)).a(1, "myCMshow");
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              VipUtils.a(this.app, "cmshow", "Apollo", "OpenCMshowButton", 0, this.i, new String[0]);
              return;
            }
          } while (paramView.b(this.jdField_g_of_type_JavaLangString) != 1);
          c();
          return;
          ApolloUtil.a(this, null, "mycmshow");
          VipUtils.a(this.app, "cmshow", "Apollo", "cmMallClick", 0, 0, new String[] { "0", "0", "mycmshow" });
          return;
          if (paramView.getId() != 2131297070) {
            break;
          }
        } while (this.jdField_a_of_type_Boolean);
        paramView = new Intent();
        paramView.putExtra("extra_key_url_append", "&roleId=" + this.i);
        ApolloUtil.a(this, paramView, "mycmshow");
        VipUtils.a(this.app, "cmshow", "Apollo", "TipClick", this.i, 0, new String[] { "0", "0", "mycmshow" });
        return;
        if (paramView.getId() != 1011) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGuestsStateActivity", 2, "popwindow down");
      return;
    } while (this.jdField_a_of_type_Boolean);
    int m = paramView.getId();
    paramView = new Intent();
    paramView.putExtra("extra_key_url_append", "&dressId=" + m + "&roleId=" + this.i);
    ApolloUtil.a(this, paramView, "mycmshow");
    VipUtils.a(this.app, "cmshow", "Apollo", "TipClick", this.i, 0, new String[] { "" + m });
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("ApolloGuestsStateActivity", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label58;
      }
    }
    label58:
    int m;
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      m = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
      paramView = this.jdField_h_of_type_JavaLangString;
      try
      {
        paramAdapterView = URLEncoder.encode(this.jdField_h_of_type_JavaLangString, "utf-8");
        paramView = new StringBuilder("http://imgcache.qq.com/apollo/html/cmshow.html?openid=");
        paramView.append(this.jdField_g_of_type_JavaLangString).append("&nickname=").append(paramAdapterView).append("&max-age=0");
        paramAdapterView = paramView.toString();
        if (m == 1)
        {
          ((ClipboardManager)super.getSystemService("clipboard")).setText(paramAdapterView);
          QRUtils.a(2, 2131364463);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramAdapterView = paramView;
          if (QLog.isColorLevel())
          {
            QLog.e("ApolloGuestsStateActivity", 2, "urlencode error = " + localException.toString());
            paramAdapterView = paramView;
          }
        }
        if (m == 2)
        {
          a(paramView.toString());
          return;
        }
        if (m == 3)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
            return;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.r))
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d();
            return;
          }
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
          return;
        }
      }
    } while ((m != 9) && (m != 10));
    paramInt = -1;
    if (!WXShareHelper.a().a()) {
      paramInt = 2131369529;
    }
    while (paramInt != -1)
    {
      QRUtils.a(0, paramInt);
      return;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131369530;
      }
    }
    if (m == 9)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.s)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e();
        } else {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, false);
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.t)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.f();
      } else {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloGuestsStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
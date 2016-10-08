package com.tencent.biz.pubaccount.imageCollection;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.PhotoItemInfo;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.RecommendItemInfo;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ImageCollectionGallery;
import cooperation.qqfav.QfavBuilder;
import hur;
import hus;
import hut;
import huu;
import huv;
import huw;
import hux;
import huy;
import huz;
import hva;
import hvb;
import hvc;
import hvd;
import hve;
import hvf;
import hvg;
import hvh;
import hvi;
import hvj;
import hvk;
import hvl;
import hvm;
import hvn;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class ImageCollectionActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener, FaceDecoder.DecodeTaskCompletionListener, WebUiBaseInterface, WebUiUtils.WebUiMethodInterface, AdapterView.OnItemLongClickListener
{
  public static final String a = "ImageCollectionActivity";
  public static final String b = "ImageCollectionSSOTAG";
  public static final String c = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=";
  public static final String d = "articleid";
  public static final String e = "recommend_source";
  public static final String f = "recommend_position";
  public static final String g = "click_source";
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private ImageCollectionPagerAdapter jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionPagerAdapter;
  public Share a;
  public ElasticHorScrView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  public ActionSheet a;
  private ImageCollectionGallery jdField_a_of_type_ComTencentWidgetImageCollectionGallery;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public ElasticHorScrView b;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  public ImageCollectionActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.l = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.n = "";
    this.o = "";
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
  }
  
  private View a(int paramInt)
  {
    View localView = super.getLayoutInflater().inflate(2130903348, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298208));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298211));
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131298209);
    GridView localGridView1 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * this.jdField_a_of_type_Float));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(new huy(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label414;
      }
    }
    label414:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      paramInt = ((List)localObject1).size();
      localGridView2.setNumColumns(paramInt);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((paramInt - 1) * 10 + paramInt * 75 + 3) * this.jdField_a_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      paramInt = localLayoutParams.width;
      this.jdField_b_of_type_Int = paramInt;
      int i1 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((i1 * 75 + (i1 - 1) * 10 + 3) * this.jdField_a_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i1);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      i1 = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_a_of_type_Int = i1;
      localView.post(new huz(this, paramInt, i1));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.bo).mkdirs();
      str = AppConstants.bo + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131368778), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131368781)).setMessage(getString(2131368783)).setPositiveButton(getString(2131368782), new hvf(this, paramURLDrawable, str)).setNegativeButton(getString(2131367259), new hve(this)).show();
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.cb);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.cb + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramString);
      localBundle.putString("forward_filepath", (String)localObject);
      localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", (String)localObject);
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtras(localBundle);
      ForwardBaseOption.a(this, paramURLDrawable, 21);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", localIOException);
          localObject = str;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
  }
  
  private List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131364561);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838114;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131364567);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838115;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131364577);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838116;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131364578);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838112;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131364565);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130839505;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364576);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.u = 2130840304;
    localActionSheetItem.v = 6;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364563);
    localActionSheetItem.u = 2130838111;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 1;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131364564);
    localActionSheetItem.u = 2130839494;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size())) {
      return;
    }
    int i1 = this.jdField_c_of_type_Int + 1;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(i1 + "/" + this.jdField_b_of_type_JavaUtilArrayList.size());
    localSpannableStringBuilder.append(" " + ((PublicAccountArticleObserver.PhotoItemInfo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).b);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, String.valueOf(i1).length(), 18);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
    this.jdField_c_of_type_AndroidWidgetTextView.scrollTo(0, 0);
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new hvg(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void b(boolean paramBoolean)
  {
    if (isActivityResume())
    {
      Dialog localDialog = new Dialog(this, 2131558943);
      localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      localDialog.setContentView(2130903466);
      if (!paramBoolean) {
        ((TextView)localDialog.findViewById(2131298712)).setText(2131372657);
      }
      localDialog.show();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hvb(this, localDialog), 1000L);
    }
  }
  
  private void c()
  {
    if (this.jdField_i_of_type_Int < 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((PublicAccountArticleObserver.RecommendItemInfo)localIterator.next()).c);
      }
    }
    int i1;
    if (this.jdField_i_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      i1 = (int)(((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_i_of_type_Int)).intValue() + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      this.jdField_c_of_type_JavaUtilArrayList.set(this.jdField_i_of_type_Int, Integer.valueOf(i1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.m, 2, this.jdField_c_of_type_JavaUtilArrayList, localArrayList);
      i1 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        this.jdField_c_of_type_JavaUtilArrayList.set(i1, Integer.valueOf(0));
        i1 += 1;
      }
      i1 = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.n, "0X8006F85", "0X8006F85", 0, 0, "", this.m, "" + this.jdField_b_of_type_JavaUtilArrayList.size(), "" + this.jdField_j_of_type_Int);
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (paramInt < 0)) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void d()
  {
    this.m = getIntent().getStringExtra("articleid");
    this.jdField_e_of_type_Int = getIntent().getIntExtra("recommend_source", 0);
    this.jdField_f_of_type_Int = getIntent().getIntExtra("recommend_position", 0);
    this.jdField_g_of_type_Int = getIntent().getIntExtra("click_source", 1);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.o = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    this.mNeedStatusTrans = false;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (paramInt < 0)) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
  }
  
  private void e()
  {
    super.setContentView(2130903464);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery = ((ImageCollectionGallery)findViewById(2131298351));
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setSpacing(getResources().getDimensionPixelSize(2131492970));
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnItemSelectedListener(new hur(this));
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnItemClickListener(new hvc(this));
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnTouchListener(new hvh(this));
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnOverScrollListener(new hvi(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(this.app, this, false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297123);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new hvj(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new hvk(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new hvl(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298694));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298695));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298696);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new hvm(this));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298697));
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298698));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298699);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298700));
    findViewById(2131298701).setOnClickListener(new hvn(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298702));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298703));
    findViewById(2131298704).setOnClickListener(new hus(this));
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_k_of_type_Int == 1) {}
    for (String str = "0X8006F9F";; str = "0X800704C")
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "" + this.n, str, str, 0, 0, "", this.m, "" + paramInt, "");
      return;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(93));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new hut(this);
  }
  
  private void g()
  {
    if (!TextUtils.isEmpty(this.m)) {
      ThreadManager.b(new huu(this));
    }
  }
  
  private void h()
  {
    int i2 = 0;
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) && (!TextUtils.isEmpty(this.n)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, this.n);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new huv(this));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    b(0);
    int i1 = i2;
    if (PublicAccountConfigUtil.jdField_e_of_type_Boolean)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Boolean) {
        i1 = 1;
      }
    }
    if (i1 != 0) {
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new huw(this));
    }
    while (i1 != 0)
    {
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new hux(this));
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void i()
  {
    b();
    findViewById(2131298706).setVisibility(0);
  }
  
  private void j()
  {
    Object localObject1 = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=" + this.m;
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).a("web", this.jdField_i_of_type_JavaLangString, (String)localObject1, "", "").a("[分享]" + this.jdField_j_of_type_JavaLangString).a();
    Object localObject2 = this.l;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a((String)localObject2, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, 1);
    ((AbsShareMsg)localObject1).addItem(localAbsStructMsgItem);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ForwardBaseOption.a(this, (Intent)localObject2, 3);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this, ImageCollectionCommentActivity.class);
    if (!TextUtils.isEmpty(this.p)) {
      localIntent.putExtra("comment", this.p);
    }
    localIntent.putExtra("anonymous", this.jdField_b_of_type_Boolean);
    startActivityForResult(localIntent, 100);
  }
  
  private void l()
  {
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this, PublicAccountBrowser.class);
      localIntent.putExtra("uin", this.o);
      localIntent.putExtra("url", this.jdField_h_of_type_JavaLangString);
      localIntent.putExtra("puin", this.n);
      startActivity(localIntent);
    }
    NetConnInfoCenter.getServerTime();
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.n, "0X8006F9E", "0X8006F9E", 0, 0, "", this.m, "", "");
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(this.m, this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838907);
    }
    for (this.jdField_h_of_type_Int -= 1;; this.jdField_h_of_type_Int += 1)
    {
      d(this.jdField_h_of_type_Int);
      return;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838800);
    }
  }
  
  private void n()
  {
    a(1);
  }
  
  private void o()
  {
    b(this.jdField_c_of_type_Int);
    a(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.n)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.a(true);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.b(true);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setRotateEnable(true);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnItemLongClickListener(this);
    c(this.jdField_e_of_type_Boolean);
  }
  
  private void p()
  {
    a(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.a(false);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.b(false);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setRotateEnable(false);
    this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.setOnItemLongClickListener(null);
    c(false);
  }
  
  private void q()
  {
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      c(this.jdField_e_of_type_Boolean);
      return;
    }
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetImageCollectionGallery.a();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131296303)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131370093, 1);
    localActionSheet.a(2131370099, 1);
    localActionSheet.d(2131367262);
    localActionSheet.a(new hvd(this, localActionSheet, (URLDrawable)localObject));
    localActionSheet.show();
  }
  
  public String a()
  {
    if (this.jdField_i_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_i_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      this.jdField_d_of_type_AndroidViewView = findViewById(2131298705);
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionPagerAdapter == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView1 = a(paramInt);
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
        if (paramInt != 1) {
          break label97;
        }
        this.jdField_k_of_type_Int = 2;
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      View localView2 = a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView2, null);
    }
    label97:
    this.jdField_k_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    } while (!QLog.isColorLevel());
    QLog.d("ImageCollectionActivity", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
  
  public void a(PublicAccountArticleObserver.RecommendItemInfo paramRecommendItemInfo, int paramInt)
  {
    Intent localIntent = new Intent(this, ImageCollectionActivity.class);
    localIntent.putExtra("articleid", paramRecommendItemInfo.c);
    localIntent.putExtra("recommend_source", paramRecommendItemInfo.jdField_a_of_type_Int);
    localIntent.putExtra("recommend_position", paramInt);
    localIntent.putExtra("click_source", 2);
    startActivity(localIntent);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "" + this.n, "0X8006F83", "0X8006F83", 0, 0, paramRecommendItemInfo.c, this.m, "" + paramInt, "" + this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.a(paramString).c(str).a(this, str, 101, null);
  }
  
  public boolean a(com.tencent.widget.AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      r();
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
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
            return;
          } while (paramInt2 != -1);
          ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
          return;
        } while (paramIntent == null);
        this.p = paramIntent.getStringExtra("comment");
        this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("anonymous", false);
        if (paramInt2 == 0)
        {
          a(this.p);
          return;
        }
      } while (paramInt2 != -1);
      a("");
      ThreadManager.b(new hva(this));
      return;
      QfavBuilder.a(this, paramIntent);
      return;
    } while (paramInt2 != -1);
    a(paramIntent.getExtras());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    d();
    super.doOnCreate(paramBundle);
    e();
    a();
    f();
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_g_of_type_Boolean = false;
    super.doOnPause();
    AbstractGifImage.pauseAll();
    c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
    this.jdField_g_of_type_Boolean = true;
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    if (this.jdField_a_of_type_Long != 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public String getCurrentUrl()
  {
    return null;
  }
  
  public CustomWebView getWebView()
  {
    return null;
  }
  
  public void hideQQBrowserButton() {}
  
  public boolean isActivityResume()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean isFullScreen()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onItemClick(android.widget.AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
      paramAdapterView = a();
      if (i1 == 1)
      {
        ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
        QRUtils.a(2, 2131364463);
        e(8);
        return;
      }
      if (i1 == 11)
      {
        Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAdapterView);
        paramView = null;
        try
        {
          paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
          paramView = String.valueOf(NetConnInfoCenter.getServerTime());
          String str = MD5Utils.b(paramAdapterView + 200 + paramView + "jubao@article@123").toLowerCase();
          paramAdapterView = "http://jubao.mp.qq.com/mobile/report?qq=" + this.o + "&mp_uin=" + this.n + "&scene=200&sub_appname=article_webview&timestamp=" + paramView + "&sign=" + str + "&article_url=" + paramAdapterView;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView);
          paramView.putExtra("hide_more_button", true);
          startActivity(paramView);
          e(9);
          return;
        }
        catch (UnsupportedEncodingException paramAdapterView)
        {
          for (;;)
          {
            paramAdapterView = paramView;
            if (QLog.isColorLevel())
            {
              QLog.d("ImageCollectionActivity", 2, "encode url failed, because UTF-8 is unknown");
              paramAdapterView = paramView;
            }
          }
        }
      }
      if (i1 == 2)
      {
        j();
        e(1);
        return;
      }
      if (i1 == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
        paramAdapterView.putExtra("normal", true);
        try
        {
          startActivity(paramAdapterView);
          e(5);
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131364483);
          }
        }
      }
      if (i1 == 3)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
        e(2);
        return;
      }
      if (i1 == 6)
      {
        a(paramAdapterView, true);
        e(6);
        return;
      }
    } while ((i1 != 9) && (i1 != 10));
    if (i1 == 9)
    {
      e(3);
      paramInt = -1;
      if (WXShareHelper.a().a()) {
        break label455;
      }
      paramInt = 2131369529;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label471;
      }
      QRUtils.a(0, paramInt);
      return;
      e(4);
      break;
      label455:
      if (!WXShareHelper.a().b()) {
        paramInt = 2131369530;
      }
    }
    label471:
    if (i1 == 9)
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public void showActionSheet() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\imageCollection\ImageCollectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
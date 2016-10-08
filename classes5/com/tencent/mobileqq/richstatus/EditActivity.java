package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.SigTplPagerAdapter;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClickableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import uhl;
import uhm;
import uhn;
import uho;
import uhp;
import uhq;
import uhr;
import uhs;
import uht;
import uhu;
import uhv;
import uhw;
import uhx;
import uhy;
import uhz;
import uia;
import uib;
import uic;
import uie;
import uif;
import uig;
import uih;
import uii;
import uij;
import uik;
import uil;
import uim;
import uin;
import uio;

public class EditActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AbsListView.OnScrollListener
{
  private static final int A = -210011;
  private static final int B = 30;
  private static final int C = 20;
  private static final int D = 1;
  public static final int a = 1;
  public static final String a = "EditActivity";
  public static boolean a = false;
  public static final int b = 2;
  public static final String b = "sp_hot_status";
  public static final int c = 4;
  public static final String c = "param_rich_status";
  public static final int d = 7;
  public static final String d = "param_old_xuan_yan";
  private static final boolean jdField_d_of_type_Boolean = AppSetting.j;
  public static final int e = 16;
  static final long jdField_e_of_type_Long = 1300L;
  public static final String e = "param_new_xuan_yan";
  public static final int f = 17;
  public static final String f = "k_action_id";
  public static final int g = 18;
  public static final String g = "k_action_text";
  public static final int h = 19;
  public static final String h = "k_data_id";
  public static final int i = 20;
  public static final String i = "k_data_text";
  public static final int j = 1;
  public static final String j = "param_entry";
  public static final int k = 2;
  public static final String k = "k_source";
  public static final int l = 3;
  public static final String l = "k_taskId";
  public static final int m = 2000;
  public static final String m = "SigCommitVIP";
  public static int n = 0;
  public static final String n = "#ffa8a8a8";
  public static int o = 0;
  public static final String o = "tipsbar_clicked";
  private static final int p = 17;
  private static final int jdField_q_of_type_Int = 18;
  private static final String jdField_q_of_type_JavaLangString = " ";
  private static final int jdField_r_of_type_Int = 7;
  private static final String jdField_r_of_type_JavaLangString = "...";
  private static final int s = 47;
  private static final int t = 10;
  private static final int w = 5;
  private static final int x = -210006;
  private static final int y = -210007;
  private static final int z = -210008;
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new uih(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new uik(this);
  protected View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new uhz(this);
  View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new uie(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  public HorizontalScrollView a;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AIOAnimationConatiner a;
  SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  private SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new uhq(this);
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new uic(this);
  UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new uii(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new uia(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new uij(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = new uhm(this);
  private RichStatusEditText jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  SigTplPagerAdapter jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter;
  protected SignatureTemplateInfo.DynamicItem a;
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new uif(this);
  public TabBarView a;
  public ActionSheet a;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new uig(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new uil(this);
  protected final MqqHandler a;
  public long b;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new uhr(this);
  public boolean b;
  long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  public long d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  long jdField_f_of_type_Long = 0L;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  public String p;
  private int u;
  private int v;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EditActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uim(this);
    this.jdField_d_of_type_Long = 0L;
  }
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    if (QLog.isColorLevel()) {
      QLog.d("EditActivity", 2, "tv.getWidth() = " + paramView.getWidth() + ",tv.getHeight()" + paramView.getHeight());
    }
    try
    {
      Object localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
      ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramView.draw((Canvas)localObject);
      paramView.setDrawingCacheEnabled(true);
      localObject = paramView.getDrawingCache();
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("EditActivity", 2, "cacheBm is null");
          return null;
        }
      }
      else
      {
        localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        paramView.destroyDrawingCache();
        paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
        paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        return paramView;
      }
    }
    catch (OutOfMemoryError paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditActivity", 2, paramView.getMessage());
      }
    }
    return null;
  }
  
  private Drawable a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor("#ffa8a8a8"));
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    Drawable localDrawable2 = localSignatureManager.a(Integer.parseInt(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString), 6, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getWidth(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getHeight());
    if ((paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0] != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) && (!localSignatureManager.b(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString))) {
      localSignatureManager.a(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString, paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
    }
    Drawable localDrawable1 = localDrawable2;
    if (paramSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null)
    {
      localDrawable1 = localDrawable2;
      if (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.c)) {
        localDrawable1 = localSignatureManager.a(Integer.parseInt(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString), 18, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getWidth(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getHeight());
      }
    }
    if ((localDrawable1 instanceof URLDrawable))
    {
      paramSignatureTemplateInfo = (URLDrawable)localDrawable1;
      if ((paramSignatureTemplateInfo.getStatus() == 1) && (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor(localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
      }
      paramSignatureTemplateInfo.setURLDrawableListener(new uhw(this, localSignatureManager));
    }
    do
    {
      return paramSignatureTemplateInfo;
      paramSignatureTemplateInfo = localDrawable1;
    } while (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor(localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
    return localDrawable1;
  }
  
  private Drawable a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903385, null);
    localView.setPadding(0, 0, 0, 0);
    ImageView localImageView = (ImageView)localView.findViewById(2131298375);
    TextView localTextView = (TextView)localView.findViewById(2131298376);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText;
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 10) {
      localObject2 = ((String)localObject1).substring(0, 9) + "...";
    }
    localTextView.setText((CharSequence)localObject2);
    if (paramBoolean2) {
      localTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    }
    for (;;)
    {
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId, 200));
      localView.setBackgroundResource(2130842874);
      return a(localView);
      if (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) {
        localTextView.setTextColor(Color.parseColor(localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getByteArray("param_rich_status");
      if ((paramBundle != null) && (paramBundle.length != 0) && (paramBundle.length > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.parseStatus(paramBundle);
      }
    }
    int i1 = (int)getIntent().getLongExtra("k_action_id", 0L);
    Object localObject;
    if (i1 != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = i1;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.d;
        ((RichStatus)localObject).actionText = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = ((int)getIntent().getLongExtra("k_data_id", 0L));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = getIntent().getStringExtra("k_data_text");
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = paramBundle;
      }
      while (paramBundle.size() < 2) {
        paramBundle.add(null);
      }
      paramBundle = " ";
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().clone());
        if ((this.v != 1) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = getResources().getString(2131372035);
        }
      }
    }
    localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = localSignatureManager.b(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
    this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter = new SigTplPagerAdapter(this.app, this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter.a = SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter);
    if ((SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null) && (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length > 0))
    {
      localSignatureManager.g = 0;
      i1 = 0;
      while (i1 < SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].jdField_a_of_type_JavaLangString);
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(localSignatureManager.g, false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      m();
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
    {
      this.g.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
      if (jdField_d_of_type_Boolean) {
        this.g.setContentDescription("所在地:" + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
      }
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, true, true);
      }
    }
    do
    {
      return;
      localObject1 = a(false, paramBoolean);
      localObject2 = a(true, paramBoolean);
    } while ((localObject1 == null) || (localObject2 == null));
    Object localObject1 = new ClickableImageSpan((Drawable)localObject1, (Drawable)localObject2);
    if (this.v != 1) {
      ((ClickableImageSpan)localObject1).a(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable() != null)) {
      ((ClickableImageSpan)localObject1).getDrawable().setState(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable().getState());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getEditableText();
    if (((ImageSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), ClickableImageSpan.class)).length > 0) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, (ClickableImageSpan)localObject1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = ((ClickableImageSpan)localObject1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().insert(0, "[S]");
      int i1 = "[S]".length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSpan((ImageSpan)localObject1, 0, i1);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297479));
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      b(false);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    b(true);
  }
  
  private void j()
  {
    setTitle(2131370625);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297138));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298268));
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131304993));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297479));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131304990));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299594));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)super.findViewById(2131296989));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = new ListView(getBaseContext());
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)super.findViewById(2131304994));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131305001));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131304998);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297195));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131304999));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131305000));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    if (jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_AndroidWidgetTextView.getText() + "按钮");
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_f_of_type_AndroidWidgetTextView.getText() + "按钮");
    }
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131304995);
    this.g = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131304997));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131304988));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131304985));
    Object localObject = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = DisplayUtil.a(this, 44.0F);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)super.findViewById(2131304986));
    localObject = new LinearLayout.LayoutParams(DisplayUtil.a(this, 100.0F), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams((LinearLayout.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(DisplayUtil.a(this, 2.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(DisplayUtil.a(this, 44.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(-14697741);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    super.findViewById(2131304991).setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    i();
    getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void k()
  {
    Object localObject = (SignatureManager)this.app.getManager(57);
    if ((this.v != 1) && (((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setPadding(DisplayUtil.a(this, 30.0F), DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 30.0F), DisplayUtil.a(this, 20.0F));
      if (((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      }
      localObject = a(((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      }
    }
  }
  
  private void l()
  {
    Object localObject = (SignatureManager)this.app.getManager(57);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
    if ((((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) && (((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, null);
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      m();
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText;
      if (((ArrayList)localObject).get(0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)((ArrayList)localObject).get(0));
      }
      if (((ArrayList)localObject).get(1) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)((ArrayList)localObject).get(1));
      }
      c(false);
    }
  }
  
  private void m()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {}
    for (int i1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan), 0);; i1 = 0)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().length();
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList();
        while (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() < 2) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(null);
        }
      }
      if ((localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) || (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i1, i2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(1, null);
      i2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength();
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0) {
            i1 = i2 - 7;
          }
        }
      }
      String str = Integer.toString(47 - i1);
      if (this.v != 1)
      {
        if (47 - i1 <= 10) {
          break label324;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      while (i1 > 47)
      {
        if (this.v != 1)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-65536);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        return;
        label324:
        if ((localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) || (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if (this.v != 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void n()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131372032)).setPositiveButton(getString(2131372033), new uio(this)).setNegativeButton(getString(2131367774), new uin(this));
    h();
    localQQCustomDialog.show();
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Long == -1L) {
      return;
    }
    try
    {
      i1 = NetworkUtil.a(getApplicationContext());
      String str1 = "";
      switch (i1)
      {
      default: 
        ReportController.b(null, "P_CliOper", "WebStatusReport", "", "unknown", str1, 0, 1, 2, "http://imgcache.qq.com/club/themes/test/gexingqianming/html/index.html", Build.VERSION.RELEASE, String.valueOf(this.jdField_a_of_type_Long - this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Long - this.jdField_b_of_type_Long));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = 0;
        continue;
        String str2 = "2G";
        continue;
        str2 = "3G";
        continue;
        str2 = "4G";
        continue;
        str2 = "wifi";
      }
    }
  }
  
  public void a()
  {
    if (this.v == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength() > 47)
      {
        a(2131370622);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
      setResult(-1, localIntent);
      super.finish();
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      n();
      return;
    }
    o();
    super.finish();
  }
  
  public void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        h();
        localSignatureManager.g = paramInt1;
      } while (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null);
      localObject = (SignatureTemplateInfo)SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[localSignatureManager.g].jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
    } while (localObject == null);
    ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_mdl_id", 0, 0, "" + ((SignatureTemplateInfo)localObject).jdField_a_of_type_JavaLangString, "", "", "");
    localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = ((SignatureTemplateInfo)localObject);
    Object localObject = a((SignatureTemplateInfo)localObject);
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setPadding(DisplayUtil.a(this, 30.0F), DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 30.0F), DisplayUtil.a(this, 20.0F));
      localSignatureManager.f = paramInt2;
      localSignatureManager.e = localSignatureManager.g;
      this.p = SignatureManager.y;
      this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
      if (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
      {
        a(false);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      }
      if ((localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) || (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(false);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    m();
    c(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (SignatureManager)this.app.getManager(57);
    Object localObject2;
    if (paramInt == 3)
    {
      if ((((SignatureManager)localObject1).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) && (!TextUtils.isEmpty(((SignatureManager)localObject1).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.c)))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        VasWebviewUtil.openQQBrowserWithoutAD(this, ((SignatureManager)localObject1).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.c, 150994944L, (Intent)localObject2, true, -1);
      }
      return;
    }
    if (paramBoolean) {}
    for (localObject1 = "mvip.gexinghua.android.signature_openbar";; localObject1 = "mvip.gxh.android.signature_" + ((SignatureManager)localObject1).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString)
    {
      localObject2 = "CJCLUBT";
      String str = getString(2131371097);
      if (paramInt == 1)
      {
        localObject2 = "LTMCLUB";
        str = getString(2131370893);
      }
      VasH5PayUtil.a(this.app, this, (String)localObject1, 1, "1450000515", (String)localObject2, str, "SigCommitVIP");
      return;
    }
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(55 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(paramString1), paramString2, Boolean.valueOf(false), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem });
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 16)
    {
      ReportController.b(this.app, "CliOper", "", "", "signiture", "sig_tlp_pay", 0, 0, "", "", "", "");
      DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131372018)).setPositiveButton(getString(2131371029), new uht(this)).setNegativeButton(getString(2131367262), new uhs(this)).show();
      return false;
    }
    if ((paramInt == 18) || (paramInt == 19))
    {
      DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131372019)).setPositiveButton(getString(2131371029), new uhv(this)).setNegativeButton(getString(2131367262), new uhu(this)).show();
      return false;
    }
    if (paramInt == 20)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131367535)).setMessage(getString(2131372020)).setPositiveButton(getString(2131372021), new uhy(this)).setNegativeButton(getString(2131367262), new uhx(this));
      TextView localTextView = localQQCustomDialog.getMessageTextView();
      ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
      localLayoutParams.width = -1;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setGravity(17);
      localQQCustomDialog.setMessageCount(null);
      localQQCustomDialog.show();
      return false;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(2131370630);
      setResult(-1);
      super.finish();
    }
    return true;
  }
  
  public void b()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_save", 0, 0, "", "", "", "");
    if (!NetworkUtil.e(this))
    {
      a(2131370621);
      return;
    }
    if ((localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) && (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.b);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = null;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength();
    int i1 = i2;
    if (this.v != 1)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
          Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan), 0);
        }
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText != null)
        {
          i1 = i2 - 7;
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(1, null);
      }
    }
    if (i1 > 47)
    {
      a(2131370622);
      ReportController.b(this.app, "CliOper", "", "", "signiture", "set_err_overnum", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getLineCount() > 7)
    {
      a(2131370623);
      return;
    }
    c();
  }
  
  protected void c()
  {
    Object localObject = (SignatureManager)this.app.getManager(57);
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    int i1;
    if (((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      i1 = Integer.parseInt(((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString);
      localRichStatus.tplId = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null) {
        break label179;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0))) {
        break label174;
      }
      i1 = 0;
      label78:
      ((RichStatus)localObject).locationPosition = i1;
      if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0))) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText))) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = null;
      }
      label124:
      if (Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().encode(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode())) {
        break label198;
      }
      e(true);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.u);
    }
    label174:
    label179:
    label198:
    long l1;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 1;
      break label78;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationPosition = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = null;
      break label124;
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_c_of_type_Long <= 2000L);
    a(2131372031);
    this.jdField_c_of_type_Long = l1;
  }
  
  void d()
  {
    ReportController.b(this.app, "CliOper", "", "", "Rich_status", "Clk_what2do", 0, 0, "", "", "", "");
    startActivityForResult(new Intent(this, ActionListActivity.class), 17);
    overridePendingTransition(2130968585, 2130968589);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 17) {
        break label185;
      }
      if (this.jdField_a_of_type_AndroidContentIntent == null)
      {
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = ((int)this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId);
          RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
          if (localObject == null) {
            break label178;
          }
          localObject = ((ActionInfo)localObject).d;
          label104:
          localRichStatus.actionText = ((String)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = ((int)paramIntent.getLongExtra("k_data_id", 0L));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramIntent.getStringExtra("k_data_text");
        d(false);
      }
    }
    else
    {
      label144:
      if (paramInt1 == 17) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
      }
    }
    label178:
    label185:
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
      break;
      localObject = " ";
      break label104;
      if (paramInt1 != 18) {
        break label144;
      }
      paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
    } while (paramIntent == null);
    if (!paramIntent.b.equals("不显示")) {}
    for (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramIntent.b;; this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "")
    {
      if (paramIntent.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.latitude = paramIntent.a.a;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.lontitude = paramIntent.a.b;
      }
      c(true);
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.v = getIntent().getIntExtra("param_entry", 0);
    if (this.v == 1) {
      super.setContentView(2130904997);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      n = ((DisplayMetrics)localObject).heightPixels;
      o = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.a(13));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
        break;
      }
      a(2131368479);
      super.finish();
      return false;
      super.setContentViewNoTitle(2130904997);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
    {
      a(2131370620);
      super.finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#dedede"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131304984));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131304989);
    Object localObject = (SignatureManager)this.app.getManager(57);
    if (this.v == 1)
    {
      LayoutInflater.from(this).inflate(2130904999, this.jdField_a_of_type_AndroidWidgetLinearLayout, true);
      setTitle("交友宣言");
      this.leftView.setText(2131366637);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297195));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428306));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)super.findViewById(2131304994));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint("你想对附近的人说点什么？");
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
      paramBundle = getIntent().getByteArrayExtra("param_old_xuan_yan");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.parseStatus(paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText;
        if (paramBundle != null) {
          break label873;
        }
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = paramBundle;
      }
    }
    label873:
    for (;;)
    {
      if (paramBundle.size() < 2)
      {
        paramBundle.add(null);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
      d(false);
      if (paramBundle.get(0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(0));
      }
      if (paramBundle.get(1) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(1));
      }
      m();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131305002);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout)super.findViewById(2131299675)).setVisibility(8);
      for (;;)
      {
        this.app.a(EditActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
        this.p = SignatureManager.y;
        this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
        if (((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
        {
          a(false);
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
        }
        return true;
        LayoutInflater.from(this).inflate(2130904998, this.jdField_a_of_type_AndroidWidgetLinearLayout, true);
        j();
        a(paramBundle);
        l();
        k();
        paramBundle = super.getIntent().getStringExtra("options");
        if (!TextUtils.isEmpty(paramBundle)) {}
        try
        {
          paramBundle = new JSONObject(paramBundle).optString("templateId");
          if (!TextUtils.isEmpty(paramBundle))
          {
            ((SignatureManager)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = ((SignatureManager)localObject).b(paramBundle);
            a(((SignatureManager)localObject).e, ((SignatureManager)localObject).f);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          this.u = getIntent().getIntExtra("k_source", -1);
          super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
          ThreadManager.a(new uhl(this), 8, null, false);
          jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Long = getIntent().getLongExtra("startOpenPageTime", -1L);
          if (this.jdField_b_of_type_Long == -1L) {}
          this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.a(44));
          this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
          this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            QLog.e("EditActivity", 2, paramBundle.getMessage());
          }
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    
    if ((this.v != 1) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    }
    this.app.a(EditActivity.class);
    h();
    a(true);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((this.v == 1) || (paramIntent.getIntExtra("k_source", 4) == 4)) {
      return;
    }
    if (this.u == -1) {
      this.u = getIntent().getIntExtra("k_source", -1);
    }
    doOnActivityResult(17, -1, paramIntent);
  }
  
  protected void doOnPause()
  {
    this.jdField_c_of_type_Boolean = false;
    h();
    a(true);
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.jdField_e_of_type_Boolean = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.jdField_e_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    this.jdField_c_of_type_Boolean = true;
    if (this.v == 1) {
      g();
    }
    if (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      a(false);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
    }
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) {
      paramBundle.putByteArray("param_rich_status", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStart()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if ((localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) && (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
    super.doOnStop();
  }
  
  public void e()
  {
    ReportController.b(this.app, "CliOper", "", "", "Rich_status", "Clk_where", 0, 0, "", "", "", "");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    localUserInfo.b = this.app.b();
    QZoneHelper.c(this, localUserInfo, 18);
    overridePendingTransition(2130968585, 2130968589);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131370618, 0);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131370619, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new uhn(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new uho(this));
  }
  
  public void g()
  {
    new Handler().postDelayed(new uhp(this), 500L);
  }
  
  void h()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
      {
        localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = localSignatureManager.b(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
        j();
        k();
        if (this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter = new SigTplPagerAdapter(this.app, this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter);
        }
        if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter.a = SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length;
          this.jdField_a_of_type_ComTencentMobileqqVasSigTplPagerAdapter.notifyDataSetChanged();
        }
        if ((SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null) && (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.removeAllViews();
          int i1 = 0;
          while (i1 < SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].jdField_a_of_type_JavaLangString);
            i1 += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(localSignatureManager.e, false);
        }
        m();
        this.p = SignatureManager.y;
        this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
        continue;
        if (localSignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
        {
          a(false);
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
          continue;
          e();
        }
      }
    }
  }
  
  public void i()
  {
    int i2 = 1;
    ImageView localImageView = (ImageView)super.findViewById(2131303133);
    TextView localTextView = (TextView)super.findViewById(2131303134);
    Button localButton = (Button)super.findViewById(2131303131);
    String str1 = this.app.a();
    Object localObject = getSharedPreferences("uniPaySp_" + str1, 0);
    String str2 = ((SharedPreferences)localObject).getString("sUin", "");
    int i3 = ((SharedPreferences)localObject).getInt("isShowOpen", 0);
    int i4 = ((SharedPreferences)localObject).getInt("iUinpPayType", 0);
    QQAppInterface localQQAppInterface = (QQAppInterface)super.getAppRuntime();
    Integer.valueOf(((SharedPreferences)localObject).getString("open_month", "3")).intValue();
    localObject = getString(2131372025);
    int i1 = i2;
    if (str2 != null)
    {
      i1 = i2;
      if (str1 != null)
      {
        i1 = i2;
        if (str2.equals(str1))
        {
          if (i3 != 1) {
            break label713;
          }
          localButton.setVisibility(0);
          switch (i4)
          {
          default: 
            localButton.setVisibility(8);
            localTextView.setVisibility(8);
            localImageView.setVisibility(8);
            i1 = 1;
          }
        }
      }
    }
    for (;;)
    {
      a(localTextView, localButton);
      localButton.setOnClickListener(new uib(this, i1));
      return;
      localButton.setText(2131370381);
      localTextView.setText(getString(2131370434, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840246));
      i1 = 1;
      continue;
      localButton.setText(2131370382);
      localTextView.setText(getString(2131370435, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840246));
      i1 = 1;
      continue;
      localButton.setText(2131370381);
      localTextView.setText(getString(2131370436, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130839582));
      i1 = 2;
      continue;
      localButton.setText(2131370382);
      localTextView.setText(getString(2131370437, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130839582));
      i1 = 2;
      continue;
      localButton.setText(2131370382);
      localTextView.setText(getString(2131370441, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840247));
      i1 = 2;
      continue;
      localButton.setText(2131370383);
      localTextView.setText(getString(2131370442, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840247));
      i1 = 2;
      continue;
      localButton.setText(2131370383);
      localTextView.setText(getString(2131370438, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130839582));
      i1 = 2;
      continue;
      localButton.setText(2131370382);
      localTextView.setText(getString(2131370439, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840248));
      i1 = 1;
      continue;
      localButton.setText(2131370383);
      localTextView.setText(getString(2131370440, new Object[] { localObject }));
      localImageView.setBackgroundDrawable(getResources().getDrawable(2130840248));
      i1 = 1;
      continue;
      label713:
      localButton.setVisibility(8);
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
      i1 = 1;
    }
  }
  
  protected boolean isWrapContent()
  {
    return this.v == 1;
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_0
    //   4: iload_1
    //   5: iload_2
    //   6: aload_3
    //   7: invokespecial 1724	com/tencent/mobileqq/app/IphoneTitleBarActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpne +123 -> 135
    //   15: aload_3
    //   16: ifnull +119 -> 135
    //   19: aload_3
    //   20: ldc_w 1726
    //   23: invokevirtual 584	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w 1728
    //   31: invokevirtual 584	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_3
    //   35: new 1484	org/json/JSONObject
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 1485	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore 4
    //   45: aload 4
    //   47: ldc_w 1730
    //   50: invokevirtual 1732	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 417	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   56: istore_2
    //   57: aload 4
    //   59: ldc_w 1734
    //   62: invokevirtual 1732	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 417	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: istore_1
    //   69: aload 4
    //   71: ldc_w 1736
    //   74: invokevirtual 1732	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 417	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore 6
    //   82: iload 6
    //   84: istore 5
    //   86: aload 4
    //   88: ifnull +47 -> 135
    //   91: iload_2
    //   92: ifne +43 -> 135
    //   95: iload_1
    //   96: ifne +39 -> 135
    //   99: iload 5
    //   101: ifne +34 -> 135
    //   104: invokestatic 1742	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   107: invokestatic 1290	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   110: ifne +25 -> 135
    //   113: aload_0
    //   114: invokevirtual 1021	com/tencent/mobileqq/richstatus/EditActivity:getApplicationContext	()Landroid/content/Context;
    //   117: aload_0
    //   118: invokevirtual 803	com/tencent/mobileqq/richstatus/EditActivity:getBaseContext	()Landroid/content/Context;
    //   121: ldc_w 1743
    //   124: invokevirtual 1688	android/content/Context:getString	(I)Ljava/lang/String;
    //   127: iconst_0
    //   128: invokestatic 1746	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   131: invokevirtual 1749	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   134: pop
    //   135: return
    //   136: astore_3
    //   137: iconst_m1
    //   138: istore_2
    //   139: aconst_null
    //   140: astore 4
    //   142: iconst_m1
    //   143: istore_1
    //   144: aload_3
    //   145: invokevirtual 1752	java/lang/Exception:printStackTrace	()V
    //   148: goto -62 -> 86
    //   151: astore_3
    //   152: iconst_m1
    //   153: istore_1
    //   154: iconst_m1
    //   155: istore_2
    //   156: goto -12 -> 144
    //   159: astore_3
    //   160: iconst_m1
    //   161: istore_1
    //   162: goto -18 -> 144
    //   165: astore_3
    //   166: goto -22 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	EditActivity
    //   0	169	1	paramInt1	int
    //   0	169	2	paramInt2	int
    //   0	169	3	paramIntent	Intent
    //   43	98	4	localJSONObject	JSONObject
    //   1	99	5	i1	int
    //   80	3	6	i2	int
    // Exception table:
    //   from	to	target	type
    //   35	45	136	java/lang/Exception
    //   45	57	151	java/lang/Exception
    //   57	69	159	java/lang/Exception
    //   69	82	165	java/lang/Exception
  }
  
  protected boolean onBackEvent()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.v == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength() > 47)
      {
        a(2131370622);
        return true;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
      setResult(-1, localIntent);
      super.finish();
      return super.onBackEvent();
    }
    if ((jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      n();
      return true;
    }
    o();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    switch (paramView.getId())
    {
    default: 
      if (paramView.getId() != 2131304994) {
        h();
      }
      break;
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
            b();
            return;
          } while (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1300L);
          h();
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText)) {
            e();
          }
          for (;;)
          {
            ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_pnt", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
              f();
            }
            this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          }
        } while (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 1300L);
        h();
        d();
      } while ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId != 0) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText.equals(getResources().getString(2131372035))));
      ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_do", 0, 0, "", "", "", "");
      return;
      if (getIntent().getStringExtra("k_taskId") == null) {}
      for (paramView = "";; paramView = getIntent().getStringExtra("k_taskId"))
      {
        ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_his", 0, 0, "0", "", "", "");
        StatusHistoryActivity.a(this, this.app.a(), this.app.b(), 0, paramView);
        return;
      }
    } while (System.currentTimeMillis() - this.jdField_f_of_type_Long <= 1300L);
    a(2131372036);
    this.jdField_f_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\EditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
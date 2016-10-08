package cooperation.qzone.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import ypb;
import ypc;
import ypd;
import ype;
import ypf;
import ypg;
import yph;
import ypi;
import ypj;
import ypk;
import ypl;
import ypm;

public class QZoneShareActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "QZoneShare";
  public static final String b = "extraIntentKeyParcelable";
  public static final String c = "contentIntentKey";
  public static final String d = "showaticon";
  public static final String e = "showemotionicon";
  public static final String f = "inputmax";
  public static final String g = "extraRequestCode";
  public static final String h = QZoneShareActivity.class.getSimpleName();
  private static final String n = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
  private static final String o = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
  public int a;
  public View a;
  protected InputMethodManager a;
  public EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public SystemEmoticonPanel a;
  private QZoneShareData jdField_a_of_type_CooperationQzoneQZoneShareData;
  public List a;
  public boolean a;
  private int jdField_b_of_type_Int;
  protected View b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private int jdField_c_of_type_Int = 1;
  public View c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private int d;
  public boolean d;
  private int e;
  protected boolean e;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = true;
  private int g;
  private String i = "";
  private String j;
  private String k;
  private String l;
  private String m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneShareActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = -1;
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    return InputViewPanelControl.a(paramCharSequence, paramInt, this.g, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.i);
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return "";
    }
    paramEditText = paramEditText.getText();
    if ((paramEditText instanceof QQTextBuilder)) {
      return ((QQTextBuilder)paramEditText).a();
    }
    return paramEditText.toString();
  }
  
  public static String a(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  private void a(Activity paramActivity, QZoneShareData paramQZoneShareData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramQZoneShareData == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramQZoneShareData.h)) {
      paramQZoneShareData.h = "shareToQzone";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramQZoneShareData.jdField_a_of_type_Long + " action=" + paramQZoneShareData.h);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramQZoneShareData.jdField_a_of_type_Long), paramQZoneShareData.h })));
    }
    for (;;)
    {
      localIntent.setPackage(paramQZoneShareData.i);
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        QLog.e("QZoneShare", 1, paramActivity.getStackTrace());
        return;
      }
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramQZoneShareData.jdField_a_of_type_Long), paramQZoneShareData.h })));
    }
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return InputViewPanelControl.a(paramString, paramBoolean, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.i);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_Boolean) && (!paramBoolean))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void k()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_CooperationQzoneQZoneShareData = ((QZoneShareData)localIntent.getParcelableExtra("extraIntentKeyParcelable"));
    Object localObject;
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null)
    {
      if ((this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            this.k = str;
          }
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.b)) {
        break label250;
      }
      localObject = null;
      this.l = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.c)) {
        break label264;
      }
      localObject = null;
      label125:
      this.m = ((String)localObject);
      if ((!TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.m)))
      {
        if (!this.l.equals(this.m)) {
          break label278;
        }
        this.m = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "params: " + this.jdField_a_of_type_CooperationQzoneQZoneShareData.toString());
      }
      this.j = localIntent.getStringExtra("qzone_uin");
      if (TextUtils.isEmpty(this.j)) {
        this.j = BaseApplicationImpl.a().a().getAccount();
      }
      a(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      return;
      label250:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.b.trim();
      break;
      label264:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.c.trim();
      break label125;
      label278:
      if (this.l.length() > 20)
      {
        localObject = this.l.substring(0, 20);
        if (this.m.startsWith((String)localObject)) {
          this.m = null;
        }
      }
    }
  }
  
  private void l()
  {
    setContentView(2130904672);
    setLeftButton(2131367214, new ypb(this));
    setRightButton(2131367215, new ypf(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303452));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131303690));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131303923));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131303924));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303926));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303927));
    a();
    this.jdField_b_of_type_AndroidViewView = findViewById(2131303930);
    c();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303929));
    e();
    d();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303931));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void m()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (TextUtils.isEmpty(this.l))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.m);
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
      localObject = getResources().getDrawable(2130842112);
      if (TextUtils.isEmpty(this.k)) {
        break label244;
      }
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      if (!a(this.k)) {
        break label225;
      }
    }
    label225:
    for (Object localObject = URLDrawable.getDrawable(this.k, localURLDrawableOptions);; localObject = URLDrawable.getDrawable(new File(this.k), localURLDrawableOptions))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      return;
      if (TextUtils.isEmpty(this.m))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.m);
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
      break;
    }
    label244:
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void n()
  {
    if (b() > a())
    {
      QQToast.a(this, 4, 2131366670, 0).a();
      return;
    }
    g();
    String str = a();
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_CooperationQzoneQZoneShareData.f);
      Object localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!a((String)((ArrayList)localObject).get(0))))
      {
        i1 = 0;
        if (i1 != 0)
        {
          localObject = new NewIntent(this, QzoneShareServlet.class);
          ((NewIntent)localObject).putExtra("reason", str);
          ((NewIntent)localObject).putExtra("uin", l1);
          ((NewIntent)localObject).putExtra("sharedata", this.jdField_a_of_type_CooperationQzoneQZoneShareData);
          BaseApplicationImpl.a().a().startServlet((NewIntent)localObject);
          QLog.e("QZoneShare", 1, "startShare()");
          if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.g != 1) {
            break label204;
          }
          a(this, this.jdField_a_of_type_CooperationQzoneQZoneShareData, true);
          setResult(-1, null);
          finish();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        ThreadManager.a(new ypg(this, localException, str), null, false);
        continue;
        label204:
        QQToast.a(this, 5, "已分享", 0).a();
        continue;
        int i1 = 1;
      }
    }
  }
  
  private void o()
  {
    this.i = "";
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    return QzoneConfig.a().a("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  protected View a()
  {
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  protected final String a()
  {
    return InputViewPanelControl.a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_JavaUtilList);
  }
  
  protected final void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = InputViewPanelControl.a(this, this.jdField_a_of_type_AndroidWidgetEditText);
      b();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    a(paramIntent.getParcelableArrayListExtra("result_set"));
  }
  
  public final void a(Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    paramQZoneShareData = new ype(this, paramActivity, paramQZoneShareData);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setMessage(2131364481);
    localQQCustomDialog.setTitle(2131364602);
    localQQCustomDialog.setNegativeButton(2131367262, paramQZoneShareData);
    localQQCustomDialog.setPositiveButton(2131364482, paramQZoneShareData);
    localQQCustomDialog.setCancelable(false);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("QZoneShare", 1, paramActivity.toString());
    }
  }
  
  public void a(QZoneShareData paramQZoneShareData)
  {
    if (paramQZoneShareData == null) {}
    label4:
    Object localObject;
    String str;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while ((paramQZoneShareData.g != 1) || ("login".equals(paramQZoneShareData.j)));
          localObject = paramQZoneShareData.f;
          str = paramQZoneShareData.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        } while (((String)localObject).equals(this.j));
        a(this, paramQZoneShareData);
        return;
      } while (TextUtils.isEmpty(str));
      localObject = new ypd(this, str, paramQZoneShareData);
      localObject = QZoneShareManager.a(BaseApplicationImpl.a().a(), String.valueOf(paramQZoneShareData.jdField_a_of_type_Long), (BusinessObserver)localObject);
    } while ((localObject == null) || (((OpenID)localObject).openID == null) || (((OpenID)localObject).openID.equals(str)));
    a(this, paramQZoneShareData);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    this.g = InputViewPanelControl.a(this.jdField_a_of_type_AndroidWidgetEditText, paramArrayList, this.jdField_a_of_type_JavaUtilList, this.g);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    a(paramBoolean);
    a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    while (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    b(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842735);
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      }
      this.jdField_e_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      return a(a(this.jdField_a_of_type_AndroidWidgetEditText)).length();
    }
    return 0;
  }
  
  protected void b()
  {
    Object localObject = a();
    if ((localObject instanceof RelativeLayout))
    {
      localObject = (RelativeLayout)localObject;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904735, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.jdField_c_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904695, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(150.0F * ViewUtils.a()));
      localLayoutParams2.addRule(3, this.jdField_a_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams2);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundColor(getResources().getColor(2131428053));
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      this.jdField_b_of_type_Int = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new yph(this, (RelativeLayout)localObject));
    }
  }
  
  protected boolean b()
  {
    return a(false);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ypi(this));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ypj(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ypk(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "doOnCreate()");
    }
    if (getIntent() == null)
    {
      QLog.e("QZoneShare", 1, "onCreate getIntent is null");
      finish();
    }
    getWindow().setSoftInputMode(3);
    l();
    k();
    m();
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        a();
        return true;
      }
      j();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      ThreadManager.c().postDelayed(new ypc(this), 300L);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ypl(this));
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    while (this.jdField_d_of_type_Boolean) {
      return;
    }
    b();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_d_of_type_Boolean = true;
    ThreadManager.c().postDelayed(new ypm(this), 100L);
  }
  
  protected void g()
  {
    a(true);
  }
  
  public void h()
  {
    if (!this.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void i()
  {
    int i1 = b() - a();
    if (i1 > 0)
    {
      str = "超出" + i1 + "个字";
      i1 = getResources().getColor(2131428010);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(this, 2131366670, 0).a();
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8)
    {
      String str;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void j()
  {
    g();
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.g == 1) {
      a(this, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    }
    setResult(0, new Intent());
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\share\QZoneShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
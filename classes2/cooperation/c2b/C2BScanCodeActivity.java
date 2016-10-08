package cooperation.c2b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.BaseActivity;
import xyx;
import xyy;
import xyz;
import xza;

public class C2BScanCodeActivity
  extends BaseActivity
  implements ScannerView.ScannerListener
{
  public static final int a = 1;
  public static String a;
  public static boolean a = false;
  public static final int b = 2;
  public static final String b = "scanStr";
  public static final int c = 0;
  public static final String c = "from_other";
  public static final int d = 3;
  private static final String d = "HYScanCodeActivity";
  private static final int g = 200;
  private static final int h = 640;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private ScannerView jdField_a_of_type_ComTencentBizWidgetsScannerView;
  protected Runnable a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  int e = 1;
  int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "isSucess";
  }
  
  public C2BScanCodeActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new xyz(this);
  }
  
  public Rect a()
  {
    int i = 640;
    int m;
    int j;
    int k;
    int n;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      m = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getWidth();
      j = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getHeight();
      k = j;
      if (!this.jdField_b_of_type_Boolean)
      {
        k = (int)(getResources().getDisplayMetrics().density * 110.0F + 0.5D);
        k = j - this.f - k;
      }
      n = Math.min(m, k);
      j = n * 5 / 7;
      if (j >= 200) {
        break label191;
      }
      i = Math.min(n, 200);
      n = (m - i) / 2;
      j = getResources().getDimensionPixelSize(2131494758);
      if (getResources().getDisplayMetrics().heightPixels <= 854) {
        j = getResources().getDimensionPixelSize(2131494759);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (m > j) {
        break label203;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setHeight(j);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, j, n + i, i + j);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label191:
      if (j > 640) {
        break;
      }
      i = j;
      break;
      label203:
      if (m <= k - i) {
        j = m;
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void a(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a != null)
    {
      int i;
      Intent localIntent;
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a.toString().equalsIgnoreCase("QR_CODE"))
      {
        i = 2;
        if ((this.e != i) && ((this.e == 1) || (this.e == 2))) {
          break label275;
        }
        localIntent = new Intent(super.getIntent());
        String str = super.getIntent().getStringExtra("destaction");
        localIntent.putExtra("scanStr", paramString);
        if ((str == null) || (str.length() <= 0) || (str.equals(super.getIntent().getAction()))) {
          break label226;
        }
        localIntent = new Intent(str);
        localIntent.putExtras(super.getIntent());
        localIntent.putExtra("scanStr", paramString);
        localIntent.setPackage(getPackageName());
        sendBroadcast(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("HYScanCodeActivity", 2, "onScanSucceed sendBroadcast:dest action = " + str + ",scanType=" + this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a.toString());
        }
      }
      for (;;)
      {
        super.finish();
        return;
        i = 1;
        break;
        label226:
        setResult(-1, localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("HYScanCodeActivity", 2, "onScanSucceed setResult,scanType = " + this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a.toString());
        }
      }
    }
    label275:
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364426);
    if (QLog.isColorLevel()) {
      QLog.d("HYScanCodeActivity", 2, "onCameraError");
    }
  }
  
  public void c()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void d()
  {
    Object localObject = getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(2131494760);
    if (((Resources)localObject).getDisplayMetrics().heightPixels <= 854) {
      i = ((Resources)localObject).getDimensionPixelSize(2131494761);
    }
    int j = i;
    if (this.e != 1)
    {
      j = i;
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        j = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      }
    }
    i = ((Resources)localObject).getDimensionPixelSize(2131494752) + j;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.topMargin = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    i = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getBottom() - ((Resources)localObject).getDimensionPixelSize(2131494755) - 20 - i;
    this.jdField_a_of_type_AndroidWidgetImageView.setMaxHeight(i);
    if (i < this.jdField_a_of_type_AndroidWidgetImageView.getHeight())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903567);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)super.findViewById(2131299270));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299274));
    this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299275));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299273));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131299272);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299271));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299276));
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("from_other", false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299278));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new xyx(this));
    paramBundle = getResources().getDisplayMetrics();
    Object localObject;
    if (paramBundle.heightPixels <= 854)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131494757);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new Rect();
      int i = getResources().getDimensionPixelSize(2131494762);
      ((Rect)localObject).left = i;
      ((Rect)localObject).right = (paramBundle.widthPixels - i);
      ((Rect)localObject).top = getResources().getDimensionPixelSize(2131494759);
      ((Rect)localObject).bottom = (((Rect)localObject).top + getResources().getDimensionPixelSize(2131494763));
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setViewFinder(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
    }
    this.f = getResources().getDimensionPixelOffset(2131492908);
    paramBundle = super.getIntent().getExtras();
    if (paramBundle != null)
    {
      this.e = paramBundle.getInt("dimension");
      if (this.e != 1) {
        break label579;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new xza(this, null), 200L);
    }
    for (;;)
    {
      localObject = paramBundle.getString("tipText");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramBundle = paramBundle.getString("tipImg");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {}
      try
      {
        paramBundle = new URL(paramBundle);
        if (paramBundle != null)
        {
          if (!jdField_a_of_type_Boolean)
          {
            new InitUrlDrawable().c();
            jdField_a_of_type_Boolean = true;
          }
          localObject = getResources().getDrawable(2130839088);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseAutoScaleParams = false;
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
          paramBundle = URLDrawable.getDrawable(paramBundle, localURLDrawableOptions);
          paramBundle.setURLDrawableListener(new xyy(this));
          if (paramBundle.getStatus() == 1) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
          }
        }
        else
        {
          if (!super.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364425);
          }
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = C2BDestoryReceiver.a(this, super.getIntent());
          return;
          label579:
          if (this.e == 2)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText("将取景框对准二维码即可自动扫描");
            this.jdField_a_of_type_ComTencentBizWidgetsScannerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
            continue;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText("将取景框对准二维码/条形码即可自动扫描");
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
        }
      }
      catch (MalformedURLException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HYScanCodeActivity", 2, paramBundle.getMessage(), paramBundle);
          }
          paramBundle = null;
          continue;
          if (NetworkUtil.i(BaseApplication.getContext()))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
            paramBundle.startDownload();
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    C2BDestoryReceiver.a(this, this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void onPause()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
    Process.setThreadPriority(0);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BScanCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
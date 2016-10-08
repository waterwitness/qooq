package com.tencent.biz.qrcode.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.chirp.PCMRecorder.OnQQRecorderListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.QWalletHelper;
import jcj;
import jck;
import jcl;
import jcm;
import jcn;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WtloginHelper;

public class ScannerActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ScannerView.FileDecodeListener, ScannerView.ScannerListener, PCMRecorder.OnQQRecorderListener, ChirpSoHandler.Callback
{
  protected static final int a = 200;
  protected static final String a = "QrcodeScanner";
  protected static final int b = 640;
  protected static final String b = "Olympic.ScannerActivity";
  protected static final int c = 0;
  protected static final String c = "hasShowGuide";
  protected static final int d = 1;
  protected static final String d = "^mecard.*";
  protected static final int e = 2;
  protected static final String e = "^begin:vcard[\\s\\S]*end:vcard";
  protected static final String f = "^bizcard.*;;$";
  public static final String g = "issupportwpa";
  public static int h = 0;
  public static final String h = "exttype";
  public static final int i = 1;
  public static final String i = "extvalue";
  public static final int j = 2;
  public static final String j = "scanForResult";
  public static final int k = 3;
  public static final String k = "from";
  public static final int l = 10;
  public static final String l = "finishAfterSucc";
  public static final int m = 11;
  public static final int n = 12;
  public static String n;
  private static final int jdField_o_of_type_Int = 291;
  private static final int jdField_p_of_type_Int = 292;
  private static final String jdField_p_of_type_JavaLangString = "key_first_enter_voice_qrcode";
  private static final int jdField_q_of_type_Int = 293;
  private static final String jdField_q_of_type_JavaLangString = "不用对准二维码，最新版QQ扫描声波也可加好友";
  private static final int jdField_r_of_type_Int = 294;
  private static final String jdField_r_of_type_JavaLangString = "请升级至最新版QQ，重新打开扫一扫";
  private static final int s = 295;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected SharedPreferences a;
  protected Rect a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  protected TextView a;
  public ScannerView a;
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  public ScannerResultReceiver a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected Runnable a;
  protected WtloginHelper a;
  protected boolean a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_b_of_type_AndroidOsHandler;
  protected View b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected TextView b;
  protected boolean b;
  private View c;
  protected TextView c;
  protected boolean c;
  private View d;
  protected TextView d;
  protected boolean d;
  private TextView e;
  protected boolean e;
  protected int f;
  private TextView f;
  public boolean f;
  protected int g;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  boolean j = false;
  public boolean k = true;
  public boolean l;
  protected String m;
  public boolean m;
  public boolean n;
  protected String o;
  private boolean jdField_o_of_type_Boolean;
  private boolean jdField_p_of_type_Boolean;
  private boolean jdField_q_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_n_of_type_JavaLangString = "addDisSource";
    jdField_h_of_type_Int = 1;
  }
  
  public ScannerActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new jcj(this);
  }
  
  private static void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      paramArrayOfShort[i1] = ((short)(paramArrayOfByte[(i1 * 2)] & 0xFF | paramArrayOfByte[(i1 * 2 + 1)] << 8 & 0xFF00));
      i1 += 1;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, "sendBroadcastToToolProc");
    }
    Intent localIntent = new Intent(this, NearbyReceiver.class);
    localIntent.putExtra("resultreceiver_nearbyfakeactivity", this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver);
    localIntent.setExtrasClassLoader(getClassLoader());
    try
    {
      sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "sendBroadcastToToolProc, exception=", localThrowable.getMessage(), localThrowable });
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "initAr, mNeedLandScape=", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    if (this.jdField_m_of_type_Boolean) {}
    ArResourceManager localArResourceManager;
    do
    {
      do
      {
        return;
        this.jdField_m_of_type_Boolean = true;
      } while ((this.app == null) || (this.jdField_e_of_type_Boolean));
      localArResourceManager = (ArResourceManager)this.app.getManager(167);
    } while (localArResourceManager == null);
    Object localObject = localArResourceManager.a();
    ARDeviceController.a().a((ArEffectConfig)localObject);
    localObject = ARDeviceController.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ScannerActivity", 2, "gpu= " + (String)localObject);
    }
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = localArResourceManager.a();
    int i1;
    if ((!bool1) && (ARDeviceController.a().b()) && (bool2))
    {
      localObject = (EarlyDownloadManager)this.app.getManager(76);
      if (localObject != null)
      {
        localObject = (ArNativeSoDownloadHandler)((EarlyDownloadManager)localObject).a("qq.android.ar.native.so");
        if (localObject != null)
        {
          i1 = ((ArNativeSoDownloadHandler)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("QrcodeScanner", 2, "version= " + ((ArNativeSoDownloadHandler)localObject).a());
          }
          if ((!((ArNativeSoDownloadHandler)localObject).j()) || (i1 <= 1)) {
            ((ArNativeSoDownloadHandler)localObject).a(true);
          }
        }
      }
    }
    if (((bool2) && (bool1)) || (ScanTorchActivity.jdField_b_of_type_Boolean))
    {
      QLog.d("Olympic.ScannerActivity", 1, "initAr, show ar = true");
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        i1 = AIOUtils.a(55.0F, getResources());
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840981);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(localArResourceManager.a().scanIconImg, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840982);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(localArResourceManager.a().scanIconPressed, (URLDrawable.URLDrawableOptions)localObject);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(new jcm(this));
          if (this.jdField_f_of_type_AndroidWidgetTextView != null)
          {
            if ((localArResourceManager.a() == null) || (TextUtils.isEmpty(localArResourceManager.a().scanIconText))) {
              this.jdField_f_of_type_AndroidWidgetTextView.setText("QQ-AR");
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
            this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver = new ScannerResultReceiver(null);
            if (NearbyFakeActivity.a()) {
              break;
            }
            e();
            return;
            localThrowable1 = localThrowable1;
            if (QLog.isColorLevel()) {
              QLog.i("Olympic.ScannerActivity", 2, "initAr,", localThrowable1);
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
          }
        }
        catch (Throwable localThrowable2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Olympic.ScannerActivity", 2, "initAr,", localThrowable2);
          }
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
          continue;
          this.jdField_f_of_type_AndroidWidgetTextView.setText(localArResourceManager.a().scanIconText);
          continue;
        }
      }
      QLog.d("Olympic.ScannerActivity", 1, new Object[] { "initAr, show ar = false, isShowArPort=", Boolean.valueOf(bool2), ", deviceSupport=", Boolean.valueOf(bool1), ", ScanTorchActivity.specialTestOn=", Boolean.valueOf(ScanTorchActivity.jdField_b_of_type_Boolean) });
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, "showArProgress");
    }
    if (this.jdField_o_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_o_of_type_Boolean = true;
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("Olympic.ScannerActivity", 2, localException.toString());
  }
  
  private void h()
  {
    this.app.E();
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "enableTalkBack = " + AppSetting.j);
    }
    boolean bool;
    if ((AppSetting.j) && (this.p))
    {
      bool = ChirpWrapper.a();
      if (QLog.isColorLevel()) {
        QLog.d("QrcodeScanner", 2, "isSoLoaded " + bool);
      }
      if (bool) {
        break label143;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.system.chirp"));
      }
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(this);
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(true);
    }
    label143:
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AudioHelper.b(1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QrcodeScanner", 2, "checkInitVoiceScan, permission is forbidden, " + this.q);
            }
          } while (this.q);
          BaseApplicationImpl.a.post(new jcn(this));
          return;
          if (!this.app.d()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QrcodeScanner", 2, "isVedioChatting");
        return;
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_enter_voice_qrcode" + this.app.a(), true);
        if (QLog.isColorLevel()) {
          QLog.d("QrcodeScanner", 2, "checkInitVoiceScan, isFirst = " + bool);
        }
        if (bool)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_enter_voice_qrcode" + this.app.a(), false).commit();
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(295, 2000L);
        }
      } while (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null);
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = new ChirpWrapper();
      i1 = this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      if (i1 == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QrcodeScanner", 2, "decode chirp init failed = " + i1);
    return;
    this.jdField_a_of_type_ComTencentChirpPCMRecorder = new PCMRecorder(this, 44100, this);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder != null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = null;
    }
    if (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null) {
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = null;
    }
  }
  
  public Rect a()
  {
    int i1 = 640;
    int i5;
    int i4;
    int i2;
    int i3;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      i5 = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getWidth();
      i4 = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getHeight();
      i2 = 0;
      i3 = i4;
      if (!this.jdField_e_of_type_Boolean)
      {
        i3 = (int)(getResources().getDisplayMetrics().density * 100.0F + 0.5D);
        i2 = this.jdField_f_of_type_Int;
        i3 = i4 - i2 - i3;
      }
      int i6 = Math.min(i5, i3);
      i4 = i6 * 5 / 7;
      if (i4 >= 200) {
        break label206;
      }
      i1 = Math.min(i6, 200);
    }
    for (;;)
    {
      i4 = (i5 - i1) / 2;
      i3 = (i3 - i1) / 2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i4, i3 + i2, i4 + i1, i2 + (i3 + i1));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.topMargin = (AIOUtils.a(15.0F, getResources()) + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label206:
      if (i4 <= 640) {
        i1 = i4;
      }
    }
  }
  
  public void a()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    if ("qlink".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366349);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131366350);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
      }
      if ((this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a() == null) || (!this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.post(new jck(this));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364424);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "record error = " + paramInt);
    }
    i();
  }
  
  public void a(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    b(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "launchAr, launchDirect=", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this, ScanTorchActivity.class);
      localIntent.addFlags(67108864);
      localIntent.addFlags(65536);
      localIntent.putExtra("click_time", this.jdField_a_of_type_Long);
      localIntent.putExtra("first_click", this.k);
      localIntent.putExtra("proc_exist", this.l);
      this.k = false;
      localIntent.putExtra("log_on", ScanTorchActivity.jdField_a_of_type_Boolean);
      ArResourceManager localArResourceManager = (ArResourceManager)this.app.getManager(167);
      if (localArResourceManager != null)
      {
        if ((localArResourceManager.a() != null) && (!TextUtils.isEmpty(localArResourceManager.a().scanIconText))) {
          break label231;
        }
        localIntent.putExtra("icon_text", "QQ-AR");
      }
      for (;;)
      {
        if ((localArResourceManager.a() != null) && (localArResourceManager.a().scanIconPressed != null)) {
          localIntent.putExtra("icon_url", localArResourceManager.a().scanIconPressed);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(292, 1000L);
        startActivityForResult(localIntent, 10);
        return;
        label231:
        localIntent.putExtra("icon_text", localArResourceManager.a().scanIconText);
      }
    }
    this.jdField_n_of_type_Boolean = true;
    g();
    e();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 5000L);
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: arraylength
    //   4: iconst_2
    //   5: idiv
    //   6: newarray <illegal type>
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: invokestatic 696	com/tencent/biz/qrcode/activity/ScannerActivity:a	([B[S)V
    //   14: aload_0
    //   15: getfield 520	com/tencent/biz/qrcode/activity/ScannerActivity:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   18: aload_2
    //   19: bipush 15
    //   21: invokevirtual 699	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 366	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +277 -> 306
    //   32: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +29 -> 64
    //   38: ldc 22
    //   40: iconst_2
    //   41: new 237	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 701
    //   51: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: ldc_w 703
    //   68: invokevirtual 706	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +225 -> 296
    //   74: iload_3
    //   75: aload_1
    //   76: invokevirtual 709	java/lang/String:length	()I
    //   79: if_icmpge +20 -> 99
    //   82: aload_1
    //   83: iload_3
    //   84: invokevirtual 713	java/lang/String:charAt	(I)C
    //   87: bipush 48
    //   89: if_icmpne +10 -> 99
    //   92: iload_3
    //   93: iconst_1
    //   94: iadd
    //   95: istore_3
    //   96: goto -22 -> 74
    //   99: aload_1
    //   100: iload_3
    //   101: invokevirtual 717	java/lang/String:substring	(I)Ljava/lang/String;
    //   104: astore_1
    //   105: aload_1
    //   106: invokestatic 723	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   109: pop2
    //   110: ldc_w 725
    //   113: invokestatic 727	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   116: ldc2_w 728
    //   119: invokestatic 735	java/lang/Thread:sleep	(J)V
    //   122: aload_1
    //   123: ifnull +27 -> 150
    //   126: ldc_w 737
    //   129: aload_1
    //   130: invokevirtual 741	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifne +17 -> 150
    //   136: aload_0
    //   137: getfield 212	com/tencent/biz/qrcode/activity/ScannerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: invokevirtual 489	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   143: aload_1
    //   144: invokevirtual 741	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifeq +61 -> 208
    //   150: new 743	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   153: dup
    //   154: aload_0
    //   155: getfield 212	com/tencent/biz/qrcode/activity/ScannerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 489	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   161: iconst_0
    //   162: invokespecial 746	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   165: astore_1
    //   166: aload_0
    //   167: aload_1
    //   168: invokestatic 751	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   171: aload_0
    //   172: getfield 212	com/tencent/biz/qrcode/activity/ScannerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   175: ldc_w 753
    //   178: ldc_w 737
    //   181: ldc_w 737
    //   184: ldc_w 755
    //   187: ldc_w 755
    //   190: iconst_0
    //   191: iconst_0
    //   192: ldc_w 737
    //   195: ldc_w 737
    //   198: ldc_w 737
    //   201: ldc_w 737
    //   204: invokestatic 760	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   207: return
    //   208: aload_0
    //   209: getfield 212	com/tencent/biz/qrcode/activity/ScannerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: bipush 50
    //   214: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   217: checkcast 762	com/tencent/mobileqq/app/FriendsManager
    //   220: aload_1
    //   221: invokevirtual 765	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   224: astore_2
    //   225: aload_2
    //   226: ifnull +57 -> 283
    //   229: aload_2
    //   230: invokevirtual 770	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   233: ifeq +50 -> 283
    //   236: new 743	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   239: dup
    //   240: aload_1
    //   241: iconst_1
    //   242: invokespecial 746	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   245: astore_1
    //   246: aload_1
    //   247: aload_2
    //   248: getfield 773	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   251: putfield 775	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   254: aload_1
    //   255: aload_2
    //   256: getfield 778	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   259: putfield 780	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:i	Ljava/lang/String;
    //   262: goto -96 -> 166
    //   265: astore_1
    //   266: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +37 -> 306
    //   272: ldc 22
    //   274: iconst_2
    //   275: ldc_w 737
    //   278: aload_1
    //   279: invokestatic 782	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: return
    //   283: new 743	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   286: dup
    //   287: aload_1
    //   288: iconst_3
    //   289: invokespecial 746	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   292: astore_1
    //   293: goto -127 -> 166
    //   296: ldc 79
    //   298: invokestatic 727	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   301: return
    //   302: astore_2
    //   303: goto -181 -> 122
    //   306: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	ScannerActivity
    //   0	307	1	paramArrayOfByte	byte[]
    //   8	248	2	localObject	Object
    //   302	1	2	localException	Exception
    //   1	100	3	i1	int
    // Exception table:
    //   from	to	target	type
    //   105	116	265	java/lang/Exception
    //   126	150	265	java/lang/Exception
    //   150	166	265	java/lang/Exception
    //   166	207	265	java/lang/Exception
    //   208	225	265	java/lang/Exception
    //   229	262	265	java/lang/Exception
    //   283	293	265	java/lang/Exception
    //   116	122	302	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364426);
  }
  
  protected void b(String paramString)
  {
    Object localObject = getIntent().getStringExtra("from");
    if (PublicAccountManager.class.getName().equals(localObject))
    {
      localObject = new Intent("com.tencent.biz.pubaccount.scanResultAction");
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        if (!this.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_JavaLangStringBuilder.toString().equalsIgnoreCase("QR_CODE")) {
          break label122;
        }
        ((Intent)localObject).putExtra("com.tencent.biz.pubaccount.scanResultType", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("com.tencent.biz.pubaccount.scanResultData", paramString);
      sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      if (!this.j) {
        break;
      }
      getIntent().putExtra("scanResult", paramString);
      setResult(-1, getIntent());
      finish();
      return;
      label122:
      ((Intent)localObject).putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
    }
    ScannerUtils.a(Boolean.valueOf(this.i), Boolean.valueOf(this.jdField_h_of_type_Boolean), paramString, this, this.app, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentBizWidgetsScannerView, this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "hideArProgress, usingHandler=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(292).sendToTarget();
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            this.jdField_o_of_type_Boolean = false;
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("Olympic.ScannerActivity", 2, localException.toString());
  }
  
  public void c()
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
  }
  
  public void c(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    b(paramString);
  }
  
  public void d()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131364432);
    jcl localjcl = new jcl(this);
    localQQCustomDialog.setPositiveButton(2131367263, localjcl);
    localQQCustomDialog.setOnCancelListener(localjcl);
    localQQCustomDialog.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
    case 1: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("retdata");
      } while (TextUtils.isEmpty(paramIntent));
      QWalletHelper.a(this, paramIntent);
      return;
    case 2: 
      finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "doOnActivityResult, requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 11: 
      finish();
      return;
    }
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((!this.jdField_b_of_type_Boolean) && (paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("qrcode", 0);
    this.jdField_e_of_type_Boolean = ScannerUtils.a(this, this.jdField_a_of_type_AndroidContentSharedPreferences);
    if (this.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrcodeScanner", 2, "needLandScapeMode");
      }
      if (getRequestedOrientation() != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        setRequestedOrientation(0);
      }
      super.setContentView(2130903785);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300072);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299271));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300061));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300062));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300059));
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)findViewById(2131299270));
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300070));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300067));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300071));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300068));
        this.jdField_c_of_type_AndroidViewView = findViewById(2131300069);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131300066);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setFileDecodeListener(this);
      this.jdField_f_of_type_Int = getResources().getDimensionPixelOffset(2131492908);
      this.jdField_g_of_type_Int = getResources().getDimensionPixelOffset(2131493126);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      paramBundle = getIntent();
      this.jdField_o_of_type_JavaLangString = paramBundle.getStringExtra("from");
      if (!"addcontacts".equals(this.jdField_o_of_type_JavaLangString)) {
        break label842;
      }
      StatisticCollector.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
      label384:
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("hasShowGuide", false);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("QRDecode", false);
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_Boolean == true) {
        bool = true;
      }
      if ((bool) || ("qlink".equalsIgnoreCase(this.jdField_o_of_type_JavaLangString))) {
        break label1021;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2130903779, null);
      addContentView(this.jdField_b_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_b_of_type_AndroidViewView.findViewById(2131300047).setOnClickListener(this);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297083);
      String str = getIntent().getExtras().getString("leftViewText");
      if (!TextUtils.isEmpty(str)) {
        localTextView.setText(str);
      }
      str = paramBundle.getStringExtra("assignBackText");
      if (!TextUtils.isEmpty(str)) {
        localTextView.setText(str);
      }
      localTextView.setOnClickListener(this);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297139)).setText(2131364389);
    }
    for (;;)
    {
      findViewById(2131297083).setOnClickListener(this);
      if (AppSetting.j) {
        findViewById(2131297083).setContentDescription("返回 按钮");
      }
      ((TextView)findViewById(2131297139)).setText(2131364389);
      if ("qlink".equalsIgnoreCase(getIntent().getStringExtra("from")))
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        ((TextView)findViewById(2131297139)).setText(2131366348);
      }
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Boolean = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364425);
      }
      this.jdField_m_of_type_JavaLangString = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (this.jdField_m_of_type_JavaLangString != null) {
        this.jdField_f_of_type_Boolean = true;
      }
      this.jdField_h_of_type_Boolean = paramBundle.getBooleanExtra("scanForResult", false);
      this.i = paramBundle.getBooleanExtra("finishAfterSucc", false);
      f();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
      return true;
      super.setContentView(2130903784);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300063));
      break;
      label842:
      if ("ImagePreviewActivity".equals(this.jdField_o_of_type_JavaLangString))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
        break label384;
      }
      if ("Conversation".equals(this.jdField_o_of_type_JavaLangString))
      {
        this.p = true;
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
        break label384;
      }
      if (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
        break label384;
      }
      if ("publicAccountNew".equals(this.jdField_o_of_type_JavaLangString))
      {
        this.j = true;
        break label384;
      }
      if (ScanTorchActivity.class.getSimpleName().equals(this.jdField_o_of_type_JavaLangString))
      {
        this.k = false;
        break label384;
      }
      if (!"QRDisplayActivity".equals(this.jdField_o_of_type_JavaLangString)) {
        break label384;
      }
      this.p = true;
      break label384;
      label1021:
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        findViewById(2131300060).setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onDestroy");
    }
    b(false);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.b(this);
      }
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.jdField_m_of_type_JavaLangString != null) {
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onPause");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(null);
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
    this.jdField_d_of_type_Boolean = false;
    Process.setThreadPriority(0);
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(294);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onResume");
    }
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean) {
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.a(true, 0);
      }
    }
    for (;;)
    {
      Process.setThreadPriority(-19);
      if (this.jdField_m_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a(this.jdField_m_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_m_of_type_JavaLangString = null;
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(this);
      }
      return;
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.a(false, 0);
      }
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 291: 
      a(true);
      return true;
    case 292: 
      b(false);
      return true;
    case 293: 
      h();
      return true;
    case 294: 
      i();
      return true;
    }
    QQAppInterface.f("不用对准二维码，最新版QQ扫描声波也可加好友");
    return true;
  }
  
  public void k()
  {
    if ((isResume()) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300047: 
      this.jdField_c_of_type_Boolean = false;
      paramView.setOnClickListener(null);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
      ((ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent()).removeView(this.jdField_b_of_type_AndroidViewView);
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
        if (this.jdField_b_of_type_AndroidOsHandler != null) {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
        }
      }
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        findViewById(2131300060).setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.a(false, 0);
      }
      paramView = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramView.putBoolean("hasShowGuide", true);
      paramView.commit();
      return;
    case 2131300061: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScannerActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      super.startActivity(paramView);
      AlbumUtil.a(this, false, true);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "xiangce", 0, 1, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X80069C9", "0X80069C9", 0, 0, "", "", "", "");
      return;
    case 2131300062: 
      paramView = new Intent(this, QRDisplayActivity.class);
      String str = this.app.a();
      paramView.putExtra("from", "ScannerActivity");
      paramView.putExtra("title", getString(2131364458));
      paramView.putExtra("nick", ContactUtils.i(this.app, str));
      paramView.putExtra("uin", str);
      paramView.putExtra("type", 1);
      super.startActivityForResult(paramView, 3);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "wode", 0, 1, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8006DF6", "0X8006DF6", 0, 0, "", "", "", "");
      return;
    case 2131297083: 
      finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("olympic", 2, "ScannerActivity, onClick, R.id.go_qrcode_olympic_button");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    boolean bool = NearbyFakeActivity.a();
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScannerActivity", 2, new Object[] { "isToolProcExist = ", Boolean.valueOf(bool) });
    }
    this.l = bool;
    if (bool) {
      a(true);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X80069CA", "0X80069CA", 0, 0, "1", "", "", "");
      return;
      a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\ScannerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
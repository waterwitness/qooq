package com.tencent.mobileqq.magicface.view;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tbh;
import tbi;
import tbj;
import tbk;
import tbl;
import tbm;
import tbq;
import tbt;
import tbu;

public class MagicfaceViewController
  implements View.OnClickListener
{
  public static final String a;
  public static boolean a;
  public Handler a;
  protected View a;
  protected WindowManager a;
  protected Button a;
  public ImageView a;
  public TextView a;
  public BaseChatPie a;
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  protected ActionGlobalData a;
  public MagicfaceActionManager a;
  protected IMagicFaceView a;
  protected MagicfaceContainerView a;
  protected MagicfaceViewController.OnMagicPlayEnd a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected View b;
  protected Button b;
  public TextView b;
  public IMagicFaceView b;
  protected MagicfaceContainerView b;
  protected String b;
  protected boolean b;
  public Button c;
  protected TextView c;
  protected Button d;
  public TextView d;
  protected Button e;
  protected Button f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MagicfaceViewController.class.getSimpleName();
    String str1 = DeviceInfoUtil.g();
    if (str1 != null)
    {
      String str2 = str1.toLowerCase();
      if ((!str2.contains("marvell")) && (!str2.contains("armv5")) && (!str2.contains("armv6"))) {
        break label88;
      }
    }
    label88:
    for (jdField_a_of_type_Boolean = false;; jdField_a_of_type_Boolean = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "cpuType=" + str1);
      }
      return;
    }
  }
  
  public MagicfaceViewController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    d();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.jdField_b_of_type_Boolean);
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.flags = 131112;
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = paramInt;
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean a()
  {
    if ((DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  private void d()
  {
    if (!DeviceInfoUtil.d())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.f(), DeviceInfoUtil.g()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initMagicfaceView begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ac();
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2130904549, null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131303145));
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131303144));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303146));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303147));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131303151));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131303148));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131303150));
        this.e = ((Button)localView.findViewById(2131303149));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.e.setOnClickListener(this);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label413;
      }
    }
    label413:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2130904548, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2130904550, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2130904552, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303152);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131299314));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131299313));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303155));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303143));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299315));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131303153));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303154));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initMagicfaceView ends");
      }
      return;
      localView = View.inflate(BaseApplicationImpl.getContext(), 2130904551, null);
      break;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b())
    {
      this.e.setBackgroundResource(2130841743);
      return;
    }
    this.e.setBackgroundResource(2130841742);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c())
    {
      this.f.setBackgroundResource(2130841713);
      return;
    }
    this.f.setBackgroundResource(2130841740);
  }
  
  private void h()
  {
    if (this.jdField_d_of_type_AndroidWidgetButton.getTag() == null) {}
    Emoticon localEmoticon;
    do
    {
      return;
      localEmoticon = (Emoticon)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    } while (localEmoticon.jobType != 2);
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() >= 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() != 0) {
        break label83;
      }
    }
    label83:
    for (localEmoticon.magicValue = "value=1";; localEmoticon.magicValue = ("value=" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localEmoticon);
      b();
      a(localEmoticon, null);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tbi(this));
  }
  
  public void a(Emoticon paramEmoticon)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    Object localObject = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(112);
    if ((localObject != null) && (((TroopGiftManager)localObject).o != 1)) {
      ((TroopGiftManager)localObject).d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyChatPie))
    {
      localObject = (NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(123);
      if (localObject != null) {
        ((NearbyFlowerManager)localObject).d();
      }
    }
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView == null) || (((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      return;
      if (paramInt1 != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
    return;
    this.jdField_b_of_type_JavaLangString = paramEmoticon.epId;
    e();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager = new MagicfaceActionManager(this);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(0);
      ((SurfaceView)localObject2).setZOrderOnTop(true);
      ((SurfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a((MagicfacePlayManager)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new tbm(this, paramInt1, (TextView)localObject1));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new tbq(this, l, paramInt1));
      if (!((IMagicFaceView)localObject2).a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidOsHandler.post(new tbl(this));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setIsFullScreen(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new tbt(this), 200L);
    ((IMagicFaceView)localObject2).setSurfaceCreatelistener(new tbu(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void a(Emoticon paramEmoticon, MagicfaceViewController.OnMagicPlayEnd paramOnMagicPlayEnd)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = paramOnMagicPlayEnd;
    if (!a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      paramOnMagicPlayEnd = new Emoticon();
      paramOnMagicPlayEnd.eId = paramEmoticon.eId;
      paramOnMagicPlayEnd.epId = paramEmoticon.epId;
      paramOnMagicPlayEnd.magicValue = paramEmoticon.magicValue;
      paramOnMagicPlayEnd.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramOnMagicPlayEnd;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new tbj(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      ((MagicfaceActionManager)localObject).a(new tbk(this, (MagicfaceActionManager)localObject));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.e();
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      b();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    b();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131303148: 
    case 2131299315: 
    case 2131303151: 
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        b();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        b();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new tbh(this), 300L);
      return;
    case 2131303150: 
      h();
      return;
    case 2131303149: 
      bool3 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (!bool3)
      {
        bool1 = true;
        label259:
        paramView.a(bool1);
        f();
        paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
        if (bool3) {
          break label335;
        }
      }
      label335:
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        if (bool3) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        return;
        bool1 = false;
        break label259;
      }
    }
    bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
    paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
    if (!bool2)
    {
      bool1 = true;
      label359:
      paramView.b(bool1);
      g();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (bool2) {
        break label434;
      }
    }
    label434:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramView.c(bool1);
      if (bool2) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break label359;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\MagicfaceViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
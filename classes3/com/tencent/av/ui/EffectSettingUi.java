package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import gst;
import gsu;
import gsv;
import gsw;
import gsx;
import gsy;
import gsz;
import gta;
import gtb;
import gtc;
import gtd;
import gte;
import gtf;
import gtg;
import gth;
import gti;
import gtj;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class EffectSettingUi
{
  static final String jdField_a_of_type_JavaLangString = "EffectSettingUi";
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public RelativeLayout a;
  public VideoAppInterface a;
  EffectSettingBtn jdField_a_of_type_ComTencentAvUiEffectSettingBtn;
  public QAVPtvTemplateAdapter.IEffectCallback a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public WeakReference a;
  public HashMap a;
  boolean jdField_a_of_type_Boolean;
  public ViewGroup b;
  public QAVPtvTemplateAdapter.IEffectCallback b;
  boolean b;
  public QAVPtvTemplateAdapter.IEffectCallback c;
  public QAVPtvTemplateAdapter.IEffectCallback d;
  
  EffectSettingUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRunnable = new gst(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gtd(this);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback = new gte(this);
    this.jdField_b_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback = new gtf(this);
    this.c = new gtg(this);
    this.d = new gsu(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 2, "EffectSettingUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private int a()
  {
    int i = 2131299137;
    gth localgth = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localgth != null) && (localgth.jdField_a_of_type_Gtj.a()))
    {
      b(true);
      return this.jdField_a_of_type_Int;
    }
    if (((!GraphicRenderMgr.soloadedPTV) || (!VideoController.a().a().j())) && (PtvFilterSoLoad.b()))
    {
      ((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299137))).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299137)) == null) || (!((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299137))).jdField_a_of_type_Gtj.a())) {
        break label184;
      }
    }
    for (;;)
    {
      if ((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) != null)
      {
        b(true);
        return i;
        ((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299137))).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break;
        label184:
        if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299136)) != null) && (((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299136))).jdField_a_of_type_Gtj.a()))
        {
          i = 2131299136;
          continue;
        }
        if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299135)) != null) && (((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299135))).jdField_a_of_type_Gtj.a()))
        {
          i = 2131299135;
          continue;
        }
        if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299134)) == null) || (!((gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131299134))).jdField_a_of_type_Gtj.a())) {
          break label332;
        }
        i = 2131299134;
        continue;
      }
      b(false);
      return i;
      label332:
      i = -1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a(this.jdField_b_of_type_Boolean);
    }
  }
  
  private boolean d()
  {
    int i = a();
    gth localgth = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (localgth != null)
    {
      localgth.jdField_a_of_type_AndroidWidgetButton.performClick();
      return true;
    }
    return false;
  }
  
  private void l()
  {
    a(2131299137, new gsz(this), 2130839051, "0X8006F89", "0X8006F8A");
    a(2131299136, new gta(this), 2130839052, "0X8006F8B", "0X8006F8C");
    a(2131299134, new gtb(this), 2130839045, "0X8006F8D", "0X8006F8E");
  }
  
  public Resources a()
  {
    return ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
  }
  
  void a()
  {
    g();
  }
  
  void a(int paramInt1, gtj paramgtj, int paramInt2, String paramString1, String paramString2)
  {
    gth localgth = new gth(this);
    localgth.jdField_b_of_type_Int = paramInt1;
    localgth.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(paramInt1));
    localgth.jdField_a_of_type_JavaLangString = paramString1;
    localgth.jdField_b_of_type_JavaLangString = paramString2;
    localgth.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localgth.jdField_a_of_type_Int = paramInt2;
    localgth.jdField_a_of_type_Gtj = paramgtj;
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), localgth);
    AudioHelper.a(a(), localgth.jdField_a_of_type_AndroidWidgetButton, paramgtj.a(), localgth.jdField_a_of_type_Int);
    if (AudioHelper.b()) {
      localgth.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-16777216);
    }
  }
  
  public void a(int paramInt, Object[] paramArrayOfObject)
  {
    gth localgth = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localgth == null) {
      return;
    }
    localgth.a(paramArrayOfObject);
  }
  
  void a(boolean paramBoolean)
  {
    int i = a();
    if (!this.jdField_b_of_type_Boolean)
    {
      QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364033), 1).a();
      gti.b();
      return;
    }
    gti.c();
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a();
    }
    Object localObject = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Int != i) {
        break label263;
      }
      ((gth)localObject).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject != null) {
        ((gth)localObject).jdField_a_of_type_ComTencentAvUiBaseToolbar.b();
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      localObject = new TranslateAnimation(a().getDisplayMetrics().widthPixels, 0.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setFillAfter(false);
      ((TranslateAnimation)localObject).setDuration(300L);
      ((TranslateAnimation)localObject).setAnimationListener(new gsv(this));
      this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      localObject = new TranslateAnimation(0.0F, -a().getDisplayMetrics().widthPixels, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setFillAfter(false);
      ((TranslateAnimation)localObject).setDuration(300L);
      ((TranslateAnimation)localObject).setAnimationListener(new gsw(this));
      this.jdField_b_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
      j();
      return;
      label263:
      ((gth)localObject).jdField_a_of_type_AndroidWidgetButton.performClick();
    }
  }
  
  boolean a()
  {
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.e()) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(124) });
    k();
    return true;
  }
  
  public boolean a(int paramInt)
  {
    j();
    if (this.jdField_a_of_type_Int != paramInt)
    {
      gth localgth = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if ((localgth == null) || (!localgth.a())) {
        return false;
      }
      localgth = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localgth != null) {
        localgth.a();
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    return true;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (AudioHelper.c()) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.c();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.b();
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((gth)((Map.Entry)((Iterator)localObject).next()).getValue()).b();
    }
    if (b())
    {
      localObject = (gth)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject != null) {
        ((gth)localObject).a();
      }
      this.jdField_a_of_type_Int = -1;
      d();
    }
  }
  
  void f()
  {
    Button localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299138);
    AudioHelper.a(a(), localButton, true, 0);
    localButton.setOnClickListener(new gtc(this));
    if (AudioHelper.b()) {
      localButton.setBackgroundColor(-16777216);
    }
  }
  
  void g()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {}
    Object localObject;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 2, "onCreate");
      }
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidViewView = ((AVActivity)localObject).getLayoutInflater().inflate(2130903543, this.jdField_a_of_type_AndroidViewViewGroup).findViewById(2131299132);
      }
      localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent();
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewGroup)localObject).findViewById(2131299344));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299133));
      l();
      f();
    } while (!AudioHelper.b());
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(65280);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-65281);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16711936);
    ((ViewGroup)localObject).setBackgroundColor(Color.argb(255, 255, 255, 255));
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(Color.argb(127, 0, 0, 0));
  }
  
  void h()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    i();
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null)
    {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.d();
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((gth)((Map.Entry)localIterator.next()).getValue()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(125) });
    b();
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, a().getDisplayMetrics().widthPixels, 0.0F, 0.0F);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new gsx(this));
    this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(-a().getDisplayMetrics().widthPixels, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new gsy(this));
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\EffectSettingUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
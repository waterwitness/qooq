package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import has;
import hat;
import java.lang.ref.WeakReference;

public class VideoNetStateBar
{
  static final int jdField_a_of_type_Int = 2000;
  static final String jdField_a_of_type_JavaLangString = "VideoNetStateBar";
  static final int jdField_b_of_type_Int = 2000;
  static final int jdField_c_of_type_Int = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  Resources jdField_a_of_type_AndroidContentResResources;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  public VideoAppInterface a;
  public Runnable a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  boolean jdField_b_of_type_Boolean;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  WeakReference jdField_c_of_type_JavaLangRefWeakReference;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  boolean e;
  boolean f;
  int g;
  public boolean g;
  int h;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_Int = 0;
    this.h = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new has(this);
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_AndroidContentResResources = paramAVActivity.getResources();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreate");
    }
    l();
    this.e = false;
    this.f = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 0;
    this.h = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b();
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if (localSessionInfo.jdField_s_of_type_Boolean)
        {
          localSessionInfo.jdField_s_of_type_Boolean = false;
          if ((localSessionInfo.f == 1) || (localSessionInfo.f == 2))
          {
            this.jdField_g_of_type_Int = localSessionInfo.jdField_s_of_type_Int;
            this.h = localSessionInfo.t;
          }
          if ((localSessionInfo.f == 3) || (localSessionInfo.f == 4)) {
            this.jdField_g_of_type_Int = localSessionInfo.jdField_s_of_type_Int;
          }
        }
        this.jdField_b_of_type_Boolean = localSessionInfo.jdField_c_of_type_Boolean;
        this.jdField_c_of_type_Boolean = localSessionInfo.d;
      }
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (!a(paramInt)) {}
    while ((paramInt == this.jdField_g_of_type_Int) && (this.e)) {
      return;
    }
    this.jdField_g_of_type_Int = paramInt;
    e(paramInt);
    this.e = true;
    o();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = j;
    if (a(paramInt1)) {
      if (paramInt1 == this.jdField_g_of_type_Int)
      {
        i = j;
        if (this.e) {}
      }
      else
      {
        this.jdField_g_of_type_Int = paramInt1;
        e(paramInt1);
        this.e = true;
        i = 1;
      }
    }
    paramInt1 = i;
    if (a(paramInt2)) {
      if (paramInt2 == this.h)
      {
        paramInt1 = i;
        if (this.f) {}
      }
      else
      {
        this.h = paramInt2;
        this.e = true;
        paramInt1 = 1;
      }
    }
    if (paramInt1 != 0) {
      o();
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramTipsManager);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      o();
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool1 = bool2;
      if (localSessionInfo != null)
      {
        if ((!this.jdField_c_of_type_Boolean) || ((localSessionInfo.f != 1) && (localSessionInfo.f != 2))) {
          break label76;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
        bool1 = true;
      }
    }
    label76:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_b_of_type_Boolean);
      if (localSessionInfo.f == 3) {
        break;
      }
      bool1 = bool2;
    } while (localSessionInfo.f != 4);
    ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
    return true;
  }
  
  boolean a(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 3);
  }
  
  void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131299065));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131299066));
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131299048);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131299049));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131299050));
    }
  }
  
  public void b(int paramInt)
  {
    if (!a(paramInt)) {}
    while ((paramInt == this.h) && (this.f)) {
      return;
    }
    this.h = paramInt;
    this.e = true;
    o();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
    o();
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        localSessionInfo.jdField_s_of_type_Int = this.jdField_g_of_type_Int;
        localSessionInfo.t = this.h;
        localSessionInfo.jdField_s_of_type_Boolean = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    l();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    o();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onStart");
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    o();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onResume");
    }
  }
  
  void e(int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "0X8005920", "0X8005920", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        do
        {
          return;
          localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((localSessionInfo == null) || (a()));
        if ((localSessionInfo.z) || (localSessionInfo.f == 1) || (localSessionInfo.f == 2))
        {
          switch (paramInt)
          {
          default: 
            return;
          case 1: 
            ReportController.b(null, "CliOper", "", "", "0X8005919", "0X8005919", 0, 0, "", "", "", "");
            return;
          case 2: 
            ReportController.b(null, "CliOper", "", "", "0X8005918", "0X8005918", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005917", "0X8005917", 0, 0, "", "", "", "");
          return;
        }
      } while ((localSessionInfo.f != 3) && (localSessionInfo.f != 4));
      if (localSessionInfo.F == 2)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 1: 
          ReportController.b(null, "CliOper", "", "", "0X800591C", "0X800591C", 0, 0, "", "", "", "");
          return;
        case 2: 
          ReportController.b(null, "CliOper", "", "", "0X800591B", "0X800591B", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800591A", "0X800591A", 0, 0, "", "", "", "");
        return;
      }
    } while (localSessionInfo.F != 1);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ReportController.b(null, "CliOper", "", "", "0X800591F", "0X800591F", 0, 0, "", "", "", "");
      return;
    case 2: 
      ReportController.b(null, "CliOper", "", "", "0X800591E", "0X800591E", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800591D", "0X800591D", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onPause");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onStop");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
    }
    this.jdField_g_of_type_Int = 3;
    this.h = 3;
    o();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onMultiConnected");
    }
    this.jdField_g_of_type_Int = 3;
    o();
    j();
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localSessionInfo != null) && ((localSessionInfo.f == 3) || (localSessionInfo.f == 4))) {
        k();
      }
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new hat(this);
      }
    } while ((this.jdField_a_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void m()
  {
    this.jdField_g_of_type_Int = 0;
    o();
  }
  
  public void n()
  {
    this.h = 0;
    o();
  }
  
  void o()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null)) {}
    label21:
    label199:
    label422:
    label1048:
    label1094:
    label1111:
    do
    {
      do
      {
        int m;
        int n;
        do
        {
          break label21;
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidContentResResources == null);
          m = this.jdField_g_of_type_Int;
          n = this.h;
        } while ((m == 0) && (n == 0));
        int k = n;
        int i = m;
        Object localObject;
        int j;
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
          k = n;
          i = m;
          if (localObject != null)
          {
            if ((((SessionInfo)localObject).f != 1) && (((SessionInfo)localObject).f != 2)) {
              break label422;
            }
            j = m;
            if (m != 0)
            {
              j = m;
              if (this.jdField_c_of_type_Boolean) {
                j = 3;
              }
            }
            k = n;
            i = j;
            if (n != 0)
            {
              k = n;
              i = j;
              if (this.jdField_b_of_type_Boolean)
              {
                k = 3;
                i = j;
              }
            }
          }
        }
        if ((i == 0) && (k != 0)) {
          switch (k)
          {
          default: 
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363880);
            j = k;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (this.d)
            {
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363883);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839233);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839233);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839234);
              if ((!this.d) && (i != 1) && (k != 1)) {
                break label1048;
              }
              if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_JavaLangString.equals(localObject))))
              {
                this.jdField_b_of_type_JavaLangString = ((String)localObject);
                TipsManager.a(101, (String)localObject);
                if ((((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a.getVisibility() != 0) || (((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).aB == 101)) {
                  ((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a(101, (String)localObject, false);
                }
              }
            }
            break;
          }
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label1111;
          }
          if ((!this.d) && (i != 1) && (k != 1)) {
            break label1094;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          p();
          return;
          if (((SessionInfo)localObject).f != 3)
          {
            k = n;
            i = m;
            if (((SessionInfo)localObject).f != 4) {
              break;
            }
          }
          k = n;
          i = m;
          if (m == 0) {
            break;
          }
          k = n;
          i = m;
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          i = 3;
          k = n;
          break;
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363882);
          break label199;
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363881);
          break label199;
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363880);
          break label199;
          if ((i != 0) && (k == 0))
          {
            switch (i)
            {
            default: 
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363877);
            }
            for (;;)
            {
              j = i;
              break;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363879);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363878);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363877);
            }
          }
          if (i < k)
          {
            switch (i)
            {
            default: 
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363877);
            }
            for (;;)
            {
              j = i;
              break;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363879);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363878);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363877);
            }
          }
          if (i > k)
          {
            switch (k)
            {
            default: 
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363880);
            }
            for (;;)
            {
              j = k;
              break;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363882);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363881);
              continue;
              localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363880);
            }
          }
          switch (i)
          {
          default: 
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363875);
          }
          for (;;)
          {
            j = i;
            break;
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363879);
            continue;
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363876);
            continue;
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363875);
          }
          switch (j)
          {
          default: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839229);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839229);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839230);
            break;
          case 1: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839227);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839227);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839228);
            break;
          case 2: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839231);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839231);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839232);
            break;
          case 3: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839229);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839229);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839230);
            break;
            if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null))
            {
              TipsManager.c(101);
              ((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a(101);
              this.jdField_b_of_type_JavaLangString = null;
            }
            break;
          }
        }
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void p()
  {
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if ((!localSessionInfo.z) && (localSessionInfo.f != 1) && (localSessionInfo.f != 2)) {
          break label69;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
      }
    }
    label69:
    while ((localSessionInfo.f != 3) && (localSessionInfo.f != 4)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoNetStateBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
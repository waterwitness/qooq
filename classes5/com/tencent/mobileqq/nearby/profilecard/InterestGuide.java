package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ScrollStateDetector;
import com.tencent.mobileqq.widget.ScrollStateDetector.OnScrollListener;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import tle;
import tlf;

public class InterestGuide
  implements Handler.Callback, View.OnClickListener, ScrollStateDetector.OnScrollListener
{
  public static Boolean a;
  static final String jdField_a_of_type_JavaLangString = InterestGuide.class.getSimpleName();
  public static WeakReference a;
  public static final String b = "interest_guide_key";
  public static String c;
  static final int f = 0;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  int[] jdField_a_of_type_ArrayOfInt;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  int b;
  int c;
  int d;
  public String d;
  int e = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InterestGuide(String paramString, View paramView, int paramInt)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = paramString;
    this.e = paramInt;
    paramString = (BounceScrollView)paramView.findViewById(2131301967);
    if (paramString != null) {
      paramString.setScrollListener(new ScrollStateDetector(this, paramString.getContext()));
    }
    int i = NearbyProfileEditPanel.jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i];
    paramInt = 0;
    while (paramInt < i)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = paramView.findViewById(NearbyProfileEditPanel.jdField_a_of_type_ArrayOfInt[paramInt]);
      paramInt += 1;
    }
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
  }
  
  public static void a(int paramInt)
  {
    InterestGuide localInterestGuide;
    if (jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localInterestGuide = null;
      if (localInterestGuide != null)
      {
        localInterestGuide.e = paramInt;
        if (NearbyUtils.a()) {
          NearbyUtils.a(jdField_a_of_type_JavaLangString, "switchMode", new Object[] { Integer.valueOf(paramInt) });
        }
        if (localInterestGuide.e != 1) {
          break label96;
        }
        localInterestGuide.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        if ((localInterestGuide.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (localInterestGuide.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
          localInterestGuide.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
      }
    }
    label96:
    while (!jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      return;
      localInterestGuide = (InterestGuide)jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
    }
    localInterestGuide.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
  }
  
  public static void a(String paramString, View paramView, int paramInt)
  {
    if (!NearbyUtils.a(paramString, jdField_c_of_type_JavaLangString))
    {
      jdField_c_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaLangBoolean = null;
      jdField_a_of_type_JavaLangRefWeakReference = null;
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkNeedShowGuide", new Object[] { paramString });
      }
    }
    if ((paramView == null) || (paramString == null) || (Boolean.FALSE.equals(jdField_a_of_type_JavaLangBoolean))) {
      return;
    }
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      ThreadManager.a(new tle(paramString, paramView, paramInt), 5, null, true);
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(new InterestGuide(paramString, paramView, paramInt));
  }
  
  public static boolean a()
  {
    InterestGuide localInterestGuide;
    if (jdField_a_of_type_JavaLangRefWeakReference == null) {
      localInterestGuide = null;
    }
    while (localInterestGuide != null) {
      if ((localInterestGuide.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (localInterestGuide.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
      {
        return true;
        localInterestGuide = (InterestGuide)jdField_a_of_type_JavaLangRefWeakReference.get();
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if (this.e != 1) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt2;
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "MSG_CHECK_INTEREST", new Object[] { Integer.valueOf(paramMessage.what), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.e), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) });
    }
    Context localContext;
    int k;
    Object localObject;
    int i;
    int m;
    int j;
    if ((paramMessage.what == 0) && (this.jdField_d_of_type_Int == 0) && (this.e != 1) && (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_AndroidGraphicsRectF == null))
      {
        this.jdField_a_of_type_ArrayOfInt = new int[2];
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        paramMessage = localContext.getResources().getDisplayMetrics();
        this.b = paramMessage.widthPixels;
        this.jdField_c_of_type_Int = paramMessage.heightPixels;
        this.jdField_a_of_type_Float = paramMessage.density;
        this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 120.0F));
      }
      k = 0;
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131302029);
      if (localObject != null)
      {
        ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        paramMessage = ((View)localObject).findViewById(2131297137);
        localObject = ((View)localObject).findViewById(2131302030);
        i = this.jdField_a_of_type_ArrayOfInt[1];
        k = paramMessage.getMeasuredHeight() + i + ((View)localObject).getMeasuredHeight();
      }
      paramMessage = new int[3];
      Message tmp262_261 = paramMessage;
      tmp262_261[0] = 2131297016;
      Message tmp267_262 = tmp262_261;
      tmp267_262[1] = 2131302039;
      Message tmp272_267 = tmp267_262;
      tmp272_267[2] = 2131302040;
      tmp272_267;
      i = this.jdField_c_of_type_Int;
      m = 0;
      if (m < paramMessage.length)
      {
        localObject = this.jdField_a_of_type_AndroidViewView.findViewById(paramMessage[m]);
        int n;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          j = i;
          if (this.jdField_a_of_type_ArrayOfInt[1] > k)
          {
            j = i;
            if (this.jdField_a_of_type_ArrayOfInt[1] < i) {
              j = this.jdField_a_of_type_ArrayOfInt[1];
            }
          }
          n = j;
          if (NearbyUtils.a())
          {
            NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(((View)localObject).getMeasuredHeight()) });
            n = j;
          }
        }
        for (;;)
        {
          m += 1;
          i = n;
          break;
          n = i;
          if (NearbyUtils.a())
          {
            NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), localObject });
            n = i;
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, k, this.b, i);
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkShowGuide", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(i) });
      }
      localObject = null;
      i = 0;
      paramMessage = (Message)localObject;
      if (0 == 0)
      {
        paramMessage = (Message)localObject;
        if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
        {
          if ((this.jdField_a_of_type_ArrayOfAndroidViewView[i] == null) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i].getVisibility() != 0)) {}
          do
          {
            i += 1;
            break;
            this.jdField_a_of_type_ArrayOfAndroidViewView[i].getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
            j = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredWidth();
            k = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredHeight();
          } while (!this.jdField_a_of_type_AndroidGraphicsRectF.contains(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], j + this.jdField_a_of_type_ArrayOfInt[0], k + this.jdField_a_of_type_ArrayOfInt[1]));
          paramMessage = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
        }
      }
      if (paramMessage != null)
      {
        localObject = new LinearLayout(localContext);
        ((LinearLayout)localObject).setOrientation(1);
        i = Color.parseColor("#BF000000");
        j = this.jdField_a_of_type_ArrayOfInt[1];
        k = paramMessage.getMeasuredHeight();
        m = this.jdField_c_of_type_Int - j - k;
        if (j > 0)
        {
          if (m <= this.jdField_a_of_type_Int) {
            break label1020;
          }
          paramMessage = new View(localContext);
          paramMessage.setBackgroundColor(i);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.b, j));
        }
        ((LinearLayout)localObject).addView(new View(localContext), new LinearLayout.LayoutParams(this.b, k));
        if (m > 0)
        {
          if (m <= this.jdField_a_of_type_Int) {
            break label1049;
          }
          paramMessage = LayoutInflater.from(localContext).inflate(2130904233, null);
          ((Button)paramMessage.findViewById(2131298931)).setOnClickListener(this);
        }
      }
    }
    for (;;)
    {
      paramMessage.setBackgroundColor(i);
      ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.b, m));
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkShowGuide", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localContext);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.b);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 51, 0, 0);
      return true;
      label1020:
      paramMessage = LayoutInflater.from(localContext).inflate(2130904234, null);
      ((Button)paramMessage.findViewById(2131298931)).setOnClickListener(this);
      break;
      label1049:
      paramMessage = new View(localContext);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      paramView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301967);
      if (paramView != null) {
        paramView.setScrollListener(null);
      }
      jdField_a_of_type_JavaLangRefWeakReference = null;
      jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
      ThreadManager.a(new tlf(this), 5, null, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\InterestGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
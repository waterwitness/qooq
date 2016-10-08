package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import xrn;
import xro;
import xrp;
import xrq;
import xrr;
import xrs;
import xrt;
import xru;
import xrw;
import xrx;
import xry;
import xrz;
import xsa;

public abstract class AbsListView
  extends AdapterView
  implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener, Filter.FilterListener
{
  protected static final int A = 1;
  protected static final int B = 2;
  protected static final int C = 3;
  protected static final int D = 4;
  protected static final int E = 5;
  protected static final int F = 6;
  static final int G = 0;
  static final int H = 1;
  static final int I = 2;
  static final int J = 3;
  static final int K = 4;
  static final int L = 100;
  static final int M = 5;
  static final int N = 6;
  public static final int O = 0;
  public static final int P = 1;
  public static final int Q = 2;
  public static final int R = 3;
  private static final int jdField_a_of_type_Int;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  static final int am = 3;
  public static final int ao = -1;
  private static final int jdField_b_of_type_Int;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 0 };
  private static final int jdField_c_of_type_Int;
  private static final int jdField_d_of_type_Int;
  private static final int jdField_e_of_type_Int;
  private static final int jdField_f_of_type_Int;
  private static final int g;
  private static final int h;
  private static final int i;
  private static final int jdField_j_of_type_Int;
  private static final int jdField_k_of_type_Int;
  private static final int l = 30;
  private static final int m = 20;
  private static final int n = -1;
  private static final int o = 0;
  private static final int p = 1;
  private static final boolean jdField_t_of_type_Boolean = false;
  public static final int v = 0;
  private static final boolean v = false;
  public static final int w = 1;
  public static final int x = 2;
  protected static final int y = -1;
  protected static final int z = 0;
  private boolean A;
  private boolean B;
  private boolean C;
  int S = 0;
  int T;
  public int U = 0;
  public int V = -1;
  int W = 0;
  int X = 0;
  int Y = 0;
  int Z = 0;
  private float jdField_a_of_type_Float;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public SparseBooleanArray a;
  public ActionMode a;
  private ContextMenu.ContextMenuInfo jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private InputConnection jdField_a_of_type_AndroidViewInputmethodInputConnection;
  private InputConnectionWrapper jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public ListAdapter a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  private AbsListView.OnScrollButtomListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollButtomListener;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private EdgeEffect jdField_a_of_type_ComTencentWidgetEdgeEffect;
  public FastScroller a;
  private Object jdField_a_of_type_JavaLangObject;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  Method jdField_a_of_type_JavaLangReflectMethod = null;
  xrq jdField_a_of_type_Xrq;
  private xrr jdField_a_of_type_Xrr;
  private xrs jdField_a_of_type_Xrs;
  private xru jdField_a_of_type_Xru;
  private xrw jdField_a_of_type_Xrw;
  xrx jdField_a_of_type_Xrx;
  private xry jdField_a_of_type_Xry;
  public xrz a;
  public final xsa a;
  private boolean jdField_a_of_type_Boolean;
  public final boolean[] a;
  private int aK;
  private int aL = -1;
  private int aM;
  private int aN;
  private int aO;
  private int aP;
  private int aQ;
  private int aR;
  private int aS;
  private int aT;
  private int aU;
  public int a_;
  int aa = 0;
  public int ab;
  public int ac;
  int ad;
  int ae;
  int af;
  public int ag = -1;
  int ah;
  int ai;
  int aj = 0;
  int ak = -1;
  int al;
  int an;
  public int ar;
  private float jdField_b_of_type_Float = 1.0F;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private EdgeEffect jdField_b_of_type_ComTencentWidgetEdgeEffect;
  private Object jdField_b_of_type_JavaLangObject;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  public int b_;
  public Rect c;
  public Drawable c;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean jdField_d_of_type_Boolean;
  View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  public boolean g;
  public boolean h;
  public boolean i;
  boolean jdField_j_of_type_Boolean;
  boolean jdField_k_of_type_Boolean;
  public boolean l;
  public boolean m;
  public boolean n;
  private int q;
  private int r;
  private int s;
  private int jdField_t_of_type_Int;
  private int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = a("AbsListView");
    jdField_a_of_type_Int = a("AbsListView_listSelector");
    jdField_b_of_type_Int = a("AbsListView_fastScrollAlwaysVisible");
    jdField_c_of_type_Int = a("AbsListView_choiceMode");
    jdField_d_of_type_Int = a("AbsListView_smoothScrollbar");
    jdField_e_of_type_Int = a("AbsListView_fastScrollEnabled");
    jdField_f_of_type_Int = a("AbsListView_cacheColorHint");
    jdField_g_of_type_Int = a("AbsListView_transcriptMode");
    jdField_h_of_type_Int = a("AbsListView_textFilterEnabled");
    jdField_i_of_type_Int = a("AbsListView_scrollingCache");
    jdField_j_of_type_Int = a("AbsListView_stackFromBottom");
    jdField_k_of_type_Int = a("AbsListView_drawSelectorOnTop");
  }
  
  public AbsListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Xsa = new xsa(this);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_q_of_type_Int = -1;
    this.jdField_s_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[1];
    c();
    setVerticalScrollBarEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(a("View"));
    initializeScrollbars(paramContext);
    paramContext.recycle();
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842858);
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Xsa = new xsa(this);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_q_of_type_Int = -1;
    this.jdField_s_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[1];
    c();
    paramContext = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt, paramInt, 0));
    paramAttributeSet = paramContext.a(jdField_a_of_type_Int);
    if (paramAttributeSet != null) {
      setSelector(paramAttributeSet);
    }
    this.jdField_f_of_type_Boolean = paramContext.a(jdField_k_of_type_Int, false);
    setStackFromBottom(paramContext.a(jdField_j_of_type_Int, false));
    setScrollingCacheEnabled(paramContext.a(jdField_i_of_type_Int, true));
    setTextFilterEnabled(paramContext.a(jdField_h_of_type_Int, false));
    setTranscriptMode(paramContext.a(jdField_g_of_type_Int, 0));
    setCacheColorHint(paramContext.b(jdField_f_of_type_Int, 0));
    setFastScrollEnabled(paramContext.a(jdField_e_of_type_Int, false));
    setSmoothScrollbarEnabled(paramContext.a(jdField_d_of_type_Int, true));
    setChoiceMode(paramContext.a(jdField_c_of_type_Int, 0));
    setFastScrollAlwaysVisible(paramContext.a(jdField_b_of_type_Int, false));
    paramContext.a();
  }
  
  private void E()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new xro(this);
    }
    post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  private void G()
  {
    if (getWindowVisibility() == 0)
    {
      a(true);
      H();
      z();
    }
  }
  
  private void H()
  {
    int i1 = getResources().getDisplayMetrics().heightPixels;
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    i1 = i1 - arrayOfInt[1] - getHeight() + (int)(this.jdField_a_of_type_Float * 20.0F);
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this, 81, arrayOfInt[0], i1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(arrayOfInt[0], i1, -1, -1);
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a();
      this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a();
    }
  }
  
  private int a(int paramInt)
  {
    if (this.mScrollY * paramInt < 0) {}
    while (this.az == 0) {
      return paramInt;
    }
    return (this.az - Math.abs(this.mScrollY)) * paramInt / this.az / 2;
  }
  
  static int a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    int i3;
    int i2;
    int i1;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 66: 
      i3 = paramRect1.right;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.left;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
    for (;;)
    {
      i1 -= i3;
      paramInt -= i2;
      return paramInt * paramInt + i1 * i1;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.bottom;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top;
      continue;
      i3 = paramRect1.left;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.right;
      paramInt = paramRect2.top + paramRect2.height() / 2;
      continue;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.top;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.bottom;
      continue;
      i3 = paramRect1.right + paramRect1.width() / 2;
      i2 = paramRect1.top + paramRect1.height() / 2;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
  }
  
  public static View a(ArrayList paramArrayList, int paramInt)
  {
    int i2 = paramArrayList.size();
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = (View)paramArrayList.get(i1);
        if (((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_b_of_type_Int == paramInt)
        {
          paramArrayList.remove(i1);
          return localView;
        }
        i1 += 1;
      }
      return (View)paramArrayList.remove(i2 - 1);
    }
    return null;
  }
  
  private Object a(Object paramObject)
  {
    return null;
  }
  
  private Object a(String paramString)
  {
    return null;
  }
  
  private void a(int paramInt)
  {
    int i5 = paramInt - this.af;
    int i4 = i5 - this.ai;
    int i2;
    Object localObject;
    int i1;
    if (this.ah != Integer.MIN_VALUE)
    {
      i2 = paramInt - this.ah;
      if (this.ag != 3) {
        break label425;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_JavaLangObject = a("AbsListView-scroll");
      }
      if (paramInt != this.ah)
      {
        if (((this.mGroupFlags & 0x80000) == 0) && (Math.abs(i5) > this.t))
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        if (this.ab < 0) {
          break label369;
        }
        i1 = this.ab - this.au;
        label125:
        localObject = getChildAt(i1);
        if (localObject == null) {
          break label783;
        }
      }
    }
    label208:
    label347:
    label369:
    label379:
    label384:
    label425:
    label517:
    label620:
    label724:
    label730:
    label771:
    label783:
    for (int i3 = ((View)localObject).getTop();; i3 = 0)
    {
      if (i2 != 0) {}
      for (boolean bool = a(i4, i2);; bool = false)
      {
        localObject = getChildAt(i1);
        if (localObject != null)
        {
          i1 = ((View)localObject).getTop();
          if (bool)
          {
            i2 = -i2 - (i1 - i3);
            i3 = a(i2);
            if ((this.l) && (i3 > 0)) {
              break label379;
            }
            i1 = 1;
            if (i1 != 0) {
              overScrollBy(0, i3, 0, getScrollY(), 0, 0, 0, this.a_, true);
            }
            if ((Math.abs(this.a_) == Math.abs(getScrollY())) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null)) {
              this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
            }
            i3 = getOverScrollMode();
            if ((i1 != 0) && ((i3 == 0) || ((i3 == 1) && (!b()))))
            {
              this.aO = 0;
              this.ag = 5;
              if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
              {
                if (i5 <= 0) {
                  break label384;
                }
                this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i2 / getHeight());
                if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a()) {
                  this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
                }
              }
            }
          }
          this.af = paramInt;
          invalidate();
        }
        else
        {
          this.ah = paramInt;
        }
        do
        {
          return;
          i2 = i4;
          break;
          i1 = getChildCount() / 2;
          break label125;
          i1 = 0;
          break label208;
          if (i5 >= 0) {
            break label347;
          }
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i2 / getHeight());
          if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) {
            break label347;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
          break label347;
        } while ((this.ag != 5) || (paramInt == this.ah));
        i4 = getScrollY();
        int i6 = i4 - i2;
        if (paramInt > this.ah)
        {
          i1 = 1;
          if (this.aO == 0) {
            this.aO = i1;
          }
          i3 = -i2;
          if (((i6 >= 0) || (i4 < 0)) && ((i6 <= 0) || (i4 > 0))) {
            break label724;
          }
          i4 = -i4;
          i3 = i4;
          i2 += i4;
          if (i3 != 0)
          {
            i4 = getScrollY();
            overScrollBy(0, a(i3), 0, i4, 0, 0, 0, this.a_, true);
            i4 = getOverScrollMode();
            if ((i4 == 0) || ((i4 == 1) && (!b())))
            {
              if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
              {
                if (i5 <= 0) {
                  break label730;
                }
                this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i3 / getHeight());
                if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a()) {
                  this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
                }
              }
              invalidate();
            }
          }
          if (i2 != 0)
          {
            this.mScrollY = 0;
            B();
            if (i2 != 0) {
              a(i2, i2);
            }
            this.ag = 3;
            i3 = d(paramInt);
            this.ai = 0;
            localObject = getChildAt(i3 - this.au);
            if (localObject == null) {
              break label771;
            }
          }
        }
        for (i2 = ((View)localObject).getTop();; i2 = 0)
        {
          this.ac = i2;
          this.af = paramInt;
          this.ab = i3;
          this.ah = paramInt;
          this.aO = i1;
          return;
          i1 = -1;
          break;
          i2 = 0;
          break label517;
          if (i5 >= 0) {
            break label620;
          }
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i3 / getHeight());
          if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) {
            break label620;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
          break label620;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1 - this.W, paramInt2 - this.X, this.Y + paramInt3, this.Z + paramInt4);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_AndroidGraphicsRect.isEmpty())
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.aL) {
      if (i1 != 0) {
        break label65;
      }
    }
    label65:
    for (i1 = 1;; i1 = 0)
    {
      this.ae = ((int)paramMotionEvent.getX(i1));
      this.af = ((int)paramMotionEvent.getY(i1));
      this.ai = 0;
      this.aL = paramMotionEvent.getPointerId(i1);
      return;
    }
  }
  
  private void a(View paramView)
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
        this.jdField_a_of_type_JavaLangReflectMethod = View.class.getMethod("dispatchStartTemporaryDetach", new Class[0]);
      }
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onStartTemporaryDetach();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      Context localContext = getContext();
      PopupWindow localPopupWindow = new PopupWindow(localContext);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2130905088, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setRawInputType(177);
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(268435456);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      localPopupWindow.setFocusable(false);
      localPopupWindow.setTouchable(false);
      localPopupWindow.setInputMethodMode(2);
      localPopupWindow.setContentView(this.jdField_a_of_type_AndroidWidgetEditText);
      localPopupWindow.setWidth(-2);
      localPopupWindow.setHeight(-2);
      localPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = localPopupWindow;
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      this.y = true;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558936);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558937);
  }
  
  private boolean a(int paramInt)
  {
    int i2 = paramInt - this.af;
    int i3 = Math.abs(i2);
    int i1;
    if (this.mScrollY != 0) {
      i1 = 1;
    }
    while (((i1 != 0) && (!this.l)) || (i3 > this.t))
    {
      h();
      if (i1 != 0)
      {
        this.ag = 5;
        this.ai = 0;
        Object localObject = getHandler();
        if (localObject != null) {
          ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_Xrs);
        }
        setPressed(false);
        localObject = getChildAt(this.ab - this.au);
        if (localObject != null) {
          ((View)localObject).setPressed(false);
        }
        b(1);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        a(paramInt);
        return true;
        i1 = 0;
      }
      else
      {
        this.ag = 3;
        if (i2 > 0) {}
        for (i1 = this.t;; i1 = -this.t)
        {
          this.ai = i1;
          break;
        }
      }
    }
    return false;
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramArrayList == null) {
      return bool2;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i1 >= i2) {
        break;
      }
      View localView = (View)paramArrayList.get(i1);
      if (localView.getParent() != null) {
        bool1 = false;
      }
      if (indexOfChild(localView) >= 0) {
        bool1 = false;
      }
      i1 += 1;
    }
  }
  
  private void b(View paramView)
  {
    try
    {
      View.class.getMethod("dispatchFinishTemporaryDetach", new Class[0]).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onFinishTemporaryDetach();
    }
  }
  
  private boolean b()
  {
    int i1 = getChildCount();
    if (i1 == 0) {}
    do
    {
      return true;
      if (i1 != this.aG) {
        return false;
      }
    } while ((getChildAt(0).getTop() >= this.jdField_c_of_type_AndroidGraphicsRect.top) && (getChildAt(i1 - 1).getBottom() <= getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom));
    return false;
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (this.aG > 0) && (paramInt1 != -1) && (paramInt1 < paramInt2);
  }
  
  private void c()
  {
    setClickable(true);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    setScrollingCacheEnabled(true);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.t = localViewConfiguration.getScaledTouchSlop();
    this.u = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.aK = localViewConfiguration.getScaledMaximumFlingVelocity();
    float f1 = getResources().getDisplayMetrics().density;
    this.a_ = ((int)(0.0F * f1 + 0.5F));
    int i1 = (int)(f1 * 30.0F + 0.5F);
    this.ar = i1;
    this.b_ = i1;
    this.jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    setOverScrollMode(0);
    setVerticalFadingEdgeEnabled(false);
  }
  
  private boolean c()
  {
    return (this.jdField_d_of_type_Boolean) && ((a() instanceof Filterable)) && (((Filterable)a()).getFilter() != null);
  }
  
  private void d()
  {
    setSelector(getResources().getDrawable(17301602));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void h()
  {
    if ((this.jdField_j_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      setChildrenDrawnWithCacheEnabled(true);
      setChildrenDrawingCacheEnabled(true);
      this.jdField_h_of_type_Boolean = true;
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    paramInt1 = b(paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
    }
    return Long.MIN_VALUE;
  }
  
  public Drawable a()
  {
    return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public SparseBooleanArray a()
  {
    if (this.S != 0) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
    }
    return null;
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  @ViewDebug.ExportedProperty
  public View a()
  {
    if ((this.aG > 0) && (this.aF >= 0) && (this.aF < this.aG)) {
      return getChildAt(this.aF - this.au);
    }
    return null;
  }
  
  public View a(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView2 = this.jdField_a_of_type_Xsa.b(paramInt);
    View localView1;
    if (localView2 != null)
    {
      localView1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView2, this);
      if (ViewCompat.getImportantForAccessibility(localView1) == 0) {
        ViewCompat.setImportantForAccessibility(localView1, 1);
      }
      if (localView1 != localView2)
      {
        this.jdField_a_of_type_Xsa.a(localView2, paramInt);
        paramArrayOfBoolean = localView1;
        if (this.an != 0)
        {
          localView1.setDrawingCacheBackgroundColor(this.an);
          paramArrayOfBoolean = localView1;
        }
      }
    }
    do
    {
      do
      {
        return paramArrayOfBoolean;
        paramArrayOfBoolean[0] = true;
        b(localView1);
        return localView1;
        localView1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, null, this);
        if (this.an != 0) {
          localView1.setDrawingCacheBackgroundColor(this.an);
        }
        paramArrayOfBoolean = localView1;
      } while (localView1 == null);
      paramArrayOfBoolean = localView1;
    } while (ViewCompat.getImportantForAccessibility(localView1) != 0);
    ViewCompat.setImportantForAccessibility(localView1, 1);
    return localView1;
  }
  
  public AbsListView.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new AbsListView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence a()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      return this.jdField_a_of_type_AndroidWidgetEditText.getText();
    }
    return null;
  }
  
  protected xrq a()
  {
    return new xrq(this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Xrz == null) {
      this.jdField_a_of_type_Xrz = new xrz(this);
    }
    this.jdField_a_of_type_Xrz.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramInt != -1) {
      this.V = paramInt;
    }
    Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    if ((paramView instanceof AbsListView.SelectionBoundsAdjuster)) {
      ((AbsListView.SelectionBoundsAdjuster)paramView).a(localRect);
    }
    a(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.x;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label114;
      }
    }
    label114:
    for (bool = true;; bool = false)
    {
      this.x = bool;
      if (r() != -1) {
        refreshDrawableState();
      }
      return;
    }
  }
  
  protected void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setBounds(paramInt1, this.mScrollY + paramInt2, paramInt3, this.mScrollY + paramInt4);
    paramDrawable.draw(paramCanvas);
  }
  
  public void a(List paramList)
  {
    int i2 = getChildCount();
    AbsListView.RecyclerListener localRecyclerListener = xsa.a(this.jdField_a_of_type_Xsa);
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (this.jdField_a_of_type_Xsa.a(localLayoutParams.jdField_a_of_type_Int)))
      {
        paramList.add(localView);
        if (localRecyclerListener != null) {
          localRecyclerListener.b(localView);
        }
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Xsa.a(paramList);
    removeAllViewsInLayout();
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt)
  {
    paramInt = b((int)paramFloat1, (int)paramFloat2);
    if (paramInt != -1)
    {
      long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
      View localView = getChildAt(paramInt - this.au);
      if (localView != null)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(localView, paramInt, l1);
        return super.showContextMenuForChild(this);
      }
    }
    return super.showContextMenu();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i10 = getChildCount();
    if (i10 == 0) {
      return true;
    }
    d("AbsListView.trackMotionScroll");
    int i7;
    int i8;
    int i3;
    int i2;
    int i9;
    int i1;
    int i4;
    int i5;
    int i11;
    label231:
    boolean bool1;
    label262:
    label314:
    for (;;)
    {
      try
      {
        i7 = getChildAt(0).getTop();
        i8 = getChildAt(i10 - 1).getBottom();
        Rect localRect = this.jdField_c_of_type_AndroidGraphicsRect;
        i3 = 0;
        i2 = 0;
        if ((this.mGroupFlags & 0x22) == 34)
        {
          i3 = localRect.top;
          i2 = localRect.bottom;
        }
        i9 = getHeight();
        i1 = getHeight() - this.mPaddingBottom - this.mPaddingTop;
        if (paramInt1 < 0)
        {
          i4 = Math.max(-(i1 - 1), paramInt1);
          if (paramInt2 < 0)
          {
            i5 = Math.max(-(i1 - 1), paramInt2);
            i11 = this.au;
            if (i11 != 0) {
              continue;
            }
            this.aM = (i7 - localRect.top);
            if (i11 + i10 != this.aG) {
              break label314;
            }
            this.aN = (localRect.bottom + i8);
            if ((i11 != 0) || (i7 < localRect.top) || (i5 < 0)) {
              break label766;
            }
            paramInt1 = 1;
            if ((i11 + i10 != this.aG) || (i8 > getHeight() - localRect.bottom) || (i5 > 0)) {
              break label771;
            }
            paramInt2 = 1;
            break;
            if ((this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollButtomListener != null) && (i5 <= 0)) {
              this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollButtomListener.q(i5);
            }
            if (i5 == 0) {
              break label776;
            }
            bool1 = true;
            return bool1;
          }
        }
        else
        {
          i4 = Math.min(i1 - 1, paramInt1);
          continue;
        }
        i5 = Math.min(i1 - 1, paramInt2);
        continue;
        this.aM += i5;
        continue;
        this.aN += i5;
      }
      finally
      {
        D();
      }
    }
    label328:
    int i12;
    int i13;
    label395:
    View localView;
    for (;;)
    {
      boolean bool2 = isInTouchMode();
      if (bool2) {
        p();
      }
      i12 = m();
      i13 = this.aG - n();
      paramInt2 = 0;
      if (!bool1) {
        break label611;
      }
      paramInt1 = -i5;
      paramInt2 = paramInt1;
      if ((this.mGroupFlags & 0x22) != 34) {
        break label793;
      }
      paramInt2 = paramInt1 + ((Rect)localObject).top;
      break label793;
      if (i1 >= i10) {
        break label801;
      }
      localView = getChildAt(i1);
      if (localView.getBottom() < paramInt2) {
        break;
      }
      break label801;
      label420:
      this.ad = (this.ac + i4);
      this.jdField_s_of_type_Boolean = true;
      if (paramInt1 > 0) {
        detachViewsFromParent(paramInt2, paramInt1);
      }
      offsetChildrenTopAndBottom(i5);
      if (bool1) {
        this.au = (paramInt1 + this.au);
      }
      invalidate();
      paramInt1 = Math.abs(i5);
      if ((i3 - i7 < paramInt1) || (i8 - (i9 - i2) < paramInt1)) {
        d(bool1);
      }
      if ((bool2) || (this.aF == -1)) {
        break label699;
      }
      paramInt1 = this.aF - this.au;
      if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
        a(this.aF, getChildAt(paramInt1));
      }
      label552:
      this.jdField_s_of_type_Boolean = false;
      j();
      awakenScrollBars();
      D();
      return false;
      label571:
      bool1 = false;
    }
    int i6 = i11 + i1;
    if ((i6 >= i12) && (i6 < i13))
    {
      this.jdField_a_of_type_Xsa.a(localView, i6);
      break label806;
      label611:
      paramInt1 = getHeight() - i5;
      i6 = paramInt1;
      if ((this.mGroupFlags & 0x22) != 34) {
        break label819;
      }
      i6 = paramInt1 - localView.bottom;
      break label819;
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        localView = getChildAt(i1);
        if (localView.getTop() <= i6) {
          break label420;
        }
        paramInt2 = i11 + i1;
        if ((paramInt2 < i12) || (paramInt2 >= i13)) {
          break label830;
        }
        this.jdField_a_of_type_Xsa.a(localView, paramInt2);
        break label830;
        label699:
        if (this.V != -1)
        {
          paramInt1 = this.V - this.au;
          if ((paramInt1 < 0) || (paramInt1 >= getChildCount())) {
            break label552;
          }
          a(-1, getChildAt(paramInt1));
          break label552;
        }
        this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
        break label552;
      }
      break label420;
      for (;;)
      {
        if (paramInt1 != 0) {
          break label774;
        }
        if (paramInt2 == 0) {
          break label782;
        }
        break label231;
        label766:
        paramInt1 = 0;
        break;
        label771:
        paramInt2 = 0;
      }
      label774:
      break label231;
      label776:
      bool1 = false;
      break label262;
      label782:
      if (i5 >= 0) {
        break label571;
      }
      bool1 = true;
      break label328;
      label793:
      paramInt1 = 0;
      i1 = 0;
      break label395;
      label801:
      paramInt2 = 0;
      break label420;
      label806:
      i1 += 1;
      paramInt1 += 1;
      break label395;
      label819:
      paramInt1 = 0;
      i1 = i10 - 1;
      continue;
      label830:
      paramInt1 += 1;
      paramInt2 = i1;
      i1 -= 1;
    }
  }
  
  boolean a(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (!c()) {
      return false;
    }
    boolean bool2;
    boolean bool1;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      bool2 = true;
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 66: 
      for (bool1 = false;; bool1 = false)
      {
        if (bool2)
        {
          a(true);
          if (paramKeyEvent.getRepeatCount() <= 0) {
            break;
          }
          localObject = KeyEvent.changeTimeRepeat(paramKeyEvent, paramKeyEvent.getEventTime(), 0);
        }
        switch (paramKeyEvent.getAction())
        {
        default: 
          return bool1;
          bool2 = false;
        }
      }
    case 4: 
      label118:
      label148:
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localObject = getKeyDispatcherState();
          if (localObject != null) {
            ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
          }
          bool1 = true;
        }
      }
      break;
    }
    for (;;)
    {
      bool2 = false;
      break;
      if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        bool1 = true;
        continue;
        bool2 = this.jdField_e_of_type_Boolean;
        bool1 = false;
        break;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyDown(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyUp(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
        break label148;
        localObject = paramKeyEvent;
        break label118;
      }
      bool1 = false;
    }
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    int i1 = 1;
    int i2 = 0;
    if ((b(paramInt, ((ListAdapter)a()).getCount())) && (this.S != 0)) {
      if ((this.S == 2) || ((this.S == 3) && (this.jdField_a_of_type_AndroidViewActionMode != null))) {
        if (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false))
        {
          bool1 = true;
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, bool1);
          if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
          {
            if (!bool1) {
              break label213;
            }
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          label126:
          if (!bool1) {
            break label233;
          }
          this.T += 1;
          label141:
          if (this.jdField_a_of_type_AndroidViewActionMode == null) {
            break label380;
          }
          this.jdField_a_of_type_Xrx.a(this.jdField_a_of_type_AndroidViewActionMode, paramInt, paramLong, bool1);
          i1 = i2;
          label167:
          this.jdField_r_of_type_Boolean = true;
          t();
          requestLayout();
        }
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (i1 != 0) {
        bool2 = bool1 | super.a(paramView, paramInt, paramLong);
      }
      return bool2;
      bool1 = false;
      break;
      label213:
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt));
      break label126;
      label233:
      this.T -= 1;
      break label141;
      if (this.S == 1)
      {
        if (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false)) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label354;
          }
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
          if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
          {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.T = 1;
          i1 = 1;
          break;
        }
        label354:
        if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 0) || (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(0))) {
          this.T = 0;
        }
      }
      label380:
      i1 = 1;
      break label167;
    }
  }
  
  public long[] a()
  {
    int i1 = 0;
    Object localObject;
    if ((this.S == 0) || (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) || (this.jdField_a_of_type_AndroidWidgetListAdapter == null))
    {
      localObject = new long[0];
      return (long[])localObject;
    }
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_ComTencentUtilLongSparseArray;
    int i2 = localLongSparseArray.a();
    long[] arrayOfLong = new long[i2];
    for (;;)
    {
      localObject = arrayOfLong;
      if (i1 >= i2) {
        break;
      }
      arrayOfLong[i1] = localLongSparseArray.a(i1);
      i1 += 1;
    }
  }
  
  public void addChildrenForAccessibility(ArrayList paramArrayList)
  {
    int i2;
    int i1;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i2 = getChildCount();
        i1 = 0;
      }
    } while (i1 >= i2);
    View localView = getChildAt(i1);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label54;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label54:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i2 = getChildCount();
    int i3 = this.au;
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localListAdapter == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = getChildAt(i1);
        if (localListAdapter.isEnabled(i3 + i1)) {
          paramArrayList.add(localView);
        }
        localView.addTouchables(paramArrayList);
        i1 += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public float b()
  {
    if ((this.jdField_a_of_type_Xru != null) && (xru.a(this.jdField_a_of_type_Xru) != null)) {
      return xru.a(this.jdField_a_of_type_Xru).a();
    }
    return -1.0F;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.au + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (paramInt != this.jdField_s_of_type_Int)
    {
      this.jdField_s_of_type_Int = paramInt;
      if (AppSetting.p) {
        if (paramInt == 0) {
          break label48;
        }
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      ThreadPriorityManager.a(bool);
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(this, paramInt);
      }
      return;
    }
  }
  
  public boolean b(int paramInt)
  {
    if ((this.S != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null)) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    }
    return false;
  }
  
  protected boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      if (getWindowVisibility() != 0) {
        break label60;
      }
    }
    label60:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((this.jdField_e_of_type_Boolean) && (paramInt1 != 0) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        H();
      }
      return bool;
    }
  }
  
  public boolean b(View paramView, int paramInt, long paramLong)
  {
    boolean bool1 = true;
    if (this.S == 3)
    {
      bool2 = bool1;
      if (VersionUtils.e())
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_AndroidViewActionMode == null)
        {
          paramView = startActionMode(this.jdField_a_of_type_Xrx);
          this.jdField_a_of_type_AndroidViewActionMode = paramView;
          bool2 = bool1;
          if (paramView != null)
          {
            setItemChecked(paramInt, true);
            performHapticFeedback(0);
            bool2 = bool1;
          }
        }
      }
      return bool2;
    }
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {}
    for (boolean bool2 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, paramView, paramInt, paramLong);; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(paramView, paramInt, paramLong);
        bool1 = super.showContextMenuForChild(this);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      performHapticFeedback(0);
      return bool1;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  abstract int c(int paramInt);
  
  public void c(int paramInt1, int paramInt2) {}
  
  protected boolean c(int paramInt)
  {
    boolean bool1 = super.onConsistencyCheck(paramInt);
    if ((paramInt & 0x1) != 0) {}
    boolean bool2;
    for (paramInt = 1;; paramInt = 0)
    {
      bool2 = bool1;
      if (paramInt == 0) {
        break label121;
      }
      localObject = xsa.a(this.jdField_a_of_type_Xsa);
      i1 = localObject.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        if (localObject[paramInt] != null) {
          bool1 = false;
        }
        paramInt += 1;
      }
    }
    if (!a(xsa.a(this.jdField_a_of_type_Xsa))) {
      bool1 = false;
    }
    Object localObject = xsa.a(this.jdField_a_of_type_Xsa);
    int i1 = localObject.length;
    paramInt = 0;
    for (;;)
    {
      bool2 = bool1;
      if (paramInt >= i1) {
        break;
      }
      if (!a(localObject[paramInt])) {
        bool1 = false;
      }
      paramInt += 1;
    }
    label121:
    return bool2;
  }
  
  protected boolean c(MotionEvent paramMotionEvent)
  {
    return (VersionUtils.d()) && ((paramMotionEvent.getButtonState() & 0x2) != 0) && (a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
  }
  
  protected boolean c_()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return paramView == this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AbsListView.LayoutParams;
  }
  
  public int computeVerticalScrollExtent()
  {
    int i3 = getChildCount();
    if (i3 > 0)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        int i2 = i3 * 100;
        View localView = getChildAt(0);
        int i4 = localView.getTop();
        int i5 = localView.getHeight();
        int i1 = i2;
        if (i5 > 0) {
          i1 = i2 + i4 * 100 / i5;
        }
        localView = getChildAt(i3 - 1);
        i3 = localView.getBottom();
        i4 = localView.getHeight();
        i2 = i1;
        if (i4 > 0) {
          i2 = i1 - (i3 - getHeight()) * 100 / i4;
        }
        return i2;
      }
      return 1;
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    int i3 = 0;
    int i2 = 0;
    int i4 = this.au;
    int i5 = getChildCount();
    int i1 = i2;
    if (i4 >= 0)
    {
      i1 = i2;
      if (i5 > 0)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label93;
        }
        View localView = getChildAt(0);
        i3 = localView.getTop();
        i5 = localView.getHeight();
        i1 = i2;
        if (i5 > 0) {
          i1 = Math.max(i4 * 100 - i3 * 100 / i5, 0);
        }
      }
    }
    return i1;
    label93:
    i2 = this.aG;
    if (i4 == 0) {
      i1 = i3;
    }
    for (;;)
    {
      float f1 = i4;
      float f2 = i5;
      return (int)(i1 / i2 * f2 + f1);
      if (i4 + i5 == i2) {
        i1 = i2;
      } else {
        i1 = i5 / 2 + i4;
      }
    }
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.jdField_c_of_type_Boolean) {
      return Math.max(this.aG * 100, 0);
    }
    return this.aG;
  }
  
  int d(int paramInt)
  {
    int i2 = getChildCount();
    if (i2 == 0) {
      paramInt = -1;
    }
    int i1;
    do
    {
      return paramInt;
      i1 = c(paramInt);
      paramInt = i1;
    } while (i1 != -1);
    return this.au + i2 - 1;
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = new xru(this);
    }
    this.jdField_a_of_type_Xru.b(paramInt);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Xrz == null) {
      this.jdField_a_of_type_Xrz = new xrz(this);
    }
    this.jdField_a_of_type_Xrz.b(paramInt1, paramInt2);
  }
  
  abstract void d(boolean paramBoolean);
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    if ((this.mGroupFlags & 0x22) == 34) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        int i3 = getScrollX();
        int i4 = getScrollY();
        paramCanvas.clipRect(this.mPaddingLeft + i3, this.mPaddingTop + i4, i3 + this.mRight - this.mLeft - this.mPaddingRight, i4 + this.mBottom - this.mTop - this.mPaddingBottom);
        this.mGroupFlags &= 0xFFFFFFDD;
      }
      boolean bool = this.jdField_f_of_type_Boolean;
      if (!bool) {
        a(paramCanvas);
      }
      super.dispatchDraw(paramCanvas);
      if (bool) {
        a(paramCanvas);
      }
      if (i1 != 0)
      {
        paramCanvas.restoreToCount(i2);
        this.mGroupFlags |= 0x22;
      }
      return;
    }
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.C) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    do
    {
      do
      {
        return bool;
      } while ((this.ag != -1) || (Math.abs(this.mScrollY) <= this.t));
      if (this.jdField_a_of_type_Xru == null) {
        this.jdField_a_of_type_Xru = new xru(this);
      }
      int i1 = 0;
      if (this.l) {
        i1 = l();
      }
      this.jdField_a_of_type_Xru.b(i1);
    } while (!QLog.isColorLevel());
    QLog.i("ListViewOverScroll", 2, "dispatchTouchEvent, springback, mScrollY = " + this.mScrollY);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      i1 = this.mScrollY;
      int i3;
      int i4;
      int i5;
      if (!this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i2 = paramCanvas.save();
        i3 = this.jdField_c_of_type_AndroidGraphicsRect.left + this.aP;
        i4 = this.jdField_c_of_type_AndroidGraphicsRect.right;
        i5 = this.aQ;
        int i6 = getWidth();
        paramCanvas.translate(i3, Math.min(0, this.aM + i1));
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i6 - i3 - (i4 + i5), getHeight());
        if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i2);
      }
      if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i2 = paramCanvas.save();
        i3 = this.jdField_c_of_type_AndroidGraphicsRect.left + this.aP;
        i4 = this.jdField_c_of_type_AndroidGraphicsRect.right;
        i5 = this.aQ;
        i4 = getWidth() - i3 - (i4 + i5);
        i5 = getHeight();
        paramCanvas.translate(i3 + -i4, Math.max(i5, i1 + this.aN));
        paramCanvas.rotate(180.0F, i4, 0.0F);
        this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i4, i5);
        if (this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i2);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null)
    {
      i1 = this.mScrollY;
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        paramCanvas.translate(0.0F, i1);
        this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    o();
  }
  
  public int e()
  {
    return this.T;
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_Xrz == null) {
      this.jdField_a_of_type_Xrz = new xrz(this);
    }
    this.jdField_a_of_type_Xrz.a(paramInt);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Xrz == null) {
      this.jdField_a_of_type_Xrz = new xrz(this);
    }
    this.jdField_a_of_type_Xrz.a(paramInt1, paramInt2);
  }
  
  public int f()
  {
    if ((this.S == 1) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 1)) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(0);
    }
    return -1;
  }
  
  void f(int paramInt)
  {
    int i1;
    if (paramInt < 0) {
      i1 = s();
    }
    for (;;)
    {
      int i2;
      float f1;
      if (i1 > -1)
      {
        View localView = getChildAt(i1 - s());
        if (localView != null)
        {
          Rect localRect = new Rect();
          i2 = i1;
          if (localView.getGlobalVisibleRect(localRect))
          {
            i2 = localView.getWidth();
            int i3 = localView.getHeight();
            int i4 = localRect.width();
            f1 = localRect.height() * i4 / (i3 * i2);
            if ((paramInt >= 0) || (f1 >= 0.75F)) {
              break label141;
            }
            i2 = i1 + 1;
          }
        }
      }
      for (;;)
      {
        e(Math.max(0, Math.min(d_(), i2 + paramInt)));
        return;
        if (paramInt <= 0) {
          break label170;
        }
        i1 = t();
        break;
        label141:
        i2 = i1;
        if (paramInt > 0)
        {
          i2 = i1;
          if (f1 < 0.75F) {
            i2 = i1 - 1;
          }
        }
      }
      label170:
      i1 = -1;
    }
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = new xru(this);
    }
    int i1 = this.au;
    int i2 = getChildCount();
    int i3 = this.mPaddingTop;
    int i4 = getHeight();
    int i5 = this.mPaddingBottom;
    if ((paramInt1 == 0) || (this.aG == 0) || (i2 == 0) || ((i1 == 0) && (getChildAt(0).getTop() == i3) && (paramInt1 < 0)) || ((i1 + i2 - 1 == this.aG - 1) && (getChildAt(i2 - 1).getBottom() == i4 - i5) && (paramInt1 > 0)))
    {
      this.jdField_a_of_type_Xru.a();
      if (this.jdField_a_of_type_Xrz != null) {
        this.jdField_a_of_type_Xrz.a();
      }
      if (this.jdField_a_of_type_Xrw != null) {
        this.jdField_a_of_type_Xrw.b();
      }
      return;
    }
    b(2);
    this.jdField_a_of_type_Xru.a(paramInt1, paramInt2);
  }
  
  public int g()
  {
    return this.S;
  }
  
  abstract void g(int paramInt);
  
  public boolean g()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.a());
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new AbsListView.LayoutParams(-1, -2, 0);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new AbsListView.LayoutParams(paramLayoutParams);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getBottomFadingEdgeStrength();
    if (i1 == 0) {}
    int i2;
    float f2;
    do
    {
      return f1;
      if (this.au + i1 - 1 < this.aG - 1) {
        return 1.0F;
      }
      i1 = getChildAt(i1 - 1).getBottom();
      i2 = getHeight();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 <= i2 - this.mPaddingBottom);
    return (i1 - i2 + this.mPaddingBottom) / f2;
  }
  
  protected int getBottomPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingBottom;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    View localView = a();
    if ((localView != null) && (localView.getParent() == this))
    {
      localView.getFocusedRect(paramRect);
      offsetDescendantRectToMyCoords(localView, paramRect);
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  protected int getLeftPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingLeft();
  }
  
  public int getOverScrollMode()
  {
    return this.aU;
  }
  
  protected int getRightPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingRight;
  }
  
  public int getSolidColor()
  {
    return this.an;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getTopFadingEdgeStrength();
    if (i1 == 0) {}
    float f2;
    do
    {
      return f1;
      if (this.au > 0) {
        return 1.0F;
      }
      i1 = getChildAt(0).getTop();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 >= this.mPaddingTop);
    return -(i1 - this.mPaddingTop) / f2;
  }
  
  protected int getTopPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingTop();
  }
  
  public int getVerticalScrollbarWidth()
  {
    if (g()) {
      return Math.max(super.getVerticalScrollbarWidth(), this.jdField_a_of_type_ComTencentWidgetFastScroller.a());
    }
    return super.getVerticalScrollbarWidth();
  }
  
  public int h()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.top;
  }
  
  @ViewDebug.ExportedProperty
  public boolean h()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int i()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.bottom;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    }
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    }
    this.T = 0;
  }
  
  protected boolean i()
  {
    return (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.b());
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable)) {
      invalidate(paramDrawable.getBounds());
    }
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.mGroupFlags & 0x22) != 34;
  }
  
  public int j()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.left;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(this, this.au, getChildCount(), this.aG);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(this, this.au, getChildCount(), this.aG);
    }
    onScrollChanged(0, 0, 0, 0);
  }
  
  @ViewDebug.ExportedProperty
  public boolean j()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
  }
  
  public int k()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.right;
  }
  
  void k()
  {
    if (getChildCount() > 0)
    {
      l();
      requestLayout();
      invalidate();
    }
  }
  
  @ViewDebug.ExportedProperty
  public boolean k()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public int l()
  {
    return 0;
  }
  
  void l()
  {
    removeAllViewsInLayout();
    this.au = 0;
    this.jdField_r_of_type_Boolean = true;
    this.p = false;
    this.aJ = -1;
    this.jdField_g_of_type_Long = Long.MIN_VALUE;
    h(-1);
    i(-1);
    this.aj = 0;
    this.V = -1;
    this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
    invalidate();
  }
  
  @ViewDebug.ExportedProperty
  public boolean l()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  int m()
  {
    return 0;
  }
  
  void m()
  {
    int i4 = 1;
    int i3 = 0;
    int i1;
    int i2;
    label57:
    View localView;
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      if (this.au > 0)
      {
        i1 = 1;
        i2 = i1;
        if (i1 == 0)
        {
          i2 = i1;
          if (getChildCount() > 0)
          {
            if (getChildAt(0).getTop() >= this.jdField_c_of_type_AndroidGraphicsRect.top) {
              break label159;
            }
            i2 = 1;
          }
        }
        localView = this.jdField_e_of_type_AndroidViewView;
        if (i2 == 0) {
          break label164;
        }
        i1 = 0;
        label68:
        localView.setVisibility(i1);
      }
    }
    else if (this.jdField_f_of_type_AndroidViewView != null)
    {
      i2 = getChildCount();
      if (this.au + i2 >= this.aG) {
        break label169;
      }
      i1 = 1;
      label100:
      if ((i1 != 0) || (i2 <= 0)) {
        break label184;
      }
      if (getChildAt(i2 - 1).getBottom() <= this.mBottom - this.jdField_c_of_type_AndroidGraphicsRect.bottom) {
        break label174;
      }
      i1 = i4;
    }
    label136:
    label159:
    label164:
    label169:
    label174:
    label184:
    for (;;)
    {
      localView = this.jdField_f_of_type_AndroidViewView;
      if (i1 != 0) {}
      for (i1 = i3;; i1 = 4)
      {
        localView.setVisibility(i1);
        return;
        i1 = 0;
        break;
        i2 = 0;
        break label57;
        i1 = 4;
        break label68;
        i1 = 0;
        break label100;
        i1 = 0;
        break label136;
      }
    }
  }
  
  @ViewDebug.ExportedProperty
  public boolean m()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  int n()
  {
    return 0;
  }
  
  void n()
  {
    if ((!isEnabled()) || (!isClickable())) {}
    for (;;)
    {
      return;
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
      if ((localDrawable != null) && ((isFocused()) || (n())) && (!((Rect)localObject).isEmpty()))
      {
        localObject = getChildAt(this.aF - this.au);
        if (localObject != null)
        {
          if (!((View)localObject).hasFocusable()) {
            ((View)localObject).setPressed(true);
          }
        }
        else
        {
          setPressed(true);
          boolean bool = isLongClickable();
          localDrawable = localDrawable.getCurrent();
          if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label172;
            }
            ((TransitionDrawable)localDrawable).startTransition(ViewConfiguration.getLongPressTimeout());
          }
          while ((bool) && (!this.jdField_r_of_type_Boolean))
          {
            if (this.jdField_a_of_type_Xrr == null) {
              this.jdField_a_of_type_Xrr = new xrr(this, null);
            }
            this.jdField_a_of_type_Xrr.a();
            postDelayed(this.jdField_a_of_type_Xrr, ViewConfiguration.getLongPressTimeout());
            return;
            label172:
            ((TransitionDrawable)localDrawable).resetTransition();
          }
        }
      }
    }
  }
  
  boolean n()
  {
    switch (this.ag)
    {
    default: 
      return false;
    }
    return true;
  }
  
  int o()
  {
    int i2 = this.aF;
    int i1 = i2;
    if (i2 < 0) {
      i1 = this.ak;
    }
    return Math.min(Math.max(0, i1), this.aG - 1);
  }
  
  void o()
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (o()) {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_b_of_type_ArrayOfInt);
  }
  
  public boolean o()
  {
    return ((hasFocus()) && (!isInTouchMode())) || (n());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    localViewTreeObserver.addOnTouchModeChangeListener(this);
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.y)) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Xrq == null))
    {
      this.jdField_a_of_type_Xrq = a();
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Xrq);
      this.jdField_r_of_type_Boolean = true;
      this.aH = this.aG;
      this.aG = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      requestLayout();
    }
    this.n = true;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    Object localObject;
    if (this.x)
    {
      localObject = super.onCreateDrawableState(paramInt);
      return (int[])localObject;
    }
    int i1 = ENABLED_STATE_SET[0];
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    paramInt = arrayOfInt.length - 1;
    label35:
    if (paramInt >= 0) {
      if (arrayOfInt[paramInt] != i1) {}
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (paramInt < 0) {
        break;
      }
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
      return arrayOfInt;
      paramInt -= 1;
      break label35;
      paramInt = -1;
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (l())
    {
      a(false);
      if (this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper == null)
      {
        this.jdField_a_of_type_AndroidViewInputmethodInputConnection = new BaseInputConnection(this, false);
        this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper = new xrp(this, this.jdField_a_of_type_AndroidWidgetEditText.onCreateInputConnection(paramEditorInfo), true);
      }
      paramEditorInfo.inputType = 177;
      paramEditorInfo.imeOptions = 6;
      return this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper;
    }
    return null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    F();
    try
    {
      this.jdField_a_of_type_Xsa.b();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      localViewTreeObserver.removeOnTouchModeChangeListener(this);
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null))
      {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
        this.y = false;
      }
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Xrq != null))
      {
        this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Xrq);
        this.jdField_a_of_type_Xrq = null;
      }
      if (this.jdField_a_of_type_JavaLangObject != null) {
        this.jdField_a_of_type_JavaLangObject = a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_b_of_type_JavaLangObject != null) {
        this.jdField_b_of_type_JavaLangObject = a(this.jdField_b_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_Xru != null) {
        removeCallbacks(this.jdField_a_of_type_Xru);
      }
      if (this.jdField_a_of_type_Xrz != null) {
        this.jdField_a_of_type_Xrz.a();
      }
      if (this.jdField_a_of_type_Xrw != null) {
        this.jdField_a_of_type_Xrw.b();
      }
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_Xry != null) {
        removeCallbacks(this.jdField_a_of_type_Xry);
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
      this.n = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onDisplayHint(int paramInt)
  {
    super.onDisplayHint(paramInt);
    switch (paramInt)
    {
    default: 
      if (paramInt != 4) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.z = bool;
      return;
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break;
      }
      F();
      break;
      if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break;
      }
      G();
      break;
    }
  }
  
  public void onFilterComplete(int paramInt)
  {
    if ((this.aF < 0) && (paramInt > 0))
    {
      this.ak = -1;
      q();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.aF < 0) && (!isInTouchMode()))
    {
      if ((!this.n) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null))
      {
        this.jdField_r_of_type_Boolean = true;
        this.aH = this.aG;
        this.aG = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      }
      q();
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    int i1;
    do
    {
      float f1;
      do
      {
        do
        {
          return super.onGenericMotionEvent(paramMotionEvent);
        } while (this.ag != -1);
        f1 = paramMotionEvent.getAxisValue(9);
      } while (f1 == 0.0F);
      i1 = (int)(f1 * c());
    } while (a(i1, i1));
    return true;
  }
  
  public void onGlobalLayout()
  {
    if (isShown()) {
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (!this.z)) {
        G();
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      return;
    }
    F();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(android.widget.AbsListView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(android.widget.AbsListView.class.getName());
    if (isEnabled())
    {
      if (s() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (t() < d_() - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1 = paramMotionEvent.getAction();
    if ((this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramMotionEvent))) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        switch (i1 & 0xFF)
        {
        case 4: 
        case 5: 
        default: 
          return false;
        case 0: 
          i1 = this.ag;
          if ((i1 == 6) || (i1 == 5))
          {
            this.ai = 0;
            return true;
          }
          i2 = (int)paramMotionEvent.getX();
          int i3 = (int)paramMotionEvent.getY();
          this.aL = paramMotionEvent.getPointerId(0);
          int i4 = d(i3);
          if ((i1 != 4) && (i4 >= 0))
          {
            this.ac = getChildAt(i4 - this.au).getTop();
            this.ae = i2;
            this.af = i3;
            this.ab = i4;
            this.ag = 0;
            E();
          }
          this.ah = Integer.MIN_VALUE;
          e();
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        }
      } while (i1 != 4);
      return true;
      switch (this.ag)
      {
      default: 
        return false;
      }
      int i2 = paramMotionEvent.findPointerIndex(this.aL);
      i1 = i2;
      if (i2 == -1)
      {
        this.aL = paramMotionEvent.getPointerId(0);
        i1 = 0;
      }
      if (this.jdField_r_of_type_Boolean) {
        v_();
      }
      i1 = (int)paramMotionEvent.getY(i1);
      f();
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    } while (!a(i1));
    return true;
    this.ag = -1;
    this.aL = -1;
    g();
    b(0);
    return false;
    a(paramMotionEvent);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    do
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      do
      {
        return bool;
      } while (!isEnabled());
    } while ((!isClickable()) || (!isPressed()) || (this.aF < 0) || (this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (this.aF >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()));
    paramKeyEvent = getChildAt(this.aF - this.au);
    if (paramKeyEvent != null)
    {
      a(paramKeyEvent, this.aF, this.jdField_e_of_type_Long);
      paramKeyEvent.setPressed(false);
    }
    setPressed(false);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    d("AbsListView.onLayout");
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.jdField_q_of_type_Boolean = true;
      if (paramBoolean)
      {
        paramInt3 = getChildCount();
        paramInt1 = i1;
        while (paramInt1 < paramInt3)
        {
          getChildAt(paramInt1).forceLayout();
          paramInt1 += 1;
        }
        this.jdField_a_of_type_Xsa.a();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.aG != this.aH)) {
        this.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.aH, this.aG);
      }
      v_();
      this.jdField_q_of_type_Boolean = false;
      this.al = ((paramInt4 - paramInt2) / 3);
      if (this.m)
      {
        if (this.jdField_a_of_type_Xrw == null) {
          this.jdField_a_of_type_Xrw = new xrw(this);
        }
        this.jdField_a_of_type_Xrw.a();
      }
      return;
    }
    finally
    {
      D();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
      d();
    }
    Object localObject = this.jdField_c_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left = (this.W + this.mPaddingLeft);
    ((Rect)localObject).top = (this.X + this.mPaddingTop);
    ((Rect)localObject).right = (this.Y + this.mPaddingRight);
    ((Rect)localObject).bottom = (this.Z + this.mPaddingBottom);
    if (this.jdField_r_of_type_Int == 1)
    {
      int i1 = getChildCount();
      if (i1 > 0)
      {
        paramInt2 = getHeight() - this.mPaddingBottom;
        localObject = getChildAt(i1 - 1);
        if (localObject == null) {
          break label144;
        }
        paramInt1 = ((View)localObject).getBottom();
        if ((i1 + this.au < this.aT) || (paramInt1 > paramInt2)) {
          break label149;
        }
      }
    }
    label144:
    label149:
    for (boolean bool = true;; bool = false)
    {
      this.A = bool;
      return;
      paramInt1 = paramInt2;
      break;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getScrollY() != paramInt2)
    {
      onScrollChanged(getScrollX(), paramInt2, getScrollX(), getScrollY());
      this.mScrollY = paramInt2;
      B();
      awakenScrollBars();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsListView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_r_of_type_Boolean = true;
    this.jdField_c_of_type_Long = paramParcelable.jdField_c_of_type_Int;
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.p = true;
      this.jdField_b_of_type_Long = paramParcelable.jdField_a_of_type_Long;
      this.ax = paramParcelable.jdField_b_of_type_Int;
      this.av = paramParcelable.jdField_a_of_type_Int;
      this.aw = paramParcelable.jdField_a_of_type_Int;
      this.ay = 0;
    }
    for (;;)
    {
      setFilterText(paramParcelable.jdField_a_of_type_JavaLangString);
      if (paramParcelable.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray = paramParcelable.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      }
      if (paramParcelable.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray = paramParcelable.jdField_a_of_type_ComTencentUtilLongSparseArray;
      }
      this.T = paramParcelable.jdField_d_of_type_Int;
      if ((VersionUtils.e()) && (paramParcelable.jdField_a_of_type_Boolean) && (this.S == 3) && (this.jdField_a_of_type_Xrx != null)) {
        this.jdField_a_of_type_AndroidViewActionMode = startActionMode(this.jdField_a_of_type_Xrx);
      }
      requestLayout();
      return;
      if (paramParcelable.jdField_b_of_type_Long >= 0L)
      {
        h(-1);
        i(-1);
        this.V = -1;
        if (paramParcelable.jdField_b_of_type_Int != Integer.MAX_VALUE)
        {
          this.p = true;
          this.jdField_b_of_type_Long = paramParcelable.jdField_b_of_type_Long;
          if (!this.jdField_i_of_type_Boolean)
          {
            this.ax = paramParcelable.jdField_b_of_type_Int;
            this.av = paramParcelable.jdField_a_of_type_Int;
            this.ay = 1;
          }
          else
          {
            this.ax = paramParcelable.jdField_b_of_type_Int;
            this.aw = paramParcelable.jdField_a_of_type_Int;
            this.ay = 2;
          }
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    boolean bool = true;
    int i3 = 0;
    F();
    AbsListView.SavedState localSavedState = new AbsListView.SavedState(super.onSaveInstanceState());
    int i1;
    Object localObject;
    if ((getChildCount() > 0) && (this.aG > 0))
    {
      i1 = 1;
      localSavedState.jdField_c_of_type_Int = this.az;
      if (this.aF < 0) {
        break label270;
      }
      localSavedState.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
      if (i1 != 0)
      {
        localSavedState.jdField_b_of_type_Int = r();
        localObject = getChildAt(this.aF - this.au);
        if (localObject != null)
        {
          if (!this.jdField_i_of_type_Boolean) {
            break label262;
          }
          i1 = this.az - ((View)localObject).getBottom();
          label108:
          localSavedState.jdField_a_of_type_Int = i1;
        }
        localSavedState.jdField_b_of_type_Long = -1L;
      }
      label120:
      localSavedState.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText();
          if (localObject != null) {
            localSavedState.jdField_a_of_type_JavaLangString = localObject.toString();
          }
        }
      }
      if ((this.S != 3) || (this.jdField_a_of_type_AndroidViewActionMode == null)) {
        break label529;
      }
    }
    for (;;)
    {
      localSavedState.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
        localSavedState.jdField_a_of_type_AndroidUtilSparseBooleanArray = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clone();
      }
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) {
        break label540;
      }
      localObject = new LongSparseArray();
      int i2 = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
      i1 = i3;
      while (i1 < i2)
      {
        ((LongSparseArray)localObject).a(this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1), this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1));
        i1 += 1;
      }
      i1 = 0;
      break;
      label262:
      i1 = ((View)localObject).getTop();
      break label108;
      label270:
      if (!this.jdField_i_of_type_Boolean)
      {
        if ((i1 != 0) && (this.au >= 0))
        {
          localSavedState.jdField_a_of_type_Int = getChildAt(0).getTop();
          i2 = this.au;
          i1 = i2;
          if (i2 >= this.aG) {
            i1 = this.aG - 1;
          }
          localSavedState.jdField_b_of_type_Int = i1;
          localSavedState.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i1);
          break label120;
        }
        localSavedState.jdField_a_of_type_Int = 0;
        localSavedState.jdField_b_of_type_Long = -1L;
        localSavedState.jdField_b_of_type_Int = 0;
        break label120;
      }
      if ((i1 != 0) && (this.au >= 0))
      {
        i2 = getChildCount();
        if (this.au == -1)
        {
          i1 = -1;
          label394:
          localObject = getChildAt(i2 - 1);
          localSavedState.jdField_a_of_type_Int = (this.az - ((View)localObject).getBottom());
          i2 = i1;
          if (i1 >= this.aG) {
            i2 = this.aG - 1;
          }
          if ((((View)localObject).getBottom() > this.az - this.jdField_c_of_type_AndroidGraphicsRect.bottom) || (this.jdField_r_of_type_Int != 1)) {
            break label500;
          }
        }
        label500:
        for (localSavedState.jdField_b_of_type_Int = Integer.MAX_VALUE;; localSavedState.jdField_b_of_type_Int = i2)
        {
          localSavedState.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i2);
          break;
          i1 = this.au + i2 - 1;
          break label394;
        }
      }
      localSavedState.jdField_a_of_type_Int = 0;
      localSavedState.jdField_b_of_type_Long = -1L;
      localSavedState.jdField_b_of_type_Int = 0;
      break label120;
      label529:
      bool = false;
    }
    localSavedState.jdField_a_of_type_ComTencentUtilLongSparseArray = ((LongSparseArray)localObject);
    label540:
    localSavedState.jdField_d_of_type_Int = this.T;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      this.jdField_r_of_type_Boolean = true;
      t();
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (l()))
    {
      paramInt1 = paramCharSequence.length();
      bool = this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
      if ((bool) || (paramInt1 <= 0)) {
        break label85;
      }
      G();
    }
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      label85:
      do
      {
        if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof Filterable))
        {
          Filter localFilter = ((Filterable)this.jdField_a_of_type_AndroidWidgetListAdapter).getFilter();
          if (localFilter == null) {
            break;
          }
          localFilter.filter(paramCharSequence, this);
        }
        return;
      } while ((!bool) || (paramInt1 != 0));
      F();
    }
    throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int i1 = 0;
    boolean bool1;
    if (!isEnabled()) {
      if ((isClickable()) || (isLongClickable())) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      if (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
        break;
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentWidgetFastScroller.b(paramMotionEvent));
    int i2 = paramMotionEvent.getAction();
    f();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i3;
    switch (i2 & 0xFF)
    {
    case 4: 
    default: 
      return true;
    case 0: 
      switch (this.ag)
      {
      default: 
        this.aL = paramMotionEvent.getPointerId(0);
        i2 = (int)paramMotionEvent.getX();
        i3 = (int)paramMotionEvent.getY();
        i1 = b(i2, getScrollY() + i3);
        if (!this.jdField_r_of_type_Boolean) {
          if ((this.ag != 4) && (i1 >= 0) && (((ListAdapter)a()).isEnabled(i1)))
          {
            this.ag = 0;
            if (this.jdField_a_of_type_JavaLangRunnable == null) {
              this.jdField_a_of_type_JavaLangRunnable = new xrt(this);
            }
            postDelayed(this.jdField_a_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i1 >= 0) {
        this.ac = getChildAt(i1 - this.au).getTop();
      }
      this.ae = i2;
      this.af = i3;
      this.ab = i1;
      this.ah = Integer.MIN_VALUE;
      for (;;)
      {
        bool1 = bool2;
        if (!c(paramMotionEvent)) {
          break;
        }
        bool1 = bool2;
        if (this.ag != 0) {
          break;
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        return true;
        this.jdField_a_of_type_Xru.a();
        if (this.jdField_a_of_type_Xrz != null) {
          this.jdField_a_of_type_Xrz.a();
        }
        if (this.jdField_a_of_type_Xrw != null) {
          this.jdField_a_of_type_Xrw.b();
        }
        this.ag = 5;
        this.ae = ((int)paramMotionEvent.getX());
        i1 = (int)paramMotionEvent.getY();
        this.ah = i1;
        this.af = i1;
        this.ai = 0;
        this.aL = paramMotionEvent.getPointerId(0);
        this.aO = 0;
      }
      if (this.ag == 4)
      {
        h();
        this.jdField_a_of_type_Xru.a();
        this.ag = 3;
        this.ai = 0;
        i1 = c(i3);
        this.jdField_a_of_type_Xru.b();
        continue;
        i2 = paramMotionEvent.findPointerIndex(this.aL);
        if (i2 == -1) {
          this.aL = paramMotionEvent.getPointerId(0);
        }
        for (;;)
        {
          if (this.jdField_r_of_type_Boolean) {
            v_();
          }
          i1 = (int)paramMotionEvent.getY(i1);
          switch (this.ag)
          {
          case 4: 
          default: 
            return true;
          case 0: 
          case 1: 
          case 2: 
            a(i1);
            return true;
          }
          a(i1);
          return true;
          switch (this.ag)
          {
          case 4: 
          default: 
          case 0: 
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              setPressed(false);
              if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
              {
                this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
                this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
              }
              invalidate();
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Xrs);
              }
              g();
              this.aL = -1;
              bool1 = bool2;
              if (this.jdField_a_of_type_JavaLangObject == null) {
                break;
              }
              this.jdField_a_of_type_JavaLangObject = a(this.jdField_a_of_type_JavaLangObject);
              return true;
              i2 = this.ab;
              localObject = getChildAt(i2 - this.au);
              f1 = paramMotionEvent.getX();
              xry localxry;
              Handler localHandler;
              if ((f1 > this.jdField_c_of_type_AndroidGraphicsRect.left) && (f1 < getWidth() - this.jdField_c_of_type_AndroidGraphicsRect.right))
              {
                i1 = 1;
                if (this.jdField_a_of_type_Xry == null) {
                  this.jdField_a_of_type_Xry = new xry(this, null);
                }
                localxry = this.jdField_a_of_type_Xry;
                localxry.jdField_a_of_type_Int = i2;
                localxry.a();
                if ((localObject == null) || (((View)localObject).hasFocusable()) || (i1 == 0)) {
                  break label1090;
                }
                if (this.ag != 0) {
                  ((View)localObject).setPressed(false);
                }
                this.ak = i2;
                if ((this.ag != 0) && (this.ag != 1)) {
                  break label1052;
                }
                localHandler = getHandler();
                if (localHandler != null) {
                  if (this.ag != 0) {
                    break label1033;
                  }
                }
              }
              label1033:
              for (paramMotionEvent = this.jdField_a_of_type_JavaLangRunnable;; paramMotionEvent = this.jdField_a_of_type_Xrs)
              {
                localHandler.removeCallbacks(paramMotionEvent);
                this.U = 0;
                if ((this.jdField_r_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
                  break label1041;
                }
                this.ag = 1;
                h(this.ab);
                v_();
                ((View)localObject).setPressed(true);
                a(this.ab, (View)localObject);
                setPressed(true);
                if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
                {
                  paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getCurrent();
                  if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TransitionDrawable))) {
                    ((TransitionDrawable)paramMotionEvent).resetTransition();
                  }
                }
                if (this.jdField_b_of_type_JavaLangRunnable != null) {
                  removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
                }
                this.jdField_b_of_type_JavaLangRunnable = new xrn(this, (View)localObject, localxry);
                postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getPressedStateDuration());
                return true;
                i1 = 0;
                break;
              }
              label1041:
              this.ag = -1;
              o();
              return true;
              label1052:
              if ((!this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
                localxry.run();
              }
              for (;;)
              {
                this.ag = -1;
                o();
                break;
                label1090:
                localxry.run();
              }
              i1 = getChildCount();
              if (i1 > 0)
              {
                i2 = getChildAt(0).getTop();
                i3 = getChildAt(i1 - 1).getBottom();
                int i4 = this.jdField_c_of_type_AndroidGraphicsRect.top;
                int i5 = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
                if ((this.au == 0) && (i2 >= i4) && (this.au + i1 < this.aG) && (i3 <= getHeight() - i5))
                {
                  this.ag = -1;
                  b(0);
                }
                else
                {
                  paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
                  paramMotionEvent.computeCurrentVelocity(1000, this.aK);
                  if (VersionUtils.b()) {}
                  for (f1 = paramMotionEvent.getYVelocity(this.aL);; f1 = paramMotionEvent.getYVelocity())
                  {
                    int i6 = (int)(f1 * this.jdField_b_of_type_Float);
                    if ((Math.abs(i6) <= this.u) || ((this.au == 0) && (i2 == i4 - this.a_)) || ((i1 + this.au == this.aG) && (i3 == this.a_ + i5))) {
                      break label1351;
                    }
                    if (this.jdField_a_of_type_Xru == null) {
                      this.jdField_a_of_type_Xru = new xru(this);
                    }
                    b(2);
                    this.jdField_a_of_type_Xru.a(-i6);
                    break;
                  }
                  label1351:
                  this.ag = -1;
                  b(0);
                  if (this.jdField_a_of_type_Xru != null) {
                    this.jdField_a_of_type_Xru.a();
                  }
                  if (this.jdField_a_of_type_Xrz != null) {
                    this.jdField_a_of_type_Xrz.a();
                  }
                  if (this.jdField_a_of_type_Xrw != null) {
                    this.jdField_a_of_type_Xrw.b();
                  }
                }
              }
              else
              {
                this.ag = -1;
                b(0);
              }
            }
          }
          if (this.jdField_a_of_type_Xru == null) {
            this.jdField_a_of_type_Xru = new xru(this);
          }
          b(2);
          this.jdField_a_of_type_Xru.b(l());
          Object localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.aK);
          if (VersionUtils.b()) {}
          for (float f1 = ((VelocityTracker)localObject).getYVelocity(this.aL);; f1 = ((VelocityTracker)localObject).getYVelocity())
          {
            c((int)(f1 * this.jdField_b_of_type_Float), (int)paramMotionEvent.getY());
            break;
          }
          switch (this.ag)
          {
          default: 
            this.ag = -1;
            setPressed(false);
            paramMotionEvent = getChildAt(this.ab - this.au);
            if (paramMotionEvent != null) {
              paramMotionEvent.setPressed(false);
            }
            E();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Xrs);
            }
            g();
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
            {
              this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
              this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
            }
            this.aL = -1;
            return true;
            if (this.jdField_a_of_type_Xru == null) {
              this.jdField_a_of_type_Xru = new xru(this);
            }
            this.jdField_a_of_type_Xru.b(0);
          }
          bool1 = bool2;
          if (!VersionUtils.b()) {
            break;
          }
          a(paramMotionEvent);
          i2 = this.ae;
          i1 = this.af;
          i2 = b(i2, i1);
          if (i2 >= 0)
          {
            this.ac = getChildAt(i2 - this.au).getTop();
            this.ab = i2;
          }
          this.ah = i1;
          return true;
          bool1 = bool2;
          if (!VersionUtils.b()) {
            break;
          }
          i3 = paramMotionEvent.getActionIndex();
          i1 = paramMotionEvent.getPointerId(i3);
          i2 = (int)paramMotionEvent.getX(i3);
          i3 = (int)paramMotionEvent.getY(i3);
          this.ai = 0;
          this.aL = i1;
          this.ae = i2;
          this.af = i3;
          i1 = b(i2, i3);
          if (i1 >= 0)
          {
            this.ac = getChildAt(i1 - this.au).getTop();
            this.ab = i1;
          }
          this.ah = i3;
          return true;
          i1 = i2;
        }
      }
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      p();
      if ((getHeight() > 0) && (getChildCount() > 0)) {
        v_();
      }
      o();
    }
    do
    {
      int i1;
      do
      {
        return;
        i1 = this.ag;
      } while ((i1 != 5) && (i1 != 6));
      if ((this.jdField_a_of_type_Xru != null) && (this.mScrollY == 0)) {
        this.jdField_a_of_type_Xru.a();
      }
      if (this.jdField_a_of_type_Xrz != null) {
        this.jdField_a_of_type_Xrz.a();
      }
      if (this.jdField_a_of_type_Xrw != null) {
        this.jdField_a_of_type_Xrw.b();
      }
    } while (getScrollY() == 0);
    this.mScrollY = 0;
    C();
    I();
    invalidate();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i1;
    if (isInTouchMode())
    {
      i1 = 0;
      if (paramBoolean) {
        break label133;
      }
      if (!this.l)
      {
        setChildrenDrawingCacheEnabled(false);
        if (this.jdField_a_of_type_Xru != null)
        {
          removeCallbacks(this.jdField_a_of_type_Xru);
          this.jdField_a_of_type_Xru.a();
          if (this.jdField_a_of_type_Xrz != null) {
            this.jdField_a_of_type_Xrz.a();
          }
          if (this.jdField_a_of_type_Xrw != null) {
            this.jdField_a_of_type_Xrw.b();
          }
          if (getScrollY() != 0)
          {
            this.mScrollY = 0;
            C();
            I();
            invalidate();
          }
        }
        F();
        if (i1 == 1) {
          this.ak = this.aF;
        }
      }
    }
    for (;;)
    {
      this.jdField_q_of_type_Int = i1;
      return;
      i1 = 1;
      break;
      label133:
      if ((this.jdField_e_of_type_Boolean) && (!this.z)) {
        G();
      }
      if ((i1 != this.jdField_q_of_type_Int) && (this.jdField_q_of_type_Int != -1)) {
        if (i1 == 1)
        {
          q();
        }
        else
        {
          p();
          this.U = 0;
          v_();
        }
      }
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = this.aU;
    int i1;
    int i2;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i1 = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label186;
      }
      i2 = 1;
      label34:
      if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
        break label192;
      }
      i1 = 1;
      label53:
      if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
        break label198;
      }
      i2 = 1;
      label72:
      paramInt1 = paramInt3 + paramInt1;
      if (i1 == 0) {
        paramInt7 = 0;
      }
      paramInt2 = paramInt4 + paramInt2;
      if (i2 == 0) {
        paramInt8 = 0;
      }
      paramInt4 = -paramInt7;
      paramInt7 += paramInt5;
      paramInt3 = -paramInt8;
      paramInt5 = paramInt8 + paramInt6;
      if (paramInt1 <= paramInt7) {
        break label204;
      }
      paramInt1 = paramInt7;
      paramBoolean = true;
    }
    for (;;)
    {
      label132:
      boolean bool = false;
      if (paramInt2 > paramInt5)
      {
        bool = true;
        paramInt2 = paramInt5;
      }
      label186:
      label192:
      label198:
      label204:
      label234:
      for (;;)
      {
        if ((!this.l) || (paramInt2 <= 0)) {
          onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        }
        if ((paramBoolean) || (bool))
        {
          return true;
          i1 = 0;
          break;
          i2 = 0;
          break label34;
          i1 = 0;
          break label53;
          i2 = 0;
          break label72;
          if (paramInt1 >= paramInt4) {
            break label237;
          }
          paramBoolean = true;
          paramInt1 = paramInt4;
          break label132;
          if (paramInt2 >= paramInt3) {
            break label234;
          }
          bool = true;
          paramInt2 = paramInt3;
          continue;
        }
        return false;
      }
      label237:
      paramBoolean = false;
    }
  }
  
  public int p()
  {
    return this.jdField_r_of_type_Int;
  }
  
  void p()
  {
    if (this.aF != -1)
    {
      if (this.U != 4) {
        this.ak = this.aF;
      }
      if ((this.aE >= 0) && (this.aE != this.aF)) {
        this.ak = this.aE;
      }
      h(-1);
      i(-1);
      this.aj = 0;
    }
  }
  
  boolean p()
  {
    if ((this.aF < 0) && (q()))
    {
      o();
      return true;
    }
    return false;
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if ((isEnabled()) && (t() < d_() - 1))
      {
        f(getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_c_of_type_AndroidGraphicsRect.bottom, 400);
        return true;
      }
      return false;
    }
    if ((isEnabled()) && (this.au > 0))
    {
      f(-(getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_c_of_type_AndroidGraphicsRect.bottom), 400);
      return true;
    }
    return false;
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public int q()
  {
    return this.an;
  }
  
  public void q()
  {
    this.jdField_r_of_type_Boolean = true;
    t();
    requestLayout();
    invalidate();
  }
  
  boolean q()
  {
    boolean bool2 = true;
    int i7 = getChildCount();
    if (i7 <= 0) {
      return false;
    }
    int i1 = this.jdField_c_of_type_AndroidGraphicsRect.top;
    int i2 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int i6 = this.au;
    int i3 = this.ak;
    View localView;
    int i4;
    int i5;
    boolean bool1;
    if ((i3 >= i6) && (i3 < i6 + i7))
    {
      localView = getChildAt(i3 - this.au);
      i4 = localView.getTop();
      i5 = localView.getBottom();
      if (i4 < i1) {
        i1 = getVerticalFadingEdgeLength() + i1;
      }
      for (;;)
      {
        bool1 = true;
        i2 = i3;
        this.ak = -1;
        removeCallbacks(this.jdField_a_of_type_Xru);
        if (this.jdField_a_of_type_Xrz != null) {
          this.jdField_a_of_type_Xrz.a();
        }
        if (this.jdField_a_of_type_Xrw != null) {
          this.jdField_a_of_type_Xrw.b();
        }
        this.ag = -1;
        E();
        this.av = i1;
        i1 = a(i2, bool1);
        if ((i1 < i6) || (i1 > t())) {
          break;
        }
        this.U = 4;
        o();
        g(i1);
        j();
        label210:
        b(0);
        if (i1 < 0) {
          break label454;
        }
        bool1 = bool2;
        label223:
        return bool1;
        i1 = i4;
        if (i5 > i2) {
          i1 = i2 - localView.getMeasuredHeight() - getVerticalFadingEdgeLength();
        }
      }
    }
    if (i3 < i6)
    {
      i4 = 0;
      i2 = 0;
      label262:
      if (i4 >= i7) {
        break label502;
      }
      i3 = getChildAt(i4).getTop();
      if (i4 != 0) {
        break label499;
      }
      if ((i6 <= 0) && (i3 >= i1)) {
        break label493;
      }
      i1 = getVerticalFadingEdgeLength() + i1;
      i2 = i3;
      label306:
      if (i3 >= i1) {
        i1 = i6 + i4;
      }
    }
    for (;;)
    {
      bool1 = true;
      i2 = i1;
      i1 = i3;
      break;
      i4 += 1;
      break label262;
      int i8 = this.aG;
      i4 = i7 - 1;
      i1 = 0;
      label352:
      if (i4 >= 0)
      {
        localView = getChildAt(i4);
        i3 = localView.getTop();
        int i9 = localView.getBottom();
        if (i4 == i7 - 1) {
          if ((i6 + i7 < i8) || (i9 > i2))
          {
            i1 = i2 - getVerticalFadingEdgeLength();
            i2 = i3;
          }
        }
        for (;;)
        {
          if (i9 <= i1)
          {
            i1 = i3;
            i2 = i6 + i4;
            bool1 = false;
            break;
          }
          i4 -= 1;
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break label352;
          i1 = -1;
          break label210;
          label454:
          bool1 = false;
          break label223;
          i1 = i2;
          i2 = i3;
          continue;
          i5 = i1;
          i1 = i2;
          i2 = i5;
        }
      }
      i2 = i6 + i7 - 1;
      bool1 = false;
      break;
      label493:
      i2 = i3;
      break label306;
      label499:
      break label306;
      label502:
      i1 = i6;
      i3 = i2;
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    int i1 = 0;
    int i2 = 0;
    long l1;
    int i5;
    int i3;
    if (i1 < this.jdField_a_of_type_ComTencentUtilLongSparseArray.a())
    {
      l1 = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1);
      i5 = ((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1)).intValue();
      if (l1 != this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i5))
      {
        i3 = Math.max(0, i5 - 20);
        i4 = Math.min(i5 + 20, this.aG);
        label89:
        if (i3 >= i4) {
          break label251;
        }
        if (l1 == this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i3))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i3, true);
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1, Integer.valueOf(i3));
        }
      }
    }
    label251:
    for (int i4 = 1;; i4 = 0)
    {
      i3 = i1;
      if (i4 == 0)
      {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l1);
        this.T -= 1;
        if ((this.jdField_a_of_type_AndroidViewActionMode != null) && (this.jdField_a_of_type_Xrx != null)) {
          this.jdField_a_of_type_Xrx.a(this.jdField_a_of_type_AndroidViewActionMode, i5, l1, false);
        }
        i3 = i1 - 1;
        i2 = 1;
      }
      for (i1 = i2;; i1 = i2)
      {
        i2 = i1;
        i1 = i3 + 1;
        break;
        i3 += 1;
        break label89;
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i5, true);
        i3 = i1;
      }
      if ((i2 != 0) && (this.jdField_a_of_type_AndroidViewActionMode != null)) {
        this.jdField_a_of_type_AndroidViewActionMode.invalidate();
      }
      return;
    }
  }
  
  public boolean r()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      g();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.jdField_s_of_type_Boolean) && (!this.jdField_q_of_type_Boolean))
    {
      t();
      super.requestLayout();
    }
  }
  
  protected void s()
  {
    int i3 = this.aG;
    int i4 = this.aT;
    this.aT = this.aG;
    if ((this.S != 0) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
      r();
    }
    if (i3 > 0)
    {
      if (this.p)
      {
        this.p = false;
        if (this.jdField_r_of_type_Int == 2) {
          this.m = true;
        }
      }
      else
      {
        switch (this.ay)
        {
        default: 
          label112:
          if (!isInTouchMode())
          {
            i2 = r();
            i1 = i2;
            if (i2 >= i3) {
              i1 = i3 - 1;
            }
            i2 = i1;
            if (i1 < 0) {
              i2 = 0;
            }
            i1 = a(i2, true);
            if (i1 >= 0) {
              i(i1);
            }
          }
          break;
        }
      }
      while (this.ak >= 0)
      {
        return;
        if (this.jdField_r_of_type_Int != 1) {
          break;
        }
        if (this.A)
        {
          this.A = false;
          this.m = true;
          break;
        }
        if (getChildCount() <= 0) {
          break;
        }
        int i5 = getChildCount();
        int i2 = getHeight() - this.mPaddingBottom;
        View localView = getChildAt(i5 - 1);
        if (localView != null) {}
        for (i1 = localView.getBottom(); (i5 + this.au >= i4) && (i1 <= i2); i1 = i2)
        {
          this.U = 3;
          return;
        }
        if (isInTouchMode())
        {
          this.U = 5;
          this.ax = Math.min(Math.max(0, this.ax), i3 - 1);
          return;
        }
        i1 = u();
        if ((i1 < 0) || (a(i1, true) != i1)) {
          break label112;
        }
        this.ax = i1;
        if (this.jdField_c_of_type_Long == getHeight()) {}
        for (this.U = 5;; this.U = 2)
        {
          i(i1);
          return;
        }
        this.U = 5;
        this.ax = Math.min(Math.max(0, this.ax), i3 - 1);
        return;
        this.U = 5;
        this.ax = Math.max(Math.min(this.ax, i3 - 1), 0);
        return;
        i1 = a(i2, false);
        if (i1 < 0) {
          break label421;
        }
        i(i1);
        return;
      }
    }
    label421:
    if (this.jdField_i_of_type_Boolean) {}
    for (int i1 = 3;; i1 = 1)
    {
      this.U = i1;
      this.aF = -1;
      this.jdField_e_of_type_Long = Long.MIN_VALUE;
      this.aE = -1;
      this.jdField_d_of_type_Long = Long.MIN_VALUE;
      this.p = false;
      this.V = -1;
      A();
      return;
    }
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i1 = s();
      int i2 = t();
      if ((this.aR == i1) && (this.aS == i2)) {
        return;
      }
      this.aR = i1;
      this.aS = i2;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter != null) && (this.S != 0) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()) && (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null)) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    }
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt != this.an)
    {
      this.an = paramInt;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        getChildAt(i1).setDrawingCacheBackgroundColor(paramInt);
        i1 += 1;
      }
      this.jdField_a_of_type_Xsa.b(paramInt);
    }
  }
  
  public void setCallbackOnUnClickItem(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setChoiceMode(int paramInt)
  {
    this.S = paramInt;
    if (this.jdField_a_of_type_AndroidViewActionMode != null)
    {
      this.jdField_a_of_type_AndroidViewActionMode.finish();
      this.jdField_a_of_type_AndroidViewActionMode = null;
    }
    if (this.S != 0)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      }
      if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
      }
      if (this.S == 3)
      {
        i();
        setLongClickable(true);
      }
    }
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    Context localContext;
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (!paramBoolean) {
        break label62;
      }
      if ((this.aU != 2) && (this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null))
      {
        localContext = getContext();
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      }
    }
    for (this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);; this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      label62:
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
    }
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_k_of_type_Boolean)) {
      setFastScrollEnabled(true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramBoolean);
    }
    try
    {
      localMethod = View.class.getDeclaredMethod("computeOpaqueFlags", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Method localMethod = View.class.getDeclaredMethod("recomputePadding", new Class[0]);
          localMethod.setAccessible(true);
          localMethod.invoke(this, new Object[0]);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("XListView", 2, localException1.getMessage(), localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("XListView", 2, localException2.getMessage(), localException2);
      }
    }
  }
  
  public void setFastScrollEnabled(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
        this.jdField_a_of_type_ComTencentWidgetFastScroller = new FastScroller(getContext(), this);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.a();
    this.jdField_a_of_type_ComTencentWidgetFastScroller = null;
  }
  
  public void setFilterText(String paramString)
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(paramString)))
    {
      a(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof Filterable))
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
          ((Filterable)this.jdField_a_of_type_AndroidWidgetListAdapter).getFilter().filter(paramString);
        }
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_Xrq.a();
      }
    }
  }
  
  public void setFriction(float paramFloat)
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = new xru(this);
    }
    xru.a(this.jdField_a_of_type_Xru).a(paramFloat);
  }
  
  public void setItemChecked(int paramInt, boolean paramBoolean)
  {
    if (this.S == 0) {}
    label144:
    label226:
    label341:
    label368:
    for (;;)
    {
      return;
      if ((VersionUtils.e()) && (paramBoolean) && (this.S == 3) && (this.jdField_a_of_type_AndroidViewActionMode == null)) {
        this.jdField_a_of_type_AndroidViewActionMode = startActionMode(this.jdField_a_of_type_Xrx);
      }
      if ((this.S == 2) || (this.S == 3))
      {
        boolean bool = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, paramBoolean);
        if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
        {
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
        }
        else
        {
          if (bool != paramBoolean)
          {
            if (!paramBoolean) {
              break label226;
            }
            this.T += 1;
          }
          if (this.jdField_a_of_type_AndroidViewActionMode != null)
          {
            long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
            this.jdField_a_of_type_Xrx.a(this.jdField_a_of_type_AndroidViewActionMode, paramInt, l1, paramBoolean);
          }
        }
      }
      for (;;)
      {
        if ((this.jdField_q_of_type_Boolean) || (this.jdField_s_of_type_Boolean)) {
          break label368;
        }
        this.jdField_r_of_type_Boolean = true;
        t();
        requestLayout();
        return;
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt));
        break;
        this.T -= 1;
        break label144;
        if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {}
        for (int i1 = 1;; i1 = 0)
        {
          if ((paramBoolean) || (b(paramInt)))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
            if (i1 != 0) {
              this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
            }
          }
          if (!paramBoolean) {
            break label341;
          }
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
          if (i1 != 0) {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.T = 1;
          break;
        }
        if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 0) || (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(0))) {
          this.T = 0;
        }
      }
    }
  }
  
  public void setMaximumVelocity(int paramInt)
  {
    this.aK = paramInt;
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    if (this.jdField_a_of_type_Xrx == null) {
      this.jdField_a_of_type_Xrx = new xrx(this);
    }
    this.jdField_a_of_type_Xrx.a(paramMultiChoiceModeListener);
  }
  
  public void setNeedCheckSpringback(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    j();
  }
  
  public void setOnScrollToButtomListener(AbsListView.OnScrollButtomListener paramOnScrollButtomListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollButtomListener = paramOnScrollButtomListener;
  }
  
  public void setOverScrollEffectPadding(int paramInt1, int paramInt2)
  {
    this.aP = paramInt1;
    this.aQ = paramInt2;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("Invalid overscroll mode " + paramInt);
    }
    Context localContext;
    if (paramInt != 2) {
      if ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null) && (this.jdField_a_of_type_Boolean)) {
        localContext = getContext();
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      for (this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);; this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null)
      {
        this.aU = paramInt;
        return;
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    xsa.a(this.jdField_a_of_type_Xsa, paramRecyclerListener);
  }
  
  public void setScrollIndicators(View paramView1, View paramView2)
  {
    this.jdField_e_of_type_AndroidViewView = paramView1;
    this.jdField_f_of_type_AndroidViewView = paramView2;
  }
  
  public void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if ((this.jdField_j_of_type_Boolean) && (!paramBoolean)) {
      E();
    }
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setSelector(int paramInt)
  {
    setSelector(getResources().getDrawable(paramInt));
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      unscheduleDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.W = localRect.left;
    this.X = localRect.top;
    this.Y = localRect.right;
    this.Z = localRect.bottom;
    paramDrawable.setCallback(this);
    o();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setStackFromBottom(boolean paramBoolean)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      k();
    }
  }
  
  public void setStackFromBottomWithoutRequestLayoutIfNecessary(boolean paramBoolean)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean) {
      this.jdField_i_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setTextFilterEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setTranscriptMode(int paramInt)
  {
    this.jdField_r_of_type_Int = paramInt;
  }
  
  public void setVelocityScale(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setVerticalScrollbarPosition(int paramInt)
  {
    super.setVerticalScrollbarPosition(paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramInt);
    }
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = a(paramView);
    if (i1 >= 0)
    {
      long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i1);
      if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {
        bool2 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, paramView, i1, l1);
      }
      bool1 = bool2;
      if (!bool2)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(getChildAt(i1 - this.au), i1, l1);
        bool1 = super.showContextMenuForChild(paramView);
      }
    }
    return bool1;
  }
  
  public void t()
  {
    int i1 = -1;
    if (getChildCount() > 0)
    {
      this.p = true;
      this.jdField_c_of_type_Long = this.az;
      if (this.aF >= 0)
      {
        localObject1 = getChildAt(this.aF - this.au);
        this.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
        this.ax = this.aE;
        if (localObject1 != null)
        {
          this.av = ((View)localObject1).getTop();
          this.aw = (this.az - ((View)localObject1).getBottom());
        }
        this.ay = 0;
      }
    }
    else
    {
      return;
    }
    Object localObject2;
    if (((this.mScrollY == 0) && (!this.jdField_i_of_type_Boolean)) || (this.mScrollY < 0))
    {
      localObject1 = getChildAt(0);
      localObject2 = (ListAdapter)a();
      if ((this.au >= 0) && (this.au < ((ListAdapter)localObject2).getCount())) {}
      for (this.jdField_b_of_type_Long = ((ListAdapter)localObject2).getItemId(this.au);; this.jdField_b_of_type_Long = -1L)
      {
        this.ax = this.au;
        if (localObject1 != null)
        {
          this.av = ((View)localObject1).getTop();
          this.aw = (this.az - ((View)localObject1).getBottom());
        }
        this.ay = 1;
        return;
      }
    }
    Object localObject1 = (ListAdapter)a();
    int i2 = getChildCount();
    if (this.au == -1)
    {
      localObject2 = getChildAt(i2 - 1);
      if ((i1 < 0) || (i1 >= ((ListAdapter)localObject1).getCount())) {
        break label314;
      }
    }
    label314:
    for (this.jdField_b_of_type_Long = ((ListAdapter)localObject1).getItemId(i1);; this.jdField_b_of_type_Long = -1L)
    {
      this.ax = i1;
      if (localObject2 != null)
      {
        this.av = ((View)localObject2).getTop();
        this.aw = (this.az - ((View)localObject2).getBottom());
      }
      this.ay = 2;
      return;
      i1 = this.au + i2 - 1;
      break;
    }
  }
  
  public void u()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_e_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        F();
      }
    }
  }
  
  public void v()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void v_() {}
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
  
  public void w() {}
  
  protected void x()
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = new xru(this);
    }
    this.jdField_a_of_type_Xru.b(0);
  }
  
  protected void y()
  {
    if (this.jdField_a_of_type_Xru != null) {
      this.jdField_a_of_type_Xru.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\AbsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
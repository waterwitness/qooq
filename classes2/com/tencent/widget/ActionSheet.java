package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import xsg;
import xsh;
import xsi;
import xsk;
import xsl;

public class ActionSheet
  extends Dialog
{
  public static final int a = 0;
  public static final String a = "ActionSheet";
  @Deprecated
  public static final int b = 1;
  public static final String b = "icon";
  @Deprecated
  public static final int c = 2;
  @Deprecated
  public static final int d = 4;
  public static final int e = 3;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xsk(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener;
  private ActionSheet.OnDismissListener jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public Object a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new xsl(this);
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private CharSequence c;
  public boolean c;
  private boolean d = true;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private int m = -1;
  private int n = 300;
  
  public ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131559023);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      getWindow().addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903055, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131296883));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131296884));
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427486);
    case 5: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    case 6: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427487);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427489);
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, false, paramBoolean);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(2131362094) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131362095) + paramTextView.getText());
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  public static ActionSheet b(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, true, paramBoolean);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  public static ActionSheet c(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    paramContext.getWindow().setWindowAnimations(2131559022);
    return paramContext;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903061, null);
      ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837533));
      ((View)localObject1).setOnClickListener(new xsg(this));
      localObject2 = (TextView)((View)localObject1).findViewById(2131296891);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_JavaLangCharSequence);
      ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131296892);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject2).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (this.e) {
        i1 = 1;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
        int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        i1 = 0;
        if (i1 < i3)
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903057, null);
          TextView localTextView = (TextView)((View)localObject2).findViewById(2131296886);
          localObject1 = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          localTextView.setText((CharSequence)((Pair)localObject1).first);
          AccessibilityUtil.b(localTextView, Button.class.getName());
          ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131296888);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
          localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
          localImageView.setLayoutParams(localLayoutParams);
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i1)))
          {
            localImageView.setVisibility(0);
            localImageView.setImageDrawable((Drawable)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1)));
            label329:
            localTextView.setTextColor(a(((Integer)((Pair)localObject1).second).intValue()));
            if ((i1 != 0) || (i2 != i3) || (i2 != 1)) {
              break label484;
            }
            localObject1 = a(0);
            label371:
            ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
            ((View)localObject2).setId(i1);
            ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
                this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.append(i1, localObject2);
              if (i1 != this.m) {
                break label544;
              }
              ((View)localObject2).findViewById(2131296887).setVisibility(0);
              a(localTextView, true);
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            localImageView.setImageDrawable(null);
            localImageView.setVisibility(8);
            break label329;
            label484:
            if ((i1 == 0) && (i2 == i3) && (i2 > 1))
            {
              localObject1 = a(1);
              break label371;
            }
            if ((i1 == i3 - 1) && (i2 > 1))
            {
              localObject1 = a(3);
              break label371;
            }
            localObject1 = a(2);
            break label371;
            label544:
            a(localTextView, false);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903056, null);
        localObject2 = (Button)((View)localObject1).findViewById(2131296885);
        ((Button)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject2).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837532);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837529);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837532);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837526);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837523);
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      super.dismiss();
      ActivityLeakSolution.a(this);
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      ActivityLeakSolution.a(this);
      return;
    }
    finally
    {
      localObject = finally;
      ActivityLeakSolution.a(this);
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    a(paramInt, paramCharSequence, 0);
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131296886);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(a(paramInt2));
          paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
          this.jdField_a_of_type_JavaUtilArrayList.set(paramInt1, paramCharSequence);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  @Deprecated
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, 0, localLayoutParams);
    }
  }
  
  public void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = paramOnButtonClickListener;
  }
  
  public void a(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    a(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label139:
      if (paramBoolean1) {
        this.m = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1), paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt1);
    if (localObject == null) {}
    do
    {
      return;
      paramString = new SpannableStringBuilder("icon" + paramString);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).a(0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentResResources));
      paramString.setSpan(localObject, 0, "icon".length(), 18);
      paramString = new Pair(paramString, Integer.valueOf(paramInt2));
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void b()
  {
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0), 2);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 2);
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void b(View paramView)
  {
    this.e = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void b(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, localLayoutParams);
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt), 0);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public void d(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void dismiss()
  {
    if (this.f)
    {
      this.f = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xsi(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.g) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void e(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.m = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.m);
        if (localView != null)
        {
          localView.findViewById(2131296887).setVisibility(0);
          a((TextView)localView.findViewById(2131296886), true);
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    if (paramInt > 0) {
      this.n = paramInt;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      dismiss();
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    super.show();
    c();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xsh(this), 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
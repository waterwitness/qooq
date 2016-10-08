package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pim;
import pin;
import pio;
import pip;
import piq;
import pir;
import pit;
import piu;
import piv;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  public static final int a = 1;
  public static double b = 0.0D;
  public static final int b = 2;
  private static final double jdField_c_of_type_Double = 0.9D;
  private static final String jdField_c_of_type_JavaLangString = "TroopMemberListInnerFrame";
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private static final int i = 4;
  private static int k = 1000;
  public double a;
  public Handler a;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new pir(this);
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  String jdField_a_of_type_JavaLangString = "";
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public Map a;
  public piu a;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public RelativeLayout b;
  public TextView b;
  public String b;
  List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public TextView c;
  public int d;
  public TextView d;
  private String d;
  public int e = 1;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Double = 10.0D;
  }
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_AndroidOsHandler = new pim(this);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_AndroidOsHandler = new pim(this);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_AndroidOsHandler = new pim(this);
  }
  
  /* Error */
  private Bitmap a(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 142	android/view/View:getWidth	()I
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual 145	android/view/View:getHeight	()I
    //   9: istore 4
    //   11: iload_3
    //   12: ifeq +41 -> 53
    //   15: iload 4
    //   17: ifeq +36 -> 53
    //   20: iload_3
    //   21: iload 4
    //   23: getstatic 151	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokestatic 157	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   29: astore_2
    //   30: aload_1
    //   31: new 159	android/graphics/Canvas
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 162	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   39: invokevirtual 166	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   42: aload_2
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aload_2
    //   52: areturn
    //   53: aconst_null
    //   54: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TroopMemberListInnerFrame
    //   0	55	1	paramView	View
    //   29	23	2	localBitmap	Bitmap
    //   4	17	3	m	int
    //   9	13	4	n	int
    // Exception table:
    //   from	to	target	type
    //   0	11	44	java/lang/Exception
    //   20	30	44	java/lang/Exception
    //   30	42	44	java/lang/Exception
    //   0	11	47	java/lang/OutOfMemoryError
    //   20	30	47	java/lang/OutOfMemoryError
    //   30	42	50	java/lang/OutOfMemoryError
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.jdField_a_of_type_JavaUtilMap = ((Map)paramMessage[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Piu.notifyDataSetChanged();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      if (this.e != 2) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, this.j);
      return;
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void a(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      str = "0";
      if (localTroopInfo != null) {
        str = localTroopInfo.troopcode;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label91;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.n();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.getHeight());
      }
    }
    return;
    label91:
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(true, paramString, str, true, 7);
  }
  
  private void a(String paramString, List paramList)
  {
    Object localObject;
    label168:
    label184:
    label201:
    int n;
    int i1;
    if (paramList == null)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        paramList = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).a();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("read troop members from database, troop uin: ").append(paramString).append(" member count: ");
          if (paramList == null)
          {
            m = 0;
            QLog.d("TroopMemberListInnerFrame", 2, m);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilMap != null) {
            break label184;
          }
          this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
        }
        for (;;)
        {
          paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_b_of_type_JavaLangString);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (paramList != null) {
            break label201;
          }
          paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
          m = paramList.size() - 1;
          break;
          this.jdField_a_of_type_JavaUtilMap.clear();
        }
        n = paramList.size();
      }
      finally {}
      this.jdField_c_of_type_Int = (n - 1);
      if (n > 0)
      {
        i1 = n / k;
        if (n % k != 0) {
          break label370;
        }
      }
    }
    label368:
    label370:
    for (int m = 0;; m = 1)
    {
      this.jdField_d_of_type_Int = (m + i1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame", 2, "parallel process mJobCount: " + this.jdField_d_of_type_Int);
      }
      for (;;)
      {
        if (m >= n) {
          break label368;
        }
        ThreadManager.a(new piq(this, paramList, m, Math.min(k + m - 1, n), (String)localObject, paramString), 8, null, false);
        m += k;
        continue;
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        break label168;
        break;
        m = 0;
      }
      break label168;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      if ((paramString == null) || (paramBoolean) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
        break label46;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      label46:
      int n = this.jdField_a_of_type_Piu.getCount();
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label105;
        }
        paramString = (TroopMemberInfo)this.jdField_a_of_type_Piu.getItem(m);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramString.memberuin)))
        {
          paramBoolean = false;
          break;
        }
        m += 1;
      }
      label105:
      paramBoolean = true;
    }
  }
  
  private Object[] a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new pit(this, null));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((Map)localObject1).get(String.valueOf(c1)) != null) {
        this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((Map)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilMap.put("#", ((Map)localObject1).get("#"));
    }
    ((Map)localObject1).clear();
    localObject1 = new int[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Object localObject2 = new String[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    int m = 1;
    while (m < localObject1.length)
    {
      int n = localObject1[m];
      int i1 = localObject1[(m - 1)];
      localObject1[m] = (((List)this.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + i1 + 1 + n);
      m += 1;
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    m = 0;
    while (localIterator.hasNext())
    {
      localObject2[m] = ((String)localIterator.next());
      m += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131304900));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298104));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427379);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304901));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304897));
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304898);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131304899));
    ((LinearLayout)localObject).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304903));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131304904));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304905));
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Q == 21)
    {
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getWindow().getDecorView();
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      int m = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 2.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(m, 0, m, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428296));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("管理员");
      TroopRankColorConfig.a(this.jdField_b_of_type_AndroidWidgetTextView, 1, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject).addView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(m, 0, m, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428296));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("群主");
      TroopRankColorConfig.a(this.jdField_c_of_type_AndroidWidgetTextView, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject).addView(this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new pin(this, (ViewGroup)localObject));
      this.jdField_c_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new pio(this, (ViewGroup)localObject));
    }
  }
  
  private void h()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "troop member last update time: " + l1 + " current time: " + l2 + " time difference: " + l3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Q != 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_c_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum - 1);
        if (this.jdField_c_of_type_Int > 0)
        {
          this.jdField_a_of_type_Double = 0.0D;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
        }
      }
    }
    if ((l1 == 0L) || ((l1 > 0L) && (l3 > 300000L)))
    {
      a(this.jdField_b_of_type_JavaLangString);
      return;
    }
    pip localpip = new pip(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localpip);
  }
  
  public ContactSearchFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Q != 21) {
      return ContactSearchFragment.a(-1, 8192, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    }
    return ContactSearchFragment.a(-1, 262144, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904965);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    g();
    this.jdField_a_of_type_Piu = new piu(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Piu);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Piu.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.clearFocus();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("group_name");
    this.e = paramBundle.getInt("param_member_show_type", 1);
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int m;
    if (bool)
    {
      m = 0;
      paramBundle.setVisibility(m);
      if (((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.length() == 0)) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_b_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_d_of_type_JavaLangString = paramBundle.troopname;
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.o) {
        break label296;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
      {
        if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
          break label314;
        }
        this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
        this.jdField_a_of_type_ArrayOfInt = new int[0];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
        this.jdField_a_of_type_Piu.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        h();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      return;
      m = 8;
      break;
      label296:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "群", this.jdField_d_of_type_JavaLangString);
    }
    label314:
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Piu.notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int m;
    do
    {
      return;
      m = this.jdField_a_of_type_Piu.a(paramString);
    } while (m == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(m + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Piu != null) {
      this.jdField_a_of_type_Piu.b();
    }
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getTag() != null))
    {
      ((Bitmap)this.jdField_b_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(null);
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getTag() != null))
    {
      ((Bitmap)this.jdField_c_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(null);
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Piu.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131304899 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label116;
      }
      paramCompoundButton = new ArrayList();
      int n = this.jdField_a_of_type_Piu.getCount();
      int m = 0;
      while (m < n)
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)this.jdField_a_of_type_Piu.getItem(m);
        if (localTroopMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          paramCompoundButton.add(SelectMemberActivity.a(localTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localTroopMemberInfo), 1, this.jdField_b_of_type_JavaLangString));
        }
        m += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramCompoundButton, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Piu.notifyDataSetChanged();
      return;
      label116:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (2131304898 != paramView.getId())
    {
      Object localObject = (piv)paramView.getTag();
      if ((localObject != null) && (((piv)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((piv)localObject).jdField_c_of_type_AndroidWidgetTextView != null) && (((piv)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((piv)localObject).jdField_b_of_type_JavaLangString, ((piv)localObject).jdField_c_of_type_AndroidWidgetTextView.getText().toString(), 1, this.jdField_b_of_type_JavaLangString);
        ((piv)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((piv)localObject).jdField_b_of_type_JavaLangString, bool);
        if (AppSetting.j)
        {
          if (!((piv)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label164;
          }
          paramView.setContentDescription(((piv)localObject).jdField_c_of_type_AndroidWidgetTextView.getText().toString() + "已选中");
          if (!((piv)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label202;
          }
        }
      }
      label164:
      label202:
      for (localObject = "已选中";; localObject = "未选中")
      {
        AccessibilityUtil.a(paramView, (String)localObject);
        return;
        paramView.setContentDescription(((piv)localObject).jdField_c_of_type_AndroidWidgetTextView.getText().toString() + "未选中");
        break;
      }
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopMemberListInnerFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
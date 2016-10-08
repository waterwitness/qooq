package com.tencent.mobileqq.hotchat;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sta;
import stb;
import stc;
import std;
import ste;
import stg;
import stj;
import stk;
import stl;
import stn;
import sto;
import stp;
import stq;
import str;
import sts;
import stv;
import stw;
import stx;
import sty;
import stz;

public class HotChatMemberListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener, AdapterView.OnItemClickListener
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "HotChatMemberListActivity";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  static final int g = 1;
  static final int h = 2;
  static final int i = 3;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public byte a;
  public Dialog a;
  public Handler a;
  public LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver;
  HotChatInfo jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
  private NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public IndexView a;
  private PinnedDividerListView.OnLayoutListener jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener;
  public PinnedDividerListView a;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  public XListView a;
  public Long a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  stv jdField_a_of_type_Stv;
  public sty a;
  boolean jdField_a_of_type_Boolean;
  public View b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public ArrayList b;
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  public View e;
  public String e;
  boolean e;
  public String f;
  public String g;
  public int j;
  public int k;
  
  public HotChatMemberListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Sty = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.f = "";
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangLong = null;
    this.j = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new stb(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener = new stc(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new std(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new ste(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new stg(this);
  }
  
  private int a(sts paramsts)
  {
    if (paramsts.jdField_a_of_type_Int == 1) {
      return 1;
    }
    if (paramsts.jdField_a_of_type_Boolean) {
      return 2;
    }
    if (paramsts.jdField_a_of_type_Int == 2) {
      return 3;
    }
    return 4;
  }
  
  private void e()
  {
    if (this.j == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131372436));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131367262));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    if (this.j == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("你想要送花给谁");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131367262));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131372437));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str2 = getIntent().getExtras().getString("leftViewText");
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(2131367975);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void f()
  {
    Object localObject = getResources().getDrawable(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    localObject = (RelativeLayout)getLayoutInflater().inflate(2130904932, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    EditText localEditText = (EditText)((RelativeLayout)localObject).findViewById(2131300895);
    ((Button)((RelativeLayout)localObject).findViewById(2131300876)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a((View)localObject);
    localEditText.setOnTouchListener(new sta(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131367347)).setPositiveButton(getString(2131367974), new stj(this));
  }
  
  private void g()
  {
    if (this.j == 2) {
      return;
    }
    if (this.j == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131367262));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText("删除成员");
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public stz a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int i2;
    int i1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
      i2 = ((ViewGroup)localObject1).getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label135;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof stz)))
      {
        localObject2 = (stz)((View)localObject2).getTag();
        if ((((stz)localObject2).jdField_b_of_type_JavaLangString != null) && (((stz)localObject2).jdField_b_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HotChatMemberListActivity", 2, "findListItemHolderByUin:" + i1);
          }
          return (stz)localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
          break;
        }
      }
      i1 += 1;
    }
    label135:
    return null;
  }
  
  public void a()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130904937);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    stk localstk = new stk(this, (TranslateAnimation)localObject1, localDialog);
    ((TranslateAnimation)localObject1).setAnimationListener(localstk);
    ((TranslateAnimation)localObject2).setAnimationListener(localstk);
    localDialog.setOnDismissListener(new stl(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_d_of_type_AndroidViewView = localDialog.findViewById(2131296895);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new stx(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new stn(this));
    localObject1 = (Button)localDialog.findViewById(2131300876);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new sto(this, localDialog));
    this.jdField_c_of_type_AndroidViewView = localDialog.findViewById(2131297767);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131297765));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new stp(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131298733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Stv == null) {
      this.jdField_a_of_type_Stv = new stv(this, this.jdField_b_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Stv);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new stq(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new str(this, localDialog));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
    {
      HotChatHandler localHotChatHandler = (HotChatHandler)this.app.a(35);
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      localHotChatHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangLong.longValue(), paramInt, true, new int[0]);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m();
    paramView = (stz)paramView.getTag();
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.jdField_b_of_type_JavaLangString;
    } while ((paramView == null) || (paramView.length() == 0));
    Object localObject;
    if (this.j == 1)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("sel_hctopic_member", new Object[] { paramView });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin)))
      {
        a(0, "你已经是房主了哈~");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isPttRomGuest(paramView)))
      {
        a(0, "你邀请的用户已经是嘉宾。");
        return;
      }
      if (!NetworkUtil.e(this))
      {
        a(1, "操作失败，请检查网络连接。");
        return;
      }
      a(0, "正在邀请，请稍候...", 800);
      localObject = (HotChatHandler)this.app.a(35);
      this.g = paramView;
      ((HotChatHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, this.g, 3, this.k, 0);
      return;
    }
    if (this.j == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramView);
      paramView = getIntent().getExtras();
      if (paramView != null) {
        ((Intent)localObject).putExtra("from", paramView.getInt("from", 0));
      }
      setResult(-1, (Intent)localObject);
      d();
      return;
    }
    HotChatUtil.a(this, this.app, this.jdField_b_of_type_JavaLangString, paramView);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Stv.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      sts localsts = (sts)this.jdField_a_of_type_JavaUtilList.get(i1);
      localsts.jdField_e_of_type_JavaLangString = "";
      localsts.f = "";
      if ((localsts.m.equals(paramString)) || (localsts.o.equals(paramString)) || (localsts.n.equals(paramString)))
      {
        localsts.jdField_e_of_type_JavaLangString = localsts.m;
        localArrayList1.add(localsts);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((localsts.j.equals(paramString)) || (localsts.l.equals(paramString)) || (localsts.k.equals(paramString)))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.j;
          localArrayList1.add(localsts);
        }
        else if ((localsts.g.equals(paramString)) || (localsts.i.equals(paramString)) || (localsts.h.equals(paramString)))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.g;
          localArrayList1.add(localsts);
        }
        else if (localsts.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localsts);
        }
        else if ((localsts.m.indexOf(paramString) == 0) || (localsts.o.indexOf(paramString) == 0) || (localsts.n.indexOf(paramString) == 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.m;
          localsts.f = localsts.n;
          localArrayList2.add(localsts);
        }
        else if ((localsts.j.indexOf(paramString) == 0) || (localsts.l.indexOf(paramString) == 0) || (localsts.k.indexOf(paramString) == 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.j;
          localsts.f = localsts.k;
          localArrayList2.add(localsts);
        }
        else if ((localsts.g.indexOf(paramString) == 0) || (localsts.i.indexOf(paramString) == 0) || (localsts.h.indexOf(paramString) == 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.g;
          localsts.f = localsts.h;
          localArrayList2.add(localsts);
        }
        else if (localsts.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.jdField_a_of_type_JavaLangString;
          localsts.f = localsts.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localsts);
        }
        else if ((localsts.m.indexOf(paramString) > 0) || (localsts.o.indexOf(paramString) > 0) || (localsts.n.indexOf(paramString) > 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.m;
          localArrayList3.add(localsts);
        }
        else if ((localsts.j.indexOf(paramString) > 0) || (localsts.l.indexOf(paramString) > 0) || (localsts.k.indexOf(paramString) > 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.j;
          localArrayList3.add(localsts);
        }
        else if ((localsts.g.indexOf(paramString) > 0) || (localsts.i.indexOf(paramString) > 0) || (localsts.h.indexOf(paramString) > 0))
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.g;
          localArrayList3.add(localsts);
        }
        else if (localsts.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localsts.jdField_e_of_type_JavaLangString = localsts.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localsts);
        }
      }
    }
    Collections.sort(localArrayList2, new stw(this, null));
    this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Stv.notifyDataSetChanged();
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    c();
    Intent localIntent = new Intent();
    localIntent.putExtra("HC_MEMBER_ACTION", this.j);
    localIntent.putExtra("HC_MEMBER_SEATID", this.k);
    if (paramBoolean)
    {
      localIntent.putExtra("SEL_MEMBER_UIN", paramString1);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      overridePendingTransition(2130968589, 2130968593);
      return;
      localIntent.putExtra("SEL_MEMBER_UIN", paramString2);
      setResult(0, localIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903052);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(getString(2131368647));
    }
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_Sty.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void d()
  {
    finish();
    if (this.j == 2) {
      overridePendingTransition(0, 2130968593);
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("showTitleBar", false);
    }
    try
    {
      requestWindowFeature(1);
      super.doOnCreate(paramBundle);
      setContentViewNoTitle(2130905077);
      paramBundle = getIntent().getExtras();
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("troop_admin");
      this.jdField_d_of_type_JavaLangString = paramBundle.getString("troop_owner");
      this.jdField_c_of_type_JavaLangString = paramBundle.getString("troop_code");
      this.j = paramBundle.getInt("HC_MEMBER_ACTION", 0);
      if (this.j == 1)
      {
        this.jdField_a_of_type_Boolean = false;
        this.k = paramBundle.getInt("HC_MEMBER_SEATID", 0);
        this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.app.a(true).a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          break label217;
        }
        if (this.j != 1) {
          break label210;
        }
        a(false, "", "");
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (this.j == 2)
        {
          this.jdField_a_of_type_Boolean = false;
        }
        else
        {
          this.jdField_a_of_type_Boolean = paramBundle.getBoolean("troop_manage", false);
          continue;
          label210:
          d();
        }
      }
      label217:
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305207));
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131296706);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297391));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131299166));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298104));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131297005);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      e();
      f();
      a(0);
      paramBundle = (ViewGroup)findViewById(2131297082);
      if (paramBundle != null) {
        setLayerType(paramBundle);
      }
      paramBundle = findViewById(2131296706);
      if (paramBundle != null) {
        setLayerType(paramBundle);
      }
      paramBundle = (TextView)findViewById(2131297083);
      if (paramBundle != null) {
        setLayerType(paramBundle);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_e_of_type_Boolean = true;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    c();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_Sty != null) {
      this.jdField_a_of_type_Sty.b();
    }
    if (this.jdField_a_of_type_Stv != null) {
      this.jdField_a_of_type_Stv.b();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    getWindow().setSoftInputMode(48);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected boolean onBackEvent()
  {
    if (this.j == 1)
    {
      a(false, "", "");
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("DelMembers", this.jdField_b_of_type_JavaUtilArrayList);
    setResult(0, localIntent);
    d();
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.j == 1) {
      if (paramView == this.jdField_d_of_type_AndroidWidgetTextView) {
        a(false, "", "");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.j == 2)
        {
          if (paramView == this.jdField_d_of_type_AndroidWidgetTextView) {
            d();
          }
        }
        else
        {
          if (paramView != this.jdField_d_of_type_AndroidWidgetTextView) {
            break;
          }
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_d_of_type_AndroidWidgetTextView.setText("删除成员");
          }
          while (this.jdField_a_of_type_Sty != null)
          {
            this.jdField_a_of_type_Sty.notifyDataSetChanged();
            return;
            this.jdField_d_of_type_Boolean = true;
            this.jdField_d_of_type_AndroidWidgetTextView.setText("完成");
          }
        }
      }
    } while (paramView != this.jdField_b_of_type_AndroidWidgetTextView);
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HotChatMemberListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
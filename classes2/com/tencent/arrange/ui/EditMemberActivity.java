package com.tencent.arrange.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import gds;
import gdt;
import gdu;
import gdv;
import gdw;
import gdx;
import gdz;
import gea;
import geb;
import gec;
import ged;
import geg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EditMemberActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  static final String c = "memberUin";
  public static final int d = 3;
  static final String d = "memberName";
  public static final int e = 4;
  static final String e = "faceId";
  public static final int f = 1;
  static final String f = "pinyin";
  public static final int g = 2;
  static final String g = "isDiscussionMember";
  public static final String j = "jump_from";
  private static final String k = EditMemberActivity.class.getSimpleName();
  public Dialog a;
  public LayoutInflater a;
  public View.OnClickListener a;
  protected View a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  protected ImageButton a;
  protected ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected IndexView a;
  public PinnedDividerListView a;
  public XListView a;
  public ged a;
  public geg a;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List a;
  public boolean a;
  protected View b;
  protected RelativeLayout b;
  protected TextView b;
  public String b;
  protected List b;
  public boolean b;
  protected View c;
  protected RelativeLayout c;
  protected TextView c;
  public boolean c;
  protected View d;
  public String h = "";
  public String i = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EditMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gds(this);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = (Map)paramList.next();
      TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
      localATroopMember.jdField_a_of_type_JavaLangString = ((String)((Map)localObject).get("memberUin"));
      localATroopMember.jdField_b_of_type_JavaLangString = ((String)((Map)localObject).get("memberName"));
      localATroopMember.d = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1);
      localATroopMember.c = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
      Boolean localBoolean = (Boolean)((Map)localObject).get("isDiscussionMember");
      if ((localBoolean != null) && (localBoolean.booleanValue())) {
        localStringBuffer.append(localATroopMember.jdField_a_of_type_JavaLangString + "&");
      }
      localObject = (Short)((Map)localObject).get("faceId");
      if (localObject == null) {}
      for (localATroopMember.jdField_a_of_type_Short = 0;; localATroopMember.jdField_a_of_type_Short = ((Short)localObject).shortValue())
      {
        localATroopMember.e(localATroopMember.jdField_b_of_type_JavaLangString);
        localATroopMember.g(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
        localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2));
        this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
        break;
      }
    }
    this.jdField_b_of_type_JavaLangString = localStringBuffer.toString();
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  private void c(String paramString)
  {
    if (paramString != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopMemberListActivity.ATroopMember)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramString)) {
            localIterator.remove();
          }
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((TroopMemberListActivity.ATroopMember)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramString)) {
          localIterator.remove();
        }
      }
    }
    b(paramString);
  }
  
  private void e()
  {
    if (this != null) {}
    try
    {
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("result_list", this.jdField_a_of_type_JavaUtilArrayList);
      setResult(-1, localIntent);
      finish();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(k, 2, localException.toString());
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130904937);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Geg = new geg(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Geg);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new gec(this, (InputMethodManager)localObject));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895)).setOnTouchListener(new gdt(this));
  }
  
  public TroopMemberListActivity.TmViewHolder a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int n;
    int m;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
      n = ((ViewGroup)localObject1).getChildCount();
      m = 0;
    }
    for (;;)
    {
      if (m >= n) {
        break label136;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(m);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof TroopMemberListActivity.TmViewHolder)))
      {
        localObject2 = (TroopMemberListActivity.TmViewHolder)((View)localObject2).getTag();
        if ((((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString != null) && (((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(k, 2, "findListItemHolderByUin:" + m);
          }
          return (TroopMemberListActivity.TmViewHolder)localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
          break;
        }
      }
      m += 1;
    }
    label136:
    return null;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131369557));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368729));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368284));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new gdu(this));
  }
  
  public void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = this.i;
      paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean;
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramATroopMember.jdField_b_of_type_JavaLangString);
      paramTmViewHolder.jdField_b_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
      paramTmViewHolder.g.setText("");
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean));
      paramTmViewHolder.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368285) + paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText().toString());
      if (this.jdField_b_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        break label306;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label196:
      if (!str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        break label326;
      }
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    for (;;)
    {
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131368282), new Object[] { paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText().toString() }));
      paramTmViewHolder.h.setContentDescription(getString(2131368283));
      return;
      str = this.h;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label306:
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label196;
      label326:
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void a(String paramString)
  {
    this.i = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Geg.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    String str1 = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramString = this.jdField_a_of_type_JavaUtilList;
    int m = 0;
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember;
      try
      {
        if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label853;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(m);
        localATroopMember.f = "";
        localATroopMember.g = "";
        if ((str1.equals(localATroopMember.n)) || (str1.equals(localATroopMember.p)) || (str1.equals(localATroopMember.o)))
        {
          localATroopMember.f = localATroopMember.n;
          localArrayList1.add(localATroopMember);
        }
        else if ((str1.equals(localATroopMember.k)) || (str1.equals(localATroopMember.m)) || (str1.equals(localATroopMember.l)))
        {
          localATroopMember.f = localATroopMember.k;
          localArrayList1.add(localATroopMember);
        }
      }
      finally {}
      if ((str2.equals(localATroopMember.h)) || (str2.equals(localATroopMember.j)) || (str2.equals(localATroopMember.i)))
      {
        localATroopMember.f = localATroopMember.h;
        localArrayList1.add(localATroopMember);
      }
      else if (str2.equals(localATroopMember.jdField_a_of_type_JavaLangString))
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList1.add(localATroopMember);
      }
      else if ((localATroopMember.n.indexOf(str2) == 0) || (localATroopMember.p.indexOf(str2) == 0) || (localATroopMember.o.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.n;
        localATroopMember.g = localATroopMember.o;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.k.indexOf(str2) == 0) || (localATroopMember.m.indexOf(str2) == 0) || (localATroopMember.l.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.k;
        localATroopMember.g = localATroopMember.l;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.h.indexOf(str2) == 0) || (localATroopMember.j.indexOf(str2) == 0) || (localATroopMember.i.indexOf(str2) == 0))
      {
        localATroopMember.f = localATroopMember.h;
        localATroopMember.g = localATroopMember.i;
        localArrayList2.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) == 0)
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localATroopMember.g = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.n.indexOf(str2) > 0) || (localATroopMember.p.indexOf(str2) > 0) || (localATroopMember.o.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.n;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.k.indexOf(str2) > 0) || (localATroopMember.m.indexOf(str2) > 0) || (localATroopMember.l.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.k;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.h.indexOf(str2) > 0) || (localATroopMember.j.indexOf(str2) > 0) || (localATroopMember.i.indexOf(str2) > 0))
      {
        localATroopMember.f = localATroopMember.h;
        localArrayList3.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) > 0)
      {
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
        break label943;
        label853:
        Collections.sort(localArrayList2, new EditMemberActivity.SearchResultComparator(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Geg.notifyDataSetChanged();
          return;
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
      }
      label943:
      m += 1;
    }
  }
  
  protected void b()
  {
    View localView = getLayoutInflater().inflate(2130905080, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131298720));
    localView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131305223));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300876)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
    this.jdField_a_of_type_Ged = new ged(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ged);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
    f();
    localEditText.setVisibility(0);
    localEditText.setOnTouchListener(new gdv(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_Ged.a();
  }
  
  public void c()
  {
    Object localObject = (InputMethodManager)getSystemService("input_method");
    int m = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -m);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -m, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    gdw localgdw = new gdw(this, localTranslateAnimation1);
    localTranslateAnimation1.setAnimationListener(localgdw);
    localTranslateAnimation2.setAnimationListener(localgdw);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new gdx(this, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296895);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new EditMemberActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new gdz(this));
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300876);
    ((Button)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131367262);
    ((Button)localObject).setOnClickListener(new gea(this));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297767);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297765));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new geb(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Geg.notifyDataSetChanged();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305207));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296706);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131299166));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298104));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297005);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131367394));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a((List)getIntent().getExtras().getParcelableArrayList("list").get(0));
    super.setContentView(2130905077);
    d();
    this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
    this.mDensity = getResources().getDisplayMetrics().density;
    a();
    b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\ui\EditMemberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
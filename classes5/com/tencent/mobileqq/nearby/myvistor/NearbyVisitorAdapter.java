package com.tencent.mobileqq.nearby.myvistor;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tkk;

public class NearbyVisitorAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "svip";
  private static final String jdField_b_of_type_JavaLangString = "vip";
  protected float a;
  protected int a;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  protected ColorStateList a;
  protected BitmapDrawable a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected FaceDecoder a;
  protected IIconDecoder a;
  protected StringBuilder a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  protected int b;
  long jdField_b_of_type_Long;
  protected ColorStateList b;
  protected StringBuilder b;
  List jdField_b_of_type_JavaUtilList;
  protected StringBuilder c;
  List c;
  protected StringBuilder d;
  List d;
  protected StringBuilder e;
  
  public NearbyVisitorAdapter(Context paramContext, View.OnClickListener paramOnClickListener, IIconDecoder paramIIconDecoder, FaceDecoder paramFaceDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_d_of_type_JavaLangStringBuilder = new StringBuilder();
    this.e = new StringBuilder();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = paramIIconDecoder;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_d_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_c_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(NearbyVisitorAdapter.ChildItemHolder paramChildItemHolder, StrangerInfo paramStrangerInfo)
  {
    SingleLineTextView localSingleLineTextView = paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView;
    if ((paramStrangerInfo.strangerDeclare != null) && (paramStrangerInfo.strangerDeclare.length > 0)) {}
    for (paramStrangerInfo = RichStatus.parseStatus(paramStrangerInfo.strangerDeclare);; paramStrangerInfo = null)
    {
      if ((paramStrangerInfo != null) && (!paramStrangerInfo.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramStrangerInfo.actionText)) {
          a(localSingleLineTextView, paramStrangerInfo.actionId);
        }
        for (;;)
        {
          paramChildItemHolder.jdField_b_of_type_Int = paramStrangerInfo.actionId;
          localSingleLineTextView.setText(paramStrangerInfo.toSpannableString(null));
          localSingleLineTextView.setVisibility(0);
          return;
          localSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      paramChildItemHolder.jdField_b_of_type_Int = 0;
      localSingleLineTextView.setVisibility(8);
      return;
    }
  }
  
  public int a()
  {
    return 2130904259;
  }
  
  public StrangerInfo a(int paramInt1, int paramInt2)
  {
    return (StrangerInfo)((List)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).get(paramInt2);
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  protected String a(StrangerInfo paramStrangerInfo)
  {
    if ((paramStrangerInfo != null) && (paramStrangerInfo.lableId == 5) && (paramStrangerInfo.interestNames != null) && (paramStrangerInfo.interestTypes != null))
    {
      this.e.append("共同爱好：");
      this.jdField_d_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_c_of_type_JavaLangStringBuilder.setLength(0);
      ArrayList localArrayList = paramStrangerInfo.interestNames;
      paramStrangerInfo = paramStrangerInfo.interestTypes;
      int i = 0;
      int j = 0;
      if (i < localArrayList.size())
      {
        int k = j;
        if (i == 0)
        {
          k = j;
          if (((Integer)paramStrangerInfo.get(0)).intValue() == 1) {
            k = 1;
          }
        }
        if (((Integer)paramStrangerInfo.get(i)).intValue() == 1)
        {
          if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
            this.jdField_d_of_type_JavaLangStringBuilder.append("、");
          }
          this.jdField_d_of_type_JavaLangStringBuilder.append((String)localArrayList.get(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          if (((Integer)paramStrangerInfo.get(i)).intValue() == 2)
          {
            if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
              this.jdField_c_of_type_JavaLangStringBuilder.append("、");
            }
            String str = (String)localArrayList.get(i);
            if (str.startsWith("爱")) {
              this.jdField_c_of_type_JavaLangStringBuilder.append(str.substring("爱".length()));
            } else {
              this.jdField_c_of_type_JavaLangStringBuilder.append(str);
            }
          }
          else
          {
            if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
              this.jdField_c_of_type_JavaLangStringBuilder.append("、");
            }
            this.jdField_c_of_type_JavaLangStringBuilder.append((String)localArrayList.get(i));
          }
        }
      }
      if (j != 0)
      {
        if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0)
        {
          this.e.append("去过").append(this.jdField_d_of_type_JavaLangStringBuilder);
          if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
            this.e.append("；");
          }
        }
        if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
          this.e.append("喜欢").append(this.jdField_c_of_type_JavaLangStringBuilder);
        }
      }
      for (;;)
      {
        return this.e.toString();
        if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0)
        {
          this.e.append("喜欢").append(this.jdField_c_of_type_JavaLangStringBuilder);
          if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
            this.e.append("；");
          }
        }
        if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
          this.e.append(this.jdField_d_of_type_JavaLangStringBuilder);
        }
      }
    }
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2, NearbyVisitorAdapter.ChildItemHolder paramChildItemHolder)
  {
    this.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    StrangerInfo localStrangerInfo = a(paramInt1, paramInt2);
    paramChildItemHolder.jdField_a_of_type_ComTencentMobileqqDataStrangerInfo = localStrangerInfo;
    label107:
    label164:
    label317:
    label372:
    String str4;
    String str3;
    String str1;
    label508:
    String str2;
    if (localStrangerInfo.tinyId > 0L)
    {
      paramChildItemHolder.jdField_a_of_type_JavaLangString = String.valueOf(localStrangerInfo.tinyId);
      paramChildItemHolder.jdField_a_of_type_Int = 32;
      paramChildItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(false));
      a(localStrangerInfo, paramChildItemHolder.jdField_a_of_type_AndroidWidgetImageView);
      if (localStrangerInfo.godFlag != 1) {
        break label1138;
      }
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (localStrangerInfo.gender != 1) {
        break label1125;
      }
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841138);
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      if (TextUtils.isEmpty(localStrangerInfo.nickName)) {
        break label1150;
      }
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localStrangerInfo.nickName.trim());
      if (AppSetting.j) {
        this.jdField_b_of_type_JavaLangStringBuilder.append(localStrangerInfo.nickName.trim());
      }
      int i = this.jdField_a_of_type_Int - (int)(189.0F * this.jdField_a_of_type_Float);
      paramInt2 = i;
      if (!TextUtils.isEmpty(localStrangerInfo.vipInfo))
      {
        paramInt1 = i;
        if ("svip".equalsIgnoreCase(localStrangerInfo.vipInfo)) {
          paramInt1 = i - (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
        }
        paramInt2 = paramInt1;
        if ("vip".equalsIgnoreCase(localStrangerInfo.vipInfo)) {
          paramInt2 = paramInt1 - (int)Math.ceil(28.5F * this.jdField_a_of_type_Float);
        }
      }
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setMaxWidth(paramInt2);
      if (TextUtils.isEmpty(localStrangerInfo.vipInfo)) {
        break label1227;
      }
      if (!"svip".equalsIgnoreCase(localStrangerInfo.vipInfo)) {
        break label1163;
      }
      paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843363);
      a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, true);
      paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setText(localStrangerInfo.timeStr);
      paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      switch (localStrangerInfo.gender)
      {
      default: 
        if (localStrangerInfo.age > 0)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append(' ').append(localStrangerInfo.age).append('岁');
          if (AppSetting.j) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localStrangerInfo.age).append("岁");
          }
        }
        str4 = "";
        if ((localStrangerInfo != null) && (localStrangerInfo.lableId > 0))
        {
          str3 = a(localStrangerInfo);
          if (TextUtils.isEmpty(str3))
          {
            paramChildItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
            paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            if (localStrangerInfo.lableMsgPre != null)
            {
              str1 = new String(localStrangerInfo.lableMsgPre);
              if (localStrangerInfo.lableMsgLast == null) {
                break label1330;
              }
              str2 = new String(localStrangerInfo.lableMsgLast);
              label530:
              if (!this.jdField_a_of_type_Boolean) {
                break label1338;
              }
              paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + str2);
              label564:
              paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localStrangerInfo.lableId));
              if (!AppSetting.j) {
                break label1497;
              }
              str1 = str1 + str2;
              paramInt2 = 1;
              paramInt1 = 1;
              str2 = str3;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramChildItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (!TextUtils.isEmpty(localStrangerInfo.constellation))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append(' ').append(localStrangerInfo.constellation);
          if (AppSetting.j) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localStrangerInfo.constellation);
          }
        }
      }
      if ((localStrangerInfo.profession > 0) && (localStrangerInfo.profession < 14))
      {
        str3 = com.tencent.mobileqq.util.NearbyProfileUtil.e[localStrangerInfo.profession];
        this.jdField_a_of_type_JavaLangStringBuilder.append(' ').append(str3);
        if (AppSetting.j) {
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("职业").append(" ").append(str3);
        }
      }
      if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
      {
        paramInt1 += 1;
        paramChildItemHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
        paramChildItemHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        label815:
        if (localStrangerInfo.charmLevel < 4) {
          break label1401;
        }
        if (paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        switch (localStrangerInfo.charmLevel)
        {
        default: 
          paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840884);
          label882:
          if (AppSetting.j) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("拥有魅力勋章");
          }
          label905:
          if ((AppSetting.j) && (!TextUtils.isEmpty(str1))) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(str1);
          }
          if (paramInt1 > 0)
          {
            paramChildItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            label947:
            if (TextUtils.isEmpty(str2)) {
              break label1437;
            }
            paramChildItemHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130840932, 0);
            paramChildItemHolder.d.setCompoundDrawablePadding((int)(5.0F * this.jdField_a_of_type_Float));
            if (!paramChildItemHolder.d.a().equals(str2)) {
              paramChildItemHolder.d.setText(str2);
            }
            paramChildItemHolder.d.setVisibility(0);
            paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(str2).append(" ");
          }
          break;
        }
      }
      for (;;)
      {
        if (AppSetting.j)
        {
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.a());
          paramChildItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_b_of_type_JavaLangStringBuilder.toString());
          if (QLog.isColorLevel()) {
            NearbyUtils.a("NearbyVisitorAdapter", "talckback", new Object[] { this.jdField_b_of_type_JavaLangStringBuilder.toString() });
          }
        }
        return;
        localStrangerInfo.tinyId = 0L;
        break;
        label1125:
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841137);
        break label107;
        label1138:
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label107;
        label1150:
        paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        break label164;
        label1163:
        if ("vip".equalsIgnoreCase(localStrangerInfo.vipInfo))
        {
          paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843496);
          a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, true);
          break label317;
        }
        paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, false);
        break label317;
        label1227:
        paramChildItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, false);
        break label317;
        this.jdField_a_of_type_JavaLangStringBuilder.append("男");
        if (!AppSetting.j) {
          break label372;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(",男");
        break label372;
        this.jdField_a_of_type_JavaLangStringBuilder.append("女");
        if (!AppSetting.j) {
          break label372;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("女");
        break label372;
        str1 = "";
        break label508;
        label1330:
        str2 = "";
        break label530;
        label1338:
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
        break label564;
        paramChildItemHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label815;
        paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840889);
        break label882;
        paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840890);
        break label882;
        paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840891);
        break label882;
        label1401:
        if (paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 8) {
          break label905;
        }
        paramChildItemHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        break label905;
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label947;
        label1437:
        paramChildItemHolder.d.setVisibility(8);
        paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        a(paramChildItemHolder, localStrangerInfo);
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("交友宣言").append(paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(" ");
      }
      label1497:
      paramInt2 = 1;
      paramInt1 = 1;
      str1 = str4;
      str2 = str3;
      continue;
      paramInt2 = 0;
      paramInt1 = 0;
      str1 = str4;
      str2 = str3;
      continue;
      paramInt2 = 0;
      str2 = "";
      paramInt1 = 0;
      str1 = str4;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    tkk localtkk2 = (tkk)paramView.getTag();
    tkk localtkk1 = localtkk2;
    if (localtkk2 == null)
    {
      localtkk1 = new tkk(this, null);
      localtkk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131302084));
      int i = paramView.getResources().getColor(2131428199);
      ((ImageView)paramView.findViewById(2131302085)).setBackgroundColor(i);
    }
    localtkk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)this.jdField_d_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(StrangerInfo paramStrangerInfo, ImageView paramImageView)
  {
    if (paramStrangerInfo != null) {
      try
      {
        if (paramStrangerInfo.tinyId > 0L)
        {
          paramStrangerInfo = String.valueOf(paramStrangerInfo.tinyId);
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramStrangerInfo, 202);
          if (localBitmap == null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramStrangerInfo, 202, true, false);
            }
            if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
            }
            paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
            return;
          }
          paramImageView.setImageBitmap(localBitmap);
          return;
        }
      }
      catch (Throwable paramStrangerInfo)
      {
        paramStrangerInfo.printStackTrace();
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
    }
    paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  protected void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(paramInt), 200, false, true);
    localObject = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject, false, false);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    ((StatableBitmapDrawable)localObject).setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    paramSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
  }
  
  public void a(SingleLineTextView paramSingleLineTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
        this.jdField_a_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131428329);
      }
      paramSingleLineTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      return;
    }
    if (this.jdField_b_of_type_AndroidContentResColorStateList == null) {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131428297);
    }
    paramSingleLineTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
  }
  
  public void a(List paramList, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StrangerInfo localStrangerInfo = (StrangerInfo)paramList.next();
        if (localStrangerInfo.isNewVisitor) {
          this.jdField_b_of_type_JavaUtilList.add(localStrangerInfo);
        } else {
          this.jdField_c_of_type_JavaUtilList.add(localStrangerInfo);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      paramList = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131372519), new Object[] { Long.valueOf(this.jdField_a_of_type_Long) });
      this.jdField_d_of_type_JavaUtilList.add(paramList);
    }
    if (this.jdField_c_of_type_JavaUtilList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      paramList = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131372520), new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
      this.jdField_d_of_type_JavaUtilList.add(paramList);
    }
    notifyDataSetChanged();
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new NearbyVisitorAdapter.ChildItemHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903414, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296790));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131298497));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131298397));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131297741));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298498));
      paramView.jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131298510));
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131298502));
      paramView.jdField_e_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131298504));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298506));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297537);
      paramView.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298505));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298398));
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131298402));
      paramView.d = ((SingleLineTextView)localView.findViewById(2131298509));
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(paramView);
    }
    a(paramInt1, paramInt2, (NearbyVisitorAdapter.ChildItemHolder)localView.getTag());
    return localView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getGroupCount()
  {
    return this.jdField_d_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new tkk(this, null);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904259, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131302084));
      localView.setTag(paramView);
    }
    ((tkk)localView.getTag()).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)this.jdField_d_of_type_JavaUtilList.get(paramInt));
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\myvistor\NearbyVisitorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
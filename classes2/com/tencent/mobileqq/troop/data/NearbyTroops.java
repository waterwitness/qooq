package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView.LayoutParams;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import vli;
import vlj;

public class NearbyTroops
{
  public static final int A = 195;
  public static final int B = 213;
  public static final int C = 190;
  public static final int D = 206;
  public static final int E = 220;
  protected static final int F = 5;
  protected static final int G = 1;
  protected static final int H = 2;
  protected static final int I = 3;
  protected static final int J = 4;
  protected static final int K = 7;
  public static final double a = 6378137.0D;
  public static final int a = 1;
  private static final String a;
  public static final boolean a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 150;
  public static final int l = 55;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 3;
  public static final int z = 175;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyTroops.class.getSimpleName();
    jdField_a_of_type_Boolean = AppSetting.j;
  }
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
    double d3 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
    double d4 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
    d1 = a(d1);
    d3 = a(d3);
    d4 = a(d4);
    d2 = a(d2);
    double d5 = Math.pow(Math.sin((d1 - d3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(d1) * Math.cos(d3) * Math.pow(Math.sin((d4 - d2) / 2.0D), 2.0D) + d5)) * 2.0D * 6378137.0D * 10000.0D) / 10000L;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903676, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2130905008);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.CustomViewHolder();
    paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299713));
    paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298260));
    paramViewGroup.g = ((TextView)paramContext.findViewById(2131299717));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131302352));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(paramInt1);
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131302355));
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(2);
    paramViewGroup.j = ((TextView)paramContext.findViewById(2131302354));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setDistanceTextView(paramViewGroup.j);
    paramViewGroup.h = ((TextView)paramContext.findViewById(2131302353));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299716));
    paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131302351));
    paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131296824));
    paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131302356));
    paramViewGroup.i = ((TextView)paramContext.findViewById(2131302357));
    paramViewGroup.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131299583);
    paramViewGroup.e = paramInt1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903675, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131299686));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131299688));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299687));
    if (paramBoolean) {
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = 3;
      paramContext.setTag(paramViewGroup);
      return paramContext;
      paramViewGroup.b.setVisibility(4);
    }
  }
  
  public static CharSequence a(GroupInfo paramGroupInfo, Context paramContext, Boolean paramBoolean)
  {
    String str = "[icon]" + " " + paramGroupInfo.iMemberCnt + "人  ";
    SpannableString localSpannableString = new SpannableString(str);
    ImageSpan localImageSpan = new ImageSpan(paramContext, 2130843477, 1);
    localSpannableString.setSpan(localImageSpan, 0, "[icon]".length(), 17);
    if ((paramGroupInfo.strLocation == null) || (paramGroupInfo.strLocation.length() == 0) || (!paramBoolean.booleanValue())) {
      return localSpannableString;
    }
    paramGroupInfo = "[icon]" + " " + paramGroupInfo.strLocation;
    paramGroupInfo = new SpannableString(str + paramGroupInfo);
    paramContext = new ImageSpan(paramContext, 2130843485, 1);
    paramGroupInfo.setSpan(localImageSpan, 0, "[icon]".length(), 17);
    paramGroupInfo.setSpan(paramContext, str.length(), str.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  public static void a(View paramView)
  {
    paramView.setBackgroundResource(2130837958);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131368207);
    paramView.b.setVisibility(8);
    paramView.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, Context paramContext)
  {
    Object localObject = new AbsListView.LayoutParams(-1, -1);
    ((AbsListView.LayoutParams)localObject).height = paramInt1;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (NearbyTroops.OccupyViewHolder)paramView.getTag();
    if (paramInt2 == 2)
    {
      paramInt1 = 2131367339;
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1);
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8814455);
      if (jdField_a_of_type_Boolean) {
        paramView.setContentDescription(paramContext.getResources().getString(paramInt1));
      }
      return;
      paramInt1 = 2131367338;
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new vlj(paramContext));
    }
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean, true);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    NearbyTroops.CustomViewHolder localCustomViewHolder = (NearbyTroops.CustomViewHolder)paramView.getTag();
    localCustomViewHolder.jdField_b_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131428297));
    Object localObject1;
    Object localObject2;
    int i1;
    if ((paramBoolean2) && (paramGroupInfo.labels != null))
    {
      localObject1 = paramGroupInfo.labels.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupLabel)((Iterator)localObject1).next();
        if (((GroupLabel)localObject2).type == 2001L)
        {
          i1 = android.graphics.Color.rgb((int)((GroupLabel)localObject2).text_color.R, (int)((GroupLabel)localObject2).text_color.G, (int)((GroupLabel)localObject2).text_color.B);
          localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        }
      }
    }
    localCustomViewHolder.h.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localCustomViewHolder.h.setText(2131364904);
      localCustomViewHolder.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
      if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0)) {
        break label674;
      }
      if ((localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList == null) || (localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      ((GroupLabel)localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.labels = localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList;
      a(paramContext, localCustomViewHolder, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label768;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label723;
      }
      localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838906);
      label405:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label781;
      }
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setBackgroundResource(2130839417);
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      label436:
      if (jdField_a_of_type_Boolean)
      {
        localObject1 = "" + paramGroupInfo.strName;
        paramContext = paramGroupInfo.iMemberCnt + "人  ";
        if (paramGroupInfo.labels == null) {
          break label863;
        }
        localObject2 = new StringBuffer();
        int i2 = paramGroupInfo.labels.size();
        i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            GroupLabel localGroupLabel = (GroupLabel)paramGroupInfo.labels.get(i1);
            if ((localGroupLabel != null) && (!TextUtils.isEmpty(localGroupLabel.strWording))) {
              ((StringBuffer)localObject2).append(localGroupLabel.strWording).append(" ");
            }
            i1 += 1;
            continue;
            i1 = paramContext.getResources().getDisplayMetrics().widthPixels;
            if (localCustomViewHolder.jdField_d_of_type_Int == 1) {
              i1 -= AIOUtils.a(110.0F, paramContext.getResources());
            }
            for (;;)
            {
              TextUtils.ellipsize(paramGroupInfo.strIntro, localCustomViewHolder.h.getPaint(), i1, TextUtils.TruncateAt.END, false, new vli(localCustomViewHolder, paramGroupInfo));
              break;
              i1 = (i1 - AIOUtils.a(137.0F, paramContext.getResources())) * 2;
            }
            label674:
            if ((a(paramContext, localCustomViewHolder, paramGroupInfo)) || (!QLog.isColorLevel())) {
              break;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
            break;
            label723:
            if (paramGroupInfo.dwCertType == 1L)
            {
              localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839365);
              break label405;
            }
            localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label405;
            label768:
            localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label405;
            label781:
            localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
            break label436;
          }
        }
        if (((StringBuffer)localObject2).length() <= 0) {
          break label863;
        }
        paramContext = ((StringBuffer)localObject2).toString();
      }
    }
    label863:
    for (;;)
    {
      localCustomViewHolder.g.setContentDescription(paramContext);
      paramContext = (String)localObject1 + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
    }
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    localGroupViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString + "(" + (int)paramFloat1 + ")");
    if (paramFloat2 < 1000.0F) {
      if (paramFloat2 <= 50.0F) {
        paramView = "50m";
      }
    }
    for (;;)
    {
      localGroupViewHolder.b.setText(paramView);
      if (!paramBoolean) {
        break;
      }
      localGroupViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840064);
      return;
      paramView = (int)(Math.floor(paramFloat2 / 50.0F) * 50.0D) + "m";
      continue;
      paramView = new DecimalFormat("#.##");
      paramView = paramView.format(Math.ceil(paramFloat2 / 50.0F) * 0.05D) + "km";
    }
    localGroupViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840063);
  }
  
  public static void a(View paramView, boolean paramBoolean, int paramInt)
  {
    int i2 = 8;
    paramView.setBackgroundResource(2130838312);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
    if (paramBoolean)
    {
      i1 = 0;
      ((ProgressBar)localObject).setVisibility(i1);
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i1 = 0;; i1 = 8)
    {
      ((TextView)localObject).setVisibility(i1);
      localObject = paramView.b;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((TextView)localObject).setVisibility(i1);
      paramView.jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label111;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131368207);
      return;
      i1 = 8;
      break;
    }
    label111:
    paramView.b.setText("更多(" + paramInt + ")");
  }
  
  protected static boolean a(Context paramContext, NearbyTroops.CustomViewHolder paramCustomViewHolder, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (paramCustomViewHolder == null) || (paramGroupInfo == null) || (paramGroupInfo.labels == null) || (paramGroupInfo.labels.size() == 0)) {
      return false;
    }
    paramCustomViewHolder.g.setVisibility(8);
    paramCustomViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
    paramContext = paramGroupInfo.labels;
    paramCustomViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
    return paramCustomViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
  }
  
  public static View b(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903677, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 2;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View c(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903679, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.OccupyViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297123));
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131299689));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View d(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903678, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.MoreBtnViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131297005));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298457));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131297124));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\NearbyTroops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
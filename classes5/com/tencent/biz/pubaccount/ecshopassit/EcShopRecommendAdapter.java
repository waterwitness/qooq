package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import huh;
import hui;
import huk;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.qqshop.qqshop.SQQSHPRecmdAccount;

public class EcShopRecommendAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, HorizontalListView.OnScrollStateChangedListener
{
  public static final int a = 4;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public Activity a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new hui(this);
  public QQAppInterface a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected List a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.bj + ".shop_assit/recommendHead/";
  }
  
  public EcShopRecommendAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4097)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1);
        if (String.valueOf(localView.getTag(2131296584)).equals(paramString)) {
          ((ImageView)localView.findViewById(2131296790)).setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(huk paramhuk, int paramInt)
  {
    paramhuk.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    paramhuk.jdField_a_of_type_AndroidViewView.setVisibility(4);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      paramhuk.jdField_a_of_type_AndroidWidgetButton.setText(2131364541);
      paramhuk.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131428281));
      paramhuk.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramhuk.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841678);
      return;
    case 3: 
      paramhuk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    paramhuk.jdField_a_of_type_AndroidWidgetButton.setText(2131370331);
    paramhuk.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131428285));
    paramhuk.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramhuk.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841682);
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    qqshop.SQQSHPRecmdAccount localSQQSHPRecmdAccount = (qqshop.SQQSHPRecmdAccount)getItem(paramInt);
    if (localSQQSHPRecmdAccount == null)
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    huk localhuk;
    label195:
    label225:
    String str;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130904537, null);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), -1));
      localhuk = new huk(this);
      localhuk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296790));
      localhuk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303099));
      localhuk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      localhuk.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300058));
      localhuk.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297445);
      localhuk.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnClickListener(new huh(this, localSQQSHPRecmdAccount));
      localhuk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303100));
      paramView.setTag(localhuk);
      localhuk.jdField_a_of_type_AndroidWidgetButton.setTag(localhuk);
      localhuk.jdField_a_of_type_TencentImOidbQqshopQqshop$SQQSHPRecmdAccount = localSQQSHPRecmdAccount;
      if (!localSQQSHPRecmdAccount.puin.has()) {
        break label449;
      }
      paramViewGroup = Long.valueOf(localSQQSHPRecmdAccount.puin.get());
      str = String.valueOf(paramViewGroup);
      paramView.setTag(2131296584, str);
      paramViewGroup = localSQQSHPRecmdAccount.nick.get();
      if (!TextUtils.isEmpty(str)) {
        break label462;
      }
      TextView localTextView = localhuk.jdField_a_of_type_AndroidWidgetTextView;
      if (paramViewGroup != null) {
        break label456;
      }
      localObject = "";
      label272:
      localTextView.setText((CharSequence)localObject);
      if (AppSetting.j)
      {
        localObject = paramViewGroup;
        if (paramViewGroup == null) {
          localObject = "";
        }
        paramView.setContentDescription((CharSequence)localObject);
      }
      localhuk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.b());
      label314:
      localhuk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localhuk.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 70.0F));
      if ((TextUtils.isEmpty(str)) || (!PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))) {
        break label561;
      }
      a(localhuk, 2);
      label369:
      if (!localSQQSHPRecmdAccount.desc.has()) {
        break label571;
      }
    }
    label449:
    label456:
    label462:
    label561:
    label571:
    for (paramViewGroup = localSQQSHPRecmdAccount.desc.get();; paramViewGroup = "")
    {
      localObject = String.valueOf(paramViewGroup);
      localhuk.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramViewGroup = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localhuk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramView;
      localhuk = (huk)paramView.getTag();
      localhuk.jdField_a_of_type_AndroidWidgetButton.setTag(localhuk);
      break label195;
      paramViewGroup = "";
      break label225;
      localObject = paramViewGroup;
      break label272;
      localObject = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        localObject = str;
      }
      localhuk.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (AppSetting.j) {
        paramView.setContentDescription((CharSequence)localObject);
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, str);
      if (paramViewGroup == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 1, true);
        }
        localhuk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838582);
        break label314;
      }
      localhuk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramViewGroup);
      break label314;
      a(localhuk, 1);
      break label369;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
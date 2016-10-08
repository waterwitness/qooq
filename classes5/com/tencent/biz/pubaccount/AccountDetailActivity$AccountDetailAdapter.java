package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.AccountDetail.bean.PictureAttr;
import com.tencent.biz.pubaccount.AccountDetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import hng;
import hnh;
import hni;
import hnj;
import hnk;
import hnl;
import hnm;
import java.util.ArrayList;

public class AccountDetailActivity$AccountDetailAdapter
  extends BaseAdapter
{
  final int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  final int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  final int c;
  final int d;
  final int e;
  
  protected AccountDetailActivity$AccountDetailAdapter(AccountDetailActivity paramAccountDetailActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.d = 3;
    this.e = 4;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    paramAccountDetailActivity = AccountDetailDynamicDataManager.a(paramAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramAccountDetailActivity.p);
    if (paramAccountDetailActivity != null)
    {
      a(paramAccountDetailActivity.a(), paramAccountDetailActivity.jdField_a_of_type_Boolean);
      a(paramAccountDetailActivity.b());
    }
  }
  
  private Bundle a(DynamicInfo paramDynamicInfo)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Long));
    if ((paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int == 2) || (paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int == 3)) {
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Long));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramDynamicInfo.A);
    localBundle2.putString("req_create_time", ReadInJoyTimeUtils.d(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c));
    localBundle2.putString("brief_key", paramDynamicInfo.A);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramDynamicInfo.A);
    return localBundle1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public DynamicInfo a(int paramInt)
  {
    if (paramInt > 1) {
      return (DynamicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 2);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.g())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b = true;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
    }
  }
  
  void a(View paramView, hnm paramhnm)
  {
    paramhnm.a = ((Button)paramView.findViewById(2131296811));
    paramhnm.b = ((Button)paramView.findViewById(2131296812));
    int i = (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getWindowManager().getDefaultDisplay().getWidth() * 0.13D);
    paramhnm.a.setPadding(0, 0, i, 0);
    paramhnm.b.setPadding(i, 0, 0, 0);
    paramhnm.a.setOnClickListener(new hni(this));
    paramhnm.b.setOnClickListener(new hnj(this));
  }
  
  public void a(DynamicInfo paramDynamicInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, 2131363475, 1).b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "open full play activity, articleID : " + paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Long + ",vid : " + paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    }
    paramDynamicInfo = a(paramDynamicInfo);
    Activity localActivity = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getActivity();
    Intent localIntent = new Intent(localActivity, MultiVideoPlayActivity.class);
    localIntent.putExtras(paramDynamicInfo);
    localActivity.overridePendingTransition(2130968620, 2130968621);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(localIntent);
  }
  
  void a(hnk paramhnk, View paramView, int paramInt)
  {
    boolean bool = false;
    DynamicInfo localDynamicInfo = a(paramInt);
    if (localDynamicInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "动态消息为空");
      }
    }
    do
    {
      return;
      if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "动态消息的消息属性为空");
    return;
    paramInt = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Int;
    if (paramInt == 2) {
      bool = true;
    }
    String str2 = localDynamicInfo.A;
    Long localLong = Long.valueOf(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c);
    String str1 = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDataForDynamicMsg:title =" + str2 + "--coverUrl=" + "" + "--jumpUrl=" + str1 + "--isVideoMsg =" + bool);
    }
    Object localObject;
    if (bool)
    {
      paramhnk.c.setVisibility(0);
      paramhnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramhnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr == null) {
        break label578;
      }
      localObject = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString;
      paramhnk.c.setText(UITools.a(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str2)) || (localLong.longValue() <= 0L))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "动态消息内容不合法");
        return;
        paramhnk.c.setVisibility(4);
        paramhnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramhnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr == null) {
          break label578;
        }
        localObject = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr.jdField_a_of_type_JavaLangString;
        continue;
      }
      Resources localResources = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getResources();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject = URLDrawable.getDrawable((String)localObject, AIOUtils.a(124.0F, localResources), AIOUtils.a(95.0F, localResources), localColorDrawable, localColorDrawable, true);
      paramhnk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        localObject = str2 + "  ";
        paramhnk.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml((String)localObject));
      }
      for (;;)
      {
        paramhnk.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyTimeUtils.d(localLong.longValue()));
        paramView.setOnClickListener(new hnh(this, paramInt, str1, localDynamicInfo));
        return;
        paramhnk.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(str2));
      }
      label578:
      localObject = "";
    }
  }
  
  void a(hnl paramhnl, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.q)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.P != AccountDetailActivity.M) {
        break label79;
      }
      paramhnl.jdField_a_of_type_AndroidWidgetTextView.setText(2131372664);
      paramView.setClickable(false);
      paramhnl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramhnl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      paramhnl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      paramhnl.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new hng(this, paramhnl));
      return;
      label79:
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.P == AccountDetailActivity.N)
      {
        paramhnl.jdField_a_of_type_AndroidWidgetTextView.setText(2131364487);
        paramhnl.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Float * 5.0F), 0, (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Float * 5.0F));
        paramhnl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838205);
        paramView.setClickable(true);
        paramhnl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.P == AccountDetailActivity.O)
      {
        paramhnl.jdField_a_of_type_AndroidWidgetTextView.setText(2131372668);
        paramView.setClickable(false);
        paramhnl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838859);
        paramhnl.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Float * 5.0F), 0, (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Float * 5.0F));
        paramhnl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o)
    {
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.g())) {
        return 3;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 2;
    }
    return 2;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      if (paramInt == 1) {
        return 1;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.g()) {
          return 4;
        }
        return 2;
      }
      return 3;
    }
    return 3;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      switch (i)
      {
      default: 
        localObject3 = null;
        paramViewGroup = null;
        localObject1 = paramView;
        paramView = (View)localObject3;
        localObject3 = localObject2;
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject3;
      }
    }
    for (;;)
    {
      if ((i == 2) && (paramViewGroup != null)) {
        a(paramViewGroup, paramView, paramInt);
      }
      if ((i == 4) && (localObject2 != null)) {
        a((hnl)localObject2, paramView);
      }
      if ((i == 1) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(((hnm)localObject1).a, ((hnm)localObject1).b);
      }
      return paramView;
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903042, paramViewGroup, false);
      ((View)localObject1).setOnClickListener(null);
      paramView = (LinearLayout)((View)localObject1).findViewById(2131296809);
      paramViewGroup = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.G = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getWindowManager().getDefaultDisplay().getHeight();
      paramViewGroup.height = ((int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.G * AccountDetailActivity.jdField_a_of_type_Double));
      paramView.setLayoutParams(paramViewGroup);
      paramView = null;
      paramViewGroup = null;
      break;
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903043, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.I = ((View)localObject1).getLayoutParams().height;
      paramViewGroup = new hnm(this);
      a((View)localObject1, paramViewGroup);
      ((View)localObject1).setTag(paramViewGroup);
      paramView = null;
      break;
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903462, paramViewGroup, false);
      localObject2 = new hnk(this);
      ((hnk)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject1).findViewById(2131298682));
      ((hnk)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131298686));
      ((hnk)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131298687));
      ((hnk)localObject2).c = ((TextView)((View)localObject1).findViewById(2131298685));
      ((hnk)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131298684));
      ((hnk)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131298683));
      ((View)localObject1).setTag(localObject2);
      paramView = null;
      paramViewGroup = null;
      break;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o)
      {
        ((View)localObject1).setMinimumHeight(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e());
        paramView = null;
        paramViewGroup = null;
        break;
      }
      ((View)localObject1).setMinimumHeight(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f());
      paramView = null;
      paramViewGroup = null;
      break;
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903461, paramViewGroup, false);
      paramView = new hnl(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131298680));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131298679));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131298681));
      ((View)localObject1).setMinimumHeight(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e());
      ((View)localObject1).setTag(paramView);
      paramViewGroup = null;
      break;
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject1 = null;
        localObject2 = localObject3;
        break;
      case 0: 
        paramViewGroup = null;
        localObject1 = null;
        localObject2 = localObject3;
        break;
      case 1: 
        localObject1 = (hnm)paramView.getTag();
        paramViewGroup = null;
        localObject2 = localObject3;
        break;
      case 2: 
        paramViewGroup = (hnk)paramView.getTag();
        localObject1 = null;
        localObject2 = localObject3;
        break;
      case 3: 
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o)
        {
          paramView.setMinimumHeight(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e());
          paramViewGroup = null;
          localObject1 = null;
          localObject2 = localObject3;
        }
        else
        {
          paramView.setMinimumHeight(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f());
          paramViewGroup = null;
          localObject1 = null;
          localObject2 = localObject3;
        }
        break;
      case 4: 
        localObject2 = (hnl)paramView.getTag();
        localObject1 = null;
        paramViewGroup = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o) {
      return 3;
    }
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetailActivity$AccountDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
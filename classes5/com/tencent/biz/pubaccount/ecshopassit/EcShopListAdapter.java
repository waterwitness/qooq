package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager.ImageHostListener;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import hue;
import huf;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EcShopListAdapter
  extends BaseAdapter
  implements View.OnClickListener, SubscriptPicManager.ImageHostListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final String jdField_a_of_type_JavaLangString = "EcShopListAdapter";
  int jdField_a_of_type_Int;
  public Context a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  EcShopAssistantManager jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager;
  SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  List jdField_a_of_type_JavaUtilList;
  
  public EcShopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 9;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = ((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    paramContext = View.inflate(paramContext, 2130904535, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131303093);
    paramContext.findViewById(2131303094).setOnClickListener(new hue(this));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.b(paramContext);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = new SubscriptPicManager();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof huf)))
        {
          localObject = (huf)localObject;
          if (paramString.equals(((huf)localObject).jdField_a_of_type_JavaLangString)) {
            ((huf)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetSwipListView.s();
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
      while (paramInt <= j)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt);
        if ((paramAbsListView != null) && ((paramAbsListView.getTag() instanceof huf)))
        {
          paramAbsListView = (huf)paramAbsListView.getTag();
          int i = 0;
          while (i < paramAbsListView.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
          {
            Drawable localDrawable = paramAbsListView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getDrawable();
            if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)) && (!((URLDrawable)localDrawable).isDownloadStarted()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("EcShopListAdapter", 2, "ecshop liststart download pic!");
              }
              ((URLDrawable)localDrawable).startDownload();
              ((URLDrawable)localDrawable).setAutoDownload(true);
            }
            i += 1;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView == null) {
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.s();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    paramImageView = paramImageView.getTag(2131296586);
    if ((paramImageView != null) && ((paramImageView instanceof Integer)))
    {
      int k = ((Integer)paramImageView).intValue();
      if ((k >= i) && (k <= j)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return Integer.valueOf(this.jdField_a_of_type_Int);
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    View localView;
    Object localObject2;
    label298:
    label450:
    label510:
    int i;
    label521:
    label732:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new huf(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904536, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296790));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)localView.findViewById(2131301711), (ImageView)localView.findViewById(2131301712), (ImageView)localView.findViewById(2131301713) };
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131296829));
      paramViewGroup.b = ((TextView)localView.findViewById(2131299765));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303096));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131299995));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, localView);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298786));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131303095);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localView.setTag(paramViewGroup);
      localObject2 = (RecentItemEcShop)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((RecentItemEcShop)localObject2).a();
      if ((!((RecentItemEcShop)localObject2).jdField_b_of_type_JavaLangString.matches("^[1-9]\\d*$")) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)))) {
        break label1289;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString);
      localObject1 = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(((RecentItemEcShop)localObject2).jdField_a_of_type_Long))) {
        localObject1 = paramView + "(" + ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((RecentItemEcShop)localObject2).jdField_a_of_type_Long)) + ")";
      }
      if (((RecentItemEcShop)localObject2).I == 0) {
        break label1298;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(((RecentItemEcShop)localObject2).I);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramView);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      if (((RecentItemEcShop)localObject2).a() <= 0L) {
        break label1310;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(TimeManager.a().a(paramViewGroup.jdField_a_of_type_JavaLangString, ((RecentItemEcShop)localObject2).a()));
      if (((RecentItemEcShop)localObject2).H <= 0) {
        break label1322;
      }
      i = 3;
      CustomWidgetUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, ((RecentItemEcShop)localObject2).H, 2130843325, 99, null);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131296585, localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramViewGroup.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(2131296585, localObject2);
      if (AppSetting.j) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format("点击进入%1$s资料卡页面", new Object[] { ((RecentItemEcShop)localObject2).b() }));
      }
      i = ((RecentItemEcShop)localObject2).c();
      paramView = "";
      if (i > 0)
      {
        if (i / 1000 <= 0) {
          break label1328;
        }
        paramView = new BigDecimal(i / 1000.0F);
        paramView = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369273) + paramView.setScale(1, 4).floatValue() + "km]";
      }
      localObject1 = new QQText(String.valueOf(((RecentItemEcShop)localObject2).jdField_b_of_type_JavaLangCharSequence).replaceFirst("^\\s+", ""), 3, 20);
      if (TextUtils.isEmpty(paramView)) {
        break label1378;
      }
      localObject3 = new SpannableString(paramView);
      ((Spannable)localObject3).setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, paramView.length(), 33);
      paramView = new SpannableStringBuilder();
      paramView.append((CharSequence)localObject3);
      paramView.append((CharSequence)localObject1);
      paramViewGroup.b.setText(paramView);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(2131296585, localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      float f2 = paramViewGroup.jdField_a_of_type_AndroidWidgetButton.getWidth();
      paramView = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getLayoutParams();
      if (!TextUtils.isEmpty(((RecentItemEcShop)localObject2).jdField_a_of_type_JavaLangString)) {
        break label1390;
      }
      paramViewGroup.b.setPadding(0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.topMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localView.findViewById(2131303098).setVisibility(8);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131296585, localObject2);
      localView.setTag(-3, Integer.valueOf((int)f2));
      paramView = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
      if ((TextUtils.isEmpty(paramViewGroup.jdField_a_of_type_JavaLangString)) || (!paramViewGroup.jdField_a_of_type_JavaLangString.equals(EcShopAssistantManager.S))) {
        break label1688;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localObject1 = (ImageButton)localView.findViewById(2131303097);
      ((ImageButton)localObject1).setVisibility(0);
      ((ImageButton)localObject1).setTag(2131296585, localObject2);
      ((ImageButton)localObject1).setOnClickListener(this);
      if (!TextUtils.isEmpty(EcShopAssistantActivity.e))
      {
        localObject1 = (URLImageView)localView.findViewById(2131299520);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838381);
      }
      try
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        localObject2 = URLDrawable.getDrawable(EcShopAssistantActivity.e, (URLDrawable.URLDrawableOptions)localObject3);
        if (localObject2 != null)
        {
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          localObject3 = (RelativeLayout.LayoutParams)((URLImageView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getHeight() - AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2);
          ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EcShopListAdapter", 2, "URLDrawable Exception:" + localException);
          }
        }
      }
      paramView.rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      label1248:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(paramView);
      localView.setOnClickListener(this);
      localView.setTag(-1, Integer.valueOf(paramInt));
      return localView;
      paramViewGroup = (huf)paramView.getTag();
      localView = paramView;
      break;
      label1289:
      paramView = ((RecentItemEcShop)localObject2).jdField_b_of_type_JavaLangString;
      break label298;
      label1298:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label450;
      label1310:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label510;
      label1322:
      i = 0;
      break label521;
      label1328:
      paramView = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369273) + i + "m]";
      break label732;
      label1378:
      paramViewGroup.b.setText((CharSequence)localObject1);
    }
    label1390:
    Object localObject1 = new ArrayList(Arrays.asList(((RecentItemEcShop)localObject2).jdField_a_of_type_JavaLangString.split(",")));
    paramViewGroup.b.setPadding(0, AIOUtils.a(5.95F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    paramView.topMargin = AIOUtils.a(5.95F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if ((FontSettingManager.a != null) && (FontSettingManager.b != null)) {}
    for (float f1 = FontSettingManager.a.density / FontSettingManager.b.density;; f1 = 1.0F)
    {
      float f3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493660);
      i = 0;
      while (i < 3)
      {
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setTag(2131296586, Integer.valueOf(paramInt));
        localObject3 = paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getLayoutParams();
        if (f1 < 1.0F)
        {
          int j = (int)(f3 * f1);
          ((ViewGroup.LayoutParams)localObject3).width = j;
          ((ViewGroup.LayoutParams)localObject3).height = j;
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(PubAccountHttpDownloader.a((String)((List)localObject1).get(i), 1), paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i], ((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height, this);
        i += 1;
      }
      localView.findViewById(2131303098).setVisibility(0);
      break;
      label1688:
      localView.findViewById(2131303097).setVisibility(8);
      localView.findViewById(2131299520).setVisibility(8);
      paramView.rightMargin = AIOUtils.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label1248;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    RecentItemEcShop localRecentItemEcShop = (RecentItemEcShop)paramView.getTag(2131296585);
    switch (i)
    {
    default: 
      return;
    case 2131298786: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(localRecentItemEcShop, "");
      return;
    case 2131303095: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localRecentItemEcShop, localRecentItemEcShop.b(), true);
      return;
    case 2131296790: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localRecentItemEcShop);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(localRecentItemEcShop, "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
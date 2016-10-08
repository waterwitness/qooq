package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import ppa;
import ppb;
import ppc;

public class RecommendFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RecommendFriendAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecommendFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ppa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ppb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
  }
  
  private StringBuilder a(ppc paramppc)
  {
    int j = 0;
    RichStatus localRichStatus = paramppc.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
    paramppc = paramppc.c;
    Object localObject1 = localRichStatus.toSpannableString(null, this.jdField_a_of_type_AndroidContentResResources.getColor(2131428313), this.jdField_a_of_type_AndroidContentResResources.getColor(2131428313));
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(512);
      ((StringBuilder)localObject2).append("updateRichStatus , status.actionText : ");
      ((StringBuilder)localObject2).append(localRichStatus.actionText);
      ((StringBuilder)localObject2).append(" , actionId : ");
      ((StringBuilder)localObject2).append(localRichStatus.actionId);
      ((StringBuilder)localObject2).append(" , status.dataText : " + localRichStatus.dataText);
      ((StringBuilder)localObject2).append(" , dataId : ");
      ((StringBuilder)localObject2).append(localRichStatus.dataId);
      ((StringBuilder)localObject2).append(" , ss : ");
      ((StringBuilder)localObject2).append((CharSequence)localObject1);
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    if (!TextUtils.isEmpty(localRichStatus.actionText))
    {
      paramppc.setVisibility(0);
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).insert(0, "[S] ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);
      localObject2 = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject2, false, false);
      i = (int)(paramppc.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new OffsetableImageSpan((Drawable)localObject2, 0);
      ((OffsetableImageSpan)localObject2).a(-0.1F);
      ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, "[S]".length(), 17);
      paramppc.setText((CharSequence)localObject1);
      paramppc = new StringBuilder();
      if (localRichStatus.actionText != null) {
        paramppc.append(localRichStatus.actionText);
      }
      if (localRichStatus.dataText != null) {
        paramppc.append(localRichStatus.dataText);
      }
      if (localRichStatus.plainText == null) {
        break label421;
      }
      i = localRichStatus.plainText.size();
    }
    for (;;)
    {
      if (j >= i) {
        return paramppc;
      }
      localObject1 = (String)localRichStatus.plainText.get(j);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramppc.append((String)localObject1);
      }
      j += 1;
      continue;
      if (((SpannableString)localObject1).length() == 0)
      {
        paramppc.setVisibility(8);
        break;
      }
      paramppc.setVisibility(0);
      paramppc.setText((CharSequence)localObject1);
      break;
      label421:
      i = 0;
    }
    return paramppc;
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.s() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.t());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.s();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.t())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, 3, this.jdField_a_of_type_Int, 1);
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, 3, this.jdField_a_of_type_Int, 1);
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.s() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.t());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.s();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.t())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new MayKnowRecommend();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new ppc();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904913, paramViewGroup, false);
      paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297019));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296818));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304705));
      paramView.c = ((TextView)localView.findViewById(2131304706));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296303));
      paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296910));
      paramView.e = ((TextView)localView.findViewById(2131296911));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(512);
        paramView.append("getView position: ");
        paramView.append(paramInt);
        paramView.append(", remark : ");
        paramView.append(localMayKnowRecommend.remark);
        paramView.append(", nick : ");
        paramView.append(localMayKnowRecommend.nick);
        paramView.append(", gender : ");
        paramView.append(localMayKnowRecommend.gender);
        paramView.append(", category : ");
        paramView.append(localMayKnowRecommend.category);
        paramView.append(", recommendReason : ");
        paramView.append(localMayKnowRecommend.recommendReason);
        paramView.append(", hasQZoneUpdate : ");
        paramView.append(localMayKnowRecommend.hasQZoneUpdate);
        paramView.append(", signature : ");
        paramView.append(localMayKnowRecommend.richSingature);
        QLog.d("RecommendFriendAdapter", 2, paramView.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(512);
      paramViewGroup.jdField_b_of_type_JavaLangString = localMayKnowRecommend.uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
      if (TextUtils.isEmpty(localMayKnowRecommend.remark)) {
        if (TextUtils.isEmpty(localMayKnowRecommend.nick))
        {
          paramView = localMayKnowRecommend.uin;
          label389:
          if (TextUtils.isEmpty(paramView)) {
            break label736;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
          if (AppSetting.j) {
            localStringBuilder.append(paramView);
          }
          label425:
          paramView = new StringBuilder();
          switch (localMayKnowRecommend.gender)
          {
          default: 
            label460:
            if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
              paramView.append(localMayKnowRecommend.category).append(" ");
            }
            if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
              paramView.append(localMayKnowRecommend.recommendReason);
            }
            paramView = paramView.toString();
            if (!TextUtils.isEmpty(paramView))
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
              if (AppSetting.j) {
                localStringBuilder.append(",").append(paramView);
              }
              label555:
              if (!localMayKnowRecommend.hasQZoneUpdate) {
                break label782;
              }
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            break;
          }
        }
      }
      try
      {
        for (;;)
        {
          paramView = a(paramViewGroup);
          if (AppSetting.j) {
            localStringBuilder.append(",").append(paramView);
          }
          if (localMayKnowRecommend.friendStatus != 0) {
            break label834;
          }
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTag(localMayKnowRecommend);
          paramViewGroup.e.setVisibility(8);
          if (AppSetting.j)
          {
            localStringBuilder.append(",点击添加");
            paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("添加");
          }
          if (AppSetting.j) {
            localView.setContentDescription(localStringBuilder.toString());
          }
          localView.setOnClickListener(this);
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_b_of_type_JavaLangString));
          return localView;
          paramViewGroup = (ppc)paramView.getTag();
          localView = paramView;
          break;
          paramView = localMayKnowRecommend.nick;
          break label389;
          paramView = localMayKnowRecommend.remark;
          break label389;
          label736:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label425;
          paramView.append("男 ");
          break label460;
          paramView.append("女 ");
          break label460;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label555;
          label782:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RecommendFriendAdapter", 2, "updateRichStatus error uin=" + localMayKnowRecommend.uin);
            continue;
            label834:
            if (localMayKnowRecommend.friendStatus == 1)
            {
              paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              paramViewGroup.e.setVisibility(0);
              paramViewGroup.e.setText(2131367290);
              if (AppSetting.j)
              {
                localStringBuilder.append(",等待验证");
                paramViewGroup.e.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367290));
              }
            }
            else
            {
              paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              paramViewGroup.e.setVisibility(0);
              paramViewGroup.e.setText(2131367279);
              if (AppSetting.j)
              {
                localStringBuilder.append(",已添加");
                paramViewGroup.e.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367279));
              }
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = (MayKnowRecommend)paramView.getTag();
        } while (localObject == null);
        paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((!paramView.b(((MayKnowRecommend)localObject).uin)) && (!paramView.d(((MayKnowRecommend)localObject).uin))) {
          if (TextUtils.isEmpty(((MayKnowRecommend)localObject).remark)) {
            if (TextUtils.isEmpty(((MayKnowRecommend)localObject).nick))
            {
              paramView = ((MayKnowRecommend)localObject).uin;
              paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject).uin, null, 3045, 3, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131369433), null);
              ((RecommendFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(paramView);
              switch (this.jdField_a_of_type_Int)
              {
              }
            }
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject, 3, this.jdField_a_of_type_Int, 3);
          return;
          paramView = ((MayKnowRecommend)localObject).nick;
          break;
          paramView = ((MayKnowRecommend)localObject).remark;
          break;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
          continue;
          if (paramView.b(((MayKnowRecommend)localObject).uin))
          {
            ((MayKnowRecommend)localObject).friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject).friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        paramView = (ppc)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((localObject != null) && (((FriendsManager)localObject).b(paramView.uin))) {}
    for (int i = 1;; i = 83)
    {
      localObject = new ProfileActivity.AllInOne(paramView.uin, i);
      if (!TextUtils.isEmpty(paramView.remark)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject).g = 88;
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(paramView, 3, this.jdField_a_of_type_Int, 2);
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
        return;
      case 2: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
        return;
      case 3: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\RecommendFriendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
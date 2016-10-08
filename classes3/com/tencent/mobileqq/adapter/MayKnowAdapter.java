package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import pov;

public class MayKnowAdapter
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, HorizontalListView.OnItemScrollEventListener
{
  static final String jdField_a_of_type_JavaLangString = "MayKnowAdapter";
  private int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public MayknowRecommendManager a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected FaceDecoder a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public MayKnowAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, FormSimpleItem paramFormSimpleItem, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new pov(this);
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = paramFormSimpleItem;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
    this.c = MayknowRecommendManager.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    switch (this.b)
    {
    default: 
      return;
    case 1: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      return;
    case 2: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      return;
    case 3: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
    notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    while (!NetworkUtil.e(this.jdField_a_of_type_AndroidAppActivity))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "startVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown())) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(a(i), this.jdField_a_of_type_Int, this.b, 1);
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof MayKnowAdapter.MKRViewHolder)))
        {
          paramString = (MayKnowAdapter.MKRViewHolder)paramString;
          if ((paramString != null) && (paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(a(paramInt), this.jdField_a_of_type_Int, this.b, 1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown())) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(a(i), this.jdField_a_of_type_Int, this.b, 1);
      i += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.c) {
      return this.c;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getView position: " + paramInt);
    }
    View localView;
    MayKnowRecommend localMayKnowRecommend;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903067, paramViewGroup, false);
      paramViewGroup = new MayKnowAdapter.MKRViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296907));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296908));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.b = ((TextView)localView.findViewById(2131296909));
      paramViewGroup.c = ((TextView)localView.findViewById(2131296910));
      paramViewGroup.d = ((TextView)localView.findViewById(2131296911));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131296906));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.setTag(paramViewGroup);
      localMayKnowRecommend = a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.jdField_a_of_type_Int, this.b, 1);
      localStringBuilder = new StringBuilder();
      paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(localMayKnowRecommend.remark)) {
        break label467;
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        break label458;
      }
      paramView = localMayKnowRecommend.uin;
      label278:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if ((AppSetting.j) && (!TextUtils.isEmpty(paramView))) {
        localStringBuilder.append(paramView);
      }
      if (TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label476;
      }
      paramViewGroup.b.setText(localMayKnowRecommend.recommendReason);
      if (AppSetting.j) {
        localStringBuilder.append(",你们有").append(localMayKnowRecommend.recommendReason);
      }
      label352:
      if (localMayKnowRecommend.friendStatus != 0) {
        break label488;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setTag(localMayKnowRecommend);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.c.setOnClickListener(this);
      if (AppSetting.j)
      {
        paramViewGroup.c.setContentDescription("添加");
        localStringBuilder.append(",添加他为好友");
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      localView.setOnClickListener(this);
      return localView;
      paramViewGroup = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label458:
      paramView = localMayKnowRecommend.nick;
      break label278;
      label467:
      paramView = localMayKnowRecommend.remark;
      break label278;
      label476:
      paramViewGroup.b.setText("");
      break label352;
      label488:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(2131367290);
        if (AppSetting.j)
        {
          paramViewGroup.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367290));
          localStringBuilder.append(",等待验证");
        }
      }
      else
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(2131367279);
        if (AppSetting.j)
        {
          paramViewGroup.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367279));
          localStringBuilder.append(",已添加");
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = (MayKnowRecommend)paramView.getTag();
          } while (localObject == null);
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(((MayKnowRecommend)localObject).uin))) {
            if (TextUtils.isEmpty(((MayKnowRecommend)localObject).remark)) {
              if (TextUtils.isEmpty(((MayKnowRecommend)localObject).nick))
              {
                paramView = ((MayKnowRecommend)localObject).uin;
                paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, ((MayKnowRecommend)localObject).uin, null, 3045, this.jdField_a_of_type_Int, paramView, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131369433), null);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
                switch (this.b)
                {
                }
              }
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject, this.jdField_a_of_type_Int, this.b, 3);
            return;
            paramView = ((MayKnowRecommend)localObject).nick;
            break;
            paramView = ((MayKnowRecommend)localObject).remark;
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin))
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
          paramView = (MayKnowRecommend)paramView.getTag();
        } while (paramView == null);
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).g(paramView.uin);
        switch (this.b)
        {
        default: 
          return;
        case 1: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          return;
        case 2: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
          return;
        case 3: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
        return;
        paramView = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    int i = 84;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramView.uin)) {
          j = 1;
        }
      }
      localObject = new ProfileActivity.AllInOne(paramView.uin, j);
      if (!TextUtils.isEmpty(paramView.remark)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).h = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject).g = 88;
      ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(paramView, this.jdField_a_of_type_Int, this.b, 2);
      switch (this.b)
      {
      default: 
        return;
      case 1: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
        return;
        i = 82;
        continue;
        i = 81;
        continue;
        i = 83;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\MayKnowAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
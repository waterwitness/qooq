package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import mjq;
import mjr;
import mjs;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "param_search_resp";
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private mjr jdField_a_of_type_Mjr;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public SearchFriendListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mjq(this);
  }
  
  public void a(View paramView, int paramInt)
  {
    SearchInfo localSearchInfo = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    mjs localmjs = (mjs)paramView.getTag();
    if (!TextUtils.isEmpty(localSearchInfo.strNick))
    {
      localmjs.jdField_a_of_type_AndroidWidgetTextView.setText(localSearchInfo.strNick);
      if (localSearchInfo.eSource != 1) {
        break label187;
      }
      localmjs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, String.valueOf(localSearchInfo.lUIN), (byte)3));
      localmjs.b.setText("QQ号码: " + localSearchInfo.lUIN);
    }
    for (;;)
    {
      localmjs.jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(localmjs.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = localmjs.jdField_a_of_type_AndroidWidgetTextView;
      if (localSearchInfo.eSource == 1) {}
      for (String str = localSearchInfo.lUIN + "";; str = localSearchInfo.strMobile)
      {
        localTextView.setText(str);
        break;
      }
      label187:
      localmjs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.b(this.app, localSearchInfo.strMobile, (byte)3));
      localmjs.b.setText("手机号码: " + localSearchInfo.strMobile);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904936);
    setContentBackgroundResource(2130837958);
    setTitle("搜索结果");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131304831));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837958);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramBundle = new JceInputStream(getIntent().getByteArrayExtra("param_search_resp"));
    RespSearch localRespSearch = new RespSearch();
    localRespSearch.readFrom(paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList = localRespSearch.vRecords;
    this.jdField_a_of_type_ArrayOfByte = localRespSearch.vSecureSig;
    this.jdField_a_of_type_Mjr = new mjr(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Mjr);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      if (!(localObject instanceof SearchInfo)) {
        break label123;
      }
      paramView = (SearchInfo)localObject;
      if (paramView.eSource != 1) {
        break label78;
      }
      paramView = AddFriendLogicActivity.a(this, 1, paramView.lUIN + "", null, 3001, 10004, paramView.strNick, null, null, null, null);
      startActivity(paramView);
    }
    label78:
    label123:
    while (!(localObject instanceof mjs))
    {
      return;
      if (paramView.bInContact == 1) {}
      for (int i = 3006;; i = 3014)
      {
        paramView = AddFriendLogicActivity.a(this, 2, paramView.strMobile, null, i, 10004, paramView.strNick, null, null, null, null);
        break;
      }
    }
    localObject = (mjs)paramView.getTag();
    paramView = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((mjs)localObject).jdField_a_of_type_Int);
    if (paramView.bIsEnterpriseQQ == 0)
    {
      AddFriendActivity.a(this, (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((mjs)localObject).jdField_a_of_type_Int), this.app.a(), this.jdField_a_of_type_ArrayOfByte, false, 0);
      return;
    }
    localObject = new Intent(this, EqqAccountDetailActivity.class);
    ((Intent)localObject).putExtra("uin", String.valueOf(paramView.lUIN));
    ((Intent)localObject).putExtra("uintype", 1024);
    startActivity((Intent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SearchFriendListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
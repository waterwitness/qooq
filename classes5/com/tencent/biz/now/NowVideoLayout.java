package com.tencent.biz.now;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import hkg;

public class NowVideoLayout
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  NowVideoView jdField_a_of_type_ComTencentBizNowNowVideoView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  StructMsgItemLive jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive;
  
  public NowVideoLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    Object localObject = findViewById(2131296579);
    ImageView localImageView;
    TextView localTextView;
    String str;
    label124:
    label159:
    boolean bool;
    if (localObject == null)
    {
      localImageView = new ImageView(getContext());
      localImageView.setId(2131296579);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).setMargins(AIOUtils.a(7.0F, getResources()), AIOUtils.a(7.0F, getResources()), 0, 0);
      addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localObject = getParent();
      localTextView = null;
      if ((localObject instanceof LinearLayout)) {
        localTextView = (TextView)((LinearLayout)localObject).findViewById(2131296362);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive != null) {
        break label249;
      }
      str = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.s))) {
        break label261;
      }
      localObject = getContext().getText(2131365314).toString();
      bool = ((NowLiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      switch (paramInt)
      {
      default: 
        localImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      return;
      localImageView = (ImageView)localObject;
      break;
      label249:
      str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.t;
      break label124;
      label261:
      localObject = getContext().getText(2131365313).toString();
      break label159;
      localImageView.setVisibility(4);
      if (bool)
      {
        localObject = getContext().getText(2131365311) + str;
        continue;
        localImageView.setImageResource(2130840171);
        localImageView.setVisibility(0);
        localObject = getContext().getText(2131365311) + str;
        continue;
        localImageView.setImageResource(2130840170);
        localImageView.setVisibility(0);
        localObject = getContext().getText(2131365313).toString();
        continue;
        localImageView.setImageResource(2130840172);
        localImageView.setVisibility(0);
        localObject = getContext().getText(2131365314).toString();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive = paramStructMsgItemLive;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView != null)
    {
      if (paramQQAppInterface != null) {
        break label162;
      }
      paramStructMsgItemLive = URLDrawable.getDrawable(paramStructMsgItemLive.p, paramStructMsgItemLive.i, paramStructMsgItemLive.j);
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.setImageDrawable(paramStructMsgItemLive);
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.a);
    }
    for (;;)
    {
      boolean bool = false;
      paramStructMsgItemLive = null;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (NowLiveManager)paramQQAppInterface.getManager(170);
        bool = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
        paramStructMsgItemLive = paramQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.time);
      }
      if (!bool) {
        break label187;
      }
      if ((paramStructMsgItemLive == null) || ((paramStructMsgItemLive.a != 1) && (paramStructMsgItemLive.a != 2))) {
        break label181;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.s))) {
        break;
      }
      a(3);
      return;
      label162:
      this.jdField_a_of_type_ComTencentBizNowNowVideoView.a(paramQQAppInterface, paramStructMsgItemLive, paramMessageRecord);
    }
    a(2);
    return;
    label181:
    a(1);
    return;
    label187:
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive.s)))
    {
      a(3);
      return;
    }
    a(2);
  }
  
  public void a(StructMsgItemLive paramStructMsgItemLive)
  {
    paramStructMsgItemLive = getContext().getResources();
    this.jdField_a_of_type_ComTencentBizNowNowVideoView = new NowVideoView(getContext());
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setId(2131296578);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setUseRadiusRound(true, getContext().getResources().getDimensionPixelSize(2131493122));
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.setContentDescription(getContext().getResources().getText(2131371169));
    paramStructMsgItemLive = new RelativeLayout.LayoutParams(AIOUtils.a(210.0F, paramStructMsgItemLive), AIOUtils.a(280.0F, paramStructMsgItemLive));
    addView(this.jdField_a_of_type_ComTencentBizNowNowVideoView, paramStructMsgItemLive);
    paramStructMsgItemLive = new ImageView(getContext());
    paramStructMsgItemLive.setImageResource(2130839556);
    paramStructMsgItemLive.setId(2131298793);
    paramStructMsgItemLive.setVisibility(8);
    int i = AIOUtils.a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    addView(paramStructMsgItemLive, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.a(paramStructMsgItemLive);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\NowVideoLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
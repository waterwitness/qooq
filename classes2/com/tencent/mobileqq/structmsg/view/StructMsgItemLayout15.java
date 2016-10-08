package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;
import uwj;
import uwk;

public class StructMsgItemLayout15
  extends AbsStructMsgItem
{
  public static final int av = 1;
  public static final int aw = 2;
  public static final int ax = 3;
  public static final String o = "StructMsgItemLayout15";
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public StructMsgItemLayout15()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwk(this);
  }
  
  private RelativeLayout a(Context paramContext)
  {
    Object localObject1 = paramContext.getResources();
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(16);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = 2;
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.setId(2131296564);
    localObject2 = new Button(paramContext);
    ((Button)localObject2).setTextColor(Color.parseColor("#00a5e0"));
    ((Button)localObject2).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject2).setId(2131296565);
    ((Button)localObject2).setPadding(AIOUtils.a(14.0F, (Resources)localObject1), 0, AIOUtils.a(7.0F, (Resources)localObject1), 0);
    ((Button)localObject2).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((Button)localObject2).setBackgroundDrawable(null);
    localRelativeLayout.addView((View)localObject2);
    localObject3 = new ProgressBar(paramContext);
    ((ProgressBar)localObject3).setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838321));
    int i = AIOUtils.a(16.0F, paramContext.getResources());
    Object localObject4 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131296565);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
    ((ProgressBar)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((ProgressBar)localObject3).setId(2131296566);
    localRelativeLayout.addView((View)localObject3);
    localObject4 = new Button(paramContext);
    ((Button)localObject4).setTextColor(Color.parseColor("#777777"));
    ((Button)localObject4).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject4).setPadding(AIOUtils.a(7.0F, (Resources)localObject1), 0, 0, 0);
    ((Button)localObject4).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject5).addRule(11);
    ((RelativeLayout.LayoutParams)localObject5).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, AIOUtils.a(14.0F, (Resources)localObject1), 0);
    ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ((Button)localObject4).setBackgroundDrawable(null);
    ((Button)localObject4).setId(2131296570);
    localRelativeLayout.addView((View)localObject4);
    localObject5 = new ImageView(paramContext);
    Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject6).addRule(0, 2131296570);
    ((RelativeLayout.LayoutParams)localObject6).addRule(15, -1);
    ((ImageView)localObject5).setPadding(AIOUtils.a(15.0F, (Resources)localObject1), AIOUtils.a(15.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1));
    ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    ((ImageView)localObject5).setImageResource(2130840206);
    ((ImageView)localObject5).setId(2131296571);
    localRelativeLayout.addView((View)localObject5);
    localObject6 = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.a(13.0F, (Resources)localObject1));
    localLayoutParams.addRule(0, 2131296571);
    localLayoutParams.addRule(15, -1);
    ((ImageView)localObject6).setLayoutParams(localLayoutParams);
    ((ImageView)localObject6).setBackgroundResource(2130840207);
    ((ImageView)localObject6).setId(2131296569);
    localRelativeLayout.addView((View)localObject6);
    localObject6 = new Button(paramContext);
    ((Button)localObject6).setTextColor(Color.parseColor("#777777"));
    ((Button)localObject6).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject6).setPadding(AIOUtils.a(7.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1), 0);
    ((Button)localObject6).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131296569);
    localLayoutParams.addRule(15, -1);
    ((Button)localObject6).setLayoutParams(localLayoutParams);
    ((Button)localObject6).setBackgroundDrawable(null);
    ((Button)localObject6).setId(2131296567);
    localRelativeLayout.addView((View)localObject6);
    paramContext = new ImageView(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131296567);
    localLayoutParams.addRule(15, -1);
    paramContext.setPadding(0, AIOUtils.a(15.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1));
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setImageResource(2130840208);
    paramContext.setId(2131296568);
    localRelativeLayout.addView(paramContext);
    ((Button)localObject2).setTag(2131296572, Integer.valueOf(1));
    ((Button)localObject6).setTag(2131296572, Integer.valueOf(2));
    paramContext.setTag(2131296572, Integer.valueOf(2));
    ((Button)localObject4).setTag(2131296572, Integer.valueOf(3));
    ((ImageView)localObject5).setTag(2131296572, Integer.valueOf(3));
    localObject1 = new StructMsgItemLayout15.ViewHolder();
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)localObject2);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject3);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)localObject6);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = paramContext;
    ((StructMsgItemLayout15.ViewHolder)localObject1).c = ((Button)localObject4);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
    localRelativeLayout.setTag(localObject1);
    return localRelativeLayout;
  }
  
  public void a(Context paramContext, MessageForTroopTopic paramMessageForTroopTopic)
  {
    TroopTopicMgr localTroopTopicMgr;
    if ((SplashActivity.class.isInstance(paramContext)) || (ChatActivity.class.isInstance(paramContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic");
      }
      localTroopTopicMgr = (TroopTopicMgr)((FragmentActivity)paramContext).getChatFragment().a().getManager(97);
      if (!paramMessageForTroopTopic.isExpand) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic isExpand refresh");
      }
      paramMessageForTroopTopic.isExpand = false;
      localTroopTopicMgr.a(paramMessageForTroopTopic.frienduin);
      paramMessageForTroopTopic.isLoading = false;
      ((FragmentActivity)paramContext).getChatFragment().a().a(131076);
    }
    label107:
    TroopTopicDetailInfo localTroopTopicDetailInfo;
    do
    {
      return;
      paramMessageForTroopTopic.isLoading = true;
      localTroopTopicDetailInfo = localTroopTopicMgr.a(paramMessageForTroopTopic);
    } while ((localTroopTopicDetailInfo == null) || (localTroopTopicDetailInfo.detailStructMsg == null));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic isExpand false. load data from cache");
    }
    paramMessageForTroopTopic.detailTopicContent = localTroopTopicDetailInfo.detailStructMsg;
    paramMessageForTroopTopic.isExpand = true;
    localTroopTopicMgr.a(paramMessageForTroopTopic);
    paramMessageForTroopTopic.isLoading = false;
    paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
    paramContext.a.setStackFromBottomWithoutRequestLayoutIfNecessary(false);
    paramContext.a(131076);
    paramContext.a.postDelayed(new uwj(this, paramContext), 100L);
  }
  
  protected int b()
  {
    return 15;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout15 getView start.");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((FragmentActivity)paramContext).getChatFragment().a();
    MessageForTroopTopic localMessageForTroopTopic;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = (RelativeLayout)paramView;
      paramBundle = (StructMsgItemLayout15.ViewHolder)paramContext.getTag();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare)))
      {
        paramView = (StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message instanceof MessageForTroopTopic))
        {
          localMessageForTroopTopic = (MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
          if (localMessageForTroopTopic.isShowExpandButton) {
            break label399;
          }
          paramBundle.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "exp_full", 0, 0, "" + localMessageForTroopTopic.frienduin, "", "", "");
          label177:
          if (!localMessageForTroopTopic.isLoading) {
            break label441;
          }
          paramBundle.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          label193:
          Button localButton = paramBundle.jdField_b_of_type_AndroidWidgetButton;
          if (localMessageForTroopTopic.likeNum > 0L) {
            break label452;
          }
          paramView = " ";
          label213:
          localButton.setText(paramView);
          localButton = paramBundle.c;
          if (localMessageForTroopTopic.commentNum > 0L) {
            break label480;
          }
          paramView = " ";
          label239:
          localButton.setText(paramView);
          if (!localMessageForTroopTopic.isLike) {
            break label508;
          }
          paramBundle.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840209);
        }
      }
    }
    for (;;)
    {
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setTag(2131296573, paramBundle);
      paramBundle.jdField_b_of_type_AndroidWidgetButton.setTag(2131296573, paramBundle);
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setTag(2131296573, paramBundle);
      paramBundle.c.setTag(2131296573, paramBundle);
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setTag(2131296573, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout15 getView end.");
      }
      return paramContext;
      paramContext = a(paramContext);
      break;
      label399:
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (localMessageForTroopTopic.isExpand)
      {
        paramBundle.jdField_a_of_type_AndroidWidgetButton.setText(2131365201);
        break label177;
      }
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setText(2131365200);
      break label177;
      label441:
      paramBundle.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      break label193;
      label452:
      paramView = localMessageForTroopTopic.likeNum + "";
      break label213;
      label480:
      paramView = localMessageForTroopTopic.commentNum + "";
      break label239;
      label508:
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840208);
    }
  }
  
  public String b()
  {
    return "Layout15";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
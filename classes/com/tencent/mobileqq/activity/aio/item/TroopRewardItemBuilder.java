package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardUtil;
import com.tencent.mobileqq.troop.widget.GradientProgressView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.manager.TicketManager;
import nrl;
import nrm;
import nro;
import nrp;
import nrq;
import nrr;
import nru;
import nrw;
import nrx;
import nry;
import nse;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TroopRewardItemBuilder
  extends BaseBubbleBuilder
{
  static Drawable a;
  public static final int h = 300;
  public LruCache a;
  protected TroopHandler a;
  public TroopRewardMgr a;
  public Handler b = new Handler(Looper.getMainLooper());
  int i;
  int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.a().getResources().getDrawable(2130840185);
  }
  
  public TroopRewardItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(4096);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)paramQQAppInterface.a(20));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr = ((TroopRewardMgr)paramQQAppInterface.getManager(151));
    this.i = ((int)(BaseApplicationImpl.a.getResources().getDisplayMetrics().density * 12.0F));
  }
  
  private void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if ((!TextUtils.isEmpty(paramMessageForTroopReward.rewardId)) && (paramMessageForTroopReward.rewardStatus != 1) && (paramMessageForTroopReward.rewardStatus != 10002))
    {
      int k = (int)NetConnInfoCenter.getServerTime();
      if (k - paramMessageForTroopReward.updateTime > 300)
      {
        paramMessageForTroopReward.updateTime = k;
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForTroopReward.rewardId, 7);
      }
    }
  }
  
  private void a(MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    Object localObject;
    Bitmap localBitmap;
    if ((paramMessageForTroopReward.rewardStatus >= 10000) && (paramMessageForTroopReward.rewardStatus <= 10003))
    {
      localObject = paramMessageForTroopReward.mediaPath;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject);
        if (localBitmap != null) {
          break label61;
        }
        a((String)localObject, paramMessageForTroopReward.rewardType, paramnse);
      }
    }
    label61:
    do
    {
      return;
      paramnse.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageBitmap(localBitmap);
      return;
      try
      {
        paramMessageForTroopReward = new URL(paramMessageForTroopReward.rewardUrl);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramMessageForTroopReward = URLDrawable.getDrawable(paramMessageForTroopReward, (URLDrawable.URLDrawableOptions)localObject);
        if (paramMessageForTroopReward.getStatus() == 2) {
          paramMessageForTroopReward.restartDownload();
        }
        paramnse.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForTroopReward);
        return;
      }
      catch (MalformedURLException paramMessageForTroopReward) {}
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, paramMessageForTroopReward.toString());
  }
  
  private void a(MessageForTroopReward paramMessageForTroopReward, nse paramnse, String paramString1, String paramString2)
  {
    TroopBarUploadItemEntity localTroopBarUploadItemEntity = new TroopBarUploadItemEntity();
    if (TextUtils.isEmpty(paramMessageForTroopReward.rewardContent)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getString(2131365285);; str = paramMessageForTroopReward.rewardContent)
    {
      localTroopBarUploadItemEntity.jdField_a_of_type_JavaLangString = str;
      localTroopBarUploadItemEntity.b = paramMessageForTroopReward.mediaPath;
      localTroopBarUploadItemEntity.c = paramMessageForTroopReward.vid;
      localTroopBarUploadItemEntity.m = 3;
      localTroopBarUploadItemEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$ApplyUploadRsp = paramMessageForTroopReward.resq;
      ThreadManager.a(new VideoUploadTask(paramString1, paramString2, localTroopBarUploadItemEntity, new nrw(this, paramMessageForTroopReward, paramnse)), 8, null, true);
      return;
    }
  }
  
  private boolean a(String paramString, MessageForTroopReward paramMessageForTroopReward)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = new JSONObject(paramString);
        int k = -1;
        if (((JSONObject)localObject).has("ec")) {
          k = ((JSONObject)localObject).optInt("ec");
        }
        if (k == 0)
        {
          paramString = ((JSONObject)localObject).optString("blurImg");
          localObject = ((JSONObject)localObject).optString("clearImg");
          paramMessageForTroopReward.blurUrl = paramString;
          paramMessageForTroopReward.rewardUrl = ((String)localObject);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  private void b(MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    if (paramMessageForTroopReward.rewardStatus == 10000)
    {
      paramMessageForTroopReward.rewardStatus = 10001;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr.a(paramMessageForTroopReward);
      localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject = ((TicketManager)localObject).getSkey(str);
      if (paramMessageForTroopReward.rewardType == 1) {
        if ((!TextUtils.isEmpty(paramMessageForTroopReward.rewardUrl)) && (!TextUtils.isEmpty(paramMessageForTroopReward.blurUrl))) {
          c(paramMessageForTroopReward, paramnse);
        }
      }
    }
    while (paramMessageForTroopReward.rewardStatus != 10002)
    {
      Object localObject;
      String str;
      do
      {
        return;
        ThreadManager.a(new nrr(this, str, (String)localObject, paramMessageForTroopReward, paramnse), 8, null, true);
        return;
      } while (paramMessageForTroopReward.rewardType != 2);
      if (TextUtils.isEmpty(paramMessageForTroopReward.vid))
      {
        ThreadManager.a(new nru(this, paramMessageForTroopReward, paramnse, str, (String)localObject), 8, null, true);
        return;
      }
      a(paramMessageForTroopReward, paramnse, str, (String)localObject);
      return;
    }
  }
  
  private void c(MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    TroopRewardMgr localTroopRewardMgr = (TroopRewardMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151);
    localTroopRewardMgr.a(paramMessageForTroopReward, new nrx(this, localTroopRewardMgr, paramMessageForTroopReward, paramnse));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected abstract View a();
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (nse)paramViewHolder;
    paramBaseChatItemLayout = (MessageForTroopReward)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = a();
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131305230));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131305236));
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setColorMask(1258291200);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b(true);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131305231));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetGradientProgressView = ((GradientProgressView)paramChatMessage.findViewById(2131305232));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131305235));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramChatMessage.findViewById(2131305233);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131305238));
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131305234));
    }
    if (paramBaseChatItemLayout.rewardType == 1)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramBaseChatItemLayout.rewardNum == 0)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = paramBaseChatItemLayout.isSend();
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.rewardContent);
      a(paramBaseChatItemLayout, paramViewHolder);
      b(paramBaseChatItemLayout, paramViewHolder);
      a(paramBaseChatItemLayout);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new nrl(this, paramOnLongClickAndTouchListener));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nro(this, paramBaseChatItemLayout, paramViewHolder));
      paramView = new TroopRewardItemBuilder.JumpClickListener(this, paramBaseChatItemLayout, paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramView);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305239).setOnClickListener(paramView);
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305237).setOnClickListener(new nrp(this));
      a(paramViewHolder, paramBaseChatItemLayout, false);
      ReportController.b(null, "dc00899", "Grp_paypic", "", "AIOchat", "Exp_paypic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopRewardUtil.a(paramBaseChatItemLayout.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + (paramBaseChatItemLayout.rewardType - 1), "");
      return paramChatMessage;
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130840184);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.rewardNum + "人赞赏");
      continue;
      if (paramBaseChatItemLayout.rewardType == 2)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130840184);
        if (paramBaseChatItemLayout.rewardNum == 0) {
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
        } else {
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.rewardNum + "人赞赏");
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nse();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopReward)paramChatMessage).getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(String paramString, int paramInt, nse paramnse)
  {
    if (paramInt == 2) {
      FileManagerUtil.a(paramString, true, 200, 200, 1000, new nry(this, paramnse));
    }
    while (paramInt != 1) {
      return;
    }
    ThreadManager.a(new nrm(this, paramString, paramnse), 8, null, true);
  }
  
  public void a(nse paramnse, MessageForTroopReward paramMessageForTroopReward)
  {
    a(paramnse, paramMessageForTroopReward, true);
  }
  
  protected void a(nse paramnse, MessageForTroopReward paramMessageForTroopReward, boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.b.post(new nrq(this, paramnse, paramMessageForTroopReward));
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr.a(paramMessageForTroopReward);
      }
      return;
      b(paramnse, paramMessageForTroopReward);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void b(nse paramnse, MessageForTroopReward paramMessageForTroopReward)
  {
    if ((paramMessageForTroopReward.rewardType == 2) && (paramMessageForTroopReward.rewardStatus == 10002) && (paramMessageForTroopReward.expiredTimeStamp > 0) && (paramMessageForTroopReward.expiredTimeStamp < (int)(System.currentTimeMillis() / 1000L))) {
      paramMessageForTroopReward.rewardStatus = 10003;
    }
    int k = paramMessageForTroopReward.rewardStatus;
    if ((k == 10000) || (k == 10001) || (k == 10002))
    {
      paramnse.jdField_a_of_type_ComTencentMobileqqTroopWidgetGradientProgressView.setVisibility(0);
      paramnse.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramnse.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramnse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    while (k == 10003)
    {
      paramnse.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      if (k == 4)
      {
        paramnse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramnse.jdField_a_of_type_ComTencentMobileqqTroopWidgetGradientProgressView.setVisibility(8);
        paramnse.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramnse.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        paramnse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramnse.jdField_a_of_type_ComTencentMobileqqTroopWidgetGradientProgressView.setVisibility(8);
        paramnse.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramnse.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    paramnse.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TroopRewardItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
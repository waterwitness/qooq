package com.tencent.mobileqq.hotchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.PttShowCallback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotchat.ui.GlowView.InnerViewOnClickListener;
import com.tencent.mobileqq.hotchat.ui.PttTimeLineItemInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.widget.HorizontalListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import suv;
import suw;

public class PttMsgAdapter
  extends BaseAdapter
  implements FileTransferManager.Callback
{
  public static int a;
  public static int b;
  protected Context a;
  public BitmapDrawable a;
  protected LayoutInflater a;
  public View a;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  public MediaPlayerManager.PttShowCallback a;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  protected QQAppInterface a;
  public GlowView.InnerViewOnClickListener a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public List a;
  public boolean a;
  public boolean b;
  protected int c;
  
  public PttMsgAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, GlowView.InnerViewOnClickListener paramInnerViewOnClickListener, MediaPlayerManager.PttShowCallback paramPttShowCallback, HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener = paramInnerViewOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback = paramPttShowCallback;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493629);
    jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493630);
    ThreadManager.a(new suv(this), 5, null, true);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(23));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt != null)
    {
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
    }
  }
  
  public int a()
  {
    int j = 0;
    int i = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).d == 0) {
        i += jdField_a_of_type_Int;
      }
      for (;;)
      {
        j += 1;
        break;
        i += jdField_b_of_type_Int;
      }
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    paramInt += 1;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d != 0) {}
      MessageForPtt localMessageForPtt;
      int i;
      do
      {
        do
        {
          paramInt += 1;
          break;
          localMessageForPtt = ((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
        } while (localMessageForPtt == null);
        i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      } while ((localMessageForPtt.isReadPtt) || (localMessageForPtt.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (i == 2005) || (i == 2004));
      return paramInt;
    }
    return -1;
  }
  
  public int a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return 0;
    }
    int j = 0;
    int i = 0;
    label10:
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).d != 0) {
        break label103;
      }
      if ((((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq == paramMessageForPtt.uniseq)) {
        return i;
      }
      i += jdField_a_of_type_Int;
    }
    for (;;)
    {
      j += 1;
      break label10;
      break;
      label103:
      i += jdField_b_of_type_Int;
    }
  }
  
  public int a(List paramList, boolean paramBoolean, int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return 0;
    }
    int i = 0;
    if (paramBoolean) {
      i = 0 + jdField_b_of_type_Int;
    }
    long l1 = 0L;
    int j = 0;
    if (j < paramList.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramList.get(j);
      if (localMessageForPtt == null) {}
      for (;;)
      {
        j += 1;
        break;
        long l2 = l1;
        int k = i;
        if (localMessageForPtt.time - l1 >= 3600L)
        {
          k = i + jdField_b_of_type_Int;
          l2 = localMessageForPtt.time - localMessageForPtt.time % 3600L;
        }
        i = k + jdField_a_of_type_Int;
        l1 = l2;
      }
    }
    j = i;
    if (paramMessageForPtt != null)
    {
      j = i;
      if (paramMessageForPtt.time - l1 >= 3600L) {
        j = i + jdField_b_of_type_Int;
      }
    }
    if (j - paramInt >= 0) {
      return j - paramInt;
    }
    return 0;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount() > 0))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
        if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PttMsgAdapter.ViewHolder)))
        {
          localObject = (PttMsgAdapter.ViewHolder)((View)localObject).getTag();
          if (a(((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
          {
            ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a(true);
            ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a((PttMsgAdapter.ViewHolder)localObject), ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000, 1);
          }
        }
        i += 1;
      }
    }
  }
  
  protected void a(int paramInt, PttMsgAdapter.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a().b());
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.b();
      a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      if (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.timeStr)) {
        break label220;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText("");
      label63:
      if ((!paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReadPtt) && (!paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        break label237;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_Int = 32;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a().setTag(Boolean.valueOf(false));
      a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView);
      if (AppSetting.j)
      {
        String str1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener != null) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a(paramViewHolder);
        }
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = "用户";
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a().setContentDescription(String.format("%s发出语音消息，%s秒，按钮双击可以播放或者暂定 语音", new Object[] { str2, paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.timeStr }));
      }
      return;
      a(paramViewHolder, true);
      break;
      label220:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.timeStr);
      break label63;
      label237:
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.e != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    PttMsgAdapter.ViewHolder localViewHolder;
    do
    {
      return;
      Object localObject = null;
      localViewHolder = (PttMsgAdapter.ViewHolder)paramView.getTag();
      paramView = (View)localObject;
      if (localViewHolder != null) {
        paramView = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      }
    } while ((paramView == null) || (paramView.uniseq != paramFileMsg.c));
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.jdField_b_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          notifyDataSetChanged();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      a(localViewHolder, paramInt2, localViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      if ((paramFileMsg.Z == 1005) || (paramFileMsg.Z == 1004))
      {
        notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (paramView.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (paramView.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (paramView.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          paramView.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  public void a(MessageForPtt paramMessageForPtt, GlowView paramGlowView)
  {
    if (paramMessageForPtt != null) {}
    try
    {
      if (Long.parseLong(paramMessageForPtt.senderuin) > 0L)
      {
        paramMessageForPtt = paramMessageForPtt.senderuin;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramMessageForPtt)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramMessageForPtt))) {}
        for (paramMessageForPtt = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramMessageForPtt); paramMessageForPtt != null; paramMessageForPtt = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramMessageForPtt, true))
        {
          paramGlowView.a().setImageDrawable(paramMessageForPtt);
          return;
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramGlowView.a().setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    catch (Throwable paramMessageForPtt)
    {
      paramMessageForPtt.printStackTrace();
    }
  }
  
  public void a(PttMsgAdapter.ViewHolder paramViewHolder)
  {
    a(paramViewHolder, 0);
  }
  
  public void a(PttMsgAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a(paramViewHolder), paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000);
      return;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a(paramViewHolder), paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength * 1000, paramInt);
  }
  
  public void a(PttMsgAdapter.ViewHolder paramViewHolder, int paramInt, MessageForPtt paramMessageForPtt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new suw(this, paramViewHolder));
      }
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a();
      continue;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.b();
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.b();
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(PttMsgAdapter.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a(paramBoolean);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject;
    long l;
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramBoolean)
      {
        localObject = new PttTimeLineItemInfo();
        ((PttTimeLineItemInfo)localObject).d = 2;
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      int i = 0;
      l = 0L;
      while (i < paramList.size())
      {
        localObject = (MessageForPtt)paramList.get(i);
        if (localObject != null) {
          break label93;
        }
        i += 1;
      }
    }
    label93:
    PttTimeLineItemInfo localPttTimeLineItemInfo;
    SimpleDateFormat localSimpleDateFormat;
    Date localDate;
    String str;
    if (((MessageForPtt)localObject).time - l >= 3600L)
    {
      localPttTimeLineItemInfo = new PttTimeLineItemInfo();
      localPttTimeLineItemInfo.d = 1;
      localSimpleDateFormat = new SimpleDateFormat("HH:00");
      localDate = new Date(((MessageForPtt)localObject).time * 1000L);
      str = TimeFormatterUtils.b(((MessageForPtt)localObject).time * 1000L);
      if (str.equals("今天"))
      {
        localPttTimeLineItemInfo.jdField_a_of_type_JavaLangString = localSimpleDateFormat.format(localDate);
        label187:
        this.jdField_a_of_type_JavaUtilList.add(localPttTimeLineItemInfo);
        l = ((MessageForPtt)localObject).time - ((MessageForPtt)localObject).time % 3600L;
      }
    }
    for (;;)
    {
      localPttTimeLineItemInfo = new PttTimeLineItemInfo();
      localPttTimeLineItemInfo.d = 0;
      localPttTimeLineItemInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)localObject);
      this.jdField_a_of_type_JavaUtilList.add(localPttTimeLineItemInfo);
      if (PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject) == -1) {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (MessageForPtt)localObject, false, 1, 0);
      }
      break;
      localPttTimeLineItemInfo.jdField_a_of_type_JavaLangString = (localSimpleDateFormat.format(localDate) + "#" + str);
      break label187;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public int b(int paramInt)
  {
    int m = -1;
    int k = 0;
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    int j = -1;
    int n;
    for (;;)
    {
      if (i >= 0)
      {
        PttTimeLineItemInfo localPttTimeLineItemInfo = (PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        n = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPttTimeLineItemInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
        if ((localPttTimeLineItemInfo.d == 0) && (!localPttTimeLineItemInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (n != 2005))
        {
          if (n == 2004)
          {
            n = m;
            m = j;
            j = n;
            i -= 1;
            n = m;
            m = j;
            j = n;
            continue;
          }
          if (localPttTimeLineItemInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReadPtt) {
            return m;
          }
          k += 1;
          if (k != paramInt) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      return i;
      m = i;
      j = i;
      break;
      n = j;
      j = m;
      m = n;
      break;
      i = j;
    }
  }
  
  public void b(PttMsgAdapter.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReadPtt = paramBoolean;
    if (paramBoolean)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int c(int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    j -= 1;
    if (j > paramInt)
    {
      if (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).d == 0) {}
      for (i = jdField_a_of_type_Int + i;; i = jdField_b_of_type_Int + i)
      {
        j -= 1;
        break;
      }
    }
    return i;
  }
  
  public int d(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (j < paramInt)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label65;
      }
      if (((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(j)).d == 0) {
        i = jdField_a_of_type_Int + i;
      }
    }
    label65:
    for (;;)
    {
      j += 1;
      break;
      i = jdField_b_of_type_Int + i;
      continue;
      return i;
    }
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = j + 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return 0;
    }
    return ((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return this.jdField_a_of_type_AndroidViewView;
      }
      return new View(this.jdField_a_of_type_AndroidContentContext);
    }
    int i = getItemViewType(paramInt);
    View localView;
    if (i == 0) {
      if (paramView != null)
      {
        paramViewGroup = (PttMsgAdapter.ViewHolder)paramView.getTag();
        if (paramViewGroup != null) {
          break label438;
        }
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904197, null);
        paramView = new PttMsgAdapter.ViewHolder();
        localView.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131299892));
        paramView.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView = ((GlowView)localView.findViewById(2131301793));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301795));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = paramView.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301794));
        paramView.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.setInnerOnClickListener(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener);
        paramView.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.setTag(paramView);
        paramViewGroup = paramView;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      int j = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      i = j;
      if (j == -1)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, false, 1, 0);
        i = 2001;
      }
      a(paramInt, paramViewGroup);
      a(paramViewGroup, i, paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localView, this);
      return localView;
      paramViewGroup = null;
      break;
      if (i == 1)
      {
        if ((paramView == null) || (!(paramView instanceof TimeLineView))) {}
        for (paramView = new TimeLineView(this.jdField_a_of_type_AndroidContentContext);; paramView = (TimeLineView)paramView)
        {
          paramView.a(((PttTimeLineItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean);
          return paramView;
        }
      }
      if (i == 2)
      {
        if ((paramView == null) || (!(paramView instanceof TimeLineView))) {}
        for (paramView = new TimeLineView(this.jdField_a_of_type_AndroidContentContext);; paramView = (TimeLineView)paramView)
        {
          paramView.b();
          return paramView;
        }
      }
      return new View(this.jdField_a_of_type_AndroidContentContext);
      label438:
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\PttMsgAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
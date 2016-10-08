package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nlv;
import nlw;
import nlx;
import nly;
import nlz;
import nme;
import nmf;
import nmg;
import nmh;
import nmi;
import nmj;
import nmk;
import nml;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  public static long a = 0L;
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  private static final long b = 3000L;
  public static final String b = "MarketFaceItemBuilder";
  public static final int h = 1;
  public static final int i = 2;
  public static int j = 1;
  MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
  public EmojiManager a;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new nlz(this);
  public List a;
  public Context b;
  private long c;
  public boolean d = false;
  public int k = 320;
  public int l = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)paramQQAppInterface.getManager(42));
    if ((this.b instanceof SplashActivity)) {
      this.d = true;
    }
  }
  
  private QQProgressDialog a()
  {
    if (((FragmentActivity)this.b).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.b).getChatFragment().a().a == null) {
        ((FragmentActivity)this.b).getChatFragment().a().a = new QQProgressDialog(this.b);
      }
      return ((FragmentActivity)this.b).getChatFragment().a().a;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.e);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    Handler localHandler;
    label337:
    label369:
    label514:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localHandler = new Handler(Looper.getMainLooper());
            if (paramInt2 != 0) {
              break label567;
            }
            if (7 != paramInt1 % 1000) {
              break;
            }
            try
            {
              paramQQAppInterface = new Bundle();
              paramQQAppInterface.putInt("forward_type", 9);
              paramEmoticon = new Intent();
              paramEmoticon.putExtras(paramQQAppInterface);
              ForwardBaseOption.a((BaseActivity)paramContext, paramEmoticon, 21);
              return;
            }
            catch (Exception paramContext) {}
          } while (!QLog.isColorLevel());
          QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
          return;
          if (6 != paramInt1 % 1000) {
            break label514;
          }
          paramString = (FavroamingDBManager)paramQQAppInterface.getManager(148);
          paramSessionInfo = paramString.a();
          if (paramSessionInfo == null) {
            break;
          }
          paramInt1 = 1;
          int m = 0;
          paramInt2 = 0;
          for (;;)
          {
            if (paramInt2 >= paramSessionInfo.size()) {
              break label337;
            }
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramSessionInfo.get(paramInt2);
            int n;
            if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
            {
              n = m;
              if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
            }
            else
            {
              n = m + 1;
            }
            if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
            {
              if (paramString.a(localCustomEmotionData, paramInt2))
              {
                paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
                localHandler.post(new nmh(paramContext));
                if (paramQQAppInterface == null) {
                  break;
                }
                paramQQAppInterface.obtainMessage(10).sendToTarget();
                return;
              }
              localHandler.post(new nmi(paramContext));
              return;
            }
            int i1 = paramInt1;
            if (paramInt1 < localCustomEmotionData.emoId) {
              i1 = localCustomEmotionData.emoId;
            }
            paramInt2 += 1;
            m = n;
            paramInt1 = i1;
          }
          if (m < FavEmoConstant.jdField_a_of_type_Int) {
            break label369;
          }
          paramContext = paramQQAppInterface.a(ChatActivity.class);
        } while (paramContext == null);
        paramContext.obtainMessage(53).sendToTarget();
        return;
        paramInt1 = 1;
        paramSessionInfo = new CustomEmotionData();
        paramSessionInfo.uin = paramQQAppInterface.a();
        paramSessionInfo.emoId = (paramInt1 + 1);
        paramSessionInfo.isMarkFace = true;
        paramSessionInfo.emoPath = paramEmoticon.epId;
        paramSessionInfo.eId = paramEmoticon.eId;
        paramString.c(paramSessionInfo);
        paramString = (FavroamingManager)paramQQAppInterface.getManager(102);
        if (paramString != null) {
          paramString.syncUpload(paramSessionInfo);
        }
        ChatActivityFacade.a(paramQQAppInterface, paramEmoticon);
        if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        localHandler.post(new nmj(paramContext));
        paramContext = paramQQAppInterface.a(ChatActivity.class);
      } while (paramContext == null);
      paramContext.obtainMessage(10).sendToTarget();
      return;
    } while (107 != paramInt1 % 1000);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
    PicEmoticonInfo.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon);
    return;
    label567:
    if (paramInt2 < 0)
    {
      localHandler.post(new nmk(paramContext, paramString));
      QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
      return;
    }
    localHandler.post(new nlw(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    EmoticonPackage localEmoticonPackage = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramPicEmoticonInfo.a.epId);
    if ((localEmoticonPackage != null) && (localEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.a, 0, null, paramSessionInfo);
      return;
    }
    if ((!NetworkUtil.h(paramContext)) || (paramInt > 1000))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.a, 65132, "网络异常，请稍后再试", paramSessionInfo);
      return;
    }
    ((EmoticonHandler)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramPicEmoticonInfo.a.epId).intValue(), paramPicEmoticonInfo.a.eId);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    String str;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 4)))
    {
      str = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      if ((((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b(str) == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)) {
        break label259;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).obtainMessage(22, str).sendToTarget();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_aio_pkg_tab", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, str, "", "");
      }
    }
    return;
    label259:
    jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject = "0";
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) {
      localObject = "1";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_detail_aio", 0, 0, "", (String)localObject, "", "");
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, str, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    int n = 200;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable2 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", bool);
      Emoticon localEmoticon = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a;
      URLDrawable localURLDrawable1 = localURLDrawable2;
      if (localURLDrawable2 != null)
      {
        localURLDrawable1 = localURLDrawable2;
        if (localURLDrawable2.getStatus() == 1)
        {
          Object localObject = "";
          if ((localURLDrawable2.getStateTag() instanceof Bundle)) {
            localObject = ((Bundle)localURLDrawable2.getStateTag()).getString("display_type");
          }
          localURLDrawable1 = localURLDrawable2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localURLDrawable1 = localURLDrawable2;
            if (((String)localObject).equals("aio_preview"))
            {
              localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticon.epId);
              localURLDrawable1 = localURLDrawable2;
              if (localObject != null)
              {
                localURLDrawable1 = localURLDrawable2;
                if (((EmoticonPackage)localObject).status == 2)
                {
                  URLDrawable.removeMemoryCacheByUrl(localURLDrawable2.getURL().toString());
                  localURLDrawable1 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", bool);
                }
              }
            }
          }
        }
      }
      if ((localURLDrawable1 != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null))
      {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width != 0) {
          break label501;
        }
        m = 200;
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height != 0) {
          break label516;
        }
        label245:
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionWidth == 0) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionHeight == 0)) {
          break label683;
        }
        n = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionWidth;
      }
      int i1;
      for (int m = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionHeight;; m = i1)
      {
        i1 = n;
        if (n != m) {
          i1 = m;
        }
        n = (i1 * this.l + (this.k >> 1)) / this.k;
        m = (m * this.l + (this.k >> 1)) / this.k;
        paramHolder.e.setLayoutParams(new FrameLayout.LayoutParams(n, m));
        paramHolder.e.setImageDrawable(localURLDrawable1);
        if (localURLDrawable1 != null) {}
        switch (localURLDrawable1.getStatus())
        {
        default: 
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          label420:
          paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          if ((paramChatMessage.isMarketFaceFlow) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0))
          {
            if (!paramChatMessage.isSend()) {
              break label662;
            }
            paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841689);
            paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          break;
        }
        for (;;)
        {
          if (localURLDrawable1 != null) {
            a(paramHolder, localURLDrawable1);
          }
          d(paramHolder);
          return;
          label501:
          m = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width;
          break;
          label516:
          n = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height;
          break label245;
          if (!MagicfaceViewController.a()) {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          if ((EmoticonUtils.a()) && (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) && (!EmoticonUtils.c())) {
            break label420;
          }
          float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
          if ((f >= 0.0F) && (1.0F != f)) {
            break label420;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          break label420;
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          if (!AppSetting.j) {
            break label420;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
          break label420;
          label662:
          paramHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841689);
          paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label683:
        i1 = n;
        n = m;
      }
    }
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131367262, 2131368031, new nlx(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new nly()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false)))
    {
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
      localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.jdField_d_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);; localEmoticonPackage.rscType = paramHolder.jdField_d_of_type_Int)
    {
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      paramHolder.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void c(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((4 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, true, true)) {
        break;
      }
      if (!EmoticonUtils.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        }
        paramHolder.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId));
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    Object localObject1 = new EmoticonPackage();
    ((EmoticonPackage)localObject1).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
    ((EmoticonPackage)localObject1).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
    ((EmoticonPackage)localObject1).jobType = 5;
    ((EmoticonPackage)localObject1).type = 1;
    ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
    this.jdField_a_of_type_JavaUtilList.add(paramHolder);
    paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramHolder.f.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject1, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, ((EmoticonPackage)localObject1).epId, "", "", "");
    return;
    if ((this.d) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b()))
    {
      paramHolder.f.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      }
    }
    for (;;)
    {
      paramHolder.f.setImageResource(2130837550);
      if ((((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()) || (System.currentTimeMillis() - this.c <= 3000L) || (((FragmentActivity)this.b).getChatFragment() == null) || (((FragmentActivity)this.b).getChatFragment().a() == null) || (((FragmentActivity)this.b).getChatFragment().a().j())) {
        break;
      }
      this.c = System.currentTimeMillis();
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      localObject1 = new Intent(this.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      Object localObject2 = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject2).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((EmoticonManager)localObject2).a(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.b.startActivity((Intent)localObject1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
      return;
      paramHolder.f.setVisibility(8);
    }
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  private void d(MarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_Boolean = false;
    if ((2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!MagicfaceViewController.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))
      {
        if (!EmoticonUtils.a())
        {
          paramHolder.f.setVisibility(8);
          return;
        }
        if ((!EmoticonUtils.c()) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
        {
          EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
          ((EmoticonPackage)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
          this.jdField_a_of_type_JavaUtilList.add(paramHolder);
          paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramHolder.f.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject, false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue) == 1) {
          paramHolder.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId;
          ((Emoticon)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((Emoticon)localObject).magicValue = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue;
          ((Emoticon)localObject).jobType = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType;
          if ((((FragmentActivity)this.b).getChatFragment() != null) && (((FragmentActivity)this.b).getChatFragment().a() != null) && (MagicfaceViewController.a())) {
            ((FragmentActivity)this.b).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
          return;
          paramHolder.f.setImageResource(2130837550);
          paramHolder.f.setVisibility(0);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l1 = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    long l2;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.b);
      paramView = new ImageView(this.b);
      paramView.setId(2131296376);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131296328);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131296328);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.b);
      ((FrameLayout)localObject1).setId(2131296380);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296376);
      paramViewHolder.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new nml(this, this.b);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject2 = new ImageView(this.b);
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.b);
      ((ImageView)localObject3).setId(2131296375);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131296380);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296380);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 10;
      paramViewHolder.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((ImageView)localObject3).setOnClickListener(this);
      localObject4 = new ImageView(this.b);
      ((ImageView)localObject4).setId(2131296377);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131296380);
      ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131296380);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      paramViewHolder.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new ImageView(this.b);
      ((ImageView)localObject5).setId(2131296378);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131296380);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131296380);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = (-AIOUtils.a(9.0F, this.b.getResources()));
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = (-AIOUtils.a(12.0F, this.b.getResources()));
      paramViewHolder.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new ProgressBar(this.b, null, 0);
      ((ProgressBar)localObject6).setId(2131296326);
      ((ProgressBar)localObject6).setIndeterminateDrawable(this.b.getResources().getDrawable(2130838321));
      int m = AIOUtils.a(16.0F, this.b.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(m, m);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject6, localLayoutParams);
      localHolder.e = paramOnLongClickAndTouchListener;
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      localHolder.jdField_c_of_type_AndroidWidgetImageView = paramView;
      localHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
      localHolder.f = ((ImageView)localObject5);
      localHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject6);
      if ((AppSetting.j) && (a(paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("表情发送失败");
      }
      localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramBaseChatItemLayout.mMarkFaceMessage);
      l2 = localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
      localHolder.jdField_a_of_type_Long = localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
      if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) {
        break label922;
      }
      localHolder.e.setImageResource(2130837545);
    }
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epid = " + localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId + ":view time = " + (l2 - l1));
      }
      return paramViewHolder;
      localHolder.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (localHolder.jdField_b_of_type_AndroidWidgetImageView != null) && ((localHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841713);
      }
      paramViewHolder = paramView;
      if (!AppSetting.j) {
        break;
      }
      localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
      paramViewHolder = paramView;
      break;
      label922:
      if (2 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType)
      {
        paramView = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82);
        boolean bool = false;
        if (localHolder.jdField_b_of_type_Int == localHolder.jdField_c_of_type_Int - 1) {
          bool = paramView.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramView.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue, localHolder, l2, bool, true, new nlv(this, paramChatMessage, localHolder));
        localHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder.f.setVisibility(8);
        d(localHolder);
      }
      else if (4 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType)
      {
        if (!paramChatMessage.isSend()) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
        a(paramChatMessage, localHolder);
        c(localHolder);
      }
      else
      {
        a(paramChatMessage, localHolder);
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int m;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!MsgUtils.a(paramChatMessage.issend)) {
        break label129;
      }
      localStringBuilder.append("发出表情");
      localObject = (MessageForMarketFace)paramChatMessage;
      if (((MessageForMarketFace)localObject).mMarkFaceMessage != null)
      {
        paramChatMessage = EmosmUtils.a(((MessageForMarketFace)localObject).mMarkFaceMessage.sbufID, ((MessageForMarketFace)localObject).mMarkFaceMessage.mediaType);
        m = ((MessageForMarketFace)localObject).mMarkFaceMessage.dwTabID;
        localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        if (localObject == null) {
          break label140;
        }
      }
    }
    label129:
    label140:
    for (paramChatMessage = ((EmoticonManager)localObject).a(String.valueOf(m), paramChatMessage);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
        localStringBuilder.append(paramChatMessage.name);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("发来表情");
      break;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131305401)
    {
      ChatActivityFacade.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      return;
    }
    if (paramInt == 2131305411)
    {
      super.b(paramChatMessage);
      return;
    }
    if (paramInt == 2131296309)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
      paramContext = a();
      if (paramContext != null)
      {
        paramContext.a(this.b.getString(2131370290));
        paramContext.show();
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
      paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      if ((paramChatMessage != null) && (paramChatMessage.name != null) && ((paramChatMessage.mobileFeetype != 0) || (paramChatMessage.downloadCount != 0)))
      {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
        int m = (int)(System.currentTimeMillis() / 1000L);
        if ((m - paramInt > 86400) || (m < paramInt))
        {
          a(6);
          return;
        }
        a(6, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramContext);
        return;
      }
      a(6);
      return;
    }
    if ((paramInt == 2131296310) || (paramInt == 2131296311))
    {
      paramChatMessage = a();
      if (paramInt == 2131296310)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
        if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c()))
        {
          ChatActivityUtils.a(this.b, 2131370490, 0);
          return;
        }
        j = 1;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        paramContext = this.b.getString(2131370291);
      }
      for (paramInt = 7;; paramInt = 107)
      {
        if (paramChatMessage != null)
        {
          paramChatMessage.a(paramContext);
          paramChatMessage.show();
        }
        if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId) != null) {
          break;
        }
        a(paramInt);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
        {
          ChatActivityUtils.a(this.b, 2131364717, 0);
          return;
        }
        paramContext = this.b.getString(2131370292);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "");
      }
      a(paramInt, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
      return;
    }
    if (paramInt == 2131296353)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.b.getString(2131367889);
      str2 = this.b.getString(2131367890);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.b, 230, str1, str2, new nme(this, paramView), new nmf(this)).show();
      return;
      paramView = paramView.e.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    a(paramHolder, paramURLDrawable, "");
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.f.setVisibility(8);
    int m = paramURLDrawable.getStatus();
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
        str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
      }
    }
    if ("aio_preview".equals(str)) {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841713);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (!"big_sound".equals(str))
    {
      do
      {
        return;
      } while ((m != 1) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.j != 3));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837547);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramURLDrawable = (AnimationDrawable)this.b.getResources().getDrawable(2130968769);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      paramURLDrawable.start();
      return;
    }
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841713);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.a == null) || (paramPicEmoticonInfo.a.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.b, null);
    localActionSheet.a(this.b.getString(2131370287));
    localActionSheet.a(this.b.getResources().getString(2131370288), 1);
    localActionSheet.a(this.b.getResources().getString(2131370289), 1);
    localActionSheet.d(2131367262);
    localActionSheet.a(new nmg(this, paramPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
    localActionSheet.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841713);
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", false);
      paramXListView.e.setImageDrawable(paramView);
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null)) {
      return false;
    }
    if ((paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramAudioPlayer.a(EmoticonUtils.k.replace("[epId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId))))
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", true);
      paramXListView.e.setImageDrawable(paramView);
      PicEmoticonInfo.a(paramView);
      paramView = (AnimationDrawable)this.b.getResources().getDrawable(2130968769);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      paramView.start();
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 1)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (AIOUtils.a(1) == 1) {
        localQQCustomMenu.a(2131296309, this.b.getString(2131370095));
      }
      localQQCustomMenu.a(2131296310, this.b.getString(2131369281));
      a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localQQCustomMenu);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 4)) {
        localQQCustomMenu.a(2131296311, this.b.getString(2131370094));
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
    }
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
      a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.b);
    return localQQCustomMenu.a();
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void e()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    if (super.a()) {
      return;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramView.getId() == 2131296380)
    {
      localObject2 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      localObject3 = ((MarketFaceItemBuilder.Holder)localObject2).e.getDrawable();
      if ((localObject3 instanceof URLDrawable))
      {
        localObject4 = (URLDrawable)localObject3;
        paramView = ((URLDrawable)localObject4).getURL().getHost();
        if (!(((URLDrawable)localObject4).getTag() instanceof Bundle)) {
          break label1781;
        }
        paramView = ((Bundle)((URLDrawable)localObject4).getTag()).getString("display_type");
      }
    }
    label696:
    label1188:
    label1781:
    for (;;)
    {
      switch (((URLDrawable)localObject3).getStatus())
      {
      }
      Object localObject1;
      for (;;)
      {
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) && (MagicfaceViewController.a())) {
          b((MarketFaceItemBuilder.Holder)localObject2);
        }
        if ((((URLDrawable)localObject3).getStatus() != 1) && ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (!((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()))) {
          break;
        }
        a((MarketFaceItemBuilder.Holder)localObject2);
        return;
        localObject1 = "";
        if ((((URLDrawable)localObject4).getStateTag() instanceof Bundle)) {
          localObject1 = ((Bundle)((URLDrawable)localObject4).getStateTag()).getString("display_type");
        }
        ((URLDrawable)localObject4).restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + ((URLDrawable)localObject4).getStatus());
        }
        a((MarketFaceItemBuilder.Holder)localObject2, (URLDrawable)localObject4, (String)localObject1);
        ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && ("big_sound".equals(paramView)))
        {
          jdField_a_of_type_Long = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 4))
          {
            ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(paramView))
            {
              if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound)) {
                if (c(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
                  QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131368056, 0).b(this.b.getResources().getDimensionPixelSize(2131492908));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(paramView))
            {
              paramView = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", true);
              if (paramView != null)
              {
                ((MarketFaceItemBuilder.Holder)localObject2).e.setImageDrawable(paramView);
                ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((MarketFaceItemBuilder.Holder)localObject2, paramView);
                if (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
                  jdField_a_of_type_Long = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localObject3 instanceof PngFrameDrawable)) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (!((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c())) {
        break;
      }
      a((MarketFaceItemBuilder.Holder)localObject2);
      return;
      if (paramView.getId() == 2131296375)
      {
        localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
        if ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
        {
          if (!c(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
            break label696;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
      }
      do
      {
        do
        {
          for (;;)
          {
            super.onClick(paramView);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131368056, 0).b(this.b.getResources().getDimensionPixelSize(2131492908));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() != 2131296377) && (paramView.getId() != 2131296376)) {
                break;
              }
              localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
              localObject2 = a();
              if (localObject2 != null)
              {
                ((QQProgressDialog)localObject2).a(this.b.getString(2131370292));
                ((QQProgressDialog)localObject2).show();
              }
              localObject3 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow", 0, 0, "", "", ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId, "");
              if (localObject3 == null)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(107, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
                EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
                this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.e);
              }
              else
              {
                a(107, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject2);
              }
            }
          }
        } while (paramView.getId() != 2131296378);
        localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
        if ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (2 == ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) {
            break;
          }
          EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
          ((EmoticonPackage)localObject2).epId = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((MarketFaceItemBuilder.Holder)localObject1).f.setVisibility(8);
          ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
          ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
      } while ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (4 != ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (System.currentTimeMillis() - this.c <= 3000L) || (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()));
      this.c = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, true, true))
      {
        localObject2 = new Intent(this.b, H5MagicPlayerActivity.class);
        ((Intent)localObject2).putExtra("clickTime", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("autoPlay", "0");
        ((Intent)localObject2).putExtra("senderUin", ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
        ((Intent)localObject2).putExtra("selfUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((Intent)localObject2).putExtra("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ((Intent)localObject2).putExtra("emoticon", ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
        localObject3 = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        localObject4 = ((EmoticonManager)localObject3).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if (localObject4 != null)
        {
          localObject3 = ((EmoticonManager)localObject3).a(((EmoticonPackage)localObject4).childEpId);
          if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
            ((Intent)localObject2).putExtra("childEmoticon", (Serializable)((List)localObject3).get(0));
          }
        }
        this.b.startActivity((Intent)localObject2);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.b).getChatFragment() == null) || (((FragmentActivity)this.b).getChatFragment().a() == null) || (!MagicfaceViewController.a()) || (((FragmentActivity)this.b).getChatFragment() == null) || (((FragmentActivity)this.b).getChatFragment().a() == null)) {
          break label1188;
        }
        ((FragmentActivity)this.b).getChatFragment().a().a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 1, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1188;
        EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
        ((EmoticonPackage)localObject2).epId = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((MarketFaceItemBuilder.Holder)localObject1).f.setVisibility(8);
        ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\MarketFaceItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
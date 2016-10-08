package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.FileDownloader;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager.OnFirstVideoDownloadListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryPostDes;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository.RepositoryUpdateEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AnimationUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import ita;
import itb;
import itc;
import itd;
import ite;
import itf;
import itg;
import ith;
import itk;
import itl;
import java.util.ArrayList;
import java.util.List;

public class StoryListPresenter
  implements Handler.Callback, UserClickManager.OnFirstVideoDownloadListener, IMyStroyPresenter
{
  public static final int a = 1;
  protected static final String a = "Q.qqstory.home.StoryListPresenter";
  public static final int b = 2;
  protected static final String b = "StoryListPresenter_sharePreferences";
  public static final int c = 3;
  protected static final String c = "download_sharePreferences_key";
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  protected long a;
  public Activity a;
  public Handler a;
  public FileDownloader a;
  protected StoryConfigManager a;
  protected Repository a;
  protected StoryListPresenter.RepositoryEventReceiver a;
  protected IMyStoryListView a;
  protected QQAppInterface a;
  public BubblePopupWindow a;
  protected boolean a;
  private boolean b;
  
  public StoryListPresenter(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
  }
  
  private void a(StoryVideoItem paramStoryVideoItem)
  {
    ((StoryVideoUploadManager)SuperManager.a().b(3)).a(paramStoryVideoItem);
  }
  
  private void a(String paramString)
  {
    new DeleteStoryVideoHandler().a(paramString);
  }
  
  private static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, ChatActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 0);
    localIntent.putExtra("aio_msg_source", 999);
    paramActivity.startActivity(localIntent);
  }
  
  private void b(String paramString)
  {
    ((StoryVideoUploadManager)SuperManager.a().b(3)).a(paramString);
  }
  
  private boolean d()
  {
    boolean bool = false;
    label116:
    for (;;)
    {
      try
      {
        try
        {
          long l1 = System.currentTimeMillis();
          long l2 = l1 - this.jdField_a_of_type_Long;
          if ((l2 > 0L) && (l2 < 800L))
          {
            if (QLog.isColorLevel())
            {
              QLog.i("isFastDoubleClick", 2, "time:" + l1 + ", mLastClickTIme:" + this.jdField_a_of_type_Long + ", timeDiff:" + l2);
              break label116;
              return bool;
            }
          }
          else
          {
            this.jdField_a_of_type_Long = l1;
            continue;
            localObject2 = finally;
          }
        }
        finally {}
        bool = true;
      }
      finally {}
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$RepositoryEventReceiver = new StoryListPresenter.RepositoryEventReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$RepositoryEventReceiver);
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    this.jdField_a_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = new Repository(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a();
    ((StoryManager)SuperManager.a(5)).a().a().a(this);
  }
  
  public void a(int paramInt, View paramView, StoryItem paramStoryItem)
  {
    a(paramView, paramStoryItem);
  }
  
  public void a(int paramInt, View paramView, RecommendItem paramRecommendItem)
  {
    if (d()) {}
    do
    {
      return;
      if (paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type != 3) {
        break;
      }
    } while ((paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory == null) || (paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes == null));
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url);
    paramView.getContext().startActivity(localIntent);
    return;
    localIntent = new Intent(paramView.getContext(), QQStoryContentActivity.class);
    localIntent.putExtra("showTitleBar", false);
    localIntent.putExtra("showAnimation", true);
    localIntent.putExtra("user_type", paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.type);
    localIntent.putExtra("user_unionid", paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.unionId);
    localIntent.putExtra("come_from", 8);
    localIntent.putExtra("need_image_animation", false);
    Context localContext = paramView.getContext();
    if ((localContext instanceof Activity))
    {
      AnimationUtils.a((Activity)localContext, localIntent, paramView, 1, paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.unionId);
      StoryReportor.a("recommend", "clk_detail", 0, paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.type, new String[] { paramRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.unionId });
      paramView.postDelayed(new itg(this, paramView), 400L);
    }
    QLog.d("Q.qqstory.home.StoryListPresenter", 2, "onClickRecommendItem, position=" + paramInt + ", bean=" + paramRecommendItem);
  }
  
  public void a(int paramInt, HotTopicItem paramHotTopicItem, View paramView)
  {
    if (d()) {
      return;
    }
    if (paramHotTopicItem == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "OnClickHotTopicItem but hotTopicitem is null!");
      return;
    }
    StoryReportor.a("ugc_video", "clk_topic", 0, 0, new String[] { String.valueOf(paramHotTopicItem.topicId), QQStoryContext.a().a(), paramHotTopicItem.topicName });
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramHotTopicItem.topicId, paramHotTopicItem.topicName, paramView);
  }
  
  public void a(int paramInt, StoryItem paramStoryItem, View paramView)
  {
    if (d()) {
      return;
    }
    if (paramStoryItem.user.isVip)
    {
      localObject = "2";
      if (paramStoryItem.preLoadStatus == 2) {
        break label124;
      }
    }
    label124:
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("last_update", "clk_friend", 0, 0, new String[] { localObject, str });
      if (paramStoryItem.preLoadStatus == 2) {
        break label132;
      }
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      paramView.obj = String.valueOf(paramStoryItem.user.uid);
      paramView.arg1 = Integer.parseInt(IPreloadVideoSource.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 30000L);
      return;
      localObject = "1";
      break;
    }
    label132:
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.b();
    paramStoryItem = new ArrayList(((ArrayList)localObject).size());
    while (paramInt < ((ArrayList)localObject).size())
    {
      paramStoryItem.add(Long.valueOf(((StoryItem)((ArrayList)localObject).get(paramInt)).user.uid));
      paramInt += 1;
    }
    SLog.b("Q.qqstory.home.StoryListPresenter", "uinList count=" + paramStoryItem.size());
    paramView = (ImageView)paramView.findViewById(2131302885);
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryItem, "最近更新", paramView);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (d()) {
      return;
    }
    if (paramStoryVideoItem.isUploadFail())
    {
      StoryReportor.a("mystory", "clk_retry", 0, 0, new String[0]);
      a(paramStoryVideoItem);
      return;
    }
    if (!paramStoryVideoItem.isUploadSuc())
    {
      SLog.d("Q.qqstory.home.StoryListPresenter", "onClick when uploading,state=" + paramStoryVideoItem.mUploadStatus);
      return;
    }
    StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "1" });
    paramView = (ImageView)paramView.findViewById(2131302915);
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, QQStoryContext.a().a(), paramStoryVideoItem.mVid, false, paramView);
  }
  
  public void a(int paramInt, MyStorys paramMyStorys)
  {
    if (d()) {
      return;
    }
    StoryReportor.a("mystory", "clk_delete", 0, 0, new String[0]);
    if ((paramMyStorys.a() == null) || (paramMyStorys.a().size() < paramInt + 1) || (paramMyStorys.a().get(paramInt) == null))
    {
      ToastUtil.a().a("没有这一项");
      return;
    }
    paramMyStorys = ((StoryVideoItem)paramMyStorys.a().get(paramInt)).mVid;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setMessage("确认删除该日迹？");
    localQQCustomDialog.setNegativeButton(2131367262, new ite(this));
    localQQCustomDialog.setPositiveButton(2131368306, new itf(this, paramMyStorys));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(MyStorys paramMyStorys, View paramView)
  {
    if (d()) {
      return;
    }
    if (paramMyStorys.g != 2)
    {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "3" });
      paramMyStorys = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      paramMyStorys.obj = String.valueOf(QQStoryContext.a().a());
      paramMyStorys.arg1 = Integer.parseInt(IPreloadVideoSource.c);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMyStorys, 30000L);
      return;
    }
    if (paramMyStorys.a().size() == 0)
    {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "2" });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false, true);
      return;
    }
    StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "1" });
    paramMyStorys = (ImageView)paramView.findViewById(2131302905);
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, QQStoryContext.a().a(), "我的日迹", paramMyStorys);
  }
  
  public void a(Repository.RepositoryUpdateEvent paramRepositoryUpdateEvent)
  {
    if (paramRepositoryUpdateEvent == null) {}
    do
    {
      return;
      SLog.b("Q.qqstory.home.StoryListPresenter", "repositoryUpdated = " + paramRepositoryUpdateEvent.jdField_a_of_type_Boolean);
      if (!paramRepositoryUpdateEvent.c) {
        break;
      }
    } while (!"friends_story".equals(paramRepositoryUpdateEvent.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a("friends_story", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c());
    return;
    boolean bool = paramRepositoryUpdateEvent.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.b(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d(), paramRepositoryUpdateEvent.b, this.b);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(bool, this.b, paramRepositoryUpdateEvent.d);
    this.b = false;
  }
  
  public void a(IMyStoryListView paramIMyStoryListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
  }
  
  public void a(String paramString1, String paramString2)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = paramString2;
    localMessage.arg1 = Integer.parseInt(paramString1);
    localMessage.sendToTarget();
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.a(paramArrayList);
  }
  
  public boolean a()
  {
    if (NetworkUtils.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    return false;
  }
  
  protected boolean a(View paramView, StoryItem paramStoryItem)
  {
    paramView.setSelected(true);
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramStoryItem.user.isVip) {
      localQQCustomMenu.a(2131305445, "取消订阅");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, localQQCustomMenu, new ith(this, paramStoryItem));
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new itb(this, paramView));
      return true;
      localQQCustomMenu.a(2131305446, this.jdField_a_of_type_AndroidAppActivity.getString(2131370330));
      localQQCustomMenu.a(2131305447, this.jdField_a_of_type_AndroidAppActivity.getString(2131369988));
    }
  }
  
  public void b() {}
  
  public void b(int paramInt, View paramView, StoryItem paramStoryItem)
  {
    a(paramView, paramStoryItem);
  }
  
  public void b(int paramInt, StoryItem paramStoryItem, View paramView)
  {
    if (d()) {
      return;
    }
    String str1;
    if (paramStoryItem.user.isVip)
    {
      str1 = "2";
      if (paramStoryItem.preLoadStatus == 2) {
        break label124;
      }
    }
    label124:
    for (String str2 = "1";; str2 = "2")
    {
      StoryReportor.a("all_story", "clk_all", 0, 0, new String[] { str1, str2 });
      if (paramStoryItem.preLoadStatus == 2) {
        break label132;
      }
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      paramView.obj = String.valueOf(paramStoryItem.user.uid);
      paramView.arg1 = Integer.parseInt(IPreloadVideoSource.b);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 30000L);
      return;
      str1 = "1";
      break;
    }
    label132:
    paramView = (ImageView)paramView.findViewById(2131302782);
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramStoryItem.user.uid, "test", paramView);
  }
  
  public void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (d()) {
      return;
    }
    StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "2" });
    StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, QQStoryContext.a().a(), paramStoryVideoItem.mVid, true, paramView);
  }
  
  public void b(String paramString1, String paramString2)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = paramString2;
    localMessage.arg1 = Integer.parseInt(paramString1);
    localMessage.sendToTarget();
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (d()) {}
    for (;;)
    {
      return;
      StoryReportor.a("mystory", "clk_download", 0, 0, new String[0]);
      if (NetworkUtil.i(this.jdField_a_of_type_AndroidAppActivity))
      {
        c(paramArrayList);
        return;
      }
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        if (!((StoryVideoItem)paramArrayList.get(i)).isPreloadSuc(true))
        {
          QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
          localQQCustomDialog.setTitle("保存日迹");
          localQQCustomDialog.setMessage("当前非Wi-Fi网络，保存我的一天将消耗部分手机流量");
          localQQCustomDialog.setPositiveButton("继续保存", new ita(this, paramArrayList));
          localQQCustomDialog.setNegativeButton("取消", new itc(this));
          localQQCustomDialog.show();
          return;
        }
        i -= 1;
      }
    }
  }
  
  public boolean b()
  {
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localTroopRedTouchManager == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    if (localTroopRedTouchManager.a() != null)
    {
      SLog.b("Q.qqstory.home.StoryListPresenter", "it have red point");
      return true;
    }
    return false;
  }
  
  public void c()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.b();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$RepositoryEventReceiver != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$RepositoryEventReceiver);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    ((StoryManager)SuperManager.a(5)).a().a().b();
  }
  
  public void c(String paramString1, String paramString2)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = paramString2;
    localMessage.arg1 = Integer.parseInt(paramString1);
    localMessage.sendToTarget();
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
    Object localObject1 = new ArrayList();
    FFmpeg localFFmpeg = FFmpeg.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringBuffer();
    long l1 = 0L;
    long l2 = 0L;
    int i = paramArrayList.size() - 1;
    if (i >= 0)
    {
      Object localObject3 = (StoryVideoItem)paramArrayList.get(i);
      ((StringBuffer)localObject2).append(((StoryVideoItem)localObject3).mVid);
      l3 = ((StoryVideoItem)localObject3).mVideoDuration;
      if ((!((StoryVideoItem)localObject3).isPreloadSuc(true)) || ((((StoryVideoItem)localObject3).isMaskVideo()) && (((StoryVideoItem)localObject3).mLocalMaskPath == null)) || ((((StoryVideoItem)localObject3).isMaskVideo()) && (((StoryVideoItem)localObject3).isNativeloadMask())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("FFmepg", 2, "正在下载视频：" + ((StoryVideoItem)localObject3).mVid);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader = new FileDownloader();
        }
        ThreadManager.a(new itd(this, (StoryVideoItem)localObject3, paramArrayList), 8, null, true);
        return;
      }
      String str2 = AppConstants.bt + ((StoryVideoItem)localObject3).mVid + ".mp4";
      String str1 = QQStoryConstant.s + ((StoryVideoItem)localObject3).mVid + ".mp4";
      if (FileUtils.c(str2)) {
        ((List)localObject1).add(str2);
      }
      for (;;)
      {
        i -= 1;
        l1 += l3;
        break;
        if (FileUtils.c(str1))
        {
          ((List)localObject1).add(str1);
        }
        else
        {
          str2 = ((StoryVideoItem)localObject3).mLocalMaskPath;
          String str3 = ((StoryVideoItem)localObject3).mLocalVideoPath;
          int j = ((StoryVideoItem)localObject3).mVideoWidth;
          int k = ((StoryVideoItem)localObject3).mVideoHeight;
          if (str2 == null)
          {
            ((List)localObject1).add(str3);
          }
          else
          {
            l2 += ((StoryVideoItem)localObject3).mVideoDuration;
            ((List)localObject1).add(str1);
            localObject3 = new FFmpegCommandUnit();
            ((FFmpegCommandUnit)localObject3).i = 1;
            ((FFmpegCommandUnit)localObject3).jdField_a_of_type_JavaUtilArrayList = new StoryListPresenter.4(this, str2, str3, str1, j, k);
            ((FFmpegCommandUnit)localObject3).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new itl(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView, str1);
            localArrayList.add(localObject3);
          }
        }
      }
    }
    if (((List)localObject1).size() == 0)
    {
      ToastUtil.a().a("没有内容可下载");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(true);
      return;
    }
    paramArrayList = FFmpegUtils.a(new String((StringBuffer)localObject2).hashCode());
    paramArrayList = AppConstants.bt + paramArrayList;
    if (localFFmpeg.a())
    {
      if (!localFFmpeg.a(paramArrayList)) {
        QQToast.a(BaseApplication.getContext(), 1, "已有其他下载任务在执行，请稍候", 0).a();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
      return;
    }
    if (FileUtils.c(paramArrayList))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, "已保存到本地相册", 0).a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(true);
      StoryReportor.a("mystory", "suc_download", 0, 0, new String[] { "1" });
      return;
    }
    if ((((List)localObject1).size() == 1) && (localArrayList.size() == 0))
    {
      if (FileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)((List)localObject1).get(0), paramArrayList))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, "已保存到本地相册", 0).a();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(true);
        StoryReportor.a("mystory", "suc_download", 0, 0, new String[] { "1" });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FFmepg", 2, "我的故事保存相册失败");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
      return;
    }
    long l3 = SystemClock.uptimeMillis();
    if ((((List)localObject1).size() == 1) && (localArrayList.size() == 1))
    {
      localObject1 = (FFmpegCommandUnit)localArrayList.get(0);
      ((FFmpegCommandUnit)localObject1).jdField_a_of_type_JavaUtilArrayList.set(2, paramArrayList);
      ((FFmpegCommandUnit)localObject1).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new itk(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView, paramArrayList, l3, l1, l2);
    }
    for (;;)
    {
      try
      {
        localFFmpeg.a(paramArrayList);
        localFFmpeg.a(localArrayList);
        return;
      }
      catch (Exception paramArrayList)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FFmepg", 2, paramArrayList.getMessage());
      return;
      localObject2 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject2).i = 7;
      ((FFmpegCommandUnit)localObject2).jdField_a_of_type_JavaUtilArrayList = new StoryListPresenter.5(this, (List)localObject1, paramArrayList);
      ((FFmpegCommandUnit)localObject2).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new itk(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView, paramArrayList, l3, l1, l2);
      localArrayList.add(localObject2);
    }
  }
  
  public boolean c()
  {
    long l = ((Long)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      SLog.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    SLog.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  public void d()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "refreshCompleted and call view requestDataCompleted()");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b();
  }
  
  public void e()
  {
    this.b = true;
    SLog.b("Q.qqstory.home.StoryListPresenter", "manual pull refresh!");
    if (NetworkUtils.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false, true, true);
  }
  
  public void f()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "run load more");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6, paramMessage);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(String.valueOf(i), paramMessage);
      return false;
    case 2: 
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
      return false;
    case 4: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, "我的日迹下载失败", 0).a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
      return false;
    case 3: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, "我的日迹下载成功", 0).a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(true);
      return false;
    case 5: 
      c((ArrayList)paramMessage.obj);
      return false;
    }
    int i = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    SLog.b("Q.qqstory.home.StoryListPresenter", "preload time out :" + paramMessage);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(String.valueOf(i), paramMessage);
    return false;
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\presenter\StoryListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.hotchat;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.PttShowCallback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.anim.ComboAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartBeatAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.anim.HeartLayout.HeartLayoutListener;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotchat.ui.GlowView.InnerViewOnClickListener;
import com.tencent.mobileqq.hotchat.ui.HotChatPttStageView;
import com.tencent.mobileqq.hotchat.ui.PttTimeLineItemInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import sua;
import sub;
import suc;
import sud;
import sue;
import suf;
import sug;
import suh;
import sui;
import suj;
import suk;
import sun;
import suo;
import suq;
import sut;
import suu;

public class HotChatPttStageControl
  extends BaseHotChatControl
  implements Handler.Callback, View.OnClickListener, MediaPlayerManager.PttShowCallback, HeartLayout.HeartLayoutListener, FaceDecoder.DecodeTaskCompletionListener, HorizontalListView.OnScrollStateChangedListener
{
  static final int jdField_a_of_type_Int = 0;
  public static final String a = "HotChatPttStageControl";
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  static final int jdField_d_of_type_Int = 3;
  public static final int e = 4;
  public static final int f = 5;
  static final int t = 2000;
  private static final int x = 20;
  public long a;
  public Handler a;
  public DisplayMetrics a;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  FileTransferManager.Callback jdField_a_of_type_ComTencentMobileqqActivityAioFileTransferManager$Callback;
  public MediaPlayerManager a;
  public SessionInfo a;
  public HotChatManager a;
  public HotChatInfo a;
  HCTopicSeatsView jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView;
  public PttMsgAdapter a;
  public HeartBeatAnimator a;
  public HeartLayout a;
  GlowView.InnerViewOnClickListener jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener;
  public HotChatPttStageView a;
  public RedDotImageView a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public HorizontalListView a;
  public ListView a;
  public ArrayList a;
  Random jdField_a_of_type_JavaUtilRandom;
  public ConcurrentHashMap a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  public long b;
  public boolean b;
  int[] jdField_b_of_type_ArrayOfInt;
  public long c;
  public boolean c;
  private final int[] jdField_c_of_type_ArrayOfInt;
  long jdField_d_of_type_Long;
  public boolean d;
  long jdField_e_of_type_Long;
  boolean jdField_e_of_type_Boolean;
  final long f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s;
  
  public HotChatPttStageControl(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, HotChatPie paramHotChatPie, RelativeLayout paramRelativeLayout, SessionInfo paramSessionInfo, String paramString)
  {
    super(paramQQAppInterface, paramContext, paramActivity, paramHotChatPie, paramRelativeLayout);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_g_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioFileTransferManager$Callback = new sui(this);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener = new suk(this);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_d_of_type_Long = 0L;
    this.n = 0;
    this.o = 8;
    this.jdField_e_of_type_Long = 250L;
    this.p = 200;
    this.q = 0;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_f_of_type_Long = 500L;
    this.jdField_c_of_type_ArrayOfInt = new int[] { Color.parseColor("#fc6a91"), Color.parseColor("#fbcf50"), Color.parseColor("#1ab7f5"), Color.parseColor("#ffa34d"), Color.parseColor("#ef5d5c"), Color.parseColor("#509efe"), Color.parseColor("#8ccf43") };
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(23));
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramSessionInfo.a);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView, this.jdField_a_of_type_ComTencentMobileqqActivityAioFileTransferManager$Callback);
  }
  
  private int a(int paramInt)
  {
    int i1 = 300;
    if (paramInt >= 20) {
      i1 = 700;
    }
    do
    {
      return i1;
      if (paramInt >= 15) {
        return 600;
      }
      if (paramInt >= 10) {
        return 500;
      }
    } while (paramInt < 5);
    return 400;
  }
  
  private PttMsgAdapter.ViewHolder a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition()) && (paramInt <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()))
    {
      int i2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      int i1 = 0;
      if (i1 < i2)
      {
        PttMsgAdapter.ViewHolder localViewHolder = (PttMsgAdapter.ViewHolder)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i1).getTag();
        if (localViewHolder == null) {}
        PttTimeLineItemInfo localPttTimeLineItemInfo;
        do
        {
          i1 += 1;
          break;
          localPttTimeLineItemInfo = (PttTimeLineItemInfo)this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getItem(paramInt);
        } while ((localPttTimeLineItemInfo == null) || (localViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != localPttTimeLineItemInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt));
        return localViewHolder;
      }
    }
    return null;
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(List paramList)
  {
    PttShowRoomMng localPttShowRoomMng;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localPttShowRoomMng = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(true);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label52;
      }
      ThreadManager.a(new suf(this, paramList, localPttShowRoomMng), 8, null, true);
    }
    for (;;)
    {
      return;
      label52:
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPttShowRoomMng.a((MessageForPtt)paramList.next());
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_e_of_type_Boolean = true;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getCount()))
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
    }
    int i1;
    int i3;
    do
    {
      int i2;
      int i4;
      for (;;)
      {
        return;
        i2 = PttMsgAdapter.a;
        i1 = (this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i2) / 2;
        i4 = paramInt - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
        i3 = a(i4);
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i4) == null)
        {
          i4 = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.c(paramInt);
          if (i4 >= i1)
          {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -i1, i3);
            return;
          }
          i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -(i1 - i2 - i4), i3);
          return;
        }
        i4 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i4).getLeft();
        if (i1 <= i4) {
          break;
        }
        i2 = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.d(paramInt);
        if (i2 == i4)
        {
          p();
          this.jdField_e_of_type_Boolean = false;
          return;
        }
        if (i2 >= i1) {}
        while (i1 > 0)
        {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -i1, i3);
          return;
          i1 = i2;
        }
      }
      if (i1 >= i4) {
        break;
      }
      int i5 = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.c(paramInt);
      if (i5 == 0)
      {
        if (i4 + i2 == this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels)
        {
          p();
          this.jdField_e_of_type_Boolean = false;
          return;
        }
        int i6 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -(i4 - (i4 + i2 - i6)), i3);
      }
      if (i5 >= i1) {}
      while (i1 == i4)
      {
        p();
        this.jdField_e_of_type_Boolean = false;
        return;
        i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i2 - i5;
      }
    } while (i1 <= 0);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -i1, i3);
    return;
    p();
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, " clearData(),mState:" + this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    f();
  }
  
  private void p()
  {
    int i1 = this.jdField_i_of_type_Int;
    if ((i1 >= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition()) && (i1 <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getItem(i1) instanceof PttTimeLineItemInfo)) {}
      MessageForPtt localMessageForPtt;
      do
      {
        return;
        localMessageForPtt = ((PttTimeLineItemInfo)this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getItem(i1)).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      } while ((this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localMessageForPtt)) || (localMessageForPtt == this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()));
      if (localMessageForPtt.isReady())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
        {
          this.jdField_f_of_type_Boolean = false;
          return;
        }
        PttMsgAdapter.ViewHolder localViewHolder = a(i1);
        if (localViewHolder == null)
        {
          this.jdField_f_of_type_Boolean = false;
          return;
        }
        if (!a(localMessageForPtt, i1))
        {
          this.jdField_f_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localViewHolder, true);
        this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localViewHolder);
        this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(localViewHolder, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatPttStageControl", 2, "autoPlayPtt ptt not ready: " + this.jdField_i_of_type_Int + " ");
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new suj(this), 1000L);
      return;
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_ArrayOfInt.length)];
  }
  
  public HCTopicSeatsView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    e();
    ArrayList localArrayList = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(0, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1026).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1026).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026);
    }
    for (;;)
    {
      Object localObject2 = new StringBuilder().append("mHotChatPttControl init from cache msgList size=");
      int i1;
      int i3;
      label200:
      int i2;
      if (localObject1 == null)
      {
        i1 = 0;
        QLog.d("PttShow", 1, i1 + ", localMaxSeq=" + l1 + ", lLastMsgSeq=" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.lLastMsgSeq);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          i1 = 1;
          i3 = ((List)localObject1).size() - 1;
          if (i3 >= 0)
          {
            localObject2 = (MessageRecord)((List)localObject1).get(i3);
            i2 = i1;
            if (localObject2 == null) {
              break label611;
            }
            i2 = i1;
            if (!(localObject2 instanceof MessageForPtt)) {
              break label611;
            }
            localObject2 = (MessageForPtt)localObject2;
            QLog.d("PttShow", 1, "mHotChatPttControl init index=" + i3 + ", ptt=" + ((MessageForPtt)localObject2).toString() + ", voice length=" + ((MessageForPtt)localObject2).voiceLength);
            if (i1 == 0) {
              break label560;
            }
            long l2 = ((MessageForPtt)localObject2).shmsgseq;
            this.jdField_b_of_type_Long = l2;
            this.jdField_a_of_type_Long = l2;
            i2 = 0;
            label321:
            localArrayList.add(0, localObject2);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((MessageForPtt)localObject2).uniseq), localObject2);
            if (localArrayList.size() < 20) {
              break label611;
            }
          }
        }
        QLog.d("PttShow", 1, "mHotChatPttControl init pttList size=" + localArrayList.size() + ", mMinPttSeq=" + this.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_b_of_type_Long);
        if ((!localArrayList.isEmpty()) && (this.jdField_a_of_type_Long <= 1L)) {
          break label624;
        }
      }
      label560:
      label611:
      label624:
      for (boolean bool = true;; bool = false)
      {
        a(localArrayList, bool);
        a(localArrayList);
        if (localArrayList.size() < 20) {
          ThreadManager.a(new sua(this, 20 - localArrayList.size()), 8, null, true);
        }
        localObject1 = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
        if (l1 < this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.lLastMsgSeq)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, 0);
          ((HotChatHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, 1L + l1, Math.min((int)(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.lLastMsgSeq - l1), 20), 1, 1, 0);
        }
        m();
        b(false);
        return;
        i1 = ((List)localObject1).size();
        break;
        if (((MessageForPtt)localObject2).shmsgseq > this.jdField_b_of_type_Long) {
          this.jdField_b_of_type_Long = ((MessageForPtt)localObject2).shmsgseq;
        }
        i2 = i1;
        if (((MessageForPtt)localObject2).shmsgseq >= this.jdField_a_of_type_Long) {
          break label321;
        }
        this.jdField_a_of_type_Long = ((MessageForPtt)localObject2).shmsgseq;
        i2 = i1;
        break label321;
        i3 -= 1;
        i1 = i2;
        break label200;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 4097) {
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        if ((this.jdField_i_of_type_Int < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition()) || (this.jdField_i_of_type_Int > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()))
        {
          paramInt = 0;
          if (paramInt == 0) {
            break label111;
          }
          this.jdField_e_of_type_Boolean = false;
          p();
        }
      }
      else {
        if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0).getLeft() >= 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state == 0)) {
          break label122;
        }
      }
    }
    label111:
    label122:
    while (paramInt != 4098)
    {
      do
      {
        for (;;)
        {
          return;
          paramInt = 1;
          continue;
          c(this.jdField_i_of_type_Int);
        }
      } while ((!this.jdField_j_of_type_Boolean) || (this.jdField_h_of_type_Boolean));
      a(((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).shmsgseq, 20);
      this.jdField_h_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006581", "0X8006581", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.b();
    }
    if ((paramInt1 == paramInt2) || (!this.jdField_b_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 0) {
          break;
        }
      } while (!this.jdField_a_of_type_Boolean);
      b(0L);
      return;
    } while ((paramInt2 != 0) || (this.jdField_a_of_type_Boolean));
    a(0L);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, "onDecodeTaskCompleted uin=" + paramString + ", type=" + paramInt2);
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      if (paramInt1 < i1)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label235;
        }
        localObject = ((View)localObject).getTag();
        if (!(localObject instanceof PttMsgAdapter.ViewHolder)) {
          break label235;
        }
        localObject = (PttMsgAdapter.ViewHolder)localObject;
        if (!((Boolean)((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a().getTag()).booleanValue()) {
          break label146;
        }
        if ((paramString == null) || (paramInt2 != ((PttMsgAdapter.ViewHolder)localObject).b) || (!paramString.equals(((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin))) {
          break label235;
        }
      }
      label146:
      do
      {
        return;
        if ((paramString == null) || (paramInt2 != ((PttMsgAdapter.ViewHolder)localObject).b) || (!paramString.equals(((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin))) {
          break;
        }
        ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a().setImageBitmap(paramBitmap);
        ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a().setTag(Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("HotChatPttStageControl", 2, "face updated, uin=" + paramString);
      return;
      label235:
      paramInt1 += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatPttStageControl", 2, "getMorePttData: shmsgseq: " + paramLong + " count: " + paramInt);
    }
    if ((paramLong <= 1L) || (paramInt < 1)) {
      return;
    }
    if (paramInt > paramLong - 1L) {
      paramInt = (int)(paramLong - 1L);
    }
    for (;;)
    {
      Object localObject1 = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(1, ((HotChatInfo)localObject2).troopUin);
      QLog.d("PttShow", 1, "getMorePttData shmsgseq=" + paramLong + ", count=" + paramInt + ", localCacheMinSeq=" + l1 + ", mMinPttSeq=" + this.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_b_of_type_Long);
      if ((paramLong > l1) && (paramLong - l1 >= paramInt))
      {
        localObject1 = new ArrayList();
        int i1 = 0;
        while (i1 < paramInt)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026, paramLong - paramInt + i1);
          if ((localObject2 != null) && ((localObject2 instanceof MessageForPtt)))
          {
            localObject2 = (MessageForPtt)localObject2;
            if (((MessageForPtt)localObject2).shmsgseq > this.jdField_b_of_type_Long) {
              this.jdField_b_of_type_Long = ((MessageForPtt)localObject2).shmsgseq;
            }
            if (((MessageForPtt)localObject2).shmsgseq < this.jdField_a_of_type_Long) {
              this.jdField_a_of_type_Long = ((MessageForPtt)localObject2).shmsgseq;
            }
            ((ArrayList)localObject1).add(localObject2);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((MessageForPtt)localObject2).uniseq), localObject2);
          }
          i1 += 1;
        }
        if ((paramLong == paramInt + l1) && (l1 == 1L)) {}
        for (boolean bool = false;; bool = true)
        {
          a((List)localObject1, bool);
          a((List)localObject1);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(((HotChatInfo)localObject2).troopUin, 1);
      ((HotChatHandler)localObject1).a((HotChatInfo)localObject2, paramLong - 1L, paramInt, 0);
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup, RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getLeft();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getWidth();
    Object localObject = paramRelativeLayout.findViewById(2131296555);
    if (localObject != null) {
      paramRelativeLayout.removeView((View)localObject);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setId(2131296555);
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription("给房间点赞,按钮");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new sug(this));
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new suh(this));
    }
    localObject = new RelativeLayout.LayoutParams(i2, AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    paramRelativeLayout = paramViewGroup.findViewById(2131296556);
    if (paramRelativeLayout != null) {
      paramViewGroup.removeView(paramRelativeLayout);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = new HeartLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setId(2131296556);
      paramRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a();
      if (paramRelativeLayout != null)
      {
        paramRelativeLayout.jdField_a_of_type_Boolean = true;
        paramRelativeLayout.m = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 2);
        paramRelativeLayout.n = (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.c / 2);
        paramRelativeLayout.l = 2000;
        paramRelativeLayout.d = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRelativeLayout.c = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setHeartListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.removeAllViews();
    paramRelativeLayout = new RelativeLayout.LayoutParams(-1, -1);
    paramRelativeLayout.addRule(8, 2131297407);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, paramRelativeLayout);
  }
  
  public void a(Animation paramAnimation) {}
  
  public void a(HeartLayout paramHeartLayout, float paramFloat1, float paramFloat2) {}
  
  public void a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramHorizontalListView = (MessageForPtt)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatPttStageControl", 2, "play over position=" + paramInt + ", ptt msg=" + paramHorizontalListView.toString());
    }
    paramChatMessage = a(paramInt);
    if (paramChatMessage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramChatMessage, false);
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramChatMessage, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHorizontalListView), paramHorizontalListView);
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(paramChatMessage, true);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.b(300L);
    this.jdField_h_of_type_Int = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.setCurSpeakingGuest("0");
    }
    if (paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramInt);
      if (this.jdField_i_of_type_Int == -1) {
        this.jdField_f_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new sun(this), 1000L);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    long l1 = 0L;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (this.jdField_c_of_type_Long = this.jdField_c_of_type_Long;; this.jdField_c_of_type_Long = l1)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new suq(this, paramArrayList, paramBoolean), this.jdField_c_of_type_Long);
      return;
      if (this.jdField_e_of_type_Boolean) {
        l1 = 300L;
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new suo(this, paramList, paramBoolean));
  }
  
  public void a(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageForPtt)))
    {
      paramObservable = (MessageForPtt)paramObject;
      QLog.d("PttShow", 1, "HotChatPie update receive ptt msg=" + paramObservable.toString() + "ptt voice length=" + paramObservable.voiceLength + ", before mMinPttSeq=" + this.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_b_of_type_Long);
      if ((paramObservable.istroop == 1026) && (Utils.a(paramObservable.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
      {
        if (paramObservable.shmsgseq > this.jdField_b_of_type_Long) {
          this.jdField_b_of_type_Long = paramObservable.shmsgseq;
        }
        if (paramObservable.shmsgseq < this.jdField_a_of_type_Long) {
          this.jdField_a_of_type_Long = paramObservable.shmsgseq;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramObservable.uniseq), paramObservable);
        paramObject = new ArrayList();
        ((ArrayList)paramObject).add(paramObservable);
        a((ArrayList)paramObject, true);
        QLog.d("PttShow", 1, "HotChatPie update receive ptt msg after mMinPttSeq=" + this.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_b_of_type_Long);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, String paramString3)
  {
    QLog.d("PttShow", 1, "onGetHotChatTopicMsg isSuccess=" + paramBoolean + ", result=" + paramInt1 + ", troopUin=" + paramString1 + ", uuid=" + paramString2 + ", lStartMsgSeq=" + paramLong1 + ", nReqMsgNum=" + paramInt2 + ", Order=" + paramInt3 + ", lNextMsgSeq=" + paramLong2 + ", errorMsg=" + paramString3);
    if ((paramBoolean) && (paramInt1 == 0) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (paramLong1 > 0L) && (paramInt2 > 0) && (paramLong2 >= 0L))
    {
      paramString2 = new ArrayList();
      if ((paramInt2 <= paramLong1) || (paramInt3 != 0)) {
        break label544;
      }
    }
    label513:
    label544:
    for (paramInt1 = (int)paramLong1;; paramInt1 = paramInt2)
    {
      int i1 = 0;
      if (i1 < paramInt2)
      {
        paramString1 = null;
        if ((paramInt3 == 0) && (paramLong1 > i1)) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026, paramLong1 - paramInt1 + i1 + 1L);
        }
        for (;;)
        {
          if ((paramString1 != null) && ((paramString1 instanceof MessageForPtt)))
          {
            paramString1 = (MessageForPtt)paramString1;
            QLog.d("PttShow", 1, "onGetHotChatTopicMsg index=" + i1 + ", ptt=" + paramString1.toString());
            if (paramString1.shmsgseq > this.jdField_b_of_type_Long) {
              this.jdField_b_of_type_Long = paramString1.shmsgseq;
            }
            if (paramString1.shmsgseq < this.jdField_a_of_type_Long) {
              this.jdField_a_of_type_Long = paramString1.shmsgseq;
            }
            if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramString1.uniseq)))
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramString1.uniseq), paramString1);
              paramString2.add(paramString1);
            }
          }
          i1 += 1;
          break;
          if (paramInt3 == 1) {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1026, i1 + paramLong1);
          }
        }
      }
      QLog.d("PttShow", 1, "onGetHotChatTopicMsg pttList size=" + paramString2.size() + ", mMinPttSeq=" + this.jdField_a_of_type_Long + ", mMaxPttSeq=" + this.jdField_b_of_type_Long);
      if (paramString2.size() > 0)
      {
        if (paramInt4 != 1) {
          break label513;
        }
        a(paramString2, false);
      }
      while (paramInt4 != 2)
      {
        a(paramString2);
        return;
      }
      if (paramLong2 > 0L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramString2, paramBoolean);
        break;
      }
    }
  }
  
  public boolean a()
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentWidgetListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView = new HotChatPttStageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.setId(2131296553);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView, 0, (ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.getId());
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840922);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, this.jdField_a_of_type_ComTencentWidgetListView.getId());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.setId(2131296553);
    this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView = this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a();
    this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter = new PttMsgAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener, this, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this);
    boolean bool;
    int i2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      bool = true;
      this.jdField_g_of_type_Boolean = bool;
      if (this.jdField_g_of_type_Boolean)
      {
        float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
        this.r = ((int)(8.0F * f1));
        this.k = ((int)(f1 * 32.0F / 2.0F));
        this.m = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.k * 2);
        this.l = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - ComboAnimator.c * 6);
        this.s = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator = new HeartBeatAnimator(this.jdField_a_of_type_AndroidContentContext);
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.e);
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
          i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildCount();
        }
      }
    }
    for (;;)
    {
      if (i1 < i2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i1);
        if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof Integer)) && (((Integer)((View)localObject).getTag()).intValue() == 20)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)localObject);
        }
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.e, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        return true;
        bool = false;
        break;
      }
      i1 += 1;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.i())
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_i_of_type_Boolean)) {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(paramMessageForPtt, true, paramInt);
    }
    for (;;)
    {
      this.jdField_h_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView != null) && (bool1))
      {
        bool2 = a(paramMessageForPtt.senderuin);
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a(300L);
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a(bool2);
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.b(bool2);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_b_of_type_Boolean = bool2;
        }
      }
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView == null) {
        break;
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.setCurSpeakingGuest(paramMessageForPtt.senderuin);
      return bool1;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(paramMessageForPtt, true);
      this.jdField_i_of_type_Boolean = true;
    }
  }
  
  public boolean a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage)
  {
    return ((MessageForPtt)paramChatMessage).isReady();
  }
  
  public boolean a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramHorizontalListView = (MessageForPtt)paramChatMessage;
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramHorizontalListView);
    if (paramHorizontalListView.isReady())
    {
      if (paramAudioPlayer.a(paramHorizontalListView.getLocalFilePath()))
      {
        a(paramHorizontalListView);
        paramChatMessage = a(paramInt);
        if (paramChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramChatMessage, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHorizontalListView), paramHorizontalListView);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatPttStageControl", 2, "play failed player return false " + paramHorizontalListView.getLocalFilePath());
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("HotChatPttStageControl", 2, "play failed not ready " + paramHorizontalListView.getLocalFilePath());
      }
    }
  }
  
  public boolean a(String paramString)
  {
    PttShowRoomMng localPttShowRoomMng = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
    if (localPttShowRoomMng == null) {}
    while (localPttShowRoomMng.a(paramString) != 1) {
      return true;
    }
    return false;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      return true;
    }
    int i2 = 0;
    boolean bool1 = true;
    MessageForPtt localMessageForPtt1;
    boolean bool2;
    int i1;
    MessageForPtt localMessageForPtt2;
    for (;;)
    {
      if (i2 < paramArrayList.size())
      {
        localMessageForPtt1 = (MessageForPtt)paramArrayList.get(i2);
        if (localMessageForPtt1 == null)
        {
          bool2 = bool1;
          i2 += 1;
          bool1 = bool2;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatPttStageControl", 2, "replacePttInfos add Ptt uniseq: " + localMessageForPtt1.uniseq + " shmSeq: " + localMessageForPtt1.shmsgseq);
          }
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          for (;;)
          {
            bool2 = bool1;
            if (i1 < 0) {
              break label421;
            }
            localMessageForPtt2 = (MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if (localMessageForPtt2 != null) {
              break;
            }
            label165:
            i1 -= 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("HotChatPttStageControl", 2, "replacePttInfos orig Ptt uniseq: " + localMessageForPtt2.uniseq + " shmSeq: " + localMessageForPtt2.shmsgseq);
          }
          if (localMessageForPtt1.uniseq == localMessageForPtt2.uniseq)
          {
            this.jdField_a_of_type_JavaUtilArrayList.set(i1, localMessageForPtt1);
            if (i1 != this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
              bool1 = false;
            }
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break label421;
            }
            QLog.i("HotChatPttStageControl", 2, "replacePttInfos setndex: " + i1);
            i1 = -1;
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i1 == -1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i1, localMessageForPtt1);
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("HotChatPttStageControl", 2, "replacePttInfos addIndex: " + i1);
      bool2 = bool1;
      break;
      if (localMessageForPtt1.shmsgseq >= localMessageForPtt2.shmsgseq)
      {
        if (i1 != this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          bool1 = false;
        }
        i1 += 1;
      }
      else
      {
        if (i1 != 0) {
          break label165;
        }
        i1 = 0;
        bool1 = false;
        continue;
        return bool1;
        label421:
        bool1 = bool2;
        i1 = -1;
      }
    }
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new sut(this, paramList, paramBoolean));
    return true;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatPttStageControl", 2, "doPraiseAnim, incCount=" + paramInt);
    }
    if ((!this.jdField_g_of_type_Boolean) || (paramInt <= 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (paramInt > this.o) {}
    for (int i1 = this.o;; i1 = paramInt)
    {
      this.q = paramInt;
      this.jdField_a_of_type_ArrayOfInt = new int[i1];
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = (this.jdField_a_of_type_JavaUtilRandom.nextInt(this.m) + this.k);
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.e(true);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.f != null) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(this.jdField_b_of_type_ArrayOfInt);
      int i1 = this.jdField_b_of_type_ArrayOfInt[0];
      int i2 = HeartBeatAnimator.b / 2;
      int i3 = this.jdField_b_of_type_ArrayOfInt[1];
      int i4 = HeartBeatAnimator.c / 2;
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator.a(i1 - i2, i3 - i4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)) || (this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatPttStageControl", 2, "uploadPraise, something is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotChatPttStageControl", 2, "getPraise, uuid=" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
    }
    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5), this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_f_of_type_Long);
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.b();
    }
    return bool;
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, " onDestory(),mState:" + this.jdField_g_of_type_Int);
    }
    o();
  }
  
  public void c(long paramLong)
  {
    QLog.d("PttShow", 1, "HotChatPttStageControl deletePttItem uniseq=" + paramLong);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new suu(this, paramLong));
  }
  
  public void d()
  {
    super.d();
    o();
  }
  
  public void e()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, "updateView, status:" + this.jdField_g_of_type_Int);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.pttstage", 2, "removeView,mState:" + this.jdField_g_of_type_Int + ",hasAttach:" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.setAnimation(null);
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.d();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView = null;
        this.jdField_a_of_type_AndroidWidgetImageView = null;
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void g()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator.b();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(0);
      ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, i1, false);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.b();
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartBeatAnimator.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.clearAnimation();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              k();
              return false;
              j();
              return false;
            } while ((this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView == null) || (this.jdField_b_of_type_Boolean));
            a(true);
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter, this, false, false);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.dY != 0) && (this.jdField_a_of_type_Boolean)) {
              b(600L);
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.hotchat.pttstage", 2, "attachPttStageView");
          return false;
          this.q -= 1;
        } while ((this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView == null) || (this.jdField_a_of_type_ArrayOfInt == null));
        int i1 = this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a().getBottom();
        int i2 = (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a().getTop() - i1) / 2;
        int i3 = this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.c;
        int i4 = this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_ArrayOfInt.length)];
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a(a(), i4, i1 + i2 + i3, -1L, 2);
      } while (this.q <= 0);
      long l1 = this.jdField_e_of_type_Long;
      long l2 = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.p);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), l1 + l2);
      return false;
    case 5: 
      b(true);
      return false;
    }
    m();
    return false;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(false);
  }
  
  public void j()
  {
    if (!VersionUtils.e())
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.setVisibility(8);
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493624);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i1 });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new sub(this, i1));
    localValueAnimator.addListener(new suc(this));
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.start();
  }
  
  public void k()
  {
    if (!VersionUtils.e())
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.setVisibility(0);
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493624);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i1, 0 });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new sud(this, i1));
    localValueAnimator.addListener(new sue(this, i1));
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.start();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null)
    {
      HotChatPie localHotChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie;
      localHotChatPie.i += 1L;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.i);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006786", "0X8006786", 0, 0, "", "", "", "");
    if (!this.jdField_g_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView == null) || (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqHotchatUiHotChatPttStageView.a() == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long > 500L) {}
    for (this.n = 1;; this.n += 1)
    {
      this.jdField_d_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(a(), this.jdField_b_of_type_ArrayOfInt[0] + this.jdField_a_of_type_AndroidViewView.getWidth() / 2, this.jdField_b_of_type_ArrayOfInt[1], -1L, 1);
      return;
    }
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)) || (this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatPttStageControl", 2, "uploadPraise, something is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotChatPttStageControl", 2, "uploadPraise, uuid=" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(0);
    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, i1);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_d_of_type_Long);
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HotChatPttStageControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
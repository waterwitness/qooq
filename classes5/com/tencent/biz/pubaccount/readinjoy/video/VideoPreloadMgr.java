package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.readinjoy.ReadInJoyHelper;
import ian;
import iao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class VideoPreloadMgr
{
  private static final int jdField_a_of_type_Int = 10000;
  private static String jdField_a_of_type_JavaLangString = "VideoPreloadMgr";
  private static final int jdField_b_of_type_Int = 1;
  private static final int c = 3;
  private static final int d = 5;
  private Handler jdField_a_of_type_AndroidOsHandler = new ian(this, Looper.getMainLooper());
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPreloadReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private List jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private List jdField_b_of_type_JavaUtilList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoPreloadMgr(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData = new VideoPreloadReportData();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.b = Collections.synchronizedList(new ArrayList());
  }
  
  private boolean a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((Long)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).longValue() == paramVideoPlayParam.jdField_a_of_type_Long) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)) {}
    while ((!a()) || (this.b == null) || (this.b.size() <= 0)) {
      return;
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam = (VideoPlayManager.VideoPlayParam)this.b.get(0);
    Object localObject = new iao(this, localVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData);
    this.jdField_a_of_type_MqqOsMqqHandler.post((Runnable)localObject);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = Long.valueOf(localVideoPlayParam.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 10000L);
  }
  
  private boolean b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.b != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.b.size())
      {
        if (((VideoPlayManager.VideoPlayParam)this.b.get(i)).jdField_a_of_type_Long == paramVideoPlayParam.jdField_a_of_type_Long) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((Long)localPair.first).longValue() == paramVideoPlayParam.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localPair);
        return (VideoPlayerWrapper)localPair.second;
      }
      i += 1;
    }
    return null;
  }
  
  public VideoPreloadReportData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
  }
  
  public ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  }
  
  public List a(int paramInt)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount();
      if (paramInt >= j - 1) {
        localObject2 = localObject1;
      }
    }
    else
    {
      return (List)localObject2;
    }
    int i = Math.min(paramInt + 1, j - 1);
    int j = Math.min(paramInt + 3, j - 1);
    paramInt = i;
    for (localObject1 = localVideoPlayParam;; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (paramInt > j) {
        break;
      }
      BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(paramInt);
      localObject2 = localObject1;
      if (localBaseArticleInfo != null)
      {
        localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
        localVideoPlayParam.e = localBaseArticleInfo.busiType;
        localVideoPlayParam.jdField_a_of_type_Long = localBaseArticleInfo.mArticleID;
        localVideoPlayParam.jdField_a_of_type_JavaLangString = localBaseArticleInfo.mVideoVid;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localVideoPlayParam);
      }
      paramInt += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    ThirdVidoeManager.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData != null)
    {
      ReadInJoyUtils.b(BaseApplication.getContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData = null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (localPair != null) {
        ((VideoPlayerWrapper)localPair.second).l();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.b.clear();
    this.b = null;
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      localList = a(paramInt);
      if ((localList != null) && (localList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.readinjoy.video", 2, "requestPreloadNext, size = " + localList.size());
        }
        paramInt = 0;
        if (paramInt < localList.size())
        {
          localVideoPlayParam = (VideoPlayManager.VideoPlayParam)localList.get(paramInt);
          bool1 = a(localVideoPlayParam);
          bool2 = b(localVideoPlayParam);
          if ((!bool2) && (!bool1)) {
            this.b.add(0, localVideoPlayParam);
          }
          for (;;)
          {
            paramInt += 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.w("Q.readinjoy.video", 2, "[preload]: ignore ..." + localVideoPlayParam.jdField_a_of_type_JavaLangString + ", articleID =" + localVideoPlayParam.jdField_a_of_type_Long + ",isInPreparedList=" + bool1 + ",isInWaitedList=" + bool2);
            }
          }
        }
        b();
      }
    }
    while (!QLog.isColorLevel())
    {
      List localList;
      VideoPlayManager.VideoPlayParam localVideoPlayParam;
      boolean bool1;
      boolean bool2;
      return;
    }
    QLog.i("Q.readinjoy.video", 2, "requestPreload: is off, return:");
  }
  
  public void a(long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.b != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.b.size())
      {
        if (((VideoPlayManager.VideoPlayParam)this.b.get(i)).jdField_a_of_type_Long == paramLong) {
          this.b.remove(i);
        }
      }
      else
      {
        b();
        return;
      }
      i += 1;
    }
  }
  
  public void a(Long paramLong, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(new Pair(paramLong, paramVideoPlayerWrapper));
      if (this.jdField_a_of_type_JavaUtilList.size() > 5)
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        int i = 0;
        while (i < j - 5)
        {
          ((VideoPlayerWrapper)((Pair)this.jdField_a_of_type_JavaUtilList.remove(i)).second).l();
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.readinjoy.video", 2, "[preload]: onPreparedAdd: preSize: " + j + ", afterSize = " + this.jdField_a_of_type_JavaUtilList.size());
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null)
    {
      bool1 = bool2;
      if (NetworkUtil.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()))
      {
        bool1 = bool2;
        if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoPreloadMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
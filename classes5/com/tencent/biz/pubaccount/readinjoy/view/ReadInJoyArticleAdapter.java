package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyArticleAdapter
  extends ReadInJoyBaseAdapter
{
  public ReadInJoyArticleAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(int paramInt)
  {
    Object localObject = (Long)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ReadInJoyLogicEngine.a().a(this.p, ((Long)localObject).longValue());
    if (localObject == null) {
      return 0;
    }
    if (ReadInJoyUtils.a((BaseArticleInfo)localObject)) {
      if (((ArticleInfo)localObject).mVideoType == 0) {
        paramInt = 4;
      }
    }
    for (;;)
    {
      return paramInt;
      paramInt = 5;
      continue;
      if (((ArticleInfo)localObject).mShowBigPicture)
      {
        if (((ArticleInfo)localObject).mIsGallery == 0) {
          paramInt = 2;
        } else {
          paramInt = 8;
        }
      }
      else if ((((ArticleInfo)localObject).mPictures != null) && (((ArticleInfo)localObject).mPictures.length >= 3)) {
        paramInt = 3;
      } else if (TextUtils.isEmpty(((ArticleInfo)localObject).mFirstPagePicUrl)) {
        paramInt = 0;
      } else if (((ArticleInfo)localObject).mIsGallery == 0) {
        paramInt = 1;
      } else {
        paramInt = 7;
      }
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return ReadInJoyLogicEngine.a().a(Integer.valueOf(this.p));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(this.p, paramLong);
  }
  
  public void a(int paramInt, long paramLong, ArrayList paramArrayList)
  {
    Object localObject1 = (ArticleInfo)a(this.p, paramLong);
    if (localObject1 == null) {}
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = ReadInJoyUtils.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.a == 5) {
                a(localDislikeInfo.c);
              }
            }
            ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject2).longValue(), ((ArticleInfo)localObject1).makeDislikeParam(paramArrayList));
            ReadInJoyLogicEngine.a().a(this.p, (BaseArticleInfo)localObject1);
          } while (paramInt != 0);
          paramArrayList = (QQAppInterface)ReadInJoyUtils.a();
          localObject1 = (KandianMergeManager)paramArrayList.getManager(161);
          if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break;
          }
        } while (this.p != 0);
        localObject2 = (Long)this.jdField_a_of_type_JavaUtilList.get(0);
        localObject2 = a(this.p, ((Long)localObject2).longValue());
      } while ((localObject2 == null) || (((KandianMergeManager)localObject1).a()));
      PublicAccountUtil.a(paramArrayList, ((BaseArticleInfo)localObject2).mTitle, String.valueOf(NetConnInfoCenter.getServerTime()), true);
      return;
      ReadInJoyLogicEngine.a().a(this.p, 20, Long.MAX_VALUE, true);
    } while (this.p != 0);
    PublicAccountUtil.a(paramArrayList, paramArrayList.a().getResources().getString(2131362982), String.valueOf(NetConnInfoCenter.getServerTime()), true);
  }
  
  protected void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    super.a(paramBaseArticleInfo, paramBoolean);
    ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.innerUniqueID, paramBoolean);
    ReadInJoyLogicEngine.a().b(paramBaseArticleInfo.innerUniqueID, paramBoolean);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label211;
      }
    }
    label211:
    for (int j = 0;; j = 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.b(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), this.p, i, j));
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = this.p;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localArrayList.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(localArrayList);
      ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
      super.a(paramVideoPlayParam, paramBaseArticleInfo);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new PublicAccountUnfollowTask((QQAppInterface)ReadInJoyUtils.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(Long.valueOf(paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyArticleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.ac.ArticleComment.ArticleLikeRequest;
import com.tencent.mobileqq.ac.ArticleComment.ArticleLikeRespond;
import com.tencent.mobileqq.ac.ArticleComment.CheckArticleLikeRequest;
import com.tencent.mobileqq.ac.ArticleComment.CheckArticleLikeRespond;
import com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRequest;
import com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleCommentCountRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleCommentCountRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleLikeCountRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleLikeCountRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.LikeRet;
import com.tencent.mobileqq.ac.ArticleComment.PhotoItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.ReadPhotoItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.RecommendItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.ReportReadPhotoCollectionRequest;
import com.tencent.mobileqq.ac.ArticleComment.ReportReadPhotoCollectionResponse;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PublicAccountArticleHandler
  extends BusinessHandler
{
  public static final String A = "VALUE_ARTICLE_ITEM_COMMENT_URL";
  public static final int a = 0;
  public static final String a = "Q.pubaccount.video.PublicAccountArticleHandler";
  public static final int b = 1;
  public static final String b = "PubAccountArticleCenter.ArticleLike";
  public static final int c = 2;
  public static final String c = "PubAccountArticleCenter.CheckArticleLike";
  public static final int d = 3;
  public static final String d = "PubAccountArticleCenter.GetArticleLikeCount";
  public static final int e = 4;
  public static final String e = "PubAccountArticleCenter.CreateArticleComment";
  public static final int f = 5;
  public static final String f = "PubAccountArticleCenter.GetArticleCommentCount";
  public static final int g = 6;
  public static final String g = "PubAccountArticleCenter.PictureInfo";
  public static final int h = 7;
  public static final String h = "PubAccountArticleCenter.GetRecommendInfo";
  public static final String i = "PubAccountAdSvc.gallery_report";
  public static final String j = "VALUE_ARTICLE_ID";
  public static final String k = "VALUE_ARTICLE_LIKE_COUNT";
  public static final String l = "VALUE_ARTICLE_IS_LIKED";
  public static final String m = "VALUE_ARTICLE_IS_LIKE_SUCCESS";
  public static final String n = "VALUE_ARTICLE_IMAGEE_IS_SUCCESS";
  public static final String o = "VALUE_ARTICLE_COMMENT_COUNT";
  public static final String p = "VALUE_ARTICLE_PUIN";
  public static final String q = "VALUE_ARTICLE_ITEM_COLLECTION_TITLE";
  public static final String r = "VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL";
  public static final String s = "VALUE_ARTICLE_ITEM_URLS";
  public static final String t = "VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS";
  public static final String u = "VALUE_ARTICLE_ITEM_CONTENTS";
  public static final String v = "VALUE_ARTICLE_ITEM_RECOMMEND_URLS";
  public static final String w = "VALUE_ARTICLE_ITEM_RECOMMEND_TITLES";
  public static final String x = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE";
  public static final String y = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID";
  public static final String z = "VALUE_ARTICLE_ITEM_RECOMMEND_CAN";
  private final long a;
  protected Set a;
  
  public PublicAccountArticleHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 30000L;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    boolean bool2;
    ArticleComment.GetArticleLikeCountRespond localGetArticleLikeCountRespond;
    if (paramFromServiceMsg.isSuccess())
    {
      bool2 = true;
      paramFromServiceMsg = new ArticleComment.GetArticleLikeCountRequest();
      localGetArticleLikeCountRespond = new ArticleComment.GetArticleLikeCountRespond();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localGetArticleLikeCountRespond.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (localGetArticleLikeCountRespond.ret.has())
        {
          if ((!localGetArticleLikeCountRespond.ret.ret_code.has()) || (localGetArticleLikeCountRespond.ret.ret_code.get() != 0)) {
            bool1 = false;
          }
        }
        else
        {
          super.a(2, bool1, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleQueryArticleLikeCount() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      if (paramFromServiceMsg.article_id.has()) {
        localBundle.putString("VALUE_ARTICLE_ID", paramFromServiceMsg.article_id.get().toStringUtf8());
      }
      boolean bool1 = bool2;
      if (localGetArticleLikeCountRespond.count.has())
      {
        localBundle.putInt("VALUE_ARTICLE_LIKE_COUNT", localGetArticleLikeCountRespond.count.get());
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    ArticleComment.CheckArticleLikeRespond localCheckArticleLikeRespond;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.CheckArticleLikeRequest();
      localCheckArticleLikeRespond = new ArticleComment.CheckArticleLikeRespond();
    }
    for (;;)
    {
      boolean bool;
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localCheckArticleLikeRespond.mergeFrom((byte[])paramObject);
        if (!localCheckArticleLikeRespond.ret.has()) {
          break label264;
        }
        if ((!localCheckArticleLikeRespond.ret.ret_code.has()) || (localCheckArticleLikeRespond.ret.ret_code.get() != 0))
        {
          bool = false;
          super.a(1, bool, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleCheckIsArticleLiked() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      if (paramFromServiceMsg.article_id.has()) {
        localBundle.putString("VALUE_ARTICLE_ID", paramFromServiceMsg.article_id.get().toStringUtf8());
      }
      if ((localCheckArticleLikeRespond.data.has()) && (localCheckArticleLikeRespond.data.size() > 0) && (((ArticleComment.LikeRet)localCheckArticleLikeRespond.data.get(0)).like.has()))
      {
        if (((ArticleComment.LikeRet)localCheckArticleLikeRespond.data.get(0)).like.get() == 0)
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", false);
          bool = true;
        }
        else
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", true);
        }
      }
      else
      {
        label264:
        bool = true;
        continue;
        bool = false;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    Bundle localBundle = new Bundle();
    ArticleComment.ArticleLikeRespond localArticleLikeRespond;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.ArticleLikeRequest();
      localArticleLikeRespond = new ArticleComment.ArticleLikeRespond();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localArticleLikeRespond.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (localArticleLikeRespond.ret.has())
        {
          if ((localArticleLikeRespond.ret.ret_code.has()) && (localArticleLikeRespond.ret.ret_code.get() != 0)) {
            break label199;
          }
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", true);
          bool1 = bool2;
          if (paramFromServiceMsg.article_id.has())
          {
            localBundle.putString("VALUE_ARTICLE_ID", paramFromServiceMsg.article_id.get().toStringUtf8());
            bool1 = bool2;
          }
        }
        super.a(0, bool1, localBundle);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleSendArticleLikeReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      label199:
      localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", false);
      continue;
      boolean bool1 = false;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    paramToServiceMsg = new Bundle();
    if (paramFromServiceMsg.isSuccess()) {
      paramFromServiceMsg = new ArticleComment.ReportReadPhotoCollectionResponse();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramFromServiceMsg.ret.has())
        {
          if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() == 0))
          {
            paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", true);
            bool1 = bool2;
          }
        }
        else
        {
          super.a(7, bool1, paramToServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleReportReadPhotoCollectionReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
      boolean bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    paramToServiceMsg = new Bundle();
    if (paramFromServiceMsg.isSuccess()) {
      paramFromServiceMsg = new ArticleComment.CreateArticleCommentRespond();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramFromServiceMsg.ret.has())
        {
          if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() == 0))
          {
            paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", true);
            bool1 = bool2;
          }
        }
        else
        {
          super.a(3, bool1, paramToServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleCreateArticleCommentReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
      boolean bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    paramToServiceMsg = new Bundle();
    if (paramFromServiceMsg.isSuccess()) {
      paramFromServiceMsg = new ArticleComment.GetArticleCommentCountRespond();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramFromServiceMsg.ret.has())
        {
          if ((paramFromServiceMsg.ret.ret_code.has()) && (paramFromServiceMsg.ret.ret_code.get() != 0)) {
            break label162;
          }
          paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", true);
          bool1 = bool2;
          if (paramFromServiceMsg.count.has())
          {
            paramToServiceMsg.putInt("VALUE_ARTICLE_COMMENT_COUNT", paramFromServiceMsg.count.get());
            bool1 = bool2;
          }
        }
        super.a(4, bool1, paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetArticleCommentCountReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      label162:
      paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
      continue;
      boolean bool1 = false;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    paramToServiceMsg = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.GetPhotoCollectionInfoResponse();
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramFromServiceMsg.ret.has()) {
            break label421;
          }
          if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() == 0))
          {
            paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", true);
            if (paramFromServiceMsg.article_url.has()) {
              paramToServiceMsg.putString("VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS", paramFromServiceMsg.article_url.get().toStringUtf8());
            }
            if (paramFromServiceMsg.puin.has()) {
              paramToServiceMsg.putLong("VALUE_ARTICLE_PUIN", paramFromServiceMsg.puin.get());
            }
            if (paramFromServiceMsg.article_img_url.has()) {
              paramToServiceMsg.putString("VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL", paramFromServiceMsg.article_img_url.get().toStringUtf8());
            }
            if (paramFromServiceMsg.article_title.has()) {
              paramToServiceMsg.putString("VALUE_ARTICLE_ITEM_COLLECTION_TITLE", paramFromServiceMsg.article_title.get().toStringUtf8());
            }
            if (paramFromServiceMsg.enable_comment.has()) {
              paramToServiceMsg.putInt("VALUE_ARTICLE_ITEM_RECOMMEND_CAN", paramFromServiceMsg.enable_comment.get());
            }
            if (paramFromServiceMsg.comment_url.has()) {
              paramToServiceMsg.putString("VALUE_ARTICLE_ITEM_COMMENT_URL", paramFromServiceMsg.comment_url.get().toStringUtf8());
            }
            if ((!paramFromServiceMsg.item.has()) || (paramFromServiceMsg.item.get().size() <= 0)) {
              break label421;
            }
            int i2 = paramFromServiceMsg.item.get().size();
            paramObject = new ArrayList();
            localArrayList = new ArrayList();
            int i1 = 0;
            if (i1 >= i2) {
              break;
            }
            ((ArrayList)paramObject).add(((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i1)).url.get().toStringUtf8());
            localArrayList.add(((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i1)).content.get().toStringUtf8());
            i1 += 1;
            continue;
          }
          paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetPhotoCollectionInfoReq() ERROR e=" + paramToServiceMsg.getMessage());
          }
          return;
        }
      }
      paramToServiceMsg.putStringArrayList("VALUE_ARTICLE_ITEM_CONTENTS", localArrayList);
      paramToServiceMsg.putStringArrayList("VALUE_ARTICLE_ITEM_URLS", (ArrayList)paramObject);
      label421:
      bool = true;
    }
    super.a(5, bool, paramToServiceMsg);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    paramToServiceMsg = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.GetRecommendInfoResponse();
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      for (;;)
      {
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramFromServiceMsg.ret.has()) {
            break label359;
          }
          if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() == 0))
          {
            paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", true);
            if ((!paramFromServiceMsg.item.has()) || (paramFromServiceMsg.item.get().size() <= 0)) {
              break label359;
            }
            int i2 = paramFromServiceMsg.item.get().size();
            paramObject = new ArrayList();
            localArrayList1 = new ArrayList();
            localArrayList2 = new ArrayList();
            localArrayList3 = new ArrayList();
            int i1 = 0;
            if (i1 >= i2) {
              break;
            }
            ((ArrayList)paramObject).add(((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i1)).url.get().toStringUtf8());
            localArrayList1.add(((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i1)).title.get().toStringUtf8());
            localArrayList2.add(Integer.valueOf(((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i1)).recommend_source.get()));
            localArrayList3.add(((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i1)).article_id.get().toStringUtf8());
            i1 += 1;
            continue;
          }
          paramToServiceMsg.putBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetRecommendInfoReq ERROR e=" + paramToServiceMsg.getMessage());
          }
          return;
        }
      }
      paramToServiceMsg.putStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_TITLES", localArrayList1);
      paramToServiceMsg.putStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_URLS", (ArrayList)paramObject);
      paramToServiceMsg.putIntegerArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE", localArrayList2);
      paramToServiceMsg.putStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID", localArrayList3);
      label359:
      bool = true;
    }
    super.a(6, bool, paramToServiceMsg);
  }
  
  protected Class a()
  {
    return PublicAccountArticleObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "onReceive() getServiceCmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    for (;;)
    {
      return;
      try
      {
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleLikeCount"))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CheckArticleLike"))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike"))
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountAdSvc.gallery_report"))
        {
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CreateArticleComment"))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleCommentCount"))
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.PictureInfo"))
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetRecommendInfo"))
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      }
      catch (Exception paramToServiceMsg) {}
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getArticleCommentCount() articleId = " + paramString);
    }
    ArticleComment.GetArticleCommentCountRequest localGetArticleCommentCountRequest = new ArticleComment.GetArticleCommentCountRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetArticleCommentCountRequest.article_id.set(paramString);
    paramString = a("PubAccountArticleCenter.GetArticleCommentCount");
    paramString.putWupBuffer(localGetArticleCommentCountRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getPhotoCollectionInfo() articleId = " + paramString);
    }
    ArticleComment.GetPhotoCollectionInfoRequest localGetPhotoCollectionInfoRequest = new ArticleComment.GetPhotoCollectionInfoRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetPhotoCollectionInfoRequest.article_id.set(paramString);
    localGetPhotoCollectionInfoRequest.cuin.set(Long.valueOf(b()).longValue());
    localGetPhotoCollectionInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPhotoCollectionInfoRequest.click_source.set(paramInt3);
    localGetPhotoCollectionInfoRequest.recommend_position.set(paramInt2);
    localGetPhotoCollectionInfoRequest.recommend_source.set(paramInt1);
    paramString = a("PubAccountArticleCenter.PictureInfo");
    paramString.putWupBuffer(localGetPhotoCollectionInfoRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.b(paramString);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "reportReadPhotoCollection() articleId = " + paramString);
    }
    ArticleComment.ReportReadPhotoCollectionRequest localReportReadPhotoCollectionRequest = new ArticleComment.ReportReadPhotoCollectionRequest();
    Object localObject = ByteStringMicro.copyFromUtf8(paramString);
    localReportReadPhotoCollectionRequest.article_id.set((ByteStringMicro)localObject);
    localReportReadPhotoCollectionRequest.cuin.set(Long.valueOf(b()).longValue());
    localReportReadPhotoCollectionRequest.versionInfo.set("6.5.5,3,2880");
    localReportReadPhotoCollectionRequest.report_timing_type.set(paramInt);
    if (paramArrayList2.size() > 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      int i1 = 0;
      int i2 = 0;
      if (i2 < paramArrayList1.size())
      {
        int i3 = ((Integer)paramArrayList1.get(i2)).intValue();
        localObject = new ArticleComment.ReadPhotoItemInfo();
        ((ArticleComment.ReadPhotoItemInfo)localObject).index.set(i2 + 1);
        ((ArticleComment.ReadPhotoItemInfo)localObject).item_remain_time.set(i3);
        if ((paramInt != 0) && (i2 == paramArrayList1.size() - 1)) {
          ((ArticleComment.ReadPhotoItemInfo)localObject).item_type.set(2);
        }
        for (;;)
        {
          localReportReadPhotoCollectionRequest.item.add((MessageMicro)localObject);
          i2 += 1;
          i1 += i3;
          break;
          ((ArticleComment.ReadPhotoItemInfo)localObject).item_type.set(1);
        }
      }
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = ByteStringMicro.copyFromUtf8((String)paramArrayList1.next());
        localReportReadPhotoCollectionRequest.recommend_article_id.add(paramArrayList2);
      }
      localReportReadPhotoCollectionRequest.total_remain_time.set(i1);
      paramArrayList1 = a("PubAccountAdSvc.gallery_report");
      paramArrayList1.putWupBuffer(localReportReadPhotoCollectionRequest.toByteArray());
      paramArrayList1.setTimeout(30000L);
      super.b(paramArrayList1);
      long l1 = NetConnInfoCenter.getServerTime();
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006FA2", "0X8006FA2", 0, 0, "" + l1, paramString, "" + i1, "");
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "createArticleComment() articleId = " + paramString1);
    }
    ArticleComment.CreateArticleCommentRequest localCreateArticleCommentRequest = new ArticleComment.CreateArticleCommentRequest();
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localCreateArticleCommentRequest.article_id.set(paramString1);
    paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
    localCreateArticleCommentRequest.comment.set(paramString1);
    localCreateArticleCommentRequest.uin.set(Long.valueOf(b()).longValue());
    localCreateArticleCommentRequest.hide_name.set(paramInt);
    paramString1 = a("PubAccountArticleCenter.CreateArticleComment");
    paramString1.putWupBuffer(localCreateArticleCommentRequest.toByteArray());
    paramString1.setTimeout(30000L);
    super.b(paramString1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ArticleComment.ArticleLikeRequest localArticleLikeRequest = new ArticleComment.ArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localArticleLikeRequest.article_id.set(paramString);
    localArticleLikeRequest.uin.set(Long.valueOf(b()).longValue());
    if (paramBoolean) {
      localArticleLikeRequest.like.set(1);
    }
    for (;;)
    {
      paramString = a("PubAccountArticleCenter.ArticleLike");
      paramString.putWupBuffer(localArticleLikeRequest.toByteArray());
      paramString.setTimeout(30000L);
      super.b(paramString);
      return;
      localArticleLikeRequest.like.set(0);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.ArticleLike");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.CheckArticleLike");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetArticleLikeCount");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.CreateArticleComment");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetArticleCommentCount");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.PictureInfo");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetRecommendInfo");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountAdSvc.gallery_report");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getRecommendInfo() articleId = " + paramString);
    }
    ArticleComment.GetRecommendInfoRequest localGetRecommendInfoRequest = new ArticleComment.GetRecommendInfoRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetRecommendInfoRequest.article_id.set(paramString);
    localGetRecommendInfoRequest.cuin.set(Long.valueOf(b()).longValue());
    localGetRecommendInfoRequest.versionInfo.set("6.5.5,3,2880");
    paramString = a("PubAccountArticleCenter.GetRecommendInfo");
    paramString.putWupBuffer(localGetRecommendInfoRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.b(paramString);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "queryArticleLikeCount() articleId = " + paramString);
    }
    ArticleComment.GetArticleLikeCountRequest localGetArticleLikeCountRequest = new ArticleComment.GetArticleLikeCountRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetArticleLikeCountRequest.article_id.set(paramString);
    paramString = a("PubAccountArticleCenter.GetArticleLikeCount");
    paramString.putWupBuffer(localGetArticleLikeCountRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.b(paramString);
  }
  
  public void d(String paramString)
  {
    ArticleComment.CheckArticleLikeRequest localCheckArticleLikeRequest = new ArticleComment.CheckArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localCheckArticleLikeRequest.article_id.set(paramString);
    localCheckArticleLikeRequest.uins.add(Long.valueOf(b()));
    paramString = a("PubAccountArticleCenter.CheckArticleLike");
    paramString.putWupBuffer(localCheckArticleLikeRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountArticleHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
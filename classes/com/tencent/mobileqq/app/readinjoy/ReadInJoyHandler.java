package com.tencent.mobileqq.app.readinjoy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.ReadInJoyRemoteCommand;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.ChannelNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.CommentFeeds;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.DeleteComment;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.DeleteFeeds;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.LikeFeeds;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.PublishFeeds;
import tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.RedSpotNotifyBody;

public class ReadInJoyHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  ReadInJoyRemoteCommand jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand = null;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReadInJoyHandler.class.getSimpleName();
  }
  
  public ReadInJoyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(SubMsgType0x8d.RedSpotNotifyBody paramRedSpotNotifyBody)
  {
    if (paramRedSpotNotifyBody == null) {}
    while ((!paramRedSpotNotifyBody.bytes_guide_wording.has()) || (paramRedSpotNotifyBody.bytes_guide_wording.get() == null)) {
      return null;
    }
    return paramRedSpotNotifyBody.bytes_guide_wording.get().toStringUtf8();
  }
  
  private List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = (SubMsgType0x8d.NotifyBody)paramList.next();
      ReadInJoyFeedsMsgRecord localReadInJoyFeedsMsgRecord = new ReadInJoyFeedsMsgRecord();
      if (((SubMsgType0x8d.NotifyBody)localObject).uint32_push_time.has()) {
        localReadInJoyFeedsMsgRecord.jdField_g_of_type_Int = ((SubMsgType0x8d.NotifyBody)localObject).uint32_push_time.get();
      }
      if (((SubMsgType0x8d.NotifyBody)localObject).uint32_seq.has()) {
        localReadInJoyFeedsMsgRecord.h = ((SubMsgType0x8d.NotifyBody)localObject).uint32_seq.get();
      }
      if ((((SubMsgType0x8d.NotifyBody)localObject).msg_publish_feeds.has()) && (((SubMsgType0x8d.NotifyBody)localObject).msg_publish_feeds.get() != null))
      {
        localReadInJoyFeedsMsgRecord.i = 10;
        localObject = (SubMsgType0x8d.PublishFeeds)((SubMsgType0x8d.NotifyBody)localObject).msg_publish_feeds.get();
        if (((SubMsgType0x8d.PublishFeeds)localObject).uint64_feeds_owner.has()) {
          localReadInJoyFeedsMsgRecord.jdField_a_of_type_Long = ((SubMsgType0x8d.PublishFeeds)localObject).uint64_feeds_owner.get();
        }
        if (((SubMsgType0x8d.PublishFeeds)localObject).uint64_feeds_id.has()) {
          localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long = ((SubMsgType0x8d.PublishFeeds)localObject).uint64_feeds_id.get();
        }
      }
      for (;;)
      {
        localReadInJoyFeedsMsgRecord.jdField_g_of_type_Long = NetConnInfoCenter.getServerTime();
        localArrayList.add(localReadInJoyFeedsMsgRecord);
        break;
        if ((((SubMsgType0x8d.NotifyBody)localObject).msg_comment_feeds.has()) && (((SubMsgType0x8d.NotifyBody)localObject).msg_comment_feeds.get() != null))
        {
          localReadInJoyFeedsMsgRecord.i = 11;
          localObject = (SubMsgType0x8d.CommentFeeds)((SubMsgType0x8d.NotifyBody)localObject).msg_comment_feeds.get();
          if (((SubMsgType0x8d.CommentFeeds)localObject).uint64_feeds_owner.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_Long = ((SubMsgType0x8d.CommentFeeds)localObject).uint64_feeds_owner.get();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).uint64_feeds_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long = ((SubMsgType0x8d.CommentFeeds)localObject).uint64_feeds_id.get();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).uint64_comment_uin.has()) {
            localReadInJoyFeedsMsgRecord.jdField_c_of_type_Long = ((SubMsgType0x8d.CommentFeeds)localObject).uint64_comment_uin.get();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).bytes_comment_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString = ((SubMsgType0x8d.CommentFeeds)localObject).bytes_comment_id.get().toStringUtf8();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).uint64_reply_uin.has()) {
            localReadInJoyFeedsMsgRecord.jdField_d_of_type_Long = ((SubMsgType0x8d.CommentFeeds)localObject).uint64_reply_uin.get();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).bytes_reply_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_c_of_type_JavaLangString = ((SubMsgType0x8d.CommentFeeds)localObject).bytes_reply_id.get().toStringUtf8();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).bytes_comment_info.has()) {
            localReadInJoyFeedsMsgRecord.jdField_d_of_type_JavaLangString = ((SubMsgType0x8d.CommentFeeds)localObject).bytes_comment_info.get().toStringUtf8();
          }
          if (((SubMsgType0x8d.CommentFeeds)localObject).bytes_feeds_subject.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_JavaLangString = ((SubMsgType0x8d.CommentFeeds)localObject).bytes_feeds_subject.get().toStringUtf8();
          }
        }
        else if ((((SubMsgType0x8d.NotifyBody)localObject).msg_like_feeds.has()) && (((SubMsgType0x8d.NotifyBody)localObject).msg_like_feeds.get() != null))
        {
          localReadInJoyFeedsMsgRecord.i = 12;
          localObject = (SubMsgType0x8d.LikeFeeds)((SubMsgType0x8d.NotifyBody)localObject).msg_like_feeds.get();
          if (((SubMsgType0x8d.LikeFeeds)localObject).uint64_feeds_owner.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_Long = ((SubMsgType0x8d.LikeFeeds)localObject).uint64_feeds_owner.get();
          }
          if (((SubMsgType0x8d.LikeFeeds)localObject).uint64_feeds_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long = ((SubMsgType0x8d.LikeFeeds)localObject).uint64_feeds_id.get();
          }
          if (((SubMsgType0x8d.LikeFeeds)localObject).uint64_like_uin.has()) {
            localReadInJoyFeedsMsgRecord.e = ((SubMsgType0x8d.LikeFeeds)localObject).uint64_like_uin.get();
          }
          if (((SubMsgType0x8d.LikeFeeds)localObject).bytes_feeds_subject.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_JavaLangString = ((SubMsgType0x8d.LikeFeeds)localObject).bytes_feeds_subject.get().toStringUtf8();
          }
        }
        else if ((((SubMsgType0x8d.NotifyBody)localObject).msg_delete_feeds.has()) && (((SubMsgType0x8d.NotifyBody)localObject).msg_delete_feeds.get() != null))
        {
          localReadInJoyFeedsMsgRecord.i = 13;
          localObject = (SubMsgType0x8d.DeleteFeeds)((SubMsgType0x8d.NotifyBody)localObject).msg_delete_feeds.get();
          if (((SubMsgType0x8d.DeleteFeeds)localObject).uint64_feeds_owner.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_Long = ((SubMsgType0x8d.DeleteFeeds)localObject).uint64_feeds_owner.get();
          }
          if (((SubMsgType0x8d.DeleteFeeds)localObject).uint64_feeds_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long = ((SubMsgType0x8d.DeleteFeeds)localObject).uint64_feeds_id.get();
          }
          if (((SubMsgType0x8d.DeleteFeeds)localObject).uint64_delete_uin.has()) {
            localReadInJoyFeedsMsgRecord.f = ((SubMsgType0x8d.DeleteFeeds)localObject).uint64_delete_uin.get();
          }
        }
        else if ((((SubMsgType0x8d.NotifyBody)localObject).msg_delete_comment.has()) && (((SubMsgType0x8d.NotifyBody)localObject).msg_delete_comment.get() != null))
        {
          localReadInJoyFeedsMsgRecord.i = 14;
          localObject = (SubMsgType0x8d.DeleteComment)((SubMsgType0x8d.NotifyBody)localObject).msg_delete_comment.get();
          if (((SubMsgType0x8d.DeleteComment)localObject).uint64_feeds_owner.has()) {
            localReadInJoyFeedsMsgRecord.jdField_a_of_type_Long = ((SubMsgType0x8d.DeleteComment)localObject).uint64_feeds_owner.get();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).uint64_feeds_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long = ((SubMsgType0x8d.DeleteComment)localObject).uint64_feeds_id.get();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).uint64_comment_uin.has()) {
            localReadInJoyFeedsMsgRecord.jdField_c_of_type_Long = ((SubMsgType0x8d.DeleteComment)localObject).uint64_comment_uin.get();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).bytes_comment_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString = ((SubMsgType0x8d.DeleteComment)localObject).bytes_comment_id.get().toStringUtf8();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).uint64_reply_uin.has()) {
            localReadInJoyFeedsMsgRecord.jdField_d_of_type_Long = ((SubMsgType0x8d.DeleteComment)localObject).uint64_reply_uin.get();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).bytes_reply_id.has()) {
            localReadInJoyFeedsMsgRecord.jdField_c_of_type_JavaLangString = ((SubMsgType0x8d.DeleteComment)localObject).bytes_reply_id.get().toStringUtf8();
          }
          if (((SubMsgType0x8d.DeleteComment)localObject).uint64_delete_uin.has()) {
            localReadInJoyFeedsMsgRecord.f = ((SubMsgType0x8d.DeleteComment)localObject).uint64_delete_uin.get();
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List a(SubMsgType0x8d.RedSpotNotifyBody paramRedSpotNotifyBody)
  {
    if (paramRedSpotNotifyBody == null) {}
    while ((!paramRedSpotNotifyBody.rpt_new_channel_list.has()) || (paramRedSpotNotifyBody.rpt_new_channel_list.get() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(10);
    paramRedSpotNotifyBody = paramRedSpotNotifyBody.rpt_new_channel_list.get().iterator();
    while (paramRedSpotNotifyBody.hasNext()) {
      localArrayList.add(Integer.valueOf((int)((Long)paramRedSpotNotifyBody.next()).longValue()));
    }
    return localArrayList;
  }
  
  private void a(SubMsgType0x8d.RedSpotNotifyBody paramRedSpotNotifyBody)
  {
    if ((!paramRedSpotNotifyBody.msg_channel_notify.has()) || (paramRedSpotNotifyBody.msg_channel_notify.get() == null)) {
      return;
    }
    long l = 0L;
    Object localObject1 = "推荐";
    Object localObject2 = "";
    ArrayList localArrayList = new ArrayList();
    SubMsgType0x8d.ChannelNotify localChannelNotify = (SubMsgType0x8d.ChannelNotify)paramRedSpotNotifyBody.msg_channel_notify.get();
    if (localChannelNotify.uint64_channel_id.has()) {
      l = localChannelNotify.uint64_channel_id.get();
    }
    paramRedSpotNotifyBody = (SubMsgType0x8d.RedSpotNotifyBody)localObject1;
    if (localChannelNotify.bytes_channel_name.has())
    {
      paramRedSpotNotifyBody = (SubMsgType0x8d.RedSpotNotifyBody)localObject1;
      if (localChannelNotify.bytes_channel_name.get() != null) {
        paramRedSpotNotifyBody = localChannelNotify.bytes_channel_name.get().toStringUtf8();
      }
    }
    localObject1 = localObject2;
    if (localChannelNotify.bytes_wording.has())
    {
      localObject1 = localObject2;
      if (localChannelNotify.bytes_wording.get() != null) {
        localObject1 = localChannelNotify.bytes_wording.get().toStringUtf8();
      }
    }
    if ((localChannelNotify.rpt_top_article_id_list.has()) && (localChannelNotify.rpt_top_article_id_list.get() != null))
    {
      localObject2 = localChannelNotify.rpt_top_article_id_list.get().iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(Long.valueOf(((Long)((Iterator)localObject2).next()).longValue()));
      }
    }
    ((ReadInJoyManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(l, paramRedSpotNotifyBody, (String)localObject1, localArrayList);
  }
  
  protected Class a()
  {
    return ReadInJoyObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand == null)
    {
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand = new ReadInJoyRemoteCommand(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand.a();
      return;
    }
    this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "readInJoyFeedsMsgNotify, isSuccess=" + paramBoolean1 + ",isNewMsgCome=" + paramBoolean2 + ",reason=" + paramInt);
    }
    a(1, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleOnlinePushReadInJoyFeedsMsg");
    }
    if (!ReadInJoyHelper.a()) {}
    do
    {
      for (;;)
      {
        return;
        if (paramArrayOfByte != null)
        {
          Object localObject = new SubMsgType0x8d.MsgBody();
          try
          {
            ((SubMsgType0x8d.MsgBody)localObject).mergeFrom(paramArrayOfByte);
            paramArrayOfByte = (ReadInJoyManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95);
            if ((((SubMsgType0x8d.MsgBody)localObject).rpt_msg_notify_infos.has()) && (((SubMsgType0x8d.MsgBody)localObject).rpt_msg_notify_infos.get() != null)) {
              paramArrayOfByte.a(a(((SubMsgType0x8d.MsgBody)localObject).rpt_msg_notify_infos.get()));
            }
            if ((((SubMsgType0x8d.MsgBody)localObject).red_spot_notify_body.has()) && (((SubMsgType0x8d.MsgBody)localObject).red_spot_notify_body.get() != null))
            {
              localObject = (SubMsgType0x8d.RedSpotNotifyBody)((SubMsgType0x8d.MsgBody)localObject).red_spot_notify_body.get();
              paramArrayOfByte.b(a((SubMsgType0x8d.RedSpotNotifyBody)localObject));
              paramArrayOfByte.a(a((SubMsgType0x8d.RedSpotNotifyBody)localObject));
              a((SubMsgType0x8d.RedSpotNotifyBody)localObject);
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handleOnlinePushReadInJoyFeedsMsg, parse error, exception: " + paramArrayOfByte.getMessage());
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null) {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand != null)
    {
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand.b();
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand = null;
    }
  }
  
  public void g()
  {
    b();
    super.g();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\readinjoy\ReadInJoyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
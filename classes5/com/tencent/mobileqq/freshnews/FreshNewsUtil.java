package com.tencent.mobileqq.freshnews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import appoint.define.appoint_define.ADFeed;
import appoint.define.appoint_define.ADFeedContent;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.FeedComment;
import appoint.define.appoint_define.FeedContent;
import appoint.define.appoint_define.FeedEvent;
import appoint.define.appoint_define.FeedInfo;
import appoint.define.appoint_define.HotTopic;
import appoint.define.appoint_define.HotTopicList;
import appoint.define.appoint_define.NearbyTopic;
import appoint.define.appoint_define.PublisherInfo;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import appoint.define.appoint_define.UserFeed;
import appoint.define.appoint_define.UserInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.freshnews.ad.UserInfo;
import com.tencent.mobileqq.freshnews.hotchat.HotchatFeedInfo;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FreshNewsUtil
{
  private static final long a = 60000L;
  public static final String a = "FreshNewsUtil";
  private static final long b = 3600000L;
  private static final long c = 86400000L;
  private static final long d = 31536000000L;
  
  public FreshNewsUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static appoint_define.FeedComment a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((paramBoolean) && ((paramLong == 0L) || (TextUtils.isEmpty(paramString3))))) {
      paramString1 = null;
    }
    appoint_define.FeedComment localFeedComment;
    do
    {
      return paramString1;
      localFeedComment = new appoint_define.FeedComment();
      localFeedComment.str_feed_id.set(paramString1);
      localFeedComment.uint32_time.set(paramInt);
      paramString1 = FreshNewsComment.a(paramString2);
      localFeedComment.msg_content.set(paramString1);
      paramString1 = localFeedComment;
    } while (!paramBoolean);
    paramString1 = new appoint_define.ReplyInfo();
    paramString1.str_comment_id.set(paramString3);
    paramString2 = new appoint_define.StrangerInfo();
    paramString2.uint64_tinyid.set(paramLong);
    paramString1.msg_stranger_info.set(paramString2);
    localFeedComment.msg_reply_info.set(paramString1);
    return localFeedComment;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    if (paramInt < 9999) {
      return String.valueOf(paramInt);
    }
    double d1 = paramInt / 1000 / 10.0D;
    return String.valueOf(d1) + "万";
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    return a(Long.valueOf(paramInt), paramBoolean);
  }
  
  public static String a(Activity paramActivity, int paramInt, Fragment paramFragment)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    if (!Utils.b())
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131368967), 0).a();
      return null;
    }
    Object localObject = new File(AppConstants.bt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localObject = PlusPanelUtils.a();
    if (QLog.isDevelopLevel()) {
      QLog.i("FreshNewsUtil", 4, "mCameraPhotoPath=" + (String)localObject);
    }
    localIntent.putExtra("output", Uri.fromFile(new File((String)localObject)));
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    if (paramFragment != null) {
      try
      {
        paramFragment.startActivityForResult(localIntent, paramInt);
        return (String)localObject;
      }
      catch (Exception paramFragment)
      {
        paramFragment.printStackTrace();
        QQToast.a(paramActivity, 2131368990, 0).a();
        return (String)localObject;
      }
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    return (String)localObject;
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {}
    for (paramRichText = paramRichText.rpt_msg_elems.get(); (paramRichText == null) || (paramRichText.isEmpty()); paramRichText = null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRichText.iterator();
    label102:
    label129:
    label194:
    label197:
    label199:
    label203:
    while (localIterator.hasNext())
    {
      appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
      if (localElem != null)
      {
        if (localElem.str_content.has())
        {
          paramRichText = localElem.str_content.get();
          localStringBuilder.append(paramRichText);
          if (!localElem.msg_face_info.has()) {
            break label194;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label197;
          }
          if (!paramRichText.uint32_index.has()) {
            break label199;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if ((i < 0) || (i >= MessageUtils.b.length)) {
            break label203;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)MessageUtils.b[i]);
          break;
          paramRichText = "";
          break label102;
          paramRichText = null;
          break label129;
          break;
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FreshNewsUtil", 4, "getStringFromRichText, result=" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong.longValue() * 1000L;
    long l2 = System.currentTimeMillis() - l1;
    paramLong = Calendar.getInstance();
    paramLong.setTimeInMillis(l1);
    if (l2 < 60000L)
    {
      if (paramBoolean) {
        return "刚刚";
      }
      return "now";
    }
    if (l2 < 3600000L)
    {
      l1 = l2 / 60000L;
      if (paramBoolean) {}
      for (paramLong = "分钟前";; paramLong = "min ago") {
        return l1 + paramLong;
      }
    }
    if (l2 < 86400000L)
    {
      l1 = l2 / 3600000L;
      if (paramBoolean) {}
      for (;;)
      {
        return l1 + "小时前";
      }
    }
    if (l2 < 172800000L)
    {
      if (paramBoolean) {
        return "昨天";
      }
      return "yesterday";
    }
    if (l2 < 31536000000L) {
      return new SimpleDateFormat("MM-dd").format(paramLong.getTime());
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(paramLong.getTime());
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("album_enter_directly", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.startActivity(localIntent);
    AlbumUtil.a(paramActivity, true, true);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramContext, paramLong, paramString, paramInt1, paramInt2, paramInt3, -1);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(0), 79);
    localAllInOne.h = paramString;
    localAllInOne.b = paramInt1;
    localAllInOne.a = ((byte)paramInt2);
    localAllInOne.g = paramInt3;
    paramString = new Intent(paramContext, NearbyPeopleProfileActivity.class);
    paramString.putExtra("AllInOne", localAllInOne);
    paramString.putExtra("param_mode", 3);
    paramString.putExtra("param_tiny_id", paramLong);
    if ((paramInt4 > 0) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).startActivityForResult(paramString, paramInt4);
    }
    for (;;)
    {
      ((AppInterface)BaseApplicationImpl.a().a().getAppRuntime("module_nearby")).a("CliOper", "", "", "0X8005CA9", "0X8005CA9", 0, 0, "", "", "", "");
      return;
      paramContext.startActivity(paramString);
    }
  }
  
  public static void a(Context paramContext, View paramView)
  {
    View localView = (View)paramView.getParent();
    if (localView != null)
    {
      int i = paramView.getTop();
      int j = paramView.getLeft();
      int k = paramView.getRight();
      int m = paramView.getBottom();
      localView.setTouchDelegate(new TouchDelegate(new Rect(j - AIOUtils.a(20.0F, paramContext.getResources()), i - AIOUtils.a(20.0F, paramContext.getResources()), k + AIOUtils.a(20.0F, paramContext.getResources()), m + AIOUtils.a(20.0F, paramContext.getResources())), paramView));
    }
  }
  
  public static void a(Context paramContext, FreshNewsInfo paramFreshNewsInfo, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, FreshNewsDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("FreshNewsInfo", paramFreshNewsInfo);
    localBundle.putInt("from", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(FreshNewsInfo paramFreshNewsInfo, appoint_define.FeedInfo paramFeedInfo, appoint_define.PublisherInfo paramPublisherInfo, int paramInt)
  {
    long l2 = 0L;
    boolean bool2 = true;
    int i = 0;
    Object localObject1;
    if ((paramFreshNewsInfo == null) || (paramFeedInfo == null) || (paramPublisherInfo == null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("updateUserFeed: freshNewsInfo, feedInfo, publisherInfo ==null?");
        if (paramFreshNewsInfo != null) {
          break label107;
        }
        bool1 = true;
        paramFreshNewsInfo = ((StringBuilder)localObject1).append(bool1).append(",");
        if (paramFeedInfo != null) {
          break label113;
        }
        bool1 = true;
        label70:
        paramFreshNewsInfo = paramFreshNewsInfo.append(bool1).append(",");
        if (paramPublisherInfo != null) {
          break label119;
        }
      }
      label107:
      label113:
      label119:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.d("FreshNewsUtil", 2, bool1);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label70;
      }
    }
    label136:
    label160:
    long l1;
    if (paramInt == 10)
    {
      paramFreshNewsInfo.ownerFlag = 1;
      paramFreshNewsInfo.publishState = 1;
      if (!paramFeedInfo.str_feed_id.has()) {
        break label895;
      }
      localObject1 = paramFeedInfo.str_feed_id.get();
      paramFreshNewsInfo.feedId = ((String)localObject1);
      if (!paramFeedInfo.uint64_feed_type.has()) {
        break label902;
      }
      l1 = paramFeedInfo.uint64_feed_type.get();
      label185:
      paramFreshNewsInfo.feedType = l1;
      if (!paramFeedInfo.uint32_publish_time.has()) {
        break label908;
      }
      l1 = paramFeedInfo.uint32_publish_time.get();
      label210:
      paramFreshNewsInfo.publishTime = l1;
      if (!paramFeedInfo.uint32_praise_count.has()) {
        break label914;
      }
      paramInt = paramFeedInfo.uint32_praise_count.get();
      label234:
      paramFreshNewsInfo.praiseCount = paramInt;
      if (!paramFeedInfo.uint32_praise_flag.has()) {
        break label919;
      }
      paramInt = paramFeedInfo.uint32_praise_flag.get();
      label257:
      paramFreshNewsInfo.praiseFlag = paramInt;
      if (!paramFeedInfo.uint32_comment_count.has()) {
        break label924;
      }
      paramInt = paramFeedInfo.uint32_comment_count.get();
      label280:
      paramFreshNewsInfo.commentCount = paramInt;
      if (paramFeedInfo.msg_feed_content.has())
      {
        localObject1 = (appoint_define.FeedContent)paramFeedInfo.msg_feed_content.get();
        if (((appoint_define.FeedContent)localObject1).msg_text.has()) {
          paramFreshNewsInfo.feedContent = a((appoint_define.RichText)((appoint_define.FeedContent)localObject1).msg_text.get());
        }
        if (((appoint_define.FeedContent)localObject1).rpt_str_pic_url.has())
        {
          localObject1 = ((appoint_define.FeedContent)localObject1).rpt_str_pic_url.get();
          paramFreshNewsInfo.photoUrls.addAll((Collection)localObject1);
        }
      }
      if (paramFeedInfo.rpt_msg_comment_list.has()) {
        paramFreshNewsInfo.commentList = FreshNewsComment.a(paramFeedInfo.rpt_msg_comment_list.get());
      }
      if (!paramFeedInfo.uint32_hot_flag.has()) {
        break label929;
      }
      paramInt = paramFeedInfo.uint32_hot_flag.get();
      label411:
      paramFreshNewsInfo.hotFlag = paramInt;
      if (paramFeedInfo.msg_topic_info.has()) {
        paramFreshNewsInfo.topicInfo = TopicInfo.a((appoint_define.NearbyTopic)paramFeedInfo.msg_topic_info.get());
      }
      l1 = l2;
      if (paramPublisherInfo.uint64_tinyid.has()) {
        l1 = paramPublisherInfo.uint64_tinyid.get();
      }
      paramFreshNewsInfo.publisherID = l1;
      if (!paramPublisherInfo.bytes_nickname.has()) {
        break label934;
      }
      localObject1 = paramPublisherInfo.bytes_nickname.get().toStringUtf8();
      label494:
      paramFreshNewsInfo.publisherNickname = ((String)localObject1);
      if (!paramPublisherInfo.uint32_age.has()) {
        break label941;
      }
      paramInt = paramPublisherInfo.uint32_age.get();
      label518:
      paramFreshNewsInfo.publisherAge = paramInt;
      if (!paramPublisherInfo.uint32_gender.has()) {
        break label946;
      }
      paramInt = paramPublisherInfo.uint32_gender.get();
      label541:
      paramFreshNewsInfo.publisherGender = paramInt;
      if (!paramPublisherInfo.str_constellation.has()) {
        break label951;
      }
      localObject1 = paramPublisherInfo.str_constellation.get();
      label565:
      paramFreshNewsInfo.publisherConstellation = ((String)localObject1);
      if (!paramPublisherInfo.uint32_profession.has()) {
        break label958;
      }
      paramInt = paramPublisherInfo.uint32_profession.get();
      label589:
      paramFreshNewsInfo.publisherProfession = paramInt;
      if (!paramPublisherInfo.str_distance.has()) {
        break label963;
      }
      localObject1 = paramPublisherInfo.str_distance.get();
      label613:
      paramFreshNewsInfo.publisherDistance = ((String)localObject1);
      if (!paramPublisherInfo.uint32_marriage.has()) {
        break label970;
      }
      paramInt = paramPublisherInfo.uint32_marriage.get();
      label637:
      paramFreshNewsInfo.publisherMaritalStatus = paramInt;
      if (!paramPublisherInfo.str_vipinfo.has()) {
        break label975;
      }
      localObject1 = paramPublisherInfo.str_vipinfo.get();
      label661:
      paramFreshNewsInfo.publisherVip = ((String)localObject1);
      if (paramPublisherInfo.msg_common_label.has())
      {
        localObject2 = (appoint_define.CommonLabel)paramPublisherInfo.msg_common_label.get();
        paramInt = i;
        if (((appoint_define.CommonLabel)localObject2).uint32_lable_id.has()) {
          paramInt = ((appoint_define.CommonLabel)localObject2).uint32_lable_id.get();
        }
        paramFreshNewsInfo.commonId = paramInt;
        if (!((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.has()) {
          break label982;
        }
        localObject1 = new String(((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.get().toByteArray());
        label748:
        if (!((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.has()) {
          break label989;
        }
      }
    }
    label895:
    label902:
    label908:
    label914:
    label919:
    label924:
    label929:
    label934:
    label941:
    label946:
    label951:
    label958:
    label963:
    label970:
    label975:
    label982:
    label989:
    for (Object localObject2 = new String(((appoint_define.CommonLabel)localObject2).bytes_lable_msg_last.get().toByteArray());; localObject2 = "")
    {
      paramFreshNewsInfo.common = ((String)localObject1 + (String)localObject2);
      if (paramPublisherInfo.uint32_pub_number.has()) {
        paramFreshNewsInfo.isPubNumber = paramPublisherInfo.uint32_pub_number.get();
      }
      paramFreshNewsInfo.strTimeDistance = (a(Long.valueOf(paramFreshNewsInfo.publishTime), true) + " " + paramFreshNewsInfo.publisherDistance);
      paramFreshNewsInfo.whichPage = 3;
      if (paramFreshNewsInfo.feedType != 8L) {
        break;
      }
      HotchatFeedInfo.a(paramFreshNewsInfo, paramFeedInfo);
      return;
      paramFreshNewsInfo.ownerFlag = 0;
      break label136;
      localObject1 = "";
      break label160;
      l1 = 0L;
      break label185;
      l1 = 0L;
      break label210;
      paramInt = 0;
      break label234;
      paramInt = 0;
      break label257;
      paramInt = 0;
      break label280;
      paramInt = 0;
      break label411;
      localObject1 = "";
      break label494;
      paramInt = 0;
      break label518;
      paramInt = -1;
      break label541;
      localObject1 = "";
      break label565;
      paramInt = 0;
      break label589;
      localObject1 = "";
      break label613;
      paramInt = 0;
      break label637;
      localObject1 = "";
      break label661;
      localObject1 = "";
      break label748;
    }
  }
  
  public static void a(FreshNewsInfo paramFreshNewsInfo, appoint_define.UserFeed paramUserFeed)
  {
    long l2 = 0L;
    int j = 0;
    if ((paramFreshNewsInfo == null) || (paramUserFeed == null)) {
      return;
    }
    paramFreshNewsInfo.publishState = 1;
    int i;
    Object localObject3;
    long l1;
    label88:
    Object localObject1;
    label117:
    label143:
    label170:
    label196:
    label222:
    label248:
    label274:
    label300:
    label326:
    label353:
    Object localObject2;
    if (paramUserFeed.uint32_owner_flag.has())
    {
      i = paramUserFeed.uint32_owner_flag.get();
      paramFreshNewsInfo.ownerFlag = i;
      if (paramUserFeed.msg_user_info.has())
      {
        localObject3 = (appoint_define.PublisherInfo)paramUserFeed.msg_user_info.get();
        if (!((appoint_define.PublisherInfo)localObject3).uint64_tinyid.has()) {
          break label1038;
        }
        l1 = ((appoint_define.PublisherInfo)localObject3).uint64_tinyid.get();
        paramFreshNewsInfo.publisherID = l1;
        if (!((appoint_define.PublisherInfo)localObject3).bytes_nickname.has()) {
          break label1044;
        }
        localObject1 = ((appoint_define.PublisherInfo)localObject3).bytes_nickname.get().toStringUtf8();
        paramFreshNewsInfo.publisherNickname = ((String)localObject1);
        if (!((appoint_define.PublisherInfo)localObject3).uint32_age.has()) {
          break label1049;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_age.get();
        paramFreshNewsInfo.publisherAge = i;
        if (!((appoint_define.PublisherInfo)localObject3).uint32_gender.has()) {
          break label1055;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_gender.get();
        paramFreshNewsInfo.publisherGender = i;
        if (!((appoint_define.PublisherInfo)localObject3).str_constellation.has()) {
          break label1061;
        }
        localObject1 = ((appoint_define.PublisherInfo)localObject3).str_constellation.get();
        paramFreshNewsInfo.publisherConstellation = ((String)localObject1);
        if (!((appoint_define.PublisherInfo)localObject3).uint32_profession.has()) {
          break label1067;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_profession.get();
        paramFreshNewsInfo.publisherProfession = i;
        if (!((appoint_define.PublisherInfo)localObject3).str_distance.has()) {
          break label1073;
        }
        localObject1 = ((appoint_define.PublisherInfo)localObject3).str_distance.get();
        paramFreshNewsInfo.publisherDistance = ((String)localObject1);
        if (!((appoint_define.PublisherInfo)localObject3).uint32_marriage.has()) {
          break label1079;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_marriage.get();
        paramFreshNewsInfo.publisherMaritalStatus = i;
        if (!((appoint_define.PublisherInfo)localObject3).str_vipinfo.has()) {
          break label1085;
        }
        localObject1 = ((appoint_define.PublisherInfo)localObject3).str_vipinfo.get();
        paramFreshNewsInfo.publisherVip = ((String)localObject1);
        if (!((appoint_define.PublisherInfo)localObject3).uint32_charm.has()) {
          break label1091;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_charm.get();
        paramFreshNewsInfo.publisherCharm = i;
        if (!((appoint_define.PublisherInfo)localObject3).uint32_charm_level.has()) {
          break label1097;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_charm_level.get();
        paramFreshNewsInfo.publisherCharmLevel = i;
        if (((appoint_define.PublisherInfo)localObject3).msg_common_label.has())
        {
          localObject2 = (appoint_define.CommonLabel)((appoint_define.PublisherInfo)localObject3).msg_common_label.get();
          if (!((appoint_define.CommonLabel)localObject2).uint32_lable_id.has()) {
            break label1103;
          }
          i = ((appoint_define.CommonLabel)localObject2).uint32_lable_id.get();
          label401:
          paramFreshNewsInfo.commonId = i;
          if (!((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.has()) {
            break label1109;
          }
          localObject1 = new String(((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.get().toByteArray());
          label435:
          if (!((appoint_define.CommonLabel)localObject2).bytes_lable_msg_pre.has()) {
            break label1115;
          }
          localObject2 = new String(((appoint_define.CommonLabel)localObject2).bytes_lable_msg_last.get().toByteArray());
          label463:
          paramFreshNewsInfo.common = ((String)localObject1 + (String)localObject2);
        }
        if (!((appoint_define.PublisherInfo)localObject3).uint32_pub_number.has()) {
          break label1121;
        }
        i = ((appoint_define.PublisherInfo)localObject3).uint32_pub_number.get();
        label506:
        paramFreshNewsInfo.isPubNumber = i;
      }
      if (!paramUserFeed.msg_feed_info.has()) {
        break label1400;
      }
      localObject2 = (appoint_define.FeedInfo)paramUserFeed.msg_feed_info.get();
      if (!((appoint_define.FeedInfo)localObject2).str_feed_id.has()) {
        break label1127;
      }
      localObject1 = ((appoint_define.FeedInfo)localObject2).str_feed_id.get();
      label551:
      paramFreshNewsInfo.feedId = ((String)localObject1);
      if (!((appoint_define.FeedInfo)localObject2).uint64_feed_type.has()) {
        break label1133;
      }
      l1 = ((appoint_define.FeedInfo)localObject2).uint64_feed_type.get();
      label575:
      paramFreshNewsInfo.feedType = l1;
      if (!((appoint_define.FeedInfo)localObject2).uint32_publish_time.has()) {
        break label1139;
      }
      l1 = ((appoint_define.FeedInfo)localObject2).uint32_publish_time.get();
      label600:
      paramFreshNewsInfo.publishTime = l1;
      if (!((appoint_define.FeedInfo)localObject2).uint32_praise_count.has()) {
        break label1145;
      }
      i = ((appoint_define.FeedInfo)localObject2).uint32_praise_count.get();
      label625:
      paramFreshNewsInfo.praiseCount = i;
      if (!((appoint_define.FeedInfo)localObject2).uint32_praise_flag.has()) {
        break label1151;
      }
      i = ((appoint_define.FeedInfo)localObject2).uint32_praise_flag.get();
      label650:
      paramFreshNewsInfo.praiseFlag = i;
      if (!((appoint_define.FeedInfo)localObject2).uint32_comment_count.has()) {
        break label1157;
      }
      i = ((appoint_define.FeedInfo)localObject2).uint32_comment_count.get();
      label675:
      paramFreshNewsInfo.commentCount = i;
      if (!((appoint_define.FeedInfo)localObject2).uint32_hot_flag.has()) {
        break label1163;
      }
      i = ((appoint_define.FeedInfo)localObject2).uint32_hot_flag.get();
      label700:
      paramFreshNewsInfo.hotFlag = i;
      if (!((appoint_define.FeedInfo)localObject2).msg_feed_content.has()) {
        break label1199;
      }
      localObject1 = (appoint_define.FeedContent)((appoint_define.FeedInfo)localObject2).msg_feed_content.get();
      if ((paramFreshNewsInfo.feedType != 12L) || (!((appoint_define.FeedContent)localObject1).msg_ad.has())) {
        break label1290;
      }
      localObject3 = (appoint_define.ADFeed)((appoint_define.FeedContent)localObject1).msg_ad.get();
      paramFreshNewsInfo.taskID = ((appoint_define.ADFeed)localObject3).uint32_task_id.get();
      paramFreshNewsInfo.adStyle = ((appoint_define.ADFeed)localObject3).uint32_style.get();
    }
    for (;;)
    {
      try
      {
        localObject1 = new appoint_define.ADFeedContent();
        ((appoint_define.ADFeedContent)localObject1).mergeFrom(((appoint_define.ADFeed)localObject3).bytes_content.get().toByteArray());
        if (((appoint_define.ADFeedContent)localObject1).msg_user_info.has()) {
          paramFreshNewsInfo.userInfo = UserInfo.a((appoint_define.UserInfo)((appoint_define.ADFeedContent)localObject1).msg_user_info.get());
        }
        if (((appoint_define.ADFeedContent)localObject1).rpt_str_pic_url.has()) {
          paramFreshNewsInfo.photoUrls = ((appoint_define.ADFeedContent)localObject1).rpt_str_pic_url.get();
        }
        if (((appoint_define.ADFeedContent)localObject1).msg_text.has()) {
          paramFreshNewsInfo.feedContent = a((appoint_define.RichText)((appoint_define.ADFeedContent)localObject1).msg_text.get());
        }
        if (((appoint_define.ADFeedContent)localObject1).str_attend_info.has()) {
          paramFreshNewsInfo.attendInfo = ((appoint_define.ADFeedContent)localObject1).str_attend_info.get();
        }
        if (((appoint_define.ADFeedContent)localObject1).str_action_url.has()) {
          paramFreshNewsInfo.actionUrl = ((appoint_define.ADFeedContent)localObject1).str_action_url.get();
        }
        if ((((appoint_define.ADFeedContent)localObject1).msg_hot_topic_list.has()) && (((appoint_define.HotTopicList)((appoint_define.ADFeedContent)localObject1).msg_hot_topic_list.get()).rpt_topic_list.has()))
        {
          localObject3 = ((appoint_define.HotTopicList)((appoint_define.ADFeedContent)localObject1).msg_hot_topic_list.get()).rpt_topic_list.get();
          paramFreshNewsInfo.adTopicList = new ArrayList();
          i = 0;
          if (i < ((List)localObject3).size())
          {
            paramFreshNewsInfo.adTopicList.add(HotTopic.a((appoint_define.HotTopic)((List)localObject3).get(i)));
            i += 1;
            continue;
            i = 0;
            break;
            label1038:
            l1 = 0L;
            break label88;
            label1044:
            localObject1 = null;
            break label117;
            label1049:
            i = 0;
            break label143;
            label1055:
            i = 0;
            break label170;
            label1061:
            localObject1 = "";
            break label196;
            label1067:
            i = 0;
            break label222;
            label1073:
            localObject1 = "";
            break label248;
            label1079:
            i = 0;
            break label274;
            label1085:
            localObject1 = "";
            break label300;
            label1091:
            i = 0;
            break label326;
            label1097:
            i = 0;
            break label353;
            label1103:
            i = 0;
            break label401;
            label1109:
            localObject1 = "";
            break label435;
            label1115:
            localObject2 = "";
            break label463;
            label1121:
            i = 0;
            break label506;
            label1127:
            localObject1 = "";
            break label551;
            label1133:
            l1 = 0L;
            break label575;
            label1139:
            l1 = 0L;
            break label600;
            label1145:
            i = 0;
            break label625;
            label1151:
            i = 0;
            break label650;
            label1157:
            i = 0;
            break label675;
            label1163:
            i = 0;
            break label700;
          }
        }
        l1 = l2;
        if (((appoint_define.ADFeedContent)localObject1).uint32_publish_time.has()) {
          l1 = ((appoint_define.ADFeedContent)localObject1).uint32_publish_time.get();
        }
        paramFreshNewsInfo.publishTime = l1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label1199:
        QLog.d("Q.nearby.freshNews", 2, "推广内容merge 失败", localInvalidProtocolBufferMicroException);
        continue;
      }
      if (!((appoint_define.FeedInfo)localObject2).rpt_msg_praise_user.has()) {
        break label1349;
      }
      localObject1 = ((appoint_define.FeedInfo)localObject2).rpt_msg_praise_user.get();
      i = j;
      if (i >= ((List)localObject1).size()) {
        break label1349;
      }
      localObject3 = (appoint_define.StrangerInfo)((List)localObject1).get(i);
      paramFreshNewsInfo.praiseIdList.add(Long.valueOf(((appoint_define.StrangerInfo)localObject3).uint64_tinyid.get()));
      i += 1;
      continue;
      label1290:
      if (localInvalidProtocolBufferMicroException.msg_text.has()) {
        paramFreshNewsInfo.feedContent = a((appoint_define.RichText)localInvalidProtocolBufferMicroException.msg_text.get());
      }
      if (localInvalidProtocolBufferMicroException.rpt_str_pic_url.has())
      {
        List localList = localInvalidProtocolBufferMicroException.rpt_str_pic_url.get();
        paramFreshNewsInfo.photoUrls.addAll(localList);
      }
    }
    label1349:
    if (((appoint_define.FeedInfo)localObject2).rpt_msg_comment_list.has()) {
      paramFreshNewsInfo.commentList = FreshNewsComment.a(((appoint_define.FeedInfo)localObject2).rpt_msg_comment_list.get());
    }
    if (((appoint_define.FeedInfo)localObject2).msg_topic_info.has()) {
      paramFreshNewsInfo.topicInfo = TopicInfo.a((appoint_define.NearbyTopic)((appoint_define.FeedInfo)localObject2).msg_topic_info.get());
    }
    label1400:
    if (paramFreshNewsInfo.ownerFlag == 1) {}
    for (paramFreshNewsInfo.strTimeDistance = a(Long.valueOf(paramFreshNewsInfo.publishTime), true);; paramFreshNewsInfo.strTimeDistance = (a(Long.valueOf(paramFreshNewsInfo.publishTime), true) + "  " + paramFreshNewsInfo.publisherDistance))
    {
      paramFreshNewsInfo.whichPage = 1;
      if (paramFreshNewsInfo.feedType != 8L) {
        break;
      }
      HotchatFeedInfo.a(paramFreshNewsInfo, (appoint_define.FeedInfo)paramUserFeed.msg_feed_info.get());
      return;
    }
  }
  
  public static void a(FreshNewsNotify paramFreshNewsNotify, appoint_define.FeedEvent paramFeedEvent)
  {
    long l2 = -1L;
    int j = -1;
    if ((paramFreshNewsNotify == null) || (paramFeedEvent == null)) {
      return;
    }
    long l1;
    int i;
    label61:
    label86:
    label113:
    label178:
    Object localObject2;
    if (paramFeedEvent.uint64_event_id.has())
    {
      l1 = paramFeedEvent.uint64_event_id.get();
      paramFreshNewsNotify.eventId = l1;
      if (!paramFeedEvent.uint32_time.has()) {
        break label382;
      }
      i = paramFeedEvent.uint32_time.get();
      paramFreshNewsNotify.time = i;
      if (!paramFeedEvent.uint32_eventtype.has()) {
        break label388;
      }
      i = paramFeedEvent.uint32_eventtype.get();
      paramFreshNewsNotify.eventType = i;
      if (!paramFeedEvent.msg_user_info.has()) {
        break label394;
      }
      localObject1 = (appoint_define.StrangerInfo)paramFeedEvent.msg_user_info.get();
      if (localObject1 != null) {
        break label399;
      }
      paramFreshNewsNotify.userTinyId = -1L;
      paramFreshNewsNotify.userNickName = "";
      paramFreshNewsNotify.userAge = -1;
      paramFreshNewsNotify.userGender = -1;
      paramFreshNewsNotify.userVipInfo = "";
      paramFreshNewsNotify.userCharmLevel = -1;
      paramFreshNewsNotify.imageUrl = "";
      if (!paramFeedEvent.msg_feed_info.has()) {
        break label587;
      }
      localObject1 = (appoint_define.FeedInfo)paramFeedEvent.msg_feed_info.get();
      if (localObject1 != null)
      {
        if (!((appoint_define.FeedInfo)localObject1).msg_feed_content.has()) {
          break label592;
        }
        localObject2 = (appoint_define.FeedContent)((appoint_define.FeedInfo)localObject1).msg_feed_content.get();
        label203:
        if ((localObject2 != null) && (((appoint_define.FeedContent)localObject2).rpt_str_pic_url.has()))
        {
          localObject2 = ((appoint_define.FeedContent)localObject2).rpt_str_pic_url.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            paramFreshNewsNotify.imageUrl = ((String)((List)localObject2).get(0));
          }
        }
        if (((appoint_define.FeedInfo)localObject1).str_feed_id.has()) {
          paramFreshNewsNotify.feedId = ((appoint_define.FeedInfo)localObject1).str_feed_id.get();
        }
      }
      if (!paramFeedEvent.str_event_tips.has()) {
        break label597;
      }
      localObject1 = paramFeedEvent.str_event_tips.get();
      label291:
      paramFreshNewsNotify.eventTips = ((String)localObject1);
      if (!paramFeedEvent.msg_comment.has()) {
        break label603;
      }
    }
    label382:
    label388:
    label394:
    label399:
    label418:
    label445:
    label469:
    label494:
    label563:
    label569:
    label575:
    label581:
    label587:
    label592:
    label597:
    label603:
    for (Object localObject1 = (appoint_define.FeedComment)paramFeedEvent.msg_comment.get();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label608;
      }
      paramFreshNewsNotify.commentId = "";
      paramFreshNewsNotify.commentFeedId = "";
      paramFreshNewsNotify.commentRichTextString = "";
      l1 = l2;
      if (paramFeedEvent.uint64_cancel_event_id.has()) {
        l1 = paramFeedEvent.uint64_cancel_event_id.get();
      }
      paramFreshNewsNotify.cancelEventId = l1;
      paramFreshNewsNotify.readType = 1;
      return;
      l1 = -1L;
      break;
      i = -1;
      break label61;
      i = -1;
      break label86;
      localObject1 = null;
      break label113;
      if (((appoint_define.StrangerInfo)localObject1).uint64_tinyid.has())
      {
        l1 = ((appoint_define.StrangerInfo)localObject1).uint64_tinyid.get();
        paramFreshNewsNotify.userTinyId = l1;
        if (!((appoint_define.StrangerInfo)localObject1).bytes_nickname.has()) {
          break label563;
        }
        localObject2 = ((appoint_define.StrangerInfo)localObject1).bytes_nickname.get().toStringUtf8();
        paramFreshNewsNotify.userNickName = ((String)localObject2);
        if (!((appoint_define.StrangerInfo)localObject1).uint32_age.has()) {
          break label569;
        }
        i = ((appoint_define.StrangerInfo)localObject1).uint32_age.get();
        paramFreshNewsNotify.userAge = i;
        if (!((appoint_define.StrangerInfo)localObject1).uint32_gender.has()) {
          break label575;
        }
        i = ((appoint_define.StrangerInfo)localObject1).uint32_gender.get();
        paramFreshNewsNotify.userGender = i;
        if (!((appoint_define.StrangerInfo)localObject1).str_vipinfo.has()) {
          break label581;
        }
      }
      for (localObject2 = ((appoint_define.StrangerInfo)localObject1).str_vipinfo.get();; localObject2 = "")
      {
        paramFreshNewsNotify.userVipInfo = ((String)localObject2);
        i = j;
        if (((appoint_define.StrangerInfo)localObject1).uint32_charm_level.has()) {
          i = ((appoint_define.StrangerInfo)localObject1).uint32_charm_level.get();
        }
        paramFreshNewsNotify.userCharmLevel = i;
        break;
        l1 = -1L;
        break label418;
        localObject2 = "";
        break label445;
        i = -1;
        break label469;
        i = -1;
        break label494;
      }
      localObject1 = null;
      break label178;
      localObject2 = null;
      break label203;
      localObject1 = "";
      break label291;
    }
    label608:
    if (((appoint_define.FeedComment)localObject1).str_comment_id.has())
    {
      localObject2 = ((appoint_define.FeedComment)localObject1).str_comment_id.get();
      label626:
      paramFreshNewsNotify.commentId = ((String)localObject2);
      if (!((appoint_define.FeedComment)localObject1).str_feed_id.has()) {
        break label692;
      }
      localObject2 = ((appoint_define.FeedComment)localObject1).str_feed_id.get();
      label649:
      paramFreshNewsNotify.commentFeedId = ((String)localObject2);
      if (!((appoint_define.FeedComment)localObject1).msg_content.has()) {
        break label698;
      }
    }
    label692:
    label698:
    for (localObject1 = a((appoint_define.RichText)((appoint_define.FeedComment)localObject1).msg_content.get());; localObject1 = "")
    {
      paramFreshNewsNotify.commentRichTextString = ((String)localObject1);
      break;
      localObject2 = "";
      break label626;
      localObject2 = "";
      break label649;
    }
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, Context paramContext, FreshNewsInfo paramFreshNewsInfo)
  {
    if ((paramNearbyAppInterface == null) || (paramContext == null) || (paramFreshNewsInfo == null)) {
      return;
    }
    if ((paramFreshNewsInfo.publisherID == 0L) && (paramFreshNewsInfo.publishState != 1))
    {
      paramNearbyAppInterface = new ProfileActivity.AllInOne(paramNearbyAppInterface.a(), 79);
      paramFreshNewsInfo = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      paramFreshNewsInfo.putExtra("param_mode", 2);
      paramFreshNewsInfo.putExtra("AllInOne", paramNearbyAppInterface);
      paramContext.startActivity(paramFreshNewsInfo);
      return;
    }
    a(paramContext, paramFreshNewsInfo.publisherID, paramFreshNewsInfo.publisherNickname, paramFreshNewsInfo.publisherAge, paramFreshNewsInfo.publisherGender, 35);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsUtil", 2, "createThumbByBigPic, smallUrl=" + paramString1 + ", smallPicPath=" + paramString2 + ", bigPicPath=" + paramString3);
    }
    if ((paramString2 == null) || (paramString3 == null)) {
      return false;
    }
    if (!new File(paramString3).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsUtil", 2, "createThumbByBigPic, bigPic not exist");
      }
      return false;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapManager.a(paramString3, (BitmapFactory.Options)localObject);
    float f;
    int j;
    int i;
    if (((BitmapFactory.Options)localObject).outWidth > ((BitmapFactory.Options)localObject).outHeight)
    {
      f = paramInt * 1.0F / ((BitmapFactory.Options)localObject).outHeight;
      j = (int)(((BitmapFactory.Options)localObject).outWidth * f);
      i = paramInt;
    }
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = ((int)(1.0F / f));
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramString3 = BitmapManager.a(paramString3, (BitmapFactory.Options)localObject);
      localObject = Bitmap.createScaledBitmap(paramString3, j, i, true);
      if ((Build.VERSION.SDK_INT < 11) && (paramString3 != localObject)) {}
      try
      {
        paramString3.recycle();
        paramString3 = Bitmap.createBitmap((Bitmap)localObject, (j - paramInt) / 2, (i - paramInt) / 2, paramInt, paramInt);
        if ((Build.VERSION.SDK_INT >= 11) || (localObject == paramString3)) {}
      }
      catch (Exception paramString3)
      {
        try
        {
          do
          {
            ((Bitmap)localObject).recycle();
            if (paramString3 != null) {
              break label341;
            }
            if (QLog.isColorLevel()) {
              QLog.d("FreshNewsUtil", 2, "createThumbByBigPic bitmap is null");
            }
            return false;
            f = paramInt * 1.0F / ((BitmapFactory.Options)localObject).outWidth;
            i = (int)(((BitmapFactory.Options)localObject).outHeight * f);
            j = paramInt;
            break;
            paramString3 = paramString3;
          } while (!QLog.isColorLevel());
          QLog.d("FreshNewsUtil", 2, "createThumbByBigPic", paramString3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FreshNewsUtil", 2, "createThumbByBigPic", localException);
            }
          }
          try
          {
            label341:
            BaseApplicationImpl.a.put(new URL(paramString1).toString(), paramString3);
            paramString1 = new File(paramString2);
            paramString1.createNewFile();
            FileOutputStream localFileOutputStream = new FileOutputStream(paramString1);
            paramString3.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
            localFileOutputStream.close();
            if (QLog.isColorLevel()) {
              QLog.d("FreshNewsUtil", 2, "createThumbByBigPic successful, smallPicPath=" + paramString2 + ", file size=" + paramString1.length() + ", W=" + paramString3.getWidth() + ", H=" + paramString3.getHeight());
            }
            return true;
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FreshNewsUtil", 2, "createThumbByBigPic exception:" + paramString1.getMessage(), paramString1);
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
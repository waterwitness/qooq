package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfoNew;
import com.tencent.biz.pubaccount.readinjoy.struct.ChildChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeResult;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeResult;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.DisLikeInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChildChannelInfo;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.InterestLabelInfo;

public class ReadInJoyMSFHandlerUtils
{
  private static Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) };
  private static Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "时事", "娱乐", "科技", "动漫", "体育", "搞笑", "时尚", "情感", "汽车", "旅行" };
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(4779), Integer.valueOf(1166), Integer.valueOf(5293), Integer.valueOf(501), Integer.valueOf(73), Integer.valueOf(5729), Integer.valueOf(1314), Integer.valueOf(3817), Integer.valueOf(3689), Integer.valueOf(3076) };
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if ((paramInt1 % 5 == 0) || (paramInt1 % 5 == 1)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return 0;
  }
  
  public static ArticleInfo a(oidb_cmd0x68b.ArticleSummary paramArticleSummary, int paramInt)
  {
    boolean bool = true;
    int i = 0;
    if (paramArticleSummary == null) {
      return null;
    }
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramInt;
    if (paramArticleSummary.uint64_article_id.has()) {
      localArticleInfo.mArticleID = paramArticleSummary.uint64_article_id.get();
    }
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localArticleInfo.mTitle = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
      localArticleInfo.mSummary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_first_page_pic_url.has()) && (paramArticleSummary.bytes_first_page_pic_url.get() != null)) {
      localArticleInfo.mFirstPagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_original_url.has()) && (paramArticleSummary.bytes_original_url.get() != null)) {
      localArticleInfo.mOriginalUrl = paramArticleSummary.bytes_original_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
      localArticleInfo.mArticleContentUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_time.has()) {
      localArticleInfo.mTime = paramArticleSummary.uint64_time.get();
    }
    if (paramArticleSummary.uint32_comment_count.has()) {
      localArticleInfo.mCommentCount = paramArticleSummary.uint32_comment_count.get();
    }
    if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
      localArticleInfo.mSubscribeID = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
      localArticleInfo.mSubscribeName = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_recommend_time.has()) {
      localArticleInfo.mRecommendTime = paramArticleSummary.uint64_recommend_time.get();
    }
    if (paramArticleSummary.uint64_recommend_seq.has()) {
      localArticleInfo.mRecommendSeq = paramArticleSummary.uint64_recommend_seq.get();
    }
    Object localObject;
    if (paramArticleSummary.uint32_show_big_picture.has())
    {
      if (paramArticleSummary.uint32_show_big_picture.get() == 1) {
        localArticleInfo.mShowBigPicture = bool;
      }
    }
    else
    {
      if (paramArticleSummary.uint64_algorithm_id.has()) {
        localArticleInfo.mAlgorithmID = paramArticleSummary.uint64_algorithm_id.get();
      }
      if ((paramArticleSummary.bytes_recommend_reason.has()) && (paramArticleSummary.bytes_recommend_reason.get() != null)) {
        localArticleInfo.mRecommentdReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
      }
      if ((paramArticleSummary.json_video_list.has()) && (paramArticleSummary.json_video_list.get() != null)) {
        localArticleInfo.mJsonVideoList = paramArticleSummary.json_video_list.get().toStringUtf8();
      }
      if ((paramArticleSummary.json_picture_list.has()) && (paramArticleSummary.json_picture_list.get() != null)) {
        localArticleInfo.mJsonPictureList = paramArticleSummary.json_picture_list.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_abandon_repeat_flag.has()) {
        localArticleInfo.mAbandonRepeatFlag = paramArticleSummary.uint32_abandon_repeat_flag.get();
      }
      if ((paramArticleSummary.bytes_test.has()) && (paramArticleSummary.bytes_test.get() != null)) {
        localArticleInfo.mArticleSubscriptText = paramArticleSummary.bytes_test.get().toStringUtf8();
      }
      if ((paramArticleSummary.bytes_colour.has()) && (paramArticleSummary.bytes_colour.get() != null)) {
        localArticleInfo.mArticleSubscriptColor = paramArticleSummary.bytes_colour.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_strategy_id.has()) {
        localArticleInfo.mStrategyId = paramArticleSummary.uint32_strategy_id.get();
      }
      if ((paramArticleSummary.bytes_friend_like_wording.has()) && (paramArticleSummary.bytes_friend_like_wording.get() != null)) {
        localArticleInfo.mArticleFriendLikeText = paramArticleSummary.bytes_friend_like_wording.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_video_show_small_picture.has()) {
        localArticleInfo.mVideoType = paramArticleSummary.uint32_video_show_small_picture.get();
      }
      if (paramArticleSummary.uint32_comment_icon_type.has()) {
        localArticleInfo.mCommentIconType = paramArticleSummary.uint32_comment_icon_type.get();
      }
      if ((paramArticleSummary.bytes_server_context.has()) && (paramArticleSummary.bytes_server_context.get() != null)) {
        localArticleInfo.mServerContext = paramArticleSummary.bytes_server_context.get().toByteArray();
      }
      if (paramArticleSummary.msg_channel_info.has())
      {
        localObject = (oidb_cmd0x68b.ChannelInfo)paramArticleSummary.msg_channel_info.get();
        if (((oidb_cmd0x68b.ChannelInfo)localObject).uint32_channel_id.has()) {
          localArticleInfo.mChannelInfoId = ((oidb_cmd0x68b.ChannelInfo)localObject).uint32_channel_id.get();
        }
        if (((oidb_cmd0x68b.ChannelInfo)localObject).bytes_channel_name.has()) {
          localArticleInfo.mChannelInfoName = ((oidb_cmd0x68b.ChannelInfo)localObject).bytes_channel_name.get().toStringUtf8();
        }
        if (((oidb_cmd0x68b.ChannelInfo)localObject).uint32_channel_type.has()) {
          localArticleInfo.mChannelInfoType = ((oidb_cmd0x68b.ChannelInfo)localObject).uint32_channel_type.get();
        }
        if (((oidb_cmd0x68b.ChannelInfo)localObject).bytes_channel_display_name.has()) {
          localArticleInfo.mChannelInfoDisplayName = ((oidb_cmd0x68b.ChannelInfo)localObject).bytes_channel_display_name.get().toStringUtf8();
        }
      }
      if (paramArticleSummary.uint32_is_disp_timestamp.has()) {
        localArticleInfo.mIsDispTimestamp = paramArticleSummary.uint32_is_disp_timestamp.get();
      }
      if (paramArticleSummary.uint32_is_gallery.has())
      {
        localArticleInfo.mIsGallery = paramArticleSummary.uint32_is_gallery.get();
        if ((localArticleInfo.mIsGallery != 0) && (paramArticleSummary.uint32_picture_number.has())) {
          localArticleInfo.mGalleryPicNumber = paramArticleSummary.uint32_picture_number.get();
        }
      }
      if ((paramArticleSummary.bytes_inner_uniq_id.has()) && (paramArticleSummary.bytes_inner_uniq_id.get() != null)) {
        localArticleInfo.innerUniqueID = paramArticleSummary.bytes_inner_uniq_id.get().toStringUtf8();
      }
      if (!paramArticleSummary.rpt_dislike_list.has()) {
        break label1082;
      }
      paramArticleSummary = paramArticleSummary.rpt_dislike_list.get();
      if ((paramArticleSummary == null) || (paramArticleSummary.size() <= 0)) {
        break label1082;
      }
      int j = paramArticleSummary.size();
      localArticleInfo.mDislikeInfos = new ArrayList();
      paramInt = i;
      label1008:
      if (paramInt >= j) {
        break label1071;
      }
      localObject = new DislikeInfo();
      ((DislikeInfo)localObject).a((oidb_cmd0x68b.DisLikeInfo)paramArticleSummary.get(paramInt));
      if (!TextUtils.isEmpty(((DislikeInfo)localObject).b)) {
        break label1059;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label1008;
      bool = false;
      break;
      label1059:
      localArticleInfo.mDislikeInfos.add(localObject);
    }
    label1071:
    localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(localArticleInfo.mDislikeInfos);
    label1082:
    ReadInJoyUtils.a(localArticleInfo);
    return localArticleInfo;
  }
  
  public static ChannelInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo)
  {
    boolean bool = true;
    ChannelInfo localChannelInfo = new ChannelInfo();
    if (paramChannelInfo.uint32_channel_id.has()) {
      localChannelInfo.mChannelID = paramChannelInfo.uint32_channel_id.get();
    }
    if ((paramChannelInfo.bytes_channel_name.has()) && (paramChannelInfo.bytes_channel_name.get() != null)) {
      localChannelInfo.mChannelName = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
    }
    if (paramChannelInfo.uint32_channel_type.has()) {
      localChannelInfo.mChannelType = paramChannelInfo.uint32_channel_type.get();
    }
    if ((paramChannelInfo.uint32_is_first_req.has()) && (localChannelInfo.mChannelType == 1)) {
      if (paramChannelInfo.uint32_is_first_req.get() == 0) {
        break label183;
      }
    }
    for (;;)
    {
      localChannelInfo.mIsFirstReq = bool;
      if ((paramChannelInfo.uint32_frame_color.has()) && (paramChannelInfo.uint32_frame_color.get() != 0)) {
        localChannelInfo.mFrameColor = paramChannelInfo.uint32_frame_color.get();
      }
      if ((paramChannelInfo.uint32_fonts_color.has()) && (paramChannelInfo.uint32_fonts_color.get() != 0)) {
        localChannelInfo.mFontColor = paramChannelInfo.uint32_fonts_color.get();
      }
      return localChannelInfo;
      label183:
      bool = false;
    }
  }
  
  public static ChannelInfoNew a(oidb_cmd0x69f.ChannelInfo paramChannelInfo)
  {
    boolean bool = true;
    ChannelInfoNew localChannelInfoNew = new ChannelInfoNew();
    if (paramChannelInfo.uint32_channel_id.has()) {
      localChannelInfoNew.jdField_a_of_type_Int = paramChannelInfo.uint32_channel_id.get();
    }
    if ((paramChannelInfo.bytes_channel_name.has()) && (paramChannelInfo.bytes_channel_name.get() != null)) {
      localChannelInfoNew.jdField_a_of_type_JavaLangString = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
    }
    if (paramChannelInfo.uint32_channel_type.has()) {
      localChannelInfoNew.b = paramChannelInfo.uint32_channel_type.get();
    }
    if ((paramChannelInfo.uint32_is_first_req.has()) && (localChannelInfoNew.b == 1)) {
      if (paramChannelInfo.uint32_is_first_req.get() == 0) {
        break label249;
      }
    }
    for (;;)
    {
      localChannelInfoNew.jdField_a_of_type_Boolean = bool;
      if ((paramChannelInfo.uint32_frame_color.has()) && (paramChannelInfo.uint32_frame_color.get() != 0)) {
        localChannelInfoNew.d = paramChannelInfo.uint32_frame_color.get();
      }
      if ((paramChannelInfo.uint32_fonts_color.has()) && (paramChannelInfo.uint32_fonts_color.get() != 0)) {
        localChannelInfoNew.e = paramChannelInfo.uint32_fonts_color.get();
      }
      if (paramChannelInfo.uint32_bold_font.has()) {
        localChannelInfoNew.f = paramChannelInfo.uint32_bold_font.get();
      }
      if (paramChannelInfo.uint32_show_icon.has()) {
        localChannelInfoNew.g = paramChannelInfo.uint32_show_icon.get();
      }
      if (paramChannelInfo.rpt_child_channel_list.has()) {
        localChannelInfoNew.a(b(paramChannelInfo.rpt_child_channel_list.get()));
      }
      return localChannelInfoNew;
      label249:
      bool = false;
    }
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x69f.ChannelInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x68b.ArticleSummary)paramList.next(), paramInt));
    }
    return localArrayList;
  }
  
  public static List a(List paramList1, List paramList2)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = j;
    if (paramList1 != null)
    {
      if (paramList1.size() == 0) {
        i = j;
      }
    }
    else
    {
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        paramList1 = new InterestLabelInfo();
        paramList1.mInterestLabelNme = jdField_a_of_type_ArrayOfJavaLangString[i];
        paramList1.mInterestLabelID = jdField_a_of_type_ArrayOfJavaLangInteger[i].intValue();
        paramList1.mIsDefault = jdField_a_of_type_ArrayOfJavaLangBoolean[i].booleanValue();
        localArrayList.add(paramList1);
        i += 1;
      }
      return localArrayList;
    }
    j = paramList1.size();
    paramList1 = paramList1.iterator();
    i = 0;
    if (paramList1.hasNext())
    {
      oidb_cmd0x6e5.InterestLabelInfo localInterestLabelInfo = (oidb_cmd0x6e5.InterestLabelInfo)paramList1.next();
      InterestLabelInfo localInterestLabelInfo1 = new InterestLabelInfo();
      if (localInterestLabelInfo.uint32_interest_label_id.has()) {
        localInterestLabelInfo1.mInterestLabelID = localInterestLabelInfo.uint32_interest_label_id.get();
      }
      if ((localInterestLabelInfo.bytes_interest_label_name.has()) && (localInterestLabelInfo.bytes_interest_label_name.get() != null)) {
        localInterestLabelInfo1.mInterestLabelNme = localInterestLabelInfo.bytes_interest_label_name.get().toStringUtf8();
      }
      if ((paramList2 != null) && (!paramList2.isEmpty())) {
        localInterestLabelInfo1.mIsDefault = paramList2.contains(Integer.valueOf(localInterestLabelInfo1.mInterestLabelID));
      }
      if ((localInterestLabelInfo1.mInterestLabelNme != null) && (localInterestLabelInfo1.mInterestLabelNme.length() > 3))
      {
        i = a(i, j);
        localArrayList.add(i, localInterestLabelInfo1);
      }
      for (;;)
      {
        break;
        localArrayList.add(localInterestLabelInfo1);
      }
    }
    return localArrayList;
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ReadInJoyUtils.a((ArticleInfo)paramList.next());
      }
    }
  }
  
  public static void a(ConcurrentHashMap paramConcurrentHashMap, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramConcurrentHashMap.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelInfoNew localChannelInfoNew = a((oidb_cmd0x69f.ChannelInfo)paramList.next());
        paramConcurrentHashMap.put(Integer.valueOf(localChannelInfoNew.jdField_a_of_type_Int), localChannelInfoNew);
      }
    }
  }
  
  public static List b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x69f.ChildChannelInfo localChildChannelInfo = (oidb_cmd0x69f.ChildChannelInfo)paramList.next();
      if (localChildChannelInfo.uint32_channel_id.has())
      {
        ChildChannelInfo localChildChannelInfo1 = new ChildChannelInfo();
        localChildChannelInfo1.jdField_a_of_type_Int = localChildChannelInfo.uint32_channel_id.get();
        localArrayList.add(localChildChannelInfo1);
      }
    }
    return localArrayList;
  }
  
  public static List c(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeResult localDislikeResult = (oidb_cmd0x46f.DislikeResult)paramList.next();
      DislikeResult localDislikeResult1 = new DislikeResult();
      if (localDislikeResult.uint64_articleid.has()) {
        localDislikeResult1.jdField_a_of_type_Long = localDislikeResult.uint64_articleid.get();
      }
      if (localDislikeResult.uint32_result.has()) {
        localDislikeResult1.jdField_a_of_type_Int = localDislikeResult.uint32_result.get();
      }
      if (localDislikeResult.str_message.has()) {
        localDislikeResult1.jdField_a_of_type_JavaLangString = localDislikeResult.str_message.get();
      }
      localArrayList.add(localDislikeResult1);
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\protocol\ReadInJoyMSFHandlerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
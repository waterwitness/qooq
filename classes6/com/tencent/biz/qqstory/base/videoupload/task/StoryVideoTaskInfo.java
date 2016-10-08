package com.tencent.biz.qqstory.base.videoupload.task;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.utils.AssertUtils;
import java.util.List;
import org.json.JSONException;

public class StoryVideoTaskInfo
  extends BaseTaskInfo
{
  private PublishVideoEntry a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  private String l;
  
  public StoryVideoTaskInfo(StoryVideoItem paramStoryVideoItem)
  {
    this.l = paramStoryVideoItem.mVid;
    this.i = paramStoryVideoItem.mVideoUrl;
    this.k = paramStoryVideoItem.mVideoThumbnailUrl;
    this.j = paramStoryVideoItem.mOriginalMaskPicUrl;
    this.jdField_a_of_type_JavaLangString = paramStoryVideoItem.mLocalVideoPath;
    this.jdField_b_of_type_JavaLangString = paramStoryVideoItem.mVideoLocalThumbnailPath;
    this.jdField_c_of_type_JavaLangString = paramStoryVideoItem.mLocalMaskPath;
    this.jdField_d_of_type_JavaLangString = paramStoryVideoItem.mLabel;
    this.jdField_e_of_type_JavaLangString = paramStoryVideoItem.mDoodleText;
    this.jdField_b_of_type_Long = paramStoryVideoItem.mVideoDuration;
    this.jdField_c_of_type_Int = paramStoryVideoItem.mVideoWidth;
    this.jdField_d_of_type_Int = paramStoryVideoItem.mVideoHeight;
    this.jdField_d_of_type_Long = paramStoryVideoItem.mCreateTime;
    this.g = paramStoryVideoItem.mUploadServerIp;
    this.jdField_e_of_type_Int = paramStoryVideoItem.mUploadLastOffset;
    if (paramStoryVideoItem.mLocation != null) {
      this.f = AddressItem.convertFromItem(paramStoryVideoItem.mLocation);
    }
  }
  
  public StoryVideoTaskInfo(String paramString)
  {
    this.l = paramString;
    AssertUtils.checkNotNull(paramString);
  }
  
  public StoryVideoTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.l = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.f = paramString6;
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public PublishVideoEntry a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    }
    List localList = a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.l });
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = ((PublishVideoEntry)localList.get(0));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = new PublishVideoEntry();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  }
  
  public StoryVideoItem a()
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.mVid = this.l;
    localStoryVideoItem.mCreateTime = this.jdField_d_of_type_Long;
    localStoryVideoItem.mVideoUrl = this.i;
    localStoryVideoItem.mVideoThumbnailUrl = this.k;
    localStoryVideoItem.mOriginalMaskPicUrl = this.j;
    localStoryVideoItem.mVideoLocalThumbnailPath = this.jdField_b_of_type_JavaLangString;
    localStoryVideoItem.mLocalVideoPath = this.jdField_a_of_type_JavaLangString;
    localStoryVideoItem.mLocalMaskPath = this.jdField_c_of_type_JavaLangString;
    localStoryVideoItem.mVideoDuration = this.jdField_b_of_type_Long;
    localStoryVideoItem.mVideoWidth = this.jdField_c_of_type_Int;
    localStoryVideoItem.mVideoHeight = this.jdField_d_of_type_Int;
    localStoryVideoItem.mLabel = this.jdField_d_of_type_JavaLangString;
    localStoryVideoItem.mDoodleText = this.jdField_e_of_type_JavaLangString;
    localStoryVideoItem.mUploadStatus = this.jdField_a_of_type_Int;
    localStoryVideoItem.mUploadServerIp = this.g;
    localStoryVideoItem.mUploadLastOffset = this.jdField_e_of_type_Int;
    localStoryVideoItem.mOwnerUid = QQStoryContext.a().a();
    if ((localStoryVideoItem.mLocation == null) && (!TextUtils.isEmpty(this.f))) {}
    try
    {
      localStoryVideoItem.mLocation = AddressItem.convertFromJson(this.f);
      return localStoryVideoItem;
    }
    catch (JSONException localJSONException)
    {
      SLog.b("StoryVideoTaskInfo, addressItem json string error ：", localJSONException.toString());
      localJSONException.printStackTrace();
    }
    return localStoryVideoItem;
  }
  
  public String a()
  {
    return this.l;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (StoryVideoTaskInfo)paramObject;
      if (this.l != null) {
        return this.l.equals(((StoryVideoTaskInfo)paramObject).l);
      }
    } while (((StoryVideoTaskInfo)paramObject).l == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.l != null) {
      return this.l.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "StoryVideoTaskInfo{createTime=" + this.jdField_d_of_type_Long + ", fakeVid='" + this.l + '\'' + ", vid='" + this.h + '\'' + ", uploadOffset='" + this.jdField_e_of_type_Int + '\'' + ", '" + super.toString() + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\StoryVideoTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReportWatchVideoManager$InnerVideoItem
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  
  public ReportWatchVideoManager$InnerVideoItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReportWatchVideoManager$InnerVideoItem(String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramLong2;
  }
  
  public ReportWatchVideoEntry a()
  {
    ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
    localReportWatchVideoEntry.vid = this.jdField_a_of_type_JavaLangString;
    localReportWatchVideoEntry.videoUid = this.jdField_a_of_type_Long;
    localReportWatchVideoEntry.isLiveVideo = this.jdField_a_of_type_Boolean;
    localReportWatchVideoEntry.createTime = this.b;
    return localReportWatchVideoEntry;
  }
  
  public void a(ReportWatchVideoEntry paramReportWatchVideoEntry)
  {
    this.jdField_a_of_type_JavaLangString = paramReportWatchVideoEntry.vid;
    this.jdField_a_of_type_Long = paramReportWatchVideoEntry.videoUid;
    this.jdField_a_of_type_Boolean = paramReportWatchVideoEntry.isLiveVideo;
    this.b = paramReportWatchVideoEntry.createTime;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (InnerVideoItem)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(((InnerVideoItem)paramObject).jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    return "InnerVideoItem { mVid=" + this.jdField_a_of_type_JavaLangString + " mVideoUid=" + this.jdField_a_of_type_Long + " mIsLiveVideo=" + this.jdField_a_of_type_Boolean + " mCreateTime=" + this.b + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\ReportWatchVideoManager$InnerVideoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
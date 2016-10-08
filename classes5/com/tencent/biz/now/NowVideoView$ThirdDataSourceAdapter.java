package com.tencent.biz.now;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class NowVideoView$ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  int jdField_a_of_type_Int;
  AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  String jdField_a_of_type_JavaLangString;
  
  public NowVideoView$ThirdDataSourceAdapter(NowVideoView paramNowVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      String str = (String)this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = str;
      if ((this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback != null) && (this.jdField_a_of_type_ComTencentBizNowNowVideoView.h == 0))
      {
        this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback.onPrepared(str);
        return true;
      }
    }
    return false;
  }
  
  public int getStaus()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramString = (String)this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = paramString;
      paramOnPreparedCallback.onPrepared(paramString);
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentBizNowNowVideoView.b, this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\NowVideoView$ThirdDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
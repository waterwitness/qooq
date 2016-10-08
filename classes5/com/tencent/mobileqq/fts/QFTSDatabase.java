package com.tencent.mobileqq.fts;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QFTSDatabase
  extends FTSDatabase
{
  public QFTSDatabase()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean a()
  {
    boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabaseV2");
    if (!bool) {
      com.tencent.mobileqq.app.proxy.FTSDBManager.a = false;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\QFTSDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
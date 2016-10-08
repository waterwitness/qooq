package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;

public class OfflineFileHttpUtils
{
  static final String a = "OfflineFileHttpUtils<FileAssistant>";
  
  public OfflineFileHttpUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(SSCM paramSSCM, long paramLong1, long paramLong2, long paramLong3)
  {
    int i;
    if (paramLong3 == 0L)
    {
      FMConstants.af = paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong3, FMConstants.ad);
      if (paramLong1 < FMConstants.af) {}
      for (;;)
      {
        i = (int)paramLong1;
        int k = Utils.a(BaseApplication.getContext());
        int j;
        if (k != 1)
        {
          j = i;
          if (k != 2) {}
        }
        else
        {
          j = i;
          if (i > 16384) {
            j = 16384;
          }
        }
        i = Math.min(j, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("OfflineFileHttpUtils<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong2 + "], size[" + i + "]");
        }
        return i;
        paramLong1 = FMConstants.af;
      }
    }
    FMConstants.ad = paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong2, FMConstants.ad);
    if (paramLong1 < FMConstants.ad + paramLong2) {}
    for (paramLong1 -= paramLong2;; paramLong1 = FMConstants.ad)
    {
      i = (int)paramLong1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\offlinefile\OfflineFileUpload\OfflineFileHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
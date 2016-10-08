package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SnapshotResultReceiver
  extends ResultReceiver
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = SnapshotResultReceiver.class.getSimpleName();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SnapshotResultReceiver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (SecSpyFileManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(93);
      switch (paramInt)
      {
      }
    }
    label274:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = localObject2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp.getManager(QQAppInterface.SEC_SPY_FILEMANAGER) == null");
              localObject1 = localObject2;
              break;
              localObject2 = paramBundle.getStringArrayList("snapshotPaths");
              l = paramBundle.getLong("seq");
              paramBundle = paramBundle.getString("seqKey");
            } while (localObject1 == null);
            ((SecSpyFileManager)localObject1).a((List)localObject2, l, paramBundle);
            return;
            localObject2 = paramBundle.getStringArrayList("snapshotPaths");
            l = paramBundle.getLong("seq");
            paramBundle = paramBundle.getString("seqKey");
            if (localObject1 != null) {
              ((SecSpyFileManager)localObject1).b((List)localObject2, l, paramBundle);
            }
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "RESULT_FINISH_ALIVE_SNAPSHOT, seq=" + l);
          return;
          if (localObject1 == null) {
            break label274;
          }
          localObject2 = paramBundle.getString("debugUrl");
          paramInt = paramBundle.getInt("maxCount");
          l = paramBundle.getLong("seq");
          ((SecSpyFileManager)localObject1).a((String)localObject2, paramInt, paramBundle.getLong("delay"), l, paramBundle.getString("seqKey"));
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "RESULT_WEBVIEW_INVALID, restart alive snapshot. seq=" + l);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RESULT_WEBVIEW_INVALID, manager == null");
      return;
    } while (localObject1 == null);
    long l = paramBundle.getLong("seq");
    ((SecSpyFileManager)localObject1).a(l);
    ((SecSpyFileManager)localObject1).a(l, -1, new Object[] { "can't find x5's method: snapshotVisibleWithBitmap" });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\SnapshotResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
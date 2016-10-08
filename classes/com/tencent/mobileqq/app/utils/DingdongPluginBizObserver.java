package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class DingdongPluginBizObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  
  public DingdongPluginBizObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
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
                      } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.UnreadNumUpdateData)));
                      a((DingdongPluginBizObserver.UnreadNumUpdateData)paramObject);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.NodeUpdateData)));
                    a((DingdongPluginBizObserver.NodeUpdateData)paramObject);
                    return;
                  } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.FeedStateUpdateData)));
                  a((DingdongPluginBizObserver.FeedStateUpdateData)paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.FeedConfirmNotifyData)));
                a((DingdongPluginBizObserver.FeedConfirmNotifyData)paramObject);
                return;
              } while (!(paramObject instanceof DingdongPluginBizObserver.ScheduleChangeNotifyData));
              a((DingdongPluginBizObserver.ScheduleChangeNotifyData)paramObject);
              return;
            } while (!(paramObject instanceof DingdongPluginBizObserver.ScheduleNotificationData));
            QLog.e("dingdongSchedule", 2, "Observer nitify get");
            a((DingdongPluginBizObserver.ScheduleNotificationData)paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.GetOpenIdNotifyData)));
          a((DingdongPluginBizObserver.GetOpenIdNotifyData)paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.GetAppListData)));
        a((DingdongPluginBizObserver.GetAppListData)paramObject);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.SetAppListData)));
      a((DingdongPluginBizObserver.SetAppListData)paramObject);
      return;
    } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.ScheduleMoreSummaryData)));
    a((DingdongPluginBizObserver.ScheduleMoreSummaryData)paramObject);
  }
  
  public void a(DingdongPluginBizObserver.FeedConfirmNotifyData paramFeedConfirmNotifyData) {}
  
  public void a(DingdongPluginBizObserver.FeedStateUpdateData paramFeedStateUpdateData) {}
  
  public void a(DingdongPluginBizObserver.GetAppListData paramGetAppListData) {}
  
  public void a(DingdongPluginBizObserver.GetOpenIdNotifyData paramGetOpenIdNotifyData) {}
  
  public void a(DingdongPluginBizObserver.NodeUpdateData paramNodeUpdateData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleChangeNotifyData paramScheduleChangeNotifyData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleNotificationData paramScheduleNotificationData) {}
  
  public void a(DingdongPluginBizObserver.SetAppListData paramSetAppListData) {}
  
  public void a(DingdongPluginBizObserver.UnreadNumUpdateData paramUnreadNumUpdateData) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\utils\DingdongPluginBizObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
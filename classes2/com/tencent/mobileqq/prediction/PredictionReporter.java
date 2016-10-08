package com.tencent.mobileqq.prediction;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PredictionReporter
{
  public static final int a = 1000;
  public static final String a = "ShortVideoPredictionEvaluator";
  private static HashMap a = new HashMap();
  public static final int b = 100;
  public static final int c = 101;
  public static final int d = 102;
  private static final int e = 24;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPredictionEvaluator", 2, "onDestroy, size=" + a.size());
    }
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      ((PredictionReporter.EvaluatorInfo)localIterator.next()).a();
    }
    a.clear();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("business_type", String.valueOf(paramInt1));
    localHashMap.put("prediction_step", String.valueOf(paramInt2));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPredictionData", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPredictionEvaluator", 2, "msgViewedInAIO, size=" + a.size());
      }
      l = System.currentTimeMillis();
    } while ((a.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))) || (a.size() >= 24));
    paramQQAppInterface = new PredictionReporter.EvaluatorInfo(paramQQAppInterface, paramMessageForShortVideo, l, 0L);
    a.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPredictionEvaluator", 2, "msgClicked, size=" + a.size());
        }
        l = System.currentTimeMillis();
      } while (!a.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
      paramQQAppInterface = (PredictionReporter.EvaluatorInfo)a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(l);
    paramQQAppInterface.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\prediction\PredictionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
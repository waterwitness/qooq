import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader.IPreDownloadStrategy;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams.Params;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class tyn
  implements PTTPreDownloader.IPreDownloadStrategy, Runnable
{
  private static final boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private tyo jdField_a_of_type_Tyo;
  private tyo jdField_b_of_type_Tyo;
  private volatile boolean jdField_b_of_type_Boolean;
  private tyo c;
  
  public tyn(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Tyo = new tyo(1);
    this.jdField_b_of_type_Tyo = new tyo(3);
    this.c = new tyo(2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private long a(MessageForPtt paramMessageForPtt)
  {
    long l2 = 4096L;
    long l1 = paramMessageForPtt.fileSize;
    if (l1 <= 0L)
    {
      if (paramMessageForPtt.voiceType == 1) {
        if (paramMessageForPtt.voiceLength <= 0) {
          l1 = 10240L;
        }
      }
      do
      {
        do
        {
          return l1;
          return paramMessageForPtt.voiceLength * 1200;
          l1 = l2;
        } while (paramMessageForPtt.voiceType != 0);
        l1 = l2;
      } while (paramMessageForPtt.voiceLength <= 0);
      return paramMessageForPtt.voiceLength * 700;
    }
    return l1;
  }
  
  private void a(tyo paramtyo)
  {
    long l2;
    if (paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int == Integer.MIN_VALUE)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PTTPreDownloader", 4, "initStrategyInfoIfNeccessary");
      }
      Date localDate = new Date();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      PreDownloadParams.Params localParams1 = PreDownloadParams.a((QQAppInterface)localObject1, paramtyo.jdField_a_of_type_Int);
      paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int = localParams1.jdField_a_of_type_Int;
      int i;
      if (paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int > 0)
      {
        PreDownloadParams.Params localParams2 = new PreDownloadParams.Params();
        localObject1 = PreDownloadParams.a((QQAppInterface)localObject1, paramtyo.jdField_a_of_type_Int, localParams2);
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(localDate);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "PreTime:" + (String)localObject1 + " curTime:" + (String)localObject2);
        }
        if (((String)localObject2).equals(localObject1))
        {
          i = 0;
          while (i <= 5)
          {
            paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams2.jdField_a_of_type_ArrayOfInt[i];
            i += 1;
          }
        }
        i = 0;
        int j = 0;
        if (localParams2.jdField_a_of_type_Int > -1)
        {
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localParams2.jdField_a_of_type_Int);
          i = j;
          while (i <= 5)
          {
            ((StringBuilder)localObject2).append('#').append(i).append('_').append(localParams2.jdField_a_of_type_ArrayOfInt[i]);
            i += 1;
          }
          ((HashMap)localObject1).put("RemainCfg", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "PttPreDownloadDailyRemain", true, 0L, 0L, (HashMap)localObject1, "");
          i = 0;
        }
        while (i <= 5)
        {
          paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams1.jdField_a_of_type_ArrayOfInt[i];
          i += 1;
        }
      }
      b(paramtyo);
      if (!this.jdField_b_of_type_Boolean)
      {
        l1 = localDate.getTime();
        i = localDate.getHours();
        localDate.setHours(0);
        localDate.setMinutes(0);
        localDate.setSeconds(0);
        l2 = localDate.getTime();
        if (i >= 0) {
          break label500;
        }
      }
    }
    label500:
    for (long l1 = 0L - (l1 - l2);; l1 = 86400000L - (l1 - l2))
    {
      if (QLog.isDevelopLevel())
      {
        l2 = l1 / 1000L;
        QLog.d("PTTPreDownloader", 4, "Next reset time offset:" + l2 / 60L + ":" + l2 % 60L);
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, l1);
      return;
    }
  }
  
  private void b(tyo paramtyo)
  {
    paramtyo = paramtyo.jdField_a_of_type_Int + ":" + paramtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params;
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, paramtyo);
    }
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "save");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Tyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != Integer.MIN_VALUE)
    {
      PreDownloadParams.a(localQQAppInterface, this.jdField_a_of_type_Tyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.jdField_a_of_type_Tyo.jdField_a_of_type_Int);
      b(this.jdField_a_of_type_Tyo);
      localHashMap.put("C2CDownload", String.valueOf(this.jdField_a_of_type_Tyo.b));
      localHashMap.put("C2CView", String.valueOf(this.jdField_a_of_type_Tyo.d));
      localHashMap.put("C2CCancel", String.valueOf(this.jdField_a_of_type_Tyo.e));
      localHashMap.put("C2CEscape", String.valueOf(this.jdField_a_of_type_Tyo.c));
    }
    if (this.jdField_b_of_type_Tyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != Integer.MIN_VALUE)
    {
      PreDownloadParams.a(localQQAppInterface, this.jdField_b_of_type_Tyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.jdField_b_of_type_Tyo.jdField_a_of_type_Int);
      b(this.jdField_b_of_type_Tyo);
      b(this.jdField_a_of_type_Tyo);
      localHashMap.put("GroupDownload", String.valueOf(this.jdField_b_of_type_Tyo.b));
      localHashMap.put("GroupView", String.valueOf(this.jdField_b_of_type_Tyo.d));
      localHashMap.put("GroupCancel", String.valueOf(this.jdField_b_of_type_Tyo.e));
      localHashMap.put("GroupEscape", String.valueOf(this.jdField_b_of_type_Tyo.c));
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != Integer.MIN_VALUE)
    {
      PreDownloadParams.a(localQQAppInterface, this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.c.jdField_a_of_type_Int);
      b(this.c);
      localHashMap.put("DiscussDownload", String.valueOf(this.c.b));
      localHashMap.put("DiscussView", String.valueOf(this.c.d));
      localHashMap.put("DiscussCancel", String.valueOf(this.c.e));
      localHashMap.put("DiscussEscape", String.valueOf(this.c.c));
    }
    if (localHashMap.size() > 0)
    {
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "PttPreDownloadPV", true, 0L, 0L, localHashMap, "");
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramMessageForPtt.istroop == 0) {}
    label386:
    for (tyo localtyo = this.jdField_a_of_type_Tyo;; localtyo = null)
    {
      long l2;
      int i;
      if (localtyo != null)
      {
        l2 = 0L;
        i = NetworkCenter.a().a();
      }
      for (;;)
      {
        long l3;
        try
        {
          a(localtyo);
          if (localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int <= 0)
          {
            l1 = l2;
            bool1 = bool3;
            bool2 = bool1;
            if (QLog.isDevelopLevel())
            {
              QLog.d("PTTPreDownloader", 4, "canDownload:" + bool1 + " sesion:" + localtyo.jdField_a_of_type_Int + " net:" + i + " " + l1 + " - " + paramMessageForPtt.estimatedSize + " = " + localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] + ", pttSize:" + paramMessageForPtt.fileSize);
              bool2 = bool1;
            }
            return bool2;
            if (paramMessageForPtt.istroop == 1)
            {
              localtyo = this.jdField_b_of_type_Tyo;
              break;
            }
            if (paramMessageForPtt.istroop != 3000) {
              break label386;
            }
            localtyo = this.c;
            break;
          }
          l3 = paramMessageForPtt.msgRecTime - paramMessageForPtt.msgTime;
          bool1 = bool3;
          l1 = l2;
          if (l3 < -10000L) {
            continue;
          }
          bool1 = bool3;
          l1 = l2;
          if (l3 > localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int * 24 * 60 * 60 * 100) {
            continue;
          }
          l3 = a(paramMessageForPtt);
          if (l3 > localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i])
          {
            localtyo.c += 1;
            bool1 = bool3;
            l1 = l2;
            continue;
          }
          localtyo.b += 1;
        }
        finally {}
        paramMessageForPtt.estimatedSize = l3;
        long l1 = localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
        int[] arrayOfInt = localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt;
        arrayOfInt[i] = ((int)(arrayOfInt[i] - l3));
        boolean bool1 = true;
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (paramInt == 2) {
      return true;
    }
    if (paramMessageForPtt.istroop == 0) {}
    label19:
    label37:
    label294:
    label355:
    for (tyo localtyo = this.jdField_a_of_type_Tyo;; localtyo = null)
    {
      if (localtyo != null)
      {
        int i;
        if ((paramMessageForPtt.extFlag & 1L) > 0L)
        {
          i = 1;
          if (i != 0) {
            i = NetworkCenter.a().a();
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              a(localtyo);
              long l1 = localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
              long l2 = paramMessageForPtt.fileSize + l1;
              PreDownloadParams.Params localParams = PreDownloadParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localtyo.jdField_a_of_type_Int);
              if (l2 > localParams.jdField_a_of_type_ArrayOfInt[i])
              {
                localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams.jdField_a_of_type_ArrayOfInt[i];
                if (paramInt != 1) {
                  break label294;
                }
                localtyo.d += 1;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.d("PTTPreDownloader", 4, "consume sesion:" + localtyo.jdField_a_of_type_Int + " netType:" + i + ", " + l1 + " + " + paramMessageForPtt.fileSize + " = " + localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i]);
                return true;
                if (paramMessageForPtt.istroop == 1)
                {
                  localtyo = this.jdField_b_of_type_Tyo;
                  break label19;
                }
                if (paramMessageForPtt.istroop != 3000) {
                  break label355;
                }
                localtyo = this.c;
                break label19;
                i = 0;
                break label37;
              }
              localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = ((int)l2);
              continue;
              if (paramInt != 3) {
                continue;
              }
            }
            finally {}
            localtyo.e += 1;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "consume sesion:" + localtyo.jdField_a_of_type_Int + " not preDownload");
        }
      }
      return false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Tyo = new tyo(1);
    this.jdField_b_of_type_Tyo = new tyo(3);
    this.c = new tyo(2);
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (paramMessageForPtt.estimatedSize <= 0L) {
      return false;
    }
    tyo localtyo = null;
    int i;
    if (paramMessageForPtt.istroop == 0)
    {
      localtyo = this.jdField_a_of_type_Tyo;
      if (localtyo == null) {
        break label256;
      }
      i = NetworkCenter.a().a();
    }
    for (;;)
    {
      try
      {
        long l1 = localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
        localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] += (int)(paramMessageForPtt.estimatedSize - paramMessageForPtt.fileSize);
        long l2 = paramMessageForPtt.estimatedSize;
        paramMessageForPtt.estimatedSize = 0L;
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("PTTPreDownloader", 4, "fixEstimatedSize sesion:" + localtyo.jdField_a_of_type_Int + " net:" + i + ", " + l1 + " + " + l2 + " - " + paramMessageForPtt.fileSize + " = " + localtyo.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] + ", PttSize:" + paramMessageForPtt.fileSize);
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      if (paramMessageForPtt.istroop == 1)
      {
        localtyo = this.jdField_b_of_type_Tyo;
        break;
      }
      if (paramMessageForPtt.istroop != 3000) {
        break;
      }
      localtyo = this.c;
      break;
      label256:
      boolean bool1 = false;
    }
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "reset");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_b_of_type_Boolean = false;
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */